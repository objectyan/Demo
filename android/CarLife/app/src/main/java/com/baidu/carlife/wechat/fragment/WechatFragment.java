package com.baidu.carlife.wechat.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;
import com.baidu.carlife.core.e;
import com.baidu.carlife.logic.voice.n;
import com.baidu.carlife.wechat.b.i;
import com.baidu.carlife.wechat.b.k;
import com.baidu.carlife.wechat.b.k.b;
import com.baidu.carlife.wechat.f.d;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.List;

public class WechatFragment
  extends a
  implements AdapterView.OnItemClickListener, k.b
{
  public static String b = WechatFragment.class.getSimpleName();
  private TextView c;
  private ImageButton d;
  private GridView e;
  private com.baidu.carlife.wechat.d.a f;
  private SimpleDraweeView g;
  private FrameLayout h;
  
  private void a(View paramView)
  {
    this.h = ((FrameLayout)paramView.findViewById(2131625247));
    this.h.setBackground(com.baidu.carlife.view.a.b.a(getActivity()));
    this.h.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        WechatFragment.this.showFragment(591, null);
      }
    });
    this.g = ((SimpleDraweeView)paramView.findViewById(2131625248));
    this.e = ((GridView)paramView.findViewById(2131625249));
    this.f = new com.baidu.carlife.wechat.d.a(getActivity());
    this.e.setAdapter(this.f);
    this.e.setOnItemClickListener(this);
    this.d = ((ImageButton)paramView.findViewById(2131625245));
    this.d.setBackground(com.baidu.carlife.view.a.b.a(getActivity()));
    this.d.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        WechatFragment.this.back();
      }
    });
    this.c = ((TextView)paramView.findViewById(2131625246));
    this.c.setText(com.baidu.carlife.core.b.a.d());
  }
  
  private void b()
  {
    if (com.baidu.carlife.wechat.b.c.a().h().size() > 0)
    {
      com.baidu.carlife.wechat.a.b.c.c("wechat contact loaded !");
      return;
    }
    com.baidu.carlife.wechat.c.a.a().c();
    com.baidu.carlife.wechat.c.a.a().a(null);
    com.baidu.carlife.wechat.c.a.a().a("0");
  }
  
  private void c()
  {
    String str = com.baidu.carlife.wechat.e.c.i() + com.baidu.carlife.wechat.b.c.a().f().d();
    this.g.setImageURI(str);
  }
  
  private void d()
  {
    if (e.a().o()) {
      return;
    }
    final com.baidu.carlife.view.dialog.c localc = new com.baidu.carlife.view.dialog.c(com.baidu.carlife.core.a.a());
    localc.c("提示").b("使用微信需开启“小度小度，语音唤醒”，是否确认开启？").d("开启").e("取消").a(new com.baidu.carlife.core.screen.b()
    {
      public void onClick()
      {
        e.a().a(true);
        n.a().a(true);
        n.a().g();
        WechatFragment.this.dismissDialog(localc);
      }
    }).b(new com.baidu.carlife.core.screen.b()
    {
      public void onClick()
      {
        WechatFragment.this.dismissDialog(localc);
      }
    });
    showDialog(localc);
  }
  
  public void a()
  {
    this.f.notifyDataSetChanged();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  protected View onCreateContentView(LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130968830, null);
    a(paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  protected void onInitView() {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    switch (5.a[this.f.a(paramInt).ordinal()])
    {
    default: 
      return;
    case 1: 
      showFragment(586, null);
      return;
    case 2: 
      showFragment(588, null);
      return;
    case 3: 
      if (!com.baidu.carlife.wechat.g.b.a()) {}
      for (boolean bool = true;; bool = false)
      {
        com.baidu.carlife.wechat.g.b.a(bool);
        this.f.notifyDataSetChanged();
        return;
      }
    }
    showFragment(589, null);
  }
  
  public void onPause()
  {
    super.onPause();
    k.a().b(this);
  }
  
  public void onResume()
  {
    super.onResume();
    if (!TextUtils.isEmpty(com.baidu.carlife.wechat.b.c.a().f().d())) {}
    for (boolean bool = true;; bool = false)
    {
      com.baidu.carlife.wechat.a.b.c.c("isLogin = " + bool + " ; firstOpenFlag = " + com.baidu.carlife.wechat.b.c.a().c());
      if (bool) {
        break;
      }
      showFragment(585, null);
      return;
    }
    if (com.baidu.carlife.wechat.b.c.a().c())
    {
      d.a("微信登录成功");
      com.baidu.carlife.wechat.c.a.a().b();
      com.baidu.carlife.wechat.c.a.a().a(0);
      b();
      com.baidu.carlife.wechat.b.c.a().a(false);
      d();
    }
    k.a().a(this);
    a();
    c();
  }
  
  protected void onUpdateOrientation(int paramInt) {}
  
  protected void onUpdateSkin()
  {
    super.onUpdateSkin();
  }
  
  protected void onUpdateStyle(boolean paramBoolean) {}
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/wechat/fragment/WechatFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */