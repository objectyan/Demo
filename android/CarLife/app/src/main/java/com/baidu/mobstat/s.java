package com.baidu.mobstat;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

class s
{
  static s a = new s();
  private String b = "";
  
  private String a(Context paramContext, String paramString)
  {
    Object localObject = "";
    paramContext = paramContext.getPackageManager();
    if (paramContext == null) {}
    for (;;)
    {
      return (String)localObject;
      try
      {
        paramContext = paramContext.getPackageInfo(paramString, 0).versionName;
        localObject = paramContext;
        if (paramContext != null) {
          continue;
        }
        return "";
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        for (;;)
        {
          bd.b(paramContext);
          paramContext = (Context)localObject;
        }
      }
    }
  }
  
  private ArrayList<t> a(Context paramContext, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return c(paramContext, paramInt);
    }
    return b(paramContext, paramInt);
  }
  
  private void a(Context paramContext, ArrayList<t> paramArrayList, boolean paramBoolean)
  {
    paramContext = new StringBuilder();
    paramContext.append(System.currentTimeMillis() + "|");
    int i;
    JSONArray localJSONArray;
    if (paramBoolean)
    {
      i = 1;
      paramContext.append(i);
      try
      {
        localJSONArray = new JSONArray();
        paramArrayList = paramArrayList.iterator();
        for (;;)
        {
          if (paramArrayList.hasNext())
          {
            JSONObject localJSONObject = ((t)paramArrayList.next()).a();
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
    }
    for (;;)
    {
      y.c.a(System.currentTimeMillis(), paramContext);
      return;
      i = 0;
      break;
      paramArrayList = new JSONObject();
      paramArrayList.put("app_trace", localJSONArray);
      paramArrayList.put("meta-data", paramContext.toString());
      paramContext = cs.a(paramArrayList.toString().getBytes());
    }
  }
  
  private void a(Context paramContext, boolean paramBoolean, int paramInt)
  {
    ArrayList localArrayList = a(paramContext, paramInt);
    if ((localArrayList == null) || (localArrayList.size() == 0)) {
      return;
    }
    if (paramBoolean)
    {
      String str = ((t)localArrayList.get(0)).b();
      if (a(str, this.b)) {
        this.b = str;
      }
    }
    a(paramContext, localArrayList, paramBoolean);
  }
  
  private boolean a(int paramInt)
  {
    boolean bool = false;
    if ((paramInt == 100) || (paramInt == 200) || (paramInt == 130)) {
      bool = true;
    }
    return bool;
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    return (!TextUtils.isEmpty(paramString1)) && (!paramString1.equals(this.b));
  }
  
  private ArrayList<t> b(Context paramContext, int paramInt)
  {
    Object localObject1 = (ActivityManager)paramContext.getSystemService("activity");
    Iterator localIterator;
    LinkedHashMap localLinkedHashMap;
    try
    {
      localObject1 = ((ActivityManager)localObject1).getRunningTasks(50);
      if (localObject1 == null) {
        return new ArrayList();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        bd.b(localException);
        localIterator = null;
      }
      localLinkedHashMap = new LinkedHashMap();
      localIterator = localIterator.iterator();
    }
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localObject2 = (ActivityManager.RunningTaskInfo)localIterator.next();
        if (localLinkedHashMap.size() <= paramInt) {}
      }
      else
      {
        return new ArrayList(localLinkedHashMap.values());
      }
      Object localObject2 = ((ActivityManager.RunningTaskInfo)localObject2).topActivity;
      if (localObject2 != null)
      {
        localObject2 = ((ComponentName)localObject2).getPackageName();
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!b(paramContext, (String)localObject2)) && (!localLinkedHashMap.containsKey(localObject2))) {
          localLinkedHashMap.put(localObject2, new t((String)localObject2, a(paramContext, (String)localObject2), ""));
        }
      }
    }
  }
  
  private boolean b(Context paramContext, String paramString)
  {
    paramContext = paramContext.getPackageManager();
    if (paramContext == null) {}
    for (;;)
    {
      return false;
      try
      {
        paramContext = paramContext.getPackageInfo(paramString, 0).applicationInfo;
        if (paramContext != null)
        {
          int i = paramContext.flags;
          if ((i & 0x1) != 0) {
            return true;
          }
        }
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        bd.b(paramContext);
      }
    }
    return false;
  }
  
  private ArrayList<t> c(Context paramContext, int paramInt)
  {
    List localList = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (localList == null) {
      return new ArrayList();
    }
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    int i = 0;
    if ((i >= localList.size()) || (localLinkedHashMap.size() > paramInt)) {
      return new ArrayList(localLinkedHashMap.values());
    }
    ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localList.get(i);
    if (!a(localRunningAppProcessInfo.importance)) {}
    for (;;)
    {
      i += 1;
      break;
      Object localObject = localRunningAppProcessInfo.pkgList;
      if ((localObject != null) && (localObject.length != 0))
      {
        localObject = localRunningAppProcessInfo.pkgList[0];
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!b(paramContext, (String)localObject)) && (!localLinkedHashMap.containsKey(localObject))) {
          localLinkedHashMap.put(localObject, new t((String)localObject, a(paramContext, (String)localObject), String.valueOf(localRunningAppProcessInfo.importance)));
        }
      }
    }
  }
  
  public void a(Context paramContext, boolean paramBoolean)
  {
    int i = 1;
    if (!paramBoolean) {
      i = 20;
    }
    try
    {
      a(paramContext, paramBoolean, i);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mobstat/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */