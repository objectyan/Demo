package com.baidu.navisdk.util.logic;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.baidu.navisdk.comapi.base.BNLogicController;
import com.baidu.navisdk.comapi.geolocate.ISensorChangeListener;
import com.baidu.navisdk.comapi.geolocate.ISensorDataChangeListener;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.model.datastruct.SensorData;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.SensorAlgoFilter;
import java.util.ArrayList;
import java.util.Iterator;

public class BNSysSensorManager
  extends BNLogicController
{
  public static final int SENSORFINGER_TYPE_ACCELEROMETER = 1;
  public static final int SENSORFINGER_TYPE_GRAVITY = 2;
  public static final int SENSORFINGER_TYPE_GYROSCOPE = 3;
  public static final int SENSORFINGER_TYPE_INVALID = 0;
  public static final int SENSORFINGER_TYPE_MAGNETOMETER = 5;
  public static final int SENSORFINGER_TYPE_ORIENTATION = 4;
  private static final String TAG = "Location";
  private static volatile BNSysSensorManager mInstance = null;
  private float[] accelerometerValues = new float[3];
  private boolean isSensorFingerInitialized = false;
  private boolean isSensorInitialized = false;
  private SensorData mCurSensor = new SensorData();
  private ArrayList<ISensorDataChangeListener> mSensorDataObservers = new ArrayList();
  private SensorEventListener mSensorEventListener = new SensorEventListener()
  {
    public void onAccuracyChanged(Sensor paramAnonymousSensor, int paramAnonymousInt) {}
    
    public void onSensorChanged(SensorEvent paramAnonymousSensorEvent)
    {
      float[] arrayOfFloat = (float[])paramAnonymousSensorEvent.values.clone();
      int i = paramAnonymousSensorEvent.sensor.getType();
      if (i == 3)
      {
        synchronized (BNSysSensorManager.this.mTmpSensor)
        {
          if (BNSysSensorManager.this.accelerometerValues == null) {
            return;
          }
          BNSysSensorManager.this.mTmpSensor.accx = BNSysSensorManager.this.accelerometerValues[0];
          BNSysSensorManager.this.mTmpSensor.accy = BNSysSensorManager.this.accelerometerValues[1];
          BNSysSensorManager.this.mTmpSensor.accz = BNSysSensorManager.this.accelerometerValues[2];
          BNSysSensorManager.this.mTmpSensor.heading = arrayOfFloat[0];
          BNSysSensorManager.this.mTmpSensor.pitch = (-arrayOfFloat[2]);
          BNSysSensorManager.this.mTmpSensor.roll = (-arrayOfFloat[1]);
          BNSysSensorManager.access$202(BNSysSensorManager.this, BNSysSensorManager.this.mTmpSensor.clone());
          Iterator localIterator = BNSysSensorManager.this.mSensorDataObservers.iterator();
          if (localIterator.hasNext()) {
            ((ISensorDataChangeListener)localIterator.next()).onSensorDataChange(BNSysSensorManager.this.mCurSensor);
          }
        }
        int j = (int)BNSysSensorManager.this.mSensorFilter.execute(paramAnonymousSensorEvent.values[0]);
        paramAnonymousSensorEvent = BNSysSensorManager.this.mSensorObservers.iterator();
        while (paramAnonymousSensorEvent.hasNext()) {
          ((ISensorChangeListener)paramAnonymousSensorEvent.next()).onSensorChange(j);
        }
      }
      if (i == 1) {
        BNSysSensorManager.access$102(BNSysSensorManager.this, (float[])arrayOfFloat.clone());
      }
    }
  };
  private SensorAlgoFilter mSensorFilter = new SensorAlgoFilter();
  private SensorEventListener mSensorFingerEventListener = new SensorEventListener()
  {
    public void onAccuracyChanged(Sensor paramAnonymousSensor, int paramAnonymousInt) {}
    
    public void onSensorChanged(SensorEvent paramAnonymousSensorEvent)
    {
      float[] arrayOfFloat = (float[])paramAnonymousSensorEvent.values.clone();
      int k = paramAnonymousSensorEvent.sensor.getType();
      int j = 0;
      int i = j;
      switch (k)
      {
      default: 
        i = j;
      }
      for (;;)
      {
        if (i != 0) {
          BNRouteGuider.getInstance().triggerRecordSensorData(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2], i);
        }
        return;
        i = 1;
        continue;
        i = 2;
        continue;
        i = 3;
        continue;
        i = 4;
        continue;
        i = 5;
        continue;
        BNRoutePlaner.getInstance().triggerPressureChange(arrayOfFloat[0]);
        i = 0;
      }
    }
  };
  private SensorManager mSensorManager = null;
  private ArrayList<ISensorChangeListener> mSensorObservers = new ArrayList();
  private SensorData mTmpSensor = new SensorData();
  
  public static void destory()
  {
    if (mInstance != null) {
      mInstance.uninitSensor();
    }
    mInstance = null;
  }
  
  public static BNSysSensorManager getInstance()
  {
    if (mInstance == null) {
      mInstance = new BNSysSensorManager();
    }
    return mInstance;
  }
  
  public void addSensorChangeListener(ISensorChangeListener paramISensorChangeListener)
  {
    synchronized (this.mSensorObservers)
    {
      if (!this.mSensorObservers.contains(paramISensorChangeListener)) {
        this.mSensorObservers.add(paramISensorChangeListener);
      }
      return;
    }
  }
  
  public void addSensorDataChangeListener(ISensorDataChangeListener paramISensorDataChangeListener)
  {
    this.mSensorDataObservers.add(paramISensorDataChangeListener);
  }
  
  public void initSensor(Context paramContext)
  {
    try
    {
      if (this.mSensorManager == null) {
        this.mSensorManager = ((SensorManager)paramContext.getSystemService("sensor"));
      }
      if (!this.isSensorInitialized)
      {
        LogUtil.e("Location", "[system] initSensor");
        paramContext = this.mSensorManager.getDefaultSensor(1);
        this.mSensorManager.registerListener(this.mSensorEventListener, paramContext, 3);
        paramContext = this.mSensorManager.getDefaultSensor(3);
        this.mSensorManager.registerListener(this.mSensorEventListener, paramContext, 3);
        this.isSensorInitialized = true;
      }
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public void initSensorFinger(Context paramContext)
  {
    try
    {
      if (this.mSensorManager == null) {
        this.mSensorManager = ((SensorManager)paramContext.getSystemService("sensor"));
      }
      if (!this.isSensorFingerInitialized)
      {
        LogUtil.e("Location", "[SensorFinger] initSensorFinger");
        paramContext = this.mSensorManager.getDefaultSensor(1);
        this.mSensorManager.registerListener(this.mSensorFingerEventListener, paramContext, 3);
        paramContext = this.mSensorManager.getDefaultSensor(9);
        this.mSensorManager.registerListener(this.mSensorFingerEventListener, paramContext, 3);
        paramContext = this.mSensorManager.getDefaultSensor(4);
        this.mSensorManager.registerListener(this.mSensorFingerEventListener, paramContext, 3);
        paramContext = this.mSensorManager.getDefaultSensor(3);
        this.mSensorManager.registerListener(this.mSensorFingerEventListener, paramContext, 3);
        paramContext = this.mSensorManager.getDefaultSensor(2);
        this.mSensorManager.registerListener(this.mSensorFingerEventListener, paramContext, 3);
        paramContext = this.mSensorManager.getDefaultSensor(6);
        if (paramContext != null) {
          this.mSensorManager.registerListener(this.mSensorFingerEventListener, paramContext, 3);
        }
        this.isSensorFingerInitialized = true;
      }
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public void removeSensorChangeListener(ISensorChangeListener paramISensorChangeListener)
  {
    synchronized (this.mSensorObservers)
    {
      this.mSensorObservers.remove(paramISensorChangeListener);
      return;
    }
  }
  
  public void removeSensorDataChangeListener(ISensorDataChangeListener paramISensorDataChangeListener)
  {
    this.mSensorDataObservers.remove(paramISensorDataChangeListener);
  }
  
  public void uninitSensor()
  {
    try
    {
      if ((this.mSensorManager != null) && (this.isSensorInitialized))
      {
        LogUtil.e("Location", "[system] uninitSensor");
        this.mSensorManager.unregisterListener(this.mSensorEventListener);
        this.isSensorInitialized = false;
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void uninitSensorFinger()
  {
    try
    {
      if ((this.mSensorManager != null) && (this.isSensorFingerInitialized))
      {
        LogUtil.e("Location", "[SensorFinger] uninitSensorFinger");
        this.mSensorManager.unregisterListener(this.mSensorFingerEventListener);
        this.isSensorFingerInitialized = false;
      }
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/logic/BNSysSensorManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */