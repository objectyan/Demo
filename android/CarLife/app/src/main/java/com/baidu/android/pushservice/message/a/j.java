package com.baidu.android.pushservice.message.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.pushservice.g.a;
import com.baidu.android.pushservice.k.f;
import com.baidu.android.pushservice.message.PublicMsg;
import com.baidu.android.pushservice.message.i;
import org.json.JSONException;
import org.json.JSONObject;

public final class j
{
  public static PublicMsg a(Context paramContext, String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    boolean bool = true;
    PublicMsg localPublicMsg = new PublicMsg();
    localPublicMsg.mMsgId = paramString1;
    localPublicMsg.mAppId = paramString2;
    try
    {
      paramString1 = new JSONObject(new String(paramArrayOfByte));
      if (!paramString1.isNull("title")) {
        localPublicMsg.mTitle = paramString1.getString("title");
      }
      if (!paramString1.isNull("description")) {
        localPublicMsg.mDescription = paramString1.getString("description");
      }
      if (!paramString1.isNull("url")) {
        localPublicMsg.mUrl = paramString1.getString("url");
      }
      if (!paramString1.isNull("notification_builder_id")) {
        localPublicMsg.mNotificationBuilder = paramString1.getInt("notification_builder_id");
      }
      if (!paramString1.isNull("open_type")) {
        localPublicMsg.mOpenType = paramString1.getInt("open_type");
      }
      if (!paramString1.isNull("notification_basic_style")) {
        localPublicMsg.mNotificationBasicStyle = paramString1.getInt("notification_basic_style");
      }
      if (!paramString1.isNull("custom_content")) {
        localPublicMsg.mCustomContent = paramString1.getString("custom_content");
      }
      if (!paramString1.isNull("net_support")) {
        localPublicMsg.mNetType = paramString1.getInt("net_support");
      }
      if (!paramString1.isNull("app_situation"))
      {
        paramString2 = paramString1.getJSONObject("app_situation");
        if (paramString2.getInt("as_is_support") != 1) {
          break label307;
        }
      }
      for (;;)
      {
        localPublicMsg.mIsSupportApp = bool;
        localPublicMsg.mSupportAppname = paramString2.getString("as_pkg_name");
        if (!paramString1.isNull("pkg_name")) {
          localPublicMsg.mPkgName = paramString1.getString("pkg_name");
        }
        if (!paramString1.isNull("pkg_vercode")) {
          localPublicMsg.mPkgVercode = paramString1.getInt("pkg_vercode");
        }
        if (!paramString1.isNull("pkg_content")) {
          localPublicMsg.mPkgContent = paramString1.getString("pkg_content");
        }
        return localPublicMsg;
        label307:
        bool = false;
      }
      return null;
    }
    catch (JSONException paramString1)
    {
      a.a("PublicMsgParser", paramString1, paramContext.getApplicationContext());
    }
  }
  
  public static i a(Context paramContext, String paramString)
  {
    paramContext = new i();
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramString);
      if (!localJSONObject1.isNull("msgContent"))
      {
        localJSONObject1 = localJSONObject1.getJSONObject("msgContent");
        JSONObject localJSONObject2;
        if (!localJSONObject1.isNull("adContent"))
        {
          localJSONObject2 = localJSONObject1.getJSONObject("adContent");
          paramContext.e = localJSONObject2.getString("notifyTitle");
          paramContext.f = localJSONObject2.getString("content");
          if (!localJSONObject2.isNull("param"))
          {
            localJSONObject2 = localJSONObject2.getJSONObject("param");
            if (!localJSONObject2.isNull("url")) {
              paramContext.a = localJSONObject2.getString("url");
            }
            if (localJSONObject2.isNull("intentUri")) {
              break label256;
            }
            paramContext.c = localJSONObject2.getString("intentUri");
          }
        }
        if (!localJSONObject1.isNull("psContent"))
        {
          localJSONObject2 = localJSONObject1.getJSONObject("psContent");
          paramContext.g = localJSONObject2.getString("notifyTitle");
          paramContext.h = localJSONObject2.getString("content");
          if (!localJSONObject2.isNull("param"))
          {
            localJSONObject2 = localJSONObject2.getJSONObject("param");
            if (!localJSONObject2.isNull("url")) {
              paramContext.b = localJSONObject2.getString("url");
            }
            if (localJSONObject2.isNull("intentUri")) {
              break label278;
            }
            paramContext.d = localJSONObject2.getString("intentUri");
          }
        }
        for (;;)
        {
          if (!localJSONObject1.isNull("extras")) {
            paramContext.a(localJSONObject1.getJSONArray("extras"));
          }
          if (!TextUtils.isEmpty(paramContext.l)) {
            break label300;
          }
          paramContext.l = f.a(paramString.getBytes(), false);
          return paramContext;
          label256:
          if (localJSONObject2.isNull("acn")) {
            break;
          }
          paramContext.c = localJSONObject2.getString("acn");
          break;
          label278:
          if (!localJSONObject2.isNull("acn")) {
            paramContext.d = localJSONObject2.getString("acn");
          }
        }
      }
      label300:
      return paramContext;
    }
    catch (Exception paramString) {}
    return paramContext;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/message/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */