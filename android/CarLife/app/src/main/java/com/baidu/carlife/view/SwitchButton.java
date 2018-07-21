package com.baidu.carlife.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.CheckBox;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.baidu.navisdk.ui.routeguide.subview.widget.FrameAnimationController;
import com.baidu.navisdk.util.common.ScreenUtil;

public class SwitchButton
  extends CheckBox
{
  private static final float A = 350.0F;
  private static final float C = 15.0F;
  private static final int t = 255;
  private float B;
  private float D;
  private float E;
  private float F;
  private Paint a;
  private ViewParent b;
  private Context c;
  private Bitmap d;
  private Bitmap e;
  private Bitmap f;
  private Bitmap g;
  private Bitmap h;
  private RectF i;
  private PorterDuffXfermode j;
  private float k;
  private float l;
  private float m;
  private float n;
  private float o;
  private float p;
  private float q;
  private int r;
  private int s;
  private int u = 255;
  private boolean v = false;
  private boolean w;
  private CompoundButton.OnCheckedChangeListener x;
  private CompoundButton.OnCheckedChangeListener y;
  private boolean z;
  
  public SwitchButton(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SwitchButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842860);
  }
  
  public SwitchButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private float a(float paramFloat)
  {
    return paramFloat - this.q / 2.0F;
  }
  
  private void a()
  {
    this.z = false;
  }
  
  private void a(Context paramContext)
  {
    this.c = paramContext;
    this.a = new Paint();
    this.a.setColor(-1);
    Resources localResources = getResources();
    this.r = (ViewConfiguration.getPressedStateDuration() + ViewConfiguration.getTapTimeout());
    this.s = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.d = BitmapFactory.decodeResource(localResources, 2130838325);
    if (this.v)
    {
      this.f = BitmapFactory.decodeResource(localResources, 2130838329);
      this.g = BitmapFactory.decodeResource(localResources, 2130838328);
      this.h = BitmapFactory.decodeResource(localResources, 2130838326);
      this.e = this.g;
      this.q = this.f.getWidth();
      this.o = this.h.getWidth();
      this.p = this.h.getHeight();
      this.n = (this.q / 2.0F);
      this.m = (this.o - this.q / 2.0F);
      if (!this.v) {
        break label297;
      }
    }
    label297:
    for (float f1 = this.m;; f1 = this.n)
    {
      this.l = f1;
      this.k = a(this.l);
      this.B = ScreenUtil.getInstance().dip2px(350.0F);
      this.D = ScreenUtil.getInstance().dip2px(15.0F);
      this.i = new RectF(0.0F, this.D, this.h.getWidth(), this.f.getHeight() + this.D);
      this.j = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
      return;
      this.f = BitmapFactory.decodeResource(localResources, 2130838331);
      this.g = BitmapFactory.decodeResource(localResources, 2130838330);
      break;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    this.z = true;
    if (paramBoolean) {}
    for (float f1 = -this.B;; f1 = this.B)
    {
      this.F = f1;
      this.E = this.l;
      new b(null).run();
      return;
    }
  }
  
  private void b()
  {
    this.E += this.F * 16.0F / 1000.0F;
    if (this.E <= this.m)
    {
      a();
      this.E = this.m;
      setCheckedDelayed(true);
    }
    for (;;)
    {
      b(this.E);
      return;
      if (this.E >= this.n)
      {
        a();
        this.E = this.n;
        setCheckedDelayed(false);
      }
    }
  }
  
  private void b(float paramFloat)
  {
    this.l = paramFloat;
    this.k = a(this.l);
    invalidate();
  }
  
  private void setCheckedDelayed(final boolean paramBoolean)
  {
    postDelayed(new Runnable()
    {
      public void run()
      {
        SwitchButton.a(SwitchButton.this, paramBoolean);
      }
    }, 10L);
  }
  
  private void setInternalChecked(boolean paramBoolean)
  {
    this.v = paramBoolean;
    if (paramBoolean) {}
    for (float f1 = this.m;; f1 = this.n)
    {
      this.l = f1;
      this.k = a(this.l);
      invalidate();
      if (!this.w) {
        break;
      }
      return;
    }
    this.w = true;
    Object localObject = getResources();
    if (this.v)
    {
      this.f = BitmapFactory.decodeResource((Resources)localObject, 2130838329);
      this.g = BitmapFactory.decodeResource((Resources)localObject, 2130838328);
      this.e = this.g;
      invalidate();
      if (this.x != null)
      {
        localObject = this.x;
        if (this.v) {
          break label187;
        }
      }
    }
    label187:
    for (paramBoolean = true;; paramBoolean = false)
    {
      ((CompoundButton.OnCheckedChangeListener)localObject).onCheckedChanged(this, paramBoolean);
      if (this.y != null) {
        this.y.onCheckedChanged(this, this.v);
      }
      this.w = false;
      return;
      this.f = BitmapFactory.decodeResource((Resources)localObject, 2130838331);
      this.g = BitmapFactory.decodeResource((Resources)localObject, 2130838330);
      this.e = this.g;
      break;
    }
  }
  
  public boolean isChecked()
  {
    return this.v;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    paramCanvas.saveLayerAlpha(this.i, this.u, 31);
    paramCanvas.drawBitmap(this.h, 0.0F, this.D, this.a);
    this.a.setXfermode(this.j);
    if (this.v) {
      paramCanvas.drawBitmap(this.d, this.k, this.D, this.a);
    }
    for (;;)
    {
      this.a.setXfermode(null);
      paramCanvas.drawBitmap(this.e, this.k, this.D, this.a);
      paramCanvas.restore();
      return;
      paramCanvas.drawBitmap(this.d, this.k, this.D, this.a);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension((int)this.o, (int)(this.p + 2.0F * this.D));
  }
  
  public boolean performClick()
  {
    if (!this.v) {}
    for (boolean bool = true;; bool = false)
    {
      a(bool);
      return true;
    }
  }
  
  public void setChecked(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      setInternalChecked(paramBoolean);
      return;
    }
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i1 = 255;; i1 = 127)
    {
      this.u = i1;
      super.setEnabled(paramBoolean);
      return;
    }
  }
  
  public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    this.x = paramOnCheckedChangeListener;
  }
  
  void setOnCheckedChangeWidgetListener(CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    this.y = paramOnCheckedChangeListener;
  }
  
  public void toggle()
  {
    if (!this.v) {}
    for (boolean bool = true;; bool = false)
    {
      setInternalChecked(bool);
      return;
    }
  }
  
  private final class a
    implements Runnable
  {
    private a() {}
    
    public void run()
    {
      SwitchButton.this.performClick();
    }
  }
  
  private final class b
    implements Runnable
  {
    private b() {}
    
    public void run()
    {
      if (!SwitchButton.a(SwitchButton.this)) {
        return;
      }
      SwitchButton.b(SwitchButton.this);
      FrameAnimationController.requestAnimationFrame(this);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/view/SwitchButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */