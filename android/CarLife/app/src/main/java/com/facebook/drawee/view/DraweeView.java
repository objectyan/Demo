package com.facebook.drawee.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import com.facebook.common.internal.j;
import com.facebook.common.internal.j.a;
import javax.annotation.Nullable;

public class DraweeView<DH extends com.facebook.drawee.g.b>
  extends ImageView
{
  private final a.a a = new a.a();
  private float b = 0.0F;
  private b<DH> c;
  private boolean d = false;
  
  public DraweeView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public DraweeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public DraweeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  @TargetApi(21)
  public DraweeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    if (this.d) {}
    do
    {
      do
      {
        return;
        this.d = true;
        this.c = b.a(null, paramContext);
      } while (Build.VERSION.SDK_INT < 21);
      paramContext = getImageTintList();
    } while (paramContext == null);
    setColorFilter(paramContext.getDefaultColor());
  }
  
  public boolean a()
  {
    return this.c.i();
  }
  
  public boolean b()
  {
    return this.c.g() != null;
  }
  
  protected void c()
  {
    e();
  }
  
  protected void d()
  {
    f();
  }
  
  protected void e()
  {
    this.c.d();
  }
  
  protected void f()
  {
    this.c.f();
  }
  
  public float getAspectRatio()
  {
    return this.b;
  }
  
  @Nullable
  public com.facebook.drawee.g.a getController()
  {
    return this.c.g();
  }
  
  public DH getHierarchy()
  {
    return this.c.h();
  }
  
  @Nullable
  public Drawable getTopLevelDrawable()
  {
    return this.c.j();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    c();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    d();
  }
  
  public void onFinishTemporaryDetach()
  {
    super.onFinishTemporaryDetach();
    c();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    this.a.a = paramInt1;
    this.a.b = paramInt2;
    a.a(this.a, this.b, getLayoutParams(), getPaddingLeft() + getPaddingRight(), getPaddingTop() + getPaddingBottom());
    super.onMeasure(this.a.a, this.a.b);
  }
  
  public void onStartTemporaryDetach()
  {
    super.onStartTemporaryDetach();
    d();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.c.a(paramMotionEvent)) {
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setAspectRatio(float paramFloat)
  {
    if (paramFloat == this.b) {
      return;
    }
    this.b = paramFloat;
    requestLayout();
  }
  
  public void setController(@Nullable com.facebook.drawee.g.a parama)
  {
    this.c.a(parama);
    super.setImageDrawable(this.c.j());
  }
  
  public void setHierarchy(DH paramDH)
  {
    this.c.a(paramDH);
    super.setImageDrawable(this.c.j());
  }
  
  @Deprecated
  public void setImageBitmap(Bitmap paramBitmap)
  {
    a(getContext());
    this.c.a(null);
    super.setImageBitmap(paramBitmap);
  }
  
  @Deprecated
  public void setImageDrawable(Drawable paramDrawable)
  {
    a(getContext());
    this.c.a(null);
    super.setImageDrawable(paramDrawable);
  }
  
  @Deprecated
  public void setImageResource(int paramInt)
  {
    a(getContext());
    this.c.a(null);
    super.setImageResource(paramInt);
  }
  
  @Deprecated
  public void setImageURI(Uri paramUri)
  {
    a(getContext());
    this.c.a(null);
    super.setImageURI(paramUri);
  }
  
  public String toString()
  {
    j.a locala = j.a(this);
    if (this.c != null) {}
    for (String str = this.c.toString();; str = "<no holder set>") {
      return locala.a("holder", str).toString();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/facebook/drawee/view/DraweeView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */