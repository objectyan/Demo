package com.baidu.mapframework.nirvana.network.asynchttp;

import android.content.Context;
import com.baidu.mapframework.commonlib.asynchttp.FileAsyncHttpResponseHandler;
import com.baidu.mapframework.commonlib.asynchttp.NirvanaResponseHandlerInterface;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;
import java.io.File;

public abstract class NirvanaFileAsyncHttpResponseHandler
  extends FileAsyncHttpResponseHandler
  implements NirvanaResponseHandlerInterface
{
  public NirvanaFileAsyncHttpResponseHandler(Module paramModule, ScheduleConfig paramScheduleConfig, Context paramContext)
  {
    super(paramContext);
    this.module = paramModule;
    this.scheduleConfig = paramScheduleConfig;
  }
  
  public NirvanaFileAsyncHttpResponseHandler(Module paramModule, ScheduleConfig paramScheduleConfig, File paramFile)
  {
    this(paramModule, paramScheduleConfig, paramFile, false);
  }
  
  public NirvanaFileAsyncHttpResponseHandler(Module paramModule, ScheduleConfig paramScheduleConfig, File paramFile, boolean paramBoolean)
  {
    this(paramModule, paramScheduleConfig, paramFile, paramBoolean, false);
  }
  
  public NirvanaFileAsyncHttpResponseHandler(Module paramModule, ScheduleConfig paramScheduleConfig, File paramFile, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramFile, paramBoolean1, paramBoolean2);
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


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/nirvana/network/asynchttp/NirvanaFileAsyncHttpResponseHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */