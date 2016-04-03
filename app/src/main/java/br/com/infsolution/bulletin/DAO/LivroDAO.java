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
public class LivroDAO extends SQLiteOpenHelper {
    public LivroDAO(Context context) {
        super(context, ControlVersionDB.dbName, null, ControlVersionDB.version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql ="CREATE TABLE livros(" +
                "id_livro INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "titulo VARCHAR (45), autor VARCHAR (45), assunto TEXT);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS livros;";
        db.execSQL(sql);
        onCreate(db);
    }

    public void inserir(Livro livro){
        ContentValues ps = new ContentValues();
        ps.put("titulo",livro.getTitulo());
        ps.put("autor",livro.getAutor());
        ps.put("assunto",livro.getAssunto());
        getWritableDatabase().insert("livros", null, ps);
    }

    public List<Livro> lista(){
        List<Livro> livros = new ArrayList<>();
        String sql = "SELECT * FROM livros;";
        Cursor c = getReadableDatabase().rawQuery(sql,null);
        while (c.moveToNext()){
            int id = c.getInt(c.getColumnIndex("id_livro"));
            String titulo = c.getString(c.getColumnIndex("titulo"));
            String autor = c.getString(c.getColumnIndex("autor"));
            String assunto = c.getString(c.getColumnIndex("assunto"));
            Livro p = new Livro(titulo, autor);
            p.setId(id);
            p.setAssunto(assunto);
            livros.add(p);
        }
        return livros;
}
    public List<Livro> listaForMateria(List<Integer> id_livros){
        List<Livro> livros = new ArrayList<>();
        for(int i=0;i<id_livros.size();i++){
            String sql = "SELECT * FROM livros WHERE id_livro = "+id_livros.get(9)+";";
            Cursor c = getReadableDatabase().rawQuery(sql,null);
            if(c.moveToFirst()){
                int id = c.getInt(c.getColumnIndex("id_livro"));
                String titulo = c.getString(c.getColumnIndex("titulo"));
                String autor = c.getString(c.getColumnIndex("autor"));
                String assunto = c.getString(c.getColumnIndex("assunto"));
                Livro p = new Livro(titulo, autor);
                p.setId(id);
                p.setAssunto(assunto);
                livros.add(p);
            }
        }



        return livros;
}
}
