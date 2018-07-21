package com.tencent.wxop.stat.b;

import android.content.Context;
import com.tencent.wxop.stat.l;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class d
{
  static f a;
  private static b d = ;
  private static JSONObject e = new JSONObject();
  Integer b = null;
  String c = null;
  
  public d(Context paramContext)
  {
    try
    {
      a(paramContext);
      this.b = m.m(paramContext.getApplicationContext());
      this.c = l.a(paramContext).b();
      return;
    }
    catch (Throwable paramContext)
    {
      d.b(paramContext);
    }
  }
  
  static f a(Context paramContext)
  {
    try
    {
      if (a == null) {
        a = new f(paramContext.getApplicationContext(), null);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  public static void a(Context paramContext, Map<String, String> paramMap)
  {
    if (paramMap == null) {}
    for (;;)
    {
      return;
      paramContext = new HashMap(paramMap).entrySet().iterator();
      while (paramContext.hasNext())
      {
        paramMap = (Map.Entry)paramContext.next();
        e.put((String)paramMap.getKey(), paramMap.getValue());
      }
    }
  }
  
  public void a(JSONObject paramJSONObject, Thread paramThread)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (a != null) {
        a.a(localJSONObject, paramThread);
      }
      s.a(localJSONObject, "cn", this.c);
      if (this.b != null) {
        localJSONObject.put("tn", this.b);
      }
      if (paramThread == null) {
        paramJSONObject.put("ev", localJSONObject);
      }
      while ((e != null) && (e.length() > 0))
      {
        paramJSONObject.put("eva", e);
        return;
        paramJSONObject.put("errkv", localJSONObject.toString());
      }
      return;
    }
    catch (Throwable paramJSONObject)
    {
      d.b(paramJSONObject);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/tencent/wxop/stat/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */