package com.baidu.carlife.logic.voice;

import android.text.TextUtils;
import com.baidu.carlife.model.q;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class e
{
  public static q a(String paramString)
  {
    String str = null;
    localObject = str;
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = new JSONObject(paramString);
        paramString = new JSONObject(paramString.getString("result") + "");
        paramString = new JSONObject(paramString.getString("json_res") + "");
        paramString = new JSONObject(paramString.getString("merged_res") + "");
        paramString = paramString.getString("semantic_form") + "";
        localObject = str;
        JSONObject localJSONObject;
        if (!TextUtils.isEmpty(paramString))
        {
          localJSONObject = new JSONObject(paramString);
          localObject = str;
          if (localJSONObject != null)
          {
            localObject = localJSONObject.optJSONArray("results").getJSONObject(0);
            str = ((JSONObject)localObject).getString("domain") + "";
            paramString = new q(str);
          }
        }
        boolean bool;
        return (q)localObject;
      }
      catch (JSONException paramString)
      {
        try
        {
          paramString.H = (localJSONObject.getString("raw_text") + "");
          if (str.isEmpty()) {
            return paramString;
          }
          paramString.G = (((JSONObject)localObject).getString("intent") + "");
          if (paramString.F.equals("music"))
          {
            if ((paramString.G.equals("play")) || (paramString.G.equals("search")))
            {
              localObject = ((JSONObject)localObject).optJSONObject("object");
              if (localObject == null) {
                break label712;
              }
              if (!((JSONObject)localObject).isNull("singer")) {
                paramString.I.b = ((JSONObject)localObject).getString("singer");
              }
              if (((JSONObject)localObject).isNull("song")) {
                break label712;
              }
              paramString.I.a = ((JSONObject)localObject).getString("song");
              return paramString;
            }
            if (!paramString.G.equals("music_setting")) {
              break label712;
            }
            localObject = ((JSONObject)localObject).getJSONObject("object");
            if (((JSONObject)localObject).isNull("operation")) {
              break label712;
            }
            paramString.I.d = ((JSONObject)localObject).getString("operation");
            return paramString;
          }
          if (paramString.F.equals("contact"))
          {
            if (!paramString.G.equals("call")) {
              break label712;
            }
            localObject = ((JSONObject)localObject).getJSONObject("object");
            if (!((JSONObject)localObject).isNull("name")) {
              paramString.K.b = ((JSONObject)localObject).getString("name");
            }
            if (((JSONObject)localObject).isNull("phone_number")) {
              break label712;
            }
            paramString.K.a = ((JSONObject)localObject).getString("phone_number");
            return paramString;
          }
          if (paramString.F.equals("setting"))
          {
            if (!paramString.G.equals("goto")) {
              break label712;
            }
            localObject = ((JSONObject)localObject).getJSONObject("object");
            if (((JSONObject)localObject).isNull("entity")) {
              break label712;
            }
            paramString.L.a = ((JSONObject)localObject).getString("entity");
            return paramString;
          }
          if (paramString.F.equals("map"))
          {
            if (paramString.G.equals("nearby"))
            {
              localObject = ((JSONObject)localObject).getJSONObject("object");
              if (!((JSONObject)localObject).isNull("nearby")) {
                paramString.J.c = ((JSONObject)localObject).getString("nearby");
              }
              if (((JSONObject)localObject).isNull("poi_type")) {
                break label712;
              }
              paramString.J.b = ((JSONObject)localObject).getString("poi_type");
              return paramString;
            }
            if (!paramString.G.equals("route")) {
              break label712;
            }
            localObject = ((JSONObject)localObject).getJSONObject("object");
            if (((JSONObject)localObject).isNull("arrival")) {
              break label712;
            }
            paramString.J.a = ((JSONObject)localObject).getString("arrival");
            return paramString;
          }
          bool = paramString.F.equals("other");
          if (!bool) {
            break label712;
          }
          return paramString;
        }
        catch (JSONException paramString)
        {
          for (;;) {}
          localObject = paramString;
        }
        paramString = paramString;
        paramString.printStackTrace();
        return null;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/logic/voice/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */