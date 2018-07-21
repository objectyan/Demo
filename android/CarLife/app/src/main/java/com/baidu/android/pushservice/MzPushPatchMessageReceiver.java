package com.baidu.android.pushservice;

import android.content.Context;
import android.content.Intent;
import com.baidu.android.pushservice.j.p;
import com.meizu.cloud.pushsdk.MzPushMessageReceiver;
import com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus;
import com.meizu.cloud.pushsdk.platform.message.RegisterStatus;
import com.meizu.cloud.pushsdk.platform.message.SubAliasStatus;
import com.meizu.cloud.pushsdk.platform.message.SubTagsStatus;
import com.meizu.cloud.pushsdk.platform.message.UnRegisterStatus;

public class MzPushPatchMessageReceiver
  extends MzPushMessageReceiver
{
  public void onMessage(Context paramContext, String paramString) {}
  
  public void onNotificationArrived(Context paramContext, String paramString1, String paramString2, String paramString3) {}
  
  public void onNotificationClicked(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    try
    {
      Intent localIntent = new Intent("com.meizu.mzpush.PUSH_MSG");
      localIntent.putExtra("mz_notification_title", paramString1);
      localIntent.putExtra("mz_notification_content", paramString2);
      localIntent.putExtra("mz_notification_self_define_content", paramString3);
      localIntent.putExtra("mz_push_msg_type", 3);
      p.a(localIntent, paramContext.getApplicationContext());
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public void onNotificationDeleted(Context paramContext, String paramString1, String paramString2, String paramString3) {}
  
  public void onPushStatus(Context paramContext, PushSwitchStatus paramPushSwitchStatus) {}
  
  public void onRegister(Context paramContext, String paramString) {}
  
  public void onRegisterStatus(Context paramContext, RegisterStatus paramRegisterStatus)
  {
    if (paramRegisterStatus != null) {}
    try
    {
      String str = paramRegisterStatus.getPushId();
      Intent localIntent = new Intent("com.meizu.mzpush.REGISTER");
      localIntent.putExtra("mz_pushid", str);
      localIntent.putExtra("mz_register_errorcode", paramRegisterStatus.getCode());
      p.a(localIntent, paramContext.getApplicationContext());
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public void onSubAliasStatus(Context paramContext, SubAliasStatus paramSubAliasStatus) {}
  
  public void onSubTagsStatus(Context paramContext, SubTagsStatus paramSubTagsStatus) {}
  
  public void onUnRegister(Context paramContext, boolean paramBoolean) {}
  
  public void onUnRegisterStatus(Context paramContext, UnRegisterStatus paramUnRegisterStatus) {}
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/MzPushPatchMessageReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */