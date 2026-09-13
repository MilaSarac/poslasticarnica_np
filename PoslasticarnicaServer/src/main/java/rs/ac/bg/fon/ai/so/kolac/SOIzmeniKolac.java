package rs.ac.bg.fon.ai.so.kolac;

import rs.ac.bg.fon.ai.baza.DBBroker;
import rs.ac.bg.fon.ai.domen.ApstraktniDomenskiObjekat;
import rs.ac.bg.fon.ai.domen.Kolac;
import rs.ac.bg.fon.ai.sistemskaOperacija.ApstraktnaSistemskaOperacija;

/**
 * Sistemska operacija koja omogucava izmenu postojeceg kolaca u sistemu.
 *
 * Pre izmene kolaca vrsi se validacija prosledjenog objekta i podataka
 * koji se menjaju.
 *
 * @author Mila
 */
public class SOIzmeniKolac extends ApstraktnaSistemskaOperacija {

	/**
     * Proverava ispravnost podataka kolaca koji se menja.
     *
     * Proverava da li je prosledjeni objekat instanca klase Kolac,
     * da li je kolac izabran, da li je cena veca od nule i da li je
     * opis kolaca unet.
     *
     * @param ado domenski objekat koji se validira
     * @throws Exception ako prosledjeni objekat nije instanca klase Kolac,
     * kolac nije izabran ili podaci kolaca nisu ispravni
     */
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

    /**
     * Menja podatke postojeceg kolaca u bazi podataka.
     *
     * @param ado kolac ciji se podaci menjaju
     * @throws Exception ako dodje do greske prilikom izmene kolaca
     */
    @Override
    protected void izvrsenje(ApstraktniDomenskiObjekat ado) throws Exception {
        DBBroker.getInstance().izmeni(ado);
    }
}
