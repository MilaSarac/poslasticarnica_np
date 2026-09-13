package rs.ac.bg.fon.ai.so.kupac;

import rs.ac.bg.fon.ai.baza.DBBroker;
import rs.ac.bg.fon.ai.domen.ApstraktniDomenskiObjekat;
import rs.ac.bg.fon.ai.domen.Kupac;
import rs.ac.bg.fon.ai.sistemskaOperacija.ApstraktnaSistemskaOperacija;

/**
 * Sistemska operacija koja brise kupca iz baze podataka.
 *
 * Operacija proverava da li je prosledjeni objekat instanca klase Kupac,
 * a zatim ga brise iz baze podataka.
 *
 * @author Mila
 */
public class SOObrisiKupca extends ApstraktnaSistemskaOperacija {

    /**
     * Proverava da li je prosledjeni objekat instanca klase Kupac.
     *
     * @param ado domenski objekat koji se validira
     * @throws Exception ako prosledjeni objekat nije instanca klase Kupac
     */
    @Override
    protected void validacija(ApstraktniDomenskiObjekat ado) throws Exception {
        if (!(ado instanceof Kupac)) {
            throw new Exception("Prosleđeni objekat nije instanca klase Kupac!");
        }
    }

    /**
     * Brise prosledjenog kupca iz baze podataka.
     *
     * @param ado objekat klase Kupac koji se brise
     * @throws Exception ako dodje do greske prilikom rada sa bazom podataka
     */
    @Override
    protected void izvrsenje(ApstraktniDomenskiObjekat ado) throws Exception {
        DBBroker.getInstance().izbrisi(ado);
    }
}