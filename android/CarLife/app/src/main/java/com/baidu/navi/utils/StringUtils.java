package com.baidu.navi.utils;

import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils
{
  public static boolean isCarPlate(String paramString)
  {
    boolean bool = false;
    if (!TextUtils.isEmpty(paramString)) {
      bool = Pattern.compile("^[\\u4e00-\\u9fa5]{1}[A-Z_0-9]{6,7}$").matcher(paramString).matches();
    }
    return bool;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/utils/StringUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */