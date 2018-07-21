package com.baidu.sapi2.utils.enums;

public enum Domain
{
  private String a;
  private String b;
  private String c;
  private String d;
  private String e;
  private boolean f;
  
  private Domain(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
    this.e = paramString5;
  }
  
  public Domain forceHttps(boolean paramBoolean)
  {
    this.f = paramBoolean;
    return this;
  }
  
  public String getConfigUrl()
  {
    return this.d;
  }
  
  public String getDeviceUrl()
  {
    return this.c;
  }
  
  public String getPortraitUrl()
  {
    return this.e;
  }
  
  public String getURL()
  {
    if (this.f) {
      return this.a.replace("http://", "https://");
    }
    return this.a;
  }
  
  public String getWap()
  {
    if (this.f) {
      return this.b.replace("http://", "https://");
    }
    return this.b;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/sapi2/utils/enums/Domain.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */