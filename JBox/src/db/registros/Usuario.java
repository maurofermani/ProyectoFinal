package db.registros;

/**
 *
 * @author fermani
 */
public class Usuario {

    private int id;
    private String login;
    private String nombre;

    public Usuario() {
        this(0);
    }

    public Usuario(int id) {
        this.id = id;
        this.login = "";
        this.nombre = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
