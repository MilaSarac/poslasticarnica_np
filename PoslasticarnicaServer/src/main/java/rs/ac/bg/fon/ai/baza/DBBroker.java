package rs.ac.bg.fon.ai.baza;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import rs.ac.bg.fon.ai.domen.ApstraktniDomenskiObjekat;

public class DBBroker {

    private static DBBroker instance;
    private Connection connection;

    private DBBroker() {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("konfiguracija.properties"));
            String url = properties.getProperty("url");
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");
            System.out.println("=== DBBroker ===");
			System.out.println("URL: " + url);
			System.out.println("Username: " + username);
            connection = DriverManager.getConnection(url, username, password);
            connection.setAutoCommit(false);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static DBBroker getInstance() {
        if (instance == null) {
            instance = new DBBroker();
        }
        return instance;
    }

    public ArrayList<ApstraktniDomenskiObjekat> vrati(ApstraktniDomenskiObjekat ado) throws SQLException {
        String upit = "SELECT * FROM " + ado.nazivTabele() + " " + ado.alijas()
                + " " + ado.join() + " " + ado.uslovZaVrati();
        System.out.println(upit + "\n");
        Statement s = connection.createStatement();
        ResultSet rs = s.executeQuery(upit);
        return ado.vratiListu(rs);
    }

    public PreparedStatement dodaj(ApstraktniDomenskiObjekat ado) throws SQLException {
        String naredba = "INSERT INTO " + ado.nazivTabele() + " "
                + ado.koloneZaDodaj() + " VALUES(" + ado.vrednostiZaDodaj() + ")";
        System.out.println(naredba + "\n");
        PreparedStatement ps = connection.prepareStatement(naredba, Statement.RETURN_GENERATED_KEYS);
        ps.executeUpdate();
        return ps;
    }

    public void izmeni(ApstraktniDomenskiObjekat ado) throws SQLException {
        String naredba = "UPDATE " + ado.nazivTabele() + " SET "
                + ado.vrednostiZaPromeni() + " WHERE " + ado.uslov();
        System.out.println(naredba + "\n");
        Statement s = connection.createStatement();
        s.executeUpdate(naredba);
    }

    public void izbrisi(ApstraktniDomenskiObjekat ado) throws SQLException {
        String naredba = "DELETE FROM " + ado.nazivTabele() + " WHERE " + ado.uslov();
        System.out.println(naredba + "\n");
        Statement s = connection.createStatement();
        s.executeUpdate(naredba);
    }
}