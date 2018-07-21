package com.baidu.navisdk.ui.widget;

import android.app.Activity;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.jar.JarUtils;

public class BNYawingProgressDialog
  extends BNVolumeKeyDownDialog
{
  private Activity mActivity;
  private Animation mAnim;
  private ImageView mCloseIV;
  private TextView mLoadingTipTV;
  private DialogInterface.OnCancelListener mOnCancelListener = null;
  private ImageView mProgress;
  
  public BNYawingProgressDialog(Activity paramActivity)
  {
    super(paramActivity);
    this.mActivity = paramActivity;
    Object localObject;
    if (Build.VERSION.SDK_INT < 21)
    {
      localObject = JarUtils.getResources().newTheme();
      ((Resources.Theme)localObject).applyStyle(1711996939, true);
      JarUtils.setDialogThemeField(this, (Resources.Theme)localObject);
    }
    try
    {
      for (;;)
      {
        paramActivity = JarUtils.inflate(paramActivity, 1711472785, null);
        if (paramActivity != null) {
          break;
        }
        return;
        localObject = getWindow();
        requestWindowFeature(1);
        ((Window)localObject).setBackgroundDrawableResource(17170445);
        ((Window)localObject).getAttributes().gravity = 17;
      }
    }
    catch (Exception paramActivity)
    {
      for (;;)
      {
        paramActivity = null;
      }
      setContentView(paramActivity);
      setCanceledOnTouchOutside(false);
      setCancelable(true);
      this.mLoadingTipTV = ((TextView)findViewById(1711865903));
      this.mCloseIV = ((ImageView)findViewById(1711865904));
      this.mProgress = ((ImageView)findViewById(1711865902));
      this.mCloseIV.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (BNYawingProgressDialog.this.mOnCancelListener != null) {
            BNYawingProgressDialog.this.mOnCancelListener.onCancel(BNYawingProgressDialog.this);
          }
          BNYawingProgressDialog.this.dismiss();
        }
      });
    }
  }
  
  public BNYawingProgressDialog setMessage(String paramString)
  {
    this.mLoadingTipTV.setText(paramString);
    return this;
  }
  
  public void setOnCancelListener(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    this.mOnCancelListener = paramOnCancelListener;
    super.setOnCancelListener(paramOnCancelListener);
  }
  
  public void startProgressAnim()
  {
    this.mAnim = BNStyleManager.loadAnimation(this.mActivity, 1711538195);
    LinearInterpolator localLinearInterpolator = new LinearInterpolator();
    this.mAnim.setInterpolator(localLinearInterpolator);
    if ((this.mAnim != null) && (localLinearInterpolator != null)) {
      this.mProgress.startAnimation(this.mAnim);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/widget/BNYawingProgressDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */