package rs.ac.bg.fon.ai.so.login;

import java.util.ArrayList;

import rs.ac.bg.fon.ai.baza.DBBroker;
import rs.ac.bg.fon.ai.domen.ApstraktniDomenskiObjekat;
import rs.ac.bg.fon.ai.domen.Poslasticar;
import rs.ac.bg.fon.ai.kontroler.ServerKontroler;
import rs.ac.bg.fon.ai.sistemskaOperacija.ApstraktnaSistemskaOperacija;

/**
 * Sistemska operacija koja omogucava prijavljivanje poslasticara na sistem.
 *
 * Operacija proverava da li je prosledjen odgovarajuci domenski objekat,
 * da li je poslasticar vec prijavljen na sistem i da li postoje ispravni
 * podaci za prijavljivanje u bazi podataka.
 *
 * @author Mila
 */
public class SOLogin extends ApstraktnaSistemskaOperacija{

	/**
     * Poslasticar koji je uspesno prijavljen na sistem.
     */
    private Poslasticar ulogovani;

    /**
     * Proverava da li je prosledjeni objekat instanca klase Poslasticar
     * i da li je poslasticar vec prijavljen na sistem.
     *
     * @param ado domenski objekat koji se validira
     * @throws Exception ako prosledjeni objekat nije instanca klase Poslasticar ili ako je poslasticar vec prijavljen na sistem
     */
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

    /**
     * Vrsi prijavljivanje poslasticara na sistem.
     *
     * Iz baze podataka se ucitavaju poslasticari, nakon cega se proveravaju
     * korisnicko ime i sifra. Ako su podaci ispravni, poslasticar se cuva
     * kao ulogovani korisnik i dodaje u listu ulogovanih poslasticara.
     *
     * @param ado poslasticar sa unetim korisnickim imenom i sifrom
     * @throws Exception ako korisnicko ime i sifra nisu ispravni
     */
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

    /**
     * Vraca poslasticara koji je uspesno prijavljen na sistem.
     *
     * @return ulogovani poslasticar
     */
    public Poslasticar getUlogovani() {
        return ulogovani;
    }
}
