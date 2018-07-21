package com.baidu.navi.cruise.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navi.style.StyleManager;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.nplatform.comapi.map.MapController;

public class CruiseScaleLevelView
{
  private static final int MSG_AUTO_HIDE = 1;
  private Activity mActivity;
  private ImageView mAppNameIV = null;
  private Handler mAutoHandler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      }
      for (;;)
      {
        super.handleMessage(paramAnonymousMessage);
        return;
        CruiseScaleLevelView.this.mLayout.setVisibility(8);
      }
    }
  };
  private RelativeLayout mLayout = null;
  private TextView mScaleIndicator = null;
  private TextView mScaleTitle = null;
  
  public CruiseScaleLevelView(Activity paramActivity, View paramView)
  {
    this.mActivity = paramActivity;
    this.mLayout = ((RelativeLayout)paramView.findViewById(2131625907));
    this.mScaleTitle = ((TextView)paramView.findViewById(2131625908));
    this.mScaleIndicator = ((TextView)paramView.findViewById(2131625909));
    this.mAppNameIV = ((ImageView)paramView.findViewById(2131625610));
    if (this.mAppNameIV != null) {
      this.mAppNameIV.setVisibility(8);
    }
  }
  
  public void autoHide(long paramLong)
  {
    this.mAutoHandler.removeMessages(1);
    this.mAutoHandler.sendEmptyMessageDelayed(1, paramLong);
  }
  
  public void hide()
  {
    if (this.mLayout != null) {
      this.mLayout.setVisibility(4);
    }
  }
  
  @SuppressLint({"NewApi"})
  public void onUpdateStyle(boolean paramBoolean)
  {
    TextView localTextView;
    if (this.mScaleTitle != null)
    {
      localTextView = this.mScaleTitle;
      if (!paramBoolean) {
        break label50;
      }
    }
    label50:
    for (int i = -13223362;; i = -1052432)
    {
      localTextView.setTextColor(i);
      if (this.mScaleIndicator != null)
      {
        if (!StyleManager.getDayStyle()) {
          break;
        }
        this.mScaleIndicator.setBackgroundDrawable(StyleManager.getDrawable(2130839200));
      }
      return;
    }
    this.mScaleIndicator.setBackgroundDrawable(StyleManager.getDrawable(2130839201));
  }
  
  public void show()
  {
    if (this.mLayout != null) {
      this.mLayout.setVisibility(0);
    }
  }
  
  public void showIcon()
  {
    this.mScaleTitle.setVisibility(4);
    this.mScaleIndicator.setVisibility(4);
  }
  
  public void showScale()
  {
    this.mScaleTitle.setVisibility(0);
    this.mScaleIndicator.setVisibility(0);
  }
  
  public void update()
  {
    int m = BNMapController.getInstance().getScreenWidth();
    int j = BNMapController.getInstance().getZoomLevel();
    double d = BNMapController.getInstance().getZoomUnitsInMeter();
    int i = MapController.getScaleDis(j);
    LogUtil.e("Meter", "room updateScale dis=" + i + " level=" + j + " u=" + d);
    for (int k = (int)Math.ceil(i / d); (k > m / 2) && (j >= 3) && (j <= 20); k = (int)Math.ceil(i / d))
    {
      j += 1;
      i = MapController.getScaleDis(j);
    }
    if (i >= 1000) {}
    for (String str = i / 1000 + StyleManager.getString(2131296779);; str = i + StyleManager.getString(2131296780))
    {
      this.mScaleTitle.setText(str);
      this.mScaleIndicator.setWidth(k);
      return;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/cruise/view/CruiseScaleLevelView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */