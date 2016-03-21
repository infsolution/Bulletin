package br.com.infsolution.bulletin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class BulletinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bulletin);
    }
    public void nextBol(View v){
        Intent goToCad = new Intent(this,CadPessoa.class);
        startActivity(goToCad);
    }
}
