package com.baidu.navisdk.ui.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.baidu.navisdk.util.jar.JarUtils;

public class BNQuitNaviDialog
  extends Dialog
{
  public static final int TYPE_COMPLETE_UGC = 2;
  public static final int TYPE_QUIT_NAVI = 1;
  private TextView cancleTv = null;
  private TextView completeUgcInfoTv = null;
  private OnNaviClickListener listener = null;
  private TextView quitNaviTv = null;
  
  public BNQuitNaviDialog(Activity paramActivity)
  {
    super(paramActivity);
    Resources.Theme localTheme = JarUtils.getResources().newTheme();
    localTheme.applyStyle(1711996937, true);
    JarUtils.setDialogThemeField(this, localTheme);
    paramActivity = JarUtils.inflate(paramActivity, 1711472695, null);
    try
    {
      setContentView(paramActivity);
      this.completeUgcInfoTv = ((TextView)paramActivity.findViewById(1711866364));
      this.cancleTv = ((TextView)paramActivity.findViewById(1711866366));
      this.quitNaviTv = ((TextView)paramActivity.findViewById(1711866365));
      this.completeUgcInfoTv.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (BNQuitNaviDialog.this.listener != null) {
            BNQuitNaviDialog.this.listener.onClick(2);
          }
        }
      });
      this.cancleTv.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          BNQuitNaviDialog.this.dismiss();
        }
      });
      this.quitNaviTv.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (BNQuitNaviDialog.this.listener != null) {
            BNQuitNaviDialog.this.listener.onClick(1);
          }
        }
      });
      return;
    }
    catch (Throwable paramActivity) {}
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    if (this.quitNaviTv != null) {
      this.quitNaviTv.performClick();
    }
  }
  
  public BNQuitNaviDialog setOnBtnClickListener(OnNaviClickListener paramOnNaviClickListener)
  {
    this.listener = paramOnNaviClickListener;
    return this;
  }
  
  public void setUgcInfoTv(boolean paramBoolean)
  {
    if (this.completeUgcInfoTv != null)
    {
      if (paramBoolean) {
        this.completeUgcInfoTv.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.completeUgcInfoTv.setVisibility(8);
  }
  
  public static abstract interface OnNaviClickListener
  {
    public abstract void onClick(int paramInt);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/widget/BNQuitNaviDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */