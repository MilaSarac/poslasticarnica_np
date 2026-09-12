package rs.ac.bg.fon.ai.transfer;

import java.io.Serializable;

public class KlijentskiZahtev implements Serializable {

	private int operacija;
    private Object zahtev;
 
    public KlijentskiZahtev() {
    }
 
    public KlijentskiZahtev(int operacija, Object zahtev) {
        this.operacija = operacija;
        this.zahtev = zahtev;
    }
 
    public int getOperacija() {
        return operacija;
    }
 
    public void setOperacija(int operacija) {
        this.operacija = operacija;
    }
 
    public Object getZahtev() {
        return zahtev;
    }
 
    public void setZahtev(Object zahtev) {
        this.zahtev = zahtev;
    }
    
}
