package com.facebook.imagepipeline.k;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.facebook.common.h.a;
import com.facebook.imagepipeline.memory.y;
import javax.annotation.concurrent.ThreadSafe;

@TargetApi(19)
@ThreadSafe
public class d
  extends b
{
  private final com.facebook.imagepipeline.memory.k b;
  
  public d(com.facebook.imagepipeline.memory.k paramk)
  {
    this.b = paramk;
  }
  
  private static void a(byte[] paramArrayOfByte, int paramInt)
  {
    paramArrayOfByte[paramInt] = -1;
    paramArrayOfByte[(paramInt + 1)] = -39;
  }
  
  protected Bitmap a(a<y> parama, int paramInt, BitmapFactory.Options paramOptions)
  {
    boolean bool = false;
    if (a(parama, paramInt)) {}
    for (byte[] arrayOfByte1 = null;; arrayOfByte1 = a)
    {
      y localy = (y)parama.a();
      if (paramInt <= localy.a()) {
        bool = true;
      }
      com.facebook.common.internal.k.a(bool);
      parama = this.b.a(paramInt + 2);
      try
      {
        byte[] arrayOfByte2 = (byte[])parama.a();
        localy.a(0, arrayOfByte2, 0, paramInt);
        int i = paramInt;
        if (arrayOfByte1 != null)
        {
          a(arrayOfByte2, paramInt);
          i = paramInt + 2;
        }
        paramOptions = (Bitmap)com.facebook.common.internal.k.a(BitmapFactory.decodeByteArray(arrayOfByte2, 0, i, paramOptions), "BitmapFactory returned null");
        return paramOptions;
      }
      finally
      {
        a.c(parama);
      }
    }
  }
  
  protected Bitmap a(a<y> parama, BitmapFactory.Options paramOptions)
  {
    y localy = (y)parama.a();
    int i = localy.a();
    parama = this.b.a(i);
    try
    {
      byte[] arrayOfByte = (byte[])parama.a();
      localy.a(0, arrayOfByte, 0, i);
      paramOptions = (Bitmap)com.facebook.common.internal.k.a(BitmapFactory.decodeByteArray(arrayOfByte, 0, i, paramOptions), "BitmapFactory returned null");
      return paramOptions;
    }
    finally
    {
      a.c(parama);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/k/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */