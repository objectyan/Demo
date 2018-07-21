package com.baidu.carlife.util;

import android.os.Handler;
import android.os.Message;
import android.view.View;

public class i
  extends Handler
{
  private static i a;
  private static View b;
  
  public i() {}
  
  public i(View paramView)
  {
    b = paramView;
  }
  
  public static i a(View paramView)
  {
    if (a == null) {
      a = new i();
    }
    b = paramView;
    return a;
  }
  
  public void a()
  {
    a(200L);
  }
  
  public void a(long paramLong)
  {
    sendEmptyMessageDelayed(0, paramLong);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (b != null) {
      b.requestFocus(0);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/util/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */