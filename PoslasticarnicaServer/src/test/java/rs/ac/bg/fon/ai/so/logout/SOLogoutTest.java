package rs.ac.bg.fon.ai.so.logout;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import rs.ac.bg.fon.ai.domen.Kolac;
import rs.ac.bg.fon.ai.domen.Poslasticar;
import rs.ac.bg.fon.ai.kontroler.ServerKontroler;

class SOLogoutTest {

    private SOLogout operacija;
    private Poslasticar poslasticar;

    @BeforeEach
    void setUp() {

        operacija = new SOLogout();

        poslasticar = new Poslasticar(1L, "Mila", "Sarac", "mila", "123", new Date());

        ServerKontroler.getInstance().getUlogovaniPoslasticari().clear();
    }

    @AfterEach
    void tearDown() {

        ServerKontroler.getInstance().getUlogovaniPoslasticari().clear();

        operacija = null;
        poslasticar = null;
    }

    @Test
    void testLogout() throws Exception {

        ServerKontroler.getInstance().getUlogovaniPoslasticari().add(poslasticar);

        assertTrue(ServerKontroler.getInstance().getUlogovaniPoslasticari().contains(poslasticar));

        assertDoesNotThrow(() -> operacija.izvrsi(poslasticar));
        assertFalse(ServerKontroler.getInstance().getUlogovaniPoslasticari().contains(poslasticar));
    }

    @Test
    void testPogresanTipObjekta() {

        assertThrows(Exception.class, () -> operacija.izvrsi(new Kolac()));
    }

    @Test
    void testPoslasticarNijeUlogovan() {

        assertFalse(ServerKontroler.getInstance().getUlogovaniPoslasticari().contains(poslasticar));
        assertThrows(Exception.class, () -> operacija.izvrsi(poslasticar));
    }
}
