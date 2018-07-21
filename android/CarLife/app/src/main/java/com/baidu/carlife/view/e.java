package com.baidu.carlife.view;

import com.baidu.carlife.core.i;
import java.util.Calendar;

public abstract class e
  implements f
{
  private static final String a = "CarlifeTouchManager#KeyListener";
  private static final int b = 300;
  private long c = 0L;
  
  public void a(String paramString)
  {
    long l = Calendar.getInstance().getTimeInMillis();
    if (l - this.c > 300L)
    {
      i.b("CarlifeTouchManager#KeyListener", "...........onKey key=" + paramString);
      this.c = l;
      b(paramString);
      return;
    }
    i.e("CarlifeTouchManager#KeyListener", "you click too fast, need to throw away, key=" + paramString);
  }
  
  public abstract void b(String paramString);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/view/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */