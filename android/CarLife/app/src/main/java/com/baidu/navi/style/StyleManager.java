package com.baidu.navi.style;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LayoutAnimationController;
import com.baidu.carlife.BaiduNaviApplication;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.ui.util.BNStyleManager;

public class StyleManager
{
  public static final String SUFFIX_DAY_MODEL = "";
  public static final String SUFFIX_NIGHT_MODEL = "_night";
  private static Context mAppContext = BaiduNaviApplication.getInstance();
  private static boolean mDayStyle = true;
  private static String mPackageName = BaiduNaviApplication.getInstance().getPackageName();
  private static boolean mRealDayStyle = true;
  private static SparseIntArray mResIdMap = new SparseIntArray();
  private static Resources mResources = BaiduNaviApplication.getInstance().getResources();
  
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
    return getColor(paramInt, mDayStyle);
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
  
  public static int getDayColor(int paramInt)
  {
    if (mResources == null) {
      return 0;
    }
    try
    {
      paramInt = mResources.getColor(paramInt);
      return paramInt;
    }
    catch (Resources.NotFoundException localNotFoundException) {}
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
    label38:
    try
    {
      localObject = mResources.getDrawable(i);
      return (Drawable)localObject;
    }
    catch (Resources.NotFoundException localNotFoundException) {}
    Object localObject = getResourceNameById(paramInt);
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
    catch (Resources.NotFoundException localNotFoundException) {}
    return "";
  }
  
  public static String getString(int paramInt, Object... paramVarArgs)
  {
    if (mResources == null) {
      return "";
    }
    try
    {
      String str1 = mResources.getString(paramInt);
      if ((str1.length() == 0) || (str1 == null)) {
        return str1;
      }
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      String str2;
      for (;;)
      {
        str2 = "";
      }
      return String.format(str2, paramVarArgs);
    }
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
  
  public static View inflate(int paramInt, ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(mAppContext).inflate(paramInt, paramViewGroup);
  }
  
  public static boolean isUsingMapMode()
  {
    return BNSettingManager.getCurrentUsingMode() == 1;
  }
  
  public static Animation loadAnimation(int paramInt)
  {
    return AnimationUtils.loadAnimation(mAppContext, paramInt);
  }
  
  public static Interpolator loadInterpolator(int paramInt)
  {
    return AnimationUtils.loadInterpolator(mAppContext, paramInt);
  }
  
  public static LayoutAnimationController loadLayoutAnimation(int paramInt)
  {
    return AnimationUtils.loadLayoutAnimation(mAppContext, paramInt);
  }
  
  public static void setDayStyle(boolean paramBoolean)
  {
    mResIdMap.clear();
    mDayStyle = paramBoolean;
    mRealDayStyle = paramBoolean;
    if (!isUsingMapMode()) {
      mDayStyle = false;
    }
    BNStyleManager.setDayStyle(mDayStyle);
  }
  
  public static void setResource(Resources paramResources)
  {
    mResources = paramResources;
  }
  
  public static void switchToCarMode()
  {
    BNStyleManager.switchToCarMode();
    mDayStyle = false;
  }
  
  public static void switchToMapMode()
  {
    if (mDayStyle != mRealDayStyle) {
      mDayStyle = mRealDayStyle;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/style/StyleManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */