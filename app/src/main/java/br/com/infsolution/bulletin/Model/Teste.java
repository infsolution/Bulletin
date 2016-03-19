package br.com.infsolution.bulletin.Model;

import android.text.format.DateFormat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cicero on 19/03/2016.
 */
public class Teste {
    private Materia materia;
    private DateFormat date;
    private List<String> conteudo = new ArrayList<>();
    private  String obs;
    private String tipo;
    private float nota;
    public Teste(){

    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public DateFormat getDate() {
        return date;
    }

    public void setDate(DateFormat date) {
        this.date = date;
    }

    public List<String> getConteudo() {
        return conteudo;
    }

    public void setConteudo(List<String> conteudo) {
        this.conteudo = conteudo;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    @Override
    public String toString() {
        return super.toString();
    }
}
