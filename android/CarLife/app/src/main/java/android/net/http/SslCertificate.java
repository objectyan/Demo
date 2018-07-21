package android.net.http;

import android.os.Bundle;
import java.security.cert.X509Certificate;
import java.util.Date;

public class SslCertificate
{
  @Deprecated
  public SslCertificate(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    throw new RuntimeException("Stub!");
  }
  
  @Deprecated
  public SslCertificate(String paramString1, String paramString2, Date paramDate1, Date paramDate2)
  {
    throw new RuntimeException("Stub!");
  }
  
  public SslCertificate(X509Certificate paramX509Certificate)
  {
    throw new RuntimeException("Stub!");
  }
  
  public static SslCertificate restoreState(Bundle paramBundle)
  {
    throw new RuntimeException("Stub!");
  }
  
  public static Bundle saveState(SslCertificate paramSslCertificate)
  {
    throw new RuntimeException("Stub!");
  }
  
  public DName getIssuedBy()
  {
    throw new RuntimeException("Stub!");
  }
  
  public DName getIssuedTo()
  {
    throw new RuntimeException("Stub!");
  }
  
  @Deprecated
  public String getValidNotAfter()
  {
    throw new RuntimeException("Stub!");
  }
  
  public Date getValidNotAfterDate()
  {
    throw new RuntimeException("Stub!");
  }
  
  @Deprecated
  public String getValidNotBefore()
  {
    throw new RuntimeException("Stub!");
  }
  
  public Date getValidNotBeforeDate()
  {
    throw new RuntimeException("Stub!");
  }
  
  public String toString()
  {
    throw new RuntimeException("Stub!");
  }
  
  public class DName
  {
    public DName(String paramString)
    {
      throw new RuntimeException("Stub!");
    }
    
    public String getCName()
    {
      throw new RuntimeException("Stub!");
    }
    
    public String getDName()
    {
      throw new RuntimeException("Stub!");
    }
    
    public String getOName()
    {
      throw new RuntimeException("Stub!");
    }
    
    public String getUName()
    {
      throw new RuntimeException("Stub!");
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/android/net/http/SslCertificate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */