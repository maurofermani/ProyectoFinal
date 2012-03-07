package jBox;

import java.io.File;
import javax.swing.ImageIcon;
import puntoGit.Status;

/**
 *
 * @author fermani
 */
public class Archivo {

    private File arch;
    private String tipo;
    private final static ImageIcon NUEVO = new ImageIcon(Archivo.class.getResource("/imagenes/status/nuevo.png"));
    private final static ImageIcon NUEVA_CARPETA = new ImageIcon(Archivo.class.getResource("/imagenes/status/nueva_carpeta.png"));
    private final static ImageIcon BORRADO = new ImageIcon(Archivo.class.getResource("/imagenes/status/borrado.png"));
    private final static ImageIcon MODIFICADO = new ImageIcon(Archivo.class.getResource("/imagenes/status/modificado.png"));
    private final static ImageIcon CONFLICTO = new ImageIcon(Archivo.class.getResource("/imagenes/status/conflictivo.png"));
    private final static ImageIcon DESCONOCIDO = new ImageIcon(Archivo.class.getResource("/imagenes/status/desconocido.png"));

    public Archivo(String tipo, String path) {
        this.arch = new File(path);
        this.tipo = tipo;
    }

    public File getArch() {
        return arch;
    }

    public void setArch(File arch) {
        this.arch = arch;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public ImageIcon getIcon() {
        if (tipo.equals(Status.BORRADO)) {
            return BORRADO;
        } else if (tipo.equals(Status.MODIFICADO)) {
            return MODIFICADO;
        } else if (tipo.equals(Status.NUEVO)) {
            if (arch.isDirectory()) {
                return NUEVA_CARPETA;
            } else {
                return NUEVO;
            }
        } else if (tipo.equals(Status.CONFLICTO)) {
            return CONFLICTO;
        } else {
            return DESCONOCIDO;
        }
    }
}
