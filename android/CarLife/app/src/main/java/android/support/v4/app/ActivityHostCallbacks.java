package android.support.v4.app;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class ActivityHostCallbacks
  extends FragmentHostCallback<FragmentActivity>
{
  private FragmentActivity activity;
  
  public ActivityHostCallbacks(FragmentActivity paramFragmentActivity)
  {
    super(paramFragmentActivity);
    this.activity = paramFragmentActivity;
    setWindow(paramFragmentActivity.getWindow());
  }
  
  public void onAttachFragment(Fragment paramFragment)
  {
    this.activity.onAttachFragment(paramFragment);
  }
  
  public void onDump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    this.activity.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
  }
  
  @Nullable
  public View onFindViewById(int paramInt)
  {
    return this.activity.findViewById(paramInt);
  }
  
  public FragmentActivity onGetHost()
  {
    return this.activity;
  }
  
  public LayoutInflater onGetLayoutInflater()
  {
    return this.activity.getLayoutInflater().cloneInContext(this.activity);
  }
  
  public int onGetWindowAnimations()
  {
    Window localWindow = this.activity.getWindow();
    if (localWindow == null) {
      return 0;
    }
    return localWindow.getAttributes().windowAnimations;
  }
  
  public boolean onHasView()
  {
    Window localWindow = this.activity.getWindow();
    return (localWindow != null) && (localWindow.peekDecorView() != null);
  }
  
  public boolean onHasWindowAnimations()
  {
    return this.activity.getWindow() != null;
  }
  
  public void onRequestPermissionsFromFragment(@NonNull Fragment paramFragment, @NonNull String[] paramArrayOfString, int paramInt)
  {
    this.activity.requestPermissionsFromFragment(paramFragment, paramArrayOfString, paramInt);
  }
  
  public boolean onShouldSaveFragmentState(Fragment paramFragment)
  {
    return !this.activity.isFinishing();
  }
  
  public boolean onShouldShowRequestPermissionRationale(@NonNull String paramString)
  {
    return ActivityCompat.shouldShowRequestPermissionRationale(this.activity, paramString);
  }
  
  public void onStartActivityFromFragment(Fragment paramFragment, Intent paramIntent, int paramInt)
  {
    this.activity.startActivityFromFragment(paramFragment, paramIntent, paramInt);
  }
  
  public void onSupportInvalidateOptionsMenu()
  {
    this.activity.supportInvalidateOptionsMenu();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/android/support/v4/app/ActivityHostCallbacks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */