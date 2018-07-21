package com.baidu.android.pushservice.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.pushservice.j.p;

public class d
{
  public f a;
  public g b;
  private c c;
  
  public d(c paramc)
  {
    this.c = paramc;
  }
  
  public static d a(Context paramContext, String paramString)
  {
    b.a(paramContext).b(paramContext);
    f localf = b.a(paramContext).d(paramString);
    if ((localf != null) && (!TextUtils.isEmpty(localf.c)))
    {
      paramContext = new d(c.a);
      paramContext.a = localf;
      return paramContext;
    }
    p.b("ClientTypeInfo*BBind* isRegisteredClientByAppid not PushClient! appid=" + paramString, paramContext);
    paramContext = h.a(paramContext).e(paramString);
    if ((paramContext != null) && (paramContext.c() != null))
    {
      paramString = new d(c.b);
      paramString.b = paramContext;
      return paramString;
    }
    return new d(c.d);
  }
  
  public c a()
  {
    return this.c;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */