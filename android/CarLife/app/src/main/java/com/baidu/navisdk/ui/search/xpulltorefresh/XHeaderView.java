package com.baidu.navisdk.ui.search.xpulltorefresh;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.jar.JarUtils;

public class XHeaderView
  extends LinearLayout
{
  private static final int ROTATE_ANIM_DURATION = 180;
  public static final int STATE_NORMAL = 0;
  public static final int STATE_READY = 1;
  public static final int STATE_REFRESHING = 2;
  private ImageView mArrowImageView;
  private TextView mHintTextView;
  private boolean mIsFirst;
  private Animation mRotateDownAnim;
  private Animation mRotateUpAnim;
  private int mState = 0;
  private ViewGroup mViewGroup;
  
  public XHeaderView(Context paramContext)
  {
    super(paramContext);
    initView((Activity)paramContext);
  }
  
  public XHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView((Activity)paramContext);
  }
  
  private void initView(Activity paramActivity)
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, 0);
    this.mViewGroup = ((ViewGroup)JarUtils.inflate(paramActivity, 1711472648, null));
    addView(this.mViewGroup, localLayoutParams);
    setGravity(80);
    this.mArrowImageView = ((ImageView)findViewById(1711865874));
    this.mHintTextView = ((TextView)findViewById(1711865872));
    this.mRotateUpAnim = new RotateAnimation(0.0F, -180.0F, 1, 0.5F, 1, 0.5F);
    this.mRotateUpAnim.setDuration(180L);
    this.mRotateUpAnim.setFillAfter(true);
    this.mRotateDownAnim = new RotateAnimation(-180.0F, 0.0F, 1, 0.5F, 1, 0.5F);
    this.mRotateDownAnim.setDuration(180L);
    this.mRotateDownAnim.setFillAfter(true);
  }
  
  public int getVisibleHeight()
  {
    return this.mViewGroup.getHeight();
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
      this.mHintTextView.setText(BNStyleManager.getString(1711669455));
      continue;
      if (this.mState != 1)
      {
        this.mArrowImageView.clearAnimation();
        this.mArrowImageView.startAnimation(this.mRotateUpAnim);
        this.mHintTextView.setText(BNStyleManager.getString(1711669456));
        continue;
        this.mHintTextView.setText(BNStyleManager.getString(1711669457));
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
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.mViewGroup.getLayoutParams();
    localLayoutParams.height = i;
    this.mViewGroup.setLayoutParams(localLayoutParams);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/search/xpulltorefresh/XHeaderView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */