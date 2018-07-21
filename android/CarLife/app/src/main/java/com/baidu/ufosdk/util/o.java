package com.baidu.ufosdk.util;

import android.app.Activity;
import android.content.Intent;
import com.baidu.ufosdk.ui.FeedbackInputActivity;
import java.io.ByteArrayOutputStream;

final class o
  implements Runnable
{
  o(n paramn, Activity paramActivity, int paramInt) {}
  
  public final void run()
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this.b, FeedbackInputActivity.class);
    localIntent.putExtra("shot", n.a(this.a).toByteArray());
    localIntent.putExtra("currentview", 1);
    localIntent.putExtra("feedback_channel", this.c);
    this.b.startActivity(localIntent);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/util/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */