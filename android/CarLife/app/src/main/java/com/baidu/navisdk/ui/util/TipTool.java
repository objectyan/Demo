package com.baidu.navisdk.ui.util;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.widget.Toast;
import com.baidu.navisdk.debug.NavSDKDebug;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.navisdk.util.worker.IBNWorkerCenter;
import java.util.Iterator;
import java.util.List;

public class TipTool
{
  private static final int MAX_TOAST_TEXT_LENGTH = 30;
  static String mLastMessagePrefix;
  static long mLastTime;
  static Toast mToast = null;
  static ToastInterface mToastinInterface;
  
  public static ToastInterface getToastinInterface()
  {
    return mToastinInterface;
  }
  
  public static void onCreateDebugToast(Context paramContext, String paramString)
  {
    if (!NavSDKDebug.sShowDebugToast) {}
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
      if ((str != null) && (str.length() <= 30)) {
        onCreateToastDialog(paramContext, str);
      }
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public static void onCreateToastDialog(final Context paramContext, final String paramString)
  {
    if ((paramContext == null) || (paramString == null) || (paramString.length() > 30)) {
      return;
    }
    ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
    do
    {
      Object localObject;
      do
      {
        do
        {
          if (!DialogReplaceToastUtils.hasNotifiyAuth())
          {
            int i = 0;
            if (paramString.length() > 15) {
              i = 1;
            }
            if (mToastinInterface != null)
            {
              mToastinInterface.showToast(paramString, i);
              return;
            }
          }
          paramContext = paramContext.getApplicationContext();
          localObject = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
        } while (localObject == null);
        localObject = ((List)localObject).iterator();
      } while (!((Iterator)localObject).hasNext());
      localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
      if (!localRunningAppProcessInfo.processName.equals(paramContext.getPackageName())) {
        break;
      }
    } while (localRunningAppProcessInfo.importance != 100);
    BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask("", null)new BNWorkerConfig
    {
      protected String execute()
      {
        int i = 0;
        try
        {
          if (paramString.length() > 15) {
            i = 1;
          }
          if (TipTool.mToastinInterface != null)
          {
            TipTool.mToastinInterface.showToast(paramString, i);
            return null;
          }
          if (TipTool.mToast != null) {
            TipTool.mToast.cancel();
          }
          TipTool.mToast = Toast.makeText(paramContext, paramString, i);
          TipTool.mToast.show();
          return null;
        }
        catch (Exception localException) {}
        return null;
      }
    }, new BNWorkerConfig(100, 0));
  }
  
  public static void setToastinInterface(ToastInterface paramToastInterface)
  {
    mToastinInterface = paramToastInterface;
  }
  
  public class a
  {
    int in;
    
    public a() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/util/TipTool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */