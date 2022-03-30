/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DIEGO
 */
public class DAOReceta {
    private static final String SQL_SELECT = "SELECT id_usuario,nombre,"
            + "apellido,correo,contra,idcargo FROM usuario WHERE correo=?";
    private static final String SQL_SELECT_ALL = "SELECT id_receta, nombre_receta, porciones, "
            + "nota, fecha FROM receta";
    private static final Conexion con=Conexion.saberEstado();
    
    public ArrayList<Receta> readAll(){
        ArrayList<Receta> lista = null;
        Receta r;
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps=con.getCon().prepareStatement(SQL_SELECT_ALL);
            rs=ps.executeQuery();
            while(rs.next()){
                r=new Receta(rs.getInt(1), rs.getInt(3), rs.getString(2), rs.getString(4), rs.getString(5));
                lista.add(r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
        }
        return lista;
    }
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
