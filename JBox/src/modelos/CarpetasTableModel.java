package modelos;

import db.registros.UsuarioCarpeta;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author fermani
 */
public class CarpetasTableModel extends AbstractTableModel {
    
    private ArrayList<UsuarioCarpeta> datos;
    private String[] titulos;

    public CarpetasTableModel() {
        this(new ArrayList<UsuarioCarpeta>());
    }

    public CarpetasTableModel(ArrayList<UsuarioCarpeta> datos) {
        this.datos = datos;
        this.titulos = new String[] {"ID", "Nombre", "Tipo", "Carpeta Local"};
    }
        
    public void newData(ArrayList<UsuarioCarpeta> datos) {
        this.datos = datos;
        fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        return this.titulos[column];
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
        UsuarioCarpeta uc = datos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return uc.getCarpeta().getId();
            case 1:
                return uc.getCarpeta().getNombre();
            case 2:
                return uc.getTipo().getDescripcion();
            case 3:
                return uc.getPuntoGit().getBox().getAbsoluteFile();
            default:
                throw new AssertionError();
        }
    }
    
    public UsuarioCarpeta get(int row) {
        return datos.get(row);
    }
    
}
