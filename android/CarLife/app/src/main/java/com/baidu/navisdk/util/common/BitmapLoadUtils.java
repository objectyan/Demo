package com.baidu.navisdk.util.common;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.InputStream;

public class BitmapLoadUtils
{
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
  
  public static Bitmap getBitmapFromResId(Resources paramResources, int paramInt)
  {
    try
    {
      paramResources = BitmapFactory.decodeResource(paramResources, paramInt);
      return paramResources;
    }
    catch (OutOfMemoryError paramResources) {}
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


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/common/BitmapLoadUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */