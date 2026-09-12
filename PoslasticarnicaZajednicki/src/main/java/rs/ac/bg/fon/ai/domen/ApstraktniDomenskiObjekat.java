package rs.ac.bg.fon.ai.domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Apstraktna klasa koja predstavlja baznu klasu za domenske objekte u aplikaciji.
 * 
 * Definise apstraktne metode koje domenske klase treba da implementiraju kako bi omogucile
 * genericki rad sa bazom podataka, odnosno formrianje SQL upita i ucitavanje
 * podataka iz baze u domenske objekte.
 * 
 * Implementira interfejs Serializable, cime je omogucena serijalizacija 
 * i deserijalizacija domenskih objekata.
 * 
 * @author Mila
 */
public abstract class ApstraktniDomenskiObjekat implements Serializable {

    /**
     * Vraca naziv tabele u bazi podataka koja odgovara domenskom objektu.
     * 
     * @return naziv tabele kao String vrednost
     */
    public abstract String nazivTabele();

    /**
     * Vraca alijas tabele koji se koristi prilikom formiranja SQL upita.
     * 
     * @return alijas tabele kao String vrednost
     */
    public abstract String alijas();

    /**
     * Vraca SQL JOIN deo upita koji se koristi za povezivanje sa drugim tabelama,
     * ukoliko je povezivanje potrebno.
     * 
     * @return JOIN deo SQL upita kao String vrednost
     */
    public abstract String join();

    /**
     * Kreira listu domenskih objekata na osnovu podataka dobijenih iz baze podataka.
     * Prolazi kroz redove ResultSet objekta i na osnovu njihovih vrednosti
     * kreira odgovarajuce domenske objekte.
     * 
     * @param rs ResultSet objekat koji sadrzi podatke dobijene iz baze podataka
     * @return lista domenskih objekata kreiranih na osnovu podataka iz baze
     * @throws SQLException ukoliko dodje do greske prilikom citanja podataka iz baze
     */
    public abstract ArrayList<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs)
            throws SQLException;

    /**
     * Vraca nazive kolona za INSERT SQL naredbu, koje se koriste prilikom dodavanja novog objekta
     * u odgovarajucu tabelu baze podataka.
     * 
     * @return nazivi kolona za INSERT naredbu kao String vrednost
     */
    public abstract String koloneZaDodaj();

    /**
     * Vraca vrednosti atributa domenskog objekta za INSERT SQL naredbu, koje se koriste prilikom
     * dodavanja novog reda u bazu podataka.
     * 
     * @return vrednosti atributa za INSERT naredbu kao String vrednost
     */
    public abstract String vrednostiZaDodaj();

    /**
     * Vraca vrednosti atributa domenskog objekta za UPDATE SQL naredbu, koje se koriste prilikom
     * izmene postojeceg reda u bazi podataka.
     * 
     * @return vrednosti atributa za UPDATE naredbu kao String vrednost
     */
    public abstract String vrednostiZaPromeni();

    /**
     * Vraca WHERE uslov koji se koristi za identifikovanje odgovarajuceg reda
     * u bazi podataka.
     * 
     * @return WHERE uslov kao String vrednost
     */
    public abstract String uslov();

    /**
     * Vraca uslov koji se koristi prilikom pretrage i vracanja podataka
     * iz baze podataka.
     * 
     * @return uslov za pretragu kao String vrednost
     */
    public abstract String uslovZaVrati();
}
