package rs.ac.bg.fon.ai.domen;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PoslasticarSmenaTest {

    private PoslasticarSmena ps;

    @BeforeEach
    void setUp() throws Exception {
        ps = new PoslasticarSmena();
    }

    @AfterEach
    void tearDown() throws Exception {
        ps = null;
    }

    @Test
    void testPoslasticarSmena() {
        assertNotNull(ps);
    }

    @Test
    void testPoslasticarSmenaPoslasticarSmenaDate() {
        Poslasticar p = new Poslasticar();
        p.setIdPoslasticar(1L);

        Smena s = new Smena();
        s.setIdSmena(1L);

        Date datum = new Date();

        PoslasticarSmena poslasticarSmena = 
                new PoslasticarSmena(p, s, datum);

        assertEquals(p, poslasticarSmena.getPoslasticar());
        assertEquals(s, poslasticarSmena.getSmena());
        assertEquals(datum, poslasticarSmena.getDatum());
    }

    @SuppressWarnings("deprecation")
	@Test
    void testSetDatum() {
        ps.setDatum(new Date(126, 8, 25));

        assertEquals(new Date(126, 8, 25), ps.getDatum());
    }

    @Test
    void testSetDatumNull() {
        assertThrows(
        		java.lang.NullPointerException.class,
                () -> ps.setDatum(null)
        );
    }
}