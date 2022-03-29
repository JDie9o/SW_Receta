
package modelo;

//Atributos
public class Usuario {
    private int id,idcargo;
    private String nombre, apellido,correo,contra,cargo;
//Constructores
    public Usuario() {
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo + ", contra=" + contra + ", cargo=" + cargo + '}';
    }

    public Usuario(int id, String nombre, String apellido, String correo, String contra,int idcargo) {
        this.id = id;
        this.idcargo = idcargo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contra = contra;
    }


    public Usuario(int id, String nombre, String apellido, String correo, String contra, String cargo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contra = contra;
        this.cargo = cargo;
    }
    
    public int getIdcargo() {
        return idcargo;
    }

//Métodos Getter and Setter
    public void setIdcargo(int idcargo) {    
        this.idcargo = idcargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        if(idcargo==1){
            this.cargo="Jefe Panaderia";
        }else{
            this.cargo="Producción";
        }
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }
    
    
}
