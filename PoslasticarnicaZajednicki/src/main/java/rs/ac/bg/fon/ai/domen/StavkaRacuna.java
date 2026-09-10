package rs.ac.bg.fon.ai.domen;

public class StavkaRacuna {

	private Racun racun;
    private int rb;
    private double cena;
    private int kolicina;
    private double iznos;
    private Kolac kolac;

    public StavkaRacuna() {
    }

    public StavkaRacuna(Racun racun, int rb, double cena, int kolicina, double iznos, Kolac kolac) {
    	this.racun = racun;
        this.rb = rb;
        setCena(cena);
        setKolicina(kolicina);
        setIznos(iznos);
        this.kolac = kolac;
    }

    public Racun getRacun() {
        return racun;
    }

    public void setRacun(Racun racun) {
        this.racun = racun;
    }

    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
    	if (cena <= 0) {
            throw new IllegalArgumentException("Cena mora biti veca od nula!");
        }

        this.cena = cena;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
    	if (kolicina <= 0) {
            throw new IllegalArgumentException("Kolicina mora biti veca od nula!");
        }

        this.kolicina = kolicina;
    }

    public double getIznos() {
        return iznos;
    }

    public void setIznos(double iznos) {
    	if (iznos <= 0) {
            throw new IllegalArgumentException("Iznos mora biti veci od nula!");
        }

        this.iznos = iznos;
    }

    public Kolac getKolac() {
        return kolac;
    }

    public void setKolac(Kolac kolac) {
        this.kolac = kolac;
    }
}
