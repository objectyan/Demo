package com.baidu.carlife.a;

import android.util.Base64;
import com.baidu.carlife.core.e;
import com.baidu.carlife.core.f;
import java.security.PublicKey;
import java.security.cert.Certificate;
import javax.crypto.Cipher;

public class b
{
  private static final String a = b.class.getSimpleName();
  private static b b;
  private static final String c = "public.der";
  private static final String d = f.jm + "/" + "public.der";
  private static final String e = "123456";
  private static final String f = "X.509";
  private static final String g = "RSA/ECB/PKCS1Padding";
  private PublicKey h;
  
  private b()
  {
    e.a().a("public.der", d);
    try
    {
      this.h = a(a(d, "X.509"));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static b a()
  {
    if (b == null) {
      b = new b();
    }
    return b;
  }
  
  private String a(String paramString, PublicKey paramPublicKey)
  {
    try
    {
      paramString = Base64.decode(paramString, 2);
      Cipher localCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
      localCipher.init(2, paramPublicKey);
      paramString = new String(localCipher.doFinal(paramString), "UTF-8");
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private PublicKey a(Certificate paramCertificate)
  {
    return paramCertificate.getPublicKey();
  }
  
  /* Error */
  private java.security.cert.X509Certificate a(String paramString1, String paramString2)
    throws java.io.IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aload 5
    //   8: astore_3
    //   9: aload_2
    //   10: invokestatic 122	java/security/cert/CertificateFactory:getInstance	(Ljava/lang/String;)Ljava/security/cert/CertificateFactory;
    //   13: astore_2
    //   14: aload 5
    //   16: astore_3
    //   17: new 124	java/io/FileInputStream
    //   20: dup
    //   21: aload_1
    //   22: invokespecial 127	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   25: astore_1
    //   26: aload_2
    //   27: aload_1
    //   28: invokevirtual 131	java/security/cert/CertificateFactory:generateCertificate	(Ljava/io/InputStream;)Ljava/security/cert/Certificate;
    //   31: checkcast 133	java/security/cert/X509Certificate
    //   34: astore_2
    //   35: aload_1
    //   36: ifnull +7 -> 43
    //   39: aload_1
    //   40: invokevirtual 138	java/io/InputStream:close	()V
    //   43: aload_2
    //   44: areturn
    //   45: astore_2
    //   46: aload 4
    //   48: astore_1
    //   49: aload_1
    //   50: astore_3
    //   51: aload_2
    //   52: invokevirtual 77	java/lang/Exception:printStackTrace	()V
    //   55: aload_1
    //   56: ifnull +7 -> 63
    //   59: aload_1
    //   60: invokevirtual 138	java/io/InputStream:close	()V
    //   63: aconst_null
    //   64: areturn
    //   65: astore_1
    //   66: aload_3
    //   67: ifnull +7 -> 74
    //   70: aload_3
    //   71: invokevirtual 138	java/io/InputStream:close	()V
    //   74: aload_1
    //   75: athrow
    //   76: astore_2
    //   77: aload_1
    //   78: astore_3
    //   79: aload_2
    //   80: astore_1
    //   81: goto -15 -> 66
    //   84: astore_2
    //   85: goto -36 -> 49
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	b
    //   0	88	1	paramString1	String
    //   0	88	2	paramString2	String
    //   8	71	3	localObject1	Object
    //   4	43	4	localObject2	Object
    //   1	14	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   9	14	45	java/lang/Exception
    //   17	26	45	java/lang/Exception
    //   9	14	65	finally
    //   17	26	65	finally
    //   51	55	65	finally
    //   26	35	76	finally
    //   26	35	84	java/lang/Exception
  }
  
  public String a(String paramString)
  {
    return a(paramString, this.h);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */