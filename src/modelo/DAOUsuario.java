package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DAOUsuario {
    private static final String SQL_SELECT = "SELECT id_usuario,nombre,"
            + "apellido,correo,contra,idcargo FROM usuario WHERE correo=?";
    private static final Conexion con=Conexion.saberEstado();
    
    
    public Usuario read(Usuario o) {
        PreparedStatement ps;
            ResultSet res;
            Usuario p=null;
        try {
            
            ps=con.getCon().prepareStatement(SQL_SELECT);
            ps.setString(1, o.getCorreo());
            res=ps.executeQuery();
            while(res.next()){
                p=new Usuario(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5),res.getInt(6));
            }
            return p;
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
        }
         return p;
    }
}
