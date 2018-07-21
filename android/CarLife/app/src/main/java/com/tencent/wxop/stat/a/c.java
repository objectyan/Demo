package com.tencent.wxop.stat.a;

import java.util.Properties;
import org.json.JSONArray;
import org.json.JSONObject;

public class c
{
  public String a;
  public JSONArray b;
  public JSONObject c = null;
  
  public c() {}
  
  public c(String paramString, String[] paramArrayOfString, Properties paramProperties)
  {
    this.a = paramString;
    if (paramProperties != null) {
      this.c = new JSONObject(paramProperties);
    }
    for (;;)
    {
      return;
      if (paramArrayOfString == null) {
        break;
      }
      this.b = new JSONArray();
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        paramString = paramArrayOfString[i];
        this.b.put(paramString);
        i += 1;
      }
    }
    this.c = new JSONObject();
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      if (this == paramObject) {
        return true;
      }
    } while (!(paramObject instanceof c));
    paramObject = (c)paramObject;
    return toString().equals(((c)paramObject).toString());
  }
  
  public int hashCode()
  {
    return toString().hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(32);
    localStringBuilder.append(this.a).append(",");
    if (this.b != null) {
      localStringBuilder.append(this.b.toString());
    }
    if (this.c != null) {
      localStringBuilder.append(this.c.toString());
    }
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/tencent/wxop/stat/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */