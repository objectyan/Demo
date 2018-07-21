package com.baidu.android.pushservice.message;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.pushservice.g.a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class i
{
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public int i;
  public String j;
  public String k;
  public String l;
  public int m;
  public String n;
  public String o;
  
  public PublicMsg a(Context paramContext)
  {
    PublicMsg localPublicMsg = new PublicMsg();
    try
    {
      localPublicMsg.mMsgId = this.l;
      localPublicMsg.mAppId = this.k;
      if ((TextUtils.isEmpty(this.g)) && (TextUtils.isEmpty(this.h)))
      {
        localPublicMsg.mTitle = this.e;
        localPublicMsg.mDescription = this.f;
        localPublicMsg.mUrl = this.a;
        localPublicMsg.mPkgContent = this.c;
        return localPublicMsg;
      }
      localPublicMsg.mTitle = this.g;
      localPublicMsg.mDescription = this.h;
      localPublicMsg.mUrl = this.b;
      localPublicMsg.mPkgContent = this.d;
      return localPublicMsg;
    }
    catch (Exception localException)
    {
      a.b("ProxyPushMessage", "Public Message Parsing Fail:\r\n" + localException.getMessage(), paramContext.getApplicationContext());
    }
    return null;
  }
  
  public String a(Context paramContext, String paramString)
  {
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString)) {
          break;
        }
        paramContext = new JSONObject(paramString);
        if (paramContext.isNull("extras")) {
          break;
        }
        paramContext = paramContext.getJSONArray("extras");
        if (paramContext == null) {
          break;
        }
        a(paramContext);
        if (TextUtils.isEmpty(this.n)) {
          break;
        }
        paramString = new JSONObject(new String(this.n));
        if (!paramString.isNull("custom_content"))
        {
          paramContext = paramString.getString("custom_content");
          if (!paramString.isNull("hwsigninfo")) {
            this.o = paramString.getString("hwsigninfo");
          }
          return paramContext;
        }
      }
      catch (JSONException paramContext)
      {
        return null;
      }
      paramContext = null;
    }
    return null;
  }
  
  public void a(JSONArray paramJSONArray)
  {
    int i1 = 0;
    try
    {
      while (i1 < paramJSONArray.length())
      {
        JSONObject localJSONObject = paramJSONArray.getJSONObject(i1);
        if (!localJSONObject.isNull("Appid")) {
          this.k = localJSONObject.getString("Appid");
        }
        if (!localJSONObject.isNull("Msgid")) {
          this.l = localJSONObject.getString("Msgid");
        }
        if (!localJSONObject.isNull("Type")) {
          this.m = localJSONObject.getInt("Type");
        }
        if (!localJSONObject.isNull("push_type")) {
          this.i = localJSONObject.getInt("push_type");
        }
        if (!localJSONObject.isNull("gid")) {
          this.j = localJSONObject.getString("gid");
        }
        if (!localJSONObject.isNull("msgBody")) {
          this.n = localJSONObject.getString("msgBody");
        }
        i1 += 1;
      }
      return;
    }
    catch (Exception paramJSONArray) {}
  }
  
  public String b(Context paramContext, String paramString)
  {
    Object localObject = null;
    paramContext = (Context)localObject;
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = new JSONObject(paramString);
        paramContext = (Context)localObject;
        if (!paramString.isNull("extras"))
        {
          paramString = paramString.getJSONArray("extras");
          paramContext = (Context)localObject;
          if (paramString != null)
          {
            a(paramString);
            paramContext = (Context)localObject;
            if (!TextUtils.isEmpty(this.n))
            {
              paramString = new JSONObject(this.n);
              paramContext = (Context)localObject;
              if (!paramString.isNull("custom_content")) {
                paramContext = paramString.getString("custom_content");
              }
            }
          }
        }
      }
      return paramContext;
    }
    catch (JSONException paramContext) {}
    return null;
  }
  
  public String c(Context paramContext, String paramString)
  {
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString)) {
          break;
        }
        paramContext = new JSONObject(paramString);
        if (paramContext.isNull("extras")) {
          break;
        }
        paramContext = paramContext.getJSONArray("extras");
        if (paramContext == null) {
          break;
        }
        a(paramContext);
        if (TextUtils.isEmpty(this.n)) {
          break;
        }
        paramString = new JSONObject(this.n);
        if (!paramString.isNull("custom_content"))
        {
          paramContext = paramString.getString("custom_content");
          if (!paramString.isNull("mzsigninfo")) {
            this.o = paramString.getString("mzsigninfo");
          }
          return paramContext;
        }
      }
      catch (JSONException paramContext)
      {
        return null;
      }
      paramContext = null;
    }
    return null;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/message/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */