package rs.ac.bg.fon.ai.domen;

import java.util.Date;

/**
 * Klasa koja predstavlja smenu u poslasticarnici.
 * 
 * Smena ima svoj jedinstveni identifikator koji je jedinstveno identifikuje,
 * naziv, vreme pocetka i vreme zavrsetka.
 * 
 * @author Mila
 */
public class Smena {

	/**
	 * ID smene kao Long vrednost.
	 */
	private Long idSmena;

	/**
	 * Naziv smene kao String vrednost.
	 */
    private String naziv;

    /**
	 * Vreme pocetka smene kao Date vrednost.
	 */
    private Date vremePocetka;

    /**
	 * Vreme zavrsetka smene kao Date vrednost.
	 */
    private Date vremeZavrsetka;

    /**
     * Konstruktor koji inicijalizuje objekat klase Smena.
     */
    public Smena() {
    }

    /**
     * Konstruktor koji inicijalizuje objekat klase Smena i postavlja
     * prosledjene vrednosti njenim atributima.
     * 
     * @param idSmena ID smene kao Long vrednost.
     * @param naziv Naziv smene kao String vrednost.
     * @param vremePocetka Vreme pocetka smene kao Date vrednost.
     * @param vremeZavrsetka Vreme zavrsetka smene kao Date vrednost.
     */
    public Smena(Long idSmena, String naziv, Date vremePocetka, Date vremeZavrsetka) {
    	this.idSmena = idSmena;
        setNaziv(naziv);
        setVremePocetka(vremePocetka);
        setVremeZavrsetka(vremeZavrsetka);
    }

    /**
     * Vraca String koji predstavlja naziv smene.
     * 
     * @return naziv smene kao String.
     */
    @Override
    public String toString() {
        return naziv;
    }

    /**
     * Vraca ID smene.
     * 
     * @return ID smene kao Long.
     */
    public Long getIdSmena() {
        return idSmena;
    }

    /**
     * Postavlja vrednost atributa idSmena na novu unetu vrednost.
     * 
     * @param idSmena ID smene kao Long.
     */
    public void setIdSmena(Long idSmena) {
        this.idSmena = idSmena;
    }

    /**
     * Vraca naziv smene.
     * 
     * @return naziv smene kao String.
     */
    public String getNaziv() {
        return naziv;
    }

    /**
     * Postavlja vrednost atributa naziv na novu unetu vrednost.
     * 
     * @param naziv Naziv smene kao String.
     * @throws java.lang.NullPointerException Ako je uneti naziv smene null
     * @throws java.lang.IllegalArgumentException Ako je uneti naziv smene prazan
     */
    public void setNaziv(String naziv) {
    	if (naziv == null) {
            throw new NullPointerException("Naziv smene ne sme biti null!");
        }

        if (naziv.isEmpty()) {
            throw new IllegalArgumentException("Naziv smene ne sme biti prazan!");
        }

        this.naziv = naziv;
    }

    /**
     * Vraca vreme pocetka smene.
     * 
     * @return vreme pocetka smene kao Date.
     */
    public Date getVremePocetka() {
        return vremePocetka;
    }

    /**
     * Postavlja vrednost atributa vremePocetka na novu unetu vrednost.
     * 
     * @param vremePocetka Vreme pocetka smene kao Date vrednost.
     * @throws java.lang.NullPointerException Ako je uneto vreme pocetka null
     */
    public void setVremePocetka(Date vremePocetka) {
    	if (vremePocetka == null) {
            throw new NullPointerException("Vreme pocetka ne sme biti null!");
        }
        this.vremePocetka = vremePocetka;
    }

    /**
     * Vraca vreme zavrsetka smene.
     * 
     * @return vreme zavrsetka smene kao Date.
     */
    public Date getVremeZavrsetka() {
        return vremeZavrsetka;
    }

    /**
     * Postavlja vrednost atributa vremeZavrsetka na novu unetu vrednost.
     * 
     * @param vremeZavrsetka Vreme zavrsetka smene kao Date vrednost.
     * @throws java.lang.NullPointerException Ako je uneto vreme zavrsetka null
     */
    public void setVremeZavrsetka(Date vremeZavrsetka) {
    	if (vremeZavrsetka == null) {
            throw new NullPointerException("Vreme zavrsetka ne sme biti null!");
        }
        this.vremeZavrsetka = vremeZavrsetka;
    }
}