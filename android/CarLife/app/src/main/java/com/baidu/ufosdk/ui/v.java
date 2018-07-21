package com.baidu.ufosdk.ui;

import android.text.TextUtils;
import com.baidu.ufosdk.UfoSDK;
import com.baidu.ufosdk.a;
import com.baidu.ufosdk.e.b;
import com.baidu.ufosdk.util.c;
import org.json.JSONObject;

final class v
  implements Runnable
{
  v(u paramu) {}
  
  public final void run()
  {
    try
    {
      Object localObject = "appid=" + UfoSDK.appid;
      localObject = b.a(a.am, (String)localObject);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new JSONObject((String)localObject);
        c.a(((JSONObject)localObject).toString());
        FeedbackFacePageActivity.a(u.a(this.a), (JSONObject)localObject);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/ui/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */