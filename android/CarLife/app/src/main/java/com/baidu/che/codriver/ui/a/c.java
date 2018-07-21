package com.baidu.che.codriver.ui.a;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.baidu.che.codriver.protocol.data.nlp.CinemaData;
import com.baidu.che.codriver.protocol.data.nlp.CinemaData.CinemaBean;
import com.baidu.che.codriver.widget.CinemaBillView;
import com.baidu.che.codriver.widget.CinemaBillView.a;
import java.util.List;

public class c
  implements h
{
  public static final int a = 3;
  private CinemaData b;
  private Context c;
  
  public c(Context paramContext)
  {
    this.c = paramContext;
  }
  
  public int a()
  {
    return (int)Math.ceil(this.b.list.size() / 3.0F);
  }
  
  public View a(int paramInt)
  {
    if (paramInt == a() - 1) {}
    LinearLayout localLinearLayout;
    LinearLayout.LayoutParams localLayoutParams;
    Object localObject;
    for (int i = this.b.list.size() - paramInt * 3;; i = 3)
    {
      localLinearLayout = new LinearLayout(this.c);
      localLinearLayout.setOrientation(0);
      localLayoutParams = new LinearLayout.LayoutParams(-1, -2, 0.0F);
      localLinearLayout.setLayoutParams(localLayoutParams);
      int j = 0;
      while (j < i)
      {
        localObject = new CinemaBillView(this.c);
        localLayoutParams = new LinearLayout.LayoutParams(0, -2, 1.0F);
        localLayoutParams.setMargins(0, com.baidu.che.codriver.util.c.a(this.c, 15.0F), 0, 0);
        ((CinemaBillView)localObject).setLayoutParams(localLayoutParams);
        CinemaData.CinemaBean localCinemaBean = (CinemaData.CinemaBean)this.b.list.get(paramInt * 3 + j);
        CinemaBillView.a locala = (CinemaBillView.a)((CinemaBillView)localObject).getTag(2131296544);
        if (locala != null)
        {
          locala.a(localCinemaBean.name);
          locala.b(localCinemaBean.score);
          locala.c(localCinemaBean.post);
        }
        localLinearLayout.addView((View)localObject);
        j += 1;
      }
    }
    i = 3 - i;
    if (i > 0)
    {
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = new View(this.c);
        ((View)localObject).setLayoutParams(localLayoutParams);
        localLinearLayout.addView((View)localObject);
        paramInt += 1;
      }
    }
    localLinearLayout.setBackgroundColor(Color.parseColor("#0FFFFFFF"));
    return localLinearLayout;
  }
  
  public void a(CinemaData paramCinemaData)
  {
    this.b = paramCinemaData;
  }
  
  public int b()
  {
    return this.b.curPage;
  }
  
  public void b(int paramInt)
  {
    this.b.curPage = paramInt;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/ui/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */