package com.baidu.navisdk.comapi.geolocate;

import com.baidu.navisdk.model.datastruct.LocData;

public abstract interface ILocationListener
{
  public abstract void onGpsStatusChange(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void onLocationChange(LocData paramLocData);
  
  public abstract void onWGS84LocationChange(LocData paramLocData1, LocData paramLocData2);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/comapi/geolocate/ILocationListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */