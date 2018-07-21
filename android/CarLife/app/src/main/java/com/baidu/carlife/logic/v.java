package com.baidu.carlife.logic;

import android.content.Context;
import com.baidu.che.codriver.sdk.a.h.b;
import com.baidu.che.codriver.util.c;
import com.baidu.navi.fragment.ContentFragment;

public class v
  implements h.b
{
  private static final String a = v.class.getName();
  
  public boolean a()
  {
    int i = com.baidu.carlife.core.screen.presentation.h.a().getCurrentFragmentType();
    com.baidu.che.codriver.util.h.b(a, "isAtHomeFragment: " + i);
    if (531 == i)
    {
      com.baidu.che.codriver.util.h.b(a, "isAtHomeFragment: true");
      return true;
    }
    com.baidu.che.codriver.util.h.b(a, "isAtHomeFragment: fragment Error");
    return false;
  }
  
  public boolean a(int paramInt)
  {
    com.baidu.che.codriver.util.h.b(a, "doSelectCommand: " + paramInt);
    ContentFragment localContentFragment = com.baidu.carlife.core.screen.presentation.h.a().getCurrentFragment();
    if (localContentFragment == null)
    {
      com.baidu.che.codriver.util.h.b(a, "doSelectCommand: fragment Error");
      return false;
    }
    return localContentFragment.onVoiceCommand(paramInt);
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    com.baidu.che.codriver.util.h.b(a, "doCommand: " + paramString1);
    c.a().getString(2131296510);
    ContentFragment localContentFragment = com.baidu.carlife.core.screen.presentation.h.a().getCurrentFragment();
    if (localContentFragment == null)
    {
      com.baidu.che.codriver.util.h.b(a, "doCommand: fragment Error");
      return false;
    }
    String str;
    if ((!paramString1.startsWith("打开")) && (!paramString1.startsWith("前往")))
    {
      str = paramString1;
      if (!paramString1.startsWith("查看")) {}
    }
    else
    {
      str = paramString1.substring(2);
      com.baidu.che.codriver.util.h.b(a, "doCommand subCommand: " + str);
    }
    return localContentFragment.onVoiceCommand(str, paramString2);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/logic/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */