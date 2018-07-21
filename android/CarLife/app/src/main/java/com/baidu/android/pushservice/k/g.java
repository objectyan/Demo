package com.baidu.android.pushservice.k;

import android.annotation.SuppressLint;
import java.security.Key;
import java.security.KeyFactory;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

public final class g
{
  public static boolean a(byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    try
    {
      paramString2 = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(b.a(paramString2.getBytes())));
      Signature localSignature = Signature.getInstance("SHA1WithRSA");
      localSignature.initVerify(paramString2);
      localSignature.update(paramArrayOfByte);
      boolean bool = localSignature.verify(b.a(paramString1.getBytes()));
      return bool;
    }
    catch (Exception paramArrayOfByte) {}
    return false;
  }
  
  @SuppressLint({"InlinedApi", "OldTargetApi"})
  public static byte[] a(byte[] paramArrayOfByte, String paramString)
    throws Exception
  {
    paramString = new PKCS8EncodedKeySpec(b.a(paramString.getBytes()));
    paramString = KeyFactory.getInstance("RSA").generatePrivate(paramString);
    Cipher localCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
    localCipher.init(2, paramString);
    return localCipher.doFinal(paramArrayOfByte);
  }
  
  @SuppressLint({"InlinedApi", "OldTargetApi"})
  public static byte[] b(byte[] paramArrayOfByte, String paramString)
    throws Exception
  {
    paramString = new X509EncodedKeySpec(b.a(paramString.getBytes()));
    paramString = KeyFactory.getInstance("RSA").generatePublic(paramString);
    Cipher localCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
    localCipher.init(1, paramString);
    return localCipher.doFinal(paramArrayOfByte);
  }
  
  @SuppressLint({"InlinedApi", "OldTargetApi"})
  public static byte[] c(byte[] paramArrayOfByte, String paramString)
    throws Exception
  {
    paramString = new X509EncodedKeySpec(b.a(paramString.getBytes()));
    Object localObject = KeyFactory.getInstance("RSA").generatePublic(paramString);
    paramString = Cipher.getInstance("RSA/ECB/PKCS1Padding");
    paramString.init(1, (Key)localObject);
    int n = paramArrayOfByte.length;
    localObject = new byte[(n + 117 - 1) / 117 * 128];
    int i = 0;
    int j = 0;
    while (j < n)
    {
      int m = n - j;
      int k = m;
      if (117 < m) {
        k = 117;
      }
      byte[] arrayOfByte = new byte[k];
      System.arraycopy(paramArrayOfByte, j, arrayOfByte, 0, k);
      j += k;
      System.arraycopy(paramString.doFinal(arrayOfByte), 0, localObject, i, 128);
      i += 128;
    }
    return (byte[])localObject;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/k/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */