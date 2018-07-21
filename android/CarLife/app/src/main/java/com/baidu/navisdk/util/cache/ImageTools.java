package com.baidu.navisdk.util.cache;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import com.baidu.navisdk.util.jar.JarUtils;
import java.io.InputStream;

public class ImageTools
{
  public static Rect calcSquareRect(Rect paramRect)
  {
    int k = paramRect.right - paramRect.left;
    int i = paramRect.bottom - paramRect.top;
    int j = Math.min(k, i);
    k = (k - j) / 2;
    i = (i - j) / 2;
    if (k == 0)
    {
      paramRect.top += i;
      paramRect.bottom -= i;
      return paramRect;
    }
    paramRect.left += k;
    paramRect.right -= k;
    return paramRect;
  }
  
  public static Bitmap getBitmapFromByteArray(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length);
      return paramArrayOfByte;
    }
    catch (OutOfMemoryError paramArrayOfByte) {}
    return null;
  }
  
  public static Bitmap getBitmapFromPath(String paramString)
  {
    try
    {
      paramString = BitmapFactory.decodeFile(paramString);
      return paramString;
    }
    catch (OutOfMemoryError paramString) {}
    return null;
  }
  
  public static Bitmap getBitmapFromResId(int paramInt)
  {
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeResource(JarUtils.getResources(), paramInt);
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
    return null;
  }
  
  public static Bitmap getBitmapFromStream(InputStream paramInputStream)
  {
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeStream(paramInputStream);
      try
      {
        paramInputStream.close();
        return localBitmap;
      }
      catch (Exception paramInputStream)
      {
        paramInputStream.printStackTrace();
        return localBitmap;
      }
      try
      {
        paramInputStream.close();
        throw ((Throwable)localObject);
      }
      catch (Exception paramInputStream)
      {
        for (;;)
        {
          paramInputStream.printStackTrace();
        }
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError = localOutOfMemoryError;
      try
      {
        paramInputStream.close();
        return null;
      }
      catch (Exception paramInputStream)
      {
        paramInputStream.printStackTrace();
        return null;
      }
    }
    finally
    {
      localObject = finally;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/cache/ImageTools.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */