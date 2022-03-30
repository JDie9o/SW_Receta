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
 * @author ROBERTO
 */
public class DAOIngrediente {
    private static final String SQL_SELECT_ALL = "SELECT nombre_ingrediente,id_ingredientes FROM ingredientes";
    private static final Conexion con=Conexion.saberEstado();
    
     public ArrayList<Ingrediente> readAll(){
        ArrayList<Ingrediente> lista = new ArrayList<>();
        Ingrediente r;
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps=con.getCon().prepareStatement(SQL_SELECT_ALL);
            rs=ps.executeQuery();
            while(rs.next()){
                r=new Ingrediente(rs.getString(1), rs.getFloat(2));
                lista.add(r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
        }
        return lista;
    }
}