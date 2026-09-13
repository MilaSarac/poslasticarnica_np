package rs.ac.bg.fon.ai.kontroler;

import java.util.ArrayList;

import rs.ac.bg.fon.ai.domen.Kolac;
import rs.ac.bg.fon.ai.domen.Kupac;
import rs.ac.bg.fon.ai.domen.Mesto;
import rs.ac.bg.fon.ai.domen.Poslasticar;
import rs.ac.bg.fon.ai.domen.Racun;
import rs.ac.bg.fon.ai.so.kolac.SODodajKolac;
import rs.ac.bg.fon.ai.so.kolac.SOIzmeniKolac;
import rs.ac.bg.fon.ai.so.kolac.SOObrisiKolac;
import rs.ac.bg.fon.ai.so.kolac.SOPretraziKolace;
import rs.ac.bg.fon.ai.so.kolac.SOVratiSveKolace;
import rs.ac.bg.fon.ai.so.kupac.SODodajKupca;
import rs.ac.bg.fon.ai.so.kupac.SOObrisiKupca;
import rs.ac.bg.fon.ai.so.kupac.SOPretraziKupce;
import rs.ac.bg.fon.ai.so.kupac.SOPromeniKupca;
import rs.ac.bg.fon.ai.so.kupac.SOVratiSveKupce;
import rs.ac.bg.fon.ai.so.login.SOLogin;
import rs.ac.bg.fon.ai.so.logout.SOLogout;
import rs.ac.bg.fon.ai.so.mesto.SOVratiSvaMesta;
import rs.ac.bg.fon.ai.so.racun.SOUbaciRacun;

public class ServerKontroler {
    
    private static ServerKontroler instance;
    private ArrayList<Poslasticar> ulogovaniPoslasticari= new ArrayList<>();
    
    private ServerKontroler() {
    }

    public static ServerKontroler getInstance() {
        if (instance == null) {
            instance = new ServerKontroler();
        }
        return instance;
    }
    
    // LOGIN
    public ArrayList<Poslasticar> getUlogovaniPoslasticari() {
        return ulogovaniPoslasticari;
    }
    
    public Poslasticar login(Poslasticar p) throws Exception {
        SOLogin so = new SOLogin();
        so.izvrsi(p);
        return so.getUlogovani();
    }
    
    // KOLAC
    public ArrayList<Kolac> vratiSveKolace() throws Exception {
        SOVratiSveKolace so = new SOVratiSveKolace();
        so.izvrsi(new Kolac());
        return so.getLista();
    }
    
    public void dodajKolac(Kolac kolac) throws Exception {
        (new SODodajKolac()).izvrsi(kolac);
    }
    
    public void izmeniKolac(Kolac kolac) throws Exception {
        SOIzmeniKolac so = new SOIzmeniKolac();
        so.izvrsi(kolac);
    }
    
    public void obrisiKolac(Kolac kolac) throws Exception {
        SOObrisiKolac so = new SOObrisiKolac();
        so.izvrsi(kolac);
    }
    
    public ArrayList<Kolac> pretraziKolace(Kolac kriterijum) throws Exception {
        SOPretraziKolace so = new SOPretraziKolace();
        so.izvrsi(kriterijum);
        return so.getLista();
    }
    
    // KUPAC
    public ArrayList<Kupac> vratiSveKupce() throws Exception {
        SOVratiSveKupce so = new SOVratiSveKupce();
        so.izvrsi(new Kupac());
        return so.getLista();
    }
    
    public void dodajKupca(Kupac kupac) throws Exception {
        SODodajKupca so = new SODodajKupca();
        so.izvrsi(kupac);
    }
    
    public void promeniKupca(Kupac kupac) throws Exception {
        SOPromeniKupca so = new SOPromeniKupca();
        so.izvrsi(kupac);
    }
    
    public void obrisiKupca(Kupac kupac) throws Exception {
        SOObrisiKupca so = new SOObrisiKupca();
        so.izvrsi(kupac);
    }
    
    public ArrayList<Kupac> pretraziKupce(Kupac kupac) throws Exception {
        SOPretraziKupce so = new SOPretraziKupce();
        so.izvrsi(kupac);
        return so.getLista();
    }
    
    // MESTO
    public ArrayList<Mesto> vratiSvaMesta() throws Exception {
        SOVratiSvaMesta so = new SOVratiSvaMesta();
        so.izvrsi(new Mesto());
        return so.getLista();
    }
    
    // RACUN
    public void ubaciRacun(Racun racun) throws Exception {
        SOUbaciRacun operacija = new SOUbaciRacun();
        operacija.izvrsi(racun);
    }
    
    // LOGOUT
    public void logout(Poslasticar poslasticar) throws Exception {
        SOLogout operacija = new SOLogout();
        operacija.izvrsi(poslasticar);
    }
}
