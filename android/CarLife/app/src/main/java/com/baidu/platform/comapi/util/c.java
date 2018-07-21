package com.baidu.platform.comapi.util;

import android.text.TextUtils;
import java.io.File;

public class c
{
  private static byte[] a = { 52, 77, 55, 32, 126, 67, 51, 30, 120, 98, 25, 37, 65, 113, 68, 116 };
  
  public static String a(String paramString)
    throws Exception
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("com file path empty!");
    }
    paramString = new File(paramString);
    if (!paramString.exists()) {}
    do
    {
      do
      {
        return null;
        paramString = MD5.getFileMD5String(paramString);
      } while (TextUtils.isEmpty(paramString));
      f.e("ComSecure", "file md5>>" + paramString);
      paramString = a.a(new String(a), paramString.getBytes());
    } while (paramString == null);
    String str = b.a(paramString);
    f.e("ComSecure", "md5 aes>>" + new String(paramString));
    f.e("ComSecure", "aes b64>>" + str);
    return str;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/util/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */