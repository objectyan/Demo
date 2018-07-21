package com.baidu.navisdk.ui.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.navisdk.util.jar.JarUtils;

public class BNCommonProgressDialog
  extends Dialog
{
  protected ImageView mCloseIV;
  protected TextView mLoadingTipTV;
  protected DialogInterface.OnCancelListener mOnCancelListener = null;
  
  public BNCommonProgressDialog(Activity paramActivity)
  {
    super(paramActivity);
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
        paramActivity = JarUtils.inflate(paramActivity, 1711472657, null);
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
      getWindow().getAttributes().gravity = 17;
      this.mLoadingTipTV = ((TextView)findViewById(1711865903));
      this.mCloseIV = ((ImageView)findViewById(1711865904));
      setCloseIVListener();
    }
  }
  
  public void setCloseGone()
  {
    this.mCloseIV.setVisibility(8);
  }
  
  public void setCloseIVListener()
  {
    this.mCloseIV.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (BNCommonProgressDialog.this.mOnCancelListener != null) {
          BNCommonProgressDialog.this.mOnCancelListener.onCancel(BNCommonProgressDialog.this);
        }
        BNCommonProgressDialog.this.dismiss();
      }
    });
  }
  
  public void setCloseVisible()
  {
    this.mCloseIV.setVisibility(0);
  }
  
  public BNCommonProgressDialog setDimAmount(float paramFloat)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      getWindow().setDimAmount(0.0F);
    }
    return this;
  }
  
  public BNCommonProgressDialog setMessage(String paramString)
  {
    this.mLoadingTipTV.setText(paramString);
    return this;
  }
  
  public void setOnCancelListener(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    this.mOnCancelListener = paramOnCancelListener;
    super.setOnCancelListener(paramOnCancelListener);
  }
  
  public BNCommonProgressDialog setYawingStyleGrivity(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localTheme = JarUtils.getResources().newTheme();
      localTheme.applyStyle(1711996941, true);
      JarUtils.setDialogThemeField(this, localTheme);
      getWindow().getAttributes().gravity = 51;
      return this;
    }
    Resources.Theme localTheme = JarUtils.getResources().newTheme();
    localTheme.applyStyle(1711996939, true);
    JarUtils.setDialogThemeField(this, localTheme);
    getWindow().getAttributes().gravity = 17;
    return this;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/widget/BNCommonProgressDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */