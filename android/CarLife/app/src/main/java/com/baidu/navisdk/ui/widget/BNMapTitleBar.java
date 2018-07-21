package com.baidu.navisdk.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.jar.JarUtils;

public class BNMapTitleBar
  extends FrameLayout
{
  protected static final int MAP_TITLE_TEXT_COLOR = -16777216;
  protected View mLayout;
  protected ImageView mLeftImageView;
  protected TextView mMiddleTextView;
  protected ImageView mRightImageView;
  
  public BNMapTitleBar(Context paramContext)
  {
    super(paramContext);
  }
  
  public BNMapTitleBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mLayout = ((RelativeLayout)JarUtils.inflate((Activity)paramContext, 1711472651, null));
    addView(this.mLayout);
    initView(paramContext);
  }
  
  private void initView(Context paramContext)
  {
    this.mRightImageView = ((ImageView)this.mLayout.findViewById(1711865879));
    this.mLeftImageView = ((ImageView)this.mLayout.findViewById(1711865878));
    this.mMiddleTextView = ((TextView)this.mLayout.findViewById(1711865880));
  }
  
  public void onUpdateStyle(boolean paramBoolean) {}
  
  public void setLeftButtonBackground(Drawable paramDrawable)
  {
    if (this.mLeftImageView != null) {
      this.mLeftImageView.setBackgroundDrawable(paramDrawable);
    }
  }
  
  public void setLeftButtonVisible(boolean paramBoolean)
  {
    ImageView localImageView;
    if (this.mLeftImageView != null)
    {
      localImageView = this.mLeftImageView;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      return;
    }
  }
  
  public void setLeftOnClickedListener(View.OnClickListener paramOnClickListener)
  {
    if (this.mLeftImageView != null) {
      this.mLeftImageView.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setMiddleText(int paramInt)
  {
    setMiddleText(BNStyleManager.getString(paramInt));
  }
  
  public void setMiddleText(String paramString)
  {
    if (this.mMiddleTextView != null) {
      this.mMiddleTextView.setText(paramString);
    }
  }
  
  public void setMiddleTextColor(int paramInt)
  {
    if (this.mMiddleTextView != null) {
      this.mMiddleTextView.setTextColor(paramInt);
    }
  }
  
  public void setMiddleTextVisible(boolean paramBoolean)
  {
    TextView localTextView;
    if (this.mMiddleTextView != null)
    {
      localTextView = this.mMiddleTextView;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      return;
    }
  }
  
  public void setRightButtonBackground(Drawable paramDrawable)
  {
    if (this.mRightImageView != null)
    {
      this.mRightImageView.setBackgroundDrawable(paramDrawable);
      this.mRightImageView.setVisibility(0);
    }
  }
  
  public void setRightButtonVisible(boolean paramBoolean)
  {
    ImageView localImageView;
    if (this.mRightImageView != null)
    {
      localImageView = this.mRightImageView;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      return;
    }
  }
  
  public void setRightOnClickedListener(View.OnClickListener paramOnClickListener)
  {
    if (this.mRightImageView != null)
    {
      this.mRightImageView.setOnClickListener(paramOnClickListener);
      this.mRightImageView.setVisibility(0);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/widget/BNMapTitleBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */