package com.baidu.speech.core;

public abstract class BDSParamBase
{
  public String iParamType;
  
  public static BDSBooleanParam boolParam(boolean paramBoolean)
  {
    return new BDSBooleanParam(paramBoolean);
  }
  
  public static BDSFloatParam floatParam(float paramFloat)
  {
    return new BDSFloatParam(paramFloat);
  }
  
  public static BDSIntParam intParam(int paramInt)
  {
    return new BDSIntParam(paramInt);
  }
  
  public static BDSObjectParam objectParam(Object paramObject, String paramString)
  {
    paramObject = new BDSObjectParam(paramObject);
    if (paramString.length() > 0) {
      ((BDSObjectParam)paramObject).iParamType = paramString;
    }
    return (BDSObjectParam)paramObject;
  }
  
  public static class BDSBooleanParam
    extends BDSParamBase
  {
    public boolean iValue;
    
    public BDSBooleanParam(boolean paramBoolean)
    {
      this.iParamType = "boolean";
      this.iValue = paramBoolean;
    }
  }
  
  public static class BDSFloatParam
    extends BDSParamBase
  {
    public float iValue;
    
    public BDSFloatParam(float paramFloat)
    {
      this.iParamType = "float";
      this.iValue = paramFloat;
    }
  }
  
  public static class BDSIntParam
    extends BDSParamBase
  {
    public int iValue;
    
    public BDSIntParam(int paramInt)
    {
      this.iParamType = "int";
      this.iValue = paramInt;
    }
  }
  
  public static class BDSObjectParam
    extends BDSParamBase
  {
    public Object iValue;
    
    public BDSObjectParam(Object paramObject)
    {
      this.iParamType = "object";
      this.iValue = paramObject;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/speech/core/BDSParamBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */