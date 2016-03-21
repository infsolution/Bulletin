package br.com.infsolution.bulletin.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import br.com.infsolution.bulletin.Model.Pessoa;

/**
 * Created by Cicero on 21/03/2016.
 */
public class PessoaDAO extends SQLiteOpenHelper{
    public PessoaDAO(Context context) {
        super(context, "Boletin.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="CREATE TABLE pessoa"+
                "(id_pessoa INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nome VARCHAR(45) NOT NULL, matricula VARCHAR(12));";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS pessoa;";
        db.execSQL(sql);
        onCreate(db);
    }
    public void inserir(Pessoa pessoa){
        ContentValues ps = new ContentValues();
        ps.put("nome", pessoa.getNome());
        ps.put("montadora", pessoa.getMatricula());

        getWritableDatabase().insert("pessoa", null, ps);

    }

    public Pessoa newPessoa(){
        String sql="SELECT * pessoa";
        Cursor c = getReadableDatabase().rawQuery(sql,null);
        c.moveToFirst();
        int id_pessoa = c.getInt(c.getColumnIndex("id_pessoa"));
        String nome = c.getString(c.getColumnIndex("nome"));
        String matricula = c.getString(c.getColumnIndex("matricula"));
        Pessoa pessoa = new Pessoa(nome,matricula);
        pessoa.setId(id_pessoa);
        return pessoa;
    }

    public  void delPessoa(Pessoa pessoa){
        String [] dados = {""+pessoa.getId()};
        getWritableDatabase().delete("pessoa","=id_pessoa",dados);
    }
}
