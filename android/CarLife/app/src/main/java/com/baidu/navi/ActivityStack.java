package com.baidu.navi;

import android.app.Activity;
import android.os.Message;
import com.baidu.carlife.core.connect.c;
import com.baidu.carlife.core.screen.presentation.a.f;
import com.baidu.carlife.core.screen.presentation.a.g;
import com.baidu.carlife.core.screen.presentation.h;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.view.DownNotifManager;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.voicecommand.BNVoiceCommandController;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ActivityStack
{
  private static List<WeakReference<Activity>> listActivities = new ArrayList();
  
  public static final void addActivity(Activity paramActivity)
  {
    paramActivity = new WeakReference(paramActivity);
    listActivities.add(paramActivity);
  }
  
  public static void exitApp(boolean paramBoolean)
  {
    if (com.baidu.carlife.l.a.a().N())
    {
      Object localObject = new c(true);
      ((c)localObject).c(65625);
      localObject = Message.obtain(null, ((c)localObject).d(), 1001, 0, localObject);
      com.baidu.carlife.l.a.a().a((Message)localObject);
    }
    try
    {
      Thread.sleep(100L);
      if (paramBoolean)
      {
        BNVoiceCommandController.getInstance().setAPPVoiceFuncCallback(null);
        BNMapController.getInstance().SaveCache();
        DownNotifManager.getInstance(com.baidu.carlife.core.a.a()).clearAllNotifs();
        finish();
        com.baidu.carlife.l.a.a().R();
        return;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
        continue;
        finish();
      }
    }
  }
  
  public static void finish()
  {
    Iterator localIterator = listActivities.iterator();
    while (localIterator.hasNext())
    {
      Activity localActivity = (Activity)((WeakReference)localIterator.next()).get();
      if (localActivity != null) {
        localActivity.finish();
      }
    }
  }
  
  public static final List<WeakReference<Activity>> getActivityStack()
  {
    return listActivities;
  }
  
  public static void handleAppBackPressed()
  {
    Object localObject = g.a().b();
    if (((f)localObject).isWindowViewShown()) {
      ((f)localObject).hideWindowView();
    }
    ContentFragment localContentFragment;
    do
    {
      return;
      if (((f)localObject).isDialogShown())
      {
        ((f)localObject).cancelDialog();
        return;
      }
      if (com.baidu.carlife.view.a.a().b())
      {
        com.baidu.carlife.view.a.a().d();
        return;
      }
      localObject = h.a();
      localContentFragment = ((h)localObject).getCurrentFragment();
    } while (((localContentFragment != null) && (localContentFragment.onBackPressed())) || (((h)localObject).h() <= 0));
    ((h)localObject).back(null);
  }
  
  public static final void removeActivity(Activity paramActivity)
  {
    Iterator localIterator = listActivities.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if (localWeakReference.get() == paramActivity) {
        listActivities.remove(localWeakReference);
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/navi/ActivityStack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */