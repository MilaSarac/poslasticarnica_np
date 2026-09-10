package rs.ac.bg.fon.ai.domen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MestoTest {

    private Mesto m;

    @BeforeEach
    void setUp() throws Exception {
        m = new Mesto();
    }

    @AfterEach
    void tearDown() throws Exception {
        m = null;
    }

    @Test
    void testMesto() {
        assertNotNull(m);
    }

    @Test
    void testMestoLongString() {
        m = new Mesto(1L, "Beograd");

        assertNotNull(m);
        assertEquals(1L, m.getIdMesto());
        assertEquals("Beograd", m.getNaziv());
    }

    @Test
    void testSetNaziv() {
        m.setNaziv("Novi Sad");

        assertEquals("Novi Sad", m.getNaziv());
    }

    @Test
    void testSetNazivNull() {
        assertThrows(java.lang.NullPointerException.class, () -> m.setNaziv(null));
    }

    @Test
    void testSetNazivPrazno() {
        assertThrows(java.lang.IllegalArgumentException.class, () -> m.setNaziv(""));
    }

    @Test
    void testToString() {
        m = new Mesto(1L, "Beograd");

        assertTrue(m.toString().contains("Beograd"));
    }
}