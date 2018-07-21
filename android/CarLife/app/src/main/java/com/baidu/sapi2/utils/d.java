package com.baidu.sapi2.utils;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.baidu.android.common.security.MD5Util;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class d
{
  private static final int a = 4;
  private static final String b = Character.toString('\001');
  private static final String c = "android";
  private static final String d = TextUtils.join("", new String[] { "O", "a", "L", "h", "z", "O", "K", "T", "T", "Q", "G", "L", "w", "8", "h", "P" });
  
  static String a()
  {
    if (!TextUtils.isEmpty(Build.VERSION.RELEASE)) {
      return Build.VERSION.RELEASE;
    }
    return "";
  }
  
  static List<String> a(String paramString)
  {
    Context localContext = SapiAccountManager.getInstance().getSapiConfiguration().context;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localContext.getPackageName());
    localArrayList.add(SapiUtils.getVersionName(localContext));
    localArrayList.add("6.14.5");
    localArrayList.add(b());
    localArrayList.add(a());
    localArrayList.add("android");
    localArrayList.add(SapiUtils.getClientId(localContext));
    localArrayList.add(SapiAccountManager.getInstance().getSapiConfiguration().tpl);
    localArrayList.add(String.valueOf(SapiAccountManager.getInstance().getShareAccounts().size()));
    localArrayList.add(TextUtils.join(",", c()));
    if (paramString != null)
    {
      localArrayList.add(paramString);
      localArrayList.add(String.valueOf(b.a(localContext).u()));
      paramString = SapiAccountManager.getInstance().getSession();
      if (paramString == null) {
        break label264;
      }
    }
    label264:
    for (paramString = paramString.uid;; paramString = "")
    {
      localArrayList.add(paramString);
      localArrayList.add(SapiUtils.getNetworkClass(localContext));
      String str = b.a(localContext).v();
      paramString = str;
      if (TextUtils.isEmpty(str))
      {
        paramString = String.valueOf(SapiUtils.isRoot());
        b.a(localContext).e(paramString);
      }
      localArrayList.add(paramString);
      localArrayList.add(SapiUtils.getWifiInfo(localContext));
      return localArrayList;
      paramString = "";
      break;
    }
  }
  
  static String b()
  {
    if (!TextUtils.isEmpty(Build.MODEL)) {
      return Build.MODEL;
    }
    return "";
  }
  
  public static String b(String paramString)
  {
    try
    {
      String str = TextUtils.join(b, a(paramString));
      paramString = d();
      str = e.a.b(new a().a(str, paramString, d));
      paramString = TextUtils.join("_", new String[] { paramString, str, MD5Util.toMd5(TextUtils.join("_", new String[] { paramString, str, "check" }).getBytes(), false).substring(0, 6) });
      return paramString;
    }
    catch (Throwable paramString)
    {
      L.e(paramString);
    }
    return "";
  }
  
  static List<String> c()
  {
    Object localObject = SapiAccountManager.getInstance().getShareAccounts();
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(((SapiAccount)((Iterator)localObject).next()).uid);
    }
    return localArrayList;
  }
  
  static String d()
  {
    return String.format("%02d", new Object[] { Integer.valueOf(new Random().nextInt(100)) }) + System.currentTimeMillis() / 1000L + String.format("%03d", new Object[] { Integer.valueOf(4) }) + "0";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/sapi2/utils/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */