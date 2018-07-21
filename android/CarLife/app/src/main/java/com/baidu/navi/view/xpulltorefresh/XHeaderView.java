package com.baidu.navi.view.xpulltorefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class XHeaderView
  extends LinearLayout
{
  public static final int STATE_NORMAL = 0;
  public static final int STATE_READY = 1;
  public static final int STATE_REFRESHING = 2;
  private final int ROTATE_ANIM_DURATION = 180;
  private ImageView mArrowImageView;
  private LinearLayout mContainer;
  private TextView mHintTextView;
  private boolean mIsFirst;
  private Animation mRotateDownAnim;
  private Animation mRotateUpAnim;
  private int mState = 0;
  
  public XHeaderView(Context paramContext)
  {
    super(paramContext);
    initView(paramContext);
  }
  
  public XHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView(paramContext);
  }
  
  private void initView(Context paramContext)
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, 0);
    this.mContainer = ((LinearLayout)LayoutInflater.from(paramContext).inflate(2130968893, null));
    addView(this.mContainer, localLayoutParams);
    setGravity(80);
    this.mArrowImageView = ((ImageView)findViewById(2131625520));
    this.mHintTextView = ((TextView)findViewById(2131625518));
    this.mRotateUpAnim = new RotateAnimation(0.0F, -180.0F, 1, 0.5F, 1, 0.5F);
    this.mRotateUpAnim.setDuration(180L);
    this.mRotateUpAnim.setFillAfter(true);
    this.mRotateDownAnim = new RotateAnimation(-180.0F, 0.0F, 1, 0.5F, 1, 0.5F);
    this.mRotateDownAnim.setDuration(180L);
    this.mRotateDownAnim.setFillAfter(true);
  }
  
  public int getVisibleHeight()
  {
    return this.mContainer.getHeight();
  }
  
  public void setState(int paramInt)
  {
    if ((paramInt == this.mState) && (this.mIsFirst))
    {
      this.mIsFirst = true;
      return;
    }
    if (paramInt == 2)
    {
      this.mArrowImageView.clearAnimation();
      this.mArrowImageView.setVisibility(4);
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      this.mState = paramInt;
      return;
      this.mArrowImageView.setVisibility(0);
      break;
      if (this.mState == 1) {
        this.mArrowImageView.startAnimation(this.mRotateDownAnim);
      }
      if (this.mState == 2) {
        this.mArrowImageView.clearAnimation();
      }
      this.mHintTextView.setText(2131296480);
      continue;
      if (this.mState != 1)
      {
        this.mArrowImageView.clearAnimation();
        this.mArrowImageView.startAnimation(this.mRotateUpAnim);
        this.mHintTextView.setText(2131296481);
        continue;
        this.mHintTextView.setText(2131296479);
      }
    }
  }
  
  public void setTextColor(int paramInt)
  {
    if (this.mHintTextView != null) {
      this.mHintTextView.setTextColor(paramInt);
    }
  }
  
  public void setVisibleHeight(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.mContainer.getLayoutParams();
    localLayoutParams.height = i;
    this.mContainer.setLayoutParams(localLayoutParams);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/view/xpulltorefresh/XHeaderView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */