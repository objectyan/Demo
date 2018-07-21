package com.baidu.platform.comapi.util.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.baidu.platform.comapi.c;
import com.baidu.platform.comapi.util.a;
import com.baidu.platform.comapi.util.b;

public class j
  implements g
{
  static final String b = "macid";
  static final String c = "mac";
  SharedPreferences a;
  private String d;
  private byte[] e = { 59, 76, 55, 32, 126, 33, 51, 30, 117, 101, 124, 124, 55, 123, 52, 54 };
  
  private String a(String paramString)
  {
    try
    {
      paramString = b.a(a.a(new String(this.e), paramString.getBytes()));
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  private String c()
  {
    String str = a();
    if (!TextUtils.isEmpty(str)) {
      return str.replaceAll(":", "");
    }
    return "";
  }
  
  public String a()
  {
    if (TextUtils.isEmpty(this.d)) {
      a(c.f());
    }
    return this.d;
  }
  
  public void a(Context paramContext)
  {
    try
    {
      Object localObject = (WifiManager)paramContext.getSystemService("wifi");
      if (localObject != null)
      {
        localObject = ((WifiManager)localObject).getConnectionInfo();
        if (localObject != null) {
          this.d = ((WifiInfo)localObject).getMacAddress();
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.d = "";
      }
    }
    if (this.a == null) {
      this.a = paramContext.getSharedPreferences("mac", 0);
    }
  }
  
  public String b()
  {
    if ((TextUtils.isEmpty(this.d)) || (this.a == null)) {
      a(c.f());
    }
    String str2 = this.a.getString("macid", "");
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      str2 = a(c());
      str1 = str2;
      if (!TextUtils.isEmpty(str2))
      {
        this.a.edit().putString("macid", str2).commit();
        str1 = str2;
      }
    }
    return str1;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/util/c/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */