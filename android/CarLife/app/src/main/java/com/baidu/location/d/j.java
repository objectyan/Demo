package com.baidu.location.d;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.wifi.ScanResult;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.location.Jni;
import com.baidu.location.a.h;
import com.baidu.location.g.a;
import com.baidu.location.h.b;
import com.baidu.location.h.g;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

public class j
  extends com.baidu.location.h.e
{
  private c A = null;
  private int B = 0;
  private boolean C = false;
  private long D = 0L;
  private SQLiteDatabase E = null;
  private b F = b.a;
  String a = null;
  String b = null;
  String c = null;
  private boolean d = false;
  private boolean e = false;
  private ArrayList<a> f = null;
  private int p = 0;
  private String q = "0";
  private boolean r = true;
  private boolean s = true;
  private boolean t = true;
  private boolean u = true;
  private int v = 60;
  private int w = 120;
  private int x = 15;
  private int y = 20;
  private boolean z = false;
  
  private j()
  {
    try
    {
      File localFile1 = new File(g.l() + File.separator + "bus_mac.db");
      File localFile2 = new File(g.l() + File.separator + "bus_mac_repll.db");
      if (localFile1.exists())
      {
        if (localFile2.exists()) {
          localFile2.delete();
        }
        localFile1.renameTo(localFile2);
        this.d = true;
        return;
      }
      if (localFile2.exists())
      {
        this.d = true;
        return;
      }
    }
    catch (Exception localException)
    {
      this.d = false;
      return;
    }
    this.d = false;
  }
  
  private static byte a(char paramChar)
  {
    return (byte)"0123456789ABCDEF".indexOf(paramChar);
  }
  
  public static j b()
  {
    return d.a;
  }
  
  private static byte[] b(String paramString)
  {
    if ((paramString == null) || (paramString.equals("")))
    {
      paramString = null;
      return paramString;
    }
    paramString = paramString.toUpperCase(Locale.US);
    int j = paramString.length() / 2;
    char[] arrayOfChar = paramString.toCharArray();
    byte[] arrayOfByte = new byte[j];
    int i = 0;
    for (;;)
    {
      paramString = arrayOfByte;
      if (i >= j) {
        break;
      }
      int k = i * 2;
      int m = a(arrayOfChar[k]);
      arrayOfByte[i] = ((byte)(a(arrayOfChar[(k + 1)]) | m << 4));
      i += 1;
    }
  }
  
  private void d(String paramString)
  {
    SharedPreferences.Editor localEditor = com.baidu.location.f.getServiceContext().getSharedPreferences("loc_realbus_config", 0).edit();
    localEditor.putString("config", paramString);
    localEditor.commit();
  }
  
  private boolean k()
  {
    return com.baidu.location.b.c.a().f() >= this.y;
  }
  
  private void l()
  {
    this.C = false;
    this.B = 0;
    this.D = 0L;
  }
  
  private void m()
  {
    if ((!this.C) || (this.F != b.c)) {}
    do
    {
      return;
      this.C = false;
    } while ((!this.r) || (!this.u));
    n();
  }
  
  private void n()
  {
    a.a().post(new Runnable()
    {
      public void run()
      {
        int i = 0;
        Object localObject = j.this.b(com.baidu.location.f.f.a().p().a);
        Bundle localBundle;
        int k;
        if ((localObject != null) && (((ArrayList)localObject).size() > 0))
        {
          j.a(j.this, 0);
          localBundle = new Bundle();
          k = ((ArrayList)localObject).size();
          int j = k;
          if (k > 3) {
            j = 3;
          }
          k = 0;
          if (k < j)
          {
            byte[] arrayOfByte = j.a((String)((ArrayList)localObject).get(k));
            if ((arrayOfByte == null) || (arrayOfByte.length != 6)) {
              break label183;
            }
            localBundle.putByteArray("mac" + i, arrayOfByte);
            i += 1;
          }
        }
        label183:
        for (;;)
        {
          k += 1;
          break;
          if (i != 0)
          {
            localObject = d.a().e().obtainMessage(1);
            localBundle.putInt("num", i);
            ((Message)localObject).setData(localBundle);
            ((Message)localObject).sendToTarget();
          }
          return;
          j.b(j.this);
          return;
        }
      }
    });
  }
  
  private void o()
  {
    long l = com.baidu.location.h.c.a().e();
    if (System.currentTimeMillis() - l > 86400000L) {
      a.a().postDelayed(new Runnable()
      {
        public void run()
        {
          if (com.baidu.location.f.f.j())
          {
            j.this.h();
            com.baidu.location.h.c.a().e(System.currentTimeMillis());
          }
        }
      }, 7000L);
    }
  }
  
  private void p()
  {
    Object localObject = com.baidu.location.f.getServiceContext().getSharedPreferences("loc_realbus_config", 0).getString("config", null);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    try
    {
      localObject = new JSONObject((String)localObject);
      if ((((JSONObject)localObject).has("is_on")) && (!((JSONObject)localObject).getString("is_on").equals("on"))) {
        this.r = false;
      }
      if ((((JSONObject)localObject).has("is_net_front_on")) && (!((JSONObject)localObject).getString("is_net_front_on").equals("on"))) {
        this.s = false;
      }
      if ((((JSONObject)localObject).has("is_net_back_on")) && (!((JSONObject)localObject).getString("is_net_back_on").equals("on"))) {
        this.t = false;
      }
      if ((((JSONObject)localObject).has("is_gps_on")) && (!((JSONObject)localObject).getString("is_gps_on").equals("on"))) {
        this.u = false;
      }
      if (((JSONObject)localObject).has("net_front_threshold")) {
        this.v = ((JSONObject)localObject).getInt("net_front_threshold");
      }
      if (((JSONObject)localObject).has("net_back_threshold")) {
        this.w = ((JSONObject)localObject).getInt("net_back_threshold");
      }
      if (((JSONObject)localObject).has("gps_threshold")) {
        this.x = ((JSONObject)localObject).getInt("gps_threshold");
      }
      if (((JSONObject)localObject).has("battery_threshold")) {
        this.y = ((JSONObject)localObject).getInt("battery_threshold");
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  private void q()
  {
    if (this.b == null) {}
    for (;;)
    {
      return;
      if (com.baidu.location.f.f.j()) {
        try
        {
          File localFile = new File(g.l() + File.separator + this.b);
          if (localFile.exists()) {
            localFile.delete();
          }
          if ((!localFile.exists()) && (com.baidu.location.a.j.a("http://" + this.a + "/" + this.b, this.b)))
          {
            String str = g.a(localFile, "MD5");
            if ((this.c != null) && (str != null) && (this.c.equals(str))) {
              new com.baidu.location.indoor.b.d().a(g.l() + File.separator + this.b, g.l() + File.separator);
            }
            localFile.delete();
            return;
          }
        }
        catch (Exception localException) {}
      }
    }
  }
  
  public void a()
  {
    StringBuffer localStringBuffer = new StringBuffer(128);
    localStringBuffer.append("&sdk=");
    localStringBuffer.append(7.32F);
    localStringBuffer.append("&fw=");
    localStringBuffer.append(com.baidu.location.f.getFrameVersion());
    localStringBuffer.append("&suit=");
    localStringBuffer.append(1);
    if (b.a().b == null)
    {
      localStringBuffer.append("&im=");
      localStringBuffer.append(b.a().a);
    }
    for (;;)
    {
      localStringBuffer.append("&mb=");
      localStringBuffer.append(Build.MODEL);
      localStringBuffer.append("&sv=");
      String str2 = Build.VERSION.RELEASE;
      String str1 = str2;
      if (str2 != null)
      {
        str1 = str2;
        if (str2.length() > 10) {
          str1 = str2.substring(0, 10);
        }
      }
      localStringBuffer.append(str1);
      localStringBuffer.append("&pack=");
      localStringBuffer.append(b.d);
      localStringBuffer.append("&ver=");
      localStringBuffer.append("" + this.q);
      this.h = (g.g() + "?&it=" + Jni.en1(localStringBuffer.toString()));
      return;
      localStringBuffer.append("&cu=");
      localStringBuffer.append(b.a().b);
    }
  }
  
  public void a(double paramDouble1, double paramDouble2)
  {
    if (!this.e)
    {
      this.e = true;
      if (this.d) {
        break label20;
      }
    }
    for (;;)
    {
      return;
      label20:
      if ((this.f != null) && (this.f.size() > 0))
      {
        int i = 0;
        while (i < this.f.size())
        {
          a locala = (a)this.f.get(i);
          if ((paramDouble1 <= locala.b) && (paramDouble1 >= locala.c) && (paramDouble2 >= locala.e) && (paramDouble2 <= locala.d))
          {
            this.p = locala.a;
            return;
          }
          i += 1;
        }
      }
    }
  }
  
  public void a(b paramb)
  {
    this.F = paramb;
    if ((this.z) && (this.A != null)) {
      a.a().removeCallbacks(this.A);
    }
    if (this.F == b.c) {}
    do
    {
      return;
      if (this.F == b.a)
      {
        l();
        return;
      }
      l();
    } while ((!this.r) || (!this.t) || (!k()));
    if (this.A == null) {
      this.A = new c(null);
    }
    a.a().postDelayed(this.A, this.w * 1000);
    this.z = true;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      JSONObject localJSONObject = new JSONObject(this.j);
      String str = localJSONObject.getString("res");
      if ("up".equals(str))
      {
        this.a = localJSONObject.getString("upath");
        if (localJSONObject.has("u1")) {
          this.b = localJSONObject.getString("u1");
        }
        if (localJSONObject.has("u1_md5")) {
          this.c = localJSONObject.getString("u1_md5");
        }
        new Thread()
        {
          public void run()
          {
            j.g(j.this);
          }
        }.start();
      }
      if (!"fail".equals(str)) {
        d(localJSONObject.toString());
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public boolean a(List<ScanResult> paramList)
  {
    boolean bool2 = false;
    paramList = b(paramList);
    boolean bool1 = bool2;
    if (paramList != null)
    {
      bool1 = bool2;
      if (paramList.size() > 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  /* Error */
  public ArrayList<String> b(List<ScanResult> paramList)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: invokestatic 278	java/lang/System:currentTimeMillis	()J
    //   8: pop2
    //   9: aload_0
    //   10: getfield 68	com/baidu/location/d/j:p	I
    //   13: ifeq +10 -> 23
    //   16: aload_0
    //   17: getfield 106	com/baidu/location/d/j:E	Landroid/database/sqlite/SQLiteDatabase;
    //   20: ifnonnull +5 -> 25
    //   23: aconst_null
    //   24: areturn
    //   25: aload_1
    //   26: ifnull -3 -> 23
    //   29: aload_1
    //   30: invokeinterface 490 1 0
    //   35: ifeq -12 -> 23
    //   38: new 492	java/util/HashMap
    //   41: dup
    //   42: invokespecial 493	java/util/HashMap:<init>	()V
    //   45: astore 5
    //   47: aload_1
    //   48: invokeinterface 497 1 0
    //   53: astore_1
    //   54: new 356	java/lang/StringBuffer
    //   57: dup
    //   58: invokespecial 498	java/lang/StringBuffer:<init>	()V
    //   61: astore 6
    //   63: iconst_1
    //   64: istore_2
    //   65: aload_1
    //   66: invokeinterface 503 1 0
    //   71: ifeq +91 -> 162
    //   74: aload_1
    //   75: invokeinterface 507 1 0
    //   80: checkcast 509	android/net/wifi/ScanResult
    //   83: getfield 512	android/net/wifi/ScanResult:BSSID	Ljava/lang/String;
    //   86: astore 7
    //   88: aload 7
    //   90: invokestatic 297	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   93: ifne +66 -> 159
    //   96: aload 7
    //   98: ldc_w 514
    //   101: ldc -79
    //   103: invokevirtual 518	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   106: astore 7
    //   108: aload 7
    //   110: invokestatic 522	com/baidu/location/Jni:encode3	(Ljava/lang/String;)Ljava/lang/Long;
    //   113: astore 8
    //   115: aload 5
    //   117: aload 8
    //   119: aload 7
    //   121: invokevirtual 526	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   124: pop
    //   125: iload_2
    //   126: ifeq +16 -> 142
    //   129: aload 6
    //   131: aload 8
    //   133: invokevirtual 529	java/lang/StringBuffer:append	(Ljava/lang/Object;)Ljava/lang/StringBuffer;
    //   136: pop
    //   137: iconst_0
    //   138: istore_2
    //   139: goto -74 -> 65
    //   142: aload 6
    //   144: ldc_w 531
    //   147: invokevirtual 364	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   150: pop
    //   151: aload 6
    //   153: aload 8
    //   155: invokevirtual 529	java/lang/StringBuffer:append	(Ljava/lang/Object;)Ljava/lang/StringBuffer;
    //   158: pop
    //   159: goto -20 -> 139
    //   162: aload 6
    //   164: invokevirtual 417	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   167: invokestatic 297	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   170: ifne +219 -> 389
    //   173: getstatic 187	java/util/Locale:US	Ljava/util/Locale;
    //   176: ldc_w 533
    //   179: iconst_2
    //   180: anewarray 535	java/lang/Object
    //   183: dup
    //   184: iconst_0
    //   185: aload_0
    //   186: getfield 68	com/baidu/location/d/j:p	I
    //   189: invokestatic 541	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   192: aastore
    //   193: dup
    //   194: iconst_1
    //   195: aload 6
    //   197: invokevirtual 417	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   200: aastore
    //   201: invokestatic 545	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   204: astore_1
    //   205: aload_0
    //   206: getfield 106	com/baidu/location/d/j:E	Landroid/database/sqlite/SQLiteDatabase;
    //   209: aload_1
    //   210: aconst_null
    //   211: invokevirtual 551	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   214: astore_1
    //   215: aload_1
    //   216: ifnull +167 -> 383
    //   219: aload_1
    //   220: invokeinterface 556 1 0
    //   225: ifeq +158 -> 383
    //   228: iconst_0
    //   229: ifne +11 -> 240
    //   232: new 430	java/util/ArrayList
    //   235: dup
    //   236: invokespecial 557	java/util/ArrayList:<init>	()V
    //   239: astore_3
    //   240: aload_1
    //   241: invokeinterface 560 1 0
    //   246: ifne +62 -> 308
    //   249: aload_3
    //   250: aload 5
    //   252: aload_1
    //   253: iconst_0
    //   254: invokeinterface 564 2 0
    //   259: invokestatic 569	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   262: invokevirtual 572	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   265: invokevirtual 575	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   268: pop
    //   269: aload_1
    //   270: invokeinterface 578 1 0
    //   275: pop
    //   276: goto -36 -> 240
    //   279: astore 4
    //   281: aload_1
    //   282: astore 4
    //   284: aload_3
    //   285: astore_1
    //   286: aload_1
    //   287: astore_3
    //   288: aload 4
    //   290: ifnull +12 -> 302
    //   293: aload 4
    //   295: invokeinterface 581 1 0
    //   300: aload_1
    //   301: astore_3
    //   302: invokestatic 278	java/lang/System:currentTimeMillis	()J
    //   305: pop2
    //   306: aload_3
    //   307: areturn
    //   308: aload_3
    //   309: astore 4
    //   311: aload 4
    //   313: astore_3
    //   314: aload_1
    //   315: ifnull -13 -> 302
    //   318: aload_1
    //   319: invokeinterface 581 1 0
    //   324: aload 4
    //   326: astore_3
    //   327: goto -25 -> 302
    //   330: astore_1
    //   331: aload 4
    //   333: astore_3
    //   334: goto -32 -> 302
    //   337: astore_3
    //   338: aconst_null
    //   339: astore_1
    //   340: aload_1
    //   341: ifnull +9 -> 350
    //   344: aload_1
    //   345: invokeinterface 581 1 0
    //   350: aload_3
    //   351: athrow
    //   352: astore_3
    //   353: aload_1
    //   354: astore_3
    //   355: goto -53 -> 302
    //   358: astore_1
    //   359: goto -9 -> 350
    //   362: astore_3
    //   363: goto -23 -> 340
    //   366: astore_1
    //   367: aconst_null
    //   368: astore_1
    //   369: goto -83 -> 286
    //   372: astore_3
    //   373: aconst_null
    //   374: astore_3
    //   375: aload_1
    //   376: astore 4
    //   378: aload_3
    //   379: astore_1
    //   380: goto -94 -> 286
    //   383: aconst_null
    //   384: astore 4
    //   386: goto -75 -> 311
    //   389: aconst_null
    //   390: astore_3
    //   391: goto -89 -> 302
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	394	0	this	j
    //   0	394	1	paramList	List<ScanResult>
    //   64	75	2	i	int
    //   4	330	3	localObject1	Object
    //   337	14	3	localObject2	Object
    //   352	1	3	localException1	Exception
    //   354	1	3	localList	List<ScanResult>
    //   362	1	3	localObject3	Object
    //   372	1	3	localException2	Exception
    //   374	17	3	localObject4	Object
    //   1	1	4	localObject5	Object
    //   279	1	4	localException3	Exception
    //   282	103	4	localObject6	Object
    //   45	206	5	localHashMap	java.util.HashMap
    //   61	135	6	localStringBuffer	StringBuffer
    //   86	34	7	str	String
    //   113	41	8	localLong	Long
    // Exception table:
    //   from	to	target	type
    //   240	276	279	java/lang/Exception
    //   318	324	330	java/lang/Exception
    //   205	215	337	finally
    //   293	300	352	java/lang/Exception
    //   344	350	358	java/lang/Exception
    //   219	228	362	finally
    //   232	240	362	finally
    //   240	276	362	finally
    //   205	215	366	java/lang/Exception
    //   219	228	372	java/lang/Exception
    //   232	240	372	java/lang/Exception
  }
  
  public void c()
  {
    if ((!this.r) || (!this.u)) {}
    long l;
    do
    {
      do
      {
        return;
      } while (!k());
      this.C = false;
      if (this.B <= 3) {
        break;
      }
      l = System.currentTimeMillis() - this.D;
    } while ((l <= (this.B - 3) * (this.x * 2 * 1000)) && (l <= 120000L));
    com.baidu.location.f.f.a().g();
    this.C = true;
    this.D = System.currentTimeMillis();
    a.a().postDelayed(new Runnable()
    {
      public void run()
      {
        j.a(j.this);
      }
    }, 3000L);
  }
  
  public boolean d()
  {
    if (this.F == b.a) {}
    for (boolean bool = true;; bool = false)
    {
      if ((!this.r) || (!this.s)) {
        bool = false;
      }
      if (!k()) {
        return false;
      }
      return bool;
    }
  }
  
  /* Error */
  public void e()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: aload_0
    //   5: aconst_null
    //   6: putfield 106	com/baidu/location/d/j:E	Landroid/database/sqlite/SQLiteDatabase;
    //   9: aload_0
    //   10: getfield 62	com/baidu/location/d/j:d	Z
    //   13: ifeq +208 -> 221
    //   16: new 114	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   23: invokestatic 121	com/baidu/location/h/g:l	()Ljava/lang/String;
    //   26: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: getstatic 128	java/io/File:separator	Ljava/lang/String;
    //   32: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: ldc -118
    //   37: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: astore_1
    //   44: aload_0
    //   45: aload_1
    //   46: aconst_null
    //   47: invokestatic 596	android/database/sqlite/SQLiteDatabase:openOrCreateDatabase	(Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;)Landroid/database/sqlite/SQLiteDatabase;
    //   50: putfield 106	com/baidu/location/d/j:E	Landroid/database/sqlite/SQLiteDatabase;
    //   53: aload_0
    //   54: getfield 106	com/baidu/location/d/j:E	Landroid/database/sqlite/SQLiteDatabase;
    //   57: ifnull +164 -> 221
    //   60: aload_0
    //   61: getfield 106	com/baidu/location/d/j:E	Landroid/database/sqlite/SQLiteDatabase;
    //   64: ldc_w 598
    //   67: aconst_null
    //   68: invokevirtual 551	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   71: astore_1
    //   72: aload_1
    //   73: ifnull +27 -> 100
    //   76: aload_3
    //   77: astore_2
    //   78: aload_1
    //   79: invokeinterface 556 1 0
    //   84: ifeq +16 -> 100
    //   87: aload_3
    //   88: astore_2
    //   89: aload_0
    //   90: aload_1
    //   91: iconst_0
    //   92: invokeinterface 601 2 0
    //   97: putfield 72	com/baidu/location/d/j:q	Ljava/lang/String;
    //   100: aload_3
    //   101: astore_2
    //   102: aload_0
    //   103: getfield 106	com/baidu/location/d/j:E	Landroid/database/sqlite/SQLiteDatabase;
    //   106: ldc_w 603
    //   109: aconst_null
    //   110: invokevirtual 551	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   113: astore_3
    //   114: aload_3
    //   115: ifnull +124 -> 239
    //   118: aload_3
    //   119: astore_2
    //   120: aload_3
    //   121: invokeinterface 556 1 0
    //   126: ifeq +113 -> 239
    //   129: aload_3
    //   130: astore_2
    //   131: aload_0
    //   132: new 430	java/util/ArrayList
    //   135: dup
    //   136: invokespecial 557	java/util/ArrayList:<init>	()V
    //   139: putfield 66	com/baidu/location/d/j:f	Ljava/util/ArrayList;
    //   142: aload_3
    //   143: astore_2
    //   144: aload_3
    //   145: invokeinterface 560 1 0
    //   150: ifne +89 -> 239
    //   153: aload_3
    //   154: astore_2
    //   155: new 14	com/baidu/location/d/j$a
    //   158: dup
    //   159: aload_0
    //   160: aload_3
    //   161: invokespecial 606	com/baidu/location/d/j$a:<init>	(Lcom/baidu/location/d/j;Landroid/database/Cursor;)V
    //   164: astore 4
    //   166: aload_3
    //   167: astore_2
    //   168: aload 4
    //   170: getfield 608	com/baidu/location/d/j$a:f	Z
    //   173: ifeq +15 -> 188
    //   176: aload_3
    //   177: astore_2
    //   178: aload_0
    //   179: getfield 66	com/baidu/location/d/j:f	Ljava/util/ArrayList;
    //   182: aload 4
    //   184: invokevirtual 575	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   187: pop
    //   188: aload_3
    //   189: astore_2
    //   190: aload_3
    //   191: invokeinterface 578 1 0
    //   196: pop
    //   197: goto -55 -> 142
    //   200: astore_3
    //   201: aload_1
    //   202: ifnull +9 -> 211
    //   205: aload_1
    //   206: invokeinterface 581 1 0
    //   211: aload_2
    //   212: ifnull +9 -> 221
    //   215: aload_2
    //   216: invokeinterface 581 1 0
    //   221: aload_0
    //   222: invokespecial 610	com/baidu/location/d/j:p	()V
    //   225: aload_0
    //   226: invokespecial 612	com/baidu/location/d/j:o	()V
    //   229: return
    //   230: astore_1
    //   231: aload_0
    //   232: aconst_null
    //   233: putfield 106	com/baidu/location/d/j:E	Landroid/database/sqlite/SQLiteDatabase;
    //   236: goto -183 -> 53
    //   239: aload_1
    //   240: ifnull +9 -> 249
    //   243: aload_1
    //   244: invokeinterface 581 1 0
    //   249: aload_3
    //   250: ifnull -29 -> 221
    //   253: aload_3
    //   254: invokeinterface 581 1 0
    //   259: goto -38 -> 221
    //   262: astore_1
    //   263: goto -42 -> 221
    //   266: astore_1
    //   267: aconst_null
    //   268: astore_3
    //   269: aconst_null
    //   270: astore_2
    //   271: aload_3
    //   272: ifnull +9 -> 281
    //   275: aload_3
    //   276: invokeinterface 581 1 0
    //   281: aload_2
    //   282: ifnull +9 -> 291
    //   285: aload_2
    //   286: invokeinterface 581 1 0
    //   291: aload_1
    //   292: athrow
    //   293: astore_1
    //   294: goto -45 -> 249
    //   297: astore_1
    //   298: goto -87 -> 211
    //   301: astore_1
    //   302: goto -81 -> 221
    //   305: astore_3
    //   306: goto -25 -> 281
    //   309: astore_2
    //   310: goto -19 -> 291
    //   313: astore 4
    //   315: aload_1
    //   316: astore_3
    //   317: aconst_null
    //   318: astore_2
    //   319: aload 4
    //   321: astore_1
    //   322: goto -51 -> 271
    //   325: astore 5
    //   327: aload_1
    //   328: astore 4
    //   330: aload_3
    //   331: astore_2
    //   332: aload 5
    //   334: astore_1
    //   335: aload 4
    //   337: astore_3
    //   338: goto -67 -> 271
    //   341: astore_1
    //   342: aconst_null
    //   343: astore_1
    //   344: goto -143 -> 201
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	347	0	this	j
    //   43	163	1	localObject1	Object
    //   230	14	1	localException1	Exception
    //   262	1	1	localException2	Exception
    //   266	26	1	localObject2	Object
    //   293	1	1	localException3	Exception
    //   297	1	1	localException4	Exception
    //   301	15	1	localException5	Exception
    //   321	14	1	localObject3	Object
    //   341	1	1	localException6	Exception
    //   343	1	1	localObject4	Object
    //   1	285	2	localObject5	Object
    //   309	1	2	localException7	Exception
    //   318	14	2	localObject6	Object
    //   3	188	3	localCursor	Cursor
    //   200	54	3	localException8	Exception
    //   268	8	3	localObject7	Object
    //   305	1	3	localException9	Exception
    //   316	22	3	localObject8	Object
    //   164	19	4	locala	a
    //   313	7	4	localObject9	Object
    //   328	8	4	localObject10	Object
    //   325	8	5	localObject11	Object
    // Exception table:
    //   from	to	target	type
    //   78	87	200	java/lang/Exception
    //   89	100	200	java/lang/Exception
    //   102	114	200	java/lang/Exception
    //   120	129	200	java/lang/Exception
    //   131	142	200	java/lang/Exception
    //   144	153	200	java/lang/Exception
    //   155	166	200	java/lang/Exception
    //   168	176	200	java/lang/Exception
    //   178	188	200	java/lang/Exception
    //   190	197	200	java/lang/Exception
    //   44	53	230	java/lang/Exception
    //   253	259	262	java/lang/Exception
    //   60	72	266	finally
    //   243	249	293	java/lang/Exception
    //   205	211	297	java/lang/Exception
    //   215	221	301	java/lang/Exception
    //   275	281	305	java/lang/Exception
    //   285	291	309	java/lang/Exception
    //   78	87	313	finally
    //   89	100	313	finally
    //   102	114	313	finally
    //   120	129	325	finally
    //   131	142	325	finally
    //   144	153	325	finally
    //   155	166	325	finally
    //   168	176	325	finally
    //   178	188	325	finally
    //   190	197	325	finally
    //   60	72	341	java/lang/Exception
  }
  
  public void f()
  {
    if (this.E != null) {}
    try
    {
      this.E.close();
      return;
    }
    catch (Exception localException) {}
  }
  
  public int g()
  {
    return this.v;
  }
  
  private class a
  {
    int a;
    double b;
    double c;
    double d;
    double e;
    boolean f = false;
    
    a(Cursor paramCursor)
    {
      try
      {
        this.a = paramCursor.getInt(0);
        this.b = paramCursor.getDouble(4);
        this.c = paramCursor.getDouble(3);
        this.d = paramCursor.getDouble(2);
        this.e = paramCursor.getDouble(1);
        this.f = true;
        return;
      }
      catch (Exception this$1)
      {
        this.f = false;
      }
    }
  }
  
  public static enum b
  {
    private b() {}
  }
  
  private class c
    implements Runnable
  {
    private c() {}
    
    public void run()
    {
      if (j.c(j.this) == true)
      {
        j.a(j.this, false);
        if (j.d(j.this) == j.b.b) {}
      }
      else
      {
        return;
      }
      if (com.baidu.location.f.f.a().g()) {
        a.a().postDelayed(new Runnable()
        {
          public void run()
          {
            if (j.this.a(com.baidu.location.f.f.a().p().a)) {
              h.c().h();
            }
          }
        }, 3000L);
      }
      a.a().postDelayed(j.e(j.this), j.f(j.this) * 1000);
      j.a(j.this, true);
    }
  }
  
  private static class d
  {
    public static final j a = new j(null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/d/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */