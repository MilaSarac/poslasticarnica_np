package rs.ac.bg.fon.ai.so.kolac;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import rs.ac.bg.fon.ai.domen.Kolac;
import rs.ac.bg.fon.ai.domen.Kupac;

class SOVratiSveKolaceTest {

    private SOVratiSveKolace operacija;

    @BeforeEach
    void setUp() {
        operacija = new SOVratiSveKolace();
    }

    @AfterEach
    void tearDown() {
        operacija = null;
    }

    @Test
    void testVratiSveKolace() throws Exception {

        operacija.izvrsi(new Kolac());

        assertNotNull(operacija.getLista());
        assertFalse(operacija.getLista().isEmpty());
    }

    @Test
    void testPogresanTipObjekta() {

        assertThrows(Exception.class, () -> {
            operacija.izvrsi(new Kupac());
        });
    }
}
