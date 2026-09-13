package rs.ac.bg.fon.ai.so.kolac;

import rs.ac.bg.fon.ai.baza.DBBroker;
import rs.ac.bg.fon.ai.domen.ApstraktniDomenskiObjekat;
import rs.ac.bg.fon.ai.domen.Kolac;
import rs.ac.bg.fon.ai.sistemskaOperacija.ApstraktnaSistemskaOperacija;

public class SOObrisiKolac extends ApstraktnaSistemskaOperacija {

    @Override
    protected void validacija(ApstraktniDomenskiObjekat ado) throws Exception {
        if (!(ado instanceof Kolac)) {
            throw new Exception("Prosleđeni objekat nije instanca klase Kolac!");
        }
    }

    @Override
    protected void izvrsenje(ApstraktniDomenskiObjekat ado) throws Exception {
        DBBroker.getInstance().izbrisi(ado);
    }
}