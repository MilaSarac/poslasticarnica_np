package rs.ac.bg.fon.ai.sesija;

import java.io.IOException;
import java.net.Socket;

import rs.ac.bg.fon.ai.domen.Poslasticar;
import rs.ac.bg.fon.ai.forme.GlavnaForma;

public class Sesija {

	private static volatile Sesija instance;
    private Socket socket;
    private Poslasticar ulogovaniPoslasticar;  
    private GlavnaForma glavnaForma;
    
    private Sesija() {
    }

    public static Sesija getInstance() {
        if (instance == null) {
            synchronized (Sesija.class) {
                if (instance == null) {
                    instance = new Sesija();
                }
            }
        }
        return instance;
    }
    
    public synchronized Socket getSocket() {
        try {
            if (socket == null || socket.isClosed() || !socket.isConnected()) {
                socket = new Socket("localhost", 9000);
            }
        } catch (IOException e) {
            throw new RuntimeException("Server nije pokrenut!", e);
        }
        return socket;
    }

    public synchronized void close() {
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException ignored) {
            }
            socket = null;
        }
    }

	public Poslasticar getUlogovaniPoslasticar() {
		return ulogovaniPoslasticar;
	}

	public void setUlogovaniPoslasticar(Poslasticar ulogovaniPoslasticar) {
		this.ulogovaniPoslasticar = ulogovaniPoslasticar;
	}

	public GlavnaForma getGlavnaForma() {
		return glavnaForma;
	}

	public void setGlavnaForma(GlavnaForma glavnaForma) {
		this.glavnaForma = glavnaForma;
	}

}
