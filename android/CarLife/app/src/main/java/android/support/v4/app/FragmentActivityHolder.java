package android.support.v4.app;

public class FragmentActivityHolder
{
  private static FragmentActivityHolder sInstance = new FragmentActivityHolder();
  private FragmentActivity fragmentActivity;
  
  public static FragmentActivityHolder getInstance()
  {
    return sInstance;
  }
  
  public FragmentActivity getFragmentActivity()
  {
    return this.fragmentActivity;
  }
  
  public void setFragmentActivity(FragmentActivity paramFragmentActivity)
  {
    this.fragmentActivity = paramFragmentActivity;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/android/support/v4/app/FragmentActivityHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */