package rs.ac.bg.fon.ai.so.kupac;

import java.util.ArrayList;

import rs.ac.bg.fon.ai.baza.DBBroker;
import rs.ac.bg.fon.ai.domen.ApstraktniDomenskiObjekat;
import rs.ac.bg.fon.ai.domen.Kupac;
import rs.ac.bg.fon.ai.sistemskaOperacija.ApstraktnaSistemskaOperacija;

/**
 * Sistemska operacija koja vraca sve kupce iz baze podataka.
 * 
 * Operacija proverava da li je prosledjeni objekat instanca klase Kupac,
 * a zatim iz baze ucitava listu kupaca.
 * 
 * @author Mila
 */
public class SOVratiSveKupce extends ApstraktnaSistemskaOperacija {

    /**
     * Lista kupaca ucitanih iz baze podataka.
     */
    private ArrayList<Kupac> lista;

    /**
     * Proverava da li je prosledjeni objekat instanca klase Kupac.
     *
     * @param ado prosledjeni domenski objekat
     * @throws Exception ako prosledjeni objekat nije instanca klase Kupac
     */
    @Override
    protected void validacija(ApstraktniDomenskiObjekat ado) throws Exception {
        if (!(ado instanceof Kupac)) {
            throw new Exception("Prosleđeni objekat nije instanca klase Kupac!");
        }
    }

    /**
     * Ucitava kupce iz baze podataka.
     *
     * @param ado objekat klase Kupac koji predstavlja kriterijum pretrage
     * @throws Exception ako dodje do greske prilikom rada sa bazom
     */
    @Override
    protected void izvrsenje(ApstraktniDomenskiObjekat ado) throws Exception {

        ArrayList<ApstraktniDomenskiObjekat> kupci = DBBroker.getInstance().vrati(ado);

        lista = (ArrayList<Kupac>) (ArrayList<?>) kupci;
    }

    /**
     * Vraca listu kupaca.
     *
     * @return lista kupaca
     */
    public ArrayList<Kupac> getLista() {
        return lista;
    }
}