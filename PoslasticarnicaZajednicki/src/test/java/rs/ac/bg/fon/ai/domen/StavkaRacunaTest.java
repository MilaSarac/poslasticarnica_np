package rs.ac.bg.fon.ai.domen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StavkaRacunaTest {

    private StavkaRacuna sr;
    private Racun r;
    private Kolac k;

    @BeforeEach
    void setUp() throws Exception {
        sr = new StavkaRacuna();
        r = new Racun();
        k = new Kolac();
    }

    @AfterEach
    void tearDown() throws Exception {
        sr = null;
        r = null;
        k = null;
    }

    @Test
    void testStavkaRacuna() {
        assertNotNull(sr);
    }

    @Test
    void testStavkaRacunaRacunIntDoubleIntDoubleKolac() {
        r.setIdRacun(1L);
        
        k.setIdKolac(1L);

        StavkaRacuna stavkaRacuna =
                new StavkaRacuna(r, 1, 300.0, 2, 600.0, k);

        assertNotNull(stavkaRacuna);
        assertEquals(r, stavkaRacuna.getRacun());
        assertEquals(1, stavkaRacuna.getRb());
        assertEquals(300.0, stavkaRacuna.getCena());
        assertEquals(2, stavkaRacuna.getKolicina());
        assertEquals(600.0, stavkaRacuna.getIznos());
        assertEquals(k, stavkaRacuna.getKolac());
    }

    @Test
    void testSetRacun() {
        r.setIdRacun(1L);

        sr.setRacun(r);

        assertEquals(r, sr.getRacun());
    }

    @Test
    void testSetCena() {
        sr.setCena(300.0);

        assertEquals(300.0, sr.getCena());
    }

    @Test
    void testSetCenaNula() {
        assertThrows(
        		java.lang.IllegalArgumentException.class,
                () -> sr.setCena(0)
        );
    }

    @Test
    void testSetCenaNegativna() {
        assertThrows(
        		java.lang.IllegalArgumentException.class,
                () -> sr.setCena(-300.0)
        );
    }

    @Test
    void testSetKolicina() {
        sr.setKolicina(2);

        assertEquals(2, sr.getKolicina());
    }

    @Test
    void testSetKolicinaNula() {
        assertThrows(
        		java.lang.IllegalArgumentException.class,
                () -> sr.setKolicina(0)
        );
    }

    @Test
    void testSetKolicinaNegativna() {
        assertThrows(
        		java.lang.IllegalArgumentException.class,
                () -> sr.setKolicina(-2)
        );
    }

    @Test
    void testSetIznos() {
        sr.setIznos(600.0);

        assertEquals(600.0, sr.getIznos());
    }

    @Test
    void testSetIznosNula() {
        assertThrows(
        		java.lang.IllegalArgumentException.class,
                () -> sr.setIznos(0)
        );
    }

    @Test
    void testSetIznosNegativan() {
        assertThrows(
        		java.lang.IllegalArgumentException.class,
                () -> sr.setIznos(-600.0)
        );
    }

    @Test
    void testSetKolac() {
        k.setIdKolac(1L);

        sr.setKolac(k);

        assertEquals(k, sr.getKolac());
    }
}