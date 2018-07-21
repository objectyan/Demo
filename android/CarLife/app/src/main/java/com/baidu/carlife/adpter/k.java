package com.baidu.carlife.adpter;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.carlife.model.j;
import com.baidu.carlife.util.r;
import com.baidu.carlife.view.MultiImageView;
import java.util.List;

public class k
  extends BaseAdapter
{
  private Context a;
  private LayoutInflater b;
  private List<j> c;
  
  public k(Context paramContext, List<j> paramList)
  {
    this.a = paramContext;
    this.b = LayoutInflater.from(paramContext);
    this.c = paramList;
  }
  
  private void a(MultiImageView paramMultiImageView, j paramj)
  {
    if (paramj.c >= 3)
    {
      paramMultiImageView.setDefaultDrawable(r.b(2130838958));
      paramMultiImageView.setImageUrl(paramj.j);
      return;
    }
    paramMultiImageView.setDefaultDrawableResId(paramj.b);
    paramMultiImageView.setImageUrl(null);
  }
  
  public int getCount()
  {
    return this.c.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.c.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramViewGroup = this.b.inflate(2130968933, null);
      paramViewGroup.setLayoutParams(new AbsListView.LayoutParams(-1, (int)this.a.getResources().getDimension(2131362000)));
      paramView = new a(null);
      paramView.b = ((TextView)paramViewGroup.findViewById(2131625654));
      paramView.a = ((MultiImageView)paramViewGroup.findViewById(2131625653));
      paramView.c = ((ImageView)paramViewGroup.findViewById(2131625655));
      paramViewGroup.setTag(paramView);
    }
    paramView = (a)paramViewGroup.getTag();
    j localj = (j)getItem(paramInt);
    if (localj == null) {
      return null;
    }
    if (!TextUtils.isEmpty(localj.l)) {
      paramView.b.setText(localj.l);
    }
    for (;;)
    {
      a(paramView.a, localj);
      if (!localj.a) {
        break;
      }
      paramView.c.setImageDrawable(r.b(2130838318));
      paramView.c.setVisibility(0);
      paramView.b.setTextColor(r.a(2131558648));
      return paramViewGroup;
      paramView.b.setText("");
    }
    paramView.c.setVisibility(4);
    paramView.b.setTextColor(r.a(2131558702));
    return paramViewGroup;
  }
  
  private static class a
  {
    MultiImageView a;
    TextView b;
    ImageView c;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/adpter/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */