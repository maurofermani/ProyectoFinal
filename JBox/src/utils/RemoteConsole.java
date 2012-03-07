/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import gitServer.GitServerInterface;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;

/**
 *
 * @author pc
 */
public class RemoteConsole extends Console {

    private GitServerInterface gitServer;
    private Registry registry;
    private String serverAddress = "127.0.1.1";
    private String serverPort = "3232";

    public RemoteConsole() throws
            RemoteException,
            NotBoundException,
            IOException {
        super();
        // get the registry
        this.registry = LocateRegistry.getRegistry(this.serverAddress, Integer.parseInt(this.serverPort));
        // look up the remote object
        this.gitServer = (GitServerInterface) (this.registry.lookup("gitServer"));

    }

    public Buffer initRemoteFolder(String carpeta) throws RemoteException, IOException, InterruptedException {
        Buffer buffer = null;
        buffer = this.gitServer.initServer(carpeta);
        return buffer;
    }
}
