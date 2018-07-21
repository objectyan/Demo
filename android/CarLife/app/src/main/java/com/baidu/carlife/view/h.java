package com.baidu.carlife.view;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import com.baidu.carlife.CarlifeActivity;
import com.baidu.carlife.adpter.s;
import com.baidu.carlife.adpter.s.a;
import com.baidu.carlife.core.e;
import com.baidu.carlife.core.f;
import com.baidu.carlife.core.screen.BaseDialog.a;
import com.baidu.carlife.logic.q;
import com.baidu.carlife.logic.voice.ReceiveDataThread;
import com.baidu.carlife.logic.voice.j;
import com.baidu.carlife.util.w;
import com.baidu.carlife.view.a.b;
import com.baidu.carlife.view.dialog.k;
import com.baidu.carlife.view.dialog.v;
import com.baidu.navi.controller.BottomTabDisplayController;
import com.baidu.navi.util.StatisticManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class h
  implements View.OnClickListener, AdapterView.OnItemClickListener
{
  private static final String a = "CarLifeVoice";
  private static final String c = "…";
  private boolean b = false;
  private int d = 1;
  private String e;
  private Context f;
  private v g;
  private View h;
  private TextView i;
  private TextView j;
  private ImageView k;
  private ImageView l;
  private ImageView m;
  private ImageView n;
  private ImageView o;
  private ImageView p;
  private ImageView q;
  private WaveformView r;
  private ScrollView s;
  private ListView t;
  private s u;
  private RotateAnimation v;
  private boolean w;
  private List<j> x = new ArrayList();
  private int y;
  private boolean z = false;
  
  private void a(int paramInt, String paramString)
  {
    com.baidu.carlife.core.i.b("Voice", "--postProcess--event:" + paramInt + "----lastEvent:" + this.y);
    if (paramInt != this.y) {
      k();
    }
    this.y = paramInt;
    d(paramInt).b(paramString);
  }
  
  private void b(int paramInt) {}
  
  private void b(int paramInt1, int paramInt2)
  {
    a(paramInt1, this.f.getString(paramInt2));
  }
  
  private j c(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return new com.baidu.carlife.logic.voice.i(this);
    case 1: 
      return new com.baidu.carlife.logic.voice.i(this);
    case 3: 
      return new com.baidu.carlife.logic.voice.a(this);
    case 2: 
      return new com.baidu.carlife.logic.voice.g(this);
    }
    return new com.baidu.carlife.logic.voice.d(this);
  }
  
  private j d(int paramInt)
  {
    Iterator localIterator = this.x.iterator();
    while (localIterator.hasNext())
    {
      j localj = (j)localIterator.next();
      if (paramInt == localj.a()) {
        return localj;
      }
    }
    this.x.add(c(paramInt));
    return d(paramInt);
  }
  
  private void g()
  {
    this.t.setVisibility(8);
    this.q.setVisibility(4);
    this.h.findViewById(2131626112).setVisibility(0);
    this.r.setVisibility(0);
    this.o.clearAnimation();
    this.o.setVisibility(4);
    this.p.setVisibility(4);
    this.s.setVisibility(4);
    this.i.setVisibility(0);
    this.i.setText("");
    this.j.setText(2131297223);
    this.l.setVisibility(0);
    this.k.setVisibility(8);
  }
  
  private void h()
  {
    if (b())
    {
      this.z = false;
      g();
      com.baidu.carlife.core.screen.presentation.a.g.a().dismissDialog(this.g);
      k();
      if (this.b) {
        w.a("VoiceRecognitionWindow: closeVoiceFull");
      }
      BottomTabDisplayController.getInstance().panelHide();
    }
  }
  
  private boolean i()
  {
    return this.w;
  }
  
  private void j()
  {
    this.w = false;
    this.k.setVisibility(8);
  }
  
  private void k()
  {
    Iterator localIterator = this.x.iterator();
    while (localIterator.hasNext()) {
      ((j)localIterator.next()).b();
    }
  }
  
  private void l()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.k.getLayoutParams();
    localLayoutParams.height = ((int)this.f.getResources().getDimension(2131361843));
    localLayoutParams.width = ((int)this.f.getResources().getDimension(2131361847));
    this.k.setLayoutParams(localLayoutParams);
    this.k.setBackground(b.a(this.f));
  }
  
  private void m()
  {
    this.k.setImageResource(2130838265);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.k.getLayoutParams();
    localLayoutParams.height = ((int)this.f.getResources().getDimension(2131361842));
    localLayoutParams.width = ((int)this.f.getResources().getDimension(2131361843));
    this.k.setLayoutParams(localLayoutParams);
    this.k.setBackgroundResource(2130838409);
  }
  
  public void a()
  {
    com.baidu.carlife.core.screen.presentation.a.g.a().showDialog(this.g, BaseDialog.a.b);
    this.z = true;
    if (this.b) {
      w.a("VoiceRecognitionWindow: show");
    }
    BottomTabDisplayController.getInstance().panelShow();
  }
  
  public void a(int paramInt)
  {
    a(paramInt, -1, null);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2, null);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    switch (paramInt1)
    {
    default: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
      do
      {
        return;
        this.d = 2;
        this.t.setVisibility(8);
        this.q.setVisibility(4);
        this.h.findViewById(2131626112).setVisibility(0);
        this.r.setVisibility(0);
        this.o.clearAnimation();
        this.o.setVisibility(4);
        this.p.setVisibility(4);
        this.s.setVisibility(4);
        this.i.setVisibility(0);
        this.i.setText("");
        this.j.setText(2131297223);
        this.l.setVisibility(0);
        this.k.setVisibility(8);
        this.g.i();
        return;
        this.d = 3;
        this.i.setText("");
        this.j.setText(2131297159);
        return;
        this.d = 4;
        this.r.setVisibility(4);
        this.p.setVisibility(0);
        this.o.setVisibility(0);
        this.o.startAnimation(this.v);
        this.q.setVisibility(4);
        this.i.setText("");
        this.j.setText(2131296535);
        return;
        this.d = 1;
        this.r.setVisibility(4);
        this.o.clearAnimation();
        this.o.setVisibility(4);
        this.p.setVisibility(4);
        this.q.setVisibility(0);
        this.j.setText("");
      } while (1 != paramInt2);
      this.j.setText(2131296536);
      return;
    case 6: 
      this.d = 6;
      this.j.setText("");
      b(paramInt2);
      switch (paramInt2)
      {
      default: 
        if (!e.a().r()) {
          b(3, 2131297413);
        }
        break;
      }
      while (!TextUtils.isEmpty(paramString))
      {
        this.i.setText(paramString);
        return;
        b(3, 2131297407);
        return;
        a(4, String.format(this.f.getString(2131297409), new Object[] { paramString }));
        return;
        b(3, 2131297412);
        return;
        b(3, 2131297405);
        StatisticManager.onEvent("1007", "小度无法启动");
        return;
        if (TextUtils.isEmpty(paramString)) {}
        for (paramString = this.f.getString(2131297411);; paramString = String.format(this.f.getString(2131297409), new Object[] { paramString }))
        {
          a(4, paramString);
          return;
        }
        if (TextUtils.isEmpty(this.e)) {
          paramString = this.f.getString(2131297414);
        }
        for (;;)
        {
          a(4, paramString);
          return;
          paramString = String.format(this.f.getString(2131297409), new Object[] { this.e });
          a(null);
        }
        a(3, this.f.getString(2131297397));
        return;
        this.l.setVisibility(8);
        this.s.setVisibility(8);
        b(3, 2131297410);
        return;
        b(1, 2131297404);
      }
    }
    this.s.setVisibility(0);
    this.j.setText(2131297224);
    this.i.setVisibility(4);
    this.l.setVisibility(4);
    this.m.setVisibility(4);
    this.n.setVisibility(4);
    this.h.findViewById(2131626112).setVisibility(4);
    this.t.setVisibility(8);
    this.k.setImageResource(2130838256);
    this.k.setVisibility(0);
    l();
    this.g.i();
  }
  
  public void a(CarlifeActivity paramCarlifeActivity)
  {
    this.f = paramCarlifeActivity.getApplicationContext();
    this.h = LayoutInflater.from(this.f).inflate(2130969033, null);
    this.g = new v(paramCarlifeActivity, this.h, 2131427336, this.f.getResources().getDimensionPixelSize(2131362152), 5);
    this.g.setOnDialogCancelListener(new com.baidu.carlife.core.screen.d()
    {
      public void onCancel()
      {
        com.baidu.carlife.logic.voice.n.a().i();
      }
    });
    this.g.setDialogShowHideListener(new k()
    {
      public void onDismiss()
      {
        com.baidu.carlife.logic.voice.n.a().i();
      }
      
      public void onShow() {}
    });
    this.h.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (com.baidu.carlife.core.screen.a.a.b().g()) {
          com.baidu.carlife.core.screen.a.a.b().j();
        }
      }
    });
    this.j = ((TextView)this.h.findViewById(2131626109));
    this.i = ((TextView)this.h.findViewById(2131626117));
    this.k = ((ImageView)this.h.findViewById(2131626107));
    this.k.setOnClickListener(this);
    this.l = ((ImageView)this.h.findViewById(2131626108));
    this.l.setOnClickListener(this);
    this.m = ((ImageView)this.h.findViewById(2131626110));
    this.m.setOnClickListener(this);
    this.n = ((ImageView)this.h.findViewById(2131626111));
    this.n.setOnClickListener(this);
    this.r = ((WaveformView)this.h.findViewById(2131626113));
    this.r.setOnClickListener(this);
    this.o = ((ImageView)this.h.findViewById(2131626114));
    this.p = ((ImageView)this.h.findViewById(2131626115));
    this.q = ((ImageView)this.h.findViewById(2131626116));
    this.q.setOnClickListener(this);
    this.s = ((ScrollView)this.h.findViewById(2131625205));
    this.t = ((ListView)this.h.findViewById(2131626118));
    this.u = new s(this.f);
    this.t.setAdapter(this.u);
    this.t.setOnItemClickListener(this);
    this.v = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
    this.v.setDuration(1000L);
    this.v.setInterpolator(new LinearInterpolator());
    this.v.setRepeatCount(-1);
    paramCarlifeActivity = (TextView)this.s.findViewById(2131623980);
    if (f.jr)
    {
      paramCarlifeActivity.setText(2131297209);
      this.s.findViewById(2131624643).setVisibility(0);
      this.s.findViewById(2131626184).setVisibility(0);
      return;
    }
    paramCarlifeActivity.setText(2131297210);
    this.s.findViewById(2131624643).setVisibility(8);
    this.s.findViewById(2131626184).setVisibility(8);
  }
  
  public void a(String paramString)
  {
    this.e = paramString;
  }
  
  public void a(final List paramList, final s.a parama)
  {
    this.t.post(new Runnable()
    {
      public void run()
      {
        h.a(h.this).a(paramList, parama);
        h.b(h.this).setVisibility(0);
        h.b(h.this).smoothScrollToPosition(0);
        h.c(h.this).setText("");
        String str;
        if (parama == s.a.a) {
          str = h.d(h.this).getString(2131297215);
        }
        for (;;)
        {
          h.e(h.this).setText(str);
          com.baidu.carlife.m.a.a().a(null);
          com.baidu.carlife.m.a.a().b(str, 1);
          return;
          if (parama == s.a.b) {
            str = h.d(h.this).getString(2131297216);
          } else {
            str = h.d(h.this).getString(2131297219);
          }
        }
      }
    });
  }
  
  public void b(String paramString)
  {
    String str = paramString;
    if (paramString.length() > 30) {
      str = "…" + paramString.substring(paramString.length() - 30, paramString.length());
    }
    this.i.setText(str);
  }
  
  public boolean b()
  {
    return this.z;
  }
  
  public void c()
  {
    this.w = true;
    a(7);
    StatisticManager.onEvent("1013", "1013");
  }
  
  public TextView d()
  {
    return this.i;
  }
  
  public void e()
  {
    if (this.l == null) {
      return;
    }
    this.l.postDelayed(new Runnable()
    {
      public void run()
      {
        c.a().a(2130838283, 2130838723);
      }
    }, 50L);
  }
  
  public void f()
  {
    if (i()) {
      j();
    }
    h();
  }
  
  public void onClick(View paramView)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    switch (paramView.getId())
    {
    case 2131626109: 
    case 2131626112: 
    case 2131626114: 
    case 2131626115: 
    default: 
      return;
    case 2131626113: 
    case 2131626116: 
      switch (this.d)
      {
      case 2: 
      case 3: 
      case 4: 
      default: 
        return;
      }
      com.baidu.carlife.logic.voice.n.a().f();
      return;
    case 2131626107: 
      if (com.baidu.carlife.core.screen.a.a.b().g()) {
        com.baidu.carlife.core.screen.a.a.b().j();
      }
      if (i())
      {
        j();
        return;
      }
      com.baidu.carlife.logic.voice.n.a().i();
      return;
    case 2131626108: 
      if (com.baidu.carlife.core.screen.a.a.b().g()) {
        com.baidu.carlife.core.screen.a.a.b().j();
      }
      c();
      return;
    case 2131626110: 
      if (ReceiveDataThread.isPlayMicAudio)
      {
        w.a("外放关闭");
        this.m.setAlpha(0.5F);
        if (ReceiveDataThread.isPlayMicAudio) {
          break label220;
        }
      }
      for (;;)
      {
        ReceiveDataThread.isPlayMicAudio = bool1;
        return;
        w.a("外放打开");
        this.m.setAlpha(1.0F);
        break;
        label220:
        bool1 = false;
      }
    }
    if (com.baidu.carlife.service.a.a)
    {
      w.a("保存功能关闭");
      this.n.setAlpha(0.5F);
      if (com.baidu.carlife.service.a.a) {
        break label277;
      }
    }
    label277:
    for (bool1 = bool2;; bool1 = false)
    {
      com.baidu.carlife.service.a.a = bool1;
      return;
      w.a("保存功能打开");
      this.n.setAlpha(1.0F);
      break;
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i1 = paramAdapterView.getAdapter().getItemViewType(paramInt);
    if ((i1 == s.a.a.ordinal()) || (i1 == s.a.b.ordinal())) {
      return;
    }
    paramAdapterView = (com.baidu.carlife.model.n)paramAdapterView.getItemAtPosition(paramInt);
    q.f().a(this.f, paramAdapterView.b);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/view/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */