package com.baidu.che.codriver.ui.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.volley.toolbox.NetworkImageView;
import com.baidu.che.codriver.widget.SwitchPageLayout;
import com.baidu.che.codriver.widget.d;
import com.baidu.che.codriver.widget.e;
import com.baidu.sapi2.SapiWebView;
import java.util.List;

public class b
  extends BaseAdapter
{
  private static final String a = "ConversationAdapter";
  private List<com.baidu.che.codriver.ui.d.b> b;
  private e c = d.a();
  private int d;
  
  public b(Context paramContext, List<com.baidu.che.codriver.ui.d.b> paramList)
  {
    this.b = paramList;
  }
  
  public e a()
  {
    return this.c;
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void a(e parame)
  {
    this.c = parame;
  }
  
  public int b()
  {
    return this.d;
  }
  
  public int getCount()
  {
    if (this.b != null) {
      return this.b.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.b != null) {
      return this.b.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (this.b != null) {
      return ((com.baidu.che.codriver.ui.d.b)this.b.get(paramInt)).f.ordinal();
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    com.baidu.che.codriver.ui.d.b localb = (com.baidu.che.codriver.ui.d.b)getItem(paramInt);
    com.baidu.che.codriver.ui.c.b localb1 = com.baidu.che.codriver.ui.c.b.a(((com.baidu.che.codriver.ui.d.b)this.b.get(paramInt)).f);
    localb1.a(localb);
    paramView = localb1.a(paramViewGroup, paramView);
    if ((paramView instanceof SwitchPageLayout))
    {
      a((SwitchPageLayout)paramView);
      a(paramInt);
    }
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return com.baidu.che.codriver.ui.d.b.a.values().length;
  }
  
  public static class a
    extends b.d
  {
    TextView a;
    TextView b;
    TextView c;
    TextView d;
    TextView e;
    NetworkImageView f;
  }
  
  public static class b
    extends b.d
  {
    public TextView a;
    public SapiWebView b;
    public ImageView c;
  }
  
  public static class c
    extends b.d
  {
    public TextView a;
  }
  
  public static class d {}
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/ui/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */