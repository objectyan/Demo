package com.baidu.navisdk.ui.disclaimer.control;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.util.jar.JarUtils;

public class DisclaimerController
  implements View.OnClickListener
{
  private CheckBox mCheckBox;
  private final Disclaimer mDisclaimer;
  private final IDisclaimerListener mDisclaimerListener;
  
  public DisclaimerController(Disclaimer paramDisclaimer, IDisclaimerListener paramIDisclaimerListener)
  {
    this.mDisclaimer = paramDisclaimer;
    this.mDisclaimerListener = paramIDisclaimerListener;
  }
  
  private static String getLocalCacheKey(Disclaimer.Type paramType)
  {
    return "NAVI_SHOW_DISCLAIMER_" + paramType.getName();
  }
  
  public static Disclaimer getShowDisclaimer(int paramInt)
  {
    Disclaimer.Type localType = null;
    Object localObject2 = null;
    if (paramInt == 1) {
      localType = Disclaimer.Type.INTERNATIONAL;
    }
    Object localObject1 = localObject2;
    if (localType != null)
    {
      localObject1 = localObject2;
      if (BNSettingManager.isDisclaimerShow(getLocalCacheKey(localType)))
      {
        localObject1 = localObject2;
        if (localType == Disclaimer.Type.INTERNATIONAL) {
          localObject1 = new Disclaimer(localType, 1711472680);
        }
      }
    }
    return (Disclaimer)localObject1;
  }
  
  private void onReceiveDisclaimer()
  {
    String str;
    if ((this.mCheckBox != null) && (this.mDisclaimer != null))
    {
      str = getLocalCacheKey(this.mDisclaimer.getType());
      if (this.mCheckBox.isChecked()) {
        break label59;
      }
    }
    label59:
    for (boolean bool = true;; bool = false)
    {
      BNSettingManager.setDisclaimerShow(str, bool);
      if (this.mDisclaimerListener != null) {
        this.mDisclaimerListener.onReceiveDisclaimer();
      }
      return;
    }
  }
  
  private void onRejectDisclaimer()
  {
    if (this.mDisclaimerListener != null) {
      this.mDisclaimerListener.onRejectDisclaimer();
    }
  }
  
  public View getDisclaimerView(Activity paramActivity)
  {
    TextView localTextView1 = null;
    Object localObject = null;
    if (this.mDisclaimer != null) {
      localObject = localTextView1;
    }
    try
    {
      paramActivity = JarUtils.inflate(paramActivity, this.mDisclaimer.getLayoutId(), null);
      localObject = paramActivity;
      if (paramActivity != null)
      {
        localObject = paramActivity;
        TextView localTextView2 = (TextView)paramActivity.findViewById(1711866136);
        localObject = paramActivity;
        localTextView1 = (TextView)paramActivity.findViewById(1711866137);
        localObject = paramActivity;
        this.mCheckBox = ((CheckBox)paramActivity.findViewById(1711866134));
        if (localTextView2 != null)
        {
          localObject = paramActivity;
          localTextView2.setOnClickListener(this);
        }
        localObject = paramActivity;
        if (localTextView1 != null)
        {
          localObject = paramActivity;
          localTextView1.setOnClickListener(this);
          localObject = paramActivity;
        }
      }
      return (View)localObject;
    }
    catch (Exception paramActivity)
    {
      paramActivity.printStackTrace();
    }
    return (View)localObject;
  }
  
  public void onClick(View paramView)
  {
    if (paramView != null) {}
    switch (paramView.getId())
    {
    default: 
      return;
    case 1711866136: 
      onRejectDisclaimer();
      return;
    }
    onReceiveDisclaimer();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/disclaimer/control/DisclaimerController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */