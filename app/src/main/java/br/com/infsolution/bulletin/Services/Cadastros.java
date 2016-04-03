package br.com.infsolution.bulletin.Services;

import android.app.Activity;
import android.view.View;

import java.util.Objects;

import br.com.infsolution.bulletin.Model.Livro;
import br.com.infsolution.bulletin.DAO.*;
import br.com.infsolution.bulletin.Model.Materia;

/**
 * Created by Cicero on 01/04/2016.
 */
public class Cadastros {
    private Livro livro;
    public Cadastros(){

    }
    public void newLivro(Livro livro, Activity activity, View view){
        LivroDAO ldao = new LivroDAO(activity);
        ldao.inserir(livro);
        ldao.close();
    }
    public void newMateria(Materia materia, Activity activity, View view){
        MateriaDAO ldao = new MateriaDAO(activity);
        ldao.inserir(materia);
        ldao.close();
    }
    public void newObejct(Objects objects, Activity activity, View view){
        LivroDAO ldao = new LivroDAO(activity);
        ldao.inserir(livro);
        ldao.close();
    }
}
