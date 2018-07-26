package com.baidu.navi.track.database;

import android.database.sqlite.SQLiteDatabase;

public interface QueryExecutor {
    void run(SQLiteDatabase sQLiteDatabase);
}
