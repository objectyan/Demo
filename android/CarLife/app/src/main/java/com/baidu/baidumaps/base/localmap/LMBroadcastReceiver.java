package com.baidu.baidumaps.base.localmap;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class LMBroadcastReceiver
  extends BroadcastReceiver
{
  private void a(Context paramContext)
  {
    b.a(paramContext).b();
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramIntent = paramIntent.getAction();
    if ((paramIntent != null) && (paramIntent.equals("com.baidu.BaiduMap.ON_LM_NOTIFICATION_FINISHED"))) {
      a(paramContext);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidumaps/base/localmap/LMBroadcastReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */