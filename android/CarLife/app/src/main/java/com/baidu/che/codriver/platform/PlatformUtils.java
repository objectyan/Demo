package com.baidu.che.codriver.platform;

import com.baidu.che.codriver.vr.e;

public class PlatformUtils
{
  public static int getCommandType(e parame)
  {
    if (parame == null) {
      return 16;
    }
    return getCommandType(parame.d());
  }
  
  private static int getCommandType(String paramString)
  {
    if (("codriver".equals(paramString)) || ("app".equals(paramString))) {
      return 1;
    }
    if (("music".equals(paramString)) || ("player".equals(paramString))) {
      return 4;
    }
    if (("navigate_instruction".equals(paramString)) || ("map".equals(paramString))) {
      return 8;
    }
    if ("telephone".equals(paramString)) {
      return 2;
    }
    return 16;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/platform/PlatformUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */