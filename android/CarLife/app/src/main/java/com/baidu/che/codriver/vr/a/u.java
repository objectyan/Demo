package com.baidu.che.codriver.vr.a;

import android.content.Context;
import com.baidu.che.codriver.protocol.data.nlp.NLPResponseData;
import com.baidu.che.codriver.vr.m;
import com.baidu.che.codriver.vr.p;

public class u
  extends a
{
  public static final String e = "ParkingCommand";
  private static int i;
  NLPResponseData f;
  String g;
  private Context h;
  
  public u(NLPResponseData paramNLPResponseData, m paramm, Context paramContext)
  {
    super(null, paramm, paramContext);
    this.f = paramNLPResponseData;
    this.h = paramContext;
    j();
  }
  
  public u(p paramp, m paramm, Context paramContext)
  {
    super(paramp, paramm, paramContext);
  }
  
  public void h() {}
  
  protected void j() {}
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/vr/a/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */