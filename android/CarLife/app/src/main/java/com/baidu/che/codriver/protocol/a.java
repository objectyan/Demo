package com.baidu.che.codriver.protocol;

import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.che.codriver.util.LocationUtil;
import com.baidu.che.codriver.util.c;
import com.baidu.che.codriver.util.d;
import com.baidu.che.codriver.util.h;

public class a
{
  private static final String A = "MDzBterNOpVZhq9S";
  private static final String B = "0123456789abcdef";
  private static final String C = "qkjXX1Msv4eNv8T5";
  public static final String a = "OTLMypNt9tKU60avOae9zHszuxSPEFyG";
  public static final String b = "http://api.map.baidu.com/";
  private static final String c = "https://vehicle.baidu.com/codriverapi";
  private static final String d = "http://sandbox.codriverapi.baidu.com/codriverapi";
  private static final String e = "http://10.52.185.183:8080/codriverapi";
  private static final String f = "https://vehicle.baidu.com/codriverapi";
  private static final String g = "https://ufosdk.baidu.com/?m=Index&a=postmsg";
  private static final String h = "https://ufosdk.baidu.com/?m=Index&a=postclientinfo";
  private static final String i = "http://ufosdk.baidu.com/?m=Client&a=postViewNew&appid=217770&needFbtype=true";
  private static final String j = "https://vehicle.baidu.com/codriverapi/robokit";
  private static final String k = "https://vehicle.baidu.com/codriverapi/uniqueid";
  private static final String l = "https://vehicle.baidu.com/codriverapi/bootloading";
  private static final String m = "https://vehicle.baidu.com/codriverapi/orbitpostjson";
  private static final String n = "https://vehicle.baidu.com/codriverapi/api/userlogpost";
  private static final String o = "https://vehicle.baidu.com/codriverapi/scanloginv2";
  private static final String p = "http://10.52.185.183:8080/codriverapi/robokit";
  private static final String q = "http://10.52.185.183:8080/codriverapi/uniqueid";
  private static final String r = "http://10.52.185.183:8080/codriverapi/bootloading";
  private static final String s = "http://10.52.185.183:8080/codriverapi/orbitpostjson";
  private static final String t = "http://10.52.185.183:8080/codriverapi/api/userlogpost";
  private static final String u = "http://10.52.185.183:8080/codriverapi/scanloginv2";
  private static final String v = "123456";
  private static final String w = ;
  private static final String x = "123456";
  private static final String y = com.baidu.che.codriver.a.a.d();
  private static final String z = "1234567812345678";
  
  public static String a()
  {
    return "https://vehicle.baidu.com/codriverapi/robokit";
  }
  
  public static String a(String paramString)
  {
    Object localObject = new e().a(a());
    ((e)localObject).a("coordtype", "2");
    ((e)localObject).a("word", paramString);
    double d1 = LocationUtil.getInstance().getLatitude();
    double d2 = LocationUtil.getInstance().getLongitude();
    ((e)localObject).a("crd", d2 + "_" + d1);
    ((e)localObject).a("av", c.k());
    ((e)localObject).a("ak", c.l());
    ((e)localObject).a("cn", c.j());
    if (TextUtils.isEmpty(c.n())) {
      if (c.o()) {
        Toast.makeText(c.a(), "uuid is empty", 0).show();
      }
    }
    for (;;)
    {
      ((e)localObject).a("pn", c.e());
      if (!TextUtils.isEmpty(c.m())) {
        ((e)localObject).a("ext", c.m());
      }
      ((e)localObject).a("sign", d.a(k() + ((e)localObject).c() + l()));
      paramString = null;
      try
      {
        localObject = ((e)localObject).b();
        paramString = (String)localObject;
      }
      catch (e.a locala)
      {
        for (;;)
        {
          h.d("NLP", "Config url exception!!!!", locala);
        }
      }
      h.b("NLP: ", paramString);
      return paramString;
      ((e)localObject).a("uuid", c.n());
    }
  }
  
  public static String b()
  {
    return "https://vehicle.baidu.com/codriverapi/uniqueid";
  }
  
  public static String c()
  {
    return "https://vehicle.baidu.com/codriverapi/bootloading";
  }
  
  public static String d()
  {
    return "https://vehicle.baidu.com/codriverapi/orbitpostjson";
  }
  
  public static String e()
  {
    return "https://vehicle.baidu.com/codriverapi/api/userlogpost";
  }
  
  public static String f()
  {
    return "https://vehicle.baidu.com/codriverapi/scanloginv2";
  }
  
  public static String g()
  {
    return "https://vehicle.baidu.com/codriverapi";
  }
  
  public static String h()
  {
    return "https://ufosdk.baidu.com/?m=Index&a=postmsg";
  }
  
  public static String i()
  {
    return "https://ufosdk.baidu.com/?m=Index&a=postclientinfo";
  }
  
  public static String j()
  {
    return "http://ufosdk.baidu.com/?m=Client&a=postViewNew&appid=217770&needFbtype=true";
  }
  
  public static String k()
  {
    return w;
  }
  
  public static String l()
  {
    return y;
  }
  
  public static String m()
  {
    if (("https://vehicle.baidu.com/codriverapi".equals("http://10.52.185.183:8080/codriverapi")) || ("https://vehicle.baidu.com/codriverapi".equals("http://sandbox.codriverapi.baidu.com/codriverapi"))) {
      return "1234567812345678";
    }
    return "MDzBterNOpVZhq9S";
  }
  
  public static String n()
  {
    if (("https://vehicle.baidu.com/codriverapi".equals("http://10.52.185.183:8080/codriverapi")) || ("https://vehicle.baidu.com/codriverapi".equals("http://sandbox.codriverapi.baidu.com/codriverapi"))) {
      return "0123456789abcdef";
    }
    return "qkjXX1Msv4eNv8T5";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/protocol/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */