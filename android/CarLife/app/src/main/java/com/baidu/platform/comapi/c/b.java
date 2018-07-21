package com.baidu.platform.comapi.c;

import com.baidu.mapframework.nirvana.concurrent.ConcurrentManager;
import com.baidu.mapframework.nirvana.concurrent.ConcurrentTask;
import com.baidu.mapframework.nirvana.concurrent.QueueToken;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;
import com.baidu.platform.comapi.c;
import com.baidu.platform.comapi.util.JsonBuilder;
import com.baidu.platform.comapi.util.NetworkUtil;
import com.baidu.platform.comapi.util.SysOSAPIv2;
import com.baidu.platform.comapi.util.f;
import com.baidu.platform.comjni.base.networkdetect.NANetworkDetect;
import com.baidu.platform.comjni.engine.NAEngine;

public class b
{
  private static final String a = "triggerType";
  private static final String b = "foreground";
  private static final String c = "netchanged";
  private static final String d = "nettype";
  private static final String e = "telecomtype";
  private static QueueToken f = ConcurrentManager.obtainTaskQueue(Module.NETWORK_DETECT);
  private NANetworkDetect g;
  
  public static b a()
  {
    return a.a();
  }
  
  private static void a(ConcurrentTask paramConcurrentTask)
  {
    try
    {
      paramConcurrentTask.setQueueToken(f);
      ConcurrentManager.executeTask(Module.NETWORK_DETECT, paramConcurrentTask, ScheduleConfig.forData());
      return;
    }
    finally
    {
      paramConcurrentTask = finally;
      throw paramConcurrentTask;
    }
  }
  
  private void b(String paramString)
  {
    f.b("NetworkLogic", "NetworkDetect");
    if (this.g == null)
    {
      this.g = new NANetworkDetect();
      this.g.create();
    }
    String str = NetworkUtil.getCurrentNetMode(c.f());
    NetworkUtil.updateNetworkProxy(c.f());
    SysOSAPIv2.getInstance().updateNetType(str);
    if (this.g != null) {
      try
      {
        JsonBuilder localJsonBuilder = new JsonBuilder();
        localJsonBuilder.object();
        try
        {
          localJsonBuilder.key("nettype").value(Integer.parseInt(str));
          localJsonBuilder.key("telecomtype").value(NetworkUtil.getNetworkOperatorType(c.f()));
          localJsonBuilder.key("triggerType").value(paramString);
          localJsonBuilder.endObject();
          this.g.networkDetect(localJsonBuilder.toString());
          return;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          for (;;)
          {
            localJsonBuilder.key("nettype").value(-1);
          }
        }
        return;
      }
      catch (Exception paramString) {}
    }
  }
  
  public void a(String paramString)
  {
    f.b("NetworkLogic", "onNetWorkChanged-" + paramString);
    if ((paramString != null) && (!paramString.equals(SysOSAPIv2.getInstance().getNetType()))) {
      a(new ConcurrentTask()
      {
        public void run()
        {
          b.a(b.this, "netchanged");
        }
      });
    }
  }
  
  public void b()
  {
    f.b("NetworkLogic", "onStartup");
    NAEngine.startSocketProc();
  }
  
  public void c()
  {
    f.b("NetworkLogic", "onForeground");
    a(new ConcurrentTask()
    {
      public void run()
      {
        b.a(b.this, "foreground");
      }
    });
    NAEngine.restartLongLink();
  }
  
  public void d()
  {
    f.b("NetworkLogic", "onBackground,stopLongLink");
    NAEngine.stopLongLink();
  }
  
  public void e()
  {
    f.b("NetworkLogic", "onExit");
    if (this.g != null) {
      this.g = null;
    }
  }
  
  private static final class a
  {
    private static final b a = new b(null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */