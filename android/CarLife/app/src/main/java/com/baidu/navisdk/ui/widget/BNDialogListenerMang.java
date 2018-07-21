package com.baidu.navisdk.ui.widget;

public class BNDialogListenerMang
{
  private static BNDialogListenerMang mInstance;
  private BNDialogListener bnDialogListener;
  
  public static BNDialogListenerMang getInstance()
  {
    if (mInstance == null) {
      mInstance = new BNDialogListenerMang();
    }
    return mInstance;
  }
  
  public BNDialogListener getBNDialogListener()
  {
    return this.bnDialogListener;
  }
  
  public void setBNDialogListener(BNDialogListener paramBNDialogListener)
  {
    this.bnDialogListener = paramBNDialogListener;
  }
  
  public static abstract interface BNDialogListener
  {
    public abstract void onDismiss(String paramString);
    
    public abstract void onShow(String paramString1, String paramString2, BNDialog paramBNDialog);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/widget/BNDialogListenerMang.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */