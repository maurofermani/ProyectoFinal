package utils;

import java.io.File;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author fermani
 */
public class Console {

    protected static final Logger loggerConsole = Logger.getLogger(Console.class.getName());;
    private final String SEPARADOR = "\n-------------------------------------------";

    public Console() throws 
            IOException {
        
        File file = new File(getClass().getResource("/log/").getPath() + "loggerConsole.log");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileHandler fh = new FileHandler(file.getAbsolutePath(), true);
        loggerConsole.addHandler(fh);
        loggerConsole.setLevel(Level.ALL);
        SimpleFormatter formatter = new SimpleFormatter();
        fh.setFormatter(formatter);
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
