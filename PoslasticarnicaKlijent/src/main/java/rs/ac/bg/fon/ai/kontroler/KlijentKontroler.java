package rs.ac.bg.fon.ai.kontroler;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import rs.ac.bg.fon.ai.domen.Kolac;
import rs.ac.bg.fon.ai.domen.Kupac;
import rs.ac.bg.fon.ai.domen.Mesto;
import rs.ac.bg.fon.ai.domen.Poslasticar;
import rs.ac.bg.fon.ai.domen.Racun;
import rs.ac.bg.fon.ai.sesija.Sesija;
import rs.ac.bg.fon.ai.transfer.KlijentskiZahtev;
import rs.ac.bg.fon.ai.transfer.ServerskiOdgovor;
import rs.ac.bg.fon.ai.transfer.util.Operacije;
import rs.ac.bg.fon.ai.transfer.util.RezultatOp;

public class KlijentKontroler {

	private static KlijentKontroler instance;

    private KlijentKontroler() {
    }

    public static KlijentKontroler getInstance() {
        if (instance == null) {
            instance = new KlijentKontroler();
        }
        return instance;
    }
    
    private synchronized Object posaljiZahtev(int operacija, Object zahtev) throws Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev(operacija, zahtev);

        ObjectOutputStream out = new ObjectOutputStream(Sesija.getInstance().getSocket().getOutputStream());
        out.writeObject(kz);

        ObjectInputStream in = new ObjectInputStream(Sesija.getInstance().getSocket().getInputStream());
        ServerskiOdgovor so = (ServerskiOdgovor) in.readObject();

        if (so.getRezultat().equals(RezultatOp.Greska)) {
            throw so.getExc();
        } else {
            return so.getOdgovor();
        }
    }
    
    // LOGIN
    public Poslasticar login(Poslasticar p) throws Exception {
        return (Poslasticar) posaljiZahtev(Operacije.LOGIN, p);
    }
    
    // KOLAC
    public ArrayList<Kolac> vratiSveKolace() throws Exception {
        return (ArrayList<Kolac>) posaljiZahtev(Operacije.VRATI_SVE_KOLACE, new Kolac());
    }
    
    public void dodajKolac(Kolac kolac) throws Exception {
        posaljiZahtev(Operacije.DODAJ_KOLAC, kolac);
    }
    
    public void izmeniKolac(Kolac kolac) throws Exception {
        posaljiZahtev(Operacije.IZMENI_KOLAC, kolac);
    }
    
    public void obrisiKolac(Kolac kolac) throws Exception {
        posaljiZahtev(Operacije.OBRISI_KOLAC, kolac);
    }
    
    public ArrayList<Kolac> pretraziKolace(Kolac kriterijum) throws Exception {
        return (ArrayList<Kolac>) posaljiZahtev(Operacije.PRETRAZI_KOLACE,kriterijum);
    }
    
    // KUPAC
    public ArrayList<Kupac> vratiSveKupce() throws Exception {
        return (ArrayList<Kupac>) posaljiZahtev(Operacije.VRATI_SVE_KUPCE, new Kupac());
    }
    
    public void dodajKupca(Kupac kupac) throws Exception {
        posaljiZahtev(Operacije.DODAJ_KUPCA, kupac);
    }
    
    public void promeniKupca(Kupac kupac) throws Exception {
        posaljiZahtev(Operacije.PROMENI_KUPCA, kupac);
    }
    
    public void obrisiKupca(Kupac kupac) throws Exception {
        posaljiZahtev(Operacije.OBRISI_KUPCA, kupac);
    }
    
    public ArrayList<Kupac> pretraziKupce(Kupac kupac) throws Exception {
        return (ArrayList<Kupac>) posaljiZahtev(Operacije.PRETRAZI_KUPCE,kupac);
    }
    
    // MESTO
    public ArrayList<Mesto> vratiSvaMesta() throws Exception {
        return (ArrayList<Mesto>) posaljiZahtev(Operacije.VRATI_SVA_MESTA, new Mesto());
    }
    
    // RACUN
    public void ubaciRacun(Racun racun) throws Exception {
        posaljiZahtev(Operacije.UBACI_RACUN, racun);
    }
    
    // LOGOUT
    public void logout(Poslasticar poslasticar) throws Exception {
        posaljiZahtev(Operacije.LOGOUT, poslasticar);
    }
}
