package com.baidu.navisdk.ui.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.jar.JarUtils;

public class BNBaseDialog
  extends Dialog
{
  protected boolean isSupportDayNight = false;
  private FrameLayout mContent;
  private TextView mFirstBtn;
  private boolean mFirstHasText;
  private OnNaviClickListener mOnFirstBtnClickListener;
  private OnNaviClickListener mOnSecondBtnClickListener;
  private TextView mSecondBtn;
  private boolean mSecondHasText;
  private TextView mTitleBar;
  private LinearLayout mTopContentLayout;
  
  public BNBaseDialog(Activity paramActivity)
  {
    super(paramActivity);
    Resources.Theme localTheme = JarUtils.getResources().newTheme();
    localTheme.applyStyle(1711996937, true);
    JarUtils.setDialogThemeField(this, localTheme);
    paramActivity = JarUtils.inflate(paramActivity, 1711472669, null);
    setContentView(paramActivity);
    this.mTopContentLayout = ((LinearLayout)paramActivity.findViewById(1711865892));
    this.mTitleBar = ((TextView)paramActivity.findViewById(1711865893));
    this.mContent = ((FrameLayout)paramActivity.findViewById(1711866080));
    this.mFirstBtn = ((TextView)paramActivity.findViewById(1711865896));
    this.mSecondBtn = ((TextView)paramActivity.findViewById(1711865897));
    this.mFirstBtn.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (BNBaseDialog.this.mOnFirstBtnClickListener != null) {
          BNBaseDialog.this.mOnFirstBtnClickListener.onClick();
        }
        BNBaseDialog.this.dismiss();
      }
    });
    this.mSecondBtn.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (BNBaseDialog.this.mOnSecondBtnClickListener != null) {
          BNBaseDialog.this.mOnSecondBtnClickListener.onClick();
        }
        BNBaseDialog.this.dismiss();
      }
    });
    this.mFirstHasText = false;
    this.mSecondHasText = false;
    this.mTitleBar.setVisibility(8);
    this.mFirstBtn.setVisibility(8);
    this.mSecondBtn.setVisibility(8);
    setCanceledOnTouchOutside(false);
    updateDayStyle();
  }
  
  private void setBtnVisible()
  {
    if ((!this.mFirstHasText) && (!this.mSecondHasText))
    {
      this.mFirstBtn.setVisibility(8);
      this.mSecondBtn.setVisibility(8);
    }
    do
    {
      return;
      if ((!this.mSecondHasText) && (this.mFirstHasText))
      {
        this.mFirstBtn.setVisibility(0);
        this.mSecondBtn.setVisibility(8);
        this.mFirstBtn.setBackgroundDrawable(BNStyleManager.getDrawable(1711407371));
        return;
      }
      if ((!this.mFirstHasText) && (this.mSecondHasText))
      {
        this.mFirstBtn.setVisibility(8);
        this.mSecondBtn.setVisibility(0);
        this.mSecondBtn.setBackgroundDrawable(BNStyleManager.getDrawable(1711407371));
        return;
      }
    } while ((!this.mFirstHasText) || (!this.mSecondHasText));
    this.mFirstBtn.setVisibility(0);
    this.mSecondBtn.setVisibility(0);
    this.mFirstBtn.setBackgroundDrawable(BNStyleManager.getDrawable(1711407372));
    this.mSecondBtn.setBackgroundDrawable(BNStyleManager.getDrawable(1711407375));
  }
  
  private void updateDayStyle()
  {
    this.mTopContentLayout.setBackgroundDrawable(JarUtils.getResources().getDrawable(1711407509));
    this.mTitleBar.setTextColor(JarUtils.getResources().getColor(1711800402));
    if ((this.mFirstHasText) && (this.mSecondHasText))
    {
      this.mFirstBtn.setBackgroundDrawable(JarUtils.getResources().getDrawable(1711407372));
      this.mSecondBtn.setBackgroundDrawable(JarUtils.getResources().getDrawable(1711407375));
    }
    do
    {
      return;
      if ((!this.mFirstHasText) && (this.mSecondHasText))
      {
        this.mSecondBtn.setBackgroundDrawable(JarUtils.getResources().getDrawable(1711407371));
        return;
      }
    } while ((this.mSecondHasText) || (!this.mFirstHasText));
    this.mFirstBtn.setBackgroundDrawable(JarUtils.getResources().getDrawable(1711407371));
  }
  
  public void dismiss()
  {
    this.mFirstHasText = false;
    this.mSecondHasText = false;
    try
    {
      super.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
  
  public BNBaseDialog enableBackKey(boolean paramBoolean)
  {
    super.setCancelable(paramBoolean);
    return this;
  }
  
  public BNBaseDialog setContent(View paramView)
  {
    if (this.mContent != null)
    {
      this.mContent.removeAllViews();
      this.mContent.addView(paramView);
    }
    return this;
  }
  
  public BNBaseDialog setContentHeight(int paramInt)
  {
    ViewGroup.LayoutParams localLayoutParams = this.mContent.getLayoutParams();
    localLayoutParams.height = paramInt;
    this.mContent.setLayoutParams(localLayoutParams);
    return this;
  }
  
  public BNBaseDialog setContentWidth(int paramInt)
  {
    ViewGroup.LayoutParams localLayoutParams = this.mContent.getLayoutParams();
    localLayoutParams.width = paramInt;
    this.mContent.setLayoutParams(localLayoutParams);
    return this;
  }
  
  public BNBaseDialog setFirstBtnEnabled(boolean paramBoolean)
  {
    this.mFirstBtn.setEnabled(paramBoolean);
    return this;
  }
  
  public BNBaseDialog setFirstBtnText(String paramString)
  {
    if (paramString == null)
    {
      this.mFirstHasText = false;
      this.mFirstBtn.setText("", TextView.BufferType.SPANNABLE);
    }
    for (;;)
    {
      setBtnVisible();
      this.mFirstBtn.setTextColor(BNStyleManager.getColor(1711800406));
      return this;
      this.mFirstHasText = true;
      this.mFirstBtn.setText(paramString, TextView.BufferType.SPANNABLE);
    }
  }
  
  public BNBaseDialog setOnFirstBtnClickListener(OnNaviClickListener paramOnNaviClickListener)
  {
    this.mOnFirstBtnClickListener = paramOnNaviClickListener;
    return this;
  }
  
  public BNBaseDialog setOnSecondBtnClickListener(OnNaviClickListener paramOnNaviClickListener)
  {
    this.mOnSecondBtnClickListener = paramOnNaviClickListener;
    return this;
  }
  
  public BNBaseDialog setSecondBtnEnabled(boolean paramBoolean)
  {
    this.mSecondBtn.setEnabled(paramBoolean);
    return this;
  }
  
  public BNBaseDialog setSecondBtnText(String paramString)
  {
    if (paramString == null)
    {
      this.mSecondHasText = false;
      this.mSecondBtn.setText("", TextView.BufferType.SPANNABLE);
    }
    for (;;)
    {
      setBtnVisible();
      this.mSecondBtn.setTextColor(BNStyleManager.getColor(1711800406));
      return this;
      this.mSecondHasText = true;
      this.mSecondBtn.setText(paramString, TextView.BufferType.SPANNABLE);
    }
  }
  
  public BNBaseDialog setTitleText(String paramString)
  {
    if (paramString == null)
    {
      this.mTitleBar.setVisibility(8);
      this.mTitleBar.setText("", TextView.BufferType.SPANNABLE);
      return this;
    }
    this.mTitleBar.setVisibility(0);
    this.mTitleBar.setText(paramString, TextView.BufferType.SPANNABLE);
    return this;
  }
  
  public void show()
  {
    if (this.isSupportDayNight) {
      updateStyle();
    }
    for (;;)
    {
      try
      {
        super.show();
        return;
      }
      catch (Exception localException) {}
      updateDayStyle();
    }
  }
  
  public void updateStyle()
  {
    this.isSupportDayNight = true;
    this.mTopContentLayout.setBackgroundDrawable(BNStyleManager.getDrawable(1711407509));
    this.mTitleBar.setTextColor(BNStyleManager.getColor(1711800402));
    if ((this.mFirstHasText) && (this.mSecondHasText))
    {
      this.mFirstBtn.setBackgroundDrawable(BNStyleManager.getDrawable(1711407372));
      this.mSecondBtn.setBackgroundDrawable(BNStyleManager.getDrawable(1711407375));
    }
    do
    {
      return;
      if ((!this.mFirstHasText) && (this.mSecondHasText))
      {
        this.mSecondBtn.setBackgroundDrawable(BNStyleManager.getDrawable(1711407371));
        return;
      }
    } while ((this.mSecondHasText) || (!this.mFirstHasText));
    this.mFirstBtn.setBackgroundDrawable(BNStyleManager.getDrawable(1711407371));
  }
  
  public static abstract interface OnNaviClickListener
  {
    public abstract void onClick();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/widget/BNBaseDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */