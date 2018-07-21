package com.baidu.che.codriver.ui;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.carlife.f.d;
import com.baidu.carlife.f.g;
import com.baidu.carlife.logic.codriver.adapter.AdapterDialog;
import com.baidu.che.codriver.ui.b.b;
import com.baidu.che.codriver.util.h;
import java.io.PrintStream;

public class a
  extends AdapterDialog
{
  private ExpandableListView g;
  private a h;
  private boolean i;
  private int j = -1;
  private int k = -1;
  private TextView l;
  
  public a(Context paramContext)
  {
    super(paramContext, null, 2131427347);
  }
  
  protected void a(Bundle paramBundle)
  {
    b();
    b("帮助");
  }
  
  public void a(boolean paramBoolean)
  {
    this.i = paramBoolean;
    super.i();
  }
  
  protected void b()
  {
    this.g = ((ExpandableListView)findViewById(2131625501));
    if (this.g == null) {
      return;
    }
    this.h = new a();
    this.g.setAdapter(this.h);
    this.g.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener()
    {
      public void onGroupExpand(int paramAnonymousInt)
      {
        int i = 0;
        int j = a.b(a.this).getExpandableListAdapter().getGroupCount();
        while (i < j)
        {
          if (paramAnonymousInt != i) {
            a.b(a.this).collapseGroup(i);
          }
          i += 1;
        }
      }
    });
    this.l = ((TextView)findViewById(2131625500));
    this.l.setText("通过\"小度小度\"唤醒之后，说出以下指令即可");
  }
  
  protected void b(String paramString)
  {
    TextView localTextView = (TextView)findViewById(2131624623);
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131624634);
    if (localTextView != null) {
      localTextView.setText(paramString);
    }
    if (localLinearLayout != null) {
      localLinearLayout.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          h.e("BaseDialog", "############## close help dialog !");
          a.this.d();
          if (a.a(a.this)) {
            b.b().t();
          }
        }
      });
    }
  }
  
  public void f()
  {
    g localg = new g(this.e, 7);
    localg.d(a(2131624635));
    localg.a(true);
    d.a().a(new com.baidu.carlife.f.a[] { localg });
    d.a().h(localg);
  }
  
  protected int getLayoutId()
  {
    return 2130968889;
  }
  
  class a
    extends BaseExpandableListAdapter
  {
    String[] a = { "导航", "音乐", "随心听", "电话", "日历", "百科", "天气" };
    String[] b = { "“我要去首都机场”", "“我要听王菲的红豆”", "“我要听中国广播电台”", "“打电话给小度”", "“上周三是几号”", "“李白是谁”", "“今天的天气怎么样”" };
    String[] c = { "“火车站怎么走”\n“我要去深圳机场”\n“我要回公司”\n“我要回家”\n“去附近的加油站”", "“我要听王菲的红豆”\n“我要听李荣浩的歌”\n“我想听张磊的南山南”", "“我要听中国广播电台”\n“我要听儿童节目”\n“我要听逻辑思维”\n“我想听相声”", "“打电话给小度”\n“呼叫10086”", "“上周三是几号”\n“今年除夕是几号”\n“这周六是几号”", "“李白是谁”\n“世界上最高的山”\n“双鱼座是几月”", "“今天的天气怎么样”\n“深圳的天气”\n“今天空气质量怎么样”" };
    
    public a() {}
    
    public Object getChild(int paramInt1, int paramInt2)
    {
      return null;
    }
    
    public long getChildId(int paramInt1, int paramInt2)
    {
      return 0L;
    }
    
    public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
    {
      paramView = LayoutInflater.from(a.this.getContext()).inflate(2130968836, null);
      paramViewGroup = new a.c(a.this);
      paramViewGroup.a = ((TextView)paramView.findViewById(2131625256));
      paramViewGroup.a.setText(this.c[paramInt1]);
      return paramView;
    }
    
    public int getChildrenCount(int paramInt)
    {
      return 1;
    }
    
    public Object getGroup(int paramInt)
    {
      return Integer.valueOf(paramInt);
    }
    
    public int getGroupCount()
    {
      return this.a.length;
    }
    
    public long getGroupId(int paramInt)
    {
      return paramInt;
    }
    
    public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        paramView = LayoutInflater.from(a.this.getContext()).inflate(2130968837, null);
        paramViewGroup = new a.b(a.this);
        paramViewGroup.a = ((ImageView)paramView.findViewById(2131624302));
        paramViewGroup.b = ((TextView)paramView.findViewById(2131625257));
        paramViewGroup.c = ((TextView)paramView.findViewById(2131625258));
        paramViewGroup.d = ((ImageView)paramView.findViewById(2131625259));
        paramView.setTag(paramViewGroup);
        if (paramInt != 0) {
          break label189;
        }
        paramViewGroup.a.setVisibility(8);
      }
      for (;;)
      {
        paramViewGroup.b.setText(this.a[paramInt].toString());
        paramViewGroup.c.setText(this.b[paramInt]);
        if (!paramBoolean) {
          break label201;
        }
        paramViewGroup.c.setText("");
        paramViewGroup.d.setImageDrawable(a.this.getResources().getDrawable(2130838315));
        return paramView;
        paramViewGroup = (a.b)paramView.getTag();
        break;
        label189:
        paramViewGroup.a.setVisibility(0);
      }
      label201:
      paramViewGroup.c.setText(this.b[paramInt]);
      paramViewGroup.d.setImageDrawable(a.this.getResources().getDrawable(2130838278));
      return paramView;
    }
    
    public boolean hasStableIds()
    {
      return false;
    }
    
    public boolean isChildSelectable(int paramInt1, int paramInt2)
    {
      return false;
    }
    
    public void onGroupCollapsed(int paramInt)
    {
      a.b(a.this, -1);
      a.a(a.this, paramInt);
      System.out.println("onGroupCollapsed");
    }
    
    public void onGroupExpanded(int paramInt)
    {
      a.a(a.this, -1);
      a.b(a.this, paramInt);
      System.out.println("onGroupExpanded");
    }
  }
  
  class b
  {
    ImageView a;
    TextView b;
    TextView c;
    ImageView d;
    
    b() {}
  }
  
  class c
  {
    TextView a;
    
    c() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/ui/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */