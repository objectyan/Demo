package com.baidu.carlife.logic.b.c.a;

import android.support.annotation.Nullable;
import android.view.View;
import android.view.View.OnClickListener;
import com.baidu.carlife.c.b.a;
import com.baidu.carlife.c.d.c;
import com.baidu.carlife.c.f;
import com.baidu.carlife.view.SwitchButton;

public abstract class a
  extends com.baidu.carlife.c.e.a<com.baidu.carlife.logic.b.b.a>
{
  private void a(boolean paramBoolean)
  {
    ((SwitchButton)b().a(2131625241)).setChecked(paramBoolean);
  }
  
  public void a(com.baidu.carlife.logic.b.b.a parama)
  {
    b().a().setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = (SwitchButton)a.this.b().a(2131625241);
        f.a().a(a.this.f(), Boolean.valueOf(paramAnonymousView.isChecked()), com.baidu.carlife.c.a.a.c());
      }
    });
    b().a(2131625241).setClickable(false);
    a(((Boolean)parama.b().b()).booleanValue());
    b().a(2131624662, (String)parama.e().b());
    b().a(2131625842).setVisibility(8);
    parama.b().a(new com.baidu.carlife.c.d.d()
    {
      public void a(@Nullable Boolean paramAnonymousBoolean)
      {
        a.a(a.this, paramAnonymousBoolean.booleanValue());
      }
    });
  }
  
  protected abstract com.baidu.carlife.c.d<Boolean, Void> f();
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/logic/b/c/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */