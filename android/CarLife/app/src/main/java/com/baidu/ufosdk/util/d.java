package com.baidu.ufosdk.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public final class d
{
  Context a;
  SharedPreferences b;
  SharedPreferences.Editor c;
  
  public d(Context paramContext)
  {
    this.a = paramContext;
    this.b = paramContext.getSharedPreferences("UfoSharePreference", 0);
    this.c = this.b.edit();
  }
  
  private int a(String paramString)
  {
    return this.b.getInt(paramString, 0);
  }
  
  private void a(String paramString, int paramInt)
  {
    this.c.putInt(paramString, paramInt);
    this.c.commit();
  }
  
  public final int a()
  {
    return a("editFeedbackView");
  }
  
  public final void a(int paramInt)
  {
    a("editFeedbackView", paramInt);
  }
  
  public final int b()
  {
    return a("editFeedbackWord");
  }
  
  public final void b(int paramInt)
  {
    a("editFeedbackWord", paramInt);
  }
  
  public final int c()
  {
    return a("editFeedbackPicture");
  }
  
  public final void c(int paramInt)
  {
    a("editFeedbackPicture", paramInt);
  }
  
  public final int d()
  {
    return a("myFeedback");
  }
  
  public final void d(int paramInt)
  {
    a("myFeedback", paramInt);
  }
  
  public final boolean e()
  {
    return (a("editFeedbackPicture") != 0) || (a("editFeedbackView") != 0) || (a("editFeedbackWord") != 0) || (a("myFeedback") != 0);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/util/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */