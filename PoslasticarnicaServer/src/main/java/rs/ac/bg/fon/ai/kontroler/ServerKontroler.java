package rs.ac.bg.fon.ai.kontroler;

import java.util.ArrayList;

import rs.ac.bg.fon.ai.domen.Kolac;
import rs.ac.bg.fon.ai.domen.Poslasticar;
import rs.ac.bg.fon.ai.so.kolac.SOVratiSveKolace;
import rs.ac.bg.fon.ai.so.login.SOLogin;

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
}
