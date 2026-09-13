package rs.ac.bg.fon.ai.modeli;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import rs.ac.bg.fon.ai.domen.Kolac;
import rs.ac.bg.fon.ai.domen.StavkaRacuna;

public class ModelTabeleStavkaRacuna extends AbstractTableModel {

    private ArrayList<StavkaRacuna> lista;
    private String[] kolone = {"Rb", "Kolač", "Cena", "Količina", "Iznos"};
    private int rb;

    public ModelTabeleStavkaRacuna() {
        lista = new ArrayList<>();
    }

    public ModelTabeleStavkaRacuna(ArrayList<StavkaRacuna> lista) {
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    @Override
    public Object getValueAt(int row, int column) {

        StavkaRacuna stavka = lista.get(row);

        switch (column) {
            case 0:
                return stavka.getRb();

            case 1:
                return stavka.getKolac().getNaziv();

            case 2:
                return stavka.getCena();

            case 3:
                return stavka.getKolicina();

            case 4:
                return stavka.getIznos();

            default:
                return null;
        }
    }

    public boolean postojiKolac(Kolac kolac) {

        for (StavkaRacuna stavka : lista) {
            if (stavka.getKolac().getIdKolac().equals(kolac.getIdKolac())) {
                return true;
            }
        }

        return false;
    }

    public void dodajStavku(StavkaRacuna stavka) {

        rb = lista.size();
        stavka.setRb(++rb);

        lista.add(stavka);

        fireTableDataChanged();
    }

    public double vratiUkupanIznos() {

        double ukupanIznos = 0;

        for (StavkaRacuna stavka : lista) {
            ukupanIznos += stavka.getIznos();
        }

        return ukupanIznos;
    }

    public void obrisiStavku(int row) {

        lista.remove(row);

        rb = 0;

        for (StavkaRacuna stavka : lista) {
            stavka.setRb(++rb);
        }

        fireTableDataChanged();
    }

    public ArrayList<StavkaRacuna> getLista() {
        return lista;
    }
}
