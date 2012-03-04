/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gitServer;

import java.net.InetAddress;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import utils.Message;

/**
 *
 * @author pc
 */
public class GitServer extends java.rmi.server.UnicastRemoteObject implements ReceiveMessageInterface{
  
    int thisPort;
    String thisAddress;
    Registry registry;
    
    @Override
    public Message receiveMessage(Message m) throws RemoteException {
        System.out.println("Mensaje recibido en GitServer -> "+m);
        return new Message(m.getContador()+1,"Texto de respuesta al cliente desde GitServer");
    }
    
     public GitServer() throws RemoteException {
       
        try {
            // get the address of this host.
            thisAddress = (InetAddress.getLocalHost()).toString();
        } catch (Exception e) {
            throw new RemoteException("can't get inet address.");
        }
        
        thisPort = 3232;  // this port(registrys port)
        System.out.println("this address=" + thisAddress + ",port=" + thisPort);
        
        try {
            // create the registry and bind the name and object.
            registry = LocateRegistry.createRegistry( thisPort );
            registry.rebind("gitServer", this);
        } catch (RemoteException e) {
            throw e;
        }
    }
     
    static public void main(String args[]) {
        try {
            GitServer s = new GitServer();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

    }
    
    
    
}
