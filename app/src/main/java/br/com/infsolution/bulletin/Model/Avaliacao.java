package br.com.infsolution.bulletin.Model;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cicero on 19/03/2016.
 */
public abstract class Avaliacao {
    private int id;
    private int id_materia;
    private String date;
    private List<Conteudo> conteudo = new ArrayList<>();
    private  String obs;
    private String tipo;
    private float nota;
    public Avaliacao(){

    }




    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_materia() {
        return id_materia;
    }

    public void setId_materia(int id_materia) {
        this.id_materia = id_materia;
    }

    public List<Conteudo> getConteudo() {
        return conteudo;
    }

    public void setConteudo(List<Conteudo> conteudo) {
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
