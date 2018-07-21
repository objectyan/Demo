package com.baidu.navisdk.ui.routeguide.model;

public class RGHorizontalMenuNode
{
  public String mButtonName;
  public boolean mIsTopShow;
  public String mMenuName;
  public int mResId;
  
  public RGHorizontalMenuNode(String paramString1, int paramInt, boolean paramBoolean, String paramString2)
  {
    this.mMenuName = paramString1;
    this.mResId = paramInt;
    this.mIsTopShow = paramBoolean;
    this.mButtonName = paramString2;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/model/RGHorizontalMenuNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */