package com.baidu.mapframework.nirvana.network.asynchttp;

import android.os.Looper;
import com.baidu.mapframework.commonlib.asynchttp.BinaryHttpResponseHandler;
import com.baidu.mapframework.commonlib.asynchttp.NirvanaResponseHandlerInterface;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;

public abstract class NirvanaBinaryHttpResponseHandler
  extends BinaryHttpResponseHandler
  implements NirvanaResponseHandlerInterface
{
  public NirvanaBinaryHttpResponseHandler(Module paramModule, ScheduleConfig paramScheduleConfig)
  {
    this.module = paramModule;
    this.scheduleConfig = paramScheduleConfig;
  }
  
  public NirvanaBinaryHttpResponseHandler(Module paramModule, ScheduleConfig paramScheduleConfig, String[] paramArrayOfString)
  {
    super(paramArrayOfString);
    this.module = paramModule;
    this.scheduleConfig = paramScheduleConfig;
  }
  
  public NirvanaBinaryHttpResponseHandler(Module paramModule, ScheduleConfig paramScheduleConfig, String[] paramArrayOfString, Looper paramLooper)
  {
    super(paramArrayOfString, paramLooper);
    this.module = paramModule;
    this.scheduleConfig = paramScheduleConfig;
  }
  
  public NirvanaBinaryHttpResponseHandler(String[] paramArrayOfString, Module paramModule, ScheduleConfig paramScheduleConfig)
  {
    super(paramArrayOfString);
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


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/nirvana/network/asynchttp/NirvanaBinaryHttpResponseHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */