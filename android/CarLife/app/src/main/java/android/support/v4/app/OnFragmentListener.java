package android.support.v4.app;

import android.app.Dialog;
import android.view.Window;

public abstract interface OnFragmentListener
{
  public abstract void attachHost();
  
  public abstract void bindDialog(Dialog paramDialog);
  
  public abstract FragmentManager getSupportFragmentManager();
  
  public abstract void onFragmentStart();
  
  public abstract void onFragmentStop();
  
  public abstract void setFragmentWindow(Window paramWindow);
  
  public abstract void setVehicleConnected(boolean paramBoolean);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/android/support/v4/app/OnFragmentListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */