package com.baidu.navi.util;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.carlife.CarlifeActivity;
import com.baidu.carlife.core.a;
import com.baidu.carlife.core.i;
import com.baidu.carlife.core.screen.presentation.h;
import com.baidu.mobstat.StatService;
import com.baidu.navisdk.BNaviModuleManager;
import java.util.LinkedHashMap;

public class StatisticManager
{
  public static LinkedHashMap<View, String> mLRUCache = new LinkedHashMap(50);
  
  private static String getPageName(Activity paramActivity)
  {
    String str2 = paramActivity.getClass().getSimpleName();
    String str1 = str2;
    if ((paramActivity instanceof CarlifeActivity))
    {
      paramActivity = h.a().getCurrentFragment();
      str1 = str2;
      if (paramActivity != null) {
        str1 = paramActivity.getClass().getSimpleName();
      }
    }
    return str1;
  }
  
  public static void onActivityPause(Context paramContext)
  {
    StatService.onPause(paramContext);
  }
  
  public static void onActivityResume(Context paramContext)
  {
    StatService.onResume(paramContext);
  }
  
  public static void onEvent(Activity paramActivity, View paramView)
  {
    Object localObject2 = (String)mLRUCache.get(paramView);
    Object localObject1 = localObject2;
    String str;
    if (localObject2 == null)
    {
      str = getPageName(paramActivity);
      localObject1 = null;
      if (!(paramView instanceof Button)) {
        break label138;
      }
      localObject1 = ((Button)paramView).getText();
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((CharSequence)localObject1).length() != 0) {}
      }
      else
      {
        localObject1 = new Throwable().getStackTrace()[1];
        str = ((StackTraceElement)localObject1).getFileName();
        localObject2 = "line:" + ((StackTraceElement)localObject1).getLineNumber();
      }
      localObject1 = str + "-" + localObject2;
      mLRUCache.put(paramView, localObject1);
      StatService.onEvent(paramActivity, (String)localObject1, (String)localObject1);
      return;
      label138:
      if ((paramView instanceof ImageView))
      {
        localObject1 = ((ImageView)paramView).getContentDescription();
      }
      else
      {
        localObject2 = traversalTextView(paramView);
        if (localObject2 != null) {
          localObject1 = ((TextView)localObject2).getText();
        }
      }
    }
  }
  
  public static void onEvent(String paramString)
  {
    StatService.onEvent(BNaviModuleManager.getContext(), paramString, paramString);
    i.b("mtj", "eventId: " + paramString + " label: " + paramString);
  }
  
  public static void onEvent(String paramString1, String paramString2)
  {
    StatService.onEvent(a.a(), paramString1, paramString2);
    i.b("mtj", "eventId: " + paramString1 + " label: " + paramString2);
  }
  
  public static void onEventDuration(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    if (paramInt <= 0) {
      return;
    }
    StatService.onEventDuration(paramContext, paramString1, paramString2, paramInt / 2);
    i.b("mtj", "eventId: " + paramString1 + " label: " + paramString2 + " duration: " + paramInt / 2);
  }
  
  public static void onEventEnd(Context paramContext, String paramString1, String paramString2)
  {
    StatService.onEventEnd(paramContext, paramString1, paramString2);
  }
  
  public static void onEventMileage(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    if (paramInt <= 0) {
      return;
    }
    StatService.onEventDuration(paramContext, paramString1, paramString2, paramInt * 10);
    i.b("mtj", "eventId: " + paramString1 + " label: " + paramString2 + " duration: " + paramInt * 10);
  }
  
  public static void onEventStart(Context paramContext, String paramString1, String paramString2)
  {
    StatService.onEventStart(paramContext, paramString1, paramString2);
  }
  
  public static void onFragmentPause(Fragment paramFragment)
  {
    StatService.onPause(paramFragment);
  }
  
  public static void onFragmentResume(Fragment paramFragment)
  {
    StatService.onResume(paramFragment);
  }
  
  public static void onPageEnd(Context paramContext, String paramString)
  {
    StatService.onPageEnd(paramContext, paramString);
  }
  
  public static void onPageStart(Context paramContext, String paramString)
  {
    StatService.onPageStart(paramContext, paramString);
  }
  
  public static void setAppChannel(String paramString)
  {
    StatService.setAppChannel(paramString);
  }
  
  public static void setDebugOn()
  {
    StatService.setDebugOn(true);
  }
  
  private static TextView traversalTextView(View paramView)
  {
    if ((paramView instanceof TextView)) {
      return (TextView)paramView;
    }
    int i;
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      i = 0;
    }
    while (i < paramView.getChildCount())
    {
      TextView localTextView = traversalTextView(paramView.getChildAt(i));
      if (localTextView != null)
      {
        return localTextView;
        return null;
      }
      i += 1;
    }
    return null;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/util/StatisticManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */