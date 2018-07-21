package com.baidu.carlife.logic.b.a;

import android.content.res.Resources;
import com.baidu.carlife.c.d.c;
import com.baidu.carlife.logic.b.b.a.a;
import java.util.ArrayList;
import java.util.List;

public class a
  extends com.baidu.carlife.c.b.a<com.baidu.carlife.logic.b.b.a>
{
  private com.baidu.carlife.logic.b.b.a a(String paramString)
  {
    c localc = new c();
    localc.b(paramString);
    paramString = new c();
    paramString.b(Integer.valueOf(2130968871));
    return a.a.a().a(paramString).c(localc).e(com.baidu.carlife.c.g.a.a(Boolean.valueOf(false))).c();
  }
  
  public List<com.baidu.carlife.logic.b.b.a> c()
  {
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = com.baidu.carlife.core.a.a().getResources().getStringArray(2131230727);
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(com.baidu.carlife.c.g.a.a(a(arrayOfString[i]), "SettingItem should not be null!"));
      i += 1;
    }
    return localArrayList;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/logic/b/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */