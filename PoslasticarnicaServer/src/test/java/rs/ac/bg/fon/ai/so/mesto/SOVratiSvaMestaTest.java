package rs.ac.bg.fon.ai.so.mesto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import rs.ac.bg.fon.ai.domen.Kolac;
import rs.ac.bg.fon.ai.domen.Mesto;

class SOVratiSvaMestaTest {

    private SOVratiSvaMesta operacija;

    @BeforeEach
    void setUp() {
        operacija = new SOVratiSvaMesta();
    }

    @Test
    void testVratiSvaMesta() {

        assertDoesNotThrow(
                () -> operacija.izvrsi(new Mesto())
        );

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
}
