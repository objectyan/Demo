package com.baidu.mapframework.widget;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.mapframework.nirvana.looper.LooperManager;
import com.baidu.mapframework.nirvana.looper.LooperTask;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;
import com.baidu.platform.comapi.c;
import com.baidu.platform.comapi.util.n;
import java.util.List;

public class MToast
{
  private static int a;
  
  public static void show(int paramInt)
  {
    show(c.f().getResources().getString(paramInt));
  }
  
  public static void show(Context paramContext, final int paramInt)
  {
    if (paramContext == null) {
      return;
    }
    n.a(new Runnable()
    {
      public void run()
      {
        MToast.show(this.a, this.a.getString(paramInt));
      }
    });
  }
  
  public static void show(Context paramContext, final String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {}
    List localList;
    do
    {
      return;
      a = 0;
      if (paramString.length() > 15) {
        a = 1;
      }
      if (Build.VERSION.SDK_INT >= 21) {
        break;
      }
      localList = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1);
    } while ((localList == null) || (localList.size() <= 0) || (localList.get(0) == null) || (!paramContext.getPackageName().equals(((ActivityManager.RunningTaskInfo)localList.get(0)).baseActivity.getPackageName())));
    LooperManager.executeTask(Module.COMMON_WIDGET_MODULE, new LooperTask()
    {
      public void run()
      {
        if (this.a != null) {
          Toast.makeText(this.a, paramString, MToast.a()).show();
        }
      }
    }, ScheduleConfig.forData());
    return;
    LooperManager.executeTask(Module.COMMON_WIDGET_MODULE, new LooperTask()
    {
      public void run()
      {
        Toast.makeText(this.a, paramString, MToast.a()).show();
      }
    }, ScheduleConfig.forData());
  }
  
  public static void show(String paramString)
  {
    show(c.f(), paramString);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/widget/MToast.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */