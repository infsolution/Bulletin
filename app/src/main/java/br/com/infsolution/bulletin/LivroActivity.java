package br.com.infsolution.bulletin;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import br.com.infsolution.bulletin.DAO.LivroDAO;
import br.com.infsolution.bulletin.Model.Livro;

public class LivroActivity extends AppCompatActivity {
    private ListView listLivros;
    private LivroDAO ldao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livro);
        listLivros = (ListView)findViewById(R.id.list_livros);
        TextView titulo = (TextView)findViewById(R.id.titulo_livro);
        registerForContextMenu(listLivros);
        registerForContextMenu(titulo);

        listLivros.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(LivroActivity.this, "Clicou no item " + position, Toast.LENGTH_SHORT).show();
            }
        });

        listLivros.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(LivroActivity.this, "Clico longo em " + parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
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
        listLivros = (ListView)findViewById(R.id.list_livros);
        ldao = new LivroDAO(this);
        List<Livro> livros = ldao.lista();
        ArrayAdapter<Livro> adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,livros);
        listLivros.setAdapter(adapter);
        ldao.close();
    }

    public void newLivro(View v){

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            EditText titulo = new EditText(this);
            builder.setTitle("Titulo do Livro");   // Título
            builder.setView(titulo);
            final String tituloLivro = titulo.getText().toString();
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {
                    Log.i("Livro:",tituloLivro);
                }
            });

        }
}

