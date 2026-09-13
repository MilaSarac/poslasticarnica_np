package rs.ac.bg.fon.ai.so.kolac;

import java.util.ArrayList;

import rs.ac.bg.fon.ai.baza.DBBroker;
import rs.ac.bg.fon.ai.domen.ApstraktniDomenskiObjekat;
import rs.ac.bg.fon.ai.domen.Kolac;
import rs.ac.bg.fon.ai.sistemskaOperacija.ApstraktnaSistemskaOperacija;


/**
 * Sistemska operacija koja omogucava dodavanje novog kolaca u sistem.
 *
 * Pre dodavanja kolaca vrsi se validacija njegovih podataka i provera
 * da li kolac sa istim nazivom vec postoji u bazi podataka.
 *
 * @author Mila
 */
public class SODodajKolac extends ApstraktnaSistemskaOperacija {

	/**
     * Proverava ispravnost podataka kolaca koji se dodaje.
     *
     * Proverava da li je prosledjeni objekat instanca klase Kolac,
     * da li su naziv i opis uneti, da li je cena veca od nule i
     * da li kolac sa istim nazivom vec postoji u bazi podataka.
     *
     * @param ado domenski objekat koji se validira
     * @throws Exception ako prosledjeni objekat nije instanca klase Kolac, 
     * podaci kolaca nisu ispravni ili kolac sa istim nazivom vec postoji
     */
    @Override
    protected void validacija(ApstraktniDomenskiObjekat ado) throws Exception {
        if (!(ado instanceof Kolac)) {
            throw new Exception("Prosleđeni objekat nije instanca klase Kolac!");
        }

        Kolac kolac = (Kolac) ado;

        if (kolac.getNaziv() == null || kolac.getNaziv().isEmpty()) {
            throw new Exception("Naziv kolača ne sme biti prazan!");
        }

        if (kolac.getCena() <= 0) {
            throw new Exception("Cena kolača mora biti veća od nula!");
        }

        if (kolac.getOpis() == null || kolac.getOpis().isEmpty()) {
            throw new Exception("Opis kolača ne sme biti prazan!");
        }
        
        Kolac kriterijum = new Kolac();
        kriterijum.setNaziv(kolac.getNaziv());

        ArrayList<Kolac> kolaci = (ArrayList<Kolac>) (ArrayList<?>) DBBroker.getInstance().vrati(kriterijum);

        if (!kolaci.isEmpty()) {
            throw new Exception(
                    "Kolač sa tim nazivom već postoji!");
        }
    }

    /**
     * Dodaje kolac u bazu podataka.
     *
     * @param ado kolac koji se dodaje u bazu podataka
     * @throws Exception ako dodje do greske prilikom dodavanja kolaca
     */
    @Override
    protected void izvrsenje(ApstraktniDomenskiObjekat ado) throws Exception {
        DBBroker.getInstance().dodaj(ado);
    }
}