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
    
    public void setBox(String path) {
        this.box = new File(path);
    }
    
    public void setBox(File box) {
        this.box = box;
    }

    public File getBox() {
        return box;
    }

    /**
     * Inicializa la carpeta en el ciente, y en el servidor.
     * @return verdadero si pudo realizar la operación
     */
    public boolean init() {
        int execute;
        try {
            
            //creo e inicializo la carpeta en el servidor
            execute = console.execute("initServer " + box.getName());

            //inicializo la carpeta del cliente
            execute = console.execute("initClient " + box.getAbsolutePath() + " " + box.getName());
            
            this.pushAll();       
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(PuntoGit.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (InterruptedException ex) {
            Logger.getLogger(PuntoGit.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        return true;
    }
    
    public boolean add(String path) {
        int execute;
        try {
            
            //agrego el o los archivos modificados
            execute = console.execute("git add " + path);
            
        } catch (IOException ex) {
            Logger.getLogger(PuntoGit.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (InterruptedException ex) {
            Logger.getLogger(PuntoGit.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        return true;
    }
    
    /**
     * Agrega los cambios y realiza un push al servidor
     * @return verdadero si la operación se realizó con éxito
     */
    public boolean pushAll() {
        int execute;
        try {
            execute = console.execute("push \"algo nuevo\" " + box.getAbsolutePath());
            
        } catch (IOException ex) {
            Logger.getLogger(PuntoGit.class.getName()).log(Level.SEVERE, null,   ex);
            return false;
        } catch (InterruptedException ex) {
            Logger.getLogger(PuntoGit.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        return true;
    }
    
    
    
}
