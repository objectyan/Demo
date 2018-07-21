package com.baidu.mobstat;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.os.Build.VERSION;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import org.json.JSONArray;
import org.json.JSONObject;

class bl
  implements Thread.UncaughtExceptionHandler
{
  private static final bl a = new bl();
  private Thread.UncaughtExceptionHandler b = null;
  private Context c = null;
  private bu d = new bu();
  
  public static bl a()
  {
    return a;
  }
  
  private JSONObject b()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("app_session", 0);
      try
      {
        localJSONObject.put("failed_cnt", 0);
        return localJSONObject;
      }
      catch (Exception localException1)
      {
        return localJSONObject;
      }
    }
    catch (Exception localException2)
    {
      for (;;) {}
    }
  }
  
  @SuppressLint({"NewApi"})
  private JSONObject c()
  {
    Object localObject = (ActivityManager)this.c.getSystemService("activity");
    if (localObject == null) {
      return null;
    }
    ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
    ((ActivityManager)localObject).getMemoryInfo(localMemoryInfo);
    localObject = new JSONObject();
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT >= 16) {
          ((JSONObject)localObject).put("total", localMemoryInfo.totalMem);
        }
        ((JSONObject)localObject).put("free", localMemoryInfo.availMem);
        if (localMemoryInfo.lowMemory)
        {
          i = 1;
          ((JSONObject)localObject).put("low", i);
          return (JSONObject)localObject;
        }
      }
      catch (Exception localException)
      {
        return (JSONObject)localObject;
      }
      int i = 0;
    }
  }
  
  public void a(long paramLong, String paramString1, String paramString2, int paramInt)
  {
    ch.a().b(this.c, System.currentTimeMillis());
    if ((this.c == null) || (paramString1 == null) || (paramString1.trim().equals(""))) {
      return;
    }
    try
    {
      String str = CooperService.a().getAppVersionName(this.c);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("t", paramLong);
      localJSONObject.put("c", paramString1);
      localJSONObject.put("y", paramString2);
      localJSONObject.put("v", str);
      localJSONObject.put("ct", paramInt);
      localJSONObject.put("mem", c());
      paramString1 = new JSONArray();
      paramString1.put(localJSONObject);
      localJSONObject = new JSONObject();
      this.d.a(this.c, localJSONObject);
      localJSONObject.put("ss", 0);
      localJSONObject.put("sq", 0);
      paramString2 = new JSONObject();
      paramString2.put("he", localJSONObject);
      paramString2.put("pr", new JSONArray());
      paramString2.put("ev", new JSONArray());
      paramString2.put("ex", paramString1);
      paramString2.put("trace", b());
      paramString1 = "__send_data_" + System.currentTimeMillis();
      cu.a(this.c, paramString1, paramString2.toString(), false);
      db.a("Dump exception successlly");
      return;
    }
    catch (Exception paramString1)
    {
      db.b(paramString1);
    }
  }
  
  public void a(Context paramContext)
  {
    if (this.b == null)
    {
      this.b = Thread.getDefaultUncaughtExceptionHandler();
      Thread.setDefaultUncaughtExceptionHandler(this);
    }
    if (this.c == null) {
      this.c = paramContext.getApplicationContext();
    }
    this.d.a(this.c);
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    String str2 = paramThrowable.toString();
    Object localObject2 = "";
    Object localObject1 = localObject2;
    if (str2 != null)
    {
      localObject1 = localObject2;
      if (str2.equals("")) {}
    }
    for (;;)
    {
      try
      {
        localObject1 = str2.split(":");
        if (str2.length() <= 1) {
          continue;
        }
        localObject1 = localObject1[0];
      }
      catch (Exception localException)
      {
        db.c(localException);
        String str1 = "";
        continue;
      }
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (!((String)localObject1).equals("")) {}
      }
      else
      {
        localObject2 = str2;
      }
      localObject1 = new StringWriter();
      paramThrowable.printStackTrace(new PrintWriter((Writer)localObject1));
      localObject1 = localObject1.toString();
      db.a((String)localObject1);
      a(System.currentTimeMillis(), (String)localObject1, (String)localObject2, 0);
      if (!this.b.equals(this)) {
        this.b.uncaughtException(paramThread, paramThrowable);
      }
      return;
      localObject1 = str2;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mobstat/bl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */