package com.baidu.che.codriver.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageContainer;
import com.android.volley.toolbox.ImageLoader.ImageListener;
import com.baidu.carlife.CarlifeActivity;
import com.baidu.che.codriver.util.l;

public class CustomNetworkImageView
  extends ImageView
{
  private String a;
  private int b;
  private int c;
  private ImageLoader d;
  private ImageLoader.ImageContainer e;
  private Bitmap f;
  private boolean g;
  private Context h;
  
  public CustomNetworkImageView(Context paramContext)
  {
    this(paramContext, null);
    this.h = paramContext;
  }
  
  public CustomNetworkImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    this.h = paramContext;
  }
  
  public CustomNetworkImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.h = paramContext;
  }
  
  private void setDefaultImageOrNull()
  {
    if (this.b != 0)
    {
      setImageResource(this.b);
      return;
    }
    setImageBitmap((Bitmap)null);
  }
  
  public void a()
  {
    if ((this.e != null) && (this.e.getRequestUrl() != null) && (this.e.getRequestUrl().equals(this.a)))
    {
      int m = getWidth();
      int k = getHeight();
      ImageView.ScaleType localScaleType = getScaleType();
      int j = 0;
      int i = 0;
      if (getLayoutParams() != null)
      {
        if (getLayoutParams().width == -2)
        {
          j = 1;
          if (getLayoutParams().height != -2) {
            break label132;
          }
          i = 1;
        }
      }
      else
      {
        label90:
        if (j == 0) {
          break label137;
        }
        j = 0;
        label96:
        if (i == 0) {
          break label143;
        }
      }
      label132:
      label137:
      label143:
      for (i = 0;; i = k)
      {
        this.d.get(this.a, new ImageLoader.ImageListener()
        {
          public void onErrorResponse(VolleyError paramAnonymousVolleyError)
          {
            if (CustomNetworkImageView.a(CustomNetworkImageView.this) != 0) {
              CustomNetworkImageView.this.setImageResource(CustomNetworkImageView.a(CustomNetworkImageView.this));
            }
          }
          
          public void onResponse(final ImageLoader.ImageContainer paramAnonymousImageContainer, boolean paramAnonymousBoolean)
          {
            if (paramAnonymousBoolean) {
              CustomNetworkImageView.this.post(new Runnable()
              {
                public void run()
                {
                  CustomNetworkImageView.2.this.onResponse(paramAnonymousImageContainer, false);
                }
              });
            }
            do
            {
              return;
              if (paramAnonymousImageContainer.getBitmap() != null)
              {
                CustomNetworkImageView.this.setImageBitmap(paramAnonymousImageContainer.getBitmap());
                return;
              }
            } while (CustomNetworkImageView.b(CustomNetworkImageView.this) == 0);
            CustomNetworkImageView.this.setImageResource(CustomNetworkImageView.b(CustomNetworkImageView.this));
          }
        }, j, i, localScaleType);
        return;
        j = 0;
        break;
        i = 0;
        break label90;
        j = m;
        break label96;
      }
    }
    l.b(this.h, CarlifeActivity.c, this.a);
  }
  
  void a(final boolean paramBoolean)
  {
    int n = getWidth();
    int m = getHeight();
    ImageView.ScaleType localScaleType = getScaleType();
    int j = 0;
    int i = 0;
    label57:
    int k;
    if (getLayoutParams() != null)
    {
      if (getLayoutParams().width == -2)
      {
        j = 1;
        if (getLayoutParams().height != -2) {
          break label122;
        }
        i = 1;
      }
    }
    else
    {
      if ((j == 0) || (i == 0)) {
        break label127;
      }
      k = 1;
      label68:
      if ((n != 0) || (m != 0) || (k != 0))
      {
        if (!TextUtils.isEmpty(this.a)) {
          break label133;
        }
        if (this.e != null)
        {
          this.e.cancelRequest();
          this.e = null;
        }
        setDefaultImageOrNull();
      }
    }
    label122:
    label127:
    label133:
    do
    {
      return;
      j = 0;
      break;
      i = 0;
      break label57;
      k = 0;
      break label68;
      if ((this.e == null) || (this.e.getRequestUrl() == null)) {
        break label178;
      }
    } while (this.e.getRequestUrl().equals(this.a));
    this.e.cancelRequest();
    setDefaultImageOrNull();
    label178:
    if (j != 0)
    {
      j = 0;
      if (i == 0) {
        break label225;
      }
    }
    label225:
    for (i = 0;; i = m)
    {
      this.e = this.d.get(this.a, new ImageLoader.ImageListener()
      {
        public void onErrorResponse(VolleyError paramAnonymousVolleyError)
        {
          if (CustomNetworkImageView.a(CustomNetworkImageView.this) != 0) {
            CustomNetworkImageView.this.setImageResource(CustomNetworkImageView.a(CustomNetworkImageView.this));
          }
        }
        
        public void onResponse(final ImageLoader.ImageContainer paramAnonymousImageContainer, boolean paramAnonymousBoolean)
        {
          if ((paramAnonymousBoolean) && (paramBoolean)) {
            CustomNetworkImageView.this.post(new Runnable()
            {
              public void run()
              {
                CustomNetworkImageView.1.this.onResponse(paramAnonymousImageContainer, false);
              }
            });
          }
          do
          {
            return;
            if (paramAnonymousImageContainer.getBitmap() != null)
            {
              CustomNetworkImageView.this.setImageBitmap(paramAnonymousImageContainer.getBitmap());
              return;
            }
          } while (CustomNetworkImageView.b(CustomNetworkImageView.this) == 0);
          CustomNetworkImageView.this.setImageResource(CustomNetworkImageView.b(CustomNetworkImageView.this));
        }
      }, j, i, localScaleType);
      return;
      j = n;
      break;
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    invalidate();
  }
  
  protected void onDetachedFromWindow()
  {
    if (this.e != null)
    {
      this.e.cancelRequest();
      setImageBitmap((Bitmap)null);
      this.e = null;
    }
    super.onDetachedFromWindow();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    a(true);
    if (this.g) {
      setImageBitmap(this.f);
    }
  }
  
  public void setDefaultImageResId(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setErrorImageResId(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setImageUrl(String paramString, ImageLoader paramImageLoader)
  {
    this.g = false;
    this.a = paramString;
    this.d = paramImageLoader;
    a(false);
    a();
  }
  
  public void setLocalImageBitmap(Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      this.g = true;
    }
    this.f = paramBitmap;
    requestLayout();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/widget/CustomNetworkImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */