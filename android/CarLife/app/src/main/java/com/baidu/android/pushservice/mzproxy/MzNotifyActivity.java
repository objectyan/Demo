package com.baidu.android.pushservice.mzproxy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.pushservice.PushManager;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class MzNotifyActivity
  extends Activity
{
  private String a;
  private String b;
  private String c;
  private String d = null;
  private String e;
  
  private String a(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.MAIN");
    localIntent.addCategory("android.intent.category.LAUNCHER");
    localIntent.setPackage(paramString);
    paramContext = paramContext.getPackageManager().queryIntentActivities(localIntent, 0).iterator();
    while (paramContext.hasNext())
    {
      paramString = (ResolveInfo)paramContext.next();
      if (paramString.activityInfo != null) {
        return paramString.activityInfo.name;
      }
    }
    return null;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    int i = 0;
    super.onCreate(paramBundle);
    for (;;)
    {
      try
      {
        paramBundle = getIntent().getStringExtra("extras");
        if (!TextUtils.isEmpty(paramBundle))
        {
          paramBundle = new JSONObject("{\"extras\":" + paramBundle + "}");
          Object localObject;
          if (!paramBundle.isNull("extras"))
          {
            paramBundle = paramBundle.getJSONArray("extras");
            if (paramBundle != null)
            {
              if (i < paramBundle.length())
              {
                localObject = paramBundle.getJSONObject(i);
                if (!((JSONObject)localObject).isNull("Msgid")) {
                  this.a = ((JSONObject)localObject).getString("Msgid");
                }
                if (((JSONObject)localObject).isNull("msgBody")) {
                  break label414;
                }
                this.c = ((JSONObject)localObject).getString("msgBody");
                break label414;
              }
              if (!TextUtils.isEmpty(this.c))
              {
                paramBundle = new JSONObject(this.c);
                if (!paramBundle.isNull("custom_content")) {
                  this.d = paramBundle.getString("custom_content");
                }
                if (!paramBundle.isNull("pkg_content")) {
                  this.e = paramBundle.getString("pkg_content");
                }
                if (!paramBundle.isNull("mzsigninfo")) {
                  this.b = paramBundle.getString("mzsigninfo");
                }
              }
            }
          }
          paramBundle = this.a + this.d;
          if (PushManager.hwMessageVerify(this, this.b, paramBundle.replaceAll("\\\\", "")))
          {
            if (!TextUtils.isEmpty(this.e)) {
              break label361;
            }
            paramBundle = new Intent();
            localObject = a(this, getPackageName());
            paramBundle.setClassName(getPackageName(), (String)localObject);
            paramBundle.setFlags(268435456);
            localObject = new JSONObject(this.d);
            Iterator localIterator = ((JSONObject)localObject).keys();
            if (!localIterator.hasNext()) {
              break label389;
            }
            String str = (String)localIterator.next();
            paramBundle.putExtra(str, ((JSONObject)localObject).optString(str));
            continue;
          }
        }
        paramBundle = Intent.parseUri(this.e, 0);
      }
      catch (Exception paramBundle)
      {
        finish();
        return;
      }
      label361:
      paramBundle.setPackage(getPackageName());
      paramBundle.addFlags(268435456);
      continue;
      label389:
      if (getPackageManager().queryIntentActivities(paramBundle, 0).size() > 0)
      {
        startActivity(paramBundle);
        continue;
        label414:
        i += 1;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/mzproxy/MzNotifyActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */