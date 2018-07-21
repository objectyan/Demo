package com.baidu.navisdk.ui.download.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.navisdk.util.jar.JarUtils;

public class BNOfflineDataMergeLoadingView
  extends FrameLayout
{
  private Animation mAnim;
  private Context mContext;
  FrameLayout mFLLayout;
  private ImageView mMergeImage;
  
  public BNOfflineDataMergeLoadingView(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    findView();
  }
  
  public BNOfflineDataMergeLoadingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    findView();
  }
  
  private void findView()
  {
    View localView = JarUtils.inflate((Activity)this.mContext, 1711472692, this);
    this.mFLLayout = ((FrameLayout)localView.findViewById(1711866348));
    this.mMergeImage = ((ImageView)localView.findViewById(1711866349));
    this.mAnim = JarUtils.loadAnimation(this.mContext, 1711538183);
  }
  
  public void hideLoading()
  {
    this.mAnim.cancel();
    this.mFLLayout.setVisibility(8);
  }
  
  public void showLoading()
  {
    this.mFLLayout.setVisibility(0);
    startAnim();
  }
  
  public void startAnim()
  {
    this.mAnim.setRepeatCount(-1);
    this.mMergeImage.startAnimation(this.mAnim);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/download/view/BNOfflineDataMergeLoadingView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */