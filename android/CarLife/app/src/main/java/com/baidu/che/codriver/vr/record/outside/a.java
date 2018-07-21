package com.baidu.che.codriver.vr.record.outside;

import com.baidu.che.codriver.util.h;
import com.baidu.che.codriver.vr.record.d;

public class a
  extends Thread
{
  private static final int a = 5000;
  private static final String b = "OutsideData";
  private com.baidu.che.codriver.vr.record.a c;
  private d d;
  
  public a(com.baidu.che.codriver.vr.record.a parama, d paramd)
  {
    this.c = parama;
    this.d = paramd;
    h.b("OutsideData", "--OutsideDataReceiver()----");
  }
  
  public void run()
  {
    byte[] arrayOfByte = new byte['ᎈ'];
    int i = 0;
    for (;;)
    {
      if (i != -1)
      {
        if (this.d == null) {
          this.c.a(null, 0, -1);
        }
      }
      else {
        return;
      }
      i = this.d.a(arrayOfByte);
      this.c.a(arrayOfByte, 0, i);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/vr/record/outside/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */