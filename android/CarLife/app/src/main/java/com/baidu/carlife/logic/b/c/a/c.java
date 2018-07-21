package com.baidu.carlife.logic.b.c.a;

import android.support.annotation.Nullable;
import android.view.View;
import android.view.View.OnClickListener;
import com.baidu.carlife.c.b.a;
import com.baidu.carlife.c.f;

public abstract class c
  extends com.baidu.carlife.c.e.a<com.baidu.carlife.logic.b.b.a>
{
  private void a(boolean paramBoolean)
  {
    View localView = b().a(2131624253);
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  protected void a(com.baidu.carlife.logic.b.b.a parama)
  {
    parama.c().a(new com.baidu.carlife.c.d.d()
    {
      public void a(@Nullable Boolean paramAnonymousBoolean)
      {
        c.a(c.this, paramAnonymousBoolean.booleanValue());
      }
    });
    b().a(2131625346, (String)parama.e().b());
    a(((Boolean)parama.c().b()).booleanValue());
    b().a().setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        f.a().a(c.this.f(), null, com.baidu.carlife.c.a.a.c());
      }
    });
  }
  
  protected abstract com.baidu.carlife.c.d<Void, Void> f();
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/logic/b/c/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */