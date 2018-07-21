package com.facebook.imagepipeline.k;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.support.v4.util.Pools.SynchronizedPool;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.internal.k;
import com.facebook.common.k.b;
import java.io.InputStream;
import java.nio.ByteBuffer;
import javax.annotation.concurrent.ThreadSafe;

@TargetApi(21)
@ThreadSafe
public class a
  implements e
{
  private static final int b = 16384;
  private static final byte[] d = { -1, -39 };
  @VisibleForTesting
  final Pools.SynchronizedPool<ByteBuffer> a;
  private final com.facebook.imagepipeline.memory.d c;
  
  public a(com.facebook.imagepipeline.memory.d paramd, int paramInt, Pools.SynchronizedPool paramSynchronizedPool)
  {
    this.c = paramd;
    this.a = paramSynchronizedPool;
    int i = 0;
    while (i < paramInt)
    {
      this.a.release(ByteBuffer.allocate(16384));
      i += 1;
    }
  }
  
  private static BitmapFactory.Options b(com.facebook.imagepipeline.i.d paramd, Bitmap.Config paramConfig)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inSampleSize = paramd.i();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeStream(paramd.d(), null, localOptions);
    if ((localOptions.outWidth == -1) || (localOptions.outHeight == -1)) {
      throw new IllegalArgumentException();
    }
    localOptions.inJustDecodeBounds = false;
    localOptions.inDither = true;
    localOptions.inPreferredConfig = paramConfig;
    localOptions.inMutable = true;
    return localOptions;
  }
  
  public com.facebook.common.h.a<Bitmap> a(com.facebook.imagepipeline.i.d paramd, Bitmap.Config paramConfig)
  {
    paramConfig = b(paramd, paramConfig);
    if (paramConfig.inPreferredConfig != Bitmap.Config.ARGB_8888) {}
    for (i = 1;; i = 0) {
      try
      {
        paramConfig = a(paramd.d(), paramConfig);
        return paramConfig;
      }
      catch (RuntimeException paramConfig)
      {
        if (i == 0) {
          break;
        }
        return a(paramd, Bitmap.Config.ARGB_8888);
        throw paramConfig;
      }
    }
  }
  
  public com.facebook.common.h.a<Bitmap> a(com.facebook.imagepipeline.i.d paramd, Bitmap.Config paramConfig, int paramInt)
  {
    boolean bool = paramd.f(paramInt);
    BitmapFactory.Options localOptions = b(paramd, paramConfig);
    paramConfig = paramd.d();
    k.a(paramConfig);
    if (paramd.j() > paramInt) {
      paramConfig = new com.facebook.common.k.a(paramConfig, paramInt);
    }
    for (;;)
    {
      if (!bool) {
        paramConfig = new b(paramConfig, d);
      }
      for (;;)
      {
        if (localOptions.inPreferredConfig != Bitmap.Config.ARGB_8888) {}
        for (paramInt = 1;; paramInt = 0) {
          try
          {
            paramConfig = a(paramConfig, localOptions);
            return paramConfig;
          }
          catch (RuntimeException paramConfig)
          {
            if (paramInt == 0) {
              break;
            }
            return a(paramd, Bitmap.Config.ARGB_8888);
            throw paramConfig;
          }
        }
      }
    }
  }
  
  protected com.facebook.common.h.a<Bitmap> a(InputStream paramInputStream, BitmapFactory.Options paramOptions)
  {
    k.a(paramInputStream);
    int i = com.facebook.h.a.a(paramOptions.outWidth, paramOptions.outHeight, paramOptions.inPreferredConfig);
    Bitmap localBitmap = (Bitmap)this.c.a(i);
    if (localBitmap == null) {
      throw new NullPointerException("BitmapPool.get returned null");
    }
    paramOptions.inBitmap = localBitmap;
    ByteBuffer localByteBuffer2 = (ByteBuffer)this.a.acquire();
    ByteBuffer localByteBuffer1 = localByteBuffer2;
    if (localByteBuffer2 == null) {
      localByteBuffer1 = ByteBuffer.allocate(16384);
    }
    try
    {
      paramOptions.inTempStorage = localByteBuffer1.array();
      paramInputStream = BitmapFactory.decodeStream(paramInputStream, null, paramOptions);
      this.a.release(localByteBuffer1);
      if (localBitmap != paramInputStream)
      {
        this.c.a(localBitmap);
        paramInputStream.recycle();
        throw new IllegalStateException();
      }
    }
    catch (RuntimeException paramInputStream)
    {
      this.c.a(localBitmap);
      throw paramInputStream;
    }
    finally
    {
      this.a.release(localByteBuffer1);
    }
    return com.facebook.common.h.a.a(paramInputStream, this.c);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/k/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */