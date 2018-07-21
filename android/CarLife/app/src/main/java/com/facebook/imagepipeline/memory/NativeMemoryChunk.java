package com.facebook.imagepipeline.memory;

import android.util.Log;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.internal.k;
import com.facebook.imagepipeline.nativecode.a;
import java.io.Closeable;

@DoNotStrip
public class NativeMemoryChunk
  implements Closeable
{
  private static final String a = "NativeMemoryChunk";
  private final long b;
  private final int c;
  private boolean d;
  
  static {}
  
  @VisibleForTesting
  public NativeMemoryChunk()
  {
    this.c = 0;
    this.b = 0L;
    this.d = true;
  }
  
  public NativeMemoryChunk(int paramInt)
  {
    if (paramInt > 0) {}
    for (boolean bool = true;; bool = false)
    {
      k.a(bool);
      this.c = paramInt;
      this.b = nativeAllocate(this.c);
      this.d = false;
      return;
    }
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    return Math.min(Math.max(0, this.c - paramInt1), paramInt2);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool2 = true;
    if (paramInt4 >= 0)
    {
      bool1 = true;
      k.a(bool1);
      if (paramInt1 < 0) {
        break label83;
      }
      bool1 = true;
      label23:
      k.a(bool1);
      if (paramInt3 < 0) {
        break label89;
      }
      bool1 = true;
      label35:
      k.a(bool1);
      if (paramInt1 + paramInt4 > this.c) {
        break label95;
      }
      bool1 = true;
      label54:
      k.a(bool1);
      if (paramInt3 + paramInt4 > paramInt2) {
        break label101;
      }
    }
    label83:
    label89:
    label95:
    label101:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      k.a(bool1);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label23;
      bool1 = false;
      break label35;
      bool1 = false;
      break label54;
    }
  }
  
  private void b(int paramInt1, NativeMemoryChunk paramNativeMemoryChunk, int paramInt2, int paramInt3)
  {
    boolean bool2 = true;
    if (!a())
    {
      bool1 = true;
      k.b(bool1);
      if (paramNativeMemoryChunk.a()) {
        break label72;
      }
    }
    label72:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      k.b(bool1);
      a(paramInt1, paramNativeMemoryChunk.c, paramInt2, paramInt3);
      nativeMemcpy(paramNativeMemoryChunk.b + paramInt2, this.b + paramInt1, paramInt3);
      return;
      bool1 = false;
      break;
    }
  }
  
  @DoNotStrip
  private static native long nativeAllocate(int paramInt);
  
  @DoNotStrip
  private static native void nativeCopyFromByteArray(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  @DoNotStrip
  private static native void nativeCopyToByteArray(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  @DoNotStrip
  private static native void nativeFree(long paramLong);
  
  @DoNotStrip
  private static native void nativeMemcpy(long paramLong1, long paramLong2, int paramInt);
  
  @DoNotStrip
  private static native byte nativeReadByte(long paramLong);
  
  /* Error */
  public byte a(int paramInt)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_0
    //   6: invokevirtual 59	com/facebook/imagepipeline/memory/NativeMemoryChunk:a	()Z
    //   9: ifne +49 -> 58
    //   12: iconst_1
    //   13: istore_3
    //   14: iload_3
    //   15: invokestatic 61	com/facebook/common/internal/k:b	(Z)V
    //   18: iload_1
    //   19: iflt +44 -> 63
    //   22: iconst_1
    //   23: istore_3
    //   24: iload_3
    //   25: invokestatic 41	com/facebook/common/internal/k:a	(Z)V
    //   28: iload_1
    //   29: aload_0
    //   30: getfield 30	com/facebook/imagepipeline/memory/NativeMemoryChunk:c	I
    //   33: if_icmpge +35 -> 68
    //   36: iload 4
    //   38: istore_3
    //   39: iload_3
    //   40: invokestatic 41	com/facebook/common/internal/k:a	(Z)V
    //   43: aload_0
    //   44: getfield 32	com/facebook/imagepipeline/memory/NativeMemoryChunk:b	J
    //   47: iload_1
    //   48: i2l
    //   49: ladd
    //   50: invokestatic 77	com/facebook/imagepipeline/memory/NativeMemoryChunk:nativeReadByte	(J)B
    //   53: istore_2
    //   54: aload_0
    //   55: monitorexit
    //   56: iload_2
    //   57: ireturn
    //   58: iconst_0
    //   59: istore_3
    //   60: goto -46 -> 14
    //   63: iconst_0
    //   64: istore_3
    //   65: goto -41 -> 24
    //   68: iconst_0
    //   69: istore_3
    //   70: goto -31 -> 39
    //   73: astore 5
    //   75: aload_0
    //   76: monitorexit
    //   77: aload 5
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	NativeMemoryChunk
    //   0	80	1	paramInt	int
    //   53	4	2	b1	byte
    //   13	57	3	bool1	boolean
    //   1	36	4	bool2	boolean
    //   73	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   5	12	73	finally
    //   14	18	73	finally
    //   24	36	73	finally
    //   39	54	73	finally
  }
  
  /* Error */
  public int a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: invokestatic 81	com/facebook/common/internal/k:a	(Ljava/lang/Object;)Ljava/lang/Object;
    //   6: pop
    //   7: aload_0
    //   8: invokevirtual 59	com/facebook/imagepipeline/memory/NativeMemoryChunk:a	()Z
    //   11: ifne +49 -> 60
    //   14: iconst_1
    //   15: istore 5
    //   17: iload 5
    //   19: invokestatic 61	com/facebook/common/internal/k:b	(Z)V
    //   22: aload_0
    //   23: iload_1
    //   24: iload 4
    //   26: invokespecial 83	com/facebook/imagepipeline/memory/NativeMemoryChunk:a	(II)I
    //   29: istore 4
    //   31: aload_0
    //   32: iload_1
    //   33: aload_2
    //   34: arraylength
    //   35: iload_3
    //   36: iload 4
    //   38: invokespecial 63	com/facebook/imagepipeline/memory/NativeMemoryChunk:a	(IIII)V
    //   41: aload_0
    //   42: getfield 32	com/facebook/imagepipeline/memory/NativeMemoryChunk:b	J
    //   45: iload_1
    //   46: i2l
    //   47: ladd
    //   48: aload_2
    //   49: iload_3
    //   50: iload 4
    //   52: invokestatic 85	com/facebook/imagepipeline/memory/NativeMemoryChunk:nativeCopyFromByteArray	(J[BII)V
    //   55: aload_0
    //   56: monitorexit
    //   57: iload 4
    //   59: ireturn
    //   60: iconst_0
    //   61: istore 5
    //   63: goto -46 -> 17
    //   66: astore_2
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_2
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	NativeMemoryChunk
    //   0	71	1	paramInt1	int
    //   0	71	2	paramArrayOfByte	byte[]
    //   0	71	3	paramInt2	int
    //   0	71	4	paramInt3	int
    //   15	47	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	14	66	finally
    //   17	55	66	finally
  }
  
  /* Error */
  public void a(int paramInt1, NativeMemoryChunk paramNativeMemoryChunk, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokestatic 81	com/facebook/common/internal/k:a	(Ljava/lang/Object;)Ljava/lang/Object;
    //   4: pop
    //   5: aload_2
    //   6: getfield 32	com/facebook/imagepipeline/memory/NativeMemoryChunk:b	J
    //   9: aload_0
    //   10: getfield 32	com/facebook/imagepipeline/memory/NativeMemoryChunk:b	J
    //   13: lcmp
    //   14: ifne +68 -> 82
    //   17: ldc 11
    //   19: new 87	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   26: ldc 90
    //   28: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: aload_0
    //   32: invokestatic 100	java/lang/System:identityHashCode	(Ljava/lang/Object;)I
    //   35: invokestatic 106	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   38: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: ldc 108
    //   43: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: aload_2
    //   47: invokestatic 100	java/lang/System:identityHashCode	(Ljava/lang/Object;)I
    //   50: invokestatic 106	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   53: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: ldc 110
    //   58: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: aload_0
    //   62: getfield 32	com/facebook/imagepipeline/memory/NativeMemoryChunk:b	J
    //   65: invokestatic 115	java/lang/Long:toHexString	(J)Ljava/lang/String;
    //   68: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokestatic 125	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   77: pop
    //   78: iconst_0
    //   79: invokestatic 41	com/facebook/common/internal/k:a	(Z)V
    //   82: aload_2
    //   83: getfield 32	com/facebook/imagepipeline/memory/NativeMemoryChunk:b	J
    //   86: aload_0
    //   87: getfield 32	com/facebook/imagepipeline/memory/NativeMemoryChunk:b	J
    //   90: lcmp
    //   91: ifge +35 -> 126
    //   94: aload_2
    //   95: monitorenter
    //   96: aload_0
    //   97: monitorenter
    //   98: aload_0
    //   99: iload_1
    //   100: aload_2
    //   101: iload_3
    //   102: iload 4
    //   104: invokespecial 127	com/facebook/imagepipeline/memory/NativeMemoryChunk:b	(ILcom/facebook/imagepipeline/memory/NativeMemoryChunk;II)V
    //   107: aload_0
    //   108: monitorexit
    //   109: aload_2
    //   110: monitorexit
    //   111: return
    //   112: astore 5
    //   114: aload_0
    //   115: monitorexit
    //   116: aload 5
    //   118: athrow
    //   119: astore 5
    //   121: aload_2
    //   122: monitorexit
    //   123: aload 5
    //   125: athrow
    //   126: aload_0
    //   127: monitorenter
    //   128: aload_2
    //   129: monitorenter
    //   130: aload_0
    //   131: iload_1
    //   132: aload_2
    //   133: iload_3
    //   134: iload 4
    //   136: invokespecial 127	com/facebook/imagepipeline/memory/NativeMemoryChunk:b	(ILcom/facebook/imagepipeline/memory/NativeMemoryChunk;II)V
    //   139: aload_2
    //   140: monitorexit
    //   141: aload_0
    //   142: monitorexit
    //   143: return
    //   144: astore_2
    //   145: aload_0
    //   146: monitorexit
    //   147: aload_2
    //   148: athrow
    //   149: astore 5
    //   151: aload_2
    //   152: monitorexit
    //   153: aload 5
    //   155: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	this	NativeMemoryChunk
    //   0	156	1	paramInt1	int
    //   0	156	2	paramNativeMemoryChunk	NativeMemoryChunk
    //   0	156	3	paramInt2	int
    //   0	156	4	paramInt3	int
    //   112	5	5	localObject1	Object
    //   119	5	5	localObject2	Object
    //   149	5	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   98	109	112	finally
    //   114	116	112	finally
    //   96	98	119	finally
    //   109	111	119	finally
    //   116	119	119	finally
    //   121	123	119	finally
    //   128	130	144	finally
    //   141	143	144	finally
    //   145	147	144	finally
    //   153	156	144	finally
    //   130	141	149	finally
    //   151	153	149	finally
  }
  
  public boolean a()
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
  
  public int b()
  {
    return this.c;
  }
  
  /* Error */
  public int b(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: invokestatic 81	com/facebook/common/internal/k:a	(Ljava/lang/Object;)Ljava/lang/Object;
    //   6: pop
    //   7: aload_0
    //   8: invokevirtual 59	com/facebook/imagepipeline/memory/NativeMemoryChunk:a	()Z
    //   11: ifne +49 -> 60
    //   14: iconst_1
    //   15: istore 5
    //   17: iload 5
    //   19: invokestatic 61	com/facebook/common/internal/k:b	(Z)V
    //   22: aload_0
    //   23: iload_1
    //   24: iload 4
    //   26: invokespecial 83	com/facebook/imagepipeline/memory/NativeMemoryChunk:a	(II)I
    //   29: istore 4
    //   31: aload_0
    //   32: iload_1
    //   33: aload_2
    //   34: arraylength
    //   35: iload_3
    //   36: iload 4
    //   38: invokespecial 63	com/facebook/imagepipeline/memory/NativeMemoryChunk:a	(IIII)V
    //   41: aload_0
    //   42: getfield 32	com/facebook/imagepipeline/memory/NativeMemoryChunk:b	J
    //   45: iload_1
    //   46: i2l
    //   47: ladd
    //   48: aload_2
    //   49: iload_3
    //   50: iload 4
    //   52: invokestatic 130	com/facebook/imagepipeline/memory/NativeMemoryChunk:nativeCopyToByteArray	(J[BII)V
    //   55: aload_0
    //   56: monitorexit
    //   57: iload 4
    //   59: ireturn
    //   60: iconst_0
    //   61: istore 5
    //   63: goto -46 -> 17
    //   66: astore_2
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_2
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	NativeMemoryChunk
    //   0	71	1	paramInt1	int
    //   0	71	2	paramArrayOfByte	byte[]
    //   0	71	3	paramInt2	int
    //   0	71	4	paramInt3	int
    //   15	47	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	14	66	finally
    //   17	55	66	finally
  }
  
  public long c()
  {
    return this.b;
  }
  
  public void close()
  {
    try
    {
      if (!this.d)
      {
        this.d = true;
        nativeFree(this.b);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  protected void finalize()
    throws Throwable
  {
    if (a()) {
      return;
    }
    Log.w("NativeMemoryChunk", "finalize: Chunk " + Integer.toHexString(System.identityHashCode(this)) + " still active. Underlying address = " + Long.toHexString(this.b));
    try
    {
      close();
      return;
    }
    finally
    {
      super.finalize();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/memory/NativeMemoryChunk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */