package com.baidu.carlife.adpter;

import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.carlife.core.screen.a;
import com.baidu.carlife.model.g;
import com.baidu.carlife.util.r;
import com.baidu.navisdk.model.datastruct.LocData;
import java.text.DecimalFormat;
import java.util.List;

public class e
  extends BaseAdapter
{
  private List<g> a;
  private LayoutInflater b;
  private String c;
  private Context d;
  
  public e(Context paramContext)
  {
    this.d = paramContext;
    this.b = LayoutInflater.from(paramContext);
    this.c = paramContext.getString(2131296500);
  }
  
  private void a(a parama)
  {
    parama.b.setTextColor(r.a(2131558702));
    parama.a.setTextColor(r.a(2131558698));
    parama.c.setTextColor(r.a(2131558698));
    parama.d.setTextColor(r.a(2131558698));
    parama.e.setTextColor(r.a(2131558698));
  }
  
  public a a(int paramInt)
  {
    g localg = (g)getItem(paramInt);
    if ((this.d == null) || (localg == null)) {
      return null;
    }
    LocData localLocData = new LocData();
    localLocData.longitude = localg.i;
    localLocData.latitude = localg.h;
    return new a(localg.i, localg.h);
  }
  
  public void a(a parama, g paramg)
  {
    if (paramg == null) {
      return;
    }
    if (paramg.l >= 0)
    {
      if (paramg.l <= 1000) {
        parama.a.setText(paramg.l + "m");
      }
    }
    else
    {
      if (!TextUtils.isEmpty(paramg.b)) {
        parama.b.setText(paramg.b);
      }
      if (!TextUtils.isEmpty(paramg.e)) {
        parama.c.setText(paramg.e);
      }
      if ((paramg.k > 0) && (paramg.j >= 0))
      {
        if (paramg.j / paramg.k > 0.1D) {
          break label265;
        }
        parama.d.setText(Html.fromHtml("<font color=\"#ff1744\">" + paramg.j + "</font>/" + paramg.k));
      }
    }
    for (;;)
    {
      if ((TextUtils.isEmpty(paramg.f)) || (!paramg.f.equals("0"))) {
        break label312;
      }
      parama.e.setText(this.c);
      parama.e.setTextColor(r.a(2131558657));
      return;
      parama.a.setText(new DecimalFormat(".00").format(paramg.l / 1000.0F) + "km");
      break;
      label265:
      parama.d.setText(Html.fromHtml("<font color=\"#ccffffff\">" + paramg.j + "</font>/" + paramg.k));
    }
    label312:
    parama.e.setText(paramg.f + paramg.g);
    parama.e.setTextColor(r.a(2131558698));
  }
  
  public void a(List<g> paramList)
  {
    this.a = paramList;
  }
  
  public int getCount()
  {
    if (this.a == null) {
      return 0;
    }
    return this.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (this.a == null) {
      return null;
    }
    return this.a.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.b.inflate(2130968865, paramViewGroup, false);
      paramViewGroup = new a(null);
      paramViewGroup.a = ((TextView)paramView.findViewById(2131625363));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131624906));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131624907));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131624187));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131624911));
      paramViewGroup.f = paramView.findViewById(2131624067);
      paramView.setTag(paramViewGroup);
      if (paramInt != getCount() - 1) {
        break label160;
      }
      paramViewGroup.f.setVisibility(8);
    }
    for (;;)
    {
      g localg = (g)getItem(paramInt);
      a(paramViewGroup);
      a(paramViewGroup, localg);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label160:
      paramViewGroup.f.setVisibility(0);
    }
  }
  
  private class a
  {
    TextView a;
    TextView b;
    TextView c;
    TextView d;
    TextView e;
    View f;
    
    private a() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/adpter/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */