package org.apache.http.impl.auth;

import org.apache.http.Header;
import org.apache.http.HttpRequest;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.MalformedChallengeException;

@Deprecated
public class BasicScheme
  extends RFC2617Scheme
{
  public BasicScheme()
  {
    throw new RuntimeException("Stub!");
  }
  
  public static Header authenticate(Credentials paramCredentials, String paramString, boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  public Header authenticate(Credentials paramCredentials, HttpRequest paramHttpRequest)
    throws AuthenticationException
  {
    throw new RuntimeException("Stub!");
  }
  
  public String getSchemeName()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean isComplete()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean isConnectionBased()
  {
    throw new RuntimeException("Stub!");
  }
  
  public void processChallenge(Header paramHeader)
    throws MalformedChallengeException
  {
    throw new RuntimeException("Stub!");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/org/apache/http/impl/auth/BasicScheme.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */