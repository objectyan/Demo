package com.baidu.tts.client.model;

import com.baidu.tts.f.g;
import com.baidu.tts.tools.DataTool;
import com.baidu.tts.tools.JsonTool;
import com.baidu.tts.tools.StringTool;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Conditions
{
  private Set<String> a;
  private String b;
  private Set<String> c;
  private Set<String> d;
  private Set<String> e;
  private Set<String> f;
  private Set<String> g;
  
  public void appendDomain(String paramString)
  {
    if (StringTool.isEmpty(paramString)) {
      return;
    }
    if (this.f == null) {
      this.f = new HashSet();
    }
    this.f.add(paramString);
  }
  
  public void appendGender(String paramString)
  {
    if (StringTool.isEmpty(paramString)) {
      return;
    }
    if (this.d == null) {
      this.d = new HashSet();
    }
    this.d.add(paramString);
  }
  
  public void appendId(String paramString)
  {
    if (StringTool.isEmpty(paramString)) {
      return;
    }
    if (this.a == null) {
      this.a = new HashSet();
    }
    this.a.add(paramString);
  }
  
  public void appendLanguage(String paramString)
  {
    if (StringTool.isEmpty(paramString)) {
      return;
    }
    if (this.c == null) {
      this.c = new HashSet();
    }
    this.c.add(paramString);
  }
  
  public void appendQuality(String paramString)
  {
    if (StringTool.isEmpty(paramString)) {
      return;
    }
    if (this.g == null) {
      this.g = new HashSet();
    }
    this.g.add(paramString);
  }
  
  public void appendSpeaker(String paramString)
  {
    if (StringTool.isEmpty(paramString)) {
      return;
    }
    if (this.e == null) {
      this.e = new HashSet();
    }
    this.e.add(paramString);
  }
  
  public String[] getDomainArray()
  {
    return DataTool.fromSetToArray(this.f);
  }
  
  public Set<String> getDomains()
  {
    return this.f;
  }
  
  public String[] getGenderArray()
  {
    return DataTool.fromSetToArray(this.d);
  }
  
  public JSONArray getGenderJA()
  {
    return JsonTool.fromSetToJson(this.d);
  }
  
  public Set<String> getGenders()
  {
    return this.d;
  }
  
  public JSONObject getJSONConditions()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put(g.i.b(), JsonTool.fromSetToJson(this.a));
      localJSONObject.put(g.aa.b(), this.b);
      localJSONObject.put(g.F.b(), JsonTool.fromSetToJson(this.c));
      localJSONObject.put(g.j.b(), JsonTool.fromSetToJson(this.d));
      localJSONObject.put(g.K.b(), JsonTool.fromSetToJson(this.e));
      localJSONObject.put(g.k.b(), JsonTool.fromSetToJson(this.f));
      localJSONObject.put(g.l.b(), JsonTool.fromSetToJson(this.g));
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject;
  }
  
  public String[] getLanguageArray()
  {
    return DataTool.fromSetToArray(this.c);
  }
  
  public Set<String> getLanguages()
  {
    return this.c;
  }
  
  public Set<String> getModelIds()
  {
    return this.a;
  }
  
  public String[] getModelIdsArray()
  {
    return DataTool.fromSetToArray(this.a);
  }
  
  public String[] getQualityArray()
  {
    return DataTool.fromSetToArray(this.g);
  }
  
  public Set<String> getQualitys()
  {
    return this.g;
  }
  
  public String[] getSpeakerArray()
  {
    return DataTool.fromSetToArray(this.e);
  }
  
  public JSONArray getSpeakerJA()
  {
    return JsonTool.fromSetToJson(this.e);
  }
  
  public Set<String> getSpeakers()
  {
    return this.e;
  }
  
  public String getVersion()
  {
    return this.b;
  }
  
  public void setDomains(Set<String> paramSet)
  {
    this.f = paramSet;
  }
  
  public void setDomains(String[] paramArrayOfString)
  {
    this.f = DataTool.fromArrayToSet(paramArrayOfString);
  }
  
  public void setGenders(Set<String> paramSet)
  {
    this.d = paramSet;
  }
  
  public void setLanguages(Set<String> paramSet)
  {
    this.c = paramSet;
  }
  
  public void setLanguages(String[] paramArrayOfString)
  {
    this.c = DataTool.fromArrayToSet(paramArrayOfString);
  }
  
  public void setModelIds(Set<String> paramSet)
  {
    this.a = paramSet;
  }
  
  public void setQualitys(Set<String> paramSet)
  {
    this.g = paramSet;
  }
  
  public void setQualitys(String[] paramArrayOfString)
  {
    this.g = DataTool.fromArrayToSet(paramArrayOfString);
  }
  
  public void setSpeakers(Set<String> paramSet)
  {
    this.e = paramSet;
  }
  
  public void setVersion(String paramString)
  {
    this.b = paramString;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/client/model/Conditions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */