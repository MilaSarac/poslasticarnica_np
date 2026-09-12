package rs.ac.bg.fon.ai.domen;

import java.util.Date;
import java.util.Objects;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Klasa koja predstavlja poslasticara u poslasticarnici.
 * 
 * Poslasticar ima svoj jedinstveni identifikator koji ga jedinstveno
 * identifikuje, ime, prezime, korisnicko ime, sifru i datum zaposlenja.
 * 
 * @author Mila
 */
public class Poslasticar extends ApstraktniDomenskiObjekat{

	/**
	 * ID poslasticara kao Long vrednost.
	 */
	private Long idPoslasticar;

	/**
	 * Ime poslasticara kao String vrednost.
	 */
    private String ime;

    /**
	 * Prezime poslasticara kao String vrednost.
	 */
    private String prezime;

    /**
	 * Korisnicko ime poslasticara kao String vrednost.
	 */
    private String korisnickoIme;

    /**
	 * Sifra poslasticara kao String vrednost.
	 */
    private String sifra;

    /**
	 * Datum zaposlenja poslasticara kao Date vrednost.
	 */
    private Date datumZaposlenja;

    /**
     * Konstruktor koji inicijalizuje objekat klase Poslasticar.
     */
	public Poslasticar() {
		
	}
	
	/**
	 * Konstruktor koji inicijalizuje objekat klase Poslasticar i postavlja
	 * prosledjene vrednosti njegovim atributima.
	 * 
	 * @param idPoslasticar ID poslasticara kao Long vrednost.
	 * @param ime Ime poslasticara kao String vrednost.
	 * @param prezime Prezime poslasticara kao String vrednost.
	 * @param korisnickoIme Korisnicko ime poslasticara kao String vrednost.
	 * @param sifra Sifra poslasticara kao String vrednost.
	 * @param datumZaposlenja Datum zaposlenja poslasticara kao Date vrednost.
	 */
	public Poslasticar(Long idPoslasticar, String ime, String prezime,
			String korisnickoIme, String sifra, Date datumZaposlenja) {
		this.idPoslasticar = idPoslasticar;
	    setIme(ime);
	    setPrezime(prezime);
	    setKorisnickoIme(korisnickoIme);
	    setSifra(sifra);
	    setDatumZaposlenja(datumZaposlenja);
    }

	/**
	 * Vraca String koji predstavlja ime i prezime poslasticara.
	 * 
	 * @return ime i prezime poslasticara kao String.
	 */
    @Override
    public String toString() {
        return ime + " " + prezime;
    }
    
    /**
     * Vraca ID poslasticara.
     * 
     * @return ID poslasticara kao Long.
     */
    public Long getIdPoslasticar() {
        return idPoslasticar;
    }

    /**
     * Postavlja vrednost atributa idPoslasticar na novu unetu vrednost.
     * 
     * @param idPoslasticar ID poslasticara kao Long.
     */
    public void setIdPoslasticar(Long idPoslasticar) {
        this.idPoslasticar = idPoslasticar;
    }

    /**
     * Vraca ime poslasticara.
     * 
     * @return ime poslasticara kao String.
     */
    public String getIme() {
        return ime;
    }

    /**
     * Postavlja vrednost atributa ime na novu unetu vrednost.
     * 
     * @param ime Ime poslasticara kao String.
     * @throws java.lang.NullPointerException Ako je uneto ime null
     * @throws java.lang.IllegalArgumentException Ako je uneto ime prazno
     */
    public void setIme(String ime) {
    	if (ime == null) {
            throw new NullPointerException("Ime ne sme biti null!");
        }
        if (ime.isEmpty()) {
            throw new IllegalArgumentException("Ime ne sme biti prazno!");
        }
        this.ime = ime;
    }

    /**
     * Vraca prezime poslasticara.
     * 
     * @return prezime poslasticara kao String.
     */
    public String getPrezime() {
        return prezime;
    }

    /**
     * Postavlja vrednost atributa prezime na novu unetu vrednost.
     * 
     * @param prezime Prezime poslasticara kao String.
     * @throws java.lang.NullPointerException Ako je uneto prezime null
     * @throws java.lang.IllegalArgumentException Ako je uneto prezime prazno
     */
    public void setPrezime(String prezime) {
    	if (prezime == null) {
            throw new NullPointerException("Prezime ne sme biti null!");
        }
        if (prezime.isEmpty()) {
            throw new IllegalArgumentException("Prezime ne sme biti prazno!");
        }
        this.prezime = prezime;
    }

    /**
     * Vraca korisnicko ime poslasticara.
     * 
     * @return korisnicko ime poslasticara kao String.
     */
    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    /**
     * Postavlja vrednost atributa korisnickoIme na novu unetu vrednost.
     * 
     * @param korisnickoIme Korisnicko ime poslasticara kao String.
     * @throws java.lang.NullPointerException Ako je uneto korisnicko ime null
     * @throws java.lang.IllegalArgumentException Ako je uneto korisnicko ime prazno
     */
    public void setKorisnickoIme(String korisnickoIme) {
    	if (korisnickoIme == null) {
            throw new NullPointerException("Korisnicko ime ne sme biti null!");
        }
        if (korisnickoIme.isEmpty()) {
            throw new IllegalArgumentException("Korisnicko ime ne sme biti prazno!");
        }
        this.korisnickoIme = korisnickoIme;
    }

    /**
     * Vraca sifru poslasticara.
     * 
     * @return sifra poslasticara kao String.
     */
    public String getSifra() {
        return sifra;
    }

    /**
     * Postavlja vrednost atributa sifra na novu unetu vrednost.
     * 
     * @param sifra Sifra poslasticara kao String.
     * @throws java.lang.NullPointerException Ako je uneta sifra null
     * @throws java.lang.IllegalArgumentException Ako je uneta sifra prazna
     */
    public void setSifra(String sifra) {
    	if (sifra == null) {
            throw new NullPointerException("Sifra ne sme biti null!");
        }
        if (sifra.isEmpty()) {
            throw new IllegalArgumentException("Sifra ne sme biti prazna!");
        }
        this.sifra = sifra;
    }

    /**
     * Vraca datum zaposlenja poslasticara.
     * 
     * @return datum zaposlenja poslasticara kao Date.
     */
    public Date getDatumZaposlenja() {
        return datumZaposlenja;
    }

    /**
     * Postavlja vrednost atributa datumZaposlenja na novu unetu vrednost.
     * 
     * @param datumZaposlenja Datum zaposlenja poslasticara kao Date vrednost.
     * @throws java.lang.NullPointerException Ako je uneti datum zaposlenja null
     * @throws java.lang.IllegalArgumentException Ako je uneti datum zaposlenja
     *         posle danasnjeg datuma
     */
    public void setDatumZaposlenja(Date datumZaposlenja) {
    	if (datumZaposlenja == null) {
            throw new NullPointerException("Datum zaposlenja ne sme biti null!");
        }

        if (datumZaposlenja.after(new Date())) {
            throw new IllegalArgumentException(
                "Datum zaposlenja ne sme biti posle danasnjeg datuma!"
            );
        }

        this.datumZaposlenja = datumZaposlenja;
    }

    /**
     * Vraca hash vrednost objekta na osnovu ID-a poslasticara.
     * 
     * @return hash vrednost objekta kao int.
     */
	@Override
	public int hashCode() {
		return Objects.hash(idPoslasticar);
	}

	/**
	 * Poredi dva poslasticara po jedinstvenim identifikatorima i vraca
	 * true ili false.
	 * 
	 * @param obj Objekat sa kojim se poredi trenutni poslasticar.
	 * @return
	 * <ul>
	 * <li><b>true</b> ako su oba objekta klase Poslasticar i imaju isti ID.</li>
	 * <li><b>false</b> u svim ostalim slucajevima.</li>
	 * </ul>
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Poslasticar other = (Poslasticar) obj;
		return Objects.equals(idPoslasticar, other.idPoslasticar);
	}
	
	@Override
    public String nazivTabele() {
        return " poslasticar ";
    }

    @Override
    public String alijas() {
        return " p ";
    }

    @Override
    public String join() {
        return "";
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
            lista.add(p);
        }
        rs.close();
        return lista;
    }
    @Override
    public String koloneZaDodaj() {
        return " (ime, prezime, korisnickoIme, sifra, datumZaposlenja) ";
    }

    @Override
    public String vrednostiZaDodaj() {
        return "'" + ime + "', '" + prezime + "', '"
                + korisnickoIme + "', '" + sifra + "', '"
                + datumZaposlenja + "'";
    }

    @Override
    public String vrednostiZaPromeni() {
        return " ime = '" + ime + "', prezime = '" + prezime
                + "', korisnickoIme = '" + korisnickoIme
                + "', sifra = '" + sifra
                + "', datumZaposlenja = '" + datumZaposlenja + "' ";
    }

    @Override
    public String uslov() {
        return " idPoslasticar = " + idPoslasticar;
    }

    @Override
    public String uslovZaVrati() {
        StringBuilder sb = new StringBuilder(" WHERE 1=1 ");
        if (idPoslasticar != null) {
            sb.append(" AND p.idPoslasticar = ").append(idPoslasticar);
        }
        if (ime != null && !ime.isEmpty()) {
            sb.append(" AND p.ime LIKE '%").append(ime).append("%'");
        }
        if (prezime != null && !prezime.isEmpty()) {
            sb.append(" AND p.prezime LIKE '%").append(prezime).append("%'");
        }
        return sb.toString();
    }
    
}