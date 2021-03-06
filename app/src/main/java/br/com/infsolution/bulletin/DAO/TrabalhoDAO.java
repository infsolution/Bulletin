package br.com.infsolution.bulletin.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import br.com.infsolution.bulletin.Model.Avaliacao;
import br.com.infsolution.bulletin.Model.Trabalho;

/**
 * Created by Cicero on 24/03/2016.
 */
public class TrabalhoDAO extends SQLiteOpenHelper {
    public TrabalhoDAO(Context context) {
        super(context, "Boletim.db", null, ControlVersionDB.version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="CREATE TABLE trabalhos(id_trabalho INTEGER PRIMARY KEY AUTOINCREMENT" +
                "id_materia INTEGER, data VARCHAR (10), data_entrega VARCHAR(10), obs TEXT, nota REAL)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS trabalhos;";
        db.execSQL(sql);
        onCreate(db);
    }
    public void inserir(Trabalho trabalho){
        ContentValues cv = new ContentValues();
        cv.put("id_materia",trabalho.getId_materia());
        cv.put("data",trabalho.getDate());
        cv.put("data_entrega",trabalho.getDataEntrega());
        cv.put("obs",trabalho.getObs());
        cv.put("nota", trabalho.getNota());
        getWritableDatabase().insert("trabalhos", null, cv);
    }

    public List<Trabalho> listaTrablhos(int id_materia){
        List<Trabalho> trabalhos = new ArrayList<>();
        String sql = "SELECT * FROM trabalhos WHERE id_materia = "+id_materia+";";
        Cursor c = getReadableDatabase().rawQuery(sql,null);

        while (c.moveToNext()){
            int id = c.getInt(c.getColumnIndex("id_pessoa"));
            int idmateria = c.getInt(c.getColumnIndex("id_materia"));
            String date = c.getString(c.getColumnIndex("data"));
            String dateEntrega = c.getString(c.getColumnIndex("data_entrega"));
            String obs = c.getString(c.getColumnIndex("obs"));
            float nota = c.getFloat(c.getColumnIndex("nota"));
           Trabalho p = new Trabalho(date,idmateria);
            p.setId(id);
            p.setDataEntrega(dateEntrega);
            p.setObs(obs);
            p.setNota(nota);
            trabalhos.add(p);
        }

        return trabalhos;
    }
    public Trabalho atrabalhon(String data, int id_materia){
        String sql = "SELECT * FROM trabalhos WHERE data = "+data+" AND id_materia = "+id_materia+";";
        Cursor c = getReadableDatabase().rawQuery(sql,null);
        String obs="";
        String date="";
        int id=0;
        int id_prova=0;
        float nota=0;
        if(c.moveToNext()) {
            id_prova=c.getInt(c.getColumnIndex("id_prova"));
            id=c.getInt(c.getColumnIndex("id_materia"));
            date=c.getString(c.getColumnIndex("data"));
            obs = c.getString(c.getColumnIndex("obs"));
            nota=c.getFloat(c.getColumnIndex("nota"));
        }
        Trabalho trabalho = new Trabalho(date,id);
        return trabalho;
    }
}
