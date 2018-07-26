package com.baidu.tts.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/* compiled from: StatisticsDbHelper */
/* renamed from: com.baidu.tts.database.c */
public class C5070c extends SQLiteOpenHelper {
    public C5070c(Context context) {
        this(context, "Statistics.db", null, 1);
    }

    public C5070c(Context context, String str, CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(C5072e.m17224a());
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(C5072e.m17225b());
        onCreate(db);
    }
}
