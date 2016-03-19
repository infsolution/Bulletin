package br.com.infsolution.bulletin.Model;

import android.text.format.DateFormat;

import br.com.infsolution.bulletin.Model.Teste;

/**
 * Created by Cicero on 19/03/2016.
 */
public class Trabalho extends Teste {
    private DateFormat dataEntrega;
    public DateFormat getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(DateFormat dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    @Override
    public String toString() {
        return "Trabalho: "+getTipo()+"\nMateria: "+getMateria().getNome()+"\nData: "+getDate()+"\nNota: "+getNota();
    }
}
