package com.baidu.carlife.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.widget.TextView;

public class BatteryTextView
  extends TextView
{
  public BatteryTextView(Context paramContext)
  {
    super(paramContext);
    IntentFilter localIntentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    paramContext.registerReceiver(new BatteryReceiver(null), localIntentFilter);
  }
  
  private class BatteryReceiver
    extends BroadcastReceiver
  {
    private BatteryReceiver() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if ("android.intent.action.BATTERY_CHANGED".equals(paramIntent.getAction()))
      {
        int i = paramIntent.getIntExtra("level", 0);
        int j = paramIntent.getIntExtra("scale", 100);
        BatteryTextView.this.setText("电池电量为" + i * 100 / j + "%");
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/view/BatteryTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */