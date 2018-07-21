package com.facebook.imagepipeline.c;

import android.annotation.TargetApi;
import javax.annotation.concurrent.ThreadSafe;

@TargetApi(11)
@ThreadSafe
public class d
  extends e
{
  private final b a;
  private final com.facebook.imagepipeline.k.e b;
  
  public d(b paramb, com.facebook.imagepipeline.k.e parame)
  {
    this.a = paramb;
    this.b = parame;
  }
  
  /* Error */
  public com.facebook.common.h.a<android.graphics.Bitmap> a(int paramInt1, int paramInt2, android.graphics.Bitmap.Config paramConfig)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 19	com/facebook/imagepipeline/c/d:a	Lcom/facebook/imagepipeline/c/b;
    //   4: iload_1
    //   5: i2s
    //   6: iload_2
    //   7: i2s
    //   8: invokevirtual 28	com/facebook/imagepipeline/c/b:a	(SS)Lcom/facebook/common/h/a;
    //   11: astore 4
    //   13: new 30	com/facebook/imagepipeline/i/d
    //   16: dup
    //   17: aload 4
    //   19: invokespecial 33	com/facebook/imagepipeline/i/d:<init>	(Lcom/facebook/common/h/a;)V
    //   22: astore 5
    //   24: aload 5
    //   26: getstatic 39	com/facebook/f/b:f	Lcom/facebook/f/b;
    //   29: invokevirtual 42	com/facebook/imagepipeline/i/d:a	(Lcom/facebook/f/b;)V
    //   32: aload_0
    //   33: getfield 21	com/facebook/imagepipeline/c/d:b	Lcom/facebook/imagepipeline/k/e;
    //   36: aload 5
    //   38: aload_3
    //   39: aload 4
    //   41: invokevirtual 47	com/facebook/common/h/a:a	()Ljava/lang/Object;
    //   44: checkcast 49	com/facebook/imagepipeline/memory/y
    //   47: invokeinterface 52 1 0
    //   52: invokeinterface 57 4 0
    //   57: astore_3
    //   58: aload_3
    //   59: invokevirtual 47	com/facebook/common/h/a:a	()Ljava/lang/Object;
    //   62: checkcast 59	android/graphics/Bitmap
    //   65: iconst_0
    //   66: invokevirtual 63	android/graphics/Bitmap:eraseColor	(I)V
    //   69: aload 5
    //   71: invokestatic 67	com/facebook/imagepipeline/i/d:d	(Lcom/facebook/imagepipeline/i/d;)V
    //   74: aload 4
    //   76: invokevirtual 70	com/facebook/common/h/a:close	()V
    //   79: aload_3
    //   80: areturn
    //   81: astore_3
    //   82: aload 5
    //   84: invokestatic 67	com/facebook/imagepipeline/i/d:d	(Lcom/facebook/imagepipeline/i/d;)V
    //   87: aload_3
    //   88: athrow
    //   89: astore_3
    //   90: aload 4
    //   92: invokevirtual 70	com/facebook/common/h/a:close	()V
    //   95: aload_3
    //   96: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	this	d
    //   0	97	1	paramInt1	int
    //   0	97	2	paramInt2	int
    //   0	97	3	paramConfig	android.graphics.Bitmap.Config
    //   11	80	4	locala	com.facebook.common.h.a
    //   22	61	5	locald	com.facebook.imagepipeline.i.d
    // Exception table:
    //   from	to	target	type
    //   32	69	81	finally
    //   13	32	89	finally
    //   69	74	89	finally
    //   82	89	89	finally
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/c/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */