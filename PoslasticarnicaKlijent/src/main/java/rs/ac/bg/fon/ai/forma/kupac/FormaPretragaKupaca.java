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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

import rs.ac.bg.fon.ai.domen.Kupac;
import rs.ac.bg.fon.ai.domen.Mesto;
import rs.ac.bg.fon.ai.kontroler.KlijentKontroler;
import rs.ac.bg.fon.ai.modeli.ModelTabeleKupac;

public class FormaPretragaKupaca extends JDialog {

    private static final long serialVersionUID = 1L;

    private JLabel lblPretraga;
    private JLabel lblMesto;

    private JTextField txtPretraga;

    private JComboBox<Object> cmbMesto;

    private JButton btnPretrazi;
    private JButton btnDetalji;
    private JButton btnZatvori;

    private JTable tblKupci;
    private JScrollPane jScrollPane1;

    public FormaPretragaKupaca(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        initComponents();

        setLocationRelativeTo(null);
        setTitle("Pretraga kupaca");

        ModelTabeleKupac model = new ModelTabeleKupac();
        tblKupci.setModel(model);

        Thread nit = new Thread(model);
        nit.start();

        popuniMesta();
    }

    private void initComponents() {

        lblPretraga = new JLabel();
        lblMesto = new JLabel();

        txtPretraga = new JTextField();

        cmbMesto = new JComboBox<>();

        btnPretrazi = new JButton();
        btnDetalji = new JButton();
        btnZatvori = new JButton();

        tblKupci = new JTable();
        jScrollPane1 = new JScrollPane();

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        lblPretraga.setText("Pretraga (ime i/ili prezime):");
        lblMesto.setText("Pretraga po mestu:");

        btnPretrazi.setText("Pretrazi");

        btnPretrazi.addActionListener(
                new java.awt.event.ActionListener() {
                    @Override
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnPretraziActionPerformed(evt);
                    }
                });

        btnDetalji.setText("Detalji o kupcu");

        btnDetalji.addActionListener(
                new java.awt.event.ActionListener() {
                    @Override
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnDetaljiActionPerformed(evt);
                    }
                });

        btnZatvori.setText("Zatvori");

        btnZatvori.addActionListener(
                new java.awt.event.ActionListener() {
                    @Override
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        dispose();
                    }
                });

        jScrollPane1.setViewportView(tblKupci);

        GroupLayout layout =
                new GroupLayout(getContentPane());

        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
                layout.createParallelGroup(
                        GroupLayout.Alignment.LEADING)

                .addGroup(
                        layout.createSequentialGroup()
                                .addGap(20, 20, 20)

                                .addGroup(
                                        layout.createParallelGroup(
                                                GroupLayout.Alignment.LEADING)

                                                .addComponent(lblPretraga)
                                                .addComponent(lblMesto)
                                )

                                .addGap(15, 15, 15)

                                .addGroup(
                                        layout.createParallelGroup(
                                                GroupLayout.Alignment.LEADING)

                                                .addComponent(
                                                        txtPretraga,
                                                        GroupLayout.PREFERRED_SIZE,
                                                        420,
                                                        GroupLayout.PREFERRED_SIZE)

                                                .addComponent(
                                                        cmbMesto,
                                                        GroupLayout.PREFERRED_SIZE,
                                                        250,
                                                        GroupLayout.PREFERRED_SIZE)
                                )

                                .addGap(20, 20, 20)

                                .addComponent(
                                        btnPretrazi,
                                        GroupLayout.PREFERRED_SIZE,
                                        120,
                                        GroupLayout.PREFERRED_SIZE)

                                .addContainerGap(
                                        20,
                                        Short.MAX_VALUE)
                )

                .addGroup(
                        layout.createSequentialGroup()
                                .addGap(20, 20, 20)

                                .addComponent(
                                        jScrollPane1,
                                        GroupLayout.DEFAULT_SIZE,
                                        800,
                                        Short.MAX_VALUE)

                                .addGap(20, 20, 20)
                )

                .addGroup(
                        layout.createSequentialGroup()

                                .addGap(220, 220, 220)

                                .addComponent(btnZatvori)

                                .addPreferredGap(
                                        LayoutStyle.ComponentPlacement.RELATED,
                                        200,
                                        Short.MAX_VALUE)

                                .addComponent(btnDetalji)

                                .addGap(220, 220, 220)
                )
        );

        layout.setVerticalGroup(
                layout.createParallelGroup(
                        GroupLayout.Alignment.LEADING)

                .addGroup(
                        layout.createSequentialGroup()

                                .addGap(20, 20, 20)

                                .addGroup(
                                        layout.createParallelGroup(
                                                GroupLayout.Alignment.BASELINE)

                                                .addComponent(lblPretraga)

                                                .addComponent(
                                                        txtPretraga,
                                                        GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE,
                                                        GroupLayout.PREFERRED_SIZE)

                                                .addComponent(btnPretrazi)
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

                                .addGap(20, 20, 20)

                                .addComponent(
                                        jScrollPane1,
                                        GroupLayout.PREFERRED_SIZE,
                                        180,
                                        GroupLayout.PREFERRED_SIZE)

                                .addGap(20, 20, 20)

                                .addGroup(
                                        layout.createParallelGroup(
                                                GroupLayout.Alignment.BASELINE)

                                                .addComponent(btnZatvori)
                                                .addComponent(btnDetalji)
                                )

                                .addGap(20, 20, 20)
                )
        );

        pack();
    }

    private void btnPretraziActionPerformed(java.awt.event.ActionEvent evt) {

        String parametar = txtPretraga.getText();

        ModelTabeleKupac model = (ModelTabeleKupac) tblKupci.getModel();

        model.setParametar(parametar);

        if (model.getLista().isEmpty()) {
            JOptionPane.showMessageDialog(this,"Sistem ne moze da nadje kupce po zadatim kriterijumima.");
        } else {
        	JOptionPane.showMessageDialog(this,"Sistem je nasao kupce po zadatim kriterijumima.");
        }
    }

    private void btnDetaljiActionPerformed(java.awt.event.ActionEvent evt) {

        int row = tblKupci.getSelectedRow();

        if (row >= 0) {

            ModelTabeleKupac model = (ModelTabeleKupac) tblKupci.getModel();

            Kupac kupac = model.getSelectedKupac(row);
            
            JOptionPane.showMessageDialog(this,"Sistem je nasao kupca.");

            new FormaDetaljiKupca(this,true,kupac).setVisible(true);

        } else {
            JOptionPane.showMessageDialog(this,"Morate izabrati kupca iz tabele.");
        }
    }

    private void popuniMesta() {

        try {

            ArrayList<Mesto> mesta = KlijentKontroler.getInstance().vratiSvaMesta();

            cmbMesto.removeAllItems();

            cmbMesto.addItem("Svi");

            for (Mesto mesto : mesta) {
                cmbMesto.addItem(mesto);
            }

            cmbMesto.addItemListener(new java.awt.event.ItemListener() {

                        @Override
                        public void itemStateChanged(java.awt.event.ItemEvent evt) {

                            if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {

                                Object selected = cmbMesto.getSelectedItem();

                                ModelTabeleKupac model = (ModelTabeleKupac) tblKupci.getModel();

                                if (selected instanceof Mesto) {
                                    model.setMesto((Mesto) selected);
                                } else {
                                    model.setMesto(null);
                                }
                            }
                        }
                    });
        } catch (Exception ex) {
            Logger.getLogger(FormaPretragaKupaca.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    public void refreshTable() {

        ModelTabeleKupac model = (ModelTabeleKupac) tblKupci.getModel();
        model.refreshTable();
        
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        FormaPretragaKupaca dialog = new FormaPretragaKupaca(new javax.swing.JFrame(),true);
                        dialog.setVisible(true);
                    }
                }
        );
    }
}