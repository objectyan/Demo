package com.baidu.ufosdk.ui;

import android.content.Context;
import com.baidu.ufosdk.UfoSDK;
import com.baidu.ufosdk.e.a;

final class cl
  implements Runnable
{
  cl(cj paramcj) {}
  
  public final void run()
  {
    Context localContext = cj.a(this.a).getApplicationContext();
    String str = UfoSDK.clientid;
    a.b(localContext);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/ui/cl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */