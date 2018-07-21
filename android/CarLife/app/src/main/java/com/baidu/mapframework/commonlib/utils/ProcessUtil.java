package com.baidu.mapframework.commonlib.utils;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Process;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ProcessUtil
{
  private static volatile int a = 0;
  
  public static int[] getPids(Context paramContext)
  {
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    LinkedList localLinkedList;
    try
    {
      localLinkedList = new LinkedList();
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        localObject = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if (((ActivityManager.RunningAppProcessInfo)localObject).uid == Process.myUid())
        {
          localLinkedList.add(Integer.valueOf(((ActivityManager.RunningAppProcessInfo)localObject).pid));
          continue;
          return paramContext;
        }
      }
    }
    catch (Exception paramContext)
    {
      paramContext = new int[0];
    }
    Object localObject = new int[localLinkedList.size()];
    int i = 0;
    int j = localObject.length;
    for (;;)
    {
      paramContext = (Context)localObject;
      if (i >= j) {
        break;
      }
      localObject[i] = ((Integer)localLinkedList.get(i)).intValue();
      i += 1;
    }
  }
  
  public static HashMap<Integer, String> getPidsByPackageName(Context paramContext)
  {
    localObject = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    try
    {
      HashMap localHashMap = new HashMap();
      Iterator localIterator = ((List)localObject).iterator();
      for (;;)
      {
        localObject = localHashMap;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (ActivityManager.RunningAppProcessInfo)localIterator.next();
        if (((ActivityManager.RunningAppProcessInfo)localObject).processName.contains(paramContext.getPackageName())) {
          localHashMap.put(Integer.valueOf(((ActivityManager.RunningAppProcessInfo)localObject).pid), ((ActivityManager.RunningAppProcessInfo)localObject).processName);
        }
      }
      return (HashMap<Integer, String>)localObject;
    }
    catch (Exception paramContext)
    {
      localObject = new HashMap();
    }
  }
  
  public static String getProcessName(Context paramContext, int paramInt)
  {
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    try
    {
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if (localRunningAppProcessInfo.pid == paramInt)
        {
          paramContext = localRunningAppProcessInfo.processName;
          return paramContext;
        }
      }
    }
    catch (Exception paramContext) {}
    return "";
  }
  
  /* Error */
  public static boolean isMainProcess(Context paramContext)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: ldc 2
    //   4: monitorenter
    //   5: getstatic 10	com/baidu/mapframework/commonlib/utils/ProcessUtil:a	I
    //   8: ifne +26 -> 34
    //   11: aload_0
    //   12: invokestatic 119	android/os/Process:myPid	()I
    //   15: invokestatic 121	com/baidu/mapframework/commonlib/utils/ProcessUtil:getProcessName	(Landroid/content/Context;I)Ljava/lang/String;
    //   18: aload_0
    //   19: invokevirtual 98	android/content/Context:getPackageName	()Ljava/lang/String;
    //   22: invokevirtual 124	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   25: ifeq +22 -> 47
    //   28: iconst_1
    //   29: istore_1
    //   30: iload_1
    //   31: putstatic 10	com/baidu/mapframework/commonlib/utils/ProcessUtil:a	I
    //   34: getstatic 10	com/baidu/mapframework/commonlib/utils/ProcessUtil:a	I
    //   37: istore_1
    //   38: iload_1
    //   39: ifle +13 -> 52
    //   42: ldc 2
    //   44: monitorexit
    //   45: iload_2
    //   46: ireturn
    //   47: iconst_m1
    //   48: istore_1
    //   49: goto -19 -> 30
    //   52: iconst_0
    //   53: istore_2
    //   54: goto -12 -> 42
    //   57: astore_0
    //   58: ldc 2
    //   60: monitorexit
    //   61: aload_0
    //   62: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	63	0	paramContext	Context
    //   29	20	1	i	int
    //   1	53	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   5	28	57	finally
    //   30	34	57	finally
    //   34	38	57	finally
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/mapframework/commonlib/utils/ProcessUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */