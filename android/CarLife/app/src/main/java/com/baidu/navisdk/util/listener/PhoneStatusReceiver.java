package com.baidu.navisdk.util.listener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.module.business.BusinessActivityPlayerManager;
import com.baidu.navisdk.module.offscreen.BNOffScreenManager;
import com.baidu.navisdk.module.ugc.dialog.UgcSoundsRecordDialog;
import com.baidu.navisdk.util.common.AppStateUtils;
import com.baidu.navisdk.util.common.AudioUtils;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.SystemAuth;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PhoneStatusReceiver
  extends BroadcastReceiver
{
  public static final int MSG_PHONE_CALL_OUT = 2;
  public static final int MSG_PHONE_IDEL = 4;
  public static final int MSG_PHONE_OFF_HOOK = 3;
  public static final int MSG_PHONE_RINGING = 1;
  public static final int MSG_TYPE_PHONE_CHANGE = 5556;
  private static final String TAG = "PhoneStatusReceiver";
  private static final List<Handler> outboxHandlers = new ArrayList();
  private static Context sContext = null;
  private static PhoneStatusReceiver sInstance = new PhoneStatusReceiver();
  private static boolean sIsPhoneReceiverRegisted = false;
  PhoneStateListener mListener = new PhoneStateListener()
  {
    public void onCallStateChanged(int paramAnonymousInt, String paramAnonymousString)
    {
      super.onCallStateChanged(paramAnonymousInt, paramAnonymousString);
      switch (paramAnonymousInt)
      {
      default: 
        return;
      case 0: 
        LogUtil.e("PhoneStatusReceiver", "CALL_STATE_IDLE");
        AppStateUtils.getInstance().setPhoneStatus(0);
        PhoneStatusReceiver.dispatchMessage(5556, 4, 0);
        return;
      case 2: 
        LogUtil.e("PhoneStatusReceiver", "CALL_STATE_OFFHOOK");
        AppStateUtils.getInstance().setPhoneStatus(2);
        PhoneStatusReceiver.dispatchMessage(5556, 3, 0);
        return;
      }
      LogUtil.e("PhoneStatusReceiver", "CALL_STATE_RINGING");
      AppStateUtils.getInstance().setPhoneStatus(1);
      PhoneStatusReceiver.dispatchMessage(5556, 1, 0);
    }
  };
  
  private static void dispatchMessage(int paramInt1, int paramInt2, int paramInt3)
  {
    if (!outboxHandlers.isEmpty())
    {
      Iterator localIterator = outboxHandlers.iterator();
      while (localIterator.hasNext())
      {
        Message localMessage = Message.obtain((Handler)localIterator.next(), paramInt1, paramInt2, paramInt3, null);
        if (localMessage.getTarget() != null) {
          localMessage.sendToTarget();
        }
      }
    }
  }
  
  public static void initPhoneStatusReceiver(Context paramContext)
  {
    if ((!SystemAuth.checkAuth("android.permission.CALL_PHONE")) || (!SystemAuth.checkAuth("android.permission.PROCESS_OUTGOING_CALLS"))) {}
    while (paramContext == null) {
      return;
    }
    sContext = paramContext;
    paramContext = new IntentFilter();
    paramContext.addAction("android.intent.action.PHONE_STATE");
    paramContext.addAction("android.intent.action.NEW_OUTGOING_CALL");
    paramContext.setPriority(Integer.MAX_VALUE);
    try
    {
      sContext.registerReceiver(sInstance, paramContext);
      sIsPhoneReceiverRegisted = true;
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public static void registerMessageHandler(Handler paramHandler)
  {
    if ((paramHandler != null) && (!outboxHandlers.contains(paramHandler))) {
      outboxHandlers.add(paramHandler);
    }
  }
  
  public static void unRegisterMessageHandler(Handler paramHandler)
  {
    if ((paramHandler != null) && (outboxHandlers.contains(paramHandler))) {
      outboxHandlers.remove(paramHandler);
    }
  }
  
  public static void uninitPhoneStatusReceiver()
  {
    if ((!SystemAuth.checkAuth("android.permission.CALL_PHONE")) || (!SystemAuth.checkAuth("android.permission.PROCESS_OUTGOING_CALLS"))) {}
    for (;;)
    {
      return;
      try
      {
        if ((sContext != null) && (sIsPhoneReceiverRegisted))
        {
          sIsPhoneReceiverRegisted = false;
          sContext.unregisterReceiver(sInstance);
          return;
        }
      }
      catch (Exception localException) {}
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramIntent = paramIntent.getStringExtra("state");
    if (TelephonyManager.EXTRA_STATE_RINGING.equals(paramIntent))
    {
      LogUtil.e("PhoneStatusReceiver", "phone state change to TelephonyManager.CALL_STATE_RINGING");
      AudioUtils.setPhoneIn(true);
      BusinessActivityPlayerManager.getInstance().cancelPlayAudio();
      TTSPlayerControl.stopSound();
      BNOffScreenManager.getInstance().handleOffScreenInterupt(true);
      UgcSoundsRecordDialog.stopRecordAndDismiss();
    }
    while ((!SystemAuth.checkAuth("android.permission.CALL_PHONE")) || (!SystemAuth.checkAuth("android.permission.PROCESS_OUTGOING_CALLS")))
    {
      return;
      if (TelephonyManager.EXTRA_STATE_OFFHOOK.equals(paramIntent))
      {
        LogUtil.e("PhoneStatusReceiver", "phone state change to TelephonyManager.CALL_STATE_OFFHOOK");
        AudioUtils.setPhoneIn(true);
        BusinessActivityPlayerManager.getInstance().cancelPlayAudio();
        TTSPlayerControl.stopSound();
      }
      else if (TelephonyManager.EXTRA_STATE_IDLE.equals(paramIntent))
      {
        LogUtil.e("PhoneStatusReceiver", "phone state change to TelephonyManager.CALL_STATE_IDLE");
        AudioUtils.setPhoneIn(false);
        BNOffScreenManager.getInstance().handleOffScreenInterupt(false);
      }
    }
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    try
    {
      paramContext.listen(this.mListener, 32);
      return;
    }
    catch (Exception paramContext) {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/listener/PhoneStatusReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */