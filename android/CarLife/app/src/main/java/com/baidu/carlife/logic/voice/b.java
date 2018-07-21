package com.baidu.carlife.logic.voice;

import android.content.res.Resources;
import com.baidu.carlife.core.a;
import com.baidu.carlife.core.screen.presentation.h;

public class b
{
  public static String a()
  {
    return a(b());
  }
  
  private static String a(int paramInt)
  {
    String[] arrayOfString = a.a().getResources().getStringArray(paramInt);
    return arrayOfString[new java.util.Random().nextInt(arrayOfString.length)];
  }
  
  private static int b()
  {
    int i = h.a().getCurrentFragmentType();
    if (h.a().a(i)) {
      return 2131230788;
    }
    if (h.a().d(i)) {
      return 2131230784;
    }
    if (h.a().b(i)) {
      return 2131230785;
    }
    if (h.a().e(i)) {
      return 2131230787;
    }
    return 2131230786;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/logic/voice/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */