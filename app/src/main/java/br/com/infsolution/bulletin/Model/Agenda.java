package br.com.infsolution.bulletin.Model;

import java.util.Date;

/**
 * Created by Cicero on 19/03/2016.
 */
public class Agenda {
    private Date data;
    private String titulo;
    private String assunto;

    public Agenda(){

    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }
}
