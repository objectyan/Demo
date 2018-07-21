package com.baidu.android.pushservice;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.android.pushservice.c.d.a;
import com.baidu.android.pushservice.h.q;
import com.baidu.android.pushservice.j.l;
import com.baidu.android.pushservice.j.m;
import com.baidu.android.pushservice.j.n;
import com.baidu.android.pushservice.j.o;
import com.baidu.android.pushservice.j.p;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import com.baidu.android.pushservice.k.e;
import com.coloros.mcssdk.callback.PushCallback;
import com.coloros.mcssdk.mode.SubscribeResult;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class f
{
  public static int a = -1;
  public static String b = null;
  public static String c = null;
  public static String d = null;
  public static String e = null;
  public static String f = null;
  public static String g = null;
  public static String h = null;
  public static String i = null;
  public static Handler j = null;
  private static final ConcurrentLinkedQueue<Runnable> k = new ConcurrentLinkedQueue();
  private static boolean l;
  
  public static Intent a(Context paramContext)
  {
    if (l(paramContext)) {
      return null;
    }
    int m;
    if (a != -1)
    {
      m = a;
      if (TextUtils.isEmpty(b)) {
        break label65;
      }
    }
    label65:
    for (String str = b;; str = m.a(paramContext, "com.baidu.android.pushservice.PushManager.LONGIN_VALUE"))
    {
      if (!TextUtils.isEmpty(str)) {
        break label75;
      }
      com.baidu.android.pushservice.g.a.b("PushManagerHandler", "Can not acquire loginValue, please check if there is a right loginValue", paramContext);
      k(paramContext);
      return null;
      m = m.b(paramContext, "com.baidu.android.pushservice.PushManager.LOGIN_TYPE", 0);
      break;
    }
    label75:
    paramContext = o.c(paramContext);
    if (m == 0)
    {
      paramContext.putExtra("secret_key", str);
      return paramContext;
    }
    return null;
  }
  
  public static Intent a(Context paramContext, int paramInt)
  {
    Intent localIntent2 = a(paramContext);
    Intent localIntent1;
    if (localIntent2 == null) {
      localIntent1 = null;
    }
    do
    {
      return localIntent1;
      localIntent2.putExtra("method", "method_bind");
      localIntent2.putExtra("bind_status", paramInt);
      localIntent2.putExtra("push_sdk_version", a.a());
      localIntent2.setFlags(localIntent2.getFlags() | 0x20);
      localIntent1 = localIntent2;
    } while (Build.VERSION.SDK_INT < 19);
    paramInt = l.a(paramContext);
    localIntent2.putExtra("bind_notify_status", paramInt + "");
    return localIntent2;
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("appid", paramString2);
    localJSONObject.put("channel_id", paramString3);
    localJSONObject.put("user_id", paramString4);
    paramString2 = new JSONObject();
    paramString2.put("request_id", paramString1);
    paramString2.put("response_params", localJSONObject);
    return paramString2.toString();
  }
  
  public static void a(Context paramContext, int paramInt, String paramString, boolean paramBoolean)
  {
    if (l(paramContext)) {
      return;
    }
    boolean bool2 = com.baidu.android.pushservice.c.d.g(paramContext);
    boolean bool1 = b(paramContext);
    a.b(paramContext, true);
    p.a(paramContext, true, true);
    if (!bool2) {
      com.baidu.android.pushservice.i.d.a().a(new com.baidu.android.pushservice.i.c()
      {
        public void a()
        {
          com.baidu.android.pushservice.d.d.a(this.a);
        }
      });
    }
    q(paramContext);
    p.b("startWork from" + paramContext.getPackageName() + " at time of " + System.currentTimeMillis(), paramContext);
    if (paramBoolean)
    {
      Object localObject = paramContext.getSharedPreferences("com.baidu.pushservice.BIND_CACHE", 0);
      paramBoolean = ((SharedPreferences)localObject).getBoolean("bind_status", false);
      String str1 = ((SharedPreferences)localObject).getString("request_id", "");
      String str2 = ((SharedPreferences)localObject).getString("appid", "");
      String str3 = ((SharedPreferences)localObject).getString("channel_id", "");
      String str4 = ((SharedPreferences)localObject).getString("user_id", "");
      localObject = null;
      try
      {
        str1 = a(str1, str2, str3, str4);
        localObject = str1;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          com.baidu.android.pushservice.g.a.b("PushManagerHandler", "error " + localJSONException.getMessage(), paramContext.getApplicationContext());
        }
      }
      bool2 = a(paramContext, paramInt, paramString);
      if ((paramBoolean) && (bool2) && (localObject != null) && (!bool1))
      {
        paramString = new Intent();
        paramString.putExtra("method", "method_bind");
        paramString.putExtra("error_msg", 0);
        paramString.putExtra("content", ((String)localObject).getBytes());
        paramString.putExtra("bind_status", 0);
        com.baidu.android.pushservice.g.a.a("PushManagerHandler", "new startWork> sendResult to " + paramContext.getPackageName() + " ,method:" + "method_bind" + " ,errorCode : " + 0 + " ,content : " + new String((String)localObject), paramContext.getApplicationContext());
        p.b(paramContext, paramString, "com.baidu.android.pushservice.action.RECEIVE", paramContext.getPackageName());
        if (a.b() > 0) {
          q.a(paramContext, "039901", 1, (String)localObject);
        }
        r(paramContext);
        return;
      }
    }
    b(paramContext, paramInt, paramString);
    r(paramContext);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    int m = 1;
    for (;;)
    {
      int n;
      JSONObject localJSONObject2;
      try
      {
        Intent localIntent;
        if ((j != null) && (!k.isEmpty()))
        {
          j.sendEmptyMessage(65553);
          localIntent = a(paramContext, 0);
          if (localIntent != null) {}
        }
        else
        {
          if (com.baidu.android.pushservice.c.d.e(paramContext)) {
            continue;
          }
          return;
        }
        n = com.baidu.android.pushservice.c.d.a(paramContext).b();
        if (TextUtils.isEmpty(paramString)) {
          break label212;
        }
        JSONObject localJSONObject1 = new JSONObject();
        localJSONObject2 = new JSONObject();
        if (n == 5)
        {
          localJSONObject2.put("platform", 0);
          if (m != 0)
          {
            localJSONObject2.put("token", paramString);
            localJSONObject1.put("info", localJSONObject2);
            n.a(paramContext, n, paramString);
          }
          localIntent.putExtra("push_proxy", localJSONObject1.toString());
          a(paramContext, localIntent);
          return;
        }
      }
      catch (Exception paramString)
      {
        p(paramContext);
        return;
      }
      if (n == 6)
      {
        localJSONObject2.put("platform", 1);
      }
      else if (n == 7)
      {
        localJSONObject2.put("platform", 3);
      }
      else if (n == 8)
      {
        localJSONObject2.put("platform", 4);
        continue;
        label212:
        p(paramContext);
      }
      else
      {
        m = 0;
      }
    }
  }
  
  static void a(Context paramContext, String paramString, boolean paramBoolean, int paramInt, long paramLong)
  {
    paramContext = paramContext.getSharedPreferences("com.baidu.pushservice.switch_sync", 0).edit();
    paramContext.putString("base_url", paramString);
    paramContext.putBoolean("switch_enable", paramBoolean);
    paramContext.putInt("sync_type", paramInt);
    paramContext.putLong("target_time", paramLong);
    paramContext.apply();
  }
  
  static void a(final Context paramContext, final String paramString, final boolean paramBoolean, final int paramInt, final PushManager.SyncCallback paramSyncCallback)
  {
    final String str = s(paramContext);
    if (TextUtils.isEmpty(str))
    {
      if (paramSyncCallback != null) {
        paramSyncCallback.onSyncResult(-1);
      }
      return;
    }
    com.baidu.android.pushservice.i.d.a().a(new com.baidu.android.pushservice.i.c("uploadPushEnabledStatus", (short)100)
    {
      public void a()
      {
        for (int i = 1;; i = 0)
        {
          try
          {
            Object localObject1 = new JSONArray();
            Object localObject2 = new JSONObject();
            ((JSONObject)localObject2).put("setting_type", 1);
            if (!paramBoolean) {
              continue;
            }
            ((JSONObject)localObject2).put("msg_setting", i);
            ((JSONObject)localObject2).put("sys_default_setting", paramInt);
            ((JSONArray)localObject1).put(localObject2);
            localObject2 = new HashMap();
            ((HashMap)localObject2).put("uid", e.a(paramContext));
            ((HashMap)localObject2).put("bccs_apikey", str);
            ((HashMap)localObject2).put("data", ((JSONArray)localObject1).toString());
            localObject1 = com.baidu.android.pushservice.f.b.a(paramString + "/boxmessage?type=message&action=setting", "POST", (HashMap)localObject2);
            if (((com.baidu.android.pushservice.f.a)localObject1).b() == 200)
            {
              i = new JSONObject(com.baidu.android.pushservice.h.a.b.a(((com.baidu.android.pushservice.f.a)localObject1).a())).getInt("errno");
              if (paramSyncCallback != null) {
                paramSyncCallback.onSyncResult(i);
              }
              if (i == 0) {
                f.n(paramContext);
              }
            }
            else if (paramSyncCallback != null)
            {
              paramSyncCallback.onSyncResult(-1);
              return;
            }
          }
          catch (Exception localException)
          {
            if (paramSyncCallback != null) {
              paramSyncCallback.onSyncResult(-1);
            }
          }
          return;
        }
      }
    });
  }
  
  public static void a(final Context paramContext, boolean paramBoolean)
  {
    paramContext = paramContext.getApplicationContext();
    if (TextUtils.isEmpty(h)) {
      h = m.a(paramContext, "BD_OPPO_PROXY_APPKEY_KEY");
    }
    if (TextUtils.isEmpty(i)) {
      i = m.a(paramContext, "BD_OPPO_PROXY_APPSECRET_KEY");
    }
    if ((TextUtils.isEmpty(h)) || (TextUtils.isEmpty(i)))
    {
      if (paramBoolean) {
        k(paramContext);
      }
      return;
    }
    p.a(paramContext, h, i, new PushCallback()
    {
      public void onGetAliases(int paramAnonymousInt, List<SubscribeResult> paramAnonymousList) {}
      
      public void onGetNotificationStatus(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public void onGetPushStatus(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public void onGetTags(int paramAnonymousInt, List<SubscribeResult> paramAnonymousList) {}
      
      public void onGetUserAccounts(int paramAnonymousInt, List<SubscribeResult> paramAnonymousList) {}
      
      public void onRegister(int paramAnonymousInt, String paramAnonymousString)
      {
        if (this.a)
        {
          if (paramAnonymousInt != 0) {
            break label45;
          }
          if (com.baidu.android.pushservice.c.d.e(paramContext))
          {
            if (TextUtils.isEmpty(paramAnonymousString)) {
              break label37;
            }
            f.a(paramContext, paramAnonymousString);
          }
        }
        return;
        label37:
        f.m(paramContext);
        return;
        label45:
        f.m(paramContext);
      }
      
      public void onSetAliases(int paramAnonymousInt, List<SubscribeResult> paramAnonymousList) {}
      
      public void onSetPushTime(int paramAnonymousInt, String paramAnonymousString) {}
      
      public void onSetTags(int paramAnonymousInt, List<SubscribeResult> paramAnonymousList) {}
      
      public void onSetUserAccounts(int paramAnonymousInt, List<SubscribeResult> paramAnonymousList) {}
      
      public void onUnRegister(int paramAnonymousInt) {}
      
      public void onUnsetAliases(int paramAnonymousInt, List<SubscribeResult> paramAnonymousList) {}
      
      public void onUnsetTags(int paramAnonymousInt, List<SubscribeResult> paramAnonymousList) {}
      
      public void onUnsetUserAccounts(int paramAnonymousInt, List<SubscribeResult> paramAnonymousList) {}
    });
  }
  
  public static boolean a(Context paramContext, int paramInt, String paramString)
  {
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("com.baidu.pushservice.BIND_CACHE", 0);
    long l1 = localSharedPreferences.getLong("currbindtime", 0L);
    String str1 = localSharedPreferences.getString("access_token", "");
    String str2 = localSharedPreferences.getString("secret_key", "");
    long l2 = localSharedPreferences.getLong("version_code", 0L);
    if (Long.valueOf(System.currentTimeMillis()).longValue() - Long.valueOf(l1).longValue() > 43200000L) {}
    do
    {
      localSharedPreferences.edit().clear().commit();
      while ((!paramString.equals(str1)) || (p.d(paramContext, paramContext.getPackageName()) != Long.valueOf(l2).longValue()))
      {
        return false;
        if (paramInt != 1) {
          break;
        }
      }
      return true;
    } while ((paramInt != 0) || (paramString.equals(str2)));
    return false;
  }
  
  public static boolean a(Context paramContext, Intent paramIntent)
  {
    return i.a(paramContext).a(paramIntent);
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (!TextUtils.isEmpty(paramString1))
      {
        bool1 = bool2;
        if (paramString2 != null)
        {
          paramContext = com.baidu.android.pushservice.k.f.a(p.a(p.B(paramContext, paramContext.getPackageName()).getBytes(), paramString2.getBytes()), false);
          paramString1 = com.baidu.android.pushservice.k.f.a(paramString1);
          bool1 = bool2;
          if (paramString1 != null)
          {
            paramString1 = com.baidu.android.pushservice.k.f.a(BaiduAppSSOJni.decryptR(paramString1, 0), "", false);
            bool1 = bool2;
            if (!TextUtils.isEmpty(paramString1))
            {
              bool1 = bool2;
              if (!TextUtils.isEmpty(paramContext))
              {
                boolean bool3 = paramContext.equals(paramString1);
                bool1 = bool2;
                if (bool3) {
                  bool1 = true;
                }
              }
            }
          }
        }
      }
      return bool1;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  public static void b(Context paramContext, int paramInt)
  {
    Intent localIntent = a(paramContext, paramInt);
    if (localIntent == null) {
      return;
    }
    com.baidu.android.pushservice.g.a.a("PushManagerHandler", "a bind intent send", paramContext.getApplicationContext());
    a(paramContext, localIntent);
    p.b("Bind by selfEventHandler", paramContext);
  }
  
  public static void b(final Context paramContext, int paramInt, final String paramString)
  {
    com.baidu.android.pushservice.c.d.a(paramContext.getApplicationContext()).a(new d.a()
    {
      public void a()
      {
        if (this.a == 0)
        {
          m.a(paramContext, "com.baidu.android.pushservice.PushManager.LOGIN_TYPE", 0);
          m.a(paramContext, "com.baidu.android.pushservice.PushManager.LONGIN_VALUE", paramString);
        }
        if (com.baidu.android.pushservice.c.d.d(paramContext))
        {
          a.b(paramContext, false);
          p.a(paramContext, true, false);
          f.e(paramContext);
        }
        do
        {
          return;
          if (com.baidu.android.pushservice.c.d.c(paramContext))
          {
            a.b(paramContext, false);
            p.a(paramContext, true, false);
            f.c(paramContext);
            return;
          }
          if (com.baidu.android.pushservice.c.d.b(paramContext))
          {
            a.b(paramContext, false);
            p.a(paramContext, true, false);
            f.d(paramContext);
            return;
          }
          if ((com.baidu.android.pushservice.c.d.e(paramContext)) && (com.baidu.android.pushservice.c.d.f(paramContext)))
          {
            a.b(paramContext, false);
            p.a(paramContext, true, false);
            f.a(paramContext, true);
            return;
          }
          com.baidu.android.pushservice.g.a.a("PushManagerHandler", "login type = " + this.a, paramContext.getApplicationContext());
          if (this.a == 0)
          {
            if (a.b() > 0) {
              q.a(paramContext, "039901", 2, paramString);
            }
            f.c(paramContext, this.a, paramString);
            return;
          }
          com.baidu.android.pushservice.g.a.b("PushManagerHandler", "Wrong login type, please check!", paramContext.getApplicationContext());
        } while (a.b() <= 0);
        q.a(paramContext, "039901", -1, "");
      }
    });
  }
  
  public static void b(Context paramContext, Intent paramIntent)
  {
    if (!a(paramContext, paramIntent)) {
      paramContext.sendBroadcast(paramIntent);
    }
  }
  
  public static boolean b(Context paramContext)
  {
    for (;;)
    {
      try
      {
        if (p.E(paramContext))
        {
          SharedPreferences localSharedPreferences = paramContext.getSharedPreferences(paramContext.getPackageName() + ".push_sync", 5);
          localSharedPreferences.edit();
          m = localSharedPreferences.getInt("version2", 0);
          int n = m;
          if (m == -1) {
            n = com.baidu.android.pushservice.d.c.c(paramContext);
          }
          m = a.a();
          return n != m;
        }
      }
      catch (Exception paramContext)
      {
        return true;
      }
      int m = -1;
    }
  }
  
  public static boolean b(Context paramContext, String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (!TextUtils.isEmpty(paramString1))
      {
        bool1 = bool2;
        if (paramString2 != null)
        {
          paramContext = com.baidu.android.pushservice.k.f.a(p.a(p.B(paramContext, paramContext.getPackageName()).getBytes(), paramString2.getBytes()), false);
          bool1 = bool2;
          if (!TextUtils.isEmpty(paramContext)) {
            bool1 = BaiduAppSSOJni.verify(paramContext.getBytes(), paramString1, 0);
          }
        }
      }
      return bool1;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  public static String c(Context paramContext, Intent paramIntent)
  {
    Object localObject2 = null;
    paramContext = null;
    if (paramIntent != null) {
      localObject1 = localObject2;
    }
    try
    {
      Uri localUri = paramIntent.getData();
      localObject1 = localObject2;
      paramIntent = paramIntent.getStringExtra("bdpush_hwsigninfo");
      paramContext = paramIntent;
      localObject1 = paramIntent;
      int m;
      if (TextUtils.isEmpty(paramIntent))
      {
        paramContext = paramIntent;
        if (localUri != null)
        {
          localObject1 = paramIntent;
          localObject2 = localUri.getFragment();
          paramContext = paramIntent;
          localObject1 = paramIntent;
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject1 = paramIntent;
            localObject2 = ((String)localObject2).split(";");
            paramContext = paramIntent;
            if (localObject2 != null)
            {
              paramContext = paramIntent;
              localObject1 = paramIntent;
              if (localObject2.length > 0) {
                m = 0;
              }
            }
          }
        }
      }
      for (;;)
      {
        paramContext = paramIntent;
        localObject1 = paramIntent;
        if (m < localObject2.length)
        {
          localObject1 = paramIntent;
          if (localObject2[m].contains("S.bdpush_hwsigninfo"))
          {
            localObject1 = paramIntent;
            paramContext = localObject2[m].split("=");
            if (paramContext != null)
            {
              localObject1 = paramIntent;
              if (1 < paramContext.length) {
                paramContext = paramContext[1];
              }
            }
          }
        }
        else
        {
          return paramContext;
        }
        m += 1;
      }
      return (String)localObject1;
    }
    catch (Exception paramContext) {}
  }
  
  public static void c(Context paramContext)
  {
    paramContext = paramContext.getApplicationContext();
    if (TextUtils.isEmpty(d)) {
      d = m.a(paramContext, "BD_PROXY_APPID_KEY");
    }
    if (TextUtils.isEmpty(e)) {
      e = m.a(paramContext, "BD_PROXY_APPKEY_KEY");
    }
    if ((TextUtils.isEmpty(d)) || (TextUtils.isEmpty(e)))
    {
      k(paramContext);
      return;
    }
    p.d(paramContext, d, e);
    o(paramContext);
  }
  
  public static void c(Context paramContext, int paramInt, String paramString)
  {
    p.b("startWork at time of " + System.currentTimeMillis(), paramContext);
    o.a(paramContext);
    b(paramContext, 0);
  }
  
  public static String d(Context paramContext, Intent paramIntent)
  {
    int m = 0;
    if (paramIntent != null) {}
    for (;;)
    {
      try
      {
        Uri localUri = paramIntent.getData();
        paramContext = paramIntent.getStringExtra("bdpush_hwsigninfo");
        paramIntent = paramIntent.getStringExtra("bdpush_hwmsgid");
        if ((TextUtils.isEmpty(paramContext)) || (TextUtils.isEmpty(paramIntent)))
        {
          if (localUri != null)
          {
            Object localObject = localUri.getFragment();
            paramContext = paramIntent;
            if (!TextUtils.isEmpty((CharSequence)localObject))
            {
              localObject = ((String)localObject).split(";");
              paramContext = paramIntent;
              if (localObject != null)
              {
                paramContext = paramIntent;
                if (localObject.length > 0)
                {
                  paramContext = paramIntent;
                  if (m < localObject.length)
                  {
                    if (!localObject[m].contains("S.bdpush_hwmsgid")) {
                      break label219;
                    }
                    paramContext = localObject[m].split("=");
                    if ((paramContext == null) || (1 >= paramContext.length)) {
                      break label219;
                    }
                    paramContext = paramContext[1];
                  }
                }
              }
            }
            paramIntent = localUri.toString();
            if ((!TextUtils.isEmpty(paramIntent)) && (paramIntent.contains("#Intent;")))
            {
              m = p.c(paramIntent);
              if (m > 0) {
                return paramContext + paramIntent.substring(0, m);
              }
            }
          }
        }
        else if (localUri != null)
        {
          paramContext = paramIntent + localUri.toString();
          return paramContext;
        }
      }
      catch (Exception paramContext) {}
      return null;
      label219:
      m += 1;
    }
  }
  
  public static void d(Context paramContext)
  {
    paramContext = paramContext.getApplicationContext();
    if (TextUtils.isEmpty(f)) {
      f = m.a(paramContext, "BD_MEIZU_PROXY_APPID_KEY");
    }
    if (TextUtils.isEmpty(g)) {
      g = m.a(paramContext, "BD_MEIZU_PROXY_APPKEY_KEY");
    }
    if ((TextUtils.isEmpty(f)) || (TextUtils.isEmpty(g)))
    {
      k(paramContext);
      return;
    }
    p.e(paramContext, f, g);
    o(paramContext);
  }
  
  public static void d(Context paramContext, int paramInt, String paramString)
  {
    paramString = "errorCode:" + paramInt + ",errorMsg:" + paramString;
    com.baidu.android.pushservice.g.a.b("PushManagerHandler", paramString, paramContext.getApplicationContext());
    if (paramContext != null)
    {
      com.baidu.android.pushservice.d.c.a(paramContext, 0L);
      if (p.E(paramContext))
      {
        localObject = paramContext.getSharedPreferences(paramContext.getPackageName() + ".push_sync", 5).edit();
        ((SharedPreferences.Editor)localObject).putLong("priority2", 0L);
        ((SharedPreferences.Editor)localObject).commit();
      }
      localObject = paramContext.getSharedPreferences("com.baidu.pushservice.BIND_CACHE", 0).edit();
      ((SharedPreferences.Editor)localObject).putBoolean("bind_status", false);
      ((SharedPreferences.Editor)localObject).commit();
    }
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("method", "method_bind");
    ((Intent)localObject).putExtra("error_msg", paramInt);
    ((Intent)localObject).putExtra("content", paramString.getBytes());
    ((Intent)localObject).putExtra("bind_status", 0);
    p.b(paramContext, (Intent)localObject, "com.baidu.android.pushservice.action.RECEIVE", paramContext.getPackageName());
  }
  
  public static void e(Context paramContext)
  {
    paramContext = paramContext.getApplicationContext();
    p.z(paramContext);
    o(paramContext);
  }
  
  public static void f(Context paramContext)
  {
    Intent localIntent = a(paramContext);
    if (localIntent == null) {
      return;
    }
    localIntent.putExtra("method", "method_unbind");
    b(paramContext, localIntent);
  }
  
  public static void g(Context paramContext)
  {
    Intent localIntent = a(paramContext);
    if (localIntent == null) {
      return;
    }
    localIntent.putExtra("method", "method_unbind");
    localIntent.putExtra("should_notify_user", false);
    b(paramContext, localIntent);
  }
  
  public static void h(Context paramContext)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("com.baidu.android.pushservice.action.RECEIVE");
    localIntent.putExtra("method", "method_unbind");
    localIntent.putExtra("error_msg", 0);
    localIntent.putExtra("content", PushConstants.a(0).getBytes());
    localIntent.setFlags(32);
    localIntent.setPackage(paramContext.getPackageName());
    p.b(paramContext, localIntent, localIntent.getAction(), paramContext.getPackageName());
  }
  
  public static void i(Context paramContext)
  {
    if ((j != null) && (!k.isEmpty()))
    {
      j.sendEmptyMessage(65553);
      k(paramContext);
    }
  }
  
  public static void j(Context paramContext)
  {
    i(paramContext);
  }
  
  public static void k(Context paramContext)
  {
    Intent localIntent = new Intent();
    String str = PushConstants.a(30602);
    localIntent.setAction("com.baidu.android.pushservice.action.RECEIVE");
    localIntent.putExtra("method", "method_bind");
    localIntent.putExtra("error_msg", 30602);
    localIntent.putExtra("content", str.getBytes());
    localIntent.setFlags(32);
    p.b(paramContext, localIntent, localIntent.getAction(), paramContext.getPackageName());
  }
  
  public static boolean l(Context paramContext)
  {
    return paramContext == null;
  }
  
  private static void o(Context paramContext)
  {
    paramContext = paramContext.getApplicationContext();
    if (k.size() > 100) {
      return;
    }
    b localb = new b(paramContext);
    k.add(localb);
    if (j == null) {
      j = new a(paramContext);
    }
    j.postDelayed(localb, 9000L);
  }
  
  private static void p(Context paramContext)
  {
    try
    {
      com.baidu.android.pushservice.g.a.b("PushManagerHandler", "errorCode:10011", paramContext.getApplicationContext());
      Intent localIntent = new Intent();
      localIntent.putExtra("method", "method_bind");
      localIntent.putExtra("error_msg", 10011);
      localIntent.putExtra("content", "errorCode:10011".getBytes());
      localIntent.putExtra("bind_status", 0);
      p.b(paramContext, localIntent, "com.baidu.android.pushservice.action.RECEIVE", paramContext.getPackageName());
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  private static void q(final Context paramContext)
  {
    if (!l)
    {
      paramContext = new com.baidu.android.pushservice.i.c("checkAppStatus", (short)90)
      {
        /* Error */
        public void a()
        {
          // Byte code:
          //   0: iconst_1
          //   1: invokestatic 27	com/baidu/android/pushservice/f:a	(Z)Z
          //   4: pop
          //   5: aload_0
          //   6: getfield 15	com/baidu/android/pushservice/f$4:a	Landroid/content/Context;
          //   9: ldc 29
          //   11: iconst_0
          //   12: invokevirtual 35	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
          //   15: astore 5
          //   17: aload 5
          //   19: ldc 37
          //   21: ldc2_w 38
          //   24: invokeinterface 45 4 0
          //   29: lstore_1
          //   30: lload_1
          //   31: ldc2_w 38
          //   34: lcmp
          //   35: ifne +20 -> 55
          //   38: aload_0
          //   39: getfield 15	com/baidu/android/pushservice/f$4:a	Landroid/content/Context;
          //   42: invokestatic 51	com/baidu/android/pushservice/j/p:m	(Landroid/content/Context;)Ljava/util/List;
          //   45: astore_3
          //   46: aload_0
          //   47: getfield 15	com/baidu/android/pushservice/f$4:a	Landroid/content/Context;
          //   50: aload_3
          //   51: invokestatic 56	com/baidu/android/pushservice/j/m:a	(Landroid/content/Context;Ljava/util/List;)V
          //   54: return
          //   55: ldc2_w 57
          //   58: lload_1
          //   59: ladd
          //   60: invokestatic 64	android/text/format/DateUtils:isToday	(J)Z
          //   63: ifeq +576 -> 639
          //   66: aload_0
          //   67: getfield 15	com/baidu/android/pushservice/f$4:a	Landroid/content/Context;
          //   70: invokestatic 51	com/baidu/android/pushservice/j/p:m	(Landroid/content/Context;)Ljava/util/List;
          //   73: astore 6
          //   75: aload 6
          //   77: ifnull -23 -> 54
          //   80: aload 6
          //   82: invokeinterface 70 1 0
          //   87: bipush 20
          //   89: if_icmpgt -35 -> 54
          //   92: aload 6
          //   94: invokeinterface 74 1 0
          //   99: astore 7
          //   101: aload 7
          //   103: invokeinterface 80 1 0
          //   108: ifeq +576 -> 684
          //   111: aload 7
          //   113: invokeinterface 84 1 0
          //   118: checkcast 86	java/lang/String
          //   121: astore 8
          //   123: aconst_null
          //   124: astore 4
          //   126: aload_0
          //   127: getfield 15	com/baidu/android/pushservice/f$4:a	Landroid/content/Context;
          //   130: invokevirtual 90	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
          //   133: astore_3
          //   134: aload_3
          //   135: ifnull +310 -> 445
          //   138: new 92	java/lang/StringBuilder
          //   141: dup
          //   142: invokespecial 94	java/lang/StringBuilder:<init>	()V
          //   145: ldc 96
          //   147: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   150: aload 8
          //   152: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   155: ldc 102
          //   157: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   160: ldc 104
          //   162: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   165: ldc 106
          //   167: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   170: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   173: invokestatic 116	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
          //   176: astore 9
          //   178: getstatic 122	com/baidu/android/pushservice/d/c$a:c	Lcom/baidu/android/pushservice/d/c$a;
          //   181: invokevirtual 125	com/baidu/android/pushservice/d/c$a:name	()Ljava/lang/String;
          //   184: astore 8
          //   186: aload_3
          //   187: aload 9
          //   189: aconst_null
          //   190: aconst_null
          //   191: aconst_null
          //   192: new 92	java/lang/StringBuilder
          //   195: dup
          //   196: invokespecial 94	java/lang/StringBuilder:<init>	()V
          //   199: aload 8
          //   201: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   204: ldc 127
          //   206: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   209: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   212: invokevirtual 133	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
          //   215: astore_3
          //   216: aload_3
          //   217: astore 4
          //   219: aload_3
          //   220: ifnull +228 -> 448
          //   223: aload_3
          //   224: astore 4
          //   226: aload_3
          //   227: invokeinterface 138 1 0
          //   232: ifeq +216 -> 448
          //   235: aload_3
          //   236: aload_3
          //   237: aload 8
          //   239: invokeinterface 142 2 0
          //   244: invokeinterface 145 2 0
          //   249: lstore_1
          //   250: aload_3
          //   251: ifnull +9 -> 260
          //   254: aload_3
          //   255: invokeinterface 148 1 0
          //   260: lload_1
          //   261: ldc2_w 38
          //   264: lcmp
          //   265: ifeq +10 -> 275
          //   268: lload_1
          //   269: invokestatic 64	android/text/format/DateUtils:isToday	(J)Z
          //   272: ifne +357 -> 629
          //   275: aload 5
          //   277: ldc -106
          //   279: ldc -104
          //   281: invokeinterface 156 3 0
          //   286: astore 4
          //   288: aload 4
          //   290: invokestatic 162	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
          //   293: ifne +336 -> 629
          //   296: new 164	java/util/ArrayList
          //   299: dup
          //   300: invokespecial 165	java/util/ArrayList:<init>	()V
          //   303: astore_3
          //   304: new 164	java/util/ArrayList
          //   307: dup
          //   308: aload 4
          //   310: ldc -89
          //   312: invokevirtual 171	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
          //   315: invokestatic 177	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
          //   318: invokespecial 180	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
          //   321: astore 4
          //   323: new 164	java/util/ArrayList
          //   326: dup
          //   327: aload 4
          //   329: invokespecial 180	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
          //   332: astore 7
          //   334: aload 7
          //   336: aload 6
          //   338: invokeinterface 184 2 0
          //   343: pop
          //   344: aload 7
          //   346: invokeinterface 74 1 0
          //   351: astore 8
          //   353: aload 8
          //   355: invokeinterface 80 1 0
          //   360: ifeq +142 -> 502
          //   363: aload 8
          //   365: invokeinterface 84 1 0
          //   370: checkcast 86	java/lang/String
          //   373: astore 9
          //   375: aload 5
          //   377: aload 9
          //   379: ldc -104
          //   381: invokeinterface 156 3 0
          //   386: astore 10
          //   388: aload 10
          //   390: invokestatic 162	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
          //   393: ifne -40 -> 353
          //   396: aload 10
          //   398: ldc -89
          //   400: invokevirtual 171	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
          //   403: astore 10
          //   405: aload_3
          //   406: new 186	com/baidu/android/pushservice/h/h
          //   409: dup
          //   410: aload 9
          //   412: aload 10
          //   414: iconst_0
          //   415: aaload
          //   416: invokestatic 192	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
          //   419: invokevirtual 195	java/lang/Integer:intValue	()I
          //   422: aload 10
          //   424: iconst_1
          //   425: aaload
          //   426: sipush 1000
          //   429: invokespecial 198	com/baidu/android/pushservice/h/h:<init>	(Ljava/lang/String;ILjava/lang/String;I)V
          //   432: invokeinterface 202 2 0
          //   437: pop
          //   438: goto -85 -> 353
          //   441: astore_3
          //   442: goto -182 -> 260
          //   445: aconst_null
          //   446: astore 4
          //   448: aload 4
          //   450: ifnull -349 -> 101
          //   453: aload 4
          //   455: invokeinterface 148 1 0
          //   460: goto -359 -> 101
          //   463: astore_3
          //   464: goto -363 -> 101
          //   467: astore_3
          //   468: aconst_null
          //   469: astore_3
          //   470: aload_3
          //   471: ifnull -370 -> 101
          //   474: aload_3
          //   475: invokeinterface 148 1 0
          //   480: goto -379 -> 101
          //   483: astore_3
          //   484: goto -383 -> 101
          //   487: astore_3
          //   488: aload 4
          //   490: ifnull +10 -> 500
          //   493: aload 4
          //   495: invokeinterface 148 1 0
          //   500: aload_3
          //   501: athrow
          //   502: aload 4
          //   504: aload 7
          //   506: invokeinterface 205 2 0
          //   511: pop
          //   512: aload 4
          //   514: invokeinterface 74 1 0
          //   519: astore 4
          //   521: aload 4
          //   523: invokeinterface 80 1 0
          //   528: ifeq +93 -> 621
          //   531: aload 4
          //   533: invokeinterface 84 1 0
          //   538: checkcast 86	java/lang/String
          //   541: astore 7
          //   543: aload 6
          //   545: aload 7
          //   547: invokeinterface 208 2 0
          //   552: ifne -31 -> 521
          //   555: aload 5
          //   557: aload 7
          //   559: ldc -104
          //   561: invokeinterface 156 3 0
          //   566: astore 8
          //   568: aload 8
          //   570: invokestatic 162	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
          //   573: ifne -52 -> 521
          //   576: aload 8
          //   578: ldc -89
          //   580: invokevirtual 171	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
          //   583: astore 8
          //   585: aload_3
          //   586: new 186	com/baidu/android/pushservice/h/h
          //   589: dup
          //   590: aload 7
          //   592: aload 8
          //   594: iconst_0
          //   595: aaload
          //   596: invokestatic 192	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
          //   599: invokevirtual 195	java/lang/Integer:intValue	()I
          //   602: aload 8
          //   604: iconst_1
          //   605: aaload
          //   606: sipush 1001
          //   609: invokespecial 198	com/baidu/android/pushservice/h/h:<init>	(Ljava/lang/String;ILjava/lang/String;I)V
          //   612: invokeinterface 202 2 0
          //   617: pop
          //   618: goto -97 -> 521
          //   621: aload_0
          //   622: getfield 15	com/baidu/android/pushservice/f$4:a	Landroid/content/Context;
          //   625: aload_3
          //   626: invokestatic 211	com/baidu/android/pushservice/d/c:a	(Landroid/content/Context;Ljava/util/List;)V
          //   629: aload_0
          //   630: getfield 15	com/baidu/android/pushservice/f$4:a	Landroid/content/Context;
          //   633: aload 6
          //   635: invokestatic 56	com/baidu/android/pushservice/j/m:a	(Landroid/content/Context;Ljava/util/List;)V
          //   638: return
          //   639: lload_1
          //   640: invokestatic 64	android/text/format/DateUtils:isToday	(J)Z
          //   643: ifne -589 -> 54
          //   646: aload_0
          //   647: getfield 15	com/baidu/android/pushservice/f$4:a	Landroid/content/Context;
          //   650: invokestatic 51	com/baidu/android/pushservice/j/p:m	(Landroid/content/Context;)Ljava/util/List;
          //   653: astore_3
          //   654: aload_0
          //   655: getfield 15	com/baidu/android/pushservice/f$4:a	Landroid/content/Context;
          //   658: aload_3
          //   659: invokestatic 56	com/baidu/android/pushservice/j/m:a	(Landroid/content/Context;Ljava/util/List;)V
          //   662: return
          //   663: astore 4
          //   665: goto -165 -> 500
          //   668: astore 5
          //   670: aload_3
          //   671: astore 4
          //   673: aload 5
          //   675: astore_3
          //   676: goto -188 -> 488
          //   679: astore 4
          //   681: goto -211 -> 470
          //   684: ldc2_w 38
          //   687: lstore_1
          //   688: goto -428 -> 260
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	691	0	this	4
          //   29	659	1	l	long
          //   45	361	3	localObject1	Object
          //   441	1	3	localException1	Exception
          //   463	1	3	localException2	Exception
          //   467	1	3	localThrowable1	Throwable
          //   469	6	3	localObject2	Object
          //   483	1	3	localException3	Exception
          //   487	139	3	localList1	List
          //   653	23	3	localObject3	Object
          //   124	408	4	localObject4	Object
          //   663	1	4	localException4	Exception
          //   671	1	4	localObject5	Object
          //   679	1	4	localThrowable2	Throwable
          //   15	541	5	localSharedPreferences	SharedPreferences
          //   668	6	5	localObject6	Object
          //   73	561	6	localList2	List
          //   99	492	7	localObject7	Object
          //   121	482	8	localObject8	Object
          //   176	235	9	localObject9	Object
          //   386	37	10	localObject10	Object
          // Exception table:
          //   from	to	target	type
          //   254	260	441	java/lang/Exception
          //   453	460	463	java/lang/Exception
          //   126	134	467	java/lang/Throwable
          //   138	216	467	java/lang/Throwable
          //   474	480	483	java/lang/Exception
          //   126	134	487	finally
          //   138	216	487	finally
          //   493	500	663	java/lang/Exception
          //   226	250	668	finally
          //   226	250	679	java/lang/Throwable
        }
      };
      com.baidu.android.pushservice.i.d.a().a(paramContext);
    }
  }
  
  private static void r(Context paramContext)
  {
    if (!paramContext.getPackageName().startsWith("com.baidu")) {}
    String str;
    boolean bool;
    int m;
    long l1;
    do
    {
      return;
      SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("com.baidu.pushservice.switch_sync", 0);
      str = localSharedPreferences.getString("base_url", "");
      bool = localSharedPreferences.getBoolean("switch_enable", true);
      m = localSharedPreferences.getInt("sync_type", 1);
      l1 = localSharedPreferences.getLong("target_time", 0L);
    } while ((TextUtils.isEmpty(str)) || (l1 == 0L) || (System.currentTimeMillis() < l1));
    a(paramContext, str, bool, m, null);
  }
  
  private static String s(Context paramContext)
  {
    if (TextUtils.isEmpty(b)) {
      return m.a(paramContext, "com.baidu.android.pushservice.PushManager.LONGIN_VALUE");
    }
    return b;
  }
  
  private static void t(Context paramContext)
  {
    paramContext.getSharedPreferences("com.baidu.pushservice.switch_sync", 0).edit().clear().apply();
  }
  
  private static class a
    extends Handler
  {
    public a(Context paramContext)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      if ((paramMessage.what == 65553) && (f.j != null) && (f.a() != null) && (!f.a().isEmpty()))
      {
        paramMessage = (f.b)f.a().poll();
        f.j.removeCallbacks(paramMessage);
      }
    }
  }
  
  private static class b
    implements Runnable
  {
    private Context a;
    
    public b(Context paramContext)
    {
      this.a = paramContext;
    }
    
    public void run()
    {
      String str = null;
      if (com.baidu.android.pushservice.c.d.c(this.a)) {
        str = n.b(this.a);
      }
      for (;;)
      {
        if (TextUtils.isEmpty(str))
        {
          f.m(this.a);
          if (!f.a().isEmpty()) {
            f.a().poll();
          }
        }
        return;
        if (com.baidu.android.pushservice.c.d.d(this.a)) {
          str = n.a(this.a);
        } else if (com.baidu.android.pushservice.c.d.b(this.a)) {
          str = n.c(this.a);
        }
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */