
package modelo;

public class Ingrediente {
    private int id;
    private String nombre;
    private int cantidad;

    public Ingrediente(int id,String nombre, int cantidad) {
        this.id=id;
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public Ingrediente(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Ingrediente(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }
    
    public Ingrediente(String nombre) {
        this.nombre = nombre;
    }

    public Ingrediente() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
