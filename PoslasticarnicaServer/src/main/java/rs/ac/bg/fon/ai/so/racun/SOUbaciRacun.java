package rs.ac.bg.fon.ai.so.racun;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import rs.ac.bg.fon.ai.baza.DBBroker;
import rs.ac.bg.fon.ai.domen.ApstraktniDomenskiObjekat;
import rs.ac.bg.fon.ai.domen.Racun;
import rs.ac.bg.fon.ai.domen.StavkaRacuna;
import rs.ac.bg.fon.ai.sistemskaOperacija.ApstraktnaSistemskaOperacija;

/**
 * Sistemska operacija koja dodaje novi racun zajedno sa njegovim stavkama
 * u bazu podataka.
 *
 * Operacija proverava ispravnost racuna i njegovih stavki, zatim dodaje
 * racun u bazu podataka, preuzima njegov generisani identifikator i nakon
 * toga dodaje sve stavke koje pripadaju tom racunu.
 *
 * @author Mila
 */
public class SOUbaciRacun extends ApstraktnaSistemskaOperacija {

    /**
     * Proverava ispravnost racuna pre njegovog dodavanja u bazu podataka.
     *
     * Proverava da li je prosledjeni objekat instanca klase Racun, da li
     * racun ima datum izdavanja, kupca, poslasticara i najmanje jednu stavku.
     * Takodje proverava ispravnost podataka svake stavke, cenu kolaca,
     * iznos stavke i da li je ukupan iznos racuna jednak zbiru iznosa
     * svih stavki racuna.
     *
     * @param ado domenski objekat koji se validira
     * @throws Exception ako prosledjeni objekat nije instanca klase Racun
     * ili podaci racuna i njegovih stavki nisu ispravni
     */
    @Override
    protected void validacija(ApstraktniDomenskiObjekat ado) throws Exception {

        if (!(ado instanceof Racun)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Racun!");
        }

        Racun racun = (Racun) ado;

        if (racun.getDatumIzdavanja() == null) {
            throw new Exception("Racun mora imati datum izdavanja!");
        }

        if (racun.getUkupanIznos() <= 0) {
            throw new Exception("Ukupan iznos racuna mora biti veci od 0!");
        }

        if (racun.getPoslasticar() == null) {
            throw new Exception("Racun mora imati poslasticara!");
        }

        if (racun.getKupac() == null) {
            throw new Exception("Racun mora imati kupca!");
        }

        if (racun.getStavkeRacuna() == null || racun.getStavkeRacuna().isEmpty()) {
            throw new Exception("Racun mora imati barem jednu stavku!");
        }

        double zbirStavki = 0;

        for (StavkaRacuna stavka : racun.getStavkeRacuna()) {

            if (stavka.getRb() <= 0) {
                throw new Exception("Redni broj stavke mora biti veci od 0!");
            }

            if (stavka.getCena() <= 0) {
                throw new Exception("Cena stavke mora biti veca od 0!");
            }

            if (stavka.getKolicina() <= 0) {
                throw new Exception("Kolicina mora biti veca od 0!");
            }

            if (stavka.getIznos() <= 0) {
                throw new Exception("Iznos stavke mora biti veci od 0!");
            }

            if (stavka.getKolac() == null) {
                throw new Exception("Stavka racuna mora imati kolac!");
            }

            if (Math.abs(stavka.getCena() - stavka.getKolac().getCena()) > 0.001) {
                throw new Exception("Cena stavke mora biti jednaka ceni kolaca!");
            }

            double ocekivaniIznos = stavka.getCena() * stavka.getKolicina();

            if (Math.abs(stavka.getIznos() - ocekivaniIznos) > 0.001) {
                throw new Exception("Iznos stavke mora biti jednak proizvodu cene i kolicine!");
            }

            zbirStavki += stavka.getIznos();
        }

        if (Math.abs(racun.getUkupanIznos() - zbirStavki) > 0.001) {
            throw new Exception("Ukupan iznos racuna mora biti jednak zbiru iznosa svih stavki!");
        }
    }

    /**
     * Dodaje racun i njegove stavke u bazu podataka.
     *
     * Najpre se dodaje racun i preuzima njegov generisani identifikator.
     * Dobijeni identifikator se postavlja novom racunu. Nakon toga se
     * svakoj stavci postavlja novokreirani racun i sve stavke se
     * pojedinacno dodaju u bazu podataka.
     *
     * @param ado objekat klase Racun koji se dodaje u bazu podataka
     * @throws Exception ako dodje do greske prilikom dodavanja racuna
     * ili njegovih stavki u bazu podataka
     */
    @Override
    protected void izvrsenje(ApstraktniDomenskiObjekat ado) throws Exception {

        PreparedStatement ps = DBBroker.getInstance().dodaj(ado);

        ResultSet tableKeys = ps.getGeneratedKeys();

        if (!tableKeys.next()) {
            throw new Exception( "Nije moguce preuzeti identifikator novog racuna!");
        }

        Long noviIdRacun = tableKeys.getLong(1);

        Racun noviRacun = (Racun) ado;
        noviRacun.setIdRacun(noviIdRacun);

        for (StavkaRacuna stavka : noviRacun.getStavkeRacuna()) {
            stavka.setRacun(noviRacun);
            DBBroker.getInstance().dodaj(stavka);
        }

        tableKeys.close();
        ps.close();
    }
}