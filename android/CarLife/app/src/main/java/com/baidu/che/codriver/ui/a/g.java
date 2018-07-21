package com.baidu.che.codriver.ui.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.che.codriver.protocol.data.Place.Result;
import com.baidu.che.codriver.ui.d.j;
import com.baidu.che.codriver.vr.a.s;
import com.baidu.che.codriver.widget.CompoundRelativeLayout;
import java.util.List;

public class g
  extends a
  implements h
{
  public static final int b = 3;
  private LayoutInflater c;
  private List<Place.Result> d;
  private s e;
  private j f;
  private Context g;
  
  public g(Context paramContext, s params)
  {
    this.g = paramContext;
    this.e = params;
    this.c = LayoutInflater.from(paramContext);
  }
  
  public int a()
  {
    return (int)Math.ceil(this.d.size() / 3.0F);
  }
  
  public View a(int paramInt)
  {
    LinearLayout localLinearLayout = new LinearLayout(this.g);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2, 0.0F));
    int i = 0;
    if (i < 3)
    {
      View localView1 = this.c.inflate(2130969000, null);
      final int j = paramInt * 3 + i;
      TextView localTextView1 = (TextView)localView1.findViewById(2131626024);
      TextView localTextView2 = (TextView)localView1.findViewById(2131626025);
      TextView localTextView3 = (TextView)localView1.findViewById(2131626026);
      View localView2 = localView1.findViewById(2131625852);
      if (j < this.d.size())
      {
        localTextView1.setText(j + 1 + ". " + ((Place.Result)this.d.get(j)).name);
        localTextView2.setText(((Place.Result)this.d.get(j)).address);
        localTextView3.setText(this.c.getContext().getResources().getString(2131298443, new Object[] { ((Place.Result)this.d.get(j)).distance + "" }));
        localView1.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            if (g.a(g.this) != null) {
              g.a(g.this).a((Place.Result)g.b(g.this).get(j));
            }
          }
        });
        super.a(localLinearLayout, (CompoundRelativeLayout)localView1, j);
        label271:
        if (a() == 1) {
          ((RelativeLayout.LayoutParams)localView2.getLayoutParams()).rightMargin = 0;
        }
        if (i != 2) {
          break label328;
        }
        localView2.setVisibility(4);
      }
      for (;;)
      {
        i += 1;
        break;
        if (i <= 0) {
          break label271;
        }
        super.a(localLinearLayout, (CompoundRelativeLayout)localView1, j);
        break label271;
        label328:
        localView2.setVisibility(0);
      }
    }
    return localLinearLayout;
  }
  
  public void a(j paramj)
  {
    this.f = paramj;
    this.d = paramj.a();
  }
  
  public int b()
  {
    return this.f.l;
  }
  
  public void b(int paramInt)
  {
    this.f.l = paramInt;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/ui/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */