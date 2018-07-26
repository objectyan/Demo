package com.baidu.tts.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/* compiled from: ModelDbHelper */
/* renamed from: com.baidu.tts.database.b */
public class C5069b extends SQLiteOpenHelper {
    public C5069b(Context context) {
        this(context, "ttsModel.db", null, 1);
    }

    public C5069b(Context context, String str, CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SpeechModelTable.m17200a());
        db.execSQL(ModelFileTable.m17195a());
        db.execSQL(FsFileInfoTable.m17190a());
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SpeechModelTable.m17202b());
        db.execSQL(ModelFileTable.m17197b());
        db.execSQL(FsFileInfoTable.m17191b());
        onCreate(db);
    }
}
