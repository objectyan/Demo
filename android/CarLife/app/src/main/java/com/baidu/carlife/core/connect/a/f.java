package com.baidu.carlife.core.connect.a;

import android.util.Base64;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

public class f
{
  public String a(String paramString, PublicKey paramPublicKey)
  {
    try
    {
      Cipher localCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
      localCipher.init(1, paramPublicKey);
      localCipher.update(paramString.getBytes("UTF-8"));
      paramString = Base64.encodeToString(localCipher.doFinal(), 2);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public PublicKey a(String paramString)
  {
    paramString = new X509EncodedKeySpec(Base64.decode(paramString, 2));
    try
    {
      paramString = KeyFactory.getInstance("RSA").generatePublic(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/core/connect/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */