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
        this.naziv = naziv;
        this.vremePocetka = vremePocetka;
        this.vremeZavrsetka = vremeZavrsetka;
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
        this.naziv = naziv;
    }

    public Date getVremePocetka() {
        return vremePocetka;
    }

    public void setVremePocetka(Date vremePocetka) {
        this.vremePocetka = vremePocetka;
    }

    public Date getVremeZavrsetka() {
        return vremeZavrsetka;
    }

    public void setVremeZavrsetka(Date vremeZavrsetka) {
        this.vremeZavrsetka = vremeZavrsetka;
    }
    
    
}
