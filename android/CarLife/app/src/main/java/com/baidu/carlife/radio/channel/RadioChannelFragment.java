package com.baidu.carlife.radio.channel;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import com.baidu.carlife.core.e;
import com.baidu.carlife.core.i;
import com.baidu.carlife.core.k;
import com.baidu.carlife.logic.music.h;
import com.baidu.carlife.logic.music.r;
import com.baidu.carlife.radio.b.ab;
import com.baidu.carlife.radio.c.a.a;
import com.baidu.carlife.util.p;
import com.baidu.carlife.util.w;
import com.baidu.carlife.view.recyclingviewpager.RecyclingViewPager;
import com.baidu.carlife.view.recyclingviewpager.RecyclingViewPager.a;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.util.StatisticManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class RadioChannelFragment
  extends ContentFragment
{
  private static final int a = 0;
  private static final int b = 8000;
  private View c;
  private RecyclingViewPager d;
  private ImageButton e;
  private ViewGroup f;
  private int g;
  private RadioChannelAdapter h;
  private boolean i = false;
  private Handler j = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      }
      RadioChannelFragment.a(RadioChannelFragment.this);
    }
  };
  private com.baidu.carlife.f.g k;
  private com.baidu.carlife.f.g l;
  private boolean m = false;
  private com.baidu.carlife.core.j n = new com.baidu.carlife.core.j()
  {
    public void careAbout()
    {
      addMsg(230);
      addMsg(225);
    }
    
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      case 230: 
        RadioChannelFragment.h(RadioChannelFragment.this);
        return;
      }
      RadioChannelFragment.i(RadioChannelFragment.this);
    }
  };
  
  private void a(int paramInt)
  {
    this.d.bringChildToFront(this.d.a(paramInt - 3));
    this.d.bringChildToFront(this.d.a(paramInt + 3));
    this.d.bringChildToFront(this.d.a(paramInt - 2));
    this.d.bringChildToFront(this.d.a(paramInt + 2));
    this.d.bringChildToFront(this.d.a(paramInt - 1));
    this.d.bringChildToFront(this.d.a(paramInt + 1));
    this.d.bringChildToFront(this.d.a(paramInt));
    e();
  }
  
  private void a(final com.baidu.carlife.radio.a.a parama)
  {
    if (!e.a().r())
    {
      w.a(2131296718);
      return;
    }
    new com.baidu.carlife.radio.c.a(getContext()).a(this, new a.a()
    {
      public void a()
      {
        if (RadioChannelFragment.c(RadioChannelFragment.this, parama))
        {
          w.a(2131296611);
          return;
        }
        com.baidu.carlife.logic.a.j.a().a(Integer.valueOf(parama.a()).intValue());
        String str = h.b().s().n();
        if ((!TextUtils.equals(parama.a(), str)) || (!h.b().w()))
        {
          StatisticManager.onEvent("CONTENT_REC_0001_CLICK");
          StatisticManager.onEvent(parama.d() + "_CLICK");
          h.b().c(parama.a());
        }
        RadioChannelFragment.d(RadioChannelFragment.this, parama);
      }
    });
  }
  
  private void b()
  {
    c();
    this.e = ((ImageButton)this.c.findViewById(2131625226));
    this.e.setBackground(com.baidu.carlife.view.a.b.b(getContext()));
    this.e.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        RadioChannelFragment.this.back();
      }
    });
  }
  
  private boolean b(com.baidu.carlife.radio.a.a parama)
  {
    return ("10".equals(parama.a())) && (TextUtils.isEmpty(p.a().a("radio_voice_query", "")));
  }
  
  private void c()
  {
    this.d = ((RecyclingViewPager)this.c.findViewById(2131625228));
    this.d.setOffscreenPageLimit(9);
    this.h = new RadioChannelAdapter(getContext(), this.d);
    this.h.a(com.baidu.carlife.radio.c.b.a().e());
    this.d.setAdapter(this.h);
    this.d.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener()
    {
      public void onPageSelected(int paramAnonymousInt)
      {
        if (!RadioChannelFragment.b(RadioChannelFragment.this).a())
        {
          RadioChannelFragment.b(RadioChannelFragment.this).setSelectEnable(true);
          return;
        }
        if ((RadioChannelFragment.c(RadioChannelFragment.this)) && (!RadioChannelFragment.b(RadioChannelFragment.this).b()))
        {
          RadioChannelFragment.a(RadioChannelFragment.this, false);
          RadioChannelFragment.b(RadioChannelFragment.this).setTouch(false);
          String str = h.b().s().n();
          if ("10".equals(str))
          {
            int j = RadioChannelFragment.d(RadioChannelFragment.this).a(str) - RadioChannelFragment.d(RadioChannelFragment.this).a(RadioChannelFragment.d(RadioChannelFragment.this).a(paramAnonymousInt).a());
            int i = j - RadioChannelFragment.d(RadioChannelFragment.this).a();
            if (j < 0) {
              i = j + RadioChannelFragment.d(RadioChannelFragment.this).a();
            }
            if (Math.abs(i) < Math.abs(j)) {
              RadioChannelFragment.a(RadioChannelFragment.this, paramAnonymousInt + i);
            }
            for (;;)
            {
              RadioChannelFragment.b(RadioChannelFragment.this).setCurrentItem(RadioChannelFragment.e(RadioChannelFragment.this));
              return;
              RadioChannelFragment.a(RadioChannelFragment.this, paramAnonymousInt + j);
            }
          }
        }
        RadioChannelFragment.b(RadioChannelFragment.this, paramAnonymousInt);
        RadioChannelFragment.a(RadioChannelFragment.this, RadioChannelFragment.d(RadioChannelFragment.this).a(paramAnonymousInt));
      }
    });
    this.d.setOnItemClickListener(new RecyclingViewPager.a()
    {
      public void a(RecyclingViewPager paramAnonymousRecyclingViewPager, int paramAnonymousInt)
      {
        RadioChannelFragment.b(RadioChannelFragment.this, RadioChannelFragment.d(RadioChannelFragment.this).a(paramAnonymousInt));
      }
    });
    this.c.findViewById(2131625227).setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return RadioChannelFragment.b(RadioChannelFragment.this).a(paramAnonymousMotionEvent);
      }
    });
    if (this.h.a() > 0)
    {
      int i1 = this.h.getCount() / 2;
      int i2 = this.h.a();
      int i3 = this.h.getCount() / 2;
      String str = h.b().s().n();
      this.g = (this.h.a(str) + (i3 - i1 % i2));
      this.d.setCurrentItem(this.g);
      this.d.post(new Runnable()
      {
        public void run()
        {
          RadioChannelFragment.b(RadioChannelFragment.this, RadioChannelFragment.e(RadioChannelFragment.this));
        }
      });
    }
  }
  
  private void c(final com.baidu.carlife.radio.a.a parama)
  {
    if (!e.a().r())
    {
      w.a(2131296718);
      return;
    }
    new com.baidu.carlife.radio.c.a(getContext()).a(this, new a.a()
    {
      public void a()
      {
        if (RadioChannelFragment.c(RadioChannelFragment.this, parama))
        {
          w.a(2131296611);
          return;
        }
        com.baidu.carlife.logic.a.j.a().a(Integer.valueOf(parama.a()).intValue());
        h.b().s().b(parama.a(), parama.b());
      }
    });
  }
  
  private void d()
  {
    int i2;
    int i3;
    int i1;
    if (!this.h.a(this.d.getCurrentItem()).a().equals("10"))
    {
      i2 = this.d.getCurrentItem();
      i3 = this.h.a("10") - this.h.a(this.h.a(i2).a());
      i1 = i3 - this.h.a();
      if (i3 < 0) {
        i1 = i3 + this.h.a();
      }
      if (Math.abs(i1) >= Math.abs(i3)) {
        break label116;
      }
    }
    label116:
    for (this.g = (i2 + i1);; this.g = (i2 + i3))
    {
      this.d.setCurrentItem(this.g);
      return;
    }
  }
  
  private void d(com.baidu.carlife.radio.a.a parama)
  {
    dismissGuideHint();
    this.j.removeMessages(0);
    parama = com.baidu.carlife.radio.c.c.a(parama.b());
    if (!TextUtils.isEmpty(parama)) {
      showGuideHint(parama);
    }
    this.j.sendEmptyMessageDelayed(0, 8000L);
  }
  
  private void e()
  {
    HashMap localHashMap = this.d.getChildrenViews();
    Iterator localIterator = localHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)localIterator.next();
      ImageView localImageView = (ImageView)localView.findViewById(2131626001);
      if (((Integer)localHashMap.get(localView)).intValue() == this.d.getCurrentItem())
      {
        localImageView.setVisibility(0);
        if (h.b().v())
        {
          localImageView.setImageResource(2130837522);
          ((AnimationDrawable)localImageView.getDrawable()).start();
        }
        else
        {
          localImageView.setImageResource(2130839342);
        }
      }
      else
      {
        localImageView.setVisibility(8);
        localImageView.setImageBitmap(null);
      }
    }
  }
  
  public void a()
  {
    if ((com.baidu.carlife.core.d.m()) && (this.f != null))
    {
      int i1 = this.f.getWidth();
      int i2 = this.f.getHeight();
      int i3 = this.d.getWidth();
      i.b("Framework", "before adapte: ContainerWidth: " + i1 + " # ViewpageWidth: " + i3 + " # Height: " + i2);
      this.d.setOffscreenPageLimit(9);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i3 * 7, i2);
      this.f.setLayoutParams(localLayoutParams);
      this.f.requestLayout();
      i1 = this.f.getWidth();
      i2 = this.f.getHeight();
      i3 = this.d.getWidth();
      i.b("Framework", "after adapte: ContainerWidth: " + i1 + " # ViewpageWidth: " + i3 + " # Height: " + i2);
    }
  }
  
  protected View onCreateContentView(LayoutInflater paramLayoutInflater)
  {
    if ((com.baidu.carlife.core.d.m()) && (com.baidu.carlife.l.a.a().N())) {}
    for (this.c = paramLayoutInflater.inflate(2130968826, null);; this.c = paramLayoutInflater.inflate(2130968825, null))
    {
      k.a(this.n);
      new ab().c();
      new com.baidu.carlife.radio.b.c().c();
      b();
      return this.c;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.i = false;
    if (this.mBackBundle != null) {
      this.i = this.mBackBundle.getBoolean("is_from_player");
    }
    if (this.i) {
      this.d.setTouch(false);
    }
    return paramLayoutInflater;
  }
  
  public void onDetach()
  {
    this.n.removeMessages(230);
    k.b(this.n);
    this.n = null;
    super.onDetach();
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    dismissGuideHint();
    com.baidu.carlife.view.g.e().f();
  }
  
  public void onInitFocusAreas()
  {
    if (this.k == null)
    {
      this.k = new com.baidu.carlife.f.g(this.c, 2, true);
      this.k.d(this.c.findViewById(2131625226));
    }
    if (this.l == null)
    {
      View localView = this.c.findViewById(2131625229);
      this.l = new com.baidu.carlife.f.g(this.c, 4, true);
      this.l.d(localView);
      this.l.a(new View.OnKeyListener()
      {
        public boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          boolean bool2 = true;
          if ((paramAnonymousKeyEvent != null) && (paramAnonymousKeyEvent.getAction() == 0)) {}
          boolean bool1;
          switch (paramAnonymousInt)
          {
          default: 
            bool1 = false;
          case 300: 
          case 301: 
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return bool1;
                    bool1 = bool2;
                  } while (RadioChannelFragment.f(RadioChannelFragment.this));
                  if (!com.baidu.carlife.core.screen.presentation.a.g.a().isDialogShown()) {
                    break;
                  }
                  bool1 = bool2;
                } while (!com.baidu.carlife.f.d.a().i());
                RadioChannelFragment.b(RadioChannelFragment.this).setCurrentItem(RadioChannelFragment.b(RadioChannelFragment.this).getCurrentItem() + 1);
                RadioChannelFragment.b(RadioChannelFragment.this, true);
                RadioChannelFragment.g(RadioChannelFragment.this).postDelayed(new Runnable()
                {
                  public void run()
                  {
                    RadioChannelFragment.b(RadioChannelFragment.this, false);
                  }
                }, 300L);
                return true;
                bool1 = bool2;
              } while (RadioChannelFragment.f(RadioChannelFragment.this));
              if (!com.baidu.carlife.core.screen.presentation.a.g.a().isDialogShown()) {
                break;
              }
              bool1 = bool2;
            } while (!com.baidu.carlife.f.d.a().i());
            RadioChannelFragment.b(RadioChannelFragment.this).setCurrentItem(RadioChannelFragment.b(RadioChannelFragment.this).getCurrentItem() - 1);
            RadioChannelFragment.b(RadioChannelFragment.this, true);
            RadioChannelFragment.g(RadioChannelFragment.this).postDelayed(new Runnable()
            {
              public void run()
              {
                RadioChannelFragment.b(RadioChannelFragment.this, false);
              }
            }, 300L);
            return true;
          }
          RadioChannelFragment.b(RadioChannelFragment.this, RadioChannelFragment.d(RadioChannelFragment.this).a(RadioChannelFragment.b(RadioChannelFragment.this).getCurrentItem()));
          return true;
        }
      });
    }
    com.baidu.carlife.f.d.a().b(new com.baidu.carlife.f.a[] { this.k, this.l });
    com.baidu.carlife.f.d.a().h(this.l);
  }
  
  protected void onInitView() {}
  
  public void onPause()
  {
    super.onPause();
    dismissGuideHint();
  }
  
  public void onResume()
  {
    super.onResume();
    k.b(4023);
  }
  
  protected void onUpdateOrientation(int paramInt) {}
  
  protected void onUpdateSkin()
  {
    super.onUpdateSkin();
  }
  
  protected void onUpdateStyle(boolean paramBoolean) {}
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/radio/channel/RadioChannelFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */