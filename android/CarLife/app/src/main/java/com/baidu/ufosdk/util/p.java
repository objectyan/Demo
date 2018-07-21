package com.baidu.ufosdk.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import com.baidu.ufosdk.a;
import java.io.IOException;

public final class p
{
  public static Bitmap a(Context paramContext, String paramString)
  {
    try
    {
      paramContext = i.a(paramContext.getAssets().open("ufo_res/" + paramString));
      paramContext = BitmapFactory.decodeByteArray(paramContext, 0, paramContext.length, null);
      return paramContext;
    }
    catch (IOException paramContext)
    {
      c.a("bmpProblemIcon fail", paramContext);
    }
    return null;
  }
  
  public static StateListDrawable a(Context paramContext, int paramInt, String paramString)
  {
    StateListDrawable localStateListDrawable = new StateListDrawable();
    ColorDrawable localColorDrawable = new ColorDrawable(paramInt);
    paramContext = new BitmapDrawable(a(paramContext, paramString));
    localStateListDrawable.addState(new int[] { 16842919 }, paramContext);
    localStateListDrawable.addState(new int[0], localColorDrawable);
    return localStateListDrawable;
  }
  
  public static StateListDrawable a(Context paramContext, String paramString1, String paramString2)
  {
    StateListDrawable localStateListDrawable = new StateListDrawable();
    try
    {
      paramString2 = r.a(paramContext, paramString2);
      localStateListDrawable.addState(new int[] { 16842919 }, paramString2);
      if (paramString1 != null)
      {
        paramContext = r.a(paramContext, paramString1);
        localStateListDrawable.addState(new int[0], paramContext);
      }
      return localStateListDrawable;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return localStateListDrawable;
  }
  
  public static byte[] a(Context paramContext)
  {
    try
    {
      paramContext = i.a(paramContext.getAssets().open("ufo_res/ufo_addpic_icon.png"));
      return paramContext;
    }
    catch (IOException paramContext)
    {
      c.a("bmpProblemIcon fail", paramContext);
    }
    return null;
  }
  
  public static byte[] b(Context paramContext)
  {
    try
    {
      paramContext = i.a(paramContext.getAssets().open("ufo_res/ufo_addpicplus_icon.png"));
      return paramContext;
    }
    catch (IOException paramContext)
    {
      c.a("bmpProblemIcon fail", paramContext);
    }
    return null;
  }
  
  public static Bitmap c(Context paramContext)
  {
    if (a.e != null) {
      return a.e;
    }
    try
    {
      paramContext = i.a(paramContext.getAssets().open("ufo_res/ufo_defult_me_icon.png"));
      paramContext = BitmapFactory.decodeByteArray(paramContext, 0, paramContext.length, null);
      return paramContext;
    }
    catch (IOException paramContext)
    {
      c.a("bmpProblemIcon fail", paramContext);
    }
    return null;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/util/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */