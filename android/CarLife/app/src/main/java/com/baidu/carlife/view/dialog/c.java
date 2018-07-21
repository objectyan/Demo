package com.baidu.carlife.view.dialog;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.baidu.carlife.core.screen.b;
import com.baidu.carlife.core.screen.e;
import com.baidu.carlife.f.a;
import com.baidu.carlife.f.d;
import com.baidu.carlife.f.g;

public class c
  extends BaseDialog
{
  private static final int e = 1;
  private static final int f = 2;
  private static final int g = 0;
  public static final int n = 1;
  public static final int o = 2;
  private int h = 0;
  private int i;
  private int j = 5;
  private View k;
  private RelativeLayout l;
  private TextView m;
  protected Handler p = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      super.handleMessage(paramAnonymousMessage);
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      case 1: 
        c.a(c.this);
        c.b(c.this);
        return;
      }
      c.this.d();
    }
  };
  private TextView q;
  private TextView r;
  private TextView s;
  private View t;
  private ImageButton u;
  private b v;
  private b w;
  private com.baidu.carlife.core.screen.c x;
  private boolean y;
  
  public c(Context paramContext)
  {
    super(paramContext);
  }
  
  private void setTimeText()
  {
    TextView localTextView = null;
    if (this.h == 1) {
      localTextView = this.r;
    }
    while (localTextView == null)
    {
      return;
      if (this.h == 2) {
        localTextView = this.s;
      }
    }
    String str = localTextView.getText().toString();
    if (str.lastIndexOf("(") > 0) {
      localTextView.setText(str.replaceAll("[(](-)?\\d+[s][)]", "(" + this.i + "s)"));
    }
    while (this.i > 0)
    {
      this.p.sendEmptyMessageDelayed(1, 1000L);
      return;
      localTextView.setText(str + "(" + this.i + "s)");
    }
    if (this.x != null)
    {
      this.x.onCountDown(this.i);
      return;
    }
    this.p.sendEmptyMessageDelayed(2, 1000L);
  }
  
  protected View a()
  {
    return LayoutInflater.from(this.c).inflate(2130968707, null);
  }
  
  public c a(int paramInt)
  {
    return b(this.c.getString(paramInt));
  }
  
  public c a(int paramInt1, int paramInt2)
  {
    this.h = paramInt1;
    this.j = paramInt2;
    return this;
  }
  
  public c a(View paramView)
  {
    this.l.removeAllViews();
    paramView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
    this.l.addView(paramView);
    this.k = paramView;
    return this;
  }
  
  public c a(b paramb)
  {
    this.v = paramb;
    return this;
  }
  
  public c a(com.baidu.carlife.core.screen.c paramc)
  {
    this.x = paramc;
    return this;
  }
  
  public c a(boolean paramBoolean)
  {
    this.r.setEnabled(paramBoolean);
    return this;
  }
  
  public void a(e parame)
  {
    super.a(parame);
    this.i = this.j;
    setTimeText();
  }
  
  public c b(int paramInt)
  {
    return c(this.c.getString(paramInt));
  }
  
  public c b(b paramb)
  {
    this.w = paramb;
    return this;
  }
  
  public c b(String paramString)
  {
    if (paramString == null)
    {
      this.q.setVisibility(8);
      this.q.setText("", TextView.BufferType.SPANNABLE);
      return this;
    }
    this.q.setVisibility(0);
    this.q.setText(paramString, TextView.BufferType.SPANNABLE);
    return this;
  }
  
  public c b(boolean paramBoolean)
  {
    this.s.setEnabled(paramBoolean);
    return this;
  }
  
  protected void b()
  {
    this.l = ((RelativeLayout)findViewById(2131624636));
    this.m = ((TextView)findViewById(2131624640));
    this.q = ((TextView)findViewById(2131624642));
    this.r = ((TextView)findViewById(2131624270));
    this.s = ((TextView)findViewById(2131624271));
    this.t = findViewById(2131624643);
    this.u = ((ImageButton)findViewById(2131624641));
    this.r.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (c.c(c.this) != null) {
          c.c(c.this).onClick();
        }
        c.this.d();
      }
    });
    this.s.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (c.d(c.this) != null) {
          c.d(c.this).onClick();
        }
        c.this.d();
      }
    });
  }
  
  public c c(int paramInt)
  {
    return d(this.c.getString(paramInt));
  }
  
  public c c(String paramString)
  {
    this.m.setText(paramString);
    this.m.setVisibility(0);
    return this;
  }
  
  public c c(boolean paramBoolean)
  {
    this.y = paramBoolean;
    return this;
  }
  
  public c d(int paramInt)
  {
    return e(this.c.getString(paramInt));
  }
  
  public c d(String paramString)
  {
    this.r.setText(paramString);
    this.r.setVisibility(0);
    return this;
  }
  
  public void d()
  {
    super.d();
    this.p.removeMessages(1);
  }
  
  public c e(int paramInt)
  {
    this.l.removeAllViews();
    this.k = View.inflate(this.c, paramInt, this.l);
    return this;
  }
  
  public c e(String paramString)
  {
    this.s.setText(paramString);
    this.s.setVisibility(0);
    this.t.setVisibility(0);
    return this;
  }
  
  public c f(int paramInt)
  {
    this.h = paramInt;
    this.j = 5;
    return this;
  }
  
  public void f()
  {
    g localg = new g(findViewById(2131624268), 11);
    localg.d(this.r).d(this.s);
    localg.a(true);
    localg.b(true);
    if (this.y) {}
    for (TextView localTextView = this.r;; localTextView = this.s)
    {
      localg.b(localTextView);
      d.a().a(new a[] { localg });
      return;
    }
  }
  
  public c g(int paramInt)
  {
    this.q.setGravity(paramInt);
    return this;
  }
  
  public TextView getContentView()
  {
    return this.q;
  }
  
  public View getDiyContentView()
  {
    return this.k;
  }
  
  public ImageButton getTitlebntRight()
  {
    return this.u;
  }
  
  public TextView getmFirstBtn()
  {
    return this.r;
  }
  
  public TextView getmSecondBtn()
  {
    return this.s;
  }
  
  public c q()
  {
    this.r.setTextColor(this.c.getResources().getColor(2131558647));
    return this;
  }
  
  public c r()
  {
    this.s.setTextColor(this.c.getResources().getColor(2131558647));
    return this;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/view/dialog/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */