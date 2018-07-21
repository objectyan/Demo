package com.baidu.carlife.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.carlife.h.b;
import com.baidu.carlife.model.k;
import java.util.List;

public class p
  extends BaseAdapter
{
  private List<k> a;
  private LayoutInflater b;
  
  public p(Context paramContext)
  {
    this.b = LayoutInflater.from(paramContext);
  }
  
  private void a(final int paramInt, a parama, final k paramk)
  {
    if (!paramk.a) {
      parama.i.setVisibility(8);
    }
    for (;;)
    {
      parama.b.setText(paramk.b);
      parama.c.setText(paramk.c);
      parama.d.setText(paramk.d);
      parama.e.setText(paramk.e);
      parama.f.setText(paramk.f);
      parama.g.setText(paramk.g);
      parama.h.setText(paramk.h);
      return;
      parama.i.setVisibility(0);
      if (!paramk.j)
      {
        parama.i.setClickable(true);
        parama.i.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            paramk.k.deleteRecordItem(paramInt);
          }
        });
      }
      else
      {
        parama.i.setClickable(false);
      }
    }
  }
  
  public void a(List<k> paramList)
  {
    this.a = paramList;
  }
  
  public int getCount()
  {
    if (this.a != null) {
      return this.a.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.a != null) && (paramInt < this.a.size())) {
      return this.a.get(paramInt);
    }
    return null;
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
      paramView = new a(null);
      localView = this.b.inflate(2130968869, paramViewGroup, false);
      paramView.a = localView;
      paramView.b = ((TextView)localView.findViewById(2131625369));
      paramView.c = ((TextView)localView.findViewById(2131625371));
      paramView.d = ((TextView)localView.findViewById(2131625374));
      paramView.e = ((TextView)localView.findViewById(2131625376));
      paramView.f = ((TextView)localView.findViewById(2131625378));
      paramView.g = ((TextView)localView.findViewById(2131624933));
      paramView.h = ((TextView)localView.findViewById(2131625379));
      paramView.i = ((RelativeLayout)localView.findViewById(2131625380));
      localView.setTag(paramView);
    }
    a(paramInt, (a)localView.getTag(), (k)getItem(paramInt));
    return localView;
  }
  
  private class a
  {
    View a;
    TextView b;
    TextView c;
    TextView d;
    TextView e;
    TextView f;
    TextView g;
    TextView h;
    RelativeLayout i;
    
    private a() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/adpter/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */