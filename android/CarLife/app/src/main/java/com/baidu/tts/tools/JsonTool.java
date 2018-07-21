package com.baidu.tts.tools;

import java.util.Set;
import org.json.JSONArray;

public class JsonTool
{
  public static JSONArray fromSetToJson(Set<String> paramSet)
  {
    if (paramSet != null) {
      return new JSONArray(paramSet);
    }
    return null;
  }
  
  public static String[] getStringarray(JSONArray paramJSONArray)
  {
    if (paramJSONArray != null)
    {
      int j = paramJSONArray.length();
      String[] arrayOfString2 = new String[j];
      int i = 0;
      for (;;)
      {
        arrayOfString1 = arrayOfString2;
        if (i >= j) {
          break;
        }
        arrayOfString2[i] = paramJSONArray.optString(i);
        i += 1;
      }
    }
    String[] arrayOfString1 = null;
    return arrayOfString1;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/tools/JsonTool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */