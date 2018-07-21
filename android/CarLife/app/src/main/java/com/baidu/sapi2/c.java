package com.baidu.sapi2;

import android.text.TextUtils;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

final class c
{
  private static final String a = "fast_reg_sms_num";
  private static final String b = "global_share_strategy";
  private static final String c = "specific_share_strategy";
  private static final String d = "authorized_packages";
  private static final String e = "authorized_domains";
  private static final String f = "cache";
  private static final String g = "enabled";
  private static final String h = "modules";
  private static final String i = "id";
  private static final String j = "download_url";
  private static final String k = "hash";
  private a l = new a();
  private String m = "10698000036592";
  private LoginShareStrategy n;
  private Map<String, LoginShareStrategy> o = new HashMap();
  private Map<String, String> p = new HashMap();
  private List<String> q = new ArrayList();
  
  public static c a(JSONObject paramJSONObject)
  {
    c localc = new c();
    localc.l = a.a(paramJSONObject.optJSONObject("cache"));
    localc.m = paramJSONObject.optString("fast_reg_sms_num", "10698000036592");
    Object localObject1 = paramJSONObject.optString("global_share_strategy");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      localc.n = LoginShareStrategy.mapStrToValue((String)localObject1);
    }
    localObject1 = paramJSONObject.optJSONObject("specific_share_strategy");
    Iterator localIterator;
    String str;
    Object localObject2;
    if (localObject1 != null)
    {
      localIterator = ((JSONObject)localObject1).keys();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        localObject2 = LoginShareStrategy.mapStrToValue(((JSONObject)localObject1).optString(str));
        localc.o.put(str, localObject2);
      }
    }
    localObject1 = paramJSONObject.optJSONObject("authorized_packages");
    if (localObject1 != null)
    {
      localIterator = ((JSONObject)localObject1).keys();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        localObject2 = ((JSONObject)localObject1).optString(str);
        if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
          localc.p.put(str, localObject2);
        }
      }
    }
    paramJSONObject = paramJSONObject.optJSONArray("authorized_domains");
    if (paramJSONObject != null)
    {
      int i1 = 0;
      while (i1 < paramJSONObject.length())
      {
        if (!TextUtils.isEmpty(paramJSONObject.optString(i1))) {
          localc.q.add(paramJSONObject.optString(i1));
        }
        i1 += 1;
      }
    }
    return localc;
  }
  
  static Map<String, String> h()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("com.baidu.sapi2.(.*)", "de308d7973b5171883333a97253327e4");
    localHashMap.put("com.baidu.tieba(.*)", "673004cf2f6efdec2385c8116c1e8c14");
    localHashMap.put("com.baidu.searchbox(.*)", "c2b0b497d0389e6de1505e7fd8f4d539");
    localHashMap.put("com.baidu.appsearch", "c2b0b497d0389e6de1505e7fd8f4d539");
    localHashMap.put("com.baidu.(.*)input(.*)", "c2b0b497d0389e6de1505e7fd8f4d539");
    localHashMap.put("com.baidu.BaiduMap(.*)", "c2b0b497d0389e6de1505e7fd8f4d539");
    localHashMap.put("com.baidu.browser.(.+)", "c2b0b497d0389e6de1505e7fd8f4d539");
    localHashMap.put("com.baidu.iknow", "13a0a8019be4015ed20e075d824f1696");
    localHashMap.put("com.baidu.yuedu", "13a0a8019be4015ed20e075d824f1696");
    localHashMap.put("com.baidu.homework", "13a0a8019be4015ed20e075d824f1696");
    localHashMap.put("com.baidu.wenku", "13a0a8019be4015ed20e075d824f1696");
    localHashMap.put("com.baidu.mbaby", "13a0a8019be4015ed20e075d824f1696");
    localHashMap.put("com.baidu.navi", "0586742e88a2e6a19e996598ec336b61");
    localHashMap.put("com.baidu.travel", "0586742e88a2e6a19e996598ec336b61");
    localHashMap.put("com.baidu.baidulife", "0586742e88a2e6a19e996598ec336b61");
    localHashMap.put("com.ting.mp3.android", "0586742e88a2e6a19e996598ec336b61");
    localHashMap.put("com.baidu.news(.*)", "0586742e88a2e6a19e996598ec336b61");
    localHashMap.put("com.baidu.video", "0586742e88a2e6a19e996598ec336b61");
    localHashMap.put("com.baidu.hao123(.*)", "7fd3727852d29eb6f4283988dc0d6150");
    localHashMap.put("com.baidu.netdisk(.*)", "ae5821440fab5e1a61a025f014bd8972");
    localHashMap.put("com.baidu.music.lebo", "b1d67a31136599143c5c38879728dcfd");
    localHashMap.put("com.hiapk.marketpho", "d46053ef4381d35cb774eb632d8e8aec");
    localHashMap.put("com.baidu.gamecenter(.*)", "bddf74f2473eb1802fe13fe3e1aab81a");
    localHashMap.put("com.baidu.notes", "989d3c446cadade24c8c57a10fe6370d");
    localHashMap.put("com.baidu.lifenote", "c1a65e392e3892db0935d22f6c20b9cc");
    localHashMap.put("com.baidu.passport.securitycenter", "db97d206640d7aca6d75975b3c1f6e87");
    localHashMap.put("com.nuomi", "59215ee95c063ff2c56226581a62130a");
    localHashMap.put("com.baidu.shucheng91", "2090b2ef3011c12d851ed125c2360954");
    localHashMap.put("com.duoku.gamesearch", "153a76549eb514258b5806f95da02bb3");
    localHashMap.put("com.baidu.qingpai", "80344917d9e7cf0fd8a8914cc918e0ef");
    localHashMap.put("cn.jingling.motu.photowonder", "6930f0bd9fa461c2cd65e216acee0118");
    localHashMap.put("com.baidu.account", "fe3c74f0431ea0dc303a10b6af6470fc");
    localHashMap.put("com.duoku.game.helper", "6231a79a3f43cdd01797eb5febbc6350");
    localHashMap.put("com.dragon.android.pandaspace", "5b120e96b20f5b4ec695d79b20d18753");
    localHashMap.put("com.baidu.addressugc", "9e2a7cde67d36c1e6a01bb070fc8ef7b");
    localHashMap.put("cn.opda.a.phonoalbumshoushou", "310a4f78e839b86df7731c2f48fcadae");
    localHashMap.put("com.baidu.fb", "a4622402640f20dfda894cbe2edf8823");
    localHashMap.put("com.baidu.baidutranslate", "0586742e88a2e6a19e996598ec336b61");
    localHashMap.put("com.baidu.lbs.waimai", "77ad7ac419a031af0252422152c62e67");
    localHashMap.put("com.baidu.lottery", "6e45686dd05db2374b0a600c7f28c0c4");
    localHashMap.put("com.baidu.doctor", "49c95b74699e358ffe67f5daacab3d48");
    localHashMap.put("com.baidu.patient", "49c95b74699e358ffe67f5daacab3d48");
    localHashMap.put("com.baidu.baidumovie", "645c143e25f34e076bcee9600b30e4c2");
    localHashMap.put("com.baidu.bdg.skyeye", "544f0f4a82864fbf7b9663fbc80437bb");
    localHashMap.put("com.zongheng.reader(.*)", "b9c43ba43f1e150d4f1670ae09a89a7f");
    localHashMap.put("com.baidu.doctor.doctorask", "13a0a8019be4015ed20e075d824f1696");
    localHashMap.put("com.baidu.k12edu", "610d60c69d2adf4b57fc6c2ec83fecbf");
    localHashMap.put("com.baidu.zuowen", "fa6b26072965ee3f372da85ca69b7b99");
    localHashMap.put("com.baidu.wallet", "de74282b18c0847e64b2b3f0ebbfe0a0");
    localHashMap.put("com.baidu.clouda.mobile.crm", "561e009b4a1f97012bf90dfed6c054d5");
    localHashMap.put("com.baidu.wear.app", "73a9573a74d219b8cf3066316d0b330c");
    localHashMap.put("com.dianxinos.optimizer.channel", "bd3df198d50f0dafa3c5804d342d3698");
    localHashMap.put("com.baidu.lbs.bus", "3d96c8b0be8fd5b1db754b8dbb73f23e");
    localHashMap.put("com.baidu.hui", "3102ce07daa9cb7c8d62c82fdc61c0ba");
    localHashMap.put("com.baidu.image", "ff934173c55f54a81d9c5da216263479");
    localHashMap.put("com.baidu.vip", "a00a833bf8afe07172262db3ccb3a5c5");
    localHashMap.put("com.baidu.mami", "86743dc804add1dd5f3a81a5818ead58");
    localHashMap.put("com.baidu.faceu", "a140a3b0775361c459fc751c50e98d77");
    localHashMap.put("com.baidu.movie", "0586742e88a2e6a19e996598ec336b61");
    return localHashMap;
  }
  
  static Map<String, Integer> i()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("com.baidu.wallet", Integer.valueOf(1));
    localHashMap.put("com.nuomi", Integer.valueOf(2));
    localHashMap.put("com.baidu.lbs.waimai", Integer.valueOf(3));
    localHashMap.put("com.baidu.searchbox(.*)", Integer.valueOf(4));
    localHashMap.put("com.baidu.BaiduMap(.*)", Integer.valueOf(5));
    localHashMap.put("com.baidu.tieba(.*)", Integer.valueOf(6));
    localHashMap.put("com.baidu.netdisk(.*)", Integer.valueOf(7));
    localHashMap.put("com.baidu.appsearch", Integer.valueOf(8));
    return localHashMap;
  }
  
  static List<String> j()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("baidu.com");
    localArrayList.add("hao123.com");
    localArrayList.add("nuomi.com");
    return localArrayList;
  }
  
  public String a()
  {
    return this.m;
  }
  
  public LoginShareStrategy b()
  {
    return this.n;
  }
  
  public Map<String, LoginShareStrategy> c()
  {
    return this.o;
  }
  
  public Map<String, String> d()
  {
    if (!this.p.isEmpty()) {
      return this.p;
    }
    return h();
  }
  
  public List<String> e()
  {
    if (!this.q.isEmpty()) {
      return this.q;
    }
    return j();
  }
  
  public a f()
  {
    return this.l;
  }
  
  public String g()
  {
    Object localObject1 = new JSONObject();
    try
    {
      ((JSONObject)localObject1).put("cache", this.l.c());
      ((JSONObject)localObject1).put("fast_reg_sms_num", this.m);
      if (this.n != null) {
        ((JSONObject)localObject1).put("global_share_strategy", this.n.getStrValue());
      }
      Object localObject2 = new JSONObject();
      Iterator localIterator = this.o.entrySet().iterator();
      Map.Entry localEntry;
      while (localIterator.hasNext())
      {
        localEntry = (Map.Entry)localIterator.next();
        ((JSONObject)localObject2).put((String)localEntry.getKey(), ((LoginShareStrategy)localEntry.getValue()).getStrValue());
      }
      ((JSONObject)localObject1).put("specific_share_strategy", localObject2);
      localObject2 = new JSONObject();
      localIterator = this.p.entrySet().iterator();
      while (localIterator.hasNext())
      {
        localEntry = (Map.Entry)localIterator.next();
        ((JSONObject)localObject2).put((String)localEntry.getKey(), localEntry.getValue());
      }
      ((JSONObject)localObject1).put("authorized_packages", localObject2);
      localObject2 = new JSONArray();
      localIterator = this.q.iterator();
      while (localIterator.hasNext()) {
        ((JSONArray)localObject2).put((String)localIterator.next());
      }
      ((JSONObject)localObject1).put("authorized_domains", localObject2);
      localObject1 = ((JSONObject)localObject1).toString();
      return (String)localObject1;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  public static class a
  {
    private static final String a = ".BD_SAPI_CACHE";
    private boolean b = true;
    private List<a> c = new ArrayList();
    
    static a a(JSONObject paramJSONObject)
    {
      locala = new a();
      if (paramJSONObject != null) {
        try
        {
          locala.b = paramJSONObject.optBoolean("enabled", true);
          paramJSONObject = paramJSONObject.optJSONArray("modules");
          int i = 0;
          while (i < paramJSONObject.length())
          {
            JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
            locala.b().add(a.a(localJSONObject));
            i += 1;
          }
          return locala;
        }
        catch (Throwable paramJSONObject) {}
      }
    }
    
    public boolean a()
    {
      return this.b;
    }
    
    public List<a> b()
    {
      return this.c;
    }
    
    JSONObject c()
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("enabled", this.b);
        JSONArray localJSONArray = new JSONArray();
        Iterator localIterator = b().iterator();
        while (localIterator.hasNext()) {
          localJSONArray.put(((a)localIterator.next()).a());
        }
        localJSONObject.put("modules", localJSONArray);
        return localJSONObject;
      }
      catch (Throwable localThrowable) {}
      return null;
    }
    
    public static class a
    {
      public String a;
      public String b;
      public String c;
      
      static a a(JSONObject paramJSONObject)
      {
        a locala = new a();
        locala.a = paramJSONObject.optString("id");
        locala.b = paramJSONObject.optString("download_url");
        locala.c = paramJSONObject.optString("hash");
        return locala;
      }
      
      public static String a(String paramString)
      {
        return b(paramString).replace('/', '-');
      }
      
      public static String b(String paramString)
      {
        return paramString.replace(':', '/');
      }
      
      public static String c(String paramString)
      {
        return ".BD_SAPI_CACHE/" + b(paramString);
      }
      
      JSONObject a()
      {
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("id", this.a);
          localJSONObject.put("download_url", this.b);
          localJSONObject.put("hash", this.c);
          return localJSONObject;
        }
        catch (Throwable localThrowable) {}
        return null;
      }
      
      public boolean equals(Object paramObject)
      {
        if (this == paramObject) {
          return true;
        }
        if ((paramObject == null) || (getClass() != paramObject.getClass())) {
          return false;
        }
        paramObject = (a)paramObject;
        return this.a.equals(((a)paramObject).a);
      }
      
      public int hashCode()
      {
        return this.a.hashCode();
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/sapi2/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */