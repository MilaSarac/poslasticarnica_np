package rs.ac.bg.fon.ai.domen;

import java.util.Objects;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Klasa koja predstavlja kupca u poslasticarnici.
 * 
 * Kupac ima svoj jedinstveni identifikator koji ga jedinstveno identifikuje,
 * ime, prezime, broj telefona, email i mesto.
 * 
 * @author Mila
 */
public class Kupac extends ApstraktniDomenskiObjekat{

	/**
	 * ID kupca kao Long vrednost.
	 */
	private Long idKupac;

	/**
	 * Ime kupca kao String vrednost.
	 */
    private String ime;

    /**
	 * Prezime kupca kao String vrednost.
	 */
    private String prezime;

    /**
	 * Broj telefona kupca kao String vrednost.
	 */
    private String brojTelefona;

    /**
	 * Email kupca kao String vrednost.
	 */
    private String email;

    /**
	 * Mesto kupca kao objekat klase Mesto.
	 */
    private Mesto mesto;
    
    /**
     * Konstruktor koji inicijalizuje objekat klase Kupac.
     */
    public Kupac() {

	}
    
    /**
     * Konstruktor koji inicijalizuje objekat klase Kupac i postavlja
     * prosledjene vrednosti njegovim atributima.
     * 
     * @param idKupac ID kupca kao Long vrednost.
     * @param ime Ime kupca kao String vrednost.
     * @param prezime Prezime kupca kao String vrednost.
     * @param brojTelefona Broj telefona kupca kao String vrednost.
     * @param email Email kupca kao String vrednost.
     * @param mesto Mesto kupca kao objekat klase Mesto.
     */
	public Kupac(Long idKupac, String ime, String prezime, String brojTelefona, String email, Mesto mesto) {
		this.idKupac = idKupac;
	    setIme(ime);
	    setPrezime(prezime);
	    setBrojTelefona(brojTelefona);
	    setEmail(email);
	    setMesto(mesto);
	}

	/**
	 * Vraca ID kupca.
	 * 
	 * @return ID kupca kao Long.
	 */
	public Long getIdKupac() {
		return idKupac;
	}

	/**
	 * Postavlja vrednost atributa idKupac na novu unetu vrednost.
	 * 
	 * @param idKupac ID kupca kao Long.
	 */
	public void setIdKupac(Long idKupac) {
		this.idKupac = idKupac;
	}
	
	/**
	 * Vraca ime kupca.
	 * 
	 * @return ime kupca kao String.
	 */
	public String getIme() {
		return ime;
	}

	/**
	 * Postavlja vrednost atributa ime na novu unetu vrednost.
	 * 
	 * Uneto ime ne sme biti null niti prazno.
	 * 
	 * @param ime Ime kupca kao String.
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
	 * Vraca prezime kupca.
	 * 
	 * @return prezime kupca kao String.
	 */
	public String getPrezime() {
		return prezime;
	}

	/**
	 * Postavlja vrednost atributa prezime na novu unetu vrednost.
	 * 
	 * Uneto prezime ne sme biti null niti prazno.
	 * 
	 * @param prezime Prezime kupca kao String.
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
	 * Vraca broj telefona kupca.
	 * 
	 * @return broj telefona kupca kao String.
	 */
	public String getBrojTelefona() {
		return brojTelefona;
	}

	/**
	 * Postavlja vrednost atributa brojTelefona na novu unetu vrednost.
	 * 
	 * @param brojTelefona Broj telefona kupca kao String.
	 * @throws java.lang.NullPointerException Ako je uneti broj telefona null
	 * @throws java.lang.IllegalArgumentException Ako je uneti broj telefona prazan
	 */
	public void setBrojTelefona(String brojTelefona) {
		if (brojTelefona == null) {
	        throw new NullPointerException("Broj telefona ne sme biti null!");
	    }
	    if (brojTelefona.isEmpty()) {
	        throw new IllegalArgumentException("Broj telefona ne sme biti prazan!");
	    }
	    this.brojTelefona = brojTelefona;
	}

	/**
	 * Vraca email kupca.
	 * 
	 * @return email kupca kao String.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Postavlja vrednost atributa email na novu unetu vrednost.
	 * 
	 * @param email Email kupca kao String.
	 * @throws java.lang.NullPointerException Ako je uneti email null
	 * @throws java.lang.IllegalArgumentException Ako je uneti email prazan
	 *         ili nije u odgovarajucem formatu
	 */
	public void setEmail(String email) {
		if (email == null) {
	        throw new NullPointerException("Email ne sme biti null!");
	    }
	    if (email.isEmpty()) {
	        throw new IllegalArgumentException("Email ne sme biti prazan!");
	    }
	    if (!email.contains("@")) {
	        throw new IllegalArgumentException("Email nije u odgovarajucem formatu!");
	    }
	    this.email = email;
	}

	/**
	 * Vraca mesto kupca.
	 * 
	 * @return mesto kupca kao objekat klase Mesto.
	 */
	public Mesto getMesto() {
		return mesto;
	}

	/**
	 * Postavlja vrednost atributa mesto na novu unetu vrednost.
	 * 
	 * @param mesto Mesto kupca kao objekat klase Mesto.
	 * @throws java.lang.NullPointerException Ako je uneto mesto null
	 */
	public void setMesto(Mesto mesto) {
		if (mesto == null) {
	        throw new NullPointerException("Mesto ne sme biti null!");
	    }
	    this.mesto = mesto;
	}

	/**
	 * Vraca String koji predstavlja ime i prezime kupca.
	 * 
	 * @return ime i prezime kupca kao String.
	 */
	@Override
	public String toString() {
		return ime + " " + prezime;
	}

	/**
	 * Vraca hash code na osnovu ID-a kupca.
	 * 
	 * @return hash vrednost objekta kao int.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(idKupac);
	}

	/**
	 * Poredi dva kupca po jedinstvenim identifikatorima i vraca true ili false.
	 * 
	 * @param obj Objekat sa kojim se poredi trenutni kupac.
	 * @return
	 * <ul>
	 * <li><b>true</b> ako je uneti objekat razlicit od null, ako je klase Kupac 
	 * i je ID isti kao kod prvog kupca.</li>
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
		Kupac other = (Kupac) obj;
		return Objects.equals(idKupac, other.idKupac);
	}
    
	@Override
    public String nazivTabele() {
        return " kupac ";
    }

    @Override
    public String alijas() {
        return " k ";
    }

    @Override
    public String join() {
        return " JOIN mesto m ON (m.idMesto = k.idMesto) ";
    }

    @Override
    public ArrayList<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {
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
            lista.add(k);
        }
        rs.close();
        return lista;
    }

    @Override
    public String koloneZaDodaj() {
        return " (ime, prezime, brojTelefona, email, idMesto) ";
    }

    @Override
    public String vrednostiZaDodaj() {
        return "'" + ime + "', '" + prezime + "', '" + brojTelefona + "', '"
                + email + "', " + mesto.getIdMesto();
    }

    @Override
    public String vrednostiZaPromeni() {
        return " brojtelefona = '" + brojTelefona + "', email = '" + email + "', "
                + "idMesto = " + mesto.getIdMesto() + " ";
    }

    @Override
    public String uslov() {
        return " idKupac = " + idKupac;
    }

    @Override
    public String uslovZaVrati() {
        StringBuilder sb = new StringBuilder(" WHERE 1=1 ");
        if (idKupac != null) {
            sb.append(" AND k.idKupac = ").append(idKupac);
        }
        if (ime != null && !ime.isEmpty()) {
            sb.append(" AND k.ime LIKE '%").append(ime).append("%'");
        }
        if (prezime != null && !prezime.isEmpty()) {
            sb.append(" AND k.prezime LIKE '%").append(prezime).append("%'");
        }
        if (brojTelefona != null && !brojTelefona.isEmpty()) {
            sb.append(" AND k.brojTelefona = '").append(brojTelefona).append("'");
        }
        if (email != null && !email.isEmpty()) {
            sb.append(" AND k.email = '").append(email).append("'");
        }
        if (mesto != null && mesto.getIdMesto() != null) {
            sb.append(" AND k.idMesto = ").append(mesto.getIdMesto());
        }
        return sb.toString();
    }
}
