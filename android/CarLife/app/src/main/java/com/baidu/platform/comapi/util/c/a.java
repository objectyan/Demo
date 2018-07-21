package com.baidu.platform.comapi.util.c;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.baidu.platform.comapi.c;

public class a
  implements g
{
  private String a;
  private int b;
  private byte[] c;
  
  public String a()
  {
    if (TextUtils.isEmpty(this.a)) {
      a(c.f());
    }
    return this.a;
  }
  
  public void a(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      PackageInfo localPackageInfo = localPackageManager.getPackageInfo(paramContext.getPackageName(), 0);
      this.a = localPackageInfo.versionName;
      this.b = localPackageInfo.versionCode;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        try
        {
          this.c = localPackageManager.getPackageInfo(paramContext.getPackageName(), 64).signatures[0].toByteArray();
          return;
        }
        catch (PackageManager.NameNotFoundException paramContext)
        {
          this.c = new byte[0];
        }
        localNameNotFoundException = localNameNotFoundException;
        this.a = "1.0.0";
        this.b = 1;
      }
    }
  }
  
  public int b()
  {
    if (this.b == 0) {
      a(c.f());
    }
    return this.b;
  }
  
  public byte[] c()
  {
    if (this.c == null) {
      a(c.f());
    }
    return this.c;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/util/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */