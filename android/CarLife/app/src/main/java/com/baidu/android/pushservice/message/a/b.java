package com.baidu.android.pushservice.message.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.android.pushservice.g.a;
import com.baidu.android.pushservice.j.p;
import com.baidu.android.pushservice.message.g;
import com.baidu.android.pushservice.message.k;
import org.json.JSONException;
import org.json.JSONObject;

public class b
  extends c
{
  private Context b;
  
  public b(Context paramContext)
  {
    super(paramContext);
    this.b = paramContext.getApplicationContext();
  }
  
  public g a(k paramk, byte[] paramArrayOfByte)
  {
    localObject2 = null;
    String str3 = paramk.h();
    localg = new g();
    try
    {
      paramk = new JSONObject(new String(paramArrayOfByte));
    }
    catch (JSONException localJSONException1)
    {
      for (;;)
      {
        String str1;
        String str4;
        label107:
        label123:
        label141:
        paramk = null;
        a.b("BaiduSupperHandler", "Supper message parsing action Fail:\r\n" + localJSONException1.getMessage(), this.b);
        String str2 = null;
        int i = 0;
        continue;
        try
        {
          paramk = paramk.getString("message");
          paramArrayOfByte = new Intent(str2);
          paramArrayOfByte.putExtra("message", paramk);
          paramk = paramArrayOfByte;
        }
        catch (JSONException paramk)
        {
          for (;;)
          {
            paramk = null;
          }
        }
        paramk = new Intent("com.baidu.pushservice.action.supper.MESSAGE");
        paramk.putExtra("message", paramArrayOfByte);
        p.b(">>> Deliver baidu supper msg with g action: com.baidu.pushservice.action.supper.MESSAGE", this.a);
      }
      localg.a(2);
      return localg;
    }
    for (;;)
    {
      try
      {
        str1 = paramk.getString("action");
        i = 1;
        if ((i == 0) || (TextUtils.isEmpty(str1))) {
          break label287;
        }
        if (!str1.equalsIgnoreCase("push.NOTIFICATION")) {
          break label251;
        }
      }
      catch (JSONException localJSONException2)
      {
        break label173;
        paramk = null;
        break label123;
        Object localObject1 = null;
        break label107;
        paramArrayOfByte = null;
        break;
      }
      try
      {
        str4 = paramk.getString("description");
        if (paramk.isNull("title")) {
          continue;
        }
        paramArrayOfByte = paramk.getString("title");
        if (paramk.isNull("iconUrl")) {
          continue;
        }
        str1 = paramk.getString("iconUrl");
        if (paramk.isNull("url")) {
          continue;
        }
        paramk = paramk.getString("url");
        f.a(this.a, paramArrayOfByte, str4, str1, paramk, str3);
        paramk = (k)localObject2;
      }
      catch (JSONException paramk)
      {
        a.b("BaiduSupperHandler", "Supper message parsing notification action Fail:\r\n" + paramk.getMessage(), this.b);
        paramk = (k)localObject2;
        break label141;
      }
    }
    if (paramk != null)
    {
      paramk.setFlags(32);
      this.a.sendBroadcast(paramk);
      localg.a(0);
      return localg;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/message/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */