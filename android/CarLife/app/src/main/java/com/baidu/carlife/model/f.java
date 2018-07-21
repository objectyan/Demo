package com.baidu.carlife.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class f
  implements Serializable
{
  public int a;
  public String b;
  public String c;
  public int d;
  public int e;
  public String f;
  public int g;
  public int h;
  public String i;
  public String j;
  public String k;
  public int l;
  public String m;
  public String n;
  public String o;
  public String p;
  public String q;
  public String r;
  
  public static List<f> a(JSONArray paramJSONArray)
  {
    int i2;
    Object localObject;
    if (paramJSONArray != null)
    {
      i2 = paramJSONArray.length();
      if (i2 >= 1) {}
    }
    else
    {
      localObject = null;
      return (List<f>)localObject;
    }
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    for (;;)
    {
      localObject = localArrayList;
      if (i1 >= i2) {
        break;
      }
      localObject = paramJSONArray.optJSONObject(i1);
      f localf = new f();
      localf.b = ((JSONObject)localObject).optString("qname");
      localf.c = ((JSONObject)localObject).optString("qattr");
      localf.d = ((JSONObject)localObject).optInt("wait");
      localf.i = ((JSONObject)localObject).optString("waittime");
      localf.g = ((JSONObject)localObject).optInt("from");
      localf.h = ((JSONObject)localObject).optInt("to");
      localf.e = ((JSONObject)localObject).optInt("type");
      localf.r = ((JSONObject)localObject).optString("sid");
      localf.q = ((JSONObject)localObject).optString("name");
      localf.p = ((JSONObject)localObject).optString("num");
      localf.j = ((JSONObject)localObject).optString("orderid");
      localf.k = ((JSONObject)localObject).optString("serialid");
      localf.l = ((JSONObject)localObject).optInt("state");
      localf.m = ((JSONObject)localObject).optString("sname");
      localf.o = ((JSONObject)localObject).optString("nowwait");
      localf.n = ((JSONObject)localObject).optString("notice");
      localArrayList.add(localf);
      i1 += 1;
    }
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt > 0) && (paramInt < 5);
  }
  
  public static List<f> b(JSONArray paramJSONArray)
  {
    int i2;
    Object localObject;
    if (paramJSONArray != null)
    {
      i2 = paramJSONArray.length();
      if (i2 >= 1) {}
    }
    else
    {
      localObject = null;
      return (List<f>)localObject;
    }
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    for (;;)
    {
      localObject = localArrayList;
      if (i1 >= i2) {
        break;
      }
      localObject = paramJSONArray.optJSONObject(i1);
      f localf = new f();
      localf.b = ((JSONObject)localObject).optString("qname");
      localf.c = ((JSONObject)localObject).optString("qattr");
      localf.d = ((JSONObject)localObject).optInt("wait");
      localf.i = ((JSONObject)localObject).optString("waittime");
      localf.g = ((JSONObject)localObject).optInt("from");
      localf.h = ((JSONObject)localObject).optInt("to");
      localf.e = ((JSONObject)localObject).optInt("type");
      localArrayList.add(localf);
      i1 += 1;
    }
  }
  
  @Deprecated
  private static List<f> c(JSONArray paramJSONArray)
  {
    int i2;
    Object localObject;
    if (paramJSONArray != null)
    {
      i2 = paramJSONArray.length();
      if (i2 >= 1) {}
    }
    else
    {
      localObject = null;
      return (List<f>)localObject;
    }
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    for (;;)
    {
      localObject = localArrayList;
      if (i1 >= i2) {
        break;
      }
      localObject = paramJSONArray.optJSONObject(i1);
      f localf = new f();
      localf.a = ((JSONObject)localObject).optInt("queueId");
      localf.b = ((JSONObject)localObject).optString("name");
      localf.c = ((JSONObject)localObject).optString("qattr");
      localf.d = ((JSONObject)localObject).optInt("wait");
      localf.i = ((JSONObject)localObject).optString("waittime");
      localArrayList.add(localf);
      i1 += 1;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/model/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */