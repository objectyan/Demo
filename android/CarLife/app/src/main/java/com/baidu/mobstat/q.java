package com.baidu.mobstat;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONObject;

class q
{
  static q a = new q();
  
  public void a(Context paramContext, String paramString1, String paramString2)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    Object localObject = "unkown";
    paramContext = (Context)localObject;
    if (!"android.intent.action.PACKAGE_REMOVED".equals(paramString1)) {}
    try
    {
      paramContext = localPackageManager.getPackageInfo(paramString2, 8192).versionName;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      try
      {
        for (;;)
        {
          localObject = new JSONObject();
          ((JSONObject)localObject).put("n", paramString2);
          ((JSONObject)localObject).put("a", paramString1);
          ((JSONObject)localObject).put("v", paramContext);
          paramContext = new JSONArray();
          paramContext.put(localObject);
          paramString1 = new StringBuilder();
          paramString1.append(System.currentTimeMillis());
          paramString2 = new JSONObject();
          paramString2.put("app_change", paramContext);
          paramString2.put("meta-data", paramString1.toString());
          paramContext = cs.a(paramString2.toString().getBytes());
          if (!TextUtils.isEmpty(paramContext))
          {
            long l = System.currentTimeMillis();
            y.d.a(l, paramContext);
          }
          return;
          paramContext = paramContext;
          bd.a(paramContext);
          paramContext = (Context)localObject;
        }
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          bd.b(paramContext.getMessage());
          paramContext = "";
        }
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mobstat/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */