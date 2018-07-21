package com.tencent.a.a.a.a;

import android.content.Context;
import android.provider.Settings.System;
import android.util.Log;

public final class e
  extends f
{
  public e(Context paramContext)
  {
    super(paramContext);
  }
  
  protected final void a(String paramString)
  {
    try
    {
      Log.i("MID", "write mid to Settings.System");
      Settings.System.putString(this.a.getContentResolver(), h.c("4kU71lN96TJUomD1vOU9lgj9Tw=="), paramString);
      return;
    }
    finally {}
  }
  
  protected final boolean a()
  {
    return h.a(this.a, "android.permission.WRITE_SETTINGS");
  }
  
  protected final String b()
  {
    try
    {
      Log.i("MID", "read mid from Settings.System");
      String str = Settings.System.getString(this.a.getContentResolver(), h.c("4kU71lN96TJUomD1vOU9lgj9Tw=="));
      return str;
    }
    finally {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/tencent/a/a/a/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */