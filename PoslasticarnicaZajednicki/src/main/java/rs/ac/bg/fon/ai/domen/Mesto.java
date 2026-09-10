package rs.ac.bg.fon.ai.domen;

public class Mesto {

	private Long idMesto;
    private String naziv;
    
    public Mesto() {
		
	}
    
	public Mesto(Long idMesto, String naziv) {
		this.idMesto = idMesto;
		setNaziv(naziv);
	}

	public Long getIdMesto() {
		return idMesto;
	}
	public void setIdMesto(Long idMesto) {
		this.idMesto = idMesto;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		if (naziv == null) {
	        throw new IllegalArgumentException("Naziv ne sme biti null!");
	    }

	    if (naziv.isEmpty()) {
	        throw new IllegalArgumentException("Naziv ne sme biti prazan!");
	    }

	    this.naziv = naziv;
	}

	@Override
	public String toString() {
		return naziv;
	}
    
    
}
