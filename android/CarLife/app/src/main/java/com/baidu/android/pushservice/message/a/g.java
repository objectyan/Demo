package com.baidu.android.pushservice.message.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.baidu.android.pushservice.a;
import com.baidu.android.pushservice.b.d;
import com.baidu.android.pushservice.b.h;
import com.baidu.android.pushservice.j.p;
import com.baidu.android.pushservice.message.k;

public class g
  extends c
{
  public g(Context paramContext)
  {
    super(paramContext);
  }
  
  public com.baidu.android.pushservice.message.g a(k paramk, byte[] paramArrayOfByte)
  {
    Object localObject1 = paramk.e();
    String str1 = paramk.h();
    int i = paramk.i();
    Object localObject2 = paramk.j();
    paramk = paramk.f();
    String str2 = new String(paramArrayOfByte);
    d locald = d.a(this.a, (String)localObject1);
    if ((!TextUtils.isEmpty(paramk)) && (p.c(this.a, paramk))) {}
    for (;;)
    {
      switch (1.a[locald.a().ordinal()])
      {
      default: 
        if (Build.VERSION.SDK_INT < 24) {
          f.a(this.a, (String)localObject1);
        }
        p.b(">>> Don't found app  in OldPrivateMessage " + str2, this.a);
        i = 7;
      }
      for (;;)
      {
        paramk = new com.baidu.android.pushservice.message.g();
        paramk.a(i);
        return paramk;
        if (locald.a() == com.baidu.android.pushservice.b.c.a)
        {
          paramk = locald.a.c();
          break;
        }
        if (locald.a() != com.baidu.android.pushservice.b.c.b) {
          break label629;
        }
        paramk = locald.b.c();
        break;
        localObject2 = p.a(this.a, str1, paramArrayOfByte, (byte[])localObject2, paramk);
        Object localObject3 = this.a.getPackageManager();
        try
        {
          ((PackageManager)localObject3).getPackageInfo(paramk, 128);
          localObject3 = new Intent();
          if (a.b() > 0)
          {
            ((Intent)localObject3).putExtra("bd.message.rate.GET", System.currentTimeMillis());
            ((Intent)localObject3).putExtra("bd.message.rate.MH", true);
          }
          ((Intent)localObject3).putExtra("app_id", (String)localObject1);
          ((Intent)localObject3).putExtra("msg_id", str1);
          ((Intent)localObject3).putExtra("message", paramArrayOfByte);
          ((Intent)localObject3).putExtra("message_string", str2);
          ((Intent)localObject3).putExtra("message_id", str1);
          ((Intent)localObject3).putExtra("baidu_message_type", i);
          ((Intent)localObject3).putExtra("baidu_message_body", paramArrayOfByte);
          ((Intent)localObject3).putExtra("baidu_message_secur_info", (byte[])localObject2);
          if (a.b() > 0) {
            ((Intent)localObject3).putExtra("bd.message.rate.REDIRECTION", System.currentTimeMillis());
          }
          i = p.a(this.a, (Intent)localObject3, "com.baidu.android.pushservice.action.MESSAGE", paramk);
          p.b(">>> Deliver message to client: " + locald.a.c() + " result: " + i, this.a);
        }
        catch (PackageManager.NameNotFoundException paramk)
        {
          paramk = ">>> NOT deliver to app: " + locald.a.c() + ", package has been uninstalled.";
          f.a(this.a, (String)localObject1);
          p.b(paramk, this.a);
          i = 7;
        }
        continue;
        try
        {
          localObject1 = p.a(this.a, str1, paramArrayOfByte, (byte[])localObject2, paramk);
          this.a.getPackageManager().getPackageInfo(paramk, 128);
          localObject2 = new Intent();
          ((Intent)localObject2).setPackage(paramk);
          ((Intent)localObject2).putExtra("message", paramArrayOfByte);
          ((Intent)localObject2).putExtra("message_string", str2);
          ((Intent)localObject2).putExtra("baidu_message_type", i);
          ((Intent)localObject2).putExtra("baidu_message_body", paramArrayOfByte);
          ((Intent)localObject2).putExtra("baidu_message_secur_info", (byte[])localObject1);
          ((Intent)localObject2).putExtra("message_id", str1);
          p.b(this.a, (Intent)localObject2, "com.baidu.android.pushservice.action.SDK_MESSAGE", paramk);
          i = 0;
        }
        catch (PackageManager.NameNotFoundException paramk)
        {
          h.a(this.a).a(locald.b, false);
          i = 8;
        }
      }
      label629:
      paramk = null;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/message/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */