package rs.ac.bg.fon.ai.forma.kupac;

import java.awt.EventQueue;
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

public class FormaNoviKupac extends JDialog {

    private static final long serialVersionUID = 1L;

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

    private JButton btnDodaj;
    private JButton btnZatvori;

    public FormaNoviKupac(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        initComponents();

        setLocationRelativeTo(null);
        setTitle("Unos kupca");

        popuniMesta();
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

        btnDodaj = new JButton();
        btnZatvori = new JButton();

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        lblIme.setText("Ime:");
        lblPrezime.setText("Prezime:");
        lblEmail.setText("Email:");
        lblBrojTelefona.setText("Broj telefona:");
        lblMesto.setText("Mesto:");

        btnDodaj.setText("Dodaj");

        btnDodaj.addActionListener(
                new java.awt.event.ActionListener() {

                    @Override
                    public void actionPerformed(
                            java.awt.event.ActionEvent evt) {

                        btnDodajActionPerformed(evt);
                    }
                });

        btnZatvori.setText("Zatvori");

        btnZatvori.addActionListener(
                new java.awt.event.ActionListener() {

                    @Override
                    public void actionPerformed(
                            java.awt.event.ActionEvent evt) {

                        btnZatvoriActionPerformed(evt);
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

                                                .addComponent(
                                                        txtPrezime)

                                                .addComponent(
                                                        txtEmail)

                                                .addComponent(
                                                        txtBrojTelefona)

                                                .addComponent(
                                                        cmbMesto,
                                                        0,
                                                        GroupLayout.DEFAULT_SIZE,
                                                        Short.MAX_VALUE)
                                )

                                .addContainerGap(
                                        25,
                                        Short.MAX_VALUE)
                )

                .addGroup(
                        layout.createSequentialGroup()
                                .addGap(70, 70, 70)

                                .addComponent(btnZatvori)

                                .addPreferredGap(
                                        LayoutStyle.ComponentPlacement.RELATED,
                                        120,
                                        Short.MAX_VALUE)

                                .addComponent(btnDodaj)

                                .addGap(70, 70, 70)
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
                                                .addComponent(btnDodaj)
                                )

                                .addGap(20, 20, 20)
                )
        );

        pack();
    }

    private void btnDodajActionPerformed(
            java.awt.event.ActionEvent evt) {

        try {

            if (txtIme.getText().isEmpty()
                    || txtPrezime.getText().isEmpty()
                    || txtEmail.getText().isEmpty()
                    || txtBrojTelefona.getText().isEmpty()
                    || cmbMesto.getSelectedItem() == null) {

                JOptionPane.showMessageDialog(
                        this,
                        "Sva polja moraju biti popunjena!"
                );

                return;
            }

            String ime =
                    txtIme.getText();

            String prezime =
                    txtPrezime.getText();

            String brojTelefona =
                    txtBrojTelefona.getText();

            String email =
                    txtEmail.getText();

            Mesto mesto =
                    (Mesto) cmbMesto.getSelectedItem();

            Kupac kupac =
                    new Kupac(
                            null,
                            ime,
                            prezime,
                            brojTelefona,
                            email,
                            mesto
                    );

            KlijentKontroler
                    .getInstance()
                    .dodajKupca(kupac);

            JOptionPane.showMessageDialog(
                    this,
                    "Sistem je zapamtio kupca."
            );

            dispose();

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Sistem ne moze da zapamti kupca.\n"
                            + ex.getMessage()
            );

            Logger.getLogger(
                    FormaNoviKupac.class.getName())
                    .log(
                            Level.SEVERE,
                            null,
                            ex
                    );
        }
    }

    private void btnZatvoriActionPerformed(
            java.awt.event.ActionEvent evt) {

        dispose();
    }

    private void popuniMesta() {

        try {

            ArrayList<Mesto> mesta =
                    KlijentKontroler
                            .getInstance()
                            .vratiSvaMesta();

            cmbMesto.removeAllItems();

            for (Mesto mesto : mesta) {
                cmbMesto.addItem(mesto);
            }

        } catch (Exception ex) {

            Logger.getLogger(
                    FormaNoviKupac.class.getName())
                    .log(
                            Level.SEVERE,
                            null,
                            ex
                    );
        }
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(
                new Runnable() {

                    @Override
                    public void run() {

                        FormaNoviKupac dialog =
                                new FormaNoviKupac(
                                        new javax.swing.JFrame(),
                                        true
                                );

                        dialog.setVisible(true);
                    }
                }
        );
    }
}
