package rs.ac.bg.fon.ai.domen;

import java.util.Date;

public class Smena {

	private Long idSmena;
    private String naziv;
    private Date vremePocetka;
    private Date vremeZavrsetka;

    public Smena() {
    }

    public Smena(Long idSmena, String naziv, Date vremePocetka, Date vremeZavrsetka) {
    	this.idSmena = idSmena;
        setNaziv(naziv);
        setVremePocetka(vremePocetka);
        setVremeZavrsetka(vremeZavrsetka);
    }

    @Override
    public String toString() {
        return naziv ;
    }

    public Long getIdSmena() {
        return idSmena;
    }

    public void setIdSmena(Long idSmena) {
        this.idSmena = idSmena;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
    	if (naziv == null) {
            throw new NullPointerException("Naziv smene ne sme biti null!");
        }

        if (naziv.isEmpty()) {
            throw new IllegalArgumentException("Naziv smene ne sme biti prazan!");
        }

        this.naziv = naziv;
    }

    public Date getVremePocetka() {
        return vremePocetka;
    }

    public void setVremePocetka(Date vremePocetka) {
    	if (vremePocetka == null) {
            throw new NullPointerException("Vreme pocetka ne sme biti null!");
        }
        this.vremePocetka = vremePocetka;
    }

    public Date getVremeZavrsetka() {
        return vremeZavrsetka;
    }

    public void setVremeZavrsetka(Date vremeZavrsetka) {
    	if (vremeZavrsetka == null) {
            throw new NullPointerException("Vreme zavrsetka ne sme biti null!");
        }
        this.vremeZavrsetka = vremeZavrsetka;
    }
    
    
}
