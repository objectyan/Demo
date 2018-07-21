package com.baidu.platform.comapi.f;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.baidu.mapframework.nirvana.concurrent.ConcurrentManager;
import com.baidu.mapframework.nirvana.concurrent.ConcurrentTask;
import com.baidu.mapframework.nirvana.concurrent.QueueToken;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;
import com.baidu.platform.comapi.util.JsonBuilder;
import com.baidu.platform.comapi.util.MD5;
import com.baidu.platform.comapi.util.SysOSAPIv2;
import com.baidu.platform.comjni.base.versionupdate.NAVersionUpdate;

public class f
{
  private static f b = null;
  private static QueueToken c = ConcurrentManager.obtainTaskQueue(Module.VERSION_UPDATE_MODULE);
  private NAVersionUpdate a = null;
  
  public static f a()
  {
    try
    {
      if (b == null) {
        b = new f();
      }
      b.b();
      f localf = b;
      return localf;
    }
    finally {}
  }
  
  public static void c()
  {
    f.1 local1 = new f.1();
    local1.setQueueToken(c);
    ConcurrentManager.executeTask(Module.VERSION_UPDATE_MODULE, local1, ScheduleConfig.forData());
  }
  
  public String a(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 64);
      if (paramContext == null) {
        return "-1";
      }
      paramContext = MD5.getMD5String(paramContext.signatures[0].toCharsString().getBytes());
      if ((TextUtils.isEmpty(paramContext)) || (paramContext.length() < 32)) {
        return "-1";
      }
    }
    catch (Exception paramContext)
    {
      com.baidu.platform.comapi.util.f.b(paramContext.getMessage());
      return "-1";
    }
    paramContext = paramContext.substring(8, 24);
    long l2 = 0L;
    long l1 = 0L;
    int i = 0;
    while (i < 8)
    {
      l1 = l1 * 16L + Integer.parseInt(paramContext.substring(i, i + 1), 16);
      i += 1;
    }
    i = 8;
    while (i < paramContext.length())
    {
      l2 = l2 * 16L + Integer.parseInt(paramContext.substring(i, i + 1), 16);
      i += 1;
    }
    return String.valueOf(l2 + l1 & 0xFFFFFFFF);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2)
  {
    if (this.a == null) {
      return;
    }
    paramContext = SysOSAPIv2.getInstance();
    paramString1 = paramContext.getVersionName();
    String str1 = paramContext.getChannel();
    String str2 = paramContext.getPhoneType();
    String str3 = paramContext.getOSVersion();
    int i = paramContext.getScreenWidth();
    int j = paramContext.getScreenHeight();
    int k = paramContext.getDensityDpi();
    int m = paramContext.getDensityDpi();
    JsonBuilder localJsonBuilder = new JsonBuilder();
    localJsonBuilder.object();
    localJsonBuilder.putStringValue("sv", paramString1);
    localJsonBuilder.putStringValue("channel", str1);
    localJsonBuilder.putStringValue("mb", str2);
    localJsonBuilder.putStringValue("os", str3);
    localJsonBuilder.putStringValue("cuid", paramContext.getCuid());
    localJsonBuilder.putStringValue("resid", paramContext.getResID());
    localJsonBuilder.putStringValue("ver", "1");
    localJsonBuilder.key("screen_x").value(i);
    localJsonBuilder.key("screen_y").value(j);
    localJsonBuilder.key("dpi_x").value(k);
    localJsonBuilder.key("dpi_y").value(m);
    localJsonBuilder.putStringValue("key", "map.android." + paramContext.getOem());
    localJsonBuilder.key("gpsloc").value(paramContext.getGPSOn());
    localJsonBuilder.key("netloc").value(paramContext.getNetOn());
    localJsonBuilder.putStringValue("glr", paramContext.getGLRenderer());
    localJsonBuilder.putStringValue("glv", paramContext.getGLVersion());
    localJsonBuilder.putStringValue("cpu", paramContext.getCPUProcessor());
    localJsonBuilder.putStringValue("net", paramContext.getNetType());
    localJsonBuilder.endObject();
    paramContext = new f.2(this, paramString2, localJsonBuilder);
    paramContext.setQueueToken(c);
    ConcurrentManager.executeTask(Module.VERSION_UPDATE_MODULE, paramContext, ScheduleConfig.forData());
  }
  
  boolean b()
  {
    if (this.a == null)
    {
      this.a = new NAVersionUpdate();
      if (this.a.create() == 0)
      {
        this.a = null;
        return false;
      }
    }
    return true;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/platform/comapi/f/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */