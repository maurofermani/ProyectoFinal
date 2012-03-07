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

/**
 *
 * @author pc
 */
public class RemoteConsole extends Console{
   
    private GitServerInterface gitServer;
    private Registry registry;
    private String serverAddress = "127.0.1.1";
    private String serverPort = "3232";
    
    public RemoteConsole(){
        super();
        
        try {
            // get the registry
            this.registry = LocateRegistry.getRegistry(this.serverAddress, Integer.parseInt(this.serverPort));
            // look up the remote object
            this.gitServer = (GitServerInterface) (this.registry.lookup("gitServer"));
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
        
    }
  
    public Buffer initRemoteFolder(String carpeta) throws RemoteException, IOException, InterruptedException {
        Buffer buffer = null;
        buffer = this.gitServer.initServer(carpeta);
        return buffer;
    }
}
