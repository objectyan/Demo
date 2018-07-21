package com.baidu.vi;

import android.content.Context;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.GpsStatus.Listener;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import java.util.Iterator;

public class VGps
{
  private static int GPS_VALID_SAT_QUANTITY = 3;
  private static final int MSG_INIT_GPS = 2;
  private static final int MSG_INVALID_GPS = 1;
  private static final int MSG_UNINIT_GPS = 3;
  private static Handler mHandler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      VGps localVGps = (VGps)paramAnonymousMessage.obj;
      if (localVGps == null) {}
      do
      {
        do
        {
          do
          {
            return;
            switch (paramAnonymousMessage.what)
            {
            default: 
              return;
            }
          } while (VGps.c(localVGps) >= VGps.a());
          localVGps.updateGps(0.0D, 0.0D, 0.0F, 0.0F, 0.0F, 0);
          return;
        } while (VIContext.getContext() == null);
        VGps.a(localVGps, (LocationManager)VIContext.getContext().getSystemService("location"));
        VGps.a(localVGps).addGpsStatusListener(VGps.e(localVGps));
        return;
      } while (VGps.a(localVGps) == null);
      VGps.a(localVGps).removeGpsStatusListener(VGps.e(localVGps));
      VGps.a(localVGps).removeUpdates(VGps.f(localVGps));
    }
  };
  private int mGpsSatellitesNum = 0;
  private GpsStatus mGpsStatus = null;
  private int mJniData = 0;
  private LocationListener mLocationListener = new LocationListener()
  {
    public void onLocationChanged(Location paramAnonymousLocation)
    {
      if (paramAnonymousLocation != null)
      {
        float f = 0.0F;
        if (paramAnonymousLocation.hasAccuracy()) {
          f = paramAnonymousLocation.getAccuracy();
        }
        if (VGps.c(VGps.this) >= VGps.a()) {
          VGps.this.updateGps(paramAnonymousLocation.getLongitude(), paramAnonymousLocation.getLatitude(), (float)(paramAnonymousLocation.getSpeed() * 3.6D), paramAnonymousLocation.getBearing(), f, VGps.c(VGps.this));
        }
      }
      else
      {
        return;
      }
      VGps.d(VGps.this);
    }
    
    public void onProviderDisabled(String paramAnonymousString)
    {
      VGps.this.updateGps(0.0D, 0.0D, 0.0F, 0.0F, 0.0F, 0);
    }
    
    public void onProviderEnabled(String paramAnonymousString) {}
    
    public void onStatusChanged(String paramAnonymousString, int paramAnonymousInt, Bundle paramAnonymousBundle)
    {
      switch (paramAnonymousInt)
      {
      default: 
        return;
      }
      VGps.this.updateGps(0.0D, 0.0D, 0.0F, 0.0F, 0.0F, 0);
    }
  };
  private LocationManager mLocationManager = null;
  private GpsStatus.Listener mStatusListener = new GpsStatus.Listener()
  {
    public void onGpsStatusChanged(int paramAnonymousInt)
    {
      switch (paramAnonymousInt)
      {
      case 3: 
      default: 
        return;
      case 4: 
        if (VGps.a(VGps.this) != null)
        {
          if (VGps.b(VGps.this) != null) {
            break label117;
          }
          VGps.a(VGps.this, VGps.a(VGps.this).getGpsStatus(null));
        }
        for (;;)
        {
          Iterator localIterator = VGps.b(VGps.this).getSatellites().iterator();
          paramAnonymousInt = 0;
          while (localIterator.hasNext()) {
            if (((GpsSatellite)localIterator.next()).usedInFix()) {
              paramAnonymousInt += 1;
            }
          }
          label117:
          VGps.a(VGps.this).getGpsStatus(VGps.b(VGps.this));
        }
        if ((paramAnonymousInt < VGps.a()) && (VGps.c(VGps.this) >= VGps.a())) {
          VGps.d(VGps.this);
        }
        VGps.a(VGps.this, paramAnonymousInt);
        return;
      }
      VGps.this.updateGps(0.0D, 0.0D, 0.0F, 0.0F, 0.0F, 0);
    }
  };
  
  private void delayInvalidGPS()
  {
    try
    {
      if (!mHandler.hasMessages(1))
      {
        Message localMessage = mHandler.obtainMessage(1, this);
        mHandler.sendMessageDelayed(localMessage, 3000L);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int getGpsSatellitesNum()
  {
    return this.mGpsSatellitesNum;
  }
  
  public boolean init()
  {
    mHandler.removeMessages(2);
    mHandler.sendMessage(mHandler.obtainMessage(2, this));
    return true;
  }
  
  public boolean unInit()
  {
    mHandler.removeMessages(1);
    mHandler.removeMessages(3);
    mHandler.sendMessage(mHandler.obtainMessage(3, this));
    return true;
  }
  
  public native void updateGps(double paramDouble1, double paramDouble2, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/vi/VGps.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */