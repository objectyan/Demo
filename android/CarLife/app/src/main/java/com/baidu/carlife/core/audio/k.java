package com.baidu.carlife.core.audio;

public class k
{
  private static k a;
  private boolean b = false;
  
  public static k a()
  {
    if (a == null) {
      a = new k();
    }
    return a;
  }
  
  private void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  private boolean b()
  {
    return this.b;
  }
  
  /* Error */
  public int a(byte[] paramArrayOfByte, int paramInt, a.d paramd)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore 5
    //   3: aload_0
    //   4: monitorenter
    //   5: invokestatic 27	com/baidu/carlife/core/audio/a:a	()Lcom/baidu/carlife/core/audio/a;
    //   8: invokevirtual 30	com/baidu/carlife/core/audio/a:g	()Z
    //   11: istore 6
    //   13: iload 6
    //   15: ifeq +12 -> 27
    //   18: iload 5
    //   20: istore 4
    //   22: aload_0
    //   23: monitorexit
    //   24: iload 4
    //   26: ireturn
    //   27: aload_3
    //   28: getstatic 35	com/baidu/carlife/core/audio/a$d:a	Lcom/baidu/carlife/core/audio/a$d;
    //   31: if_acmpeq +10 -> 41
    //   34: aload_3
    //   35: getstatic 38	com/baidu/carlife/core/audio/a$d:d	Lcom/baidu/carlife/core/audio/a$d;
    //   38: if_acmpne +57 -> 95
    //   41: aload_0
    //   42: iconst_1
    //   43: invokespecial 40	com/baidu/carlife/core/audio/k:a	(Z)V
    //   46: aload_3
    //   47: getstatic 43	com/baidu/carlife/core/audio/a$d:f	Lcom/baidu/carlife/core/audio/a$d;
    //   50: if_acmpne +14 -> 64
    //   53: iload 5
    //   55: istore 4
    //   57: aload_0
    //   58: invokespecial 45	com/baidu/carlife/core/audio/k:b	()Z
    //   61: ifeq -39 -> 22
    //   64: iload 5
    //   66: istore 4
    //   68: invokestatic 48	com/baidu/carlife/core/audio/a:h	()Z
    //   71: ifeq -49 -> 22
    //   74: iload 5
    //   76: istore 4
    //   78: iload_2
    //   79: iflt -57 -> 22
    //   82: invokestatic 53	com/baidu/carlife/core/connect/e:a	()Lcom/baidu/carlife/core/connect/e;
    //   85: aload_1
    //   86: iload_2
    //   87: invokevirtual 57	com/baidu/carlife/core/connect/e:c	([BI)I
    //   90: istore 4
    //   92: goto -70 -> 22
    //   95: aload_3
    //   96: getstatic 59	com/baidu/carlife/core/audio/a$d:c	Lcom/baidu/carlife/core/audio/a$d;
    //   99: if_acmpeq +10 -> 109
    //   102: aload_3
    //   103: getstatic 61	com/baidu/carlife/core/audio/a$d:b	Lcom/baidu/carlife/core/audio/a$d;
    //   106: if_acmpne -60 -> 46
    //   109: aload_0
    //   110: iconst_0
    //   111: invokespecial 40	com/baidu/carlife/core/audio/k:a	(Z)V
    //   114: goto -68 -> 46
    //   117: astore_1
    //   118: aload_0
    //   119: monitorexit
    //   120: aload_1
    //   121: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	this	k
    //   0	122	1	paramArrayOfByte	byte[]
    //   0	122	2	paramInt	int
    //   0	122	3	paramd	a.d
    //   20	71	4	i	int
    //   1	74	5	j	int
    //   11	3	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   5	13	117	finally
    //   27	41	117	finally
    //   41	46	117	finally
    //   46	53	117	finally
    //   57	64	117	finally
    //   68	74	117	finally
    //   82	92	117	finally
    //   95	109	117	finally
    //   109	114	117	finally
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/core/audio/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */