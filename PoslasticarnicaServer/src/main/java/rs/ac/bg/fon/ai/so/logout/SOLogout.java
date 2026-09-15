package rs.ac.bg.fon.ai.so.logout;

import rs.ac.bg.fon.ai.domen.ApstraktniDomenskiObjekat;
import rs.ac.bg.fon.ai.domen.Poslasticar;
import rs.ac.bg.fon.ai.kontroler.ServerKontroler;
import rs.ac.bg.fon.ai.sistemskaOperacija.ApstraktnaSistemskaOperacija;

/**
 * Sistemska operacija koja odjavljuje poslasticara sa sistema.
 *
 * Operacija proverava da li je prosledjeni objekat instanca klase
 * Poslasticar i uklanja prijavljenog poslasticara iz liste trenutno
 * ulogovanih poslasticara.
 *
 * @author Mila
 */
public class SOLogout extends ApstraktnaSistemskaOperacija {

    /**
     * Proverava da li je prosledjeni objekat instanca klase Poslasticar.
     *
     * @param ado domenski objekat koji se validira
     * @throws Exception ako prosledjeni objekat nije instanca klase Poslasticar
     */
    @Override
    protected void validacija(ApstraktniDomenskiObjekat ado) throws Exception {

        if (!(ado instanceof Poslasticar)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Poslasticar!");
        }
    }

    /**
     * Odjavljuje poslasticara sa sistema uklanjanjem iz liste trenutno
     * ulogovanih poslasticara.
     *
     * @param ado poslasticar koji se odjavljuje sa sistema
     * @throws Exception ako poslasticar nije prijavljen na sistem
     */
    @Override
    protected void izvrsenje(ApstraktniDomenskiObjekat ado) throws Exception {

        Poslasticar poslasticar = (Poslasticar) ado;

        boolean uklonjen = ServerKontroler.getInstance().getUlogovaniPoslasticari().remove(poslasticar);

        if (!uklonjen) {
            throw new Exception("Poslasticar nije prijavljen na sistem!");
        }
    }
}