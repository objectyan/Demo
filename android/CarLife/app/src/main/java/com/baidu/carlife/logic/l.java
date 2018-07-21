package com.baidu.carlife.logic;

import android.os.Handler;
import android.util.Log;
import java.util.Vector;

public class l
{
  public static final String a = "MonitorTcpPort";
  private static l b = null;
  private a c = null;
  private boolean d = false;
  private Vector<String> e = null;
  private Vector<String> f = null;
  private boolean g = false;
  private boolean h = false;
  private boolean i = false;
  private final String[] j = { "170C", "170D", "29D6", "29D7" };
  
  private boolean a(String paramString)
  {
    boolean bool2 = false;
    int k = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (k < this.j.length)
      {
        int m = paramString.indexOf(this.j[k]);
        if ((m > 0) && (':' == paramString.charAt(m - 1))) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      k += 1;
    }
  }
  
  private boolean a(Vector<String> paramVector)
  {
    int k = 0;
    if (k < paramVector.size())
    {
      Object localObject = ((String)paramVector.get(k)).trim().split("\\s+");
      if (localObject.length < 4) {}
      do
      {
        String str;
        do
        {
          k += 1;
          break;
          str = localObject[1];
          localObject = localObject[3];
        } while (!a(str));
        this.g = true;
      } while (!((String)localObject).equals("01"));
      this.h = true;
    }
    return this.h;
  }
  
  public static l c()
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new l();
      }
      return b;
    }
    finally {}
  }
  
  private boolean e()
  {
    try
    {
      boolean bool = this.d;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  private void f()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 39	com/baidu/carlife/logic/l:e	Ljava/util/Vector;
    //   4: invokevirtual 117	java/util/Vector:clear	()V
    //   7: iconst_0
    //   8: istore_1
    //   9: new 119	java/io/FileReader
    //   12: dup
    //   13: ldc 121
    //   15: invokespecial 124	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   18: astore_3
    //   19: new 126	java/io/LineNumberReader
    //   22: dup
    //   23: aload_3
    //   24: invokespecial 129	java/io/LineNumberReader:<init>	(Ljava/io/Reader;)V
    //   27: astore 4
    //   29: aload_3
    //   30: ifnull +33 -> 63
    //   33: aload 4
    //   35: invokevirtual 132	java/io/LineNumberReader:readLine	()Ljava/lang/String;
    //   38: astore 5
    //   40: aload 5
    //   42: ifnonnull +24 -> 66
    //   45: aload_3
    //   46: ifnull +7 -> 53
    //   49: aload_3
    //   50: invokevirtual 135	java/io/FileReader:close	()V
    //   53: aload_0
    //   54: getfield 39	com/baidu/carlife/logic/l:e	Ljava/util/Vector;
    //   57: ldc -119
    //   59: invokevirtual 141	java/util/Vector:addElement	(Ljava/lang/Object;)V
    //   62: return
    //   63: goto -30 -> 33
    //   66: iload_1
    //   67: iconst_1
    //   68: iadd
    //   69: istore_2
    //   70: aload 5
    //   72: invokevirtual 88	java/lang/String:trim	()Ljava/lang/String;
    //   75: ldc 90
    //   77: invokevirtual 94	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   80: astore 6
    //   82: iload_2
    //   83: istore_1
    //   84: aload 6
    //   86: arraylength
    //   87: iconst_4
    //   88: if_icmplt -55 -> 33
    //   91: iload_2
    //   92: istore_1
    //   93: aload 6
    //   95: iconst_3
    //   96: aaload
    //   97: ldc 98
    //   99: invokevirtual 102	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   102: ifeq -69 -> 33
    //   105: aload_0
    //   106: getfield 39	com/baidu/carlife/logic/l:e	Ljava/util/Vector;
    //   109: aload 5
    //   111: invokevirtual 141	java/util/Vector:addElement	(Ljava/lang/Object;)V
    //   114: iload_2
    //   115: istore_1
    //   116: goto -83 -> 33
    //   119: astore_3
    //   120: goto -67 -> 53
    //   123: astore_3
    //   124: goto -71 -> 53
    //   127: astore_3
    //   128: goto -75 -> 53
    //   131: astore_3
    //   132: goto -79 -> 53
    //   135: astore_3
    //   136: goto -83 -> 53
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	this	l
    //   8	108	1	k	int
    //   69	46	2	m	int
    //   18	32	3	localFileReader	java.io.FileReader
    //   119	1	3	localIOException	java.io.IOException
    //   123	1	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   127	1	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   131	1	3	localFileNotFoundException3	java.io.FileNotFoundException
    //   135	1	3	localNullPointerException	NullPointerException
    //   27	7	4	localLineNumberReader	java.io.LineNumberReader
    //   38	72	5	str	String
    //   80	14	6	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   33	40	119	java/io/IOException
    //   49	53	119	java/io/IOException
    //   70	82	119	java/io/IOException
    //   84	91	119	java/io/IOException
    //   93	114	119	java/io/IOException
    //   9	19	123	java/io/FileNotFoundException
    //   19	29	127	java/io/FileNotFoundException
    //   33	40	131	java/io/FileNotFoundException
    //   49	53	131	java/io/FileNotFoundException
    //   70	82	131	java/io/FileNotFoundException
    //   84	91	131	java/io/FileNotFoundException
    //   93	114	131	java/io/FileNotFoundException
    //   33	40	135	java/lang/NullPointerException
    //   49	53	135	java/lang/NullPointerException
    //   70	82	135	java/lang/NullPointerException
    //   84	91	135	java/lang/NullPointerException
    //   93	114	135	java/lang/NullPointerException
  }
  
  /* Error */
  private void g()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 41	com/baidu/carlife/logic/l:f	Ljava/util/Vector;
    //   4: invokevirtual 117	java/util/Vector:clear	()V
    //   7: iconst_0
    //   8: istore_1
    //   9: new 119	java/io/FileReader
    //   12: dup
    //   13: ldc -113
    //   15: invokespecial 124	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   18: astore_3
    //   19: new 126	java/io/LineNumberReader
    //   22: dup
    //   23: aload_3
    //   24: invokespecial 129	java/io/LineNumberReader:<init>	(Ljava/io/Reader;)V
    //   27: astore 4
    //   29: aload_3
    //   30: ifnull +87 -> 117
    //   33: aload 4
    //   35: invokevirtual 132	java/io/LineNumberReader:readLine	()Ljava/lang/String;
    //   38: astore 5
    //   40: aload 5
    //   42: ifnonnull +10 -> 52
    //   45: aload_3
    //   46: invokevirtual 135	java/io/FileReader:close	()V
    //   49: goto +67 -> 116
    //   52: iload_1
    //   53: iconst_1
    //   54: iadd
    //   55: istore_2
    //   56: aload 5
    //   58: invokevirtual 88	java/lang/String:trim	()Ljava/lang/String;
    //   61: ldc 90
    //   63: invokevirtual 94	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   66: astore 6
    //   68: iload_2
    //   69: istore_1
    //   70: aload 6
    //   72: arraylength
    //   73: iconst_4
    //   74: if_icmplt -41 -> 33
    //   77: iload_2
    //   78: istore_1
    //   79: aload 6
    //   81: iconst_3
    //   82: aaload
    //   83: ldc 98
    //   85: invokevirtual 102	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   88: ifeq -55 -> 33
    //   91: aload_0
    //   92: getfield 41	com/baidu/carlife/logic/l:f	Ljava/util/Vector;
    //   95: aload 5
    //   97: invokevirtual 141	java/util/Vector:addElement	(Ljava/lang/Object;)V
    //   100: iload_2
    //   101: istore_1
    //   102: goto -69 -> 33
    //   105: astore_3
    //   106: goto +10 -> 116
    //   109: astore_3
    //   110: return
    //   111: astore_3
    //   112: return
    //   113: astore_3
    //   114: return
    //   115: astore_3
    //   116: return
    //   117: goto -84 -> 33
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	this	l
    //   8	94	1	k	int
    //   55	46	2	m	int
    //   18	28	3	localFileReader	java.io.FileReader
    //   105	1	3	localIOException	java.io.IOException
    //   109	1	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   111	1	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   113	1	3	localFileNotFoundException3	java.io.FileNotFoundException
    //   115	1	3	localNullPointerException	NullPointerException
    //   27	7	4	localLineNumberReader	java.io.LineNumberReader
    //   38	58	5	str	String
    //   66	14	6	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   33	40	105	java/io/IOException
    //   45	49	105	java/io/IOException
    //   56	68	105	java/io/IOException
    //   70	77	105	java/io/IOException
    //   79	100	105	java/io/IOException
    //   9	19	109	java/io/FileNotFoundException
    //   19	29	111	java/io/FileNotFoundException
    //   33	40	113	java/io/FileNotFoundException
    //   45	49	113	java/io/FileNotFoundException
    //   56	68	113	java/io/FileNotFoundException
    //   70	77	113	java/io/FileNotFoundException
    //   79	100	113	java/io/FileNotFoundException
    //   33	40	115	java/lang/NullPointerException
    //   45	49	115	java/lang/NullPointerException
    //   56	68	115	java/lang/NullPointerException
    //   70	77	115	java/lang/NullPointerException
    //   79	100	115	java/lang/NullPointerException
  }
  
  private boolean h()
  {
    this.g = false;
    this.h = false;
    if (this.e == null) {
      this.e = new Vector();
    }
    if (this.f == null) {
      this.f = new Vector();
    }
    f();
    g();
    a(this.e);
    if (!this.h) {
      a(this.f);
    }
    return this.h;
  }
  
  public void a()
  {
    this.e = new Vector();
    this.f = new Vector();
  }
  
  public void a(Handler paramHandler)
  {
    try
    {
      if (this.c == null)
      {
        this.c = new a(paramHandler);
        this.c.start();
      }
      return;
    }
    finally {}
  }
  
  public void a(boolean paramBoolean)
  {
    try
    {
      this.d = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void b()
  {
    this.h = false;
    this.i = false;
    this.g = false;
  }
  
  public void d()
  {
    if (this.c != null)
    {
      this.c.a();
      this.c = null;
    }
  }
  
  private class a
    extends Thread
  {
    public static final String a = "MonitorThread";
    private boolean c = false;
    private Handler d = null;
    
    public a(Handler paramHandler)
    {
      this.d = paramHandler;
    }
    
    public void a()
    {
      try
      {
        this.c = true;
        Log.d("MonitorThread", "MonitorThread  Exit" + this.c);
        return;
      }
      catch (Exception localException)
      {
        Log.e("MonitorThread", "Close  fail");
        localException.printStackTrace();
      }
    }
    
    public void run()
    {
      Log.d("MonitorThread", "MonitorThread Running!!!");
      for (;;)
      {
        if (!this.c)
        {
          l.a(l.this, false);
          l.b(l.this, false);
          l.a(l.this);
          if (l.b(l.this)) {
            if ((!l.c(l.this)) && (l.d(l.this)) && (this.d != null))
            {
              this.d.sendEmptyMessage(52480);
              l.c(l.this, true);
            }
          }
          try
          {
            for (;;)
            {
              sleep(2000L);
              l.a(l.this, false);
              l.b(l.this, false);
              break;
              l.c(l.this, false);
            }
          }
          catch (InterruptedException localInterruptedException)
          {
            for (;;)
            {
              localInterruptedException.printStackTrace();
            }
          }
        }
      }
      Log.d("MonitorThread", "MonitorThread End!!!");
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/logic/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */