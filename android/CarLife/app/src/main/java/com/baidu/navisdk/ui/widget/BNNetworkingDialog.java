package com.baidu.navisdk.ui.widget;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.jar.JarUtils;

public class BNNetworkingDialog
  extends BNBaseDialog
{
  private OnBackPressedListener mBackPressedListener;
  private TextView mConfirmNetworkingTv;
  private LinearLayout mContentLayout;
  private TextView mDownloadOfflinedataTv;
  private TextView mNetworkingCancleTv;
  private TextView mNetworkingContent;
  
  public BNNetworkingDialog(Activity paramActivity)
  {
    super(paramActivity);
    paramActivity = JarUtils.inflate(paramActivity, 1711472688, null);
    setTitleText(JarUtils.getResources().getString(1711669600));
    setContent(paramActivity);
    this.mContentLayout = ((LinearLayout)paramActivity.findViewById(1711865866));
    this.mNetworkingContent = ((TextView)paramActivity.findViewById(1711866325));
    this.mConfirmNetworkingTv = ((TextView)paramActivity.findViewById(1711866326));
    this.mDownloadOfflinedataTv = ((TextView)paramActivity.findViewById(1711866327));
    this.mNetworkingCancleTv = ((TextView)paramActivity.findViewById(1711866328));
    setCanceledOnTouchOutside(false);
    initStyle();
  }
  
  public void initStyle()
  {
    this.mConfirmNetworkingTv.setBackgroundDrawable(BNStyleManager.getDrawable(1711407374));
    this.mDownloadOfflinedataTv.setBackgroundDrawable(BNStyleManager.getDrawable(1711407374));
    this.mNetworkingCancleTv.setBackgroundDrawable(BNStyleManager.getDrawable(1711407374));
    this.mNetworkingContent.setTextColor(BNStyleManager.getColor(1711800402));
    this.mConfirmNetworkingTv.setTextColor(BNStyleManager.getColor(1711800406));
    this.mDownloadOfflinedataTv.setTextColor(BNStyleManager.getColor(1711800406));
    this.mNetworkingCancleTv.setTextColor(BNStyleManager.getColor(1711800406));
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    if (this.mBackPressedListener != null) {
      this.mBackPressedListener.onBackPressed();
    }
  }
  
  public BNNetworkingDialog setCancleListener(View.OnClickListener paramOnClickListener)
  {
    this.mNetworkingCancleTv.setOnClickListener(paramOnClickListener);
    return this;
  }
  
  public BNNetworkingDialog setConfirmNetworkMessage(String paramString)
  {
    this.mConfirmNetworkingTv.setText(paramString);
    return this;
  }
  
  public BNNetworkingDialog setConfirmNetworkingListener(View.OnClickListener paramOnClickListener)
  {
    this.mConfirmNetworkingTv.setOnClickListener(paramOnClickListener);
    return this;
  }
  
  public BNNetworkingDialog setDownloadListener(View.OnClickListener paramOnClickListener)
  {
    this.mDownloadOfflinedataTv.setOnClickListener(paramOnClickListener);
    return this;
  }
  
  public BNNetworkingDialog setNetworkingContentMessage(String paramString)
  {
    this.mNetworkingContent.setText(paramString);
    return this;
  }
  
  public BNNetworkingDialog setOnBackPressedListener(OnBackPressedListener paramOnBackPressedListener)
  {
    this.mBackPressedListener = paramOnBackPressedListener;
    return this;
  }
  
  public BNNetworkingDialog setOneButtonMode(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mDownloadOfflinedataTv.setVisibility(8);
      this.mNetworkingCancleTv.setVisibility(8);
    }
    return this;
  }
  
  public BNNetworkingDialog setTwoButtonMode(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.mDownloadOfflinedataTv.setVisibility(8);
    }
    return this;
  }
  
  public void show()
  {
    initStyle();
    super.show();
  }
  
  public static abstract interface OnBackPressedListener
  {
    public abstract void onBackPressed();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/widget/BNNetworkingDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */