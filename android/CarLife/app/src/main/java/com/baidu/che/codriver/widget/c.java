package com.baidu.che.codriver.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.android.volley.toolbox.NetworkImageView;
import com.baidu.che.codriver.util.a;
import com.baidu.che.codriver.vr.ImageSearchData;
import com.baidu.che.codriver.vr.ImageSearchData.ImageDetail;
import com.baidu.che.codriver.vr.a.g;
import java.util.List;

public class c
  implements View.OnClickListener, com.baidu.che.codriver.ui.a.h
{
  private int a = 1;
  private g b;
  private int c = 0;
  private Context d;
  
  public c(Context paramContext)
  {
    this.d = paramContext;
  }
  
  private void c() {}
  
  public int a()
  {
    return (int)Math.ceil(this.b.a.list.size() / this.a);
  }
  
  public View a(int paramInt)
  {
    ViewGroup localViewGroup = (ViewGroup)LayoutInflater.from(this.d).inflate(2130968866, null);
    ((NetworkImageView)localViewGroup.findViewById(2131625364)).setImageUrl(((ImageSearchData.ImageDetail)this.b.a.list.get(paramInt)).bigImage, a.a());
    com.baidu.che.codriver.util.h.c("sanba", "imagesearchurl:" + ((ImageSearchData.ImageDetail)this.b.a.list.get(paramInt)).smailImage);
    c();
    return localViewGroup;
  }
  
  public void a(g paramg)
  {
    this.b = paramg;
  }
  
  public int b()
  {
    return this.c;
  }
  
  public void b(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void onClick(View paramView) {}
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/widget/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */