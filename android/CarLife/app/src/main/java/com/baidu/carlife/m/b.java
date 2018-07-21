package com.baidu.carlife.m;

import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.baidunavis.tts.BaseTTSPlayer;
import com.baidu.carlife.core.a;
import com.baidu.platform.basic.BMExecutorsManager;
import java.io.File;
import java.util.concurrent.ExecutorService;

public class b
{
  public static void a()
  {
    String str = NavMapAdapter.getInstance().getDataPath() + File.separator + "bnav";
    BMExecutorsManager.CACHED_EXECUTOR_SERVICE.execute(new Runnable()
    {
      public void run()
      {
        BaseTTSPlayer.loadTTSSO();
        BaseTTSPlayer.getInstance().initPlayer(a.a(), this.a);
      }
    });
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/m/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */