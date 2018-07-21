package com.baidu.mapframework.widget;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.support.v4.app.FragmentActivity;

public class MProgressDialog
{
  static BMProgressDialog a;
  static final int b = 1;
  
  private static void a(FragmentActivity paramFragmentActivity, int paramInt, String paramString1, String paramString2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    
    if ((a(paramFragmentActivity)) && (paramFragmentActivity.getSupportFragmentManager() != null)) {}
    try
    {
      a = BMProgressDialog.a(paramInt, paramOnCancelListener);
      a.show(paramFragmentActivity.getSupportFragmentManager(), "BMProgressDialog");
      return;
    }
    catch (Exception paramFragmentActivity) {}
  }
  
  private static boolean a(Activity paramActivity)
  {
    return (paramActivity != null) && (!paramActivity.isFinishing());
  }
  
  public static void dismiss()
  {
    if ((a != null) && (a.getFragmentManager() != null)) {
      a.dismiss();
    }
    a = null;
  }
  
  public static void show(FragmentActivity paramFragmentActivity, int paramInt, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    a(paramFragmentActivity, paramInt, null, null, paramOnCancelListener);
  }
  
  public static void show(FragmentActivity paramFragmentActivity, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    a(paramFragmentActivity, 0, null, null, paramOnCancelListener);
  }
  
  public static void show(FragmentActivity paramFragmentActivity, String paramString1, String paramString2)
  {
    a(paramFragmentActivity, 0, paramString1, paramString2, new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
  }
  
  public static void show(FragmentActivity paramFragmentActivity, String paramString1, String paramString2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    a(paramFragmentActivity, 0, paramString1, paramString2, paramOnCancelListener);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/widget/MProgressDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */