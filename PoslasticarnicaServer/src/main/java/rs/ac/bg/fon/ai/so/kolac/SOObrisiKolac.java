package rs.ac.bg.fon.ai.so.kolac;

import rs.ac.bg.fon.ai.baza.DBBroker;
import rs.ac.bg.fon.ai.domen.ApstraktniDomenskiObjekat;
import rs.ac.bg.fon.ai.domen.Kolac;
import rs.ac.bg.fon.ai.sistemskaOperacija.ApstraktnaSistemskaOperacija;

/**
 * Sistemska operacija koja omogucava brisanje kolaca iz sistema.
 *
 * Pre brisanja proverava se da li je prosledjeni objekat
 * instanca klase Kolac.
 *
 * @author Mila
 */
public class SOObrisiKolac extends ApstraktnaSistemskaOperacija {

	/**
     * Proverava da li je prosledjeni domenski objekat
     * instanca klase Kolac.
     *
     * @param ado domenski objekat koji se validira
     * @throws Exception ako prosledjeni objekat nije instanca klase Kolac
     */
    @Override
    protected void validacija(ApstraktniDomenskiObjekat ado) throws Exception {
        if (!(ado instanceof Kolac)) {
            throw new Exception("Prosleđeni objekat nije instanca klase Kolac!");
        }
    }

    /**
     * Brise prosledjeni kolac iz baze podataka.
     *
     * @param ado kolac koji se brise iz baze podataka
     * @throws Exception ako dodje do greske prilikom brisanja kolaca
     */
    @Override
    protected void izvrsenje(ApstraktniDomenskiObjekat ado) throws Exception {
        DBBroker.getInstance().izbrisi(ado);
    }
}