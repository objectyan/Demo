package com.baidu.che.codriver.sdk.a;

import android.view.KeyEvent;
import com.baidu.che.codriver.util.h;

public class d
{
  private a a;
  
  public static d a()
  {
    return b.a();
  }
  
  public void a(a parama)
  {
    this.a = parama;
  }
  
  public void a(String paramString1, String paramString2)
  {
    h.e("CdHardKeyManager", "param:" + paramString1 + ";data:" + paramString2);
    l.a().a("hardkey.tool", paramString1, paramString2);
  }
  
  public a b()
  {
    return this.a;
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt);
    
    public abstract void a(int paramInt, KeyEvent paramKeyEvent);
    
    public abstract void b(int paramInt);
    
    public abstract void b(int paramInt, KeyEvent paramKeyEvent);
  }
  
  private static class b
  {
    private static d a = new d();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/sdk/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */