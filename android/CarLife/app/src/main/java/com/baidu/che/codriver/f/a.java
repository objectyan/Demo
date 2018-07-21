package com.baidu.che.codriver.f;

import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.che.codriver.stat.StatManager;
import com.baidu.che.codriver.util.LocationUtil;
import com.baidu.che.codriver.util.b;
import com.baidu.che.codriver.util.h;
import com.baidu.che.codriver.vr.n;
import com.baidu.sapi2.SapiAccount;
import java.util.HashMap;
import java.util.Map;

public class a
  extends com.baidu.che.codriver.d.a.a
{
  private static final HashMap<String, String> d = new HashMap();
  private a b;
  private String c;
  private Map<String, Map> e;
  
  public a(a parama)
  {
    this.b = parama;
  }
  
  public static void b(String paramString)
  {
    h.b("network", "remove OtherParams key = " + paramString);
    d.remove(paramString);
  }
  
  public static void b(String paramString1, String paramString2)
  {
    h.b("network", "add OtherParams key = " + paramString1 + "; value = " + paramString2);
    d.put(paramString1, paramString2);
  }
  
  @Deprecated
  public void a()
  {
    a(null);
  }
  
  public void a(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("query is null");
    }
    this.c = paramString;
    super.a();
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    h.b("network", "response=" + paramString2);
    if (paramInt == 200)
    {
      this.b.b(paramString2);
      return;
    }
    this.b.a("statusCode=" + paramInt);
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.b.a(paramString2);
  }
  
  public a b(Map<String, Map> paramMap)
  {
    this.e = paramMap;
    return this;
  }
  
  public String c()
  {
    return n.d();
  }
  
  public Map<String, String> d()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("coordtype", "2");
    localHashMap.put("word", this.c);
    double d1 = LocationUtil.getInstance().getLatitude();
    double d2 = LocationUtil.getInstance().getLongitude();
    localHashMap.put("crd", d2 + "_" + d1);
    localHashMap.put("av", com.baidu.che.codriver.util.c.k());
    localHashMap.put("ak", com.baidu.che.codriver.i.a.b());
    localHashMap.put("cn", com.baidu.che.codriver.i.a.a());
    if (b.a().b()) {
      localHashMap.put("BDUSS", b.a().c().bduss);
    }
    String str = com.baidu.che.codriver.util.c.n();
    if (TextUtils.isEmpty(str))
    {
      StatManager.getInstance().checkActivation(com.baidu.che.codriver.util.c.a());
      if (n.a()) {
        Toast.makeText(com.baidu.che.codriver.util.c.a(), "uuid is empty", 0).show();
      }
    }
    for (;;)
    {
      localHashMap.put("pn", com.baidu.che.codriver.util.c.e());
      if (!TextUtils.isEmpty(com.baidu.che.codriver.util.c.m())) {
        localHashMap.put("ext", com.baidu.che.codriver.util.c.m());
      }
      if (!d.isEmpty()) {
        localHashMap.putAll(d);
      }
      localHashMap.put("sign", com.baidu.che.codriver.d.a.c.a(localHashMap, n.e(), n.f()));
      h.b("network", "params = " + localHashMap.toString());
      return localHashMap;
      localHashMap.put("uuid", str);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString);
    
    public abstract void b(String paramString);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/f/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */