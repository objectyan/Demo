package com.baidu.tts.client.model;

import com.baidu.tts.f.g;
import com.baidu.tts.tools.JsonTool;
import org.json.JSONException;
import org.json.JSONObject;

public class LibEngineParams
{
  private String a;
  private String b;
  private String[] c;
  private String[] d;
  private String[] e;
  
  public LibEngineParams(String paramString)
  {
    this.a = paramString;
    try
    {
      paramString = new JSONObject(paramString);
      this.b = paramString.optString(g.aa.b());
      this.c = JsonTool.getStringarray(paramString.optJSONArray(g.k.b()));
      this.d = JsonTool.getStringarray(paramString.optJSONArray(g.F.b()));
      this.e = JsonTool.getStringarray(paramString.optJSONArray(g.l.b()));
      return;
    }
    catch (Exception paramString) {}
  }
  
  public String[] getDomain()
  {
    return this.c;
  }
  
  public JSONObject getJsonResult()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(this.a);
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return null;
  }
  
  public String[] getLanguage()
  {
    return this.d;
  }
  
  public String[] getQuality()
  {
    return this.e;
  }
  
  public String getResult()
  {
    return this.a;
  }
  
  public String getVersion()
  {
    return this.b;
  }
  
  public void setDomain(String[] paramArrayOfString)
  {
    this.c = paramArrayOfString;
  }
  
  public void setLanguage(String[] paramArrayOfString)
  {
    this.d = paramArrayOfString;
  }
  
  public void setQuality(String[] paramArrayOfString)
  {
    this.e = paramArrayOfString;
  }
  
  public void setVersion(String paramString)
  {
    this.b = paramString;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/client/model/LibEngineParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */