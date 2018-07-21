package com.baidu.navi.favorite.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.carlife.core.i;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class FavoriteDao
{
  public static final String TAG = FavoriteDao.class.getSimpleName();
  private SQLiteDatabase mDatabase;
  
  public FavoriteDao(SQLiteDatabase paramSQLiteDatabase)
  {
    this.mDatabase = paramSQLiteDatabase;
  }
  
  private boolean addToDB(String paramString1, String paramString2)
  {
    try
    {
      this.mDatabase.execSQL("INSERT OR REPLACE INTO [Fvorite_Poi] (key, value) values (?, ?);", new String[] { paramString1, paramString2 });
      return true;
    }
    catch (Exception paramString1) {}
    return false;
  }
  
  private boolean updateToDB(String paramString1, String paramString2)
  {
    try
    {
      this.mDatabase.execSQL("REPLACE INTO [Fvorite_Poi] (key, value)values (?, ?)", new String[] { paramString1, paramString2 });
      return true;
    }
    catch (Exception paramString1) {}
    return false;
  }
  
  public boolean add(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    if (this.mDatabase == null) {
      return false;
    }
    boolean bool1 = bool2;
    for (;;)
    {
      try
      {
        this.mDatabase.beginTransaction();
        bool1 = bool2;
        bool2 = addToDB(paramString1, paramString2);
        bool1 = bool2;
        this.mDatabase.setTransactionSuccessful();
      }
      catch (Exception paramString1)
      {
        try
        {
          this.mDatabase.endTransaction();
        }
        catch (Exception paramString1)
        {
          return false;
        }
      }
      finally
      {
        try
        {
          this.mDatabase.endTransaction();
          throw paramString1;
        }
        catch (Exception paramString1) {}
      }
      try
      {
        this.mDatabase.endTransaction();
        bool1 = bool2;
        return bool1;
      }
      catch (Exception paramString1)
      {
        return false;
      }
    }
    return false;
  }
  
  public boolean addAll(Map<String, String> paramMap)
  {
    boolean bool = false;
    if (paramMap == null) {
      return false;
    }
    if (this.mDatabase == null) {
      return false;
    }
    try
    {
      this.mDatabase.beginTransaction();
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        addToDB((String)localEntry.getKey(), (String)localEntry.getValue());
      }
      return false;
    }
    catch (Exception paramMap)
    {
      for (;;)
      {
        try
        {
          this.mDatabase.endTransaction();
          return bool;
        }
        catch (Exception paramMap)
        {
          return false;
        }
        this.mDatabase.setTransactionSuccessful();
        bool = true;
        try
        {
          this.mDatabase.endTransaction();
        }
        catch (Exception paramMap)
        {
          return false;
        }
      }
    }
    finally
    {
      try
      {
        this.mDatabase.endTransaction();
        throw paramMap;
      }
      catch (Exception paramMap) {}
    }
  }
  
  public boolean clear()
  {
    return true;
  }
  
  /* Error */
  public List<String> getAllKey()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: aload_0
    //   7: getfield 25	com/baidu/navi/favorite/database/FavoriteDao:mDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   10: ifnonnull +5 -> 15
    //   13: aconst_null
    //   14: areturn
    //   15: aconst_null
    //   16: astore_3
    //   17: aconst_null
    //   18: astore_2
    //   19: aload_0
    //   20: getfield 25	com/baidu/navi/favorite/database/FavoriteDao:mDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   23: ldc 93
    //   25: aconst_null
    //   26: invokevirtual 97	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   29: astore_1
    //   30: aload_1
    //   31: astore_2
    //   32: aload_1
    //   33: astore_3
    //   34: getstatic 18	com/baidu/navi/favorite/database/FavoriteDao:TAG	Ljava/lang/String;
    //   37: ldc 99
    //   39: invokestatic 105	com/baidu/carlife/core/i:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   42: aload 6
    //   44: astore 4
    //   46: aload_1
    //   47: ifnull +95 -> 142
    //   50: aload 6
    //   52: astore 4
    //   54: aload_1
    //   55: astore_2
    //   56: aload_1
    //   57: astore_3
    //   58: aload_1
    //   59: invokeinterface 111 1 0
    //   64: ifle +78 -> 142
    //   67: aload_1
    //   68: astore_2
    //   69: aload_1
    //   70: astore_3
    //   71: new 113	java/util/ArrayList
    //   74: dup
    //   75: invokespecial 114	java/util/ArrayList:<init>	()V
    //   78: astore 4
    //   80: aload_1
    //   81: invokeinterface 117 1 0
    //   86: ifeq +56 -> 142
    //   89: aload 4
    //   91: aload_1
    //   92: aload_1
    //   93: ldc 119
    //   95: invokeinterface 123 2 0
    //   100: invokeinterface 127 2 0
    //   105: invokevirtual 130	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   108: pop
    //   109: goto -29 -> 80
    //   112: astore_2
    //   113: aload 4
    //   115: astore_3
    //   116: aload_1
    //   117: astore_2
    //   118: getstatic 18	com/baidu/navi/favorite/database/FavoriteDao:TAG	Ljava/lang/String;
    //   121: ldc -124
    //   123: invokestatic 105	com/baidu/carlife/core/i:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   126: aload_3
    //   127: astore_2
    //   128: aload_1
    //   129: ifnull +11 -> 140
    //   132: aload_1
    //   133: invokeinterface 135 1 0
    //   138: aload_3
    //   139: astore_2
    //   140: aload_2
    //   141: areturn
    //   142: aload 4
    //   144: astore_2
    //   145: aload_1
    //   146: ifnull -6 -> 140
    //   149: aload_1
    //   150: invokeinterface 135 1 0
    //   155: aload 4
    //   157: astore_2
    //   158: goto -18 -> 140
    //   161: astore_3
    //   162: aload_2
    //   163: astore_1
    //   164: aload_1
    //   165: ifnull +9 -> 174
    //   168: aload_1
    //   169: invokeinterface 135 1 0
    //   174: aload_3
    //   175: athrow
    //   176: astore_3
    //   177: goto -13 -> 164
    //   180: astore_1
    //   181: aload_3
    //   182: astore_1
    //   183: aload 5
    //   185: astore_3
    //   186: goto -70 -> 116
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	189	0	this	FavoriteDao
    //   29	140	1	localObject1	Object
    //   180	1	1	localException1	Exception
    //   182	1	1	localObject2	Object
    //   18	51	2	localObject3	Object
    //   112	1	2	localException2	Exception
    //   117	46	2	localObject4	Object
    //   16	123	3	localObject5	Object
    //   161	14	3	localObject6	Object
    //   176	6	3	localObject7	Object
    //   185	1	3	localObject8	Object
    //   44	112	4	localObject9	Object
    //   4	180	5	localObject10	Object
    //   1	50	6	localObject11	Object
    // Exception table:
    //   from	to	target	type
    //   80	109	112	java/lang/Exception
    //   19	30	161	finally
    //   34	42	161	finally
    //   58	67	161	finally
    //   71	80	161	finally
    //   118	126	161	finally
    //   80	109	176	finally
    //   19	30	180	java/lang/Exception
    //   34	42	180	java/lang/Exception
    //   58	67	180	java/lang/Exception
    //   71	80	180	java/lang/Exception
  }
  
  public String getValue(String paramString)
  {
    Object localObject3 = null;
    Object localObject1;
    if (this.mDatabase == null) {
      localObject1 = localObject3;
    }
    for (;;)
    {
      return (String)localObject1;
      localObject1 = null;
      Cursor localCursor = null;
      String str = String.format("SELECT * FROM Fvorite_Poi WHERE key='%s'", new Object[] { paramString });
      i.b(TAG, "getValue: " + str);
      paramString = localCursor;
      try
      {
        localCursor = this.mDatabase.rawQuery(str, null);
        if (localCursor != null)
        {
          paramString = localCursor;
          localObject1 = localCursor;
          if (localCursor.getCount() > 0)
          {
            paramString = localCursor;
            localObject1 = localCursor;
            if (localCursor.moveToFirst())
            {
              paramString = localCursor;
              localObject1 = localCursor;
              str = localCursor.getString(localCursor.getColumnIndex("value"));
              paramString = str;
              localObject1 = paramString;
              if (localCursor == null) {
                continue;
              }
              localCursor.close();
              return paramString;
            }
          }
        }
        localObject1 = localObject3;
        if (localCursor == null) {
          continue;
        }
        localCursor.close();
        return null;
      }
      catch (Exception localException)
      {
        localObject2 = paramString;
        i.b(TAG, "getValue DB Exception");
        localObject2 = localObject3;
        if (paramString == null) {
          continue;
        }
        paramString.close();
        return null;
      }
      finally
      {
        Object localObject2;
        if (localObject2 != null) {
          ((Cursor)localObject2).close();
        }
      }
    }
  }
  
  public boolean isExist(String paramString)
  {
    if (this.mDatabase == null) {}
    for (;;)
    {
      return false;
      Object localObject = null;
      Cursor localCursor = null;
      String str2 = String.format("SELECT key FROM Fvorite_Poi WHERE key='%s'", new Object[] { paramString });
      i.b(TAG, "isExist: " + str2);
      paramString = localCursor;
      try
      {
        localCursor = this.mDatabase.rawQuery(str2, null);
        if (localCursor != null)
        {
          paramString = localCursor;
          localObject = localCursor;
          int i = localCursor.getCount();
          if (i > 0) {
            return true;
          }
        }
        return false;
      }
      catch (Exception localException)
      {
        str1 = paramString;
        i.b(TAG, "isExist DB Exception");
        return false;
      }
      finally
      {
        String str1;
        if (str1 != null) {
          str1.close();
        }
      }
    }
  }
  
  public boolean remove(String paramString)
  {
    boolean bool1 = false;
    if (this.mDatabase == null) {
      return false;
    }
    boolean bool2 = bool1;
    for (;;)
    {
      try
      {
        this.mDatabase.beginTransaction();
        bool2 = bool1;
        paramString = paramString + "";
        bool2 = bool1;
        if (this.mDatabase.delete("Fvorite_Poi", "key=?", new String[] { paramString }) > 0)
        {
          bool1 = true;
          bool2 = bool1;
          this.mDatabase.setTransactionSuccessful();
        }
      }
      catch (Exception paramString)
      {
        paramString = paramString;
        try
        {
          this.mDatabase.endTransaction();
          bool1 = bool2;
        }
        catch (Exception paramString)
        {
          bool1 = false;
        }
        continue;
      }
      finally {}
      try
      {
        this.mDatabase.endTransaction();
        return bool1;
        bool1 = false;
      }
      catch (Exception paramString)
      {
        bool1 = false;
      }
    }
    try
    {
      this.mDatabase.endTransaction();
      throw paramString;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public boolean removeAll(List<String> paramList)
  {
    boolean bool = false;
    if (this.mDatabase == null) {
      return false;
    }
    try
    {
      this.mDatabase.beginTransaction();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        str = str + "";
        this.mDatabase.delete("Fvorite_Poi", "key=?", new String[] { str });
      }
      try
      {
        this.mDatabase.endTransaction();
        throw paramList;
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
    catch (Exception paramList)
    {
      paramList = paramList;
      try
      {
        this.mDatabase.endTransaction();
        for (;;)
        {
          return bool;
          this.mDatabase.setTransactionSuccessful();
          bool = true;
          try
          {
            this.mDatabase.endTransaction();
          }
          catch (Exception paramList)
          {
            bool = false;
          }
        }
      }
      catch (Exception paramList)
      {
        for (;;)
        {
          bool = false;
        }
      }
    }
    finally {}
  }
  
  public boolean update(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    if (this.mDatabase == null) {
      return false;
    }
    boolean bool1 = bool2;
    for (;;)
    {
      try
      {
        this.mDatabase.beginTransaction();
        bool1 = bool2;
        bool2 = updateToDB(paramString1, paramString2);
        bool1 = bool2;
        this.mDatabase.setTransactionSuccessful();
      }
      catch (Exception paramString1)
      {
        paramString1 = paramString1;
        try
        {
          this.mDatabase.endTransaction();
        }
        catch (Exception paramString1)
        {
          bool1 = false;
        }
        continue;
      }
      finally {}
      try
      {
        this.mDatabase.endTransaction();
        bool1 = bool2;
      }
      catch (Exception paramString1)
      {
        bool1 = false;
      }
    }
    return bool1;
    try
    {
      this.mDatabase.endTransaction();
      throw paramString1;
    }
    catch (Exception paramString2)
    {
      for (;;) {}
    }
  }
  
  public boolean updateAll(Map<String, String> paramMap)
  {
    boolean bool = false;
    if (paramMap == null) {
      return false;
    }
    if (this.mDatabase == null) {
      return false;
    }
    try
    {
      this.mDatabase.beginTransaction();
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        updateToDB((String)localEntry.getKey(), (String)localEntry.getValue());
      }
      return false;
    }
    catch (Exception paramMap)
    {
      for (;;)
      {
        try
        {
          this.mDatabase.endTransaction();
          return bool;
        }
        catch (Exception paramMap)
        {
          return false;
        }
        this.mDatabase.setTransactionSuccessful();
        bool = true;
        try
        {
          this.mDatabase.endTransaction();
        }
        catch (Exception paramMap)
        {
          return false;
        }
      }
    }
    finally
    {
      try
      {
        this.mDatabase.endTransaction();
        throw paramMap;
      }
      catch (Exception paramMap) {}
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/favorite/database/FavoriteDao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */