package com.baidu.platform.comapi.map;

import android.os.Message;
import com.baidu.mapframework.nirvana.looper.MainLooperHandler;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;

class LocalMapHandler
  extends MainLooperHandler
{
  private LocalMapListener listener = null;
  
  LocalMapHandler()
  {
    super(Module.MAP_ENGINE, ScheduleConfig.forData());
  }
  
  public void onMessage(Message paramMessage)
  {
    if (paramMessage.what != 65289) {}
    do
    {
      return;
      switch (paramMessage.arg1)
      {
      default: 
        return;
      }
    } while (this.listener == null);
    this.listener.onGetLocalMapState(paramMessage.arg1, paramMessage.arg2);
  }
  
  void registListener(LocalMapListener paramLocalMapListener)
  {
    this.listener = paramLocalMapListener;
  }
  
  void removeListener(LocalMapListener paramLocalMapListener) {}
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/LocalMapHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */