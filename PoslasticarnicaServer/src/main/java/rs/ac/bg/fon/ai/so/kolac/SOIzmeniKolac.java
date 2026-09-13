package rs.ac.bg.fon.ai.so.kolac;

import rs.ac.bg.fon.ai.baza.DBBroker;
import rs.ac.bg.fon.ai.domen.ApstraktniDomenskiObjekat;
import rs.ac.bg.fon.ai.domen.Kolac;
import rs.ac.bg.fon.ai.sistemskaOperacija.ApstraktnaSistemskaOperacija;

public class SOIzmeniKolac extends ApstraktnaSistemskaOperacija {

    @Override
    protected void validacija(ApstraktniDomenskiObjekat ado) throws Exception {
        if (!(ado instanceof Kolac)) {
            throw new Exception("Prosleđeni objekat nije instanca klase Kolac!");
        }

        Kolac kolac = (Kolac) ado;

        if (kolac.getIdKolac() == null) {
            throw new Exception("Kolač nije izabran!");
        }

        if (kolac.getCena() <= 0) {
            throw new Exception("Cena kolača mora biti veća od 0!");
        }

        if (kolac.getOpis() == null || kolac.getOpis().isEmpty()) {
            throw new Exception("Opis kolača ne sme biti prazan!");
        }
    }

    @Override
    protected void izvrsenje(ApstraktniDomenskiObjekat ado) throws Exception {
        DBBroker.getInstance().izmeni(ado);
    }
}
