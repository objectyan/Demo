package com.baidu.carlife.util;

import android.animation.ObjectAnimator;
import android.os.Build.VERSION;
import android.widget.TextView;
import com.baidu.carlife.core.a;
import com.baidu.carlife.core.l;

public class w
{
  private static w b = new w();
  private TextView a;
  
  public static w a()
  {
    return b;
  }
  
  public static void a(int paramInt)
  {
    a(a.a().getString(paramInt));
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    a(a.a().getString(paramInt1), paramInt2);
  }
  
  public static void a(String paramString)
  {
    a(paramString, 0);
  }
  
  public static void a(String paramString, int paramInt)
  {
    a().b(paramString, paramInt);
  }
  
  public static void b()
  {
    a().c();
  }
  
  private void b(final String paramString, final int paramInt)
  {
    l.a().post(new Runnable()
    {
      public void run()
      {
        if (w.a(w.this) != null)
        {
          w.a(w.this).setText(paramString);
          long l = 2500L;
          if (paramInt == 1) {
            l = 3500L;
          }
          ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(w.a(w.this), "alpha", new float[] { 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F }).setDuration(l);
          if (Build.VERSION.SDK_INT >= 18) {
            localObjectAnimator.setAutoCancel(true);
          }
          localObjectAnimator.start();
        }
      }
    });
  }
  
  private void c()
  {
    this.a = null;
  }
  
  public void a(TextView paramTextView)
  {
    this.a = paramTextView;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/util/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */