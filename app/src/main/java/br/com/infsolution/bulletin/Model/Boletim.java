package br.com.infsolution.bulletin.Model;

/**
 * Created by Cicero on 21/03/2016.
 */
public class Boletim {
    private static Boletim instance;
    private int id;
    private double meta;
    private String ano;
    private String periodo;
    private String escola;
    private Pessoa pessoa;
    private Horario horario;
    private Agenda agenda;

    private Boletim(){

    }

    public static synchronized Boletim getInstance() {
        if(instance==null){
        instance = new Boletim();}
        return instance;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMeta() {
        return meta;
    }

    public void setMeta(double meta) {
        this.meta = meta;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
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
