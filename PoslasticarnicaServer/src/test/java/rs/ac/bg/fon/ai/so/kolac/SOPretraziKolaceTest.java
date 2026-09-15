package rs.ac.bg.fon.ai.so.kolac;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import rs.ac.bg.fon.ai.domen.Kolac;
import rs.ac.bg.fon.ai.domen.Kupac;

class SOPretraziKolaceTest {

    private SOPretraziKolace operacija;

    @BeforeEach
    void setUp() {
        operacija = new SOPretraziKolace();
    }

    @Test
    void testPretraziKolace() throws Exception {

        Kolac kriterijum = new Kolac();
        kriterijum.setNaziv("torta");

        operacija.izvrsi(kriterijum);

        assertNotNull(operacija.getLista());
        assertFalse(operacija.getLista().isEmpty());

        for (Kolac kolac : operacija.getLista()) {
            assertTrue(kolac.getNaziv().toLowerCase().contains("torta"));
        }
    }

    @Test
    void testPretragaBezRezultata() throws Exception {

        Kolac kriterijum = new Kolac();
        kriterijum.setNaziv("Kolac12345");

        operacija.izvrsi(kriterijum);

        assertNotNull(operacija.getLista());
        assertTrue(operacija.getLista().isEmpty());
    }

    @Test
    void testPogresanTipObjekta() {

        assertThrows(Exception.class, () -> {
            operacija.izvrsi(new Kupac());
        });
    }
}