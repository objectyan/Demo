package com.baidu.navi.util;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;

public class ListViewUtils
{
  public static void setListViewHeightBasedOnChildren(ListView paramListView)
  {
    ListAdapter localListAdapter = paramListView.getAdapter();
    if (localListAdapter == null) {
      return;
    }
    int j = 0;
    int i = 0;
    int m = localListAdapter.getCount();
    for (;;)
    {
      if (i >= m) {
        break label91;
      }
      localObject = null;
      try
      {
        View localView = localListAdapter.getView(i, null, paramListView);
        localObject = localView;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          int k;
          localException.printStackTrace();
        }
      }
      k = j;
      if (localObject != null)
      {
        ((View)localObject).measure(0, 0);
        k = j + ((View)localObject).getMeasuredHeight();
      }
      i += 1;
      j = k;
    }
    label91:
    Object localObject = paramListView.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = (paramListView.getDividerHeight() * (localListAdapter.getCount() - 1) + j);
    paramListView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/util/ListViewUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */