package com.baidu.navi.track.model;

public class NaviPoint
{
  private String addr = "";
  private boolean hasAddr;
  private boolean hasLat;
  private boolean hasLng;
  private double lat = 0.0D;
  private double lng = 0.0D;
  
  public NaviPoint clear()
  {
    clearLng();
    clearLat();
    clearAddr();
    return this;
  }
  
  public NaviPoint clearAddr()
  {
    this.hasAddr = false;
    this.addr = "";
    return this;
  }
  
  public NaviPoint clearLat()
  {
    this.hasLat = false;
    this.lat = 0.0D;
    return this;
  }
  
  public NaviPoint clearLng()
  {
    this.hasLng = false;
    this.lng = 0.0D;
    return this;
  }
  
  public String getAddr()
  {
    return this.addr;
  }
  
  public double getLat()
  {
    return this.lat;
  }
  
  public double getLng()
  {
    return this.lng;
  }
  
  public boolean hadAddr()
  {
    return this.hasAddr;
  }
  
  public boolean hasLat()
  {
    return this.hasLat;
  }
  
  public boolean hasLng()
  {
    return this.hasLng;
  }
  
  public NaviPoint setAddr(String paramString)
  {
    this.hasAddr = true;
    this.addr = paramString;
    return this;
  }
  
  public NaviPoint setLat(double paramDouble)
  {
    this.hasLat = true;
    this.lat = paramDouble;
    return this;
  }
  
  public NaviPoint setLng(double paramDouble)
  {
    this.hasLng = true;
    this.lng = paramDouble;
    return this;
  }
  
  public String toString()
  {
    return "NaviPoint [addr=" + this.addr + ", lng=" + this.lng + ", lat=" + this.lat + "]";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/track/model/NaviPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */