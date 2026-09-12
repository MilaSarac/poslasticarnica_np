package rs.ac.bg.fon.ai.kontroler;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import rs.ac.bg.fon.ai.domen.Poslasticar;
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
    
    public Poslasticar login(Poslasticar p) throws Exception {
        return (Poslasticar) posaljiZahtev(Operacije.LOGIN, p);
    }
}
