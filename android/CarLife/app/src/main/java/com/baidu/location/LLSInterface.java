package com.baidu.location;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

public abstract interface LLSInterface
{
  public abstract double getVersion();
  
  public abstract IBinder onBind(Intent paramIntent);
  
  public abstract void onCreate(Context paramContext);
  
  public abstract void onDestroy();
  
  public abstract int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2);
  
  public abstract void onTaskRemoved(Intent paramIntent);
  
  public abstract boolean onUnBind(Intent paramIntent);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/LLSInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */