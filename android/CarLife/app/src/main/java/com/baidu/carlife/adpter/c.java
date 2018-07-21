package com.baidu.carlife.adpter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RatingBar;
import android.widget.TextView;
import com.baidu.carlife.BaiduNaviApplication;
import com.baidu.carlife.CarlifeActivity;
import com.baidu.carlife.core.screen.l;
import com.baidu.carlife.logic.h;
import com.baidu.carlife.model.e;
import com.baidu.carlife.util.r;
import com.baidu.carlife.view.MultiImageView;
import com.baidu.navi.util.StatisticManager;
import java.util.List;
import java.util.Map;

public class c
  extends BaseAdapter
{
  private List<com.baidu.carlife.model.f> a;
  private List<e> b;
  private LayoutInflater c;
  private CarlifeActivity d;
  private l e;
  
  public c(Context paramContext, l paraml)
  {
    this.c = LayoutInflater.from(paramContext);
    this.e = paraml;
  }
  
  private void a(String paramString, TextView paramTextView)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramTextView.setText(paramString);
      return;
    }
    paramTextView.setText("");
  }
  
  public void a(List<com.baidu.carlife.model.f> paramList)
  {
    this.a = paramList;
  }
  
  public void b(List<e> paramList)
  {
    this.b = paramList;
  }
  
  public int getCount()
  {
    int i = 0;
    int j = 0;
    if (this.b != null) {
      i = this.b.size();
    }
    if (this.a != null) {
      j = this.a.size();
    }
    return i + j;
  }
  
  public Object getItem(int paramInt)
  {
    int i = 0;
    if (this.a != null)
    {
      int j = this.a.size();
      i = j;
      if (paramInt < j) {
        return this.a.get(paramInt);
      }
    }
    if (this.b != null) {
      return this.b.get(paramInt - i);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.a != null) && (paramInt < this.a.size())) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, final ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null)
    {
      paramView = new a(null);
      if (getItemViewType(paramInt) == 1)
      {
        localView = this.c.inflate(2130968860, paramViewGroup, false);
        paramView.c = ((MultiImageView)localView.findViewById(2131624900));
        paramView.a = ((TextView)localView.findViewById(2131624906));
        paramView.d = ((RatingBar)localView.findViewById(2131624909));
        paramView.e = ((TextView)localView.findViewById(2131624911));
        paramView.f = ((TextView)localView.findViewById(2131624910));
        paramView.g = ((TextView)localView.findViewById(2131625350));
        paramView.i = ((TextView)localView.findViewById(2131624903));
        paramView.h = ((TextView)localView.findViewById(2131625349));
        paramView.b = ((TextView)localView.findViewById(2131624902));
        localView.setTag(paramView);
      }
    }
    else
    {
      paramView = (a)localView.getTag();
      paramViewGroup = getItem(paramInt);
      if (!(paramViewGroup instanceof com.baidu.carlife.model.f)) {
        break label663;
      }
      paramViewGroup = (com.baidu.carlife.model.f)paramViewGroup;
      a(paramViewGroup.q, paramView.a);
      if (TextUtils.isEmpty(paramViewGroup.m)) {
        break label588;
      }
      paramView.j.setVisibility(0);
      paramView.j.setText(paramViewGroup.m);
      if (!com.baidu.carlife.model.f.a(paramViewGroup.l)) {
        break label575;
      }
      paramView.j.setBackgroundResource(2130838229);
      label258:
      int i = 0;
      paramInt = i;
      if (!TextUtils.isEmpty(paramViewGroup.r))
      {
        paramInt = i;
        if (h.a.containsKey(paramViewGroup.r)) {
          paramInt = ((Integer)h.a.get(paramViewGroup.r)).intValue();
        }
      }
      if (paramInt <= 0) {
        break label600;
      }
      paramView.b.setText(e.a(paramInt));
      label326:
      if (TextUtils.isEmpty(paramViewGroup.p)) {
        break label612;
      }
      paramView.k.setText(paramViewGroup.p);
      label347:
      if ((!com.baidu.carlife.model.f.a(paramViewGroup.l)) || (TextUtils.isEmpty(paramViewGroup.i))) {
        break label625;
      }
      paramView.m.setText(paramViewGroup.i);
      label378:
      if (!com.baidu.carlife.model.f.a(paramViewGroup.l)) {
        break label638;
      }
      paramView.l.setText(BaiduNaviApplication.getInstance().getApplicationContext().getString(2131297540, new Object[] { Integer.valueOf(paramViewGroup.d) }));
    }
    for (;;)
    {
      if (!com.baidu.carlife.core.f.jr) {
        break label651;
      }
      paramView.n.setVisibility(0);
      paramView.n.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (!TextUtils.isEmpty(paramViewGroup.q))
          {
            StatisticManager.onEvent("DISCOVER_ZMS_0003", "DISCOVER_ZMS_0003");
            if (com.baidu.carlife.model.f.a(paramViewGroup.l)) {
              StatisticManager.onEvent("DISCOVER_ZMS_0004", "DISCOVER_ZMS_0004");
            }
            c.a(c.this).innerNameSearch(paramViewGroup.q);
          }
        }
      });
      return localView;
      localView = this.c.inflate(2130968861, paramViewGroup, false);
      paramView.a = ((TextView)localView.findViewById(2131624906));
      paramView.j = ((TextView)localView.findViewById(2131625352));
      paramView.b = ((TextView)localView.findViewById(2131624902));
      paramView.k = ((TextView)localView.findViewById(2131625353));
      paramView.l = ((TextView)localView.findViewById(2131625354));
      paramView.m = ((TextView)localView.findViewById(2131625355));
      paramView.n = localView.findViewById(2131625356);
      localView.setTag(paramView);
      break;
      label575:
      paramView.j.setBackgroundResource(2130838230);
      break label258;
      label588:
      paramView.j.setVisibility(8);
      break label258;
      label600:
      paramView.b.setText("");
      break label326;
      label612:
      paramView.k.setText(2131297531);
      break label347;
      label625:
      paramView.m.setText(2131297531);
      break label378;
      label638:
      paramView.l.setText(2131297531);
    }
    label651:
    paramView.n.setVisibility(8);
    return localView;
    label663:
    paramViewGroup = (e)paramViewGroup;
    paramView.c.setDefaultDrawable(r.b(2130838560));
    paramView.c.setImageUrl(paramViewGroup.j);
    a(paramViewGroup.i, paramView.a);
    float f1 = 0.0F;
    try
    {
      float f2 = Float.parseFloat(paramViewGroup.B + "");
      f1 = f2;
    }
    catch (Exception localException)
    {
      label808:
      label895:
      label907:
      label919:
      for (;;) {}
    }
    paramView.d.setRating(f1);
    if (paramViewGroup.A > 0)
    {
      paramView.e.setText(BaiduNaviApplication.getInstance().getApplicationContext().getString(2131297530, new Object[] { Integer.valueOf(paramViewGroup.A) }));
      if (TextUtils.isEmpty(paramViewGroup.x)) {
        break label895;
      }
      paramView.f.setText(paramViewGroup.x);
      if (paramViewGroup.n.intValue() <= 0) {
        break label907;
      }
      paramView.b.setText(e.a(paramViewGroup.n.intValue()));
    }
    for (;;)
    {
      if (paramViewGroup.m <= 0) {
        break label919;
      }
      paramView.i.setVisibility(4);
      paramView.h.setVisibility(0);
      paramView.g.setVisibility(0);
      paramView.g.setText(String.valueOf(paramViewGroup.m));
      return localView;
      paramView.e.setText("");
      break;
      paramView.f.setText("");
      break label808;
      paramView.b.setText("");
    }
    paramView.h.setVisibility(4);
    paramView.g.setVisibility(4);
    paramView.i.setVisibility(0);
    if ((paramViewGroup.l != null) && (!paramViewGroup.l.isEmpty()))
    {
      paramView.i.setText(paramViewGroup.l);
      if (paramViewGroup.l.equals("不用排队"))
      {
        paramView.i.setTextColor(r.a(2131558692));
        return localView;
      }
      paramView.i.setTextColor(r.a(2131558641));
      return localView;
    }
    paramView.i.setText(BaiduNaviApplication.getInstance().getApplicationContext().getString(2131297527));
    paramView.i.setTextColor(r.a(2131558641));
    return localView;
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  private class a
  {
    TextView a;
    TextView b;
    MultiImageView c;
    RatingBar d;
    TextView e;
    TextView f;
    TextView g;
    TextView h;
    TextView i;
    TextView j;
    TextView k;
    TextView l;
    TextView m;
    View n;
    
    private a() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/adpter/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */