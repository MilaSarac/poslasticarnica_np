package rs.ac.bg.fon.ai.modeli;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.table.AbstractTableModel;

import rs.ac.bg.fon.ai.domen.Kupac;
import rs.ac.bg.fon.ai.domen.Mesto;
import rs.ac.bg.fon.ai.kontroler.KlijentKontroler;

public class ModelTabeleKupac extends AbstractTableModel implements Runnable {

    private ArrayList<Kupac> lista;

    private final String[] kolone = {
        "ID",
        "Ime",
        "Prezime",
        "Broj telefona",
        "Email",
        "Mesto"
    };

    private String parametar = "";
    private Mesto mesto;

    public ModelTabeleKupac() {

        lista = new ArrayList<>();

        try {

            lista = KlijentKontroler.getInstance()
                    .pretraziKupce(new Kupac());

        } catch (Exception ex) {

            Logger.getLogger(ModelTabeleKupac.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
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

        Kupac kupac = lista.get(row);

        switch (column) {

            case 0:
                return kupac.getIdKupac();

            case 1:
                return kupac.getIme();

            case 2:
                return kupac.getPrezime();

            case 3:
                return kupac.getBrojTelefona();

            case 4:
                return kupac.getEmail();

            case 5:
                return kupac.getMesto();

            default:
                return null;
        }
    }

    public Kupac getSelectedKupac(int row) {
        return lista.get(row);
    }

    @Override
    public void run() {

        try {

            while (!Thread.currentThread().isInterrupted()) {

                Thread.sleep(10000);
                refreshTable();
            }

        } catch (InterruptedException ex) {

            Logger.getLogger(ModelTabeleKupac.class.getName())
                    .log(Level.SEVERE, null, ex);

            Thread.currentThread().interrupt();
        }
    }

    public void setParametar(String parametar) {

        this.parametar = parametar;
        refreshTable();
    }

    public void setMesto(Mesto mesto) {

        this.mesto = mesto;
        refreshTable();
    }

    public void refreshTable() {

        try {

            Kupac kriterijum = new Kupac();

            if (mesto != null) {
                kriterijum.setMesto(mesto);
            }

            lista = KlijentKontroler.getInstance()
                    .pretraziKupce(kriterijum);

            if (parametar != null && !parametar.isEmpty()) {

                ArrayList<Kupac> novaLista = new ArrayList<>();

                for (Kupac kupac : lista) {

                    if (kupac.getIme().toLowerCase()
                            .contains(parametar.toLowerCase())
                            || kupac.getPrezime().toLowerCase()
                                    .contains(parametar.toLowerCase())) {

                        novaLista.add(kupac);
                    }
                }

                lista = novaLista;
            }

            fireTableDataChanged();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Kupac> getLista() {
        return lista;
    }
}
