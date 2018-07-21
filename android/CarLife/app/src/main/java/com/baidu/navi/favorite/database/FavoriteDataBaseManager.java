package com.baidu.navi.favorite.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.carlife.core.a;
import com.baidu.carlife.core.i;
import java.util.concurrent.atomic.AtomicInteger;

public class FavoriteDataBaseManager
{
  public static final String TAG = FavoriteDataBaseManager.class.getSimpleName();
  private static FavoriteDataBaseManager mInstance;
  private SQLiteDatabase db;
  private FavoriteDataBaseHelper mHelper;
  private AtomicInteger mUseCounter = new AtomicInteger();
  
  private FavoriteDataBaseManager(Context paramContext)
  {
    this.mHelper = new FavoriteDataBaseHelper(paramContext);
    try
    {
      this.db = this.mHelper.getWritableDatabase();
      return;
    }
    catch (Exception paramContext)
    {
      i.b(TAG, "FavoriteDataBaseHelper getWritableDatabase exception");
    }
  }
  
  public static FavoriteDataBaseManager getInstance()
  {
    try
    {
      if (mInstance == null) {
        newInstance(a.a());
      }
      i.b(TAG, "DB Version = 1");
      FavoriteDataBaseManager localFavoriteDataBaseManager = mInstance;
      return localFavoriteDataBaseManager;
    }
    finally {}
  }
  
  private static FavoriteDataBaseManager newInstance(Context paramContext)
  {
    try
    {
      if (mInstance == null) {
        mInstance = new FavoriteDataBaseManager(paramContext);
      }
      paramContext = mInstance;
      return paramContext;
    }
    finally {}
  }
  
  /* Error */
  public void closeDataBase()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 36	com/baidu/navi/favorite/database/FavoriteDataBaseManager:mUseCounter	Ljava/util/concurrent/atomic/AtomicInteger;
    //   6: invokevirtual 78	java/util/concurrent/atomic/AtomicInteger:decrementAndGet	()I
    //   9: ifne +29 -> 38
    //   12: aload_0
    //   13: getfield 48	com/baidu/navi/favorite/database/FavoriteDataBaseManager:db	Landroid/database/sqlite/SQLiteDatabase;
    //   16: ifnull +22 -> 38
    //   19: aload_0
    //   20: getfield 48	com/baidu/navi/favorite/database/FavoriteDataBaseManager:db	Landroid/database/sqlite/SQLiteDatabase;
    //   23: invokevirtual 84	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   26: istore_1
    //   27: iload_1
    //   28: ifeq +10 -> 38
    //   31: aload_0
    //   32: getfield 48	com/baidu/navi/favorite/database/FavoriteDataBaseManager:db	Landroid/database/sqlite/SQLiteDatabase;
    //   35: invokevirtual 87	android/database/sqlite/SQLiteDatabase:close	()V
    //   38: aload_0
    //   39: monitorexit
    //   40: return
    //   41: astore_2
    //   42: getstatic 24	com/baidu/navi/favorite/database/FavoriteDataBaseManager:TAG	Ljava/lang/String;
    //   45: ldc 89
    //   47: invokestatic 56	com/baidu/carlife/core/i:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   50: goto -12 -> 38
    //   53: astore_2
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_2
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	FavoriteDataBaseManager
    //   26	2	1	bool	boolean
    //   41	1	2	localException	Exception
    //   53	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   31	38	41	java/lang/Exception
    //   2	27	53	finally
    //   31	38	53	finally
    //   42	50	53	finally
  }
  
  public void executeQurey(FavoriteQueryExecutor paramFavoriteQueryExecutor)
  {
    paramFavoriteQueryExecutor.run(openDataBase());
    closeDataBase();
  }
  
  public SQLiteDatabase openDataBase()
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
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/favorite/database/FavoriteDataBaseManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */