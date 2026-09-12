package rs.ac.bg.fon.ai.sistemskaOperacija;

import java.sql.SQLException;
import rs.ac.bg.fon.ai.baza.DBBroker;
import rs.ac.bg.fon.ai.domen.ApstraktniDomenskiObjekat;

public abstract class ApstraktnaSistemskaOperacija {
	
	protected abstract void validacija(ApstraktniDomenskiObjekat ado) throws Exception;

    protected abstract void izvrsenje(ApstraktniDomenskiObjekat ado) throws Exception;

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

    public void commit() throws SQLException {
        DBBroker.getInstance().getConnection().commit();
    }

    public void rollback() throws SQLException {
        DBBroker.getInstance().getConnection().rollback();
    }
    
}
