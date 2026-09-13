package rs.ac.bg.fon.ai.so.login;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import rs.ac.bg.fon.ai.domen.Kolac;
import rs.ac.bg.fon.ai.domen.Poslasticar;
import rs.ac.bg.fon.ai.kontroler.ServerKontroler;

class SOLoginTest {

    private SOLogin operacija;

    @BeforeEach
    void setUp() {

        operacija = new SOLogin();

        ServerKontroler.getInstance().getUlogovaniPoslasticari().clear();
    }

    @AfterEach
    void tearDown() {

        ServerKontroler.getInstance().getUlogovaniPoslasticari().clear();
        operacija = null;
    }

    @Test
    void testUspesanLogin() throws Exception {

        Poslasticar poslasticar = new Poslasticar();

        poslasticar.setKorisnickoIme("ana");
        poslasticar.setSifra("ana123");

        operacija.izvrsi(poslasticar);

        assertNotNull(operacija.getUlogovani());

        assertEquals(poslasticar.getKorisnickoIme(), operacija.getUlogovani().getKorisnickoIme());

        assertTrue(ServerKontroler.getInstance().getUlogovaniPoslasticari().contains(operacija.getUlogovani()));
    }

    @Test
    void testPogresanTipObjekta() {

        assertThrows(Exception.class, () -> {operacija.izvrsi(new Kolac());});
    }

    @Test
    void testPogresniPodaciZaLogin() {

        Poslasticar poslasticar = new Poslasticar();

        poslasticar.setKorisnickoIme("nepostojeciKorisnik");
        poslasticar.setSifra("pogresnaSifra");

        Exception ex = assertThrows(Exception.class, () -> {operacija.izvrsi(poslasticar);});

        assertEquals("Korisničko ime i šifra nisu ispravni.", ex.getMessage());
    }
}
