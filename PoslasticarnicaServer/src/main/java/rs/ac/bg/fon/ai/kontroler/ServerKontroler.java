package rs.ac.bg.fon.ai.kontroler;

import java.util.ArrayList;

import rs.ac.bg.fon.ai.domen.Poslasticar;
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
    
    public ArrayList<Poslasticar> getUlogovaniPoslasticari() {
        return ulogovaniPoslasticari;
    }
    
    public Poslasticar login(Poslasticar p) throws Exception {
        SOLogin so = new SOLogin();
        so.izvrsi(p);
        return so.getUlogovani();
    }
}
