package br.com.infsolution.bulletin.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Cicero on 19/03/2016.
 */
public class Aula {
    private Materia materia;
    private List<String> topicos = new ArrayList<>();
    private List<String> obs = new ArrayList<>();
    private Date date;

    public Aula(){

    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public List<String> getTopicos() {
        return topicos;
    }

    public void setTopicos(List<String> topicos) {
        this.topicos = topicos;
    }

    public List<String> getObs() {
        return obs;
    }

    public void setObs(List<String> obs) {
        this.obs = obs;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
