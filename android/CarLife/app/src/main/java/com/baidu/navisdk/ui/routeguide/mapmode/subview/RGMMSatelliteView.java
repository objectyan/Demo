package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.widget.BNBaseView;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;

public class RGMMSatelliteView
  extends BNBaseView
{
  private static String TAG = RGMMSatelliteView.class.getName();
  private final String TIPS_TEXT = "GPS信号弱，请谨慎驾驶";
  private ViewGroup mSatelliteContainer = null;
  private TextView mSatelliteTV = null;
  private View mSatelliteView = null;
  
  public RGMMSatelliteView(Context paramContext, ViewGroup paramViewGroup, OnRGSubViewListener paramOnRGSubViewListener)
  {
    super(paramContext, paramViewGroup, paramOnRGSubViewListener);
    initViews();
    updateStyle(BNStyleManager.getDayStyle());
    initListener();
  }
  
  private void initListener()
  {
    if (this.mSatelliteContainer != null) {
      this.mSatelliteContainer.setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          return true;
        }
      });
    }
  }
  
  private void initViews()
  {
    if (this.mRootViewGroup == null) {}
    do
    {
      do
      {
        return;
      } while (this.mSatelliteContainer == null);
      this.mSatelliteContainer.removeAllViews();
      this.mSatelliteView = JarUtils.inflate((Activity)this.mContext, 1711472707, null);
      this.mSatelliteTV = ((TextView)this.mSatelliteView.findViewById(1711866462));
    } while ((this.mSatelliteContainer == null) || (this.mSatelliteView == null));
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
    this.mSatelliteContainer.addView(this.mSatelliteView, localLayoutParams);
  }
  
  public void hide()
  {
    super.hide();
    LogUtil.e(TAG, "hide()");
    if (this.mSatelliteContainer != null) {
      this.mSatelliteContainer.setVisibility(8);
    }
  }
  
  public void show()
  {
    super.show();
    LogUtil.e(TAG, "show()");
    if (this.mSatelliteContainer != null) {
      this.mSatelliteContainer.setVisibility(0);
    }
    if (this.mSatelliteTV != null)
    {
      this.mSatelliteTV.setText("GPS信号弱，请谨慎驾驶");
      this.mSatelliteTV.setTextColor(-1);
    }
  }
  
  public void updateStyle(boolean paramBoolean)
  {
    super.updateStyle(paramBoolean);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/mapmode/subview/RGMMSatelliteView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */