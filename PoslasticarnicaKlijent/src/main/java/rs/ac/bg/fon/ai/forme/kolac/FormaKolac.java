package rs.ac.bg.fon.ai.forme.kolac;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import rs.ac.bg.fon.ai.domen.Kolac;
import rs.ac.bg.fon.ai.kontroler.KlijentKontroler;
import rs.ac.bg.fon.ai.modeli.ModelTabeleKolac;

import javax.swing.GroupLayout.Alignment;

import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FormaKolac extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel pnlKolaci;

    private JLabel lblPretraga;
    private JTextField txtPretraga;
    private JButton btnPretrazi;

    private JLabel lblNaziv;
    private JTextField txtNaziv;

    private JLabel lblCena;
    private JTextField txtCena;

    private JLabel lblOpis;
    private JTextField txtOpis;

    private JButton btnDodaj;
    private JButton btnIzmeni;
    private JButton btnObrisi;

    private JScrollPane scrollPane;
    private JTable tblKolaci;
    
    private Kolac izabraniKolac;

    public FormaKolac() {
        initialize();
        setLocationRelativeTo(null);
        tblKolaci.setModel(new ModelTabeleKolac());
        popuniTabelu();
    }

    private void initialize() {

        setTitle("Kolaci");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 746, 791);

        pnlKolaci = new JPanel();
        pnlKolaci.setBorder(new TitledBorder(null, "Kolaci", TitledBorder.LEADING, TitledBorder.TOP, null, null));

        setContentPane(pnlKolaci);

        lblPretraga = new JLabel("Pretraga po nazivu:");

        txtPretraga = new JTextField();
        txtPretraga.setColumns(10);

        btnPretrazi = new JButton("Pretraži");

        lblNaziv = new JLabel("Naziv:");

        txtNaziv = new JTextField();
        txtNaziv.setColumns(10);

        lblCena = new JLabel("Cena:");

        txtCena = new JTextField();
        txtCena.setColumns(10);

        lblOpis = new JLabel("Opis:");

        txtOpis = new JTextField();
        txtOpis.setColumns(10);

        btnDodaj = new JButton("Dodaj");

        btnDodaj.addActionListener(e -> {
            btnDodajActionPerformed();
        });

        btnIzmeni = new JButton("Izmeni");

        btnIzmeni.addActionListener(e -> {
            btnIzmeniActionPerformed();
        });

        btnObrisi = new JButton("Obriši");

        btnObrisi.addActionListener(e -> {
            btnObrisiActionPerformed();
        });

        btnPretrazi.addActionListener(e -> {
            btnPretraziActionPerformed();
        });

        scrollPane = new JScrollPane();

        tblKolaci = new JTable();
        tblKolaci.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		tblKolaciMouseClicked(e);
        	}
        });

        tblKolaci.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "Naziv", "Cena", "Opis"
                }
        ));

        scrollPane.setViewportView(tblKolaci);

        javax.swing.GroupLayout layout =
                new javax.swing.GroupLayout(pnlKolaci);
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(30)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(8)
        					.addComponent(scrollPane))
        				.addGroup(Alignment.LEADING, layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(lblNaziv)
        						.addComponent(lblCena)
        						.addComponent(lblOpis))
        					.addGap(35)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(txtNaziv)
        						.addComponent(txtOpis)
        						.addComponent(txtCena, GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE)
        						.addComponent(btnDodaj, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)))
        				.addGroup(Alignment.LEADING, layout.createSequentialGroup()
        					.addComponent(lblPretraga)
        					.addGap(18)
        					.addComponent(txtPretraga, GroupLayout.PREFERRED_SIZE, 337, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(btnPretrazi, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        			.addGap(300))
        		.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
        			.addGap(325)
        			.addComponent(btnIzmeni, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
        			.addGap(45)
        			.addComponent(btnObrisi, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
        			.addGap(317))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(25)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblPretraga)
        				.addComponent(txtPretraga, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btnPretrazi))
        			.addGap(25)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblNaziv)
        				.addComponent(txtNaziv, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(15)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblCena)
        				.addComponent(txtCena, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(15)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblOpis)
        				.addComponent(txtOpis, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(btnDodaj)
        			.addGap(14)
        			.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
        			.addGap(26)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btnIzmeni)
        				.addComponent(btnObrisi))
        			.addContainerGap(225, Short.MAX_VALUE))
        );

        pnlKolaci.setLayout(layout);
    }

    private void btnDodajActionPerformed() {
        try {
            String naziv = txtNaziv.getText();
            String opis = txtOpis.getText();

            if (naziv.isEmpty() || txtCena.getText().isEmpty() || opis.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Morate popuniti sva polja!");
                return;
            }

            double cena = Double.parseDouble(txtCena.getText());

            Kolac kolac = new Kolac(
                    null,
                    naziv,
                    cena,
                    opis
            );

            KlijentKontroler.getInstance().dodajKolac(kolac);

            JOptionPane.showMessageDialog(this, "Kolač je uspešno dodat!");

            popuniTabelu();

            txtNaziv.setText("");
            txtCena.setText("");
            txtOpis.setText("");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Cena mora biti broj!");

        } catch (Exception ex) { 
        	JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    private void btnIzmeniActionPerformed() {

        try {

            if (izabraniKolac == null) {
                JOptionPane.showMessageDialog(this, "Morate izabrati kolač iz tabele!");
                return;
            }

            if (txtCena.getText().isEmpty() || txtOpis.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Morate popuniti sva polja!");
                return;
            }

            double cena = Double.parseDouble(txtCena.getText());

            izabraniKolac.setCena(cena);
            izabraniKolac.setOpis(txtOpis.getText());

            KlijentKontroler.getInstance().izmeniKolac(izabraniKolac);

            JOptionPane.showMessageDialog(this, "Kolač je uspešno izmenjen!");

            popuniTabelu();

            txtNaziv.setText("");
            txtCena.setText("");
            txtOpis.setText("");

            txtNaziv.setEditable(true);

            izabraniKolac = null;

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Cena mora biti broj!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    private void btnObrisiActionPerformed() {
        try {

            if (izabraniKolac == null) {
                JOptionPane.showMessageDialog(this, "Morate izabrati kolač iz tabele!");
                return;
            }

            int odgovor = JOptionPane.showConfirmDialog(
                    this,
                    "Da li ste sigurni da zelite da obrišete izabrani kolač?",
                    "Potvrda",
                    JOptionPane.YES_NO_OPTION
            );

            if (odgovor != JOptionPane.YES_OPTION) {
                return;
            }

            KlijentKontroler.getInstance().obrisiKolac(izabraniKolac);
            JOptionPane.showMessageDialog(this, "Kolač je uspešno obrisan!");

            popuniTabelu();

            txtNaziv.setText("");
            txtCena.setText("");
            txtOpis.setText("");

            txtNaziv.setEditable(true);

            izabraniKolac = null;

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    private void btnPretraziActionPerformed() {

        try {

            String naziv = txtPretraga.getText();

            Kolac kriterijum = new Kolac();
            kriterijum.setNaziv(naziv);

            ArrayList<Kolac> kolaci = KlijentKontroler.getInstance().pretraziKolace(kriterijum);

            ModelTabeleKolac model = (ModelTabeleKolac) tblKolaci.getModel();
            model.setLista(kolaci);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,ex.getMessage());
        }
    }
    
    private void popuniTabelu() {
        try {
            ArrayList<Kolac> kolaci = KlijentKontroler.getInstance().vratiSveKolace();

            ModelTabeleKolac model = (ModelTabeleKolac) tblKolaci.getModel();

            model.setLista(kolaci);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private void tblKolaciMouseClicked(java.awt.event.MouseEvent evt) {

        int selektovaniRed = tblKolaci.getSelectedRow();

        if (selektovaniRed == -1) {
            return;
        }

        ModelTabeleKolac model = (ModelTabeleKolac) tblKolaci.getModel();

        izabraniKolac = model.getKolac(selektovaniRed);

        txtNaziv.setText(izabraniKolac.getNaziv());
        txtCena.setText(String.valueOf(izabraniKolac.getCena()));
        txtOpis.setText(izabraniKolac.getOpis());

        txtNaziv.setEditable(false);
    }
}
