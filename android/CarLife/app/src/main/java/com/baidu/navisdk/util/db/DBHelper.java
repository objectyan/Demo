package com.baidu.navisdk.util.db;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.db.table.FavoriteRoutePlanNodeDBTable;
import com.baidu.navisdk.util.db.table.NaviRouteDBTable;
import com.baidu.navisdk.util.db.table.RouteCustomDBTable;
import com.baidu.navisdk.util.db.table.RoutePlanNodeDBTable;
import com.baidu.navisdk.util.db.table.SearchNameDBTable;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "navi.common.db";
    private static final int DATABASE_VERSION = 3;
    private static final String IS_FIRST_TIME_RUN = "IS_FIRST_TIME_RUN";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 3);
        SharedPreferences sp = context.getSharedPreferences("navi.common.db.config", 0);
        if (sp.getBoolean(IS_FIRST_TIME_RUN, true)) {
            SQLiteDatabase db = getWritableDatabase();
            if (db != null) {
                onCreate(db);
                db.close();
            }
            Editor editor = sp.edit();
            editor.putBoolean(IS_FIRST_TIME_RUN, false);
            editor.commit();
        }
    }

    public void onCreate(SQLiteDatabase db) {
        LogUtil.m15791e(DBManager.class.getName(), "db create!");
        db.execSQL(RoutePlanNodeDBTable.DATABASE_CREATE);
        db.execSQL(SearchNameDBTable.DATABASE_CREATE);
        db.execSQL(NaviRouteDBTable.DATABASE_CREATE);
        db.execSQL(RouteCustomDBTable.DATABASE_CREATE);
        db.execSQL(FavoriteRoutePlanNodeDBTable.DATABASE_CREATE);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        LogUtil.m15791e(DBManager.class.getName(), "Upgrading database from version " + oldVersion + " to " + newVersion + ", which will destroy all old data");
        if (oldVersion == 1 && newVersion == 2) {
            db.execSQL(RouteCustomDBTable.DATABASE_CREATE);
        }
        if (oldVersion == 2 && newVersion == 3) {
            db.execSQL(FavoriteRoutePlanNodeDBTable.DATABASE_CREATE);
        }
    }
}
