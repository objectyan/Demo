package com.baidu.mobstat;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class r
{
  static final r a = new r();
  
  private long a(String paramString)
  {
    long l2 = 0L;
    long l1 = l2;
    if (paramString != null)
    {
      paramString = new File(paramString);
      l1 = l2;
      if (paramString != null)
      {
        l1 = l2;
        if (paramString.exists()) {
          l1 = paramString.lastModified();
        }
      }
    }
    return l1;
  }
  
  private void a(boolean paramBoolean, String paramString1, String paramString2, PackageInfo paramPackageInfo, JSONArray paramJSONArray)
  {
    long l2 = 0L;
    if ((paramBoolean) && (paramPackageInfo.packageName.startsWith("com.android."))) {
      return;
    }
    try
    {
      l1 = paramPackageInfo.firstInstallTime;
      try
      {
        l3 = paramPackageInfo.lastUpdateTime;
        l2 = l3;
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          long l3;
          bd.b(localThrowable2);
        }
      }
      l3 = a(paramString2);
      paramString2 = new JSONObject();
      try
      {
        paramString2.put("n", paramPackageInfo.packageName);
        paramString2.put("a", paramString1);
        paramString2.put("v", String.valueOf(paramPackageInfo.versionName));
        paramString2.put("f", l1);
        paramString2.put("l", l2);
        paramString2.put("m", l3);
        paramJSONArray.put(paramString2);
        return;
      }
      catch (JSONException paramString1)
      {
        bd.b(paramString1);
        return;
      }
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        bd.b(localThrowable1);
        long l1 = 0L;
      }
    }
  }
  
  private void b(Context paramContext, boolean paramBoolean)
  {
    int i = 1;
    Object localObject2 = paramContext.getPackageManager();
    if (localObject2 == null) {}
    Object localObject3;
    label154:
    do
    {
      return;
      paramContext = new ArrayList(1);
      try
      {
        localObject1 = ((PackageManager)localObject2).getInstalledPackages(0);
        paramContext = (Context)localObject1;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          Object localObject1;
          bd.b(localException1);
          continue;
          boolean bool = false;
        }
      }
      localObject1 = new JSONArray();
      paramContext = paramContext.iterator();
      for (;;)
      {
        if (!paramContext.hasNext()) {
          break label154;
        }
        localObject3 = (PackageInfo)paramContext.next();
        Object localObject4 = ((PackageInfo)localObject3).applicationInfo;
        if (localObject4 != null)
        {
          if ((((ApplicationInfo)localObject4).flags & 0x1) == 0) {
            break;
          }
          bool = true;
          String str2 = ((ApplicationInfo)localObject4).loadLabel((PackageManager)localObject2).toString();
          localObject4 = ((ApplicationInfo)localObject4).sourceDir;
          if (paramBoolean == bool) {
            a(paramBoolean, str2, (String)localObject4, (PackageInfo)localObject3, (JSONArray)localObject1);
          }
        }
      }
    } while (localException1.length() == 0);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(System.currentTimeMillis() + "|");
    if (paramBoolean) {}
    for (;;)
    {
      ((StringBuilder)localObject2).append(i);
      paramContext = "";
      try
      {
        localObject3 = new JSONObject();
        ((JSONObject)localObject3).put("app_list", localException1);
        ((JSONObject)localObject3).put("meta-data", ((StringBuilder)localObject2).toString());
        String str1 = cs.a(((JSONObject)localObject3).toString().getBytes());
        paramContext = str1;
      }
      catch (Exception localException2)
      {
        long l;
        for (;;) {}
      }
      if (TextUtils.isEmpty(paramContext)) {
        break;
      }
      l = System.currentTimeMillis();
      y.b.a(l, paramContext);
      return;
      i = 0;
    }
  }
  
  public void a(Context paramContext, boolean paramBoolean)
  {
    try
    {
      b(paramContext, paramBoolean);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mobstat/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */