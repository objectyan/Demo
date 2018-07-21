package com.baidu.navi.favorite.http;

import android.text.TextUtils;
import com.baidu.carlife.k.a.d;
import com.baidu.carlife.k.a.e;
import com.baidu.navi.favorite.sync.FamilyAndCompanySyncManager;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.platform.comapi.util.a;
import org.json.JSONException;
import org.json.JSONObject;

public class AuthTokenSyncRequest
  extends e
{
  public static final String KEY = "YiVz0MC3b9UqsETN";
  public static final String SYNC_AUTH_ID = "sync_auth_id";
  public static final String SYNC_AUTH_TOKEN = "sync_auth_token";
  
  public AuthTokenSyncRequest()
  {
    this.tag = AuthTokenSyncRequest.class.getSimpleName();
  }
  
  public static byte[] hex2byte(String paramString)
  {
    paramString = paramString.getBytes();
    if (paramString.length % 2 != 0) {
      throw new IllegalArgumentException("长度不是偶数");
    }
    byte[] arrayOfByte = new byte[paramString.length / 2];
    int i = 0;
    while (i < paramString.length)
    {
      String str = new String(paramString, i, 2);
      arrayOfByte[(i / 2)] = ((byte)Integer.parseInt(str, 16));
      i += 2;
    }
    return arrayOfByte;
  }
  
  protected d getPostRequestParams()
  {
    return null;
  }
  
  protected String getUrl()
  {
    long l = System.currentTimeMillis();
    return "http://automap.baidu.com/naviauto/?__c=user&rt=login&ofmt=json&ctime=" + l + "&fromapp=carlife";
  }
  
  protected d getUrlParams()
  {
    return null;
  }
  
  public void reponseNoJsonCallBack(String paramString)
  {
    int k = -4;
    i = k;
    try
    {
      paramString = new String(a.b("YiVz0MC3b9UqsETN", hex2byte(paramString.trim())));
      j = k;
      i = k;
      if (!TextUtils.isEmpty(paramString))
      {
        i = k;
        Object localObject = new JSONObject(paramString).optJSONObject("result");
        i = k;
        paramString = ((JSONObject)localObject).optString("auth_id");
        i = k;
        localObject = ((JSONObject)localObject).optString("auth_token");
        i = k;
        LogUtil.e("family", "authId:" + paramString + "authToken:" + (String)localObject);
        j = k;
        i = k;
        if (!TextUtils.isEmpty(paramString))
        {
          j = k;
          i = k;
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            i = k;
            PreferenceHelper.getInstance(BNaviModuleManager.getContext()).putString("sync_auth_id", paramString);
            i = k;
            PreferenceHelper.getInstance(BNaviModuleManager.getContext()).putString("sync_auth_token", (String)localObject);
            i = 0;
            j = 0;
            new Thread(new Runnable()
            {
              public void run()
              {
                FamilyAndCompanySyncManager.getInstance().startSync();
              }
            }).start();
          }
        }
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        int j = i;
      }
    }
    notifyResponseListener(j);
  }
  
  protected int responseSuccessCallBack(String paramString)
    throws JSONException
  {
    return -4;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/favorite/http/AuthTokenSyncRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */