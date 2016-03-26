package br.com.infsolution.bulletin.Model;

import android.text.format.DateFormat;

/**
 * Created by Cicero on 19/03/2016.
 */
public class Trabalho extends Avaliacao {
    private String dataEntrega;
    public Trabalho(String data, int materia){
        this.setDate(data);
        this.setId_materia(materia);
    }
    public String getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(String dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    @Override
    public String toString() {
        return "Trabalho: "+getTipo()+"\nData: "+getDate()+"\nNota: "+getNota();
    }
}
