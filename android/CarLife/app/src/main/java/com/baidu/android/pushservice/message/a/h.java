package com.baidu.android.pushservice.message.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.baidu.android.pushservice.a;
import com.baidu.android.pushservice.b.d;
import com.baidu.android.pushservice.j.p;
import com.baidu.android.pushservice.message.PublicMsg;
import com.baidu.android.pushservice.message.k;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class h
  extends c
{
  public h(Context paramContext)
  {
    super(paramContext);
  }
  
  public static String[] a(Context paramContext, int paramInt, String paramString1, String paramString2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (!p.a(paramContext, paramArrayOfByte1, paramString1, paramString2, paramArrayOfByte2)) {
      return null;
    }
    paramArrayOfByte1 = new String[2];
    if ((paramInt == l.b.a()) || (paramInt == l.c.a()))
    {
      paramArrayOfByte1[0] = new String(paramArrayOfByte2);
      paramArrayOfByte1[1] = null;
    }
    for (;;)
    {
      return paramArrayOfByte1;
      if (paramInt == l.g.a())
      {
        paramContext = j.a(paramContext, paramString2, paramString1, paramArrayOfByte2);
        paramArrayOfByte1[0] = paramContext.mDescription;
        paramArrayOfByte1[1] = paramContext.mCustomContent;
      }
    }
  }
  
  public com.baidu.android.pushservice.message.g a(k paramk, byte[] paramArrayOfByte)
  {
    String str = paramk.e();
    Object localObject2 = paramk.h();
    int j = paramk.i();
    Object localObject3 = paramk.j();
    paramk = paramk.f();
    int i = 0;
    d locald = d.a(this.a, str);
    Object localObject1 = null;
    if ((!TextUtils.isEmpty(paramk)) && (p.c(this.a, paramk))) {}
    for (;;)
    {
      switch (1.a[locald.a().ordinal()])
      {
      default: 
        i = 7;
        paramk = ">>> NOT found client for privateMessageHandler appid " + str;
        if (Build.VERSION.SDK_INT < 24) {
          f.a(this.a, str);
        }
        p.b(paramk, this.a);
        paramk = new com.baidu.android.pushservice.message.g();
        paramk.a(i);
        return paramk;
        if (locald.a() == com.baidu.android.pushservice.b.c.a)
        {
          paramk = locald.a.c();
        }
        else
        {
          paramk = (k)localObject1;
          if (locald.a() == com.baidu.android.pushservice.b.c.b) {
            paramk = locald.b.c();
          }
        }
        break;
      }
    }
    Object localObject4 = p.a(this.a, (String)localObject2, paramArrayOfByte, (byte[])localObject3, paramk);
    localObject1 = this.a.getPackageManager();
    for (;;)
    {
      Intent localIntent;
      try
      {
        ((PackageManager)localObject1).getPackageInfo(paramk, 128);
        localObject3 = j.a(this.a, (String)localObject2, str, paramArrayOfByte);
        bool = a(paramArrayOfByte);
        if (localObject3 == null) {
          break label858;
        }
        localIntent = new Intent();
        if (a.b() <= 0) {
          break label863;
        }
        localIntent.putExtra("bd.message.rate.GET", System.currentTimeMillis());
        localIntent.putExtra("bd.message.rate.MH", true);
      }
      catch (PackageManager.NameNotFoundException paramk)
      {
        label307:
        i = 8;
        paramk = ">>> NOT deliver to app: " + locald.a.c() + ", package has been uninstalled.";
        f.a(this.a, str);
        p.b(paramk, this.a);
      }
      localIntent.putExtra("message_string", ((PublicMsg)localObject3).mDescription);
      localIntent.putExtra("message_id", (String)localObject2);
      localIntent.putExtra("baidu_message_type", j);
      localIntent.putExtra("baidu_message_body", paramArrayOfByte);
      localIntent.putExtra("app_id", str);
      localIntent.putExtra("baidu_message_secur_info", (byte[])localObject4);
      boolean bool = TextUtils.isEmpty(((PublicMsg)localObject3).mCustomContent);
      if (!bool) {
        try
        {
          paramArrayOfByte = new JSONObject(((PublicMsg)localObject3).mCustomContent);
          localObject2 = paramArrayOfByte.keys();
          if (!((Iterator)localObject2).hasNext()) {
            break label601;
          }
          localObject4 = (String)((Iterator)localObject2).next();
          localIntent.putExtra((String)localObject4, paramArrayOfByte.getString((String)localObject4));
          continue;
          if (a.b() <= 0) {
            continue;
          }
        }
        catch (JSONException paramArrayOfByte) {}
      } else {
        label443:
        localIntent.putExtra("bd.message.rate.REDIRECTION", System.currentTimeMillis());
      }
      i = p.a(this.a, localIntent, (String)localObject1, paramk);
      p.b(">>> Deliver message to client: " + paramk + " msg: " + ((PublicMsg)localObject3).mDescription + " result: " + i, this.a);
      break;
      break;
      label601:
      label858:
      label863:
      do
      {
        localIntent.putExtra("msg_id", (String)localObject2);
        localObject1 = "com.baidu.android.pushservice.action.MESSAGE";
        break label307;
        localIntent.putExtra("extra_extra_custom_content", ((PublicMsg)localObject3).mCustomContent);
        break label443;
        localObject1 = p.a(this.a, (String)localObject2, paramArrayOfByte, (byte[])localObject3, paramk);
        try
        {
          str = new JSONObject(new String(paramArrayOfByte)).optString("description");
          bool = TextUtils.isEmpty(str);
          if (!bool) {}
          for (;;)
          {
            try
            {
              this.a.getPackageManager().getPackageInfo(paramk, 128);
              localObject3 = new Intent();
              ((Intent)localObject3).setPackage(locald.b.c());
              ((Intent)localObject3).putExtra("message", paramArrayOfByte);
              ((Intent)localObject3).putExtra("message_string", str);
              ((Intent)localObject3).setFlags(32);
              ((Intent)localObject3).putExtra("baidu_message_body", paramArrayOfByte);
              ((Intent)localObject3).putExtra("baidu_message_secur_info", (byte[])localObject1);
              ((Intent)localObject3).putExtra("message_id", (String)localObject2);
              ((Intent)localObject3).putExtra("baidu_message_type", j);
              p.b(this.a, (Intent)localObject3, "com.baidu.android.pushservice.action.SDK_MESSAGE", paramk);
            }
            catch (PackageManager.NameNotFoundException paramk)
            {
              new StringBuilder().append(">>> NOT deliver to app: ").append(locald.b.c()).append(", package has been uninstalled.").toString();
              com.baidu.android.pushservice.b.h.a(this.a).a(locald.b, false);
              i = 8;
              continue;
            }
            i = 2;
          }
        }
        catch (JSONException paramk)
        {
          i = 2;
        }
        i = 0;
        break;
      } while (!bool);
      localObject1 = "com.baidu.android.pushservice.action.FB_MESSAGE";
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/message/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */