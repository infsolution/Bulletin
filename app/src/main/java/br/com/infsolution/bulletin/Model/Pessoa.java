package br.com.infsolution.bulletin.Model;

/**
 * Created by Cicero on 19/03/2016.
 */
public class Pessoa {
    private int id;
    private String nome;
    private String matricula;
     public Pessoa(String nome, String matricula){
        this.nome = nome;
         this.matricula = matricula;
     }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }


    public String getMatricula() {
        return matricula;
    }

}
