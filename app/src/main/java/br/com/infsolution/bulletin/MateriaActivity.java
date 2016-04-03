package br.com.infsolution.bulletin;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import br.com.infsolution.bulletin.DAO.MateriaDAO;
import br.com.infsolution.bulletin.Model.AdapterListMateria;
import br.com.infsolution.bulletin.Model.Materia;

public class MateriaActivity extends AppCompatActivity {
    private ListView listMaterias;
    private MateriaDAO matdao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materia);
        listMaterias = (ListView)findViewById(R.id.list_materias);
        final TextView label = (TextView)findViewById(R.id.titulo);

        registerForContextMenu(listMaterias);
        registerForContextMenu(label);

        listMaterias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MateriaActivity.this, "Clicou no item " + position, Toast.LENGTH_SHORT).show();
            }
        });

        listMaterias.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(MateriaActivity.this, "Clico longo em " + parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();

                return false;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
       povoaList();
    }
    public void povoaList(){
        listMaterias = (ListView)findViewById(R.id.list_materias);
        matdao = new MateriaDAO(this);
        List<Materia> materias = matdao.lista();
        ArrayAdapter<Materia> adapter = new AdapterListMateria(this,android.R.layout.simple_list_item_1,materias);
        listMaterias.setAdapter(adapter);
        matdao.close();
    }
    public void newMateria(View v){
        Intent newMat = new Intent(this, CadMateriaActivity.class);
        startActivity(newMat);
    }
}
