package rs.ac.bg.fon.ai.domen;

import java.util.Date;

/**
 * Klasa koja predstavlja angazovanje poslasticara u odredjenoj smeni
 * odredjenog datuma.
 * 
 * PoslasticarSmena sadrzi poslasticara, smenu u kojoj poslasticar radi
 * i datum za koji je smena odredjena.
 * 
 * @author Mila
 */
public class PoslasticarSmena {

	/**
	 * Poslasticar kao objekat klase Poslasticar.
	 */
	private Poslasticar poslasticar;

	/**
	 * Smena poslasticara kao objekat klase Smena.
	 */
    private Smena smena;

    /**
	 * Datum smene poslasticara kao Date vrednost.
	 */
    private Date datum;

    /**
     * Konstruktor koji inicijalizuje objekat klase PoslasticarSmena.
     */
    public PoslasticarSmena() {
    }

    /**
     * Konstruktor koji inicijalizuje objekat klase PoslasticarSmena i postavlja
     * prosledjene vrednosti njegovim atributima.
     * 
     * @param poslasticar Poslasticar kao objekat klase Poslasticar.
     * @param smena Smena poslasticara kao objekat klase Smena.
     * @param datum Datum smene poslasticara kao Date vrednost.
     */
    public PoslasticarSmena(Poslasticar poslasticar, Smena smena, Date datum) {
    	setPoslasticar(poslasticar);
        setSmena(smena);
        setDatum(datum);
    }

    /**
     * Vraca poslasticara.
     * 
     * @return poslasticar kao objekat klase Poslasticar.
     */
    public Poslasticar getPoslasticar() {
        return poslasticar;
    }

    /**
     * Postavlja vrednost atributa poslasticar na novu unetu vrednost.
     * 
     * @param poslasticar Poslasticar kao objekat klase Poslasticar.
     */
    public void setPoslasticar(Poslasticar poslasticar) {
        this.poslasticar = poslasticar;
    }

    /**
     * Vraca smenu poslasticara.
     * 
     * @return smena poslasticara kao objekat klase Smena.
     */
    public Smena getSmena() {
        return smena;
    }

    /**
     * Postavlja vrednost atributa smena na novu unetu vrednost.
     * 
     * @param smena Smena poslasticara kao objekat klase Smena.
     */
    public void setSmena(Smena smena) {
        this.smena = smena;
    }

    /**
     * Vraca datum smene poslasticara.
     * 
     * @return datum smene poslasticara kao Date.
     */
    public Date getDatum() {
        return datum;
    }

    /**
     * Postavlja vrednost atributa datum na novu unetu vrednost.
     * 
     * @param datum Datum smene poslasticara kao Date vrednost.
     * @throws java.lang.NullPointerException Ako je uneti datum null
     */
    public void setDatum(Date datum) {
    	if (datum == null) {
            throw new NullPointerException("Datum ne sme biti null!");
        }

        this.datum = datum;
    }
}