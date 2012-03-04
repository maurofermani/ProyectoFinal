package db.registros;

/**
 *
 * @author fermani
 */
public class Tipo {

    public static final int PROPIETARIO = 1;
    public static final int PUEDE_EDITAR = 2;
    public static final int SOLO_LECTURA = 3;
    
    private static String STRING_PROPIETARIO = "PROPIETARIO";
    private static String STRING_PUEDE_EDITAR = "PUEDE EDITAR";
    private static String STRING_SOLO_LECTURA = "SOLO LECTURA";
    
    
    private int id;

    public Tipo() {
        this(0);
    }

    public Tipo(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        switch (getId()) {
            case Tipo.PROPIETARIO:
                return STRING_PROPIETARIO;
            case Tipo.PUEDE_EDITAR:
                return STRING_PUEDE_EDITAR;
            case Tipo.SOLO_LECTURA:
                return STRING_SOLO_LECTURA;
            default:
                throw new AssertionError();
        }
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
