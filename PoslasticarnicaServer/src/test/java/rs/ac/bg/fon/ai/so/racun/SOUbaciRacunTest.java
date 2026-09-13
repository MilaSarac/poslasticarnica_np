package rs.ac.bg.fon.ai.so.racun;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import rs.ac.bg.fon.ai.baza.DBBroker;
import rs.ac.bg.fon.ai.domen.Kolac;
import rs.ac.bg.fon.ai.domen.Kupac;
import rs.ac.bg.fon.ai.domen.Mesto;
import rs.ac.bg.fon.ai.domen.Poslasticar;
import rs.ac.bg.fon.ai.domen.Racun;
import rs.ac.bg.fon.ai.domen.StavkaRacuna;

class SOUbaciRacunTest {

    private SOUbaciRacun operacija;
    private Long idDodatogRacuna;

    private Poslasticar poslasticar;
    private Kupac kupac;
    private Kolac kolac;

    @BeforeEach
    void setUp() throws Exception {

        operacija = new SOUbaciRacun();

        poslasticar = vratiPrvogPoslasticara();
        kupac = vratiPrvogKupca();
        kolac = vratiPrviKolac();
    }

    @AfterEach
    void tearDown() throws Exception {

        if (idDodatogRacuna != null) {

            Connection connection =
                    DBBroker.getInstance().getConnection();

            PreparedStatement psStavke =
                    connection.prepareStatement(
                            "DELETE FROM stavkaRacuna WHERE idRacun = ?"
                    );

            psStavke.setLong(1, idDodatogRacuna);
            psStavke.executeUpdate();
            psStavke.close();

            PreparedStatement psRacun =
                    connection.prepareStatement(
                            "DELETE FROM racun WHERE idRacun = ?"
                    );

            psRacun.setLong(1, idDodatogRacuna);
            psRacun.executeUpdate();
            psRacun.close();

            connection.commit();
        }

        operacija = null;
    }

    @Test
    void testUbaciRacun() throws Exception {

        ArrayList<StavkaRacuna> stavke =
                new ArrayList<>();

        StavkaRacuna stavka =
                new StavkaRacuna(
                        null,
                        1,
                        kolac.getCena(),
                        2,
                        kolac.getCena() * 2,
                        kolac
                );

        stavke.add(stavka);

        double ukupanIznos =
                kolac.getCena() * 2;

        Racun racun =
                new Racun(
                        null,
                        new Date(),
                        ukupanIznos,
                        poslasticar,
                        kupac,
                        stavke
                );

        assertDoesNotThrow(
                () -> operacija.izvrsi(racun)
        );

        assertNotNull(racun.getIdRacun());

        idDodatogRacuna = racun.getIdRacun();

        assertTrue(
                postojiRacunUBazi(idDodatogRacuna)
        );

        assertTrue(
                postojiStavkaUBazi(idDodatogRacuna)
        );
    }

    @Test
    void testPogresanTipObjekta() {

        assertThrows(
                Exception.class,
                () -> operacija.izvrsi(new Kolac())
        );
    }

    @Test
    void testRacunBezStavki() {

        /*
         * Koristimo prazan konstruktor zato sto bi konstruktor Racuna
         * pozvao setUkupanIznos(0), koji vec baca izuzetak.
         */

        Racun racun = new Racun();

        racun.setDatumIzdavanja(new Date());
        racun.setUkupanIznos(100);
        racun.setPoslasticar(poslasticar);
        racun.setKupac(kupac);
        racun.setStavkeRacuna(new ArrayList<>());

        assertThrows(
                Exception.class,
                () -> operacija.izvrsi(racun)
        );
    }

    @Test
    void testNeispravanUkupanIznos() {

        ArrayList<StavkaRacuna> stavke =
                new ArrayList<>();

        StavkaRacuna stavka =
                new StavkaRacuna(
                        null,
                        1,
                        kolac.getCena(),
                        2,
                        kolac.getCena() * 2,
                        kolac
                );

        stavke.add(stavka);

        /*
         * Stavke zajedno vrede cena * 2, ali namerno postavljamo
         * drugaciji ukupan iznos racuna.
         */
        double pogresanUkupanIznos =
                kolac.getCena() * 2 + 100;

        Racun racun =
                new Racun(
                        null,
                        new Date(),
                        pogresanUkupanIznos,
                        poslasticar,
                        kupac,
                        stavke
                );

        assertThrows(
                Exception.class,
                () -> operacija.izvrsi(racun)
        );
    }

    private Poslasticar vratiPrvogPoslasticara()
            throws Exception {

        PreparedStatement ps =
                DBBroker.getInstance()
                        .getConnection()
                        .prepareStatement(
                                "SELECT * FROM poslasticar LIMIT 1"
                        );

        ResultSet rs = ps.executeQuery();

        assertTrue(
                rs.next(),
                "U bazi mora postojati makar jedan poslasticar."
        );

        Poslasticar p =
                new Poslasticar(
                        rs.getLong("idPoslasticar"),
                        rs.getString("ime"),
                        rs.getString("prezime"),
                        rs.getString("korisnickoIme"),
                        rs.getString("sifra"),
                        rs.getDate("datumZaposlenja")
                );

        rs.close();
        ps.close();

        return p;
    }

    private Kupac vratiPrvogKupca()
            throws Exception {

        PreparedStatement ps =
                DBBroker.getInstance()
                        .getConnection()
                        .prepareStatement(
                                "SELECT k.*, m.naziv AS nazivMesta "
                                + "FROM kupac k "
                                + "JOIN mesto m "
                                + "ON k.idMesto = m.idMesto "
                                + "LIMIT 1"
                        );

        ResultSet rs = ps.executeQuery();

        assertTrue(
                rs.next(),
                "U bazi mora postojati makar jedan kupac."
        );

        Mesto mesto =
                new Mesto(
                        rs.getLong("idMesto"),
                        rs.getString("nazivMesta")
                );

        Kupac k =
                new Kupac(
                        rs.getLong("idKupac"),
                        rs.getString("ime"),
                        rs.getString("prezime"),
                        rs.getString("brojTelefona"),
                        rs.getString("email"),
                        mesto
                );

        rs.close();
        ps.close();

        return k;
    }

    private Kolac vratiPrviKolac()
            throws Exception {

        PreparedStatement ps =
                DBBroker.getInstance()
                        .getConnection()
                        .prepareStatement(
                                "SELECT * FROM kolac LIMIT 1"
                        );

        ResultSet rs = ps.executeQuery();

        assertTrue(
                rs.next(),
                "U bazi mora postojati makar jedan kolac."
        );

        Kolac k =
                new Kolac(
                        rs.getLong("idKolac"),
                        rs.getString("naziv"),
                        rs.getDouble("cena"),
                        rs.getString("opis")
                );

        rs.close();
        ps.close();

        return k;
    }

    private boolean postojiRacunUBazi(Long idRacun)
            throws Exception {

        PreparedStatement ps =
                DBBroker.getInstance()
                        .getConnection()
                        .prepareStatement(
                                "SELECT * FROM racun "
                                + "WHERE idRacun = ?"
                        );

        ps.setLong(1, idRacun);

        ResultSet rs = ps.executeQuery();

        boolean postoji = rs.next();

        rs.close();
        ps.close();

        return postoji;
    }

    private boolean postojiStavkaUBazi(Long idRacun)
            throws Exception {

        PreparedStatement ps =
                DBBroker.getInstance()
                        .getConnection()
                        .prepareStatement(
                                "SELECT * FROM stavkaRacuna "
                                + "WHERE idRacun = ?"
                        );

        ps.setLong(1, idRacun);

        ResultSet rs = ps.executeQuery();

        boolean postoji = rs.next();

        rs.close();
        ps.close();

        return postoji;
    }
}