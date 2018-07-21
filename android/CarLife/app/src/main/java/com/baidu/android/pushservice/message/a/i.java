package com.baidu.android.pushservice.message.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.pushservice.j.p;
import com.baidu.android.pushservice.message.PublicMsg;
import com.baidu.android.pushservice.message.g;
import com.baidu.android.pushservice.message.k;

public class i
  extends c
{
  public i(Context paramContext)
  {
    super(paramContext);
  }
  
  public g a(k paramk, byte[] paramArrayOfByte)
  {
    String str = paramk.e();
    paramk = paramk.h();
    paramArrayOfByte = j.a(this.a, paramk, str, paramArrayOfByte);
    int i;
    if ((paramArrayOfByte != null) && (!TextUtils.isEmpty(paramArrayOfByte.mTitle)) && (!TextUtils.isEmpty(paramArrayOfByte.mDescription)) && (!TextUtils.isEmpty(paramArrayOfByte.mUrl))) {
      if ((f.a(this.a, paramArrayOfByte)) && (p.e(this.a, this.a.getPackageName())))
      {
        p.b(">>> Show pMsg Notification!", this.a);
        f.a(this.a, paramArrayOfByte, paramk);
        i = 1;
      }
    }
    for (;;)
    {
      paramk = new g();
      paramk.a(i);
      return paramk;
      p.b(">>> Don't Show pMsg Notification! --- IsBaiduApp = " + p.e(this.a, this.a.getPackageName()), this.a);
      i = 0;
      continue;
      p.b(">>> pMsg JSON parsing error!", this.a);
      i = 2;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/message/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */