package br.com.infsolution.bulletin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import br.com.infsolution.bulletin.DAO.PessoaDAO;
import br.com.infsolution.bulletin.Model.Boletim;
import br.com.infsolution.bulletin.Model.Pessoa;

public class BulletinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bulletin);
    }

    @Override
    protected void onResume() {
        super.onResume();
        recarregarDados();
    }

    private void recarregarDados() {
        PessoaDAO dao = new PessoaDAO(this);
        TextView welcome = (TextView) findViewById(R.id.txt_nome_wc);
        Button cad = (Button) findViewById(R.id.but_cad_pessoa);
        welcome.setText(dao.setWelcome().toString());

    }
    public void nextBol(View v){
        Boletim boletim =  Boletim.getInstance();
        Intent goToCad = new Intent(this,HorarioActivity.class);
        startActivity(goToCad);
    }
}
