package com.baidu.mapframework.nirvana.network.asynchttp;

import com.baidu.mapframework.commonlib.asynchttp.FileAsyncHttpResponseHandler;
import com.baidu.mapframework.commonlib.asynchttp.NirvanaResponseHandlerInterface;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;
import java.io.File;

public abstract class NirvanaRangeFileAsyncHttpResponseHandler
  extends FileAsyncHttpResponseHandler
  implements NirvanaResponseHandlerInterface
{
  public NirvanaRangeFileAsyncHttpResponseHandler(Module paramModule, ScheduleConfig paramScheduleConfig, File paramFile)
  {
    super(paramFile);
    this.module = paramModule;
    this.scheduleConfig = this.scheduleConfig;
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


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/nirvana/network/asynchttp/NirvanaRangeFileAsyncHttpResponseHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */