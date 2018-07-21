package com.baidu.mobstat;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import java.util.HashMap;
import java.util.Map;

class bm
{
  private static HandlerThread b = new HandlerThread("EventHandleThread");
  private static Handler c;
  private static bm d = new bm();
  HashMap<String, bs> a = new HashMap();
  
  private bm()
  {
    b.start();
    b.setPriority(10);
    c = new Handler(b.getLooper());
  }
  
  public static bm a()
  {
    return d;
  }
  
  public String a(String paramString1, String paramString2)
  {
    return "__sdk_" + paramString1 + "$|$" + paramString2;
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, int paramInt, long paramLong1, long paramLong2, ExtraInfo paramExtraInfo, Map<String, String> paramMap)
  {
    DataCore.instance().putEvent(paramContext, paramString1, paramString2, paramInt, paramLong1, paramLong2, "", "", 0, false, paramExtraInfo, paramMap);
    DataCore.instance().flush(paramContext);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, int paramInt1, long paramLong1, long paramLong2, String paramString3, String paramString4, int paramInt2, boolean paramBoolean)
  {
    DataCore.instance().putEvent(paramContext, paramString1, paramString2, paramInt1, paramLong1, paramLong2, paramString3, paramString4, paramInt2, paramBoolean, null, null);
    DataCore.instance().flush(paramContext);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, int paramInt, long paramLong, ExtraInfo paramExtraInfo, Map<String, String> paramMap)
  {
    c.post(new bo(this, paramContext, paramString1, paramString2, paramInt, paramLong, paramExtraInfo, paramMap));
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, int paramInt1, long paramLong, String paramString3, String paramString4, int paramInt2, boolean paramBoolean)
  {
    c.post(new bn(this, paramContext, paramString1, paramString2, paramInt1, paramLong, paramString3, paramString4, paramInt2, paramBoolean));
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, long paramLong)
  {
    c.post(new bp(this, paramLong, paramString1, paramString2));
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, long paramLong, ExtraInfo paramExtraInfo, Map<String, String> paramMap)
  {
    c.post(new bq(this, paramString1, paramString2, paramLong, paramContext, paramExtraInfo, paramMap));
  }
  
  public void b(Context paramContext, String paramString1, String paramString2, long paramLong, ExtraInfo paramExtraInfo, Map<String, String> paramMap)
  {
    c.post(new br(this, paramLong, paramContext, paramString1, paramString2, paramExtraInfo, paramMap));
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mobstat/bm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */