package com.baidu.navi.routedetails;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.carlife.util.r;
import com.baidu.navisdk.util.common.LogUtil;

public class RGRouteDetailsOutlineItemView
  extends LinearLayout
{
  private AnimationSet animationExperienceSet;
  private AnimationSet animationScrownSet;
  private boolean hasSetupStampAnimation = false;
  private boolean initSucceeded = false;
  private boolean isFiveStarRoute = false;
  private boolean isFocus = false;
  private Activity mActivity;
  private View mAnimationLayout;
  private ImageView mAnimationStampView;
  private RelativeLayout mDetailItemLL;
  private TextView mDistTv;
  private GestureDetector mGestureDetector;
  private TextView mLightsNew;
  private int mOrientation;
  private int mRouteIndex;
  private TextView mRouteTag;
  private TextView mTimeTv;
  private OnDragOpenListener mTragOpenListener;
  private int testcount = 0;
  
  public RGRouteDetailsOutlineItemView(Context paramContext)
  {
    super(paramContext);
  }
  
  private boolean setupView(Activity paramActivity)
  {
    this.mActivity = paramActivity;
    this.mOrientation = paramActivity.getResources().getConfiguration().orientation;
    paramActivity = this.mActivity.getLayoutInflater().inflate(2130968975, this);
    if (paramActivity == null)
    {
      LogUtil.e("RGRouteDetailsOutlineItemView", "setupView: -->> Inflate failed!");
      return false;
    }
    this.mTimeTv = ((TextView)paramActivity.findViewById(2131625952));
    this.mDistTv = ((TextView)paramActivity.findViewById(2131625954));
    this.mRouteTag = ((TextView)paramActivity.findViewById(2131625953));
    this.mLightsNew = ((TextView)paramActivity.findViewById(2131625955));
    this.mDetailItemLL = ((RelativeLayout)paramActivity.findViewById(2131625951));
    if (this.mDetailItemLL != null)
    {
      this.mDetailItemLL.setBackground(r.b(2130838223));
      this.mDetailItemLL.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (RGRouteDetailsOutlineItemView.this.mTragOpenListener != null) {
            RGRouteDetailsOutlineItemView.this.mTragOpenListener.onClick();
          }
        }
      });
    }
    return true;
  }
  
  public void focusItem()
  {
    if ((!this.initSucceeded) || (this.mActivity == null)) {
      return;
    }
    this.mTimeTv.setTextColor(this.mActivity.getResources().getColor(2131558646));
    this.mDistTv.setTextColor(this.mActivity.getResources().getColor(2131558646));
    this.mRouteTag.setTextColor(this.mActivity.getResources().getColor(2131558646));
    this.mLightsNew.setTextColor(this.mActivity.getResources().getColor(2131558646));
    this.isFocus = true;
  }
  
  public View getDetailItem()
  {
    return this.mDetailItemLL;
  }
  
  public int getRouteIndex()
  {
    return this.mRouteIndex;
  }
  
  public boolean isInitSucceeded()
  {
    return this.initSucceeded;
  }
  
  public void setData(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    if (!this.initSucceeded) {
      return;
    }
    this.mTimeTv.setText(paramString1);
    this.mDistTv.setText(paramString2);
    this.mRouteTag.setText(paramString3);
    this.mLightsNew.setText("红绿灯" + paramInt1 + "个");
    this.mRouteIndex = paramInt2;
  }
  
  public void setTragOpenListener(OnDragOpenListener paramOnDragOpenListener)
  {
    this.mTragOpenListener = paramOnDragOpenListener;
  }
  
  public void unfocusItem()
  {
    if (!this.initSucceeded) {
      return;
    }
    this.mTimeTv.setTextColor(this.mActivity.getResources().getColor(2131558703));
    this.mDistTv.setTextColor(this.mActivity.getResources().getColor(2131558692));
    this.mRouteTag.setTextColor(this.mActivity.getResources().getColor(2131558692));
    this.mLightsNew.setTextColor(this.mActivity.getResources().getColor(2131558692));
    this.isFocus = false;
  }
  
  class MyOnGestureListener
    extends GestureDetector.SimpleOnGestureListener
  {
    MyOnGestureListener() {}
    
    public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      return false;
    }
    
    public boolean onSingleTapUp(MotionEvent paramMotionEvent)
    {
      if (RGRouteDetailsOutlineItemView.this.mTragOpenListener != null) {
        RGRouteDetailsOutlineItemView.this.mTragOpenListener.onClick();
      }
      return false;
    }
  }
  
  public static abstract interface OnDragOpenListener
  {
    public abstract void onClick();
    
    public abstract void onOpen();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/routedetails/RGRouteDetailsOutlineItemView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */