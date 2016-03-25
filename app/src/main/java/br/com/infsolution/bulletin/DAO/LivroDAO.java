package br.com.infsolution.bulletin.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Cicero on 24/03/2016.
 */
public class LivroDAO extends SQLiteOpenHelper {
    public LivroDAO(Context context) {
        super(context, "Boletim.db", null, 3);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
