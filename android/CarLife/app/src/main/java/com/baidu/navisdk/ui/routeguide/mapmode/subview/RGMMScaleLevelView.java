package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.ui.routeguide.BNavConfig;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.nplatform.comapi.map.MapController;

public class RGMMScaleLevelView
{
  private static final int MSG_AUTO_HIDE = 1;
  private ImageView mAppNameIV = null;
  private Handler mAutoHandler = new Handler(Looper.getMainLooper())
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
        RGMMScaleLevelView.this.mLayout.setVisibility(8);
      }
    }
  };
  private Context mContext;
  private RelativeLayout mLayout = null;
  private TextView mScaleIndicator = null;
  private TextView mScaleTitle = null;
  
  public RGMMScaleLevelView(Context paramContext, View paramView)
  {
    this.mContext = paramContext;
    initView(paramView);
    onUpdateStyle(BNStyleManager.getDayStyle());
  }
  
  private void initView(View paramView)
  {
    this.mLayout = ((RelativeLayout)paramView.findViewById(1711866587));
    this.mScaleTitle = ((TextView)paramView.findViewById(1711866588));
    this.mScaleIndicator = ((TextView)paramView.findViewById(1711866589));
    this.mAppNameIV = ((ImageView)paramView.findViewById(1711865954));
    if (this.mAppNameIV != null) {
      this.mAppNameIV.setVisibility(8);
    }
    if ((this.mLayout != null) && (BNavConfig.pRGLocateMode == 2)) {
      this.mLayout.setVisibility(8);
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
      this.mLayout.setVisibility(8);
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
        break label44;
      }
    }
    label44:
    for (int i = -13223362;; i = -1052432)
    {
      localTextView.setTextColor(i);
      if (this.mScaleIndicator != null) {
        this.mScaleIndicator.setBackgroundDrawable(BNStyleManager.getDrawable(1711407694));
      }
      return;
    }
  }
  
  public void orientationChanged(ViewGroup paramViewGroup, int paramInt)
  {
    initView(paramViewGroup);
    onUpdateStyle(BNStyleManager.getDayStyle());
  }
  
  public void show()
  {
    if ((this.mLayout != null) && (BNavConfig.pRGLocateMode != 2)) {
      this.mLayout.setVisibility(0);
    }
  }
  
  public void update()
  {
    int m = BNMapController.getInstance().getScreenWidth();
    int j = BNMapController.getInstance().getZoomLevel();
    double d = BNMapController.getInstance().getZoomUnitsInMeter();
    int i = MapController.getScaleDis(j);
    LogUtil.e("Map", "room updateScale dis=" + i + " level=" + j + " u=" + d);
    for (int k = (int)Math.ceil(i / d); (k > m / 2) && (j >= 3) && (j <= 20); k = (int)Math.ceil(i / d))
    {
      j += 1;
      i = MapController.getScaleDis(j);
    }
    if (i >= 1000) {}
    for (String str = i / 1000 + JarUtils.getResources().getString(1711669516);; str = i + JarUtils.getResources().getString(1711669517))
    {
      if (this.mScaleTitle != null) {
        this.mScaleTitle.setText(str);
      }
      if (this.mScaleIndicator != null) {
        this.mScaleIndicator.setWidth(k);
      }
      return;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/mapmode/subview/RGMMScaleLevelView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */