package br.com.infsolution.bulletin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import br.com.infsolution.bulletin.DAO.AulaDAO;
import br.com.infsolution.bulletin.Model.Aula;
import br.com.infsolution.bulletin.Model.Materia;

public class CadAulaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_aula);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
    public void cadAula(View v){

        EditText nomeMat = (EditText)findViewById(R.id.edt_nome_materia);
        EditText diaAula = (EditText)findViewById(R.id.edt_dia_aula);
        EditText horaAula = (EditText)findViewById(R.id.edt_hora_aula);

        String nomMat = nomeMat.getText().toString();
        String  horAul= diaAula.getText().toString();
        String diaAul = horaAula.getText().toString();
        Materia materia = new Materia(nomMat);
        Aula aula = new Aula(materia,diaAul,horAul);
        AulaDAO aulaDao = new AulaDAO(this);
        aulaDao.inserir(aula);


    }
}
