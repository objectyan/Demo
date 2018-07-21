package com.baidu.carlife.radio.b;

import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class j<T>
  implements m<String, List<T>>
{
  private m<JSONObject, T> a;
  
  public j(m<JSONObject, T> paramm)
  {
    this.a = paramm;
  }
  
  m<JSONObject, T> a()
  {
    return this.a;
  }
  
  public List<T> a(String paramString)
  {
    try
    {
      paramString = a(new JSONObject(paramString));
      return paramString;
    }
    catch (JSONException paramString) {}
    return null;
  }
  
  protected abstract List<T> a(JSONObject paramJSONObject);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/radio/b/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */