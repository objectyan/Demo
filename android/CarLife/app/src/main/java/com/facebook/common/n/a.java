package com.facebook.common.n;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import java.io.FileDescriptor;
import java.io.InputStream;

public abstract interface a
{
  public abstract Bitmap a(FileDescriptor paramFileDescriptor, Rect paramRect, BitmapFactory.Options paramOptions);
  
  public abstract Bitmap a(InputStream paramInputStream, Rect paramRect, BitmapFactory.Options paramOptions);
  
  public abstract Bitmap a(String paramString, BitmapFactory.Options paramOptions);
  
  public abstract Bitmap a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, BitmapFactory.Options paramOptions);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/common/n/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */