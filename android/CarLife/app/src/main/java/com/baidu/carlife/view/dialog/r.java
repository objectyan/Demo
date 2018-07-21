package com.baidu.carlife.view.dialog;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.carlife.core.k;
import com.baidu.carlife.core.screen.e;
import com.baidu.carlife.f.a;
import com.baidu.carlife.f.d;
import com.baidu.carlife.f.g;

public class r
  extends BaseDialog
  implements View.OnClickListener
{
  private static final int e = 0;
  private static final int f = 1;
  private static final String g = "abc";
  private static final String h = "123";
  private String[] i;
  private String[] j;
  private EditText k;
  private HorizontalScrollView l;
  private LinearLayout m;
  private Button n;
  private ImageButton o;
  private ImageButton p;
  private int q = 0;
  private TextView r;
  private int s;
  private int t;
  private View.OnFocusChangeListener u = new View.OnFocusChangeListener()
  {
    public void onFocusChange(final View paramAnonymousView, boolean paramAnonymousBoolean)
    {
      if ((paramAnonymousView instanceof Button))
      {
        paramAnonymousView = (Button)paramAnonymousView;
        if (!paramAnonymousBoolean) {
          break label124;
        }
        paramAnonymousView.setTextSize(30.0F);
        r.a(r.this, paramAnonymousView, r.a(r.this));
        if ((r.b(r.this)[(r.b(r.this).length - 1)].equals(paramAnonymousView.getText().toString())) || (r.c(r.this)[(r.c(r.this).length - 1)].equals(paramAnonymousView.getText().toString()))) {
          new Handler().post(new Runnable()
          {
            public void run()
            {
              r.d(r.this).scrollTo(paramAnonymousView.getRight(), 0);
            }
          });
        }
      }
      return;
      label124:
      paramAnonymousView.setTextSize(20.0F);
      r.a(r.this, paramAnonymousView, r.e(r.this));
    }
  };
  private View.OnKeyListener v = new View.OnKeyListener()
  {
    public boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
    {
      if ((paramAnonymousKeyEvent != null) && (paramAnonymousKeyEvent.getAction() == 0)) {}
      switch (paramAnonymousInt)
      {
      default: 
        return false;
      case 20: 
        r.this.d();
        return true;
      case 67: 
        r.f(r.this);
        return true;
      }
      r.g(r.this).setText("");
      return true;
    }
  };
  
  public r(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public r(Context paramContext, EditText paramEditText)
  {
    super(paramContext, null, 2131427383);
    this.k = paramEditText;
    this.s = this.c.getResources().getDimensionPixelSize(2131362116);
    this.t = this.c.getResources().getDimensionPixelSize(2131362117);
  }
  
  private void a(int paramInt)
  {
    if (paramInt == 0)
    {
      this.n.setText("123");
      this.n.requestFocus();
      a(this.i);
      return;
    }
    this.n.setText("abc");
    this.n.requestFocus();
    a(this.j);
  }
  
  private void a(String[] paramArrayOfString)
  {
    this.m.removeAllViews();
    int i1 = 0;
    while (i1 < paramArrayOfString.length)
    {
      Button localButton = (Button)View.inflate(this.c, 2130969019, null);
      setKeyWidth(localButton, this.t);
      localButton.setText(paramArrayOfString[i1]);
      localButton.setOnClickListener(this);
      localButton.setOnFocusChangeListener(this.u);
      this.m.addView(localButton);
      i1 += 1;
    }
  }
  
  private void b(String paramString)
  {
    if (this.k == null) {
      return;
    }
    int i1 = this.k.getSelectionStart();
    Editable localEditable = this.k.getEditableText();
    if (i1 >= 0) {}
    try
    {
      if (i1 >= localEditable.length())
      {
        localEditable.append(paramString);
        return;
      }
      localEditable.insert(i1, paramString);
      return;
    }
    catch (Exception paramString) {}
  }
  
  private void l()
  {
    Editable localEditable = this.k.getText();
    int i1 = this.k.getSelectionStart();
    if ((localEditable != null) && (localEditable.length() > 0) && (i1 > 0)) {
      localEditable.delete(i1 - 1, i1);
    }
  }
  
  private void setKeyWidth(View paramView, int paramInt)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    if (localLayoutParams != null)
    {
      localLayoutParams.width = paramInt;
      return;
    }
    localLayoutParams = new LinearLayout.LayoutParams(paramInt, this.s);
    localLayoutParams.gravity = 17;
    paramView.setLayoutParams(localLayoutParams);
  }
  
  protected View a()
  {
    View localView = LayoutInflater.from(this.c).inflate(2130968885, null);
    localView.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        r.this.d();
      }
    });
    return localView;
  }
  
  public void a(e parame)
  {
    a(this.q);
    super.a(parame);
  }
  
  protected void b()
  {
    this.i = new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };
    this.j = this.c.getResources().getStringArray(2131230757);
    this.l = ((HorizontalScrollView)findViewById(2131625477));
    this.m = ((LinearLayout)findViewById(2131625478));
    this.p = ((ImageButton)findViewById(2131625476));
    this.p.setOnClickListener(this);
    this.o = ((ImageButton)findViewById(2131625475));
    this.o.setOnClickListener(this);
    this.n = ((Button)findViewById(2131625474));
    this.n.setOnClickListener(this);
    this.r = ((TextView)findViewById(2131625464));
    this.n.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        paramAnonymousView = (Button)paramAnonymousView;
        if (paramAnonymousBoolean)
        {
          paramAnonymousView.setTextSize(22.0F);
          return;
        }
        paramAnonymousView.setTextSize(18.0F);
      }
    });
    findViewById(2131625479).setOnClickListener(this);
    a(this.q);
    setCanceledOnTouchOutside(true);
  }
  
  public void f()
  {
    g localg = new g(findViewById(2131623980), 11, true);
    localg.d(this.n).d(this.o).d(this.p);
    int i2 = this.m.getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      localg.d(this.m.getChildAt(i1));
      i1 += 1;
    }
    localg.b(this.n);
    localg.a(this.v);
    localg.a(true);
    d.a().a(new a[] { localg });
  }
  
  public int getCustomHeight()
  {
    return this.c.getResources().getDimensionPixelSize(2131362118);
  }
  
  public void i()
  {
    if (this.r.getVisibility() == 0)
    {
      k.a(5151);
      k.a(5151, 50, 100);
    }
  }
  
  public void j()
  {
    if (this.r != null)
    {
      this.n.setEnabled(false);
      this.r.setVisibility(0);
      setClickable(false);
    }
  }
  
  public void k()
  {
    if (this.r != null)
    {
      this.r.setVisibility(8);
      this.n.setEnabled(true);
      setClickable(true);
    }
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 == 2131625474) {
      if (this.q == 0)
      {
        i1 = 1;
        this.q = i1;
        a(this.q);
        f();
      }
    }
    do
    {
      do
      {
        return;
        i1 = 0;
        break;
        if (i1 == 2131625479)
        {
          d();
          return;
        }
      } while (this.k == null);
      if (i1 == 2131625476)
      {
        b(" ");
        return;
      }
      if (i1 == 2131625475)
      {
        l();
        return;
      }
    } while (!(paramView instanceof Button));
    b(((Button)paramView).getText().toString());
  }
  
  public void setEditText(EditText paramEditText)
  {
    this.k = paramEditText;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/view/dialog/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */