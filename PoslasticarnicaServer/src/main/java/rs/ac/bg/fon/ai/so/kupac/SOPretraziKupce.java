package rs.ac.bg.fon.ai.so.kupac;

import java.util.ArrayList;

import rs.ac.bg.fon.ai.baza.DBBroker;
import rs.ac.bg.fon.ai.domen.ApstraktniDomenskiObjekat;
import rs.ac.bg.fon.ai.domen.Kupac;
import rs.ac.bg.fon.ai.sistemskaOperacija.ApstraktnaSistemskaOperacija;

/**
 * Sistemska operacija koja pretrazuje kupce prema zadatim kriterijumima.
 *
 * @author Mila
 */
public class SOPretraziKupce extends ApstraktnaSistemskaOperacija {

    private ArrayList<Kupac> lista;

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
     * Pretrazuje kupce u bazi prema prosledjenim kriterijumima.
     *
     * @param ado objekat klase Kupac koji sadrzi kriterijume pretrage
     * @throws Exception ako dodje do greske prilikom rada sa bazom
     */
    @Override
    protected void izvrsenje(ApstraktniDomenskiObjekat ado) throws Exception {
        ArrayList<ApstraktniDomenskiObjekat> kupci =
                DBBroker.getInstance().vrati(ado);

        lista = (ArrayList<Kupac>) (ArrayList<?>) kupci;
    }

    public ArrayList<Kupac> getLista() {
        return lista;
    }
}