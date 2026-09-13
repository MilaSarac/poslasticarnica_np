package rs.ac.bg.fon.ai.so.mesto;

import java.util.ArrayList;

import rs.ac.bg.fon.ai.baza.DBBroker;
import rs.ac.bg.fon.ai.domen.ApstraktniDomenskiObjekat;
import rs.ac.bg.fon.ai.domen.Mesto;
import rs.ac.bg.fon.ai.sistemskaOperacija.ApstraktnaSistemskaOperacija;

/**
 * Sistemska operacija koja vraca sva mesta iz baze podataka.
 *
 * @author Mila
 */
public class SOVratiSvaMesta extends ApstraktnaSistemskaOperacija {

    private ArrayList<Mesto> lista;

    @Override
    protected void validacija(ApstraktniDomenskiObjekat ado) throws Exception {
        if (!(ado instanceof Mesto)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Mesto!");
        }
    }

    @Override
    protected void izvrsenje(ApstraktniDomenskiObjekat ado) throws Exception {

        ArrayList<ApstraktniDomenskiObjekat> mesta =
                DBBroker.getInstance().vrati(ado);

        lista = (ArrayList<Mesto>) (ArrayList<?>) mesta;
    }

    public ArrayList<Mesto> getLista() {
        return lista;
    }
}