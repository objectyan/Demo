package com.baidu.carlife.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageContainer;
import com.android.volley.toolbox.ImageLoader.ImageListener;
import com.baidu.carlife.BaiduNaviApplication;
import com.baidu.carlife.k.a.e;

public class MultiImageView
  extends ImageView
{
  private String a;
  private Drawable b;
  private ImageLoader c;
  private ImageLoader.ImageContainer d;
  
  public MultiImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MultiImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MultiImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(final boolean paramBoolean)
  {
    if (TextUtils.isEmpty(this.a))
    {
      if (this.d != null)
      {
        this.d.cancelRequest();
        this.d = null;
      }
      setDefaultImageOrNull();
    }
    int n;
    int m;
    ImageView.ScaleType localScaleType;
    int j;
    label77:
    label91:
    int k;
    label102:
    do
    {
      return;
      n = getWidth();
      m = getHeight();
      localScaleType = getScaleType();
      j = 0;
      i = 0;
      if (getLayoutParams() != null)
      {
        if (getLayoutParams().width != -2) {
          break label203;
        }
        j = 1;
        if (getLayoutParams().height != -2) {
          break label208;
        }
        i = 1;
      }
      if ((j == 0) || (i == 0)) {
        break label213;
      }
      k = 1;
      if ((n == 0) && (m == 0) && (k == 0)) {
        break label217;
      }
      if ((this.d == null) || (this.d.getRequestUrl() == null)) {
        break;
      }
    } while (this.d.getRequestUrl().equals(this.a));
    this.d.cancelRequest();
    setDefaultImageOrNull();
    if (j != 0)
    {
      j = 0;
      label168:
      if (i == 0) {
        break label225;
      }
    }
    label203:
    label208:
    label213:
    label217:
    label225:
    for (int i = 0;; i = m)
    {
      this.d = this.c.get(this.a, new ImageLoader.ImageListener()
      {
        public void onErrorResponse(VolleyError paramAnonymousVolleyError) {}
        
        public void onResponse(final ImageLoader.ImageContainer paramAnonymousImageContainer, boolean paramAnonymousBoolean)
        {
          if ((paramAnonymousBoolean) && (paramBoolean)) {
            MultiImageView.this.post(new Runnable()
            {
              public void run()
              {
                MultiImageView.1.this.onResponse(paramAnonymousImageContainer, false);
              }
            });
          }
          do
          {
            return;
            if (paramAnonymousImageContainer.getBitmap() != null)
            {
              MultiImageView.this.setImageBitmap(paramAnonymousImageContainer.getBitmap());
              return;
            }
          } while (MultiImageView.a(MultiImageView.this) == null);
          MultiImageView.this.setImageDrawable(MultiImageView.a(MultiImageView.this));
        }
      }, j, i, localScaleType);
      return;
      j = 0;
      break label77;
      i = 0;
      break label91;
      k = 0;
      break label102;
      break;
      j = n;
      break label168;
    }
  }
  
  private void setDefaultImageOrNull()
  {
    if (this.b != null)
    {
      setImageDrawable(this.b);
      return;
    }
    setImageBitmap(null);
  }
  
  private void setImageUrl(String paramString, ImageLoader paramImageLoader)
  {
    this.a = paramString;
    this.c = paramImageLoader;
    a(false);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    invalidate();
  }
  
  protected void onDetachedFromWindow()
  {
    if (this.d != null)
    {
      this.d.cancelRequest();
      setImageBitmap(null);
      this.d = null;
    }
    super.onDetachedFromWindow();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    a(true);
  }
  
  public void setDefaultDrawable(Drawable paramDrawable)
  {
    this.b = paramDrawable;
  }
  
  public void setDefaultDrawableResId(int paramInt)
  {
    this.b = BaiduNaviApplication.getInstance().getApplicationContext().getResources().getDrawable(paramInt);
  }
  
  public void setImageUrl(String paramString)
  {
    setImageUrl(paramString, e.getImageLoader());
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/view/MultiImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */