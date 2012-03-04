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
    private String serverAddress= "127.0.1.1";
    private String serverPort = "3232";
    
    public Console(){
      
       try{
           // get the registry
           this.registry = LocateRegistry.getRegistry(this.serverAddress,Integer.parseInt(this.serverPort));
           // look up the remote object
           this.gitServer = (ReceiveMessageInterface)(this.registry.lookup("gitServer"));

       }
       catch(RemoteException e){
           e.printStackTrace();
       }
       catch(NotBoundException e){
           e.printStackTrace();
       }

    }

    public static int execute(String command) throws IOException, InterruptedException {
        Process exec = Runtime.getRuntime().exec(command);
        StreamSalida error = new StreamSalida(exec.getErrorStream(), "ERROR");
        StreamSalida out = new StreamSalida(exec.getInputStream(), "");

        error.start();
        out.start();
        
        return exec.waitFor();
    }
    
    public Message remoteExecute( Message m){
        Message response = null;
        try {
            response = this.gitServer.receiveMessage(m);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return response;
    }
    
}
