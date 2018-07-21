package com.baidu.carlife.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.baidu.carlife.core.i;
import java.util.Calendar;

public abstract class d
  implements View.OnClickListener
{
  private static final String a = "CarlifeTouchManager#ClickListener";
  public static final int b = 300;
  private long c = 0L;
  
  public abstract void a(View paramView);
  
  public void onClick(View paramView)
  {
    long l = Calendar.getInstance().getTimeInMillis();
    if (l - this.c > 300L)
    {
      this.c = l;
      a(paramView);
      return;
    }
    i.e("CarlifeTouchManager#ClickListener", "you click too fast, need to throw away");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/view/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */