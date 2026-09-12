package rs.ac.bg.fon.ai.domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Klasa koja predstavlja stavku racuna u poslasticarnici.
 * 
 * Stavka racuna pripada odredjenom racunu i sadrzi redni broj stavke,
 * cenu, kolicinu, iznos i kolac na koji se stavka odnosi.
 * 
 * @author Mila
 */
public class StavkaRacuna extends ApstraktniDomenskiObjekat{

	/**
	 * Racun kome stavka pripada kao objekat klase Racun.
	 */
	private Racun racun;

	/**
	 * Redni broj stavke racuna kao int vrednost.
	 */
    private int rb;

    /**
	 * Cena kolaca u stavci racuna kao double vrednost.
	 */
    private double cena;

    /**
	 * Kolicina kolaca u stavci racuna kao int vrednost.
	 */
    private int kolicina;

    /**
	 * Iznos stavke racuna kao double vrednost.
	 */
    private double iznos;

    /**
	 * Kolac na koji se stavka racuna odnosi kao objekat klase Kolac.
	 */
    private Kolac kolac;

    /**
     * Konstruktor koji inicijalizuje objekat klase StavkaRacuna.
     */
    public StavkaRacuna() {
    }

    /**
     * Konstruktor koji inicijalizuje objekat klase StavkaRacuna i postavlja
     * prosledjene vrednosti njenim atributima.
     * 
     * @param racun Racun kome stavka pripada kao objekat klase Racun.
     * @param rb Redni broj stavke racuna kao int vrednost.
     * @param cena Cena kolaca u stavci racuna kao double vrednost.
     * @param kolicina Kolicina kolaca u stavci racuna kao int vrednost.
     * @param iznos Iznos stavke racuna kao double vrednost.
     * @param kolac Kolac na koji se stavka racuna odnosi kao objekat klase Kolac.
     */
    public StavkaRacuna(Racun racun, int rb, double cena, int kolicina,
    		double iznos, Kolac kolac) {
    	this.racun = racun;
        this.rb = rb;
        setCena(cena);
        setKolicina(kolicina);
        setIznos(iznos);
        this.kolac = kolac;
    }

    /**
     * Vraca racun kome stavka pripada.
     * 
     * @return racun kao objekat klase Racun.
     */
    public Racun getRacun() {
        return racun;
    }

    /**
     * Postavlja vrednost atributa racun na novu unetu vrednost.
     * 
     * @param racun Racun kome stavka pripada kao objekat klase Racun.
     */
    public void setRacun(Racun racun) {
        this.racun = racun;
    }

    /**
     * Vraca redni broj stavke racuna.
     * 
     * @return redni broj stavke racuna kao int.
     */
    public int getRb() {
        return rb;
    }

    /**
     * Postavlja vrednost atributa rb na novu unetu vrednost.
     * 
     * @param rb Redni broj stavke racuna kao int vrednost.
     */
    public void setRb(int rb) {
        this.rb = rb;
    }

    /**
     * Vraca cenu kolaca u stavci racuna.
     * 
     * @return cena kolaca u stavci racuna kao double.
     */
    public double getCena() {
        return cena;
    }

    /**
     * Postavlja vrednost atributa cena na novu unetu vrednost.
     * 
     * @param cena Cena kolaca u stavci racuna kao double vrednost.
     * @throws java.lang.IllegalArgumentException Ako je uneta cena
     *         manja ili jednaka nuli
     */
    public void setCena(double cena) {
    	if (cena <= 0) {
            throw new IllegalArgumentException("Cena mora biti veca od nula!");
        }

        this.cena = cena;
    }

    /**
     * Vraca kolicinu kolaca u stavci racuna.
     * 
     * @return kolicina kolaca u stavci racuna kao int.
     */
    public int getKolicina() {
        return kolicina;
    }

    /**
     * Postavlja vrednost atributa kolicina na novu unetu vrednost.
     * 
     * @param kolicina Kolicina kolaca u stavci racuna kao int vrednost.
     * @throws java.lang.IllegalArgumentException Ako je uneta kolicina
     *         manja ili jednaka nuli
     */
    public void setKolicina(int kolicina) {
    	if (kolicina <= 0) {
            throw new IllegalArgumentException("Kolicina mora biti veca od nula!");
        }

        this.kolicina = kolicina;
    }

    /**
     * Vraca iznos stavke racuna.
     * 
     * @return iznos stavke racuna kao double.
     */
    public double getIznos() {
        return iznos;
    }

    /**
     * Postavlja vrednost atributa iznos na novu unetu vrednost.
     * 
     * @param iznos Iznos stavke racuna kao double vrednost.
     * @throws java.lang.IllegalArgumentException Ako je uneti iznos
     *         manji ili jednak nuli
     */
    public void setIznos(double iznos) {
    	if (iznos <= 0) {
            throw new IllegalArgumentException("Iznos mora biti veci od nula!");
        }

        this.iznos = iznos;
    }

    /**
     * Vraca kolac na koji se stavka racuna odnosi.
     * 
     * @return kolac kao objekat klase Kolac.
     */
    public Kolac getKolac() {
        return kolac;
    }

    /**
     * Postavlja vrednost atributa kolac na novu unetu vrednost.
     * 
     * @param kolac Kolac na koji se stavka racuna odnosi kao objekat klase Kolac.
     */
    public void setKolac(Kolac kolac) {
        this.kolac = kolac;
    }
    
    @Override
    public String nazivTabele() {
        return " stavkaRacuna ";
    }

    @Override
    public String alijas() {
        return " sr ";
    }

    @Override
    public String join() {
        return " JOIN racun r ON (r.idRacun = sr.idRacun) "
                + " JOIN poslasticar p ON (p.idPoslasticar = r.idPoslasticar) "
                + " JOIN kupac k ON (k.idKupac = r.idKupac) "
                + " JOIN mesto m ON ON (m.idMesto = k.idMesto) "
                + " JOIN kolac ko ON (ko.idKolac = sr.idKolac) ";
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
            Mesto m = new Mesto(
                    rs.getLong("m.idMesto"),
                    rs.getString("m.naziv")
            );
            Kupac k = new Kupac(
                    rs.getLong("k.idKupac"),
                    rs.getString("k.ime"),
                    rs.getString("k.prezime"),
                    rs.getString("k.brojTelefona"),
                    rs.getString("k.email"),
                    m
            );
            Racun r = new Racun(
                    rs.getLong("r.idRacun"),
                    rs.getDate("r.datumIzdavanja"),
                    rs.getDouble("r.ukupanIznos"),
                    p, k, null
            );

            Kolac ko = new Kolac(
                    rs.getLong("ko.idKolac"),
                    rs.getString("ko.naziv"),
                    rs.getDouble("ko.cena"),
                    rs.getString("ko.opis")
            );

            StavkaRacuna sr = new StavkaRacuna(
                    r,
                    rs.getInt("sr.rb"),
                    rs.getDouble("sr.cena"),
                    rs.getInt("sr.kolicina"),
                    rs.getDouble("sr.iznos"),
                    ko
            );

            lista.add(sr);
        }
        rs.close();
        return lista;
    }

    @Override
    public String koloneZaDodaj() {
        return " (idRacun, rb, cena, kolicina, iznos, idKolac) ";
    }

    @Override
    public String vrednostiZaDodaj() {
        return racun.getIdRacun() + ", " + rb + ", " + cena + ", "
                + kolicina + ", " + iznos + ", " + kolac.getIdKolac();
    }

    @Override
    public String vrednostiZaPromeni() {
        return " cena = " + cena + ", iznos = " + iznos
                + ", kolicina = " + kolicina + ", "
                + "idKolac = " + kolac.getIdKolac() + " ";
    }

    @Override
    public String uslov() {
        return " idRacun = " + racun.getIdRacun() + " AND rb = " + rb;
    }

    @Override
    public String uslovZaVrati() {
        return " WHERE sr.idRacun = " + racun.getIdRacun();
    }
    
}
