package com.baidu.che.codriver.b;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.che.codriver.protocol.data.nlp.NLPResponseData;
import com.baidu.che.codriver.util.c;
import com.baidu.che.codriver.util.h;
import com.baidu.che.codriver.util.l;
import com.baidu.che.codriver.vr.n;
import com.baidu.che.codriver.vr.p;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class a
{
  public static final boolean a = false;
  public static boolean b = l.a(c.a(), "support_aec", false);
  private static final String d = "CoDriverTestUtils";
  private static Map<String, Long> e = new HashMap();
  private static a f;
  private static long g = 0L;
  private static long h = 0L;
  private static long i = 0L;
  private static long j = 0L;
  private static long k = 0L;
  private static long l = 0L;
  private static long m = 0L;
  private static long n = 0L;
  private static long o = 0L;
  private static long p = 0L;
  private static long q = 0L;
  private static a r;
  public b c;
  
  public static a a()
  {
    if (f == null) {
      f = new a();
    }
    return f;
  }
  
  public static void a(a parama)
  {
    r = parama;
  }
  
  public static void a(NLPResponseData paramNLPResponseData)
  {
    f("---NLP访问URL---" + n.c());
    f("---CUID---" + c.n());
    StringBuilder localStringBuilder = new StringBuilder().append("---NLP兜底解析结果---");
    if (paramNLPResponseData != null) {}
    for (paramNLPResponseData = paramNLPResponseData.toString();; paramNLPResponseData = null)
    {
      f(paramNLPResponseData);
      return;
    }
  }
  
  public static void a(p paramp)
  {
    if ((paramp != null) && ("route".equals(paramp.c())))
    {
      f("---NLP解析结果---" + paramp.e() + "---domain:" + paramp.b() + "---intent:" + paramp.c());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder().append("---NLP解析结果---");
    if (paramp != null) {}
    for (paramp = paramp.toString();; paramp = null)
    {
      f(paramp);
      return;
    }
  }
  
  public static void a(String paramString)
  {
    if (!n.a()) {
      return;
    }
    h = SystemClock.elapsedRealtime();
    f("---语音识别返回时间---" + (h - j) + "ms");
    f("---语音识别返回结果---" + paramString);
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    if ((this.c != null) && (n.a())) {}
  }
  
  private void a(Throwable paramThrowable)
  {
    if ((this.c != null) && (n.a())) {}
  }
  
  public static void b()
  {
    if (!n.a()) {
      return;
    }
    g = SystemClock.elapsedRealtime();
    f("---语音引擎Ready---");
  }
  
  public static void b(String paramString)
  {
    if (!n.a()) {
      return;
    }
    i = SystemClock.elapsedRealtime();
    f("---NLP语义返回时间---" + (i - h) + "ms");
    f("---NLP语义返回结果---" + paramString);
    f("---NLP访问URL---" + n.c());
    f("---NLP访问CUID---" + c.n());
  }
  
  public static void c()
  {
    if (!n.a()) {
      return;
    }
    j = SystemClock.elapsedRealtime();
    p = j - k;
    f("---尾点检测时长---" + p + "ms");
  }
  
  public static void c(String paramString)
  {
    f("---RawText---" + paramString);
  }
  
  public static void d()
  {
    if (!n.a()) {
      return;
    }
    k = SystemClock.elapsedRealtime();
    f("---手动记录语音尾点时间---");
  }
  
  public static void d(String paramString)
  {
    if ((n.a()) && (!TextUtils.isEmpty(paramString))) {
      e.put(paramString, Long.valueOf(System.currentTimeMillis()));
    }
  }
  
  public static void e()
  {
    if (!n.a()) {
      return;
    }
    l = SystemClock.elapsedRealtime();
    f("---检测到语音起点---");
  }
  
  public static void e(String paramString)
  {
    if ((n.a()) && (!TextUtils.isEmpty(paramString)) && (e.containsKey(paramString)))
    {
      Log.d("CoDriverTestUtils", paramString + ":" + (System.currentTimeMillis() - ((Long)e.get(paramString)).longValue()) + "ms");
      e.remove(paramString);
    }
  }
  
  public static void f()
  {
    if (!n.a()) {
      return;
    }
    f("---识别成功---");
  }
  
  private static void f(String paramString)
  {
    if (r != null) {
      r.a(paramString);
    }
    h.b("CoDriverTestUtils", paramString);
  }
  
  public static void g()
  {
    if (!n.a()) {
      return;
    }
    f("---识别失败---");
  }
  
  public static void h()
  {
    if (!n.a()) {
      return;
    }
    n = SystemClock.elapsedRealtime();
    f("---唤醒语音结束---");
  }
  
  public static void i()
  {
    if (!n.a()) {
      return;
    }
    o = SystemClock.elapsedRealtime();
    f("---唤醒时间---" + (o - n) + "ms");
  }
  
  public static void j()
  {
    if (!n.a()) {
      return;
    }
    f("---唤醒界面展现时间---" + (SystemClock.elapsedRealtime() - o) + "ms");
  }
  
  public void k()
  {
    if (n.a()) {}
  }
  
  public void l()
  {
    if (this.c != null) {
      this.c.b();
    }
  }
  
  static abstract interface a
  {
    public abstract void a(String paramString);
  }
  
  private class b
    extends Thread
  {
    private final long b = 5242880L;
    private final long c = 86400000L;
    private final long d = 20L;
    private final String e = c.a().getExternalFilesDir("log") + File.separator;
    private final SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss");
    private final SimpleDateFormat g = new SimpleDateFormat("MM-dd_HH_mm_ss.SS");
    private Handler h;
    private Looper i;
    private File j;
    private File k;
    private FileWriter l;
    private Comparator<File> m = new Comparator()
    {
      public int a(File paramAnonymousFile1, File paramAnonymousFile2)
      {
        return (int)(paramAnonymousFile2.lastModified() - paramAnonymousFile1.lastModified());
      }
    };
    
    private b() {}
    
    public File a()
    {
      return this.k;
    }
    
    public void a(String paramString1, String paramString2, String paramString3)
    {
      if (this.h == null) {
        return;
      }
      paramString1 = this.g.format(new Date()) + " " + paramString1 + "/" + paramString2 + ":" + paramString3 + "\n";
      paramString2 = Message.obtain();
      paramString2.obj = paramString1;
      this.h.sendMessage(paramString2);
    }
    
    public void a(Throwable paramThrowable)
    {
      if (this.h == null) {
        return;
      }
      String str = this.g.format(new Date()) + "/CoDriver Crash!\n";
      Message localMessage = Message.obtain();
      localMessage.obj = (str + Log.getStackTraceString(paramThrowable));
      this.h.sendMessage(localMessage);
    }
    
    public void b()
    {
      if (this.l != null) {}
      try
      {
        this.l.close();
        if (this.i != null) {
          this.i.quit();
        }
        return;
      }
      catch (IOException localIOException)
      {
        for (;;) {}
      }
    }
    
    public void run()
    {
      this.j = new File(this.e);
      if (!this.j.exists()) {
        this.j.mkdirs();
      }
      String str = null;
      File[] arrayOfFile = this.j.listFiles();
      Arrays.sort(arrayOfFile, this.m);
      localObject = str;
      if (arrayOfFile != null)
      {
        localObject = str;
        if (arrayOfFile.length > 0) {
          localObject = arrayOfFile[0];
        }
      }
      long l1;
      if (localObject != null)
      {
        l1 = 0L;
        str = ((File)localObject).getName().substring(0, ((File)localObject).getName().length() - 4);
      }
      try
      {
        long l2 = this.f.parse(str).getTime();
        l1 = l2;
      }
      catch (ParseException localParseException)
      {
        try
        {
          this.l = new FileWriter(this.k, true);
          Looper.prepare();
          this.i = Looper.myLooper();
          this.h = new Handler(this.i)
          {
            /* Error */
            public void handleMessage(Message paramAnonymousMessage)
            {
              // Byte code:
              //   0: aload_1
              //   1: getfield 32	android/os/Message:obj	Ljava/lang/Object;
              //   4: instanceof 34
              //   7: ifeq +239 -> 246
              //   10: aload_0
              //   11: getfield 18	com/baidu/che/codriver/b/a$b$2:a	Lcom/baidu/che/codriver/b/a$b;
              //   14: invokestatic 37	com/baidu/che/codriver/b/a$b:a	(Lcom/baidu/che/codriver/b/a$b;)Ljava/io/File;
              //   17: ifnonnull +156 -> 173
              //   20: aload_0
              //   21: getfield 18	com/baidu/che/codriver/b/a$b$2:a	Lcom/baidu/che/codriver/b/a$b;
              //   24: invokestatic 39	com/baidu/che/codriver/b/a$b:b	(Lcom/baidu/che/codriver/b/a$b;)Ljava/io/File;
              //   27: invokevirtual 45	java/io/File:listFiles	()[Ljava/io/File;
              //   30: astore_3
              //   31: aload_3
              //   32: ifnull +47 -> 79
              //   35: aload_3
              //   36: arraylength
              //   37: i2l
              //   38: ldc2_w 46
              //   41: lcmp
              //   42: iflt +37 -> 79
              //   45: aload_3
              //   46: aload_0
              //   47: getfield 18	com/baidu/che/codriver/b/a$b$2:a	Lcom/baidu/che/codriver/b/a$b;
              //   50: invokestatic 51	com/baidu/che/codriver/b/a$b:c	(Lcom/baidu/che/codriver/b/a$b;)Ljava/util/Comparator;
              //   53: invokestatic 57	java/util/Arrays:sort	([Ljava/lang/Object;Ljava/util/Comparator;)V
              //   56: bipush 19
              //   58: istore_2
              //   59: iload_2
              //   60: aload_3
              //   61: arraylength
              //   62: if_icmpge +17 -> 79
              //   65: aload_3
              //   66: iload_2
              //   67: aaload
              //   68: invokevirtual 61	java/io/File:delete	()Z
              //   71: pop
              //   72: iload_2
              //   73: iconst_1
              //   74: iadd
              //   75: istore_2
              //   76: goto -17 -> 59
              //   79: aload_0
              //   80: getfield 18	com/baidu/che/codriver/b/a$b$2:a	Lcom/baidu/che/codriver/b/a$b;
              //   83: new 41	java/io/File
              //   86: dup
              //   87: new 63	java/lang/StringBuilder
              //   90: dup
              //   91: invokespecial 65	java/lang/StringBuilder:<init>	()V
              //   94: aload_0
              //   95: getfield 18	com/baidu/che/codriver/b/a$b$2:a	Lcom/baidu/che/codriver/b/a$b;
              //   98: invokestatic 69	com/baidu/che/codriver/b/a$b:d	(Lcom/baidu/che/codriver/b/a$b;)Ljava/lang/String;
              //   101: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
              //   104: aload_0
              //   105: getfield 18	com/baidu/che/codriver/b/a$b$2:a	Lcom/baidu/che/codriver/b/a$b;
              //   108: invokestatic 77	com/baidu/che/codriver/b/a$b:e	(Lcom/baidu/che/codriver/b/a$b;)Ljava/text/SimpleDateFormat;
              //   111: new 79	java/util/Date
              //   114: dup
              //   115: invokespecial 80	java/util/Date:<init>	()V
              //   118: invokevirtual 86	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
              //   121: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
              //   124: ldc 88
              //   126: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
              //   129: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
              //   132: invokespecial 95	java/io/File:<init>	(Ljava/lang/String;)V
              //   135: invokestatic 98	com/baidu/che/codriver/b/a$b:a	(Lcom/baidu/che/codriver/b/a$b;Ljava/io/File;)Ljava/io/File;
              //   138: pop
              //   139: aload_0
              //   140: getfield 18	com/baidu/che/codriver/b/a$b$2:a	Lcom/baidu/che/codriver/b/a$b;
              //   143: invokestatic 37	com/baidu/che/codriver/b/a$b:a	(Lcom/baidu/che/codriver/b/a$b;)Ljava/io/File;
              //   146: invokevirtual 101	java/io/File:createNewFile	()Z
              //   149: pop
              //   150: aload_0
              //   151: getfield 18	com/baidu/che/codriver/b/a$b$2:a	Lcom/baidu/che/codriver/b/a$b;
              //   154: new 103	java/io/FileWriter
              //   157: dup
              //   158: aload_0
              //   159: getfield 18	com/baidu/che/codriver/b/a$b$2:a	Lcom/baidu/che/codriver/b/a$b;
              //   162: invokestatic 37	com/baidu/che/codriver/b/a$b:a	(Lcom/baidu/che/codriver/b/a$b;)Ljava/io/File;
              //   165: iconst_1
              //   166: invokespecial 106	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
              //   169: invokestatic 109	com/baidu/che/codriver/b/a$b:a	(Lcom/baidu/che/codriver/b/a$b;Ljava/io/FileWriter;)Ljava/io/FileWriter;
              //   172: pop
              //   173: aload_0
              //   174: getfield 18	com/baidu/che/codriver/b/a$b$2:a	Lcom/baidu/che/codriver/b/a$b;
              //   177: invokestatic 113	com/baidu/che/codriver/b/a$b:f	(Lcom/baidu/che/codriver/b/a$b;)Ljava/io/FileWriter;
              //   180: ifnull +30 -> 210
              //   183: aload_0
              //   184: getfield 18	com/baidu/che/codriver/b/a$b$2:a	Lcom/baidu/che/codriver/b/a$b;
              //   187: invokestatic 113	com/baidu/che/codriver/b/a$b:f	(Lcom/baidu/che/codriver/b/a$b;)Ljava/io/FileWriter;
              //   190: aload_1
              //   191: getfield 32	android/os/Message:obj	Ljava/lang/Object;
              //   194: checkcast 34	java/lang/String
              //   197: invokevirtual 116	java/io/FileWriter:write	(Ljava/lang/String;)V
              //   200: aload_0
              //   201: getfield 18	com/baidu/che/codriver/b/a$b$2:a	Lcom/baidu/che/codriver/b/a$b;
              //   204: invokestatic 113	com/baidu/che/codriver/b/a$b:f	(Lcom/baidu/che/codriver/b/a$b;)Ljava/io/FileWriter;
              //   207: invokevirtual 119	java/io/FileWriter:flush	()V
              //   210: aload_0
              //   211: getfield 18	com/baidu/che/codriver/b/a$b$2:a	Lcom/baidu/che/codriver/b/a$b;
              //   214: invokestatic 37	com/baidu/che/codriver/b/a$b:a	(Lcom/baidu/che/codriver/b/a$b;)Ljava/io/File;
              //   217: ifnull +29 -> 246
              //   220: aload_0
              //   221: getfield 18	com/baidu/che/codriver/b/a$b$2:a	Lcom/baidu/che/codriver/b/a$b;
              //   224: invokestatic 37	com/baidu/che/codriver/b/a$b:a	(Lcom/baidu/che/codriver/b/a$b;)Ljava/io/File;
              //   227: invokevirtual 123	java/io/File:length	()J
              //   230: ldc2_w 124
              //   233: lcmp
              //   234: ifle +12 -> 246
              //   237: aload_0
              //   238: getfield 18	com/baidu/che/codriver/b/a$b$2:a	Lcom/baidu/che/codriver/b/a$b;
              //   241: aconst_null
              //   242: invokestatic 98	com/baidu/che/codriver/b/a$b:a	(Lcom/baidu/che/codriver/b/a$b;Ljava/io/File;)Ljava/io/File;
              //   245: pop
              //   246: return
              //   247: astore_3
              //   248: aload_3
              //   249: invokevirtual 128	java/io/IOException:printStackTrace	()V
              //   252: goto -79 -> 173
              //   255: astore_1
              //   256: aload_0
              //   257: getfield 18	com/baidu/che/codriver/b/a$b$2:a	Lcom/baidu/che/codriver/b/a$b;
              //   260: invokestatic 37	com/baidu/che/codriver/b/a$b:a	(Lcom/baidu/che/codriver/b/a$b;)Ljava/io/File;
              //   263: ifnull -17 -> 246
              //   266: aload_0
              //   267: getfield 18	com/baidu/che/codriver/b/a$b$2:a	Lcom/baidu/che/codriver/b/a$b;
              //   270: invokestatic 37	com/baidu/che/codriver/b/a$b:a	(Lcom/baidu/che/codriver/b/a$b;)Ljava/io/File;
              //   273: invokevirtual 123	java/io/File:length	()J
              //   276: ldc2_w 124
              //   279: lcmp
              //   280: ifle -34 -> 246
              //   283: aload_0
              //   284: getfield 18	com/baidu/che/codriver/b/a$b$2:a	Lcom/baidu/che/codriver/b/a$b;
              //   287: aconst_null
              //   288: invokestatic 98	com/baidu/che/codriver/b/a$b:a	(Lcom/baidu/che/codriver/b/a$b;Ljava/io/File;)Ljava/io/File;
              //   291: pop
              //   292: return
              //   293: astore_1
              //   294: aload_0
              //   295: getfield 18	com/baidu/che/codriver/b/a$b$2:a	Lcom/baidu/che/codriver/b/a$b;
              //   298: invokestatic 37	com/baidu/che/codriver/b/a$b:a	(Lcom/baidu/che/codriver/b/a$b;)Ljava/io/File;
              //   301: ifnull +29 -> 330
              //   304: aload_0
              //   305: getfield 18	com/baidu/che/codriver/b/a$b$2:a	Lcom/baidu/che/codriver/b/a$b;
              //   308: invokestatic 37	com/baidu/che/codriver/b/a$b:a	(Lcom/baidu/che/codriver/b/a$b;)Ljava/io/File;
              //   311: invokevirtual 123	java/io/File:length	()J
              //   314: ldc2_w 124
              //   317: lcmp
              //   318: ifle +12 -> 330
              //   321: aload_0
              //   322: getfield 18	com/baidu/che/codriver/b/a$b$2:a	Lcom/baidu/che/codriver/b/a$b;
              //   325: aconst_null
              //   326: invokestatic 98	com/baidu/che/codriver/b/a$b:a	(Lcom/baidu/che/codriver/b/a$b;Ljava/io/File;)Ljava/io/File;
              //   329: pop
              //   330: aload_1
              //   331: athrow
              // Local variable table:
              //   start	length	slot	name	signature
              //   0	332	0	this	2
              //   0	332	1	paramAnonymousMessage	Message
              //   58	18	2	i	int
              //   30	36	3	arrayOfFile	File[]
              //   247	2	3	localIOException	IOException
              // Exception table:
              //   from	to	target	type
              //   139	173	247	java/io/IOException
              //   173	210	255	java/io/IOException
              //   173	210	293	finally
            }
          };
          Looper.loop();
          return;
          localParseException = localParseException;
          ((File)localObject).delete();
        }
        catch (IOException localIOException)
        {
          for (;;) {}
        }
      }
      if ((l1 > 0L) && (new Date().getTime() - l1 < 86400000L)) {
        this.k = ((File)localObject);
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */