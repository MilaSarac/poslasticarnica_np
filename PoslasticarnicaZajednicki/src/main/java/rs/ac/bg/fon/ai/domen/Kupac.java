package rs.ac.bg.fon.ai.domen;

import java.util.Objects;

public class Kupac {

	private Long idKupac;
    private String ime;
    private String prezime;
    private String brojtelefona;
    private String email;
    private Mesto mesto;
    
    public Kupac() {

	}
    
	public Kupac(Long idKupac, String ime, String prezime, String brojtelefona, String email, Mesto mesto) {
		super();
		this.idKupac = idKupac;
		this.ime = ime;
		this.prezime = prezime;
		this.brojtelefona = brojtelefona;
		this.email = email;
		this.mesto = mesto;
	}

	public Long getIdKupac() {
		return idKupac;
	}

	public void setIdKupac(Long idKupac) {
		this.idKupac = idKupac;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getBrojtelefona() {
		return brojtelefona;
	}

	public void setBrojtelefona(String brojtelefona) {
		this.brojtelefona = brojtelefona;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Mesto getMesto() {
		return mesto;
	}

	public void setMesto(Mesto mesto) {
		this.mesto = mesto;
	}

	@Override
	public String toString() {
		return ime + " " + prezime;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idKupac);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Kupac other = (Kupac) obj;
		return Objects.equals(idKupac, other.idKupac);
	}
    
	
    
}
