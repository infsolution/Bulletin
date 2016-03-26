package br.com.infsolution.bulletin.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import br.com.infsolution.bulletin.Model.Agenda;

/**
 * Created by Cicero on 24/03/2016.
 */
public class AgendaDAO  extends SQLiteOpenHelper {

    public AgendaDAO(Context context) {
        super(context, "Boletim.db", null, 3);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE paginas(id_pagina INTEGER PRIMARY KEY AUTOINCREMENT," +
                "data VARCHAR (10), titulo VARCHAR (255), assunto TEXT);";

        db.execSQL(sql);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS paginas;";
        db.execSQL(sql);
        onCreate(db);
    }

    public void inserir(Agenda agenda){
        ContentValues ps = new ContentValues();
        ps.put("id_pagina", agenda.getId_pagina());
        ps.put("data",agenda.getData());
        ps.put("titulo",agenda.getTitulo());
        ps.put("assunto", agenda.getAssunto());
        getWritableDatabase().insert("paginas", null, ps);
    }
    public List<Agenda> lista(){
        List<Agenda> agenda = new ArrayList<>();
        String sql = "SELECT * FROM paginas;";
        Cursor c = getReadableDatabase().rawQuery(sql,null);
        while (c.moveToNext()){
            int id = c.getInt(c.getColumnIndex("id_pagina"));
            String data = c.getString(c.getColumnIndex("data"));
            String titulo = c.getString(c.getColumnIndex("titulo"));
            String assunto = c.getString(c.getColumnIndex("assunto"));
            Agenda ag = new Agenda();
            ag.setId_pagina(id);
            ag.setData(data);
            ag.setTitulo(titulo);
            ag.setAssunto(assunto);
            agenda.add(ag);
        }

        return agenda;
    }

}