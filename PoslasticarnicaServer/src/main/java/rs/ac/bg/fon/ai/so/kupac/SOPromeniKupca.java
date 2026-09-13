package rs.ac.bg.fon.ai.so.kupac;

import java.util.ArrayList;
import java.util.regex.Pattern;

import rs.ac.bg.fon.ai.baza.DBBroker;
import rs.ac.bg.fon.ai.domen.ApstraktniDomenskiObjekat;
import rs.ac.bg.fon.ai.domen.Kupac;
import rs.ac.bg.fon.ai.sistemskaOperacija.ApstraktnaSistemskaOperacija;

/**
 * Sistemska operacija koja menja podatke o kupcu.
 *
 * Operacija proverava da li je prosledjeni objekat instanca klase Kupac,
 * validira format email adrese i broja telefona i proverava da li drugi kupac
 * vec koristi isti email ili broj telefona.
 *
 * @author Mila
 */
public class SOPromeniKupca extends ApstraktnaSistemskaOperacija{
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
     * Proverava ispravnost kupca pre izmene.
     *
     * Proverava tip objekta, postojanje identifikatora, format email adrese
     * i broja telefona, kao i da li kupac postoji u bazi. Ukoliko su email
     * adresa ili broj telefona promenjeni, proverava se da li ih vec koristi
     * neki drugi kupac.
     *
     * @param ado domenski objekat koji se validira
     * @throws Exception ako objekat nije instanca klase Kupac, kupac nema
     * identifikator, ne postoji u bazi, podaci nisu ispravnog formata ili
     * drugi kupac vec koristi isti email ili broj telefona
     */
    @Override
    protected void validacija(ApstraktniDomenskiObjekat ado) throws Exception {

        if (!(ado instanceof Kupac)) {
            throw new Exception(
                    "Prosledjeni objekat nije instanca klase Kupac!"
            );
        }

        Kupac kupac = (Kupac) ado;

        if (kupac.getIdKupac() == null) {
            throw new Exception(
                    "Kupac mora imati identifikator!"
            );
        }

        if (!EMAIL_PATTERN.matcher(kupac.getEmail()).matches()) {
            throw new Exception(
                    "Email nije u ispravnom formatu!"
            );
        }

        if (!TELEFON_PATTERN.matcher(
                kupac.getBrojTelefona()).matches()) {

            throw new Exception(
                    "Telefon mora biti u formatu 06XXXXXXXX!"
            );
        }

        /*
         * Pronalazimo trenutno stanje kupca u bazi.
         */
        Kupac kriterijumId = new Kupac();
        kriterijumId.setIdKupac(kupac.getIdKupac());

        ArrayList<Kupac> pronadjeniKupci =
                (ArrayList<Kupac>) (ArrayList<?>)
                DBBroker.getInstance().vrati(kriterijumId);

        if (pronadjeniKupci.isEmpty()) {
            throw new Exception(
                    "Kupac ne postoji u bazi!"
            );
        }

        Kupac postojeciKupac =
                pronadjeniKupci.get(0);

        /*
         * Email proveravamo samo ako je promenjen.
         */
        if (!postojeciKupac.getEmail()
                .equals(kupac.getEmail())) {

            Kupac kriterijumEmail =
                    new Kupac();

            kriterijumEmail.setEmail(
                    kupac.getEmail()
            );

            ArrayList<Kupac> kupciPoEmailu =
                    (ArrayList<Kupac>) (ArrayList<?>)
                    DBBroker.getInstance()
                            .vrati(kriterijumEmail);

            for (Kupac k : kupciPoEmailu) {

                if (!k.getIdKupac()
                        .equals(kupac.getIdKupac())) {

                    throw new Exception(
                            "Kupac sa tim emailom vec postoji!"
                    );
                }
            }
        }

        /*
         * Telefon proveravamo samo ako je promenjen.
         */
        if (!postojeciKupac.getBrojTelefona()
                .equals(kupac.getBrojTelefona())) {

            Kupac kriterijumTelefon =
                    new Kupac();

            kriterijumTelefon.setBrojTelefona(
                    kupac.getBrojTelefona()
            );

            ArrayList<Kupac> kupciPoTelefonu =
                    (ArrayList<Kupac>) (ArrayList<?>)
                    DBBroker.getInstance()
                            .vrati(kriterijumTelefon);

            for (Kupac k : kupciPoTelefonu) {

                if (!k.getIdKupac()
                        .equals(kupac.getIdKupac())) {

                    throw new Exception(
                            "Kupac sa tim brojem telefona vec postoji!"
                    );
                }
            }
        }
    }

    /**
     * Menja podatke o kupcu u bazi podataka.
     *
     * @param ado objekat klase Kupac koji se menja
     * @throws Exception ako dodje do greske prilikom rada sa bazom podataka
     */
    @Override
    protected void izvrsenje(ApstraktniDomenskiObjekat ado) throws Exception {
        DBBroker.getInstance().izmeni(ado);
    }
}
