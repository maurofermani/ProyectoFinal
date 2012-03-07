package utils;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fermani
 */
public class Console {

    
    private Logger loggerConsole;
    private final String SEPARADOR = "\n-------------------------------------------";

    public Console() {
        this.loggerConsole = loggerConsole;
     }

    public Buffer execute(String[] command) throws
            IOException,
            InterruptedException {

        String log = "";
        for (String str : command) {
            log += " " + str;
        }
        log += SEPARADOR;
        loggerConsole.log(Level.INFO, log);
        Process exec = Runtime.getRuntime().exec(command);
        StreamSalida error = new StreamSalida(exec.getErrorStream(), "ERROR");
        StreamSalida out = new StreamSalida(exec.getInputStream(), "OUT");

        error.start();
        out.start();

        int sal = exec.waitFor();

        Buffer buffer = new Buffer();
        buffer.put(error.getType(), error.getSalida());
        buffer.put(out.getType(), out.getSalida());

        return buffer;
    }


}
