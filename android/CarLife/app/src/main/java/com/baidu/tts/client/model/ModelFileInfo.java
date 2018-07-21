package com.baidu.tts.client.model;

import android.content.Context;
import com.baidu.tts.f.g;
import com.baidu.tts.tools.ResourceTools;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class ModelFileInfo
{
  private String a;
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  
  public void generateAbsPath(Context paramContext)
  {
    this.e = ResourceTools.getModelFileAbsName(paramContext, this.d);
  }
  
  public String getAbsPath()
  {
    return this.e;
  }
  
  public String getLength()
  {
    return this.b;
  }
  
  public String getMd5()
  {
    return this.c;
  }
  
  public String getName()
  {
    return this.d;
  }
  
  public String getServerid()
  {
    return this.a;
  }
  
  public String getUrl()
  {
    return this.f;
  }
  
  public void parseJson(JSONObject paramJSONObject)
  {
    this.a = paramJSONObject.optString(g.i.b());
    this.b = paramJSONObject.optString(g.g.b());
    this.c = paramJSONObject.optString(g.f.b());
    this.d = paramJSONObject.optString(g.o.b());
    this.f = paramJSONObject.optString(g.e.b());
  }
  
  public void setAbsPath(String paramString)
  {
    this.e = paramString;
  }
  
  public void setLength(String paramString)
  {
    this.b = paramString;
  }
  
  public void setMap(Map<String, String> paramMap)
  {
    if ((paramMap == null) || (paramMap.isEmpty())) {
      return;
    }
    this.a = ((String)paramMap.get(g.i.b()));
    this.b = ((String)paramMap.get(g.g.b()));
    this.c = ((String)paramMap.get(g.f.b()));
    this.d = ((String)paramMap.get(g.o.b()));
    this.e = ((String)paramMap.get(g.h.b()));
  }
  
  public void setMd5(String paramString)
  {
    this.c = paramString;
  }
  
  public void setName(String paramString)
  {
    this.d = paramString;
  }
  
  public void setServerid(String paramString)
  {
    this.a = paramString;
  }
  
  public void setUrl(String paramString)
  {
    this.f = paramString;
  }
  
  public JSONObject toJson()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.putOpt(g.i.b(), this.a);
      localJSONObject.putOpt(g.g.b(), this.b);
      localJSONObject.putOpt(g.f.b(), this.c);
      localJSONObject.putOpt(g.o.b(), this.d);
      localJSONObject.putOpt(g.h.b(), this.e);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/client/model/ModelFileInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */