package com.baidu.navisdk.ui.widget.ptrrecyclerview.header;

import android.support.v7.widget.RecyclerView.ItemDecoration;

public class BaseHeader
  extends RecyclerView.ItemDecoration
{
  protected int mHeaderHeight;
  
  public int getHeight()
  {
    return this.mHeaderHeight;
  }
  
  public void setHeight(int paramInt)
  {
    this.mHeaderHeight = paramInt;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/widget/ptrrecyclerview/header/BaseHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */