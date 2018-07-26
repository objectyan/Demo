package com.baidu.navi.driveanalysis.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.navi.track.database.DataBaseHelper;

public class DataBaseManager {
    private final String TAG = DataBaseManager.class.getSimpleName();
    private SQLiteDatabase mDB;
    private DataBaseHelper mHelper;

    public DataBaseManager(Context context) {
        this.mHelper = new DataBaseHelper(context);
    }

    public void openDataBase() {
        this.mDB = this.mHelper.getWritableDatabase();
    }

    public void closeDataBase() {
        if (this.mDB != null && this.mDB.isOpen()) {
            this.mDB.close();
        }
    }

    public void executeQurey(QueryExecutor executor) {
        executor.run(this.mDB);
    }
}
