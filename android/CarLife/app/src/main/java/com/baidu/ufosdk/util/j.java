package com.baidu.ufosdk.util;

import android.app.Activity;
import android.os.Handler;
import android.widget.Toast;

final class j
  implements Runnable
{
  j(Activity paramActivity, String paramString, long paramLong) {}
  
  public final void run()
  {
    Toast localToast = Toast.makeText(this.a, this.b, 1);
    localToast.show();
    new Handler().postDelayed(new k(this, localToast), this.c);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/util/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */