package com.baidu.android.pushservice.hwproxy;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.pushservice.f;
import com.baidu.android.pushservice.j.p;

public class HwNotifyActivity
  extends Activity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    try
    {
      paramBundle = getIntent();
      if (paramBundle != null)
      {
        Uri localUri = paramBundle.getData();
        String str1 = f.d(getApplicationContext(), paramBundle);
        String str2 = f.c(getApplicationContext(), paramBundle);
        if ((!TextUtils.isEmpty(str2)) && (localUri != null) && (f.a(getApplicationContext(), str2, str1))) {
          p.a(getApplicationContext(), paramBundle);
        }
      }
    }
    catch (Exception paramBundle)
    {
      for (;;) {}
    }
    finish();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/hwproxy/HwNotifyActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */