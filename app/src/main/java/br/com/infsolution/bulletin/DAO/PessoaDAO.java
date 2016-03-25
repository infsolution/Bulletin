package br.com.infsolution.bulletin.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import br.com.infsolution.bulletin.Model.Pessoa;

/**
 * Created by Cicero on 21/03/2016.
 */
public class PessoaDAO extends SQLiteOpenHelper{
    public PessoaDAO(Context context) {
        super(context, "Boletim.db", null, 3);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="CREATE TABLE pessoas"+
                "(id_pessoa INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nome VARCHAR (45), matricula VARCHAR (12));";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS pessoas;";
        db.execSQL(sql);
        onCreate(db);
    }
    public void inserir(Pessoa pessoa){
        ContentValues ps = new ContentValues();
        ps.put("nome", pessoa.getNome());
        ps.put("matricula", pessoa.getMatricula());
        getWritableDatabase().insert("pessoas", null, ps);

    }
    public List<Pessoa> lista(){
        List<Pessoa> pessoas = new ArrayList<>();
        String sql = "SELECT * FROM pessoas;";
        Cursor c = getReadableDatabase().rawQuery(sql,null);

        while (c.moveToNext()){
            int id = c.getInt(c.getColumnIndex("id_pessoa"));
            String nome = c.getString(c.getColumnIndex("nome"));
            String matricula = c.getString(c.getColumnIndex("matricula"));
            Pessoa p = new Pessoa(nome, matricula);
            p.setId(id);
            pessoas.add(p);
        }

        return pessoas;
    }
    public String setWelcome(){
        String sql = "select * from pessoas;";
        Cursor c = getReadableDatabase().rawQuery(sql,null);
        String nome;
        if(c.moveToNext()) {
             nome = c.getString(c.getColumnIndex("nome"));
        }else{
            nome="Visitante!";
        }
        return nome;
    }
    public Pessoa buscPessoa(){
        String nome="";
        String matricula="";
        String sql="SELECT * FROM pessoas;";
        Cursor c = getReadableDatabase().rawQuery(sql, null);
        if(c.moveToFirst()){
            int id = c.getInt(c.getColumnIndex("id_pessoa"));
            nome = c.getString(c.getColumnIndex("nome"));
            matricula = c.getString(c.getColumnIndex("matricla"));
        }
        Pessoa pessoa = new Pessoa(nome,matricula);
        return pessoa;
    }

    public  void delPessoa(Pessoa pessoa){
        String [] dados = {""+pessoa.getId()};
        getWritableDatabase().delete("pessoa","id_pessoa = ?",dados);
    }
}
