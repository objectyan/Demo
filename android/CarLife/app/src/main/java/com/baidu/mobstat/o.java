package com.baidu.mobstat;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class o
{
  static o a = new o();
  
  private void a(Context paramContext, ArrayList<p> paramArrayList)
  {
    paramContext = new StringBuilder();
    paramContext.append(System.currentTimeMillis());
    JSONArray localJSONArray;
    try
    {
      localJSONArray = new JSONArray();
      paramArrayList = paramArrayList.iterator();
      for (;;)
      {
        if (paramArrayList.hasNext())
        {
          JSONObject localJSONObject = ((p)paramArrayList.next()).a();
          if (localJSONObject != null)
          {
            localJSONArray.put(localJSONObject);
            continue;
            if (TextUtils.isEmpty(paramContext)) {
              break;
            }
          }
        }
      }
    }
    catch (Exception paramContext)
    {
      bd.b(paramContext);
      paramContext = "";
    }
    for (;;)
    {
      y.e.a(System.currentTimeMillis(), paramContext);
      return;
      paramArrayList = new JSONObject();
      paramArrayList.put("app_apk", localJSONArray);
      paramArrayList.put("meta-data", paramContext.toString());
      paramContext = cs.a(paramArrayList.toString().getBytes());
    }
  }
  
  private void b(Context paramContext)
  {
    a(paramContext, c(paramContext));
  }
  
  private ArrayList<p> c(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = d(paramContext).iterator();
    Object localObject;
    String str1;
    String str2;
    while (localIterator.hasNext())
    {
      paramContext = (PackageInfo)localIterator.next();
      localObject = paramContext.applicationInfo;
      if (localObject != null)
      {
        str1 = paramContext.packageName;
        str2 = paramContext.versionName;
        paramContext = paramContext.signatures;
        if ((paramContext == null) || (paramContext.length == 0)) {
          break label147;
        }
      }
    }
    label147:
    for (paramContext = paramContext[0].toChars().toString();; paramContext = "")
    {
      String str3 = cz.a(paramContext.getBytes());
      paramContext = "";
      localObject = ((ApplicationInfo)localObject).sourceDir;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        paramContext = cz.a(new File((String)localObject));
      }
      localArrayList.add(new p(str1, str2, str3, paramContext));
      break;
      return localArrayList;
    }
  }
  
  private ArrayList<PackageInfo> d(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = paramContext.getPackageManager();
    if (localObject == null) {
      return localArrayList;
    }
    paramContext = new ArrayList(1);
    try
    {
      localObject = ((PackageManager)localObject).getInstalledPackages(64);
      paramContext = (Context)localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        bd.b(localException);
      }
    }
    paramContext = paramContext.iterator();
    while (paramContext.hasNext())
    {
      localObject = (PackageInfo)paramContext.next();
      ApplicationInfo localApplicationInfo = ((PackageInfo)localObject).applicationInfo;
      if ((localApplicationInfo != null) && ((localApplicationInfo.flags & 0x1) == 0)) {
        localArrayList.add(localObject);
      }
    }
    return localArrayList;
  }
  
  public void a(Context paramContext)
  {
    try
    {
      b(paramContext);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mobstat/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */