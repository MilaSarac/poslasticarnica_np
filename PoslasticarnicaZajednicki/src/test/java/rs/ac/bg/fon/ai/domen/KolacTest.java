package rs.ac.bg.fon.ai.domen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class KolacTest {
	
	private Kolac k;

	@BeforeEach
	void setUp() throws Exception {
		k = new Kolac();
	}

	@AfterEach
	void tearDown() throws Exception {
		k = null;
	}
	
	@Test
	void testKolac() {
		assertNotNull(k);
	}
	
	@Test
	void testKolacLongStringDoubleString() {
		k = new Kolac(1l, "Brauni", 370.0, "Ukusan kolac");
		assertNotNull(k);
		assertEquals(1l, k.getIdKolac());
		assertEquals("Brauni", k.getNaziv());
		assertEquals(370.0, k.getCena());
		assertEquals("Ukusan kolac", k.getOpis());
	}

	@Test
	void testSetNaziv() {
		k.setNaziv("Mak tart");
		assertEquals("Mak tart", k.getNaziv());
	}
	
	@Test
	void testSetNazivNull() {
		assertThrows(java.lang.NullPointerException.class, () -> k.setNaziv(null));
	}

	@Test
	void testSetNazivPrazno() {
		assertThrows(java.lang.IllegalArgumentException.class, () -> k.setNaziv(""));
	}
	
	@Test
	void testSetOpis() {
		k.setOpis("Ukusan kolac");
		assertEquals("Ukusan kolac", k.getOpis());
	}
	
	@Test
	void testSetOpisNull() {
		assertThrows(java.lang.NullPointerException.class, () -> k.setOpis(null));
	}

	@Test
	void testSetOpisPrazno() {
		assertThrows(java.lang.IllegalArgumentException.class, () -> k.setOpis(""));
	}
	
	@Test
	void testSetCena() {
		k.setCena(450.0);
		assertEquals(450.0, k.getCena());
	}

	@Test
	void testSetCenaNula() {
		assertThrows(java.lang.IllegalArgumentException.class, () -> k.setCena(0));
	}
	
	@Test
	void testSetCenaNegativna() {
		assertThrows(java.lang.IllegalArgumentException.class, () -> k.setCena(-100.0));
	}
	
	@Test
	void testToString() {
		k = new Kolac(1l, "Brauni", 370.0, "Ukusan kolac");
		//assertEquals("Brauni", k.toString());
		assertTrue(k.toString().contains("Brauni"));
	}
	
}
