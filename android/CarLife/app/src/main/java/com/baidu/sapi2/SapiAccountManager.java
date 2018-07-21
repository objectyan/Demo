package com.baidu.sapi2;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.sapi2.share.a;
import com.baidu.sapi2.utils.L;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatService;
import com.baidu.sapi2.utils.d;
import com.baidu.sapi2.utils.e;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public final class SapiAccountManager
{
  public static final String SESSION_BDUSS = "bduss";
  public static final String SESSION_DISPLAYNAME = "displayname";
  public static final String SESSION_PTOKEN = "ptoken";
  public static final String SESSION_STOKEN = "stoken";
  public static final String SESSION_UID = "uid";
  public static final int VERSION_CODE = 80;
  public static final String VERSION_NAME = "6.14.5";
  private static SapiAccountManager a;
  private static SapiConfiguration b;
  private static SapiAccountService c;
  private static SilentShareListener d;
  private static ReceiveShareListener e;
  private static GlobalAuthorizationListener f;
  private static final List<String> g = new ArrayList();
  
  static
  {
    g.addAll(Arrays.asList(new String[] { "uid", "displayname", "bduss", "ptoken", "stoken" }));
  }
  
  @TargetApi(3)
  static String a(Context paramContext)
  {
    try
    {
      int i = Process.myPid();
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if (localRunningAppProcessInfo.pid == i)
        {
          paramContext = localRunningAppProcessInfo.processName;
          return paramContext;
        }
      }
    }
    catch (Throwable paramContext)
    {
      L.e(paramContext);
    }
    return "";
  }
  
  static String b(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128).processName;
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      L.e(paramContext);
    }
    return "";
  }
  
  static boolean c(Context paramContext)
  {
    String str = a(paramContext);
    paramContext = b(paramContext);
    return (TextUtils.isEmpty(str)) || (TextUtils.isEmpty(paramContext)) || (str.equals(paramContext));
  }
  
  public static GlobalAuthorizationListener getGlobalAuthorizationListener()
  {
    return f;
  }
  
  public static SapiAccountManager getInstance()
  {
    try
    {
      if (a == null) {
        a = new SapiAccountManager();
      }
      SapiAccountManager localSapiAccountManager = a;
      return localSapiAccountManager;
    }
    finally {}
  }
  
  public static ReceiveShareListener getReceiveShareListener()
  {
    return e;
  }
  
  public static SilentShareListener getSilentShareListener()
  {
    return d;
  }
  
  public static void registerGlobalAuthorizationListener(GlobalAuthorizationListener paramGlobalAuthorizationListener)
  {
    f = paramGlobalAuthorizationListener;
  }
  
  public static void registerReceiveShareListener(ReceiveShareListener paramReceiveShareListener)
  {
    e = paramReceiveShareListener;
  }
  
  public static void registerSilentShareListener(SilentShareListener paramSilentShareListener)
  {
    d = paramSilentShareListener;
  }
  
  public static void unregisterGlobalAuthorizationListener()
  {
    f = null;
  }
  
  public static void unregisterReceiveShareListener()
  {
    e = null;
  }
  
  public static void unregisterSilentShareListener()
  {
    d = null;
  }
  
  void a()
  {
    if (b == null) {
      throw new IllegalStateException(getClass().getSimpleName() + " have not been initialized");
    }
  }
  
  boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (g.contains(paramString));
  }
  
  public SapiAccountService getAccountService()
  {
    a();
    return c;
  }
  
  public List<SapiAccount> getLoginAccounts()
  {
    a();
    return b.a(b.context).f();
  }
  
  public SapiConfiguration getSapiConfiguration()
  {
    a();
    return b;
  }
  
  public SapiAccount getSession()
  {
    a();
    return b.a(b.context).d();
  }
  
  public String getSession(String paramString)
  {
    a();
    return getSession(paramString, null);
  }
  
  public String getSession(String paramString1, String paramString2)
  {
    a();
    Object localObject = getSession();
    if ((!a(paramString1)) || (!isLogin()) || (localObject == null)) {}
    do
    {
      return paramString2;
      localObject = ((SapiAccount)localObject).toJSONObject();
    } while (localObject == null);
    return ((JSONObject)localObject).optString(paramString1, paramString2);
  }
  
  public List<SapiAccount> getShareAccounts()
  {
    a();
    ArrayList localArrayList = new ArrayList();
    if (b.loginShareStrategy() == LoginShareStrategy.DISABLED) {
      return localArrayList;
    }
    Iterator localIterator = b.a(b.context).e().iterator();
    while (localIterator.hasNext())
    {
      SapiAccount localSapiAccount = (SapiAccount)localIterator.next();
      if (SapiUtils.isValidAccount(localSapiAccount)) {
        localArrayList.add(localSapiAccount);
      } else {
        b.a(b.context).d(localSapiAccount);
      }
    }
    Collections.reverse(localArrayList);
    return localArrayList;
  }
  
  public void init(final SapiConfiguration paramSapiConfiguration)
  {
    if (paramSapiConfiguration == null) {
      try
      {
        throw new IllegalArgumentException(getClass().getSimpleName() + " initialized failed: SapiConfiguration can't be null");
      }
      finally {}
    }
    if (b == null)
    {
      b = paramSapiConfiguration;
      c = new SapiAccountService(paramSapiConfiguration.context);
      if (c(paramSapiConfiguration.context)) {
        new Thread(new Runnable()
        {
          public void run()
          {
            int i = SapiUtils.getVersionCode(paramSapiConfiguration.context);
            if ((paramSapiConfiguration.silentShareOnUpgrade) && (i > b.a(paramSapiConfiguration.context).t())) {
              SapiUtils.resetSilentShareStatus(paramSapiConfiguration.context);
            }
            b.a(paramSapiConfiguration.context).a(i);
            paramSapiConfiguration.clientId = SapiUtils.getClientId(paramSapiConfiguration.context);
            paramSapiConfiguration.clientIp = SapiUtils.getLocalIpAddress();
            a.b();
            if (paramSapiConfiguration.syncCacheOnInit) {
              SapiCache.init(paramSapiConfiguration.context);
            }
            if (!TextUtils.isEmpty(paramSapiConfiguration.deviceLoginSignKey)) {
              SapiAccountManager.b().deviceLoginCheck();
            }
            StatService.a();
            e.a(paramSapiConfiguration.context);
          }
        }).start();
      }
    }
    for (;;)
    {
      return;
      L.d(getClass().getSimpleName() + " had already been initialized", new Object[0]);
    }
  }
  
  public boolean isLogin()
  {
    a();
    return b.a(b.context).d() != null;
  }
  
  public void logout()
  {
    StatService.a("logout", Collections.singletonMap("di", d.b("sdk_api_logout")));
    removeLoginAccount(getSession());
  }
  
  public void removeLoginAccount(SapiAccount paramSapiAccount)
  {
    a();
    b.a(b.context).e(paramSapiAccount);
  }
  
  public boolean validate(SapiAccount paramSapiAccount)
  {
    a();
    if (!SapiUtils.isValidAccount(paramSapiAccount)) {
      return false;
    }
    a.a().a(paramSapiAccount);
    return true;
  }
  
  public static abstract class GlobalAuthorizationListener
  {
    public void onLogoutSuccess(SapiAccount paramSapiAccount) {}
  }
  
  public static abstract interface ReceiveShareListener
  {
    public abstract void onReceiveShare();
  }
  
  public static abstract interface SilentShareListener
  {
    public abstract void onSilentShare();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/sapi2/SapiAccountManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */