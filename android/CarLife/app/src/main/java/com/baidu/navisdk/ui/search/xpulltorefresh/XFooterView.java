package com.baidu.navisdk.ui.search.xpulltorefresh;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.jar.JarUtils;

public class XFooterView
  extends LinearLayout
{
  private static final int ROTATE_ANIM_DURATION = 180;
  public static final int STATE_LOADING = 2;
  public static final int STATE_NORMAL = 0;
  public static final int STATE_READY = 1;
  private TextView mHintView;
  private Animation mRotateDownAnim;
  private Animation mRotateUpAnim;
  private int mState = 0;
  private ViewGroup mViewGroup;
  
  public XFooterView(Context paramContext)
  {
    super(paramContext);
    initView((Activity)paramContext);
  }
  
  public XFooterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView((Activity)paramContext);
  }
  
  private void initView(Activity paramActivity)
  {
    this.mViewGroup = ((ViewGroup)JarUtils.inflate(paramActivity, 1711472647, null));
    this.mViewGroup.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    addView(this.mViewGroup);
    this.mHintView = ((TextView)this.mViewGroup.findViewById(1711865868));
    this.mRotateUpAnim = new RotateAnimation(0.0F, 180.0F, 1, 0.5F, 1, 0.5F);
    this.mRotateUpAnim.setDuration(180L);
    this.mRotateUpAnim.setFillAfter(true);
    this.mRotateDownAnim = new RotateAnimation(180.0F, 0.0F, 1, 0.5F, 1, 0.5F);
    this.mRotateDownAnim.setDuration(180L);
    this.mRotateDownAnim.setFillAfter(true);
  }
  
  public int getBottomMargin()
  {
    return ((LinearLayout.LayoutParams)this.mViewGroup.getLayoutParams()).bottomMargin;
  }
  
  public void hide()
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.mViewGroup.getLayoutParams();
    localLayoutParams.height = 0;
    this.mViewGroup.setLayoutParams(localLayoutParams);
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
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.mViewGroup.getLayoutParams();
    localLayoutParams.bottomMargin = paramInt;
    this.mViewGroup.setLayoutParams(localLayoutParams);
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
      this.mHintView.setText(BNStyleManager.getString(1711669459));
      continue;
      if (this.mState != 1) {
        this.mHintView.setText(BNStyleManager.getString(1711669460));
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
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.mViewGroup.getLayoutParams();
    localLayoutParams.height = -2;
    this.mViewGroup.setLayoutParams(localLayoutParams);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/search/xpulltorefresh/XFooterView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */