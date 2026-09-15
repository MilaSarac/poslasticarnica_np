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

class SODodajKupcaTest {

    private SODodajKupca operacija;

    private static final String TEST_EMAIL = "testkupac@gmail.com";
    private static final String TEST_TELEFON = "0612345678";

    @BeforeEach
    void setUp() throws Exception {
        operacija = new SODodajKupca();
        obrisiTestKupca();
    }

    @AfterEach
    void tearDown() throws Exception {
        obrisiTestKupca();
        operacija = null;
    }

    @Test
    void testDodajKupca() {

        Mesto mesto = new Mesto();
        mesto.setIdMesto(1L);

        Kupac kupac = new Kupac(null,"Test","Kupac",TEST_TELEFON,TEST_EMAIL,mesto);

        assertDoesNotThrow(() -> operacija.izvrsi(kupac));
    }

    @Test
    void testPogresanTipObjekta() {

        assertThrows(Exception.class,() -> operacija.izvrsi(new Kolac()));
    }

    @Test
    void testNeispravanTelefon() {

        Mesto mesto = new Mesto();
        mesto.setIdMesto(1L);

        Kupac kupac = new Kupac(null,"Test","Kupac","12345",TEST_EMAIL, mesto);

        assertThrows(Exception.class, () -> operacija.izvrsi(kupac));
    }

    @Test
    void testPostojeciEmail() throws Exception {

        Mesto mesto = new Mesto();
        mesto.setIdMesto(1L);

        Kupac prvi = new Kupac(null,"Test","Kupac",TEST_TELEFON,TEST_EMAIL,mesto);

        operacija.izvrsi(prvi);

        SODodajKupca drugaOperacija = new SODodajKupca();

        Kupac drugi = new Kupac(null,"Drugi","Kupac","0698765432",TEST_EMAIL, mesto);

        assertThrows(Exception.class, () -> drugaOperacija.izvrsi(drugi));
    }

    @Test
    void testPostojeciTelefon() throws Exception {

        Mesto mesto = new Mesto();
        mesto.setIdMesto(1L);

        Kupac prvi = new Kupac(null,"Test","Kupac",TEST_TELEFON,TEST_EMAIL,mesto);

        operacija.izvrsi(prvi);

        SODodajKupca drugaOperacija = new SODodajKupca();

        Kupac drugi = new Kupac(null,"Drugi","Kupac",TEST_TELEFON,"drugi@gmail.com",mesto);

        assertThrows(Exception.class, () -> drugaOperacija.izvrsi(drugi));
    }

    private void obrisiTestKupca() throws Exception {

        Connection connection = DBBroker.getInstance().getConnection();

        String upit = "DELETE FROM kupac WHERE email = ? OR brojTelefona = ?";

        PreparedStatement ps = connection.prepareStatement(upit);

        ps.setString(1, TEST_EMAIL);
        ps.setString(2, TEST_TELEFON);

        ps.executeUpdate();
        connection.commit();

        ps.close();
    }
}