package rs.ac.bg.fon.ai.domen;

import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Klasa koja predstavlja angazovanje poslasticara u odredjenoj smeni
 * odredjenog datuma.
 * 
 * PoslasticarSmena sadrzi poslasticara, smenu u kojoj poslasticar radi
 * i datum za koji je smena odredjena.
 * 
 * @author Mila
 */
public class PoslasticarSmena extends ApstraktniDomenskiObjekat{

	/**
	 * Poslasticar kao objekat klase Poslasticar.
	 */
	private Poslasticar poslasticar;

	/**
	 * Smena poslasticara kao objekat klase Smena.
	 */
    private Smena smena;

    /**
	 * Datum smene poslasticara kao Date vrednost.
	 */
    private Date datum;

    /**
     * Konstruktor koji inicijalizuje objekat klase PoslasticarSmena.
     */
    public PoslasticarSmena() {
    }

    /**
     * Konstruktor koji inicijalizuje objekat klase PoslasticarSmena i postavlja
     * prosledjene vrednosti njegovim atributima.
     * 
     * @param poslasticar Poslasticar kao objekat klase Poslasticar.
     * @param smena Smena poslasticara kao objekat klase Smena.
     * @param datum Datum smene poslasticara kao Date vrednost.
     */
    public PoslasticarSmena(Poslasticar poslasticar, Smena smena, Date datum) {
    	setPoslasticar(poslasticar);
        setSmena(smena);
        setDatum(datum);
    }

    /**
     * Vraca poslasticara.
     * 
     * @return poslasticar kao objekat klase Poslasticar.
     */
    public Poslasticar getPoslasticar() {
        return poslasticar;
    }

    /**
     * Postavlja vrednost atributa poslasticar na novu unetu vrednost.
     * 
     * @param poslasticar Poslasticar kao objekat klase Poslasticar.
     */
    public void setPoslasticar(Poslasticar poslasticar) {
        this.poslasticar = poslasticar;
    }

    /**
     * Vraca smenu poslasticara.
     * 
     * @return smena poslasticara kao objekat klase Smena.
     */
    public Smena getSmena() {
        return smena;
    }

    /**
     * Postavlja vrednost atributa smena na novu unetu vrednost.
     * 
     * @param smena Smena poslasticara kao objekat klase Smena.
     */
    public void setSmena(Smena smena) {
        this.smena = smena;
    }

    /**
     * Vraca datum smene poslasticara.
     * 
     * @return datum smene poslasticara kao Date.
     */
    public Date getDatum() {
        return datum;
    }

    /**
     * Postavlja vrednost atributa datum na novu unetu vrednost.
     * 
     * @param datum Datum smene poslasticara kao Date vrednost.
     * @throws java.lang.NullPointerException Ako je uneti datum null
     */
    public void setDatum(Date datum) {
    	if (datum == null) {
            throw new NullPointerException("Datum ne sme biti null!");
        }

        this.datum = datum;
    }
    
    @Override
    public String nazivTabele() {
        return " poslasticarSmena ";
    }

    @Override
    public String alijas() {
        return " ps ";
    }

    @Override
    public String join() {
        return " JOIN poslasticar p ON (p.idPoslasticar = ps.idPoslasticar) "
                + " JOIN Smena s ON (s.idSmena= ps.idSmena) ";
    }

    @Override
    public ArrayList<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            Poslasticar p = new Poslasticar(
                    rs.getLong("p.idPoslasticar"),
                    rs.getString("p.ime"),
                    rs.getString("p.prezime"),
                    rs.getString("p.korisnickoIme"),
                    rs.getString("p.sifra"),
                    rs.getDate("p.datumZaposlenja")
            );
            Smena s = new Smena(
                    rs.getLong("s.idSmena"),
                    rs.getString("s.naziv"),
                    rs.getDate("s.vremePocetka"),
                    rs.getDate("s.vremeZavrsetka")
            );
            PoslasticarSmena ps = new PoslasticarSmena(p, s, rs.getDate("ps.datum"));
            lista.add(ps);
        }
        rs.close();
        return lista;
    }

    @Override
    public String koloneZaDodaj() {
        return " (idPoslasticar, idSmena, datum) ";
    }

    @Override
    public String vrednostiZaDodaj() {
        return poslasticar.getIdPoslasticar() + ", " + smena.getIdSmena()
                + ", '" + datum + "'";
    }

    @Override
    public String vrednostiZaPromeni() {
        return " datum = '" + datum + "' ";
    }

    @Override
    public String uslov() {
        return " idPoslasticar = " + poslasticar.getIdPoslasticar()
                + " AND idSmena= " + smena.getIdSmena();
    }

    @Override
    public String uslovZaVrati() {
        return "";
    }
    
}