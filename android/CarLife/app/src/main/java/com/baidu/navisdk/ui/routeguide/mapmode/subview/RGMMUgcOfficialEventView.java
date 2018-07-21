package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.widget.BNBaseView;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;

public class RGMMUgcOfficialEventView
  extends BNBaseView
{
  private static final int MSG_HIDE_UGC_OFFICIAL_EVENT_CARD = 1;
  private static final String TAG = "RGMMUgcOfficialEventView";
  private ViewGroup mUgcOfficialEventContainer = null;
  private TextView mUgcOfficialEventTV = null;
  private View mUgcOfficialEventView = null;
  
  public RGMMUgcOfficialEventView(Context paramContext, ViewGroup paramViewGroup, OnRGSubViewListener paramOnRGSubViewListener)
  {
    super(paramContext, paramViewGroup, paramOnRGSubViewListener);
    initViews();
    updateStyle(BNStyleManager.getDayStyle());
    initListener();
  }
  
  private void initListener() {}
  
  private void initViews()
  {
    if (this.mRootViewGroup == null) {}
    do
    {
      do
      {
        return;
      } while (this.mUgcOfficialEventContainer == null);
      this.mUgcOfficialEventContainer.removeAllViews();
      this.mUgcOfficialEventView = JarUtils.inflate((Activity)this.mContext, 1711472707, null);
      if (this.mUgcOfficialEventContainer != null) {
        this.mUgcOfficialEventTV = ((TextView)this.mUgcOfficialEventView.findViewById(1711866462));
      }
    } while (this.mUgcOfficialEventTV == null);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
    this.mUgcOfficialEventContainer.addView(this.mUgcOfficialEventView, localLayoutParams);
  }
  
  public void hide()
  {
    super.hide();
    LogUtil.e("RGMMUgcOfficialEventView", "hide()");
    if (this.mUgcOfficialEventContainer != null) {
      this.mUgcOfficialEventContainer.setVisibility(8);
    }
  }
  
  public void show()
  {
    super.show();
    LogUtil.e("RGMMUgcOfficialEventView", "show()");
    if (this.mUgcOfficialEventContainer != null) {
      this.mUgcOfficialEventContainer.setVisibility(0);
    }
    if (this.mUgcOfficialEventTV != null) {
      this.mUgcOfficialEventTV.setText(JNIGuidanceControl.getInstance().GetRoadEventText());
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/mapmode/subview/RGMMUgcOfficialEventView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */