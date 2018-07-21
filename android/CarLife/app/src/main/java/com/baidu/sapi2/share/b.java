package com.baidu.sapi2.share;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.utils.L;
import com.baidu.sapi2.utils.SapiDataEncryptor;
import com.baidu.sapi2.utils.a;
import java.io.File;

public final class b
{
  private static String a = null;
  
  static SapiAccount a(Context paramContext, SapiAccount paramSapiAccount)
  {
    if ((paramContext == null) || (paramSapiAccount == null)) {
      return null;
    }
    SapiAccount localSapiAccount = new SapiAccount();
    localSapiAccount.displayname = a(paramContext, paramSapiAccount.displayname);
    localSapiAccount.uid = a(paramContext, paramSapiAccount.uid);
    localSapiAccount.username = a(paramContext, paramSapiAccount.username);
    localSapiAccount.app = a(paramContext, paramSapiAccount.app);
    localSapiAccount.bduss = a(paramContext, paramSapiAccount.bduss);
    localSapiAccount.ptoken = a(paramContext, paramSapiAccount.ptoken);
    localSapiAccount.stoken = a(paramContext, paramSapiAccount.stoken);
    localSapiAccount.email = a(paramContext, paramSapiAccount.email);
    localSapiAccount.extra = a(paramContext, paramSapiAccount.extra);
    localSapiAccount.phone = a(paramContext, paramSapiAccount.phone);
    return localSapiAccount;
  }
  
  private static String a(Context paramContext)
  {
    if (a != null) {
      return a;
    }
    Object localObject1 = null;
    String str1 = null;
    Object localObject2 = null;
    if (Build.VERSION.SDK_INT < 23) {
      localObject1 = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
    }
    String str2 = Build.MODEL;
    paramContext = (Context)localObject2;
    if ("mounted".equals(Environment.getExternalStorageState()))
    {
      paramContext = new StatFs(Environment.getExternalStorageDirectory().getPath());
      str1 = paramContext.getBlockSize() + "";
      paramContext = paramContext.getBlockCount() + "";
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (paramContext = String.format("%1$s-%2$s-%3$s-%4$s", new Object[] { str2, localObject1, str1, paramContext });; paramContext = String.format("%1$s-%2$s-%3$s", new Object[] { str2, str1, paramContext }))
    {
      localObject1 = paramContext.substring(0, 16);
      paramContext = (Context)localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        paramContext = "----------------";
      }
      localObject1 = paramContext;
      if (paramContext.length() < 16) {
        localObject1 = (paramContext + "----------------").substring(0, 16);
      }
      a = (String)localObject1;
      return a;
    }
  }
  
  public static String a(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    try
    {
      paramContext = SapiDataEncryptor.a(new a("AES", "AES/CBC/PKCS5Padding").a(paramString, "8070605040302010", a(paramContext)));
      return paramContext;
    }
    catch (Exception paramContext)
    {
      L.e(paramContext);
    }
    return null;
  }
  
  static SapiAccount b(Context paramContext, SapiAccount paramSapiAccount)
  {
    if ((paramContext == null) || (paramSapiAccount == null)) {
      return null;
    }
    SapiAccount localSapiAccount = new SapiAccount();
    localSapiAccount.displayname = b(paramContext, paramSapiAccount.displayname);
    localSapiAccount.uid = b(paramContext, paramSapiAccount.uid);
    localSapiAccount.username = b(paramContext, paramSapiAccount.username);
    localSapiAccount.app = b(paramContext, paramSapiAccount.app);
    localSapiAccount.bduss = b(paramContext, paramSapiAccount.bduss);
    localSapiAccount.ptoken = b(paramContext, paramSapiAccount.ptoken);
    localSapiAccount.stoken = b(paramContext, paramSapiAccount.stoken);
    localSapiAccount.email = b(paramContext, paramSapiAccount.email);
    localSapiAccount.extra = b(paramContext, paramSapiAccount.extra);
    localSapiAccount.phone = b(paramContext, paramSapiAccount.phone);
    return localSapiAccount;
  }
  
  public static String b(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    try
    {
      paramContext = new String(new a("AES", "AES/CBC/PKCS5Padding").a(SapiDataEncryptor.b(paramString), "8070605040302010", a(paramContext))).trim();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      L.e(paramContext);
    }
    return null;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/sapi2/share/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */