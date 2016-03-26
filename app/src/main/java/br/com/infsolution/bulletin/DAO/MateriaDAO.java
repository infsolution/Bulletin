package br.com.infsolution.bulletin.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import br.com.infsolution.bulletin.Model.Materia;

/**
 * Created by Cicero on 24/03/2016.
 */
public class MateriaDAO extends SQLiteOpenHelper {
    public MateriaDAO(Context context) {
        super(context, "Boletim.db", null, 3);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE materias(id_materia INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nome VARCHAR (45), professor VARCHAR (45), media REAL);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS materias;";
        db.execSQL(sql);
        onCreate(db);
    }
    public void inserir(Materia materia){
        ContentValues ps = new ContentValues();
        ps.put("nome", materia.getNome());
        ps.put("professor", materia.getProfessor());
        ps.put("media", materia.getMedia());
        getWritableDatabase().insert("pessoas", null, ps);

    }
    public List<Materia> lista(){
        List<Materia> materias = new ArrayList<>();
        String sql = "SELECT * FROM materias;";
        Cursor c = getReadableDatabase().rawQuery(sql,null);
        while (c.moveToNext()){
            int id = c.getInt(c.getColumnIndex("id_materia"));
            String nome = c.getString(c.getColumnIndex("nome"));
            String professor = c.getString(c.getColumnIndex("professor"));
            double media = c.getDouble(c.getColumnIndex("media"));
            Materia m = new Materia(nome);
            m.setId(id);
            m.setProfessor(professor);
            m.setMedia(media);
            materias.add(m);
        }

        return materias;
    }


}
