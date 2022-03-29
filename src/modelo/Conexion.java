//modifique algo
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    public static Conexion instance;
    private Connection con;
    private Conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/receta_sw","root","");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Hola");
    }
    public static Conexion saberEstado(){
        if(instance==null){
            instance=new Conexion();
        }
        return instance;
    }

    public Connection getCon() {
        return con;
    }
    
    public void cerrarConexion(){
        instance = null;
    }
}