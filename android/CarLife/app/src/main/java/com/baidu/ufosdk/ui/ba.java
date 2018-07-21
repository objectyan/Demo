package com.baidu.ufosdk.ui;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.baidu.ufosdk.util.m;

final class ba
  implements Runnable
{
  ba(az paramaz, String paramString) {}
  
  public final void run()
  {
    SharedPreferences.Editor localEditor = this.a.a.getSharedPreferences("UfoSharePreference", 0).edit();
    localEditor.putString("contact", m.a(this.b));
    localEditor.commit();
    FeedbackInputActivity.c(this.a.a, this.b);
    FeedbackInputActivity.P(this.a.a);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/ui/ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */