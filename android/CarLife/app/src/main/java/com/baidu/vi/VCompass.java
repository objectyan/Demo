package com.baidu.vi;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Message;
import java.util.List;

public class VCompass
{
  private static final int MSG_INIT_COMPASS = 1;
  private static final int MSG_UNINIT_COMPASS = 2;
  private static final Handler mHandler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      VCompass localVCompass = (VCompass)paramAnonymousMessage.obj;
      if (localVCompass == null) {}
      do
      {
        return;
        switch (paramAnonymousMessage.what)
        {
        default: 
          return;
        case 1: 
          paramAnonymousMessage = VIContext.getContext();
          if (VCompass.a(localVCompass) == null) {
            VCompass.a(localVCompass, (SensorManager)paramAnonymousMessage.getSystemService("sensor"));
          }
          paramAnonymousMessage = VCompass.a(localVCompass).getSensorList(3);
        }
      } while (paramAnonymousMessage.size() <= 0);
      paramAnonymousMessage = (Sensor)paramAnonymousMessage.get(0);
      VCompass.a(localVCompass).registerListener(VCompass.b(localVCompass), paramAnonymousMessage, 1);
      return;
      VCompass.a(localVCompass).unregisterListener(VCompass.b(localVCompass));
    }
  };
  private SensorEventListener mEventListener = new SensorEventListener()
  {
    public void onAccuracyChanged(Sensor paramAnonymousSensor, int paramAnonymousInt) {}
    
    public void onSensorChanged(SensorEvent paramAnonymousSensorEvent)
    {
      switch (paramAnonymousSensorEvent.sensor.getType())
      {
      default: 
        return;
      }
      int i = (int)VCompass.a(VCompass.this, paramAnonymousSensorEvent.values[0]);
      VCompass.a(VCompass.this, i);
    }
  };
  private int mJniData = 0;
  private SensorManager mSensorManager = null;
  private float myBarrier = 2.0F;
  private float oldV;
  
  private float checkAndCalc(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f2 = paramFloat1 - paramFloat2;
    float f1;
    if ((f2 > 180.0F) || (f2 < -180.0F)) {
      f1 = paramFloat2;
    }
    do
    {
      return f1;
      if (f2 < -paramFloat3) {
        break;
      }
      f1 = paramFloat1;
    } while (paramFloat3 >= f2);
    return (paramFloat1 + paramFloat2) / 2.0F;
  }
  
  private float execute(float paramFloat)
  {
    this.oldV = checkAndCalc(this.oldV, paramFloat, this.myBarrier);
    return this.oldV;
  }
  
  private void init()
  {
    mHandler.removeMessages(1);
    mHandler.sendMessage(mHandler.obtainMessage(1, this));
  }
  
  private void unInit()
  {
    mHandler.removeMessages(2);
    mHandler.sendMessage(mHandler.obtainMessage(2, this));
  }
  
  private native void updateCompass(int paramInt);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/vi/VCompass.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */