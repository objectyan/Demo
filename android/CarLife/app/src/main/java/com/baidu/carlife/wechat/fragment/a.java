package com.baidu.carlife.wechat.fragment;

import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.baidu.carlife.core.j;
import com.baidu.carlife.core.k;
import com.baidu.carlife.wechat.b.c;
import com.baidu.carlife.wechat.b.c.b;
import com.baidu.carlife.wechat.e.b;
import com.baidu.carlife.wechat.e.b.d;
import com.baidu.navi.fragment.ContentFragment;

abstract class a
  extends ContentFragment
{
  a a;
  
  private void a()
  {
    b.a(new b.d()
    {
      public void a()
      {
        c.a().a(c.b.c);
      }
      
      public void b()
      {
        c.a().a(c.b.c);
      }
    });
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void onResume()
  {
    super.onResume();
    this.a = new a(Looper.getMainLooper());
    k.a(this.a);
  }
  
  public void onStop()
  {
    k.b(this.a);
    super.onStop();
  }
  
  private class a
    extends j
  {
    public a(Looper paramLooper)
    {
      super();
    }
    
    public void careAbout()
    {
      addMsg(1002);
    }
    
    public void handleMessage(Message paramMessage)
    {
      super.handleMessage(paramMessage);
      switch (paramMessage.what)
      {
      default: 
        return;
      }
      a.a(a.this);
      a.this.showFragment(545, null);
      a.this.removeWeChatFragmentFromStack();
      com.baidu.carlife.wechat.a.a();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/wechat/fragment/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */