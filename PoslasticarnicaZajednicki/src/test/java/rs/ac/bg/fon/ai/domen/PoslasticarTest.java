package rs.ac.bg.fon.ai.domen;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PoslasticarTest {

    private Poslasticar p;

    @BeforeEach
    void setUp() throws Exception {
        p = new Poslasticar();
    }

    @AfterEach
    void tearDown() throws Exception {
        p = null;
    }

    @Test
    void testPoslasticar() {
        assertNotNull(p);
    }

    @SuppressWarnings("deprecation")
	@Test
    void testPoslasticarLongStringStringStringStringDate() {

        p = new Poslasticar(
                1L,
                "Petar",
                "Petrovic",
                "petar",
                "sifra123",
                new Date(125, 5, 10)
        );

        assertNotNull(p);
        assertEquals(1L, p.getIdPoslasticar());
        assertEquals("Petar", p.getIme());
        assertEquals("Petrovic", p.getPrezime());
        assertEquals("petar", p.getKorisnickoIme());
        assertEquals("sifra123", p.getSifra());
        assertEquals(new Date(125, 5, 10), p.getDatumZaposlenja());
    }

    @Test
    void testSetIme() {
        p.setIme("Petar");
        assertEquals("Petar", p.getIme());
    }

    @Test
    void testSetImeNull() {
        assertThrows(
        		java.lang.NullPointerException.class,
                () -> p.setIme(null)
        );
    }

    @Test
    void testSetImePrazno() {
        assertThrows(
        		java.lang.IllegalArgumentException.class,
                () -> p.setIme("")
        );
    }

    @Test
    void testSetPrezime() {
        p.setPrezime("Petrovic");
        assertEquals("Petrovic", p.getPrezime());
    }

    @Test
    void testSetPrezimeNull() {
        assertThrows(
        		java.lang.NullPointerException.class,
                () -> p.setPrezime(null)
        );
    }

    @Test
    void testSetPrezimePrazno() {
        assertThrows(
        		java.lang.IllegalArgumentException.class,
                () -> p.setPrezime("")
        );
    }

    @Test
    void testSetKorisnickoIme() {
        p.setKorisnickoIme("petar");
        assertEquals("petar", p.getKorisnickoIme());
    }

    @Test
    void testSetKorisnickoImeNull() {
        assertThrows(
        		java.lang.NullPointerException.class,
                () -> p.setKorisnickoIme(null)
        );
    }

    @Test
    void testSetKorisnickoImePrazno() {
        assertThrows(
        		java.lang.IllegalArgumentException.class,
                () -> p.setKorisnickoIme("")
        );
    }

    @Test
    void testSetSifra() {
        p.setSifra("sifra123");
        assertEquals("sifra123", p.getSifra());
    }

    @Test
    void testSetSifraNull() {
        assertThrows(
        		java.lang.NullPointerException.class,
                () -> p.setSifra(null)
        );
    }

    @Test
    void testSetSifraPrazno() {
        assertThrows(
        		java.lang.IllegalArgumentException.class,
                () -> p.setSifra("")
        );
    }

    @Test
    void testSetDatumZaposlenja() {
        Date datum = new Date();

        p.setDatumZaposlenja(datum);

        assertEquals(datum, p.getDatumZaposlenja());
    }

    @Test
    void testSetDatumZaposlenjaNull() {
        assertThrows(
        		java.lang.NullPointerException.class,
                () -> p.setDatumZaposlenja(null)
        );
    }

	@SuppressWarnings("deprecation")
	@Test
    void testSetDatumZaposlenjaPosleDanasnjeg() {
    	assertThrows(
    			java.lang.IllegalArgumentException.class,
                () -> p.setDatumZaposlenja(new Date(126, 12, 1))
        );
    }

    @Test
    void testToString() {
        p.setIme("Pera");
        p.setPrezime("Peric");

        assertTrue(p.toString().contains("Pera"));
		assertTrue(p.toString().contains("Peric"));
    }

    @ParameterizedTest
    @CsvSource({
        "1, 1, true",
        "1, 2, false"
    })
    void testEquals(Long id1, Long id2, boolean ocekivano) {
        p.setIdPoslasticar(id1);

        Poslasticar p2 = new Poslasticar();
        p2.setIdPoslasticar(id2);

        assertEquals(ocekivano, p.equals(p2));
    }
    
}