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
    private static final String SQL_SELECT = "SELECT id_ingredientes,nombre_ingrediente FROM ingredientes WHERE nombre_ingrediente=?";
    private static final String SQL_INSERT = "INSERT INTO receta_ingredientes(recetaid_receta, ingredientesid_ingredientes, Cantidad) "
            + "                                 VALUES (?,?,?)";
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
                r=new Ingrediente(rs.getString(1), rs.getInt(2));
                lista.add(r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
        }
        return lista;
    }
     
    public boolean create(int id,ArrayList<Ingrediente> lista) {
        PreparedStatement ps;
        try {
            ps=con.getCon().prepareStatement(SQL_INSERT);
            for(int i=0;i<lista.size();i++){
            ps.setInt(1, id);
            ps.setInt(2,lista.get(i).getId());
            ps.setInt(3, (int) lista.get(i).getCantidad());
            ps.executeUpdate();
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DAOIngrediente.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
        }
        return false;
    }
    
    public Ingrediente read(String o) {
        PreparedStatement ps;
            ResultSet res;
            Ingrediente p=null;
        try {
            
            ps=con.getCon().prepareStatement(SQL_SELECT);
            ps.setString(1, o);
            res=ps.executeQuery();
            while(res.next()){
                p=new Ingrediente(res.getInt(1), res.getString(2));
            }
            return p;
        } catch (SQLException ex) {
            Logger.getLogger(DAOIngrediente.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
        }
         return p;
    }
}