package com.baidu.che.codriver.vr;

import android.text.TextUtils;

public class l
{
  private String a;
  private b b;
  
  public l(String paramString, b paramb)
  {
    this.a = paramString;
    this.b = paramb;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return (this.a + ",").contains(paramString + ",");
  }
  
  public void b(String paramString)
  {
    if (this.b != null) {
      this.b.a(paramString);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/vr/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */