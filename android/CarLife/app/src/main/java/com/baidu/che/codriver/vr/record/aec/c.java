package com.baidu.che.codriver.vr.record.aec;

public class c
  implements com.baidu.che.codriver.vr.record.d
{
  private d a;
  
  public int a(byte[] paramArrayOfByte)
  {
    return -1;
  }
  
  public void a()
  {
    if ((this.a != null) && (this.a.isAlive())) {
      this.a.a();
    }
  }
  
  public void b()
  {
    if ((this.a != null) && (this.a.isAlive())) {
      this.a.b();
    }
  }
  
  public void c()
  {
    if ((this.a == null) || (!this.a.isAlive())) {
      this.a = new d();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/vr/record/aec/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */