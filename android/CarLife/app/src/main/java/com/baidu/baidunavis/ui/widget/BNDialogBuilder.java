package com.baidu.baidunavis.ui.widget;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;

public class BNDialogBuilder
  extends AlertDialog.Builder
{
  boolean mCanceledOnTouchOutside;
  DialogInterface.OnKeyListener onKeyListener;
  
  public BNDialogBuilder(Context paramContext)
  {
    super(paramContext);
    setCancelable(false);
  }
  
  public AlertDialog create()
  {
    AlertDialog localAlertDialog = super.create();
    localAlertDialog.setCanceledOnTouchOutside(this.mCanceledOnTouchOutside);
    localAlertDialog.setOnKeyListener(new DialogInterface.OnKeyListener()
    {
      public boolean onKey(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        if (paramAnonymousInt == 84) {
          return true;
        }
        if (BNDialogBuilder.this.onKeyListener != null) {
          return BNDialogBuilder.this.onKeyListener.onKey(paramAnonymousDialogInterface, paramAnonymousInt, paramAnonymousKeyEvent);
        }
        return false;
      }
    });
    return localAlertDialog;
  }
  
  public void setCanceledOnTouchOutside(boolean paramBoolean)
  {
    this.mCanceledOnTouchOutside = paramBoolean;
  }
  
  public AlertDialog.Builder setOnKeyListener(DialogInterface.OnKeyListener paramOnKeyListener)
  {
    this.onKeyListener = paramOnKeyListener;
    return this;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidunavis/ui/widget/BNDialogBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */