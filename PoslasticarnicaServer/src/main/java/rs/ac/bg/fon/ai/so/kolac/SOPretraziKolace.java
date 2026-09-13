package rs.ac.bg.fon.ai.so.kolac;

import java.util.ArrayList;

import rs.ac.bg.fon.ai.baza.DBBroker;
import rs.ac.bg.fon.ai.domen.ApstraktniDomenskiObjekat;
import rs.ac.bg.fon.ai.domen.Kolac;
import rs.ac.bg.fon.ai.sistemskaOperacija.ApstraktnaSistemskaOperacija;

/**
 * Sistemska operacija koja omogucava pretragu kolaca.
 *
 * Pretraga se vrsi na osnovu kriterijuma prosledjenih kroz objekat
 * klase Kolac, a rezultat operacije predstavlja lista kolaca koji
 * zadovoljavaju zadati kriterijum.
 *
 * @author Mila
 */
public class SOPretraziKolace extends ApstraktnaSistemskaOperacija {

	/**
     * Lista kolaca koji zadovoljavaju zadati kriterijum pretrage.
     */
    private ArrayList<Kolac> lista;

    /**
     * Proverava da li je prosledjeni domenski objekat instanca klase Kolac.
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
     * Pretrazuje kolace u bazi podataka na osnovu prosledjenog kriterijuma
     * i rezultat pretrage smesta u listu.
     *
     * @param ado kolac koji sadrzi kriterijum pretrage
     * @throws Exception ako dodje do greske prilikom pretrage kolaca
     */
    @Override
    protected void izvrsenje(ApstraktniDomenskiObjekat ado) throws Exception {

        ArrayList<ApstraktniDomenskiObjekat> kolaci = DBBroker.getInstance().vrati(ado);
        lista = (ArrayList<Kolac>) (ArrayList<?>) kolaci;
    }
    
    /**
     * Vraca listu kolaca koji zadovoljavaju kriterijum pretrage.
     *
     * @return lista pronadjenih kolaca
     */
    public ArrayList<Kolac> getLista() {
        return lista;
    }
}
