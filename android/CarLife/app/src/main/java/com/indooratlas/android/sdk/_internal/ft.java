package com.indooratlas.android.sdk._internal;

import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;

public final class ft
{
  public static final ft a = new ft(new a(), (byte)0);
  private final Map<String, Set<iq>> b;
  
  private ft(a parama)
  {
    this.b = gy.a(parama.a);
  }
  
  private static iq a(X509Certificate paramX509Certificate)
  {
    return gy.a(iq.a(paramX509Certificate.getPublicKey().getEncoded()));
  }
  
  public static String a(Certificate paramCertificate)
  {
    if (!(paramCertificate instanceof X509Certificate)) {
      throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }
    return "sha1/" + im.a(a((X509Certificate)paramCertificate).c);
  }
  
  public final void a(String paramString, List<Certificate> paramList)
    throws SSLPeerUnverifiedException
  {
    Object localObject3 = null;
    Object localObject2 = (Set)this.b.get(paramString);
    int i = paramString.indexOf('.');
    if (i != paramString.lastIndexOf('.')) {}
    for (Object localObject1 = (Set)this.b.get("*." + paramString.substring(i + 1));; localObject1 = null)
    {
      if ((localObject2 == null) && (localObject1 == null)) {
        localObject1 = localObject3;
      }
      while (localObject1 == null)
      {
        return;
        if ((localObject2 != null) && (localObject1 != null))
        {
          localObject3 = new LinkedHashSet();
          ((Set)localObject3).addAll((Collection)localObject2);
          ((Set)localObject3).addAll((Collection)localObject1);
          localObject1 = localObject3;
        }
        else if (localObject2 != null)
        {
          localObject1 = localObject2;
        }
      }
      int j = paramList.size();
      i = 0;
      for (;;)
      {
        if (i >= j) {
          break label198;
        }
        if (((Set)localObject1).contains(a((X509Certificate)paramList.get(i)))) {
          break;
        }
        i += 1;
      }
      label198:
      localObject2 = new StringBuilder("Certificate pinning failure!\n  Peer certificate chain:");
      j = paramList.size();
      i = 0;
      while (i < j)
      {
        localObject3 = (X509Certificate)paramList.get(i);
        ((StringBuilder)localObject2).append("\n    ").append(a((Certificate)localObject3)).append(": ").append(((X509Certificate)localObject3).getSubjectDN().getName());
        i += 1;
      }
      ((StringBuilder)localObject2).append("\n  Pinned certificates for ").append(paramString).append(":");
      paramString = ((Set)localObject1).iterator();
      while (paramString.hasNext())
      {
        paramList = (iq)paramString.next();
        ((StringBuilder)localObject2).append("\n    sha1/").append(im.a(paramList.c));
      }
      throw new SSLPeerUnverifiedException(((StringBuilder)localObject2).toString());
    }
  }
  
  public static final class a
  {
    final Map<String, Set<iq>> a = new LinkedHashMap();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/ft.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */