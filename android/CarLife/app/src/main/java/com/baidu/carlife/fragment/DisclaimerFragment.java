package com.baidu.carlife.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ScrollView;
import android.widget.TextView;
import com.baidu.carlife.core.c;
import com.baidu.carlife.f.a;
import com.baidu.carlife.f.d;
import com.baidu.carlife.f.f;
import com.baidu.carlife.f.g;
import com.baidu.navi.fragment.ContentFragment;

public class DisclaimerFragment
  extends ContentFragment
{
  private TextView a;
  private View b;
  private ScrollView c;
  private g d;
  private f e;
  private boolean f;
  
  public boolean onBackPressed()
  {
    return true;
  }
  
  protected View onCreateContentView(LayoutInflater paramLayoutInflater)
  {
    this.mContentView = paramLayoutInflater.inflate(2130968748, null);
    this.a = ((TextView)this.mContentView.findViewById(2131624769));
    this.b = this.mContentView.findViewById(2131624770);
    this.c = ((ScrollView)this.mContentView.findViewById(2131624757));
    this.c.setOverScrollMode(2);
    this.a.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        boolean bool = false;
        if (DisclaimerFragment.a(DisclaimerFragment.this)) {
          DisclaimerFragment.b(DisclaimerFragment.this).setCompoundDrawablesWithIntrinsicBounds(2130838334, 0, 0, 0);
        }
        for (;;)
        {
          paramAnonymousView = DisclaimerFragment.this;
          if (!DisclaimerFragment.a(DisclaimerFragment.this)) {
            bool = true;
          }
          DisclaimerFragment.a(paramAnonymousView, bool);
          return;
          DisclaimerFragment.b(DisclaimerFragment.this).setCompoundDrawablesWithIntrinsicBounds(2130838262, 0, 0, 0);
        }
      }
    });
    this.b.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        c.a().b(DisclaimerFragment.a(DisclaimerFragment.this));
        DisclaimerFragment.this.showFragment(531, null);
      }
    });
    return this.mContentView;
  }
  
  public void onInitFocusAreas()
  {
    if (this.fragmentType != getCurrentFragmentType()) {
      return;
    }
    d locald = d.a();
    if (this.e == null) {
      this.e = new f(this.c, 4);
    }
    if (this.d == null)
    {
      this.d = new g(this.mContentView, 6);
      this.d.d(this.a).d(this.b);
    }
    locald.b(new a[] { this.e, this.d });
    locald.h(this.d);
  }
  
  protected void onInitView() {}
  
  protected void onUpdateOrientation(int paramInt) {}
  
  protected void onUpdateStyle(boolean paramBoolean) {}
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/fragment/DisclaimerFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */