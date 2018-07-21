package com.baidu.sapi2.utils.enums;

import android.text.TextUtils;

public enum FastLoginFeature
{
  private String a;
  
  static
  {
    SINA_WEIBO_SSO = new FastLoginFeature("SINA_WEIBO_SSO", 1, "tsina_sso");
    SINA_WEIBO_WEBVIEW = new FastLoginFeature("SINA_WEIBO_WEBVIEW", 2, "tsina");
    TX_WEIBO_WEBVIEW = new FastLoginFeature("TX_WEIBO_WEBVIEW", 3, "tqq");
    TX_QQ_WEBVIEW = new FastLoginFeature("TX_QQ_WEBVIEW", 4, "qzone");
    RENREN_WEBVIEW = new FastLoginFeature("RENREN_WEBVIEW", 5, "renren");
    DEVICE_LOGIN = new FastLoginFeature("DEVICE_LOGIN", 6, "device_login");
    QR_LOGIN = new FastLoginFeature("QR_LOGIN", 7, "qr_app_login");
    NM_LOGIN = new FastLoginFeature("NM_LOGIN", 8, "nuomi_login");
    VOICE_LOGIN = new FastLoginFeature("VOICE_LOGIN", 9, "voice_login");
  }
  
  private FastLoginFeature(String paramString)
  {
    this.a = paramString;
  }
  
  public static FastLoginFeature getDefault()
  {
    return SINA_WEIBO_SSO;
  }
  
  public static FastLoginFeature mapStrToValue(String paramString)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString))
    {
      localObject = getDefault();
      return (FastLoginFeature)localObject;
    }
    FastLoginFeature[] arrayOfFastLoginFeature = values();
    int j = arrayOfFastLoginFeature.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label57;
      }
      FastLoginFeature localFastLoginFeature = arrayOfFastLoginFeature[i];
      localObject = localFastLoginFeature;
      if (paramString.equals(localFastLoginFeature.getStrValue())) {
        break;
      }
      i += 1;
    }
    label57:
    return getDefault();
  }
  
  public String getStrValue()
  {
    return this.a;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/sapi2/utils/enums/FastLoginFeature.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */