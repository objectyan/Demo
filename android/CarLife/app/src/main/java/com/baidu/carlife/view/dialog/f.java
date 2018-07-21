package com.baidu.carlife.view.dialog;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.carlife.adpter.r;
import com.baidu.carlife.f.a;
import com.baidu.carlife.f.c;

public class f
  extends BaseDialog
{
  private TextView e;
  private ListView f;
  private String g;
  private BaseAdapter h;
  private View i;
  private boolean j = false;
  private boolean k = true;
  private c l;
  
  public f(Context paramContext, int paramInt, BaseAdapter paramBaseAdapter, AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    super(paramContext);
    this.k = true;
    this.h = paramBaseAdapter;
    this.g = paramContext.getString(paramInt);
    setTitle(this.g);
    this.f.setOnItemClickListener(paramOnItemClickListener);
    this.f.setAdapter(this.h);
    setCanceledOnTouchOutside(true);
  }
  
  public f(Context paramContext, BaseAdapter paramBaseAdapter, AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    super(paramContext);
    this.k = false;
    k();
    this.h = paramBaseAdapter;
    this.f.setOnItemClickListener(paramOnItemClickListener);
    this.f.setAdapter(this.h);
    setCanceledOnTouchOutside(true);
  }
  
  private void k()
  {
    if (!this.k) {
      this.e.setVisibility(8);
    }
  }
  
  protected View a()
  {
    View localView = LayoutInflater.from(this.c).inflate(2130968709, null);
    localView.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView) {}
    });
    return localView;
  }
  
  public void a(final int paramInt)
  {
    if (this.f != null) {
      this.f.post(new Runnable()
      {
        public void run()
        {
          ListView localListView = f.a(f.this);
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
  
  public void a(View paramView)
  {
    this.i = paramView;
  }
  
  protected void b()
  {
    this.e = ((TextView)findViewById(2131624059));
    this.e.setText(this.g);
    this.f = ((ListView)findViewById(2131624060));
    this.f.setOverScrollMode(2);
    if (this.i != null) {
      this.f.addFooterView(this.i, null, false);
    }
    if (this.j) {
      this.f.setDivider(null);
    }
  }
  
  public void f()
  {
    if (this.l == null)
    {
      this.l = new c(this.f, 9);
      this.l.a(new View.OnKeyListener()
      {
        public boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          if ((paramAnonymousKeyEvent != null) && (paramAnonymousKeyEvent.getAction() == 0) && (paramAnonymousInt == 21))
          {
            f.this.d();
            return true;
          }
          return false;
        }
      });
      this.l.a(true);
    }
    com.baidu.carlife.f.d.a().a(new a[] { this.l });
  }
  
  public void g()
  {
    com.baidu.carlife.f.d.a().e();
  }
  
  protected int getCustomWidth()
  {
    if (com.baidu.carlife.core.d.m()) {
      return this.c.getResources().getDimensionPixelSize(2131361852);
    }
    return this.c.getResources().getDimensionPixelSize(2131361853);
  }
  
  public void i()
  {
    if (this.h != null) {
      this.h.notifyDataSetChanged();
    }
  }
  
  public void j()
  {
    this.j = true;
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    if (this.f != null) {
      this.f.setOnItemClickListener(paramOnItemClickListener);
    }
  }
  
  public void setSelected(int paramInt)
  {
    if ((this.h instanceof r))
    {
      ((r)this.h).a(paramInt);
      this.h.notifyDataSetChanged();
    }
  }
  
  public void setTitle(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      this.g = paramString;
    } while (this.e == null);
    this.e.setText(this.g);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/view/dialog/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */