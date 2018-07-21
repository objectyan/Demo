package com.baidu.carlife.logic.a;

import com.baidu.carlife.l.a;
import com.baidu.carlife.logic.music.r;
import com.baidu.che.codriver.sdk.a.n;
import com.baidu.che.codriver.sdk.a.n.a;
import com.baidu.che.codriver.sdk.a.n.b;
import com.baidu.navi.util.StatisticManager;

public class h
  implements n
{
  public void a()
  {
    com.baidu.carlife.logic.music.h.b().s().z();
    if (!a.a().N()) {
      StatisticManager.onEvent("VOICE_PHONE_0004");
    }
  }
  
  public void a(n.b paramb, n.a parama)
  {
    com.baidu.carlife.logic.music.h.b().s().a(paramb.e, parama);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/logic/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */