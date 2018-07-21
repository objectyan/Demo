package com.baidu.sapi2.utils.enums;

import android.text.TextUtils;

public enum RegistMode
{
  private String a;
  
  private RegistMode(String paramString)
  {
    this.a = paramString;
  }
  
  public static RegistMode getDefault()
  {
    return NORMAL;
  }
  
  public static RegistMode mapStrToValue(String paramString)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString))
    {
      localObject = getDefault();
      return (RegistMode)localObject;
    }
    RegistMode[] arrayOfRegistMode = values();
    int j = arrayOfRegistMode.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label57;
      }
      RegistMode localRegistMode = arrayOfRegistMode[i];
      localObject = localRegistMode;
      if (paramString.equals(localRegistMode.getStrValue())) {
        break;
      }
      i += 1;
    }
    label57:
    return getDefault();
  }
  
  public String getStrValue()
  {
    return this.a;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/sapi2/utils/enums/RegistMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */