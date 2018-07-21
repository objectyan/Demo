package com.baidu.carlife.view;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.carlife.k.a.h;
import com.baidu.carlife.k.a.h.a;
import com.baidu.carlife.k.a.h.b;
import com.baidu.carlife.k.a.h.c;
import com.baidu.carlife.logic.t;
import com.baidu.carlife.model.l;
import com.baidu.carlife.model.l.a;
import com.baidu.carlife.util.r;
import com.baidu.navi.util.StatisticManager;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;

public class SkinItemView
  extends RelativeLayout
  implements h.c
{
  private a a;
  private DecimalFormat b;
  private t c;
  private l d;
  private h e;
  private View.OnClickListener f = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      if (SkinItemView.a(SkinItemView.this).c().equals(SkinItemView.b(SkinItemView.this).h)) {
        return;
      }
      switch (SkinItemView.b(SkinItemView.this).j)
      {
      default: 
        return;
      case 0: 
        SkinItemView.a(SkinItemView.this).d();
        StatisticManager.onEvent("1053", "默认皮肤");
        return;
      case 1: 
        paramAnonymousView = null;
        try
        {
          InputStream localInputStream = SkinItemView.this.getResources().getAssets().open(SkinItemView.b(SkinItemView.this).h);
          paramAnonymousView = localInputStream;
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            localIOException.printStackTrace();
          }
        }
        SkinItemView.a(SkinItemView.this).a(paramAnonymousView, SkinItemView.b(SkinItemView.this).h, SkinItemView.b(SkinItemView.this).e);
        StatisticManager.onEvent("1053", "本地皮肤");
        return;
      }
      if (SkinItemView.b(SkinItemView.this).l == l.a.b)
      {
        SkinItemView.this.a();
        SkinItemView.a(SkinItemView.this, new h(SkinItemView.b(SkinItemView.this).g, SkinItemView.b(SkinItemView.this).h, SkinItemView.this));
        SkinItemView.c(SkinItemView.this).e();
      }
      for (;;)
      {
        StatisticManager.onEvent("1053", "服务端皮肤");
        return;
        if (SkinItemView.b(SkinItemView.this).l == l.a.a) {
          SkinItemView.a(SkinItemView.this).a(SkinItemView.b(SkinItemView.this).h, SkinItemView.b(SkinItemView.this).e);
        }
      }
    }
  };
  private View.OnClickListener g = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      if (SkinItemView.c(SkinItemView.this) != null)
      {
        SkinItemView.this.c();
        SkinItemView.c(SkinItemView.this).d();
        SkinItemView.c(SkinItemView.this).a();
      }
    }
  };
  
  public SkinItemView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SkinItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
    this.c = t.a();
    this.b = new DecimalFormat("0.0");
  }
  
  private void a(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2130968840, this, true);
    paramContext.setOnClickListener(this.f);
    this.a = new a(null);
    this.a.a = ((MultiImageView)paramContext.findViewById(2131625263));
    this.a.b = paramContext.findViewById(2131625264);
    this.a.c = ((CircleProgressBarView)paramContext.findViewById(2131625265));
    this.a.d = ((TriangleStateView)paramContext.findViewById(2131625266));
    this.a.e = ((ImageView)paramContext.findViewById(2131625267));
    this.a.f = ((TextView)paramContext.findViewById(2131625268));
    this.a.g = ((TextView)paramContext.findViewById(2131625269));
  }
  
  public void a()
  {
    if (this.a == null) {
      return;
    }
    this.d.l = l.a.c;
    this.a.d.setVisibility(8);
    this.a.e.setVisibility(8);
    this.a.g.setVisibility(0);
    this.a.b.setVisibility(0);
  }
  
  public void a(long paramLong, int paramInt)
  {
    a();
    if (this.a != null) {
      this.a.c.setProgress(paramInt);
    }
  }
  
  public void a(h.b paramb, h.a parama)
  {
    switch (3.b[paramb.ordinal()])
    {
    }
    do
    {
      return;
      c();
      return;
    } while ((this.e == null) || (this.c == null));
    this.c.a(this.e.b(), this.d.e);
    b();
  }
  
  public void b()
  {
    if (this.a == null) {
      return;
    }
    this.d.l = l.a.a;
    this.a.d.setVisibility(8);
    this.a.e.setVisibility(8);
    this.a.g.setVisibility(8);
    this.a.b.setVisibility(8);
  }
  
  public void c()
  {
    if (this.a == null) {
      return;
    }
    this.d.l = l.a.b;
    this.a.d.setVisibility(0);
    this.a.d.setBgColor(r.a(2131558660));
    this.a.e.setVisibility(0);
    this.a.e.setImageResource(2130838598);
    this.a.g.setVisibility(0);
    this.a.b.setVisibility(8);
  }
  
  public void setData(l paraml)
  {
    if (this.e != null) {
      this.e.a();
    }
    this.d = paraml;
    switch (paraml.j)
    {
    }
    for (;;)
    {
      this.a.a.setBackground(r.b(2130838566));
      this.a.f.setTextColor(r.a(2131558702));
      this.a.g.setTextColor(r.a(2131558692));
      if (!t.a().c().equals(paraml.h)) {
        break;
      }
      this.a.a.setSelected(true);
      this.a.d.setVisibility(0);
      this.a.d.setBgColor(r.a(2131558610));
      this.a.e.setVisibility(0);
      this.a.e.setImageResource(2130838599);
      return;
      this.a.a.setDefaultDrawableResId(paraml.k);
      this.a.a.setImageUrl(null);
      this.a.b.setVisibility(8);
      this.a.f.setText(paraml.d);
      this.a.g.setVisibility(8);
      this.a.d.setVisibility(8);
      this.a.e.setVisibility(8);
      continue;
      this.a.a.setDefaultDrawable(r.b(2130838597));
      this.a.a.setImageUrl(paraml.f);
      this.a.f.setText(paraml.d);
      float f1 = paraml.i / 1000.0F / 1000.0F;
      this.a.g.setText(this.b.format(f1) + "M");
      if (this.c.a(paraml.h)) {
        paraml.l = l.a.a;
      }
      switch (3.a[paraml.l.ordinal()])
      {
      default: 
        break;
      case 1: 
        b();
        break;
      case 2: 
        c();
        break;
      case 3: 
        a();
        if (this.e != null) {
          this.e.a(this);
        }
        this.a.c.setOnClickListener(this.g);
      }
    }
    this.a.a.setSelected(false);
  }
  
  private class a
  {
    MultiImageView a;
    View b;
    CircleProgressBarView c;
    TriangleStateView d;
    ImageView e;
    TextView f;
    TextView g;
    
    private a() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/view/SkinItemView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */