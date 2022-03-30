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
    private int porciones;
    private String nombre;
    private String notas;
    private Fecha f;

    public Receta() {
    }

    public Receta(int id, int porciones, String nombre, String notas,String fecha) {
        this.id = id;
        this.porciones = porciones;
        this.nombre = nombre;
        this.notas = notas;
        this.f = new Fecha(fecha);
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

    public int getPorciones() {
        return porciones;
    }

    public void setPorciones(int porciones) {
        this.porciones = porciones;
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
