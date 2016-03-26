package br.com.infsolution.bulletin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import java.util.ArrayList;
import java.util.List;
import br.com.infsolution.bulletin.Model.Aula;

public class HorarioActivity extends AppCompatActivity {
    private List<Aula>aulas = new ArrayList<>();
    private final String SEGUNDA = "Segunda";
    private final String TERCA = "Terça";
    private final String QUARTA = "Quarta";
    private final String QUINTA = "Quinta";
    private final String SEXTA = "Sexta";
    private final String SABADO = "Sabado";
    private final String DOMINGO = "Domingo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horario);
        ImageButton bt = (ImageButton)findViewById(R.id.ib_sg_aula1);
        bt.setImageResource(R.drawable.books_icon);
    }
}
