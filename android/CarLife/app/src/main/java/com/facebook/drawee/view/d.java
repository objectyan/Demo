package com.facebook.drawee.view;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.internal.k;
import java.util.ArrayList;

public class d<DH extends com.facebook.drawee.g.b>
{
  @VisibleForTesting
  boolean a = false;
  @VisibleForTesting
  ArrayList<b<DH>> b = new ArrayList();
  
  public void a()
  {
    if (this.a) {}
    for (;;)
    {
      return;
      this.a = true;
      int i = 0;
      while (i < this.b.size())
      {
        ((b)this.b.get(i)).d();
        i += 1;
      }
    }
  }
  
  public void a(int paramInt)
  {
    b localb = (b)this.b.get(paramInt);
    if (this.a) {
      localb.f();
    }
    this.b.remove(paramInt);
  }
  
  public void a(int paramInt, b<DH> paramb)
  {
    k.a(paramb);
    k.a(paramInt, this.b.size() + 1);
    this.b.add(paramInt, paramb);
    if (this.a) {
      paramb.d();
    }
  }
  
  public void a(Canvas paramCanvas)
  {
    int i = 0;
    while (i < this.b.size())
    {
      Drawable localDrawable = b(i).j();
      if (localDrawable != null) {
        localDrawable.draw(paramCanvas);
      }
      i += 1;
    }
  }
  
  public void a(b<DH> paramb)
  {
    a(this.b.size(), paramb);
  }
  
  public boolean a(Drawable paramDrawable)
  {
    int i = 0;
    while (i < this.b.size())
    {
      if (paramDrawable == b(i).j()) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    int i = 0;
    while (i < this.b.size())
    {
      if (((b)this.b.get(i)).a(paramMotionEvent)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public b<DH> b(int paramInt)
  {
    return (b)this.b.get(paramInt);
  }
  
  public void b()
  {
    if (!this.a) {}
    for (;;)
    {
      return;
      this.a = false;
      int i = 0;
      while (i < this.b.size())
      {
        ((b)this.b.get(i)).f();
        i += 1;
      }
    }
  }
  
  public void c()
  {
    if (this.a)
    {
      int i = 0;
      while (i < this.b.size())
      {
        ((b)this.b.get(i)).f();
        i += 1;
      }
    }
    this.b.clear();
  }
  
  public int d()
  {
    return this.b.size();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/drawee/view/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */