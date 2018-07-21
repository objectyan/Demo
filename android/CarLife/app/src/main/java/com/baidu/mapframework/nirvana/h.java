package com.baidu.mapframework.nirvana;

import java.util.concurrent.atomic.AtomicInteger;

public class h
  extends Thread
{
  static final String a = "NirvanaThread";
  static final AtomicInteger b = new AtomicInteger();
  static final AtomicInteger c = new AtomicInteger();
  private static volatile boolean d = false;
  
  public h(Runnable paramRunnable)
  {
    this(paramRunnable, "NirvanaThread");
  }
  
  public h(Runnable paramRunnable, String paramString)
  {
    super(paramRunnable, paramString + "-" + b.incrementAndGet());
  }
  
  public h(String paramString)
  {
    this(null, paramString);
  }
  
  public static int a()
  {
    return b.get();
  }
  
  public static void a(boolean paramBoolean)
  {
    d = paramBoolean;
  }
  
  public static int b()
  {
    return c.get();
  }
  
  public static boolean c()
  {
    return d;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: getstatic 26	com/baidu/mapframework/nirvana/h:d	Z
    //   3: istore_1
    //   4: invokestatic 65	java/lang/System:nanoTime	()J
    //   7: lstore_2
    //   8: iload_1
    //   9: ifeq +42 -> 51
    //   12: ldc 8
    //   14: new 33	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   21: ldc 67
    //   23: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_0
    //   27: invokevirtual 70	com/baidu/mapframework/nirvana/h:getName	()Ljava/lang/String;
    //   30: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: ldc 72
    //   35: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_0
    //   39: invokevirtual 75	com/baidu/mapframework/nirvana/h:isDaemon	()Z
    //   42: invokevirtual 78	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   45: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokestatic 83	com/baidu/mapframework/nirvana/n:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   51: getstatic 24	com/baidu/mapframework/nirvana/h:c	Ljava/util/concurrent/atomic/AtomicInteger;
    //   54: invokevirtual 44	java/util/concurrent/atomic/AtomicInteger:incrementAndGet	()I
    //   57: pop
    //   58: aload_0
    //   59: invokespecial 85	java/lang/Thread:run	()V
    //   62: getstatic 24	com/baidu/mapframework/nirvana/h:c	Ljava/util/concurrent/atomic/AtomicInteger;
    //   65: invokevirtual 88	java/util/concurrent/atomic/AtomicInteger:decrementAndGet	()I
    //   68: pop
    //   69: iload_1
    //   70: ifeq +62 -> 132
    //   73: ldc 8
    //   75: invokestatic 94	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   78: ldc 96
    //   80: iconst_4
    //   81: anewarray 98	java/lang/Object
    //   84: dup
    //   85: iconst_0
    //   86: aload_0
    //   87: invokevirtual 70	com/baidu/mapframework/nirvana/h:getName	()Ljava/lang/String;
    //   90: aastore
    //   91: dup
    //   92: iconst_1
    //   93: getstatic 104	java/util/concurrent/TimeUnit:NANOSECONDS	Ljava/util/concurrent/TimeUnit;
    //   96: invokestatic 65	java/lang/System:nanoTime	()J
    //   99: lload_2
    //   100: lsub
    //   101: invokevirtual 108	java/util/concurrent/TimeUnit:toMillis	(J)J
    //   104: invokestatic 114	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   107: aastore
    //   108: dup
    //   109: iconst_2
    //   110: invokestatic 116	com/baidu/mapframework/nirvana/h:a	()I
    //   113: invokestatic 121	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   116: aastore
    //   117: dup
    //   118: iconst_3
    //   119: invokestatic 123	com/baidu/mapframework/nirvana/h:b	()I
    //   122: invokestatic 121	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   125: aastore
    //   126: invokestatic 129	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   129: invokestatic 83	com/baidu/mapframework/nirvana/n:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   132: return
    //   133: astore 4
    //   135: getstatic 24	com/baidu/mapframework/nirvana/h:c	Ljava/util/concurrent/atomic/AtomicInteger;
    //   138: invokevirtual 88	java/util/concurrent/atomic/AtomicInteger:decrementAndGet	()I
    //   141: pop
    //   142: iload_1
    //   143: ifeq +62 -> 205
    //   146: ldc 8
    //   148: invokestatic 94	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   151: ldc 96
    //   153: iconst_4
    //   154: anewarray 98	java/lang/Object
    //   157: dup
    //   158: iconst_0
    //   159: aload_0
    //   160: invokevirtual 70	com/baidu/mapframework/nirvana/h:getName	()Ljava/lang/String;
    //   163: aastore
    //   164: dup
    //   165: iconst_1
    //   166: getstatic 104	java/util/concurrent/TimeUnit:NANOSECONDS	Ljava/util/concurrent/TimeUnit;
    //   169: invokestatic 65	java/lang/System:nanoTime	()J
    //   172: lload_2
    //   173: lsub
    //   174: invokevirtual 108	java/util/concurrent/TimeUnit:toMillis	(J)J
    //   177: invokestatic 114	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   180: aastore
    //   181: dup
    //   182: iconst_2
    //   183: invokestatic 116	com/baidu/mapframework/nirvana/h:a	()I
    //   186: invokestatic 121	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   189: aastore
    //   190: dup
    //   191: iconst_3
    //   192: invokestatic 123	com/baidu/mapframework/nirvana/h:b	()I
    //   195: invokestatic 121	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   198: aastore
    //   199: invokestatic 129	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   202: invokestatic 83	com/baidu/mapframework/nirvana/n:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   205: aload 4
    //   207: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	208	0	this	h
    //   3	140	1	bool	boolean
    //   7	166	2	l	long
    //   133	73	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   51	62	133	finally
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/nirvana/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */