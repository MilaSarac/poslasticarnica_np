package rs.ac.bg.fon.ai.transfer;

import java.io.Serializable;

import rs.ac.bg.fon.ai.transfer.util.RezultatOp;

/**
 * Klasa koja predstavlja odgovor koji server salje klijentu.
 * 
 * Sadrzi objekat odgovora, eventualni izuzetak koji je nastao prilikom
 * izvrsavanja operacije i rezultat izvrsene operacije.
 * 
 * Implementira interfejs Serializable, cime je omogucena serijalizacija
 * objekata ove klase prilikom komunikacije izmedju servera i klijenta.
 * 
 * @author Mila
 */
public class ServerskiOdgovor implements Serializable {

    /**
     * Objekat koji sadrzi podatke odgovora servera.
     */
    private Object odgovor;

    /**
     * Izuzetak koji je nastao prilikom izvrsavanja operacije, ukoliko postoji.
     */
    private Exception exc;

    /**
     * Rezultat izvrsene operacije.
     */
    private RezultatOp rezultat;

    /**
     * Kreira novi prazan objekat klase ServerskiOdgovor.
     */
    public ServerskiOdgovor() {
    }

    /**
     * Kreira novi objekat klase ServerskiOdgovor sa zadatim odgovorom,
     * izuzetkom i rezultatom operacije.
     * 
     * @param odgovor Objekat koji sadrzi podatke odgovora servera
     * @param exc Izuzetak koji je nastao prilikom izvrsavanja operacije
     * @param rezultat Rezultat izvrsene operacije
     */
    public ServerskiOdgovor(Object odgovor, Exception exc, RezultatOp rezultat) {
        this.odgovor = odgovor;
        this.exc = exc;
        this.rezultat = rezultat;
    }

    /**
     * Vraca objekat koji sadrzi podatke odgovora servera.
     * 
     * @return objekat odgovora
     */
    public Object getOdgovor() {
        return odgovor;
    }

    /**
     * Postavlja objekat koji sadrzi podatke odgovora servera.
     * 
     * @param odgovor Novi objekat odgovora
     */
    public void setOdgovor(Object odgovor) {
        this.odgovor = odgovor;
    }

    /**
     * Vraca izuzetak koji je nastao prilikom izvrsavanja operacije.
     * 
     * @return izuzetak, odnosno null ukoliko izuzetak nije nastao
     */
    public Exception getExc() {
        return exc;
    }

    /**
     * Postavlja izuzetak koji je nastao prilikom izvrsavanja operacije.
     * 
     * @param exc Novi izuzetak
     */
    public void setExc(Exception exc) {
        this.exc = exc;
    }

    /**
     * Vraca rezultat izvrsene operacije.
     * 
     * @return rezultat operacije
     */
    public RezultatOp getRezultat() {
        return rezultat;
    }

    /**
     * Postavlja rezultat izvrsene operacije.
     * 
     * @param rezultat Novi rezultat operacije
     */
    public void setRezultat(RezultatOp rezultat) {
        this.rezultat = rezultat;
    }
}
