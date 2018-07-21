package com.baidu.carlife.wechat.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.carlife.util.r;
import com.baidu.carlife.wechat.b.k;
import com.baidu.carlife.wechat.g.c;
import java.util.ArrayList;
import java.util.List;

public class a
  extends BaseAdapter
{
  private Context a;
  private List<b> b;
  private float c;
  
  public a(Context paramContext)
  {
    this.a = paramContext;
    this.c = c.c();
    a();
  }
  
  private void a()
  {
    this.b = new ArrayList();
    this.b.add(b.a);
    this.b.add(b.b);
    this.b.add(b.c);
    this.b.add(b.d);
  }
  
  public b a(int paramInt)
  {
    return (b)this.b.get(paramInt);
  }
  
  public int getCount()
  {
    return this.b.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = LayoutInflater.from(this.a).inflate(2130968996, paramViewGroup, false);
    Object localObject = (TextView)paramView.findViewById(2131626004);
    paramViewGroup = (TextView)paramView.findViewById(2131626005);
    b localb = a(paramInt);
    ((TextView)localObject).setText(localb.a());
    paramView.setBackground(r.b(2130838563));
    ((TextView)localObject).setTextColor(r.a(2131558700));
    ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(0, localb.b(), 0, 0);
    if (localb == b.c)
    {
      if (com.baidu.carlife.wechat.g.b.a())
      {
        ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(0, 2130903109, 0, 0);
        ((TextView)localObject).setText("微信已静音");
      }
    }
    else
    {
      paramViewGroup.setVisibility(8);
      paramViewGroup.setText("");
      if (a(paramInt) == b.a)
      {
        paramInt = k.a().d();
        if (paramInt > 0)
        {
          localObject = (RelativeLayout.LayoutParams)paramViewGroup.getLayoutParams();
          if (paramInt >= 10) {
            break label223;
          }
        }
      }
    }
    label223:
    for (((RelativeLayout.LayoutParams)localObject).width = ((int)(18.0F * this.c));; ((RelativeLayout.LayoutParams)localObject).width = -2)
    {
      paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramViewGroup.setVisibility(0);
      if (paramInt <= 99) {
        break label233;
      }
      paramViewGroup.setText("...");
      return paramView;
      ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(0, 2130903108, 0, 0);
      ((TextView)localObject).setText("微信静音");
      break;
    }
    label233:
    paramViewGroup.setText(String.valueOf(paramInt));
    return paramView;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/wechat/d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */