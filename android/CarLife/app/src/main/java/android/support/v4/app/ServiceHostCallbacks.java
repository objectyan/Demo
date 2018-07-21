package android.support.v4.app;

import android.app.Dialog;
import android.content.Intent;
import android.support.v4.util.SimpleArrayMap;
import android.util.AndroidRuntimeException;
import android.util.Log;
import android.view.LayoutInflater;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class ServiceHostCallbacks
  extends FragmentHostCallback<Service>
{
  private static final String TAG = "FragmentManager";
  private Dialog mDialog;
  private Service mService;
  
  public ServiceHostCallbacks(Service paramService)
  {
    super(paramService, paramService.mHandler, 0);
    this.mService = paramService;
  }
  
  public void bindDialog(Dialog paramDialog)
  {
    this.mDialog = paramDialog;
  }
  
  void doLoaderDestroy() {}
  
  void doLoaderRetain() {}
  
  void doLoaderStart()
  {
    if (FragmentManagerImpl.DEBUG) {
      Log.v("FragmentManager", " doLoaderStart()");
    }
  }
  
  void doLoaderStop(boolean paramBoolean) {}
  
  void dumpLoaders(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {}
  
  LoaderManagerImpl getLoaderManagerImpl()
  {
    throw new AndroidRuntimeException("ServiceHostCallbacks not support LoaderMangerImpl");
  }
  
  void inactivateFragment(String paramString) {}
  
  public Service onGetHost()
  {
    return this.mService;
  }
  
  public LayoutInflater onGetLayoutInflater()
  {
    if (FragmentManagerImpl.DEBUG) {
      Log.v("FragmentManager", "ServiceHostCallbacks onGetLayoutInflater");
    }
    return this.mDialog.getLayoutInflater().cloneInContext(this.mDialog.getContext());
  }
  
  public void onStartActivityFromFragment(Fragment paramFragment, Intent paramIntent, int paramInt)
  {
    throw new AndroidRuntimeException("ServiceHostCallbacks not support onStartActivityFromFragment() method.");
  }
  
  void reportLoaderStart() {}
  
  void restoreLoaderNonConfig(SimpleArrayMap<String, LoaderManager> paramSimpleArrayMap) {}
  
  SimpleArrayMap<String, LoaderManager> retainLoaderNonConfig()
  {
    return new SimpleArrayMap();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/android/support/v4/app/ServiceHostCallbacks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */