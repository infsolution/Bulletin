package br.com.infsolution.bulletin.Model;

import java.util.Date;

/**
 * Created by Cicero on 19/03/2016.
 */
public class Agenda {
    private int id_pagina;
    private String data;
    private String titulo;
    private String assunto;

    public Agenda(){

    }

    public int getId_pagina() {
        return id_pagina;
    }

    public void setId_pagina(int id_pagina) {
        this.id_pagina = id_pagina;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
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
