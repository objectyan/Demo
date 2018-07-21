package com.baidu.carlife.c.d;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class h
{
  @SuppressLint({"StaticFieldLeak"})
  private static a a;
  
  private static Application a(Activity paramActivity)
  {
    paramActivity = paramActivity.getApplication();
    if (paramActivity == null) {
      throw new IllegalStateException("Your activity/fragment is not yet attached to Application. You can't request ViewModel before onCreate call.");
    }
    return paramActivity;
  }
  
  @MainThread
  public static g a(@NonNull Fragment paramFragment)
  {
    a(a(b(paramFragment)));
    return new g(new i(), a);
  }
  
  @MainThread
  public static g a(@NonNull FragmentActivity paramFragmentActivity)
  {
    a(a(paramFragmentActivity));
    return new g(new i(), a);
  }
  
  private static void a(Application paramApplication)
  {
    if (a == null) {
      a = new a(paramApplication);
    }
  }
  
  private static Activity b(Fragment paramFragment)
  {
    paramFragment = paramFragment.getActivity();
    if (paramFragment == null) {
      throw new IllegalStateException("Can't create ViewModelProvider for detached fragment");
    }
    return paramFragment;
  }
  
  public static class a
    extends g.c
  {
    private Application a;
    
    public a(@NonNull Application paramApplication)
    {
      this.a = paramApplication;
    }
    
    @NonNull
    public <T extends f> T a(@NonNull Class<T> paramClass)
    {
      if (a.class.isAssignableFrom(paramClass)) {
        try
        {
          f localf = (f)paramClass.getConstructor(new Class[] { Application.class }).newInstance(new Object[] { this.a });
          return localf;
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          throw new RuntimeException("Cannot create an instance of " + paramClass, localNoSuchMethodException);
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          throw new RuntimeException("Cannot create an instance of " + paramClass, localIllegalAccessException);
        }
        catch (InstantiationException localInstantiationException)
        {
          throw new RuntimeException("Cannot create an instance of " + paramClass, localInstantiationException);
        }
        catch (InvocationTargetException localInvocationTargetException)
        {
          throw new RuntimeException("Cannot create an instance of " + paramClass, localInvocationTargetException);
        }
      }
      return super.a(paramClass);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/c/d/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */