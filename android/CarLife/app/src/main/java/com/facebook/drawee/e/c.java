package com.facebook.drawee.e;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.facebook.drawee.b.c;
import com.facebook.drawee.d.q.c;
import javax.annotation.Nullable;

public class c
{
  @Nullable
  private static Drawable a(Context paramContext, TypedArray paramTypedArray, int paramInt)
  {
    paramInt = paramTypedArray.getResourceId(paramInt, 0);
    if (paramInt == 0) {
      return null;
    }
    return paramContext.getResources().getDrawable(paramInt);
  }
  
  @Nullable
  private static q.c a(TypedArray paramTypedArray, int paramInt)
  {
    switch (paramTypedArray.getInt(paramInt, -2))
    {
    default: 
      throw new RuntimeException("XML attribute not specified!");
    case -1: 
      return null;
    case 0: 
      return q.c.a;
    case 1: 
      return q.c.b;
    case 2: 
      return q.c.c;
    case 3: 
      return q.c.d;
    case 4: 
      return q.c.e;
    case 5: 
      return q.c.f;
    case 6: 
      return q.c.g;
    }
    return q.c.h;
  }
  
  public static a a(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    return b(paramContext, paramAttributeSet).u();
  }
  
  public static b a(b paramb, Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    int i = 0;
    int k = 0;
    int j = 0;
    int m = 0;
    boolean bool3 = true;
    boolean bool7 = true;
    boolean bool4 = true;
    boolean bool8 = true;
    boolean bool1 = true;
    boolean bool5 = true;
    boolean bool2 = true;
    boolean bool6 = true;
    if (paramAttributeSet != null) {
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, b.c.GenericDraweeHierarchy);
    }
    for (;;)
    {
      int n;
      int i2;
      try
      {
        int i1 = paramAttributeSet.getIndexCount();
        n = 0;
        j = m;
        bool4 = bool8;
        bool3 = bool7;
        bool2 = bool6;
        bool1 = bool5;
        i = k;
        k = n;
        if (k >= i1) {
          break label1283;
        }
        i2 = paramAttributeSet.getIndex(k);
        if (i2 == b.c.GenericDraweeHierarchy_actualImageScaleType)
        {
          paramb.e(a(paramAttributeSet, i2));
          m = i;
          bool5 = bool1;
          bool6 = bool2;
          bool7 = bool3;
          bool8 = bool4;
          n = j;
        }
        else if (i2 == b.c.GenericDraweeHierarchy_placeholderImage)
        {
          paramb.a(a(paramContext, paramAttributeSet, i2));
          m = i;
          bool5 = bool1;
          bool6 = bool2;
          bool7 = bool3;
          bool8 = bool4;
          n = j;
        }
      }
      finally
      {
        paramAttributeSet.recycle();
      }
      if (i2 == b.c.GenericDraweeHierarchy_pressedStateOverlayImage)
      {
        paramb.g(a(paramContext, paramAttributeSet, i2));
        m = i;
        bool5 = bool1;
        bool6 = bool2;
        bool7 = bool3;
        bool8 = bool4;
        n = j;
      }
      else if (i2 == b.c.GenericDraweeHierarchy_progressBarImage)
      {
        paramb.d(a(paramContext, paramAttributeSet, i2));
        m = i;
        bool5 = bool1;
        bool6 = bool2;
        bool7 = bool3;
        bool8 = bool4;
        n = j;
      }
      else if (i2 == b.c.GenericDraweeHierarchy_fadeDuration)
      {
        paramb.a(paramAttributeSet.getInt(i2, 0));
        m = i;
        bool5 = bool1;
        bool6 = bool2;
        bool7 = bool3;
        bool8 = bool4;
        n = j;
      }
      else if (i2 == b.c.GenericDraweeHierarchy_viewAspectRatio)
      {
        paramb.a(paramAttributeSet.getFloat(i2, 0.0F));
        m = i;
        bool5 = bool1;
        bool6 = bool2;
        bool7 = bool3;
        bool8 = bool4;
        n = j;
      }
      else if (i2 == b.c.GenericDraweeHierarchy_placeholderImageScaleType)
      {
        paramb.a(a(paramAttributeSet, i2));
        m = i;
        bool5 = bool1;
        bool6 = bool2;
        bool7 = bool3;
        bool8 = bool4;
        n = j;
      }
      else if (i2 == b.c.GenericDraweeHierarchy_retryImage)
      {
        paramb.b(a(paramContext, paramAttributeSet, i2));
        m = i;
        bool5 = bool1;
        bool6 = bool2;
        bool7 = bool3;
        bool8 = bool4;
        n = j;
      }
      else if (i2 == b.c.GenericDraweeHierarchy_retryImageScaleType)
      {
        paramb.b(a(paramAttributeSet, i2));
        m = i;
        bool5 = bool1;
        bool6 = bool2;
        bool7 = bool3;
        bool8 = bool4;
        n = j;
      }
      else if (i2 == b.c.GenericDraweeHierarchy_failureImage)
      {
        paramb.c(a(paramContext, paramAttributeSet, i2));
        m = i;
        bool5 = bool1;
        bool6 = bool2;
        bool7 = bool3;
        bool8 = bool4;
        n = j;
      }
      else if (i2 == b.c.GenericDraweeHierarchy_failureImageScaleType)
      {
        paramb.c(a(paramAttributeSet, i2));
        m = i;
        bool5 = bool1;
        bool6 = bool2;
        bool7 = bool3;
        bool8 = bool4;
        n = j;
      }
      else if (i2 == b.c.GenericDraweeHierarchy_progressBarImageScaleType)
      {
        paramb.d(a(paramAttributeSet, i2));
        m = i;
        bool5 = bool1;
        bool6 = bool2;
        bool7 = bool3;
        bool8 = bool4;
        n = j;
      }
      else if (i2 == b.c.GenericDraweeHierarchy_progressBarAutoRotateInterval)
      {
        m = paramAttributeSet.getInteger(i2, i);
        bool5 = bool1;
        bool6 = bool2;
        bool7 = bool3;
        bool8 = bool4;
        n = j;
      }
      else if (i2 == b.c.GenericDraweeHierarchy_backgroundImage)
      {
        paramb.e(a(paramContext, paramAttributeSet, i2));
        m = i;
        bool5 = bool1;
        bool6 = bool2;
        bool7 = bool3;
        bool8 = bool4;
        n = j;
      }
      else if (i2 == b.c.GenericDraweeHierarchy_overlayImage)
      {
        paramb.f(a(paramContext, paramAttributeSet, i2));
        m = i;
        bool5 = bool1;
        bool6 = bool2;
        bool7 = bool3;
        bool8 = bool4;
        n = j;
      }
      else if (i2 == b.c.GenericDraweeHierarchy_roundAsCircle)
      {
        a(paramb).a(paramAttributeSet.getBoolean(i2, false));
        m = i;
        bool5 = bool1;
        bool6 = bool2;
        bool7 = bool3;
        bool8 = bool4;
        n = j;
      }
      else if (i2 == b.c.GenericDraweeHierarchy_roundedCornerRadius)
      {
        n = paramAttributeSet.getDimensionPixelSize(i2, j);
        m = i;
        bool5 = bool1;
        bool6 = bool2;
        bool7 = bool3;
        bool8 = bool4;
      }
      else if (i2 == b.c.GenericDraweeHierarchy_roundTopLeft)
      {
        bool7 = paramAttributeSet.getBoolean(i2, bool3);
        m = i;
        bool5 = bool1;
        bool6 = bool2;
        bool8 = bool4;
        n = j;
      }
      else if (i2 == b.c.GenericDraweeHierarchy_roundTopRight)
      {
        bool8 = paramAttributeSet.getBoolean(i2, bool4);
        m = i;
        bool5 = bool1;
        bool6 = bool2;
        bool7 = bool3;
        n = j;
      }
      else if (i2 == b.c.GenericDraweeHierarchy_roundBottomLeft)
      {
        bool5 = paramAttributeSet.getBoolean(i2, bool1);
        m = i;
        bool6 = bool2;
        bool7 = bool3;
        bool8 = bool4;
        n = j;
      }
      else if (i2 == b.c.GenericDraweeHierarchy_roundBottomRight)
      {
        bool6 = paramAttributeSet.getBoolean(i2, bool2);
        m = i;
        bool5 = bool1;
        bool7 = bool3;
        bool8 = bool4;
        n = j;
      }
      else if (i2 == b.c.GenericDraweeHierarchy_roundWithOverlayColor)
      {
        a(paramb).a(paramAttributeSet.getColor(i2, 0));
        m = i;
        bool5 = bool1;
        bool6 = bool2;
        bool7 = bool3;
        bool8 = bool4;
        n = j;
      }
      else if (i2 == b.c.GenericDraweeHierarchy_roundingBorderWidth)
      {
        a(paramb).c(paramAttributeSet.getDimensionPixelSize(i2, 0));
        m = i;
        bool5 = bool1;
        bool6 = bool2;
        bool7 = bool3;
        bool8 = bool4;
        n = j;
      }
      else if (i2 == b.c.GenericDraweeHierarchy_roundingBorderColor)
      {
        a(paramb).b(paramAttributeSet.getColor(i2, 0));
        m = i;
        bool5 = bool1;
        bool6 = bool2;
        bool7 = bool3;
        bool8 = bool4;
        n = j;
      }
      else
      {
        m = i;
        bool5 = bool1;
        bool6 = bool2;
        bool7 = bool3;
        bool8 = bool4;
        n = j;
        if (i2 == b.c.GenericDraweeHierarchy_roundingBorderPadding)
        {
          a(paramb).d(paramAttributeSet.getDimensionPixelSize(i2, 0));
          m = i;
          bool5 = bool1;
          bool6 = bool2;
          bool7 = bool3;
          bool8 = bool4;
          n = j;
          break label1403;
          label1283:
          paramAttributeSet.recycle();
          if ((paramb.k() != null) && (i > 0)) {
            paramb.d(new com.facebook.drawee.d.b(paramb.k(), i));
          }
          float f1;
          float f2;
          label1346:
          float f3;
          if (j > 0)
          {
            paramContext = a(paramb);
            if (!bool3) {
              break label1380;
            }
            f1 = j;
            if (!bool4) {
              break label1385;
            }
            f2 = j;
            if (!bool2) {
              break label1391;
            }
            f3 = j;
            label1356:
            if (!bool1) {
              break label1397;
            }
          }
          label1380:
          label1385:
          label1391:
          label1397:
          for (float f4 = j;; f4 = 0.0F)
          {
            paramContext.a(f1, f2, f3, f4);
            return paramb;
            f1 = 0.0F;
            break;
            f2 = 0.0F;
            break label1346;
            f3 = 0.0F;
            break label1356;
          }
        }
      }
      label1403:
      k += 1;
      i = m;
      bool1 = bool5;
      bool2 = bool6;
      bool3 = bool7;
      bool4 = bool8;
      j = n;
    }
  }
  
  private static e a(b paramb)
  {
    if (paramb.t() == null) {
      paramb.a(new e());
    }
    return paramb.t();
  }
  
  public static b b(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    return a(new b(paramContext.getResources()), paramContext, paramAttributeSet);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/facebook/drawee/e/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */