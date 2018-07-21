package com.facebook.imagepipeline.nativecode;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.internal.k;
import java.nio.ByteBuffer;

@DoNotStrip
public class Bitmaps
{
  static {}
  
  public static ByteBuffer a(Bitmap paramBitmap, long paramLong1, long paramLong2)
  {
    k.a(paramBitmap);
    return nativeGetByteBuffer(paramBitmap, paramLong1, paramLong2);
  }
  
  public static void a(Bitmap paramBitmap)
  {
    k.a(paramBitmap);
    nativePinBitmap(paramBitmap);
  }
  
  @TargetApi(19)
  public static void a(Bitmap paramBitmap, int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    if (paramBitmap.getAllocationByteCount() >= paramInt1 * paramInt2 * com.facebook.h.a.a(paramConfig)) {}
    for (boolean bool = true;; bool = false)
    {
      k.a(bool);
      paramBitmap.reconfigure(paramInt1, paramInt2, paramConfig);
      return;
    }
  }
  
  public static void a(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    boolean bool2 = true;
    if (paramBitmap2.getConfig() == paramBitmap1.getConfig())
    {
      bool1 = true;
      k.a(bool1);
      k.a(paramBitmap1.isMutable());
      if (paramBitmap1.getWidth() != paramBitmap2.getWidth()) {
        break label83;
      }
      bool1 = true;
      label39:
      k.a(bool1);
      if (paramBitmap1.getHeight() != paramBitmap2.getHeight()) {
        break label88;
      }
    }
    label83:
    label88:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      k.a(bool1);
      nativeCopyBitmap(paramBitmap1, paramBitmap1.getRowBytes(), paramBitmap2, paramBitmap2.getRowBytes(), paramBitmap1.getHeight());
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label39;
    }
  }
  
  public static void b(Bitmap paramBitmap)
  {
    k.a(paramBitmap);
    nativeReleaseByteBuffer(paramBitmap);
  }
  
  @DoNotStrip
  private static native void nativeCopyBitmap(Bitmap paramBitmap1, int paramInt1, Bitmap paramBitmap2, int paramInt2, int paramInt3);
  
  @DoNotStrip
  private static native ByteBuffer nativeGetByteBuffer(Bitmap paramBitmap, long paramLong1, long paramLong2);
  
  @DoNotStrip
  private static native void nativePinBitmap(Bitmap paramBitmap);
  
  @DoNotStrip
  private static native void nativeReleaseByteBuffer(Bitmap paramBitmap);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/nativecode/Bitmaps.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */