package rs.ac.bg.fon.ai.domen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class KupacTest {

    private Kupac k;
    private Mesto m;

    @BeforeEach
    void setUp() throws Exception {
        k = new Kupac();
        m = new Mesto(1L, "Beograd");
    }

    @AfterEach
    void tearDown() throws Exception {
        k = null;
        m = null;
    }

    @Test
    void testKupac() {
        assertNotNull(k);
    }

    @Test
    void testKupacLongStringStringStringStringMesto() {
        k = new Kupac(
                1L,
                "Mila",
                "Sarac",
                "0611234567",
                "mila@gmail.com",
                m
        );

        assertNotNull(k);
        assertEquals(1L, k.getIdKupac());
        assertEquals("Mila", k.getIme());
        assertEquals("Sarac", k.getPrezime());
        assertEquals("0611234567", k.getBrojTelefona());
        assertEquals("mila@gmail.com", k.getEmail());
        assertEquals(m, k.getMesto());
    }

    @Test
    void testSetIme() {
        k.setIme("Mila");
        assertEquals("Mila", k.getIme());
    }

    @Test
    void testSetImeNull() {
        assertThrows(NullPointerException.class, () -> k.setIme(null));
    }

    @Test
    void testSetImePrazno() {
        assertThrows(IllegalArgumentException.class, () -> k.setIme(""));
    }

    @Test
    void testSetPrezime() {
        k.setPrezime("Sarac");
        assertEquals("Sarac", k.getPrezime());
    }

    @Test
    void testSetPrezimeNull() {
        assertThrows(NullPointerException.class, () -> k.setPrezime(null));
    }

    @Test
    void testSetPrezimePrazno() {
        assertThrows(IllegalArgumentException.class, () -> k.setPrezime(""));
    }

    @Test
    void testSetBrojTelefona() {
        k.setBrojTelefona("0611234567");
        assertEquals("0611234567", k.getBrojTelefona());
    }

    @Test
    void testSetBrojTelefonaNull() {
        assertThrows(
                NullPointerException.class,
                () -> k.setBrojTelefona(null)
        );
    }

    @Test
    void testSetBrojtelefonaPrazno() {
        assertThrows(
                IllegalArgumentException.class,
                () -> k.setBrojTelefona("")
        );
    }

    @Test
    void testSetEmail() {
        k.setEmail("mila@gmail.com");
        assertEquals("mila@gmail.com", k.getEmail());
    }

    @Test
    void testSetEmailNull() {
        assertThrows(NullPointerException.class, () -> k.setEmail(null));
    }

    @Test
    void testSetEmailPrazno() {
        assertThrows(IllegalArgumentException.class, () -> k.setEmail(""));
    }

    @Test
    void testSetEmailNeispravanFormat() {
        assertThrows(
                IllegalArgumentException.class,
                () -> k.setEmail("milagmail.com")
        );
    }

    @Test
    void testSetMesto() {
        k.setMesto(m);
        assertEquals(m, k.getMesto());
    }

    @Test
    void testSetMestoNull() {
        assertThrows(NullPointerException.class, () -> k.setMesto(null));
    }

    @Test
    void testToString() {
        k = new Kupac(
                1L,
                "Mila",
                "Sarac",
                "0611234567",
                "mila@gmail.com",
                m
        );

        assertEquals("Mila Sarac", k.toString());
    }
    
    @ParameterizedTest
    @CsvSource({
        "1, 1, true",
        "1, 2, false"
    })
    void testEquals(Long id1, Long id2, boolean ocekivano) {

        Kupac k1 = new Kupac();
        k1.setIdKupac(id1);

        Kupac k2 = new Kupac();
        k2.setIdKupac(id2);

        assertEquals(ocekivano, k1.equals(k2));
    }
    
    /*
    @ParameterizedTest
    @CsvSource({
        "1, 1, true",
        "1, 2, false"
    })
    void testEquals(Long id1, Long id2, boolean ocekivano) {

        Kupac k1 = new Kupac(
                id1, "Mila", "Sarac",
                "0611234567", "mila@gmail.com", m);

        Kupac k2 = new Kupac(
                id2, "Ana", "Jovic",
                "0621234567", "ana@gmail.com", m);

        assertEquals(ocekivano, k1.equals(k2));
    }
    */
    /*
    @Test
    void testEqualsTrue() {
    	k = new Kupac(
                1L,
                "Mila",
                "Sarac",
                "0611234567",
                "mila@gmail.com",
                m
        );
    	
    	Kupac k2 = new Kupac(
                1L, "Ana", "Jovic",
                "0621234567", "ana@gmail.com", m
        );
    	
    	 assertTrue(k.equals(k2));
    }
    
    @Test
    void testEqualsFalse() {
    	k = new Kupac(
                1L,
                "Mila",
                "Sarac",
                "0611234567",
                "mila@gmail.com",
                m
        );
    	
    	Kupac k2 = new Kupac(
                2L, "Ana", "Jovic",
                "0621234567", "ana@gmail.com", m
        );
    	
    	 assertFalse(k.equals(k2));
    }
    */
    
}
