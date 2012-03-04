package puntoGit;

import java.util.ArrayList;
import utils.Buffer;

/**
 *
 * @author fermani
 */
public class Status extends Buffer {

    public final static String MODIFICADO = " M";
    public final static String BORRADO = " D";
    public final static String NUEVO = "??";
    public final static String CONFLICTO = "UU";
    
    public Status() {
        super();
        buffer.put(MODIFICADO, new ArrayList<String>());
        buffer.put(NUEVO, new ArrayList<String>());
        buffer.put(BORRADO, new ArrayList<String>());
    }

    public void addModificado(String path) {
        buffer.get(MODIFICADO).add(path);
    }

    public void addBorrado(String path) {
        buffer.get(BORRADO).add(path);
    }

    public void addNuevo(String path) {
        buffer.get(NUEVO).add(path);
    }

    public ArrayList<String> getModificados() {
        return buffer.get(MODIFICADO);
    }

    public ArrayList<String> getBorrados() {
        return buffer.get(BORRADO);
    }
    
    public ArrayList<String> getNuevos() {
        return buffer.get(NUEVO);
    }
}