package login;

import jBox.JBox;

/**
 *
 * @author fermani
 */
public class DialogLogin extends javax.swing.JDialog {

    JBox padre;
    
    public DialogLogin(JBox padre) {
        super(padre, true);
        this.padre = padre;
        getContentPane().add(new PnlLogin(this), java.awt.BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
    }

    public JBox getPadre() {
        return padre;
    }

}
