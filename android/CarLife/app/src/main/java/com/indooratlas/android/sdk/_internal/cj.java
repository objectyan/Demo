package com.indooratlas.android.sdk._internal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;

public final class cj
  extends SQLiteOpenHelper
{
  private static AtomicInteger a = new AtomicInteger();
  
  private cj(Context paramContext)
  {
    super(paramContext, "com_indooratlas_sdk.db", null, 3);
    paramContext = a();
    if (paramContext != null) {}
    for (paramContext = Integer.valueOf(paramContext.getVersion());; paramContext = "null") {
      return;
    }
  }
  
  public static cj a(Context paramContext)
  {
    try
    {
      a.incrementAndGet();
      paramContext = new cj(paramContext);
      return paramContext;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void a(SQLiteDatabase paramSQLiteDatabase)
  {
    if (paramSQLiteDatabase == null) {
      return;
    }
    try
    {
      paramSQLiteDatabase.endTransaction();
      return;
    }
    catch (SQLiteException paramSQLiteDatabase)
    {
      new StringBuilder("endTransactionSafely, SQLiteException: ").append(paramSQLiteDatabase.toString());
    }
  }
  
  public final SQLiteDatabase a()
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
      return localSQLiteDatabase;
    }
    catch (SQLiteException localSQLiteException)
    {
      ee.a("IAStorage", "Failed to get writable database: " + localSQLiteException.toString(), new Object[0]);
    }
    return null;
  }
  
  public final SQLiteDatabase b()
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = getReadableDatabase();
      return localSQLiteDatabase;
    }
    catch (SQLiteException localSQLiteException)
    {
      ee.a("IAStorage", "Failed to get readable database: " + localSQLiteException.toString(), new Object[0]);
    }
    return null;
  }
  
  public final void c()
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = a();
      if (localSQLiteDatabase != null)
      {
        String[] arrayOfString = a.a;
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          localSQLiteDatabase.delete(arrayOfString[i], null, null);
          i += 1;
        }
      }
      localSQLiteDatabase = a();
      if (localSQLiteDatabase != null) {
        onCreate(localSQLiteDatabase);
      }
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      ee.a("IAStorage", "handleDatabaseFullException failed: " + localSQLiteException.toString(), new Object[0]);
    }
  }
  
  public final void close()
  {
    try
    {
      a.decrementAndGet();
      super.close();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE event (_id INTEGER PRIMARY KEY AUTOINCREMENT, type INTEGER NOT NULL,data TEXT NOT NULL,sync_batch_id TEXT,sync_status TEXT)");
  }
  
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    paramInt2 = 0;
    if (paramInt1 != 3)
    {
      String[] arrayOfString = a.a;
      int i = arrayOfString.length;
      paramInt1 = paramInt2;
      while (paramInt1 < i)
      {
        String str = arrayOfString[paramInt1];
        paramSQLiteDatabase.execSQL("drop table if exists " + str);
        paramInt1 += 1;
      }
      onCreate(paramSQLiteDatabase);
    }
  }
  
  static abstract interface a
  {
    public static final String[] a = { "event" };
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/cj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */