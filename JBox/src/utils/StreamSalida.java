package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fermani
 */
class StreamSalida extends Thread {

    private InputStream is;
    private String type;
    private ArrayList<String> salida;

    StreamSalida(InputStream is, String type) {
        this.is = is;
        this.type = type;
        salida = new ArrayList<String>();
    }

    @Override
    public void run() {
        try {
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            while ((line = br.readLine()) != null) {
                salida.add(line);
            }
        } catch (IOException ex) {
            Logger.getLogger(StreamSalida.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<String> getSalida() {
        return salida;
    }

    public String getType() {
        return type;
    }
}
