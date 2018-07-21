package com.baidu.carlife.view.dialog;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.carlife.custom.b;
import com.baidu.carlife.f.c;
import com.baidu.navi.fragment.NaviFragmentManager;

public class a
  extends BaseDialog
  implements View.OnClickListener, View.OnTouchListener, AbsListView.OnScrollListener
{
  private View e;
  private ImageButton f;
  private ImageButton g;
  private ViewGroup h;
  private View i;
  private int j = 0;
  private int k = 0;
  private int l = 0;
  private int m = 0;
  private int n = 0;
  private int o = 0;
  private int p = 0;
  private boolean q = true;
  private boolean r = true;
  private TextView s;
  private ListView t;
  private String u;
  private BaseAdapter v;
  private boolean w = false;
  private boolean x = true;
  private c y;
  
  public a(Context paramContext, int paramInt, BaseAdapter paramBaseAdapter, AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    super(paramContext);
    this.x = true;
    this.v = paramBaseAdapter;
    this.u = paramContext.getString(paramInt);
    setTitle(this.u);
    this.t.setOnItemClickListener(paramOnItemClickListener);
    this.t.setAdapter(this.v);
    setCanceledOnTouchOutside(true);
  }
  
  public a(Context paramContext, BaseAdapter paramBaseAdapter, AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    super(paramContext);
    this.x = false;
    k();
    this.v = paramBaseAdapter;
    this.t.setOnItemClickListener(paramOnItemClickListener);
    this.t.setAdapter(this.v);
    setCanceledOnTouchOutside(true);
  }
  
  private void k()
  {
    if (!this.x) {
      this.s.setVisibility(8);
    }
  }
  
  protected View a()
  {
    View localView = LayoutInflater.from(this.c).inflate(2130968598, null);
    localView.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView) {}
    });
    return localView;
  }
  
  public void a(final int paramInt)
  {
    if (this.t != null) {
      this.t.post(new Runnable()
      {
        public void run()
        {
          ListView localListView = a.a(a.this);
          if (paramInt > 0) {}
          for (int i = paramInt - 1;; i = paramInt)
          {
            localListView.setSelection(i);
            return;
          }
        }
      });
    }
  }
  
  protected void b()
  {
    this.s = ((TextView)findViewById(2131624059));
    this.s.setText(this.u);
    this.t = ((ListView)findViewById(2131624060));
    this.t.setOverScrollMode(2);
    this.e = findViewById(2131624054);
    if ((com.baidu.carlife.custom.a.a().b()) || (b.a().b())) {
      this.e.setVisibility(0);
    }
    this.h = ((ViewGroup)findViewById(2131624056));
    this.i = findViewById(2131624057);
    this.f = ((ImageButton)findViewById(2131624055));
    this.g = ((ImageButton)findViewById(2131624058));
    this.f.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.t.setOnScrollListener(this);
    this.t.setOnTouchListener(this);
    if (this.w) {
      this.t.setDivider(null);
    }
  }
  
  public void f()
  {
    if (this.y == null)
    {
      this.y = new c(this.t, 9);
      this.y.a(new View.OnKeyListener()
      {
        public boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          if ((paramAnonymousKeyEvent != null) && (paramAnonymousKeyEvent.getAction() == 0) && (paramAnonymousInt == 21))
          {
            a.this.d();
            return true;
          }
          return false;
        }
      });
      this.y.a(true);
    }
    com.baidu.carlife.f.d.a().a(new com.baidu.carlife.f.a[] { this.y });
  }
  
  public void g()
  {
    com.baidu.carlife.f.d.a().e();
  }
  
  protected int getCustomWidth()
  {
    return this.c.getResources().getDimensionPixelSize(2131361817);
  }
  
  public void i()
  {
    if (this.v != null) {
      this.v.notifyDataSetChanged();
    }
  }
  
  public void j()
  {
    this.w = true;
  }
  
  public void onClick(View paramView)
  {
    if (this.n == 0) {
      return;
    }
    int i1 = this.l / this.n;
    switch (paramView.getId())
    {
    case 2131624056: 
    case 2131624057: 
    default: 
      return;
    case 2131624055: 
      this.t.smoothScrollToPositionFromTop(this.p - i1, -this.t.getDividerHeight() - 1);
      return;
    }
    this.t.smoothScrollToPositionFromTop(this.p + i1, -this.t.getDividerHeight() - 1);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (((com.baidu.carlife.custom.a.a().b()) || (b.a().b())) && (paramMotionEvent.getAction() == 2) && (com.baidu.carlife.core.screen.presentation.h.a().getNaviFragmentManager().isDriving())) {
      return true;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.t.getChildAt(0) == null) {}
    do
    {
      return;
      if ((this.j != 0) && (this.l != 0) && (this.o == paramInt3)) {
        break;
      }
      this.o = paramInt3;
      if ((this.v != null) && ((this.v instanceof com.baidu.carlife.adpter.h)))
      {
        paramAbsListView = (com.baidu.carlife.adpter.h)this.v;
        if ((Boolean.valueOf(paramAbsListView.b()).booleanValue()) && (paramAbsListView.a() == 0)) {
          this.o = (paramInt3 - 1);
        }
      }
      this.l = this.t.getHeight();
      this.n = (this.t.getChildAt(0).getHeight() + this.t.getDividerHeight());
      this.m = (this.n * this.o - 10);
      this.j = this.h.getHeight();
    } while (this.j == 0);
    paramAbsListView = this.i.getLayoutParams();
    this.k = (this.l * this.j / this.o / this.n);
    paramInt2 = com.baidu.carlife.core.d.a().c(12);
    if (this.k < paramInt2)
    {
      this.j -= paramInt2 - this.k;
      this.k = paramInt2;
    }
    paramAbsListView.height = this.k;
    this.i.setLayoutParams(paramAbsListView);
    paramInt2 = -(this.n * paramInt1 - this.t.getChildAt(0).getTop()) * this.j / this.m;
    if (paramInt2 == 0)
    {
      if (this.q)
      {
        this.q = false;
        this.f.setImageResource(2130838314);
        this.f.setEnabled(false);
      }
      if (this.r) {
        if (-(this.j - this.k - 2) >= 0)
        {
          this.r = false;
          this.g.setImageResource(2130838306);
          this.g.setEnabled(false);
        }
      }
    }
    for (;;)
    {
      this.p = paramInt1;
      this.h.scrollTo(0, paramInt2);
      return;
      if (-(this.j - this.k - 2) < 0)
      {
        this.r = true;
        this.g.setImageResource(2130838305);
        this.g.setEnabled(true);
        continue;
        if (paramInt2 <= -(this.j - this.k - 2))
        {
          if (this.r)
          {
            this.r = false;
            this.g.setImageResource(2130838306);
            this.g.setEnabled(false);
          }
          if ((paramInt2 != 0) && (!this.q))
          {
            this.q = true;
            this.f.setImageResource(2130838313);
            this.f.setEnabled(true);
          }
        }
        else
        {
          if (!this.q)
          {
            this.q = true;
            this.f.setImageResource(2130838313);
            this.f.setEnabled(true);
          }
          if (!this.r)
          {
            this.r = true;
            this.g.setImageResource(2130838305);
            this.g.setEnabled(true);
          }
        }
      }
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void setBtnVisibility(int paramInt)
  {
    if (((paramInt == 0) || (paramInt == 8)) && (this.e != null))
    {
      this.e.setVisibility(paramInt);
      ((View)this.e.getParent()).invalidate();
    }
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    if (this.t != null) {
      this.t.setOnItemClickListener(paramOnItemClickListener);
    }
  }
  
  public void setTitle(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      this.u = paramString;
    } while (this.s == null);
    this.s.setText(this.u);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/view/dialog/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */