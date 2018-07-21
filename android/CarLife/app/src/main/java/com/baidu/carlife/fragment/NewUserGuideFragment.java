package com.baidu.carlife.fragment;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.carlife.CarlifeActivity;
import com.baidu.carlife.core.c;
import com.baidu.carlife.core.e;
import com.baidu.carlife.core.i;
import com.baidu.carlife.f.d;
import com.baidu.carlife.f.h;
import com.baidu.carlife.logic.u;
import com.baidu.carlife.view.UserGuideViewPager;
import com.baidu.carlife.view.a.b;
import com.baidu.navi.fragment.BaseFragment;
import com.baidu.navi.fragment.ContentFragment;
import java.util.ArrayList;
import java.util.List;

public class NewUserGuideFragment
  extends ContentFragment
  implements View.OnClickListener, View.OnTouchListener
{
  public static final String a = "firstEnter";
  public static final String b = "index";
  private boolean c;
  private int d = 0;
  private RelativeLayout e;
  private ImageView f;
  private ImageView g;
  private ImageView h;
  private RelativeLayout i;
  private RelativeLayout j;
  private UserGuideViewPager k;
  private List<View> l;
  private TextView m;
  private com.baidu.carlife.f.g n;
  private h o;
  
  private void a()
  {
    if (this.o == null)
    {
      this.o = new h((ViewPager)this.mContentView.findViewById(2131624834), 4);
      this.o.a(new View.OnKeyListener()
      {
        public boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          if ((paramAnonymousKeyEvent.getAction() == 0) && (paramAnonymousInt == 23))
          {
            if ((com.baidu.carlife.core.screen.presentation.a.g.a().isDialogShown()) && (!d.a().i())) {}
            while (!NewUserGuideFragment.g(NewUserGuideFragment.this)) {
              return true;
            }
            NewUserGuideFragment.h(NewUserGuideFragment.this);
            return true;
          }
          return false;
        }
      });
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.f.setVisibility(paramInt1);
    this.h.setVisibility(paramInt3);
    this.g.setVisibility(paramInt2);
  }
  
  private void a(LayoutInflater paramLayoutInflater)
  {
    View localView = paramLayoutInflater.inflate(2130969047, null);
    paramLayoutInflater = paramLayoutInflater.inflate(2130969049, null);
    this.l = new ArrayList();
    this.l.add(localView);
    this.l.add(paramLayoutInflater);
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      if (c()) {
        this.h.setBackground(ContextCompat.getDrawable(mActivity, 2130838542));
      }
    }
    while (paramMotionEvent.getAction() != 1)
    {
      return;
      this.g.setBackground(ContextCompat.getDrawable(mActivity, 2130838536));
      return;
    }
    if (c()) {
      if (this.c) {
        d();
      }
    }
    for (;;)
    {
      f();
      return;
      this.g.setBackground(ContextCompat.getDrawable(mActivity, 2130839534));
    }
  }
  
  private void a(View paramView)
  {
    this.m = ((TextView)paramView.findViewById(2131624842));
    this.m.setText(u.a(getStringUtil(2131296550)));
    this.m.setMovementMethod(LinkMovementMethod.getInstance());
  }
  
  private boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramView.getId())
    {
    case 2131624838: 
    default: 
      return false;
    case 2131624837: 
      b(paramMotionEvent);
      return true;
    }
    a(paramMotionEvent);
    return true;
  }
  
  private void b()
  {
    if (this.c)
    {
      d.a().b(new com.baidu.carlife.f.a[] { this.o });
      d.a().h(this.o);
      return;
    }
    d.a().b(new com.baidu.carlife.f.a[] { this.n, this.o });
    d.a().h(this.n);
  }
  
  private void b(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      this.f.setBackground(ContextCompat.getDrawable(mActivity, 2130838539));
    }
    while (paramMotionEvent.getAction() != 1) {
      return;
    }
    this.f.setBackground(ContextCompat.getDrawable(mActivity, 2130839531));
    e();
  }
  
  private void b(View paramView)
  {
    this.i = ((RelativeLayout)paramView.findViewById(2131624837));
    this.i.setOnTouchListener(this);
    this.j = ((RelativeLayout)paramView.findViewById(2131624839));
    this.j.setOnTouchListener(this);
  }
  
  private void c(View paramView)
  {
    this.f = ((ImageView)paramView.findViewById(2131624838));
    this.f.setOnClickListener(this);
    this.g = ((ImageView)paramView.findViewById(2131624840));
    this.g.setOnClickListener(this);
    this.h = ((ImageView)paramView.findViewById(2131624841));
    this.h.setOnClickListener(this);
  }
  
  private boolean c()
  {
    return this.k.getCurrentItem() == this.l.size() - 1;
  }
  
  private void d()
  {
    i.b("Framework", "onEnterCarlife");
    c.a().a(false);
    if ((!e.a().x()) && (!com.baidu.carlife.l.a.a().N()))
    {
      showFragment(513, null);
      return;
    }
    showFragment(515, null);
  }
  
  private void d(View paramView)
  {
    this.e = ((RelativeLayout)paramView.findViewById(2131624835));
    if (this.c)
    {
      this.e.setVisibility(8);
      return;
    }
    this.e.setVisibility(0);
    this.e.setOnClickListener(this);
  }
  
  private void e()
  {
    if (this.d <= 0) {
      return;
    }
    this.d -= 1;
    this.k.setCurrentItem(this.d);
  }
  
  private void e(View paramView)
  {
    this.k = ((UserGuideViewPager)paramView.findViewById(2131624834));
    this.k.setScrollOperationFlag(false);
    this.k.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
    {
      private void a(int paramAnonymousInt)
      {
        if (NewUserGuideFragment.a(NewUserGuideFragment.this))
        {
          if (paramAnonymousInt == 0)
          {
            NewUserGuideFragment.a(NewUserGuideFragment.this, 8, 0, 8);
            NewUserGuideFragment.b(NewUserGuideFragment.this).setVisibility(8);
          }
          while (paramAnonymousInt != NewUserGuideFragment.c(NewUserGuideFragment.this).size() - 1) {
            return;
          }
          NewUserGuideFragment.a(NewUserGuideFragment.this, 0, 8, 0);
          NewUserGuideFragment.b(NewUserGuideFragment.this).setVisibility(0);
          return;
        }
        if (paramAnonymousInt == 0)
        {
          NewUserGuideFragment.d(NewUserGuideFragment.this).setVisibility(8);
          return;
        }
        NewUserGuideFragment.d(NewUserGuideFragment.this).setVisibility(0);
        NewUserGuideFragment.e(NewUserGuideFragment.this).setVisibility(0);
      }
      
      public void onPageScrollStateChanged(int paramAnonymousInt) {}
      
      public void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {}
      
      public void onPageSelected(int paramAnonymousInt)
      {
        a(paramAnonymousInt);
      }
    });
    this.k.setAdapter(new a(null));
    this.k.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean)
        {
          NewUserGuideFragment.f(NewUserGuideFragment.this).setBackground(ContextCompat.getDrawable(BaseFragment.mActivity, 2130838541));
          return;
        }
        NewUserGuideFragment.f(NewUserGuideFragment.this).setBackground(ContextCompat.getDrawable(BaseFragment.mActivity, 2130838540));
      }
    });
  }
  
  private void f()
  {
    if (this.d >= this.l.size() - 1) {
      return;
    }
    this.d += 1;
    this.k.setCurrentItem(this.d);
  }
  
  public boolean onBackPressed()
  {
    if (this.c)
    {
      mActivity.d();
      return true;
    }
    setBottomBarStatus(true);
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131624836: 
    case 2131624837: 
    case 2131624839: 
    default: 
      return;
    case 2131624835: 
      back();
      setBottomBarStatus(true);
      return;
    case 2131624838: 
      e();
      return;
    case 2131624840: 
      f();
      return;
    }
    d();
  }
  
  protected View onCreateContentView(LayoutInflater paramLayoutInflater)
  {
    setBottomBarStatus(false);
    if (this.mShowBundle != null)
    {
      this.c = this.mShowBundle.getBoolean("firstEnter", false);
      this.d = this.mShowBundle.getInt("index", 0);
    }
    View localView = paramLayoutInflater.inflate(2130968759, null);
    a(localView);
    d(localView);
    a(paramLayoutInflater);
    e(localView);
    b(localView);
    c(localView);
    this.k.setCurrentItem(this.d);
    return localView;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (Build.VERSION.SDK_INT > 16)
    {
      if ((mActivity != null) && (!mActivity.isDestroyed())) {
        removeAllFragmentByType(516);
      }
      return;
    }
    removeAllFragmentByType(516);
  }
  
  public void onInitFocusAreas()
  {
    if (this.mContentView == null) {
      return;
    }
    if (this.n == null)
    {
      this.n = new com.baidu.carlife.f.g(this.mContentView.findViewById(2131624833), 2);
      this.n.d(this.mContentView.findViewById(2131624835));
    }
    a();
    b();
  }
  
  protected void onInitView() {}
  
  public void onResume()
  {
    super.onResume();
    b();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return a(paramView, paramMotionEvent);
  }
  
  protected void onUpdateOrientation(int paramInt) {}
  
  protected void onUpdateSkin()
  {
    super.onUpdateSkin();
    this.e.setBackground(b.a(mActivity));
  }
  
  protected void onUpdateStyle(boolean paramBoolean) {}
  
  private class a
    extends PagerAdapter
  {
    private a() {}
    
    public void destroyItem(View paramView, int paramInt, Object paramObject)
    {
      ((ViewPager)paramView).removeView((View)NewUserGuideFragment.c(NewUserGuideFragment.this).get(paramInt));
    }
    
    public int getCount()
    {
      if (NewUserGuideFragment.a(NewUserGuideFragment.this)) {
        return NewUserGuideFragment.c(NewUserGuideFragment.this).size();
      }
      return NewUserGuideFragment.c(NewUserGuideFragment.this).size() - 1;
    }
    
    public Object instantiateItem(View paramView, int paramInt)
    {
      ((ViewPager)paramView).addView((View)NewUserGuideFragment.c(NewUserGuideFragment.this).get(paramInt));
      return NewUserGuideFragment.c(NewUserGuideFragment.this).get(paramInt);
    }
    
    public boolean isViewFromObject(View paramView, Object paramObject)
    {
      return paramView == paramObject;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/fragment/NewUserGuideFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */