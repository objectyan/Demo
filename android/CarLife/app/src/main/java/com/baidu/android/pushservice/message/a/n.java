package com.baidu.android.pushservice.message.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.android.pushservice.b.b;
import com.baidu.android.pushservice.b.f;
import com.baidu.android.pushservice.j.e;
import com.baidu.android.pushservice.j.p;
import com.baidu.android.pushservice.message.g;
import com.baidu.android.pushservice.message.k;
import org.json.JSONException;
import org.json.JSONObject;

public class n
  extends c
{
  public n(Context paramContext)
  {
    super(paramContext);
  }
  
  private g a(String paramString1, long paramLong, String paramString2, byte[] paramArrayOfByte, String paramString3)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("com.baidu.android.pushservice.action.CROSS_REQUEST");
    localIntent.putExtra("message_id", paramString2);
    localIntent.putExtra("baidu_message_body", paramString3);
    localIntent.putExtra("baidu_message_secur_info", paramArrayOfByte);
    localIntent.setFlags(32);
    localIntent.setPackage(paramString1);
    localIntent.setClassName(paramString1, "com.baidu.android.pushservice.PushService");
    localIntent.putExtra("bd.cross.request.COMMAND_TYPE", "bd.cross.command.ULTRON_DELIVER");
    localIntent.putExtra("bd.cross.request.SOURCE_SERVICE", "com.baidu.android.pushservice.PushService");
    localIntent.putExtra("bd.cross.request.SOURCE_PACKAGE", this.a.getPackageName());
    return new e(this.a, localIntent).b();
  }
  
  public g a(k paramk, byte[] paramArrayOfByte)
  {
    Object localObject = paramk.e();
    String str1 = paramk.h();
    byte[] arrayOfByte = paramk.j();
    paramk = paramk.f();
    g localg = new g();
    paramArrayOfByte = new String(paramArrayOfByte);
    for (;;)
    {
      int k;
      boolean bool;
      try
      {
        paramArrayOfByte = new JSONObject(paramArrayOfByte);
        int j = paramArrayOfByte.optInt("version_require", -1);
        k = paramArrayOfByte.optInt("command_type");
        String str2 = paramArrayOfByte.optString("command_body");
        if ((TextUtils.isEmpty((CharSequence)localObject)) || (((String)localObject).equals("0"))) {
          break label334;
        }
        if ((TextUtils.isEmpty(paramk)) || (!p.c(this.a, paramk))) {
          break label329;
        }
        f localf = b.a(this.a).d((String)localObject);
        if ((localf == null) || (localf.c() == null)) {
          break label283;
        }
        if (p.c(this.a, localf.c()))
        {
          paramArrayOfByte = paramk;
          if (TextUtils.isEmpty(paramk)) {
            paramArrayOfByte = localf.c();
          }
          localObject = paramArrayOfByte;
          if (k != 1) {
            break label321;
          }
          localObject = paramArrayOfByte;
          if (localf.d() >= j) {
            break label321;
          }
          i = 6;
          paramk = paramArrayOfByte;
          if ((paramk != null) || (i != 0)) {
            break label318;
          }
          if (k != 2) {
            break label298;
          }
          bool = true;
          paramArrayOfByte = b.a(this.a).a(j, bool);
          if (paramArrayOfByte != null) {
            break label304;
          }
          i = 6;
          if (i != 0) {
            break label312;
          }
          paramk = a(paramk, 0L, str1, arrayOfByte, str2);
          paramk.a(i);
          return paramk;
        }
      }
      catch (JSONException paramk)
      {
        localg.a(2);
        return localg;
      }
      localObject = paramk;
      if (k == 1)
      {
        i = 8;
        continue;
        label283:
        localObject = paramk;
        if (k == 1)
        {
          i = 7;
          continue;
          label298:
          bool = false;
          continue;
          label304:
          paramk = paramArrayOfByte.c();
          continue;
          label312:
          paramk = localg;
          continue;
          label318:
          continue;
        }
      }
      label321:
      int i = 0;
      paramk = (k)localObject;
      continue;
      label329:
      paramk = null;
      continue;
      label334:
      paramk = null;
      i = 0;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/message/a/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */