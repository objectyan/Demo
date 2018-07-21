package com.baidu.carlife;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Display;
import android.view.WindowManager;
import com.baidu.android.common.util.CommonParam;
import com.baidu.carlife.core.i;
import com.baidu.mobstat.StatService;
import com.baidu.navi.ActivityStack;
import com.baidu.navisdk.model.MainMapModel;
import com.baidu.navisdk.util.common.PackageUtil;
import java.util.Iterator;
import java.util.List;

public class BaseActivity
  extends FragmentActivity
{
  public static String a = "BaseActivity";
  public boolean b = true;
  
  public String a(Context paramContext)
  {
    Object localObject = null;
    List localList = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1);
    paramContext = (Context)localObject;
    if (localList != null) {
      paramContext = ((ActivityManager.RunningTaskInfo)localList.get(0)).topActivity.getClassName();
    }
    return paramContext;
  }
  
  public boolean a()
  {
    Object localObject = (ActivityManager)getApplicationContext().getSystemService("activity");
    String str = getApplicationContext().getPackageName();
    localObject = ((ActivityManager)localObject).getRunningAppProcesses();
    if (localObject == null) {}
    ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
    do
    {
      while (!((Iterator)localObject).hasNext())
      {
        return false;
        localObject = ((List)localObject).iterator();
      }
      localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
    } while ((!localRunningAppProcessInfo.processName.equals(str)) || (localRunningAppProcessInfo.importance != 100));
    return true;
  }
  
  public boolean b()
  {
    Object localObject = (ActivityManager)getApplicationContext().getSystemService("activity");
    String str = getApplicationContext().getPackageName();
    localObject = ((ActivityManager)localObject).getRunningAppProcesses();
    if (localObject == null) {}
    ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
    do
    {
      while (!((Iterator)localObject).hasNext())
      {
        return false;
        localObject = ((List)localObject).iterator();
      }
      localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
    } while ((!localRunningAppProcessInfo.processName.equals(str)) || (localRunningAppProcessInfo.importance != 400));
    return true;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = getWindowManager().getDefaultDisplay();
    if (Build.VERSION.SDK_INT >= 8)
    {
      MainMapModel.getInstance().mScreenRotation = (paramConfiguration.getRotation() * 90);
      return;
    }
    MainMapModel.getInstance().mScreenRotation = (paramConfiguration.getOrientation() * 90);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    ActivityStack.addActivity(this);
    super.onCreate(paramBundle);
    i.a(a, "Time test:Start in BaseActivity 0 ");
    StatService.setAppChannel(getApplicationContext(), PackageUtil.getChannel(), true);
    i.a(a, "Time test:Start in BaseActivity 1 ");
    paramBundle = CommonParam.getCUID(getApplicationContext());
    PackageUtil.setCuid(paramBundle);
    i.a(a, "cuid = " + paramBundle);
    i.a(a, "Time test:Start in BaseActivity 2");
    paramBundle = getWindowManager().getDefaultDisplay();
    if (Build.VERSION.SDK_INT >= 8)
    {
      MainMapModel.getInstance().mScreenRotation = (paramBundle.getRotation() * 90);
      return;
    }
    MainMapModel.getInstance().mScreenRotation = (paramBundle.getOrientation() * 90);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    ActivityStack.removeActivity(this);
  }
  
  protected void onPause()
  {
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
  }
  
  protected void onStart()
  {
    super.onStart();
  }
  
  protected void onStop()
  {
    super.onStop();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/BaseActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */