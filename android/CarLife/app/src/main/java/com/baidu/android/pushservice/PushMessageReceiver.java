package com.baidu.android.pushservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.android.pushservice.b.b;
import com.baidu.android.pushservice.c.d;
import com.baidu.android.pushservice.d.c;
import com.baidu.android.pushservice.j.m;
import com.baidu.android.pushservice.j.p;
import com.baidu.android.pushservice.message.PublicMsg;
import com.baidu.android.pushservice.message.a.h;
import com.baidu.android.pushservice.message.i;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.mipush.sdk.MiPushMessage;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class PushMessageReceiver
  extends BroadcastReceiver
{
  public static final String TAG = "PushMessageReceiver";
  
  private void handleMeizuMessageCallBack(Context paramContext, Intent paramIntent)
  {
    i locali = new i();
    int i = paramIntent.getIntExtra("mz_push_msg_type", 0);
    String str = locali.c(paramContext, paramIntent.getStringExtra("mz_notification_self_define_content"));
    if (!p.y(paramContext)) {}
    while ((p.y(paramContext, locali.l)) || (!PushManager.hwMessageVerify(paramContext, locali.o, (locali.l + str).replaceAll("\\\\", ""))) || (i != b.a(b.c))) {
      return;
    }
    onNotificationClicked(paramContext, paramIntent.getStringExtra("mz_notification_title"), paramIntent.getStringExtra("mz_notification_content"), str);
    com.baidu.android.pushservice.h.q.a(paramContext, locali.l, "010206");
  }
  
  private void handleOppoMessageCallBack(Context paramContext, Intent paramIntent)
  {
    Object localObject1 = paramIntent.getStringExtra("op_notification_sign");
    String str1 = paramIntent.getStringExtra("op_notification_msg_id");
    Object localObject2 = paramIntent.getStringExtra("op_notification_pkg_content");
    paramIntent = paramIntent.getStringExtra("extra_extra_custom_content");
    if ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty(str1))) {}
    while ((!p.y(paramContext)) || (p.y(paramContext, str1)) || (!f.b(paramContext, (String)localObject1, str1 + paramIntent))) {
      return;
    }
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {}
    try
    {
      localObject1 = Intent.parseUri((String)localObject2, 0);
      ((Intent)localObject1).setPackage(paramContext.getPackageName());
      ((Intent)localObject1).addFlags(268435456);
      localObject2 = new JSONObject(paramIntent);
      Iterator localIterator = ((JSONObject)localObject2).keys();
      while (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        ((Intent)localObject1).putExtra(str2, ((JSONObject)localObject2).optString(str2));
      }
      if (paramContext.getPackageManager().queryIntentActivities((Intent)localObject1, 0).size() > 0) {
        paramContext.startActivity((Intent)localObject1);
      }
      try
      {
        onNotificationClicked(paramContext, null, null, new JSONObject("{\"extras\":" + paramIntent + "}").getString("extras"));
        com.baidu.android.pushservice.h.q.a(paramContext, str1, "010207");
        return;
      }
      catch (Exception paramContext) {}
      return;
    }
    catch (Exception paramContext) {}
  }
  
  private void handleXiaomiMessageCallBack(Context paramContext, MiPushMessage paramMiPushMessage, int paramInt)
  {
    try
    {
      String str = paramMiPushMessage.getContent();
      i locali = new i();
      boolean bool = msgFromXMConsole(str);
      if (bool)
      {
        locali.m = com.baidu.android.pushservice.message.a.l.b.a();
        if (p.y(paramContext)) {
          break label85;
        }
      }
      for (;;)
      {
        if ((bool) || (paramInt != b.a(b.c))) {
          break label310;
        }
        com.baidu.android.pushservice.h.q.a(paramContext, locali.l, "010205");
        return;
        str = locali.b(paramContext, str);
        break;
        label85:
        if ((paramInt == b.a(b.c)) || (!p.y(paramContext, locali.l))) {
          if (locali.m == com.baidu.android.pushservice.message.a.l.p.a()) {
            p.A(paramContext);
          } else if (locali.m == com.baidu.android.pushservice.message.a.l.o.a()) {
            p.B(paramContext);
          } else if ((locali.m == com.baidu.android.pushservice.message.a.l.g.a()) || (locali.m == com.baidu.android.pushservice.message.a.l.c.a()) || (locali.m == com.baidu.android.pushservice.message.a.l.b.a()) || (locali.m == com.baidu.android.pushservice.message.a.l.f.a()) || (locali.m == com.baidu.android.pushservice.message.a.l.d.a()) || (locali.m == com.baidu.android.pushservice.message.a.l.e.a())) {
            if (paramInt == b.a(b.a)) {
              onMessage(paramContext, str, null);
            } else if (paramInt == b.a(b.b)) {
              onNotificationArrived(paramContext, paramMiPushMessage.getTitle(), paramMiPushMessage.getDescription(), str);
            } else if (paramInt == b.a(b.c)) {
              onNotificationClicked(paramContext, paramMiPushMessage.getTitle(), paramMiPushMessage.getDescription(), str);
            }
          }
        }
      }
      label310:
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  private static boolean msgFromXMConsole(String paramString)
  {
    try
    {
      new JSONObject(paramString);
      return false;
    }
    catch (Exception paramString) {}
    return true;
  }
  
  private void sendCallback(Context paramContext, Intent paramIntent, int paramInt)
  {
    try
    {
      if (paramIntent.getBooleanExtra("bdpush_deliver_NO_CALLBACK", false)) {
        return;
      }
      paramIntent.putExtra("bd.cross.request.RESULT_CODE", paramInt);
      paramIntent.setClass(paramContext, CommandService.class);
      paramIntent.putExtra("bd.cross.request.COMMAND_TYPE", "bd.cross.command.MESSAGE_ACK");
      paramContext.startService(paramIntent);
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public abstract void onBind(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract void onDelTags(Context paramContext, int paramInt, List<String> paramList1, List<String> paramList2, String paramString);
  
  public abstract void onListTags(Context paramContext, int paramInt, List<String> paramList, String paramString);
  
  public abstract void onMessage(Context paramContext, String paramString1, String paramString2);
  
  public abstract void onNotificationArrived(Context paramContext, String paramString1, String paramString2, String paramString3);
  
  public abstract void onNotificationClicked(Context paramContext, String paramString1, String paramString2, String paramString3);
  
  public final void onReceive(final Context paramContext, final Intent paramIntent)
  {
    if ((paramIntent == null) || (paramIntent.getAction() == null)) {
      return;
    }
    for (;;)
    {
      int j;
      try
      {
        paramIntent.getByteArrayExtra("baidu_message_secur_info");
        final Object localObject1 = paramIntent.getAction();
        final Object localObject3;
        final Object localObject4;
        final Object localObject5;
        if (((String)localObject1).equals("com.baidu.android.pushservice.action.MESSAGE"))
        {
          if (d.g(paramContext)) {
            break;
          }
          if (!p.y(paramContext))
          {
            f.g(paramContext);
            return;
          }
          if (paramIntent.getExtras() == null) {
            break;
          }
          localObject1 = paramIntent.getByteArrayExtra("baidu_message_secur_info");
          localObject3 = paramIntent.getByteArrayExtra("baidu_message_body");
          localObject4 = paramIntent.getStringExtra("message_id");
          i = paramIntent.getIntExtra("baidu_message_type", -1);
          localObject5 = paramIntent.getStringExtra("app_id");
          if ((localObject1 == null) || (localObject3 == null) || (TextUtils.isEmpty((CharSequence)localObject4)) || (TextUtils.isEmpty((CharSequence)localObject5)) || (i == -1))
          {
            sendCallback(paramContext, paramIntent, 2);
            return;
          }
          if ((p.t(paramContext, (String)localObject4)) || (!com.baidu.android.pushservice.d.a.e(paramContext, (String)localObject4)))
          {
            sendCallback(paramContext, paramIntent, 4);
            return;
          }
          new Thread()
          {
            public void handleMessage(Message paramAnonymousMessage)
            {
              if (this.d.get() != null)
              {
                PushMessageReceiver.this.onMessage((Context)this.d.get(), paramAnonymousMessage.getData().getString("message"), paramAnonymousMessage.getData().getString("custom_content"));
                PushMessageReceiver.this.sendCallback(paramContext, paramIntent, 10);
              }
            }
          }
          {
            public void run()
            {
              String[] arrayOfString = h.a(paramContext, i, localObject5, localObject4, localObject1, localObject3);
              if ((arrayOfString == null) || (arrayOfString.length != 2)) {
                PushMessageReceiver.this.sendCallback(paramContext, paramIntent, 9);
              }
              do
              {
                return;
                Message localMessage = new Message();
                Bundle localBundle = new Bundle();
                localBundle.putString("message", arrayOfString[0]);
                localBundle.putString("custom_content", arrayOfString[1]);
                localMessage.setData(localBundle);
                this.h.sendMessage(localMessage);
                p.b("message " + arrayOfString[0] + " at time of " + System.currentTimeMillis(), paramContext);
              } while (a.b() <= 0);
              com.baidu.android.pushservice.h.l.b(paramContext, localObject5, localObject4, i, arrayOfString[0].getBytes(), 0, com.baidu.android.pushservice.h.j.a);
            }
          }.start();
          return;
        }
        String str;
        Object localObject6;
        if (((String)localObject1).equals("com.baidu.android.pushservice.action.RECEIVE"))
        {
          localObject3 = paramIntent.getStringExtra("method");
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            break;
          }
          j = paramIntent.getIntExtra("error_msg", 0);
          if (paramIntent.getByteArrayExtra("content") == null) {
            break label2403;
          }
          localObject1 = new String(paramIntent.getByteArrayExtra("content"));
          if (((String)localObject3).equals("com.baidu.android.pushservice.action.notification.ARRIVED"))
          {
            localObject1 = paramIntent.getStringExtra("msgid");
            localObject3 = paramIntent.getStringExtra("notification_title");
            localObject4 = paramIntent.getStringExtra("notification_content");
            localObject5 = paramIntent.getStringExtra("extra_extra_custom_content");
            str = paramIntent.getStringExtra("com.baidu.pushservice.app_id");
            if (!p.a(paramContext, paramIntent.getByteArrayExtra("baidu_message_secur_info"), str, (String)localObject1, paramIntent.getByteArrayExtra("baidu_message_body"))) {
              break;
            }
            onNotificationArrived(paramContext, (String)localObject3, (String)localObject4, (String)localObject5);
            return;
          }
          if ((((String)localObject3).equals("method_bind")) || (((String)localObject3).equals("method_deal_lapp_bind_intent")))
          {
            if ((j == 0) && (!TextUtils.isEmpty((CharSequence)localObject1))) {
              try
              {
                localObject1 = new JSONObject((String)localObject1);
                localObject4 = ((JSONObject)localObject1).getString("request_id");
                localObject1 = ((JSONObject)localObject1).getJSONObject("response_params");
                localObject5 = ((JSONObject)localObject1).getString("appid");
                PushSettings.b(paramContext, (String)localObject5);
                str = ((JSONObject)localObject1).getString("channel_id");
                localObject6 = ((JSONObject)localObject1).getString("user_id");
                long l = 0L;
                localObject1 = null;
                localObject3 = null;
                if (paramIntent.hasExtra("real_bind"))
                {
                  l = System.currentTimeMillis();
                  localObject1 = paramIntent.getStringExtra("access_token");
                  localObject3 = paramIntent.getStringExtra("secret_key");
                }
                m.a(paramContext, (String)localObject5, str, (String)localObject4, (String)localObject6, true, p.d(paramContext, paramContext.getPackageName()), l, (String)localObject1, (String)localObject3);
                onBind(paramContext, j, (String)localObject5, (String)localObject6, str, (String)localObject4);
                p.b("PushMessageReceiver#onBind from " + paramContext.getPackageName() + ", errorCode= " + j + ", appid=  " + (String)localObject5 + ", userId=" + (String)localObject6 + ", channelId=" + str + ", requestId=" + (String)localObject4 + ", at time of " + System.currentTimeMillis(), paramContext);
                paramIntent = new StringBuilder();
                paramIntent.append(paramContext.getPackageName());
                paramIntent.append(",");
                paramIntent.append((String)localObject5);
                paramIntent.append(",");
                paramIntent.append((String)localObject6);
                paramIntent.append(",");
                paramIntent.append("false");
                paramIntent.append(",");
                paramIntent.append(a.a());
                paramIntent = b.a(paramContext).b(paramIntent.toString());
                c.e(paramContext, paramIntent);
                if (!p.E(paramContext)) {
                  break;
                }
                com.baidu.android.pushservice.j.q.a(paramContext, paramContext.getPackageName() + ".self_push_sync", "bindinfo", paramIntent);
                return;
              }
              catch (Exception paramIntent)
              {
                onBind(paramContext, j, null, null, null, null);
                com.baidu.android.pushservice.h.q.a(paramContext, "020102", paramContext.getPackageName(), j, paramIntent.getMessage());
                p.b("onBind from " + paramContext.getPackageName() + " errorCode " + j + " exception " + paramIntent.getMessage() + " at time of " + System.currentTimeMillis(), paramContext);
                return;
              }
            }
            onBind(paramContext, j, null, null, null, null);
            com.baidu.android.pushservice.h.q.a(paramContext, "020102", paramContext.getPackageName(), j, (String)localObject1);
            p.b("onBind from " + paramContext.getPackageName() + " errorCode " + j + " errorMsg = " + (String)localObject1 + " at time of " + System.currentTimeMillis(), paramContext);
            return;
          }
          if ((((String)localObject3).equals("method_unbind")) || (((String)localObject3).equals("method_lapp_unbind")))
          {
            paramIntent = paramContext.getSharedPreferences("bindcache", 0).edit();
            if (d.g(paramContext)) {
              break label2397;
            }
            i = 0;
            try
            {
              onUnbind(paramContext, i, new JSONObject((String)localObject1).getString("request_id"));
              paramIntent.putBoolean("bind_status", false);
              paramIntent.commit();
              if (d.c(paramContext)) {
                MiPushClient.unregisterPush(paramContext);
              }
              if (d.b(paramContext))
              {
                paramIntent = m.a(paramContext, "BD_MEIZU_PROXY_APPID_KEY");
                localObject1 = m.a(paramContext, "BD_MEIZU_PROXY_APPKEY_KEY");
                if ((!TextUtils.isEmpty(paramIntent)) && (!TextUtils.isEmpty((CharSequence)localObject1))) {
                  com.meizu.cloud.pushsdk.PushManager.unRegister(paramContext, paramIntent, (String)localObject1);
                }
              }
              p.b("unbind from" + paramContext.getPackageName() + " errorCode " + i + " at time of " + System.currentTimeMillis(), paramContext);
              return;
            }
            catch (JSONException localJSONException)
            {
              onUnbind(paramContext, i, null);
              paramIntent.putBoolean("bind_status", false);
              paramIntent.commit();
              continue;
            }
          }
          if ((((String)localObject3).equals("method_set_tags")) || (((String)localObject3).equals("method_set_lapp_tags")))
          {
            try
            {
              localObject2 = new JSONObject(localJSONException);
              paramIntent = ((JSONObject)localObject2).getString("request_id");
              if (!TextUtils.isEmpty(((JSONObject)localObject2).optString("error_msg")))
              {
                onSetTags(paramContext, j, new ArrayList(), new ArrayList(), paramIntent);
                return;
              }
            }
            catch (JSONException paramIntent)
            {
              onSetTags(paramContext, j, null, null, null);
              return;
            }
            localObject2 = ((JSONObject)localObject2).optJSONObject("response_params");
            if (localObject2 == null) {
              break;
            }
            localObject2 = ((JSONObject)localObject2).getJSONArray("details");
            if (localObject2 == null) {
              break;
            }
            localObject3 = new ArrayList();
            localObject4 = new ArrayList();
            i = 0;
            if (i < ((JSONArray)localObject2).length())
            {
              localObject5 = ((JSONArray)localObject2).getJSONObject(i);
              str = ((JSONObject)localObject5).getString("tag");
              if (((JSONObject)localObject5).getInt("result") == 0)
              {
                ((List)localObject3).add(str);
                break label2410;
              }
              ((List)localObject4).add(str);
              break label2410;
            }
            onSetTags(paramContext, j, (List)localObject3, (List)localObject4, paramIntent);
            return;
          }
          if ((((String)localObject3).equals("method_del_tags")) || (((String)localObject3).equals("method_del_lapp_tags")))
          {
            try
            {
              localObject2 = new JSONObject((String)localObject2);
              paramIntent = ((JSONObject)localObject2).getString("request_id");
              localObject2 = ((JSONObject)localObject2).getJSONObject("response_params");
              if (localObject2 == null) {
                break;
              }
              localObject2 = ((JSONObject)localObject2).getJSONArray("details");
              if (localObject2 == null) {
                break;
              }
              localObject3 = new ArrayList();
              localObject4 = new ArrayList();
              i = 0;
              if (i < ((JSONArray)localObject2).length())
              {
                localObject5 = ((JSONArray)localObject2).getJSONObject(i);
                str = ((JSONObject)localObject5).getString("tag");
                if (((JSONObject)localObject5).getInt("result") == 0) {
                  ((List)localObject3).add(str);
                } else {
                  ((List)localObject4).add(str);
                }
              }
            }
            catch (JSONException paramIntent)
            {
              onDelTags(paramContext, j, null, null, null);
              return;
            }
            onDelTags(paramContext, j, (List)localObject3, (List)localObject4, paramIntent);
            return;
          }
          if ((!((String)localObject3).equals("method_listtags")) && (!((String)localObject3).equals("method_list_lapp_tags"))) {
            break;
          }
          try
          {
            localObject2 = new JSONObject((String)localObject2).getString("request_id");
            onListTags(paramContext, j, paramIntent.getStringArrayListExtra("tags_list"), (String)localObject2);
            return;
          }
          catch (JSONException paramIntent)
          {
            onListTags(paramContext, j, null, null);
            return;
          }
        }
        if (((String)localObject2).equals("com.baidu.android.pushservice.action.notification.CLICK"))
        {
          localObject2 = paramIntent.getStringExtra("msgid");
          localObject3 = paramIntent.getStringExtra("notification_title");
          localObject4 = paramIntent.getStringExtra("notification_content");
          localObject5 = paramIntent.getStringExtra("extra_extra_custom_content");
          str = paramIntent.getStringExtra("com.baidu.pushservice.app_id");
          localObject6 = paramIntent.getByteArrayExtra("baidu_message_secur_info");
          paramIntent = paramIntent.getByteArrayExtra("baidu_message_body");
          if ((!p.b(paramContext, (String)localObject2, str, (String)localObject3, (String)localObject4, (String)localObject5)) && (!p.a(paramContext, (byte[])localObject6, str, (String)localObject2, paramIntent))) {
            break;
          }
          onNotificationClicked(paramContext, (String)localObject3, (String)localObject4, (String)localObject5);
          return;
        }
        if (((String)localObject2).equals("com.huawei.android.push.intent.REGISTRATION"))
        {
          if (!d.d(paramContext)) {
            break;
          }
          try
          {
            paramIntent = new String(paramIntent.getByteArrayExtra("device_token"), "UTF-8");
            if (TextUtils.isEmpty(paramIntent)) {
              break;
            }
            f.a(paramContext, paramIntent);
            return;
          }
          catch (Exception paramContext)
          {
            return;
          }
        }
        if (((String)localObject2).equals("com.huawei.intent.action.PUSH"))
        {
          if (!d.d(paramContext)) {
            break;
          }
          try
          {
            paramIntent = new String(paramIntent.getByteArrayExtra("selfshow_info"), "UTF-8");
            if ((TextUtils.isEmpty(paramIntent)) || (paramContext == null)) {
              break;
            }
            paramIntent = com.baidu.android.pushservice.message.a.j.a(paramContext, paramIntent);
            localObject2 = paramIntent.a(paramContext);
            if ((localObject2 == null) || (!p.y(paramContext)) || (p.y(paramContext, paramIntent.l))) {
              break;
            }
            PushServiceReceiver.a(paramContext, paramContext.getPackageName(), "com.baidu.android.pushservice.CommandService", (PublicMsg)localObject2);
            return;
          }
          catch (Exception paramContext)
          {
            return;
          }
        }
        if (((String)localObject2).equals("com.huawei.android.push.intent.RECEIVE"))
        {
          if (!d.d(paramContext)) {
            break;
          }
          localObject2 = paramIntent.getByteArrayExtra("msg_data");
          paramIntent = paramIntent.getByteArrayExtra("device_token");
        }
      }
      catch (Exception paramContext)
      {
        return;
      }
      try
      {
        localObject2 = new String((byte[])localObject2, "utf-8");
        new String(paramIntent, "utf-8");
        paramIntent = new i();
        localObject2 = paramIntent.a(paramContext, (String)localObject2);
        if ((!p.y(paramContext)) || (p.y(paramContext, paramIntent.l)) || (!PushManager.hwMessageVerify(paramContext, paramIntent.o, paramIntent.l + (String)localObject2))) {
          break;
        }
        if (paramIntent.m == com.baidu.android.pushservice.message.a.l.p.a())
        {
          p.A(paramContext);
          return;
        }
        if (paramIntent.m == com.baidu.android.pushservice.message.a.l.o.a())
        {
          p.B(paramContext);
          return;
        }
        if ((paramIntent.m != com.baidu.android.pushservice.message.a.l.g.a()) && (paramIntent.m != com.baidu.android.pushservice.message.a.l.b.a())) {
          break;
        }
        onMessage(paramContext, (String)localObject2, null);
        return;
      }
      catch (Exception paramContext) {}
      if (((String)localObject2).equals("com.xiaomi.mipush.REGISTER"))
      {
        if ((!d.c(paramContext)) || (!paramIntent.hasExtra("xm_register_errorcode"))) {
          break;
        }
        if (paramIntent.getLongExtra("xm_register_errorcode", 0L) != 0L)
        {
          f.i(paramContext);
          return;
        }
        if (!paramIntent.hasExtra("xm_regid")) {
          break;
        }
        paramIntent = paramIntent.getStringExtra("xm_regid");
        if (TextUtils.isEmpty(paramIntent)) {
          break;
        }
        f.a(paramContext, paramIntent);
        return;
      }
      if (((String)localObject2).equals("com.xiaomi.mipush.PUSH_MSG"))
      {
        if ((!d.c(paramContext)) || (!paramIntent.hasExtra("xm_push_msg"))) {
          break;
        }
        localObject2 = (MiPushMessage)paramIntent.getSerializableExtra("xm_push_msg");
        if (!paramIntent.hasExtra("xm_push_msg_type")) {
          break;
        }
        handleXiaomiMessageCallBack(paramContext, (MiPushMessage)localObject2, paramIntent.getIntExtra("xm_push_msg_type", 0));
        return;
      }
      if (((String)localObject2).equals("com.meizu.mzpush.REGISTER"))
      {
        if ((!d.b(paramContext)) || (!paramIntent.hasExtra("mz_register_errorcode"))) {
          break;
        }
        if (paramIntent.getStringExtra("mz_register_errorcode").equals("200"))
        {
          if (!paramIntent.hasExtra("mz_pushid")) {
            break;
          }
          paramIntent = paramIntent.getStringExtra("mz_pushid");
          if (TextUtils.isEmpty(paramIntent)) {
            break;
          }
          f.a(paramContext, paramIntent);
          return;
        }
        f.j(paramContext);
        return;
      }
      if (((String)localObject2).equals("com.meizu.mzpush.PUSH_MSG"))
      {
        if ((!d.b(paramContext)) || (!paramIntent.hasExtra("mz_push_msg_type"))) {
          break;
        }
        handleMeizuMessageCallBack(paramContext, paramIntent);
        return;
      }
      if ((!((String)localObject2).equals("com.baidu.android.pushservice.action.OPPO_CLICK")) || (!d.e(paramContext))) {
        break;
      }
      handleOppoMessageCallBack(paramContext, paramIntent);
      return;
      label2397:
      final int i = j;
      continue;
      label2403:
      Object localObject2 = "";
      continue;
      label2410:
      i += 1;
      continue;
      i += 1;
    }
  }
  
  public abstract void onSetTags(Context paramContext, int paramInt, List<String> paramList1, List<String> paramList2, String paramString);
  
  public abstract void onUnbind(Context paramContext, int paramInt, String paramString);
  
  private static class a
    extends Handler
  {
    protected final WeakReference<Context> d;
    
    public a(Context paramContext)
    {
      this.d = new WeakReference(paramContext);
    }
  }
  
  private static enum b
  {
    private int d;
    
    private b(int paramInt)
    {
      this.d = paramInt;
    }
    
    private int a()
    {
      return this.d;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/PushMessageReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */