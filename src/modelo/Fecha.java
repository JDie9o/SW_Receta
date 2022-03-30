
package modelo;

import java.util.Calendar;

public class Fecha {
    private int dia;
    private int mes;
    private int anio;
    public Fecha(){
        dia=Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        mes=Calendar.getInstance().get(Calendar.MONTH)+1;
        anio=Calendar.getInstance().get(Calendar.YEAR);
    }

    public Fecha(String fecha) {
        String[] fechaSeparada = fecha.split("/");
        this.dia = Integer.valueOf(fechaSeparada[0]);
        this.mes = Integer.valueOf(fechaSeparada[1]);
        this.anio = Integer.valueOf(fechaSeparada[2]);
    }
    
    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAnio() {
        return anio;
    }
    public String fecha(){
        return dia + "/" + mes + "/" + anio;
    }

}
