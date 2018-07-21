package com.baidu.che.codriver.i;

import android.text.TextUtils;
import com.baidu.che.codriver.util.h;

public class a
{
  private static final String a = "CarLifeVrUtil";
  private static String b;
  private static String c;
  
  public static String a()
  {
    if (TextUtils.isEmpty(b)) {
      b = com.baidu.che.codriver.a.a.a();
    }
    h.b("CarLifeVrUtil", "mChannel = " + b);
    return b;
  }
  
  public static void a(String paramString)
  {
    b = paramString;
  }
  
  public static String b()
  {
    if (TextUtils.isEmpty(c)) {
      c = com.baidu.che.codriver.a.a.b();
    }
    h.b("CarLifeVrUtil", "mAk = " + c);
    return c;
  }
  
  public static void b(String paramString)
  {
    c = paramString;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/i/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */