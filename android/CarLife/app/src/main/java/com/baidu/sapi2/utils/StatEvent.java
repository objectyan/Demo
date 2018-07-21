package com.baidu.sapi2.utils;

public enum StatEvent
{
  String a;
  String b;
  
  static
  {
    OP_LOGIN = new StatEvent("OP_LOGIN", 1, "num_login_va", "/v2/sapi/login");
    PV_SMS_LOGIN = new StatEvent("PV_SMS_LOGIN", 2, "pv_slogin", "/v2/sapi/getdpass");
    OP_SMS_LOGIN = new StatEvent("OP_SMS_LOGIN", 3, "num_slogin_va", "/v2/sapi/getdpass");
    PV_REG = new StatEvent("PV_REG", 4, "pv_reg", "/v2/sapi/applyregcode");
    OP_REG = new StatEvent("OP_REG", 5, "num_reg_va", "/v2/sapi/applyregcode");
    PV_QUICK_USER_REG = new StatEvent("PV_QUICK_USER_REG", 6, "pv_qreg", "/v2/sapi/reg/quick");
  }
  
  private StatEvent(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/sapi2/utils/StatEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */