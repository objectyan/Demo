package com.baidu.navisdk.util.db;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.navisdk.util.common.LogUtil;

public class DBHelper
  extends SQLiteOpenHelper
{
  private static final String DATABASE_NAME = "navi.common.db";
  private static final int DATABASE_VERSION = 3;
  private static final String IS_FIRST_TIME_RUN = "IS_FIRST_TIME_RUN";
  
  public DBHelper(Context paramContext)
  {
    super(paramContext, "navi.common.db", null, 3);
    paramContext = paramContext.getSharedPreferences("navi.common.db.config", 0);
    if (paramContext.getBoolean("IS_FIRST_TIME_RUN", true))
    {
      SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
      if (localSQLiteDatabase != null)
      {
        onCreate(localSQLiteDatabase);
        localSQLiteDatabase.close();
      }
      paramContext = paramContext.edit();
      paramContext.putBoolean("IS_FIRST_TIME_RUN", false);
      paramContext.commit();
    }
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    LogUtil.e(DBManager.class.getName(), "db create!");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS route_plan_node(routeplan_id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,description TEXT,latitude INTEGER DEFAULT 0,longitude INTEGER DEFAULT 0,is_from INTEGER DEFAULT 0, poi_origin_uid TEXT,arg1 INTEGER DEFAULT 0,arg2 INTEGER DEFAULT 0);");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS search_name(search_name_id INTEGER PRIMARY KEY AUTOINCREMENT,search_name_name text,search_count INTEGER);");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS navi_route(navi_route_id INTEGER PRIMARY KEY AUTOINCREMENT,navi_route_time INTEGER);");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS route_custom(route_custom_id INTEGER PRIMARY KEY AUTOINCREMENT,his_route_id INTEGER, route_name TEXT, is_open INTEGER, push_time_hour INTEGER, push_time_minute INTEGER, push_time_mills INTEGER, route_custom_time INTEGER, route_modified_time INTEGER, dest_type INTEGER, is_repeat INTEGER, repeat_date TEXT );");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS favorite_route_plan_node(routeplan_id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,description TEXT,latitude INTEGER DEFAULT 0,longitude INTEGER DEFAULT 0,is_from INTEGER DEFAULT 0, poi_origin_uid TEXT,arg1 INTEGER DEFAULT 0,arg2 INTEGER DEFAULT 0);");
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    LogUtil.e(DBManager.class.getName(), "Upgrading database from version " + paramInt1 + " to " + paramInt2 + ", which will destroy all old data");
    if ((paramInt1 == 1) && (paramInt2 == 2)) {
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS route_custom(route_custom_id INTEGER PRIMARY KEY AUTOINCREMENT,his_route_id INTEGER, route_name TEXT, is_open INTEGER, push_time_hour INTEGER, push_time_minute INTEGER, push_time_mills INTEGER, route_custom_time INTEGER, route_modified_time INTEGER, dest_type INTEGER, is_repeat INTEGER, repeat_date TEXT );");
    }
    if ((paramInt1 == 2) && (paramInt2 == 3)) {
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS favorite_route_plan_node(routeplan_id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,description TEXT,latitude INTEGER DEFAULT 0,longitude INTEGER DEFAULT 0,is_from INTEGER DEFAULT 0, poi_origin_uid TEXT,arg1 INTEGER DEFAULT 0,arg2 INTEGER DEFAULT 0);");
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/db/DBHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */