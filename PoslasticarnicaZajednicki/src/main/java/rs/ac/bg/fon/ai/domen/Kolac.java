package rs.ac.bg.fon.ai.domen;

/**
 * Klasa koja predstavlja kolac u poslasticarnici.
 * 
 * Kolac ima svoj jedinstveni identifikator koji ga jedinstveno identifikuje,
 * naziv, cenu i opis.
 * 
 * @author Mila
 */
public class Kolac {

	 /**
     * ID kolaca kao Long vrednost.
     */
	private Long idKolac;
	/**
     * Naziv kolaca kao String vrednost.
     */
    private String naziv;
    /**
     * Cena kolaca kao double vrednost.
     */
    private double cena;
    /**
     * Opis kolaca kao String vrednost.
     */
    private String opis;

    /**
     * Konstruktor koji inicijalizuje objekat klase Kolac sa 
     * atributima koji imaju default vrednosti.
     */
    public Kolac() {
    }

    /**
     * Konstruktor koji inicijalizuje instancu kolaca i postavlja
     * prosledjene vrednosti njegovim atributima.
     * 
     * @param idKolac ID kolaca koji se unosi u objekat.
     * @param naziv Naziv kolaca koji se unosi u objekat.
     * @param cena Cena kolaca koja se unosi u objekat.
     * @param opis Opis kolaca koji se unosi u objekat.
     */
    public Kolac(Long idKolac, String naziv, double cena, String opis) {
        this.idKolac = idKolac;
        setNaziv(naziv);
        setCena(cena);
        setOpis(opis);
    }

    /**
     * Vraca String koji predstavlja naziv kolaca.
     * 
     * @return Naziv kolaca kao String.
     */
    @Override
    public String toString() {
        return naziv;
    }

    /**
     * Vraca ID kolaca.
     * 
     * @return ID kolaca kao Long.
     */
    public Long getIdKolac() {
        return idKolac;
    }

    /**
     * Postavlja vrednost atributa idKolac na novu unetu vrednost.
     * 
     * @param idKolac ID kolaca kao Long.
     */
    public void setIdKolac(Long idKolac) {
        this.idKolac = idKolac;
    }

    /**
     * Vraca naziv kolaca.
     * 
     * @return naziv kolaca kao String.
     */
    public String getNaziv() {
        return naziv;
    }

    /**
     * Postavlja vrednost atributa naziv na novu unetu vrednost.
     * 
     * Uneti naziv ne sme biti null niti prazan.
     * 
     * @param naziv Naziv kolaca kao String.
     * @throws java.lang.NullPointerException Ako je uneti naziv null
     * @throws java.lang.IllegalArgumentException Ako je uneti naziv prazan
     */
    public void setNaziv(String naziv) {
    	if(naziv==null) {
    		throw new NullPointerException("Naziv ne sme biti null!");
    	}
    	
    	if(naziv.isEmpty()) {
    		throw new IllegalArgumentException("Naziv ne sme biti prazan!");
    	}
    	
        this.naziv = naziv;
    }

    /**
     * Vraca cenu kolaca.
     * 
     * @return cena kolaca kao double.
     */
    public double getCena() {
        return cena;
    }

    /**
     * Postavlja vrednost atributa cena na novu unetu vrednost.
     * 
     * @param cena cena kolaca kao double.
     * @throws java.lang.IllegalArgumentException ako je uneta cena manja
     *         ili jednaka nuli
     */
    public void setCena(double cena) {
    	if (cena<=0) {
            throw new IllegalArgumentException("Cena mora biti veca od nula!");
        }
    	
        this.cena = cena;
    }

    /**
     * Vraca opis kolaca.
     * 
     * @return opis kolaca kao String.
     */
    public String getOpis() {
        return opis;
    }

    /**
     * Postavlja vrednost atributa opis na novu unetu vrednost.
     * 
     * @param opis Opis kolaca kao String.
     * @throws java.lang.NullPointerException Ako je uneti opis null
     * @throws java.lang.IllegalArgumentException Ako je uneti opis prazan
     */
    public void setOpis(String opis) {
    	if(opis==null) {
    		throw new NullPointerException("Opis ne sme biti null!");
    	}
    	
    	if(opis.isEmpty()) {
    		throw new IllegalArgumentException("Opis ne sme biti prazan!");
    	}
    	
        this.opis = opis;
    }
}
