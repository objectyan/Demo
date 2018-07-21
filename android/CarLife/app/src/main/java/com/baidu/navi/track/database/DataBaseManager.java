package com.baidu.navi.track.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.carlife.BaiduNaviApplication;
import com.baidu.carlife.core.i;
import java.util.concurrent.atomic.AtomicInteger;

public class DataBaseManager
{
  private static final String TAG = "DataBaseManager";
  private static Context mContext;
  private static DataBaseManager mInstance;
  private SQLiteDatabase db;
  private DataBaseHelper mHelper;
  private AtomicInteger mUseCounter = new AtomicInteger();
  
  private DataBaseManager(Context paramContext)
  {
    this.mHelper = new DataBaseHelper(paramContext);
    try
    {
      this.db = this.mHelper.getWritableDatabase();
      return;
    }
    catch (Exception paramContext)
    {
      i.b("DataBaseManager", "DataBaseHelper getWritableDatabase exception");
    }
  }
  
  /* Error */
  private void closeDataBase()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 30	com/baidu/navi/track/database/DataBaseManager:mUseCounter	Ljava/util/concurrent/atomic/AtomicInteger;
    //   6: invokevirtual 56	java/util/concurrent/atomic/AtomicInteger:decrementAndGet	()I
    //   9: ifne +29 -> 38
    //   12: aload_0
    //   13: getfield 42	com/baidu/navi/track/database/DataBaseManager:db	Landroid/database/sqlite/SQLiteDatabase;
    //   16: ifnull +22 -> 38
    //   19: aload_0
    //   20: getfield 42	com/baidu/navi/track/database/DataBaseManager:db	Landroid/database/sqlite/SQLiteDatabase;
    //   23: invokevirtual 62	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   26: istore_1
    //   27: iload_1
    //   28: ifeq +10 -> 38
    //   31: aload_0
    //   32: getfield 42	com/baidu/navi/track/database/DataBaseManager:db	Landroid/database/sqlite/SQLiteDatabase;
    //   35: invokevirtual 65	android/database/sqlite/SQLiteDatabase:close	()V
    //   38: aload_0
    //   39: monitorexit
    //   40: return
    //   41: astore_2
    //   42: ldc 8
    //   44: ldc 67
    //   46: invokestatic 50	com/baidu/carlife/core/i:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   49: goto -11 -> 38
    //   52: astore_2
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_2
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	DataBaseManager
    //   26	2	1	bool	boolean
    //   41	1	2	localException	Exception
    //   52	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   31	38	41	java/lang/Exception
    //   2	27	52	finally
    //   31	38	52	finally
    //   42	49	52	finally
  }
  
  public static DataBaseManager getInstance()
  {
    try
    {
      if (mInstance == null) {
        newInstance(BaiduNaviApplication.getInstance().getApplicationContext());
      }
      i.b("DataBaseManager", "DB Version = 1");
      DataBaseManager localDataBaseManager = mInstance;
      return localDataBaseManager;
    }
    finally {}
  }
  
  private static DataBaseManager newInstance(Context paramContext)
  {
    try
    {
      if (mInstance == null)
      {
        mContext = paramContext;
        mInstance = new DataBaseManager(paramContext);
      }
      paramContext = mInstance;
      return paramContext;
    }
    finally {}
  }
  
  private SQLiteDatabase openDataBase()
  {
    try
    {
      if (this.mUseCounter.incrementAndGet() == 1) {
        this.db = this.mHelper.getWritableDatabase();
      }
      SQLiteDatabase localSQLiteDatabase = this.db;
      return localSQLiteDatabase;
    }
    finally {}
  }
  
  public void executeQurey(QueryExecutor paramQueryExecutor)
  {
    paramQueryExecutor.run(openDataBase());
    closeDataBase();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/track/database/DataBaseManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */