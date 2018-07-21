package com.baidu.che.codriver.a;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.Window;
import com.baidu.che.codriver.util.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class b
{
  private static final float a = 160.0F;
  private List<b> b = new ArrayList();
  
  private b()
  {
    this.b.add(b.a);
    this.b.add(b.b);
    this.b.add(b.c);
    this.b.add(b.d);
    this.b.add(b.e);
  }
  
  public static b a()
  {
    return a.a();
  }
  
  private void a(Resources paramResources, int paramInt, float paramFloat)
  {
    Configuration localConfiguration = paramResources.getConfiguration();
    DisplayMetrics localDisplayMetrics = paramResources.getDisplayMetrics();
    float f = paramInt / 160.0F;
    localConfiguration.densityDpi = paramInt;
    localConfiguration.fontScale = paramFloat;
    localDisplayMetrics.densityDpi = paramInt;
    localDisplayMetrics.density = f;
    localDisplayMetrics.scaledDensity = f;
    paramResources.updateConfiguration(localConfiguration, localDisplayMetrics);
    h.c("ScreenAdapter", "[new] densityDpi=" + paramInt + ",density=scaledDensity=" + f + ",fontScale=" + paramFloat);
  }
  
  public void a(final Activity paramActivity)
  {
    View localView = paramActivity.getWindow().getDecorView();
    localView.setSystemUiVisibility(3842);
    localView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener()
    {
      public void onSystemUiVisibilityChange(int paramAnonymousInt)
      {
        paramActivity.getWindow().getDecorView().setSystemUiVisibility(3842);
      }
    });
  }
  
  public boolean a(Context paramContext)
  {
    int i = paramContext.getResources().getDisplayMetrics().widthPixels;
    int j = paramContext.getResources().getDisplayMetrics().heightPixels;
    return i * 1.0F / j > 1.7777778F;
  }
  
  public void b(Context paramContext)
  {
    paramContext = paramContext.getResources();
    Object localObject1 = paramContext.getConfiguration();
    Object localObject2 = paramContext.getDisplayMetrics();
    int i = ((DisplayMetrics)localObject2).widthPixels;
    int j = ((DisplayMetrics)localObject2).heightPixels;
    int k = ((DisplayMetrics)localObject2).densityDpi;
    float f1 = ((DisplayMetrics)localObject2).density;
    float f2 = ((DisplayMetrics)localObject2).scaledDensity;
    float f3 = ((Configuration)localObject1).fontScale;
    h.c("ScreenAdapter", "resolution=" + i + "*" + j + ",densityDpi=" + k + ",density=" + f1 + ",scaledDensity=" + f2 + ",fontScale=" + f3);
    localObject1 = this.b.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (b)((Iterator)localObject1).next();
      if (((b)localObject2).a(i, j))
      {
        if (k != ((b)localObject2).h)
        {
          a(paramContext, ((b)localObject2).h, ((b)localObject2).i);
          return;
        }
        h.c("ScreenAdapter", "the screen params is standard");
        return;
      }
    }
    h.e("ScreenAdapter", "screen adapt failed, resolution=" + i + "*" + j);
  }
  
  private static final class a
  {
    private static final b a = new b(null);
  }
  
  static enum b
  {
    int f;
    int g;
    int h;
    float i;
    
    private b(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
    {
      this.f = paramInt1;
      this.g = paramInt2;
      this.h = paramInt3;
      this.i = paramFloat;
    }
    
    boolean a(int paramInt1, int paramInt2)
    {
      return (this.f == paramInt1) && (this.g == paramInt2);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */