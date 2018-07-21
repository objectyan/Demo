package android.support.v4.app;

import android.util.Log;

public class FragmentManagerHolder
{
  private static volatile FragmentManagerHolder sInstance = null;
  private FragmentManagerImpl mFragmentManager = null;
  
  private FragmentManagerHolder()
  {
    Log.v("FragmentManager", "FragmentManagerHolder init() mFragmentManager=" + this.mFragmentManager);
  }
  
  public static FragmentManagerHolder getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new FragmentManagerHolder();
      }
      return sInstance;
    }
    finally {}
  }
  
  public void destroy()
  {
    sInstance = null;
  }
  
  public FragmentManagerImpl getFragmentManagerImpl()
  {
    return this.mFragmentManager;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/android/support/v4/app/FragmentManagerHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */