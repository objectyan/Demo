package com.baidu.location.e;

import android.database.sqlite.SQLiteDatabase;
import com.baidu.location.Jni;
import com.baidu.location.h.e;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

final class f
{
  private static final String d = String.format(Locale.US, "DELETE FROM LOG WHERE timestamp NOT IN (SELECT timestamp FROM LOG ORDER BY timestamp DESC LIMIT %d);", new Object[] { Integer.valueOf(3000) });
  private static final String e = String.format(Locale.US, "SELECT * FROM LOG ORDER BY timestamp DESC LIMIT %d;", new Object[] { Integer.valueOf(3) });
  private String a = null;
  private final SQLiteDatabase b;
  private final a c;
  
  f(SQLiteDatabase paramSQLiteDatabase)
  {
    this.b = paramSQLiteDatabase;
    this.c = new a(this);
    if ((this.b != null) && (this.b.isOpen())) {}
    try
    {
      this.b.execSQL("CREATE TABLE IF NOT EXISTS LOG(timestamp LONG PRIMARY KEY, log VARCHAR(4000))");
      return;
    }
    catch (Exception paramSQLiteDatabase) {}
  }
  
  private void a(boolean paramBoolean)
  {
    String str;
    if ((paramBoolean) && (this.a != null)) {
      str = String.format("DELETE FROM LOG WHERE timestamp in (%s);", new Object[] { this.a });
    }
    try
    {
      if (this.a.length() > 0) {
        this.b.execSQL(str);
      }
      this.a = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  /* Error */
  private String b()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aconst_null
    //   6: astore 6
    //   8: aconst_null
    //   9: astore 5
    //   11: new 91	org/json/JSONArray
    //   14: dup
    //   15: invokespecial 92	org/json/JSONArray:<init>	()V
    //   18: astore 7
    //   20: new 94	org/json/JSONObject
    //   23: dup
    //   24: invokespecial 95	org/json/JSONObject:<init>	()V
    //   27: astore 8
    //   29: aload_0
    //   30: getfield 53	com/baidu/location/e/f:b	Landroid/database/sqlite/SQLiteDatabase;
    //   33: getstatic 42	com/baidu/location/e/f:e	Ljava/lang/String;
    //   36: aconst_null
    //   37: invokevirtual 99	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   40: astore_2
    //   41: aload 6
    //   43: astore_1
    //   44: aload_2
    //   45: ifnull +172 -> 217
    //   48: aload 5
    //   50: astore_3
    //   51: aload 6
    //   53: astore_1
    //   54: aload_2
    //   55: invokeinterface 104 1 0
    //   60: ifle +157 -> 217
    //   63: aload 5
    //   65: astore_3
    //   66: new 106	java/lang/StringBuffer
    //   69: dup
    //   70: invokespecial 107	java/lang/StringBuffer:<init>	()V
    //   73: astore 6
    //   75: aload 5
    //   77: astore_3
    //   78: aload_2
    //   79: invokeinterface 110 1 0
    //   84: pop
    //   85: aload 5
    //   87: astore_3
    //   88: aload_2
    //   89: invokeinterface 113 1 0
    //   94: ifne +90 -> 184
    //   97: aload 5
    //   99: astore_3
    //   100: aload 7
    //   102: aload_2
    //   103: iconst_1
    //   104: invokeinterface 117 2 0
    //   109: invokevirtual 121	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   112: pop
    //   113: aload 5
    //   115: astore_3
    //   116: aload 6
    //   118: invokevirtual 122	java/lang/StringBuffer:length	()I
    //   121: ifeq +14 -> 135
    //   124: aload 5
    //   126: astore_3
    //   127: aload 6
    //   129: ldc 124
    //   131: invokevirtual 128	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   134: pop
    //   135: aload 5
    //   137: astore_3
    //   138: aload 6
    //   140: aload_2
    //   141: iconst_0
    //   142: invokeinterface 132 2 0
    //   147: invokevirtual 135	java/lang/StringBuffer:append	(J)Ljava/lang/StringBuffer;
    //   150: pop
    //   151: aload 5
    //   153: astore_3
    //   154: aload_2
    //   155: invokeinterface 138 1 0
    //   160: pop
    //   161: goto -76 -> 85
    //   164: astore_1
    //   165: aload_3
    //   166: astore 4
    //   168: aload_2
    //   169: ifnull +12 -> 181
    //   172: aload_2
    //   173: invokeinterface 141 1 0
    //   178: aload_3
    //   179: astore 4
    //   181: aload 4
    //   183: areturn
    //   184: aload 5
    //   186: astore_3
    //   187: aload 8
    //   189: ldc -113
    //   191: aload 7
    //   193: invokevirtual 146	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   196: pop
    //   197: aload 5
    //   199: astore_3
    //   200: aload 8
    //   202: invokevirtual 149	org/json/JSONObject:toString	()Ljava/lang/String;
    //   205: astore_1
    //   206: aload_1
    //   207: astore_3
    //   208: aload_0
    //   209: aload 6
    //   211: invokevirtual 150	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   214: putfield 51	com/baidu/location/e/f:a	Ljava/lang/String;
    //   217: aload_1
    //   218: astore 4
    //   220: aload_2
    //   221: ifnull -40 -> 181
    //   224: aload_2
    //   225: invokeinterface 141 1 0
    //   230: aload_1
    //   231: areturn
    //   232: astore_2
    //   233: aload_1
    //   234: areturn
    //   235: astore_1
    //   236: aconst_null
    //   237: astore_2
    //   238: aload_2
    //   239: ifnull +9 -> 248
    //   242: aload_2
    //   243: invokeinterface 141 1 0
    //   248: aload_1
    //   249: athrow
    //   250: astore_1
    //   251: aload_3
    //   252: areturn
    //   253: astore_2
    //   254: goto -6 -> 248
    //   257: astore_1
    //   258: goto -20 -> 238
    //   261: astore_1
    //   262: aconst_null
    //   263: astore_2
    //   264: goto -99 -> 165
    //   267: astore_1
    //   268: aload 4
    //   270: astore_1
    //   271: goto -65 -> 206
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	274	0	this	f
    //   43	11	1	localStringBuffer1	StringBuffer
    //   164	1	1	localException1	Exception
    //   205	29	1	str	String
    //   235	14	1	localObject1	Object
    //   250	1	1	localException2	Exception
    //   257	1	1	localObject2	Object
    //   261	1	1	localException3	Exception
    //   267	1	1	localJSONException	org.json.JSONException
    //   270	1	1	localObject3	Object
    //   40	185	2	localCursor	android.database.Cursor
    //   232	1	2	localException4	Exception
    //   237	6	2	localObject4	Object
    //   253	1	2	localException5	Exception
    //   263	1	2	localObject5	Object
    //   1	251	3	localObject6	Object
    //   3	266	4	localObject7	Object
    //   9	189	5	localObject8	Object
    //   6	204	6	localStringBuffer2	StringBuffer
    //   18	174	7	localJSONArray	org.json.JSONArray
    //   27	174	8	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   54	63	164	java/lang/Exception
    //   66	75	164	java/lang/Exception
    //   78	85	164	java/lang/Exception
    //   88	97	164	java/lang/Exception
    //   100	113	164	java/lang/Exception
    //   116	124	164	java/lang/Exception
    //   127	135	164	java/lang/Exception
    //   138	151	164	java/lang/Exception
    //   154	161	164	java/lang/Exception
    //   187	197	164	java/lang/Exception
    //   200	206	164	java/lang/Exception
    //   208	217	164	java/lang/Exception
    //   224	230	232	java/lang/Exception
    //   29	41	235	finally
    //   172	178	250	java/lang/Exception
    //   242	248	253	java/lang/Exception
    //   54	63	257	finally
    //   66	75	257	finally
    //   78	85	257	finally
    //   88	97	257	finally
    //   100	113	257	finally
    //   116	124	257	finally
    //   127	135	257	finally
    //   138	151	257	finally
    //   154	161	257	finally
    //   187	197	257	finally
    //   200	206	257	finally
    //   208	217	257	finally
    //   29	41	261	java/lang/Exception
    //   187	197	267	org/json/JSONException
    //   200	206	267	org/json/JSONException
  }
  
  void a()
  {
    a.a(this.c);
  }
  
  void a(String paramString)
  {
    paramString = Jni.encodeOfflineLocationUpdateRequest(paramString);
    paramString = String.format(Locale.US, "INSERT OR IGNORE INTO LOG VALUES (%d,\"%s\");", new Object[] { Long.valueOf(System.currentTimeMillis()), paramString });
    try
    {
      this.b.execSQL(paramString);
      this.b.execSQL(d);
      return;
    }
    catch (Exception paramString) {}
  }
  
  private class a
    extends e
  {
    private int b;
    private long c;
    private String d;
    private boolean e;
    private boolean f;
    private f p;
    
    a(f paramf)
    {
      this.p = paramf;
      this.d = null;
      this.e = false;
      this.f = false;
      this.k = new HashMap();
      this.b = 0;
      this.c = -1L;
    }
    
    private void b()
    {
      if (!this.e)
      {
        this.d = f.a(this.p);
        if ((this.c != -1L) && (this.c + 86400000L <= System.currentTimeMillis()))
        {
          this.b = 0;
          this.c = -1L;
        }
        if ((this.d != null) && (this.b < 2))
        {
          this.e = true;
          c("https://ofloc.map.baidu.com/offline_loc");
        }
      }
    }
    
    public void a()
    {
      this.k.clear();
      this.k.put("qt", "ofbh");
      this.k.put("req", this.d);
      this.h = d.b;
    }
    
    public void a(boolean paramBoolean)
    {
      this.f = false;
      if ((paramBoolean) && (this.j != null)) {}
      try
      {
        JSONObject localJSONObject = new JSONObject(this.j);
        if ((localJSONObject != null) && (localJSONObject.has("error")) && (localJSONObject.getInt("error") == 161)) {
          this.f = true;
        }
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
      if (!this.f)
      {
        this.b += 1;
        this.c = System.currentTimeMillis();
      }
      f.a(this.p, this.f);
      this.e = false;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/e/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */