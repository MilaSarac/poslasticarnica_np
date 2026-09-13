package rs.ac.bg.fon.ai.so.kolac;

import java.util.ArrayList;

import rs.ac.bg.fon.ai.baza.DBBroker;
import rs.ac.bg.fon.ai.domen.ApstraktniDomenskiObjekat;
import rs.ac.bg.fon.ai.domen.Kolac;
import rs.ac.bg.fon.ai.sistemskaOperacija.ApstraktnaSistemskaOperacija;

/**
 * Sistemska operacija koja vraca sve kolace iz baze podataka.
 * 
 * @author Mila
 */
public class SOVratiSveKolace extends ApstraktnaSistemskaOperacija {

	/**
     * Lista kolaca pronadjenih u bazi podataka.
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
     * Vraca sve kolace iz baze podataka i smesta ih u listu.
     *
     * @param ado domenski objekat na osnovu kog se vrse pretraga i vracanje podataka
     * @throws Exception ako dodje do greske prilikom izvrsavanja operacije
     */
    @Override
    protected void izvrsenje(ApstraktniDomenskiObjekat ado) throws Exception {
    	ArrayList<ApstraktniDomenskiObjekat> kolaci = DBBroker.getInstance().vrati(ado);
        lista = (ArrayList<Kolac>) (ArrayList<?>) kolaci;
    }

    /**
     * Vraca listu kolaca.
     *
     * @return lista kolaca
     */
    public ArrayList<Kolac> getLista() {
        return lista;
    }
}
