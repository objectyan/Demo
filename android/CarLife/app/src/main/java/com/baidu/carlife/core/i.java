package com.baidu.carlife.core;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class i
  implements h
{
  public static final boolean a = false;
  public static final String b = "_Carlife.log";
  public static final SimpleDateFormat c = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.getDefault());
  private static final String e = "com.baidu.carlife#";
  private static Map<String, Long> f = new HashMap();
  private static i g;
  public a d;
  
  public static i a()
  {
    if (g == null) {
      g = new i();
    }
    return g;
  }
  
  private static void a(int paramInt, String paramString1, String paramString2, Object... paramVarArgs)
  {
    if ((f.jp <= paramInt) && (paramString1 != null) && (paramString2 != null)) {
      Log.println(paramInt, "com.baidu.carlife#" + paramString1, String.format(paramString2, paramVarArgs));
    }
  }
  
  public static void a(String paramString)
  {
    if ((e.t()) && (!TextUtils.isEmpty(paramString))) {
      f.put(paramString, Long.valueOf(System.currentTimeMillis()));
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (f.jp <= 2) {
      Log.v("com.baidu.carlife#" + paramString1, paramString2);
    }
    if (g != null) {
      g.b("V", paramString1, paramString2);
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    if (g != null) {
      g.b(paramString1, paramString2, paramString3);
    }
  }
  
  public static void a(String paramString1, String paramString2, Object... paramVarArgs)
  {
    a(2, paramString1, paramString2, paramVarArgs);
    if (g != null) {
      g.b("V", paramString1, paramString2);
    }
  }
  
  public static void a(String paramString, Throwable paramThrowable)
  {
    if (f.jp <= 6) {
      Log.w("com.baidu.carlife#" + paramString, "CarLife Exception!", paramThrowable);
    }
    if (g != null) {
      g.c(paramThrowable);
    }
  }
  
  public static void a(Throwable paramThrowable)
  {
    if (f.jp <= 5)
    {
      StringBuilder localStringBuilder = new StringBuilder(256);
      localStringBuilder.append("Got exception: ");
      localStringBuilder.append(paramThrowable.toString());
      localStringBuilder.append("\n");
      System.out.println(localStringBuilder.toString());
      paramThrowable.printStackTrace(System.out);
    }
  }
  
  public static void b(String paramString)
  {
    if ((e.t()) && (!TextUtils.isEmpty(paramString)) && (f.containsKey(paramString)))
    {
      Log.d("com.baidu.carlife#" + paramString, "QA time is:" + (System.currentTimeMillis() - ((Long)f.get(paramString)).longValue()) + "ms");
      f.remove(paramString);
    }
  }
  
  public static void b(String paramString1, String paramString2)
  {
    if (f.jp <= 3) {
      Log.d("com.baidu.carlife#" + paramString1, paramString2);
    }
    if (g != null) {
      g.b("D", paramString1, paramString2);
    }
  }
  
  private void b(String paramString1, String paramString2, String paramString3)
  {
    if ((this.d != null) && (e.t()) && (f.ju)) {
      this.d.a(paramString1, paramString2, paramString3);
    }
  }
  
  public static void b(String paramString1, String paramString2, Object... paramVarArgs)
  {
    a(3, paramString1, paramString2, paramVarArgs);
    if (g != null) {
      g.b("D", paramString1, paramString2);
    }
  }
  
  public static void b(String paramString, Throwable paramThrowable)
  {
    if (f.jp <= 6) {
      Log.e("com.baidu.carlife#" + paramString, "CarLife Exception!", paramThrowable);
    }
    if (g != null) {
      g.c(paramThrowable);
    }
  }
  
  public static void b(Throwable paramThrowable)
  {
    if (f.jp <= 6) {
      Log.e("com.baidu.carlife#", "CarLife Crash!", paramThrowable);
    }
    if (g != null) {
      g.c(paramThrowable);
    }
  }
  
  public static void c(String paramString1, String paramString2)
  {
    if (f.jp <= 4) {
      Log.i("com.baidu.carlife#" + paramString1, paramString2);
    }
    if (g != null) {
      g.b("I", paramString1, paramString2);
    }
  }
  
  public static void c(String paramString1, String paramString2, Object... paramVarArgs)
  {
    a(4, paramString1, paramString2, paramVarArgs);
    if (g != null) {
      g.b("I", paramString1, paramString2);
    }
  }
  
  private void c(Throwable paramThrowable)
  {
    if ((this.d != null) && (e.t()) && (f.ju)) {
      this.d.a(paramThrowable);
    }
  }
  
  public static void d(String paramString1, String paramString2)
  {
    if (f.jp <= 5) {
      Log.w("com.baidu.carlife#" + paramString1, paramString2);
    }
    if (g != null) {
      g.b("W", paramString1, paramString2);
    }
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    a(5, paramString1, paramString2, paramVarArgs);
    if (g != null) {
      g.b("W", paramString1, paramString2);
    }
  }
  
  public static void e(String paramString1, String paramString2)
  {
    if (f.jp <= 6) {
      Log.e("com.baidu.carlife#" + paramString1, paramString2);
    }
    if (g != null) {
      g.b("E", paramString1, paramString2);
    }
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    a(6, paramString1, paramString2, paramVarArgs);
    if (g != null) {
      g.b("E", paramString1, paramString2);
    }
  }
  
  public static void f(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return;
    }
    for (;;)
    {
      try
      {
        int i = paramString2.length();
        int j = 120;
        if (i > 120)
        {
          i = j;
          paramString2 = paramString2.substring(0, i);
          paramString1 = c.format(new Date());
          paramString2 = "[" + paramString1 + "]" + paramString2 + "\r\n";
          if ((paramString1 == null) || (paramString1.length() < 10)) {
            break;
          }
          paramString1 = new FileWriter(f.jm + "/" + paramString1.substring(0, 10) + "_Carlife.log", true);
          paramString1.write(paramString2);
          paramString1.flush();
          paramString1.close();
          return;
        }
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
    }
  }
  
  public void b()
  {
    if ((!e.t()) || (!f.ju)) {}
    while (this.d != null) {
      return;
    }
    this.d = new a(null);
    this.d.start();
  }
  
  public void c()
  {
    if (this.d != null) {
      this.d.b();
    }
  }
  
  public void d()
  {
    if ((this.d != null) && (this.d.a() != null)) {
      this.d.a(this.d.a());
    }
  }
  
  private class a
    extends Thread
  {
    private final long b = 5242880L;
    private final long c = 86400000L;
    private final long d = 20L;
    private final String e = f.jm + File.separator + "debugLog" + File.separator;
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
    
    private a() {}
    
    public File a()
    {
      return this.k;
    }
    
    public void a(File paramFile)
    {
      i.b("com.baidu.carlife#", "insertDivider not impl.");
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
      String str = this.g.format(new Date()) + "/CarLife Crash!\n";
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
        this.l = null;
        if (this.i != null)
        {
          this.i.quit();
          this.h = null;
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
          if (Looper.myLooper() != null) {
            break label178;
          }
          Looper.prepare();
          this.i = Looper.myLooper();
          this.h = new Handler(this.i)
          {
            /* Error */
            public void handleMessage(Message paramAnonymousMessage)
            {
              // Byte code:
              //   0: aload_1
              //   1: getfield 31	android/os/Message:obj	Ljava/lang/Object;
              //   4: instanceof 33
              //   7: ifeq +239 -> 246
              //   10: aload_0
              //   11: getfield 17	com/baidu/carlife/core/i$a$2:a	Lcom/baidu/carlife/core/i$a;
              //   14: invokestatic 36	com/baidu/carlife/core/i$a:a	(Lcom/baidu/carlife/core/i$a;)Ljava/io/File;
              //   17: ifnonnull +156 -> 173
              //   20: aload_0
              //   21: getfield 17	com/baidu/carlife/core/i$a$2:a	Lcom/baidu/carlife/core/i$a;
              //   24: invokestatic 39	com/baidu/carlife/core/i$a:b	(Lcom/baidu/carlife/core/i$a;)Ljava/io/File;
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
              //   47: getfield 17	com/baidu/carlife/core/i$a$2:a	Lcom/baidu/carlife/core/i$a;
              //   50: invokestatic 51	com/baidu/carlife/core/i$a:c	(Lcom/baidu/carlife/core/i$a;)Ljava/util/Comparator;
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
              //   80: getfield 17	com/baidu/carlife/core/i$a$2:a	Lcom/baidu/carlife/core/i$a;
              //   83: new 41	java/io/File
              //   86: dup
              //   87: new 63	java/lang/StringBuilder
              //   90: dup
              //   91: invokespecial 65	java/lang/StringBuilder:<init>	()V
              //   94: aload_0
              //   95: getfield 17	com/baidu/carlife/core/i$a$2:a	Lcom/baidu/carlife/core/i$a;
              //   98: invokestatic 69	com/baidu/carlife/core/i$a:d	(Lcom/baidu/carlife/core/i$a;)Ljava/lang/String;
              //   101: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
              //   104: aload_0
              //   105: getfield 17	com/baidu/carlife/core/i$a$2:a	Lcom/baidu/carlife/core/i$a;
              //   108: invokestatic 77	com/baidu/carlife/core/i$a:e	(Lcom/baidu/carlife/core/i$a;)Ljava/text/SimpleDateFormat;
              //   111: new 79	java/util/Date
              //   114: dup
              //   115: invokespecial 80	java/util/Date:<init>	()V
              //   118: invokevirtual 86	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
              //   121: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
              //   124: ldc 88
              //   126: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
              //   129: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
              //   132: invokespecial 95	java/io/File:<init>	(Ljava/lang/String;)V
              //   135: invokestatic 98	com/baidu/carlife/core/i$a:a	(Lcom/baidu/carlife/core/i$a;Ljava/io/File;)Ljava/io/File;
              //   138: pop
              //   139: aload_0
              //   140: getfield 17	com/baidu/carlife/core/i$a$2:a	Lcom/baidu/carlife/core/i$a;
              //   143: invokestatic 36	com/baidu/carlife/core/i$a:a	(Lcom/baidu/carlife/core/i$a;)Ljava/io/File;
              //   146: invokevirtual 101	java/io/File:createNewFile	()Z
              //   149: pop
              //   150: aload_0
              //   151: getfield 17	com/baidu/carlife/core/i$a$2:a	Lcom/baidu/carlife/core/i$a;
              //   154: new 103	java/io/FileWriter
              //   157: dup
              //   158: aload_0
              //   159: getfield 17	com/baidu/carlife/core/i$a$2:a	Lcom/baidu/carlife/core/i$a;
              //   162: invokestatic 36	com/baidu/carlife/core/i$a:a	(Lcom/baidu/carlife/core/i$a;)Ljava/io/File;
              //   165: iconst_1
              //   166: invokespecial 106	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
              //   169: invokestatic 109	com/baidu/carlife/core/i$a:a	(Lcom/baidu/carlife/core/i$a;Ljava/io/FileWriter;)Ljava/io/FileWriter;
              //   172: pop
              //   173: aload_0
              //   174: getfield 17	com/baidu/carlife/core/i$a$2:a	Lcom/baidu/carlife/core/i$a;
              //   177: invokestatic 113	com/baidu/carlife/core/i$a:f	(Lcom/baidu/carlife/core/i$a;)Ljava/io/FileWriter;
              //   180: ifnull +30 -> 210
              //   183: aload_0
              //   184: getfield 17	com/baidu/carlife/core/i$a$2:a	Lcom/baidu/carlife/core/i$a;
              //   187: invokestatic 113	com/baidu/carlife/core/i$a:f	(Lcom/baidu/carlife/core/i$a;)Ljava/io/FileWriter;
              //   190: aload_1
              //   191: getfield 31	android/os/Message:obj	Ljava/lang/Object;
              //   194: checkcast 33	java/lang/String
              //   197: invokevirtual 116	java/io/FileWriter:write	(Ljava/lang/String;)V
              //   200: aload_0
              //   201: getfield 17	com/baidu/carlife/core/i$a$2:a	Lcom/baidu/carlife/core/i$a;
              //   204: invokestatic 113	com/baidu/carlife/core/i$a:f	(Lcom/baidu/carlife/core/i$a;)Ljava/io/FileWriter;
              //   207: invokevirtual 119	java/io/FileWriter:flush	()V
              //   210: aload_0
              //   211: getfield 17	com/baidu/carlife/core/i$a$2:a	Lcom/baidu/carlife/core/i$a;
              //   214: invokestatic 36	com/baidu/carlife/core/i$a:a	(Lcom/baidu/carlife/core/i$a;)Ljava/io/File;
              //   217: ifnull +29 -> 246
              //   220: aload_0
              //   221: getfield 17	com/baidu/carlife/core/i$a$2:a	Lcom/baidu/carlife/core/i$a;
              //   224: invokestatic 36	com/baidu/carlife/core/i$a:a	(Lcom/baidu/carlife/core/i$a;)Ljava/io/File;
              //   227: invokevirtual 123	java/io/File:length	()J
              //   230: ldc2_w 124
              //   233: lcmp
              //   234: ifle +12 -> 246
              //   237: aload_0
              //   238: getfield 17	com/baidu/carlife/core/i$a$2:a	Lcom/baidu/carlife/core/i$a;
              //   241: aconst_null
              //   242: invokestatic 98	com/baidu/carlife/core/i$a:a	(Lcom/baidu/carlife/core/i$a;Ljava/io/File;)Ljava/io/File;
              //   245: pop
              //   246: return
              //   247: astore_3
              //   248: aload_3
              //   249: invokevirtual 128	java/io/IOException:printStackTrace	()V
              //   252: goto -79 -> 173
              //   255: astore_1
              //   256: aload_0
              //   257: getfield 17	com/baidu/carlife/core/i$a$2:a	Lcom/baidu/carlife/core/i$a;
              //   260: invokestatic 36	com/baidu/carlife/core/i$a:a	(Lcom/baidu/carlife/core/i$a;)Ljava/io/File;
              //   263: ifnull -17 -> 246
              //   266: aload_0
              //   267: getfield 17	com/baidu/carlife/core/i$a$2:a	Lcom/baidu/carlife/core/i$a;
              //   270: invokestatic 36	com/baidu/carlife/core/i$a:a	(Lcom/baidu/carlife/core/i$a;)Ljava/io/File;
              //   273: invokevirtual 123	java/io/File:length	()J
              //   276: ldc2_w 124
              //   279: lcmp
              //   280: ifle -34 -> 246
              //   283: aload_0
              //   284: getfield 17	com/baidu/carlife/core/i$a$2:a	Lcom/baidu/carlife/core/i$a;
              //   287: aconst_null
              //   288: invokestatic 98	com/baidu/carlife/core/i$a:a	(Lcom/baidu/carlife/core/i$a;Ljava/io/File;)Ljava/io/File;
              //   291: pop
              //   292: return
              //   293: astore_1
              //   294: aload_0
              //   295: getfield 17	com/baidu/carlife/core/i$a$2:a	Lcom/baidu/carlife/core/i$a;
              //   298: invokestatic 36	com/baidu/carlife/core/i$a:a	(Lcom/baidu/carlife/core/i$a;)Ljava/io/File;
              //   301: ifnull +29 -> 330
              //   304: aload_0
              //   305: getfield 17	com/baidu/carlife/core/i$a$2:a	Lcom/baidu/carlife/core/i$a;
              //   308: invokestatic 36	com/baidu/carlife/core/i$a:a	(Lcom/baidu/carlife/core/i$a;)Ljava/io/File;
              //   311: invokevirtual 123	java/io/File:length	()J
              //   314: ldc2_w 124
              //   317: lcmp
              //   318: ifle +12 -> 330
              //   321: aload_0
              //   322: getfield 17	com/baidu/carlife/core/i$a$2:a	Lcom/baidu/carlife/core/i$a;
              //   325: aconst_null
              //   326: invokestatic 98	com/baidu/carlife/core/i$a:a	(Lcom/baidu/carlife/core/i$a;Ljava/io/File;)Ljava/io/File;
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


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/core/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */