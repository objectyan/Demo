package com.baidu.mobstat;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;

class cq
  extends bk
{
  static cq a = new cq();
  
  public static cq a()
  {
    return a;
  }
  
  public SharedPreferences a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 11) {
      return paramContext.getSharedPreferences("baidu_mtj_sdk_record", 4);
    }
    return paramContext.getSharedPreferences("baidu_mtj_sdk_record", 0);
  }
  
  protected void a(Context paramContext, long paramLong)
  {
    b(paramContext, "session_first_visit_time", paramLong);
  }
  
  protected void a(Context paramContext, String paramString)
  {
    b(paramContext, "session_today_visit_count", paramString);
  }
  
  protected Long b(Context paramContext)
  {
    return Long.valueOf(a(paramContext, "session_first_visit_time", 0L));
  }
  
  protected void b(Context paramContext, long paramLong)
  {
    b(paramContext, "session_last_visit_time", paramLong);
  }
  
  protected void b(Context paramContext, String paramString)
  {
    b(paramContext, "session_recent_visit", paramString);
  }
  
  protected Long c(Context paramContext)
  {
    return Long.valueOf(a(paramContext, "session_last_visit_time", 0L));
  }
  
  protected void c(Context paramContext, long paramLong)
  {
    b(paramContext, "session_visit_interval", paramLong);
  }
  
  protected Long d(Context paramContext)
  {
    return Long.valueOf(a(paramContext, "session_visit_interval", 0L));
  }
  
  protected String e(Context paramContext)
  {
    return a(paramContext, "session_today_visit_count", "");
  }
  
  protected String f(Context paramContext)
  {
    return a(paramContext, "session_recent_visit", "");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mobstat/cq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */