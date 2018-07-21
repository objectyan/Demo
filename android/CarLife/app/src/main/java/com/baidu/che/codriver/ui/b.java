package com.baidu.che.codriver.ui;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.carlife.core.k;
import com.baidu.carlife.f.g;
import com.baidu.carlife.logic.codriver.adapter.AdapterDialog;
import com.baidu.che.codriver.ui.d.b.a;
import com.baidu.che.codriver.util.h;
import com.baidu.che.codriver.widget.DuerOSMicImageView;
import com.baidu.che.codriver.widget.e;
import com.baidu.mobstat.StatService;
import java.util.ArrayList;
import java.util.Iterator;

public class b
  extends AdapterDialog
{
  private static final String g = "MainDialog";
  private ImageView h;
  private ImageView i;
  private TextView j;
  private ListView k;
  private com.baidu.che.codriver.ui.b.a l;
  private DuerOSMicImageView m;
  private com.baidu.che.codriver.ui.a.b n;
  private ArrayList<com.baidu.che.codriver.ui.d.b> o;
  
  public b(Context paramContext, com.baidu.che.codriver.ui.b.a parama)
  {
    super(paramContext, null, 2131427347);
    this.l = parama;
  }
  
  private View a(AdapterView paramAdapterView, int paramInt)
  {
    paramInt -= paramAdapterView.getFirstVisiblePosition();
    if ((paramInt >= 0) && (paramInt < paramAdapterView.getChildCount())) {
      return paramAdapterView.getChildAt(paramInt);
    }
    return null;
  }
  
  private void a(AbsListView paramAbsListView, final int paramInt1, int paramInt2)
  {
    if (a(paramAbsListView, a(paramAbsListView, paramInt1))) {
      return;
    }
    paramAbsListView.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onScrollStateChanged(final AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        if (paramAnonymousInt == 0)
        {
          paramAnonymousAbsListView.setOnScrollListener(null);
          b.a(b.this).post(new Runnable()
          {
            public void run()
            {
              paramAnonymousAbsListView.setSelection(b.1.this.a);
            }
          });
        }
      }
    });
    paramAbsListView.smoothScrollToPositionFromTop(paramInt1, 0, paramInt2);
  }
  
  private boolean a(AbsListView paramAbsListView, View paramView)
  {
    return (paramView != null) && ((paramView.getTop() == 0) || ((paramView.getTop() > 0) && (!paramAbsListView.canScrollVertically(1))));
  }
  
  private boolean b(com.baidu.che.codriver.ui.d.b paramb)
  {
    return (paramb == null) || (!l()) || ((TextUtils.isEmpty(paramb.g)) && (paramb.f == b.a.c));
  }
  
  private boolean q()
  {
    if (this.o.isEmpty()) {}
    com.baidu.che.codriver.ui.d.b localb;
    do
    {
      return true;
      localb = (com.baidu.che.codriver.ui.d.b)this.o.get(this.o.size() - 1);
    } while ((localb == null) || (localb.f == b.a.c) || (localb.j != 1));
    return false;
  }
  
  private boolean r()
  {
    return (this.n.b() <= this.k.getLastVisiblePosition()) && (this.n.b() >= this.k.getFirstVisiblePosition());
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i1 = this.o.size();
    paramInt1 = i1 - paramInt1;
    h.b("MainDialog", "size=" + i1 + " pos=" + paramInt1);
    if ((paramInt1 < 0) || (paramInt1 > i1)) {
      return;
    }
    a(this.k, paramInt1, paramInt2);
    h.b("MainDialog", "smoothScrollToBottom pos=" + paramInt1);
  }
  
  protected void a(Bundle paramBundle)
  {
    h.b("MainDialog", "-----onCreate------");
    com.baidu.che.codriver.a.b.a().b(this.c);
    b();
    this.o = new ArrayList();
    this.n = new com.baidu.che.codriver.ui.a.b(this.c, this.o);
    this.k.setAdapter(this.n);
    StatService.setSessionTimeOut(30);
  }
  
  public void a(com.baidu.che.codriver.ui.d.b paramb)
  {
    if (b(paramb)) {
      return;
    }
    h.b("MainDialog", "------addModel-------type:" + paramb.f.name());
    Iterator localIterator;
    if (paramb.f == b.a.k)
    {
      localIterator = this.o.iterator();
      while (localIterator.hasNext()) {
        if (((com.baidu.che.codriver.ui.d.b)localIterator.next()).f == b.a.k) {
          localIterator.remove();
        }
      }
    }
    for (;;)
    {
      this.j.setVisibility(4);
      this.k.setVisibility(0);
      this.o.add(paramb);
      this.n.notifyDataSetChanged();
      m();
      return;
      if (paramb.f == b.a.o)
      {
        localIterator = this.o.iterator();
        while (localIterator.hasNext()) {
          if (((com.baidu.che.codriver.ui.d.b)localIterator.next()).f == b.a.o) {
            localIterator.remove();
          }
        }
        this.k.smoothScrollBy(1, 1);
      }
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    h.b("MainDialog", "------show-------");
    i();
  }
  
  protected void b()
  {
    h.b("MainDialog", "-----initView-----");
    this.h = ((ImageView)a(2131625503));
    this.i = ((ImageView)a(2131625504));
    this.j = ((TextView)a(2131625506));
    this.k = ((ListView)a(2131625505));
    View localView = new View(this.c);
    localView.setLayoutParams(new AbsListView.LayoutParams(10, com.baidu.che.codriver.util.c.d() - getContext().getResources().getDimensionPixelSize(2131361923)));
    this.k.addFooterView(localView);
    this.m = ((DuerOSMicImageView)a(2131625510));
    this.m.setOnClickListener(this.l);
    this.i.setOnClickListener(this.l);
    this.h.setOnClickListener(this.l);
    this.k.setOnTouchListener(this.l);
  }
  
  public void b(String paramString)
  {
    setStatusText(paramString);
  }
  
  public void c()
  {
    this.f = true;
    this.l.a();
  }
  
  public void d()
  {
    k.a(4100);
    k.b(4100);
    super.d();
  }
  
  public void f()
  {
    g localg = new g(a(2131625502), 9);
    localg.d(this.h);
    localg.a(true);
    com.baidu.carlife.f.d.a().a(new com.baidu.carlife.f.a[] { localg });
  }
  
  protected int getLayoutId()
  {
    return 2130968890;
  }
  
  protected void j()
  {
    super.j();
    h.b("MainDialog", "-----onStart------");
    k.a(4100);
    k.b(4100);
    com.baidu.che.codriver.h.a.a().b();
  }
  
  protected void k()
  {
    super.k();
    h.b("MainDialog", "-----onStop------");
    com.baidu.che.codriver.h.a.a().c();
    if (com.baidu.che.codriver.vr.a.c.a().f()) {
      com.baidu.che.codriver.vr.a.c.a().g();
    }
    for (;;)
    {
      this.o.clear();
      this.n.notifyDataSetChanged();
      this.n.a(0);
      this.n.a(com.baidu.che.codriver.widget.d.a());
      return;
      if (com.baidu.che.codriver.vr.a.c.a().e()) {
        com.baidu.che.codriver.vr.a.c.a().d();
      }
    }
  }
  
  public void m()
  {
    this.k.post(new Runnable()
    {
      public void run()
      {
        b.this.a(1, 500);
      }
    });
  }
  
  public boolean n()
  {
    m();
    return (!(this.n.a() instanceof com.baidu.che.codriver.widget.d)) && (r());
  }
  
  public boolean o()
  {
    return this.n.a().b();
  }
  
  public boolean p()
  {
    return this.n.a().c();
  }
  
  public void setStateIniting(String paramString)
  {
    h.b("MainDialog", "setStateIniting");
    this.m.a();
    this.j.setText(paramString);
    this.j.setVisibility(0);
    this.k.setVisibility(4);
  }
  
  public void setStateListening()
  {
    h.b("MainDialog", "setStateListening");
    this.m.b();
    if (q())
    {
      this.j.setVisibility(4);
      this.j.setText("");
      this.k.setVisibility(4);
    }
  }
  
  public void setStatePrecessing()
  {
    h.b("MainDialog", "setStatePrecessing");
    this.m.c();
    this.j.setVisibility(4);
    this.j.setText("");
    this.k.setVisibility(0);
  }
  
  public void setStatePrepared()
  {
    h.b("MainDialog", "setStatePrepared");
    this.m.a();
    this.j.setVisibility(4);
    this.j.setText("");
    this.k.setVisibility(0);
  }
  
  public void setStateRecording()
  {
    h.b("MainDialog", "setStateRecording");
    this.m.b();
    if (q())
    {
      this.j.setVisibility(0);
      this.k.setVisibility(4);
    }
  }
  
  public void setStatusGone()
  {
    if (this.j == null) {
      return;
    }
    this.j.setText("");
    this.j.setVisibility(8);
  }
  
  public void setStatusText(int paramInt)
  {
    if (this.j == null) {
      return;
    }
    this.j.setVisibility(0);
    this.j.setText(paramInt);
  }
  
  public void setStatusText(String paramString)
  {
    if (this.j == null) {
      return;
    }
    this.j.setVisibility(0);
    this.k.setVisibility(4);
    this.j.setText(paramString);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/ui/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */