package com.baidu.carlife.adpter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.carlife.BaiduNaviApplication;
import com.baidu.carlife.model.m;
import com.baidu.carlife.util.r;
import java.util.List;

public class a
  extends BaseAdapter
{
  private LayoutInflater a;
  private List<m> b = null;
  private String c;
  
  public a(Context paramContext)
  {
    this.a = LayoutInflater.from(paramContext);
    this.c = BaiduNaviApplication.getInstance().getApplicationContext().getString(2131297655);
  }
  
  public m a(int paramInt)
  {
    if (this.b == null) {
      return null;
    }
    return (m)this.b.get(paramInt);
  }
  
  public void a(List<m> paramList)
  {
    this.b = paramList;
  }
  
  public int getCount()
  {
    if (this.b == null) {
      return 0;
    }
    return this.b.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      localView = this.a.inflate(2130968600, paramViewGroup, false);
      paramViewGroup = new a(null);
      paramViewGroup.a = ((TextView)localView.findViewById(2131624063));
      paramViewGroup.b = ((TextView)localView.findViewById(2131624064));
      paramViewGroup.c = localView.findViewById(2131624065);
      paramViewGroup.d = ((TextView)localView.findViewById(2131624066));
      paramViewGroup.e = localView.findViewById(2131624067);
      localView.setTag(paramViewGroup);
    }
    m localm;
    for (;;)
    {
      localm = a(paramInt);
      if (localm != null) {
        break;
      }
      return null;
      paramViewGroup = (a)paramView.getTag();
      localView = paramView;
    }
    if (paramInt == getCount() - 1)
    {
      paramViewGroup.e.setVisibility(8);
      paramInt = localm.d;
      if (paramInt != 2) {
        break label302;
      }
      paramViewGroup.c.setVisibility(0);
      label162:
      if (paramInt != 3) {
        break label314;
      }
      paramViewGroup.a.setTextColor(r.a(2131558641));
      paramViewGroup.b.setTextColor(r.a(2131558641));
      label191:
      paramView = this.c;
      if (TextUtils.isEmpty(localm.a)) {
        break label341;
      }
      paramView = localm.a;
      label213:
      paramViewGroup.a.setText(paramView);
      if (localm.c <= 1) {
        break label361;
      }
      paramViewGroup.b.setText("(" + localm.c + ")");
    }
    for (;;)
    {
      if (TextUtils.isEmpty(localm.f)) {
        break label373;
      }
      paramViewGroup.d.setText(localm.f);
      return localView;
      paramViewGroup.e.setVisibility(0);
      break;
      label302:
      paramViewGroup.c.setVisibility(8);
      break label162;
      label314:
      paramViewGroup.a.setTextColor(r.a(2131558702));
      paramViewGroup.b.setTextColor(r.a(2131558702));
      break label191;
      label341:
      if (TextUtils.isEmpty(localm.b)) {
        break label213;
      }
      paramView = localm.b;
      break label213;
      label361:
      paramViewGroup.b.setText("");
    }
    label373:
    paramViewGroup.d.setText("");
    return localView;
  }
  
  private static class a
  {
    TextView a;
    TextView b;
    View c;
    TextView d;
    View e;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/adpter/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */