package com.baidu.navisdk.ui.util;

import android.graphics.Paint;
import android.os.Build.VERSION;
import android.text.DynamicLayout;
import android.text.Layout.Alignment;
import android.text.TextPaint;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.navisdk.util.common.LogUtil;

public class UIUtils
{
  private static final String TAG = "UIUtils";
  
  public static boolean isTextFullDisplay(TextView paramTextView, int paramInt, String paramString)
  {
    return paramInt >= paramTextView.getPaint().measureText(paramString);
  }
  
  public static boolean isTextFullDisplay(TextView paramTextView, int paramInt1, String paramString, int paramInt2)
  {
    if (paramInt1 < 0)
    {
      LogUtil.e("UiUtil", "isTextFullDisplay viewWidth < 0");
      LogUtil.printCallStatck();
      return true;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramTextView = new DynamicLayout(paramString, paramTextView.getPaint(), paramInt1, Layout.Alignment.ALIGN_NORMAL, paramTextView.getLineSpacingMultiplier(), paramTextView.getLineSpacingExtra(), paramTextView.getIncludeFontPadding());
      if (paramTextView.getLineCount() > paramInt2) {
        break label90;
      }
    }
    label90:
    for (boolean bool = true;; bool = false)
    {
      return bool;
      paramTextView = new DynamicLayout(paramString, paramTextView.getPaint(), paramInt1, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
      break;
    }
  }
  
  public static int mearsureTextWidth(TextView paramTextView, String paramString)
  {
    paramTextView = paramTextView.getPaint();
    if (paramTextView == null) {
      return -1;
    }
    return (int)paramTextView.measureText(paramString);
  }
  
  public static void releaseImageView(ImageView paramImageView)
  {
    if (paramImageView != null) {}
    try
    {
      paramImageView.setImageBitmap(null);
      paramImageView.setBackgroundResource(17170445);
      paramImageView.setBackgroundDrawable(null);
      return;
    }
    catch (Exception paramImageView)
    {
      LogUtil.e("UIUtils", "releaseImageView Exception :" + paramImageView.getMessage());
    }
  }
  
  public static void releaseImageViewWithoutNull(ImageView paramImageView)
  {
    if (paramImageView != null) {}
    try
    {
      paramImageView.setImageBitmap(null);
      paramImageView.setBackgroundResource(17170445);
      paramImageView.setBackgroundDrawable(null);
      return;
    }
    catch (Exception paramImageView)
    {
      LogUtil.e("UIUtils", "releaseImageView Exception :" + paramImageView.getMessage());
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/util/UIUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */