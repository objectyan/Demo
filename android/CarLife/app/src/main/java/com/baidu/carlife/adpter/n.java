package com.baidu.carlife.adpter;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

public class n
  extends BaseAdapter
{
  private String a;
  private LayoutInflater b;
  private List<com.baidu.carlife.model.n> c;
  private String d;
  private int e;
  
  public n(Context paramContext)
  {
    this.b = LayoutInflater.from(paramContext);
    this.a = paramContext.getString(2131296838);
    this.e = paramContext.getResources().getColor(2131558648);
  }
  
  private SpannableString a(String paramString1, String paramString2)
  {
    SpannableString localSpannableString = new SpannableString(paramString1);
    int i = 0;
    if (!TextUtils.isEmpty(this.d)) {
      i = paramString1.indexOf(this.d);
    }
    int j = i;
    if (i == -1) {
      j = 0;
    }
    localSpannableString.setSpan(new ForegroundColorSpan(this.e), j, paramString2.length() + j, 33);
    return localSpannableString;
  }
  
  public com.baidu.carlife.model.n a(int paramInt)
  {
    if (this.c == null) {
      return null;
    }
    return (com.baidu.carlife.model.n)this.c.get(paramInt);
  }
  
  public void a(String paramString)
  {
    this.d = paramString;
  }
  
  public void a(List<com.baidu.carlife.model.n> paramList)
  {
    this.c = paramList;
  }
  
  public int getCount()
  {
    if (this.c == null) {
      return 0;
    }
    return this.c.size();
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
      localView = this.b.inflate(2130968988, paramViewGroup, false);
      paramView = new a(null);
      paramView.a = ((TextView)localView.findViewById(2131625971));
      paramView.b = ((TextView)localView.findViewById(2131625972));
      localView.setTag(paramView);
    }
    paramView = (a)localView.getTag();
    paramViewGroup = a(paramInt);
    if (paramViewGroup == null) {
      return localView;
    }
    if (TextUtils.isEmpty(paramViewGroup.a)) {
      paramView.a.setText(this.a);
    }
    for (;;)
    {
      paramView.b.setText(a(paramViewGroup.b, this.d));
      return localView;
      paramView.a.setText(paramViewGroup.a);
    }
  }
  
  private class a
  {
    TextView a;
    TextView b;
    
    private a() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/adpter/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */