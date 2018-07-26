package com.baidu.vi.db;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class SQLiteDatabase4C {
    private static SQLiteDatabase database;

    public static SQLiteDatabase getSQLiteDatabase() {
        return database;
    }

    public static boolean openDB(String path) {
        database = SQLiteDatabase.openOrCreateDatabase(path, null);
        return database.isOpen();
    }

    public static boolean closeDB() {
        if (isDBExists()) {
            database.close();
        }
        return true;
    }

    public static boolean isDBExists() {
        return database != null;
    }

    public static boolean isTableExists(String tableName) {
        Cursor cursor = database.query("sqlite_master", new String[]{"[sql]"}, "[type] = 'table' and name = ?", new String[]{tableName}, null, null, null);
        boolean isFind = cursor.getCount() == 1;
        try {
            cursor.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return isFind;
    }

    public static SQLiteStatement4C compileStatement(String sql) {
        if (database.isOpen()) {
            return new SQLiteStatement4C(database, sql);
        }
        return null;
    }

    public static boolean transactionBegin() {
        try {
            database.execSQL("BEGIN EXCLUSIVE;");
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public static boolean transactionCommit() {
        try {
            database.execSQL("COMMIT;");
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public static boolean transactionRollback() {
        try {
            database.execSQL("ROLLBACK;");
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public static boolean isThreadSafe() {
        return true;
    }
}
