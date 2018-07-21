package com.baidu.navisdk.module.perfomance;

import android.util.Log;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.debug.SDKDebugFileUtil;
import java.util.HashMap;
import java.util.Map;

public class TimeConsume
{
  public static final boolean OPEN = true;
  public static final String TAG = "time_consume";
  public static final String TARGET_NAVING = "tc_naving";
  public static final String TARGET_NAVI_INIT = "tc_navi_init";
  public static final String TARGET_NAVI_MAP_RENDER = "navi_map_render";
  public static Map<String, Long> sBaseTime = null;
  public static Map<String, Integer> sSumTime = null;
  
  public static void dot(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (!BNSettingManager.isShowJavaLog()) {}
    while ((paramString1 == null) || (paramString1.length() == 0) || (!init())) {
      return;
    }
    if (paramBoolean)
    {
      sBaseTime.put(paramString1, Long.valueOf(System.currentTimeMillis()));
      sSumTime.put(paramString1, Integer.valueOf(0));
      SDKDebugFileUtil.get(paramString1).add("耗时：0, 累积耗时：0, 基准时间：" + sBaseTime.get(paramString1) + ", " + paramString2);
      Log.e("time_consume", paramString1 + ", 耗时：" + 0 + ", 累积耗时：" + 0 + ", 基准时间：" + sBaseTime.get(paramString1) + ", " + paramString2);
      return;
    }
    if (!sBaseTime.containsKey(paramString1))
    {
      sBaseTime.put(paramString1, Long.valueOf(System.currentTimeMillis()));
      sSumTime.put(paramString1, Integer.valueOf(0));
    }
    int i = ((Integer)sSumTime.get(paramString1)).intValue();
    int j = (int)(System.currentTimeMillis() - ((Long)sBaseTime.get(paramString1)).longValue());
    sSumTime.put(paramString1, Integer.valueOf(j));
    SDKDebugFileUtil.get(paramString1).add("耗时：" + (j - i) + ", 累积耗时：" + j + ", 基准时间：" + sBaseTime.get(paramString1) + ", " + paramString2);
    Log.e("time_consume", paramString1 + ", 耗时：" + (j - i) + ", 累积耗时：" + j + ", 基准时间：" + sBaseTime.get(paramString1) + ", " + paramString2);
  }
  
  public static void dotEng(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (!BNSettingManager.isShowJavaLog()) {}
    while ((paramString1 == null) || (paramString1.length() == 0) || (!init())) {
      return;
    }
    if (paramBoolean)
    {
      sBaseTime.put(paramString1, Long.valueOf(System.currentTimeMillis()));
      sSumTime.put(paramString1, Integer.valueOf(0));
      SDKDebugFileUtil.get(paramString1).add("TimeConsume: 0, TotalTimeConsume: 0, BaseTime: " + sBaseTime.get(paramString1) + ", " + paramString2);
      Log.e("time_consume", paramString1 + ", TimeConsume: " + 0 + ", TotalTimeConsume: " + 0 + ", BaseTime: " + sBaseTime.get(paramString1) + ", " + paramString2);
      return;
    }
    if (!sBaseTime.containsKey(paramString1))
    {
      sBaseTime.put(paramString1, Long.valueOf(System.currentTimeMillis()));
      sSumTime.put(paramString1, Integer.valueOf(0));
    }
    int i = ((Integer)sSumTime.get(paramString1)).intValue();
    int j = (int)(System.currentTimeMillis() - ((Long)sBaseTime.get(paramString1)).longValue());
    sSumTime.put(paramString1, Integer.valueOf(j));
    SDKDebugFileUtil.get(paramString1).add("TimeConsume: " + (j - i) + ", TotalTimeConsume: " + j + ", BaseTime: " + sBaseTime.get(paramString1) + ", " + paramString2);
    Log.e("time_consume", paramString1 + ", TimeConsume: " + (j - i) + ", TotalTimeConsume: " + j + ", BaseTime: " + sBaseTime.get(paramString1) + ", " + paramString2);
  }
  
  public static void dotTmp(String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramString1 == null) || (paramString1.length() == 0)) {}
    while (!init()) {
      return;
    }
    if (paramBoolean)
    {
      sBaseTime.put(paramString1, Long.valueOf(System.currentTimeMillis()));
      sSumTime.put(paramString1, Integer.valueOf(0));
      Log.e("time_consume", paramString1 + ", 耗时：" + 0 + ", 累积耗时：" + 0 + ", 基准时间：" + sBaseTime.get(paramString1) + ", " + paramString2);
      return;
    }
    if (!sBaseTime.containsKey(paramString1))
    {
      sBaseTime.put(paramString1, Long.valueOf(System.currentTimeMillis()));
      sSumTime.put(paramString1, Integer.valueOf(0));
    }
    int i = ((Integer)sSumTime.get(paramString1)).intValue();
    int j = (int)(System.currentTimeMillis() - ((Long)sBaseTime.get(paramString1)).longValue());
    sSumTime.put(paramString1, Integer.valueOf(j));
    Log.e("time_consume", paramString1 + ", 耗时：" + (j - i) + ", 累积耗时：" + j + ", 基准时间：" + sBaseTime.get(paramString1) + ", " + paramString2);
  }
  
  private static boolean init()
  {
    if ((sBaseTime == null) || (sSumTime == null))
    {
      sBaseTime = new HashMap();
      sSumTime = new HashMap();
    }
    return true;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/module/perfomance/TimeConsume.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */