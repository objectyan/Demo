package com.baidu.carlife.bluetooth;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageButton;
import android.widget.TextView;
import com.baidu.carlife.BaiduNaviApplication;
import com.baidu.carlife.core.i;
import com.baidu.carlife.core.j;
import com.baidu.carlife.core.k;
import com.baidu.carlife.f.d;
import com.baidu.carlife.logic.q;
import com.baidu.carlife.logic.q.g;
import java.util.Locale;

public class g
{
  private static final String a = g.class.getSimpleName();
  private static final int b = -1;
  private static final int c = 1;
  private static final int d = 2;
  private static final int e = 3;
  private static a f = null;
  private static g g = null;
  private static Context i = null;
  private static int l = -1;
  private static boolean m = false;
  private static boolean n = false;
  private static boolean o = false;
  private static boolean p = false;
  private b h = new b(null);
  private int j = 0;
  private boolean k = false;
  private q.g q = new q.g()
  {
    public void a()
    {
      i.b(g.g(), "on PhoneStateActive");
    }
    
    public void a(boolean paramAnonymousBoolean)
    {
      i.b(g.g(), "on PhoneStateIDLE");
      if (g.i() == -1) {
        i.b(g.g(), "From Initial State to Call Idle State");
      }
      for (;;)
      {
        g.a(0);
        g.b(false);
        g.a(false);
        g.a(g.this, false);
        g.e(g.this);
        return;
        if (g.i() != 0) {
          if (g.i() == 1)
          {
            i.b(g.g(), "From Ring State to Call Idle State");
            if (g.c(g.this)) {
              g.d(g.this);
            }
            if (com.baidu.carlife.util.b.d()) {
              g.this.e();
            }
          }
          else if (g.i() == 2)
          {
            i.b(g.g(), "From Offhook State to Call Idle State");
            if (g.c(g.this)) {
              g.d(g.this);
            }
            if (com.baidu.carlife.util.b.d()) {
              g.this.e();
            }
          }
        }
      }
    }
    
    public void b(boolean paramAnonymousBoolean)
    {
      i.b(g.g(), "on PhoneCallRinging");
      if (g.i() == -1)
      {
        i.b(g.g(), "From Initial State to Call Ring State");
        new Handler().postDelayed(new Runnable()
        {
          public void run()
          {
            g.b(g.this, 1);
          }
        }, 100L);
      }
      for (;;)
      {
        g.b(false);
        g.a(true);
        g.a(1);
        return;
        if (g.i() == 0)
        {
          i.b(g.g(), "From Idle State to Call Ring State");
          g.b(g.this, 1);
          if ((com.baidu.carlife.util.b.d()) && ((com.baidu.carlife.util.b.b()) || (com.baidu.carlife.util.b.c()))) {
            g.this.d();
          }
          if (g.f(g.this)) {
            g.g(g.this);
          }
        }
        else if (g.i() == 1)
        {
          i.b(g.g(), "From Ring State to Call Ring State");
        }
        else if (g.i() == 2)
        {
          i.b(g.g(), "From Offhook State to Call Ring State");
        }
      }
    }
    
    public void c(boolean paramAnonymousBoolean)
    {
      i.b(g.g(), "on PhoneStateOffhook");
      if (g.i() == -1)
      {
        i.b(g.g(), "From Initial State to Call Offhook State");
        if (!com.baidu.carlife.l.a.a().e()) {
          c.a(true);
        }
      }
      for (;;)
      {
        g.a(2);
        return;
        if (g.i() == 0)
        {
          i.b(g.g(), "From Idle State to Call Offhook State");
          g.b(true);
          g.b(g.this, 2);
          g.a(true);
          g.g(g.this);
        }
        else if (g.i() == 1)
        {
          i.b(g.g(), "From Ring State to Call Offhook State");
          if (g.h(g.this))
          {
            g.a(true);
            g.g(g.this);
          }
          for (;;)
          {
            if (!com.baidu.carlife.util.b.d()) {
              break label155;
            }
            g.this.e();
            break;
            if (g.c(g.this)) {
              g.d(g.this);
            }
          }
        }
        else
        {
          label155:
          if (g.i() == 2) {
            i.b(g.g(), "From Offhook State to Call Offhook State");
          }
        }
      }
    }
    
    public void d(boolean paramAnonymousBoolean) {}
  };
  private View r = null;
  private WindowManager s = null;
  
  public g()
  {
    f = new a(null);
    k.a(this.h);
  }
  
  public static g a()
  {
    if (g == null) {}
    try
    {
      if (g == null) {
        g = new g();
      }
      return g;
    }
    finally {}
  }
  
  private void a(View paramView)
  {
    d locald = d.a();
    com.baidu.carlife.f.g localg = new com.baidu.carlife.f.g(paramView, 4);
    localg.d(paramView.findViewById(2131624716)).d(paramView.findViewById(2131624717));
    locald.b(localg);
  }
  
  private View b(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2130968726, null);
    ((TextView)paramContext.findViewById(2131624714)).setText(q.f().a());
    ((ImageButton)paramContext.findViewById(2131624716)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        i.b(g.g(), "answer call.");
        q.f().m();
        g.this.e();
      }
    });
    ((ImageButton)paramContext.findViewById(2131624717)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        i.b(g.g(), "reject call");
        q.f().a(BaiduNaviApplication.getInstance());
        g.this.e();
      }
    });
    a(paramContext);
    return paramContext;
  }
  
  private void b(int paramInt) {}
  
  private boolean k()
  {
    return p;
  }
  
  private void l() {}
  
  private boolean m()
  {
    return (Build.MODEL.toLowerCase(Locale.ENGLISH).contains("lg-d857")) || (Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).contains("xiaomi"));
  }
  
  private boolean n()
  {
    if (Build.VERSION.SDK_INT >= 21) {}
    while (Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).contains("xiaomi")) {
      return false;
    }
    return true;
  }
  
  private void o()
  {
    this.j = 30;
    k.b(2024);
  }
  
  private void p()
  {
    k.a(2024);
  }
  
  private WindowManager.LayoutParams q()
  {
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
    localLayoutParams.type = 2010;
    localLayoutParams.flags = 132096;
    localLayoutParams.format = -3;
    localLayoutParams.width = -1;
    localLayoutParams.height = -1;
    localLayoutParams.gravity = 17;
    return localLayoutParams;
  }
  
  public void a(Context paramContext)
  {
    i = paramContext;
    this.j = 0;
    m = false;
    this.k = false;
    p = false;
    l = -1;
    q.f().a(this.q);
  }
  
  public void b()
  {
    if (k()) {
      l();
    }
    q.f().b(this.q);
  }
  
  public a c()
  {
    return f;
  }
  
  public void d()
  {
    if ((this.r != null) && (this.r.getParent() != null))
    {
      i.c(a, "return cause already shown");
      return;
    }
    Object localObject = BaiduNaviApplication.getInstance().getApplicationContext();
    if (this.s == null) {
      this.s = ((WindowManager)((Context)localObject).getSystemService("window"));
    }
    this.r = b((Context)localObject);
    localObject = q();
    this.s.addView(this.r, (ViewGroup.LayoutParams)localObject);
    i.c(a, "add view");
  }
  
  public void e()
  {
    if (this.r != null)
    {
      i.c(a, "hidePopupWindow");
      this.s.removeView(this.r);
      this.r = null;
    }
    d.a().b(null);
  }
  
  private class a
    extends l
  {
    private a() {}
    
    public void a()
    {
      i.b(g.g(), "onStart: ");
    }
    
    public void a(Intent paramIntent)
    {
      i.b(g.g(), "onNewIntent: ");
      int i;
      if (paramIntent != null)
      {
        i = paramIntent.getIntExtra("com.baidu.carlife.callstate", -2);
        i.b(g.g(), "get Intent Extra: com.baidu.carlife.callstate = " + i);
        if (i != 1) {
          break label65;
        }
        if (com.baidu.carlife.util.b.d()) {
          g.this.d();
        }
      }
      label65:
      do
      {
        do
        {
          return;
          if (i != 2) {
            break;
          }
          if (g.c(g.this)) {
            new Handler().postDelayed(new Runnable()
            {
              public void run()
              {
                g.d(g.this);
              }
            }, 1000L);
          }
        } while (!com.baidu.carlife.util.b.d());
        g.this.d();
        return;
      } while ((i != -2) || (!Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).contains("xiaomi")) || (!g.c(g.this)));
      new Handler().postDelayed(new Runnable()
      {
        public void run()
        {
          g.d(g.this);
        }
      }, 1000L);
    }
    
    public void b()
    {
      i.b(g.g(), "onStop: ");
      new Handler().postDelayed(new Runnable()
      {
        public void run()
        {
          if (!g.j())
          {
            i.b(g.g(), "no phonecall,and send background message");
            c.a(false);
            return;
          }
          i.b(g.g(), "Phone calling cause switching and dont send background message");
          g.a(false);
        }
      }, 1000L);
    }
    
    public void c()
    {
      i.b(g.g(), "onPause: ");
    }
    
    public void d()
    {
      i.b(g.g(), "onResume: ");
      com.baidu.carlife.l.a.a().g();
      c.a(true);
    }
    
    public void e()
    {
      i.b(g.g(), "onConfigurationChanged: ");
    }
  }
  
  private class b
    extends j
  {
    private b() {}
    
    public void careAbout()
    {
      addMsg(2024);
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        return;
      }
      paramMessage = com.baidu.carlife.processes.a.c(g.f());
      i.b(g.g(), "Top process name = " + paramMessage);
      if (com.baidu.carlife.processes.a.b(g.f()))
      {
        i.b(g.g(), "Pull carlife to foreground");
        postDelayed(new Runnable()
        {
          public void run()
          {
            if (com.baidu.carlife.util.b.d())
            {
              if (g.h()) {
                b.a().c(-1);
              }
              return;
            }
            b.a().c(g.i());
          }
        }, 1000L);
        g.a(g.this, 0);
        return;
      }
      if ((g.a(g.this) > 0) || (g.b(g.this)))
      {
        k.a(2024, 200);
        return;
      }
      i.b(g.g(), "Timeout: Pull carlife to foreground failed,and set carlife to background");
      c.a(false);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/bluetooth/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */