package br.com.infsolution.bulletin.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import br.com.infsolution.bulletin.Model.Conteudo;


/**
 * Created by Cicero on 25/03/2016.
 */
public class ConteudoDAO extends SQLiteOpenHelper{
    public ConteudoDAO(Context context) {
        super(context, "Boletim.db", null, ControlVersionDB.version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE conteudos(" +
                "id_conteudo INTEGER PRIMARY KEY AUTOINCREMENT," +
                "id_prova INTEGER, id_trabalho INTEGER, conteudo TEXT)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS couteudos;";
        db.execSQL(sql);
        onCreate(db);
    }
    public void inserir(Conteudo conteudo){
        ContentValues cv = new ContentValues();
        cv.put("id_prova", conteudo.getId_prova());
        cv.put("id_trabalho", conteudo.getId_trabalho());
        cv.put("conteudo", conteudo.getConteudo());
        getWritableDatabase().insert("conteudos", null, cv);

    }
    public List<Conteudo> lista(String tipo,int  id){
        List<Conteudo> conteudos = new ArrayList<>();
        String sql = "SELECT * FROM conteudos WHERE id_"+tipo+" = "+id+";";
        Cursor c = getReadableDatabase().rawQuery(sql,null);

        while (c.moveToNext()){
            int id_ava = c.getInt(c.getColumnIndex("id_conteudo"));
            String conteudo = c.getString(c.getColumnIndex("conteudo"));
            Conteudo ct = new Conteudo();
            ct.setId(id_ava);
            ct.setConteudo(conteudo);
            conteudos.add(ct);
        }

        return conteudos;
    }
}
