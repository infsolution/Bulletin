package br.com.infsolution.bulletin;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import br.com.infsolution.bulletin.DAO.MateriaDAO;
import br.com.infsolution.bulletin.Model.Materia;

public class CadMateriaActivity extends AppCompatActivity {
   private MateriaDAO matDao;
    private Materia materia;
    private String path;
    private static int IMAGE_SELECT=101;
    ImageButton imb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_materia);
        //im_bt = (ImageButton)findViewById(R.id.bt_enviar_image);

    }

    @Override
    protected void onResume() {
        super.onResume();
    }


    public void selectImage(View v){
        Intent intent = new   Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, IMAGE_SELECT);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            // When an Image is picked
            if (requestCode == IMAGE_SELECT && resultCode == RESULT_OK
                    && null != data) {
                // Get the Image from data
                Uri selectedImage = data.getData();
                String[] filePathColumn = { MediaStore.Images.Media.DATA };
                // Get the cursor
                Cursor cursor = getContentResolver().query(selectedImage,
                        filePathColumn, null, null, null);
                // Move to first row
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                path = cursor.getString(columnIndex);
                cursor.close();
                imb = (ImageButton) findViewById(R.id.bt_enviar_image);
                // Set the Image in ImageView after decoding the String
                imb.setImageBitmap(BitmapFactory
                        .decodeFile(path));
            } else {
                Toast.makeText(this, "You haven't picked Image",
                        Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG).show();
        }
    }

    public void cadNewMateria(View v){
        EditText nomeMateria = (EditText)findViewById(R.id.edt_cad_nome_materia);
        EditText nomeProfe = (EditText)findViewById(R.id.edt_cad_nome_professor);
        String nome = nomeMateria.getText().toString();
        String nomePro = nomeProfe.getText().toString();
        Materia materia = new Materia(nome);
        materia.setProfessor(nomePro);
        materia.setFoto(path);
        matDao = new MateriaDAO(this);
        matDao.inserir(materia);
        matDao.close();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Materia cadastrada!");
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();

            }
        });

        builder.show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
