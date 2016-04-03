package br.com.infsolution.bulletin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import br.com.infsolution.bulletin.DAO.PessoaDAO;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        TextView nome = (TextView)findViewById(R.id.txt_test_nome);
        PessoaDAO pes = new PessoaDAO(this);
        String nomeP = pes.setWelcome();
        nome.setText(nomeP);
    }
}
