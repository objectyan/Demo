package com.baidu.che.codriver.vr;

import android.text.TextUtils;
import com.baidu.che.codriver.f.a.a;
import com.baidu.che.codriver.protocol.data.nlp.NLPResponseData;
import com.baidu.che.codriver.util.c;
import com.baidu.che.codriver.util.h;
import com.google.gson.Gson;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class j
  implements Comparator<JSONObject>
{
  private static final String a = "CoDriverVoice-ParserHelper";
  private static final String b = "__";
  private static int e = 0;
  private static final Object f = new Object();
  private HashMap<String, Integer> c;
  private HashMap<String, d> d;
  private i g;
  private boolean h = false;
  
  protected j(HashMap<String, d> paramHashMap)
  {
    this.d = paramHashMap;
    this.c = new HashMap();
    this.c.put("other", Integer.valueOf(0));
    this.c.put("hotel", Integer.valueOf(1));
    this.c.put("train", Integer.valueOf(2));
    this.c.put("flight", Integer.valueOf(3));
    this.c.put("app", Integer.valueOf(4));
    this.c.put("codriver", Integer.valueOf(5));
    this.c.put("player", Integer.valueOf(6));
    this.c.put("music", Integer.valueOf(7));
    this.c.put("telephone", Integer.valueOf(8));
    this.c.put("navigate_instruction", Integer.valueOf(9));
    this.c.put("map", Integer.valueOf(10));
    this.c.put("calendar", Integer.valueOf(11));
  }
  
  private String a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).getJSONArray("results_recognition").getString(0);
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private JSONObject a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    try
    {
      Object localObject1 = paramJSONObject.optString("intent");
      JSONObject localJSONObject = paramJSONObject.optJSONObject("object");
      localObject1 = ((String)localObject1).split("__");
      Object localObject2 = localObject1[0];
      if (localObject1.length >= 3) {
        localJSONObject.put(localObject1[1], localObject1[2]);
      }
      paramJSONObject.put("intent", localObject2);
      paramJSONObject.put("object", localJSONObject);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    h.b("CoDriverVoice-ParserHelper", "resultObject = " + paramJSONObject.toString());
    return paramJSONObject;
  }
  
  private void a(String paramString, p paramp)
  {
    try
    {
      paramp.e(a(new JSONArray(new JSONObject(new JSONObject(paramString).optString("results_nlu")).optString("results")).getJSONObject(0)).toString());
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private boolean a(String paramString, p paramp, a parama)
  {
    paramString = paramString.toLowerCase(Locale.ENGLISH);
    d locald = (d)this.d.get(paramString.toLowerCase());
    if (locald == null) {
      return false;
    }
    paramp.d(paramString);
    paramp.a(locald.a);
    paramp.b(locald.b);
    paramp.c(locald.c);
    parama.a(paramString);
    parama.a(paramp);
    return true;
  }
  
  private String b(String paramString, p paramp, a parama)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      int i = ((JSONObject)localObject).optInt("error", 0);
      paramp.a(i);
      if (i != 0)
      {
        if (((JSONObject)localObject).has("sub_error"))
        {
          i = ((JSONObject)localObject).optInt("sub_error");
          paramp.a(((JSONObject)localObject).optInt("sub_error"));
        }
        if ((i == 3101) && (e != 3101)) {
          paramp.a(4);
        }
        e = i;
        parama.a(paramp);
        return null;
      }
      e = 0;
      localObject = a(paramString);
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        parama.a(paramp);
        return null;
      }
      a(paramString, paramp);
      return (String)localObject;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private JSONObject b(String paramString)
    throws JSONException
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      paramString = new JSONArray(paramString);
      if (paramString.length() == 1) {
        return paramString.optJSONObject(0);
      }
    } while (paramString.length() == 0);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramString.length())
    {
      localArrayList.add(paramString.optJSONObject(i));
      i += 1;
    }
    Collections.sort(localArrayList, this);
    return (JSONObject)localArrayList.get(paramString.length() - 1);
  }
  
  public int a(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    BigDecimal localBigDecimal1 = BigDecimal.valueOf(paramJSONObject1.optDouble("score", 0.0D));
    BigDecimal localBigDecimal2 = BigDecimal.valueOf(paramJSONObject2.optDouble("score", 0.0D));
    if (localBigDecimal1.compareTo(localBigDecimal2) == 0) {
      return ((Integer)this.c.get(paramJSONObject1.optString("domain", "other"))).intValue() - ((Integer)this.c.get(paramJSONObject2.optString("domain", "other"))).intValue();
    }
    return localBigDecimal1.compareTo(localBigDecimal2);
  }
  
  protected void a(i parami)
  {
    this.g = parami;
  }
  
  protected void a(String paramString, a parama)
  {
    a(null, paramString, parama);
  }
  
  protected void a(String paramString, b paramb, a parama)
  {
    if (parama == null) {}
    boolean bool;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (paramb != b.b) {
                break;
              }
              h.b("CoDriverVoice-ParserHelper", "using localparse");
              paramb = new p();
              paramString = b(paramString, paramb, parama);
            } while (paramString == null);
            a(paramString, paramb, parama);
            return;
            if (paramb != b.a) {
              break;
            }
            h.b("CoDriverVoice-ParserHelper", "using nlpParse");
          } while (b(paramString, new p(), parama) == null);
          a(a(paramString), parama);
          return;
        } while (paramb != b.c);
        paramb = new p();
        paramString = b(paramString, paramb, parama);
      } while (paramString == null);
      bool = a(paramString, paramb, parama);
      h.b("CoDriverVoice-ParserHelper", "localParse-->" + bool);
    } while (bool);
    h.b("CoDriverVoice-ParserHelper", "using nlpParse");
    a(paramString, parama);
  }
  
  protected void a(Map<String, Map> paramMap, final String paramString, final a parama)
  {
    h.b("CoDriverVoice-ParserHelper", "using nlpParse ");
    if (!com.baidu.che.codriver.util.j.a(c.a()))
    {
      paramMap = new p();
      paramMap.a(10012);
      parama.a(paramMap);
    }
    do
    {
      return;
      if (TextUtils.isEmpty(paramString))
      {
        paramMap = new p();
        paramMap.a(1);
        parama.a(paramMap);
        return;
      }
      if ((this.g != null) && (this.g.b(paramString)))
      {
        h.b("CoDriverVoice-ParserHelper", "onIntercept  return");
        return;
      }
    } while (this.h);
    parama.a(paramString);
    this.h = true;
    new com.baidu.che.codriver.f.a(new a.a()
    {
      private String c(String paramAnonymousString)
        throws JSONException
      {
        JSONObject localJSONObject = new JSONObject(paramAnonymousString).getJSONArray("result").getJSONObject(0);
        Object localObject1 = "";
        if (localJSONObject != null) {
          localObject1 = localJSONObject.optString("card_type");
        }
        Object localObject2 = null;
        paramAnonymousString = (String)localObject2;
        if (!"ui_control".equals(localObject1))
        {
          paramAnonymousString = (String)localObject2;
          if (localJSONObject.has("data")) {
            paramAnonymousString = localJSONObject.getJSONObject("data").optString("list_type");
          }
        }
        localObject1 = localJSONObject.optJSONObject("data");
        if (localObject1 != null)
        {
          ((JSONObject)localObject1).optString("domain");
          ((JSONObject)localObject1).optJSONArray("list");
          ((JSONObject)localObject1).optString("list_type");
        }
        return paramAnonymousString;
      }
      
      public void a(String paramAnonymousString)
      {
        h.b("CoDriverVoice-ParserHelper", "onErrorResponse: " + paramAnonymousString);
        j.a(j.this, false);
        paramAnonymousString = new p();
        paramAnonymousString.a(3);
        parama.a(paramAnonymousString);
      }
      
      public void b(String paramAnonymousString)
      {
        h.b("CoDriverVoice-ParserHelper", "onResponse: " + paramAnonymousString);
        j.a(j.this, false);
        com.baidu.che.codriver.b.a.b(paramAnonymousString);
        Object localObject;
        for (;;)
        {
          try
          {
            localObject = new JSONObject(paramAnonymousString);
            if (!((JSONObject)localObject).has("result_list")) {
              break;
            }
            paramAnonymousString = new p();
            int i = ((JSONObject)localObject).optInt("error", 0);
            paramAnonymousString.a(i);
            if (i != 0)
            {
              if (((JSONObject)localObject).has("sub_error")) {
                paramAnonymousString.a(((JSONObject)localObject).optInt("sub_error"));
              }
              parama.a(paramAnonymousString);
              return;
            }
            localObject = ((JSONObject)localObject).getJSONArray("result_list").getJSONObject(0);
            JSONObject localJSONObject = ((JSONObject)localObject).getJSONObject("merged_res").getJSONObject("semantic_form");
            paramAnonymousString.d(localJSONObject.optString("raw_text"));
            paramAnonymousString.f(((JSONObject)localObject).toString());
            localObject = j.a(j.this, localJSONObject.optString("results"));
            if (localObject != null)
            {
              paramAnonymousString.e(((JSONObject)localObject).toString());
              paramAnonymousString.a(((JSONObject)localObject).optString("domain", "other"));
              paramAnonymousString.b(((JSONObject)localObject).optString("intent"));
              paramAnonymousString.c(((JSONObject)localObject).optString("object"));
              paramAnonymousString.d(paramString);
              parama.a(paramAnonymousString);
              return;
            }
          }
          catch (JSONException paramAnonymousString)
          {
            paramAnonymousString.printStackTrace();
            paramAnonymousString = new p();
            paramAnonymousString.a(2);
            parama.a(paramAnonymousString);
            return;
          }
          paramAnonymousString.a(1);
        }
        boolean bool = ((JSONObject)localObject).has("result");
        if (bool) {
          try
          {
            localObject = (NLPResponseData)new Gson().fromJson(paramAnonymousString, NLPResponseData.class);
            ((NLPResponseData)localObject).listType = c(paramAnonymousString);
            parama.a((NLPResponseData)localObject);
            return;
          }
          catch (Exception paramAnonymousString)
          {
            paramAnonymousString.printStackTrace();
            paramAnonymousString = new p();
            paramAnonymousString.a(2);
            parama.a(paramAnonymousString);
            return;
          }
        }
        paramAnonymousString = new p();
        paramAnonymousString.a(2);
        parama.a(paramAnonymousString);
      }
    }).b(paramMap).a(paramString);
  }
  
  public static abstract interface a
  {
    public abstract void a(NLPResponseData paramNLPResponseData);
    
    public abstract void a(p paramp);
    
    public abstract void a(String paramString);
  }
  
  public static enum b
  {
    private b() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/vr/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */