package com.baidu.location.h;

import java.io.File;
import java.io.RandomAccessFile;

public class c
{
  static c c;
  String a = "firll.dat";
  int b = 3164;
  int d = 0;
  int e = 20;
  int f = 40;
  int g = 60;
  int h = 80;
  int i = 100;
  
  /* Error */
  private long a(int paramInt)
  {
    // Byte code:
    //   0: invokestatic 50	com/baidu/location/h/g:l	()Ljava/lang/String;
    //   3: astore 5
    //   5: aload 5
    //   7: ifnonnull +7 -> 14
    //   10: ldc2_w 51
    //   13: lreturn
    //   14: new 54	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   21: aload 5
    //   23: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: getstatic 64	java/io/File:separator	Ljava/lang/String;
    //   29: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_0
    //   33: getfield 24	com/baidu/location/h/c:a	Ljava/lang/String;
    //   36: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: astore 5
    //   44: aconst_null
    //   45: astore 6
    //   47: new 69	java/io/RandomAccessFile
    //   50: dup
    //   51: aload 5
    //   53: ldc 71
    //   55: invokespecial 74	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   58: astore 5
    //   60: iload_1
    //   61: i2l
    //   62: lstore_3
    //   63: aload 5
    //   65: lload_3
    //   66: invokevirtual 78	java/io/RandomAccessFile:seek	(J)V
    //   69: aload 5
    //   71: invokevirtual 82	java/io/RandomAccessFile:readInt	()I
    //   74: istore_1
    //   75: aload 5
    //   77: invokevirtual 86	java/io/RandomAccessFile:readLong	()J
    //   80: lstore_3
    //   81: aload 5
    //   83: invokevirtual 82	java/io/RandomAccessFile:readInt	()I
    //   86: istore_2
    //   87: iload_1
    //   88: iload_2
    //   89: if_icmpne +15 -> 104
    //   92: aload 5
    //   94: ifnull +8 -> 102
    //   97: aload 5
    //   99: invokevirtual 89	java/io/RandomAccessFile:close	()V
    //   102: lload_3
    //   103: lreturn
    //   104: aload 5
    //   106: ifnull -96 -> 10
    //   109: aload 5
    //   111: invokevirtual 89	java/io/RandomAccessFile:close	()V
    //   114: ldc2_w 51
    //   117: lreturn
    //   118: astore 5
    //   120: ldc2_w 51
    //   123: lreturn
    //   124: astore 5
    //   126: aload 6
    //   128: astore 5
    //   130: aload 5
    //   132: ifnull -122 -> 10
    //   135: aload 5
    //   137: invokevirtual 89	java/io/RandomAccessFile:close	()V
    //   140: ldc2_w 51
    //   143: lreturn
    //   144: astore 5
    //   146: ldc2_w 51
    //   149: lreturn
    //   150: astore 6
    //   152: aconst_null
    //   153: astore 5
    //   155: aload 5
    //   157: ifnull +8 -> 165
    //   160: aload 5
    //   162: invokevirtual 89	java/io/RandomAccessFile:close	()V
    //   165: aload 6
    //   167: athrow
    //   168: astore 5
    //   170: goto -68 -> 102
    //   173: astore 5
    //   175: goto -10 -> 165
    //   178: astore 6
    //   180: goto -25 -> 155
    //   183: astore 6
    //   185: goto -55 -> 130
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	188	0	this	c
    //   0	188	1	paramInt	int
    //   86	4	2	j	int
    //   62	41	3	l	long
    //   3	107	5	localObject1	Object
    //   118	1	5	localIOException1	java.io.IOException
    //   124	1	5	localException1	Exception
    //   128	8	5	localObject2	Object
    //   144	1	5	localIOException2	java.io.IOException
    //   153	8	5	localObject3	Object
    //   168	1	5	localIOException3	java.io.IOException
    //   173	1	5	localIOException4	java.io.IOException
    //   45	82	6	localObject4	Object
    //   150	16	6	localObject5	Object
    //   178	1	6	localObject6	Object
    //   183	1	6	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   109	114	118	java/io/IOException
    //   47	60	124	java/lang/Exception
    //   135	140	144	java/io/IOException
    //   47	60	150	finally
    //   97	102	168	java/io/IOException
    //   160	165	173	java/io/IOException
    //   63	87	178	finally
    //   63	87	183	java/lang/Exception
  }
  
  public static c a()
  {
    if (c == null) {
      c = new c();
    }
    return c;
  }
  
  private void a(int paramInt, long paramLong)
  {
    Object localObject = g.l();
    if (localObject == null) {
      return;
    }
    localObject = (String)localObject + File.separator + this.a;
    try
    {
      localObject = new RandomAccessFile((String)localObject, "rw");
      ((RandomAccessFile)localObject).seek(paramInt);
      ((RandomAccessFile)localObject).writeInt(this.b);
      ((RandomAccessFile)localObject).writeLong(paramLong);
      ((RandomAccessFile)localObject).writeInt(this.b);
      ((RandomAccessFile)localObject).close();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void a(long paramLong)
  {
    a(this.d, paramLong);
  }
  
  public long b()
  {
    return a(this.d);
  }
  
  public void b(long paramLong)
  {
    a(this.e, paramLong);
  }
  
  public long c()
  {
    return a(this.e);
  }
  
  public void c(long paramLong)
  {
    a(this.f, paramLong);
  }
  
  public long d()
  {
    return a(this.g);
  }
  
  public void d(long paramLong)
  {
    a(this.g, paramLong);
  }
  
  public long e()
  {
    return a(this.h);
  }
  
  public void e(long paramLong)
  {
    a(this.h, paramLong);
  }
  
  public long f()
  {
    return a(this.i);
  }
  
  public void f(long paramLong)
  {
    a(this.i, paramLong);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/h/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */