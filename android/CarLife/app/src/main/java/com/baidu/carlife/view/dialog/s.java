package com.baidu.carlife.view.dialog;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import com.baidu.carlife.core.i;
import com.baidu.carlife.f.a;
import com.baidu.carlife.f.c;
import com.baidu.carlife.f.g;
import com.baidu.carlife.logic.q;
import com.baidu.carlife.logic.q.a;
import com.baidu.carlife.util.r;
import com.baidu.carlife.view.softinputphonekey.SoftInputPhoneKey;

public class s
  extends BaseDialog
  implements View.OnClickListener
{
  private g A;
  private c B;
  private boolean e;
  private EditText f;
  private View g;
  private ImageButton h;
  private SoftInputPhoneKey i;
  private SoftInputPhoneKey j;
  private SoftInputPhoneKey k;
  private SoftInputPhoneKey l;
  private SoftInputPhoneKey m;
  private SoftInputPhoneKey n;
  private SoftInputPhoneKey o;
  private SoftInputPhoneKey p;
  private SoftInputPhoneKey q;
  private SoftInputPhoneKey r;
  private SoftInputPhoneKey s;
  private SoftInputPhoneKey t;
  private ListView u;
  private com.baidu.carlife.adpter.n v;
  private q w = q.f();
  private View x = null;
  private q.a y = new q.a()
  {
    public void a() {}
    
    public void a(int paramAnonymousInt)
    {
      s.b(s.this).append(String.valueOf((char)paramAnonymousInt));
    }
    
    public void b() {}
    
    public void c() {}
  };
  private View.OnKeyListener z = new View.OnKeyListener()
  {
    public boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
    {
      if ((paramAnonymousKeyEvent != null) && (paramAnonymousKeyEvent.getAction() == 0)) {
        switch (paramAnonymousInt)
        {
        }
      }
      for (;;)
      {
        return false;
        if ((s.e(s.this) != null) && (paramAnonymousView != null))
        {
          if (s.e(s.this).getVisibility() != 0)
          {
            s.this.d();
            return true;
          }
          if (paramAnonymousView.getId() == s.e(s.this).getId())
          {
            s.this.d();
            return true;
            if ((s.e(s.this) != null) && (paramAnonymousView != null) && (paramAnonymousView.getId() != s.e(s.this).getId()) && (s.f(s.this) != null) && (s.f(s.this).getCount() == 0))
            {
              return true;
              s.g(s.this);
              return true;
              s.a(s.this);
              return true;
              s.b(s.this).append("0");
              continue;
              s.b(s.this).append("1");
              continue;
              s.b(s.this).append("2");
              continue;
              s.b(s.this).append("3");
              continue;
              s.b(s.this).append("4");
              continue;
              s.b(s.this).append("5");
              continue;
              s.b(s.this).append("6");
              continue;
              s.b(s.this).append("7");
              continue;
              s.b(s.this).append("8");
              continue;
              s.b(s.this).append("9");
              continue;
              s.b(s.this).append("*");
              continue;
              s.b(s.this).append("#");
              continue;
              s.b(s.this).append("+");
            }
          }
        }
      }
    }
  };
  
  public s(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    this.e = paramBoolean;
    i();
  }
  
  /* Error */
  private void b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 99	com/baidu/carlife/view/dialog/s:v	Lcom/baidu/carlife/adpter/n;
    //   6: aload_1
    //   7: invokevirtual 103	com/baidu/carlife/adpter/n:a	(Ljava/lang/String;)V
    //   10: aload_0
    //   11: getfield 81	com/baidu/carlife/view/dialog/s:w	Lcom/baidu/carlife/logic/q;
    //   14: aload_1
    //   15: invokevirtual 106	com/baidu/carlife/logic/q:b	(Ljava/lang/String;)Ljava/util/List;
    //   18: astore_1
    //   19: aload_1
    //   20: ifnull +12 -> 32
    //   23: aload_1
    //   24: invokeinterface 112 1 0
    //   29: ifeq +15 -> 44
    //   32: aload_0
    //   33: getfield 114	com/baidu/carlife/view/dialog/s:u	Landroid/widget/ListView;
    //   36: bipush 8
    //   38: invokevirtual 120	android/widget/ListView:setVisibility	(I)V
    //   41: aload_0
    //   42: monitorexit
    //   43: return
    //   44: aload_0
    //   45: getfield 99	com/baidu/carlife/view/dialog/s:v	Lcom/baidu/carlife/adpter/n;
    //   48: aload_1
    //   49: invokevirtual 123	com/baidu/carlife/adpter/n:a	(Ljava/util/List;)V
    //   52: aload_0
    //   53: getfield 114	com/baidu/carlife/view/dialog/s:u	Landroid/widget/ListView;
    //   56: invokevirtual 126	android/widget/ListView:hasFocus	()Z
    //   59: ifeq +17 -> 76
    //   62: aload_0
    //   63: getfield 99	com/baidu/carlife/view/dialog/s:v	Lcom/baidu/carlife/adpter/n;
    //   66: invokevirtual 130	com/baidu/carlife/adpter/n:getCount	()I
    //   69: ifne +7 -> 76
    //   72: aload_0
    //   73: invokevirtual 132	com/baidu/carlife/view/dialog/s:f	()V
    //   76: aload_0
    //   77: getfield 99	com/baidu/carlife/view/dialog/s:v	Lcom/baidu/carlife/adpter/n;
    //   80: invokevirtual 135	com/baidu/carlife/adpter/n:notifyDataSetChanged	()V
    //   83: aload_0
    //   84: getfield 114	com/baidu/carlife/view/dialog/s:u	Landroid/widget/ListView;
    //   87: iconst_0
    //   88: invokevirtual 120	android/widget/ListView:setVisibility	(I)V
    //   91: aload_0
    //   92: getfield 114	com/baidu/carlife/view/dialog/s:u	Landroid/widget/ListView;
    //   95: iconst_0
    //   96: invokevirtual 138	android/widget/ListView:setSelection	(I)V
    //   99: goto -58 -> 41
    //   102: astore_1
    //   103: aload_0
    //   104: monitorexit
    //   105: aload_1
    //   106: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	this	s
    //   0	107	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	19	102	finally
    //   23	32	102	finally
    //   32	41	102	finally
    //   44	76	102	finally
    //   76	99	102	finally
  }
  
  private void i()
  {
    if (!this.e)
    {
      this.v = new com.baidu.carlife.adpter.n(getContext());
      this.u.setAdapter(this.v);
      this.u.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          paramAnonymousAdapterView = (com.baidu.carlife.model.n)paramAnonymousAdapterView.getItemAtPosition(paramAnonymousInt);
          if (paramAnonymousAdapterView != null)
          {
            s.c(s.this).a(s.this.getContext(), paramAnonymousAdapterView.b);
            s.this.d();
          }
        }
      });
      this.h.setImageResource(2130839274);
      this.h.setBackground(r.b(2130838211));
      InputFilter.LengthFilter localLengthFilter = new InputFilter.LengthFilter(40);
      this.f.setFilters(new InputFilter[] { localLengthFilter });
      this.f.addTextChangedListener(new TextWatcher()
      {
        public void afterTextChanged(Editable paramAnonymousEditable)
        {
          paramAnonymousEditable = paramAnonymousEditable.toString();
          if (TextUtils.isEmpty(paramAnonymousEditable))
          {
            s.d(s.this).setVisibility(4);
            s.this.f();
          }
          for (;;)
          {
            s.b(s.this).setSelection(paramAnonymousEditable.length());
            s.a(s.this, paramAnonymousEditable);
            return;
            s.d(s.this).setVisibility(0);
          }
        }
        
        public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      return;
    }
    this.h.setImageResource(2130839289);
    this.h.setBackground(r.b(2130838212));
    findViewById(2131624643).setVisibility(8);
    this.u.setVisibility(8);
    this.w.a(this.y);
  }
  
  private void j()
  {
    String str = this.f.getText().toString();
    if (!TextUtils.isEmpty(str)) {
      this.f.setText(str.substring(0, str.length() - 1));
    }
  }
  
  private void k()
  {
    this.f.setText("");
  }
  
  protected View a()
  {
    if (com.baidu.carlife.core.d.m()) {
      i.b("BaseDialog", "phone: show big Screen input");
    }
    for (this.x = LayoutInflater.from(this.c).inflate(2130968887, null);; this.x = LayoutInflater.from(this.c).inflate(2130968886, null))
    {
      this.x.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView) {}
      });
      return this.x;
      i.b("BaseDialog", "phone: show normal Screen input");
    }
  }
  
  public void a(com.baidu.carlife.core.screen.e parame)
  {
    super.a(parame);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.u != null)
      {
        localLayoutParams = this.u.getLayoutParams();
        localLayoutParams.width = this.c.getResources().getDimensionPixelSize(2131362115);
        this.u.setLayoutParams(localLayoutParams);
        this.x.requestLayout();
      }
    }
    while (this.u == null) {
      return;
    }
    ViewGroup.LayoutParams localLayoutParams = this.u.getLayoutParams();
    localLayoutParams.width = this.c.getResources().getDimensionPixelSize(2131362114);
    this.u.setLayoutParams(localLayoutParams);
    this.x.requestLayout();
  }
  
  protected void b()
  {
    this.f = ((EditText)findViewById(2131625484));
    this.g = findViewById(2131625483);
    this.g.setOnClickListener(this);
    this.h = ((ImageButton)findViewById(2131625485));
    this.h.setOnClickListener(this);
    this.u = ((ListView)findViewById(2131625480));
    this.u.setOverScrollMode(2);
    this.i = ((SoftInputPhoneKey)findViewById(2131625486));
    this.j = ((SoftInputPhoneKey)findViewById(2131625487));
    this.k = ((SoftInputPhoneKey)findViewById(2131625488));
    this.l = ((SoftInputPhoneKey)findViewById(2131625489));
    this.m = ((SoftInputPhoneKey)findViewById(2131625490));
    this.n = ((SoftInputPhoneKey)findViewById(2131625491));
    this.o = ((SoftInputPhoneKey)findViewById(2131625492));
    this.p = ((SoftInputPhoneKey)findViewById(2131625493));
    this.q = ((SoftInputPhoneKey)findViewById(2131625494));
    this.r = ((SoftInputPhoneKey)findViewById(2131625495));
    this.s = ((SoftInputPhoneKey)findViewById(2131625496));
    this.t = ((SoftInputPhoneKey)findViewById(2131625497));
    a locala = new a(null);
    this.i.setSoftInputKeyListener(locala);
    this.j.setSoftInputKeyListener(locala);
    this.k.setSoftInputKeyListener(locala);
    this.l.setSoftInputKeyListener(locala);
    this.m.setSoftInputKeyListener(locala);
    this.n.setSoftInputKeyListener(locala);
    this.o.setSoftInputKeyListener(locala);
    this.p.setSoftInputKeyListener(locala);
    this.q.setSoftInputKeyListener(locala);
    this.r.setSoftInputKeyListener(locala);
    this.s.setSoftInputKeyListener(locala);
    this.t.setSoftInputKeyListener(locala);
    this.g.setOnLongClickListener(new View.OnLongClickListener()
    {
      public boolean onLongClick(View paramAnonymousView)
      {
        s.a(s.this);
        return true;
      }
    });
    setOnDialogCancelListener(new com.baidu.carlife.core.screen.d()
    {
      public void onCancel()
      {
        s.b(s.this).setText("");
      }
    });
    setCanceledOnTouchOutside(true);
  }
  
  public void d()
  {
    super.d();
    k();
    this.B = null;
    this.A = null;
  }
  
  public void f()
  {
    if (this.A == null)
    {
      this.A = new g(findViewById(2131625481), 10);
      this.A.d(this.g).d(this.i.getFocusView()).d(this.j.getFocusView()).d(this.k.getFocusView()).d(this.l.getFocusView()).d(this.m.getFocusView()).d(this.n.getFocusView()).d(this.o.getFocusView()).d(this.p.getFocusView()).d(this.q.getFocusView()).d(this.r.getFocusView()).d(this.s.getFocusView()).d(this.t.getFocusView()).d(this.h);
      this.A.b(this.i.getFocusView());
    }
    if (this.B == null) {
      this.B = new c(this.u, 8);
    }
    this.B.a(this.z);
    this.A.a(this.z);
    this.B.a(true);
    this.A.a(true);
    com.baidu.carlife.f.d.a().a(new a[] { this.B, this.A });
    com.baidu.carlife.f.d.a().h(this.A);
  }
  
  public String getInputString()
  {
    return this.f.getText().toString();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      j();
      return;
      if (this.e)
      {
        this.w.a(getContext());
        d();
        return;
      }
    } while (TextUtils.isEmpty(this.f.getText().toString()));
    this.w.a(getContext(), this.f.getText().toString());
    d();
  }
  
  private class a
    extends com.baidu.carlife.view.e
  {
    private a() {}
    
    public void b(String paramString)
    {
      if (s.h(s.this))
      {
        s.c(s.this).a(paramString.charAt(0));
        return;
      }
      s.b(s.this).append(paramString);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/view/dialog/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */