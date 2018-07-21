package com.baidu.ufosdk.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;
import com.baidu.ufosdk.util.l;

@SuppressLint({"NewApi"})
public final class e
{
  private static Display a;
  private static int b;
  private static int c;
  
  public static int[] a(Context paramContext)
  {
    if (b == 0)
    {
      if (a == null) {
        a = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
      }
      paramContext = new Point();
      if (l.a() >= 13) {
        break label91;
      }
      paramContext.set(a.getWidth(), a.getHeight());
    }
    for (;;)
    {
      b = paramContext.x;
      c = paramContext.y;
      return new int[] { b, c };
      label91:
      a.getSize(paramContext);
    }
  }
  
  public static String b(Context paramContext)
  {
    paramContext = a(paramContext);
    return paramContext[0] + "x" + paramContext[1];
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/b/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */