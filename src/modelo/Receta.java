/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author ROBERTO
 */
public class Receta {
    private int id;
    private ArrayList<Ingrediente> lista;
    private int porciones;
    private String fecha;
    private String preparacion;
    private String nombre;
    private String notas;
    private Fecha f;

    public Receta() {
    }

    public Fecha getF() {
        return f;
    }

    public void setF(Fecha f) {
        Fecha f2 = new Fecha();
        this.f = f2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Ingrediente> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Ingrediente> lista) {
        this.lista = lista;
    }

    public int getPorciones() {
        return porciones;
    }

    public void setPorciones(int porciones) {
        this.porciones = porciones;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getPreparacion() {
        return preparacion;
    }

    public void setPreparacion(String preparacion) {
        this.preparacion = preparacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }
    
    
}
