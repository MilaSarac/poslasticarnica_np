package rs.ac.bg.fon.ai.transfer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class KlijentskiZahtevTest {

    private KlijentskiZahtev klijentskiZahtev;

    @BeforeEach
    public void setUp() {
        int operacija = 0;
        Object zahtev = "zahtev";
        klijentskiZahtev = new KlijentskiZahtev(operacija, zahtev);
    }

    @AfterEach
    public void tearDown() {
        klijentskiZahtev = null;
    }

    @Test
    public void testGetOperacija() {
        int rezultat = klijentskiZahtev.getOperacija();

        assertEquals(0, rezultat);
    }

    @Test
    public void testSetOperacija() {
        int novaOperacija = 1;
        klijentskiZahtev.setOperacija(novaOperacija);
        int rezultat = klijentskiZahtev.getOperacija();
        
        assertEquals(1, rezultat);
    }

    @Test
    public void testGetZahtev() {
        Object rezultat = klijentskiZahtev.getZahtev();

        assertEquals("zahtev", rezultat);
    }

    @Test
    public void testSetZahtev() {
        Object noviZahtev = "zahtev123";
        klijentskiZahtev.setZahtev(noviZahtev);
        Object rezultat = klijentskiZahtev.getZahtev();
        
        assertEquals("zahtev123", rezultat);
    }
}