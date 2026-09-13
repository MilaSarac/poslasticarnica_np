package rs.ac.bg.fon.ai.so.kupac;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import rs.ac.bg.fon.ai.baza.DBBroker;
import rs.ac.bg.fon.ai.domen.Kolac;
import rs.ac.bg.fon.ai.domen.Kupac;
import rs.ac.bg.fon.ai.domen.Mesto;

class SOPretraziKupceTest {

    private SOPretraziKupce operacija;

    private String testEmail;

    @BeforeEach
    void setUp() throws Exception {
        operacija = new SOPretraziKupce();

        long vreme = System.currentTimeMillis();
        testEmail = "pretraga" + vreme + "@gmail.com";

        String telefon =
                "06" + String.valueOf(vreme).substring(
                        String.valueOf(vreme).length() - 8);

        Mesto mesto = new Mesto();
        mesto.setIdMesto(1L);

        Kupac kupac = new Kupac(
                null,
                "TestPretraga",
                "Kupac",
                telefon,
                testEmail,
                mesto
        );

        DBBroker.getInstance().dodaj(kupac);
        DBBroker.getInstance().getConnection().commit();
    }

    @AfterEach
    void tearDown() throws Exception {
        obrisiTestKupca();
        operacija = null;
    }

    @Test
    void testPretraziKupcePoEmailu() {

        Kupac kriterijum = new Kupac();
        kriterijum.setEmail(testEmail);

        assertDoesNotThrow(() -> operacija.izvrsi(kriterijum));

        assertNotNull(operacija.getLista());
        assertFalse(operacija.getLista().isEmpty());

        assertEquals(
                testEmail,
                operacija.getLista().get(0).getEmail()
        );
    }

    @Test
    void testPretraziKupcePoImenu() {

        Kupac kriterijum = new Kupac();
        kriterijum.setIme("TestPretraga");

        assertDoesNotThrow(() -> operacija.izvrsi(kriterijum));

        assertNotNull(operacija.getLista());
        assertFalse(operacija.getLista().isEmpty());
    }

    @Test
    void testPogresanTipObjekta() {

        assertThrows(
                Exception.class,
                () -> operacija.izvrsi(new Kolac())
        );
    }

    private void obrisiTestKupca() throws Exception {

        Connection connection =
                DBBroker.getInstance().getConnection();

        String upit =
                "DELETE FROM kupac WHERE email = ?";

        PreparedStatement ps =
                connection.prepareStatement(upit);

        ps.setString(1, testEmail);

        ps.executeUpdate();
        connection.commit();

        ps.close();
    }
}