package com.baidu.carlife.f;

import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;

public class i
  extends a
{
  public i(WebView paramWebView, int paramInt)
  {
    super(paramWebView, paramInt);
    paramWebView.setOnKeyListener(this);
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    com.baidu.carlife.core.i.e("FocusArea", "keycode = " + paramInt + ", event = " + paramKeyEvent.toString());
    if ((paramKeyEvent != null) && (paramKeyEvent.getAction() == 0)) {}
    switch (paramInt)
    {
    default: 
      bool = super.onKey(paramView, paramInt, paramKeyEvent);
    case 19: 
    case 20: 
    case 21: 
    case 22: 
    case 23: 
      return bool;
    case 300: 
      com.baidu.carlife.core.i.b("FocusArea", "WebView: KEYCODE_KONB_CLOCKWISE ");
      this.r.onKeyDown(20, paramKeyEvent);
      return true;
    }
    com.baidu.carlife.core.i.b("FocusArea", "WebView: KEYCODE_KONB_ANTI_CLOCKWISE ");
    this.r.onKeyDown(19, paramKeyEvent);
    return true;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/f/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */