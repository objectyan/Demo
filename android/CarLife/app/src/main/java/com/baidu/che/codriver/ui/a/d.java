package com.baidu.che.codriver.ui.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.che.codriver.c.a;
import com.baidu.che.codriver.ui.d.f;
import java.util.List;

public class d
  implements h
{
  public static final int a = 3;
  private f b;
  private Context c;
  
  public d(Context paramContext)
  {
    this.c = paramContext;
  }
  
  public int a()
  {
    return (int)Math.ceil(this.b.a().size() / 3.0F);
  }
  
  public View a(int paramInt)
  {
    LinearLayout localLinearLayout = new LinearLayout(this.c);
    localLinearLayout.setOrientation(1);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2, 0.0F);
    localLinearLayout.setLayoutParams(localLayoutParams);
    int i = 0;
    while (i < 3)
    {
      View localView = LayoutInflater.from(this.c).inflate(2130968935, null);
      int j = paramInt * 3 + i;
      if (j < this.b.a().size())
      {
        a locala = (a)this.b.a().get(j);
        TextView localTextView1 = (TextView)localView.findViewById(2131624637);
        TextView localTextView2 = (TextView)localView.findViewById(2131625661);
        localTextView1.setText(j + 1 + ". " + locala.e);
        localTextView2.setText(locala.i + " <" + locala.f + ">");
      }
      localView.setLayoutParams(localLayoutParams);
      localLinearLayout.addView(localView);
      localView = new View(this.c);
      localView.setBackgroundColor(this.c.getResources().getColor(2131559208));
      localView.setLayoutParams(new ViewGroup.LayoutParams(-1, 1));
      localLinearLayout.addView(localView);
      i += 1;
    }
    return localLinearLayout;
  }
  
  public void a(f paramf)
  {
    this.b = paramf;
  }
  
  public int b()
  {
    return this.b.a;
  }
  
  public void b(int paramInt)
  {
    this.b.a = paramInt;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/ui/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */