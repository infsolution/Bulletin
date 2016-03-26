package br.com.infsolution.bulletin.Model;

/**
 * Created by Cicero on 25/03/2016.
 */
public class Conteudo {
    private int id;
    private int id_prova;
    private int id_trabalho;
    private String conteudo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_prova() {
        return id_prova;
    }

    public void setId_prova(int id_prova) {
        this.id_prova = id_prova;
    }

    public int getId_trabalho() {
        return id_trabalho;
    }

    public void setId_trabalho(int id_trabalho) {
        this.id_trabalho = id_trabalho;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    @Override
    public String toString() {
        return getId()+": "+getConteudo();
    }
}
