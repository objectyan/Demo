package com.baidu.android.pushservice.message.a;

import android.content.Context;
import com.baidu.android.pushservice.j.p;
import com.baidu.android.pushservice.message.PublicMsg;
import com.baidu.android.pushservice.message.g;

public class a
  extends c
{
  public a(Context paramContext)
  {
    super(paramContext);
  }
  
  public g a(com.baidu.android.pushservice.message.k paramk, byte[] paramArrayOfByte)
  {
    long l1 = paramk.b();
    long l3 = paramk.c();
    long l2 = paramk.d();
    Object localObject2 = l.a(paramk.i());
    String str1 = paramk.h();
    String str2 = paramk.e();
    l3 -= l1;
    l1 = l2 - l1;
    PublicMsg localPublicMsg = new PublicMsg();
    g localg = new g();
    Object localObject1;
    if ((!paramk.a()) || ((l3 <= 0L) && (l1 > 0L))) {
      if (((l)localObject2).equals(l.j))
      {
        localObject1 = l.f;
        localObject2 = new k(this.a).a((l)localObject1);
        if (localObject2 == null) {
          break label309;
        }
        paramArrayOfByte = ((c)localObject2).a(paramk, paramArrayOfByte);
        com.baidu.android.pushservice.d.a.d(this.a, paramk.h());
        if (!((l)localObject1).equals(l.f)) {
          break label198;
        }
        localPublicMsg.handleAlarmMessage(this.a, "010701", str1, str2);
        paramk = paramArrayOfByte;
      }
    }
    for (;;)
    {
      return paramk;
      localObject1 = localObject2;
      if (!((l)localObject2).equals(l.k)) {
        break;
      }
      localObject1 = l.g;
      break;
      label198:
      if (((l)localObject1).equals(l.g)) {
        localPublicMsg.handleAlarmMessage(this.a, "010702", str1, str2);
      }
      paramk = paramArrayOfByte;
      continue;
      if (l1 <= 0L)
      {
        localPublicMsg.handleAlarmMessage(this.a, "010704", str1, str2);
        com.baidu.android.pushservice.d.a.d(this.a, paramk.h());
        return localg;
      }
      paramk.b(l3 * 1000L + System.currentTimeMillis());
      paramk.c(l1 * 1000L + System.currentTimeMillis());
      p.a(this.a, paramk, paramArrayOfByte);
      localg.a(1);
      return localg;
      label309:
      paramk = localg;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/message/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */