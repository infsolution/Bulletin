package br.com.infsolution.bulletin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import br.com.infsolution.bulletin.DAO.MateriaDAO;
import br.com.infsolution.bulletin.Model.Materia;

public class MateriaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materia);
        ListView listMaterias = (ListView)findViewById(R.id.list_materias);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ListView listMaterias = (ListView)findViewById(R.id.list_materias);
        MateriaDAO dao = new MateriaDAO(this);
        List<Materia> veiculos = dao.lista();

        ArrayAdapter<Materia> adapter = new ArrayAdapter<Materia>(this, android.R.layout.simple_list_item_1,veiculos);

        listMaterias.setAdapter(adapter);
    }
    public void newMateria(View v){
        Intent newMat = new Intent(this, CadMateriaActivity.class);
        startActivity(newMat);
    }
}
