package com.baidu.navisdk.ui.widget.ptrrecyclerview.header;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;

public class Header
  extends BaseHeader
{
  public void getItemOffsets(Rect paramRect, int paramInt, RecyclerView paramRecyclerView)
  {
    if (paramInt == 0) {
      paramRect.set(0, this.mHeaderHeight, 0, 0);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/widget/ptrrecyclerview/header/Header.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */