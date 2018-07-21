package com.baidu.sapi2.utils;

import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import javax.crypto.Cipher;
import javax.security.cert.X509Certificate;

public class b
{
  public static byte[] a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (TextUtils.isEmpty(paramString2))) {
      return null;
    }
    try
    {
      Cipher localCipher = Cipher.getInstance("RSA/NONE/NoPadding");
      localCipher.init(1, X509Certificate.getInstance(new ByteArrayInputStream(paramString2.getBytes())).getPublicKey());
      paramString1 = localCipher.doFinal(paramString1.getBytes("UTF-8"));
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      L.e(paramString1);
    }
    return null;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/sapi2/utils/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */