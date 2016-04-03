package br.com.infsolution.bulletin.DAO;

/**
 * Created by Cicero on 29/03/2016.
 */
public class ControlVersionDB {
    static int version=13;
    static String dbName="Boletim.db";
    public ControlVersionDB(){

    }

    public static int getVersion() {
        return version;
    }

    public static void setVersion(int version) {
        ControlVersionDB.version = version;
    }

    public static String getDbName() {
        return dbName;
    }

    public static void setDbName(String dbName) {
        ControlVersionDB.dbName = dbName;
    }
}
