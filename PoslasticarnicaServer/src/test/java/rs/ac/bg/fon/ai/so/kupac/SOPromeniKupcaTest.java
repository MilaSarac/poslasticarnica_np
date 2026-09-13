package rs.ac.bg.fon.ai.so.kupac;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import rs.ac.bg.fon.ai.baza.DBBroker;
import rs.ac.bg.fon.ai.domen.Kolac;
import rs.ac.bg.fon.ai.domen.Kupac;
import rs.ac.bg.fon.ai.domen.Mesto;

class SOPromeniKupcaTest {

    private SOPromeniKupca operacija;

    private ArrayList<Long> testKupci;

    @BeforeEach
    void setUp() {
        operacija = new SOPromeniKupca();
        testKupci = new ArrayList<>();
    }

    @AfterEach
    void tearDown() throws Exception {

        Connection connection =
                DBBroker.getInstance().getConnection();

        for (Long id : testKupci) {

            PreparedStatement ps =
                    connection.prepareStatement(
                            "DELETE FROM kupac WHERE idKupac = ?"
                    );

            ps.setLong(1, id);
            ps.executeUpdate();
            ps.close();
        }

        connection.commit();

        testKupci.clear();
        operacija = null;
    }

    @Test
    void testPromeniSamoMesto() throws Exception {

        Mesto mesto = vratiPrvoMesto();

        String email =
                "promena" + System.nanoTime() + "@gmail.com";

        String telefon =
                generisiTelefon(1);

        Kupac kupac = new Kupac(
                null,
                "Test",
                "Kupac",
                telefon,
                email,
                mesto
        );

        Long idKupac = dodajTestKupca(kupac);

        Kupac promenjeniKupac = new Kupac(
                idKupac,
                "Test",
                "Kupac",
                telefon,
                email,
                mesto
        );

        assertDoesNotThrow(
                () -> operacija.izvrsi(promenjeniKupac)
        );
    }

    @Test
    void testPromeniEmailITelefon() throws Exception {

        Mesto mesto = vratiPrvoMesto();

        String email =
                "stari" + System.nanoTime() + "@gmail.com";

        String telefon =
                generisiTelefon(2);

        Kupac kupac = new Kupac(
                null,
                "Test",
                "Kupac",
                telefon,
                email,
                mesto
        );

        Long idKupac = dodajTestKupca(kupac);

        String noviEmail =
                "novi" + System.nanoTime() + "@gmail.com";

        String noviTelefon =
                generisiTelefon(3);

        Kupac promenjeniKupac = new Kupac(
                idKupac,
                "Test",
                "Kupac",
                noviTelefon,
                noviEmail,
                mesto
        );

        assertDoesNotThrow(
                () -> operacija.izvrsi(promenjeniKupac)
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
    void testKupacBezIdentifikatora() throws Exception {

        Mesto mesto = vratiPrvoMesto();

        Kupac kupac = new Kupac(
                null,
                "Test",
                "Kupac",
                generisiTelefon(4),
                "bezid" + System.nanoTime() + "@gmail.com",
                mesto
        );

        assertThrows(
                Exception.class,
                () -> operacija.izvrsi(kupac)
        );
    }

    @Test
    void testPostojeciEmail() throws Exception {

        Mesto mesto = vratiPrvoMesto();

        String emailPrvog =
                "prvi" + System.nanoTime() + "@gmail.com";

        String emailDrugog =
                "drugi" + System.nanoTime() + "@gmail.com";

        Kupac prvi = new Kupac(
                null,
                "Prvi",
                "Kupac",
                generisiTelefon(5),
                emailPrvog,
                mesto
        );

        Kupac drugi = new Kupac(
                null,
                "Drugi",
                "Kupac",
                generisiTelefon(6),
                emailDrugog,
                mesto
        );

        dodajTestKupca(prvi);
        Long idDrugog = dodajTestKupca(drugi);

        Kupac promenjeniDrugi = new Kupac(
                idDrugog,
                "Drugi",
                "Kupac",
                drugi.getBrojTelefona(),
                emailPrvog,
                mesto
        );

        assertThrows(
                Exception.class,
                () -> operacija.izvrsi(promenjeniDrugi)
        );
    }

    @Test
    void testPostojeciTelefon() throws Exception {

        Mesto mesto = vratiPrvoMesto();

        String telefonPrvog =
                generisiTelefon(7);

        String telefonDrugog =
                generisiTelefon(8);

        Kupac prvi = new Kupac(
                null,
                "Prvi",
                "Kupac",
                telefonPrvog,
                "prvi" + System.nanoTime() + "@gmail.com",
                mesto
        );

        Kupac drugi = new Kupac(
                null,
                "Drugi",
                "Kupac",
                telefonDrugog,
                "drugi" + System.nanoTime() + "@gmail.com",
                mesto
        );

        dodajTestKupca(prvi);
        Long idDrugog = dodajTestKupca(drugi);

        Kupac promenjeniDrugi = new Kupac(
                idDrugog,
                "Drugi",
                "Kupac",
                telefonPrvog,
                drugi.getEmail(),
                mesto
        );

        assertThrows(
                Exception.class,
                () -> operacija.izvrsi(promenjeniDrugi)
        );
    }

    private Long dodajTestKupca(Kupac kupac) throws Exception {

        DBBroker.getInstance().dodaj(kupac);
        DBBroker.getInstance().getConnection().commit();

        PreparedStatement ps =
                DBBroker.getInstance()
                        .getConnection()
                        .prepareStatement(
                                "SELECT idKupac FROM kupac WHERE email = ?"
                        );

        ps.setString(1, kupac.getEmail());

        ResultSet rs = ps.executeQuery();

        Long id = null;

        if (rs.next()) {
            id = rs.getLong("idKupac");
        }

        rs.close();
        ps.close();

        assertNotNull(id);

        testKupci.add(id);

        return id;
    }

    private Mesto vratiPrvoMesto() throws Exception {

        PreparedStatement ps =
                DBBroker.getInstance()
                        .getConnection()
                        .prepareStatement(
                                "SELECT idMesto, naziv FROM mesto LIMIT 1"
                        );

        ResultSet rs = ps.executeQuery();

        assertTrue(
                rs.next(),
                "U bazi mora postojati makar jedno mesto."
        );

        Mesto mesto = new Mesto(
                rs.getLong("idMesto"),
                rs.getString("naziv")
        );

        rs.close();
        ps.close();

        return mesto;
    }

    private String generisiTelefon(int dodatak) {

        long broj =
                Math.abs(
                        (System.nanoTime() + dodatak)
                                % 100000000L
                );

        return String.format(
                "06%08d",
                broj
        );
    }
}
