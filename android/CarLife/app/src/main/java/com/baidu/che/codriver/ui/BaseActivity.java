package com.baidu.che.codriver.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.che.codriver.ui.b.b;
import com.baidu.che.codriver.util.h;
import com.baidu.mobstat.StatService;
import java.util.Iterator;
import java.util.Stack;

public abstract class BaseActivity
  extends Activity
{
  private static Stack<BaseActivity> b = new Stack();
  private boolean a;
  
  public static void a()
  {
    if (!b.empty())
    {
      Iterator localIterator = b.iterator();
      while (localIterator.hasNext())
      {
        BaseActivity localBaseActivity = (BaseActivity)localIterator.next();
        if ((localBaseActivity != null) && (!localBaseActivity.isFinishing())) {
          localBaseActivity.finish();
        }
      }
      b.clear();
    }
  }
  
  public static void a(BaseActivity paramBaseActivity)
  {
    if ((paramBaseActivity != null) && (!paramBaseActivity.isFinishing())) {
      paramBaseActivity.finish();
    }
    c(paramBaseActivity);
  }
  
  public static BaseActivity b()
  {
    if (!b.empty())
    {
      Iterator localIterator = b.iterator();
      while (localIterator.hasNext())
      {
        BaseActivity localBaseActivity = (BaseActivity)localIterator.next();
        if ((localBaseActivity != null) && ((localBaseActivity instanceof MainActivity))) {
          return localBaseActivity;
        }
      }
    }
    return null;
  }
  
  private static void b(BaseActivity paramBaseActivity)
  {
    if (paramBaseActivity == null) {
      return;
    }
    b.push(paramBaseActivity);
  }
  
  private static void c(BaseActivity paramBaseActivity)
  {
    if (paramBaseActivity == null) {}
    while (!b.contains(paramBaseActivity)) {
      return;
    }
    b.remove(paramBaseActivity);
  }
  
  protected void a(String paramString) {}
  
  public void onBackPressed()
  {
    if ("main_dialog".equals(getIntent().getStringExtra("last_page"))) {
      b.b().t();
    }
    super.onBackPressed();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    h.b(getClass().getSimpleName(), "onCreate()");
    this.a = true;
    super.onCreate(paramBundle);
    b(this);
  }
  
  protected void onDestroy()
  {
    h.b(getClass().getSimpleName(), "onDestroy()");
    super.onDestroy();
    c(this);
  }
  
  protected void onPause()
  {
    h.b(getClass().getSimpleName(), "onPause()");
    StatService.onPause(this);
    this.a = false;
    super.onPause();
  }
  
  protected void onResume()
  {
    h.b(getClass().getSimpleName(), "onResume()");
    StatService.onResume(this);
    super.onResume();
  }
  
  protected void onStart()
  {
    h.b(getClass().getSimpleName(), "onStart()");
    super.onStart();
  }
  
  protected void onStop()
  {
    h.b(getClass().getSimpleName(), "onStop()");
    super.onStop();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/ui/BaseActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */