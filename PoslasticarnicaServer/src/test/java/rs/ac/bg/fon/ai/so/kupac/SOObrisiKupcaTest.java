package rs.ac.bg.fon.ai.so.kupac;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import rs.ac.bg.fon.ai.baza.DBBroker;
import rs.ac.bg.fon.ai.domen.Kolac;
import rs.ac.bg.fon.ai.domen.Kupac;
import rs.ac.bg.fon.ai.domen.Mesto;

class SOObrisiKupcaTest {

    private SOObrisiKupca operacija;

    @BeforeEach
    void setUp() {
        operacija = new SOObrisiKupca();
    }

    @Test
    void testObrisiKupca() throws Exception {

        Mesto mesto = new Mesto();
        mesto.setIdMesto(1L);

        long vreme = System.currentTimeMillis();

        String email = "brisanje" + vreme + "@gmail.com";

        String telefon =
                "06" + String.valueOf(vreme).substring(
                        String.valueOf(vreme).length() - 8);

        Kupac kupac = new Kupac(
                null,
                "Test",
                "Kupac",
                telefon,
                email,
                mesto
        );

        DBBroker.getInstance().dodaj(kupac);
        DBBroker.getInstance().getConnection().commit();

        Long idKupac = pronadjiIdKupca(email);

        assertNotNull(idKupac);

        kupac.setIdKupac(idKupac);

        assertDoesNotThrow(() -> operacija.izvrsi(kupac));

        assertFalse(postojiKupac(idKupac));
    }

    @Test
    void testPogresanTipObjekta() {

        assertThrows(Exception.class,() -> operacija.izvrsi(new Kolac()));
    }

    private Long pronadjiIdKupca(String email) throws Exception {

        Connection connection = DBBroker.getInstance().getConnection();

        String upit = "SELECT idKupac FROM kupac WHERE email = ?";

        PreparedStatement ps = connection.prepareStatement(upit);

        ps.setString(1, email);

        ResultSet rs = ps.executeQuery();

        Long idKupac = null;

        if (rs.next()) {
            idKupac = rs.getLong("idKupac");
        }

        rs.close();
        ps.close();

        return idKupac;
    }

    private boolean postojiKupac(Long idKupac) throws Exception {

        Connection connection = DBBroker.getInstance().getConnection();

        String upit = "SELECT idKupac FROM kupac WHERE idKupac = ?";

        PreparedStatement ps = connection.prepareStatement(upit);

        ps.setLong(1, idKupac);

        ResultSet rs = ps.executeQuery();

        boolean postoji = rs.next();

        rs.close();
        ps.close();

        return postoji;
    }
}