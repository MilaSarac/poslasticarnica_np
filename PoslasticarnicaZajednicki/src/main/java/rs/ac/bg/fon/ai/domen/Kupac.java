package rs.ac.bg.fon.ai.domen;

import java.util.Objects;

public class Kupac {

	private Long idKupac;
    private String ime;
    private String prezime;
    private String brojTelefona;
    private String email;
    private Mesto mesto;
    
    public Kupac() {

	}
    
	public Kupac(Long idKupac, String ime, String prezime, String brojTelefona, String email, Mesto mesto) {
		this.idKupac = idKupac;
	    setIme(ime);
	    setPrezime(prezime);
	    setBrojTelefona(brojTelefona);
	    setEmail(email);
	    setMesto(mesto);
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
		if (ime == null) {
	        throw new NullPointerException("Ime ne sme biti null!");
	    }
	    if (ime.isEmpty()) {
	        throw new IllegalArgumentException("Ime ne sme biti prazno!");
	    }
	    this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		if (prezime == null) {
	        throw new NullPointerException("Prezime ne sme biti null!");
	    }
	    if (prezime.isEmpty()) {
	        throw new IllegalArgumentException("Prezime ne sme biti prazno!");
	    }
	    this.prezime = prezime;
	}

	public String getBrojTelefona() {
		return brojTelefona;
	}

	public void setBrojTelefona(String brojTelefona) {
		if (brojTelefona == null) {
	        throw new NullPointerException("Broj telefona ne sme biti null!");
	    }
	    if (brojTelefona.isEmpty()) {
	        throw new IllegalArgumentException("Broj telefona ne sme biti prazan!");
	    }
	    this.brojTelefona = brojTelefona;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (email == null) {
	        throw new NullPointerException("Email ne sme biti null!");
	    }
	    if (email.isEmpty()) {
	        throw new IllegalArgumentException("Email ne sme biti prazan!");
	    }
	    if (!email.contains("@")) {
	        throw new IllegalArgumentException("Email nije u odgovarajucem formatu!");
	    }
	    this.email = email;
	}

	public Mesto getMesto() {
		return mesto;
	}

	public void setMesto(Mesto mesto) {
		if (mesto == null) {
	        throw new NullPointerException("Mesto ne sme biti null!");
	    }
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
