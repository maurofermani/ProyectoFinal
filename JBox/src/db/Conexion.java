package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fermani
 */
public class Conexion {

    private final Connection conexion;
    private final Statement st;
    private Usuario usuario;

    public Conexion() throws Exception {
        usuario = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/JBox", "jbox", "jbox");
            st = conexion.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    public ResultSet execSQLSelect(String sql) throws SQLException {
        ResultSet rs = st.executeQuery(sql);
        return rs;
    }

    public int execUpdate(String sql) throws SQLException {

        int rtdo = st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
        return rtdo;
    }

    public int getSerial() throws SQLException {
        ResultSet rs = st.getGeneratedKeys();
        int id = 0;
        while (rs.next()) {
            id = rs.getInt(1);
        }
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void initTransaction() throws SQLException {
        conexion.setAutoCommit(true);
    }

    public void rollback() throws SQLException {
        conexion.rollback();
    }

    public void endTransaction() throws SQLException {
        conexion.setAutoCommit(false);
    }
}
