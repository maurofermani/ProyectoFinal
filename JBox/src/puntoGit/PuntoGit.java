package puntoGit;

import db.Conexion;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import utils.Buffer;
import utils.RemoteConsole;

/**
 *
 * @author fermani
 */
public class PuntoGit {

    private File box;
    private RemoteConsole console;

    public PuntoGit(File carpeta, RemoteConsole console) {
        this.box = carpeta;
        this.console = console;
    }

    public PuntoGit(String path, RemoteConsole console) {
        this.box = new File(path);
        this.console = console;
    }

    public void setBox(String path) {
        this.box = new File(path);
    }

    public void setBox(File box) {
        this.box = box;
    }

    public File getBox() {
        return box;
    }

    /**
     * Inicializa la carpeta en el ciente, y en el servidor.
     * @return verdadero si pudo realizar la operación
     */
    public Buffer init(Conexion conexion) throws
            IOException,
            InterruptedException {
        try {
            Buffer buffer;

            //inserto los registro en la base de datos
            conexion.initTransaction();
            String qry = "INSERT INTO carpetas VALUES (0, '" + box.getName() + "');";
            System.out.println(qry);
            conexion.execUpdate(qry);
            qry = "INSERT INTO usuario_carpeta (id_usuario, id_carpeta, id_tipo, carpeta_local) VALUES ("
                    + conexion.getUsuario().getId() + ", "
                    + conexion.getSerial() + ", "
                    + "1, "
                    + "'" + box.getAbsolutePath() + "');";
            System.out.println(qry);
            conexion.execUpdate(qry);
            
            //creo e inicializo la carpeta en el servidor
            buffer = console.initRemoteFolder(box.getName());

            //inicializo la carpeta del cliente
            buffer = console.execute(new String[] {"initClient", box.getAbsolutePath(), box.getName()});

            this.push("InitialCommit");

            conexion.endTransaction();

            return buffer;
        } catch (SQLException ex) {
            try {
                conexion.rollback();
                conexion.logger(Level.SEVERE, ex.getSQLState());
            } catch (SQLException ex1) {
                conexion.logger(Level.SEVERE, ex1.getSQLState());
            }
        }
        return null;
    }

    public Buffer add(String path) throws
            IOException,
            InterruptedException {

        //agrego el o los archivos modificados
        return console.execute(new String[] {"git", "add", path});
    }

    /**
     * Agrega los cambios y realiza un push al servidor
     * @return verdadero si la operación se realizó con éxito
     */
    public Buffer push(String msg) throws
            IOException,
            InterruptedException {
        return console.execute(new String[] {"push", msg, box.getAbsolutePath()});
    }

    /**
     * Ejecuta el comando git-status y devuelve los archivos modificados 
     * @return Status: Archivos modificados, agregados y borrados.
     * @throws IOException
     * @throws InterruptedException 
     */
    public Status status() throws
            IOException,
            InterruptedException {
        Buffer out = console.execute(new String[] {"status", box.getAbsolutePath()});
        Status archivos = new Status();
        ArrayList<String> list = out.getList("OUT");
        
        String tipo;
        for (String str : list) {
            tipo = str.substring(0, 2);
            if (tipo.equals(Status.BORRADO)) {
                archivos.addBorrado(str.substring(3));
            } else if (tipo.equals(Status.MODIFICADO)) {
                archivos.addModificado(str.substring(3));
            } else if (tipo.equals(Status.NUEVO)) {
                archivos.addNuevo(str.substring(3));
            }
        }
        
        return archivos;
    }
}
