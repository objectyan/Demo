package com.baidu.navi.view.xpulltorefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class XFooterView
  extends LinearLayout
{
  public static final int STATE_LOADING = 2;
  public static final int STATE_NORMAL = 0;
  public static final int STATE_READY = 1;
  private final int ROTATE_ANIM_DURATION = 180;
  private TextView mHintView;
  private View mLayout;
  private Animation mRotateDownAnim;
  private Animation mRotateUpAnim;
  private int mState = 0;
  
  public XFooterView(Context paramContext)
  {
    super(paramContext);
    initView(paramContext);
  }
  
  public XFooterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView(paramContext);
  }
  
  private void initView(Context paramContext)
  {
    this.mLayout = LayoutInflater.from(paramContext).inflate(2130968892, null);
    this.mLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    addView(this.mLayout);
    this.mHintView = ((TextView)this.mLayout.findViewById(2131625514));
    this.mRotateUpAnim = new RotateAnimation(0.0F, 180.0F, 1, 0.5F, 1, 0.5F);
    this.mRotateUpAnim.setDuration(180L);
    this.mRotateUpAnim.setFillAfter(true);
    this.mRotateDownAnim = new RotateAnimation(180.0F, 0.0F, 1, 0.5F, 1, 0.5F);
    this.mRotateDownAnim.setDuration(180L);
    this.mRotateDownAnim.setFillAfter(true);
  }
  
  public int getBottomMargin()
  {
    return ((LinearLayout.LayoutParams)this.mLayout.getLayoutParams()).bottomMargin;
  }
  
  public void hide()
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.mLayout.getLayoutParams();
    localLayoutParams.height = 0;
    this.mLayout.setLayoutParams(localLayoutParams);
  }
  
  public void loading()
  {
    this.mHintView.setVisibility(8);
  }
  
  public void normal()
  {
    this.mHintView.setVisibility(0);
  }
  
  public void setBottomMargin(int paramInt)
  {
    if (paramInt < 0) {
      return;
    }
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.mLayout.getLayoutParams();
    localLayoutParams.bottomMargin = paramInt;
    this.mLayout.setLayoutParams(localLayoutParams);
  }
  
  public void setState(int paramInt)
  {
    if (paramInt == this.mState) {
      return;
    }
    if (paramInt == 2)
    {
      this.mHintView.setVisibility(4);
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      this.mState = paramInt;
      return;
      this.mHintView.setVisibility(0);
      break;
      this.mHintView.setText(2131296472);
      continue;
      if (this.mState != 1) {
        this.mHintView.setText(2131296473);
      }
    }
  }
  
  public void setText(int paramInt)
  {
    if (this.mHintView != null) {
      this.mHintView.setText(paramInt);
    }
  }
  
  public void setTextColor(int paramInt)
  {
    if (this.mHintView != null) {
      this.mHintView.setTextColor(paramInt);
    }
  }
  
  public void show()
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.mLayout.getLayoutParams();
    localLayoutParams.height = -2;
    this.mLayout.setLayoutParams(localLayoutParams);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/view/xpulltorefresh/XFooterView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */