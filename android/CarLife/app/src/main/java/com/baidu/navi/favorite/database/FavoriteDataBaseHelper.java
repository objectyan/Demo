package com.baidu.navi.favorite.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.carlife.core.C1260i;

public class FavoriteDataBaseHelper extends SQLiteOpenHelper {
    private static final String TAG = FavoriteDataBaseHelper.class.getSimpleName();

    public FavoriteDataBaseHelper(Context context) {
        super(context, FavoriteDataBaseConstants.DATABASE_NAME, null, 1);
        C1260i.b(TAG, "db FavoriteDataBaseHelper()");
    }

    public void onCreate(SQLiteDatabase db) {
        C1260i.b(TAG, "db = " + db);
        try {
            db.execSQL(FavoriteDataBaseConstants.CREATE_FAVORITE_POI_TABLE);
        } catch (Exception e) {
            C1260i.b(TAG, "db onCreate exception");
        }
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
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
