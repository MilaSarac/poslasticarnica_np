package rs.ac.bg.fon.ai.transfer.util;

/**
 * Interfejs koji definise konstante koje predstavljaju operacije sistema.
 * 
 * Konstante se koriste za identifikovanje operacija prilikom komunikacije
 * izmedju klijenta i servera.
 * 
 * @author Mila
 */
public interface Operacije {

    /**
     * Konstanta koja predstavlja operaciju prijavljivanja korisnika na sistem.
     */
    public static final int LOGIN = 0;
    /**
     * Konstanta koja predstavlja operaciju vracanja svih kolaca iz sistema.
     */
    public static final int VRATI_SVE_KOLACE = 1;
    /**
     * Konstanta koja predstavlja operaciju dodavanja kolaca u sistem.
     */
    public static final int DODAJ_KOLAC = 2;
}