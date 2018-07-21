package com.facebook.imagepipeline.l;

import android.content.res.AssetManager;
import android.net.Uri;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.i.d;
import com.facebook.imagepipeline.m.c;
import com.facebook.imagepipeline.memory.z;
import java.io.IOException;
import java.util.concurrent.Executor;

public class u
  extends y
{
  @VisibleForTesting
  static final String a = "LocalAssetFetchProducer";
  private final AssetManager b;
  
  public u(Executor paramExecutor, z paramz, AssetManager paramAssetManager, boolean paramBoolean)
  {
    super(paramExecutor, paramz, paramBoolean);
    this.b = paramAssetManager;
  }
  
  /* Error */
  private int b(c paramc)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: aload_0
    //   7: getfield 18	com/facebook/imagepipeline/l/u:b	Landroid/content/res/AssetManager;
    //   10: aload_1
    //   11: invokestatic 26	com/facebook/imagepipeline/l/u:c	(Lcom/facebook/imagepipeline/m/c;)Ljava/lang/String;
    //   14: invokevirtual 32	android/content/res/AssetManager:openFd	(Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   17: astore_1
    //   18: aload_1
    //   19: astore 6
    //   21: aload_1
    //   22: astore 7
    //   24: aload_1
    //   25: invokevirtual 38	android/content/res/AssetFileDescriptor:getLength	()J
    //   28: lstore 4
    //   30: lload 4
    //   32: l2i
    //   33: istore_3
    //   34: iload_3
    //   35: istore_2
    //   36: aload_1
    //   37: ifnull +9 -> 46
    //   40: aload_1
    //   41: invokevirtual 42	android/content/res/AssetFileDescriptor:close	()V
    //   44: iload_3
    //   45: istore_2
    //   46: iload_2
    //   47: ireturn
    //   48: astore_1
    //   49: iconst_m1
    //   50: istore_2
    //   51: aload 6
    //   53: ifnull -7 -> 46
    //   56: aload 6
    //   58: invokevirtual 42	android/content/res/AssetFileDescriptor:close	()V
    //   61: iconst_m1
    //   62: ireturn
    //   63: astore_1
    //   64: iconst_m1
    //   65: ireturn
    //   66: astore_1
    //   67: aload 7
    //   69: ifnull +8 -> 77
    //   72: aload 7
    //   74: invokevirtual 42	android/content/res/AssetFileDescriptor:close	()V
    //   77: aload_1
    //   78: athrow
    //   79: astore_1
    //   80: iload_3
    //   81: ireturn
    //   82: astore 6
    //   84: goto -7 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	u
    //   0	87	1	paramc	c
    //   35	16	2	i	int
    //   33	48	3	j	int
    //   28	3	4	l	long
    //   4	53	6	localc1	c
    //   82	1	6	localIOException	IOException
    //   1	72	7	localc2	c
    // Exception table:
    //   from	to	target	type
    //   6	18	48	java/io/IOException
    //   24	30	48	java/io/IOException
    //   56	61	63	java/io/IOException
    //   6	18	66	finally
    //   24	30	66	finally
    //   40	44	79	java/io/IOException
    //   72	77	82	java/io/IOException
  }
  
  private static String c(c paramc)
  {
    return paramc.b().getPath().substring(1);
  }
  
  protected d a(c paramc)
    throws IOException
  {
    return b(this.b.open(c(paramc), 2), b(paramc));
  }
  
  protected String a()
  {
    return "LocalAssetFetchProducer";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/l/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */