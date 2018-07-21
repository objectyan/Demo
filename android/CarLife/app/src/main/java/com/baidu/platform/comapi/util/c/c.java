package com.baidu.platform.comapi.util.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.baidu.android.common.util.CommonParam;

public class c
  implements g
{
  private String a;
  private SharedPreferences b;
  
  public String a()
  {
    if (TextUtils.isEmpty(this.a)) {
      a(com.baidu.platform.comapi.c.f());
    }
    return this.a;
  }
  
  public void a(Context paramContext)
  {
    this.b = paramContext.getSharedPreferences("cuid", 0);
    try
    {
      if ((this.b != null) && (this.b.contains("cuid"))) {
        this.a = this.b.getString("cuid", "");
      }
      if (TextUtils.isEmpty(this.a))
      {
        this.a = CommonParam.getCUID(paramContext);
        this.b.edit().putString("cuid", this.a).commit();
      }
      return;
    }
    catch (Exception localException)
    {
      this.a = CommonParam.getCUID(paramContext);
    }
  }
  
  public void b()
  {
    this.a = CommonParam.getCUID(com.baidu.platform.comapi.c.f());
    if (this.b != null) {
      this.b.edit().putString("cuid", this.a).commit();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/util/c/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */