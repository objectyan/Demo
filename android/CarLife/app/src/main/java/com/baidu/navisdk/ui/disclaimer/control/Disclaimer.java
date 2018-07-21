package com.baidu.navisdk.ui.disclaimer.control;

import java.io.Serializable;

public class Disclaimer
  implements Serializable
{
  private final int mLayoutId;
  private final Type mType;
  
  Disclaimer(Type paramType, int paramInt)
  {
    this.mType = paramType;
    this.mLayoutId = paramInt;
  }
  
  public int getLayoutId()
  {
    return this.mLayoutId;
  }
  
  public Type getType()
  {
    return this.mType;
  }
  
  public static enum Type
  {
    INTERNATIONAL("international");
    
    String mName;
    
    private Type(String paramString)
    {
      this.mName = paramString;
    }
    
    public String getName()
    {
      return this.mName;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/disclaimer/control/Disclaimer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */