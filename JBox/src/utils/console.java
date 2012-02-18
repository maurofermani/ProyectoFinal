package utils;

import java.io.IOException;

/**
 *
 * @author fermani
 */
public class console {

    public static int execute(String command) throws IOException, InterruptedException {
        Process exec = Runtime.getRuntime().exec(command);
        StreamSalida error = new StreamSalida(exec.getErrorStream(), "ERROR");
        StreamSalida out = new StreamSalida(exec.getInputStream(), "");

        error.start();
        out.start();
        
        return exec.waitFor();
    }
}
