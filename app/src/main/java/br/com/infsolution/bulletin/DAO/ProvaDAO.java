package br.com.infsolution.bulletin.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import br.com.infsolution.bulletin.Model.Avaliacao;
import br.com.infsolution.bulletin.Model.Prova;

/**
 * Created by Cicero on 24/03/2016.
 */
public class ProvaDAO extends SQLiteOpenHelper {
    public ProvaDAO(Context context) {
        super(context, "Boletim.db", null, ControlVersionDB.version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="CREATE TABLE provas(id_prova INTEGER PRIMARY KEY AUTOINCREMENT" +
                "id_materia INTEGER, data VARCHAR (10), obs TEXT, nota REAL)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS provas;";
        db.execSQL(sql);
        onCreate(db);
    }

    public void inserir(Prova prova){
        ContentValues cv = new ContentValues();
        cv.put("id_materia",prova.getId_materia());
        cv.put("data",prova.getDate());
        cv.put("obs",prova.getObs());
        cv.put("nota", prova.getNota());
        getWritableDatabase().insert("provas", null, cv);
    }
    public List<Prova> listaProvas(int id_materia){
        List<Prova> provas = new ArrayList<>();
        String sql = "SELECT * FROM provas WHERE id_materia = "+id_materia+";";
        Cursor c = getReadableDatabase().rawQuery(sql,null);

        while (c.moveToNext()){
            int id = c.getInt(c.getColumnIndex("id_pessoa"));
            int idmateria = c.getInt(c.getColumnIndex("id_materia"));
            String date = c.getString(c.getColumnIndex("data"));
            String obs = c.getString(c.getColumnIndex("obs"));
            float nota = c.getFloat(c.getColumnIndex("nota"));
            Prova p = new Prova(date,idmateria);
            p.setId(id);
            p.setObs(obs);
            p.setNota(nota);
            provas.add(p);
        }

        return provas;
    }
    public Prova anProva(String data, int id_materia){
        String sql = "SELECT * FROM provas WHERE data = "+data+" AND id_materia = "+id_materia+";";
        Cursor c = getReadableDatabase().rawQuery(sql,null);
        String obs="";
        String date="";
        int id=0;
        int id_prova=0;
        float nota=0;
        if(c.moveToNext()) {
            id_prova=c.getInt(c.getColumnIndex("id_prova"));
            id=c.getInt(c.getColumnIndex("id_materia"));
            date = c.getString(c.getColumnIndex("data"));
            obs = c.getString(c.getColumnIndex("obs"));
            nota=c.getFloat(c.getColumnIndex("nota"));
        }
        Prova prova = new Prova(date,id);
        prova.setId(id_prova);
        prova.setObs(obs);
        prova.setNota(nota);
        return prova;
    }

}
