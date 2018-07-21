package com.baidu.carlife.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.NinePatchDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.carlife.R.p;
import com.baidu.carlife.core.i;

public class CircularImageView
  extends ImageView
{
  private int a = 0;
  private Context b;
  private int c = 17170445;
  
  public CircularImageView(Context paramContext)
  {
    super(paramContext);
    this.b = paramContext;
  }
  
  public CircularImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.b = paramContext;
    setCustomAttributes(paramAttributeSet);
  }
  
  public CircularImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.b = paramContext;
    setCustomAttributes(paramAttributeSet);
  }
  
  private Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    int m = paramBitmap.getWidth();
    int k = paramBitmap.getHeight();
    int i = getWidth();
    int n = getHeight();
    int j = i;
    if (i <= 0) {
      j = m;
    }
    i = n;
    if (n <= 0) {
      i = k;
    }
    Object localObject = getScaleType();
    if (localObject == null) {
      return paramBitmap;
    }
    Rect localRect;
    switch (1.a[localObject.ordinal()])
    {
    case 2: 
    case 3: 
    case 4: 
    default: 
      if (j / i > m / k)
      {
        n = (int)(m / (k / i));
        j = i;
        i = n;
        localObject = new Rect(0, 0, m, k);
        localRect = new Rect(0, 0, i, j);
      }
      break;
    }
    for (;;)
    {
      try
      {
        localObject = a(paramBitmap, paramInt, (Rect)localObject, localRect, i, j);
        paramBitmap = (Bitmap)localObject;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        int i1;
        int i2;
        int i3;
        i.e("CircularImageView", localOutOfMemoryError.toString());
        continue;
      }
      catch (Exception localException)
      {
        i.e("CircularImageView", localException.toString());
        continue;
      }
      return paramBitmap;
      if (j / i > m / k)
      {
        n = Math.min(i, k);
        i1 = (int)(m / (k / n));
        i2 = (j - i1) / 2;
        i3 = (i - n) / 2;
        localObject = new Rect(0, 0, m, k);
        localRect = new Rect(i2, i3, i2 + i1, i3 + n);
        k = i;
        i = j;
        j = k;
      }
      else
      {
        i1 = Math.min(j, m);
        n = (int)(k / (m / i1));
        continue;
        i = j;
        j = (int)(k / (m / j));
        break;
        if (j / i > m / k)
        {
          i2 = m;
          i3 = (int)(i * (m / j));
          n = 0;
          i1 = (k - i3) / 2;
          m = i2;
          k = i3;
          i2 = i;
          localObject = new Rect(n, i1, n + m, i1 + k);
          localRect = new Rect(0, 0, j, i2);
          i = j;
          j = i2;
        }
        else
        {
          n = (int)(j * (k / i));
          i2 = (m - n) / 2;
          i1 = 0;
          m = n;
          n = i2;
          continue;
          n = i;
          localObject = new Rect(0, 0, m, k);
          localRect = new Rect(0, 0, j, n);
          i = j;
          j = n;
          continue;
          j = Math.min(j, m);
          n = Math.min(i, k);
          i = (m - j) / 2;
          k = (k - n) / 2;
          localObject = new Rect(i, k, i + j, k + n);
          localRect = new Rect(0, 0, j, n);
          i = j;
          j = n;
        }
      }
    }
  }
  
  private Bitmap a(Bitmap paramBitmap, int paramInt1, Rect paramRect1, Rect paramRect2, int paramInt2, int paramInt3)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramInt2, paramInt3, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    paramRect2 = new RectF(paramRect2);
    localPaint.setAntiAlias(true);
    localCanvas.drawARGB(0, 0, 0, 0);
    localPaint.setColor(-16777216);
    localCanvas.drawRoundRect(paramRect2, paramInt1, paramInt1, localPaint);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    localCanvas.drawBitmap(paramBitmap, paramRect1, paramRect2, localPaint);
    return localBitmap;
  }
  
  private void setCustomAttributes(AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet == null) {
      return;
    }
    paramAttributeSet = this.b.obtainStyledAttributes(paramAttributeSet, R.p.circularimageview);
    this.a = paramAttributeSet.getDimensionPixelSize(0, 0);
    this.c = paramAttributeSet.getColor(1, this.c);
    paramAttributeSet.recycle();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    Object localObject = getDrawable();
    if (localObject == null) {}
    do
    {
      do
      {
        return;
      } while ((getWidth() == 0) || (getHeight() == 0));
      measure(0, 0);
    } while (localObject.getClass() == NinePatchDrawable.class);
    localObject = ((BitmapDrawable)localObject).getBitmap();
    int j = getWidth();
    int k = getHeight();
    if (j < k) {}
    for (int i = j;; i = k)
    {
      i = i / 2 - this.a;
      localObject = a((Bitmap)localObject, i);
      Paint localPaint = new Paint();
      localPaint.setAntiAlias(true);
      localPaint.setFilterBitmap(true);
      localPaint.setDither(true);
      localPaint.setColor(this.c);
      paramCanvas.drawCircle(j / 2, k / 2, this.a + i, localPaint);
      paramCanvas.drawBitmap((Bitmap)localObject, j / 2 - i, k / 2 - i, null);
      return;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/view/CircularImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */