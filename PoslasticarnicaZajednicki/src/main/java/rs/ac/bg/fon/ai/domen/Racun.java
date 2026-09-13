package rs.ac.bg.fon.ai.domen;

import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Klasa koja predstavlja racun u sistemu poslasticarnice.
 * 
 * Racun ima svoj jedinstveni identifikator, datum izdavanja, ukupan iznos,
 * poslasticara koji je izdao racun, kupca kome je racun izdat i stavke racuna.
 * 
 * @author Mila
 */
public class Racun extends ApstraktniDomenskiObjekat{

    /**
     * ID racuna kao Long vrednost.
     */
    private Long idRacun;

    /**
     * Datum izdavanja racuna kao Date vrednost.
     */
    private Date datumIzdavanja;

    /**
     * Ukupan iznos racuna kao double vrednost.
     */
    private double ukupanIznos;

    /**
     * Poslasticar koji je izdao racun kao objekat klase Poslasticar.
     */
    private Poslasticar poslasticar;

    /**
     * Kupac kome je racun izdat kao objekat klase Kupac.
     */
    private Kupac kupac;

    /**
     * Stavke racuna kao ArrayList objekata klase StavkaRacuna.
     */
    private ArrayList<StavkaRacuna> stavkeRacuna;

    /**
     * Konstruktor koji inicijalizuje objekat klase Racun.
     */
    public Racun() {

    }

    /**
     * Konstruktor koji inicijalizuje objekat klase Racun i postavlja
     * prosledjene vrednosti njegovim atributima.
     * 
     * @param idRacun ID novog racuna kao Long vrednost.
     * @param datumIzdavanja Datum izdavanja novog racuna kao Date vrednost.
     * @param ukupanIznos Ukupan iznos novog racuna kao double vrednost.
     * @param poslasticar Poslasticar koji je izdao racun kao objekat klase Poslasticar.
     * @param kupac Kupac kome je racun izdat kao objekat klase Kupac.
     * @param stavkeRacuna Stavke novog racuna kao ArrayList objekata klase StavkaRacuna.
     */
    public Racun(Long idRacun, Date datumIzdavanja, double ukupanIznos,
            Poslasticar poslasticar, Kupac kupac,
            ArrayList<StavkaRacuna> stavkeRacuna) {

        this.idRacun = idRacun;
        setDatumIzdavanja(datumIzdavanja);
        setUkupanIznos(ukupanIznos);
        setPoslasticar(poslasticar);
        setKupac(kupac);
        setStavkeRacuna(stavkeRacuna);
    }

    /**
     * Vraca ID racuna.
     * 
     * @return ID racuna kao Long vrednost.
     */
    public Long getIdRacun() {
        return idRacun;
    }

    /**
     * Postavlja vrednost atributa idRacun na novu unetu vrednost.
     * 
     * @param idRacun ID racuna kao Long vrednost.
     */
    public void setIdRacun(Long idRacun) {
        this.idRacun = idRacun;
    }

    /**
     * Vraca datum izdavanja racuna.
     * 
     * @return datum izdavanja racuna kao Date vrednost.
     */
    public Date getDatumIzdavanja() {
        return datumIzdavanja;
    }

    /**
     * Postavlja vrednost atributa datumIzdavanja na novu unetu vrednost.
     * 
     * @param datumIzdavanja Datum izdavanja racuna kao Date vrednost.
     * @throws java.lang.NullPointerException Ako je uneti datum izdavanja null.
     * @throws java.lang.IllegalArgumentException Ako je uneti datum izdavanja
     * u buducnosti.
     */
    public void setDatumIzdavanja(Date datumIzdavanja) {

        if (datumIzdavanja == null) {
            throw new NullPointerException(
                    "Datum izdavanja ne sme biti null!"
            );
        }

        if (datumIzdavanja.after(new Date())) {
            throw new IllegalArgumentException(
                    "Datum izdavanja ne sme biti u buducnosti!"
            );
        }

        this.datumIzdavanja = datumIzdavanja;
    }

    /**
     * Vraca ukupan iznos racuna.
     * 
     * @return ukupan iznos racuna kao double vrednost.
     */
    public double getUkupanIznos() {
        return ukupanIznos;
    }

    /**
     * Postavlja vrednost atributa ukupanIznos na novu unetu vrednost.
     * 
     * @param ukupanIznos Ukupan iznos racuna kao double vrednost.
     * @throws java.lang.IllegalArgumentException Ako je uneti ukupan iznos
     * manji ili jednak nuli.
     */
    public void setUkupanIznos(double ukupanIznos) {

        if (ukupanIznos <= 0) {
            throw new IllegalArgumentException(
                    "Ukupan iznos mora biti veci od nula!"
            );
        }

        this.ukupanIznos = ukupanIznos;
    }

    /**
     * Vraca poslasticara koji je izdao racun.
     * 
     * @return poslasticar koji je izdao racun kao objekat klase Poslasticar.
     */
    public Poslasticar getPoslasticar() {
        return poslasticar;
    }

    /**
     * Postavlja vrednost atributa poslasticar na novu unetu vrednost.
     * 
     * @param poslasticar Poslasticar koji je izdao racun kao objekat klase Poslasticar.
     */
    public void setPoslasticar(Poslasticar poslasticar) {
        this.poslasticar = poslasticar;
    }

    /**
     * Vraca kupca kome je racun izdat.
     * 
     * @return kupac kome je racun izdat kao objekat klase Kupac.
     */
    public Kupac getKupac() {
        return kupac;
    }

    /**
     * Postavlja vrednost atributa kupac na novu unetu vrednost.
     * 
     * @param kupac Kupac kome je racun izdat kao objekat klase Kupac.
     */
    public void setKupac(Kupac kupac) {
        this.kupac = kupac;
    }

    /**
     * Vraca stavke racuna.
     * 
     * @return stavke racuna kao ArrayList objekata klase StavkaRacuna.
     */
    public ArrayList<StavkaRacuna> getStavkeRacuna() {
        return stavkeRacuna;
    }

    /**
     * Postavlja vrednost atributa stavkeRacuna na novu unetu vrednost.
     * 
     * @param stavkeRacuna Stavke racuna kao ArrayList objekata klase StavkaRacuna.
     */
    public void setStavkeRacuna(ArrayList<StavkaRacuna> stavkeRacuna) {
        this.stavkeRacuna = stavkeRacuna;
    }
    
    @Override
    public String nazivTabele() {
        return " racun ";
    }

    @Override
    public String alijas() {
        return " r ";
    }

    @Override
    public String join() {
        return " JOIN poslasticar p ON (p.idPoslasticar = r.idPoslasticar) "
                + " JOIN kupac k ON (k.idKupac = r.idKupac) "
                + " JOIN mesto m ON (m.idMesto = k.idMesto) ";
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
            lista.add(r);
        }
        rs.close();
        return lista;
    }

    @Override
    public String koloneZaDodaj() {
        return " (datumIzdavanja, ukupanIznos, idPoslasticar, idKupac) ";
    }

    @Override
    public String vrednostiZaDodaj() {
        return "'" + new java.sql.Date(datumIzdavanja.getTime()) + "', " + ukupanIznos + ", "
                + poslasticar.getIdPoslasticar() + ", " + kupac.getIdKupac();
    }

    @Override
    public String vrednostiZaPromeni() {
        return " datumIzdavanja = '" + new java.sql.Date(datumIzdavanja.getTime()) + "', "
                + "ukupanIznos = " + ukupanIznos + " ";
    }

    @Override
    public String uslov() {
        return " idRacun = " + idRacun;
    }

    @Override
    public String uslovZaVrati() {
        StringBuilder sb = new StringBuilder(" WHERE 1=1 ");
        if (idRacun != null) {
            sb.append(" AND r.idRacun = ").append(idRacun);
        }
        if (poslasticar != null && poslasticar.getIdPoslasticar() != null) {
            sb.append(" AND r.idPoslasticar = ").append(poslasticar.getIdPoslasticar());
        }
        if (kupac != null && kupac.getIdKupac() != null) {
            sb.append(" AND r.idKupac = ").append(kupac.getIdKupac());
        }
        return sb.toString();
    }

}