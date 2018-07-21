package com.baidu.carlife.wechat.b;

public class e
{
  private String a;
  private String b;
  private String c;
  
  public e(String paramString1, String paramString2, String paramString3)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3.replaceAll("amp;", "");
  }
  
  public String a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public String toString()
  {
    return "Music[" + this.a + "," + this.b + "," + this.c + "]";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/wechat/b/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */