package com.baidu.carlife.view.dialog;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.navisdk.ui.util.BNStyleManager;
import java.util.ArrayList;

public class n
  extends m
{
  private ListView e;
  
  public n(Context paramContext)
  {
    super(paramContext);
  }
  
  protected View a()
  {
    return LayoutInflater.from(this.c).inflate(2130968953, null);
  }
  
  public n a(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.e.setOnItemClickListener(paramOnItemClickListener);
    return this;
  }
  
  public n a(ListAdapter paramListAdapter)
  {
    this.e.setAdapter(paramListAdapter);
    return this;
  }
  
  protected void b()
  {
    this.e = ((ListView)findViewById(2131625835));
  }
  
  public n c(View paramView)
  {
    super.a(paramView);
    return this;
  }
  
  public n c(m.a parama)
  {
    super.a(parama);
    return this;
  }
  
  public n c(boolean paramBoolean)
  {
    super.a(paramBoolean);
    return this;
  }
  
  public n d(View paramView)
  {
    super.b(paramView);
    return this;
  }
  
  public n d(m.a parama)
  {
    super.b(parama);
    return this;
  }
  
  public n d(boolean paramBoolean)
  {
    super.b(paramBoolean);
    return this;
  }
  
  public n f(int paramInt)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.e.getLayoutParams();
    localLayoutParams.width = paramInt;
    this.e.setLayoutParams(localLayoutParams);
    return this;
  }
  
  public n f(String paramString)
  {
    super.b(paramString);
    return this;
  }
  
  public n g(int paramInt)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.e.getLayoutParams();
    localLayoutParams.height = paramInt;
    this.e.setLayoutParams(localLayoutParams);
    return this;
  }
  
  public n g(String paramString)
  {
    super.c(paramString);
    return this;
  }
  
  protected int getCustomWidth()
  {
    return this.c.getResources().getDimensionPixelSize(2131361841);
  }
  
  public ListView getListView()
  {
    return this.e;
  }
  
  public n h(int paramInt)
  {
    this.e.setSelection(paramInt);
    return this;
  }
  
  public n h(String paramString)
  {
    super.d(paramString);
    return this;
  }
  
  public n i(int paramInt)
  {
    super.a(paramInt);
    return this;
  }
  
  public n i(String paramString)
  {
    super.e(paramString);
    return this;
  }
  
  public n j(int paramInt)
  {
    super.b(paramInt);
    return this;
  }
  
  public n k(int paramInt)
  {
    super.c(paramInt);
    return this;
  }
  
  public n l(int paramInt)
  {
    super.d(paramInt);
    return this;
  }
  
  public n m(int paramInt)
  {
    super.e(paramInt);
    return this;
  }
  
  public void setListAdapter(ArrayList<String> paramArrayList)
  {
    paramArrayList = new a(paramArrayList);
    this.e.setAdapter(paramArrayList);
  }
  
  public class a
    extends BaseAdapter
  {
    private ArrayList<String> b = new ArrayList();
    
    public a()
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
      if (paramView == null)
      {
        paramView = LayoutInflater.from(n.this.getContext()).inflate(2130969044, null);
        paramViewGroup = (TextView)paramView.findViewById(2131624273);
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        if ((this.b != null) && (paramInt >= 0) && (paramInt < this.b.size())) {
          paramViewGroup.setText((CharSequence)this.b.get(paramInt));
        }
        if (paramInt != getCount() - 1) {
          break;
        }
        paramViewGroup.setTextColor(BNStyleManager.getColor(1711800514));
        paramView.setBackgroundDrawable(BNStyleManager.getDrawable(1711407371));
        return paramView;
        paramViewGroup = (TextView)paramView.getTag();
      }
      paramViewGroup.setTextColor(BNStyleManager.getColor(1711800514));
      paramView.setBackgroundDrawable(BNStyleManager.getDrawable(1711407374));
      return paramView;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/view/dialog/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */