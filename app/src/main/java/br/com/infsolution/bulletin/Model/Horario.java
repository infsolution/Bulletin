package br.com.infsolution.bulletin.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cicero on 19/03/2016.
 */
public class Horario {
    private List<Materia> materias = new ArrayList<>();
    private List<Aula> aulas = new ArrayList<>();

    public Horario(){

    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }

    public List<Aula> getAulas() {
        return aulas;
    }

    public void setAulas(List<Aula> aulas) {
        this.aulas = aulas;
    }
}
