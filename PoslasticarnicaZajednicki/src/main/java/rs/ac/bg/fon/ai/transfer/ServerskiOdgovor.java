package rs.ac.bg.fon.ai.transfer;

import java.io.Serializable;
import rs.ac.bg.fon.ai.transfer.util.RezultatOp;

public class ServerskiOdgovor implements Serializable {

	private Object odgovor;
    private Exception exc;
    private RezultatOp rezultat;
    
    public ServerskiOdgovor() {
    }

    public ServerskiOdgovor(Object odgovor, Exception exc, RezultatOp rezultat) {
        this.odgovor = odgovor;
        this.exc = exc;
        this.rezultat = rezultat;
    }

    public Object getOdgovor() {
        return odgovor;
    }

    public void setOdgovor(Object odgovor) {
        this.odgovor = odgovor;
    }

    public Exception getExc() {
        return exc;
    }

    public void setExc(Exception exc) {
        this.exc = exc;
    }

    public RezultatOp getRezultat() {
        return rezultat;
    }

    public void setRezultat(RezultatOp rezultat) {
        this.rezultat = rezultat;
    }
    
}
