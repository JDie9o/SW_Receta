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
    private static final String SQL_SELECT = "SELECT id_receta, nombre_receta, porciones, "
            + "nota, fecha ,tiempo,temperatura FROM receta WHERE nombre_receta=?";
    private static final String SQL_SELECT_ID = "SELECT id_receta, nombre_receta, porciones, "
            + "nota, fecha ,tiempo,temperatura FROM receta WHERE id_receta=?";
    private static final String SQL_SELECT_ALL = "SELECT id_receta, nombre_receta, porciones, "
            + "nota, fecha ,tiempo,temperatura FROM receta";
    private static final String SQL_SEARCH_ID = "SELECT id_receta FROM receta WHERE nombre_receta=?";
    private static final String SQL_SEARCH_ID_INGRE = "SELECT id_ingredientes FROM ingredientes WHERE nombre_ingrediente=?";
    private static final String SQL_INNER = "SELECT i.id_ingredientes,i.nombre_ingrediente,ri.Cantidad "
            + "FROM receta r INNER JOIN receta_ingredientes ri ON r.id_receta=ri.recetaid_receta "
            + "INNER JOIN ingredientes i ON ri.ingredientesid_ingredientes=i.id_ingredientes WHERE r.id_receta=?;";
    private static final String SQL_UPDATE ="UPDATE receta SET nombre_receta=?,porciones=?,nota=?,fecha =? ,tiempo=?,temperatura=? WHERE id_receta=?;";
    private static final Conexion con=Conexion.saberEstado();
    
    public ArrayList<Receta> readAll(){
        ArrayList<Receta> lista = new ArrayList<>();
        Receta r;
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps=con.getCon().prepareStatement(SQL_SELECT_ALL);
            rs=ps.executeQuery();
            while(rs.next()){
                r=new Receta(rs.getInt(1), rs.getInt(3), rs.getString(2), rs.getString(4), rs.getString(6), rs.getString(7), rs.getString(5));
                lista.add(r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
        }
        return lista;
    }
    public Receta read(Receta r) {
        PreparedStatement ps;
        ResultSet rs;
        Receta re=null;
        try {
            ps=con.getCon().prepareStatement(SQL_SELECT);
            ps.setString(1, r.getNombre());
            rs=ps.executeQuery();
            while(rs.next()){
                re=new Receta(rs.getInt(1), rs.getInt(3), rs.getString(2), rs.getString(4), rs.getString(6), rs.getString(7), rs.getString(5));
            }
            return re;
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
        }
         return re;
    }
    public Receta readId(Receta r) {
        PreparedStatement ps;
        ResultSet rs;
        Receta re=null;
        try {
            ps=con.getCon().prepareStatement(SQL_SELECT_ID);
            ps.setInt(1, r.getId());
            rs=ps.executeQuery();
            while(rs.next()){
                re=new Receta(rs.getInt(1), rs.getInt(3), rs.getString(2), rs.getString(4), rs.getString(6), rs.getString(7), rs.getString(5));
            }
            return re;
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
        }
         return re;
    }
    public Receta searchId(Receta r){
        PreparedStatement ps;
        ResultSet rs;
        Receta re=null;
        try {
            ps=con.getCon().prepareStatement(SQL_SEARCH_ID);
            ps.setString(1, r.getNombre());
            rs=ps.executeQuery();
            while(rs.next()){
                re=new Receta();
                re.setId(rs.getInt(1));
                re.setNombre(r.getNombre());
            }
            return re;
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
        }
         return re;
    }
    public ArrayList<Ingrediente> readIn(Receta r){
        ArrayList<Ingrediente> lista = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps=con.getCon().prepareStatement(SQL_INNER);
            ps.setInt(1, r.getId());
            rs=ps.executeQuery();
            while(rs.next()){
                Ingrediente i=new Ingrediente(rs.getInt(1),rs.getString(2), rs.getInt(3));
                lista.add(i);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
        }
        return lista;
    }
    public Ingrediente searchIdIngre(Ingrediente i){
        Ingrediente in = null;
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps=con.getCon().prepareStatement(SQL_SEARCH_ID_INGRE);
            ps.setString(1, i.getNombre());
            rs=ps.executeQuery();
            while(rs.next()){
                in=new Ingrediente();
                in.setId(rs.getInt(1));
                in.setNombre(i.getNombre());
            }
            return in;
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
        }
        return in;
    }
    public void update(Receta r){
        Ingrediente in = null;
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps=con.getCon().prepareStatement(SQL_UPDATE);
            ps.setString(1, r.getNombre());
            ps.setInt(2, r.getPorciones());
            ps.setString(3, r.getNotas());
            ps.setString(4, r.getF().fecha());
            ps.setString(5, r.getTiempo());
            ps.setString(6, r.getTemperatura());
            ps.setInt(7, r.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
        }
    }
}
