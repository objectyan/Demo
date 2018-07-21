package com.baidu.che.codriver.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.che.codriver.ui.d.i;
import com.baidu.che.codriver.ui.d.i.a;
import com.baidu.che.codriver.widget.CompoundRelativeLayout;
import java.util.ArrayList;
import java.util.List;

public class f
  extends a
  implements h
{
  public static final int b = 3;
  private i c;
  private List<com.baidu.che.codriver.e.a> d = new ArrayList();
  private Context e;
  private i.a f;
  private a g;
  
  public f(Context paramContext, i parami)
  {
    this.e = paramContext;
    this.e = paramContext;
    this.c = parami;
    this.g = parami.d();
    this.f = parami.a();
    if (parami.b() != null) {
      this.d.addAll(parami.b());
    }
  }
  
  public int a()
  {
    return (int)Math.ceil(this.d.size() / 3.0F);
  }
  
  public View a(int paramInt)
  {
    LinearLayout localLinearLayout = new LinearLayout(this.e);
    Object localObject1;
    if (this.f == i.a.c)
    {
      localLinearLayout = (LinearLayout)LayoutInflater.from(this.e).inflate(2130968986, null);
      localObject2 = (TextView)localLinearLayout.findViewById(2131625974);
      localObject1 = localLinearLayout;
      if (this.d.size() > 0)
      {
        ((TextView)localObject2).setText(((com.baidu.che.codriver.e.a)this.d.get(0)).b());
        localObject1 = localLinearLayout;
      }
    }
    int i;
    do
    {
      return (View)localObject1;
      localLinearLayout.setOrientation(1);
      localLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2, 0.0F));
      i = 0;
      localObject1 = localLinearLayout;
    } while (i >= 3);
    final int j = paramInt * 3 + i;
    Object localObject2 = (RelativeLayout)LayoutInflater.from(this.e).inflate(2130968987, null);
    TextView localTextView = (TextView)((RelativeLayout)localObject2).findViewById(2131625975);
    View localView = ((RelativeLayout)localObject2).findViewById(2131625852);
    final com.baidu.che.codriver.e.a locala;
    if (j < this.d.size())
    {
      locala = (com.baidu.che.codriver.e.a)this.d.get(j);
      if (this.f == i.a.a)
      {
        localObject1 = locala.a();
        label220:
        localTextView.setText(String.valueOf(j + 1) + ". " + (String)localObject1);
        localTextView.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            if (f.a(f.this) != null) {
              f.a(f.this).a(j, locala, f.b(f.this));
            }
          }
        });
        super.a(localLinearLayout, (CompoundRelativeLayout)localObject2, j);
        label282:
        if (a() == 1) {
          ((RelativeLayout.LayoutParams)localView.getLayoutParams()).rightMargin = 0;
        }
        if (i != 2) {
          break label349;
        }
        localView.setVisibility(4);
      }
    }
    for (;;)
    {
      i += 1;
      break;
      localObject1 = locala.b();
      break label220;
      if (i <= 0) {
        break label282;
      }
      super.a(localLinearLayout, (CompoundRelativeLayout)localObject2, j);
      break label282;
      label349:
      localView.setVisibility(0);
    }
  }
  
  public int b()
  {
    return this.c.c();
  }
  
  public void b(int paramInt)
  {
    this.c.a(paramInt);
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt, com.baidu.che.codriver.e.a parama, i.a parama1);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/ui/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */