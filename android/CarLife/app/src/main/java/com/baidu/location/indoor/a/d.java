package com.baidu.location.indoor.a;

import android.os.Bundle;
import com.baidu.location.BDLocation;
import com.indooratlas.android.sdk.IALocation;
import com.indooratlas.android.sdk.IALocationListener;
import com.indooratlas.android.sdk.IARegion;
import com.indooratlas.android.sdk.IARegion.Listener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

class d
  implements IALocationListener, IARegion.Listener
{
  private c a;
  private String b = null;
  
  d(c paramc)
  {
    this.a = paramc;
  }
  
  public void onEnterRegion(IARegion paramIARegion)
  {
    if ((paramIARegion != null) && (paramIARegion.getType() == 1)) {
      this.b = paramIARegion.getName().toLowerCase(Locale.US);
    }
  }
  
  public void onExitRegion(IARegion paramIARegion) {}
  
  public void onLocationChanged(IALocation paramIALocation)
  {
    BDLocation localBDLocation = new BDLocation();
    localBDLocation.setLocType(161);
    localBDLocation.setNetworkLocationType("ml");
    localBDLocation.setBuildingID(this.a.f());
    localBDLocation.setFloor(this.a.g());
    if ((this.b != null) && (this.a.g() != null) && (!this.b.equals(this.a.g()))) {
      localBDLocation.setFloor(this.b);
    }
    localBDLocation.setLongitude(paramIALocation.getLongitude());
    localBDLocation.setLatitude(paramIALocation.getLatitude());
    localBDLocation.setRadius(paramIALocation.getAccuracy());
    localBDLocation.setIndoorLocMode(true);
    localBDLocation.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date(System.currentTimeMillis())));
    this.a.a(localBDLocation);
  }
  
  public void onStatusChanged(String paramString, int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    case 0: 
    case 1: 
    case 10: 
    default: 
      return;
    case 11: 
      switch (paramBundle.getInt("quality"))
      {
      default: 
        return;
      case 0: 
        return;
      case 1: 
        return;
      }
      return;
    }
    this.b = null;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/indoor/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */