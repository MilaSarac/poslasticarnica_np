package rs.ac.bg.fon.ai.so.kupac;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import rs.ac.bg.fon.ai.domen.Kolac;
import rs.ac.bg.fon.ai.domen.Kupac;

class SOVratiSveKupceTest {

    private SOVratiSveKupce operacija;

    @BeforeEach
    void setUp() {
        operacija = new SOVratiSveKupce();
    }

    @Test
    void testVratiSveKupce() {
        assertDoesNotThrow(() -> {
            operacija.izvrsi(new Kupac());

            assertNotNull(operacija.getLista());
        });
    }

    @Test
    void testPogresanTipObjekta() {
        Exception ex = assertThrows(
                Exception.class,
                () -> operacija.izvrsi(new Kolac())
        );

        assertEquals(
                "Prosleđeni objekat nije instanca klase Kupac!",
                ex.getMessage()
        );
    }
}
