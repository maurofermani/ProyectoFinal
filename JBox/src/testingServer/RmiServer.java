/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testingServer;

import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;
import java.net.*;

public class RmiServer 
        implements ReceiveMessageInterface {

//    private final int thisPort;
//    private final String thisAddress;
//    private final Registry registry;    // rmi registry for lookup the remote objects.

    // This method is called from the remote client by the RMI.
    // This is the implementation of the ReceiveMessageInterface.
    public void receiveMessage(String x) throws RemoteException {
        System.out.println(x);
    }

    public RmiServer() throws RemoteException {
        super();
    }

    static public void main(String args[]) {
        try {
            RmiServer server = new RmiServer();


            try {
                // get the address of this host.
//                thisAddress = (InetAddress.getLocalHost()).toString();
            } catch (Exception e) {
                throw new RemoteException("can't get inet address.");
            }

//            thisPort = 1099;  // this port(registrys port)
//            System.out.println("this address=" + thisAddress + ",port=" + thisPort);
            try {
                // create the registry and bind the name and object.
                Registry registry = LocateRegistry.getRegistry();
                
                ReceiveMessageInterface stub = (ReceiveMessageInterface) UnicastRemoteObject.exportObject(server, 0);
//            System.out.println(registry.list());
                registry.rebind("gfdgsgdfgdfgsggdfsgdfgd", stub);
            } catch (RemoteException e) {
                throw e;
            }


        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

    }
}