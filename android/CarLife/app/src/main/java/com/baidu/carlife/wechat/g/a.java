package com.baidu.carlife.wechat.g;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import java.io.InputStream;
import java.lang.reflect.Field;

public class a
{
  public static int a(a parama1, a parama2)
  {
    int k = parama1.a;
    int m = parama1.b;
    int j = 1;
    int n = parama2.a;
    int i1 = parama2.b;
    int i = j;
    if (k > n)
    {
      i = j;
      if (m > i1) {
        i = Math.max(Math.round(k / n), Math.round(m / i1));
      }
    }
    return i;
  }
  
  private static int a(Object paramObject, String paramString)
  {
    int j = 0;
    try
    {
      paramString = ImageView.class.getDeclaredField(paramString);
      paramString.setAccessible(true);
      int k = paramString.getInt(paramObject);
      int i = j;
      if (k > 0)
      {
        i = j;
        if (k < Integer.MAX_VALUE) {
          i = k;
        }
      }
      return i;
    }
    catch (Exception paramObject)
    {
      ((Exception)paramObject).printStackTrace();
    }
    return 0;
  }
  
  public static Bitmap a(String paramString)
  {
    paramString = Base64.decode(paramString, 0);
    return BitmapFactory.decodeByteArray(paramString, 0, paramString.length);
  }
  
  public static a a(View paramView)
  {
    a locala = new a();
    locala.a = c(paramView);
    locala.b = b(paramView);
    return locala;
  }
  
  public static a a(InputStream paramInputStream)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeStream(paramInputStream, null, localOptions);
    return new a(localOptions.outWidth, localOptions.outHeight);
  }
  
  private static int b(View paramView)
  {
    int j = 0;
    if (paramView == null) {
      return 0;
    }
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    int i = j;
    if (localLayoutParams != null)
    {
      i = j;
      if (localLayoutParams.height != -2) {
        i = paramView.getWidth();
      }
    }
    j = i;
    if (i <= 0)
    {
      j = i;
      if (localLayoutParams != null) {
        j = localLayoutParams.height;
      }
    }
    i = j;
    if (j <= 0) {
      i = a(paramView, "mMaxHeight");
    }
    j = i;
    if (i <= 0) {
      j = paramView.getContext().getResources().getDisplayMetrics().heightPixels;
    }
    return j;
  }
  
  private static int c(View paramView)
  {
    int j = 0;
    if (paramView == null) {
      return 0;
    }
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    int i = j;
    if (localLayoutParams != null)
    {
      i = j;
      if (localLayoutParams.width != -2) {
        i = paramView.getWidth();
      }
    }
    j = i;
    if (i <= 0)
    {
      j = i;
      if (localLayoutParams != null) {
        j = localLayoutParams.width;
      }
    }
    i = j;
    if (j <= 0) {
      i = a(paramView, "mMaxWidth");
    }
    j = i;
    if (i <= 0) {
      j = paramView.getContext().getResources().getDisplayMetrics().widthPixels;
    }
    return j;
  }
  
  public static class a
  {
    int a;
    int b;
    
    public a() {}
    
    public a(int paramInt1, int paramInt2)
    {
      this.a = paramInt1;
      this.b = paramInt2;
    }
    
    public String toString()
    {
      return "ImageSize[width=" + this.a + ", height=" + this.b + ']';
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/wechat/g/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */