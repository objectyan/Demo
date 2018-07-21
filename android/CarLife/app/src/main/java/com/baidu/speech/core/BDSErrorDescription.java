package com.baidu.speech.core;

public class BDSErrorDescription
{
  public int errorCode;
  public String errorDescription;
  public int errorDomain;
  
  public int getDetailCode()
  {
    return this.errorDomain << 16 | 0xFFFF & this.errorCode;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/speech/core/BDSErrorDescription.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */