package android.support.v4.app;

import android.app.Dialog;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import android.view.Window;

public class Service
  extends android.app.Service
  implements OnFragmentListener
{
  static final int MSG_REALLY_STOPPED = 1;
  static final int MSG_RESUME_PENDING = 2;
  boolean mCreated;
  final FragmentController mFragments = FragmentController.createController(new ServiceHostCallbacks(this));
  final Handler mHandler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
        super.handleMessage(paramAnonymousMessage);
      case 1: 
        do
        {
          return;
        } while (!Service.this.mStopped);
        Service.this.doReallyStop(false);
        return;
      }
      Service.this.onResumeFragments();
      Service.this.mFragments.execPendingActions();
    }
  };
  boolean mReallyStopped;
  boolean mResumed;
  boolean mRetaining;
  boolean mStopped;
  
  public void attachHost()
  {
    this.mFragments.attachHost(null);
  }
  
  public void bindDialog(Dialog paramDialog)
  {
    this.mFragments.bindDialog(paramDialog);
  }
  
  void doReallyStop(boolean paramBoolean)
  {
    if (!this.mReallyStopped)
    {
      this.mReallyStopped = true;
      this.mRetaining = paramBoolean;
      this.mHandler.removeMessages(1);
      onReallyStop();
    }
  }
  
  public FragmentManager getSupportFragmentManager()
  {
    return this.mFragments.getSupportFragmentManager();
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    this.mReallyStopped = false;
    this.mStopped = false;
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onFragmentStart()
  {
    this.mFragments.onFragmentStart();
  }
  
  public void onFragmentStop()
  {
    this.mFragments.onFragmentStop();
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
    this.mFragments.dispatchLowMemory();
  }
  
  void onReallyStop()
  {
    this.mFragments.doLoaderStop(this.mRetaining);
    this.mFragments.dispatchReallyStop();
  }
  
  public void onRebind(Intent paramIntent)
  {
    super.onRebind(paramIntent);
  }
  
  protected void onResumeFragments()
  {
    this.mFragments.dispatchResume();
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    this.mReallyStopped = true;
    this.mStopped = true;
    return super.onUnbind(paramIntent);
  }
  
  public void setFragmentWindow(Window paramWindow)
  {
    Log.v("FragmentManager", "Service setFragmentWindow window=" + paramWindow);
    this.mFragments.setFragmentWindow(paramWindow);
  }
  
  public void setVehicleConnected(boolean paramBoolean)
  {
    Log.v("FragmentManager", "Service setVehicleConnected vehicleConnected=" + paramBoolean);
    this.mFragments.setVehicleConnected(paramBoolean);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/android/support/v4/app/Service.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */