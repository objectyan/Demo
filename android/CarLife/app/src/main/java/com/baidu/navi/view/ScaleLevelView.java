package com.baidu.navi.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.navi.style.StyleManager;
import com.baidu.navisdk.util.common.LogUtil;

public class ScaleLevelView
{
  private Context mContext;
  private boolean mIsForRouteDetails = false;
  private TextView mScaleIndicator = null;
  private TextView mScaleTitle = null;
  private boolean visibility;
  
  public void hide()
  {
    if (this.mScaleTitle.isShown()) {
      this.mScaleTitle.setVisibility(4);
    }
    if (this.mScaleIndicator.isShown()) {
      this.mScaleIndicator.setVisibility(4);
    }
    this.visibility = false;
  }
  
  public void initView(Context paramContext, View paramView)
  {
    if ((paramView == null) || (paramContext == null)) {
      return;
    }
    this.mContext = paramContext;
    if (this.mIsForRouteDetails)
    {
      i = 1711866155;
      this.mScaleTitle = ((TextView)paramView.findViewById(i));
      if (!this.mIsForRouteDetails) {
        break label65;
      }
    }
    label65:
    for (int i = 1711866156;; i = 2131624955)
    {
      this.mScaleIndicator = ((TextView)paramView.findViewById(i));
      return;
      i = 2131624954;
      break;
    }
  }
  
  public void initView(Context paramContext, View paramView, boolean paramBoolean)
  {
    this.mIsForRouteDetails = paramBoolean;
    initView(paramContext, paramView);
  }
  
  @SuppressLint({"NewApi"})
  public void onUpdateStyle(boolean paramBoolean)
  {
    int i = -13223362;
    LogUtil.e("ScaleView", "update style:" + paramBoolean);
    TextView localTextView;
    if (!this.mIsForRouteDetails)
    {
      if (this.mScaleTitle != null)
      {
        localTextView = this.mScaleTitle;
        if (!paramBoolean) {
          break label76;
        }
      }
      for (;;)
      {
        localTextView.setTextColor(i);
        if (this.mScaleIndicator != null) {
          this.mScaleIndicator.setBackgroundDrawable(StyleManager.getDrawable(2130837802, paramBoolean));
        }
        return;
        label76:
        i = -1052432;
      }
    }
    if (this.mScaleTitle != null)
    {
      localTextView = this.mScaleTitle;
      if (!paramBoolean) {
        break label124;
      }
    }
    for (;;)
    {
      localTextView.setTextColor(i);
      if (this.mScaleIndicator == null) {
        break;
      }
      this.mScaleIndicator.setBackgroundDrawable(StyleManager.getDrawable(2130837802, paramBoolean));
      return;
      label124:
      i = -1052432;
    }
  }
  
  public void show()
  {
    if (this.mScaleTitle != null) {
      this.mScaleTitle.setVisibility(0);
    }
    if (this.mScaleIndicator != null) {
      this.mScaleIndicator.setVisibility(0);
    }
    this.visibility = true;
  }
  
  public void updateScaleView(String paramString, int paramInt)
  {
    this.mScaleTitle.setText(paramString);
    this.mScaleIndicator.setWidth(paramInt);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/view/ScaleLevelView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */