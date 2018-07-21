package com.facebook.h;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.support.v4.util.Pools.SynchronizedPool;
import android.util.Pair;
import java.io.ByteArrayInputStream;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

public final class a
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 4;
  public static final int d = 2;
  public static final float e = 2048.0F;
  private static final int f = 16384;
  private static final int g = 12;
  private static final Pools.SynchronizedPool<ByteBuffer> h = new Pools.SynchronizedPool(12);
  
  public static int a(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    return paramInt1 * paramInt2 * a(paramConfig);
  }
  
  public static int a(Bitmap.Config paramConfig)
  {
    int i = 2;
    switch (a.1.a[paramConfig.ordinal()])
    {
    default: 
      throw new UnsupportedOperationException("The provided Bitmap.Config is not supported");
    case 1: 
      i = 4;
    case 3: 
    case 4: 
      return i;
    }
    return 1;
  }
  
  @SuppressLint({"NewApi"})
  public static int a(@Nullable Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return 0;
    }
    if (Build.VERSION.SDK_INT > 19) {
      try
      {
        int i = paramBitmap.getAllocationByteCount();
        return i;
      }
      catch (NullPointerException localNullPointerException) {}
    }
    if (Build.VERSION.SDK_INT >= 12) {
      return paramBitmap.getByteCount();
    }
    return paramBitmap.getWidth() * paramBitmap.getRowBytes();
  }
  
  /* Error */
  @Nullable
  public static Pair<Integer, Integer> a(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: invokestatic 91	com/facebook/common/internal/k:a	(Ljava/lang/Object;)Ljava/lang/Object;
    //   6: pop
    //   7: getstatic 32	com/facebook/h/a:h	Landroid/support/v4/util/Pools$SynchronizedPool;
    //   10: invokevirtual 95	android/support/v4/util/Pools$SynchronizedPool:acquire	()Ljava/lang/Object;
    //   13: checkcast 97	java/nio/ByteBuffer
    //   16: astore 4
    //   18: aload 4
    //   20: astore_2
    //   21: aload 4
    //   23: ifnonnull +10 -> 33
    //   26: sipush 16384
    //   29: invokestatic 101	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   32: astore_2
    //   33: new 103	android/graphics/BitmapFactory$Options
    //   36: dup
    //   37: invokespecial 104	android/graphics/BitmapFactory$Options:<init>	()V
    //   40: astore 4
    //   42: aload 4
    //   44: iconst_1
    //   45: putfield 108	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   48: aload 4
    //   50: aload_2
    //   51: invokevirtual 112	java/nio/ByteBuffer:array	()[B
    //   54: putfield 116	android/graphics/BitmapFactory$Options:inTempStorage	[B
    //   57: aload_0
    //   58: aconst_null
    //   59: aload 4
    //   61: invokestatic 122	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   64: pop
    //   65: aload_3
    //   66: astore_0
    //   67: aload 4
    //   69: getfield 125	android/graphics/BitmapFactory$Options:outWidth	I
    //   72: iconst_m1
    //   73: if_icmpeq +16 -> 89
    //   76: aload 4
    //   78: getfield 128	android/graphics/BitmapFactory$Options:outHeight	I
    //   81: istore_1
    //   82: iload_1
    //   83: iconst_m1
    //   84: if_icmpne +15 -> 99
    //   87: aload_3
    //   88: astore_0
    //   89: getstatic 32	com/facebook/h/a:h	Landroid/support/v4/util/Pools$SynchronizedPool;
    //   92: aload_2
    //   93: invokevirtual 132	android/support/v4/util/Pools$SynchronizedPool:release	(Ljava/lang/Object;)Z
    //   96: pop
    //   97: aload_0
    //   98: areturn
    //   99: new 134	android/util/Pair
    //   102: dup
    //   103: aload 4
    //   105: getfield 125	android/graphics/BitmapFactory$Options:outWidth	I
    //   108: invokestatic 140	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   111: aload 4
    //   113: getfield 128	android/graphics/BitmapFactory$Options:outHeight	I
    //   116: invokestatic 140	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   119: invokespecial 143	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   122: astore_0
    //   123: goto -34 -> 89
    //   126: astore_0
    //   127: getstatic 32	com/facebook/h/a:h	Landroid/support/v4/util/Pools$SynchronizedPool;
    //   130: aload_2
    //   131: invokevirtual 132	android/support/v4/util/Pools$SynchronizedPool:release	(Ljava/lang/Object;)Z
    //   134: pop
    //   135: aload_0
    //   136: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	paramInputStream	java.io.InputStream
    //   81	4	1	i	int
    //   20	111	2	localObject1	Object
    //   1	87	3	localObject2	Object
    //   16	96	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   48	65	126	finally
    //   67	82	126	finally
    //   99	123	126	finally
  }
  
  @Nullable
  public static Pair<Integer, Integer> a(byte[] paramArrayOfByte)
  {
    return a(new ByteArrayInputStream(paramArrayOfByte));
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/facebook/h/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */