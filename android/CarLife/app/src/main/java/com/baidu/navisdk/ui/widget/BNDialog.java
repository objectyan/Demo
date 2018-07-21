package com.baidu.navisdk.ui.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.jar.JarUtils;
import org.json.JSONObject;

public class BNDialog
  extends Dialog
{
  private String currDialogId;
  private boolean isSupportDayNight = false;
  private FrameLayout mContentList;
  private TextView mFirstBtn;
  private boolean mFirstHasText;
  private LinearLayout mLayoutContentList;
  private TextView mMessage;
  private OnNaviClickListener mOnFirstBtnClickListener;
  private OnNaviClickListener mOnSecondBtnClickListener;
  private TextView mSecondBtn;
  private boolean mSecondHasText;
  private TextView mTitleBar;
  private TextView mTitleBarList;
  private LinearLayout mTopContentLayout;
  
  public BNDialog(Activity paramActivity)
  {
    super(paramActivity);
    Resources.Theme localTheme = JarUtils.getResources().newTheme();
    localTheme.applyStyle(1711996937, true);
    JarUtils.setDialogThemeField(this, localTheme);
    this.currDialogId = ("BaiduMapAutoSDK_Dialog_" + System.currentTimeMillis());
    paramActivity = JarUtils.inflate(paramActivity, 1711472656, null);
    try
    {
      setContentView(paramActivity);
      this.mTopContentLayout = ((LinearLayout)paramActivity.findViewById(1711865892));
      this.mTitleBar = ((TextView)paramActivity.findViewById(1711865893));
      this.mMessage = ((TextView)paramActivity.findViewById(1711865894));
      this.mLayoutContentList = ((LinearLayout)findViewById(1711865898));
      this.mContentList = ((FrameLayout)findViewById(1711865900));
      this.mTitleBarList = ((TextView)findViewById(1711865899));
      this.mFirstBtn = ((TextView)paramActivity.findViewById(1711865896));
      this.mSecondBtn = ((TextView)paramActivity.findViewById(1711865897));
      this.mFirstBtn.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (BNDialog.this.mOnFirstBtnClickListener != null) {
            BNDialog.this.mOnFirstBtnClickListener.onClick();
          }
          BNDialog.this.dismiss();
        }
      });
      this.mSecondBtn.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (BNDialog.this.mOnSecondBtnClickListener != null) {
            BNDialog.this.mOnSecondBtnClickListener.onClick();
          }
          try
          {
            BNDialog.this.dismiss();
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
        this.mFirstBtn.setBackgroundDrawable(BNStyleManager.getDrawable(1711407371, paramBoolean));
        return;
      }
      if ((!this.mFirstHasText) && (this.mSecondHasText))
      {
        this.mFirstBtn.setVisibility(8);
        this.mSecondBtn.setVisibility(0);
        this.mSecondBtn.setBackgroundDrawable(BNStyleManager.getDrawable(1711407371, paramBoolean));
        return;
      }
    } while ((!this.mFirstHasText) || (!this.mSecondHasText));
    this.mFirstBtn.setVisibility(0);
    this.mSecondBtn.setVisibility(0);
    this.mFirstBtn.setBackgroundDrawable(BNStyleManager.getDrawable(1711407372, paramBoolean));
    this.mSecondBtn.setBackgroundDrawable(BNStyleManager.getDrawable(1711407375, paramBoolean));
  }
  
  private void updateDayStyle()
  {
    this.mTopContentLayout.setBackgroundDrawable(JarUtils.getResources().getDrawable(1711407509));
    this.mTitleBar.setTextColor(JarUtils.getResources().getColor(1711800402));
    this.mMessage.setTextColor(JarUtils.getResources().getColor(1711800402));
    this.mFirstBtn.setTextColor(JarUtils.getResources().getColor(1711800402));
    this.mSecondBtn.setTextColor(JarUtils.getResources().getColor(1711800402));
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
    } while ((!this.mFirstHasText) || (this.mSecondHasText));
    this.mFirstBtn.setBackgroundDrawable(JarUtils.getResources().getDrawable(1711407371));
  }
  
  public void dismiss()
  {
    this.mFirstHasText = false;
    this.mSecondHasText = false;
    if (BNDialogListenerMang.getInstance().getBNDialogListener() != null) {
      BNDialogListenerMang.getInstance().getBNDialogListener().onDismiss(this.currDialogId);
    }
    super.dismiss();
  }
  
  public BNDialog enableBackKey(boolean paramBoolean)
  {
    super.setCancelable(paramBoolean);
    return this;
  }
  
  public TextView getFirstBtn()
  {
    return this.mFirstBtn;
  }
  
  public TextView getSecondBtn()
  {
    return this.mSecondBtn;
  }
  
  public BNDialog setContentCenter()
  {
    this.mMessage.setGravity(17);
    return this;
  }
  
  public BNDialog setContentList(View paramView)
  {
    if (this.mTopContentLayout != null) {
      this.mTopContentLayout.setBackgroundResource(BNStyleManager.getColor(1711408176));
    }
    if (this.mLayoutContentList != null) {
      this.mLayoutContentList.setVisibility(0);
    }
    if (this.mContentList != null)
    {
      this.mContentList.removeAllViews();
      this.mContentList.addView(paramView);
    }
    return this;
  }
  
  public BNDialog setContentMessage(int paramInt)
  {
    return setContentMessage(JarUtils.getResources().getString(paramInt));
  }
  
  public BNDialog setContentMessage(String paramString)
  {
    if (this.mMessage == null) {
      return this;
    }
    if (TextUtils.isEmpty(paramString))
    {
      this.mMessage.setVisibility(8);
      this.mMessage.setText("", TextView.BufferType.SPANNABLE);
      return this;
    }
    this.mMessage.setVisibility(0);
    this.mMessage.setText(paramString, TextView.BufferType.SPANNABLE);
    return this;
  }
  
  public BNDialog setContentMessageFromActivity(int paramInt)
  {
    this.mMessage.setVisibility(0);
    this.mMessage.setText(paramInt, TextView.BufferType.SPANNABLE);
    return this;
  }
  
  public BNDialog setFirstBtnEnabled(boolean paramBoolean)
  {
    this.mFirstBtn.setEnabled(paramBoolean);
    return this;
  }
  
  public BNDialog setFirstBtnText(int paramInt)
  {
    return setFirstBtnText(JarUtils.getResources().getString(paramInt));
  }
  
  public BNDialog setFirstBtnText(Spanned paramSpanned)
  {
    if (paramSpanned == null)
    {
      this.mFirstHasText = false;
      this.mFirstBtn.setText("");
    }
    for (;;)
    {
      setBtnVisible();
      return this;
      this.mFirstHasText = true;
      this.mFirstBtn.setText(paramSpanned);
    }
  }
  
  public BNDialog setFirstBtnText(String paramString)
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
  
  public BNDialog setFirstBtnText(boolean paramBoolean, String paramString)
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
  
  public BNDialog setFirstBtnTextColorHighLight()
  {
    this.mFirstBtn.setTextColor(-12352272);
    return this;
  }
  
  public BNDialog setFirstBtnTextFromActivity(int paramInt)
  {
    this.mFirstHasText = true;
    this.mFirstBtn.setText(paramInt, TextView.BufferType.SPANNABLE);
    setBtnVisible();
    return this;
  }
  
  public BNDialog setListTitleText(String paramString)
  {
    if (paramString == null)
    {
      this.mTitleBarList.setVisibility(8);
      this.mTitleBarList.setText("", TextView.BufferType.SPANNABLE);
    }
    for (;;)
    {
      this.mTitleBarList.setTextColor(BNStyleManager.getColor(1711800344));
      this.mTitleBarList.setBackgroundDrawable(BNStyleManager.getDrawable(1711407509));
      return this;
      this.mTopContentLayout.setVisibility(8);
      this.mTitleBarList.setVisibility(0);
      this.mTitleBarList.setText(paramString, TextView.BufferType.SPANNABLE);
    }
  }
  
  public BNDialog setOnFirstBtnClickListener(OnNaviClickListener paramOnNaviClickListener)
  {
    this.mOnFirstBtnClickListener = paramOnNaviClickListener;
    return this;
  }
  
  public BNDialog setOnSecondBtnClickListener(OnNaviClickListener paramOnNaviClickListener)
  {
    this.mOnSecondBtnClickListener = paramOnNaviClickListener;
    return this;
  }
  
  public BNDialog setSecondBtnEnabled(boolean paramBoolean)
  {
    this.mSecondBtn.setEnabled(paramBoolean);
    return this;
  }
  
  public BNDialog setSecondBtnText(int paramInt)
  {
    return setSecondBtnText(JarUtils.getResources().getString(paramInt));
  }
  
  public BNDialog setSecondBtnText(Spanned paramSpanned)
  {
    if (paramSpanned == null)
    {
      this.mSecondHasText = false;
      this.mSecondBtn.setText("");
    }
    for (;;)
    {
      setBtnVisible();
      return this;
      this.mSecondHasText = true;
      this.mSecondBtn.setText(paramSpanned);
    }
  }
  
  public BNDialog setSecondBtnText(String paramString)
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
  
  public BNDialog setSecondBtnText(boolean paramBoolean, String paramString)
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
  
  public BNDialog setSecondBtnTextColorHighLight()
  {
    this.mSecondBtn.setTextColor(-12352272);
    return this;
  }
  
  public BNDialog setSecondBtnTextFromActivity(int paramInt)
  {
    this.mSecondHasText = true;
    this.mSecondBtn.setText(paramInt, TextView.BufferType.SPANNABLE);
    setBtnVisible();
    return this;
  }
  
  public BNDialog setTitleText(int paramInt)
  {
    return setTitleText(JarUtils.getResources().getString(paramInt));
  }
  
  public BNDialog setTitleText(String paramString)
  {
    if (this.mTitleBar != null)
    {
      if (paramString == null)
      {
        this.mTitleBar.setVisibility(8);
        this.mTitleBar.setText("", TextView.BufferType.SPANNABLE);
      }
    }
    else {
      return this;
    }
    this.mTitleBar.setVisibility(0);
    this.mTitleBar.setText(paramString, TextView.BufferType.SPANNABLE);
    return this;
  }
  
  public BNDialog setTitleTextFromActivity(int paramInt)
  {
    this.mTitleBar.setVisibility(0);
    this.mTitleBar.setText(paramInt, TextView.BufferType.SPANNABLE);
    return this;
  }
  
  public void show()
  {
    if (this.isSupportDayNight) {
      updateStyle();
    }
    try
    {
      for (;;)
      {
        JSONObject localJSONObject1 = new JSONObject();
        localJSONObject1.put("dialogid", this.currDialogId);
        localJSONObject1.put("type", "message");
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("title", this.mTitleBar.getText().toString());
        localJSONObject2.put("content", this.mMessage.getText().toString());
        localJSONObject2.put("firstbtn", this.mFirstBtn.getText().toString());
        localJSONObject2.put("secondbtn", this.mSecondBtn.getText().toString());
        localJSONObject1.put("value", localJSONObject2);
        if (BNDialogListenerMang.getInstance().getBNDialogListener() != null) {
          BNDialogListenerMang.getInstance().getBNDialogListener().onShow(this.currDialogId, localJSONObject1.toString(), this);
        }
        super.show();
        return;
        updateDayStyle();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void updateStyle()
  {
    this.isSupportDayNight = true;
    this.mTopContentLayout.setBackgroundDrawable(BNStyleManager.getDrawable(1711407509));
    this.mTitleBar.setTextColor(BNStyleManager.getColor(1711800402));
    this.mMessage.setTextColor(BNStyleManager.getColor(1711800402));
    this.mFirstBtn.setTextColor(BNStyleManager.getColor(1711800402));
    this.mSecondBtn.setTextColor(BNStyleManager.getColor(1711800402));
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
    } while ((!this.mFirstHasText) || (this.mSecondHasText));
    this.mFirstBtn.setBackgroundDrawable(BNStyleManager.getDrawable(1711407371));
  }
  
  public static abstract interface OnNaviClickListener
  {
    public abstract void onClick();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/widget/BNDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */