package com.baidu.navi.driveanalysis;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import com.baidu.carlife.BaiduNaviApplication;
import com.baidu.carlife.core.j;
import com.baidu.carlife.e.a;

public class TrackDataUpload
{
  public static TrackDataUpload mInstance;
  private DataService.DataUploadBinder mBinder;
  private Context mContext = BaiduNaviApplication.getInstance().getApplicationContext();
  private MsgRomoteConfigSyncHandler mMsgRomoteConfigSyncHandler;
  private ServiceConnection mServiceConnection;
  
  public static TrackDataUpload getInstance()
  {
    if (mInstance == null) {
      mInstance = new TrackDataUpload();
    }
    return mInstance;
  }
  
  private void init()
  {
    this.mServiceConnection = new ServiceConnection()
    {
      public void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
      {
        TrackDataUpload.access$002(TrackDataUpload.this, (DataService.DataUploadBinder)paramAnonymousIBinder);
        TrackDataUpload.this.mBinder.startUpload();
      }
      
      public void onServiceDisconnected(ComponentName paramAnonymousComponentName) {}
    };
    this.mContext.bindService(new Intent(this.mContext, DataService.class), this.mServiceConnection, 1);
  }
  
  public void startTrackDataUpload()
  {
    if (a.a().i() != 1) {
      return;
    }
    init();
  }
  
  public void stopTrackDataUpload()
  {
    if (this.mBinder != null)
    {
      this.mBinder.stopUpload();
      this.mContext.unbindService(this.mServiceConnection);
    }
  }
  
  private class MsgRomoteConfigSyncHandler
    extends j
  {
    private MsgRomoteConfigSyncHandler() {}
    
    public void careAbout()
    {
      addMsg(6001);
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      }
      do
      {
        return;
      } while (a.a().i() != 1);
      TrackDataUpload.this.startTrackDataUpload();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/driveanalysis/TrackDataUpload.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */