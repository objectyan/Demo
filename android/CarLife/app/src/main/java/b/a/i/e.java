package b.a.i;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.PublicKey;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.X509TrustManager;
import javax.security.auth.x500.X500Principal;

public abstract class e
{
  public static e a(X509TrustManager paramX509TrustManager)
  {
    try
    {
      Object localObject = paramX509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", new Class[] { X509Certificate.class });
      ((Method)localObject).setAccessible(true);
      localObject = new a(paramX509TrustManager, (Method)localObject);
      return (e)localObject;
    }
    catch (NoSuchMethodException localNoSuchMethodException) {}
    return a(paramX509TrustManager.getAcceptedIssuers());
  }
  
  public static e a(X509Certificate... paramVarArgs)
  {
    return new b(paramVarArgs);
  }
  
  public abstract X509Certificate a(X509Certificate paramX509Certificate);
  
  static final class a
    extends e
  {
    private final X509TrustManager a;
    private final Method b;
    
    a(X509TrustManager paramX509TrustManager, Method paramMethod)
    {
      this.b = paramMethod;
      this.a = paramX509TrustManager;
    }
    
    public X509Certificate a(X509Certificate paramX509Certificate)
    {
      Object localObject = null;
      try
      {
        TrustAnchor localTrustAnchor = (TrustAnchor)this.b.invoke(this.a, new Object[] { paramX509Certificate });
        paramX509Certificate = (X509Certificate)localObject;
        if (localTrustAnchor != null) {
          paramX509Certificate = localTrustAnchor.getTrustedCert();
        }
        return paramX509Certificate;
      }
      catch (IllegalAccessException paramX509Certificate)
      {
        throw new AssertionError();
      }
      catch (InvocationTargetException paramX509Certificate) {}
      return null;
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      do
      {
        return true;
        if (!(paramObject instanceof a)) {
          return false;
        }
        paramObject = (a)paramObject;
      } while ((this.a.equals(((a)paramObject).a)) && (this.b.equals(((a)paramObject).b)));
      return false;
    }
    
    public int hashCode()
    {
      return this.a.hashCode() + this.b.hashCode() * 31;
    }
  }
  
  static final class b
    extends e
  {
    private final Map<X500Principal, Set<X509Certificate>> a = new LinkedHashMap();
    
    public b(X509Certificate... paramVarArgs)
    {
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        X509Certificate localX509Certificate = paramVarArgs[i];
        X500Principal localX500Principal = localX509Certificate.getSubjectX500Principal();
        Set localSet = (Set)this.a.get(localX500Principal);
        Object localObject = localSet;
        if (localSet == null)
        {
          localObject = new LinkedHashSet(1);
          this.a.put(localX500Principal, localObject);
        }
        ((Set)localObject).add(localX509Certificate);
        i += 1;
      }
    }
    
    public X509Certificate a(X509Certificate paramX509Certificate)
    {
      Object localObject = paramX509Certificate.getIssuerX500Principal();
      localObject = (Set)this.a.get(localObject);
      if (localObject == null) {
        return null;
      }
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        X509Certificate localX509Certificate = (X509Certificate)((Iterator)localObject).next();
        PublicKey localPublicKey = localX509Certificate.getPublicKey();
        try
        {
          paramX509Certificate.verify(localPublicKey);
          return localX509Certificate;
        }
        catch (Exception localException) {}
      }
      return null;
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      while (((paramObject instanceof b)) && (((b)paramObject).a.equals(this.a))) {
        return true;
      }
      return false;
    }
    
    public int hashCode()
    {
      return this.a.hashCode();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/b/a/i/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */