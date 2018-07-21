package com.baidu.android.pushservice;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.android.pushservice.b.b;
import com.baidu.android.pushservice.b.g;
import com.baidu.android.pushservice.e.m;
import com.baidu.android.pushservice.e.n;
import com.baidu.android.pushservice.e.o;
import com.baidu.android.pushservice.e.r;
import com.baidu.android.pushservice.e.s;
import com.baidu.android.pushservice.e.t;
import com.baidu.android.pushservice.e.u;
import com.baidu.android.pushservice.e.v;
import com.baidu.android.pushservice.e.w;
import com.baidu.android.pushservice.e.y;
import com.baidu.android.pushservice.e.z;
import com.baidu.android.pushservice.i.d;
import com.baidu.android.pushservice.message.PublicMsg;
import com.baidu.android.pushservice.message.a.c;

public class i
{
  private static i c;
  private Context a;
  private com.baidu.android.pushservice.h.q b;
  
  private i(Context paramContext)
  {
    this.a = paramContext;
    b.a(paramContext);
    j.a(paramContext);
    d.a();
  }
  
  public static i a(Context paramContext)
  {
    if (c == null) {
      c = new i(paramContext);
    }
    return c;
  }
  
  private void b(Intent paramIntent)
  {
    com.baidu.android.pushservice.e.l locall = new com.baidu.android.pushservice.e.l(paramIntent);
    int i = paramIntent.getIntExtra("bind_status", 0);
    int j = paramIntent.getIntExtra("push_sdk_version", 0);
    com.baidu.android.pushservice.g.a.a("RegistrationService", "<<< METHOD_BIND ", this.a);
    com.baidu.android.pushservice.j.p.b("RegistrationService#handleBind#METHOD_BIND request arrive at " + System.currentTimeMillis(), this.a);
    String str = b.a(this.a).f(locall.e);
    if ((!TextUtils.isEmpty(locall.i)) && (b.a(this.a).b(locall.e, locall.i)) && (!TextUtils.isEmpty(str)))
    {
      paramIntent = new Intent();
      paramIntent.putExtra("method", locall.a);
      paramIntent.putExtra("error_msg", 0);
      paramIntent.putExtra("content", str.getBytes());
      paramIntent.putExtra("bind_status", i);
      if (a.b() > 0) {
        com.baidu.android.pushservice.h.q.a(this.a, "039902", 2, str);
      }
      com.baidu.android.pushservice.j.p.b(this.a, paramIntent, "com.baidu.android.pushservice.action.RECEIVE", locall.e);
      com.baidu.android.pushservice.j.p.b("RegistrationService#handleBind#returned by cacheContent = " + str, this.a);
    }
    for (;;)
    {
      return;
      com.baidu.android.pushservice.j.p.b("RegistrationService#handleBind#METHOD_BIND request start at " + System.currentTimeMillis(), this.a);
      if (a.b() > 0) {
        com.baidu.android.pushservice.h.q.a(this.a, "039902", 0, str);
      }
      boolean bool;
      if (paramIntent.hasExtra("bind_notify_status"))
      {
        paramIntent = paramIntent.getStringExtra("bind_notify_status");
        bool = a(new com.baidu.android.pushservice.e.f(locall, this.a, i, j, paramIntent));
        com.baidu.android.pushservice.j.p.b("submitApiProcessor for bind=" + locall.toString(), this.a);
      }
      while (!bool)
      {
        new Thread(new com.baidu.android.pushservice.e.f(locall, this.a, i, j)).start();
        com.baidu.android.pushservice.j.p.b("submitApiProcessor failed bind " + locall.toString(), this.a);
        return;
        bool = a(new com.baidu.android.pushservice.e.f(locall, this.a, i, j));
        com.baidu.android.pushservice.j.p.b("submitApiProcessor for bind=" + locall.toString(), this.a);
      }
    }
  }
  
  private void c(Intent paramIntent)
  {
    com.baidu.android.pushservice.e.l locall = new com.baidu.android.pushservice.e.l(paramIntent);
    int i = paramIntent.getIntExtra("bind_status", 0);
    int j = paramIntent.getIntExtra("push_sdk_version", 0);
    int k = paramIntent.getIntExtra("sdk_client_version", 0);
    paramIntent = new g(locall.i, locall.e);
    paramIntent.a(k);
    com.baidu.android.pushservice.b.h.a(this.a).a(paramIntent, true);
    com.baidu.android.pushservice.g.a.a("RegistrationService", "<<< METHOD_SDK_BIND ", this.a);
    a(new com.baidu.android.pushservice.e.f(locall, this.a, i, j));
  }
  
  private void d(Intent paramIntent)
  {
    paramIntent = new com.baidu.android.pushservice.e.l(paramIntent);
    com.baidu.android.pushservice.g.a.a("RegistrationService", "<<< METHOD_UNBIND ", this.a);
    if ((!TextUtils.isEmpty(paramIntent.e)) && (!TextUtils.isEmpty(paramIntent.i)))
    {
      com.baidu.android.pushservice.b.f localf = b.a(this.a).c(paramIntent.e);
      if ((localf != null) && (!TextUtils.isEmpty(localf.a()))) {
        paramIntent.f = localf.a();
      }
      b.a(this.a).g(paramIntent.e);
    }
    a(new y(paramIntent, this.a));
  }
  
  private void e(Intent paramIntent)
  {
    paramIntent = new com.baidu.android.pushservice.e.l(paramIntent);
    com.baidu.android.pushservice.g.a.a("RegistrationService", "<<< METHOD_SDK_UNBIND ", this.a);
    a(new y(paramIntent, this.a));
  }
  
  private void f(Intent paramIntent)
  {
    a(new y(new com.baidu.android.pushservice.e.l(paramIntent), this.a));
  }
  
  private boolean g(Intent paramIntent)
  {
    String str2 = paramIntent.getStringExtra("package_name");
    String str1 = paramIntent.getStringExtra("app_id");
    Object localObject = str1;
    if (TextUtils.isEmpty(str1))
    {
      com.baidu.android.pushservice.b.f localf = b.a(this.a).c(str2);
      localObject = str1;
      if (localf != null) {
        localObject = localf.a();
      }
    }
    str1 = paramIntent.getStringExtra("user_id");
    PushSettings.c(this.a, str2);
    paramIntent = new com.baidu.android.pushservice.e.l();
    paramIntent.a = "com.baidu.android.pushservice.action.UNBINDAPP";
    if (!TextUtils.isEmpty(str2)) {
      paramIntent.e = str2;
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!"null".equals(localObject))) {
      paramIntent.f = ((String)localObject);
    }
    if ((!TextUtils.isEmpty(str1)) && (!"null".equals(str1))) {
      paramIntent.g = str1;
    }
    if (!TextUtils.isEmpty(paramIntent.e))
    {
      localObject = b.a(this.a).c(paramIntent.e);
      if ((localObject != null) && (!TextUtils.isEmpty(((com.baidu.android.pushservice.b.f)localObject).a()))) {
        paramIntent.f = ((com.baidu.android.pushservice.b.f)localObject).a();
      }
      b.a(this.a).g(paramIntent.e);
    }
    return a(new z(paramIntent, this.a));
  }
  
  private void h(Intent paramIntent)
  {
    com.baidu.android.pushservice.e.l locall = new com.baidu.android.pushservice.e.l(paramIntent);
    int i = paramIntent.getIntExtra("fetch_type", 1);
    int j = paramIntent.getIntExtra("fetch_num", 1);
    com.baidu.android.pushservice.g.a.a("RegistrationService", "<<< METHOD_FETCH ", this.a);
    a(new m(locall, this.a, i, j));
  }
  
  private void i(Intent paramIntent)
  {
    paramIntent = new com.baidu.android.pushservice.e.l(paramIntent);
    com.baidu.android.pushservice.g.a.a("RegistrationService", "<<< METHOD_COUNT ", this.a);
    a(new com.baidu.android.pushservice.e.h(paramIntent, this.a));
  }
  
  private void j(Intent paramIntent)
  {
    com.baidu.android.pushservice.e.l locall = new com.baidu.android.pushservice.e.l(paramIntent);
    paramIntent = paramIntent.getStringArrayExtra("msg_ids");
    com.baidu.android.pushservice.g.a.a("RegistrationService", "<<< METHOD_DELETE ", this.a);
    a(new com.baidu.android.pushservice.e.k(locall, this.a, paramIntent));
  }
  
  private void k(Intent paramIntent)
  {
    com.baidu.android.pushservice.e.l locall = new com.baidu.android.pushservice.e.l(paramIntent);
    paramIntent = paramIntent.getStringExtra("gid");
    com.baidu.android.pushservice.g.a.a("RegistrationService", "<<< ACTION_GBIND ", this.a);
    a(new o(locall, this.a, paramIntent));
  }
  
  private void l(Intent paramIntent)
  {
    com.baidu.android.pushservice.e.l locall = new com.baidu.android.pushservice.e.l(paramIntent);
    paramIntent = paramIntent.getStringExtra("tags");
    com.baidu.android.pushservice.g.a.a("RegistrationService", "<<< ACTION_SET_TAGS ", this.a);
    a(new w(locall, this.a, paramIntent));
  }
  
  private void m(Intent paramIntent)
  {
    com.baidu.android.pushservice.e.l locall = new com.baidu.android.pushservice.e.l(paramIntent);
    paramIntent = paramIntent.getStringExtra("tags");
    com.baidu.android.pushservice.g.a.a("RegistrationService", "<<< ACTION_GBIND ", this.a);
    a(new com.baidu.android.pushservice.e.j(locall, this.a, paramIntent));
  }
  
  private void n(Intent paramIntent)
  {
    com.baidu.android.pushservice.e.l locall = new com.baidu.android.pushservice.e.l(paramIntent);
    paramIntent = paramIntent.getStringExtra("gid");
    com.baidu.android.pushservice.g.a.a("RegistrationService", "<<< ACTION_GUNBIND ", this.a);
    a(new r(locall, this.a, paramIntent));
  }
  
  private void o(Intent paramIntent)
  {
    com.baidu.android.pushservice.e.l locall = new com.baidu.android.pushservice.e.l(paramIntent);
    paramIntent = paramIntent.getStringExtra("gid");
    com.baidu.android.pushservice.g.a.a("RegistrationService", "<<< METHOD_GINFO ", this.a);
    a(new com.baidu.android.pushservice.e.p(locall, this.a, paramIntent));
  }
  
  private void p(Intent paramIntent)
  {
    paramIntent = new com.baidu.android.pushservice.e.l(paramIntent);
    com.baidu.android.pushservice.g.a.a("RegistrationService", "<<< METHOD_LISTTAGS ", this.a);
    a(new s(paramIntent, this.a));
  }
  
  private void q(Intent paramIntent)
  {
    paramIntent = new com.baidu.android.pushservice.e.l(paramIntent);
    com.baidu.android.pushservice.g.a.a("RegistrationService", "<<< METHOD_GLIST ", this.a);
    a(new com.baidu.android.pushservice.e.q(paramIntent, this.a));
  }
  
  private void r(Intent paramIntent)
  {
    com.baidu.android.pushservice.e.l locall = new com.baidu.android.pushservice.e.l(paramIntent);
    String str = paramIntent.getStringExtra("gid");
    int i = paramIntent.getIntExtra("group_fetch_type", 1);
    int j = paramIntent.getIntExtra("group_fetch_num", 1);
    com.baidu.android.pushservice.g.a.a("RegistrationService", "<<< METHOD_FETCHGMSG ", this.a);
    a(new n(locall, this.a, str, i, j));
  }
  
  private void s(Intent paramIntent)
  {
    com.baidu.android.pushservice.e.l locall = new com.baidu.android.pushservice.e.l(paramIntent);
    paramIntent = paramIntent.getStringExtra("gid");
    com.baidu.android.pushservice.g.a.a("RegistrationService", "<<< METHOD_COUNTGMSG ", this.a);
    a(new com.baidu.android.pushservice.e.i(locall, this.a, paramIntent));
  }
  
  private void t(Intent paramIntent)
  {
    paramIntent = new com.baidu.android.pushservice.e.l(paramIntent);
    com.baidu.android.pushservice.g.a.a("RegistrationService", "<<< METHOD_ONLINE ", this.a);
    a(new t(paramIntent, this.a));
  }
  
  private void u(Intent paramIntent)
  {
    com.baidu.android.pushservice.e.l locall = new com.baidu.android.pushservice.e.l(paramIntent);
    com.baidu.android.pushservice.g.a.a("RegistrationService", "<<< METHOD_SEND ", this.a);
    paramIntent = paramIntent.getStringExtra("push_ msg");
    a(new u(locall, this.a, paramIntent));
  }
  
  private void v(Intent paramIntent)
  {
    com.baidu.android.pushservice.e.l locall = new com.baidu.android.pushservice.e.l(paramIntent);
    com.baidu.android.pushservice.g.a.a("RegistrationService", "<<< METHOD_SEND_MSG_TO_USER ", this.a);
    String str1 = paramIntent.getStringExtra("app_id");
    String str2 = paramIntent.getStringExtra("user_id");
    String str3 = paramIntent.getStringExtra("push_ msg_key");
    paramIntent = paramIntent.getStringExtra("push_ msg");
    a(new v(locall, this.a, str1, str2, str3, paramIntent));
  }
  
  private void w(Intent paramIntent)
  {
    if (this.b == null) {
      this.b = new com.baidu.android.pushservice.h.q(this.a);
    }
    this.b.a();
    this.b.a(false, null);
  }
  
  private void x(Intent paramIntent)
  {
    if (this.b == null) {
      this.b = new com.baidu.android.pushservice.h.q(this.a);
    }
    boolean bool = paramIntent.getBooleanExtra("force_send", false);
    this.b.a(bool, null);
  }
  
  private void y(Intent paramIntent)
  {
    PushSettings.a(this.a, 0);
  }
  
  public boolean a(Intent paramIntent)
  {
    Object localObject2 = null;
    boolean bool2 = true;
    boolean bool1;
    if ((paramIntent == null) || (TextUtils.isEmpty(paramIntent.getAction()))) {
      bool1 = false;
    }
    String str;
    do
    {
      return bool1;
      str = paramIntent.getAction();
      com.baidu.android.pushservice.j.p.b("handleIntent#action = " + str, this.a);
      if ("com.baidu.android.pushservice.action.OPENDEBUGMODE".equals(str))
      {
        PushSettings.enableDebugMode(this.a, true);
        com.baidu.android.pushservice.g.a.a("RegistrationService", "<<<debugMode is open", this.a);
        return true;
      }
      if ("com.baidu.android.pushservice.action.CLOSEDEBUGMODE".equals(str))
      {
        PushSettings.enableDebugMode(this.a, false);
        com.baidu.android.pushservice.g.a.a("RegistrationService", "<<<debugMode is close", this.a);
        return true;
      }
      if (("com.baidu.pushservice.action.publicmsg.CLICK_V2".equals(str)) || ("com.baidu.pushservice.action.publicmsg.DELETE_V2".equals(str)))
      {
        localObject1 = (PublicMsg)paramIntent.getParcelableExtra("public_msg");
        paramIntent = paramIntent.getData().getHost();
        ((PublicMsg)localObject1).handle(this.a, str, paramIntent);
        return true;
      }
      if ((!"com.baidu.android.pushservice.action.privatenotification.CLICK".equals(str)) && (!"com.baidu.android.pushservice.action.privatenotification.DELETE".equals(str))) {
        break;
      }
      localObject1 = (PublicMsg)paramIntent.getParcelableExtra("public_msg");
      bool1 = bool2;
    } while (!com.baidu.android.pushservice.j.p.b(this.a, (PublicMsg)localObject1));
    localObject2 = paramIntent.getStringExtra("app_id");
    Object localObject3 = paramIntent.getStringExtra("msg_id");
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("baidu_message_secur_info");
    paramIntent = paramIntent.getByteArrayExtra("baidu_message_body");
    ((PublicMsg)localObject1).handlePrivateNotification(this.a, str, (String)localObject3, (String)localObject2, arrayOfByte, paramIntent);
    return true;
    if (("com.baidu.android.pushservice.action.passthrough.notification.CLICK".equals(str)) || ("com.baidu.android.pushservice.action.passthrough.notification.DELETE".equals(str)) || ("com.baidu.android.pushservice.action.passthrough.notification.NOTIFIED".equals(str)))
    {
      com.baidu.android.pushservice.j.p.b("push_passthrough: receive  click delete and notified action", this.a);
      if (!paramIntent.hasExtra("app_id")) {
        break label1269;
      }
    }
    label1269:
    for (Object localObject1 = paramIntent.getStringExtra("app_id");; localObject1 = null)
    {
      if (paramIntent.hasExtra("msg_id")) {
        localObject2 = paramIntent.getStringExtra("msg_id");
      }
      com.baidu.android.pushservice.h.l.a(this.a, (String)localObject2, (String)localObject1, str);
      return true;
      if (("com.baidu.android.pushservice.action.media.CLICK".equals(str)) || ("com.baidu.android.pushservice.action.media.DELETE".equals(str)))
      {
        localObject1 = (PublicMsg)paramIntent.getParcelableExtra("public_msg");
        paramIntent = paramIntent.getStringExtra("app_id");
        ((PublicMsg)localObject1).handleRichMediaNotification(this.a, str, paramIntent);
        return true;
      }
      bool1 = bool2;
      if ("com.baidu.android.pushservice.action.lightapp.notification.CLICK".equals(str)) {
        break;
      }
      bool1 = bool2;
      if ("com.baidu.android.pushservice.action.lightapp.notification.DELETE".equals(str)) {
        break;
      }
      if ("com.baidu.android.pushservice.action.alarm.message".equals(str))
      {
        localObject1 = (com.baidu.android.pushservice.message.k)paramIntent.getSerializableExtra("tinyMessageHead");
        localObject2 = paramIntent.getByteArrayExtra("msgBody");
        ((com.baidu.android.pushservice.message.k)localObject1).a(false);
        if (com.baidu.android.pushservice.d.a.c(this.a, ((com.baidu.android.pushservice.message.k)localObject1).h()).f == 0)
        {
          com.baidu.android.pushservice.d.a.d(this.a, ((com.baidu.android.pushservice.message.k)localObject1).h());
          return true;
        }
        localObject3 = new com.baidu.android.pushservice.message.a.a(this.a);
        if (localObject3 != null) {
          ((c)localObject3).a((com.baidu.android.pushservice.message.k)localObject1, (byte[])localObject2);
        }
      }
      if ("com.baidu.pushservice.action.TOKEN".equals(str))
      {
        com.baidu.android.pushservice.g.a.a("RegistrationService", "<<< ACTION_TOKEN ", this.a);
        bool1 = bool2;
        if (j.a(this.a).c()) {
          break;
        }
        j.a(this.a).a(this.a, true, null);
        return true;
      }
      if (!"com.baidu.android.pushservice.action.METHOD".equals(str)) {
        return false;
      }
      localObject1 = paramIntent.getStringExtra("method");
      if ("method_bind".equals(localObject1))
      {
        b(paramIntent);
        bool1 = true;
      }
      for (;;)
      {
        return bool1;
        if ("method_webapp_bind_from_deeplink".equals(localObject1))
        {
          bool1 = true;
        }
        else if ("method_deal_webapp_bind_intent".equals(localObject1))
        {
          bool1 = true;
        }
        else if ("method_deal_lapp_bind_intent".equals(localObject1))
        {
          bool1 = true;
        }
        else if ("method_get_lapp_bind_state".equals(localObject1))
        {
          bool1 = true;
        }
        else if ("method_sdk_bind".equals(localObject1))
        {
          c(paramIntent);
          bool1 = true;
        }
        else if ("method_unbind".equals(localObject1))
        {
          d(paramIntent);
          bool1 = true;
        }
        else if ("method_sdk_unbind".equals(localObject1))
        {
          e(paramIntent);
          bool1 = true;
        }
        else if ("method_lapp_unbind".equals(localObject1))
        {
          f(paramIntent);
          bool1 = true;
        }
        else if ("com.baidu.android.pushservice.action.UNBINDAPP".equals(localObject1))
        {
          g(paramIntent);
          bool1 = true;
        }
        else if ("method_fetch".equals(localObject1))
        {
          h(paramIntent);
          bool1 = true;
        }
        else if ("method_count".equals(localObject1))
        {
          i(paramIntent);
          bool1 = true;
        }
        else if ("method_delete".equals(localObject1))
        {
          j(paramIntent);
          bool1 = true;
        }
        else if ("method_gbind".equals(localObject1))
        {
          k(paramIntent);
          bool1 = true;
        }
        else if (("method_set_tags".equals(localObject1)) || ("method_set_sdk_tags".equals(localObject1)) || ("method_set_lapp_tags".equals(localObject1)))
        {
          l(paramIntent);
          bool1 = true;
        }
        else if (("method_del_tags".equals(localObject1)) || ("method_del_sdk_tags".equals(localObject1)) || ("method_del_lapp_tags".equals(localObject1)))
        {
          m(paramIntent);
          bool1 = true;
        }
        else if ("method_gunbind".equals(localObject1))
        {
          n(paramIntent);
          bool1 = true;
        }
        else if ("method_ginfo".equals(localObject1))
        {
          o(paramIntent);
          bool1 = true;
        }
        else if ("method_glist".equals(localObject1))
        {
          q(paramIntent);
          bool1 = true;
        }
        else if (("method_listtags".equals(localObject1)) || ("method_list_sdk_tags".equals(localObject1)) || ("method_list_lapp_tags".equals(localObject1)))
        {
          p(paramIntent);
          bool1 = true;
        }
        else if ("method_fetchgmsg".equals(localObject1))
        {
          r(paramIntent);
          bool1 = true;
        }
        else if ("method_countgmsg".equals(localObject1))
        {
          s(paramIntent);
          bool1 = true;
        }
        else if ("method_online".equals(localObject1))
        {
          t(paramIntent);
          bool1 = true;
        }
        else if ("method_send".equals(localObject1))
        {
          u(paramIntent);
          bool1 = true;
        }
        else if ("com.baidu.android.pushservice.action.SEND_APPSTAT".equals(localObject1))
        {
          w(paramIntent);
          bool1 = true;
        }
        else if ("com.baidu.android.pushservice.action.SEND_LBS".equals(localObject1))
        {
          x(paramIntent);
          bool1 = true;
        }
        else if ("com.baidu.android.pushservice.action.ENBALE_APPSTAT".equals(localObject1))
        {
          y(paramIntent);
          bool1 = true;
        }
        else if ("method_send_msg_to_user".equals(localObject1))
        {
          v(paramIntent);
          bool1 = true;
        }
        else
        {
          bool1 = false;
        }
      }
    }
  }
  
  public boolean a(com.baidu.android.pushservice.e.a parama)
  {
    try
    {
      d.a().a(parama);
      return true;
    }
    catch (Exception parama)
    {
      com.baidu.android.pushservice.g.a.a("RegistrationService", parama, this.a);
    }
    return false;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */