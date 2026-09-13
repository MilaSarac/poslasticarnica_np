package rs.ac.bg.fon.ai.sistemskaOperacija;

import java.sql.SQLException;
import rs.ac.bg.fon.ai.baza.DBBroker;
import rs.ac.bg.fon.ai.domen.ApstraktniDomenskiObjekat;

/**
 * Apstraktna klasa koja predstavlja opstu sistemsku operaciju.
 * Definise zajednicki nacin izvrsavanja svih sistemskih operacija.
 * 
 * Sistemsku operaciju cine validacija prosledjenog domenskog objekta,
 * izvrsenje konkretne operacije i potvrda transakcije. Ukoliko dodje
 * do greske, transakcija se ponistava.
 * 
 * @author Mila
 */
public abstract class ApstraktnaSistemskaOperacija {
	
	 /**
     * Vrsi validaciju prosledjenog domenskog objekta pre izvrsenja sistemske operacije.
     *
     * @param ado domenski objekat koji se validira
     * @throws Exception ako prosledjeni objekat ne ispunjava uslove za izvrsenje sistemske operacije
     */
	protected abstract void validacija(ApstraktniDomenskiObjekat ado) throws Exception;

	/**
     * Izvrsava konkretnu sistemsku operaciju.
     *
     * @param ado domenski objekat nad kojim se izvrsava operacija
     * @throws Exception ako dodje do greske prilikom izvrsenja operacije
     */
    protected abstract void izvrsenje(ApstraktniDomenskiObjekat ado) throws Exception;

    /**
     * Izvrsava sistemsku operaciju.
     * 
     * Prvo se vrsi validacija prosledjenog objekta, zatim izvrsenje konkretne operacije. 
     * Ukoliko se operacija uspesno izvrsi, transakcija se potvrdjuje. U slucaju greske, 
     * transakcija se ponistava i izuzetak se ponovo prosledjuje.
     *
     * @param ado domenski objekat nad kojim se izvrsava sistemska operacija
     * @throws Exception ako dodje do greske prilikom validacije ili izvrsenja sistemske operacije
     */
    public void izvrsi(ApstraktniDomenskiObjekat ado) throws Exception {
        try {
            validacija(ado);
            izvrsenje(ado);
            commit();
        } catch (Exception e) {
            rollback();
            throw e;
        }
    }

    /**
     * Potvrdjuje promene izvrsene u okviru transakcije.
     *
     * @throws SQLException ako dodje do greske prilikom potvrde transakcije
     */
    public void commit() throws SQLException {
        DBBroker.getInstance().getConnection().commit();
    }

    /**
     * Ponistava promene izvrsene u okviru transakcije.
     *
     * @throws SQLException ako dodje do greske prilikom ponistavanja transakcije
     */
    public void rollback() throws SQLException {
        DBBroker.getInstance().getConnection().rollback();
    }
    
}
