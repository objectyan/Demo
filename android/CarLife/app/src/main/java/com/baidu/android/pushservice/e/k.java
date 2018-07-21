package com.baidu.android.pushservice.e;

import android.content.Context;
import java.util.HashMap;
import org.json.JSONArray;

public class k
  extends c
{
  private String[] d;
  
  public k(l paraml, Context paramContext, String[] paramArrayOfString)
  {
    super(paraml, paramContext);
    this.d = paramArrayOfString;
  }
  
  protected void a(HashMap<String, String> paramHashMap)
  {
    super.a(paramHashMap);
    int j = this.d.length;
    if (j == 0)
    {
      a(30602);
      return;
    }
    paramHashMap.put("method", "delete");
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    while (i < j)
    {
      localJSONArray.put(this.d[i]);
      i += 1;
    }
    paramHashMap.put("msg_ids", localJSONArray.toString());
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/e/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */