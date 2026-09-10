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
        this.datumIzdavanja = datumIzdavanja;
        this.ukupanIznos = ukupanIznos;
        this.poslasticar = poslasticar;
        this.kupac = kupac;
        this.stavkeRacuna = stavkeRacuna;
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
        this.datumIzdavanja = datumIzdavanja;
    }

    public double getUkupanIznos() {
        return ukupanIznos;
    }

    public void setUkupanIznos(double ukupanIznos) {
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
