package rs.ac.bg.fon.ai.domen;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RacunTest {

    private Racun r;

    @BeforeEach
    void setUp() throws Exception {
        r = new Racun();
    }

    @AfterEach
    void tearDown() throws Exception {
        r = null;
    }

    @Test
    void testRacun() {
        assertNotNull(r);
    }

    @Test
    void testRacunLongDateDoublePoslasticarKupacArrayList() {
        Date datum = new Date();

        Poslasticar p = new Poslasticar();
        p.setIdPoslasticar(1L);

        Kupac k = new Kupac();
        k.setIdKupac(1L);

        ArrayList<StavkaRacuna> stavke = new ArrayList<StavkaRacuna>();

        Racun racun = new Racun(
                1L,
                datum,
                1500.0,
                p,
                k,
                stavke
        );

        assertNotNull(racun);
        assertEquals(1L, racun.getIdRacun());
        assertEquals(datum, racun.getDatumIzdavanja());
        assertEquals(1500.0, racun.getUkupanIznos());
        assertEquals(p, racun.getPoslasticar());
        assertEquals(k, racun.getKupac());
        assertEquals(stavke, racun.getStavkeRacuna());
    }

    @Test
    void testSetDatumIzdavanja() {
        Date datum = new Date();

        r.setDatumIzdavanja(datum);

        assertEquals(datum, r.getDatumIzdavanja());
    }

    @Test
    void testSetDatumIzdavanjaNull() {
        assertThrows(
        		java.lang.NullPointerException.class,
                () -> r.setDatumIzdavanja(null)
        );
    }

    @SuppressWarnings("deprecation")
	@Test
    void testSetDatumIzdavanjaBuducnost() {
        assertThrows(
        		java.lang.IllegalArgumentException.class,
                () -> r.setDatumIzdavanja(new Date(126, 9, 11))
        );
    }

    @Test
    void testSetUkupanIznos() {
        r.setUkupanIznos(1500.0);

        assertEquals(1500.0, r.getUkupanIznos());
    }

    @Test
    void testSetUkupanIznosNula() {
        assertThrows(
        		java.lang.IllegalArgumentException.class,
                () -> r.setUkupanIznos(0)
        );
    }

    @Test
    void testSetUkupanIznosNegativan() {
        assertThrows(
        		java.lang.IllegalArgumentException.class,
                () -> r.setUkupanIznos(-500.0)
        );
    }

    @Test
    void testSetPoslasticar() {
    	Poslasticar p = new Poslasticar();
        p.setIdPoslasticar(1L);

        r.setPoslasticar(p);

        assertEquals(p, r.getPoslasticar());
    }

    @Test
    void testSetKupac() {
    	Kupac k = new Kupac();
        k.setIdKupac(1L);

        r.setKupac(k);

        assertEquals(k, r.getKupac());
    }

    @Test
    void testSetStavkeRacuna() {
    	Kolac k = new Kolac();
        StavkaRacuna sr = new StavkaRacuna(
                r, 1, 300.0, 2, 600.0, k
        );
        ArrayList<StavkaRacuna> stavke = new ArrayList<>();
        stavke.add(sr);
        r.setStavkeRacuna(stavke);

        assertEquals(stavke, r.getStavkeRacuna());
    }
}