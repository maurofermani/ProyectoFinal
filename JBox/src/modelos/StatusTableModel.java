package modelos;

import jBox.Archivo;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;
import puntoGit.PuntoGit;
import puntoGit.Status;

/**
 *
 * @author fermani
 */
public class StatusTableModel extends AbstractTableModel {

    private ArrayList<Archivo> datos;
    private String[] titulos;
    private Class[] clases;
    private PuntoGit pg;

    public StatusTableModel(Status status, PuntoGit pg) {
        this.pg = pg;
        datos = new ArrayList<Archivo>();
        ArrayList<String> borrados = status.getBorrados();
        ArrayList<String> modificados = status.getModificados();
        ArrayList<String> nuevos = status.getNuevos();
        for (String borrado : borrados) {
            datos.add(new Archivo(Status.BORRADO, pg.getBox().getAbsolutePath() + "/" + borrado));
        }
        for (String modificado : modificados) {
            datos.add(new Archivo(Status.MODIFICADO, pg.getBox().getAbsolutePath() + "/" + modificado));
        }
        for (String nuevo : nuevos) {
            datos.add(new Archivo(Status.NUEVO, pg.getBox().getAbsolutePath() + "/" + nuevo));
        }
        titulos = new String[]{"  ", "Archivos"};
        clases = new Class[]{ImageIcon.class, String.class};
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return titulos.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Archivo arch = datos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return arch.getIcon();
            case 1:
                return arch.getArch().getAbsolutePath().substring(pg.getBox().getAbsolutePath().length() + 1);
            default:
                throw new AssertionError();
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return clases[columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return titulos[column];
    }
    
    
}
