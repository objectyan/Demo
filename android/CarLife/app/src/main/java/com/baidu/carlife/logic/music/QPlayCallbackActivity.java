package com.baidu.carlife.logic.music;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.baidu.carlife.CarlifeActivity;
import com.baidu.carlife.core.k;

public class QPlayCallbackActivity
  extends Activity
{
  private void a()
  {
    Uri localUri = getIntent().getData();
    if (localUri != null)
    {
      if (localUri.getQueryParameter("qmlogin").equalsIgnoreCase("1"))
      {
        q.Y = true;
        k.a(3013, 1000);
      }
    }
    else {
      return;
    }
    q.Y = false;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a();
    startActivity(new Intent(this, CarlifeActivity.class));
    finish();
  }
  
  protected void onResume()
  {
    super.onResume();
    a();
    startActivity(new Intent(this, CarlifeActivity.class));
    finish();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/logic/music/QPlayCallbackActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */