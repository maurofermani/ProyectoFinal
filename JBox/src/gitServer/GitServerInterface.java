/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gitServer;

import db.registros.Usuario;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import utils.Buffer;

/**
 *
 * @author pc
 */
public interface GitServerInterface extends Remote {
    
    public Buffer initServer(String carpeta) throws RemoteException, IOException, InterruptedException;
            
}
