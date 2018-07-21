package com.facebook.drawee.view;

import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import javax.annotation.Nullable;

public class a
{
  public static void a(a parama, float paramFloat, @Nullable ViewGroup.LayoutParams paramLayoutParams, int paramInt1, int paramInt2)
  {
    if ((paramFloat <= 0.0F) || (paramLayoutParams == null)) {}
    do
    {
      return;
      if (a(paramLayoutParams.height))
      {
        parama.b = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int)((View.MeasureSpec.getSize(parama.a) - paramInt1) / paramFloat + paramInt2), parama.b), 1073741824);
        return;
      }
    } while (!a(paramLayoutParams.width));
    parama.a = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int)((View.MeasureSpec.getSize(parama.b) - paramInt2) * paramFloat + paramInt1), parama.a), 1073741824);
  }
  
  private static boolean a(int paramInt)
  {
    return (paramInt == 0) || (paramInt == -2);
  }
  
  public static class a
  {
    public int a;
    public int b;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/drawee/view/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */