package com.baidu.navisdk.ui.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LayoutAnimationController;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.util.jar.JarUtils;

public class BNStyleManager
{
  public static final String SUFFIX_DAY_MODEL = "";
  public static final String SUFFIX_NIGHT_MODEL = "_night";
  private static boolean mDayStyle = false;
  private static String mPackageName = "com.baidu.navisdk";
  private static boolean mRealDayStyle = true;
  private static SparseIntArray mResIdMap;
  private static Resources mResources;
  
  static
  {
    mPackageName = "com.baidu.navisdk";
    mResIdMap = new SparseIntArray();
    mResources = JarUtils.getResources();
  }
  
  public static void clearCacheResId()
  {
    mResIdMap.clear();
  }
  
  public static Bitmap getBitmap(int paramInt)
  {
    if (mResources == null) {
      return null;
    }
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeResource(mResources, paramInt);
      return localBitmap;
    }
    catch (Resources.NotFoundException localNotFoundException) {}
    return null;
  }
  
  public static boolean getBoolean(int paramInt)
  {
    if (mResources == null) {
      return false;
    }
    try
    {
      boolean bool = mResources.getBoolean(paramInt);
      return bool;
    }
    catch (Resources.NotFoundException localNotFoundException) {}
    return false;
  }
  
  public static int getColor(int paramInt)
  {
    return getColor(paramInt, mRealDayStyle);
  }
  
  public static int getColor(int paramInt, boolean paramBoolean)
  {
    if (mResources == null) {
      return 0;
    }
    int i = paramInt;
    if (!paramBoolean)
    {
      i = mResIdMap.get(paramInt, -1);
      if (i == -1) {
        break label38;
      }
    }
    label38:
    try
    {
      paramInt = mResources.getColor(i);
      return paramInt;
    }
    catch (Resources.NotFoundException localNotFoundException) {}
    String str = getResourceNameById(paramInt);
    str = str + getSuffix(paramBoolean);
    i = mResources.getIdentifier(str, "color", mPackageName);
    if (i != 0) {
      mResIdMap.put(paramInt, i);
    }
    if (i == 0) {}
    for (;;)
    {
      i = paramInt;
      break;
      paramInt = i;
    }
    return 0;
  }
  
  public static boolean getDayStyle()
  {
    return mDayStyle;
  }
  
  public static int getDimension(int paramInt)
  {
    if (mResources == null) {
      return 0;
    }
    try
    {
      float f = mResources.getDimension(paramInt);
      return (int)f;
    }
    catch (Resources.NotFoundException localNotFoundException) {}
    return 0;
  }
  
  public static Drawable getDrawable(int paramInt)
  {
    return getDrawable(paramInt, mDayStyle);
  }
  
  public static Drawable getDrawable(int paramInt, boolean paramBoolean)
  {
    if (mResources == null) {
      return null;
    }
    int i = paramInt;
    if (!paramBoolean)
    {
      i = mResIdMap.get(paramInt, -1);
      if (i == -1) {
        break label38;
      }
    }
    try
    {
      localObject = mResources.getDrawable(i);
      return (Drawable)localObject;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      Object localObject;
      label38:
      return null;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
    localObject = getResourceNameById(paramInt);
    localObject = (String)localObject + getSuffix(paramBoolean);
    i = mResources.getIdentifier((String)localObject, "drawable", mPackageName);
    if (i != 0) {
      mResIdMap.put(paramInt, i);
    }
    if (i == 0) {}
    for (;;)
    {
      i = paramInt;
      break;
      paramInt = i;
    }
    return null;
  }
  
  public static boolean getRealDayStyle()
  {
    return mRealDayStyle;
  }
  
  public static Drawable getRealDrawable(int paramInt)
  {
    return getDrawable(paramInt, mRealDayStyle);
  }
  
  private static String getResourceNameById(int paramInt)
  {
    String str = "";
    if (mResources != null) {}
    try
    {
      str = mResources.getResourceEntryName(paramInt);
      return str;
    }
    catch (Resources.NotFoundException localNotFoundException) {}
    return "";
  }
  
  public static String getString(int paramInt)
  {
    if (mResources == null) {
      return "";
    }
    try
    {
      String str = mResources.getString(paramInt);
      return str;
    }
    catch (Exception localException) {}
    return "";
  }
  
  public static String[] getStringArray(int paramInt)
  {
    if (mResources == null) {
      return null;
    }
    try
    {
      String[] arrayOfString = mResources.getStringArray(paramInt);
      return arrayOfString;
    }
    catch (Resources.NotFoundException localNotFoundException) {}
    return null;
  }
  
  private static String getSuffix(boolean paramBoolean)
  {
    String str = "";
    if (!paramBoolean) {
      str = "_night";
    }
    return str;
  }
  
  public static View inflate(Activity paramActivity, int paramInt, ViewGroup paramViewGroup)
  {
    return JarUtils.inflate(paramActivity, paramInt, paramViewGroup);
  }
  
  public static boolean isUsingMapMode()
  {
    return BNSettingManager.getCurrentUsingMode() == 1;
  }
  
  public static Animation loadAnimation(Context paramContext, int paramInt)
  {
    return JarUtils.loadAnimation(paramContext, paramInt);
  }
  
  public static Interpolator loadInterpolator(Context paramContext, int paramInt)
  {
    return JarUtils.loadInterpolator(paramContext, paramInt);
  }
  
  public static LayoutAnimationController loadLayoutAnimation(Context paramContext, int paramInt)
  {
    return JarUtils.loadLayoutAnimation(paramContext, paramInt);
  }
  
  public static void setDayStyle(boolean paramBoolean)
  {
    mResIdMap.clear();
    mDayStyle = paramBoolean;
    mRealDayStyle = paramBoolean;
  }
  
  public static void setResource(Resources paramResources)
  {
    mResources = paramResources;
  }
  
  public static void switchToCarMode()
  {
    mDayStyle = false;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/util/BNStyleManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */