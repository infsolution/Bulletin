package br.com.infsolution.bulletin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import br.com.infsolution.bulletin.DAO.AgendaDAO;
import br.com.infsolution.bulletin.Model.Agenda;

public class AgendaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);
        ListView listMaterias = (ListView)findViewById(R.id.list_agenda);

    }

    @Override
    protected void onResume() {
        super.onResume();
        povoaList();
    }

    public void povoaList(){
        ListView listMaterias = (ListView)findViewById(R.id.list_agenda);
        AgendaDAO ageDao = new AgendaDAO(this);
        List<Agenda> agenda = ageDao.lista();
        ArrayAdapter<Agenda> adapter = new ArrayAdapter<Agenda>(this, android.R.layout.simple_list_item_1,agenda);
        listMaterias.setAdapter(adapter);
    }

    public void newAgenda(){
        TextView dat = (TextView)findViewById(R.id.edt_data_agenda);
        TextView tit = (TextView)findViewById(R.id.edt_title_agenda);
        TextView ass = (TextView)findViewById(R.id.edt_assunto_agenda);
        String dt = dat.getText().toString();
        String tt = tit.getText().toString();
        String as = ass.getText().toString();
        AgendaDAO ageDao = new AgendaDAO(this);
        Agenda hoje = new Agenda();
        hoje.setData(dt);
        hoje.setTitulo(tt);
        hoje.setAssunto(as);
        ageDao.inserir(hoje);

    }
}

