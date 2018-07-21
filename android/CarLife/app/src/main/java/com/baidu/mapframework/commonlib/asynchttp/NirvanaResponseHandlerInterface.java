package com.baidu.mapframework.commonlib.asynchttp;

import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;

public abstract interface NirvanaResponseHandlerInterface
  extends ResponseHandlerInterface
{
  public abstract Module getNirvanaModule();
  
  public abstract ScheduleConfig getNirvanaScheduleConfig();
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/commonlib/asynchttp/NirvanaResponseHandlerInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */