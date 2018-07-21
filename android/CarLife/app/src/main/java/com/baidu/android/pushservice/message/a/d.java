package com.baidu.android.pushservice.message.a;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.baidu.android.pushservice.PushSettings;
import com.baidu.android.pushservice.j.l;
import com.baidu.android.pushservice.j.m;
import com.baidu.android.pushservice.j.o;
import com.baidu.android.pushservice.j.p;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import com.baidu.android.pushservice.k.e;
import com.baidu.android.pushservice.message.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class d
  extends c
{
  public d(Context paramContext)
  {
    super(paramContext);
  }
  
  public static void a(final Context paramContext)
  {
    long l1 = m.c(paramContext, "com.baidu.pushservice.internal.bind.LATEST_TIME");
    final long l2 = System.currentTimeMillis();
    if ((com.baidu.android.pushservice.j.k.a(paramContext)) && (l2 - l1 > 259200000L)) {
      com.baidu.android.pushservice.i.d.a().a(new com.baidu.android.pushservice.i.c("uploadInternalBindApps", (short)95)
      {
        public void a()
        {
          try
          {
            m.a(paramContext, "com.baidu.pushservice.internal.bind.LATEST_TIME", l2);
            String str = d.b(paramContext);
            HashMap localHashMap = new HashMap();
            com.baidu.android.pushservice.e.b.a(localHashMap);
            localHashMap.put("device_type", "3");
            localHashMap.put("params", str);
            int i = 0;
            int j;
            do
            {
              j = i + 1;
              i = com.baidu.android.pushservice.f.b.a("https://api.tuisong.baidu.com/rest/3.0/oem/upload_unbind_oem", "POST", localHashMap, "BCCS_SDK/3.0").b();
              if (i == 200) {
                return;
              }
              i = j;
            } while (j < 2);
            return;
          }
          catch (Exception localException) {}
        }
      });
    }
  }
  
  private void a(String paramString1, String paramString2, Context paramContext)
  {
    Intent localIntent = new Intent("com.baidu.android.pushservice.action.METHOD");
    localIntent.addFlags(32);
    localIntent.putExtra("method_version", "V2");
    localIntent.putExtra("secret_key", paramString1);
    localIntent.putExtra("pkg_name", paramString2);
    localIntent.putExtra("is_baidu_internal_bind", "true");
    localIntent.putExtra("method", "method_bind");
    localIntent.putExtra("bind_status", 0);
    localIntent.putExtra("push_sdk_version", com.baidu.android.pushservice.a.a());
    if (Build.VERSION.SDK_INT >= 19)
    {
      int i = l.a(paramContext);
      localIntent.putExtra("bind_notify_status", i + "");
    }
    o.a(paramContext, localIntent);
  }
  
  private static String c(Context paramContext)
  {
    Object localObject = p.q(paramContext);
    if (!((ArrayList)localObject).isEmpty())
    {
      JSONArray localJSONArray = new JSONArray();
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str1 = (String)((Iterator)localObject).next();
        if (!p.x(paramContext, str1))
        {
          Context localContext = p.v(paramContext, str1);
          String str2 = p.w(localContext, str1);
          String str3 = p.a(localContext, str1, "bp_reg_key");
          if (!TextUtils.isEmpty(str3)) {
            try
            {
              JSONObject localJSONObject = new JSONObject();
              localJSONObject.put("packagename", str1);
              localJSONObject.put("apikey", str3);
              localJSONObject.put("installtime", str2);
              localJSONObject.put("pkgMD5info", p.r(localContext, str1));
              localJSONArray.put(localJSONObject);
            }
            catch (Exception localException) {}
          }
        }
      }
      if (localJSONArray.length() > 0) {
        return localJSONArray.toString();
      }
    }
    return null;
  }
  
  private static String d(Context paramContext)
    throws Exception
  {
    String str1 = c(paramContext);
    if (TextUtils.isEmpty(str1)) {
      throw new Exception("NO INTERNAL BIND APP INFOS！");
    }
    JSONObject localJSONObject = new JSONObject();
    String str2 = PushSettings.a(paramContext);
    paramContext = e.a(paramContext);
    localJSONObject.put("channel_id", str2);
    localJSONObject.put("cuid", paramContext);
    localJSONObject.put("aksinfo", str1);
    return com.baidu.android.pushservice.k.b.a(BaiduAppSSOJni.encryptR(localJSONObject.toString().getBytes(), 2), "utf-8");
  }
  
  public g a(com.baidu.android.pushservice.message.k paramk, byte[] paramArrayOfByte)
  {
    int k = 0;
    int i = 0;
    paramk.h();
    paramk.i();
    for (;;)
    {
      try
      {
        paramk = new JSONObject(new String(paramArrayOfByte));
        j = k;
        if (!paramk.isNull("custom_content"))
        {
          paramk = paramk.getString("custom_content");
          j = k;
          if (!TextUtils.isEmpty(paramk))
          {
            paramk = new JSONArray(paramk);
            int m = paramk.length();
            j = k;
            if (m > 0)
            {
              paramArrayOfByte = p.q(this.a);
              k = 0;
              j = i;
              if (k < m)
              {
                Object localObject = (JSONObject)paramk.get(k);
                String str = ((JSONObject)localObject).getString("package_name");
                if (!paramArrayOfByte.contains(str))
                {
                  i = 8;
                }
                else
                {
                  localObject = ((JSONObject)localObject).getString("apikey");
                  if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject)) && (!p.x(this.a, str))) {
                    a((String)localObject, str, this.a);
                  }
                }
              }
            }
          }
        }
      }
      catch (Exception paramk)
      {
        int j = 2;
        paramk = new g();
        paramk.a(j);
        return paramk;
      }
      k += 1;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/message/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */