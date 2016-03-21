package br.com.infsolution.bulletin.Model;

/**
 * Created by Cicero on 19/03/2016.
 */
public class Prova extends Avaliacao {
    public Prova(){

    }

    @Override
    public String toString() {
        return "Prova: "+getTipo()+"\nMateria: "+getMateria().getNome()+"\nData: "+getDate()+"\nNota: "+getNota();
    }
}
