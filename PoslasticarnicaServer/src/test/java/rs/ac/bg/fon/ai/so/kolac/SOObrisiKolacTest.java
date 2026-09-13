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

class SOObrisiKolacTest {

    private SOObrisiKolac operacija;
    private Kolac testKolac;

    @BeforeEach
    void setUp() throws Exception {

        operacija = new SOObrisiKolac();

        Kolac kolac = new Kolac(
                null,
                "JUnit Test Kolac Za Brisanje",
                500,
                "Test opis"
        );

        DBBroker.getInstance().dodaj(kolac);
        DBBroker.getInstance().getConnection().commit();

        Kolac kriterijum = new Kolac();
        kriterijum.setNaziv("JUnit Test Kolac Za Brisanje");

        ArrayList<ApstraktniDomenskiObjekat> lista =
                DBBroker.getInstance().vrati(kriterijum);

        testKolac = (Kolac) lista.get(0);
    }
    
    @AfterEach
    void tearDown() throws Exception {

        Kolac kriterijum = new Kolac();
        kriterijum.setNaziv("JUnit Test Kolac Za Brisanje");

        ArrayList<ApstraktniDomenskiObjekat> lista =
                DBBroker.getInstance().vrati(kriterijum);

        for (ApstraktniDomenskiObjekat ado : lista) {
            Kolac kolac = (Kolac) ado;

            if (kolac.getNaziv().equals("JUnit Test Kolac Za Brisanje")) {
                DBBroker.getInstance().izbrisi(kolac);
            }
        }

        DBBroker.getInstance().getConnection().commit();

        operacija = null;
        testKolac = null;
    }

    @Test
    void testObrisiKolac() throws Exception {

        operacija.izvrsi(testKolac);

        Kolac kriterijum = new Kolac();
        kriterijum.setNaziv("JUnit Test Kolac Za Brisanje");

        ArrayList<ApstraktniDomenskiObjekat> lista =
                DBBroker.getInstance().vrati(kriterijum);

        assertTrue(lista.isEmpty());
    }

    @Test
    void testPogresanTipObjekta() {

        assertThrows(Exception.class, () -> {
            operacija.izvrsi(new Kupac());
        });
    }
}