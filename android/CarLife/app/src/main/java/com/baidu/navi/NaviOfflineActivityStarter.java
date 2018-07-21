package com.baidu.navi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.carlife.CarlifeActivity;

public class NaviOfflineActivityStarter
  extends Activity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = new Intent(getIntent());
    paramBundle.setClass(this, CarlifeActivity.class);
    startActivity(paramBundle);
    finish();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/NaviOfflineActivityStarter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */