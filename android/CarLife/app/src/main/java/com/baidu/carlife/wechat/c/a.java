package com.baidu.carlife.wechat.c;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.Html;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.carlife.core.screen.presentation.h;
import com.baidu.carlife.wechat.b.c.b;
import com.baidu.carlife.wechat.b.d.a;
import com.baidu.carlife.wechat.b.e;
import com.baidu.carlife.wechat.b.f;
import com.baidu.carlife.wechat.b.k;
import com.baidu.carlife.wechat.e.b.a;
import com.baidu.carlife.wechat.e.b.b;
import com.baidu.carlife.wechat.e.b.f;
import com.baidu.carlife.wechat.e.b.g;
import com.baidu.carlife.wechat.e.b.j;
import com.baidu.navi.util.StatisticManager;
import java.util.ArrayList;
import java.util.List;

public class a
{
  private int a = 0;
  private boolean b = false;
  private a c;
  private com.baidu.carlife.wechat.b.d d = null;
  
  public static a a()
  {
    return b.a();
  }
  
  private void a(String paramString1, String paramString2, d.a parama)
  {
    com.baidu.carlife.view.g.e().a(paramString1, paramString2, parama);
  }
  
  private void b(int paramInt)
  {
    List localList = com.baidu.carlife.wechat.b.c.a().i();
    int i = localList.size();
    if ((paramInt < 0) || (paramInt >= i))
    {
      c();
      if (this.c != null) {
        this.c.a();
      }
      return;
    }
    b.a local5 = new b.a()
    {
      public void a(int paramAnonymousInt)
      {
        a.b(a.this, paramAnonymousInt);
      }
      
      public void a(int paramAnonymousInt, List<com.baidu.carlife.wechat.b.b> paramAnonymousList)
      {
        if (paramAnonymousList != null)
        {
          List localList = com.baidu.carlife.wechat.b.c.a().i();
          int i = 0;
          int k = paramAnonymousList.size();
          while (i < k)
          {
            int j = 0;
            int m = localList.size();
            while (j < m)
            {
              if (TextUtils.equals(((com.baidu.carlife.wechat.b.b)localList.get(j)).a(), ((com.baidu.carlife.wechat.b.b)paramAnonymousList.get(i)).a())) {
                localList.set(j, paramAnonymousList.get(i));
              }
              j += 1;
            }
            i += 1;
          }
        }
        a.b(a.this, paramAnonymousInt);
      }
    };
    com.baidu.carlife.wechat.e.b.a(localList.subList(paramInt, Math.min(i, paramInt + 50)), paramInt, local5);
  }
  
  private void g()
  {
    com.baidu.carlife.wechat.a.b.c.c("");
    if (com.baidu.carlife.wechat.b.c.a().d() != c.b.b)
    {
      com.baidu.carlife.wechat.a.b.c.e("账号未登录，心跳请求停止。。。。。。。。。。。。");
      return;
    }
    if (!com.baidu.carlife.wechat.a.a.b.a(com.baidu.carlife.core.a.a()))
    {
      Toast.makeText(com.baidu.carlife.core.a.a(), "网络连接异常，请检查您的网络连接", 0).show();
      com.baidu.carlife.wechat.a.b.c.e("网络连接异常，10s后重试!!!!!!!!!!!!!");
      new Handler(Looper.getMainLooper()).postDelayed(new Runnable()
      {
        public void run()
        {
          a.this.b();
        }
      }, 10000L);
      return;
    }
    com.baidu.carlife.wechat.e.b.a(new b.g()
    {
      public void a()
      {
        a.a(a.this);
      }
      
      public void b()
      {
        a.this.b();
      }
      
      public void c()
      {
        a.this.b();
      }
      
      public void d()
      {
        com.baidu.carlife.wechat.a.b.c.e("sync check canceled，心跳请求停止。。。。。。。。。。。。");
      }
      
      public void e()
      {
        if (com.baidu.carlife.wechat.b.c.a().d() == c.b.b)
        {
          h.a().showFragment(585, null);
          h.a().removeWeChatFragmentFromStack();
        }
      }
    });
  }
  
  private void h()
  {
    com.baidu.carlife.wechat.e.b.a(new b.j()
    {
      public void a()
      {
        a.this.b();
      }
      
      public void a(int paramAnonymousInt)
      {
        a.this.b();
      }
    });
  }
  
  private void i()
  {
    com.baidu.carlife.view.g.e().a("微信消息发送中...");
  }
  
  public void a(int paramInt)
  {
    com.baidu.carlife.wechat.a.b.c.c("start = " + paramInt);
    List localList = k.a().b();
    int i = localList.size();
    if ((paramInt < 0) || (paramInt >= i)) {
      com.baidu.carlife.wechat.a.b.c.c("session is already loaded.");
    }
    b.a local6;
    ArrayList localArrayList;
    do
    {
      return;
      local6 = new b.a()
      {
        public void a(int paramAnonymousInt)
        {
          a.this.a(paramAnonymousInt);
        }
        
        public void a(int paramAnonymousInt, List<com.baidu.carlife.wechat.b.b> paramAnonymousList)
        {
          if ((paramAnonymousList != null) && (paramAnonymousList.size() > 0))
          {
            ArrayList localArrayList = new ArrayList();
            int i = 0;
            int j = paramAnonymousList.size();
            if (i < j)
            {
              com.baidu.carlife.wechat.b.b localb = (com.baidu.carlife.wechat.b.b)paramAnonymousList.get(i);
              if ((localb.j()) || ((localb.k()) && (!localb.m()))) {}
              for (;;)
              {
                i += 1;
                break;
                localArrayList.add(new com.baidu.carlife.wechat.b.a(localb, 0 - i));
              }
            }
            k.a().a(localArrayList);
          }
          a.this.a(paramAnonymousInt);
        }
      };
      localArrayList = new ArrayList();
      int j = Math.min(i, paramInt + 50);
      i = paramInt;
      while (i < j)
      {
        com.baidu.carlife.wechat.b.b localb = new com.baidu.carlife.wechat.b.b();
        localb.a((String)localList.get(i));
        localArrayList.add(localb);
        i += 1;
      }
    } while (localArrayList.size() == 0);
    com.baidu.carlife.wechat.e.b.a(localArrayList, paramInt, local6);
  }
  
  public void a(final com.baidu.carlife.wechat.b.b paramb, final String paramString)
  {
    com.baidu.carlife.wechat.a.b.c.c("send msg >>>  " + paramb.b() + " : " + paramString);
    k.a().a(true);
    i();
    b.f local7 = new b.f()
    {
      public void a()
      {
        k.a().a(false);
        k.a().b(new com.baidu.carlife.wechat.b.d(paramb, paramString));
        com.baidu.carlife.wechat.f.d.a("发送成功");
        a.this.e();
        com.baidu.carlife.wechat.f.b.d().f();
        new Handler().postDelayed(new Runnable()
        {
          public void run()
          {
            k.a().f();
          }
        }, 1000L);
      }
      
      public void a(String paramAnonymousString)
      {
        com.baidu.carlife.wechat.a.b.c.e("消息发送失败，reason=" + paramAnonymousString);
        k.a().a(false);
        com.baidu.carlife.wechat.f.d.a("发送失败");
        com.baidu.carlife.wechat.f.b.d().f();
        a.this.e();
        new Handler().postDelayed(new Runnable()
        {
          public void run()
          {
            k.a().f();
          }
        }, 1000L);
      }
      
      public void b()
      {
        k.a().a(false);
        a.this.e();
        com.baidu.carlife.wechat.f.d.a("登录态失效");
        Toast.makeText(com.baidu.carlife.core.a.a(), "登录态失效，请重新登录", 0).show();
        h.a().showFragment(585, null);
        h.a().removeWeChatFragmentFromStack();
      }
    };
    com.baidu.carlife.wechat.e.b.a(paramb.a(), paramString + "【以上文字由语音转换】", local7);
    StatisticManager.onEvent("HOME_CARLIFE_005");
  }
  
  public void a(com.baidu.carlife.wechat.b.d paramd)
  {
    if (paramd == null)
    {
      com.baidu.carlife.wechat.f.b.d().c();
      return;
    }
    if ((!com.baidu.carlife.core.b.a.a()) && (!com.baidu.carlife.wechat.a.b.a.b(com.baidu.carlife.core.a.a())))
    {
      this.d = paramd;
      paramd = new Intent("com.baidu.carlife.Action.WECHAT");
      com.baidu.carlife.core.a.a().sendBroadcast(paramd);
      return;
    }
    this.d = null;
    com.baidu.carlife.wechat.b.b localb = paramd.g();
    String str2 = "";
    String str3 = localb.b();
    String str1 = str2;
    if (localb.k())
    {
      com.baidu.carlife.wechat.b.g localg = localb.d(paramd.m());
      str1 = str2;
      if (localg != null) {
        str1 = localg.c();
      }
    }
    if (paramd.i() != null)
    {
      str2 = paramd.i().a();
      if (localb.k()) {
        str1 = "【群消息】" + str1 + " 分享的地址";
      }
    }
    for (;;)
    {
      a(str2, str1, paramd.p());
      return;
      str1 = str3 + "分享的地址";
      continue;
      if (paramd.h() == null) {
        break;
      }
      str2 = Html.fromHtml(paramd.h().a()) + "—" + Html.fromHtml(paramd.h().b());
      if (localb.k()) {
        str1 = "【群消息】" + str1 + " 分享的音乐";
      } else {
        str1 = str3 + "分享的音乐";
      }
    }
    if (localb.k()) {}
    for (str2 = "群消息：" + str3;; str2 = str3 + "的微信消息")
    {
      str1 = "收到1条消息";
      break;
    }
  }
  
  public void a(a parama)
  {
    this.c = parama;
  }
  
  public void a(final String paramString)
  {
    if (this.b) {
      com.baidu.carlife.wechat.a.b.c.c("contacts is loading...");
    }
    do
    {
      do
      {
        return;
        this.a += 1;
        com.baidu.carlife.wechat.a.b.c.c("load contacts...   load times =" + this.a);
        if (this.a <= 3) {
          break;
        }
        com.baidu.carlife.wechat.a.b.c.c("load contacts failed , load times = " + this.a);
        c();
      } while (this.c == null);
      this.c.a();
      return;
      if ((!TextUtils.equals("0", paramString)) || (com.baidu.carlife.wechat.b.c.a().h().size() <= 0)) {
        break;
      }
      com.baidu.carlife.wechat.a.b.c.c("contacts is already loaded.");
      c();
    } while (this.c == null);
    this.c.a();
    return;
    this.b = true;
    com.baidu.carlife.wechat.e.b.a(paramString, new b.b()
    {
      public void a()
      {
        a.a(a.this, false);
        a.this.a(paramString);
      }
      
      public void a(String paramAnonymousString)
      {
        if (TextUtils.equals(paramAnonymousString, "0"))
        {
          a.a(a.this, 0);
          a.b(a.this, 0);
          return;
        }
        a.this.c();
        a.this.a(paramAnonymousString);
      }
    });
  }
  
  public void b()
  {
    com.baidu.carlife.wechat.a.b.c.c("");
    if (k.a().h()) {
      com.baidu.carlife.wechat.a.b.c.e("正在下载语音消息，不能取消全部网络任务");
    }
    for (;;)
    {
      g();
      return;
      com.baidu.carlife.wechat.e.b.a(false);
    }
  }
  
  public void c()
  {
    this.a = 0;
    this.b = false;
  }
  
  public boolean d()
  {
    return this.b;
  }
  
  public void e()
  {
    com.baidu.carlife.view.g.e().f();
  }
  
  public void f()
  {
    a(this.d);
  }
  
  public static abstract interface a
  {
    public abstract void a();
  }
  
  private static class b
  {
    private static final a a = new a(null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/wechat/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */