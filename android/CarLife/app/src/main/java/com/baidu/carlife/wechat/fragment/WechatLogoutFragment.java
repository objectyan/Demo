package com.baidu.carlife.wechat.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.carlife.wechat.b.c.b;
import com.baidu.carlife.wechat.b.i;
import com.baidu.carlife.wechat.e.b.d;
import com.baidu.carlife.wechat.f.d;
import com.facebook.drawee.view.SimpleDraweeView;

public class WechatLogoutFragment
  extends a
{
  private ImageButton b;
  private TextView c;
  private SimpleDraweeView d;
  private Button e;
  private com.baidu.carlife.view.dialog.c f;
  
  private void a()
  {
    this.f = new com.baidu.carlife.view.dialog.c(getActivity());
    this.f.c("注销");
    this.f.b("确定要注销微信账号么？");
    this.f.g(17);
    this.f.d("确定");
    this.f.q();
    this.f.e("取消");
    this.f.a(new com.baidu.carlife.core.screen.b()
    {
      public void onClick()
      {
        WechatLogoutFragment.b(WechatLogoutFragment.this);
      }
    });
    showDialog(this.f);
  }
  
  private void a(View paramView)
  {
    this.b = ((ImageButton)paramView.findViewById(2131625250));
    this.b.setBackground(com.baidu.carlife.view.a.b.a(getActivity()));
    this.b.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        WechatLogoutFragment.this.back();
      }
    });
    this.c = ((TextView)paramView.findViewById(2131625251));
    this.c.setText(com.baidu.carlife.wechat.b.c.a().f().c());
    this.d = ((SimpleDraweeView)paramView.findViewById(2131625252));
    String str = com.baidu.carlife.wechat.e.c.i() + com.baidu.carlife.wechat.b.c.a().f().d();
    this.d.setImageURI(str);
    this.e = ((Button)paramView.findViewById(2131625253));
    this.e.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        WechatLogoutFragment.a(WechatLogoutFragment.this);
      }
    });
  }
  
  private void b()
  {
    Toast.makeText(getActivity(), "正在注销微信账号。。。", 0).show();
    com.baidu.carlife.wechat.e.b.a(new b.d()
    {
      public void a()
      {
        com.baidu.carlife.wechat.b.c.a().a(c.b.c);
        WechatLogoutFragment.this.showFragment(585, null);
        d.a("已退出微信");
      }
      
      public void b()
      {
        com.baidu.carlife.wechat.b.c.a().a(c.b.c);
        WechatLogoutFragment.this.showFragment(585, null);
        d.a("已退出微信");
      }
    });
  }
  
  protected View onCreateContentView(LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130968831, null);
    paramLayoutInflater.setOnClickListener(null);
    a(paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  protected void onInitView() {}
  
  protected void onUpdateOrientation(int paramInt) {}
  
  protected void onUpdateStyle(boolean paramBoolean) {}
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/wechat/fragment/WechatLogoutFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */