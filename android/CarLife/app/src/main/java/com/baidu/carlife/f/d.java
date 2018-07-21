package com.baidu.carlife.f;

import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalFocusChangeListener;
import android.view.ViewTreeObserver.OnTouchModeChangeListener;
import com.baidu.carlife.core.i;
import com.baidu.carlife.core.screen.presentation.h;
import com.baidu.carlife.logic.g;
import com.baidu.navi.fragment.ContentFragment;

public class d
  implements View.OnFocusChangeListener, View.OnKeyListener, View.OnTouchListener, ViewTreeObserver.OnGlobalFocusChangeListener, ViewTreeObserver.OnTouchModeChangeListener
{
  private static d a = null;
  private static final int u = 200;
  private static final int v = 201;
  private View b;
  private a c;
  private a d;
  private a e;
  private a f;
  private a g;
  private a h;
  private a i;
  private a j;
  private a k;
  private a l;
  private a m;
  private a n;
  private a o;
  private a p;
  private a q;
  private a r;
  private a s;
  private boolean t = true;
  private Handler w = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if (d.this.b()) {
        d.this.g();
      }
      if ((paramAnonymousMessage.what == 200) && (paramAnonymousMessage.obj != null) && ((paramAnonymousMessage.obj instanceof a))) {
        ((a)paramAnonymousMessage.obj).a();
      }
    }
  };
  
  public static d a()
  {
    if (a == null) {
      a = new d();
    }
    return a;
  }
  
  public d a(a parama)
  {
    this.c = parama;
    return this;
  }
  
  public d a(a... paramVarArgs)
  {
    e();
    if (paramVarArgs != null)
    {
      int i1 = 0;
      if (i1 < paramVarArgs.length)
      {
        if (paramVarArgs[i1] == null) {}
        for (;;)
        {
          i1 += 1;
          break;
          switch (paramVarArgs[i1].b())
          {
          case 12: 
          default: 
            break;
          case 7: 
            this.j = paramVarArgs[i1];
            break;
          case 11: 
            this.q = paramVarArgs[i1];
            break;
          case 13: 
            this.m = paramVarArgs[i1];
            break;
          case 14: 
            this.n = paramVarArgs[i1];
            break;
          case 15: 
            this.o = paramVarArgs[i1];
            break;
          case 9: 
            this.l = paramVarArgs[i1];
            break;
          case 8: 
            this.k = paramVarArgs[i1];
            break;
          case 10: 
            this.p = paramVarArgs[i1];
          }
        }
      }
    }
    if (this.k != null)
    {
      this.s = this.k;
      this.k.a();
    }
    do
    {
      return this;
      if (this.m != null)
      {
        this.s = this.m;
        this.m.a();
        return this;
      }
      if (this.l != null)
      {
        this.s = this.l;
        this.l.a();
        return this;
      }
      if (this.p != null)
      {
        this.s = this.p;
        this.p.a();
        return this;
      }
      if (this.j != null)
      {
        this.s = this.j;
        this.j.a();
        return this;
      }
    } while (this.q == null);
    this.s = this.q;
    this.q.a();
    return this;
  }
  
  public void a(View paramView)
  {
    this.b = paramView;
    this.b.getViewTreeObserver().addOnTouchModeChangeListener(this);
    this.b.getViewTreeObserver().addOnGlobalFocusChangeListener(this);
    this.w.sendEmptyMessage(201);
  }
  
  public d b(a parama)
  {
    if ((parama == null) && (this.h != null) && (this.h.c()))
    {
      parama = a().d(this.h);
      i.b("FocusManager", "setFocusAreaTop focusArea = " + parama);
      if (parama != null) {
        parama.a();
      }
      this.h = null;
      return this;
    }
    this.h = parama;
    return this;
  }
  
  public d b(a... paramVarArgs)
  {
    d();
    if (paramVarArgs != null)
    {
      int i1 = 0;
      if (i1 < paramVarArgs.length)
      {
        if (paramVarArgs[i1] == null) {}
        for (;;)
        {
          i1 += 1;
          break;
          switch (paramVarArgs[i1].b())
          {
          default: 
            break;
          case 2: 
            this.d = paramVarArgs[i1];
            break;
          case 3: 
            this.e = paramVarArgs[i1];
            break;
          case 4: 
            this.g = paramVarArgs[i1];
            break;
          case 5: 
            this.f = paramVarArgs[i1];
            break;
          case 6: 
            this.i = paramVarArgs[i1];
            break;
          case 11: 
            this.q = paramVarArgs[i1];
            break;
          case 9: 
            this.l = paramVarArgs[i1];
            break;
          case 7: 
            this.j = paramVarArgs[i1];
            break;
          case 8: 
            this.k = paramVarArgs[i1];
            break;
          case 10: 
            this.p = paramVarArgs[i1];
          }
        }
      }
    }
    return this;
  }
  
  public boolean b()
  {
    if (this.b == null) {
      return false;
    }
    return this.b.isInTouchMode();
  }
  
  public d c()
  {
    this.r = null;
    return this;
  }
  
  public d c(a parama)
  {
    if (parama != null)
    {
      this.r = parama;
      this.r.a();
    }
    return this;
  }
  
  public a d(a parama)
  {
    if (parama == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return null;
            switch (parama.b())
            {
            case 1: 
            case 11: 
            case 12: 
            default: 
              return null;
            case 0: 
              if (this.d == null) {
                break label273;
              }
              return this.d;
            }
          } while (this.q == null);
          return this.q;
        } while (this.n == null);
        return this.n;
      } while (this.o == null);
      return this.o;
      if (this.m != null) {
        return this.m;
      }
      if (this.k != null) {
        return this.k;
      }
      if (this.l != null) {
        return this.l;
      }
      if (this.p != null) {
        return this.p;
      }
    } while (this.q == null);
    return this.q;
    return this.c;
    if (this.i != null) {
      return this.i;
    }
    return this.c;
    if (this.e != null) {
      return this.e;
    }
    if (this.g != null) {
      return this.g;
    }
    if (this.f != null) {
      return this.f;
    }
    if (this.i != null) {
      return this.i;
    }
    return this.c;
    label273:
    if (this.e != null) {
      return this.e;
    }
    if (this.g != null) {
      return this.g;
    }
    if (this.f != null) {
      return this.f;
    }
    if (this.i != null) {
      return this.i;
    }
    return this.c;
  }
  
  public d d()
  {
    this.e = null;
    this.g = null;
    this.f = null;
    this.i = null;
    this.d = null;
    return this;
  }
  
  public a e(a parama)
  {
    if (parama == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return null;
            switch (parama.b())
            {
            case 0: 
            case 7: 
            case 12: 
            default: 
              return null;
            case 1: 
              if (this.i == null) {
                break;
              }
              return this.i;
            case 11: 
              if (this.o != null) {
                return this.o;
              }
              if (this.k != null) {
                return this.k;
              }
              if (this.l != null) {
                return this.l;
              }
              if (this.p != null) {
                return this.p;
              }
              break;
            }
          } while (this.j == null);
          return this.j;
        } while (this.j == null);
        return this.j;
      } while (this.m == null);
      return this.m;
    } while (this.n == null);
    return this.n;
    return this.h;
    if (this.d != null) {
      return this.d;
    }
    return this.h;
    if (this.e != null) {
      return this.e;
    }
    if (this.g != null) {
      return this.g;
    }
    if (this.f != null) {
      return this.f;
    }
    if (this.d != null) {
      return this.d;
    }
    return this.h;
    if (this.e != null) {
      return this.e;
    }
    if (this.g != null) {
      return this.g;
    }
    if (this.f != null) {
      return this.f;
    }
    if (this.d != null) {
      return this.d;
    }
    return this.h;
  }
  
  public d e()
  {
    this.q = null;
    this.j = null;
    this.l = null;
    this.p = null;
    this.k = null;
    this.m = null;
    this.n = null;
    this.o = null;
    this.s = null;
    return this;
  }
  
  public a f(a parama)
  {
    if (parama == null) {
      return null;
    }
    switch (parama.b())
    {
    case 0: 
    case 1: 
    case 2: 
    case 3: 
    case 6: 
    case 7: 
    case 8: 
    case 11: 
    case 12: 
    default: 
      return null;
    case 4: 
      return this.e;
    case 9: 
      return this.k;
    case 10: 
      if (this.l != null) {
        return this.l;
      }
      return this.k;
    }
    if (this.g != null) {
      return this.g;
    }
    return this.e;
  }
  
  public void f()
  {
    if (this.w != null) {
      this.w.removeMessages(200);
    }
  }
  
  public a g(a parama)
  {
    if (parama == null) {
      return null;
    }
    switch (parama.b())
    {
    case 0: 
    case 1: 
    case 2: 
    case 5: 
    case 6: 
    case 7: 
    case 10: 
    case 11: 
    case 12: 
    default: 
      return null;
    case 3: 
      if (this.g != null) {
        return this.g;
      }
      break;
    case 9: 
      return this.p;
    case 8: 
      if (this.l != null) {
        return this.l;
      }
      return this.p;
    case 4: 
      return this.f;
    }
    return this.f;
  }
  
  public void g()
  {
    if (!g.a().c()) {}
    do
    {
      do
      {
        return;
      } while ((this.b == null) || (!b()));
      this.b.requestFocusFromTouch();
      if (this.r != null)
      {
        this.r.a();
        return;
      }
    } while (this.s == null);
    this.s.a();
  }
  
  public void h(a parama)
  {
    if ((parama == null) || (this.w == null)) {
      return;
    }
    this.w.removeMessages(200);
    Message localMessage = new Message();
    localMessage.what = 200;
    localMessage.arg1 = parama.b();
    localMessage.obj = parama;
    this.w.sendMessageDelayed(localMessage, 100L);
  }
  
  public boolean h()
  {
    if (!g.a().c()) {
      return false;
    }
    if (this.r != null)
    {
      this.r.a();
      return false;
    }
    if (this.s != null)
    {
      this.s.a();
      return false;
    }
    return true;
  }
  
  public boolean i()
  {
    if (this.r != null)
    {
      this.r.a();
      return false;
    }
    if (this.s != null)
    {
      this.s.a();
      return false;
    }
    return true;
  }
  
  public void j()
  {
    if (!g.a().c()) {}
    ContentFragment localContentFragment;
    do
    {
      return;
      localContentFragment = h.a().getCurrentFragment();
      if (this.r != null)
      {
        this.r.a();
        return;
      }
      if (this.s != null)
      {
        this.s.a();
        return;
      }
    } while ((localContentFragment == null) || (!localContentFragment.isDisplayed));
    localContentFragment.onInitFocusAreas();
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean) {}
  
  public void onGlobalFocusChanged(View paramView1, View paramView2) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void onTouchModeChanged(boolean paramBoolean)
  {
    if (!g.a().c()) {}
    do
    {
      do
      {
        return;
        this.t = paramBoolean;
      } while ((!paramBoolean) || (this.b == null));
      this.b.requestFocusFromTouch();
      if (this.r != null)
      {
        this.r.a();
        return;
      }
    } while (this.s == null);
    this.s.a();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/f/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */