package br.com.infsolution.bulletin.Model;

/**
 * Created by Cicero on 21/03/2016.
 */
public class Boletim {
    private Pessoa pessoa;
    private String escola;
    private Horario horario;
    private Agenda agenda;

    public Boletim(){

    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getEscola() {
        return escola;
    }

    public void setEscola(String escola) {
        this.escola = escola;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }
}
