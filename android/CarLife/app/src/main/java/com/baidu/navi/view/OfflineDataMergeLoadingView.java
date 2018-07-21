package com.baidu.navi.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class OfflineDataMergeLoadingView
  extends FrameLayout
{
  private Animation mAnim;
  private Context mContext;
  FrameLayout mFLLayout;
  private ImageView mMergeImage;
  
  public OfflineDataMergeLoadingView(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    findView();
  }
  
  public OfflineDataMergeLoadingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    findView();
  }
  
  private void findView()
  {
    View localView = ((LayoutInflater)this.mContext.getSystemService("layout_inflater")).inflate(2130968597, this);
    this.mFLLayout = ((FrameLayout)localView.findViewById(2131624051));
    this.mMergeImage = ((ImageView)localView.findViewById(2131624052));
    this.mAnim = AnimationUtils.loadAnimation(this.mContext, 2130839257);
  }
  
  public void hideLoading()
  {
    this.mAnim.cancel();
    this.mFLLayout.setVisibility(8);
  }
  
  public void showLoading()
  {
    startAnim();
    this.mFLLayout.setVisibility(0);
  }
  
  public void startAnim()
  {
    this.mAnim.setRepeatMode(1);
    this.mAnim.setRepeatCount(-1);
    this.mMergeImage.startAnimation(this.mAnim);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/view/OfflineDataMergeLoadingView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */