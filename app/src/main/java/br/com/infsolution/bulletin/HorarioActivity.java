package br.com.infsolution.bulletin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;

public class HorarioActivity extends AppCompatActivity {
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horario);
        ImageButton bt = (ImageButton)findViewById(R.id.ib_sg_aula1);
        bt.setImageResource(R.drawable.books_icon);
    }
}
