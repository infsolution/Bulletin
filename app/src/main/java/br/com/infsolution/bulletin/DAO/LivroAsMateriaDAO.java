package br.com.infsolution.bulletin.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import br.com.infsolution.bulletin.Model.Livro;
import br.com.infsolution.bulletin.Model.Materia;

/**
 * Created by Cicero on 24/03/2016.
 */
public class LivroAsMateriaDAO extends SQLiteOpenHelper {
    public LivroAsMateriaDAO(Context context) {
        super(context, "Boletim.db", null, ControlVersionDB.version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String  sql = "CREATE TABLE livro_materia(" +
                "id_livro_materia INTEGER PRIMARY KEY AUTOINCREMENT," +
                "id_livro INTEGER, id_materia INTEGER);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS livro_materia;";
        db.execSQL(sql);
        onCreate(db);
    }

    public void inserir(Livro livro, Materia materia){
        ContentValues ps = new ContentValues();
        ps.put("id_livro", livro.getId());
        ps.put("id_materia", materia.getId());
        getWritableDatabase().insert("livro_materia", null, ps);

    }
    public List<List> lista(){
        List<List> livros_materias = new ArrayList<>();
        String sql = "SELECT * FROM livro_materia;";
        Cursor c = getReadableDatabase().rawQuery(sql,null);
        while (c.moveToNext()){
            int id_livro = c.getInt(c.getColumnIndex("id_livro"));
            int id_materia = c.getInt(c.getColumnIndex("id_materia"));
            List<Integer>dados = new ArrayList<>();
            dados.add(id_livro);
            dados.add(id_materia);
            livros_materias.add(dados);
        }
        return livros_materias;
    }
    public List<Integer> listaLivros(Materia materia){
        List<Integer> id_livro = new ArrayList<>();
        String sql = "SELECT * FROM livro_materia WHERE id_materia = "+materia.getId()+";";
        Cursor c = getReadableDatabase().rawQuery(sql,null);
        while (c.moveToNext()){
            int id = c.getInt(c.getColumnIndex("id_livro"));
            id_livro.add(id);
        }
        return id_livro;
    }

    public List<Integer> listaMateria(Livro livro){
        List<Integer> id_materias = new ArrayList<>();
        String sql = "SELECT * FROM livro_materia WHERE id_livro = "+livro.getId()+";";
        Cursor c = getReadableDatabase().rawQuery(sql,null);
        while (c.moveToNext()){
            int id = c.getInt(c.getColumnIndex("id_livro"));
            id_materias.add(id);
        }
        return id_materias;
    }
}
