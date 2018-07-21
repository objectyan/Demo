package com.baidu.carlife.logic;

import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.baidu.carlife.core.a;
import com.baidu.carlife.core.screen.presentation.h;

public class u
{
  public static SpannableString a(String paramString)
  {
    paramString = new SpannableString(paramString);
    a(paramString);
    return paramString;
  }
  
  private static void a(SpannableString paramSpannableString)
  {
    s locals = new s(17, 23);
    a(paramSpannableString, locals, Color.parseColor("#FF000000"));
    a(paramSpannableString, locals, new a()
    {
      public void a()
      {
        u.a(a.a().getString(2131297137), "file:///android_asset/carlifeDisclaimer.html");
      }
    });
    locals = new s(24, 30);
    a(paramSpannableString, locals, Color.parseColor("#FF000000"));
    a(paramSpannableString, locals, new a()
    {
      public void a()
      {
        u.a(a.a().getString(2131296858), "https://www.baidu.com/duty/wise/wise_secretright.html");
      }
    });
  }
  
  private static void a(SpannableString paramSpannableString, s params, int paramInt)
  {
    paramSpannableString.setSpan(new ForegroundColorSpan(paramInt), params.a(), params.b(), 33);
  }
  
  private static void a(SpannableString paramSpannableString, s params, a parama)
  {
    paramSpannableString.setSpan(new n()
    {
      public void onClick(View paramAnonymousView)
      {
        if (this.a != null) {
          this.a.a();
        }
      }
    }, params.a(), params.b(), 33);
  }
  
  private static void b(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("bundle_title_key", paramString1);
    localBundle.putString("bundle_url_key", paramString2);
    h.a().showFragment(517, localBundle);
  }
  
  public static abstract interface a
  {
    public abstract void a();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/logic/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */