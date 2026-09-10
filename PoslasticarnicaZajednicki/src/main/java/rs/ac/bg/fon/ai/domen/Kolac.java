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
        setNaziv(naziv);
        setCena(cena);
        setOpis(opis);
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
    	if(naziv==null) {
    		throw new NullPointerException("Naziv ne sme biti null!");
    	}
    	
    	if(naziv.isEmpty()) {
    		throw new IllegalArgumentException("Naziv ne sme biti prazan!");
    	}
    	
        this.naziv = naziv;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
    	if (cena<=0) {
            throw new IllegalArgumentException("Cena mora biti veca od nula!");
        }
    	
        this.cena = cena;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
    	if(opis==null) {
    		throw new NullPointerException("Opis ne sme biti null!");
    	}
    	
    	if(opis.isEmpty()) {
    		throw new IllegalArgumentException("Opis ne sme biti prazan!");
    	}
    	
        this.opis = opis;
    }
}
