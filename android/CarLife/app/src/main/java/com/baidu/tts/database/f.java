package com.baidu.tts.database;

import android.database.sqlite.SQLiteDatabase;

public class f
{
  private SQLiteDatabase a;
  private a b;
  
  public f(SQLiteDatabase paramSQLiteDatabase, a parama)
  {
    this.a = paramSQLiteDatabase;
    this.b = parama;
  }
  
  public boolean a()
  {
    boolean bool3 = false;
    bool2 = false;
    bool1 = bool2;
    if (this.b != null)
    {
      bool1 = bool2;
      if (this.a != null) {
        bool2 = bool3;
      }
    }
    try
    {
      this.a.beginTransaction();
      bool2 = bool3;
      bool3 = this.b.a(this.a);
      if (bool3)
      {
        bool2 = bool3;
        this.a.setTransactionSuccessful();
      }
      bool1 = bool3;
      if (this.a != null)
      {
        this.a.endTransaction();
        this.a.close();
        bool1 = bool3;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      bool1 = bool2;
      return bool2;
    }
    finally
    {
      if (this.a == null) {
        break label142;
      }
      this.a.endTransaction();
      this.a.close();
    }
    return bool1;
  }
  
  public static abstract interface a
  {
    public abstract boolean a(SQLiteDatabase paramSQLiteDatabase);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/database/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */