package puntoGit;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.console;

/**
 *
 * @author fermani
 */
public class PuntoGit {

    private File box;

    public PuntoGit(File carpeta) {
        this.box = carpeta;
    }

    public PuntoGit(String path) {
        this.box = new File(path);
    }

    public File getBox() {
        return box;
    }

    /**
     * Inicializa la carpeta en el ciente, y en el servidor.
     * @return verdadero si pudo realizar la operación
     */
    public boolean init() {
        try {
            int execute = console.execute("initClient " + box.getAbsolutePath());
        } catch (IOException ex) {
            Logger.getLogger(PuntoGit.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(PuntoGit.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return true;
    }
}
