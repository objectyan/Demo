package com.baidu.mapframework.nirvana.network.asynchttp;

import com.baidu.mapframework.commonlib.asynchttp.AsyncHttpResponseHandler;
import com.baidu.mapframework.commonlib.asynchttp.NirvanaResponseHandlerInterface;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;

public abstract class NirvanaBaseHttpResponseHandler
  extends AsyncHttpResponseHandler
  implements NirvanaResponseHandlerInterface
{
  public NirvanaBaseHttpResponseHandler(Module paramModule, ScheduleConfig paramScheduleConfig)
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
  
  public void onProgress(long paramLong1, long paramLong2)
  {
    super.onProgress(paramLong1, paramLong2);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/nirvana/network/asynchttp/NirvanaBaseHttpResponseHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */