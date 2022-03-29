
package modelo;

import java.util.Calendar;

public class Fecha {
    private int dia;
    private int mes;
    private int anio;
    private int hora;
    private int minuto;
    private int segundo;
    public Fecha(){
        dia=Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        mes=Calendar.getInstance().get(Calendar.MONTH)+1;
        anio=Calendar.getInstance().get(Calendar.YEAR);
        hora=Calendar.getInstance().get(Calendar.HOUR);
        minuto=Calendar.getInstance().get(Calendar.MINUTE);
        segundo=Calendar.getInstance().get(Calendar.SECOND);
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

    public int getHora() {
        return hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public int getSegundo() {
        return segundo;
    }
    public String fecha(){
        return dia + "/" + mes + "/" + anio;
    }
    public String hora(){
        return hora+":"+minuto+":"+segundo;
    }
    @Override
    public String toString() {
        return  ""+dia + "/" + mes + "/" + anio+"\n";
    }

}
