package android.net.http;

public class HttpAuthHeader
{
  public static final int BASIC = 1;
  public static final String BASIC_TOKEN = "Basic";
  public static final int DIGEST = 2;
  public static final String DIGEST_TOKEN = "Digest";
  public static final int UNKNOWN = 0;
  
  public HttpAuthHeader(String paramString)
  {
    throw new RuntimeException("Stub!");
  }
  
  public String getAlgorithm()
  {
    throw new RuntimeException("Stub!");
  }
  
  public String getNonce()
  {
    throw new RuntimeException("Stub!");
  }
  
  public String getOpaque()
  {
    throw new RuntimeException("Stub!");
  }
  
  public String getPassword()
  {
    throw new RuntimeException("Stub!");
  }
  
  public String getQop()
  {
    throw new RuntimeException("Stub!");
  }
  
  public String getRealm()
  {
    throw new RuntimeException("Stub!");
  }
  
  public int getScheme()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean getStale()
  {
    throw new RuntimeException("Stub!");
  }
  
  public String getUsername()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean isBasic()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean isDigest()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean isProxy()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean isSupportedScheme()
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setPassword(String paramString)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setProxy()
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setUsername(String paramString)
  {
    throw new RuntimeException("Stub!");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/android/net/http/HttpAuthHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */