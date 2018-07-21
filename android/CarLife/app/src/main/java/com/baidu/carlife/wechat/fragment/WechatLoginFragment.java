package com.baidu.carlife.wechat.fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.carlife.view.g;
import com.baidu.carlife.wechat.b.k;
import com.baidu.carlife.wechat.e.b.c;
import com.baidu.carlife.wechat.e.b.e;
import com.baidu.carlife.wechat.e.b.h;
import com.baidu.carlife.wechat.e.b.i;
import com.baidu.carlife.wechat.f.d;
import com.baidu.navi.util.StatisticManager;

public class WechatLoginFragment
  extends a
  implements View.OnClickListener
{
  private ImageView b;
  private TextView c;
  private ImageView d;
  private TextView e;
  private TextView f;
  private ImageButton g;
  private boolean h = true;
  private int i = 0;
  private int j = 0;
  private int k = 0;
  private int l = 0;
  
  private void a(View paramView)
  {
    this.g = ((ImageButton)paramView.findViewById(2131625220));
    this.g.setBackground(com.baidu.carlife.view.a.b.a(getActivity()));
    this.g.setOnClickListener(this);
    this.b = ((ImageView)paramView.findViewById(2131625223));
    this.d = ((ImageView)paramView.findViewById(2131625224));
    this.d.setOnClickListener(this);
    this.c = ((TextView)paramView.findViewById(2131625225));
    this.e = ((TextView)paramView.findViewById(2131625221));
    this.f = ((TextView)paramView.findViewById(2131625222));
  }
  
  private void a(final String paramString)
  {
    com.baidu.carlife.wechat.a.b.c.c("check login...  retry_times=" + this.j);
    com.baidu.carlife.wechat.e.b.a(paramString, new b.c()
    {
      public void a()
      {
        WechatLoginFragment.h(WechatLoginFragment.this);
        if (WechatLoginFragment.i(WechatLoginFragment.this) <= 3)
        {
          WechatLoginFragment.a(WechatLoginFragment.this, paramString);
          return;
        }
        WechatLoginFragment.c(WechatLoginFragment.this, 0);
        WechatLoginFragment.j(WechatLoginFragment.this);
      }
      
      public void a(String paramAnonymousString)
      {
        WechatLoginFragment.b(WechatLoginFragment.this, 0);
        WechatLoginFragment.c(WechatLoginFragment.this, paramAnonymousString);
      }
      
      public void b()
      {
        WechatLoginFragment.j(WechatLoginFragment.this);
      }
      
      public void b(String paramAnonymousString)
      {
        WechatLoginFragment.d(WechatLoginFragment.this).setText("扫描成功，请在手机上点击登录");
        WechatLoginFragment.f(WechatLoginFragment.this).setText("返回二维码登录");
        WechatLoginFragment.g(WechatLoginFragment.this).setVisibility(8);
        WechatLoginFragment.e(WechatLoginFragment.this).setVisibility(8);
        if (!TextUtils.isEmpty(paramAnonymousString))
        {
          paramAnonymousString = com.baidu.carlife.wechat.g.a.a(paramAnonymousString.substring("data:img/jpg;base64,".length()));
          WechatLoginFragment.a(WechatLoginFragment.this).setImageBitmap(paramAnonymousString);
          return;
        }
        WechatLoginFragment.a(WechatLoginFragment.this).setImageBitmap(null);
      }
      
      public void c()
      {
        WechatLoginFragment.a(WechatLoginFragment.this, paramString);
      }
      
      public void d()
      {
        com.baidu.carlife.wechat.a.b.c.e("login check canceled，登录态轮询检测停止。。。。。。。。。。。。");
      }
    });
  }
  
  private void b()
  {
    com.baidu.carlife.wechat.e.b.a(true);
    e();
    this.i = 0;
    c();
  }
  
  private void b(final String paramString)
  {
    this.k += 1;
    com.baidu.carlife.wechat.a.b.c.c("redirect uri... times = " + this.k);
    d("正在加载数据...");
    com.baidu.carlife.wechat.e.b.a(paramString, new b.e()
    {
      public void a()
      {
        WechatLoginFragment.d(WechatLoginFragment.this, 0);
        WechatLoginFragment.k(WechatLoginFragment.this);
      }
      
      public void b()
      {
        if (WechatLoginFragment.l(WechatLoginFragment.this) <= 3)
        {
          WechatLoginFragment.c(WechatLoginFragment.this, paramString);
          return;
        }
        WechatLoginFragment.b(WechatLoginFragment.this, 0);
        d.a("用户数据加载失败");
        WechatLoginFragment.b(WechatLoginFragment.this, "用户数据加载失败");
        WechatLoginFragment.j(WechatLoginFragment.this);
      }
    });
  }
  
  private void c()
  {
    this.i += 1;
    com.baidu.carlife.wechat.a.b.c.c("load UUID... times=" + this.i);
    com.baidu.carlife.wechat.b.c.a().b();
    k.a().e();
    this.b.setImageBitmap(null);
    this.c.setText(2131298869);
    this.d.setVisibility(8);
    this.e.setText("微信");
    this.f.setText(com.baidu.carlife.core.b.a.d());
    com.baidu.carlife.wechat.e.b.a(new b.h()
    {
      public void a(String paramAnonymousString)
      {
        WechatLoginFragment.a(WechatLoginFragment.this, 0);
        WechatLoginFragment.a(WechatLoginFragment.this, paramAnonymousString);
        float f = com.baidu.carlife.wechat.g.c.c();
        paramAnonymousString = com.baidu.carlife.wechat.g.c.a(com.baidu.carlife.wechat.e.c.b(paramAnonymousString), (int)(116.0F * f), (int)(116.0F * f));
        WechatLoginFragment.a(WechatLoginFragment.this).setImageBitmap(com.baidu.carlife.wechat.g.c.a(paramAnonymousString, 0.8F));
      }
      
      public void b(String paramAnonymousString)
      {
        if (WechatLoginFragment.b(WechatLoginFragment.this) < 3)
        {
          WechatLoginFragment.c(WechatLoginFragment.this);
          return;
        }
        WechatLoginFragment.b(WechatLoginFragment.this, "获取二维码失败");
        WechatLoginFragment.d(WechatLoginFragment.this).setText("获取失败，请刷新或检查网络后重试");
        WechatLoginFragment.e(WechatLoginFragment.this).setVisibility(0);
        WechatLoginFragment.f(WechatLoginFragment.this).setText("微信");
        WechatLoginFragment.g(WechatLoginFragment.this).setText(com.baidu.carlife.core.b.a.d());
      }
    });
  }
  
  private void c(String paramString)
  {
    Toast.makeText(getActivity(), paramString, 0).show();
  }
  
  private void d()
  {
    this.l += 1;
    com.baidu.carlife.wechat.a.b.c.c("web wx init... webwxInitTimes=" + this.l);
    com.baidu.carlife.wechat.e.b.a(new b.i()
    {
      public void a()
      {
        StatisticManager.onEvent("HOME_CARLIFE_004");
        WechatLoginFragment.m(WechatLoginFragment.this);
        WechatLoginFragment.this.showFragment(584, null);
        WechatLoginFragment.this.removeWeChatFragmentFromStack();
      }
      
      public void a(String paramAnonymousString)
      {
        if (WechatLoginFragment.n(WechatLoginFragment.this) < 3)
        {
          WechatLoginFragment.k(WechatLoginFragment.this);
          return;
        }
        WechatLoginFragment.d(WechatLoginFragment.this, 0);
        d.a("数据加载失败");
        WechatLoginFragment.b(WechatLoginFragment.this, "数据加载失败，请重新登录");
        WechatLoginFragment.j(WechatLoginFragment.this);
      }
    });
  }
  
  private void d(String paramString)
  {
    g.e().a(paramString);
  }
  
  private void e()
  {
    g.e().f();
  }
  
  public void a()
  {
    if (!com.baidu.carlife.wechat.a.a.b.a(com.baidu.carlife.core.a.a()))
    {
      Toast.makeText(getActivity(), "网络连接异常，请检查您的网络连接", 0).show();
      d.a("网络连接异常");
      return;
    }
    b();
  }
  
  public boolean onBackPressed()
  {
    removeWeChatFragmentFromStack();
    back();
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131625220) {
      if (this.e.getText().toString().equals("微信"))
      {
        removeWeChatFragmentFromStack();
        back();
      }
    }
    while (paramView.getId() != 2131625224)
    {
      return;
      b();
      return;
    }
    a();
  }
  
  protected View onCreateContentView(LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130968824, null);
    paramLayoutInflater.setOnClickListener(null);
    a(paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  protected void onInitView() {}
  
  public void onResume()
  {
    super.onResume();
    if (this.h)
    {
      b();
      if (this.h) {
        break label30;
      }
    }
    label30:
    for (boolean bool = true;; bool = false)
    {
      this.h = bool;
      return;
    }
  }
  
  protected void onUpdateOrientation(int paramInt) {}
  
  protected void onUpdateStyle(boolean paramBoolean) {}
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/wechat/fragment/WechatLoginFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */