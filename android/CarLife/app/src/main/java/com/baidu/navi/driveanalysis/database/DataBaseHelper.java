package com.baidu.navi.driveanalysis.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.carlife.core.C1260i;
import com.baidu.navi.driveanalysis.CommonConstants;

public class DataBaseHelper extends SQLiteOpenHelper {
    private static final String TAG = DataBaseHelper.class.getSimpleName();

    public DataBaseHelper(Context context) {
        super(context, CommonConstants.DATABASE_NAME, null, 1);
    }

    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(CommonConstants.CREATE_TRACK_DATA_TABLE);
        } catch (Exception e) {
            C1260i.b(TAG, "db onCreate exception");
        }
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
