package utils;

import gitServer.ReceiveMessageInterface;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fermani
 */
public class Console {

    private ReceiveMessageInterface gitServer;
    private Registry registry;
    private String serverAddress = "127.0.1.1";
    private String serverPort = "3232";
    private Logger loggerConsole;
    private final String SEPARADOR = "\n-------------------------------------------";

    public Console(Logger loggerConsole) {
        this.loggerConsole = loggerConsole;
        try {
            // get the registry
            this.registry = LocateRegistry.getRegistry(this.serverAddress, Integer.parseInt(this.serverPort));
            // look up the remote object
            this.gitServer = (ReceiveMessageInterface) (this.registry.lookup("gitServer"));

        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
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

    public Message remoteExecute(Message m) {
        Message response = null;
        try {
            response = this.gitServer.receiveMessage(m);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return response;
    }
}
