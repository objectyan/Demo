package com.baidu.sapi2.utils;

import android.text.TextUtils;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.utils.enums.SocialType;
import org.json.JSONException;
import org.json.JSONObject;

public class c
{
  public static final String a = "is_social_account";
  public static final String b = "social_type";
  public static final String c = "social_portrait";
  
  public static void a(SapiAccount paramSapiAccount, SocialType paramSocialType, String paramString)
  {
    a(paramSapiAccount, "is_social_account", Boolean.valueOf(true));
    a(paramSapiAccount, "social_type", Integer.valueOf(paramSocialType.getType()));
    a(paramSapiAccount, "social_portrait", paramString);
  }
  
  public static void a(SapiAccount paramSapiAccount, String paramString, Object paramObject)
  {
    if ((paramSapiAccount == null) || (TextUtils.isEmpty(paramString)) || (paramObject == null)) {
      return;
    }
    JSONObject localJSONObject;
    if (TextUtils.isEmpty(paramSapiAccount.extra)) {
      try
      {
        localJSONObject = new JSONObject();
        localJSONObject.put(paramString, paramObject);
        paramSapiAccount.extra = localJSONObject.toString();
        return;
      }
      catch (JSONException paramSapiAccount)
      {
        L.e(paramSapiAccount);
        return;
      }
    }
    try
    {
      localJSONObject = new JSONObject(paramSapiAccount.extra);
      localJSONObject.put(paramString, paramObject);
      paramSapiAccount.extra = localJSONObject.toString();
      return;
    }
    catch (JSONException paramSapiAccount)
    {
      L.e(paramSapiAccount);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/sapi2/utils/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */