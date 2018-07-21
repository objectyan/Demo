package com.baidu.android.pushservice.h;

import android.content.Context;
import com.baidu.android.pushservice.d.a;
import com.baidu.android.pushservice.d.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class p
{
  private static volatile p a = null;
  private Context b = null;
  
  private p(Context paramContext)
  {
    this.b = paramContext.getApplicationContext();
    if (this.b == null) {}
  }
  
  public static p a(Context paramContext)
  {
    if (a == null) {
      a = new p(paramContext);
    }
    return a;
  }
  
  public String a(long paramLong1, long paramLong2, int paramInt)
  {
    JSONArray localJSONArray = new JSONArray();
    Object localObject6 = a.a(this.b);
    Object localObject7 = new ArrayList();
    HashMap localHashMap = new HashMap();
    Object localObject5 = new HashMap();
    Object localObject4 = new HashMap();
    Object localObject3 = new ArrayList();
    Object localObject8 = a.a(this.b, paramLong1, paramLong2, 1500);
    Object localObject9 = c.h(this.b);
    if (localObject8 == null) {
      return null;
    }
    int j;
    int i;
    label135:
    Object localObject10;
    Object localObject11;
    label235:
    int k;
    if (((List)localObject8).size() > paramInt)
    {
      j = 1;
      if (localObject9 != null) {
        ((List)localObject8).addAll((Collection)localObject9);
      }
      localObject9 = ((List)localObject8).iterator();
      i = 0;
      if (!((Iterator)localObject9).hasNext()) {
        break label1290;
      }
      localObject10 = (e)((Iterator)localObject9).next();
      if (!((e)localObject10).a().startsWith(n.r)) {
        break label446;
      }
      if (!localHashMap.containsKey(((e)localObject10).b())) {
        localHashMap.put(((e)localObject10).b(), new ArrayList());
      }
      localObject11 = (List)localHashMap.get(((e)localObject10).b());
      if (localObject11 != null) {
        ((List)localObject11).add(((e)localObject10).e());
      }
      if (j == 0) {
        break label638;
      }
      k = i + 1;
      i = k;
      if (k < paramInt) {
        break label638;
      }
      i = k;
      if (i < paramInt) {
        localObject8 = ((List)localObject8).iterator();
      }
    }
    for (;;)
    {
      if (((Iterator)localObject8).hasNext())
      {
        localObject9 = (e)((Iterator)localObject8).next();
        if (((e)localObject9).a().startsWith(n.t)) {
          ((List)localObject7).add(((e)localObject9).d());
        }
        if (j != 0)
        {
          k = i + 1;
          i = k;
          if (k < paramInt) {}
        }
      }
      else
      {
        try
        {
          if (((List)localObject7).size() <= 0) {
            break label662;
          }
          localObject8 = new JSONObject();
          ((JSONObject)localObject8).put("app_appid", "9527");
          localObject9 = new JSONArray();
          localObject7 = ((List)localObject7).iterator();
          while (((Iterator)localObject7).hasNext()) {
            ((JSONArray)localObject9).put(((i)((Iterator)localObject7).next()).a());
          }
          if (localJSONArray.length() != 0) {
            break label1284;
          }
        }
        catch (JSONException localJSONException1) {}
        label429:
        return "";
        j = 0;
        break;
        label446:
        if (((e)localObject10).a().startsWith(n.s))
        {
          if (!((HashMap)localObject5).containsKey(((e)localObject10).b())) {
            ((HashMap)localObject5).put(((e)localObject10).b(), new ArrayList());
          }
          localObject11 = (List)((HashMap)localObject5).get(((e)localObject10).b());
          if (localObject11 == null) {
            break label235;
          }
          ((List)localObject11).add(((e)localObject10).f());
          break label235;
        }
        if (((e)localObject10).a().startsWith(n.v))
        {
          if (!((HashMap)localObject4).containsKey(((e)localObject10).b())) {
            ((HashMap)localObject4).put(((e)localObject10).b(), new ArrayList());
          }
          localObject11 = (List)((HashMap)localObject4).get(((e)localObject10).b());
          if (localObject11 == null) {
            break label235;
          }
          ((List)localObject11).add(((e)localObject10).h());
          break label235;
        }
        if (!((e)localObject10).a().startsWith(n.u)) {
          break label235;
        }
        ((List)localObject3).add(((e)localObject10).g());
        break label235;
        label638:
        break label135;
      }
    }
    ((JSONObject)localObject8).put("push_action", localObject9);
    localJSONArray.put(localObject8);
    label662:
    if (localObject6 != null)
    {
      localObject6 = ((List)localObject6).iterator();
      if (((Iterator)localObject6).hasNext())
      {
        localObject9 = (j)((Iterator)localObject6).next();
        localObject7 = ((j)localObject9).a(this.b);
        localObject8 = new JSONArray();
        Object localObject12 = (List)localJSONException1.get(((j)localObject9).b());
        localObject11 = (List)((HashMap)localObject5).get(((j)localObject9).b());
        localObject10 = (List)((HashMap)localObject4).get(((j)localObject9).b());
        if (localObject12 != null) {
          try
          {
            if (((List)localObject12).size() != 0)
            {
              localObject12 = ((List)localObject12).iterator();
              for (;;)
              {
                if (((Iterator)localObject12).hasNext())
                {
                  ((JSONArray)localObject8).put(((k)((Iterator)localObject12).next()).a());
                  continue;
                  if (((JSONArray)localObject8).length() <= 0) {
                    break;
                  }
                }
              }
            }
          }
          catch (JSONException localJSONException2) {}
        }
        for (;;)
        {
          ((JSONObject)localObject7).put("push_action", localObject8);
          localJSONArray.put(localObject7);
          break;
          if ((localObject11 != null) && (((List)localObject11).size() != 0))
          {
            localObject11 = ((List)localObject11).iterator();
            while (((Iterator)localObject11).hasNext()) {
              ((JSONArray)localObject8).put(((b)((Iterator)localObject11).next()).a());
            }
          }
          if (localObject10 != null)
          {
            localObject10 = ((List)localObject10).iterator();
            while (((Iterator)localObject10).hasNext())
            {
              localObject11 = (h)((Iterator)localObject10).next();
              if (((h)localObject11).j.equals(localJSONException2.b()))
              {
                ((JSONArray)localObject8).put(((h)localObject11).a());
                ((HashMap)localObject4).remove(localJSONException2.b());
              }
            }
          }
        }
      }
      localObject5 = ((HashMap)localObject4).keySet().iterator();
      label995:
      if (!((Iterator)localObject5).hasNext()) {}
    }
    label1284:
    label1290:
    Object localObject2;
    for (Object localObject1 = (String)((Iterator)localObject5).next();; localObject2 = null)
    {
      try
      {
        localObject1 = (List)((HashMap)localObject4).get(localObject1);
        localObject6 = new JSONArray();
        if (localObject1 == null) {
          continue;
        }
        localObject7 = ((List)localObject1).iterator();
        localObject1 = null;
        while (((Iterator)localObject7).hasNext())
        {
          localObject1 = (h)((Iterator)localObject7).next();
          ((JSONArray)localObject6).put(((h)localObject1).a());
        }
        if (localObject1 == null) {
          break label995;
        }
        localObject7 = new JSONObject();
        ((JSONObject)localObject7).put("app_type", j.b);
        ((JSONObject)localObject7).put("app_package_name", ((h)localObject1).j);
        ((JSONObject)localObject7).put("app_vercode", ((h)localObject1).b);
        ((JSONObject)localObject7).put("app_vername", ((h)localObject1).a);
        if (((JSONArray)localObject6).length() > 0) {
          ((JSONObject)localObject7).put("push_action", localObject6);
        }
        localJSONArray.put(localObject7);
      }
      catch (Exception localException) {}
      if (((List)localObject3).size() <= 0) {
        break label429;
      }
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("app_appid", "9528");
      localObject4 = new JSONArray();
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((JSONArray)localObject4).put(((f)((Iterator)localObject3).next()).a());
      }
      ((JSONObject)localObject1).put("crash_info", localObject4);
      localJSONArray.put(localObject1);
      break label429;
      return localJSONArray.toString();
      break;
      break label995;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/h/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */