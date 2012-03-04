/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gitServer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import utils.Message;

/**
 *
 * @author pc
 */
public interface ReceiveMessageInterface extends Remote {
    Message receiveMessage(Message m) throws RemoteException;
}
