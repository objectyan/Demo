package com.baidu.mapframework.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.Window;
import com.baidu.platform.comapi.util.f;

public class BMProgressDialog
  extends DialogFragment
{
  private static final String a = "title";
  private static final String b = "message";
  private static final String c = "layout_resid";
  private static DialogInterface.OnCancelListener d;
  private boolean e = false;
  
  public static BMProgressDialog a(int paramInt, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    return a(null, null, paramInt, paramOnCancelListener);
  }
  
  public static BMProgressDialog a(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2, 0, null);
  }
  
  private static BMProgressDialog a(String paramString1, String paramString2, int paramInt, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    d = paramOnCancelListener;
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
  
  public static BMProgressDialog a(String paramString1, String paramString2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    return a(paramString1, paramString2, 0, paramOnCancelListener);
  }
  
  public void dismiss()
  {
    this.e = true;
    if (getActivity() != null) {}
    try
    {
      dismissAllowingStateLoss();
      d = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        f.a(BMProgressDialog.class.getSimpleName(), "exception", localException);
      }
    }
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (d != null) {
      d.onCancel(paramDialogInterface);
    }
    d = null;
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    return new a(getActivity(), getArguments().getInt("layout_resid"));
  }
  
  public class a
    extends Dialog
  {
    private final int b = 2130968714;
    private int c = 2130968714;
    
    public a(Context paramContext, int paramInt)
    {
      super(2131427455);
      if (paramInt != 0) {
        this.c = paramInt;
      }
      setContentView(this.c);
      getWindow().getAttributes().gravity = 17;
    }
    
    public void show()
    {
      try
      {
        if (!BMProgressDialog.a(BMProgressDialog.this))
        {
          super.show();
          return;
        }
        BMProgressDialog.this.dismissAllowingStateLoss();
        return;
      }
      catch (Exception localException)
      {
        f.a(BMProgressDialog.class.getSimpleName(), "exception", localException);
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/widget/BMProgressDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */