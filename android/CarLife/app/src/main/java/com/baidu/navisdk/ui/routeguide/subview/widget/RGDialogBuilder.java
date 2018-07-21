package com.baidu.navisdk.ui.routeguide.subview.widget;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;

public class RGDialogBuilder
  extends AlertDialog.Builder
{
  boolean mCanceledOnTouchOutside;
  DialogInterface.OnKeyListener onKeyListener;
  
  public RGDialogBuilder(Context paramContext)
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
        if (RGDialogBuilder.this.onKeyListener != null) {
          return RGDialogBuilder.this.onKeyListener.onKey(paramAnonymousDialogInterface, paramAnonymousInt, paramAnonymousKeyEvent);
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


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/subview/widget/RGDialogBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */