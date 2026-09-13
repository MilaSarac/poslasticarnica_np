package rs.ac.bg.fon.ai.niti;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import rs.ac.bg.fon.ai.domen.Kolac;
import rs.ac.bg.fon.ai.domen.Poslasticar;
import rs.ac.bg.fon.ai.kontroler.ServerKontroler;
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
        } catch (IOException ex) {
            System.out.println("Klijent je prekinuo konekciju.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            zatvoriSocket();
        }
    }

    private ServerskiOdgovor obradiZahtev(KlijentskiZahtev kz) {
        ServerskiOdgovor so = new ServerskiOdgovor(null, null, RezultatOp.Uspeh);
        try {
            switch (kz.getOperacija()) {

                case Operacije.LOGIN:
                	Poslasticar p =  (Poslasticar) kz.getZahtev();
                    Poslasticar ulogovani = ServerKontroler.getInstance().login(p);
                    so.setOdgovor(ulogovani);
                    break;
                    
                case Operacije.VRATI_SVE_KOLACE:
                    so.setOdgovor(ServerKontroler.getInstance().vratiSveKolace());
                    break;
                case Operacije.DODAJ_KOLAC:
                    ServerKontroler.getInstance().dodajKolac((Kolac) kz.getZahtev());
                    so.setOdgovor(null);
                    so.setRezultat(RezultatOp.Uspeh);
                    break;    
                case Operacije.IZMENI_KOLAC:
                    ServerKontroler.getInstance().izmeniKolac((Kolac) kz.getZahtev());
                    break;
                case Operacije.OBRISI_KOLAC:
                    ServerKontroler.getInstance().obrisiKolac((Kolac) kz.getZahtev());
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