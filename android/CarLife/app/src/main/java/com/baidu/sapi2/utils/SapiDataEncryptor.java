package com.baidu.sapi2.utils;

import android.text.TextUtils;
import com.baidu.android.common.security.Base64;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.security.cert.CertificateException;
import javax.security.cert.X509Certificate;
import org.json.JSONArray;

public class SapiDataEncryptor
{
  public static final String a = TextUtils.join("", new String[] { "b", "a", "i", "d", "u", "v", "o", "i", "c", "e", "3", "5", "h", "y", "1", "2" });
  public static final String b = TextUtils.join("", new String[] { "b", "a", "i", "d", "u", "f", "a", "c", "e", "D", "z", "T", "9", "9", "1", "1" });
  private static final String c = "0123456789ABCDEF";
  private String d = "kf1t9tsczk16vc8z";
  private a e = new a();
  
  public static String a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfByte[i];
      localStringBuilder.append("0123456789ABCDEF".charAt(k >> 4 & 0xF)).append("0123456789ABCDEF".charAt(k & 0xF));
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private byte[] a(Key paramKey, byte[] paramArrayOfByte)
    throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException
  {
    Cipher localCipher = Cipher.getInstance("RSA/NONE/PKCS1Padding");
    localCipher.init(1, paramKey);
    return localCipher.doFinal(paramArrayOfByte);
  }
  
  private String b()
  {
    Random localRandom = new Random();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < 16)
    {
      localStringBuilder.append("abcdefghijklmnopqrstuvwxyz0123456789".charAt(localRandom.nextInt("abcdefghijklmnopqrstuvwxyz0123456789".length())));
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String b(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = Base64.decode(paramString1.getBytes());
      String str = new StringBuffer(paramString2).reverse().toString();
      paramString1 = new String(new a().a(paramString1, str, paramString2), "UTF-8").trim();
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      L.e(paramString1);
    }
    return "";
  }
  
  public static byte[] b(String paramString)
  {
    int j = paramString.length() / 2;
    byte[] arrayOfByte = new byte[j];
    int i = 0;
    while (i < j)
    {
      arrayOfByte[i] = Integer.valueOf(paramString.substring(i * 2, i * 2 + 2), 16).byteValue();
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static String c(String paramString1, String paramString2)
  {
    try
    {
      String str = new StringBuffer(paramString2).reverse().toString();
      paramString1 = Base64.encode(new a().a(paramString1, str, paramString2), "UTF-8");
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      L.e(paramString1);
    }
    return "";
  }
  
  public static String encryptPwd(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      paramString = b.a(String.valueOf(TextUtils.getReverse(paramString, 0, paramString.length())), "-----BEGIN CERTIFICATE-----\nMIIChzCCAfACAQAwDQYJKoZIhvcNAQEEBQAwgYsxCzAJBgNVBAYTAkNOMRAwDgYD\nVQQIEwdiZWlqaW5nMRAwDgYDVQQHEwdiZWlqaW5nMQ4wDAYDVQQKEwViYWlkdTEO\nMAwGA1UECxMFYmFpZHUxFjAUBgNVBAMTDXd3dy5iYWlkdS5jb20xIDAeBgkqhkiG\n9w0BCQEWEXBhc3MtcmRAYmFpZHUuY29tMB4XDTEzMDMyMjA5NTYyM1oXDTIzMDMy\nMDA5NTYyM1owgYsxCzAJBgNVBAYTAkNOMRAwDgYDVQQIEwdiZWlqaW5nMRAwDgYD\nVQQHEwdiZWlqaW5nMQ4wDAYDVQQKEwViYWlkdTEOMAwGA1UECxMFYmFpZHUxFjAU\nBgNVBAMTDXd3dy5iYWlkdS5jb20xIDAeBgkqhkiG9w0BCQEWEXBhc3MtcmRAYmFp\nZHUuY29tMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCzxh67pGWcTONjkofu\nhx8fSPeTDql3mRx6/jzEQv6klkMhLn1XDIU/NoBlzFeiAUZm2orn1JP9R9FxwNiU\n7uPtf5n2eYt//XtYcyJwOK0j4xl2MajLZCITufJ9SQGrDZK/onVCrokIVTlu2Sd1\nJVyXf1wwLx5+1LHjacEstrGCLwIDAQABMA0GCSqGSIb3DQEBBAUAA4GBAFaJ31WX\nD5F1MOFVQtK5Z22eaClL1NZaqjlt7IC22ovWhfO836K07YrYgF97w3DdAsJxXpG+\ny/y8HAvAnPN5IzI1Or6nMgEVZLawkkbvttbcAkhW4fleZPsn06aVYZ1sSxQok/k/\nZOj/cz22nU8JgmiJL0ZChHeHyC3VusOHtUW3\n-----END CERTIFICATE-----");
    } while (paramString == null);
    return a(paramString);
  }
  
  public String a()
  {
    return this.d;
  }
  
  public String a(String paramString)
    throws Exception
  {
    paramString = Base64.decode(paramString.getBytes());
    String str = new StringBuffer(this.d).reverse().toString();
    return new String(this.e.a(paramString, str, this.d), "UTF-8");
  }
  
  public String a(String paramString1, String paramString2)
    throws CertificateException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return null;
    }
    paramString1 = X509Certificate.getInstance(new ByteArrayInputStream(paramString1.getBytes())).getPublicKey();
    JSONArray localJSONArray = new JSONArray();
    paramString2 = paramString2.getBytes("UTF-8");
    int i;
    int j;
    if (paramString2.length % 116 == 0)
    {
      i = paramString2.length / 116;
      j = 0;
      label67:
      if (j >= i) {
        break label215;
      }
      if (1 != i) {
        break label115;
      }
      localJSONArray.put(Base64.encode(a(paramString1, paramString2), "UTF-8"));
    }
    for (;;)
    {
      j += 1;
      break label67;
      i = paramString2.length / 116 + 1;
      break;
      label115:
      byte[] arrayOfByte;
      if (j != i - 1)
      {
        arrayOfByte = new byte[116];
        System.arraycopy(paramString2, j * 116, arrayOfByte, 0, 116);
        localJSONArray.put(Base64.encode(a(paramString1, arrayOfByte), "UTF-8"));
      }
      else
      {
        int k = paramString2.length - j * 116;
        arrayOfByte = new byte[k];
        System.arraycopy(paramString2, j * 116, arrayOfByte, 0, k);
        localJSONArray.put(Base64.encode(a(paramString1, arrayOfByte), "UTF-8"));
      }
    }
    label215:
    return Base64.encode(localJSONArray.toString().getBytes("UTF-8"), "UTF-8");
  }
  
  public static class a
  {
    public static final int a = 1;
    public static final String b = "-----BEGIN CERTIFICATE-----\nMIIFKDCCBBCgAwIBAgIQaG9YabPddabIY+N5IoXttzANBgkqhkiG9w0BAQUFADCB\nvDELMAkGA1UEBhMCVVMxFzAVBgNVBAoTDlZlcmlTaWduLCBJbmMuMR8wHQYDVQQL\nExZWZXJpU2lnbiBUcnVzdCBOZXR3b3JrMTswOQYDVQQLEzJUZXJtcyBvZiB1c2Ug\nYXQgaHR0cHM6Ly93d3cudmVyaXNpZ24uY29tL3JwYSAoYykxMDE2MDQGA1UEAxMt\nVmVyaVNpZ24gQ2xhc3MgMyBJbnRlcm5hdGlvbmFsIFNlcnZlciBDQSAtIEczMB4X\nDTEwMTIwMzAwMDAwMFoXDTEyMTIwMjIzNTk1OVowga8xCzAJBgNVBAYTAkNOMRAw\nDgYDVQQIEwdCZWlqaW5nMRAwDgYDVQQHFAdCZWlqaW5nMTkwNwYDVQQKFDBCZWlK\naW5nIEJhaWR1IE5ldGNvbSBTY2llbmNlIFRlY2hub2xvZ3kgQ28uLCBMdGQxJTAj\nBgNVBAsUHHNlcnZpY2Ugb3BlcmF0aW9uIGRlcGFydG1lbnQxGjAYBgNVBAMUEW9w\nZW5hcGkuYmFpZHUuY29tMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC68R1G\nWkkVvvjBOGKHOoyLxdtEcxBiVOGG8lvXTckB8jNrg4tihQzql+fJbr/X8V9MqQLw\nzzOyQViYlW+/GhC6u1jrP6t3Br0Wy8HyThDnvOAWyPFEawgbIywT20F41Iqayled\n/DQ/JCDWcNA7+xX56rqEcQd+6baNAiu9o962PwIDAQABo4IBszCCAa8wCQYDVR0T\nBAIwADALBgNVHQ8EBAMCBaAwQQYDVR0fBDowODA2oDSgMoYwaHR0cDovL1NWUklu\ndGwtRzMtY3JsLnZlcmlzaWduLmNvbS9TVlJJbnRsRzMuY3JsMEQGA1UdIAQ9MDsw\nOQYLYIZIAYb4RQEHFwMwKjAoBggrBgEFBQcCARYcaHR0cHM6Ly93d3cudmVyaXNp\nZ24uY29tL3JwYTAoBgNVHSUEITAfBglghkgBhvhCBAEGCCsGAQUFBwMBBggrBgEF\nBQcDAjByBggrBgEFBQcBAQRmMGQwJAYIKwYBBQUHMAGGGGh0dHA6Ly9vY3NwLnZl\ncmlzaWduLmNvbTA8BggrBgEFBQcwAoYwaHR0cDovL1NWUkludGwtRzMtYWlhLnZl\ncmlzaWduLmNvbS9TVlJJbnRsRzMuY2VyMG4GCCsGAQUFBwEMBGIwYKFeoFwwWjBY\nMFYWCWltYWdlL2dpZjAhMB8wBwYFKw4DAhoEFEtruSiWBgy70FI4mymsSweLIQUY\nMCYWJGh0dHA6Ly9sb2dvLnZlcmlzaWduLmNvbS92c2xvZ28xLmdpZjANBgkqhkiG\n9w0BAQUFAAOCAQEAgNIl8/QIKP4KWWWj6ltL6lVknoGlpUIoowvnv+57H7FdEYJb\n9zQewrAqoFkblB0mMiUEGdJOa7YxKKJialqz6KnlMrHQMAsB641BHLDESvLjuhio\nUsWmvBowIK92HQ2H9N01U8d1i5rTz5wwFK+Nvue/61tzCTTmbRgBuGPotQ/tcA+g\nYCNuEIHsJMbWiX9O3gflnMdRME7z9Hw9zMogt+lz7GudP/AO1K6sZ6VnQ931Gv1e\nIOmPCPfvO/Kw/aXSacoEWnMsy+qTIewVPT/MMgSaq9JewAQgLpMX+O5qqAJBYoDj\nxoZnHufGgOIKfNmSvYiHjDFJtP55PdEH21q+JA==\n-----END CERTIFICATE-----";
  }
  
  public static class b
  {
    public static final int a = 2;
    public static final String b = "-----BEGIN CERTIFICATE-----\nMIIChzCCAfACAQAwDQYJKoZIhvcNAQEEBQAwgYsxCzAJBgNVBAYTAkNOMRAwDgYD\nVQQIEwdiZWlqaW5nMRAwDgYDVQQHEwdiZWlqaW5nMQ4wDAYDVQQKEwViYWlkdTEO\nMAwGA1UECxMFYmFpZHUxFjAUBgNVBAMTDXd3dy5iYWlkdS5jb20xIDAeBgkqhkiG\n9w0BCQEWEXBhc3MtcmRAYmFpZHUuY29tMB4XDTEzMDMyMjA5NTYyM1oXDTIzMDMy\nMDA5NTYyM1owgYsxCzAJBgNVBAYTAkNOMRAwDgYDVQQIEwdiZWlqaW5nMRAwDgYD\nVQQHEwdiZWlqaW5nMQ4wDAYDVQQKEwViYWlkdTEOMAwGA1UECxMFYmFpZHUxFjAU\nBgNVBAMTDXd3dy5iYWlkdS5jb20xIDAeBgkqhkiG9w0BCQEWEXBhc3MtcmRAYmFp\nZHUuY29tMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCzxh67pGWcTONjkofu\nhx8fSPeTDql3mRx6/jzEQv6klkMhLn1XDIU/NoBlzFeiAUZm2orn1JP9R9FxwNiU\n7uPtf5n2eYt//XtYcyJwOK0j4xl2MajLZCITufJ9SQGrDZK/onVCrokIVTlu2Sd1\nJVyXf1wwLx5+1LHjacEstrGCLwIDAQABMA0GCSqGSIb3DQEBBAUAA4GBAFaJ31WX\nD5F1MOFVQtK5Z22eaClL1NZaqjlt7IC22ovWhfO836K07YrYgF97w3DdAsJxXpG+\ny/y8HAvAnPN5IzI1Or6nMgEVZLawkkbvttbcAkhW4fleZPsn06aVYZ1sSxQok/k/\nZOj/cz22nU8JgmiJL0ZChHeHyC3VusOHtUW3\n-----END CERTIFICATE-----";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/sapi2/utils/SapiDataEncryptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */