package com.baidu.tts.client.model;

import com.baidu.tts.f.g;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class ModelInfo
{
  private String a;
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  private String i;
  private String j;
  private String k;
  
  public String getDomain()
  {
    return this.h;
  }
  
  public String getGender()
  {
    return this.f;
  }
  
  public String getLanguage()
  {
    return this.e;
  }
  
  public String getName()
  {
    return this.b;
  }
  
  public String getQuality()
  {
    return this.i;
  }
  
  public String getServerId()
  {
    return this.a;
  }
  
  public String getSpeaker()
  {
    return this.g;
  }
  
  public String getSpeechDataId()
  {
    return this.k;
  }
  
  public String getTextDataId()
  {
    return this.j;
  }
  
  public String getVersionMax()
  {
    return this.d;
  }
  
  public String getVersionMin()
  {
    return this.c;
  }
  
  public void parseJson(JSONObject paramJSONObject)
  {
    this.a = paramJSONObject.optString(g.i.b());
    this.b = paramJSONObject.optString(g.o.b());
    this.c = paramJSONObject.optString(g.p.b());
    this.d = paramJSONObject.optString(g.q.b());
    this.e = paramJSONObject.optString(g.F.b());
    this.f = paramJSONObject.optString(g.j.b());
    this.g = paramJSONObject.optString(g.K.b());
    this.h = paramJSONObject.optString(g.k.b());
    this.i = paramJSONObject.optString(g.l.b());
    this.j = paramJSONObject.optString(g.r.b());
    this.k = paramJSONObject.optString(g.s.b());
  }
  
  public void setDomain(String paramString)
  {
    this.h = paramString;
  }
  
  public void setGender(String paramString)
  {
    this.f = paramString;
  }
  
  public void setLanguage(String paramString)
  {
    this.e = paramString;
  }
  
  public void setMap(Map<String, String> paramMap)
  {
    if (paramMap != null)
    {
      this.a = ((String)paramMap.get(g.i.b()));
      this.b = ((String)paramMap.get(g.o.b()));
      this.c = ((String)paramMap.get(g.p.b()));
      this.d = ((String)paramMap.get(g.q.b()));
      this.e = ((String)paramMap.get(g.F.b()));
      this.f = ((String)paramMap.get(g.j.b()));
      this.g = ((String)paramMap.get(g.K.b()));
      this.h = ((String)paramMap.get(g.k.b()));
      this.i = ((String)paramMap.get(g.l.b()));
      this.j = ((String)paramMap.get(g.r.b()));
      this.k = ((String)paramMap.get(g.s.b()));
    }
  }
  
  public void setName(String paramString)
  {
    this.b = paramString;
  }
  
  public void setQuality(String paramString)
  {
    this.i = paramString;
  }
  
  public void setServerId(String paramString)
  {
    this.a = paramString;
  }
  
  public void setSpeaker(String paramString)
  {
    this.g = paramString;
  }
  
  public void setSpeechDataId(String paramString)
  {
    this.k = paramString;
  }
  
  public void setTextDataId(String paramString)
  {
    this.j = paramString;
  }
  
  public void setVersionMax(String paramString)
  {
    this.d = paramString;
  }
  
  public void setVersionMin(String paramString)
  {
    this.c = paramString;
  }
  
  public JSONObject toJson()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.putOpt(g.i.b(), this.a);
      localJSONObject.putOpt(g.o.b(), this.b);
      localJSONObject.putOpt(g.p.b(), this.c);
      localJSONObject.putOpt(g.q.b(), this.d);
      localJSONObject.putOpt(g.F.b(), this.e);
      localJSONObject.putOpt(g.j.b(), this.f);
      localJSONObject.putOpt(g.K.b(), this.g);
      localJSONObject.putOpt(g.k.b(), this.h);
      localJSONObject.putOpt(g.l.b(), this.i);
      localJSONObject.putOpt(g.r.b(), this.j);
      localJSONObject.putOpt(g.s.b(), this.k);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/client/model/ModelInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */