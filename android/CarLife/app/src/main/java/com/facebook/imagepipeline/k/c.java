package com.facebook.imagepipeline.k;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.os.MemoryFile;
import com.facebook.common.h.a;
import com.facebook.common.internal.o;
import com.facebook.imagepipeline.memory.y;
import java.io.FileDescriptor;
import java.lang.reflect.Method;

public class c
  extends b
{
  private static Method b;
  private final boolean c;
  
  public c(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  /* Error */
  private static MemoryFile a(a<y> parama, int paramInt, @javax.annotation.Nullable byte[] paramArrayOfByte)
    throws java.io.IOException
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +125 -> 126
    //   4: iconst_0
    //   5: istore_3
    //   6: new 23	android/os/MemoryFile
    //   9: dup
    //   10: aconst_null
    //   11: iload_1
    //   12: iload_3
    //   13: iadd
    //   14: invokespecial 26	android/os/MemoryFile:<init>	(Ljava/lang/String;I)V
    //   17: astore 9
    //   19: aload 9
    //   21: iconst_0
    //   22: invokevirtual 30	android/os/MemoryFile:allowPurging	(Z)Z
    //   25: pop
    //   26: aconst_null
    //   27: astore 8
    //   29: aconst_null
    //   30: astore 7
    //   32: aconst_null
    //   33: astore 4
    //   35: aconst_null
    //   36: astore 6
    //   38: new 32	com/facebook/imagepipeline/memory/aa
    //   41: dup
    //   42: aload_0
    //   43: invokevirtual 37	com/facebook/common/h/a:a	()Ljava/lang/Object;
    //   46: checkcast 39	com/facebook/imagepipeline/memory/y
    //   49: invokespecial 42	com/facebook/imagepipeline/memory/aa:<init>	(Lcom/facebook/imagepipeline/memory/y;)V
    //   52: astore 5
    //   54: new 44	com/facebook/common/k/a
    //   57: dup
    //   58: aload 5
    //   60: iload_1
    //   61: invokespecial 47	com/facebook/common/k/a:<init>	(Ljava/io/InputStream;I)V
    //   64: astore 8
    //   66: aload 9
    //   68: invokevirtual 51	android/os/MemoryFile:getOutputStream	()Ljava/io/OutputStream;
    //   71: astore 6
    //   73: aload 6
    //   75: astore 4
    //   77: aload 8
    //   79: aload 6
    //   81: invokestatic 56	com/facebook/common/internal/b:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   84: pop2
    //   85: aload_2
    //   86: ifnull +17 -> 103
    //   89: aload 6
    //   91: astore 4
    //   93: aload 9
    //   95: aload_2
    //   96: iconst_0
    //   97: iload_1
    //   98: aload_2
    //   99: arraylength
    //   100: invokevirtual 60	android/os/MemoryFile:writeBytes	([BIII)V
    //   103: aload_0
    //   104: invokestatic 63	com/facebook/common/h/a:c	(Lcom/facebook/common/h/a;)V
    //   107: aload 5
    //   109: invokestatic 68	com/facebook/common/internal/c:a	(Ljava/io/InputStream;)V
    //   112: aload 8
    //   114: invokestatic 68	com/facebook/common/internal/c:a	(Ljava/io/InputStream;)V
    //   117: aload 6
    //   119: iconst_1
    //   120: invokestatic 71	com/facebook/common/internal/c:a	(Ljava/io/Closeable;Z)V
    //   123: aload 9
    //   125: areturn
    //   126: aload_2
    //   127: arraylength
    //   128: istore_3
    //   129: goto -123 -> 6
    //   132: astore 4
    //   134: aload 8
    //   136: astore_2
    //   137: aload 7
    //   139: astore 5
    //   141: aload_0
    //   142: invokestatic 63	com/facebook/common/h/a:c	(Lcom/facebook/common/h/a;)V
    //   145: aload_2
    //   146: invokestatic 68	com/facebook/common/internal/c:a	(Ljava/io/InputStream;)V
    //   149: aload 5
    //   151: invokestatic 68	com/facebook/common/internal/c:a	(Ljava/io/InputStream;)V
    //   154: aload 6
    //   156: iconst_1
    //   157: invokestatic 71	com/facebook/common/internal/c:a	(Ljava/io/Closeable;Z)V
    //   160: aload 4
    //   162: athrow
    //   163: astore 4
    //   165: aload 5
    //   167: astore_2
    //   168: aload 7
    //   170: astore 5
    //   172: goto -31 -> 141
    //   175: astore 7
    //   177: aload 8
    //   179: astore 6
    //   181: aload 5
    //   183: astore_2
    //   184: aload 6
    //   186: astore 5
    //   188: aload 4
    //   190: astore 6
    //   192: aload 7
    //   194: astore 4
    //   196: goto -55 -> 141
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	199	0	parama	a<y>
    //   0	199	1	paramInt	int
    //   0	199	2	paramArrayOfByte	byte[]
    //   5	124	3	i	int
    //   33	59	4	localObject1	Object
    //   132	29	4	localObject2	Object
    //   163	26	4	localObject3	Object
    //   194	1	4	localObject4	Object
    //   52	135	5	localObject5	Object
    //   36	155	6	localObject6	Object
    //   30	139	7	localObject7	Object
    //   175	18	7	localObject8	Object
    //   27	151	8	locala	com.facebook.common.k.a
    //   17	107	9	localMemoryFile	MemoryFile
    // Exception table:
    //   from	to	target	type
    //   38	54	132	finally
    //   54	66	163	finally
    //   66	73	175	finally
    //   77	85	175	finally
    //   93	103	175	finally
  }
  
  private FileDescriptor a(MemoryFile paramMemoryFile)
  {
    try
    {
      paramMemoryFile = (FileDescriptor)a().invoke(paramMemoryFile, new Object[0]);
      return paramMemoryFile;
    }
    catch (Exception paramMemoryFile)
    {
      throw o.b(paramMemoryFile);
    }
  }
  
  /* Error */
  private Method a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 98	com/facebook/imagepipeline/k/c:b	Ljava/lang/reflect/Method;
    //   5: astore_1
    //   6: aload_1
    //   7: ifnonnull +17 -> 24
    //   10: ldc 23
    //   12: ldc 100
    //   14: iconst_0
    //   15: anewarray 102	java/lang/Class
    //   18: invokevirtual 106	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   21: putstatic 98	com/facebook/imagepipeline/k/c:b	Ljava/lang/reflect/Method;
    //   24: getstatic 98	com/facebook/imagepipeline/k/c:b	Ljava/lang/reflect/Method;
    //   27: astore_1
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_1
    //   31: areturn
    //   32: astore_1
    //   33: aload_1
    //   34: invokestatic 96	com/facebook/common/internal/o:b	(Ljava/lang/Throwable;)Ljava/lang/RuntimeException;
    //   37: athrow
    //   38: astore_1
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_1
    //   42: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	this	c
    //   5	26	1	localMethod	Method
    //   32	2	1	localException	Exception
    //   38	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   10	24	32	java/lang/Exception
    //   2	6	38	finally
    //   10	24	38	finally
    //   24	28	38	finally
    //   33	38	38	finally
  }
  
  protected Bitmap a(a<y> parama, int paramInt, BitmapFactory.Options paramOptions)
  {
    if (a(parama, paramInt)) {}
    for (byte[] arrayOfByte = null;; arrayOfByte = a) {
      return a(parama, paramInt, arrayOfByte, paramOptions);
    }
  }
  
  /* Error */
  protected Bitmap a(a<y> parama, int paramInt, byte[] paramArrayOfByte, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: aload_1
    //   7: iload_2
    //   8: aload_3
    //   9: invokestatic 119	com/facebook/imagepipeline/k/c:a	(Lcom/facebook/common/h/a;I[B)Landroid/os/MemoryFile;
    //   12: astore_1
    //   13: aload_1
    //   14: astore 5
    //   16: aload_1
    //   17: astore 6
    //   19: aload_0
    //   20: aload_1
    //   21: invokespecial 121	com/facebook/imagepipeline/k/c:a	(Landroid/os/MemoryFile;)Ljava/io/FileDescriptor;
    //   24: astore_3
    //   25: aload_1
    //   26: astore 5
    //   28: aload_1
    //   29: astore 6
    //   31: aload_0
    //   32: getfield 15	com/facebook/imagepipeline/k/c:c	Z
    //   35: ifeq +48 -> 83
    //   38: aload_1
    //   39: astore 5
    //   41: aload_1
    //   42: astore 6
    //   44: getstatic 127	com/facebook/common/n/b:d	Lcom/facebook/common/n/a;
    //   47: aload_3
    //   48: aconst_null
    //   49: aload 4
    //   51: invokeinterface 132 4 0
    //   56: astore_3
    //   57: aload_1
    //   58: astore 5
    //   60: aload_1
    //   61: astore 6
    //   63: aload_3
    //   64: ldc -122
    //   66: invokestatic 139	com/facebook/common/internal/k:a	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   69: checkcast 141	android/graphics/Bitmap
    //   72: astore_3
    //   73: aload_1
    //   74: ifnull +7 -> 81
    //   77: aload_1
    //   78: invokevirtual 144	android/os/MemoryFile:close	()V
    //   81: aload_3
    //   82: areturn
    //   83: aload_1
    //   84: astore 5
    //   86: aload_1
    //   87: astore 6
    //   89: aload_3
    //   90: aconst_null
    //   91: aload 4
    //   93: invokestatic 149	android/graphics/BitmapFactory:decodeFileDescriptor	(Ljava/io/FileDescriptor;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   96: astore_3
    //   97: goto -40 -> 57
    //   100: astore_1
    //   101: aload 5
    //   103: astore 6
    //   105: aload_1
    //   106: invokestatic 96	com/facebook/common/internal/o:b	(Ljava/lang/Throwable;)Ljava/lang/RuntimeException;
    //   109: athrow
    //   110: astore_1
    //   111: aload 6
    //   113: ifnull +8 -> 121
    //   116: aload 6
    //   118: invokevirtual 144	android/os/MemoryFile:close	()V
    //   121: aload_1
    //   122: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	this	c
    //   0	123	1	parama	a<y>
    //   0	123	2	paramInt	int
    //   0	123	3	paramArrayOfByte	byte[]
    //   0	123	4	paramOptions	BitmapFactory.Options
    //   4	98	5	locala	a<y>
    //   1	116	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   6	13	100	java/io/IOException
    //   19	25	100	java/io/IOException
    //   31	38	100	java/io/IOException
    //   44	57	100	java/io/IOException
    //   63	73	100	java/io/IOException
    //   89	97	100	java/io/IOException
    //   6	13	110	finally
    //   19	25	110	finally
    //   31	38	110	finally
    //   44	57	110	finally
    //   63	73	110	finally
    //   89	97	110	finally
    //   105	110	110	finally
  }
  
  protected Bitmap a(a<y> parama, BitmapFactory.Options paramOptions)
  {
    return a(parama, ((y)parama.a()).a(), null, paramOptions);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/k/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */