package com.baidu.navi.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.Window;

public class BMProgressDialog
  extends DialogFragment
{
  private static final String LAYOUT_RESID = "layout_resid";
  private static final String MESSAGE = "message";
  private static final String TITLE = "title";
  private static DialogInterface.OnCancelListener mCancelListener;
  private boolean isDestroyed = false;
  
  private static BMProgressDialog create(String paramString1, String paramString2, int paramInt, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    mCancelListener = paramOnCancelListener;
    paramOnCancelListener = new BMProgressDialog();
    Bundle localBundle = new Bundle();
    if (paramString1 != null) {
      localBundle.putString("title", paramString1);
    }
    if (paramString2 != null) {
      localBundle.putString("message", paramString2);
    }
    localBundle.putInt("layout_resid", paramInt);
    paramOnCancelListener.setArguments(localBundle);
    return paramOnCancelListener;
  }
  
  public static BMProgressDialog newInstance(int paramInt, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    return create(null, null, paramInt, paramOnCancelListener);
  }
  
  public static BMProgressDialog newInstance(String paramString1, String paramString2)
  {
    return create(paramString1, paramString2, 0, null);
  }
  
  public static BMProgressDialog newInstance(String paramString1, String paramString2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    return create(paramString1, paramString2, 0, paramOnCancelListener);
  }
  
  public void dismiss()
  {
    this.isDestroyed = true;
    if (getActivity() != null) {}
    try
    {
      dismissAllowingStateLoss();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (mCancelListener != null) {
      mCancelListener.onCancel(paramDialogInterface);
    }
    mCancelListener = null;
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    return new INProgressDialog(getActivity(), getArguments().getInt("layout_resid"));
  }
  
  public class INProgressDialog
    extends Dialog
  {
    private static final int COMMON_RESID = 2130968714;
    private int mLayoutResId = 2130968714;
    
    public INProgressDialog(Context paramContext, int paramInt)
    {
      super(2131427455);
      if (paramInt != 0) {
        this.mLayoutResId = paramInt;
      }
      setContentView(this.mLayoutResId);
      getWindow().getAttributes().gravity = 17;
    }
    
    public void show()
    {
      try
      {
        if (!BMProgressDialog.this.isDestroyed)
        {
          super.show();
          return;
        }
        BMProgressDialog.this.dismissAllowingStateLoss();
        return;
      }
      catch (Exception localException) {}
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/widget/BMProgressDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */