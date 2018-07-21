package com.baidu.android.pushservice.message.a;

import android.content.Context;
import com.baidu.android.pushservice.j.p;

public class k
{
  private Context a;
  
  public k(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public c a(l paraml)
  {
    switch (1.a[paraml.ordinal()])
    {
    default: 
      p.b(">>> Unknown msg_type : " + paraml, this.a);
      return null;
    case 1: 
    case 2: 
      return new g(this.a);
    case 3: 
      return new h(this.a);
    case 4: 
    case 5: 
      return new i(this.a);
    case 6: 
      return new e(this.a);
    case 7: 
      return new m(this.a);
    case 8: 
      return new b(this.a);
    case 9: 
      return new d(this.a);
    case 10: 
    case 11: 
    case 12: 
      return new a(this.a);
    }
    return new n(this.a);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/message/a/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */