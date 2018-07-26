package com.baidu.navi.track.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.carlife.core.C1260i;

public class DataBaseHelper extends SQLiteOpenHelper {
    private static final String TAG = "DataBaseHelper";

    public DataBaseHelper(Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DataBaseHelper(Context context) {
        super(context, DataBaseConstants.DATABASE_NAME, null, 1);
        C1260i.b(TAG, "db DataBaseHelper()");
    }

    public void onCreate(SQLiteDatabase db) {
        C1260i.b(TAG, "db = " + db);
        try {
            db.execSQL(DataBaseConstants.CREATE_TRACK_CAR_TABLE);
        } catch (Exception e) {
            C1260i.b(TAG, "db onCreate exception");
        }
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        C1260i.b(TAG, "lodVersion = " + oldVersion + ", newVersion = " + newVersion);
        try {
            db.execSQL(DataBaseConstants.DELETE_TRACK_CAR_TABLE);
            onCreate(db);
        } catch (Exception e) {
            C1260i.b(TAG, "db onUpgrade exception");
        }
        C1260i.b(TAG, "db onUpgrade");
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        C1260i.b(TAG, "db onDowngrade");
    }

    public SQLiteDatabase getReadableDatabase() {
        SQLiteDatabase db = null;
        try {
            db = super.getReadableDatabase();
        } catch (Exception e) {
            C1260i.b(TAG, "db getReadableDatabase exception");
        }
        return db;
    }

    public SQLiteDatabase getWritableDatabase() {
        SQLiteDatabase db = null;
        try {
            db = super.getWritableDatabase();
        } catch (Exception e) {
            C1260i.b(TAG, "db getWritableDatabase exception");
        }
        return db;
    }
}
