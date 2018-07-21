package com.baidu.android.pushservice.opproxy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.pushservice.j.p;

public class OpNotifyActivity
  extends Activity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Object localObject = getIntent();
    if (localObject != null)
    {
      paramBundle = ((Intent)localObject).getStringExtra("msgid");
      String str1 = ((Intent)localObject).getStringExtra("opsigninfo");
      String str2 = ((Intent)localObject).getStringExtra("custom_content");
      localObject = ((Intent)localObject).getStringExtra("pkg_content");
      if ((!TextUtils.isEmpty(paramBundle)) && (!TextUtils.isEmpty(str1)))
      {
        Intent localIntent = new Intent("com.baidu.android.pushservice.action.OPPO_CLICK");
        localIntent.putExtra("op_notification_sign", str1);
        localIntent.putExtra("op_notification_msg_id", paramBundle);
        localIntent.putExtra("op_notification_pkg_content", (String)localObject);
        localIntent.putExtra("extra_extra_custom_content", str2);
        p.a(localIntent, getApplicationContext());
      }
    }
    finish();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/opproxy/OpNotifyActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */