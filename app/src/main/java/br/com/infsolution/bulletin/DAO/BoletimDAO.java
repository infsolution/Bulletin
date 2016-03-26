package br.com.infsolution.bulletin.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import br.com.infsolution.bulletin.Model.Boletim;

/**
 * Created by Cicero on 24/03/2016.
 */
public class BoletimDAO extends SQLiteOpenHelper {
    public BoletimDAO(Context context) {
        super(context, "Boletim.db", null, 3);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE boletins(id_boletim " +
                "INTEGER PRIMARY KEY AUTOINCREMENT, ano VARCHAR (4), periodo VARCHAR (10)," +
                "escola VARCHAR (45));";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS boletins;";
        db.execSQL(sql);
        onCreate(db);
    }
    public void inserir(Boletim boletim){
        ContentValues cv = new ContentValues();
        cv.put("id", boletim.getId());
        cv.put("meta",boletim.getMeta());
        cv.put("ano",boletim.getAno());
        cv.put("periodo",boletim.getPeriodo());
        cv.put("escola", boletim.getEscola());
        getWritableDatabase().insert("boletins", null, cv);
    }

    public Boletim upBoletim(){
        String sql = "SELECT * FROM boletins;";
        Cursor c = getReadableDatabase().rawQuery(sql,null);
        int id=0;
        String ano="";
        String periodo="";
        String escola="";
        double meta=0.0;
        if(c.moveToNext()) {
            id = c.getInt(c.getColumnIndex("id_boletim"));
            ano = c.getString(c.getColumnIndex("ano"));
            periodo = c.getString(c.getColumnIndex("periodo"));
            escola = c.getString(c.getColumnIndex("escola"));
            meta = c.getDouble(c.getColumnIndex("meta"));
        }
        Boletim boletim = Boletim.getInstance();
        boletim.setId(id);
        boletim.setAno(ano);
        boletim.setPeriodo(periodo);
        boletim.setEscola(escola);
        boletim.setMeta(meta);
        return boletim;
    }
}
