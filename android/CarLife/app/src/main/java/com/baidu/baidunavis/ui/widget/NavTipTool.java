package com.baidu.baidunavis.ui.widget;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.widget.Toast;
import com.baidu.baidunavis.control.NavLogUtils;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.navisdk.util.worker.IBNWorkerCenter;
import java.util.Iterator;
import java.util.List;

public class NavTipTool
{
  private static final int MAX_TOAST_TEXT_LENGTH = 20;
  static String mLastMessagePrefix;
  static long mLastTime;
  static Toast mToast = null;
  
  public static void onCreateDebugToast(Context paramContext, String paramString)
  {
    if (!NavLogUtils.LOGGABLE) {}
    while ((paramString == null) || (paramString.length() < 2)) {
      return;
    }
    long l = System.currentTimeMillis();
    String str = paramString.split(" ")[0];
    if ((l - mLastTime < 10000L) && (mLastMessagePrefix != null) && (mLastMessagePrefix.equals(str)))
    {
      mLastTime = System.currentTimeMillis();
      return;
    }
    mLastMessagePrefix = str;
    mLastTime = System.currentTimeMillis();
    onCreateToastDialog(paramContext, paramString);
  }
  
  public static void onCreateToastDialog(Context paramContext, int paramInt)
  {
    try
    {
      String str = paramContext.getString(paramInt);
      if ((str != null) && (str.length() <= 20)) {
        onCreateToastDialog(paramContext, str);
      }
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public static void onCreateToastDialog(final Context paramContext, final String paramString)
  {
    if ((paramContext == null) || (paramString == null) || (paramString.length() > 20)) {}
    ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
    do
    {
      return;
      Object localObject;
      while (!((Iterator)localObject).hasNext())
      {
        do
        {
          paramContext = paramContext.getApplicationContext();
          localObject = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
        } while (localObject == null);
        localObject = ((List)localObject).iterator();
      }
      localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
    } while ((!localRunningAppProcessInfo.processName.equals(paramContext.getPackageName())) || (localRunningAppProcessInfo.importance != 100));
    BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask("NavTipTool", null)new BNWorkerConfig
    {
      protected String execute()
      {
        try
        {
          if (NavTipTool.mToast != null) {
            NavTipTool.mToast.cancel();
          }
          int i = 0;
          try
          {
            if (paramString.length() > 15) {
              i = 1;
            }
            NavTipTool.mToast = Toast.makeText(paramContext, paramString, i);
            NavTipTool.mToast.show();
          }
          catch (Exception localException1)
          {
            for (;;) {}
          }
          return null;
        }
        catch (Exception localException2)
        {
          for (;;) {}
        }
      }
    }, new BNWorkerConfig(100, 0));
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidunavis/ui/widget/NavTipTool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */