package com.baidu.carlife.c;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.carlife.c.f.a.a;
import com.baidu.carlife.c.f.a.b;
import com.baidu.carlife.c.f.b.b;

public class b
  extends BaseAdapter
  implements b.b
{
  private com.baidu.carlife.c.f.b.a a;
  
  public void a(com.baidu.carlife.c.f.b.a parama)
  {
    this.a = parama;
  }
  
  public void a(Object paramObject)
  {
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.a.d();
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.c(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(this.a.b(paramInt), paramViewGroup, false);
      paramViewGroup = new a(paramView, paramInt);
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      a.a locala2 = paramViewGroup.c();
      a.a locala1 = locala2;
      if (locala2 == null)
      {
        locala1 = this.a.d(paramInt);
        locala1.a(paramInt);
        locala1.a(this.a);
        locala1.a(paramViewGroup);
        paramViewGroup.a(locala1);
      }
      locala1.a(this.a.c(paramInt));
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
  }
  
  public static final class a
    implements a.b
  {
    private static final int a = 0;
    private SparseArray<View> b = new SparseArray();
    private View c;
    private a.a d;
    private int e;
    
    public a(View paramView, int paramInt)
    {
      this.c = paramView;
      this.e = paramInt;
    }
    
    public View a()
    {
      return this.c;
    }
    
    public <T extends View> T a(int paramInt)
    {
      View localView2 = (View)this.b.get(paramInt);
      View localView1 = localView2;
      if (localView2 == null)
      {
        localView1 = this.c.findViewById(paramInt);
        this.b.put(paramInt, localView1);
      }
      return localView1;
    }
    
    public void a(int paramInt, View.OnClickListener paramOnClickListener)
    {
      if (paramInt == 0)
      {
        this.c.setOnClickListener(paramOnClickListener);
        return;
      }
      a(paramInt).setOnClickListener(paramOnClickListener);
    }
    
    public void a(int paramInt, String paramString)
    {
      ((TextView)a(paramInt)).setText(paramString);
    }
    
    public void a(a.a parama)
    {
      this.d = parama;
    }
    
    public int b()
    {
      return this.e;
    }
    
    public a.a c()
    {
      return this.d;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */