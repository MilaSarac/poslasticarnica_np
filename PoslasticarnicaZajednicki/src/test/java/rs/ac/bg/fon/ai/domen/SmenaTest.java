package rs.ac.bg.fon.ai.domen;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SmenaTest {

    private Smena s;

    @BeforeEach
    void setUp() throws Exception {
        s = new Smena();
    }

    @AfterEach
    void tearDown() throws Exception {
        s = null;
    }

    @Test
    void testSmena() {
        assertNotNull(s);
    }

    @Test
    void testSmenaLongStringDateDate() {
        Date vremePocetka = new Date();
        Date vremeZavrsetka = new Date();

        s = new Smena(
                1L,
                "Prva smena",
                vremePocetka,
                vremeZavrsetka
        );

        assertNotNull(s);
        assertEquals(1L, s.getIdSmena());
        assertEquals("Prva smena", s.getNaziv());
        assertEquals(vremePocetka, s.getVremePocetka());
        assertEquals(vremeZavrsetka, s.getVremeZavrsetka());
    }

    @Test
    void testSetNaziv() {
        s.setNaziv("Prva smena");

        assertEquals("Prva smena", s.getNaziv());
    }

    @Test
    void testSetNazivNull() {
        assertThrows(
        		java.lang.NullPointerException.class,
                () -> s.setNaziv(null)
        );
    }

    @Test
    void testSetNazivPrazno() {
        assertThrows(
        		java.lang.IllegalArgumentException.class,
                () -> s.setNaziv("")
        );
    }

    @Test
    void testSetVremePocetka() {
        Date vremePocetka = new Date();

        s.setVremePocetka(vremePocetka);

        assertEquals(vremePocetka, s.getVremePocetka());
    }

    @Test
    void testSetVremePocetkaNull() {
        assertThrows(
        		java.lang.NullPointerException.class,
                () -> s.setVremePocetka(null)
        );
    }

    @Test
    void testSetVremeZavrsetka() {
        Date vremeZavrsetka = new Date();

        s.setVremeZavrsetka(vremeZavrsetka);

        assertEquals(vremeZavrsetka, s.getVremeZavrsetka());
    }

    @Test
    void testSetVremeZavrsetkaNull() {
        assertThrows(
        		java.lang.NullPointerException.class,
                () -> s.setVremeZavrsetka(null)
        );
    }

    @Test
    void testToString() {
        s.setNaziv("Prva smena");

        assertEquals("Prva smena", s.toString());
    }
}