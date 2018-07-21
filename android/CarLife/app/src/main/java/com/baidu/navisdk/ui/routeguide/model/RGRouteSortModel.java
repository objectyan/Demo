package com.baidu.navisdk.ui.routeguide.model;

public class RGRouteSortModel
{
  public String mItemName = null;
  public int mPreferValue = 0;
  
  public RGRouteSortModel(String paramString, int paramInt)
  {
    this.mItemName = paramString;
    this.mPreferValue = paramInt;
  }
  
  public void reset()
  {
    this.mItemName = null;
    this.mPreferValue = 0;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/model/RGRouteSortModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */