package com.baidu.navisdk.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.navisdk.ui.util.BNStyleManager;

public class BNScaleLevelView
{
  private View mAppNameIV = null;
  private Context mContext;
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
    if ((paramView == null) || (paramContext == null)) {}
    do
    {
      return;
      this.mContext = paramContext;
      this.mScaleTitle = ((TextView)paramView.findViewById(1711866155));
      this.mScaleIndicator = ((TextView)paramView.findViewById(1711866156));
      this.mAppNameIV = paramView.findViewById(1711865954);
    } while (this.mAppNameIV == null);
    this.mAppNameIV.setVisibility(8);
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
        this.mScaleIndicator.setBackgroundDrawable(BNStyleManager.getDrawable(1711407387));
      }
      return;
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


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/widget/BNScaleLevelView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */