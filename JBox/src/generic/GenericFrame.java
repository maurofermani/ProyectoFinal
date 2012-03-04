package generic;

import db.Conexion;
import jBox.JBox;
import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import utils.Console;

/**
 *
 * @author fermani
 */
public class GenericFrame extends javax.swing.JFrame {

    public static final Logger logger = Logger.getLogger(JBox.class.getName());
    private Conexion conexion;
    private Console console;

    public GenericFrame() throws IOException {
        super();

        // Conexion y loggers
        File file = new File(getClass().getResource("/log/").getPath() + "logger.log");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileHandler fh = new FileHandler(file.getAbsolutePath(), true);
        logger.addHandler(fh);
        logger.setLevel(Level.ALL);
        SimpleFormatter formatter = new SimpleFormatter();
        fh.setFormatter(formatter);
        try {
            conexion = new Conexion(this);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
            System.exit(1);
        }

        file = new File(getClass().getResource("/log/").getPath() + "loggerConsole.log");
        if (!file.exists()) {
            file.createNewFile();
        }
        Logger loggerConsole = Logger.getLogger(JBox.class.getName());
        fh = new FileHandler(file.getAbsolutePath(), true);
        loggerConsole.addHandler(fh);
        loggerConsole.setLevel(Level.ALL);
        fh.setFormatter(formatter);
        console = new Console(loggerConsole);


        try {
            UIManager.setLookAndFeel(new javax.swing.plaf.metal.MetalLookAndFeel());
        } catch (UnsupportedLookAndFeelException ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
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

    public void setConexion(Conexion conexion) {
        this.conexion = conexion;
    }

    public void msg(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }

    public void logger(Level level, String log) {
        logger.log(level, log);
    }

    public Console getConsole() {
        return console;
    }
}
