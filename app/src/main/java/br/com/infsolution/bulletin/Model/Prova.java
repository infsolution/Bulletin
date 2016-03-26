package br.com.infsolution.bulletin.Model;

/**
 * Created by Cicero on 19/03/2016.
 */
public class Prova extends Avaliacao {
    private final String TIPO = "prova";
    public Prova(String data, int materia){
        this.setDate(data);
        this.setId_materia(materia);
    }

    public String getTIPO() {
        return TIPO;
    }

    @Override
    public String toString() {
        return "Prova: "+getTipo()+"\nData: "+getDate()+"\nNota: "+getNota();
    }
}
