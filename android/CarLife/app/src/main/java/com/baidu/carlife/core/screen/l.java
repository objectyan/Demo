package com.baidu.carlife.core.screen;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

public abstract interface l
{
  public abstract void hideMapFragment();
  
  public abstract void innerNameSearch(String paramString);
  
  public abstract void openNavi();
  
  public abstract void openNavi(Bundle paramBundle);
  
  public abstract void openNaviFromOutSide(int paramInt, Bundle paramBundle);
  
  public abstract void performOpenHome();
  
  public abstract void setBottomBarBackgroud(Drawable paramDrawable);
  
  public abstract void setBottomBarStatus(boolean paramBoolean);
  
  public abstract boolean showConnectForbidDialog();
  
  public abstract void showMapFragment();
  
  public abstract void startCalcRoute(a parama);
  
  public abstract void updateGaussianBlurBackground();
  
  public abstract void updateMainDisplayStatus(int paramInt);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/core/screen/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */