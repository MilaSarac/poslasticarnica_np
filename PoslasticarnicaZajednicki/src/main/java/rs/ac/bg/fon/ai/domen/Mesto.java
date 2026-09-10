package rs.ac.bg.fon.ai.domen;

/**
 * Klasa koja predstavlja mesto u sistemu poslasticarnice.
 * 
 * Mesto ima svoj jedinstveni identifikator koji ga jedinstveno identifikuje
 * i naziv.
 * 
 * @author Mila
 */
public class Mesto {

	/**
     * ID mesta kao Long vrednost.
     */
	private Long idMesto;
	/**
     * Naziv mesta kao String vrednost.
     */
    private String naziv;
    
    /**
     * Konstruktor koji inicijalizuje objekat klase Mesto.
     */
    public Mesto() {
		
	}
    
    /**
     * Konstruktor koji inicijalizuje objekat klase Mesto i postavlja
     * prosledjene vrednosti njegovim atributima.
     * 
     * @param idMesto ID mesta kao Long vrednost.
     * @param naziv Naziv mesta kao String vrednost.
     */
	public Mesto(Long idMesto, String naziv) {
		this.idMesto = idMesto;
		setNaziv(naziv);
	}

	 /**
     * Vraca ID mesta.
     * 
     * @return ID mesta kao Long.
     */
	public Long getIdMesto() {
		return idMesto;
	}
	
	/**
     * Postavlja vrednost atributa idMesto na novu unetu vrednost.
     * 
     * @param idMesto ID mesta kao Long.
     */
	public void setIdMesto(Long idMesto) {
		this.idMesto = idMesto;
	}
	
	 /**
     * Vraca naziv mesta.
     * 
     * @return naziv mesta kao String.
     */
	public String getNaziv() {
		return naziv;
	}
	
	/**
     * Postavlja vrednost atributa naziv na novu unetu vrednost.
     * 
     * Uneti naziv ne sme biti null niti prazan.
     * 
     * @param naziv Naziv mesta kao String.
     * @throws java.lang.NullPointerException Ako je uneti naziv null
     * @throws java.lang.IllegalArgumentException Ako je uneti naziv prazan
     */
	public void setNaziv(String naziv) {
		if (naziv == null) {
	        throw new NullPointerException("Naziv ne sme biti null!");
	    }

	    if (naziv.isEmpty()) {
	        throw new IllegalArgumentException("Naziv ne sme biti prazan!");
	    }

	    this.naziv = naziv;
	}

	 /**
     * Vraca String koji predstavlja naziv mesta.
     * 
     * @return naziv mesta kao String.
     */
	@Override
	public String toString() {
		return naziv;
	}
    
    
}
