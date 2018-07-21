package com.baidu.navisdk.ui.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.jar.JarUtils;

public class BNImageTextDialog
  extends Dialog
{
  private boolean isSupportDayNight = false;
  private LinearLayout mContentLayout;
  private TextView mFirstBtn;
  private boolean mFirstHasText;
  private TextView mMessage;
  private OnNaviClickListener mOnFirstBtnClickListener;
  private OnNaviClickListener mOnSecondBtnClickListener;
  private TextView mSecondBtn;
  private boolean mSecondHasText;
  private TextView mTitleBar;
  private ImageView mTopImageView;
  
  public BNImageTextDialog(Activity paramActivity)
  {
    super(paramActivity);
    Resources.Theme localTheme = JarUtils.getResources().newTheme();
    localTheme.applyStyle(1711996937, true);
    JarUtils.setDialogThemeField(this, localTheme);
    paramActivity = JarUtils.inflate(paramActivity, 1711472679, null);
    try
    {
      setContentView(paramActivity);
      this.mContentLayout = ((LinearLayout)paramActivity.findViewById(1711866131));
      this.mTopImageView = ((ImageView)paramActivity.findViewById(1711866130));
      this.mTitleBar = ((TextView)paramActivity.findViewById(1711866132));
      this.mMessage = ((TextView)paramActivity.findViewById(1711866133));
      this.mFirstBtn = ((TextView)paramActivity.findViewById(1711865896));
      this.mSecondBtn = ((TextView)paramActivity.findViewById(1711865897));
      this.mFirstBtn.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (BNImageTextDialog.this.mOnFirstBtnClickListener != null) {
            BNImageTextDialog.this.mOnFirstBtnClickListener.onClick();
          }
          BNImageTextDialog.this.dismiss();
        }
      });
      this.mSecondBtn.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (BNImageTextDialog.this.mOnSecondBtnClickListener != null) {
            BNImageTextDialog.this.mOnSecondBtnClickListener.onClick();
          }
          try
          {
            BNImageTextDialog.this.dismiss();
            return;
          }
          catch (Exception paramAnonymousView) {}
        }
      });
      this.mFirstHasText = false;
      this.mSecondHasText = false;
      this.mTitleBar.setVisibility(8);
      this.mMessage.setVisibility(8);
      this.mFirstBtn.setVisibility(8);
      this.mSecondBtn.setVisibility(8);
      setCanceledOnTouchOutside(false);
      return;
    }
    catch (Throwable paramActivity) {}
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
        this.mFirstBtn.setBackgroundDrawable(BNStyleManager.getDrawable(1711407147));
        return;
      }
      if ((!this.mFirstHasText) && (this.mSecondHasText))
      {
        this.mFirstBtn.setVisibility(8);
        this.mSecondBtn.setVisibility(0);
        this.mSecondBtn.setBackgroundDrawable(BNStyleManager.getDrawable(1711407147));
        return;
      }
    } while ((!this.mFirstHasText) || (!this.mSecondHasText));
    this.mFirstBtn.setVisibility(0);
    this.mSecondBtn.setVisibility(0);
    this.mFirstBtn.setBackgroundDrawable(BNStyleManager.getDrawable(1711407147));
    this.mSecondBtn.setBackgroundDrawable(BNStyleManager.getDrawable(1711407147));
  }
  
  private void setBtnVisible(boolean paramBoolean)
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
        this.mFirstBtn.setBackgroundDrawable(BNStyleManager.getDrawable(1711407147, paramBoolean));
        return;
      }
      if ((!this.mFirstHasText) && (this.mSecondHasText))
      {
        this.mFirstBtn.setVisibility(8);
        this.mSecondBtn.setVisibility(0);
        this.mSecondBtn.setBackgroundDrawable(BNStyleManager.getDrawable(1711407147, paramBoolean));
        return;
      }
    } while ((!this.mFirstHasText) || (!this.mSecondHasText));
    this.mFirstBtn.setVisibility(0);
    this.mSecondBtn.setVisibility(0);
    this.mFirstBtn.setBackgroundDrawable(BNStyleManager.getDrawable(1711407147, paramBoolean));
    this.mSecondBtn.setBackgroundDrawable(BNStyleManager.getDrawable(1711407147, paramBoolean));
  }
  
  private void updateDayStyle()
  {
    this.mTitleBar.setTextColor(JarUtils.getResources().getColor(1711800674));
    this.mMessage.setTextColor(JarUtils.getResources().getColor(1711800674));
    this.mFirstBtn.setTextColor(JarUtils.getResources().getColorStateList(1711800809));
    this.mSecondBtn.setTextColor(JarUtils.getResources().getColorStateList(1711800809));
    this.mFirstBtn.setBackgroundDrawable(JarUtils.getResources().getDrawable(1711407147));
    this.mSecondBtn.setBackgroundDrawable(JarUtils.getResources().getDrawable(1711407147));
  }
  
  public void dismiss()
  {
    this.mFirstHasText = false;
    this.mSecondHasText = false;
    super.dismiss();
  }
  
  public BNImageTextDialog enableBackKey(boolean paramBoolean)
  {
    super.setCancelable(paramBoolean);
    return this;
  }
  
  public BNImageTextDialog setBottomImageDrawable(Drawable paramDrawable)
  {
    this.mContentLayout.setBackgroundDrawable(paramDrawable);
    return this;
  }
  
  public BNImageTextDialog setContentMessage(String paramString)
  {
    if (paramString == null)
    {
      this.mMessage.setVisibility(8);
      this.mMessage.setText("", TextView.BufferType.SPANNABLE);
      return this;
    }
    this.mMessage.setVisibility(0);
    this.mMessage.setText(paramString, TextView.BufferType.SPANNABLE);
    return this;
  }
  
  public BNImageTextDialog setFirstBtnText(String paramString)
  {
    if (paramString == null)
    {
      this.mFirstHasText = false;
      this.mFirstBtn.setText("", TextView.BufferType.SPANNABLE);
    }
    for (;;)
    {
      setBtnVisible();
      return this;
      this.mFirstHasText = true;
      this.mFirstBtn.setText(paramString, TextView.BufferType.SPANNABLE);
    }
  }
  
  public BNImageTextDialog setFirstBtnText(boolean paramBoolean, String paramString)
  {
    if (paramString == null)
    {
      this.mFirstHasText = false;
      this.mFirstBtn.setText("", TextView.BufferType.SPANNABLE);
    }
    for (;;)
    {
      setBtnVisible(paramBoolean);
      return this;
      this.mFirstHasText = true;
      this.mFirstBtn.setText(paramString, TextView.BufferType.SPANNABLE);
    }
  }
  
  public BNImageTextDialog setOnFirstBtnClickListener(OnNaviClickListener paramOnNaviClickListener)
  {
    this.mOnFirstBtnClickListener = paramOnNaviClickListener;
    return this;
  }
  
  public BNImageTextDialog setOnSecondBtnClickListener(OnNaviClickListener paramOnNaviClickListener)
  {
    this.mOnSecondBtnClickListener = paramOnNaviClickListener;
    return this;
  }
  
  public BNImageTextDialog setSecondBtnChecked()
  {
    this.mSecondBtn.setSelected(true);
    return this;
  }
  
  public BNImageTextDialog setSecondBtnText(String paramString)
  {
    if (paramString == null)
    {
      this.mSecondHasText = false;
      this.mSecondBtn.setText("", TextView.BufferType.SPANNABLE);
    }
    for (;;)
    {
      setBtnVisible();
      return this;
      this.mSecondHasText = true;
      this.mSecondBtn.setText(paramString, TextView.BufferType.SPANNABLE);
    }
  }
  
  public BNImageTextDialog setSecondBtnText(boolean paramBoolean, String paramString)
  {
    if (paramString == null)
    {
      this.mSecondHasText = false;
      this.mSecondBtn.setText("", TextView.BufferType.SPANNABLE);
    }
    for (;;)
    {
      setBtnVisible(paramBoolean);
      return this;
      this.mSecondHasText = true;
      this.mSecondBtn.setText(paramString, TextView.BufferType.SPANNABLE);
    }
  }
  
  public BNImageTextDialog setTitleText(String paramString)
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
  
  public BNImageTextDialog setTopImageDrawable(Drawable paramDrawable)
  {
    this.mTopImageView.setVisibility(0);
    this.mTopImageView.setImageDrawable(paramDrawable);
    return this;
  }
  
  public void show()
  {
    if (this.isSupportDayNight) {
      updateStyle();
    }
    for (;;)
    {
      super.show();
      return;
      updateDayStyle();
    }
  }
  
  public void updateStyle()
  {
    this.isSupportDayNight = true;
    this.mTitleBar.setTextColor(BNStyleManager.getColor(1711800402));
    this.mMessage.setTextColor(BNStyleManager.getColor(1711800402));
    this.mFirstBtn.setTextColor(JarUtils.getResources().getColorStateList(1711800809));
    this.mSecondBtn.setTextColor(JarUtils.getResources().getColorStateList(1711800809));
    this.mFirstBtn.setBackgroundDrawable(BNStyleManager.getDrawable(1711407147));
    this.mSecondBtn.setBackgroundDrawable(BNStyleManager.getDrawable(1711407147));
  }
  
  public static abstract interface OnNaviClickListener
  {
    public abstract void onClick();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/widget/BNImageTextDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */