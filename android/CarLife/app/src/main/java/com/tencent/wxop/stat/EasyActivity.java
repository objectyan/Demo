package com.tencent.wxop.stat;

import android.app.Activity;

public class EasyActivity
  extends Activity
{
  protected void onPause()
  {
    super.onPause();
    i.c(this);
  }
  
  protected void onResume()
  {
    super.onResume();
    i.b(this);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/tencent/wxop/stat/EasyActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */