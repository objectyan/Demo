package com.baidu.mapframework.nirvana.network.asynchttp;

import com.baidu.mapframework.commonlib.asynchttp.BaseJsonHttpResponseHandler;
import com.baidu.mapframework.commonlib.asynchttp.NirvanaResponseHandlerInterface;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;

public abstract class NirvanaBaseJsonHttpResponseHandler<JSON_TYPE>
  extends BaseJsonHttpResponseHandler
  implements NirvanaResponseHandlerInterface
{
  public NirvanaBaseJsonHttpResponseHandler(Module paramModule, ScheduleConfig paramScheduleConfig)
  {
    this(paramModule, paramScheduleConfig, "UTF-8");
  }
  
  public NirvanaBaseJsonHttpResponseHandler(Module paramModule, ScheduleConfig paramScheduleConfig, String paramString)
  {
    super(paramString);
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


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/nirvana/network/asynchttp/NirvanaBaseJsonHttpResponseHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */