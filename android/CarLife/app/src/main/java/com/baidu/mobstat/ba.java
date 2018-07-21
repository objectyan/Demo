package com.baidu.mobstat;

import android.content.Context;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ba
{
  public static final ba a = new ba();
  
  private void a(JSONObject paramJSONObject)
  {
    paramJSONObject = new be(paramJSONObject);
    bc.b = paramJSONObject.a;
    bc.c = paramJSONObject.b;
    bc.d = paramJSONObject.c;
  }
  
  private boolean a()
  {
    if (!y.a.b()) {}
    while ((!y.b.b()) || (!y.c.b()) || (!y.d.b()) || (!y.e.b())) {
      return true;
    }
    return false;
  }
  
  private void b(Context paramContext, JSONObject paramJSONObject)
  {
    int i = 0;
    JSONObject localJSONObject = new JSONObject();
    int j;
    Object localObject;
    try
    {
      localJSONObject.put("he", paramJSONObject);
      j = paramJSONObject.toString().length();
      i = 0 + j;
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        try
        {
          localJSONObject.put("app_mem3", localObject);
          j = ((JSONArray)localObject).toString().length();
          j = i + j;
          bd.a("APP_APK");
          localObject = y.e.a(20480);
          paramJSONObject = new JSONArray();
          localObject = ((List)localObject).iterator();
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          str = (String)((Iterator)localObject).next();
          bd.a(str);
          paramJSONObject.put(str);
          continue;
          paramJSONObject = paramJSONObject;
          bd.a(paramJSONObject);
        }
        catch (JSONException paramJSONObject)
        {
          bd.a(paramJSONObject);
        }
        j = i;
      }
      i = j;
      if (paramJSONObject.length() <= 0) {
        break label229;
      }
      try
      {
        localJSONObject.put("app_apk3", paramJSONObject);
        i = paramJSONObject.toString().length();
        i = j + i;
      }
      catch (JSONException paramJSONObject)
      {
        for (;;)
        {
          label229:
          bd.a(paramJSONObject);
          i = j;
        }
        j = i;
        if (paramJSONObject.length() <= 0) {
          break label344;
        }
        try
        {
          localJSONObject.put("app_change3", paramJSONObject);
          j = paramJSONObject.toString().length();
          j = i + j;
        }
        catch (JSONException paramJSONObject)
        {
          for (;;)
          {
            bd.a(paramJSONObject);
            j = i;
          }
          i = j;
          if (paramJSONObject.length() <= 0) {
            break label457;
          }
          try
          {
            localJSONObject.put("app_trace3", paramJSONObject);
            i = paramJSONObject.toString().length();
            i = j + i;
          }
          catch (JSONException paramJSONObject)
          {
            for (;;)
            {
              bd.a(paramJSONObject);
              i = j;
            }
            j = i;
            if (paramJSONObject.length() <= 0) {
              break label571;
            }
            try
            {
              localJSONObject.put("app_list3", paramJSONObject);
              j = paramJSONObject.toString().length();
              j = i + j;
            }
            catch (JSONException paramJSONObject)
            {
              for (;;)
              {
                bd.a(paramJSONObject);
                j = i;
              }
              i = j;
              if (paramJSONObject.length() <= 0) {
                break label686;
              }
              try
              {
                localJSONObject.put("ap_list3", paramJSONObject);
                i = paramJSONObject.toString().length();
                i = j + i;
              }
              catch (JSONException paramJSONObject)
              {
                for (;;)
                {
                  try
                  {
                    localJSONObject.put("payload", paramJSONObject);
                    al.a().a(paramContext, localJSONObject.toString());
                    return;
                  }
                  catch (Exception paramContext)
                  {
                    bd.a(paramContext);
                  }
                  paramJSONObject = paramJSONObject;
                  bd.a(paramJSONObject);
                  i = j;
                }
              }
              bd.a("log in bytes is almost :" + i);
              paramJSONObject = new JSONArray();
              paramJSONObject.put(localJSONObject);
              localJSONObject = new JSONObject();
            }
            bd.a("AP_LIST");
            localObject = y.a.a(184320 - j);
            paramJSONObject = new JSONArray();
            localObject = ((List)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              str = (String)((Iterator)localObject).next();
              bd.a(str);
              paramJSONObject.put(str);
            }
          }
          bd.a("APP_LIST");
          localObject = y.b.a(46080);
          paramJSONObject = new JSONArray();
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            str = (String)((Iterator)localObject).next();
            bd.a(str);
            paramJSONObject.put(str);
          }
        }
        bd.a("APP_TRACE");
        localObject = y.c.a(15360);
        paramJSONObject = new JSONArray();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          str = (String)((Iterator)localObject).next();
          bd.a(str);
          paramJSONObject.put(str);
        }
      }
      bd.a("APP_CHANGE");
      localObject = y.d.a(10240);
      paramJSONObject = new JSONArray();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        str = (String)((Iterator)localObject).next();
        bd.a(str);
        paramJSONObject.put(str);
      }
    }
    bd.a("APP_MEM");
    if (!az.a(paramContext).b())
    {
      paramJSONObject = de.t(paramContext);
      localObject = new JSONArray();
      bd.a(paramJSONObject);
      ((JSONArray)localObject).put(paramJSONObject);
      if (((JSONArray)localObject).length() <= 0) {}
    }
    String str;
    label344:
    label457:
    label571:
    label686:
    return;
  }
  
  private void c(Context paramContext)
  {
    bd.a("collectAPWithStretegy 1");
    az localaz = az.a(paramContext);
    long l1 = localaz.a(u.a);
    long l2 = System.currentTimeMillis();
    long l3 = localaz.e();
    bd.a("now time: " + l2 + ": last time: " + l1 + "; time interval: " + l3);
    if ((l1 == 0L) || (l2 - l1 > l3))
    {
      bd.a("collectAPWithStretegy 2");
      n.a(paramContext);
    }
  }
  
  private void d(Context paramContext)
  {
    bd.a("collectAPPListWithStretegy 1");
    long l1 = System.currentTimeMillis();
    az localaz = az.a(paramContext);
    long l2 = localaz.a(u.b);
    long l3 = localaz.f();
    bd.a("now time: " + l1 + ": last time: " + l2 + "; userInterval : " + l3);
    if ((l2 == 0L) || (l1 - l2 > l3) || (!localaz.a(l2)))
    {
      bd.a("collectUserAPPListWithStretegy 2");
      n.a(paramContext, false);
    }
    l2 = localaz.a(u.c);
    l3 = localaz.g();
    bd.a("now time: " + l1 + ": last time: " + l2 + "; sysInterval : " + l3);
    if ((l2 == 0L) || (l1 - l2 > l3))
    {
      bd.a("collectSysAPPListWithStretegy 2");
      n.a(paramContext, true);
    }
  }
  
  private void e(Context paramContext)
  {
    bd.a("collectAPPTraceWithStretegy 1");
    long l1 = System.currentTimeMillis();
    az localaz = az.a(paramContext);
    long l2 = localaz.a(u.e);
    long l3 = localaz.i();
    bd.a("now time: " + l1 + ": last time: " + l2 + "; time interval: " + l3);
    if ((l2 == 0L) || (l1 - l2 > l3))
    {
      bd.a("collectAPPTraceWithStretegy 2");
      n.b(paramContext, false);
    }
  }
  
  private void f(Context paramContext)
  {
    bd.a("collectAPKWithStretegy 1");
    long l1 = System.currentTimeMillis();
    az localaz = az.a(paramContext);
    long l2 = localaz.a(u.g);
    long l3 = localaz.h();
    bd.a("now time: " + l1 + ": last time: " + l2 + "; interval : " + l3);
    if ((l2 == 0L) || (l1 - l2 > l3))
    {
      bd.a("collectAPKWithStretegy 2");
      n.b(paramContext);
    }
  }
  
  private void g(Context paramContext)
  {
    az.a(paramContext).a(u.h, System.currentTimeMillis());
    JSONObject localJSONObject = v.a(paramContext);
    bd.a("header: " + localJSONObject);
    int i = 0;
    while (a())
    {
      if (i > 0) {
        v.c(localJSONObject);
      }
      b(paramContext, localJSONObject);
      i += 1;
    }
  }
  
  public void a(Context paramContext, long paramLong)
  {
    az.a(paramContext).a(u.i, paramLong);
  }
  
  public void a(Context paramContext, String paramString)
  {
    az.a(paramContext).a(paramString);
  }
  
  public void a(Context paramContext, JSONObject paramJSONObject)
  {
    bd.a("startDataAnynalyzed start");
    a(paramJSONObject);
    paramJSONObject = az.a(paramContext);
    boolean bool = paramJSONObject.a();
    bd.a("is data collect closed:" + bool);
    if (!bool)
    {
      if (!y.a.b(10000)) {
        c(paramContext);
      }
      if (!y.b.b(10000)) {
        d(paramContext);
      }
      if (!y.c.b(10000)) {
        e(paramContext);
      }
      if ((bc.e) && (!y.e.b(10000))) {
        f(paramContext);
      }
      bool = de.n(paramContext);
      if ((!bool) || (!paramJSONObject.l())) {
        break label156;
      }
      bd.a("sendLog");
      g(paramContext);
    }
    for (;;)
    {
      bd.a("startDataAnynalyzed finished");
      return;
      label156:
      if (!bool) {
        bd.a("isWifiAvailable = false, will not sendLog");
      } else {
        bd.a("can not sendLog due to time stratergy");
      }
    }
  }
  
  public boolean a(Context paramContext)
  {
    paramContext = az.a(paramContext);
    long l1 = paramContext.a(u.i);
    long l2 = paramContext.c();
    long l3 = System.currentTimeMillis();
    if (l3 - l1 > l2)
    {
      bd.a("need to update, checkWithLastUpdateTime lastUpdateTime =" + l1 + "nowTime=" + l3 + ";timeInteveral=" + l2);
      return true;
    }
    bd.a("no need to update, checkWithLastUpdateTime lastUpdateTime =" + l1 + "nowTime=" + l3 + ";timeInteveral=" + l2);
    return false;
  }
  
  public void b(Context paramContext, String paramString)
  {
    az.a(paramContext).b(paramString);
  }
  
  public boolean b(Context paramContext)
  {
    return (!az.a(paramContext).a()) || (a(paramContext));
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mobstat/ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */