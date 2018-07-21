package com.baidu.carlife.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintLayout.LayoutParams;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.ImageView;
import android.widget.TextView;

public class DiscoverCardView
  extends ConstraintLayout
{
  private View a;
  private TextView b;
  private TextView c;
  private ImageView d;
  private View e;
  private View f;
  private int g = -1;
  
  public DiscoverCardView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public DiscoverCardView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public DiscoverCardView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.a = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2130968859, this, true);
    this.d = ((ImageView)this.a.findViewById(2131625345));
    this.b = ((TextView)this.a.findViewById(2131625346));
    this.f = this.a.findViewById(2131624253);
    this.c = ((TextView)this.a.findViewById(2131625347));
    this.e = this.a.findViewById(2131624255);
    setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean)
        {
          DiscoverCardView.a(DiscoverCardView.this).setVisibility(0);
          return;
        }
        DiscoverCardView.a(DiscoverCardView.this).setVisibility(8);
      }
    });
  }
  
  public DiscoverCardView a(int paramInt)
  {
    this.d.setImageResource(paramInt);
    return this;
  }
  
  public DiscoverCardView a(String paramString)
  {
    this.b.setText(paramString);
    return this;
  }
  
  public DiscoverCardView b(String paramString)
  {
    this.c.setText(paramString);
    return this;
  }
  
  public String getCardName()
  {
    return this.b.getText().toString();
  }
  
  public int getTagInt()
  {
    return this.g;
  }
  
  public void setCardDescriptionVisibility(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.c.setVisibility(0);
      return;
    }
    this.c.setVisibility(8);
    ConstraintLayout.LayoutParams localLayoutParams = (ConstraintLayout.LayoutParams)this.b.getLayoutParams();
    localLayoutParams.topToTop = 0;
    localLayoutParams.bottomToBottom = 0;
    this.b.setLayoutParams(localLayoutParams);
  }
  
  public void setCardTitleColor(int paramInt)
  {
    if (this.b != null) {
      this.b.setTextColor(paramInt);
    }
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
  
  public void setRedPointVisibility(int paramInt)
  {
    this.f.setVisibility(paramInt);
  }
  
  public void setTagInt(int paramInt)
  {
    this.g = paramInt;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/view/DiscoverCardView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */