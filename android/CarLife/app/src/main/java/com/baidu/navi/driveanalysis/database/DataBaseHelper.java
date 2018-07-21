package com.baidu.navi.driveanalysis.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.carlife.core.i;

public class DataBaseHelper
  extends SQLiteOpenHelper
{
  private static final String TAG = DataBaseHelper.class.getSimpleName();
  
  public DataBaseHelper(Context paramContext)
  {
    super(paramContext, "driveAnalysis.db", null, 1);
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS TrackDataTable(guid TEXT PRIMARY KEY,latitude REAL,longitude REAL,coordType INTEGER,speed REAL,direction INTEGER,height REAL,radius REAL,localTime INTEGER)");
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      i.b(TAG, "db onCreate exception");
    }
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/driveanalysis/database/DataBaseHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */