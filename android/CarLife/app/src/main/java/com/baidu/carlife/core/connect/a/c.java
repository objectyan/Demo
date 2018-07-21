package com.baidu.carlife.core.connect.a;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.widget.Toast;
import com.baidu.carlife.core.j;
import com.baidu.carlife.core.k;

public class c
{
  private static final boolean a = false;
  private static c b;
  private static final int c = 2222222;
  private static final String d = "key";
  private Context e;
  private a f = new a(null);
  
  private c()
  {
    k.a(this.f);
  }
  
  public static c a()
  {
    if (b == null) {
      b = new c();
    }
    return b;
  }
  
  public void a(Context paramContext)
  {
    this.e = paramContext;
  }
  
  public void a(String paramString) {}
  
  private class a
    extends j
  {
    private a() {}
    
    public void careAbout()
    {
      addMsg(2222222);
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        return;
      }
      Toast.makeText(c.a(c.this), paramMessage.getData().getString("key"), 0).show();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/core/connect/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */