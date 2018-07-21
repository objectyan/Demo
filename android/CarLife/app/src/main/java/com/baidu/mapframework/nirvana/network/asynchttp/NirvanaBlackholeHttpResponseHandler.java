package com.baidu.mapframework.nirvana.network.asynchttp;

import com.baidu.mapframework.commonlib.asynchttp.BlackholeHttpResponseHandler;
import com.baidu.mapframework.commonlib.asynchttp.NirvanaResponseHandlerInterface;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;

public class NirvanaBlackholeHttpResponseHandler
  extends BlackholeHttpResponseHandler
  implements NirvanaResponseHandlerInterface
{
  public NirvanaBlackholeHttpResponseHandler(Module paramModule, ScheduleConfig paramScheduleConfig)
  {
    this.module = paramModule;
    this.scheduleConfig = paramScheduleConfig;
  }
  
  public Module getNirvanaModule()
  {
    return this.module;
  }
  
  public ScheduleConfig getNirvanaScheduleConfig()
  {
    return this.scheduleConfig;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/nirvana/network/asynchttp/NirvanaBlackholeHttpResponseHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */