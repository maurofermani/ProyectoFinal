package utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author fermani
 */
public class Buffer implements Serializable{

    /**
     * Tipo - Lineas
     */
    protected HashMap<String, ArrayList<String>> buffer;

    public Buffer() {
        buffer = new HashMap<String, ArrayList<String>>();
    }

    public void put(String tipo, String linea) {
        if (buffer.get(tipo) == null) {
            buffer.put(tipo, new ArrayList<String>());
        }
        buffer.get(tipo).add(linea);
    }

    public void put(String tipo, ArrayList<String> lista) {
        buffer.put(tipo, lista);
    }
    
    public ArrayList<String> getList(String tipo) {
        return buffer.get(tipo);
    }
    
}
