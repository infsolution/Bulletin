package br.com.infsolution.bulletin.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import br.com.infsolution.bulletin.Model.Horario;

/**
 * Created by Cicero on 24/03/2016.
 */
public class HorarioDAO extends SQLiteOpenHelper {
    public HorarioDAO(Context context) {
        super(context, "Boletim.db", null, 3);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE horarios(id_horario INTEGER PRIMARY KEY AUTOINCREMENT," +
                "turno VARCHAR (10)";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS horarios;";
        db.execSQL(sql);
        onCreate(db);
    }
    public void inserir(Horario horario){
        ContentValues ps = new ContentValues();
        ps.put("turno", horario.getTurno());
        getWritableDatabase().insert("horarios", null, ps);
    }

    public Horario upHorario(){
        String sql = "SELECT * FROM horarios;";
        Cursor c = getReadableDatabase().rawQuery(sql,null);
        int id=0;
        String turno="";
        if(c.moveToNext()) {
            id = c.getInt(c.getColumnIndex("id_horario"));
            turno = c.getString(c.getColumnIndex("turno"));
        }
        Horario horario= new Horario(id,turno);
        return horario;
    }
}
