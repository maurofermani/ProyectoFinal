package db.registros;

import puntoGit.PuntoGit;
import utils.RemoteConsole;

/**
 *
 * @author fermani
 */
public class UsuarioCarpeta {

    private Usuario usuario;
    private Carpeta carpeta;
    private Tipo tipo;
    private PuntoGit puntoGit;

    public UsuarioCarpeta(RemoteConsole console) {
        this.usuario = new Usuario();
        this.carpeta = new Carpeta();
        this.tipo = new Tipo();
        this.puntoGit = new PuntoGit("", console);
    }

    public Carpeta getCarpeta() {
        return carpeta;
    }

    public void setCarpeta(Carpeta carpeta) {
        this.carpeta = carpeta;
    }

    public PuntoGit getPuntoGit() {
        return puntoGit;
    }

    public void setCarpetaLocal(String carpetaLocal) {
        this.puntoGit.setBox(carpetaLocal);
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
