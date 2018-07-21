package com.baidu.navi.widget;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.support.v4.app.FragmentActivity;

public class MProgressDialog
{
  static final int RUNNING_TASK_SIZE = 1;
  static BMProgressDialog mBMProgressDialog;
  
  public static void dismiss()
  {
    if ((mBMProgressDialog != null) && (mBMProgressDialog.getFragmentManager() != null)) {
      mBMProgressDialog.dismiss();
    }
    mBMProgressDialog = null;
  }
  
  private static boolean isActivityRunning(Activity paramActivity)
  {
    return (paramActivity != null) && (!paramActivity.isFinishing());
  }
  
  public static void show(FragmentActivity paramFragmentActivity, int paramInt, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    showDialog(paramFragmentActivity, paramInt, null, null, paramOnCancelListener);
  }
  
  public static void show(FragmentActivity paramFragmentActivity, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    showDialog(paramFragmentActivity, 0, null, null, paramOnCancelListener);
  }
  
  public static void show(FragmentActivity paramFragmentActivity, String paramString1, String paramString2)
  {
    showDialog(paramFragmentActivity, 0, paramString1, paramString2, new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
  }
  
  public static void show(FragmentActivity paramFragmentActivity, String paramString1, String paramString2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    showDialog(paramFragmentActivity, 0, paramString1, paramString2, paramOnCancelListener);
  }
  
  private static void showDialog(FragmentActivity paramFragmentActivity, int paramInt, String paramString1, String paramString2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    
    if ((isActivityRunning(paramFragmentActivity)) && (paramFragmentActivity.getSupportFragmentManager() != null)) {}
    try
    {
      mBMProgressDialog = BMProgressDialog.newInstance(paramInt, paramOnCancelListener);
      mBMProgressDialog.show(paramFragmentActivity.getSupportFragmentManager(), "BMProgressDialog");
      return;
    }
    catch (Exception paramFragmentActivity) {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/widget/MProgressDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */