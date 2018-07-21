package com.baidu.carlife.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.carlife.model.n;
import com.baidu.carlife.util.r;
import com.baidu.carlife.view.pinnedheaderlistview.a;
import com.baidu.carlife.view.pinnedheaderlistview.b;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class o
  extends b
{
  private LayoutInflater a;
  private Map<String, List<n>> b = null;
  private String[] c = null;
  private a d = null;
  private int[] e = null;
  private String[] f = null;
  
  public o(Context paramContext)
  {
    this.a = LayoutInflater.from(paramContext);
  }
  
  private void d()
  {
    String[] arrayOfString = new String[this.b.size()];
    int i = 0;
    int j = 0;
    int k = 0;
    if (k < this.c.length)
    {
      if ((this.c[k].compareTo("A") < 0) || (this.c[k].compareTo("Z") > 0))
      {
        arrayOfString[j] = this.c[k];
        j += 1;
      }
      for (;;)
      {
        k += 1;
        break;
        this.c[i] = this.c[k];
        i += 1;
      }
    }
    Arrays.sort(this.c, 0, this.c.length - j);
    if ((arrayOfString != null) && (j > 0)) {
      Arrays.sort(arrayOfString, 0, j);
    }
    k = 0;
    while (k < j)
    {
      this.c[i] = arrayOfString[k];
      k += 1;
      i += 1;
    }
  }
  
  private void e()
  {
    int i = 0;
    int j = 0;
    int k;
    while (j < this.c.length)
    {
      k = i;
      if (this.c[j].compareTo("A") >= 0)
      {
        k = i;
        if (this.c[j].compareTo("Z") <= 0) {
          k = i + 1;
        }
      }
      j += 1;
      i = k;
    }
    if (i == 0) {}
    for (;;)
    {
      return;
      this.f = new String[i];
      k = 0;
      j = 0;
      while ((k < i) && (j < this.c.length))
      {
        int m = k;
        if (this.c[j].compareTo("A") >= 0)
        {
          m = k;
          if (this.c[j].compareTo("Z") <= 0)
          {
            this.f[k] = this.c[j];
            m = k + 1;
          }
        }
        j += 1;
        k = m;
      }
    }
  }
  
  private List<n> g(int paramInt)
  {
    if ((this.b == null) || (this.b.size() < 1)) {
      return null;
    }
    return (List)this.b.get(this.c[paramInt]);
  }
  
  public int a()
  {
    if (this.b == null) {
      return 0;
    }
    return this.b.size();
  }
  
  public int a(int paramInt)
  {
    if (this.d != null) {
      return this.d.getPositionForSection(paramInt);
    }
    return -1;
  }
  
  public int a(String paramString)
  {
    int i;
    if ("#".equalsIgnoreCase(paramString)) {
      i = this.f.length;
    }
    while (i >= 0)
    {
      return i;
      if ((this.f != null) && (this.f.length > 0)) {
        i = Arrays.binarySearch(this.f, paramString);
      } else {
        try
        {
          i = Arrays.binarySearch(this.c, paramString);
        }
        catch (NullPointerException paramString)
        {
          return -2;
        }
      }
    }
    return -i - 1;
  }
  
  public View a(int paramInt1, int paramInt2, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = this.a.inflate(2130968985, paramViewGroup, false);
      paramView = new a(null);
      paramView.a = ((TextView)localView.findViewById(2131625971));
      paramView.b = ((TextView)localView.findViewById(2131625972));
      localView.setTag(paramView);
    }
    paramView = (a)localView.getTag();
    paramViewGroup = a(paramInt1, paramInt2);
    if (paramViewGroup == null) {
      return null;
    }
    paramView.a.setText(paramViewGroup.a);
    paramView.b.setText(paramViewGroup.b);
    paramView.a.setTextColor(r.a(2131558702));
    paramView.b.setTextColor(r.a(2131558692));
    return localView;
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = this.a.inflate(2130968718, paramViewGroup, false);
    }
    localView.setBackground(r.b(2131558590));
    ((TextView)localView.findViewById(2131624660)).setText(String.valueOf(this.c[paramInt]));
    return localView;
  }
  
  public n a(int paramInt1, int paramInt2)
  {
    List localList = g(paramInt1);
    if ((localList == null) || (localList.size() < 1)) {
      return null;
    }
    return (n)localList.get(paramInt2);
  }
  
  public void a(Map<String, List<n>> paramMap)
  {
    if ((paramMap == null) || (paramMap.size() < 1)) {
      return;
    }
    this.b = paramMap;
    this.c = new String[this.b.size()];
    this.b.keySet().toArray(this.c);
    d();
    e();
    this.e = new int[this.b.size()];
    int i = 0;
    while (i < this.c.length)
    {
      this.e[i] = b(i);
      i += 1;
    }
    this.d = new a(this.c, this.e);
  }
  
  public int b(int paramInt)
  {
    List localList = g(paramInt);
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public long b(int paramInt1, int paramInt2)
  {
    return 0L;
  }
  
  private class a
  {
    TextView a;
    TextView b;
    
    private a() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/adpter/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */