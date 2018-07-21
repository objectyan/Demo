package com.baidu.navi.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.net.Uri;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import com.baidu.carlife.BaiduNaviApplication;
import com.baidu.navisdk.ui.util.TipTool;
import java.io.InputStream;

public class Tools
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
      Bitmap localBitmap = BitmapFactory.decodeResource(BaiduNaviApplication.getInstance().getResources(), paramInt);
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
  
  public static String getRealUrl(String paramString)
  {
    return "https://vehicle.baidu.com" + paramString;
  }
  
  public static void goMarket()
  {
    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + BaiduNaviApplication.getInstance().getPackageName()));
    localIntent.addFlags(268435456);
    try
    {
      BaiduNaviApplication.getInstance().startActivity(localIntent);
      return;
    }
    catch (Exception localException)
    {
      TipTool.onCreateToastDialog(BaiduNaviApplication.getInstance(), "您还没有安装google play，请先安装google play。");
      localException.printStackTrace();
    }
  }
  
  public static void softInputHide(Activity paramActivity, Context paramContext)
  {
    try
    {
      paramContext = (InputMethodManager)paramActivity.getSystemService("input_method");
      if (paramContext != null) {
        paramContext.hideSoftInputFromWindow(paramActivity.getWindow().getDecorView().getWindowToken(), 0);
      }
      return;
    }
    catch (Exception paramActivity)
    {
      paramActivity.printStackTrace();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/utils/Tools.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */