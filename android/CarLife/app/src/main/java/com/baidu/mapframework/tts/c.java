package com.baidu.mapframework.tts;

import android.content.Context;
import com.baidu.baidunavis.tts.BaseTTSPlayer;
import com.baidu.mapframework.common.util.StorageInformation;
import com.baidu.mapframework.common.util.StorageSettings;
import com.baidu.mapframework.nirvana.concurrent.ConcurrentManager;
import com.baidu.mapframework.nirvana.concurrent.ConcurrentTask;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;
import java.io.File;

public class c
{
  public static void a(Context paramContext)
  {
    final String str = StorageSettings.getInstance().getCurrentStorage().getDataPath() + File.separator + "bnav";
    ConcurrentManager.executeTask(Module.VOICE_MODULE, new ConcurrentTask()
    {
      public void run()
      {
        BaseTTSPlayer.loadTTSSO();
        BaseTTSPlayer.getInstance().initPlayer(this.a, str);
      }
    }, ScheduleConfig.forData());
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/tts/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */