package com.indooratlas.android.sdk._internal;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

final class fj
  implements fh
{
  public final String a(String paramString1, String paramString2)
  {
    try
    {
      paramString2 = paramString2.trim().getBytes("UTF-8");
      paramString1 = new SecretKeySpec(paramString1.getBytes("UTF-8"), "HmacSHA256");
      Mac localMac = Mac.getInstance("HmacSHA256");
      localMac.init(paramString1);
      paramString1 = new String(jh.a(localMac.doFinal(paramString2)));
      return paramString1;
    }
    catch (InvalidKeyException paramString1)
    {
      paramString1.printStackTrace();
      return null;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
      }
    }
    catch (NoSuchAlgorithmException paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
      }
    }
    catch (IllegalStateException paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  public final String a(byte[] paramArrayOfByte)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-256");
      localMessageDigest.update(paramArrayOfByte);
      paramArrayOfByte = new String(jh.a(localMessageDigest.digest()));
      return paramArrayOfByte;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/fj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */