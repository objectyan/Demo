package com.indooratlas.android.sdk._internal;

import java.io.IOException;
import java.net.URLDecoder;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;

final class ap
  implements gf
{
  private final an a;
  
  ap(an paraman)
  {
    this.a = paraman;
  }
  
  public final gm a(gf.a parama)
    throws IOException
  {
    gk localgk = parama.a();
    Object localObject1 = localgk.a("X-IA-Skip-Signature");
    if ((this.a.a()) && ((localObject1 == null) || (!"true".equals(localObject1))) && (localgk.a("Host").endsWith(".indooratlas.com"))) {}
    for (int i = 1; i == 0; i = 0) {
      return parama.a(localgk);
    }
    String str1 = localgk.a("Content-Type");
    String str2 = localgk.a("Date");
    localObject1 = localgk.a();
    String str3 = ((ge)localObject1).d();
    localObject1 = ((ge)localObject1).g();
    String str4 = localgk.b();
    Object localObject3;
    Object localObject2;
    Object localObject4;
    if (localObject1 != null)
    {
      localObject1 = URLDecoder.decode((String)localObject1, "UTF-8");
      localObject3 = Collections.emptyMap();
      localObject2 = null;
      localObject4 = localgk.d();
      if (localObject4 != null)
      {
        localObject2 = new in();
        ((gl)localObject4).a((io)localObject2);
        ((io)localObject2).close();
        localObject2 = ((io)localObject2).b().n();
      }
    }
    label692:
    for (;;)
    {
      try
      {
        Object localObject7 = af.a(str2);
        localObject4 = new fi();
        if (!af.a(str1)) {
          break label692;
        }
        str1 = "";
        Object localObject5 = this.a;
        ((an)localObject5).b();
        localObject5 = ((an)localObject5).b;
        Object localObject6 = this.a;
        ((an)localObject6).b();
        localObject6 = ((an)localObject6).c;
        Object localObject8 = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.ENGLISH);
        ((SimpleDateFormat)localObject8).setTimeZone(TimeZone.getTimeZone("UTC"));
        localObject7 = ((SimpleDateFormat)localObject8).format((Date)localObject7);
        if (localObject2 != null)
        {
          ((fi)localObject4).a((byte[])localObject2);
          localObject2 = ((fi)localObject4).a((byte[])localObject2);
          if ((localObject2 != null) && (!"".equals(localObject2)))
          {
            str1 = str1.split(";")[0];
            localObject3 = new TreeMap((Map)localObject3);
            localObject8 = new StringBuilder();
            ((StringBuilder)localObject8).append(str4.toUpperCase().trim() + "\n");
            ((StringBuilder)localObject8).append((String)localObject2 + "\n");
            ((StringBuilder)localObject8).append(str1 + "\n");
            ((StringBuilder)localObject8).append((String)localObject7 + "\n");
            ((StringBuilder)localObject8).append(fi.a((Map)localObject3));
            ((StringBuilder)localObject8).append(fi.a(str3, (String)localObject1));
            localObject1 = ((StringBuilder)localObject8).toString();
            str1 = ((fi)localObject4).a.a((String)localObject6, (String)localObject1);
            localObject1 = new fk();
            ((fk)localObject1).c = ("HMAC-256 " + (String)localObject5 + ":" + str1);
            ((fk)localObject1).b = ((String)localObject7);
            ((fk)localObject1).d = ((String)localObject2);
            ((fk)localObject1).a = str1;
            localObject2 = localgk.e().a("Authorization", ((fk)localObject1).c).a("Date", ((fk)localObject1).b);
            if (!af.a(((fk)localObject1).d)) {
              ((gk.a)localObject2).a("Content-SHA256", ((fk)localObject1).d);
            }
            return parama.a(((gk.a)localObject2).a());
          }
          str1 = "";
          continue;
        }
        localObject2 = "";
      }
      catch (ParseException parama)
      {
        throw new IOException("Failed to parse Date header value: '" + str2 + "'", parama);
      }
      catch (NoSuchAlgorithmException parama)
      {
        throw new IOException("Signing request failed", parama);
      }
      catch (fl parama)
      {
        throw new IOException("Signing request failed", parama);
      }
      continue;
      localObject1 = null;
      break;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */