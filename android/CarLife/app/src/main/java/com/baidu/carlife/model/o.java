package com.baidu.carlife.model;

import android.text.TextUtils;

public class o
{
  public static final int f = 0;
  public int g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  public String m;
  public String n;
  
  public String a()
  {
    if (TextUtils.isEmpty(this.n)) {
      return null;
    }
    return "com.baidu.carlife.platform." + this.n;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof o)) {
        break;
      }
      paramObject = (o)paramObject;
    } while ((!TextUtils.isEmpty(this.m)) && (this.m.equals(((o)paramObject).m)));
    return false;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/model/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */