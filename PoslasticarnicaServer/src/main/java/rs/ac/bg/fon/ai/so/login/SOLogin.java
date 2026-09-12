package rs.ac.bg.fon.ai.so.login;

import java.util.ArrayList;

import rs.ac.bg.fon.ai.baza.DBBroker;
import rs.ac.bg.fon.ai.domen.ApstraktniDomenskiObjekat;
import rs.ac.bg.fon.ai.domen.Poslasticar;
import rs.ac.bg.fon.ai.kontroler.ServerKontroler;
import rs.ac.bg.fon.ai.sistemskaOperacija.ApstraktnaSistemskaOperacija;

public class SOLogin extends ApstraktnaSistemskaOperacija{

    private Poslasticar ulogovani;

    @Override
    protected void validacija(ApstraktniDomenskiObjekat ado) throws Exception {
        if (!(ado instanceof Poslasticar)) {
            throw new Exception("Prosleđeni objekat nije instanca klase Poslasticar!");
        }
        Poslasticar p = (Poslasticar) ado;
        for (Poslasticar p2 : ServerKontroler.getInstance().getUlogovaniPoslasticari()) {
            if (p2.getKorisnickoIme().equals(p.getKorisnickoIme())) {
                throw new Exception("Ovaj poslastičar je već ulogovan na sistem!");
            }
        }
    }

    @Override
    protected void izvrsenje(ApstraktniDomenskiObjekat ado) throws Exception {
        Poslasticar p = (Poslasticar) ado;

        ArrayList<Poslasticar> listaPoslasticara =
                (ArrayList<Poslasticar>) (ArrayList<?>) DBBroker.getInstance().vrati(ado);

        for (Poslasticar p2 : listaPoslasticara) {
            if (p2.getKorisnickoIme().equals(p.getKorisnickoIme())
                    && p2.getSifra().equals(p.getSifra())) {
                ulogovani = p2;
                ServerKontroler.getInstance().getUlogovaniPoslasticari().add(ulogovani);
                return;
            }
        }

        throw new Exception("Korisničko ime i šifra nisu ispravni.");
    }

    public Poslasticar getUlogovani() {
        return ulogovani;
    }
}
