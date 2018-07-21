package com.baidu.carlife.core.screen;

import android.content.Context;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.baidu.carlife.core.h;
import com.baidu.carlife.core.j;
import com.baidu.carlife.core.k;

public abstract class BaseDialog
  extends FrameLayout
  implements h
{
  protected static final String a = "BaseDialog";
  protected j b = new j()
  {
    public void careAbout()
    {
      addMsg(4140);
      addMsg(4001);
      addMsg(4002);
      addMsg(4003);
      addMsg(4004);
    }
    
    public void handleMessage(Message paramAnonymousMessage)
    {
      super.handleMessage(paramAnonymousMessage);
      switch (paramAnonymousMessage.what)
      {
      }
      do
      {
        return;
      } while (!BaseDialog.this.isShown());
      BaseDialog.this.d();
    }
  };
  protected Context c;
  protected boolean d = true;
  private e e;
  private d f;
  private boolean g = false;
  
  public BaseDialog(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BaseDialog(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BaseDialog(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.c = paramContext;
    addView(a(), i());
    b();
  }
  
  private FrameLayout.LayoutParams i()
  {
    int j = -1;
    FrameLayout.LayoutParams localLayoutParams = generateDefaultLayoutParams();
    localLayoutParams.gravity = 17;
    if (getCustomWidth() > 0) {}
    for (int i = getCustomWidth();; i = -1)
    {
      localLayoutParams.width = i;
      i = j;
      if (getCustomHeight() > 0) {
        i = getCustomHeight();
      }
      localLayoutParams.height = i;
      return localLayoutParams;
    }
  }
  
  protected abstract View a();
  
  public void a(e parame)
  {
    this.d = false;
    this.e = parame;
    k.a(this.b);
  }
  
  protected abstract void b();
  
  public void c()
  {
    if (this.d) {
      return;
    }
    if (this.f != null) {
      this.f.onCancel();
    }
    d();
  }
  
  public void d()
  {
    if (this.d) {
      return;
    }
    this.d = true;
    if (this.e != null) {
      this.e.dismissDialog(this);
    }
    k.b(this.b);
    g();
  }
  
  public boolean e()
  {
    return this.g;
  }
  
  public abstract void f();
  
  public void g() {}
  
  public int getCustomHeight()
  {
    return 0;
  }
  
  protected int getCustomWidth()
  {
    return 0;
  }
  
  public boolean h()
  {
    return this.d;
  }
  
  public void setCanceledOnTouchOutside(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public void setOnDialogCancelListener(d paramd)
  {
    this.f = paramd;
  }
  
  public static enum a
  {
    private a() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/core/screen/BaseDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */