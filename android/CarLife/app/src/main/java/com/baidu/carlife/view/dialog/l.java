package com.baidu.carlife.view.dialog;

import android.content.Context;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.carlife.f.a;
import com.baidu.carlife.f.d;
import com.baidu.carlife.f.g;
import com.baidu.carlife.view.KeyboardResultView;
import com.baidu.carlife.view.KeyboardResultView.b;
import com.baidu.carlife.view.KeyboardResultView.c;
import com.baidu.carlife.view.b;

public class l
  extends BaseDialog
  implements View.OnClickListener
{
  private static final int e = 26;
  private TextView A;
  private KeyboardResultView.c B;
  private View.OnClickListener C;
  private boolean D = false;
  private boolean E = false;
  private g F = null;
  private g G = null;
  private g H = null;
  private g I = null;
  private g J = null;
  private View f;
  private View g;
  private View h;
  private EditText i;
  private KeyboardResultView j;
  private b k;
  private View l;
  private View m;
  private ImageView n;
  private View o;
  private TextView p;
  private View q;
  private TextView r;
  private TextView s;
  private View t;
  private View u;
  private TextView v;
  private View w;
  private TextView[] x;
  private char[] y;
  private TextView[] z;
  
  public l(Context paramContext)
  {
    super(paramContext);
  }
  
  protected View a()
  {
    View localView = LayoutInflater.from(this.c).inflate(2130968876, null);
    setCanceledOnTouchOutside(true);
    return localView;
  }
  
  protected void b()
  {
    this.i = ((EditText)findViewById(2131625405));
    this.j = ((KeyboardResultView)findViewById(2131625404));
    this.k = new b(this.c);
    this.j.setAdapter(this.k);
    this.j.setPageCallback(new KeyboardResultView.b()
    {
      public void a(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, int paramAnonymousInt)
      {
        float f2 = 0.3F;
        int i;
        if ((l.a(l.this).getCount() == 0) && (TextUtils.isEmpty(l.b(l.this).getText())))
        {
          l.c(l.this).setVisibility(0);
          l.this.findViewById(2131625399).setVisibility(0);
          l.d(l.this).setVisibility(8);
          l.e(l.this).setVisibility(8);
          l.this.findViewById(2131625401).setVisibility(8);
          l.this.findViewById(2131625403).setVisibility(8);
          if (l.f(l.this) != null)
          {
            if (paramAnonymousInt <= 0) {
              break label505;
            }
            l.f(l.this).i();
            if (paramAnonymousBoolean1) {
              l.f(l.this).d(l.d(l.this));
            }
            i = 0;
            label158:
            if ((i < paramAnonymousInt) && (i <= l.g(l.this).getChildCount())) {
              break label473;
            }
            if (paramAnonymousBoolean2) {
              l.f(l.this).d(l.e(l.this));
            }
            l.f(l.this).c(l.g(l.this).getChildAt(0));
            if (l.h(l.this))
            {
              l.f(l.this).a();
              l.a(l.this, false);
            }
          }
        }
        label473:
        label505:
        do
        {
          return;
          l.c(l.this).setVisibility(8);
          l.this.findViewById(2131625399).setVisibility(8);
          if ((paramAnonymousBoolean1) || (paramAnonymousBoolean2))
          {
            l.d(l.this).setVisibility(0);
            l.e(l.this).setVisibility(0);
            l.this.findViewById(2131625401).setVisibility(0);
            l.this.findViewById(2131625403).setVisibility(0);
            l.d(l.this).setEnabled(paramAnonymousBoolean1);
            View localView = l.d(l.this);
            if (paramAnonymousBoolean1) {}
            for (float f1 = 1.0F;; f1 = 0.3F)
            {
              localView.setAlpha(f1);
              l.e(l.this).setEnabled(paramAnonymousBoolean2);
              localView = l.e(l.this);
              f1 = f2;
              if (paramAnonymousBoolean2) {
                f1 = 1.0F;
              }
              localView.setAlpha(f1);
              break;
            }
          }
          l.d(l.this).setVisibility(8);
          l.e(l.this).setVisibility(8);
          l.this.findViewById(2131625401).setVisibility(8);
          l.this.findViewById(2131625403).setVisibility(8);
          break;
          l.f(l.this).d(l.g(l.this).getChildAt(i));
          i += 1;
          break label158;
          l.f(l.this).i();
          l.f(l.this).d(l.c(l.this));
          l.f(l.this).c(l.c(l.this));
        } while (!l.h(l.this));
        l.f(l.this).a();
        l.a(l.this, false);
      }
    });
    this.j.setItemClickListener(new KeyboardResultView.c()
    {
      public void a(int paramAnonymousInt, View paramAnonymousView)
      {
        if (l.i(l.this) != null) {
          l.i(l.this).a(paramAnonymousInt, paramAnonymousView);
        }
      }
    });
    this.l = findViewById(2131625406);
    this.m = findViewById(2131625443);
    this.f = findViewById(2131625398);
    this.f.setOnClickListener(this);
    this.g = findViewById(2131625400);
    this.g.setOnClickListener(this);
    this.h = findViewById(2131625402);
    this.h.setOnClickListener(this);
    this.n = ((ImageView)findViewById(2131625429));
    this.n.setOnClickListener(this);
    this.o = findViewById(2131625439);
    this.o.setOnClickListener(this);
    this.p = ((TextView)findViewById(2131625440));
    this.p.setOnClickListener(this);
    this.q = findViewById(2131625437);
    this.q.setOnClickListener(this);
    this.r = ((TextView)findViewById(2131625442));
    this.r.setOnClickListener(this);
    this.s = ((TextView)findViewById(2131625441));
    this.s.setOnClickListener(this);
    this.t = findViewById(2131625459);
    this.t.setOnClickListener(this);
    this.u = findViewById(2131625448);
    this.u.setOnClickListener(this);
    this.v = ((TextView)findViewById(2131625463));
    this.v.setOnClickListener(this);
    this.w = findViewById(2131625460);
    this.w.setOnClickListener(this);
    this.y = new char[] { 113, 119, 101, 114, 116, 121, 117, 105, 111, 112, 97, 115, 100, 102, 103, 104, 106, 107, 108, 122, 120, 99, 118, 98, 110, 109 };
    this.x = new TextView[26];
    this.x[0] = ((TextView)findViewById(2131625408));
    this.x[1] = ((TextView)findViewById(2131625409));
    this.x[2] = ((TextView)findViewById(2131625410));
    this.x[3] = ((TextView)findViewById(2131625411));
    this.x[4] = ((TextView)findViewById(2131625412));
    this.x[5] = ((TextView)findViewById(2131625413));
    this.x[6] = ((TextView)findViewById(2131625414));
    this.x[7] = ((TextView)findViewById(2131625415));
    this.x[8] = ((TextView)findViewById(2131625416));
    this.x[9] = ((TextView)findViewById(2131625417));
    this.x[10] = ((TextView)findViewById(2131625419));
    this.x[11] = ((TextView)findViewById(2131625420));
    this.x[12] = ((TextView)findViewById(2131625421));
    this.x[13] = ((TextView)findViewById(2131625422));
    this.x[14] = ((TextView)findViewById(2131625423));
    this.x[15] = ((TextView)findViewById(2131625424));
    this.x[16] = ((TextView)findViewById(2131625425));
    this.x[17] = ((TextView)findViewById(2131625426));
    this.x[18] = ((TextView)findViewById(2131625427));
    this.x[19] = ((TextView)findViewById(2131625430));
    this.x[20] = ((TextView)findViewById(2131625431));
    this.x[21] = ((TextView)findViewById(2131625432));
    this.x[22] = ((TextView)findViewById(2131625433));
    this.x[23] = ((TextView)findViewById(2131625434));
    this.x[24] = ((TextView)findViewById(2131625435));
    this.x[25] = ((TextView)findViewById(2131625436));
    TextView[] arrayOfTextView = this.x;
    int i2 = arrayOfTextView.length;
    int i1 = 0;
    while (i1 < i2)
    {
      arrayOfTextView[i1].setOnClickListener(this);
      i1 += 1;
    }
    this.z = new TextView[16];
    this.z[0] = ((TextView)findViewById(2131625461));
    this.z[1] = ((TextView)findViewById(2131625445));
    this.z[2] = ((TextView)findViewById(2131625446));
    this.z[3] = ((TextView)findViewById(2131625447));
    this.z[4] = ((TextView)findViewById(2131625450));
    this.z[5] = ((TextView)findViewById(2131625451));
    this.z[6] = ((TextView)findViewById(2131625452));
    this.z[7] = ((TextView)findViewById(2131625455));
    this.z[8] = ((TextView)findViewById(2131625456));
    this.z[9] = ((TextView)findViewById(2131625457));
    this.z[10] = ((TextView)findViewById(2131625444));
    this.z[11] = ((TextView)findViewById(2131625449));
    this.z[12] = ((TextView)findViewById(2131625453));
    this.z[13] = ((TextView)findViewById(2131625454));
    this.z[14] = ((TextView)findViewById(2131625458));
    this.z[15] = ((TextView)findViewById(2131625462));
    arrayOfTextView = this.z;
    i2 = arrayOfTextView.length;
    i1 = 0;
    while (i1 < i2)
    {
      arrayOfTextView[i1].setOnClickListener(this);
      i1 += 1;
    }
    this.A = ((TextView)findViewById(2131625464));
    this.A.setOnClickListener(this);
  }
  
  public void f()
  {
    if (this.F == null)
    {
      this.F = new g(findViewById(2131625397), 7, false);
      this.G = new g(findViewById(2131625407), 13, false);
      this.H = new g(findViewById(2131625418), 14, false);
      this.I = new g(findViewById(2131625428), 15, false);
      this.J = new g(findViewById(2131625438), 11, false);
      View.OnKeyListener local3 = new View.OnKeyListener()
      {
        public boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          boolean bool = true;
          if ((paramAnonymousKeyEvent == null) || (paramAnonymousKeyEvent.getAction() != 0))
          {
            bool = false;
            return bool;
          }
          if ((l.j(l.this) != null) && (l.j(l.this).getVisibility() == 0))
          {
            switch (paramAnonymousInt)
            {
            }
            return false;
          }
          if (paramAnonymousInt == 19)
          {
            l.this.d();
            return true;
          }
          return false;
        }
      };
      View.OnKeyListener local4 = new View.OnKeyListener()
      {
        public boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          boolean bool = true;
          if ((paramAnonymousKeyEvent == null) || (paramAnonymousKeyEvent.getAction() != 0))
          {
            bool = false;
            return bool;
          }
          if ((l.j(l.this) != null) && (l.j(l.this).getVisibility() == 0))
          {
            switch (paramAnonymousInt)
            {
            }
            return false;
          }
          if (paramAnonymousInt == 20)
          {
            l.this.d();
            return true;
          }
          return false;
        }
      };
      View.OnKeyListener local5 = new View.OnKeyListener()
      {
        public boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          boolean bool = true;
          if ((paramAnonymousKeyEvent == null) || (paramAnonymousKeyEvent.getAction() != 0))
          {
            bool = false;
            return bool;
          }
          if ((l.j(l.this) != null) && (l.j(l.this).getVisibility() == 0))
          {
            switch (paramAnonymousInt)
            {
            }
            return false;
          }
          if ((paramAnonymousInt == 19) && (l.c(l.this).getVisibility() == 8) && (l.a(l.this).getCount() == 0))
          {
            l.this.d();
            return true;
          }
          return false;
        }
      };
      View.OnKeyListener local6 = new View.OnKeyListener()
      {
        public boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          if ((paramAnonymousKeyEvent == null) || (paramAnonymousKeyEvent.getAction() != 0)) {}
          while ((l.j(l.this) == null) || (l.j(l.this).getVisibility() != 0)) {
            return false;
          }
          switch (paramAnonymousInt)
          {
          default: 
            return false;
          }
          return true;
        }
      };
      this.F.a(local3);
      this.J.a(local4);
      this.G.a(local5);
      this.H.a(local6);
      this.I.a(local6);
    }
    int i1;
    while (this.E)
    {
      this.F.d(this.f);
      this.G.d(this.z[10]);
      i1 = 1;
      for (;;)
      {
        if (i1 < 4)
        {
          this.G.d(this.z[i1]);
          i1 += 1;
          continue;
          this.F.i();
          this.G.i();
          this.H.i();
          this.I.i();
          this.J.i();
          break;
        }
      }
      this.G.d(this.u);
      this.H.d(this.z[11]);
      i1 = 4;
      while (i1 < 7)
      {
        this.H.d(this.z[i1]);
        i1 += 1;
      }
      this.H.d(this.z[12]);
      this.I.d(this.z[13]);
      i1 = 7;
      while (i1 < 10)
      {
        this.I.d(this.z[i1]);
        i1 += 1;
      }
      this.I.d(this.z[14]);
      this.J.d(this.t).d(this.w).d(this.z[0]).d(this.z[15]).d(this.v);
      this.F.b(this.f).a(true);
      this.G.b(this.z[2]).b(true).a(true);
      this.H.b(this.z[5]).b(true).a(true);
      this.I.b(this.z[8]).b(true).a(true);
      this.J.b(this.z[0]).b(true).a(true);
    }
    for (;;)
    {
      d.a().a(new a[] { this.F, this.H, this.I, this.J, this.G });
      d.a().h(this.G);
      return;
      this.F.d(this.f);
      i1 = 0;
      while (i1 < 10)
      {
        this.G.d(this.x[i1]);
        i1 += 1;
      }
      i1 = 10;
      while (i1 < 19)
      {
        this.H.d(this.x[i1]);
        i1 += 1;
      }
      this.I.d(this.n);
      i1 = 19;
      while (i1 < 26)
      {
        this.I.d(this.x[i1]);
        i1 += 1;
      }
      this.I.d(this.q);
      this.J.d(this.o).d(this.p).d(this.s).d(this.r);
      this.F.b(this.f).a(true);
      this.G.b(this.x[4]).b(true).a(true);
      this.H.b(this.x[14]).b(true).a(true);
      this.I.b(this.x[22]).b(true).a(true);
      this.J.b(this.s).b(true).a(true);
    }
  }
  
  public void g()
  {
    super.g();
    this.F = null;
    this.G = null;
    this.H = null;
    this.I = null;
    this.J = null;
  }
  
  public TextView getLetterFinishKey()
  {
    return this.r;
  }
  
  public View getLetterKeyboard()
  {
    return this.l;
  }
  
  public TextView[] getLetterKeys()
  {
    return this.x;
  }
  
  public TextView getLetterLanguageKey()
  {
    return this.p;
  }
  
  public ImageView getLetterShiftKey()
  {
    return this.n;
  }
  
  public int getLetterSize()
  {
    return 26;
  }
  
  public TextView getLetterSpaceKey()
  {
    return this.s;
  }
  
  public char[] getLetters()
  {
    return this.y;
  }
  
  public TextView getNumFinishKey()
  {
    return this.v;
  }
  
  public View getNumKeyboard()
  {
    return this.m;
  }
  
  public b getResultAdapter()
  {
    return this.k;
  }
  
  public EditText getResultEditText()
  {
    return this.i;
  }
  
  public KeyboardResultView getResultKeyboard()
  {
    return this.j;
  }
  
  public void i()
  {
    if (this.A != null)
    {
      this.A.setVisibility(0);
      this.A.bringToFront();
    }
  }
  
  public void j()
  {
    if (this.A != null) {
      this.A.setVisibility(8);
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.C != null) {
      this.C.onClick(paramView);
    }
    if ((paramView.getId() == this.g.getId()) || (paramView.getId() == this.h.getId()))
    {
      this.D = true;
      return;
    }
    this.D = false;
  }
  
  public void setNeedGrantResultFocus(boolean paramBoolean)
  {
    this.D = paramBoolean;
  }
  
  public void setNumType(boolean paramBoolean)
  {
    this.E = paramBoolean;
    f();
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.C = paramOnClickListener;
  }
  
  public void setResultItemClickListener(KeyboardResultView.c paramc)
  {
    this.B = paramc;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/view/dialog/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */