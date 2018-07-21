package com.baidu.sapi2.share;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccount.ReloginCredentials;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiAccountManager.SilentShareListener;
import com.baidu.sapi2.utils.L;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatService;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

final class c
{
  static String a(byte[] paramArrayOfByte)
  {
    String str = "";
    if (paramArrayOfByte == null) {
      return "";
    }
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.reset();
      localMessageDigest.update(paramArrayOfByte);
      paramArrayOfByte = b(localMessageDigest.digest());
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      for (;;)
      {
        L.e(paramArrayOfByte);
        paramArrayOfByte = str;
      }
    }
  }
  
  static List<Intent> a(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    Map localMap = com.baidu.sapi2.b.a(paramContext).n();
    if (paramContext == null) {}
    for (;;)
    {
      return localArrayList;
      try
      {
        Object localObject1 = paramContext.getPackageManager().queryIntentServices(new Intent("baidu.intent.action.account.SHARE_SERVICE"), 32);
        if (localObject1 == null) {
          continue;
        }
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = ((ResolveInfo)((Iterator)localObject1).next()).serviceInfo;
          if (localObject2 != null)
          {
            Intent localIntent = new Intent("baidu.intent.action.account.SHARE_SERVICE");
            localIntent.setClassName(((ServiceInfo)localObject2).packageName, ((ServiceInfo)localObject2).name);
            if (Build.VERSION.SDK_INT > 11) {
              localIntent.addFlags(32);
            }
            if (((TextUtils.isEmpty(((ServiceInfo)localObject2).permission)) || (paramContext.checkCallingOrSelfPermission(((ServiceInfo)localObject2).permission) == 0)) && (a(paramContext, localIntent.getComponent().getPackageName())) && (!paramContext.getPackageName().equals(localIntent.getComponent().getPackageName())))
            {
              int i = Integer.MAX_VALUE;
              localObject2 = localMap.keySet().iterator();
              while (((Iterator)localObject2).hasNext())
              {
                String str = (String)((Iterator)localObject2).next();
                if (localIntent.getComponent().getPackageName().matches(str)) {
                  i = ((Integer)localMap.get(str)).intValue();
                }
              }
              localHashMap.put(localIntent, Integer.valueOf(i));
            }
          }
        }
        paramContext = new ArrayList(localHashMap.entrySet());
      }
      catch (Throwable paramContext)
      {
        L.e(paramContext);
        return localArrayList;
      }
      Collections.sort(paramContext, new Comparator()
      {
        public int a(Map.Entry<Intent, Integer> paramAnonymousEntry1, Map.Entry<Intent, Integer> paramAnonymousEntry2)
        {
          return ((Integer)paramAnonymousEntry1.getValue()).compareTo((Integer)paramAnonymousEntry2.getValue());
        }
      });
      paramContext = paramContext.iterator();
      while (paramContext.hasNext()) {
        localArrayList.add(((Map.Entry)paramContext.next()).getKey());
      }
    }
  }
  
  static void a(Context paramContext, ShareModel paramShareModel)
  {
    if ((paramContext == null) || (paramShareModel == null)) {}
    do
    {
      do
      {
        return;
        paramShareModel.b(paramContext);
        paramContext = com.baidu.sapi2.b.a(paramContext);
      } while (paramShareModel.a().size() <= 0);
      paramShareModel = (SapiAccount)paramShareModel.a().get(0);
    } while ((paramContext.d() != null) && (paramContext.d().uid.equals(paramShareModel.uid)));
    paramContext.d(paramShareModel);
  }
  
  static void a(Context paramContext, LoginShareStrategy paramLoginShareStrategy, ShareModel paramShareModel)
  {
    if ((paramContext == null) || (paramLoginShareStrategy == null) || (paramShareModel == null)) {}
    for (;;)
    {
      return;
      com.baidu.sapi2.b localb;
      try
      {
        paramShareModel.b(paramContext);
        localb = com.baidu.sapi2.b.a(paramContext);
        if ((paramLoginShareStrategy != LoginShareStrategy.SILENT) || (localb.h()) || (localb.d() != null) || (paramShareModel.a().size() <= 0) || (!SapiUtils.isValidAccount((SapiAccount)paramShareModel.a().get(0)))) {
          break label224;
        }
        paramLoginShareStrategy = (SapiAccount)paramShareModel.a().get(0);
        localb.a(paramLoginShareStrategy);
        localb.c(paramLoginShareStrategy);
        localb.d(paramLoginShareStrategy);
        if (SapiAccountManager.getSilentShareListener() != null) {
          new Handler(Looper.getMainLooper()).post(new Runnable()
          {
            public void run()
            {
              if ((SapiAccountManager.getSilentShareListener() != null) && (this.a.d() != null)) {
                SapiAccountManager.getSilentShareListener().onSilentShare();
              }
            }
          });
        }
        paramShareModel = paramShareModel.a().iterator();
        while (paramShareModel.hasNext())
        {
          SapiAccount localSapiAccount = (SapiAccount)paramShareModel.next();
          if (a(paramContext, localSapiAccount)) {
            localb.b(localSapiAccount);
          }
        }
        paramContext = new HashMap();
      }
      finally {}
      paramContext.put("app", paramLoginShareStrategy.app);
      StatService.a("silent_login_share", paramContext);
      continue;
      label224:
      paramLoginShareStrategy = paramShareModel.a().iterator();
      while (paramLoginShareStrategy.hasNext())
      {
        paramShareModel = (SapiAccount)paramLoginShareStrategy.next();
        if (a(paramContext, paramShareModel)) {
          localb.b(paramShareModel);
        }
        b(paramContext, paramShareModel);
      }
    }
  }
  
  static boolean a(Context paramContext, SapiAccount paramSapiAccount)
  {
    if (paramContext == null) {}
    do
    {
      return false;
      paramContext = com.baidu.sapi2.b.a(paramContext);
    } while ((!SapiUtils.isValidAccount(paramSapiAccount)) || ((paramContext.d() != null) && (paramContext.d().uid.equals(paramSapiAccount.uid))) || (paramContext.f().contains(paramSapiAccount)));
    return true;
  }
  
  static boolean a(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {}
    Map localMap;
    String str;
    do
    {
      Iterator localIterator;
      while (!localIterator.hasNext())
      {
        do
        {
          return false;
          localMap = com.baidu.sapi2.b.a(paramContext).k();
          paramContext = b(paramContext, paramString);
        } while (TextUtils.isEmpty(paramContext));
        localIterator = localMap.keySet().iterator();
      }
      str = (String)localIterator.next();
    } while ((!paramString.matches(str)) || (!paramContext.equals(localMap.get(str))));
    return true;
  }
  
  static String b(Context paramContext, String paramString)
  {
    str = "";
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {
      return "";
    }
    try
    {
      paramString = paramContext.getPackageManager().getPackageInfo(paramString, 64);
      paramContext = str;
      if (paramString.signatures.length > 0) {
        paramContext = a(paramString.signatures[0].toByteArray());
      }
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        L.e(paramContext);
        paramContext = str;
      }
    }
    return paramContext;
  }
  
  static String b(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramArrayOfByte == null) {
      return localStringBuilder.toString();
    }
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str.length() == 1) {
        localStringBuilder.append("0");
      }
      localStringBuilder.append(str);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  static void b(Context paramContext, SapiAccount paramSapiAccount)
  {
    if ((paramContext == null) || (!SapiUtils.isValidAccount(paramSapiAccount))) {}
    for (;;)
    {
      return;
      paramContext = com.baidu.sapi2.b.a(paramContext);
      Object localObject = paramContext.d();
      if ((localObject != null) && (paramSapiAccount.uid.equals(((SapiAccount)localObject).uid)))
      {
        ((SapiAccount)localObject).bduss = paramSapiAccount.bduss;
        paramContext.a((SapiAccount)localObject);
      }
      localObject = paramContext.f().iterator();
      SapiAccount localSapiAccount;
      while (((Iterator)localObject).hasNext())
      {
        localSapiAccount = (SapiAccount)((Iterator)localObject).next();
        if (paramSapiAccount.uid.equals(localSapiAccount.uid))
        {
          localSapiAccount.bduss = paramSapiAccount.bduss;
          paramContext.c(localSapiAccount);
        }
      }
      localObject = paramContext.e().iterator();
      while (((Iterator)localObject).hasNext())
      {
        localSapiAccount = (SapiAccount)((Iterator)localObject).next();
        if (paramSapiAccount.uid.equals(localSapiAccount.uid))
        {
          localSapiAccount.bduss = paramSapiAccount.bduss;
          paramContext.b(localSapiAccount);
        }
      }
    }
  }
  
  static void b(Context paramContext, LoginShareStrategy paramLoginShareStrategy, ShareModel paramShareModel)
  {
    if ((paramContext == null) || (paramLoginShareStrategy == null) || (paramShareModel == null)) {
      return;
    }
    if (TextUtils.isEmpty(paramShareModel.c())) {
      paramShareModel.a(paramContext.getPackageName());
    }
    paramShareModel.a(paramLoginShareStrategy);
    paramShareModel.a(paramContext);
  }
  
  static boolean b(Context paramContext)
  {
    if (paramContext == null) {}
    String str1;
    String str2;
    String str3;
    do
    {
      Iterator localIterator;
      while (!localIterator.hasNext())
      {
        do
        {
          return false;
          str1 = c(paramContext);
          str2 = b(paramContext, str1);
          paramContext = com.baidu.sapi2.b.a(paramContext).k();
        } while ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)));
        localIterator = paramContext.keySet().iterator();
      }
      str3 = (String)localIterator.next();
    } while ((!str1.matches(str3)) || (!str2.equals(paramContext.get(str3))));
    return true;
  }
  
  static String c(Context paramContext)
  {
    str = "";
    if (paramContext == null) {
      return "";
    }
    try
    {
      String[] arrayOfString = paramContext.getPackageManager().getPackagesForUid(Binder.getCallingUid());
      paramContext = str;
      if (arrayOfString.length > 0) {
        paramContext = arrayOfString[0];
      }
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        L.e(paramContext);
        paramContext = str;
      }
    }
    return paramContext;
  }
  
  static void c(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return;
      try
      {
        paramString = new JSONObject(b.b(paramContext, paramString));
        Iterator localIterator = paramString.keys();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          com.baidu.sapi2.b.a(paramContext).a(str, SapiAccount.ReloginCredentials.fromJSONObject(paramString.optJSONObject(str)));
        }
        return;
      }
      catch (Throwable paramContext)
      {
        L.e(paramContext);
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/sapi2/share/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */