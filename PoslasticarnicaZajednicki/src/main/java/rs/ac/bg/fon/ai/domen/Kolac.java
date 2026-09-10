package rs.ac.bg.fon.ai.domen;

public class Kolac {

	private Long idKolac;
    private String naziv;
    private double cena;
    private String opis;

    public Kolac() {
    }

    public Kolac(Long idKolac, String naziv, double cena, String opis) {
        this.idKolac = idKolac;
        this.naziv = naziv;
        this.cena = cena;
        this.opis = opis;
    }

    @Override
    public String toString() {
        return naziv;
    }

    public Long getIdKolac() {
        return idKolac;
    }

    public void setIdKolac(Long idKolac) {
        this.idKolac = idKolac;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
}
