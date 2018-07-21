package com.baidu.mobstat;

import android.content.Context;
import android.text.TextUtils;
import java.text.SimpleDateFormat;
import org.json.JSONObject;

public class az
{
  private static az a;
  private Context b;
  private JSONObject c = new JSONObject();
  private long d = 24L;
  private long e = 0L;
  private long f = 0L;
  private long g = 0L;
  private long h = 5L;
  private long i = 24L;
  private long j = 15L;
  private long k = 15L;
  private long l = 30L;
  private long m = 12L;
  private long n = 1L;
  private long o = 24L;
  private String p = "";
  private String q = "";
  
  private az(Context paramContext)
  {
    this.b = paramContext;
    m();
    j();
    k();
  }
  
  public static az a(Context paramContext)
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new az(paramContext);
      }
      return a;
    }
    finally {}
  }
  
  private long b(long paramLong)
  {
    long l1 = paramLong;
    if (paramLong - System.currentTimeMillis() > 0L) {
      l1 = 0L;
    }
    return l1;
  }
  
  private void m()
  {
    String str = cu.b("backups/system/.timestamp");
    try
    {
      if (!TextUtils.isEmpty(str)) {
        this.c = new JSONObject(str);
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public long a(u paramu)
  {
    l2 = paramu.j;
    try
    {
      paramu = paramu.toString();
      l1 = l2;
      if (this.c.has(paramu)) {
        l1 = this.c.getLong(paramu);
      }
    }
    catch (Exception paramu)
    {
      for (;;)
      {
        bd.a(paramu);
        long l1 = l2;
      }
    }
    return b(l1);
  }
  
  public void a(u paramu, long paramLong)
  {
    paramu.j = paramLong;
    try
    {
      this.c.put(paramu.toString(), paramLong);
    }
    catch (Exception paramu)
    {
      for (;;)
      {
        try
        {
          cu.a("backups/system/.timestamp", this.c.toString(), false);
          return;
        }
        catch (Exception paramu)
        {
          bd.a(paramu);
        }
        paramu = paramu;
        bd.a(paramu);
      }
    }
  }
  
  public void a(String paramString)
  {
    cu.a(this.b, ".config2", paramString, false);
    j();
  }
  
  public boolean a()
  {
    return this.e != 0L;
  }
  
  public boolean a(long paramLong)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyyMMdd");
    return localSimpleDateFormat.format(Long.valueOf(paramLong)).equals(localSimpleDateFormat.format(Long.valueOf(System.currentTimeMillis())));
  }
  
  public void b(String paramString)
  {
    cu.a(this.b, ".sign", paramString, false);
    k();
  }
  
  public boolean b()
  {
    return this.f != 0L;
  }
  
  public long c()
  {
    return this.d * 60L * 60L * 1000L;
  }
  
  public String c(String paramString)
  {
    if ((!TextUtils.isEmpty(this.p)) && (this.p.equals(paramString)) && (!TextUtils.isEmpty(this.q))) {
      return this.q;
    }
    return "";
  }
  
  public long d()
  {
    return this.o * 60L * 60L * 1000L;
  }
  
  public long e()
  {
    return this.h * 60L * 1000L;
  }
  
  public long f()
  {
    return this.i * 60L * 60L * 1000L;
  }
  
  public long g()
  {
    return this.j * 24L * 60L * 60L * 1000L;
  }
  
  public long h()
  {
    return this.k * 24L * 60L * 60L * 1000L;
  }
  
  public long i()
  {
    return this.m * 60L * 60L * 1000L;
  }
  
  /* Error */
  public void j()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 78	com/baidu/mobstat/az:b	Landroid/content/Context;
    //   4: ldc -107
    //   6: invokestatic 186	com/baidu/mobstat/cu:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   9: astore_1
    //   10: new 171	java/lang/String
    //   13: dup
    //   14: iconst_0
    //   15: invokestatic 191	com/baidu/mobstat/cw:a	()[B
    //   18: aload_1
    //   19: invokevirtual 194	java/lang/String:getBytes	()[B
    //   22: invokestatic 199	com/baidu/mobstat/cv:a	([B)[B
    //   25: invokestatic 204	com/baidu/mobstat/dc:b	(Z[B[B)[B
    //   28: invokespecial 207	java/lang/String:<init>	([B)V
    //   31: astore_1
    //   32: aload_1
    //   33: invokestatic 112	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   36: ifeq +4 -> 40
    //   39: return
    //   40: new 33	org/json/JSONObject
    //   43: dup
    //   44: aload_1
    //   45: invokespecial 115	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   48: astore_1
    //   49: aload_0
    //   50: aload_1
    //   51: ldc -48
    //   53: invokevirtual 131	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   56: putfield 42	com/baidu/mobstat/az:e	J
    //   59: aload_0
    //   60: aload_1
    //   61: ldc -47
    //   63: invokevirtual 131	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   66: putfield 50	com/baidu/mobstat/az:h	J
    //   69: aload_0
    //   70: aload_1
    //   71: ldc -46
    //   73: invokevirtual 131	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   76: putfield 52	com/baidu/mobstat/az:i	J
    //   79: aload_0
    //   80: aload_1
    //   81: ldc -45
    //   83: invokevirtual 131	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   86: putfield 56	com/baidu/mobstat/az:j	J
    //   89: aload_0
    //   90: aload_1
    //   91: ldc -44
    //   93: invokevirtual 131	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   96: putfield 40	com/baidu/mobstat/az:d	J
    //   99: aload_0
    //   100: aload_1
    //   101: ldc -42
    //   103: invokevirtual 131	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   106: putfield 70	com/baidu/mobstat/az:o	J
    //   109: aload_0
    //   110: aload_1
    //   111: ldc -40
    //   113: invokevirtual 131	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   116: putfield 58	com/baidu/mobstat/az:k	J
    //   119: aload_0
    //   120: aload_1
    //   121: ldc -38
    //   123: invokevirtual 131	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   126: putfield 62	com/baidu/mobstat/az:l	J
    //   129: aload_0
    //   130: aload_1
    //   131: ldc -36
    //   133: invokevirtual 131	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   136: putfield 66	com/baidu/mobstat/az:m	J
    //   139: aload_0
    //   140: aload_1
    //   141: ldc -34
    //   143: invokevirtual 131	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   146: putfield 68	com/baidu/mobstat/az:n	J
    //   149: aload_0
    //   150: aload_1
    //   151: ldc -32
    //   153: invokevirtual 131	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   156: putfield 44	com/baidu/mobstat/az:f	J
    //   159: aload_0
    //   160: aload_1
    //   161: ldc -30
    //   163: invokevirtual 131	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   166: putfield 46	com/baidu/mobstat/az:g	J
    //   169: return
    //   170: astore_1
    //   171: aload_1
    //   172: invokestatic 228	com/baidu/mobstat/bd:b	(Ljava/lang/Throwable;)V
    //   175: return
    //   176: astore_1
    //   177: aload_1
    //   178: invokestatic 228	com/baidu/mobstat/bd:b	(Ljava/lang/Throwable;)V
    //   181: return
    //   182: astore_2
    //   183: aload_2
    //   184: invokestatic 228	com/baidu/mobstat/bd:b	(Ljava/lang/Throwable;)V
    //   187: goto -128 -> 59
    //   190: astore_2
    //   191: aload_2
    //   192: invokestatic 228	com/baidu/mobstat/bd:b	(Ljava/lang/Throwable;)V
    //   195: goto -126 -> 69
    //   198: astore_2
    //   199: aload_2
    //   200: invokestatic 228	com/baidu/mobstat/bd:b	(Ljava/lang/Throwable;)V
    //   203: goto -124 -> 79
    //   206: astore_2
    //   207: aload_2
    //   208: invokestatic 228	com/baidu/mobstat/bd:b	(Ljava/lang/Throwable;)V
    //   211: goto -122 -> 89
    //   214: astore_2
    //   215: aload_2
    //   216: invokestatic 228	com/baidu/mobstat/bd:b	(Ljava/lang/Throwable;)V
    //   219: goto -120 -> 99
    //   222: astore_2
    //   223: aload_2
    //   224: invokestatic 228	com/baidu/mobstat/bd:b	(Ljava/lang/Throwable;)V
    //   227: goto -118 -> 109
    //   230: astore_2
    //   231: aload_2
    //   232: invokestatic 228	com/baidu/mobstat/bd:b	(Ljava/lang/Throwable;)V
    //   235: goto -116 -> 119
    //   238: astore_2
    //   239: aload_2
    //   240: invokestatic 228	com/baidu/mobstat/bd:b	(Ljava/lang/Throwable;)V
    //   243: goto -114 -> 129
    //   246: astore_2
    //   247: aload_2
    //   248: invokestatic 228	com/baidu/mobstat/bd:b	(Ljava/lang/Throwable;)V
    //   251: goto -112 -> 139
    //   254: astore_2
    //   255: aload_2
    //   256: invokestatic 228	com/baidu/mobstat/bd:b	(Ljava/lang/Throwable;)V
    //   259: goto -110 -> 149
    //   262: astore_2
    //   263: aload_2
    //   264: invokestatic 228	com/baidu/mobstat/bd:b	(Ljava/lang/Throwable;)V
    //   267: goto -108 -> 159
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	270	0	this	az
    //   9	152	1	localObject	Object
    //   170	2	1	localJSONException1	org.json.JSONException
    //   176	2	1	localException	Exception
    //   182	2	2	localJSONException2	org.json.JSONException
    //   190	2	2	localJSONException3	org.json.JSONException
    //   198	2	2	localJSONException4	org.json.JSONException
    //   206	2	2	localJSONException5	org.json.JSONException
    //   214	2	2	localJSONException6	org.json.JSONException
    //   222	2	2	localJSONException7	org.json.JSONException
    //   230	2	2	localJSONException8	org.json.JSONException
    //   238	2	2	localJSONException9	org.json.JSONException
    //   246	2	2	localJSONException10	org.json.JSONException
    //   254	2	2	localJSONException11	org.json.JSONException
    //   262	2	2	localJSONException12	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   159	169	170	org/json/JSONException
    //   10	39	176	java/lang/Exception
    //   40	49	176	java/lang/Exception
    //   49	59	176	java/lang/Exception
    //   59	69	176	java/lang/Exception
    //   69	79	176	java/lang/Exception
    //   79	89	176	java/lang/Exception
    //   89	99	176	java/lang/Exception
    //   99	109	176	java/lang/Exception
    //   109	119	176	java/lang/Exception
    //   119	129	176	java/lang/Exception
    //   129	139	176	java/lang/Exception
    //   139	149	176	java/lang/Exception
    //   149	159	176	java/lang/Exception
    //   159	169	176	java/lang/Exception
    //   171	175	176	java/lang/Exception
    //   183	187	176	java/lang/Exception
    //   191	195	176	java/lang/Exception
    //   199	203	176	java/lang/Exception
    //   207	211	176	java/lang/Exception
    //   215	219	176	java/lang/Exception
    //   223	227	176	java/lang/Exception
    //   231	235	176	java/lang/Exception
    //   239	243	176	java/lang/Exception
    //   247	251	176	java/lang/Exception
    //   255	259	176	java/lang/Exception
    //   263	267	176	java/lang/Exception
    //   49	59	182	org/json/JSONException
    //   59	69	190	org/json/JSONException
    //   69	79	198	org/json/JSONException
    //   79	89	206	org/json/JSONException
    //   89	99	214	org/json/JSONException
    //   99	109	222	org/json/JSONException
    //   109	119	230	org/json/JSONException
    //   119	129	238	org/json/JSONException
    //   129	139	246	org/json/JSONException
    //   139	149	254	org/json/JSONException
    //   149	159	262	org/json/JSONException
  }
  
  /* Error */
  public void k()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 78	com/baidu/mobstat/az:b	Landroid/content/Context;
    //   4: ldc -79
    //   6: invokestatic 186	com/baidu/mobstat/cu:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   9: astore_1
    //   10: new 171	java/lang/String
    //   13: dup
    //   14: iconst_0
    //   15: invokestatic 191	com/baidu/mobstat/cw:a	()[B
    //   18: aload_1
    //   19: invokevirtual 194	java/lang/String:getBytes	()[B
    //   22: invokestatic 199	com/baidu/mobstat/cv:a	([B)[B
    //   25: invokestatic 204	com/baidu/mobstat/dc:b	(Z[B[B)[B
    //   28: invokespecial 207	java/lang/String:<init>	([B)V
    //   31: astore_1
    //   32: aload_1
    //   33: invokestatic 112	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   36: ifeq +4 -> 40
    //   39: return
    //   40: new 33	org/json/JSONObject
    //   43: dup
    //   44: aload_1
    //   45: invokespecial 115	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   48: astore_1
    //   49: aload_0
    //   50: aload_1
    //   51: ldc -26
    //   53: invokevirtual 233	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   56: putfield 76	com/baidu/mobstat/az:q	Ljava/lang/String;
    //   59: aload_0
    //   60: aload_1
    //   61: ldc -21
    //   63: invokevirtual 233	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   66: putfield 74	com/baidu/mobstat/az:p	Ljava/lang/String;
    //   69: return
    //   70: astore_1
    //   71: aload_1
    //   72: invokestatic 228	com/baidu/mobstat/bd:b	(Ljava/lang/Throwable;)V
    //   75: return
    //   76: astore_1
    //   77: aload_1
    //   78: invokestatic 228	com/baidu/mobstat/bd:b	(Ljava/lang/Throwable;)V
    //   81: return
    //   82: astore_2
    //   83: aload_2
    //   84: invokestatic 228	com/baidu/mobstat/bd:b	(Ljava/lang/Throwable;)V
    //   87: goto -28 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	az
    //   9	52	1	localObject	Object
    //   70	2	1	localException1	Exception
    //   76	2	1	localException2	Exception
    //   82	2	2	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   59	69	70	java/lang/Exception
    //   10	39	76	java/lang/Exception
    //   40	49	76	java/lang/Exception
    //   71	75	76	java/lang/Exception
    //   83	87	76	java/lang/Exception
    //   49	59	82	java/lang/Exception
  }
  
  public boolean l()
  {
    long l1 = System.currentTimeMillis();
    long l2 = a(u.h);
    long l3 = d();
    bd.a("canSend now=" + l1 + ";lastSendTime=" + l2 + ";sendLogTimeInterval=" + l3);
    return (l1 - l2 > l3) || (!a(l2));
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mobstat/az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */