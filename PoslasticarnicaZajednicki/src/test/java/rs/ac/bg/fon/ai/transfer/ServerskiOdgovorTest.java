package rs.ac.bg.fon.ai.transfer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import rs.ac.bg.fon.ai.transfer.util.RezultatOp;

class ServerskiOdgovorTest {

    private ServerskiOdgovor serverskiOdgovor;

    private final Object testOdgovor = "testOdgovor";
    private final Exception testException = new Exception("Test exception");
    private final RezultatOp testRezultat = RezultatOp.Uspeh;

    @BeforeEach
    public void setUp() {
        serverskiOdgovor =
                new ServerskiOdgovor(testOdgovor, testException, testRezultat);
    }

    @AfterEach
    public void tearDown() {
        serverskiOdgovor = null;
    }

    @Test
    public void testGetOdgovor() {
        Object rezultat = serverskiOdgovor.getOdgovor();

        assertEquals(testOdgovor, rezultat);
    }

    @Test
    public void testSetOdgovor() {
        Object noviOdgovor = 123;
        serverskiOdgovor.setOdgovor(noviOdgovor);
        Object rezultat = serverskiOdgovor.getOdgovor();
        
        assertEquals(noviOdgovor, rezultat);
    }

    @Test
    public void testGetExc() {
        Exception rezultat = serverskiOdgovor.getExc();

        assertEquals(testException, rezultat);
    }

    @Test
    public void testSetExc() {
        Exception noviException = new Exception("Novi test exception");
        serverskiOdgovor.setExc(noviException);
        Exception rezultat = serverskiOdgovor.getExc();
        
        assertEquals(noviException, rezultat);
    }

    @Test
    public void testGetRezultat() {
        RezultatOp rezultat = serverskiOdgovor.getRezultat();

        assertEquals(testRezultat, rezultat);
    }

    @Test
    public void testSetRezultat() {
        RezultatOp noviRezultat = RezultatOp.Greska;
        serverskiOdgovor.setRezultat(noviRezultat);
        RezultatOp rezultat = serverskiOdgovor.getRezultat();
        
        assertEquals(noviRezultat, rezultat);
    }
}