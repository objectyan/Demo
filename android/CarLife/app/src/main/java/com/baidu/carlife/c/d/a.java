package com.baidu.carlife.c.d;

import android.annotation.SuppressLint;
import android.app.Application;
import android.support.annotation.NonNull;

public class a
  extends f
{
  @SuppressLint({"StaticFieldLeak"})
  private Application a;
  
  public a(@NonNull Application paramApplication)
  {
    this.a = paramApplication;
  }
  
  @NonNull
  public <T extends Application> T a()
  {
    return this.a;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/c/d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */