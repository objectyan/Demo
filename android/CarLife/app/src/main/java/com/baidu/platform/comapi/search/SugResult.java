package com.baidu.platform.comapi.search;

public class SugResult
  implements ResultBase
{
  private String[] cityid;
  private String[] distance;
  public boolean ispinyin;
  public String keyword;
  public int mResultType;
  private String[] poiname;
  private int requestId;
  private String[] subtitle;
  public int type;
  
  public String getCityid(int paramInt)
  {
    if (this.cityid.length > paramInt) {
      return this.cityid[paramInt];
    }
    return null;
  }
  
  public String[] getCityid()
  {
    return this.cityid;
  }
  
  public String getPoiname(int paramInt)
  {
    if (this.poiname.length > paramInt) {
      return this.poiname[paramInt];
    }
    return null;
  }
  
  public String[] getPoiname()
  {
    return this.poiname;
  }
  
  public int getRequestId()
  {
    return this.requestId;
  }
  
  public String getSubtitle(int paramInt)
  {
    if (this.subtitle.length > paramInt) {
      return this.subtitle[paramInt];
    }
    return null;
  }
  
  public String[] getSubtitle(String[] paramArrayOfString)
  {
    return paramArrayOfString;
  }
  
  public void setCityid(String[] paramArrayOfString)
  {
    this.cityid = paramArrayOfString;
  }
  
  public void setDistance(String[] paramArrayOfString)
  {
    this.distance = paramArrayOfString;
  }
  
  public void setPoiname(String[] paramArrayOfString)
  {
    this.poiname = paramArrayOfString;
  }
  
  public void setRequestId(int paramInt)
  {
    this.requestId = paramInt;
  }
  
  public void setSubtitle(String[] paramArrayOfString)
  {
    this.subtitle = paramArrayOfString;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/search/SugResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */