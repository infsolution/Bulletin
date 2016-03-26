package br.com.infsolution.bulletin.Model;

/**
 * Created by Cicero on 24/03/2016.
 */
public class Livro {
    private int id;
    private String titulo;
    private String autor;
    private String assunto;

    public Livro(String titulo, String autor){
        this.titulo = titulo;
        this.autor = autor;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
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

    @Override
    public String toString() {
        return "Titulo: "+getTitulo()+"\nAutor: "+getAutor()+"\n";
    }
}
