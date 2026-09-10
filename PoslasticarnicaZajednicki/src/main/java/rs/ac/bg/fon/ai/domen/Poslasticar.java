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
	
	public Poslasticar(Long idPoslasticar, String ime, String prezime, String korisnickoime, String sifra, Date datumZaposlenja) {
        this.idPoslasticar = idPoslasticar;
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoime;
        this.sifra = sifra;
        this.datumZaposlenja = datumZaposlenja;
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
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public Date getDatumZaposlenja() {
        return datumZaposlenja;
    }

    public void setDatumZaposlenja(Date datumZaposlenja) {
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
