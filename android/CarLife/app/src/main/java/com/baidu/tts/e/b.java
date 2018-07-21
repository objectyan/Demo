package com.baidu.tts.e;

import android.content.Context;

public class b
  extends Thread
{
  private Context a;
  private String b;
  
  public b(Context paramContext, String paramString)
  {
    this.a = paramContext;
    this.b = paramString;
  }
  
  public void run()
  {
    a.a(this.a, this.b);
    this.a = null;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/e/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */