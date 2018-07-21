package com.baidu.tts.client.model;

import android.content.Context;
import com.baidu.tts.p.b;

public class Statistics
{
  public static boolean isStatistics = true;
  private b a;
  
  public Statistics(Context paramContext)
  {
    this.a = new b(paramContext);
  }
  
  public static void setEnable(boolean paramBoolean)
  {
    isStatistics = paramBoolean;
  }
  
  public int start()
  {
    this.a.a();
    return 0;
  }
  
  public int stop()
  {
    this.a.b();
    return 0;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/client/model/Statistics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */