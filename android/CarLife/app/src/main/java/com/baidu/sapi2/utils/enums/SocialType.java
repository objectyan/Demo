package com.baidu.sapi2.utils.enums;

public enum SocialType
{
  private int a;
  private String b;
  
  static
  {
    RENREN = new SocialType("RENREN", 1, 1, "人人");
    SINA_WEIBO = new SocialType("SINA_WEIBO", 2, 2, "新浪微博");
    SINA_WEIBO_SSO = new SocialType("SINA_WEIBO_SSO", 3, 2, "新浪微博SSO");
    TENCENT_WEIBO = new SocialType("TENCENT_WEIBO", 4, 4, "腾讯微博");
    QZONE = new SocialType("QZONE", 5, 15, "QQ空间");
    QQ = new SocialType("QQ", 6, 15, "QQ");
    WEIXIN = new SocialType("WEIXIN", 7, 42, "微信");
    HUAWEI = new SocialType("HUAWEI", 8, 45, "华为");
    WANDA_FEIFAN = new SocialType("WANDA_FEIFAN", 9, 46, "万达飞凡");
  }
  
  private SocialType(int paramInt, String paramString)
  {
    this.a = paramInt;
    this.b = paramString;
  }
  
  public static SocialType getSocialType(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return UNKNOWN;
    case 1: 
      return RENREN;
    case 2: 
      return SINA_WEIBO;
    case 4: 
      return TENCENT_WEIBO;
    case 15: 
      return QQ;
    case 42: 
      return WEIXIN;
    case 45: 
      return HUAWEI;
    case 46: 
      return WANDA_FEIFAN;
    }
    return IQIYI;
  }
  
  public String getName()
  {
    return this.b;
  }
  
  public int getType()
  {
    return this.a;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/sapi2/utils/enums/SocialType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */