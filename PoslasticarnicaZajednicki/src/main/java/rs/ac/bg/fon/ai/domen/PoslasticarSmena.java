package rs.ac.bg.fon.ai.domen;

import java.util.Date;

public class PoslasticarSmena {

	private Poslasticar poslasticar;
    private Smena smena;
    private Date datum;

    public PoslasticarSmena() {
    }

    public PoslasticarSmena(Poslasticar poslasticar, Smena smena, Date datum) {
    	setPoslasticar(poslasticar);
        setSmena(smena);
        setDatum(datum);
    }

    public Poslasticar getPoslasticar() {
        return poslasticar;
    }

    public void setPoslasticar(Poslasticar poslasticar) {
        this.poslasticar = poslasticar;
    }

    public Smena getSmena() {
        return smena;
    }

    public void setSmena(Smena smena) {
        this.smena = smena;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
    	if (datum == null) {
            throw new NullPointerException("Datum ne sme biti null!");
        }

        this.datum = datum;
    }
}
