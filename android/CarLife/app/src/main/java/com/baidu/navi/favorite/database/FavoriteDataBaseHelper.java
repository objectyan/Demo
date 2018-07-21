package com.baidu.navi.favorite.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.carlife.core.i;

public class FavoriteDataBaseHelper
  extends SQLiteOpenHelper
{
  private static final String TAG = FavoriteDataBaseHelper.class.getSimpleName();
  
  public FavoriteDataBaseHelper(Context paramContext)
  {
    super(paramContext, "favorites.db", null, 1);
    i.b(TAG, "db FavoriteDataBaseHelper()");
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
      i.b(TAG, "db getReadableDatabase exception");
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
      i.b(TAG, "db getWritableDatabase exception");
    }
    return null;
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    i.b(TAG, "db = " + paramSQLiteDatabase);
    try
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS Fvorite_Poi( key TEXT PRIMARY KEY UNIQUE ,value TEXT )");
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      i.b(TAG, "db onCreate exception");
    }
  }
  
  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    i.b(TAG, "db onDowngrade");
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    i.b(TAG, "db onUpgrade");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/favorite/database/FavoriteDataBaseHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */