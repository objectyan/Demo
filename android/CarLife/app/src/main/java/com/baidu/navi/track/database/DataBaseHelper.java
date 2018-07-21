package com.baidu.navi.track.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.carlife.core.i;

public class DataBaseHelper
  extends SQLiteOpenHelper
{
  private static final String TAG = "DataBaseHelper";
  
  public DataBaseHelper(Context paramContext)
  {
    super(paramContext, "tracks.db", null, 1);
    i.b("DataBaseHelper", "db DataBaseHelper()");
  }
  
  public DataBaseHelper(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt)
  {
    super(paramContext, paramString, paramCursorFactory, paramInt);
  }
  
  public SQLiteDatabase getReadableDatabase()
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = super.getReadableDatabase();
      return localSQLiteDatabase;
    }
    catch (Exception localException)
    {
      i.b("DataBaseHelper", "db getReadableDatabase exception");
    }
    return null;
  }
  
  public SQLiteDatabase getWritableDatabase()
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = super.getWritableDatabase();
      return localSQLiteDatabase;
    }
    catch (Exception localException)
    {
      i.b("DataBaseHelper", "db getWritableDatabase exception");
    }
    return null;
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    i.b("DataBaseHelper", "db = " + paramSQLiteDatabase);
    try
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS Track_Car( guid TEXT PRIMARY KEY UNIQUE ,type TEXT ,car_cuid TEXT ,car_channel TEXT ,car_version TEXT ,isconnect INTEGER DEFAULT 0,ctime INTEGER DEFAULT 0,modifyTime INTEGER DEFAULT 0,sid TEXT ,action_state INTEGER DEFAULT 0,useid TEXT ,sign TEXT ,start_lng REAL ,start_lat REAL ,start_addr TEXT ,end_lng REAL ,end_lat REAL ,end_addr TEXT ,distance INTEGER DEFAULT 0,duration INTEGER DEFAULT 0,avg_speed REAL DEFAULT 0,maxSpeed REAL DEFAULT 0,sdcard_path TEXT )");
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      i.b("DataBaseHelper", "db onCreate exception");
    }
  }
  
  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    i.b("DataBaseHelper", "db onDowngrade");
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    i.b("DataBaseHelper", "lodVersion = " + paramInt1 + ", newVersion = " + paramInt2);
    try
    {
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS Track_Car");
      onCreate(paramSQLiteDatabase);
      i.b("DataBaseHelper", "db onUpgrade");
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      for (;;)
      {
        i.b("DataBaseHelper", "db onUpgrade exception");
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/track/database/DataBaseHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */