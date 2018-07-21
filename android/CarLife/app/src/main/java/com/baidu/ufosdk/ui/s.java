package com.baidu.ufosdk.ui;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

final class s
  implements AbsListView.OnScrollListener
{
  s(FeedbackFacePageActivity paramFeedbackFacePageActivity) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    try
    {
      if ((this.a.getCurrentFocus() != null) && (this.a.getCurrentFocus().getWindowToken() != null))
      {
        paramAbsListView = (InputMethodManager)this.a.getSystemService("input_method");
        if (paramAbsListView != null) {
          paramAbsListView.hideSoftInputFromWindow(this.a.getCurrentFocus().getWindowToken(), 2);
        }
      }
      return;
    }
    catch (Exception paramAbsListView)
    {
      paramAbsListView.printStackTrace();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/ui/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */