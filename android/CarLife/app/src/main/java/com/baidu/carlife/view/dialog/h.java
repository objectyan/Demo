package com.baidu.carlife.view.dialog;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.navi.style.StyleManager;
import com.baidu.navisdk.ui.util.BNStyleManager;

public class h
  extends n
{
  public static final int e = 1;
  public static final int f = 2;
  public static final int g = 3;
  public static final int h = 4;
  private String[] j;
  private a k;
  private int l;
  private int m;
  private String[] n = { "重命名", "添加到“我要去”", "取消收藏", "关闭" };
  private String[] o = { "重命名", "从“我要去”移除", "取消收藏", "关闭" };
  private String[] p = { "更改地址", "关闭" };
  private String[] q = { "拍照", "从相册选择", "关闭" };
  
  public h(Context paramContext, int paramInt1, int paramInt2, a parama)
  {
    super(paramContext);
    this.q = paramContext.getResources().getStringArray(2131230724);
    this.k = parama;
    this.m = paramInt1;
    this.l = paramInt2;
    m();
    l();
  }
  
  private void l()
  {
    a(new b(this.j));
    a(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        switch (h.a(h.this))
        {
        }
        for (;;)
        {
          h.this.d();
          return;
          if (h.b(h.this) != null) {
            if (paramAnonymousInt == 0)
            {
              h.b(h.this).a(h.c(h.this));
            }
            else if (paramAnonymousInt == 1)
            {
              h.b(h.this).b(h.c(h.this));
            }
            else if (paramAnonymousInt == 2)
            {
              h.b(h.this).d(h.c(h.this));
              continue;
              if (h.b(h.this) != null) {
                if (paramAnonymousInt == 0)
                {
                  h.b(h.this).a(h.c(h.this));
                }
                else if (paramAnonymousInt == 1)
                {
                  h.b(h.this).c(h.c(h.this));
                }
                else if (paramAnonymousInt == 2)
                {
                  h.b(h.this).d(h.c(h.this));
                  continue;
                  if ((h.b(h.this) != null) && (paramAnonymousInt == 0))
                  {
                    h.b(h.this).e(h.c(h.this));
                    continue;
                    if (h.b(h.this) != null) {
                      if (paramAnonymousInt == 0) {
                        h.b(h.this).e(paramAnonymousInt);
                      } else if (paramAnonymousInt == 1) {
                        h.b(h.this).e(paramAnonymousInt);
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    });
  }
  
  private void m()
  {
    switch (this.m)
    {
    default: 
      return;
    case 1: 
      this.j = this.n;
      return;
    case 2: 
      this.j = this.o;
      return;
    case 3: 
      this.j = this.p;
      return;
    }
    this.j = this.q;
  }
  
  public void f() {}
  
  public void setPoisition(int paramInt)
  {
    this.l = paramInt;
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt);
    
    public abstract void b(int paramInt);
    
    public abstract void c(int paramInt);
    
    public abstract void d(int paramInt);
    
    public abstract void e(int paramInt);
  }
  
  private class b
    extends BaseAdapter
  {
    private String[] b;
    
    public b(String[] paramArrayOfString)
    {
      this.b = paramArrayOfString;
    }
    
    public int getCount()
    {
      if ((this.b != null) && (this.b.length > 0)) {
        return this.b.length;
      }
      return 0;
    }
    
    public Object getItem(int paramInt)
    {
      if ((this.b == null) || (paramInt < 0) || (paramInt >= this.b.length)) {
        return null;
      }
      return this.b[paramInt];
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        paramView = LayoutInflater.from(h.this.getContext()).inflate(2130968730, null);
        paramViewGroup = (TextView)paramView.findViewById(2131624273);
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        paramViewGroup.setText(this.b[paramInt]);
        switch (paramInt)
        {
        default: 
          return paramView;
          paramViewGroup = (TextView)paramView.getTag();
        }
      }
      paramViewGroup.setTextColor(StyleManager.getColor(2131558860));
      paramViewGroup.setBackgroundDrawable(BNStyleManager.getDrawable(1711407509));
      return paramView;
      paramViewGroup.setTextColor(StyleManager.getColor(2131558860));
      paramViewGroup.setBackgroundDrawable(BNStyleManager.getDrawable(1711407374));
      return paramView;
      paramViewGroup.setTextColor(BNStyleManager.getColor(1711800514));
      paramViewGroup.setBackgroundDrawable(BNStyleManager.getDrawable(1711407371));
      return paramView;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/view/dialog/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */