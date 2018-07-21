package com.baidu.android.pushservice.c;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class c
{
  private String a;
  private String b;
  private int c;
  private ArrayList<e> d;
  private ArrayList<f> e;
  private String f;
  private String g;
  private a h;
  
  public c(String paramString)
  {
    this.a = paramString;
    d(paramString);
  }
  
  private void d(String paramString)
  {
    int j = 0;
    try
    {
      paramString = new JSONObject(paramString);
      a(paramString.getString("manufacturer"));
      Object localObject1 = paramString.getString("mode");
      int i;
      label72:
      Object localObject4;
      Object localObject3;
      if ("I".equalsIgnoreCase((String)localObject1))
      {
        a(1);
        localObject1 = new ArrayList();
        if (!paramString.has("osversion")) {
          break label301;
        }
        localObject2 = paramString.getJSONArray("osversion");
        i = 0;
        if (i >= ((JSONArray)localObject2).length()) {
          break label301;
        }
        localObject4 = ((JSONArray)localObject2).getJSONObject(i);
        localObject3 = new e();
        ((e)localObject3).a(((JSONObject)localObject4).getString("key"));
        ((e)localObject3).b(((JSONObject)localObject4).getString("value"));
        localObject4 = ((JSONObject)localObject4).getString("match");
        if (!((String)localObject4).equalsIgnoreCase("above")) {
          break label263;
        }
        ((e)localObject3).a(0);
      }
      for (;;)
      {
        ((ArrayList)localObject1).add(localObject3);
        i += 1;
        break label72;
        if ("I_HW".equalsIgnoreCase((String)localObject1))
        {
          a(5);
          break;
        }
        if ("I_XM".equalsIgnoreCase((String)localObject1))
        {
          a(6);
          break;
        }
        if ("I_MZ".equalsIgnoreCase((String)localObject1))
        {
          a(7);
          break;
        }
        if ("I_OP".equalsIgnoreCase((String)localObject1))
        {
          a(8);
          break;
        }
        if ("C".equalsIgnoreCase((String)localObject1))
        {
          a(2);
          break;
        }
        a(0);
        break;
        label263:
        if (((String)localObject4).equalsIgnoreCase("equal")) {
          ((e)localObject3).a(1);
        } else if (((String)localObject4).equalsIgnoreCase("regular")) {
          ((e)localObject3).a(2);
        }
      }
      label301:
      Object localObject2 = new ArrayList();
      if (paramString.has("systemprop"))
      {
        localObject3 = paramString.getJSONArray("systemprop");
        i = j;
        if (i < ((JSONArray)localObject3).length())
        {
          localObject4 = ((JSONArray)localObject3).getJSONObject(i);
          f localf = new f();
          localf.a(((JSONObject)localObject4).getString("key"));
          localf.b(((JSONObject)localObject4).getString("value"));
          String str = ((JSONObject)localObject4).getString("match");
          if (str.equalsIgnoreCase("above")) {
            localf.a(0);
          }
          for (;;)
          {
            localf.c(((JSONObject)localObject4).getString("regular"));
            ((ArrayList)localObject2).add(localf);
            i += 1;
            break;
            if (str.equalsIgnoreCase("equal")) {
              localf.a(1);
            }
          }
        }
      }
      if (paramString.has("apkname")) {
        b(paramString.getString("apkname"));
      }
      if (paramString.has("apksign")) {
        c(paramString.getString("apksign"));
      }
      if (paramString.has("apkversion"))
      {
        paramString = paramString.getJSONObject("apkversion");
        a(paramString.optInt("from"), paramString.optInt("to"));
      }
      if (((ArrayList)localObject1).size() > 0) {
        a((ArrayList)localObject1);
      }
      if (((ArrayList)localObject2).size() > 0)
      {
        b((ArrayList)localObject2);
        return;
      }
    }
    catch (Exception paramString) {}
  }
  
  public a a()
  {
    return this.h;
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.h = new a();
    this.h.a = paramInt1;
    this.h.b = paramInt2;
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public void a(ArrayList<e> paramArrayList)
  {
    this.d = paramArrayList;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public void b(String paramString)
  {
    this.f = paramString;
  }
  
  public void b(ArrayList<f> paramArrayList)
  {
    this.e = paramArrayList;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public void c(String paramString)
  {
    this.g = paramString;
  }
  
  public ArrayList<e> d()
  {
    return this.d;
  }
  
  public ArrayList<f> e()
  {
    return this.e;
  }
  
  public String f()
  {
    return this.f;
  }
  
  public String g()
  {
    return this.g;
  }
  
  public String toString()
  {
    return this.a;
  }
  
  public class a
  {
    public int a;
    public int b;
    
    public a() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/c/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */