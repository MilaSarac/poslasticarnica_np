package rs.ac.bg.fon.ai.transfer;

import java.io.Serializable;

/**
 * Klasa koja predstavlja zahtev koji klijent salje serveru.
 * 
 * Sadrzi informaciju o operaciji koju je potrebno izvrsiti i objekat
 * koji predstavlja podatke zahteva.
 * 
 * Implementira interfejs Serializable, cime je omogucena serijalizacija
 * objekata ove klase prilikom komunikacije izmedju klijenta i servera.
 * 
 * @author Mila
 */
public class KlijentskiZahtev implements Serializable {

    /**
     * Operacija koju je potrebno izvrsiti.
     */
    private int operacija;

    /**
     * Objekat koji sadrzi podatke zahteva.
     */
    private Object zahtev;

    /**
     * Kreira novi prazan objekat klase KlijentskiZahtev.
     */
    public KlijentskiZahtev() {
    }

    /**
     * Kreira novi objekat klase KlijentskiZahtev sa zadatom operacijom
     * i objektom zahteva.
     * 
     * @param operacija Operacija koju je potrebno izvrsiti
     * @param zahtev Objekat koji sadrzi podatke zahteva
     */
    public KlijentskiZahtev(int operacija, Object zahtev) {
        this.operacija = operacija;
        this.zahtev = zahtev;
    }

    /**
     * Vraca operaciju koju je potrebno izvrsiti.
     * 
     * @return operacija kao int vrednost
     */
    public int getOperacija() {
        return operacija;
    }

    /**
     * Postavlja operaciju koju je potrebno izvrsiti.
     * 
     * @param operacija Nova vrednost operacije
     */
    public void setOperacija(int operacija) {
        this.operacija = operacija;
    }

    /**
     * Vraca objekat koji sadrzi podatke zahteva.
     * 
     * @return objekat zahteva
     */
    public Object getZahtev() {
        return zahtev;
    }

    /**
     * Postavlja objekat koji sadrzi podatke zahteva.
     * 
     * @param zahtev Novi objekat zahteva
     */
    public void setZahtev(Object zahtev) {
        this.zahtev = zahtev;
    }
}
