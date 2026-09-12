package rs.ac.bg.fon.ai.niti;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PokreniServer extends Thread{
    
    private ServerSocket serverSocket;
    private List<ObradaKlijentskihZahteva> listaNitiKlijenta;
    
    public PokreniServer(int port) {
        try {
            serverSocket = new ServerSocket(port);
            listaNitiKlijenta = new ArrayList<>();
            System.out.println("Server je pokrenut na portu " + port);
        } catch (IOException ex) {
            Logger.getLogger(PokreniServer.class.getName())
                    .log(Level.SEVERE, "Greska prilikom pokretanja servera na portu " + port, ex);
        }
    }
    
    @Override
    public void run() {
        System.out.println("POKRENUT JE SERVER - CEKANJE KLIJENATA...");
        try {
            while (!serverSocket.isClosed()) {
                Socket socket = serverSocket.accept();
                System.out.println("Klijent se povezao!");
                ObradaKlijentskihZahteva nitKlijenta = new ObradaKlijentskihZahteva(socket);
                listaNitiKlijenta.add(nitKlijenta);
                System.out.println("Ukupno povezanih klijenata: " + listaNitiKlijenta.size());
                nitKlijenta.start();
            }
        } catch (SocketException e) {
            System.out.println("Server je zaustavljen.");
        } catch (IOException e) {
            Logger.getLogger(PokreniServer.class.getName())
                    .log(Level.SEVERE, "Greska u radu servera: " + e.getMessage(), e);
        }
    }
    
    public void zaustaviServer() {
        try {
            for (ObradaKlijentskihZahteva nitKlijenta : listaNitiKlijenta) {
                nitKlijenta.zatvoriSocket();
            }
            listaNitiKlijenta.clear();
            if (serverSocket != null && !serverSocket.isClosed()) {
                serverSocket.close();
            }
            System.out.println("Server uspesno zaustavljen.");
        } catch (IOException ex) {
            Logger.getLogger(PokreniServer.class.getName())
                    .log(Level.WARNING, "Greska prilikom zaustavljanja servera: " + ex.getMessage(), ex);
        }
    }
}