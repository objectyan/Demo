package com.baidu.carlife.util;

import com.baidu.carlife.core.i;
import java.io.IOException;

public class e
{
  public static final String a = "CarlifeShell";
  private static e b = null;
  private Runtime c = null;
  
  public static e a()
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new e();
      }
      return b;
    }
    finally {}
  }
  
  public boolean a(String paramString)
  {
    int i = 1;
    i.b("CarlifeShell", "exec: " + paramString);
    try
    {
      int j = this.c.exec(paramString).waitFor();
      i = j;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        i.e("CarlifeShell", "exec: " + paramString + " get InterruptedException");
        localInterruptedException.printStackTrace();
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        i.e("CarlifeShell", "exec: " + paramString + " get IOException");
        localIOException.printStackTrace();
      }
    }
    i.b("CarlifeShell", "exit value: " + i);
    return i == 0;
  }
  
  public boolean b(String paramString)
  {
    i.b("CarlifeShell", "exec: " + paramString);
    try
    {
      this.c.exec(paramString);
      i.b("CarlifeShell", "exit value: " + 0);
      if (0 != 0) {
        return false;
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        i.e("CarlifeShell", "exec: " + paramString + " get IOException");
        localIOException.printStackTrace();
      }
    }
    return true;
  }
  
  /* Error */
  public java.io.BufferedReader c(String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: iconst_1
    //   4: istore_2
    //   5: aconst_null
    //   6: astore 7
    //   8: ldc 8
    //   10: new 37	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   17: ldc 40
    //   19: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_1
    //   23: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokestatic 53	com/baidu/carlife/core/i:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: iload_2
    //   33: istore_3
    //   34: iload 5
    //   36: istore 4
    //   38: aload_0
    //   39: getfield 22	com/baidu/carlife/util/e:c	Ljava/lang/Runtime;
    //   42: aload_1
    //   43: invokevirtual 57	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   46: astore 6
    //   48: iload_2
    //   49: istore_3
    //   50: iload 5
    //   52: istore 4
    //   54: aload 6
    //   56: invokevirtual 63	java/lang/Process:waitFor	()I
    //   59: istore_2
    //   60: iload_2
    //   61: istore_3
    //   62: iload_2
    //   63: istore 4
    //   65: new 82	java/io/BufferedInputStream
    //   68: dup
    //   69: aload 6
    //   71: invokevirtual 86	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   74: invokespecial 89	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   77: astore 6
    //   79: new 91	java/io/BufferedReader
    //   82: dup
    //   83: new 93	java/io/InputStreamReader
    //   86: dup
    //   87: aload 6
    //   89: invokespecial 94	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   92: invokespecial 97	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   95: astore 6
    //   97: aload 6
    //   99: astore_1
    //   100: ldc 8
    //   102: new 37	java/lang/StringBuilder
    //   105: dup
    //   106: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   109: ldc 65
    //   111: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: iload_2
    //   115: invokevirtual 68	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   118: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: invokestatic 53	com/baidu/carlife/core/i:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   124: iload_2
    //   125: ifeq +5 -> 130
    //   128: aconst_null
    //   129: astore_1
    //   130: aload_1
    //   131: areturn
    //   132: astore 6
    //   134: iload_3
    //   135: istore_2
    //   136: ldc 8
    //   138: new 37	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   145: ldc 40
    //   147: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: aload_1
    //   151: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: ldc 70
    //   156: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokestatic 73	com/baidu/carlife/core/i:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   165: aload 6
    //   167: invokevirtual 76	java/lang/InterruptedException:printStackTrace	()V
    //   170: aload 7
    //   172: astore_1
    //   173: goto -73 -> 100
    //   176: astore 6
    //   178: iload 4
    //   180: istore_2
    //   181: ldc 8
    //   183: new 37	java/lang/StringBuilder
    //   186: dup
    //   187: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   190: ldc 40
    //   192: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: aload_1
    //   196: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: ldc 78
    //   201: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: invokestatic 73	com/baidu/carlife/core/i:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   210: aload 6
    //   212: invokevirtual 79	java/io/IOException:printStackTrace	()V
    //   215: aload 7
    //   217: astore_1
    //   218: goto -118 -> 100
    //   221: astore 6
    //   223: goto -42 -> 181
    //   226: astore 6
    //   228: goto -92 -> 136
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	231	0	this	e
    //   0	231	1	paramString	String
    //   4	177	2	i	int
    //   33	102	3	j	int
    //   36	143	4	k	int
    //   1	50	5	m	int
    //   46	52	6	localObject1	Object
    //   132	34	6	localInterruptedException1	InterruptedException
    //   176	35	6	localIOException1	IOException
    //   221	1	6	localIOException2	IOException
    //   226	1	6	localInterruptedException2	InterruptedException
    //   6	210	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   38	48	132	java/lang/InterruptedException
    //   54	60	132	java/lang/InterruptedException
    //   65	79	132	java/lang/InterruptedException
    //   38	48	176	java/io/IOException
    //   54	60	176	java/io/IOException
    //   65	79	176	java/io/IOException
    //   79	97	221	java/io/IOException
    //   79	97	226	java/lang/InterruptedException
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/util/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */