package com.baidu.carlife.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.carlife.R.p;

public class HomeCardView
  extends RelativeLayout
  implements View.OnTouchListener
{
  private static final String a = HomeCardView.class.getSimpleName();
  private a b;
  private View c;
  private View d;
  private View e;
  private View f;
  private View g;
  private View h;
  private View i;
  private View j;
  private TextView k;
  private TextView l;
  private ImageView m;
  private ImageView n;
  private ImageView o;
  private HomeCardMusicMelodyView p;
  private View.OnClickListener q;
  private View.OnClickListener r;
  private View.OnClickListener s;
  
  public HomeCardView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public HomeCardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
    a(paramContext, paramAttributeSet);
  }
  
  public HomeCardView a()
  {
    this.m.setVisibility(0);
    return this;
  }
  
  public HomeCardView a(int paramInt)
  {
    this.m.setVisibility(paramInt);
    return this;
  }
  
  public HomeCardView a(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      this.m.setImageDrawable(paramDrawable);
      this.m.setVisibility(0);
      return this;
    }
    this.m.setVisibility(8);
    return this;
  }
  
  public HomeCardView a(View.OnClickListener paramOnClickListener)
  {
    this.q = paramOnClickListener;
    return this;
  }
  
  public HomeCardView a(a parama)
  {
    this.b = parama;
    return this;
  }
  
  public HomeCardView a(String paramString)
  {
    this.k.setText(paramString);
    return this;
  }
  
  protected void a(Context paramContext)
  {
    this.c = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2130968623, this, true);
    this.d = findViewById(2131624243);
    this.e = findViewById(2131624245);
    this.f = findViewById(2131624244);
    this.i = findViewById(2131624248);
    this.g = findViewById(2131624254);
    this.h = findViewById(2131624255);
    this.j = findViewById(2131624253);
    this.k = ((TextView)findViewById(2131624246));
    this.l = ((TextView)findViewById(2131624247));
    this.m = ((ImageView)findViewById(2131624249));
    this.n = ((ImageView)findViewById(2131624250));
    this.o = ((ImageView)findViewById(2131624251));
    this.p = ((HomeCardMusicMelodyView)findViewById(2131624252));
    this.c.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return true;
      }
    });
    this.f.setOnTouchListener(this);
    this.e.setOnTouchListener(this);
    this.e.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (HomeCardView.a(HomeCardView.this) != null) {
          HomeCardView.a(HomeCardView.this).onClick(HomeCardView.this);
        }
      }
    });
    this.f.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (HomeCardView.a(HomeCardView.this) != null) {
          HomeCardView.a(HomeCardView.this).onClick(HomeCardView.this);
        }
      }
    });
    this.m.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (HomeCardView.b(HomeCardView.this) != null) {
          HomeCardView.b(HomeCardView.this).onClick(paramAnonymousView);
        }
      }
    });
    this.n.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (HomeCardView.c(HomeCardView.this) != null) {
          HomeCardView.c(HomeCardView.this).onClick(paramAnonymousView);
        }
      }
    });
    this.m.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        if (HomeCardView.d(HomeCardView.this) == HomeCardView.a.c)
        {
          if (paramAnonymousMotionEvent.getAction() != 0) {
            break label33;
          }
          HomeCardView.e(HomeCardView.this).setVisibility(0);
        }
        label33:
        while (paramAnonymousMotionEvent.getAction() != 1) {
          return false;
        }
        HomeCardView.e(HomeCardView.this).setVisibility(8);
        return false;
      }
    });
    this.o.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        if (HomeCardView.d(HomeCardView.this) == HomeCardView.a.d)
        {
          if (paramAnonymousMotionEvent.getAction() != 0) {
            break label33;
          }
          HomeCardView.e(HomeCardView.this).setVisibility(0);
        }
        label33:
        while (paramAnonymousMotionEvent.getAction() != 1) {
          return false;
        }
        HomeCardView.e(HomeCardView.this).setVisibility(8);
        return false;
      }
    });
    setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean)
        {
          HomeCardView.e(HomeCardView.this).setVisibility(8);
          HomeCardView.f(HomeCardView.this).setVisibility(0);
          return;
        }
        HomeCardView.f(HomeCardView.this).setVisibility(8);
      }
    });
  }
  
  protected void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet == null) {
      return;
    }
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.p.HomeCardView);
    paramAttributeSet = paramContext.getString(7);
    Object localObject;
    if (!TextUtils.isEmpty(paramAttributeSet))
    {
      if (a.a.a().equals(paramAttributeSet)) {
        this.b = a.a;
      }
    }
    else
    {
      paramAttributeSet = paramContext.getDrawable(0);
      if (paramAttributeSet != null) {
        this.d.setBackground(paramAttributeSet);
      }
      if (this.b != a.d) {
        break label242;
      }
      paramAttributeSet = paramContext.getDrawable(1);
      localObject = paramContext.getDrawable(2);
      String str = paramContext.getString(3);
      this.k.setText(str);
      if (paramAttributeSet != null) {
        this.e.setBackground(paramAttributeSet);
      }
      if (localObject != null) {
        this.o.setImageDrawable((Drawable)localObject);
      }
      this.o.setVisibility(0);
      this.i.setVisibility(8);
    }
    for (;;)
    {
      paramContext.recycle();
      return;
      if (a.b.a().equals(paramAttributeSet))
      {
        this.b = a.b;
        break;
      }
      if (a.c.a().equals(paramAttributeSet))
      {
        this.b = a.c;
        break;
      }
      if (a.d.a().equals(paramAttributeSet))
      {
        this.b = a.d;
        break;
      }
      if (!a.e.a().equals(paramAttributeSet)) {
        break;
      }
      this.b = a.e;
      break;
      label242:
      this.o.setVisibility(8);
      this.i.setVisibility(0);
      paramAttributeSet = paramContext.getString(3);
      localObject = paramContext.getString(4);
      this.k.setText(paramAttributeSet);
      this.l.setText((CharSequence)localObject);
      paramAttributeSet = paramContext.getDrawable(5);
      localObject = paramContext.getDrawable(6);
      if (paramAttributeSet != null)
      {
        this.m.setImageDrawable(paramAttributeSet);
        this.m.setVisibility(0);
      }
      for (;;)
      {
        if (localObject == null) {
          break label355;
        }
        this.n.setImageDrawable((Drawable)localObject);
        this.n.setVisibility(0);
        break;
        this.m.setVisibility(8);
      }
      label355:
      this.n.setVisibility(8);
    }
  }
  
  public HomeCardView b()
  {
    this.n.setVisibility(0);
    return this;
  }
  
  public HomeCardView b(int paramInt)
  {
    this.m.setImageResource(paramInt);
    return this;
  }
  
  public HomeCardView b(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      this.n.setImageDrawable(paramDrawable);
      this.n.setVisibility(0);
      return this;
    }
    this.n.setVisibility(8);
    return this;
  }
  
  public HomeCardView b(View.OnClickListener paramOnClickListener)
  {
    this.r = paramOnClickListener;
    return this;
  }
  
  public HomeCardView b(String paramString)
  {
    this.l.setText(paramString);
    return this;
  }
  
  public HomeCardView c()
  {
    this.m.setVisibility(8);
    return this;
  }
  
  public HomeCardView c(int paramInt)
  {
    this.n.setImageResource(paramInt);
    return this;
  }
  
  public HomeCardView c(Drawable paramDrawable)
  {
    this.o.setImageDrawable(paramDrawable);
    return this;
  }
  
  public HomeCardView c(View.OnClickListener paramOnClickListener)
  {
    this.o.setOnClickListener(paramOnClickListener);
    return this;
  }
  
  public HomeCardView c(String paramString)
  {
    this.k.setText(paramString);
    this.e.setBackground(null);
    return this;
  }
  
  public HomeCardView d()
  {
    this.n.setVisibility(8);
    return this;
  }
  
  public HomeCardView d(int paramInt)
  {
    this.j.setVisibility(paramInt);
    return this;
  }
  
  public HomeCardView d(Drawable paramDrawable)
  {
    this.e.setBackground(paramDrawable);
    this.k.setText("");
    return this;
  }
  
  public HomeCardView e(int paramInt)
  {
    this.o.setImageResource(paramInt);
    return this;
  }
  
  public HomeCardView f(int paramInt)
  {
    this.e.setBackgroundResource(paramInt);
    this.k.setText("");
    return this;
  }
  
  public HomeCardView g(int paramInt)
  {
    this.p.setVisibility(paramInt);
    return this;
  }
  
  public HomeCardMusicMelodyView getMusicMelody()
  {
    return this.p;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      this.g.setVisibility(0);
    }
    while (paramMotionEvent.getAction() != 1) {
      return false;
    }
    this.g.setVisibility(8);
    return false;
  }
  
  public void setFocusViewGone()
  {
    this.h.setVisibility(8);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    super.setOnClickListener(paramOnClickListener);
    this.s = paramOnClickListener;
  }
  
  public static enum a
  {
    private String f;
    
    private a(String paramString)
    {
      this.f = paramString;
    }
    
    public String a()
    {
      try
      {
        String str = this.f;
        return str;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    public void a(String paramString)
    {
      try
      {
        this.f = paramString;
        return;
      }
      finally
      {
        paramString = finally;
        throw paramString;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/view/HomeCardView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */