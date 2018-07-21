package com.baidu.lbsapi.auth;

import android.content.Context;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

class d
{
  private Context a;
  private HashMap<String, String> b = null;
  private a<String> c = null;
  
  protected d(Context paramContext)
  {
    this.a = paramContext;
  }
  
  private HashMap<String, String> a(HashMap<String, String> paramHashMap)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = ((String)localIterator.next()).toString();
      localHashMap.put(str, paramHashMap.get(str));
    }
    return localHashMap;
  }
  
  private void a(String paramString)
  {
    Object localObject = paramString;
    if (paramString == null) {
      localObject = "";
    }
    try
    {
      localObject = new JSONObject((String)localObject);
      paramString = (String)localObject;
      if (!((JSONObject)localObject).has("status"))
      {
        ((JSONObject)localObject).put("status", -1);
        paramString = (String)localObject;
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString = new JSONObject();
        try
        {
          paramString.put("status", -1);
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
        continue;
        paramString = new JSONObject().toString();
      }
    }
    if (this.c != null)
    {
      localObject = this.c;
      if (paramString != null)
      {
        paramString = paramString.toString();
        ((a)localObject).a(paramString);
      }
    }
    else
    {
      return;
    }
  }
  
  protected void a(HashMap<String, String> paramHashMap, a<String> parama)
  {
    this.b = a(paramHashMap);
    this.c = parama;
    new Thread(new Runnable()
    {
      public void run()
      {
        a.a("postWithHttps start Thread id = " + String.valueOf(Thread.currentThread().getId()));
        String str = new f(d.a(d.this)).a(d.b(d.this));
        d.a(d.this, str);
      }
    }).start();
  }
  
  static abstract interface a<Result>
  {
    public abstract void a(Result paramResult);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/lbsapi/auth/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */