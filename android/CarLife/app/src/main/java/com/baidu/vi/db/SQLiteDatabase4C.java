package com.baidu.vi.db;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class SQLiteDatabase4C
{
  private static SQLiteDatabase database;
  
  public static boolean closeDB()
  {
    if (isDBExists()) {
      database.close();
    }
    return true;
  }
  
  public static SQLiteStatement4C compileStatement(String paramString)
  {
    if (database.isOpen()) {
      return new SQLiteStatement4C(database, paramString);
    }
    return null;
  }
  
  public static SQLiteDatabase getSQLiteDatabase()
  {
    return database;
  }
  
  public static boolean isDBExists()
  {
    return database != null;
  }
  
  public static boolean isTableExists(String paramString)
  {
    paramString = database.query("sqlite_master", new String[] { "[sql]" }, "[type] = 'table' and name = ?", new String[] { paramString }, null, null, null);
    if (paramString.getCount() == 1) {}
    for (boolean bool = true;; bool = false) {
      try
      {
        paramString.close();
        return bool;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
    return bool;
  }
  
  public static boolean isThreadSafe()
  {
    return true;
  }
  
  public static boolean openDB(String paramString)
  {
    database = SQLiteDatabase.openOrCreateDatabase(paramString, null);
    return database.isOpen();
  }
  
  public static boolean transactionBegin()
  {
    try
    {
      database.execSQL("BEGIN EXCLUSIVE;");
      return true;
    }
    catch (SQLException localSQLException) {}
    return false;
  }
  
  public static boolean transactionCommit()
  {
    try
    {
      database.execSQL("COMMIT;");
      return true;
    }
    catch (SQLException localSQLException) {}
    return false;
  }
  
  public static boolean transactionRollback()
  {
    try
    {
      database.execSQL("ROLLBACK;");
      return true;
    }
    catch (SQLException localSQLException) {}
    return false;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/vi/db/SQLiteDatabase4C.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */