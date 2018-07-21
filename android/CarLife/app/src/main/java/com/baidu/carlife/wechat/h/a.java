package com.baidu.carlife.wechat.h;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.carlife.wechat.b.b;
import com.facebook.drawee.view.SimpleDraweeView;

public class a
{
  private View a;
  private SimpleDraweeView b;
  private TextView c;
  private TextView d;
  private Button e;
  private Button f;
  private a g;
  
  public a(Context paramContext, ViewGroup paramViewGroup)
  {
    this.a = LayoutInflater.from(paramContext).inflate(2130968880, paramViewGroup, false);
    paramViewGroup = this.a.getLayoutParams();
    paramViewGroup.width = (com.baidu.carlife.wechat.g.c.a(paramContext) / 2);
    paramViewGroup.height = -2;
    e();
  }
  
  private void e()
  {
    this.b = ((SimpleDraweeView)this.a.findViewById(2131625467));
    this.c = ((TextView)this.a.findViewById(2131625468));
    this.d = ((TextView)this.a.findViewById(2131625469));
    this.e = ((Button)this.a.findViewById(2131625470));
    this.f = ((Button)this.a.findViewById(2131625471));
  }
  
  public View a()
  {
    this.a.setVisibility(8);
    return this.a;
  }
  
  public void a(b paramb, String paramString, a parama)
  {
    a(parama);
    this.a.setVisibility(0);
    this.b.setImageURI(com.baidu.carlife.wechat.e.c.i() + paramb.e());
    this.c.setText(Html.fromHtml(paramb.b()));
    this.d.setText(Html.fromHtml(paramString));
  }
  
  public void a(a parama)
  {
    this.g = parama;
    switch (1.a[parama.ordinal()])
    {
    default: 
      this.e.setText("确定");
      return;
    case 1: 
      this.e.setText("播报");
      return;
    case 2: 
      this.e.setText("回复");
      return;
    }
    this.e.setText("发起导航");
  }
  
  public Button b()
  {
    return this.f;
  }
  
  public Button c()
  {
    return this.e;
  }
  
  public a d()
  {
    return this.g;
  }
  
  public static enum a
  {
    private a() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/wechat/h/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */