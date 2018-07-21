package com.baidu.carlife.core.audio;

import com.baidu.carlife.core.connect.a.b;
import com.baidu.carlife.core.connect.e;
import com.baidu.carlife.core.i;

public class m
  extends f
{
  private static final String a = "Audio-" + m.class.getSimpleName();
  private o b = new o();
  private byte[] c = new byte[120];
  private int d;
  private int e;
  private p f = new p();
  private c g = new c();
  private b h = new b();
  
  public m()
  {
    a.a();
    this.e = 12;
  }
  
  private int b(byte[] paramArrayOfByte, int paramInt)
  {
    if (a.a().g()) {
      return -1;
    }
    return e.a().e(paramArrayOfByte, paramInt);
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 87	com/baidu/carlife/core/audio/a:h	()Z
    //   5: istore_1
    //   6: iload_1
    //   7: ifne +6 -> 13
    //   10: aload_0
    //   11: monitorexit
    //   12: return
    //   13: aload_0
    //   14: getfield 65	com/baidu/carlife/core/audio/m:b	Lcom/baidu/carlife/core/audio/o;
    //   17: ldc 88
    //   19: invokevirtual 91	com/baidu/carlife/core/audio/o:c	(I)V
    //   22: aload_0
    //   23: getfield 65	com/baidu/carlife/core/audio/m:b	Lcom/baidu/carlife/core/audio/o;
    //   26: iconst_0
    //   27: invokevirtual 93	com/baidu/carlife/core/audio/o:a	(I)V
    //   30: aload_0
    //   31: aload_0
    //   32: getfield 65	com/baidu/carlife/core/audio/m:b	Lcom/baidu/carlife/core/audio/o;
    //   35: invokevirtual 96	com/baidu/carlife/core/audio/o:a	()[B
    //   38: aload_0
    //   39: getfield 65	com/baidu/carlife/core/audio/m:b	Lcom/baidu/carlife/core/audio/o;
    //   42: invokevirtual 99	com/baidu/carlife/core/audio/o:b	()I
    //   45: invokespecial 101	com/baidu/carlife/core/audio/m:b	([BI)I
    //   48: pop
    //   49: goto -39 -> 10
    //   52: astore_2
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_2
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	m
    //   5	2	1	bool	boolean
    //   52	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	6	52	finally
    //   13	49	52	finally
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    for (;;)
    {
      try
      {
        boolean bool = a.h();
        if (!bool) {
          return;
        }
        i.b(a, "sampleRate: " + paramInt1 + " channelConfig: " + paramInt2 + " sampleFormat: " + paramInt3);
        if (paramInt1 < 4000) {
          break label169;
        }
        if (paramInt1 <= 48000) {
          break label160;
        }
      }
      finally {}
      this.b.c(262145);
      this.d = this.b.b(paramInt1, paramInt2, paramInt3, this.c);
      this.b.a(this.d);
      System.arraycopy(this.b.a(), 0, this.c, 0, this.e);
      b(this.c, this.e + this.d);
      continue;
      label160:
      label163:
      label169:
      while ((paramInt3 == 8) && (paramInt3 == 16))
      {
        break;
        paramInt1 = 16000;
        if ((paramInt2 == 1) && (paramInt2 == 2)) {
          break label163;
        }
        paramInt2 = 1;
      }
      paramInt3 = 16;
    }
  }
  
  /* Error */
  public void a(byte[] paramArrayOfByte, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: astore 5
    //   5: iload_2
    //   6: istore_3
    //   7: aload 5
    //   9: astore 6
    //   11: iload_3
    //   12: istore 4
    //   14: invokestatic 135	com/baidu/carlife/core/connect/a/e:a	()Lcom/baidu/carlife/core/connect/a/e;
    //   17: invokevirtual 137	com/baidu/carlife/core/connect/a/e:c	()Z
    //   20: ifeq +46 -> 66
    //   23: aload 5
    //   25: astore 6
    //   27: iload_3
    //   28: istore 4
    //   30: iload_2
    //   31: ifle +35 -> 66
    //   34: aload_0
    //   35: getfield 60	com/baidu/carlife/core/audio/m:h	Lcom/baidu/carlife/core/connect/a/b;
    //   38: aload_1
    //   39: iload_2
    //   40: invokevirtual 140	com/baidu/carlife/core/connect/a/b:a	([BI)[B
    //   43: astore 6
    //   45: aload 6
    //   47: ifnonnull +14 -> 61
    //   50: getstatic 43	com/baidu/carlife/core/audio/m:a	Ljava/lang/String;
    //   53: ldc -114
    //   55: invokestatic 144	com/baidu/carlife/core/i:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   58: aload_0
    //   59: monitorexit
    //   60: return
    //   61: aload 6
    //   63: arraylength
    //   64: istore 4
    //   66: invokestatic 87	com/baidu/carlife/core/audio/a:h	()Z
    //   69: ifeq -11 -> 58
    //   72: aload_0
    //   73: getfield 65	com/baidu/carlife/core/audio/m:b	Lcom/baidu/carlife/core/audio/o;
    //   76: ldc -111
    //   78: invokevirtual 91	com/baidu/carlife/core/audio/o:c	(I)V
    //   81: aload_0
    //   82: getfield 65	com/baidu/carlife/core/audio/m:b	Lcom/baidu/carlife/core/audio/o;
    //   85: iload 4
    //   87: invokevirtual 93	com/baidu/carlife/core/audio/o:a	(I)V
    //   90: aload_0
    //   91: getfield 65	com/baidu/carlife/core/audio/m:b	Lcom/baidu/carlife/core/audio/o;
    //   94: invokevirtual 147	com/baidu/carlife/core/audio/o:c	()V
    //   97: aload_0
    //   98: getfield 55	com/baidu/carlife/core/audio/m:g	Lcom/baidu/carlife/core/audio/c;
    //   101: aload_0
    //   102: getfield 65	com/baidu/carlife/core/audio/m:b	Lcom/baidu/carlife/core/audio/o;
    //   105: invokevirtual 96	com/baidu/carlife/core/audio/o:a	()[B
    //   108: aload_0
    //   109: getfield 74	com/baidu/carlife/core/audio/m:e	I
    //   112: aload 6
    //   114: iload 4
    //   116: aload_0
    //   117: getfield 50	com/baidu/carlife/core/audio/m:f	Lcom/baidu/carlife/core/audio/p;
    //   120: invokevirtual 150	com/baidu/carlife/core/audio/c:a	([BI[BILcom/baidu/carlife/core/audio/p;)V
    //   123: aload_0
    //   124: aload_0
    //   125: getfield 50	com/baidu/carlife/core/audio/m:f	Lcom/baidu/carlife/core/audio/p;
    //   128: invokevirtual 151	com/baidu/carlife/core/audio/p:a	()[B
    //   131: aload_0
    //   132: getfield 50	com/baidu/carlife/core/audio/m:f	Lcom/baidu/carlife/core/audio/p;
    //   135: invokevirtual 152	com/baidu/carlife/core/audio/p:b	()I
    //   138: invokespecial 101	com/baidu/carlife/core/audio/m:b	([BI)I
    //   141: pop
    //   142: goto -84 -> 58
    //   145: astore_1
    //   146: aload_0
    //   147: monitorexit
    //   148: aload_1
    //   149: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	150	0	this	m
    //   0	150	1	paramArrayOfByte	byte[]
    //   0	150	2	paramInt	int
    //   6	22	3	i	int
    //   12	103	4	j	int
    //   3	21	5	arrayOfByte1	byte[]
    //   9	104	6	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   14	23	145	finally
    //   34	45	145	finally
    //   50	58	145	finally
    //   61	66	145	finally
    //   66	142	145	finally
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/core/audio/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */