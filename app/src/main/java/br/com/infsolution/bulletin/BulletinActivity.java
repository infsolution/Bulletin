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
    }

    public void goForCadastro(View v){
        Intent goToCad = new Intent(this,CadPessoa.class);
        startActivity(goToCad);
    }
    public void goForAgenda(View v){
        Intent goToCad = new Intent(this,AgendaActivity.class);
        startActivity(goToCad);
    }
    public void goForHorario(View v){
        Intent goToCad = new Intent(this,HorarioActivity.class);
        startActivity(goToCad);
    }
    public void goForBoletim(View v){
        Intent goToCad = new Intent(this,BoletimActivity.class);
        startActivity(goToCad);
    }
    public void goForProfile(View v){
        Intent goToCad = new Intent(this,ProfileActivity.class);
        startActivity(goToCad);
    }
    public void goForMaterias(View v){
        Intent goToCad = new Intent(this, MateriaActivity.class);
        startActivity(goToCad);
    }
}
