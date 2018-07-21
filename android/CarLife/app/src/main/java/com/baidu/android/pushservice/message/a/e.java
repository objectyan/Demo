package com.baidu.android.pushservice.message.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.baidu.android.pushservice.b.d;
import com.baidu.android.pushservice.b.h;
import com.baidu.android.pushservice.j.p;
import com.baidu.android.pushservice.message.PublicMsg;
import com.baidu.android.pushservice.message.k;

public class e
  extends c
{
  public e(Context paramContext)
  {
    super(paramContext);
  }
  
  public static PublicMsg a(Context paramContext, String paramString1, String paramString2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (!p.a(paramContext, paramArrayOfByte1, paramString1, paramString2, paramArrayOfByte2)) {
      paramString1 = null;
    }
    do
    {
      return paramString1;
      paramString2 = j.a(paramContext, paramString2, paramString1, paramArrayOfByte2);
      paramString2.mPkgName = paramContext.getPackageName();
      paramString1 = paramString2;
    } while (!TextUtils.isEmpty(paramString2.mTitle));
    paramString2.mTitle = paramContext.getPackageManager().getApplicationLabel(paramContext.getApplicationInfo()).toString();
    return paramString2;
  }
  
  public com.baidu.android.pushservice.message.g a(k paramk, byte[] paramArrayOfByte)
  {
    String str1 = paramk.e();
    String str2 = paramk.h();
    int i = paramk.i();
    byte[] arrayOfByte = paramk.j();
    Object localObject = paramk.f();
    PublicMsg localPublicMsg = j.a(this.a, str2, str1, paramArrayOfByte);
    if ((localPublicMsg != null) && (!TextUtils.isEmpty(localPublicMsg.mDescription)))
    {
      paramk = d.a(this.a, str1);
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (p.c(this.a, (String)localObject)))
      {
        localPublicMsg.mPkgName = ((String)localObject);
        p.a(this.a, localPublicMsg);
        switch (1.a[paramk.a().ordinal()])
        {
        default: 
          if (Build.VERSION.SDK_INT < 24) {
            f.a(this.a, str1);
          }
          p.b("MultiPrivateNotificationHandler*BBind*>>> Don't Show pMsg private Notification! package name is null", this.a);
          i = 7;
        }
      }
    }
    for (;;)
    {
      paramk = new com.baidu.android.pushservice.message.g();
      paramk.a(i);
      return paramk;
      if (paramk.a() == com.baidu.android.pushservice.b.c.a)
      {
        localPublicMsg.mPkgName = paramk.a.c();
        break;
      }
      if (paramk.a() != com.baidu.android.pushservice.b.c.b) {
        break;
      }
      localPublicMsg.mPkgName = paramk.b.c();
      break;
      arrayOfByte = p.a(this.a, str2, paramArrayOfByte, arrayOfByte, localPublicMsg.mPkgName);
      localObject = this.a.getPackageManager();
      try
      {
        ApplicationInfo localApplicationInfo = ((PackageManager)localObject).getApplicationInfo(localPublicMsg.mPkgName, 128);
        if (TextUtils.isEmpty(localPublicMsg.mTitle)) {
          localPublicMsg.mTitle = ((PackageManager)localObject).getApplicationLabel(localApplicationInfo).toString();
        }
        if (!str1.equals("8965186")) {
          f.a(this.a, localPublicMsg, str2, str1, i, arrayOfByte, paramArrayOfByte);
        }
        i = 1;
        p.b(">>> Show pMsg private Notification!", this.a);
      }
      catch (PackageManager.NameNotFoundException paramArrayOfByte)
      {
        if (paramk.a() != com.baidu.android.pushservice.b.c.a) {
          break label372;
        }
      }
      f.a(this.a, str1);
      for (;;)
      {
        i = 8;
        break;
        label372:
        if (paramk.a() == com.baidu.android.pushservice.b.c.b) {
          h.a(this.a).a(paramk.b, false);
        }
      }
      p.b("MultiPrivateNotificationHandler*BBind*>>> pMsg JSON parsing error!", this.a);
      i = 2;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/message/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */