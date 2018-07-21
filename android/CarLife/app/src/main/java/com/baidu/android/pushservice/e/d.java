package com.baidu.android.pushservice.e;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.pushservice.a;
import com.baidu.android.pushservice.b.b;
import com.baidu.android.pushservice.b.f;
import com.baidu.android.pushservice.b.g;
import com.baidu.android.pushservice.b.h;
import com.baidu.android.pushservice.j;
import com.baidu.android.pushservice.j.p;
import org.json.JSONException;
import org.json.JSONObject;

public class d
  extends c
{
  protected boolean d = false;
  
  public d(l paraml, Context paramContext)
  {
    super(paraml, paramContext);
  }
  
  protected String b(String paramString)
  {
    do
    {
      do
      {
        for (;;)
        {
          try
          {
            localObject = new JSONObject(paramString);
            JSONObject localJSONObject = ((JSONObject)localObject).getJSONObject("response_params");
            String str2 = localJSONObject.getString("user_id");
            str1 = localJSONObject.getString("appid");
            localJSONObject.put("channel_id", j.a(this.a).a());
            this.b.g = str2;
            this.b.f = str1;
            localObject = ((JSONObject)localObject).toString();
          }
          catch (JSONException localJSONException)
          {
            Object localObject;
            String str1;
            continue;
          }
          try
          {
            if (this.b.a.equals("method_sdk_bind"))
            {
              paramString = (g)h.a(this.a).b(this.b.i);
              if (paramString != null)
              {
                paramString.a(str1);
                paramString.b(this.b.e);
                paramString = h.a(this.a).a(paramString);
                p.a(this.a, paramString, 3);
                return (String)localObject;
              }
            }
            paramString = (String)localObject;
          }
          catch (JSONException paramString)
          {
            paramString = localJSONException;
          }
        }
        if (TextUtils.isEmpty(this.b.b)) {
          break;
        }
        localObject = paramString;
      } while (this.b.b.equals("internal"));
      if (TextUtils.isEmpty(this.b.l)) {
        break;
      }
      localObject = paramString;
    } while (com.baidu.android.pushservice.c.d.g(this.a));
    localObject = new f();
    ((f)localObject).b(this.b.e);
    ((f)localObject).a(this.b.f);
    ((f)localObject).f = this.b.g;
    ((f)localObject).a(this.b.k);
    ((f)localObject).b(a.a());
    localObject = b.a(this.a).a((f)localObject, this.d);
    b.a(this.a).a("r_v2", (String)localObject);
    p.a(this.a, (String)localObject, 0);
    return paramString;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/e/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */