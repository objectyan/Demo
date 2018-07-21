package com.baidu.che.codriver.platform.navi;

import com.baidu.che.codriver.util.INoProguard;

public class NaviAddressData
  implements INoProguard
{
  private String address;
  private String lat;
  private String lng;
  private String name;
  private String type;
  
  public String getAddress()
  {
    return this.address;
  }
  
  public String getLat()
  {
    return this.lat;
  }
  
  public String getLng()
  {
    return this.lng;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getType()
  {
    return this.type;
  }
  
  public void setAddress(String paramString)
  {
    this.address = paramString;
  }
  
  public void setLat(String paramString)
  {
    this.lat = paramString;
  }
  
  public void setLng(String paramString)
  {
    this.lng = paramString;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setType(String paramString)
  {
    this.type = paramString;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/platform/navi/NaviAddressData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */