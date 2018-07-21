package com.baidu.sapi2.utils;

import android.os.Looper;
import android.text.TextUtils;
import com.baidu.cloudsdk.common.http.AsyncHttpClient;
import com.baidu.cloudsdk.common.http.HttpResponseHandler;
import com.baidu.cloudsdk.common.http.RequestParams;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class StatService
{
  private static final String a = "http://nsclick.baidu.com/v.gif";
  private static final Map<String, String> b = new HashMap();
  
  static
  {
    b.put("pid", "111");
    b.put("type", "1023");
    b.put("device", "android");
  }
  
  public static void a()
  {
    try
    {
      Iterator localIterator = b.a(SapiAccountManager.getInstance().getSapiConfiguration().context).q().entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        a((String)localEntry.getKey(), (Map)localEntry.getValue());
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      L.e(localThrowable);
    }
  }
  
  public static void a(final String paramString, Map<String, String> paramMap)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      try
      {
        final SapiConfiguration localSapiConfiguration = SapiAccountManager.getInstance().getSapiConfiguration();
        b.a(localSapiConfiguration.context).a(paramString, paramMap);
        if (SapiUtils.hasActiveNetwork(localSapiConfiguration.context))
        {
          HashMap localHashMap = new HashMap();
          localHashMap.putAll(b);
          localHashMap.put("name", paramString);
          localHashMap.put("tpl", localSapiConfiguration.tpl);
          localHashMap.put("clientfrom", "mobilesdk_enhanced");
          localHashMap.put("app_version", SapiUtils.getVersionName(localSapiConfiguration.context));
          localHashMap.put("sdk_version", "6.14.5");
          if (!TextUtils.isEmpty(localSapiConfiguration.clientId)) {
            localHashMap.put("cuid", localSapiConfiguration.clientId);
          }
          localHashMap.put("v", String.valueOf(System.currentTimeMillis()));
          if (paramMap != null)
          {
            paramMap = paramMap.entrySet().iterator();
            while (paramMap.hasNext())
            {
              Map.Entry localEntry = (Map.Entry)paramMap.next();
              if ((!TextUtils.isEmpty((CharSequence)localEntry.getKey())) && (!TextUtils.isEmpty((CharSequence)localEntry.getValue()))) {
                localHashMap.put(localEntry.getKey(), localEntry.getValue());
              }
            }
          }
          new AsyncHttpClient().get(localSapiConfiguration.context, "http://nsclick.baidu.com/v.gif", new RequestParams(localHashMap), new HttpResponseHandler(Looper.getMainLooper())
          {
            protected void onSuccess(int paramAnonymousInt, String paramAnonymousString)
            {
              b.a(localSapiConfiguration.context).d(paramString);
            }
          });
        }
      }
      catch (Throwable paramString)
      {
        L.e(paramString);
        return;
      }
    }
  }
  
  public static void onEvent(StatEvent paramStatEvent)
  {
    if ((paramStatEvent == null) || (TextUtils.isEmpty(paramStatEvent.a))) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("di", d.b(paramStatEvent.b));
    a(paramStatEvent.a, localHashMap);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/sapi2/utils/StatService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */