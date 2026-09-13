package rs.ac.bg.fon.ai.sistemskaOperacija;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import rs.ac.bg.fon.ai.domen.Kolac;
import rs.ac.bg.fon.ai.domen.Kupac;
import rs.ac.bg.fon.ai.so.kolac.SOVratiSveKolace;

class ApstraktnaSistemskaOperacijaTest {

    @Test
    void testIzvrsiUspesno() throws Exception {

        ApstraktnaSistemskaOperacija operacija = new SOVratiSveKolace();

        assertDoesNotThrow(() -> {operacija.izvrsi(new Kolac());});
    }

    @Test
    void testIzvrsiNeuspesno() {

        ApstraktnaSistemskaOperacija operacija = new SOVratiSveKolace();

        assertThrows(Exception.class, () -> {operacija.izvrsi(new Kupac());});
    }
}
