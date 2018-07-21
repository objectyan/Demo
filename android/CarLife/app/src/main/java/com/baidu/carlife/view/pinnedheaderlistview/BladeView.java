package com.baidu.carlife.view.pinnedheaderlistview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.carlife.l.a;
import com.baidu.carlife.util.r;

public class BladeView
  extends View
{
  int a = -1;
  Paint b = new Paint();
  boolean c = false;
  Runnable d = new Runnable()
  {
    public void run()
    {
      if ((BladeView.a(BladeView.this) != null) && (BladeView.a(BladeView.this).isShowing())) {
        BladeView.a(BladeView.this).dismiss();
      }
    }
  };
  private a e;
  private String[] f = { "A", ".", "D", ".", "G", ".", "K", ".", "O", ".", "R", ".", "W", ".", "Z", "#" };
  private String[] g = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" };
  private PopupWindow h;
  private TextView i;
  private Handler j = new Handler();
  
  public BladeView(Context paramContext)
  {
    super(paramContext);
  }
  
  public BladeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public BladeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(int paramInt)
  {
    if (this.e != null)
    {
      this.e.a(this.g[paramInt]);
      a(this.g[paramInt]);
    }
  }
  
  private void a(String paramString)
  {
    if (this.h == null)
    {
      this.j.removeCallbacks(this.d);
      this.i = new TextView(getContext());
      this.i.setBackground(r.b(2130838268));
      this.i.setTextColor(r.a(2131558703));
      this.i.setTextSize(getResources().getDimensionPixelSize(2131361813));
      this.i.setGravity(17);
      int k = getResources().getDimensionPixelSize(2131361814);
      int m = getResources().getDimensionPixelSize(2131361815);
      this.h = new PopupWindow(this.i, m, k);
    }
    this.i.setText(paramString);
    if (this.h.isShowing())
    {
      this.h.update();
      return;
    }
    this.h.showAtLocation(getRootView(), 17, 0, 0);
  }
  
  public void a()
  {
    this.c = false;
    this.a = -1;
    this.j.postDelayed(this.d, 800L);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int n = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getY();
    int i1 = this.a;
    int m = 0;
    int k = m;
    if (getHeight() > 0)
    {
      k = m;
      if (this.g.length > 0) {
        k = (int)(f1 / getHeight() * this.g.length);
      }
    }
    switch (n)
    {
    default: 
    case 0: 
    case 2: 
      do
      {
        do
        {
          return true;
          this.c = true;
        } while ((i1 == k) || (k < 0) || (k >= this.g.length));
        a(k);
        this.a = k;
        invalidate();
        return true;
      } while ((a.a().N()) || (i1 == k) || (k < 0) || (k >= this.g.length));
      a(k);
      this.a = k;
      invalidate();
      return true;
    }
    a();
    invalidate();
    return true;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int k = getHeight();
    int m = getWidth();
    int n = k / this.f.length;
    k = 0;
    while (k < this.f.length)
    {
      this.b.setColor(r.a(2131558651));
      this.b.setTextSize(getResources().getDimensionPixelSize(2131361812));
      this.b.setFakeBoldText(true);
      this.b.setAntiAlias(true);
      float f1 = m / 3;
      float f2 = n * k + n;
      paramCanvas.drawText(this.f[k], f1, f2, this.b);
      this.b.reset();
      k += 1;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setLetterDisplayList(String[] paramArrayOfString)
  {
    this.f = paramArrayOfString;
  }
  
  public void setOnItemClickListener(a parama)
  {
    this.e = parama;
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/view/pinnedheaderlistview/BladeView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */