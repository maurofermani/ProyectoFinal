/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gitServer;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import utils.Buffer;
import utils.Console;

/**
 *
 * @author pc
 */
public class GitServer extends java.rmi.server.UnicastRemoteObject implements GitServerInterface {
// pasar a hilos y usar worker (no threads)

    private int thisPort;
    private String thisAddress;
    private Registry registry;
    public static final Logger loggerServer = Logger.getLogger(GitServer.class.getName());
    private Console console;

    @Override
    public Buffer initServer(String carpeta) throws RemoteException, IOException, InterruptedException {
        //creo e inicializo la carpeta en el servidor
        Buffer buffer = this.console.execute(new String[]{"initServer", carpeta});
        return buffer;
    }

    public GitServer() throws
            IOException {

        this.console = new Console();

        File file = new File(getClass().getResource("/log/").getPath() + "loggerServer.log");
        if (!file.exists()) {
            file.createNewFile();
        }

        FileHandler fh = new FileHandler(file.getAbsolutePath(), true);
        loggerServer.addHandler(fh);
        loggerServer.setLevel(Level.ALL);
        SimpleFormatter formatter = new SimpleFormatter();
        fh.setFormatter(formatter);

        try {
            // get the address of this host.
            thisAddress = (InetAddress.getLocalHost()).toString();
        } catch (Exception e) {
            throw new RemoteException("No se pudo obtener la dirección de red.");
        }

        thisPort = 3232;  // this port(registrys port)
        System.out.println("this address=" + thisAddress + ",port=" + thisPort);

        try {
            // create the registry and bind the name and object.
            registry = LocateRegistry.createRegistry(thisPort);
            registry.rebind("gitServer", this);
        } catch (RemoteException e) {
            throw e;
        }
    }

    static public void main(String args[]) {
        try {
            GitServer s = new GitServer();
        } catch (Exception e) {
            GitServer.loggerServer.log(Level.SEVERE, e.getMessage(), e);
            System.exit(1);
        }

    }
}
