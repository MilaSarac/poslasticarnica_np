package rs.ac.bg.fon.ai.domen;

import java.util.ArrayList;
import java.util.Date;

public class Racun {

	private Long idRacun;
    private Date datumIzdavanja;
    private double ukupanIznos;
    
    private Poslasticar poslasticar;
    private Kupac kupac;
    private ArrayList<StavkaRacuna> stavkeRacuna;

    public Racun() {
    }

    public Racun(Long idRacun, Date datumIzdavanja, double ukupanIznos, Poslasticar poslasticar, Kupac kupac, ArrayList<StavkaRacuna> stavkeRacuna) {
    	this.idRacun = idRacun;
	    setDatumIzdavanja(datumIzdavanja);
	    setUkupanIznos(ukupanIznos);
	    setPoslasticar(poslasticar);
	    setKupac(kupac);
	    setStavkeRacuna(stavkeRacuna);
    }

    public Long getIdRacun() {
        return idRacun;
    }

    public void setIdRacun(Long idRacun) {
        this.idRacun = idRacun;
    }

    public Date getDatumIzdavanja() {
        return datumIzdavanja;
    }

    public void setDatumIzdavanja(Date datumIzdavanja) {
    	if (datumIzdavanja == null) {
            throw new NullPointerException(
                    "Datum izdavanja ne sme biti null!"
            );
        }

        if (datumIzdavanja.after(new Date())) {
            throw new IllegalArgumentException(
                    "Datum izdavanja ne sme biti u buducnosti!"
            );
        }

        this.datumIzdavanja = datumIzdavanja;
    }

    public double getUkupanIznos() {
        return ukupanIznos;
    }

    public void setUkupanIznos(double ukupanIznos) {
    	if (ukupanIznos <= 0) {
            throw new IllegalArgumentException(
                    "Ukupan iznos mora biti veci od nula!"
            );
        }

        this.ukupanIznos = ukupanIznos;
    }

    public Poslasticar getPoslasticar() {
        return poslasticar;
    }

    public void setPoslasticar(Poslasticar poslasticar) {
        this.poslasticar = poslasticar;
    }

    public Kupac getKupac() {
        return kupac;
    }

    public void setKupac(Kupac kupac) {
        this.kupac = kupac;
    }

    public ArrayList<StavkaRacuna> getStavkeRacuna() {
        return stavkeRacuna;
    }

    public void setStavkeRacuna(ArrayList<StavkaRacuna> stavkeRacuna) {
        this.stavkeRacuna = stavkeRacuna;
    }
}
