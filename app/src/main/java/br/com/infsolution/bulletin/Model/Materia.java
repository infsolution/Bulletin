package br.com.infsolution.bulletin.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cicero on 19/03/2016.
 */
public class Materia {
    private int id;
    private String nome;
    private String professor;
    private List<Prova> provas = new ArrayList<>();
    private List<Trabalho> trabalhos = new ArrayList<>();
    private List<String> livros = new ArrayList<>();
    private double media=0.0;

    public Materia(String nome){
        this.nome=nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public List<Prova> getProvas() {
        return provas;
    }

    public void setProvas(List<Prova> provas) {
        this.provas = provas;
    }

    public List<Trabalho> getTrabalhos() {
        return trabalhos;
    }

    public void setTrabalhos(List<Trabalho> trabalhos) {
        this.trabalhos = trabalhos;
    }

    public List<String> getLivros() {
        return livros;
    }

    public void setLivros(List<String> livros) {
        this.livros = livros;
    }
    public double calculaMedia(List<Prova> provas){
        float media=0, somaNota=0;
        for (Prova nota : provas){
            somaNota+=nota.getNota();
        }
        media=somaNota/provas.size();
        return media;   
    }
    public double getMedia() {
        return media;
    }


}
