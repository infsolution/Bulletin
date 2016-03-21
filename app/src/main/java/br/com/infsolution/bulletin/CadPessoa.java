package br.com.infsolution.bulletin;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import br.com.infsolution.bulletin.DAO.PessoaDAO;
import br.com.infsolution.bulletin.Model.Pessoa;

public class CadPessoa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_pessoa);
    }

    public void newCadPessoa(View v){
        EditText nomePess = (EditText)findViewById(R.id.etx_nome_pessoa);
        EditText matPess = (EditText)findViewById(R.id.etx_matricula);

        String nome = nomePess.getText().toString();
        String matricula = matPess.getText().toString();
        Pessoa pessoa = new Pessoa(nome,matricula);
        PessoaDAO pesDao = new PessoaDAO(this);
        pesDao.inserir(pessoa);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Pessoa cadastrada ;)");

        builder.show();
    }
}
