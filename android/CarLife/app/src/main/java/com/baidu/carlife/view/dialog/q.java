package com.baidu.carlife.view.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.carlife.f.a;
import com.baidu.carlife.f.c;
import com.baidu.carlife.f.d;
import com.baidu.carlife.f.g;
import java.util.ArrayList;
import java.util.HashMap;

public class q
  extends BaseDialog
{
  private TextView e;
  private TextView f;
  private ListView g;
  private TextView h;
  private a i;
  private int j = 0;
  private int k = -1;
  private c l;
  private g m;
  
  public q(Context paramContext, ArrayList<HashMap<String, Object>> paramArrayList)
  {
    super(paramContext);
    paramContext = null;
    int n = 0;
    while (n < paramArrayList.size())
    {
      if (((Boolean)((HashMap)paramArrayList.get(n)).get("check")).booleanValue())
      {
        paramContext = (String)((HashMap)paramArrayList.get(n)).get("label");
        this.j += 1;
      }
      n += 1;
    }
    if (this.j == 0) {
      this.f.setText(2131296650);
    }
    for (;;)
    {
      paramContext = new b(paramArrayList);
      this.g.setAdapter(paramContext);
      return;
      if (this.j == 2) {
        this.f.setText(2131296652);
      } else if (this.j == 1) {
        if ("内置存储卡".equals(paramContext)) {
          this.f.setText(2131296651);
        } else {
          this.f.setText(2131296653);
        }
      }
    }
  }
  
  protected View a()
  {
    return LayoutInflater.from(this.c).inflate(2130969007, null);
  }
  
  public q a(a parama)
  {
    this.i = parama;
    return this;
  }
  
  protected void b()
  {
    this.e = ((TextView)findViewById(2131624146));
    this.f = ((TextView)findViewById(2131626044));
    this.g = ((ListView)findViewById(2131626046));
    this.g.setSelector(2130837694);
    this.h = ((TextView)findViewById(2131626048));
    this.h.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (q.a(q.this) != null) {
          q.a(q.this).a();
        }
      }
    });
  }
  
  public void f()
  {
    if (this.m == null)
    {
      this.m = new g(this.h, 11);
      this.m.d(this.h);
    }
    if (this.l == null) {
      this.l = new c(this.g, 9);
    }
    this.m.a(true);
    this.l.a(true);
    d.a().a(new a[] { this.m, this.l });
  }
  
  public void g()
  {
    d.a().e();
  }
  
  public ListView getListView()
  {
    return this.g;
  }
  
  public int getmCheckedPosition()
  {
    return this.k;
  }
  
  public void i()
  {
    this.j = 0;
  }
  
  public void setmCheckedPosition(int paramInt)
  {
    this.k = paramInt;
  }
  
  public static abstract interface a
  {
    public abstract void a();
  }
  
  public class b
    extends BaseAdapter
  {
    private ArrayList<HashMap<String, Object>> b = new ArrayList();
    
    public b()
    {
      int i = 0;
      Object localObject;
      while (i < ((ArrayList)localObject).size())
      {
        this.b.add(((ArrayList)localObject).get(i));
        i += 1;
      }
    }
    
    public int getCount()
    {
      if ((this.b != null) && (this.b.size() > 0)) {
        return this.b.size();
      }
      return 0;
    }
    
    public Object getItem(int paramInt)
    {
      if ((this.b != null) && (paramInt >= 0) && (paramInt < this.b.size())) {
        return this.b.get(paramInt);
      }
      return null;
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      paramView = LayoutInflater.from(q.this.getContext()).inflate(2130969006, null);
      paramViewGroup = (ImageView)paramView.findViewById(2131626041);
      Object localObject = (TextView)paramView.findViewById(2131626042);
      TextView localTextView = (TextView)paramView.findViewById(2131624556);
      CheckBox localCheckBox = (CheckBox)paramView.findViewById(2131626043);
      localCheckBox.setChecked(false);
      String str;
      if ((this.b != null) && (paramInt >= 0) && (paramInt < this.b.size()))
      {
        str = (String)((HashMap)this.b.get(paramInt)).get("label");
        ((TextView)localObject).setText(str);
        localTextView.setText((String)((HashMap)this.b.get(paramInt)).get("volume"));
        localObject = (Boolean)((HashMap)this.b.get(paramInt)).get("check");
        if (q.b(q.this) < 2) {
          if (!((Boolean)localObject).booleanValue()) {
            break label236;
          }
        }
      }
      label236:
      for (int i = 2130837748;; i = 2130837751)
      {
        localCheckBox.setButtonDrawable(i);
        if ((q.b(q.this) < 2) && (((Boolean)localObject).booleanValue())) {
          q.this.setmCheckedPosition(paramInt);
        }
        if (!"内置存储卡".equals(str)) {
          break;
        }
        paramViewGroup.setImageResource(2130837970);
        return paramView;
      }
      paramViewGroup.setImageResource(2130837971);
      return paramView;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/view/dialog/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */