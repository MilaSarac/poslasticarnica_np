package rs.ac.bg.fon.ai.domen;

import java.util.Date;
import java.util.Objects;

public class Poslasticar {

	private Long idPoslasticar;
    private String ime;
    private String prezime;
    private String korisnickoIme;
    private String sifra;
    private Date datumZaposlenja;

	public Poslasticar() {
		
	}
	
	public Poslasticar(Long idPoslasticar, String ime, String prezime, String korisnickoIme, String sifra, Date datumZaposlenja) {
		this.idPoslasticar = idPoslasticar;
	    setIme(ime);
	    setPrezime(prezime);
	    setKorisnickoIme(korisnickoIme);
	    setSifra(sifra);
	    setDatumZaposlenja(datumZaposlenja);
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }
    
    public Long getIdPoslasticar() {
        return idPoslasticar;
    }

    public void setIdPoslasticar(Long idPoslasticar) {
        this.idPoslasticar = idPoslasticar;
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

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
    	if (korisnickoIme == null) {
            throw new NullPointerException("Korisnicko ime ne sme biti null!");
        }
        if (korisnickoIme.isEmpty()) {
            throw new IllegalArgumentException("Korisnicko ime ne sme biti prazno!");
        }
        this.korisnickoIme = korisnickoIme;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
    	if (sifra == null) {
            throw new NullPointerException("Sifra ne sme biti null!");
        }
        if (sifra.isEmpty()) {
            throw new IllegalArgumentException("Sifra ne sme biti prazna!");
        }
        this.sifra = sifra;
    }

    public Date getDatumZaposlenja() {
        return datumZaposlenja;
    }

    public void setDatumZaposlenja(Date datumZaposlenja) {
    	if (datumZaposlenja == null) {
            throw new NullPointerException("Datum zaposlenja ne sme biti null!");
        }

        if (datumZaposlenja.after(new Date())) {
            throw new IllegalArgumentException(
                "Datum zaposlenja ne sme biti posle danasnjeg datuma!"
            );
        }

        this.datumZaposlenja = datumZaposlenja;
    }

	@Override
	public int hashCode() {
		return Objects.hash(idPoslasticar);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Poslasticar other = (Poslasticar) obj;
		return Objects.equals(idPoslasticar, other.idPoslasticar);
	}
    
    
}
