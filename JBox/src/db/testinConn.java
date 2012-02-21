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
public class testinConn {

    public testinConn() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/JBox", "jbox", "jbox");
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery("select * from usuarios;");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id")+" - Login: " + rs.getString("login") + " - Nombre: '" + rs.getString("nombre") + "'");
            }
            
            
            st.executeUpdate("insert into otra values (10, 'prueba');", Statement.RETURN_GENERATED_KEYS);
            rs = st.getGeneratedKeys();
            int id = 0;
            while (rs.next()) {
                id = rs.getInt(1);
            }
            System.out.println("ID: " + id);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(testinConn.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(testinConn.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new testinConn();
    }
}
