package generic;

import db.Conexion;
import jBox.JBox;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UnsupportedLookAndFeelException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author fermani
 */
public class GenericFrame extends javax.swing.JFrame {

    private Conexion conexion;

    public GenericFrame() {
        super();
        try {
            conexion = new Conexion();
        } catch (Exception ex) {
            Logger.getLogger(GenericFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            UIManager.setLookAndFeel(new javax.swing.plaf.metal.MetalLookAndFeel());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(JBox.class.getName()).log(Level.SEVERE, null, ex);
        }
//        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    public Conexion getConexion() {
        return conexion;
    }

    public void setConexion(Conexion     conexion) {
        this.conexion = conexion;
    }

    public void msg(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }
}
