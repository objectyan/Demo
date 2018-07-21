package com.baidu.carlife.f;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import com.baidu.carlife.core.i;
import com.baidu.carlife.view.KeyboardEditText;
import java.util.ArrayList;
import java.util.Iterator;

public class g
  extends a
  implements View.OnFocusChangeListener
{
  private ArrayList<View> v = new ArrayList();
  private View w;
  private View x;
  private View.OnKeyListener y;
  private boolean z = false;
  
  public g(View paramView, int paramInt)
  {
    super(paramView, paramInt);
    paramView.setOnFocusChangeListener(this);
  }
  
  public g(View paramView, int paramInt, boolean paramBoolean)
  {
    super(paramView, paramInt, paramBoolean);
    paramView.setOnFocusChangeListener(this);
  }
  
  private boolean f(View paramView)
  {
    if ((i(paramView)) && (paramView.requestFocus()))
    {
      a(paramView);
      i.b("FocusManager", "requestFocusForView view=" + paramView);
      this.x = paramView;
      return true;
    }
    return false;
  }
  
  private View g(View paramView)
  {
    if (this.v.size() == 0)
    {
      paramView = null;
      return paramView;
    }
    int j = this.v.indexOf(paramView);
    if (j == -1) {
      return null;
    }
    if ((j == this.v.size() - 1) && (!this.t)) {
      return null;
    }
    int i = 1;
    for (;;)
    {
      if ((i >= this.v.size()) || ((!this.t) && (j + i >= this.v.size()))) {
        break label143;
      }
      int k = (j + i) % this.v.size();
      if (k < this.v.size())
      {
        View localView = (View)this.v.get(k);
        paramView = localView;
        if (i(localView)) {
          break;
        }
      }
      i += 1;
    }
    label143:
    return null;
  }
  
  private View h(View paramView)
  {
    if (this.v.size() == 0)
    {
      paramView = null;
      return paramView;
    }
    int j = this.v.indexOf(paramView);
    if (j == -1) {
      return null;
    }
    if ((j == 0) && (!this.t)) {
      return null;
    }
    int i = 1;
    for (;;)
    {
      if ((i >= this.v.size()) || ((!this.t) && (j - i < 0))) {
        break label135;
      }
      int k = (j - i + this.v.size()) % this.v.size();
      if (k < this.v.size())
      {
        View localView = (View)this.v.get(k);
        paramView = localView;
        if (i(localView)) {
          break;
        }
      }
      i += 1;
    }
    label135:
    return null;
  }
  
  private boolean i(View paramView)
  {
    if ((paramView != null) && (this.v.contains(paramView)) && (paramView.isShown()) && (paramView.isEnabled())) {
      return true;
    }
    int i = 0;
    if (paramView == null) {
      i = 1;
    }
    for (;;)
    {
      i.d("FocusManager", "illegalview view=" + paramView + " code=" + i);
      return false;
      if (!this.v.contains(paramView)) {
        i = 2;
      } else if (!paramView.isShown()) {
        i = 3;
      } else if (!paramView.isEnabled()) {
        i = 4;
      }
    }
  }
  
  public void a(View.OnKeyListener paramOnKeyListener)
  {
    this.y = paramOnKeyListener;
  }
  
  public boolean a()
  {
    i.b("FocusManager", "grantFocus FocusViewGroup");
    if ((this.z) && (this.w != null) && (f(this.w))) {
      return true;
    }
    if (this.x != null)
    {
      if (f(this.x)) {
        return true;
      }
      this.x = null;
    }
    if ((this.w != null) && (f(this.w))) {
      return true;
    }
    int i = 0;
    while (i < this.v.size())
    {
      this.w = ((View)this.v.get(i));
      if (f(this.w)) {
        return true;
      }
      i += 1;
    }
    this.w = null;
    return false;
  }
  
  public g b(View paramView)
  {
    this.w = paramView;
    return this;
  }
  
  public g b(boolean paramBoolean)
  {
    this.z = paramBoolean;
    return this;
  }
  
  public g c(View paramView)
  {
    this.x = paramView;
    return this;
  }
  
  public g d(View paramView)
  {
    if (!paramView.isFocusable()) {
      return this;
    }
    paramView.setOnKeyListener(this);
    if (paramView.getOnFocusChangeListener() == null) {
      paramView.setOnFocusChangeListener(this);
    }
    this.v.add(paramView);
    return this;
  }
  
  public ArrayList<View> e()
  {
    return this.v;
  }
  
  public boolean e(View paramView)
  {
    Object localObject = null;
    boolean bool = this.v.remove(paramView);
    View localView;
    if (this.x == paramView)
    {
      if (this.v.size() == 0)
      {
        localView = null;
        this.x = localView;
      }
    }
    else if (this.w == paramView) {
      if (this.v.size() != 0) {
        break label80;
      }
    }
    label80:
    for (paramView = (View)localObject;; paramView = (View)this.v.get(0))
    {
      this.w = paramView;
      return bool;
      localView = (View)this.v.get(0);
      break;
    }
  }
  
  public View f()
  {
    return this.w;
  }
  
  public View g()
  {
    return this.x;
  }
  
  public void h()
  {
    if (this.v != null)
    {
      Iterator localIterator = this.v.iterator();
      while (localIterator.hasNext()) {
        ((View)localIterator.next()).setOnKeyListener(this);
      }
    }
  }
  
  public void i()
  {
    this.x = null;
    this.w = null;
    if (this.v != null) {
      this.v.clear();
    }
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    i.b("FocusManager", "onFocusChange v=" + paramView + " hasFocus=" + paramBoolean);
    if ((paramView != null) && (paramView.isFocused())) {
      a(paramView);
    }
    i.b("FocusManager", "hasFocus=" + paramView.isFocused());
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("onKey keyCode=").append(paramInt).append(" v=").append(paramView).append(" action=");
    if (paramKeyEvent.getAction() == 0) {}
    for (String str = "ACTION_DOWN";; str = "ACTION_UP")
    {
      i.b("FocusManager", str);
      if ((this.y == null) || (!this.y.onKey(paramView, paramInt, paramKeyEvent))) {
        break;
      }
      return true;
    }
    if (paramKeyEvent != null)
    {
      if (paramKeyEvent.getAction() != 0) {
        break label241;
      }
      switch (paramInt)
      {
      }
    }
    label241:
    while ((!(paramView instanceof KeyboardEditText)) || (paramKeyEvent.getAction() != 1) || (paramInt != 23))
    {
      do
      {
        return super.onKey(paramView, paramInt, paramKeyEvent);
        if ((!d()) && (com.baidu.carlife.core.screen.presentation.a.g.a().isDialogShown()) && (!d.a().i())) {
          return true;
        }
        f(g(paramView));
        return true;
        if ((!d()) && (com.baidu.carlife.core.screen.presentation.a.g.a().isDialogShown()) && (!d.a().i())) {
          return true;
        }
        f(h(paramView));
        return true;
      } while (!(paramView instanceof KeyboardEditText));
      com.baidu.carlife.view.a.a().a((KeyboardEditText)paramView);
      return true;
    }
    return com.baidu.carlife.view.a.a().b((KeyboardEditText)paramView);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/f/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */