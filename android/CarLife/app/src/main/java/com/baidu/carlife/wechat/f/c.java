package com.baidu.carlife.wechat.f;

import android.text.TextUtils;
import com.baidu.carlife.core.screen.presentation.h;
import com.baidu.carlife.wechat.b.b;
import com.baidu.carlife.wechat.b.i;
import com.baidu.carlife.wechat.b.k;
import com.baidu.che.codriver.sdk.a.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class c
  implements p
{
  public List<com.baidu.che.codriver.sdk.b.a> a(String paramString)
  {
    Object localObject = com.baidu.carlife.wechat.b.c.a().c(paramString);
    paramString = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      b localb = (b)((Iterator)localObject).next();
      paramString.add(new com.baidu.che.codriver.sdk.b.a(localb.a(), localb.b()));
    }
    return paramString;
  }
  
  public void a(com.baidu.che.codriver.sdk.b.a parama, String paramString)
  {
    parama = com.baidu.carlife.wechat.b.c.a().b(parama.c());
    k.a().a(true);
    com.baidu.carlife.wechat.c.a.a().a(parama, paramString);
  }
  
  public boolean a()
  {
    return !TextUtils.isEmpty(com.baidu.carlife.wechat.b.c.a().f().d());
  }
  
  public boolean b()
  {
    return com.baidu.carlife.core.b.a.c();
  }
  
  public void c()
  {
    h.a().showFragment(585, null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/wechat/f/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */