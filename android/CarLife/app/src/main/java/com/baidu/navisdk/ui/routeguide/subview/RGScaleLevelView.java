package com.baidu.navisdk.ui.routeguide.subview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.ui.routeguide.control.NMapControlProxy;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;

public class RGScaleLevelView
{
  private Context mContext;
  private RelativeLayout mLayout = null;
  private TextView mScaleIndicator = null;
  private TextView mScaleTitle = null;
  
  public RGScaleLevelView(Context paramContext, View paramView)
  {
    this.mContext = paramContext;
    this.mLayout = ((RelativeLayout)paramView.findViewById(1711866587));
    this.mScaleTitle = ((TextView)paramView.findViewById(1711866588));
    this.mScaleIndicator = ((TextView)paramView.findViewById(1711866589));
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
    int i;
    TextView localTextView;
    if (this.mScaleTitle != null)
    {
      localObject = this.mScaleTitle;
      if (paramBoolean)
      {
        i = -13223362;
        ((TextView)localObject).setTextColor(i);
      }
    }
    else if (this.mScaleIndicator != null)
    {
      localTextView = this.mScaleIndicator;
      if (!paramBoolean) {
        break label63;
      }
    }
    label63:
    for (Object localObject = JarUtils.getResources().getDrawable(1711407694);; localObject = JarUtils.getResources().getDrawable(1711407695))
    {
      localTextView.setBackgroundDrawable((Drawable)localObject);
      return;
      i = -1052432;
      break;
    }
  }
  
  public void show()
  {
    if (this.mLayout != null) {
      this.mLayout.setVisibility(0);
    }
  }
  
  public void update()
  {
    int m = NMapControlProxy.getInstance().getScreenWidth();
    int j = NMapControlProxy.getInstance().getZoomLevel();
    double d = NMapControlProxy.getInstance().getZoomUnitsInMeter();
    int i = NMapControlProxy.getScaleDis(j);
    LogUtil.e("Meter", "room updateScale dis=" + i + " level=" + j + " u=" + d);
    for (int k = (int)Math.ceil(i / d); (k > m / 2) && (j >= 3) && (j <= 20); k = (int)Math.ceil(i / d))
    {
      j += 1;
      i = NMapControlProxy.getScaleDis(j);
    }
    if (i >= 1000) {}
    for (String str = i / 1000 + JarUtils.getResources().getString(1711669516);; str = i + JarUtils.getResources().getString(1711669517))
    {
      this.mScaleTitle.setText(str);
      this.mScaleIndicator.setWidth(k);
      return;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/subview/RGScaleLevelView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */