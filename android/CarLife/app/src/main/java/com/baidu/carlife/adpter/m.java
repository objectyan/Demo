package com.baidu.carlife.adpter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.carlife.model.n;
import com.baidu.carlife.util.r;
import java.util.List;

public class m
  extends BaseAdapter
{
  private String a;
  private LayoutInflater b;
  private List<n> c;
  
  public m(Context paramContext)
  {
    this.b = LayoutInflater.from(paramContext);
    this.a = paramContext.getString(2131296838);
  }
  
  public n a(int paramInt)
  {
    if (this.c == null) {
      return null;
    }
    return (n)this.c.get(paramInt);
  }
  
  public void a(List<n> paramList)
  {
    this.c = paramList;
  }
  
  public int getCount()
  {
    if (this.c == null) {
      return 0;
    }
    return this.c.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = this.b.inflate(2130968985, paramViewGroup, false);
      paramView = new a(null);
      paramView.a = ((TextView)localView.findViewById(2131625971));
      paramView.b = ((TextView)localView.findViewById(2131625972));
      paramView.c = ((TextView)localView.findViewById(2131625973));
      paramView.d = localView.findViewById(2131624067);
      localView.setTag(paramView);
    }
    paramView = (a)localView.getTag();
    paramViewGroup = a(paramInt);
    if (paramViewGroup == null) {
      return localView;
    }
    if (paramInt == getCount() - 1)
    {
      paramView.d.setVisibility(8);
      if (!TextUtils.isEmpty(paramViewGroup.a)) {
        break label254;
      }
      paramView.a.setText(this.a);
      label151:
      paramView.b.setText(paramViewGroup.b);
      paramView.c.setText(paramViewGroup.e);
      if ((paramViewGroup.f) || (paramViewGroup.g)) {
        break label268;
      }
      paramView.a.setVisibility(0);
      paramView.b.setVisibility(8);
    }
    for (;;)
    {
      paramView.a.setTextColor(r.a(2131558702));
      paramView.b.setTextColor(r.a(2131558692));
      paramView.c.setTextColor(r.a(2131558692));
      return localView;
      paramView.d.setVisibility(0);
      break;
      label254:
      paramView.a.setText(paramViewGroup.a);
      break label151;
      label268:
      if ((!paramViewGroup.f) && (paramViewGroup.g))
      {
        paramView.a.setVisibility(0);
        paramView.b.setVisibility(0);
      }
      else
      {
        paramView.a.setVisibility(4);
        paramView.b.setVisibility(0);
      }
    }
  }
  
  private class a
  {
    TextView a;
    TextView b;
    TextView c;
    View d;
    
    private a() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/adpter/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */