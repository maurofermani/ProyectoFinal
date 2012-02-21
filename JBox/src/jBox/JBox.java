package jBox;

import db.Conexion;
import java.util.logging.Level;
import java.util.logging.Logger;
import login.DialogLogin;
import java.io.File;
import javax.swing.JFileChooser;
import puntoGit.PuntoGit;

/**
 *
 * @author fermani
 */
public class JBox extends generic.GenericFrame {

    private JFileChooser fileChooser;
    private PuntoGit pg;

    public JBox() {
        super();
        initComponents();
        setLocationRelativeTo(null);

//        PuntoGit pg = new PuntoGit("/home/fermani/Tesis/GIT/p30");
//        
//        pg.init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlDatos = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        pnlTitulo = new javax.swing.JPanel();
        btnAgrCarp = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        jXTable1 = new org.jdesktop.swingx.JXTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        pnlDatos.setLayout(new java.awt.BorderLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(40, 50));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 588, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        pnlDatos.add(jPanel1, java.awt.BorderLayout.SOUTH);

        pnlTitulo.setBackground(new java.awt.Color(184, 184, 255));

        btnAgrCarp.setText("Agregar Carpeta");
        btnAgrCarp.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnAgrCarp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgrCarpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTituloLayout = new javax.swing.GroupLayout(pnlTitulo);
        pnlTitulo.setLayout(pnlTituloLayout);
        pnlTituloLayout.setHorizontalGroup(
            pnlTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTituloLayout.createSequentialGroup()
                .addContainerGap(448, Short.MAX_VALUE)
                .addComponent(btnAgrCarp)
                .addContainerGap())
        );
        pnlTituloLayout.setVerticalGroup(
            pnlTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAgrCarp)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        pnlDatos.add(pnlTitulo, java.awt.BorderLayout.PAGE_START);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        pnlDatos.add(jToolBar1, java.awt.BorderLayout.LINE_END);

        jXTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jXTable1);

        pnlDatos.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlDatos, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgrCarpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgrCarpActionPerformed
        if (fileChooser == null) {
            fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        }
        int showOpenDialog = fileChooser.showDialog(this, "Compartir");
        if (showOpenDialog == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            System.out.println(file.getAbsoluteFile());
            System.out.println(file.getName());
            pg = new PuntoGit(file);
            try {
                pg.init(getConexion());
            } catch (Exception ex) {
                Logger.getLogger(JBox.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnAgrCarpActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        DialogLogin dialogLogin = new DialogLogin(this);
        dialogLogin.setVisible(true);
        if (getConexion().getUsuario() == null) {
            this.dispose();
        } else {
            
        }
    }//GEN-LAST:event_formWindowOpened

    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new JBox().setVisible(true);
            }
        });

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgrCarp;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private org.jdesktop.swingx.JXTable jXTable1;
    private javax.swing.JPanel pnlDatos;
    private javax.swing.JPanel pnlTitulo;
    // End of variables declaration//GEN-END:variables
}
