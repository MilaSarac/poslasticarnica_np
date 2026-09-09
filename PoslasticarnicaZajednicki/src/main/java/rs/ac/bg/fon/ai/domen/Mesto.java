package rs.ac.bg.fon.ai.domen;

public class Mesto {

	private Long idMesto;
    private String naziv;
    
    public Mesto() {
		
	}
    
	public Mesto(Long idMesto, String naziv) {
		super();
		this.idMesto = idMesto;
		this.naziv = naziv;
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
		this.naziv = naziv;
	}

	@Override
	public String toString() {
		return naziv;
	}
    
    
}
