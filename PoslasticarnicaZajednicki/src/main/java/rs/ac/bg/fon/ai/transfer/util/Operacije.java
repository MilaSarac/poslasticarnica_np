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
    /**
     * Konstanta koja predstavlja operaciju izmene kolaca u sistemu.
     */
    public static final int IZMENI_KOLAC = 3;
    /**
     * Konstanta koja predstavlja operaciju brisanja kolaca iz sistema.
     */
    public static final int OBRISI_KOLAC = 4;
    /**
     * Konstanta koja predstavlja operaciju pretrage kolaca.
     */
    public static final int PRETRAZI_KOLACE = 5;
    /**
     * Konstanta koja predstavlja operaciju za vracanje svih kupaca iz baze podataka.
     */
    public static final int VRATI_SVE_KUPCE = 6;
    /**
     * Konstanta koja predstavlja operaciju za dodavanje novog kupca u bazu podataka.
     */
    public static final int DODAJ_KUPCA = 7;
    /**
     * Konstanta koja predstavlja operaciju za promenu podataka o kupcu.
     */
    public static final int PROMENI_KUPCA = 8;
    /**
     * Konstanta koja predstavlja operaciju za brisanje kupca iz baze podataka.
     */
    public static final int OBRISI_KUPCA = 9;
    /**
     * Konstanta koja predstavlja operaciju za pretragu kupaca.
     */
    public static final int PRETRAZI_KUPCE = 10;
    /**
     * Konstanta koja predstavlja operaciju za vracanje svih mesta.
     */
    public static final int VRATI_SVA_MESTA = 11;
}