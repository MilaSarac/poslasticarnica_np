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

class SOIzmeniKolacTest {

    private SOIzmeniKolac operacija;
    private Kolac testKolac;
    private final String nazivTestKolaca = "JUnit Test Kolac";

    @BeforeEach
    void setUp() throws Exception {

        operacija = new SOIzmeniKolac();

        Kolac kolac = new Kolac(
                null,
                nazivTestKolaca,
                500,
                "Pocetni opis"
        );

        DBBroker.getInstance().dodaj(kolac);
        DBBroker.getInstance().getConnection().commit();

        Kolac kriterijum = new Kolac();
        kriterijum.setNaziv(nazivTestKolaca);

        ArrayList<ApstraktniDomenskiObjekat> lista =
                DBBroker.getInstance().vrati(kriterijum);

        testKolac = (Kolac) lista.get(0);
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
        testKolac = null;
    }

    @Test
    void testIzmeniKolac() throws Exception {

        testKolac.setCena(600);
        testKolac.setOpis("Izmenjen opis");

        operacija.izvrsi(testKolac);

        Kolac kriterijum = new Kolac();
        kriterijum.setNaziv(nazivTestKolaca);

        ArrayList<ApstraktniDomenskiObjekat> lista =
                DBBroker.getInstance().vrati(kriterijum);

        Kolac izmenjeniKolac = (Kolac) lista.get(0);

        assertEquals(600, izmenjeniKolac.getCena());
        assertEquals("Izmenjen opis", izmenjeniKolac.getOpis());
    }

    @Test
    void testPogresanTipObjekta() {

        assertThrows(Exception.class, () -> {
            operacija.izvrsi(new Kupac());
        });
    }

    @Test
    void testKolacNijeIzabran() {

        Kolac kolac = new Kolac(
                null,
                "Neki kolac",
                500,
                "Opis"
        );

        assertThrows(Exception.class, () -> {
            operacija.izvrsi(kolac);
        });
    }

}