package db.registros;

/**
 *
 * @author fermani
 */
public class Carpeta {

    private int id;
    private String nombre;

    public Carpeta() {
        this(0);
    }

    public Carpeta(int id) {
        this.id = id;
        this.nombre = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
