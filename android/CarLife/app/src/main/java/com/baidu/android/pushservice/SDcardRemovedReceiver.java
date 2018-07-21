package com.baidu.android.pushservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.android.pushservice.d.a;

public class SDcardRemovedReceiver
  extends BroadcastReceiver
{
  private static String a = "SDRev";
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent.getAction().equals("android.intent.action.MEDIA_BAD_REMOVAL")) || (paramIntent.getAction().equals("android.intent.action.MEDIA_REMOVED"))) {
      a.a();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/SDcardRemovedReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */