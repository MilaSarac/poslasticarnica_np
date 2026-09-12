package rs.ac.bg.fon.ai.niti;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import rs.ac.bg.fon.ai.transfer.KlijentskiZahtev;
import rs.ac.bg.fon.ai.transfer.ServerskiOdgovor;
import rs.ac.bg.fon.ai.transfer.util.Operacije;
import rs.ac.bg.fon.ai.transfer.util.RezultatOp;

public class ObradaKlijentskihZahteva extends Thread {
    
    private Socket socket;

    ObradaKlijentskihZahteva(Socket socket) {
        this.socket = socket;
    }
    
    @Override
    public void run() {
        try {
            while (!socket.isClosed()) {
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                KlijentskiZahtev kz = (KlijentskiZahtev) in.readObject();

                ServerskiOdgovor so = obradiZahtev(kz);
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                out.writeObject(so);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private ServerskiOdgovor obradiZahtev(KlijentskiZahtev kz) {
        ServerskiOdgovor so = new ServerskiOdgovor(null, null, RezultatOp.Uspeh);
        try {
            switch (kz.getOperacija()) {

                case Operacije.LOGIN:
                    break;
                default:
                    return null;
            }
        } catch (Exception ex) {
            so.setRezultat(RezultatOp.Greska);
            so.setExc(ex);
        }
        return so;
    }
    
    public void zatvoriSocket() {
        try {
            if (socket != null && !socket.isClosed()) {
                socket.close();
                Logger.getLogger(ObradaKlijentskihZahteva.class.getName())
                        .log(Level.INFO, "Soket je uspesno zatvoren.");
            }
        } catch (IOException e) {
            Logger.getLogger(ObradaKlijentskihZahteva.class.getName())
                    .log(Level.SEVERE, "Greska pri zatvaranju soketa.", e);
        }
    }
    
}