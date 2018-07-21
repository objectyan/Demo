package com.baidu.carlife.core.audio;

import com.baidu.carlife.core.connect.a.b;
import com.baidu.carlife.core.connect.e;
import com.baidu.carlife.core.i;

public class q
  extends f
{
  private static final String a = "Audio-" + q.class.getSimpleName();
  private o b = new o();
  private byte[] c = new byte[120];
  private int d;
  private int e;
  private p f = new p();
  private c g = new c();
  private b h = new b();
  
  public q()
  {
    a.a();
    this.e = 12;
  }
  
  private int b(byte[] paramArrayOfByte, int paramInt)
  {
    if (a.a().g()) {
      return -1;
    }
    return e.a().g(paramArrayOfByte, paramInt);
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
    //   13: getstatic 43	com/baidu/carlife/core/audio/q:a	Ljava/lang/String;
    //   16: ldc 89
    //   18: invokestatic 94	com/baidu/carlife/core/i:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: aload_0
    //   22: getfield 65	com/baidu/carlife/core/audio/q:b	Lcom/baidu/carlife/core/audio/o;
    //   25: ldc 95
    //   27: invokevirtual 98	com/baidu/carlife/core/audio/o:c	(I)V
    //   30: aload_0
    //   31: getfield 65	com/baidu/carlife/core/audio/q:b	Lcom/baidu/carlife/core/audio/o;
    //   34: iconst_0
    //   35: invokevirtual 100	com/baidu/carlife/core/audio/o:a	(I)V
    //   38: aload_0
    //   39: aload_0
    //   40: getfield 65	com/baidu/carlife/core/audio/q:b	Lcom/baidu/carlife/core/audio/o;
    //   43: invokevirtual 103	com/baidu/carlife/core/audio/o:a	()[B
    //   46: aload_0
    //   47: getfield 65	com/baidu/carlife/core/audio/q:b	Lcom/baidu/carlife/core/audio/o;
    //   50: invokevirtual 106	com/baidu/carlife/core/audio/o:b	()I
    //   53: invokespecial 108	com/baidu/carlife/core/audio/q:b	([BI)I
    //   56: pop
    //   57: goto -47 -> 10
    //   60: astore_2
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_2
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	q
    //   5	2	1	bool	boolean
    //   60	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	6	60	finally
    //   13	57	60	finally
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
      this.b.c(327682);
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
    //   14: invokestatic 137	com/baidu/carlife/core/connect/a/e:a	()Lcom/baidu/carlife/core/connect/a/e;
    //   17: invokevirtual 139	com/baidu/carlife/core/connect/a/e:c	()Z
    //   20: ifeq +46 -> 66
    //   23: aload 5
    //   25: astore 6
    //   27: iload_3
    //   28: istore 4
    //   30: iload_2
    //   31: ifle +35 -> 66
    //   34: aload_0
    //   35: getfield 60	com/baidu/carlife/core/audio/q:h	Lcom/baidu/carlife/core/connect/a/b;
    //   38: aload_1
    //   39: iload_2
    //   40: invokevirtual 142	com/baidu/carlife/core/connect/a/b:a	([BI)[B
    //   43: astore 6
    //   45: aload 6
    //   47: ifnonnull +14 -> 61
    //   50: getstatic 43	com/baidu/carlife/core/audio/q:a	Ljava/lang/String;
    //   53: ldc -112
    //   55: invokestatic 146	com/baidu/carlife/core/i:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   58: aload_0
    //   59: monitorexit
    //   60: return
    //   61: aload 6
    //   63: arraylength
    //   64: istore 4
    //   66: invokestatic 87	com/baidu/carlife/core/audio/a:h	()Z
    //   69: ifeq -11 -> 58
    //   72: getstatic 43	com/baidu/carlife/core/audio/q:a	Ljava/lang/String;
    //   75: new 23	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   82: ldc -108
    //   84: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: iload 4
    //   89: invokevirtual 114	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   92: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokestatic 94	com/baidu/carlife/core/i:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   98: aload_0
    //   99: getfield 65	com/baidu/carlife/core/audio/q:b	Lcom/baidu/carlife/core/audio/o;
    //   102: ldc -107
    //   104: invokevirtual 98	com/baidu/carlife/core/audio/o:c	(I)V
    //   107: aload_0
    //   108: getfield 65	com/baidu/carlife/core/audio/q:b	Lcom/baidu/carlife/core/audio/o;
    //   111: iload 4
    //   113: invokevirtual 100	com/baidu/carlife/core/audio/o:a	(I)V
    //   116: aload_0
    //   117: getfield 65	com/baidu/carlife/core/audio/q:b	Lcom/baidu/carlife/core/audio/o;
    //   120: invokevirtual 151	com/baidu/carlife/core/audio/o:c	()V
    //   123: aload_0
    //   124: getfield 55	com/baidu/carlife/core/audio/q:g	Lcom/baidu/carlife/core/audio/c;
    //   127: aload_0
    //   128: getfield 65	com/baidu/carlife/core/audio/q:b	Lcom/baidu/carlife/core/audio/o;
    //   131: invokevirtual 103	com/baidu/carlife/core/audio/o:a	()[B
    //   134: aload_0
    //   135: getfield 74	com/baidu/carlife/core/audio/q:e	I
    //   138: aload 6
    //   140: iload 4
    //   142: aload_0
    //   143: getfield 50	com/baidu/carlife/core/audio/q:f	Lcom/baidu/carlife/core/audio/p;
    //   146: invokevirtual 154	com/baidu/carlife/core/audio/c:a	([BI[BILcom/baidu/carlife/core/audio/p;)V
    //   149: aload_0
    //   150: aload_0
    //   151: getfield 50	com/baidu/carlife/core/audio/q:f	Lcom/baidu/carlife/core/audio/p;
    //   154: invokevirtual 155	com/baidu/carlife/core/audio/p:a	()[B
    //   157: aload_0
    //   158: getfield 50	com/baidu/carlife/core/audio/q:f	Lcom/baidu/carlife/core/audio/p;
    //   161: invokevirtual 156	com/baidu/carlife/core/audio/p:b	()I
    //   164: invokespecial 108	com/baidu/carlife/core/audio/q:b	([BI)I
    //   167: pop
    //   168: goto -110 -> 58
    //   171: astore_1
    //   172: aload_0
    //   173: monitorexit
    //   174: aload_1
    //   175: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	this	q
    //   0	176	1	paramArrayOfByte	byte[]
    //   0	176	2	paramInt	int
    //   6	22	3	i	int
    //   12	129	4	j	int
    //   3	21	5	arrayOfByte1	byte[]
    //   9	130	6	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   14	23	171	finally
    //   34	45	171	finally
    //   50	58	171	finally
    //   61	66	171	finally
    //   66	168	171	finally
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/core/audio/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */