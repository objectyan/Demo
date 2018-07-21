package com.baidu.android.pushservice.message.a;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import com.baidu.android.pushservice.b.b;
import com.baidu.android.pushservice.j.p;
import com.baidu.android.pushservice.message.PublicMsg;
import com.baidu.android.pushservice.message.g;
import com.baidu.android.pushservice.message.k;

public class m
  extends c
{
  public m(Context paramContext)
  {
    super(paramContext);
  }
  
  public g a(k paramk, byte[] paramArrayOfByte)
  {
    String str1 = paramk.e();
    String str2 = paramk.h();
    int i = paramk.i();
    byte[] arrayOfByte = paramk.j();
    Object localObject = paramk.f();
    paramk = new g();
    PublicMsg localPublicMsg = j.a(this.a, str2, str1, paramArrayOfByte);
    if ((localPublicMsg != null) && (!TextUtils.isEmpty(localPublicMsg.mUrl))) {
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (p.c(this.a, (String)localObject)))
      {
        localPublicMsg.mPkgName = ((String)localObject);
        arrayOfByte = p.a(this.a, str2, paramArrayOfByte, arrayOfByte, localPublicMsg.mPkgName);
      }
    }
    for (;;)
    {
      try
      {
        this.a.getPackageManager().getPackageInfo(localPublicMsg.mPkgName, 128);
        f.a(this.a, str1, localPublicMsg, str2, i, arrayOfByte, paramArrayOfByte);
        i = 1;
        p.b(">>> Show rich media Notification!", this.a);
      }
      catch (PackageManager.NameNotFoundException paramArrayOfByte)
      {
        i = 8;
        paramArrayOfByte = ">>> NOT deliver to app: " + localPublicMsg.mPkgName + ", package has been uninstalled.";
        f.a(this.a, str1);
        p.b(paramArrayOfByte, this.a);
        continue;
      }
      paramk.a(i);
      return paramk;
      localObject = b.a(this.a).d(str1);
      if ((localObject != null) && (((com.baidu.android.pushservice.b.f)localObject).c() != null))
      {
        localPublicMsg.mPkgName = ((com.baidu.android.pushservice.b.f)localObject).c();
        break;
      }
      paramk.a(7);
      return paramk;
      p.b(">>> Don't Show rich media Notification! url is null", this.a);
      i = 2;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/message/a/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */