package rs.ac.bg.fon.ai.so.kupac;

import java.util.ArrayList;
import java.util.regex.Pattern;

import rs.ac.bg.fon.ai.baza.DBBroker;
import rs.ac.bg.fon.ai.domen.ApstraktniDomenskiObjekat;
import rs.ac.bg.fon.ai.domen.Kupac;
import rs.ac.bg.fon.ai.sistemskaOperacija.ApstraktnaSistemskaOperacija;

/**
 * Sistemska operacija koja dodaje novog kupca u bazu podataka.
 * 
 * Operacija proverava da li je prosledjeni objekat instanca klase Kupac,
 * validira format email adrese i broja telefona i proverava da li kupac
 * sa istim emailom ili brojem telefona vec postoji u bazi.
 * 
 * @author Mila
 */
public class SODodajKupca extends ApstraktnaSistemskaOperacija {

    /**
     * Obrazac za proveru formata email adrese.
     */
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    /**
     * Obrazac za proveru formata broja telefona.
     */
    private static final Pattern TELEFON_PATTERN =
            Pattern.compile("^06[0-9]{8}$");

    /**
     * Proverava ispravnost prosledjenog objekta, format email adrese i
     * broja telefona, kao i postojanje kupca sa istim emailom ili telefonom.
     * 
     * @param ado domenski objekat koji se validira
     * @throws Exception ako objekat nije instanca klase Kupac, ako email ili
     * broj telefona nisu u ispravnom formatu ili ako kupac vec postoji
     */
    @Override
    protected void validacija(ApstraktniDomenskiObjekat ado) throws Exception {

        if (!(ado instanceof Kupac)) {
            throw new Exception("Prosleđeni objekat nije instanca klase Kupac!");
        }

        Kupac kupac = (Kupac) ado;

        if (!EMAIL_PATTERN.matcher(kupac.getEmail()).matches()) {
            throw new Exception("Email nije u ispravnom formatu!");
        }

        if (!TELEFON_PATTERN.matcher(kupac.getBrojTelefona()).matches()) {
            throw new Exception("Telefon mora biti u formatu 06XXXXXXXX!");
        }

        Kupac kriterijumEmail = new Kupac();
        kriterijumEmail.setEmail(kupac.getEmail());

        ArrayList<Kupac> kupciPoEmailu =
                (ArrayList<Kupac>) (ArrayList<?>) DBBroker.getInstance().vrati(kriterijumEmail);

        if (!kupciPoEmailu.isEmpty()) {
            throw new Exception("Kupac sa tim emailom već postoji!");
        }

        Kupac kriterijumTelefon = new Kupac();
        kriterijumTelefon.setBrojTelefona(kupac.getBrojTelefona());

        ArrayList<Kupac> kupciPoTelefonu =
                (ArrayList<Kupac>) (ArrayList<?>) DBBroker.getInstance().vrati(kriterijumTelefon);

        if (!kupciPoTelefonu.isEmpty()) {
            throw new Exception("Kupac sa tim brojem telefona već postoji!");
        }
    }

    /**
     * Dodaje prosledjenog kupca u bazu podataka.
     * 
     * @param ado objekat klase Kupac koji se dodaje u bazu
     * @throws Exception ako dodje do greske prilikom rada sa bazom podataka
     */
    @Override
    protected void izvrsenje(ApstraktniDomenskiObjekat ado) throws Exception {
        DBBroker.getInstance().dodaj(ado);
    }
}