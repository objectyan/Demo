package com.baidu.platform.basic;

import java.util.concurrent.atomic.AtomicInteger;

public class b
  extends Thread
{
  public static final String a = "BMThread";
  private static final AtomicInteger b = new AtomicInteger();
  private static final AtomicInteger c = new AtomicInteger();
  private static volatile boolean d = false;
  
  public b(Runnable paramRunnable)
  {
    super(paramRunnable, "BMThread");
  }
  
  public b(Runnable paramRunnable, String paramString)
  {
    super(paramRunnable, paramString + "-" + b.incrementAndGet());
  }
  
  public b(String paramString)
  {
    super(paramString);
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
    //   0: getstatic 26	com/baidu/platform/basic/b:d	Z
    //   3: istore_1
    //   4: invokestatic 66	java/lang/System:nanoTime	()J
    //   7: lstore_2
    //   8: iload_1
    //   9: ifeq +30 -> 39
    //   12: ldc 8
    //   14: new 33	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   21: ldc 68
    //   23: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_0
    //   27: invokevirtual 71	com/baidu/platform/basic/b:getName	()Ljava/lang/String;
    //   30: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokestatic 76	com/baidu/platform/comapi/util/f:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: getstatic 24	com/baidu/platform/basic/b:c	Ljava/util/concurrent/atomic/AtomicInteger;
    //   42: invokevirtual 44	java/util/concurrent/atomic/AtomicInteger:incrementAndGet	()I
    //   45: pop
    //   46: aload_0
    //   47: invokespecial 78	java/lang/Thread:run	()V
    //   50: getstatic 24	com/baidu/platform/basic/b:c	Ljava/util/concurrent/atomic/AtomicInteger;
    //   53: invokevirtual 81	java/util/concurrent/atomic/AtomicInteger:decrementAndGet	()I
    //   56: pop
    //   57: iload_1
    //   58: ifeq +47 -> 105
    //   61: ldc 8
    //   63: invokestatic 87	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   66: ldc 89
    //   68: iconst_3
    //   69: anewarray 91	java/lang/Object
    //   72: dup
    //   73: iconst_0
    //   74: aload_0
    //   75: invokevirtual 71	com/baidu/platform/basic/b:getName	()Ljava/lang/String;
    //   78: aastore
    //   79: dup
    //   80: iconst_1
    //   81: invokestatic 66	java/lang/System:nanoTime	()J
    //   84: lload_2
    //   85: lsub
    //   86: invokestatic 97	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   89: aastore
    //   90: dup
    //   91: iconst_2
    //   92: invokestatic 99	com/baidu/platform/basic/b:b	()I
    //   95: invokestatic 104	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   98: aastore
    //   99: invokestatic 110	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   102: invokestatic 76	com/baidu/platform/comapi/util/f:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   105: return
    //   106: astore 4
    //   108: getstatic 24	com/baidu/platform/basic/b:c	Ljava/util/concurrent/atomic/AtomicInteger;
    //   111: invokevirtual 81	java/util/concurrent/atomic/AtomicInteger:decrementAndGet	()I
    //   114: pop
    //   115: iload_1
    //   116: ifeq +47 -> 163
    //   119: ldc 8
    //   121: invokestatic 87	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   124: ldc 89
    //   126: iconst_3
    //   127: anewarray 91	java/lang/Object
    //   130: dup
    //   131: iconst_0
    //   132: aload_0
    //   133: invokevirtual 71	com/baidu/platform/basic/b:getName	()Ljava/lang/String;
    //   136: aastore
    //   137: dup
    //   138: iconst_1
    //   139: invokestatic 66	java/lang/System:nanoTime	()J
    //   142: lload_2
    //   143: lsub
    //   144: invokestatic 97	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   147: aastore
    //   148: dup
    //   149: iconst_2
    //   150: invokestatic 99	com/baidu/platform/basic/b:b	()I
    //   153: invokestatic 104	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   156: aastore
    //   157: invokestatic 110	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   160: invokestatic 76	com/baidu/platform/comapi/util/f:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   163: aload 4
    //   165: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	this	b
    //   3	113	1	bool	boolean
    //   7	136	2	l	long
    //   106	58	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   39	50	106	finally
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/basic/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */