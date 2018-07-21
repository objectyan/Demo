package com.baidu.platform.comapi.util;

import org.json.JSONObject;

public class JsonBuilder
{
  private StringBuilder a = new StringBuilder();
  private boolean b = false;
  
  private void a()
  {
    if (this.b) {
      this.a.append(",");
    }
  }
  
  private void b()
  {
    this.b = false;
  }
  
  private void c()
  {
    this.b = true;
  }
  
  public JsonBuilder arrayValue()
  {
    a();
    this.a.append("[");
    b();
    return this;
  }
  
  public JsonBuilder endArrayValue()
  {
    this.a.append("]");
    c();
    return this;
  }
  
  public JsonBuilder endObject()
  {
    this.a.append("}");
    c();
    return this;
  }
  
  public String getJson()
  {
    return this.a.toString();
  }
  
  public JsonBuilder key(String paramString)
  {
    a();
    this.a.append(JSONObject.quote(paramString));
    this.a.append(":");
    b();
    return this;
  }
  
  public JsonBuilder object()
  {
    a();
    this.a.append("{");
    b();
    return this;
  }
  
  public JsonBuilder objectValue(String paramString)
  {
    a();
    this.a.append(paramString);
    c();
    return this;
  }
  
  public JsonBuilder putObjectValue(String paramString1, String paramString2)
  {
    if (paramString2 != null) {
      key(paramString1).objectValue(paramString2);
    }
    return this;
  }
  
  public JsonBuilder putStringValue(String paramString1, String paramString2)
  {
    if (paramString2 != null) {
      key(paramString1).value(paramString2);
    }
    return this;
  }
  
  public void reset()
  {
    this.a.setLength(0);
    this.b = false;
  }
  
  public String toString()
  {
    return getJson();
  }
  
  public JsonBuilder value(double paramDouble)
  {
    a();
    this.a.append(String.format("%f", new Object[] { Double.valueOf(paramDouble) }));
    c();
    return this;
  }
  
  public JsonBuilder value(int paramInt)
  {
    a();
    this.a.append(paramInt);
    c();
    return this;
  }
  
  public JsonBuilder value(long paramLong)
  {
    a();
    this.a.append(paramLong);
    c();
    return this;
  }
  
  public JsonBuilder value(Object paramObject)
  {
    if ((paramObject instanceof Number))
    {
      Number localNumber = (Number)paramObject;
      if ((paramObject instanceof Byte)) {
        return value(localNumber.byteValue());
      }
      if ((paramObject instanceof Short)) {
        return value(localNumber.shortValue());
      }
      if ((paramObject instanceof Integer)) {
        return value(localNumber.intValue());
      }
      if ((paramObject instanceof Long)) {
        return value(localNumber.longValue());
      }
      if ((paramObject instanceof Float)) {
        return value(localNumber.floatValue());
      }
      if ((paramObject instanceof Double)) {
        return value(localNumber.doubleValue());
      }
    }
    return value(paramObject.toString());
  }
  
  public JsonBuilder value(String paramString)
  {
    a();
    this.a.append(JSONObject.quote(paramString));
    c();
    return this;
  }
  
  public JsonBuilder value(boolean paramBoolean)
  {
    a();
    this.a.append(paramBoolean);
    c();
    return this;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/util/JsonBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */