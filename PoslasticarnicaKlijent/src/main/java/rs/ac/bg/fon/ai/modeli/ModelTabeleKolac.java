package rs.ac.bg.fon.ai.modeli;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import rs.ac.bg.fon.ai.domen.Kolac;

public class ModelTabeleKolac extends AbstractTableModel {

    private ArrayList<Kolac> lista;
    private String[] kolone = {"Naziv", "Cena", "Opis"};

    public ModelTabeleKolac() {
        lista = new ArrayList<>();
    }

    public ModelTabeleKolac(ArrayList<Kolac> lista) {
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

        Kolac kolac = lista.get(row);

        switch (column) {
            case 0:
                return kolac.getNaziv();

            case 1:
                return kolac.getCena();

            case 2:
                return kolac.getOpis();

            default:
                return null;
        }
    }

    public Kolac getKolac(int row) {
        return lista.get(row);
    }

    public void setLista(ArrayList<Kolac> lista) {
        this.lista = lista;
        fireTableDataChanged();
    }

    public ArrayList<Kolac> getLista() {
        return lista;
    }
}