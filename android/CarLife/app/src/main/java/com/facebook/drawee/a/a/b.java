package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.f.g;
import com.facebook.imagepipeline.f.h;
import com.facebook.imagepipeline.f.j;

public class b
{
  private static e a;
  
  public static e a()
  {
    return a;
  }
  
  public static void a(Context paramContext)
  {
    j.a(paramContext);
    b(paramContext);
  }
  
  public static void a(Context paramContext, h paramh)
  {
    j.a(paramh);
    b(paramContext);
  }
  
  public static d b()
  {
    return a.a();
  }
  
  private static void b(Context paramContext)
  {
    a = new e(paramContext);
    SimpleDraweeView.a(a);
  }
  
  public static j c()
  {
    return j.a();
  }
  
  public static g d()
  {
    return c().j();
  }
  
  public static void e()
  {
    a = null;
    SimpleDraweeView.g();
    j.b();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/drawee/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */