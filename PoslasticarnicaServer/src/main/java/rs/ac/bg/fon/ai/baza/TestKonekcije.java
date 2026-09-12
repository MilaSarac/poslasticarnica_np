package rs.ac.bg.fon.ai.baza;

public class TestKonekcije {

    public static void main(String[] args) {

        if (DBBroker.getInstance().getConnection() != null) {
            System.out.println("Uspesno povezivanje sa bazom.");
        } else {
            System.out.println("Povezivanje sa bazom nije uspelo.");
        }
    }
}