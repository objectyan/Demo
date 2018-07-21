package com.baidu.tts.e;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONException;
import org.json.JSONObject;

public class c
{
  private static c a;
  private a b;
  private ReadWriteLock c = new ReentrantReadWriteLock();
  private Lock d = this.c.writeLock();
  private Lock e = this.c.readLock();
  private Context f;
  
  private c(Context paramContext)
  {
    this.f = paramContext;
    this.b = new a(this.f);
  }
  
  public static c a(Context paramContext)
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new c(paramContext);
      }
      return a;
    }
    finally {}
  }
  
  private SQLiteDatabase c()
  {
    return this.b.getWritableDatabase();
  }
  
  private SQLiteDatabase d()
  {
    return this.b.getReadableDatabase();
  }
  
  /* Error */
  public int a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore_2
    //   8: aconst_null
    //   9: astore_3
    //   10: aload_0
    //   11: getfield 40	com/baidu/tts/e/c:e	Ljava/util/concurrent/locks/Lock;
    //   14: invokeinterface 72 1 0
    //   19: aload_0
    //   20: invokespecial 74	com/baidu/tts/e/c:d	()Landroid/database/sqlite/SQLiteDatabase;
    //   23: astore 7
    //   25: aload 7
    //   27: ifnull +302 -> 329
    //   30: aload 7
    //   32: ldc 76
    //   34: bipush 6
    //   36: anewarray 78	java/lang/String
    //   39: dup
    //   40: iconst_0
    //   41: ldc 80
    //   43: aastore
    //   44: dup
    //   45: iconst_1
    //   46: ldc 82
    //   48: aastore
    //   49: dup
    //   50: iconst_2
    //   51: ldc 84
    //   53: aastore
    //   54: dup
    //   55: iconst_3
    //   56: ldc 86
    //   58: aastore
    //   59: dup
    //   60: iconst_4
    //   61: ldc 88
    //   63: aastore
    //   64: dup
    //   65: iconst_5
    //   66: ldc 76
    //   68: aastore
    //   69: aconst_null
    //   70: aconst_null
    //   71: aconst_null
    //   72: aconst_null
    //   73: aconst_null
    //   74: invokevirtual 94	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   77: astore 6
    //   79: aload 6
    //   81: astore_2
    //   82: aload_2
    //   83: invokeinterface 99 1 0
    //   88: istore_1
    //   89: aload_2
    //   90: invokeinterface 102 1 0
    //   95: aload 7
    //   97: invokevirtual 103	android/database/sqlite/SQLiteDatabase:close	()V
    //   100: aload_0
    //   101: getfield 40	com/baidu/tts/e/c:e	Ljava/util/concurrent/locks/Lock;
    //   104: invokeinterface 106 1 0
    //   109: iload_1
    //   110: ireturn
    //   111: astore 4
    //   113: aload_3
    //   114: astore_2
    //   115: ldc 108
    //   117: new 110	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   124: ldc 113
    //   126: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: aload 4
    //   131: invokevirtual 121	android/database/sqlite/SQLiteException:toString	()Ljava/lang/String;
    //   134: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokestatic 127	com/baidu/tts/chainofresponsibility/logger/LoggerProxy:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   143: aload_3
    //   144: invokeinterface 102 1 0
    //   149: aload 7
    //   151: invokevirtual 103	android/database/sqlite/SQLiteDatabase:close	()V
    //   154: aload_0
    //   155: getfield 40	com/baidu/tts/e/c:e	Ljava/util/concurrent/locks/Lock;
    //   158: invokeinterface 106 1 0
    //   163: iconst_0
    //   164: ireturn
    //   165: astore_2
    //   166: aload 4
    //   168: astore_3
    //   169: aload_2
    //   170: astore 4
    //   172: aload_3
    //   173: astore_2
    //   174: ldc 108
    //   176: new 110	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   183: ldc 113
    //   185: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: aload 4
    //   190: invokevirtual 128	java/lang/IllegalStateException:toString	()Ljava/lang/String;
    //   193: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   199: invokestatic 127	com/baidu/tts/chainofresponsibility/logger/LoggerProxy:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   202: aload_3
    //   203: invokeinterface 102 1 0
    //   208: aload 7
    //   210: invokevirtual 103	android/database/sqlite/SQLiteDatabase:close	()V
    //   213: aload_0
    //   214: getfield 40	com/baidu/tts/e/c:e	Ljava/util/concurrent/locks/Lock;
    //   217: invokeinterface 106 1 0
    //   222: iconst_0
    //   223: ireturn
    //   224: astore 4
    //   226: aload 5
    //   228: astore_3
    //   229: aload_3
    //   230: astore_2
    //   231: ldc 108
    //   233: new 110	java/lang/StringBuilder
    //   236: dup
    //   237: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   240: ldc 113
    //   242: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: aload 4
    //   247: invokevirtual 129	java/lang/Exception:toString	()Ljava/lang/String;
    //   250: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: invokestatic 127	com/baidu/tts/chainofresponsibility/logger/LoggerProxy:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   259: aload_3
    //   260: invokeinterface 102 1 0
    //   265: aload 7
    //   267: invokevirtual 103	android/database/sqlite/SQLiteDatabase:close	()V
    //   270: aload_0
    //   271: getfield 40	com/baidu/tts/e/c:e	Ljava/util/concurrent/locks/Lock;
    //   274: invokeinterface 106 1 0
    //   279: iconst_0
    //   280: ireturn
    //   281: astore_3
    //   282: aload_2
    //   283: invokeinterface 102 1 0
    //   288: aload 7
    //   290: invokevirtual 103	android/database/sqlite/SQLiteDatabase:close	()V
    //   293: aload_0
    //   294: getfield 40	com/baidu/tts/e/c:e	Ljava/util/concurrent/locks/Lock;
    //   297: invokeinterface 106 1 0
    //   302: aload_3
    //   303: athrow
    //   304: astore_3
    //   305: goto -23 -> 282
    //   308: astore 4
    //   310: aload_2
    //   311: astore_3
    //   312: goto -83 -> 229
    //   315: astore 4
    //   317: aload_2
    //   318: astore_3
    //   319: goto -147 -> 172
    //   322: astore 4
    //   324: aload_2
    //   325: astore_3
    //   326: goto -213 -> 113
    //   329: aconst_null
    //   330: astore_2
    //   331: iconst_0
    //   332: istore_1
    //   333: goto -244 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	336	0	this	c
    //   88	245	1	i	int
    //   7	108	2	localObject1	Object
    //   165	5	2	localIllegalStateException1	IllegalStateException
    //   173	158	2	localObject2	Object
    //   9	251	3	localObject3	Object
    //   281	22	3	localObject4	Object
    //   304	1	3	localObject5	Object
    //   311	15	3	localObject6	Object
    //   1	1	4	localObject7	Object
    //   111	56	4	localSQLiteException1	SQLiteException
    //   170	19	4	localObject8	Object
    //   224	22	4	localException1	Exception
    //   308	1	4	localException2	Exception
    //   315	1	4	localIllegalStateException2	IllegalStateException
    //   322	1	4	localSQLiteException2	SQLiteException
    //   4	223	5	localObject9	Object
    //   77	3	6	localCursor	Cursor
    //   23	266	7	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   30	79	111	android/database/sqlite/SQLiteException
    //   30	79	165	java/lang/IllegalStateException
    //   30	79	224	java/lang/Exception
    //   30	79	281	finally
    //   115	143	281	finally
    //   174	202	281	finally
    //   231	259	281	finally
    //   82	89	304	finally
    //   82	89	308	java/lang/Exception
    //   82	89	315	java/lang/IllegalStateException
    //   82	89	322	android/database/sqlite/SQLiteException
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    this.d.lock();
    SQLiteDatabase localSQLiteDatabase = c();
    try
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("time", Long.valueOf(paramLong));
      localContentValues.put("code", Integer.valueOf(paramInt1));
      localContentValues.put("cmd_type", Integer.valueOf(paramInt2));
      localContentValues.put("cmd_id", Integer.valueOf(paramInt3));
      localContentValues.put("result", paramString);
      localSQLiteDatabase.insert("result", null, localContentValues);
      return;
    }
    catch (SQLiteException paramString)
    {
      LoggerProxy.d("SynthesizeResultDb", "exception:" + paramString.toString());
      return;
    }
    catch (IllegalStateException paramString)
    {
      LoggerProxy.d("SynthesizeResultDb", "exception:" + paramString.toString());
      return;
    }
    catch (Exception paramString)
    {
      LoggerProxy.d("SynthesizeResultDb", "exception:" + paramString.toString());
      return;
    }
    finally
    {
      localSQLiteDatabase.close();
      this.d.unlock();
    }
  }
  
  public void a(List<Integer> paramList)
  {
    int i = 0;
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    this.d.lock();
    SQLiteDatabase localSQLiteDatabase = d();
    String str = "";
    try
    {
      while (i < paramList.size())
      {
        str = str + paramList.get(i) + ",";
        i += 1;
      }
      if (str.length() > 0)
      {
        paramList = str.substring(0, str.length() - 1);
        localSQLiteDatabase.delete("result", "_id in (" + paramList + ")", null);
      }
      return;
    }
    catch (SQLiteException paramList)
    {
      LoggerProxy.d("SynthesizeResultDb", "exception:" + paramList.toString());
      return;
    }
    catch (IllegalStateException paramList)
    {
      LoggerProxy.d("SynthesizeResultDb", "exception:" + paramList.toString());
      return;
    }
    catch (Exception paramList)
    {
      LoggerProxy.d("SynthesizeResultDb", "exception:" + paramList.toString());
      return;
    }
    finally
    {
      localSQLiteDatabase.close();
      this.d.unlock();
    }
  }
  
  public Map<String, ArrayList> b()
  {
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    this.e.lock();
    SQLiteDatabase localSQLiteDatabase = d();
    Cursor localCursor = localSQLiteDatabase.rawQuery("select * from result limit 0,500", null);
    try
    {
      if (localCursor.moveToNext()) {
        localJSONObject = new JSONObject();
      }
    }
    catch (SQLiteException localSQLiteException)
    {
      JSONObject localJSONObject;
      int i;
      String str1;
      int j;
      int k;
      int m;
      String str2;
      for (;;) {}
    }
    catch (IllegalStateException localIllegalStateException)
    {
      LoggerProxy.d("SynthesizeResultDb", "exception:" + localIllegalStateException.toString());
      return localHashMap;
      localHashMap.put("listId", localArrayList2);
      localHashMap.put("list", localIllegalStateException);
      return localHashMap;
    }
    catch (Exception localException1)
    {
      LoggerProxy.d("SynthesizeResultDb", "exception:" + localException1.toString());
      return localHashMap;
    }
    finally
    {
      localCursor.close();
      localSQLiteDatabase.close();
      this.e.unlock();
    }
  }
  
  class a
    extends SQLiteOpenHelper
  {
    public a(Context paramContext)
    {
      super("ttsdata", null, 1);
    }
    
    public void onCreate(SQLiteDatabase paramSQLiteDatabase)
    {
      paramSQLiteDatabase.execSQL("create table result (_id integer primary key autoincrement, time text, code integer, cmd_type integer, cmd_id integer, result text);");
    }
    
    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS result");
      onCreate(paramSQLiteDatabase);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/e/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */