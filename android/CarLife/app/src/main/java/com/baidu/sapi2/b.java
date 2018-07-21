package com.baidu.sapi2;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.baidu.sapi2.share.a;
import com.baidu.sapi2.utils.L;
import com.baidu.sapi2.utils.SapiUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  private static final String a = "app_version_code";
  private static final String b = "current_account";
  private static final String c = "share_accounts";
  private static final String d = "login_accounts";
  private static final String e = "first_install";
  private static final String f = "login_status_changed";
  private static final String g = "sapi_options";
  private static final String h = "relogin_credentials";
  private static final String i = "cuidtoken";
  private static final String j = "device_token";
  private static final String k = "device_login_available";
  private static final String l = "hosts_hijacked";
  private static final String m = "stat_items";
  private static final String n = "time_offset_seconds";
  private static final String o = "device_info_read_times";
  private static final String p = "root_status";
  private static b s;
  private SharedPreferences q;
  private Context r;
  
  private b(Context paramContext)
  {
    this.r = paramContext;
    this.q = paramContext.getSharedPreferences("sapi_system", 0);
  }
  
  public static b a(Context paramContext)
  {
    try
    {
      if (s == null) {
        s = new b(paramContext.getApplicationContext());
      }
      return s;
    }
    finally {}
  }
  
  private void a(String paramString, int paramInt)
  {
    if (Build.VERSION.SDK_INT > 8)
    {
      this.q.edit().putInt(paramString, paramInt).apply();
      return;
    }
    this.q.edit().putInt(paramString, paramInt).commit();
  }
  
  private void a(String paramString, long paramLong)
  {
    if (Build.VERSION.SDK_INT > 8)
    {
      this.q.edit().putLong(paramString, paramLong).apply();
      return;
    }
    this.q.edit().putLong(paramString, paramLong).commit();
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (Build.VERSION.SDK_INT > 8)
    {
      this.q.edit().putString(paramString1, paramString2).apply();
      return;
    }
    this.q.edit().putString(paramString1, paramString2).commit();
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT > 8)
    {
      this.q.edit().putBoolean(paramString, paramBoolean).apply();
      return;
    }
    this.q.edit().putBoolean(paramString, paramBoolean).commit();
  }
  
  private void a(List<SapiAccount> paramList)
  {
    paramList = SapiAccount.toJSONArray(paramList);
    if (paramList != null) {
      a("share_accounts", paramList.toString());
    }
  }
  
  private int b(String paramString, int paramInt)
  {
    return this.q.getInt(paramString, paramInt);
  }
  
  private long b(String paramString, long paramLong)
  {
    return this.q.getLong(paramString, paramLong);
  }
  
  private void b(List<SapiAccount> paramList)
  {
    paramList = SapiAccount.toJSONArray(paramList);
    if (paramList != null) {
      a("login_accounts", paramList.toString());
    }
  }
  
  private boolean b(String paramString, boolean paramBoolean)
  {
    return this.q.getBoolean(paramString, paramBoolean);
  }
  
  private String f(String paramString)
  {
    return this.q.getString(paramString, "");
  }
  
  private void w()
  {
    a("login_status_changed", true);
  }
  
  public String a()
  {
    return f("device_token");
  }
  
  <T> List<T> a(List<T> paramList, int paramInt)
  {
    Object localObject = paramList;
    if (paramList != null)
    {
      localObject = paramList;
      if (paramInt >= 0)
      {
        localObject = paramList;
        if (paramInt < paramList.size()) {
          localObject = paramList.subList(paramList.size() - paramInt, paramList.size());
        }
      }
    }
    return (List<T>)localObject;
  }
  
  public void a(int paramInt)
  {
    a("app_version_code", paramInt);
  }
  
  public void a(SapiAccount paramSapiAccount)
  {
    if (paramSapiAccount == null)
    {
      a("current_account", "");
      SapiUtils.webLogout(this.r);
    }
    do
    {
      JSONObject localJSONObject;
      do
      {
        return;
        localJSONObject = paramSapiAccount.toJSONObject();
      } while (localJSONObject == null);
      a("current_account", localJSONObject.toString());
      SapiUtils.webLogin(this.r, paramSapiAccount.bduss);
    } while (h());
    w();
  }
  
  public void a(c paramc)
  {
    if (paramc != null) {
      a("sapi_options", paramc.g());
    }
  }
  
  public void a(String paramString)
  {
    a("device_token", paramString);
  }
  
  public void a(String paramString, SapiAccount.ReloginCredentials paramReloginCredentials)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramReloginCredentials == null) || (TextUtils.isEmpty(paramReloginCredentials.account)) || (TextUtils.isEmpty(paramReloginCredentials.password)) || (TextUtils.isEmpty(paramReloginCredentials.ubi)) || (TextUtils.isEmpty(paramReloginCredentials.accountType))) {
      return;
    }
    c(paramReloginCredentials.ubi);
    JSONObject localJSONObject2 = o();
    JSONObject localJSONObject1 = localJSONObject2;
    if (localJSONObject2 == null) {
      localJSONObject1 = new JSONObject();
    }
    try
    {
      localJSONObject1.put(paramString, paramReloginCredentials.toJSONObject());
      a("relogin_credentials", localJSONObject1.toString());
      return;
    }
    catch (JSONException paramString)
    {
      L.e(paramString);
    }
  }
  
  public void a(String paramString, Map<String, String> paramMap)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = paramMap;
      if (paramMap == null) {
        localObject = Collections.emptyMap();
      }
      try
      {
        paramMap = q();
        paramMap.put(paramString, localObject);
        paramString = new JSONObject();
        paramMap = paramMap.entrySet().iterator();
        while (paramMap.hasNext())
        {
          localObject = (Map.Entry)paramMap.next();
          paramString.put((String)((Map.Entry)localObject).getKey(), new JSONObject((Map)((Map.Entry)localObject).getValue()));
          continue;
          return;
        }
      }
      catch (Throwable paramString)
      {
        L.e(paramString);
      }
    }
    a("stat_items", paramString.toString());
  }
  
  public void a(boolean paramBoolean)
  {
    a("device_login_available", paramBoolean);
  }
  
  public SapiAccount.ReloginCredentials b(String paramString)
  {
    JSONObject localJSONObject = o();
    if (localJSONObject != null)
    {
      paramString = localJSONObject.optJSONObject(paramString);
      if (paramString != null)
      {
        paramString = SapiAccount.ReloginCredentials.fromJSONObject(paramString);
        paramString.ubi = p();
        return paramString;
      }
    }
    return new SapiAccount.ReloginCredentials();
  }
  
  public void b(SapiAccount paramSapiAccount)
  {
    if (paramSapiAccount == null) {
      return;
    }
    List localList = e();
    if (!localList.contains(paramSapiAccount)) {
      localList.add(paramSapiAccount);
    }
    for (;;)
    {
      a(a(localList, 5));
      return;
      localList.remove(localList.indexOf(paramSapiAccount));
      localList.add(paramSapiAccount);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    a("hosts_hijacked", paramBoolean);
  }
  
  public boolean b()
  {
    return b("device_login_available", false);
  }
  
  public void c(SapiAccount paramSapiAccount)
  {
    if (paramSapiAccount == null) {
      return;
    }
    List localList = f();
    if (!localList.contains(paramSapiAccount)) {
      localList.add(paramSapiAccount);
    }
    for (;;)
    {
      b(localList);
      return;
      localList.set(localList.indexOf(paramSapiAccount), paramSapiAccount);
    }
  }
  
  void c(String paramString)
  {
    a("cuidtoken", paramString);
  }
  
  public boolean c()
  {
    return b("hosts_hijacked", false);
  }
  
  public SapiAccount d()
  {
    SapiAccount localSapiAccount = null;
    if (!TextUtils.isEmpty(f("current_account"))) {}
    try
    {
      localSapiAccount = SapiAccount.fromJSONObject(new JSONObject(f("current_account")));
      return localSapiAccount;
    }
    catch (JSONException localJSONException) {}
    return null;
  }
  
  public void d(SapiAccount paramSapiAccount)
  {
    if (paramSapiAccount == null) {}
    List localList;
    do
    {
      return;
      localList = e();
    } while (!localList.contains(paramSapiAccount));
    localList.remove(paramSapiAccount);
    a(localList);
  }
  
  public void d(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      Map localMap = q();
      if (localMap.containsKey(paramString)) {
        localMap.remove(paramString);
      }
      a("stat_items", new JSONObject(localMap).toString());
      return;
    }
    catch (Throwable paramString)
    {
      L.e(paramString);
    }
  }
  
  public List<SapiAccount> e()
  {
    if (!TextUtils.isEmpty(f("share_accounts"))) {
      try
      {
        List localList = a(SapiAccount.fromJSONArray(new JSONArray(f("share_accounts"))), 5);
        return localList;
      }
      catch (Throwable localThrowable)
      {
        return new ArrayList();
      }
    }
    return new ArrayList();
  }
  
  public void e(SapiAccount paramSapiAccount)
  {
    if (paramSapiAccount == null) {}
    for (;;)
    {
      return;
      Object localObject = d();
      if ((localObject != null) && (!TextUtils.isEmpty(paramSapiAccount.uid)) && (paramSapiAccount.uid.equals(((SapiAccount)localObject).uid)))
      {
        a(null);
        a.a().b(paramSapiAccount);
        if (SapiAccountManager.getGlobalAuthorizationListener() == null) {}
      }
      try
      {
        SapiAccountManager.getGlobalAuthorizationListener().onLogoutSuccess(paramSapiAccount);
        localObject = f();
        if (!((List)localObject).contains(paramSapiAccount)) {
          continue;
        }
        ((List)localObject).remove(paramSapiAccount);
        b((List)localObject);
        return;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          L.e(localThrowable);
        }
      }
    }
  }
  
  public void e(String paramString)
  {
    a("root_status", paramString);
  }
  
  public List<SapiAccount> f()
  {
    if (!TextUtils.isEmpty(f("login_accounts"))) {
      try
      {
        List localList = SapiAccount.fromJSONArray(new JSONArray(f("login_accounts")));
        return localList;
      }
      catch (Exception localException)
      {
        return new ArrayList();
      }
    }
    return new ArrayList();
  }
  
  public boolean g()
  {
    if (b("first_install", true))
    {
      a("first_install", false);
      return true;
    }
    return false;
  }
  
  public boolean h()
  {
    return b("login_status_changed", false);
  }
  
  public void i()
  {
    a("login_status_changed", false);
  }
  
  public c j()
  {
    Object localObject = f("sapi_options");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      try
      {
        localObject = c.a(new JSONObject((String)localObject));
        return (c)localObject;
      }
      catch (JSONException localJSONException) {}
    }
    return new c();
  }
  
  public Map<String, String> k()
  {
    return j().d();
  }
  
  public List<String> l()
  {
    return j().e();
  }
  
  public String m()
  {
    return j().a();
  }
  
  public Map<String, Integer> n()
  {
    j();
    return c.i();
  }
  
  public JSONObject o()
  {
    Object localObject = f("relogin_credentials");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      try
      {
        localObject = new JSONObject((String)localObject);
        return (JSONObject)localObject;
      }
      catch (JSONException localJSONException) {}
    }
    return null;
  }
  
  String p()
  {
    return f("cuidtoken");
  }
  
  public Map<String, Map<String, String>> q()
  {
    HashMap localHashMap1 = new HashMap();
    Object localObject = f("stat_items");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    for (;;)
    {
      String str1;
      HashMap localHashMap2;
      try
      {
        localObject = new JSONObject((String)localObject);
        Iterator localIterator1 = ((JSONObject)localObject).keys();
        if (localIterator1.hasNext())
        {
          str1 = (String)localIterator1.next();
          localHashMap2 = new HashMap();
          JSONObject localJSONObject = ((JSONObject)localObject).optJSONObject(str1);
          if (localJSONObject != null)
          {
            Iterator localIterator2 = localJSONObject.keys();
            if (localIterator2.hasNext())
            {
              String str2 = (String)localIterator2.next();
              String str3 = localJSONObject.optString(str2);
              if ((TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3))) {
                continue;
              }
              localHashMap2.put(str2, str3);
              continue;
            }
          }
        }
        else
        {
          return localHashMap1;
        }
      }
      catch (Throwable localThrowable)
      {
        L.e(localThrowable);
      }
      localHashMap1.put(str1, localHashMap2);
    }
  }
  
  public int r()
  {
    return b("time_offset_seconds", 0);
  }
  
  public long s()
  {
    return System.currentTimeMillis() / 1000L + r();
  }
  
  public int t()
  {
    return b("app_version_code", 0);
  }
  
  public long u()
  {
    long l1 = b("device_info_read_times", 0L) + 1L;
    a("device_info_read_times", l1);
    return l1;
  }
  
  public String v()
  {
    return f("root_status");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/sapi2/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */