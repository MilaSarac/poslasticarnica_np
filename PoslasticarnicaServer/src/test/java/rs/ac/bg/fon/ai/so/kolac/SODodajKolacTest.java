package rs.ac.bg.fon.ai.so.kolac;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import rs.ac.bg.fon.ai.baza.DBBroker;
import rs.ac.bg.fon.ai.domen.ApstraktniDomenskiObjekat;
import rs.ac.bg.fon.ai.domen.Kolac;
import rs.ac.bg.fon.ai.domen.Kupac;

class SODodajKolacTest {

    private SODodajKolac operacija;
    private final String nazivTestKolaca = "Test kolac";

    @BeforeEach
    void setUp() {
        operacija = new SODodajKolac();
    }

    @AfterEach
    void tearDown() throws Exception {

        Kolac kriterijum = new Kolac();
        kriterijum.setNaziv(nazivTestKolaca);

        ArrayList<ApstraktniDomenskiObjekat> lista =
                DBBroker.getInstance().vrati(kriterijum);

        for (ApstraktniDomenskiObjekat ado : lista) {

            Kolac kolac = (Kolac) ado;

            if (kolac.getNaziv().equals(nazivTestKolaca)) {
                DBBroker.getInstance().izbrisi(kolac);
            }
        }

        DBBroker.getInstance().getConnection().commit();

        operacija = null;
    }

    @Test
    void testDodajKolac() {

        Kolac kolac = new Kolac(
                null,
                nazivTestKolaca,
                500,
                "Opis test kolaca"
        );

        assertDoesNotThrow(() -> {
            operacija.izvrsi(kolac);
        });
    }

    @Test
    void testPogresanTipObjekta() {

        assertThrows(Exception.class, () -> {
            operacija.izvrsi(new Kupac());
        });
    }

    @Test
    void testPrazanNaziv() {

        Kolac kolac = new Kolac();

        assertThrows(Exception.class, () -> {
            operacija.izvrsi(kolac);
        });
    }

    @Test
    void testCenaNula() {

        Kolac kolac = new Kolac();
        kolac.setNaziv(nazivTestKolaca);
        kolac.setOpis("Opis");

        assertThrows(Exception.class, () -> {
            operacija.izvrsi(kolac);
        });
    }

    @Test
    void testPrazanOpis() {

        Kolac kolac = new Kolac();
        kolac.setNaziv(nazivTestKolaca);
        kolac.setCena(500);

        assertThrows(Exception.class, () -> {
            operacija.izvrsi(kolac);
        });
    }
}