package br.com.infsolution.bulletin.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import br.com.infsolution.bulletin.Model.Aula;
import br.com.infsolution.bulletin.Model.Materia;

/**
 * Created by Cicero on 24/03/2016.
 */
public class AulaDAO extends SQLiteOpenHelper {
    public AulaDAO(Context context) {
        super(context, "Boletim.db", null,ControlVersionDB.version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table aulas (id_aula INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "materia VARCHAR (45),data VARCHAR (12), dia VARCHAR (10),hora VARCHAR (6), " +
                "id_horario INTEGER, topicos TEXT, obs TEXT);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS aulas;";
        db.execSQL(sql);
        onCreate(db);
    }

    public void inserir(Aula aula) {
        ContentValues cv = new ContentValues();
        cv.put("materia", aula.getMateria().getNome());
        cv.put("data", aula.getDate());
        cv.put("dia", aula.getDia());
        cv.put("hora", aula.getHora());
        cv.put("id_horario", aula.getId_horario());
        cv.put("topicos", aula.getTopicos());
        cv.put("obs", aula.getObs());
        getWritableDatabase().insert("aulas", null, cv);

    }

    public List<Aula> lista(int id_horario) {
        List<Aula> aulas = new ArrayList<>();
        String sql = "SELECT * FROM aulas WHERE id_horario = " + id_horario + ";";
        Cursor c = getReadableDatabase().rawQuery(sql, null);

        while (c.moveToNext()) {
            int id = c.getInt(c.getColumnIndex("id_aula"));
            String nomeMat = c.getString(c.getColumnIndex("materia"));
            String dia = c.getString(c.getColumnIndex("dia"));
            String hora = c.getString(c.getColumnIndex("hora"));
            Materia materia = new Materia(nomeMat);
            Aula a = new Aula(materia,dia, hora);
            a.setId(id);
            aulas.add(a);
        }
        return aulas;
    }
}