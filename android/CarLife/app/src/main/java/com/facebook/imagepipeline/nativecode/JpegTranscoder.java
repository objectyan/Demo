package com.facebook.imagepipeline.nativecode;

import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.internal.k;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@DoNotStrip
public class JpegTranscoder
{
  public static final int a = 0;
  public static final int b = 100;
  public static final int c = 1;
  public static final int d = 16;
  public static final int e = 8;
  
  static {}
  
  public static void a(InputStream paramInputStream, OutputStream paramOutputStream, int paramInt1, int paramInt2, int paramInt3)
    throws IOException
  {
    boolean bool2 = false;
    if (paramInt2 >= 1)
    {
      bool1 = true;
      k.a(bool1);
      if (paramInt2 > 16) {
        break label117;
      }
      bool1 = true;
      label25:
      k.a(bool1);
      if (paramInt3 < 0) {
        break label123;
      }
      bool1 = true;
      label38:
      k.a(bool1);
      if (paramInt3 > 100) {
        break label129;
      }
    }
    label117:
    label123:
    label129:
    for (boolean bool1 = true;; bool1 = false)
    {
      k.a(bool1);
      k.a(a(paramInt1));
      if (paramInt2 == 8)
      {
        bool1 = bool2;
        if (paramInt1 == 0) {}
      }
      else
      {
        bool1 = true;
      }
      k.a(bool1, "no transformation requested");
      nativeTranscodeJpeg((InputStream)k.a(paramInputStream), (OutputStream)k.a(paramOutputStream), paramInt1, paramInt2, paramInt3);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label25;
      bool1 = false;
      break label38;
    }
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt >= 0) && (paramInt <= 270) && (paramInt % 90 == 0);
  }
  
  @DoNotStrip
  private static native void nativeTranscodeJpeg(InputStream paramInputStream, OutputStream paramOutputStream, int paramInt1, int paramInt2, int paramInt3)
    throws IOException;
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/nativecode/JpegTranscoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */