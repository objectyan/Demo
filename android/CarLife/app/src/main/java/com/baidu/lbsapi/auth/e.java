package com.baidu.lbsapi.auth;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

class e
{
  private Context a;
  private List<HashMap<String, String>> b = null;
  private a<String> c = null;
  
  protected e(Context paramContext)
  {
    this.a = paramContext;
  }
  
  private List<HashMap<String, String>> a(HashMap<String, String> paramHashMap, String[] paramArrayOfString)
  {
    ArrayList localArrayList = new ArrayList();
    int i;
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0)) {
      i = 0;
    }
    while (i < paramArrayOfString.length)
    {
      Object localObject1 = new HashMap();
      Object localObject2 = paramHashMap.keySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = ((String)((Iterator)localObject2).next()).toString();
        ((HashMap)localObject1).put(str, paramHashMap.get(str));
      }
      ((HashMap)localObject1).put("mcode", paramArrayOfString[i]);
      localArrayList.add(localObject1);
      i += 1;
      continue;
      paramArrayOfString = new HashMap();
      localObject1 = paramHashMap.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((String)((Iterator)localObject1).next()).toString();
        paramArrayOfString.put(localObject2, paramHashMap.get(localObject2));
      }
      localArrayList.add(paramArrayOfString);
    }
    return localArrayList;
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
  
  private void a(List<HashMap<String, String>> paramList)
  {
    a.a("syncConnect start Thread id = " + String.valueOf(Thread.currentThread().getId()));
    if ((paramList == null) || (paramList.size() == 0)) {
      a.c("syncConnect failed,params list is null or size is 0");
    }
    for (;;)
    {
      return;
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      if (i < paramList.size())
      {
        a.a("syncConnect resuest " + i + "  start!!!");
        Object localObject1 = (HashMap)paramList.get(i);
        Object localObject2 = new f(this.a);
        if (((f)localObject2).a())
        {
          localObject2 = ((f)localObject2).a((HashMap)localObject1);
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          a.a("syncConnect resuest " + i + "  result:" + (String)localObject1);
          localArrayList.add(localObject1);
          try
          {
            localObject2 = new JSONObject((String)localObject1);
            if ((((JSONObject)localObject2).has("status")) && (((JSONObject)localObject2).getInt("status") == 0))
            {
              a.a("auth end and break");
              a((String)localObject1);
              return;
            }
          }
          catch (JSONException localJSONException)
          {
            a.a("continue-------------------------------");
          }
        }
        for (;;)
        {
          a.a("syncConnect end");
          i += 1;
          break;
          a.a("Current network is not available.");
          localArrayList.add(c.a("Current network is not available."));
        }
      }
      a.a("--iiiiii:" + i + "<><>paramList.size():" + paramList.size() + "<><>authResults.size():" + localArrayList.size());
      if ((paramList.size() > 0) && (i == paramList.size()) && (localArrayList.size() > 0) && (i == localArrayList.size()) && (i - 1 > 0)) {
        try
        {
          paramList = new JSONObject((String)localArrayList.get(i - 1));
          if ((paramList.has("status")) && (paramList.getInt("status") != 0))
          {
            a.a("i-1 result is not 0,return first result");
            a((String)localArrayList.get(0));
            return;
          }
        }
        catch (JSONException paramList)
        {
          a(c.a("JSONException:" + paramList.getMessage()));
        }
      }
    }
  }
  
  protected void a(HashMap<String, String> paramHashMap, String[] paramArrayOfString, a<String> parama)
  {
    this.b = a(paramHashMap, paramArrayOfString);
    this.c = parama;
    new Thread(new Runnable()
    {
      public void run()
      {
        e.a(e.this, e.a(e.this));
      }
    }).start();
  }
  
  static abstract interface a<Result>
  {
    public abstract void a(Result paramResult);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/lbsapi/auth/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */