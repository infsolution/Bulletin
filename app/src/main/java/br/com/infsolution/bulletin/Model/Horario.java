package br.com.infsolution.bulletin.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cicero on 19/03/2016.
 */
public class Horario {
    private int id;
    private String turno;
    private List<Aula> aulas = new ArrayList<>();

    public Horario(int id, String turno){
        this.id=id;
        this.turno=turno;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public List<Aula> getAulas() {
        return aulas;
    }

    public void setAulas(List<Aula> aulas) {
        this.aulas = aulas;
    }
}
