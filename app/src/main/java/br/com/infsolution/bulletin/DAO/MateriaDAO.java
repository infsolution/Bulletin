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
        super(context, ControlVersionDB.dbName, null, ControlVersionDB.version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE tab_materias "+
                "(id_materia INTEGER PRIMARY KEY AUTOINCREMENT, "+
                "nome VARCHAR (45), professor VARCHAR (45), media DOUBLE, " +
                "foto VARCHAR (60));";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS tab_materias;";
        db.execSQL(sql);
        onCreate(db);
    }
    public void inserir(Materia materia){
        ContentValues ps = new ContentValues();
        ps.put("nome", materia.getNome());
        ps.put("professor", materia.getProfessor());
        ps.put("media", materia.getMedia());
        ps.put("foto",materia.getFoto());
        getWritableDatabase().insert("tab_materias", null, ps);

    }
    public List<Materia> lista(){
        List<Materia> materias = new ArrayList<>();
        String sql = "SELECT * FROM tab_materias;";
        Cursor c = getReadableDatabase().rawQuery(sql,null);
        while (c.moveToNext()){
            int id = c.getInt(c.getColumnIndex("id_materia"));
            String nome = c.getString(c.getColumnIndex("nome"));
            String professor = c.getString(c.getColumnIndex("professor"));
            double media = c.getDouble(c.getColumnIndex("media"));
            String foto = c.getString(c.getColumnIndex("foto"));
            Materia m = new Materia(nome);
            m.setId(id);
            m.setProfessor(professor);
            m.setMedia(media);
            m.setFoto(foto);
            materias.add(m);
        }

        return materias;
    }


}
