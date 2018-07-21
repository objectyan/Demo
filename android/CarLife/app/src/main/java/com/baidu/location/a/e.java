package com.baidu.location.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.wifi.WifiInfo;
import android.os.Bundle;
import com.baidu.location.Jni;
import com.baidu.location.f.f;
import com.baidu.location.h.g;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class e
{
  private static Object c = new Object();
  private static e d = null;
  private static final String e = g.l() + "/hst.db";
  a a = null;
  a b = null;
  private SQLiteDatabase f = null;
  private boolean g = false;
  
  public static e a()
  {
    synchronized (c)
    {
      if (d == null) {
        d = new e();
      }
      e locale = d;
      return locale;
    }
  }
  
  private void a(Bundle paramBundle)
  {
    a.a().a(paramBundle, 406);
  }
  
  private String b(boolean paramBoolean)
  {
    com.baidu.location.f.a locala = com.baidu.location.f.b.a().f();
    com.baidu.location.f.e locale = f.a().q();
    StringBuffer localStringBuffer = new StringBuffer(1024);
    if ((locala != null) && (locala.b())) {
      localStringBuffer.append(locala.i());
    }
    if ((locale != null) && (locale.a() > 1)) {
      localStringBuffer.append(locale.a(15));
    }
    for (;;)
    {
      if (paramBoolean) {
        localStringBuffer.append("&imo=1");
      }
      localStringBuffer.append(com.baidu.location.h.b.a().a(false));
      localStringBuffer.append(a.a().f());
      return localStringBuffer.toString();
      if (f.a().m() != null) {
        localStringBuffer.append(f.a().m());
      }
    }
  }
  
  private void f()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("hotspot", -1);
    a(localBundle);
  }
  
  public void a(String paramString)
  {
    Long localLong = null;
    if (this.g) {}
    for (;;)
    {
      return;
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        paramString = localLong;
        if (localJSONObject.has("content")) {
          paramString = localJSONObject.getJSONObject("content");
        }
        if ((paramString == null) || (!paramString.has("imo"))) {
          continue;
        }
        localLong = Long.valueOf(paramString.getJSONObject("imo").getString("mac"));
        int i = paramString.getJSONObject("imo").getInt("mv");
        paramString = new ContentValues();
        paramString.put("tt", Integer.valueOf((int)(System.currentTimeMillis() / 1000L)));
        paramString.put("hst", Integer.valueOf(i));
        try
        {
          if (this.f.update("hstdata", paramString, "id = \"" + localLong + "\"", null) > 0) {
            continue;
          }
          paramString.put("id", localLong);
          this.f.insert("hstdata", null, paramString);
          return;
        }
        catch (Exception paramString) {}
        return;
      }
      catch (Exception paramString) {}
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.b == null) {
      this.b = new a();
    }
    if (this.b != null)
    {
      Object localObject = f.a().l();
      if ((localObject != null) && (((WifiInfo)localObject).getBSSID() != null))
      {
        localObject = ((WifiInfo)localObject).getBSSID().replace(":", "");
        this.b.a((String)localObject, b(false), paramBoolean);
      }
    }
  }
  
  public void b()
  {
    try
    {
      File localFile = new File(e);
      if (!localFile.exists()) {
        localFile.createNewFile();
      }
      if (localFile.exists())
      {
        this.f = SQLiteDatabase.openOrCreateDatabase(localFile, null);
        this.f.execSQL("CREATE TABLE IF NOT EXISTS hstdata(id Long PRIMARY KEY,hst INT,tt INT);");
        this.f.setVersion(1);
      }
      return;
    }
    catch (Exception localException)
    {
      this.f = null;
    }
  }
  
  public void c()
  {
    if (this.f != null) {}
    try
    {
      this.f.close();
      this.f = null;
      return;
    }
    catch (Exception localException)
    {
      localException = localException;
      this.f = null;
      return;
    }
    finally
    {
      localObject = finally;
      this.f = null;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public int d()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: bipush -3
    //   5: istore_1
    //   6: aload_0
    //   7: getfield 53	com/baidu/location/a/e:g	Z
    //   10: ifeq +7 -> 17
    //   13: iload_1
    //   14: istore_2
    //   15: iload_2
    //   16: ireturn
    //   17: iload_1
    //   18: istore_2
    //   19: invokestatic 281	com/baidu/location/f/f:j	()Z
    //   22: ifeq -7 -> 15
    //   25: iload_1
    //   26: istore_2
    //   27: aload_0
    //   28: getfield 51	com/baidu/location/a/e:f	Landroid/database/sqlite/SQLiteDatabase;
    //   31: ifnull -16 -> 15
    //   34: invokestatic 87	com/baidu/location/f/f:a	()Lcom/baidu/location/f/f;
    //   37: invokevirtual 234	com/baidu/location/f/f:l	()Landroid/net/wifi/WifiInfo;
    //   40: astore_3
    //   41: iload_1
    //   42: istore_2
    //   43: aload_3
    //   44: ifnull -29 -> 15
    //   47: iload_1
    //   48: istore_2
    //   49: aload_3
    //   50: invokevirtual 239	android/net/wifi/WifiInfo:getBSSID	()Ljava/lang/String;
    //   53: ifnull -38 -> 15
    //   56: aload_3
    //   57: invokevirtual 239	android/net/wifi/WifiInfo:getBSSID	()Ljava/lang/String;
    //   60: ldc -15
    //   62: ldc -13
    //   64: invokevirtual 249	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   67: invokestatic 286	com/baidu/location/Jni:encode3	(Ljava/lang/String;)Ljava/lang/Long;
    //   70: astore_3
    //   71: aload_0
    //   72: getfield 51	com/baidu/location/a/e:f	Landroid/database/sqlite/SQLiteDatabase;
    //   75: new 30	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   82: ldc_w 288
    //   85: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: aload_3
    //   89: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   92: ldc_w 290
    //   95: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: aconst_null
    //   102: invokevirtual 294	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   105: astore_3
    //   106: aload_3
    //   107: ifnull +45 -> 152
    //   110: aload_3
    //   111: astore 4
    //   113: aload_3
    //   114: invokeinterface 299 1 0
    //   119: ifeq +33 -> 152
    //   122: aload_3
    //   123: astore 4
    //   125: aload_3
    //   126: iconst_1
    //   127: invokeinterface 302 2 0
    //   132: istore_2
    //   133: iload_2
    //   134: istore_1
    //   135: iload_1
    //   136: istore_2
    //   137: aload_3
    //   138: ifnull -123 -> 15
    //   141: aload_3
    //   142: invokeinterface 303 1 0
    //   147: iload_1
    //   148: ireturn
    //   149: astore_3
    //   150: iload_1
    //   151: ireturn
    //   152: bipush -2
    //   154: istore_1
    //   155: goto -20 -> 135
    //   158: astore_3
    //   159: iload_1
    //   160: istore_2
    //   161: aload 4
    //   163: ifnull -148 -> 15
    //   166: aload 4
    //   168: invokeinterface 303 1 0
    //   173: bipush -3
    //   175: ireturn
    //   176: astore_3
    //   177: bipush -3
    //   179: ireturn
    //   180: astore_3
    //   181: aconst_null
    //   182: astore 4
    //   184: aload 4
    //   186: ifnull +10 -> 196
    //   189: aload 4
    //   191: invokeinterface 303 1 0
    //   196: aload_3
    //   197: athrow
    //   198: astore_3
    //   199: bipush -3
    //   201: ireturn
    //   202: astore 4
    //   204: goto -8 -> 196
    //   207: astore 5
    //   209: aload_3
    //   210: astore 4
    //   212: aload 5
    //   214: astore_3
    //   215: goto -31 -> 184
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	218	0	this	e
    //   5	155	1	i	int
    //   14	147	2	j	int
    //   40	102	3	localObject1	Object
    //   149	1	3	localException1	Exception
    //   158	1	3	localException2	Exception
    //   176	1	3	localException3	Exception
    //   180	17	3	localObject2	Object
    //   198	12	3	localException4	Exception
    //   214	1	3	localObject3	Object
    //   1	189	4	localObject4	Object
    //   202	1	4	localException5	Exception
    //   210	1	4	localObject5	Object
    //   207	6	5	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   141	147	149	java/lang/Exception
    //   71	106	158	java/lang/Exception
    //   113	122	158	java/lang/Exception
    //   125	133	158	java/lang/Exception
    //   166	173	176	java/lang/Exception
    //   71	106	180	finally
    //   19	25	198	java/lang/Exception
    //   27	41	198	java/lang/Exception
    //   49	71	198	java/lang/Exception
    //   196	198	198	java/lang/Exception
    //   189	196	202	java/lang/Exception
    //   113	122	207	finally
    //   125	133	207	finally
  }
  
  public void e()
  {
    localObject4 = null;
    j = 1;
    if (this.g) {
      return;
    }
    for (;;)
    {
      String str;
      int k;
      try
      {
        if ((!f.j()) || (this.f == null)) {
          break label359;
        }
        localObject1 = f.a().l();
        if ((localObject1 == null) || (((WifiInfo)localObject1).getBSSID() == null)) {
          break label354;
        }
        str = ((WifiInfo)localObject1).getBSSID().replace(":", "");
        localObject1 = Jni.encode3(str);
        i = 0;
      }
      catch (Exception localException1)
      {
        Object localObject1;
        return;
      }
      try
      {
        localObject1 = this.f.rawQuery("select * from hstdata where id = \"" + localObject1 + "\";", null);
        if (localObject1 != null) {
          localObject4 = localObject1;
        }
      }
      catch (Exception localException2)
      {
        Bundle localBundle;
        Object localObject2 = null;
        j = i;
        if (localObject2 == null) {
          continue;
        }
        try
        {
          ((Cursor)localObject2).close();
          j = i;
        }
        catch (Exception localException3)
        {
          j = i;
        }
        continue;
      }
      finally
      {
        if (localObject4 == null) {}
      }
      for (;;)
      {
        try
        {
          if (((Cursor)localObject1).moveToFirst())
          {
            localObject4 = localObject1;
            k = ((Cursor)localObject1).getInt(1);
            localObject4 = localObject1;
            int m = ((Cursor)localObject1).getInt(2);
            localObject4 = localObject1;
            long l = System.currentTimeMillis() / 1000L;
            if (l - m > 259200L)
            {
              i = j;
              j = i;
              if (localObject1 == null) {
                break;
              }
            }
          }
        }
        catch (Exception localException6)
        {
          break label311;
        }
        try
        {
          ((Cursor)localObject1).close();
          j = i;
        }
        catch (Exception localException4)
        {
          try
          {
            ((Cursor)localObject4).close();
            throw ((Throwable)localObject3);
            f();
            return;
            f();
            return;
            localException4 = localException4;
            j = i;
          }
          catch (Exception localException5) {}
        }
      }
      if (j == 0) {
        break;
      }
      if (this.a == null) {
        this.a = new a();
      }
      if (this.a == null) {
        break;
      }
      this.a.a(str, b(true));
      return;
      localObject4 = localException1;
      localBundle = new Bundle();
      localObject4 = localException1;
      localBundle.putByteArray("mac", str.getBytes());
      localObject4 = localException1;
      localBundle.putInt("hotspot", k);
      localObject4 = localException1;
      a(localBundle);
      i = 0;
      continue;
      i = 1;
    }
  }
  
  class a
    extends com.baidu.location.h.e
  {
    private String b = null;
    private String c = null;
    private boolean d = true;
    private boolean e = false;
    
    a()
    {
      this.k = new HashMap();
    }
    
    public void a()
    {
      this.i = 1;
      this.h = g.e();
      String str = Jni.encodeTp4(this.c);
      this.c = null;
      this.k.put("bloc", str);
    }
    
    public void a(String paramString1, String paramString2)
    {
      if (!e.c(e.this))
      {
        e.a(e.this, true);
        this.b = paramString1;
        this.c = paramString2;
        c(g.f);
      }
    }
    
    public void a(String paramString1, String paramString2, boolean paramBoolean)
    {
      if (!e.c(e.this))
      {
        e.a(e.this, true);
        this.b = paramString1;
        this.c = paramString2;
        this.d = false;
        this.e = paramBoolean;
        if (!this.e) {
          break label80;
        }
      }
      label80:
      for (this.c += "&imou=1";; this.c += "&imou=0")
      {
        c(g.f);
        return;
      }
    }
    
    /* Error */
    public void a(boolean paramBoolean)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_3
      //   2: iload_1
      //   3: ifeq +274 -> 277
      //   6: aload_0
      //   7: getfield 97	com/baidu/location/a/e$a:j	Ljava/lang/String;
      //   10: ifnull +267 -> 277
      //   13: aload_0
      //   14: getfield 97	com/baidu/location/a/e$a:j	Ljava/lang/String;
      //   17: astore 4
      //   19: aload_0
      //   20: getfield 27	com/baidu/location/a/e$a:d	Z
      //   23: ifeq +228 -> 251
      //   26: new 99	org/json/JSONObject
      //   29: dup
      //   30: aload 4
      //   32: invokespecial 101	org/json/JSONObject:<init>	(Ljava/lang/String;)V
      //   35: astore 4
      //   37: aload 4
      //   39: ldc 103
      //   41: invokevirtual 107	org/json/JSONObject:has	(Ljava/lang/String;)Z
      //   44: ifeq +11 -> 55
      //   47: aload 4
      //   49: ldc 103
      //   51: invokevirtual 111	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
      //   54: astore_3
      //   55: aload_3
      //   56: ifnull +195 -> 251
      //   59: aload_3
      //   60: ldc 113
      //   62: invokevirtual 107	org/json/JSONObject:has	(Ljava/lang/String;)Z
      //   65: ifeq +186 -> 251
      //   68: aload_3
      //   69: ldc 113
      //   71: invokevirtual 111	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
      //   74: ldc 115
      //   76: invokevirtual 118	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
      //   79: invokestatic 124	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
      //   82: astore 4
      //   84: aload_3
      //   85: ldc 113
      //   87: invokevirtual 111	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
      //   90: ldc 126
      //   92: invokevirtual 130	org/json/JSONObject:getInt	(Ljava/lang/String;)I
      //   95: istore_2
      //   96: aload_0
      //   97: getfield 23	com/baidu/location/a/e$a:b	Ljava/lang/String;
      //   100: invokestatic 133	com/baidu/location/Jni:encode3	(Ljava/lang/String;)Ljava/lang/Long;
      //   103: invokevirtual 137	java/lang/Long:longValue	()J
      //   106: aload 4
      //   108: invokevirtual 137	java/lang/Long:longValue	()J
      //   111: lcmp
      //   112: ifne +139 -> 251
      //   115: new 139	android/content/ContentValues
      //   118: dup
      //   119: invokespecial 140	android/content/ContentValues:<init>	()V
      //   122: astore_3
      //   123: aload_3
      //   124: ldc -114
      //   126: invokestatic 147	java/lang/System:currentTimeMillis	()J
      //   129: ldc2_w 148
      //   132: ldiv
      //   133: l2i
      //   134: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   137: invokevirtual 157	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
      //   140: aload_3
      //   141: ldc -97
      //   143: iload_2
      //   144: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   147: invokevirtual 157	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
      //   150: aload_0
      //   151: getfield 18	com/baidu/location/a/e$a:a	Lcom/baidu/location/a/e;
      //   154: invokestatic 162	com/baidu/location/a/e:a	(Lcom/baidu/location/a/e;)Landroid/database/sqlite/SQLiteDatabase;
      //   157: ldc -92
      //   159: aload_3
      //   160: new 79	java/lang/StringBuilder
      //   163: dup
      //   164: invokespecial 80	java/lang/StringBuilder:<init>	()V
      //   167: ldc -90
      //   169: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   172: aload 4
      //   174: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   177: ldc -85
      //   179: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   182: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   185: aconst_null
      //   186: invokevirtual 177	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
      //   189: ifgt +26 -> 215
      //   192: aload_3
      //   193: ldc -77
      //   195: aload 4
      //   197: invokevirtual 182	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
      //   200: aload_0
      //   201: getfield 18	com/baidu/location/a/e$a:a	Lcom/baidu/location/a/e;
      //   204: invokestatic 162	com/baidu/location/a/e:a	(Lcom/baidu/location/a/e;)Landroid/database/sqlite/SQLiteDatabase;
      //   207: ldc -92
      //   209: aconst_null
      //   210: aload_3
      //   211: invokevirtual 186	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
      //   214: pop2
      //   215: new 188	android/os/Bundle
      //   218: dup
      //   219: invokespecial 189	android/os/Bundle:<init>	()V
      //   222: astore_3
      //   223: aload_3
      //   224: ldc 115
      //   226: aload_0
      //   227: getfield 23	com/baidu/location/a/e$a:b	Ljava/lang/String;
      //   230: invokevirtual 195	java/lang/String:getBytes	()[B
      //   233: invokevirtual 199	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
      //   236: aload_3
      //   237: ldc -55
      //   239: iload_2
      //   240: invokevirtual 205	android/os/Bundle:putInt	(Ljava/lang/String;I)V
      //   243: aload_0
      //   244: getfield 18	com/baidu/location/a/e$a:a	Lcom/baidu/location/a/e;
      //   247: aload_3
      //   248: invokestatic 208	com/baidu/location/a/e:a	(Lcom/baidu/location/a/e;Landroid/os/Bundle;)V
      //   251: aload_0
      //   252: getfield 36	com/baidu/location/a/e$a:k	Ljava/util/Map;
      //   255: ifnull +12 -> 267
      //   258: aload_0
      //   259: getfield 36	com/baidu/location/a/e$a:k	Ljava/util/Map;
      //   262: invokeinterface 211 1 0
      //   267: aload_0
      //   268: getfield 18	com/baidu/location/a/e$a:a	Lcom/baidu/location/a/e;
      //   271: iconst_0
      //   272: invokestatic 70	com/baidu/location/a/e:a	(Lcom/baidu/location/a/e;Z)Z
      //   275: pop
      //   276: return
      //   277: aload_0
      //   278: getfield 27	com/baidu/location/a/e$a:d	Z
      //   281: ifeq -30 -> 251
      //   284: aload_0
      //   285: getfield 18	com/baidu/location/a/e$a:a	Lcom/baidu/location/a/e;
      //   288: invokestatic 213	com/baidu/location/a/e:b	(Lcom/baidu/location/a/e;)V
      //   291: goto -40 -> 251
      //   294: astore_3
      //   295: goto -44 -> 251
      //   298: astore_3
      //   299: goto -84 -> 215
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	302	0	this	a
      //   0	302	1	paramBoolean	boolean
      //   95	145	2	i	int
      //   1	247	3	localObject1	Object
      //   294	1	3	localException1	Exception
      //   298	1	3	localException2	Exception
      //   17	179	4	localObject2	Object
      // Exception table:
      //   from	to	target	type
      //   13	37	294	java/lang/Exception
      //   37	55	294	java/lang/Exception
      //   59	150	294	java/lang/Exception
      //   215	251	294	java/lang/Exception
      //   150	215	298	java/lang/Exception
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */