package br.com.infsolution.bulletin.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;

/**
 * Created by Cicero on 19/03/2016.
 */
public class Aula {
    private int id;
    private Materia materia;
    private String topicos;
    private String obs;
    private String date;
    private String dia;
    private String hora;
    private int id_horario;

    public Aula(Materia materia,String dia,String hora){
        this.materia = materia;
        this.dia=dia;
        this.hora=hora;

    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public String getTopicos() {
        return topicos;
    }

    public void setTopicos(String topicos) {
        this.topicos = topicos;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getId_horario() {
        return id_horario;
    }

    public void setId_horario(int id_horario) {
        this.id_horario = id_horario;
    }

    @Override
    public String toString() {
        return "Materia: "+getMateria()+"\nDia: "+getDia()+" "+getHora();
    }
}
