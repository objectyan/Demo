package com.baidu.navi.widget;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.carlife.util.w;
import java.util.List;

public class MToast
{
  public static void show(Context paramContext, int paramInt)
  {
    if (paramContext == null) {
      return;
    }
    show(paramContext, paramContext.getString(paramInt));
  }
  
  public static void show(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {}
    List localList;
    do
    {
      return;
      localList = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1);
    } while ((localList == null) || (localList.get(0) == null) || (!paramContext.getPackageName().equals(((ActivityManager.RunningTaskInfo)localList.get(0)).baseActivity.getPackageName())));
    int i = 0;
    if (paramString.length() > 15) {
      i = 1;
    }
    w.a(paramString, i);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/widget/MToast.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */