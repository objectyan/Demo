package com.baidu.mobstat;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

class bf
{
  private static final bf b = new bf();
  private HashMap<String, Set<String>> a = new HashMap();
  private boolean c;
  private boolean d;
  
  private View.AccessibilityDelegate a(View paramView)
  {
    try
    {
      paramView = (View.AccessibilityDelegate)paramView.getClass().getMethod("getAccessibilityDelegate", new Class[0]).invoke(paramView, new Object[0]);
      return paramView;
    }
    catch (Exception paramView)
    {
      db.b("getAccessibilityDelegate threw an exception when called");
    }
    return null;
  }
  
  public static bf a()
  {
    return b;
  }
  
  private String a(View paramView, Activity paramActivity)
  {
    if (paramView == null) {
      paramActivity = "";
    }
    for (;;)
    {
      return paramActivity;
      ArrayList localArrayList = null;
      try
      {
        paramActivity = (ViewGroup)((ViewGroup)paramActivity.getWindow().getDecorView().findViewById(16908290)).getChildAt(0);
        localArrayList = new ArrayList();
        localArrayList.add(paramView.getClass().getName());
        while ((paramView != null) && (paramView != paramActivity))
        {
          paramView = (View)paramView.getParent();
          localArrayList.add(paramView.getClass().getName());
        }
        int i = localArrayList.size() - 1;
        paramView = "";
        while (i >= 0)
        {
          paramView = paramView + (String)localArrayList.get(i) + "/";
          i -= 1;
        }
        paramActivity = paramView;
        if (!paramView.endsWith("/")) {
          continue;
        }
        return paramView.substring(0, paramView.length() - 1);
      }
      catch (Exception paramActivity)
      {
        for (;;)
        {
          paramActivity = localArrayList;
        }
      }
    }
  }
  
  private void a(Activity paramActivity)
  {
    Object localObject1 = paramActivity.getWindow();
    if (localObject1 == null) {}
    for (;;)
    {
      return;
      localObject1 = ((Window)localObject1).getDecorView();
      if (localObject1 == null) {
        continue;
      }
      try
      {
        localObject1 = (ViewGroup)((ViewGroup)((View)localObject1).findViewById(16908290)).getChildAt(0);
        if (localObject1 == null) {
          continue;
        }
        a(paramActivity, (ViewGroup)localObject1);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject2 = null;
        }
      }
    }
  }
  
  private void a(Activity paramActivity, View paramView)
  {
    String str;
    if ((paramView instanceof Button))
    {
      str = ((Button)paramView).getText().toString();
      if (!TextUtils.isEmpty(str)) {}
    }
    else
    {
      return;
    }
    a(paramActivity, paramView, str);
  }
  
  private void a(Activity paramActivity, View paramView, String paramString)
  {
    View.AccessibilityDelegate localAccessibilityDelegate = a(paramView);
    if (!(localAccessibilityDelegate instanceof bh)) {
      paramView.setAccessibilityDelegate(new bh(this, paramActivity, paramView, paramString, localAccessibilityDelegate));
    }
  }
  
  private void a(Activity paramActivity, ViewGroup paramViewGroup)
  {
    int i = paramViewGroup.getChildCount() - 1;
    while (i >= 0)
    {
      View localView = paramViewGroup.getChildAt(i);
      if ((localView instanceof ViewGroup)) {
        a(paramActivity, (ViewGroup)localView);
      }
      a(paramActivity, localView);
      i -= 1;
    }
  }
  
  private void a(Activity paramActivity, boolean paramBoolean)
  {
    if ((paramActivity instanceof IIgnoreAutoTrace)) {
      return;
    }
    if (paramBoolean) {
      bv.a().a(paramActivity);
    }
    if (paramBoolean)
    {
      ch.a().a(paramActivity, System.currentTimeMillis(), true);
      return;
    }
    ch.a().a(paramActivity, System.currentTimeMillis(), true, null);
  }
  
  @TargetApi(14)
  private void a(Context paramContext, boolean paramBoolean)
  {
    if (this.d) {}
    do
    {
      return;
      if (Build.VERSION.SDK_INT >= 14) {
        break;
      }
    } while (!paramBoolean);
    db.a("module autotrace only support android os version bigger than 4.0");
    return;
    b(paramContext);
    this.d = true;
  }
  
  private void b(Activity paramActivity, View paramView, String paramString)
  {
    bv.a().a(paramActivity);
    String str2 = paramView.hashCode() + "_" + paramView.getId();
    String str1 = paramActivity.getClass().getName();
    synchronized (this.a)
    {
      Set localSet = (Set)this.a.get(str1);
      if ((localSet != null) && (localSet.contains(str2))) {
        return;
      }
      paramView = a(paramView, paramActivity);
      int i = Config.EventViewType.BUTTON.getValue();
      bm.a().a(paramActivity.getApplicationContext(), paramString, "", 1, System.currentTimeMillis(), paramView, str1, i, true);
      return;
    }
  }
  
  private void b(Context paramContext)
  {
    bg localbg = new bg(this);
    try
    {
      ((Application)paramContext.getApplicationContext()).registerActivityLifecycleCallbacks(localbg);
      return;
    }
    catch (Exception paramContext)
    {
      db.a("registerActivityLifecycleCallbacks encounter exception");
    }
  }
  
  public void a(Context paramContext)
  {
    a(paramContext, false);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mobstat/bf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */