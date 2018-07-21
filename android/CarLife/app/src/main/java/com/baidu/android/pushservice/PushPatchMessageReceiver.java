package com.baidu.android.pushservice;

import android.content.Context;
import android.content.Intent;
import com.baidu.android.pushservice.j.p;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.mipush.sdk.PushMessageReceiver;
import java.util.List;

public class PushPatchMessageReceiver
  extends PushMessageReceiver
{
  public static final int MSG_ARRIVED = 2;
  public static final int MSG_CLICKED = 3;
  public static final int MSG_PASS = 1;
  public static final String PUSH_MSG = "xm_push_msg";
  public static final String PUSH_MSG_TYPE = "xm_push_msg_type";
  public static final String REGID = "xm_regid";
  public static final String REGISTER_ERRORCODE = "xm_register_errorcode";
  private static final String TAG = "PushPatchMessageReceiver";
  public static final String XIAOMI_PUSH_MSG = "com.xiaomi.mipush.PUSH_MSG";
  public static final String XIAOMI_REGISTER = "com.xiaomi.mipush.REGISTER";
  
  private void handleXiaomiMsg(Context paramContext, MiPushMessage paramMiPushMessage, int paramInt)
  {
    try
    {
      Intent localIntent = new Intent("com.xiaomi.mipush.PUSH_MSG");
      localIntent.putExtra("xm_push_msg", paramMiPushMessage);
      localIntent.putExtra("xm_push_msg_type", paramInt);
      p.a(localIntent, paramContext.getApplicationContext());
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public void onNotificationMessageArrived(Context paramContext, MiPushMessage paramMiPushMessage)
  {
    super.onNotificationMessageArrived(paramContext, paramMiPushMessage);
    handleXiaomiMsg(paramContext, paramMiPushMessage, 2);
  }
  
  public void onNotificationMessageClicked(Context paramContext, MiPushMessage paramMiPushMessage)
  {
    super.onNotificationMessageClicked(paramContext, paramMiPushMessage);
    handleXiaomiMsg(paramContext, paramMiPushMessage, 3);
  }
  
  public void onReceivePassThroughMessage(Context paramContext, MiPushMessage paramMiPushMessage)
  {
    super.onReceivePassThroughMessage(paramContext, paramMiPushMessage);
    handleXiaomiMsg(paramContext, paramMiPushMessage, 1);
  }
  
  public void onReceiveRegisterResult(Context paramContext, MiPushCommandMessage paramMiPushCommandMessage)
  {
    super.onReceiveRegisterResult(paramContext, paramMiPushCommandMessage);
    if (paramMiPushCommandMessage != null) {}
    try
    {
      Object localObject2 = paramMiPushCommandMessage.getCommand();
      Object localObject1 = paramMiPushCommandMessage.getCommandArguments();
      if ((localObject1 != null) && (((List)localObject1).size() > 0)) {}
      for (localObject1 = (String)((List)localObject1).get(0);; localObject1 = null)
      {
        if ("register".equals(localObject2))
        {
          localObject2 = new Intent("com.xiaomi.mipush.REGISTER");
          ((Intent)localObject2).putExtra("xm_regid", (String)localObject1);
          ((Intent)localObject2).putExtra("xm_register_errorcode", paramMiPushCommandMessage.getResultCode());
          p.a((Intent)localObject2, paramContext.getApplicationContext());
        }
        return;
      }
      return;
    }
    catch (Exception paramContext) {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/PushPatchMessageReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */