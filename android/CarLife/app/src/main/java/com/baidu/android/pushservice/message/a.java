package com.baidu.android.pushservice.message;

import android.content.Context;

public class a
{
  private Context a;
  
  public a(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public c a(h paramh)
  {
    switch (1.a[paramh.ordinal()])
    {
    case 4: 
    case 5: 
    default: 
      return null;
    case 1: 
      return new b(this.a);
    case 2: 
    case 3: 
      return new l(this.a);
    }
    return new j(this.a);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/message/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */