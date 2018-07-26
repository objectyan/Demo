package com.baidu.navi.driveanalysis.database;

import android.database.sqlite.SQLiteDatabase;

public interface QueryExecutor {
    void run(SQLiteDatabase sQLiteDatabase);
}
