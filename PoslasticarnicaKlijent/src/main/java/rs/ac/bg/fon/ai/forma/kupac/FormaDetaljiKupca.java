package rs.ac.bg.fon.ai.forma.kupac;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

import rs.ac.bg.fon.ai.domen.Kupac;
import rs.ac.bg.fon.ai.domen.Mesto;
import rs.ac.bg.fon.ai.kontroler.KlijentKontroler;

public class FormaDetaljiKupca extends JDialog {

    private static final long serialVersionUID = 1L;

    private Kupac kupac;

    private JLabel lblIme;
    private JLabel lblPrezime;
    private JLabel lblEmail;
    private JLabel lblBrojTelefona;
    private JLabel lblMesto;

    private JTextField txtIme;
    private JTextField txtPrezime;
    private JTextField txtEmail;
    private JTextField txtBrojTelefona;

    private JComboBox<Mesto> cmbMesto;

    private JButton btnZatvori;
    private JButton btnObrisi;
    private JButton btnPromeni;

    public FormaDetaljiKupca(FormaPretragaKupaca parent, boolean modal, Kupac kupac) {

        super(parent, modal);

        this.kupac = kupac;

        initComponents();

        setLocationRelativeTo(null);
        setTitle("Detalji o kupcu");

        txtIme.setEditable(false);
        txtPrezime.setEditable(false);

        popuniMesta();
        popuniPodatke();
    }

    private void initComponents() {

        lblIme = new JLabel();
        lblPrezime = new JLabel();
        lblEmail = new JLabel();
        lblBrojTelefona = new JLabel();
        lblMesto = new JLabel();

        txtIme = new JTextField();
        txtPrezime = new JTextField();
        txtEmail = new JTextField();
        txtBrojTelefona = new JTextField();

        cmbMesto = new JComboBox<>();

        btnZatvori = new JButton();
        btnObrisi = new JButton();
        btnPromeni = new JButton();

        setDefaultCloseOperation(
                JDialog.DISPOSE_ON_CLOSE
        );

        lblIme.setText("Ime:");
        lblPrezime.setText("Prezime:");
        lblEmail.setText("Email:");
        lblBrojTelefona.setText("Broj telefona:");
        lblMesto.setText("Mesto:");

        btnZatvori.setText("Zatvori");

        btnZatvori.addActionListener(
                new java.awt.event.ActionListener() {

                    @Override
                    public void actionPerformed(
                            java.awt.event.ActionEvent evt) {

                        dispose();
                    }
                });

        btnObrisi.setText("Obrisi");

        btnObrisi.addActionListener(
                new java.awt.event.ActionListener() {

                    @Override
                    public void actionPerformed(
                            java.awt.event.ActionEvent evt) {

                        btnObrisiActionPerformed(evt);
                    }
                });

        btnPromeni.setText("Promeni");

        btnPromeni.addActionListener(
                new java.awt.event.ActionListener() {

                    @Override
                    public void actionPerformed(
                            java.awt.event.ActionEvent evt) {

                        btnPromeniActionPerformed(evt);
                    }
                });

        GroupLayout layout =
                new GroupLayout(getContentPane());

        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
                layout.createParallelGroup(
                        GroupLayout.Alignment.LEADING)

                .addGroup(
                        layout.createSequentialGroup()

                                .addGap(25, 25, 25)

                                .addGroup(
                                        layout.createParallelGroup(
                                                GroupLayout.Alignment.LEADING)

                                                .addComponent(lblIme)
                                                .addComponent(lblPrezime)
                                                .addComponent(lblEmail)
                                                .addComponent(lblBrojTelefona)
                                                .addComponent(lblMesto)
                                )

                                .addGap(30, 30, 30)

                                .addGroup(
                                        layout.createParallelGroup(
                                                GroupLayout.Alignment.LEADING,
                                                false)

                                                .addComponent(
                                                        txtIme,
                                                        GroupLayout.DEFAULT_SIZE,
                                                        250,
                                                        Short.MAX_VALUE)

                                                .addComponent(txtPrezime)
                                                .addComponent(txtEmail)
                                                .addComponent(txtBrojTelefona)

                                                .addComponent(
                                                        cmbMesto,
                                                        0,
                                                        GroupLayout.DEFAULT_SIZE,
                                                        Short.MAX_VALUE)
                                )

                                .addGap(25, 25, 25)
                )

                .addGroup(
                        layout.createSequentialGroup()

                                .addGap(45, 45, 45)

                                .addComponent(btnZatvori)

                                .addPreferredGap(
                                        LayoutStyle.ComponentPlacement.RELATED,
                                        70,
                                        Short.MAX_VALUE)

                                .addComponent(btnObrisi)

                                .addGap(70, 70, 70)

                                .addComponent(btnPromeni)

                                .addGap(45, 45, 45)
                )
        );

        layout.setVerticalGroup(
                layout.createParallelGroup(
                        GroupLayout.Alignment.LEADING)

                .addGroup(
                        layout.createSequentialGroup()

                                .addGap(25, 25, 25)

                                .addGroup(
                                        layout.createParallelGroup(
                                                GroupLayout.Alignment.BASELINE)

                                                .addComponent(lblIme)

                                                .addComponent(
                                                        txtIme,
                                                        GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE,
                                                        GroupLayout.PREFERRED_SIZE)
                                )

                                .addPreferredGap(
                                        LayoutStyle.ComponentPlacement.UNRELATED)

                                .addGroup(
                                        layout.createParallelGroup(
                                                GroupLayout.Alignment.BASELINE)

                                                .addComponent(lblPrezime)

                                                .addComponent(
                                                        txtPrezime,
                                                        GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE,
                                                        GroupLayout.PREFERRED_SIZE)
                                )

                                .addPreferredGap(
                                        LayoutStyle.ComponentPlacement.UNRELATED)

                                .addGroup(
                                        layout.createParallelGroup(
                                                GroupLayout.Alignment.BASELINE)

                                                .addComponent(lblEmail)

                                                .addComponent(
                                                        txtEmail,
                                                        GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE,
                                                        GroupLayout.PREFERRED_SIZE)
                                )

                                .addPreferredGap(
                                        LayoutStyle.ComponentPlacement.UNRELATED)

                                .addGroup(
                                        layout.createParallelGroup(
                                                GroupLayout.Alignment.BASELINE)

                                                .addComponent(lblBrojTelefona)

                                                .addComponent(
                                                        txtBrojTelefona,
                                                        GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE,
                                                        GroupLayout.PREFERRED_SIZE)
                                )

                                .addPreferredGap(
                                        LayoutStyle.ComponentPlacement.UNRELATED)

                                .addGroup(
                                        layout.createParallelGroup(
                                                GroupLayout.Alignment.BASELINE)

                                                .addComponent(lblMesto)

                                                .addComponent(
                                                        cmbMesto,
                                                        GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE,
                                                        GroupLayout.PREFERRED_SIZE)
                                )

                                .addGap(25, 25, 25)

                                .addGroup(
                                        layout.createParallelGroup(
                                                GroupLayout.Alignment.BASELINE)

                                                .addComponent(btnZatvori)
                                                .addComponent(btnObrisi)
                                                .addComponent(btnPromeni)
                                )

                                .addGap(20, 20, 20)
                )
        );

        pack();
    }

    private void popuniPodatke() {

        txtIme.setText(kupac.getIme());

        txtPrezime.setText(kupac.getPrezime());

        txtEmail.setText(kupac.getEmail());

        txtBrojTelefona.setText(kupac.getBrojTelefona());

        selektujMesto();
    }

    private void popuniMesta() {

        try {

            ArrayList<Mesto> mesta = KlijentKontroler.getInstance().vratiSvaMesta();

            cmbMesto.removeAllItems();

            for (Mesto mesto : mesta) {

                cmbMesto.addItem(mesto);
            }

        } catch (Exception ex) {

            Logger.getLogger(FormaDetaljiKupca.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    private void selektujMesto() {

        if (kupac.getMesto() == null) {
            return;
        }

        for (int i = 0; i < cmbMesto.getItemCount(); i++) {

            Mesto mesto = cmbMesto.getItemAt(i);

            if (mesto != null && mesto.getIdMesto() != null && 
            		mesto.getIdMesto().equals(kupac.getMesto().getIdMesto())) {
            	
                cmbMesto.setSelectedIndex(i);
                break;
            }
        }
    }

    private void btnPromeniActionPerformed(
            java.awt.event.ActionEvent evt) {

        try {

            if (txtEmail.getText().isEmpty()
                    || txtBrojTelefona.getText().isEmpty()
                    || cmbMesto.getSelectedItem() == null) {

                JOptionPane.showMessageDialog(this, "Sva polja moraju biti popunjena!");

                return;
            }

            String email = txtEmail.getText();

            String brojTelefona = txtBrojTelefona.getText();

            Mesto mesto = (Mesto) cmbMesto.getSelectedItem();

            kupac.setEmail(email);

            kupac.setBrojTelefona(brojTelefona);

            kupac.setMesto(mesto);

            KlijentKontroler.getInstance().promeniKupca(kupac);

            FormaPretragaKupaca parent = (FormaPretragaKupaca) getParent();

            parent.refreshTable();

            JOptionPane.showMessageDialog(this,"Sistem je zapamtio kupca.");

            dispose();

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(this,"Sistem ne moze da zapamti kupca.\n"+ ex.getMessage());

            Logger.getLogger(FormaDetaljiKupca.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    private void btnObrisiActionPerformed(
            java.awt.event.ActionEvent evt) {

        int rezultat =
                JOptionPane.showConfirmDialog(
                        this,
                        "Da li ste sigurni da zelite da obrisete ovog kupca?",
                        "Potvrda",
                        JOptionPane.YES_NO_OPTION
                );

        if (rezultat != JOptionPane.YES_OPTION) {
            return;
        }

        try {

            KlijentKontroler.getInstance().obrisiKupca(kupac);

            FormaPretragaKupaca parent = (FormaPretragaKupaca) getParent();

            parent.refreshTable();

            JOptionPane.showMessageDialog(this,"Sistem je obrisao kupca.");

            dispose();

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(this,"Sistem ne moze da obrise kupca.\n"+ ex.getMessage());
            Logger.getLogger(FormaDetaljiKupca.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
}