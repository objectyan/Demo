package com.baidu.carlife.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
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

public class HomeDiscoverCardView
  extends RelativeLayout
  implements View.OnTouchListener
{
  private View a;
  private View b;
  private View c;
  private View d;
  private View e;
  private TextView f;
  private ImageView g;
  private View.OnClickListener h;
  private int i = -1;
  
  public HomeDiscoverCardView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public HomeDiscoverCardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public HomeDiscoverCardView a(int paramInt)
  {
    this.g.setImageResource(paramInt);
    return this;
  }
  
  public HomeDiscoverCardView a(Drawable paramDrawable)
  {
    this.g.setImageDrawable(paramDrawable);
    return this;
  }
  
  public HomeDiscoverCardView a(String paramString)
  {
    this.f.setText(paramString);
    return this;
  }
  
  protected void a(Context paramContext)
  {
    this.a = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2130968624, this, true);
    this.b = findViewById(2131624243);
    this.c = findViewById(2131624254);
    this.d = findViewById(2131624255);
    this.e = findViewById(2131624253);
    this.g = ((ImageView)findViewById(2131624256));
    this.f = ((TextView)findViewById(2131624257));
    this.a.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return false;
      }
    });
    this.b.setOnTouchListener(this);
    this.b.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if ((HomeDiscoverCardView.a(HomeDiscoverCardView.this) != null) && (HomeDiscoverCardView.this.isEnabled())) {
          HomeDiscoverCardView.a(HomeDiscoverCardView.this).onClick(HomeDiscoverCardView.this);
        }
      }
    });
    setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean)
        {
          HomeDiscoverCardView.b(HomeDiscoverCardView.this).setVisibility(8);
          HomeDiscoverCardView.c(HomeDiscoverCardView.this).setVisibility(0);
          return;
        }
        HomeDiscoverCardView.c(HomeDiscoverCardView.this).setVisibility(8);
      }
    });
  }
  
  public HomeDiscoverCardView b(int paramInt)
  {
    this.e.setVisibility(paramInt);
    return this;
  }
  
  public String getCardName()
  {
    return this.f.getText().toString();
  }
  
  public int getTagInt()
  {
    return this.i;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 0) && (isEnabled())) {
      this.c.setVisibility(0);
    }
    while (paramMotionEvent.getAction() != 1) {
      return false;
    }
    this.c.setVisibility(8);
    return false;
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    if (paramBoolean)
    {
      setAlpha(1.0F);
      return;
    }
    setAlpha(0.5F);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    super.setOnClickListener(paramOnClickListener);
    this.h = paramOnClickListener;
  }
  
  public void setTagInt(int paramInt)
  {
    this.i = paramInt;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/view/HomeDiscoverCardView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */