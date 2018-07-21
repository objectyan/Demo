package com.baidu.tts.client.model;

import com.baidu.tts.tools.StringTool;
import java.util.HashSet;
import java.util.Set;

public class AvailableConditions
{
  private Set<String> a;
  private Set<String> b;
  
  public void appendGender(String paramString)
  {
    if (StringTool.isEmpty(paramString)) {
      return;
    }
    if (this.a == null) {
      this.a = new HashSet();
    }
    this.a.add(paramString);
  }
  
  public void appendSpeaker(String paramString)
  {
    if (StringTool.isEmpty(paramString)) {
      return;
    }
    if (this.b == null) {
      this.b = new HashSet();
    }
    this.b.add(paramString);
  }
  
  public Set<String> getGenders()
  {
    return this.a;
  }
  
  public Set<String> getSpeakers()
  {
    return this.b;
  }
  
  public void setGenders(Set<String> paramSet)
  {
    this.a = paramSet;
  }
  
  public void setSpeakers(Set<String> paramSet)
  {
    this.b = paramSet;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/client/model/AvailableConditions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */