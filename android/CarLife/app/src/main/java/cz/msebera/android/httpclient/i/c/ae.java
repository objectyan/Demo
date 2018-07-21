package cz.msebera.android.httpclient.i.c;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.d.a;
import cz.msebera.android.httpclient.e.p;
import cz.msebera.android.httpclient.i.g.l;
import cz.msebera.android.httpclient.j.d;
import cz.msebera.android.httpclient.j.f;
import cz.msebera.android.httpclient.x;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.util.concurrent.atomic.AtomicLong;

@Immutable
public class ae
  implements p<cz.msebera.android.httpclient.e.b.b, cz.msebera.android.httpclient.e.u>
{
  public static final ae a = new ae();
  private static final AtomicLong e = new AtomicLong();
  public cz.msebera.android.httpclient.h.b b = new cz.msebera.android.httpclient.h.b(o.class);
  public cz.msebera.android.httpclient.h.b c = new cz.msebera.android.httpclient.h.b("cz.msebera.android.httpclient.headers");
  public cz.msebera.android.httpclient.h.b d = new cz.msebera.android.httpclient.h.b("cz.msebera.android.httpclient.wire");
  private final f<cz.msebera.android.httpclient.u> f;
  private final d<x> g;
  
  public ae()
  {
    this(null, null);
  }
  
  public ae(d<x> paramd)
  {
    this(null, paramd);
  }
  
  public ae(f<cz.msebera.android.httpclient.u> paramf, d<x> paramd)
  {
    if (paramf != null)
    {
      this.f = paramf;
      if (paramd == null) {
        break label69;
      }
    }
    for (;;)
    {
      this.g = paramd;
      return;
      paramf = l.a;
      break;
      label69:
      paramd = m.a;
    }
  }
  
  public cz.msebera.android.httpclient.e.u a(cz.msebera.android.httpclient.e.b.b paramb, a parama)
  {
    CharsetDecoder localCharsetDecoder;
    CharsetEncoder localCharsetEncoder;
    Charset localCharset;
    if (parama != null)
    {
      paramb = parama;
      localCharsetDecoder = null;
      localCharsetEncoder = null;
      localCharset = paramb.c();
      if (paramb.d() == null) {
        break label169;
      }
      parama = paramb.d();
      label30:
      if (paramb.e() == null) {
        break label176;
      }
    }
    label169:
    label176:
    for (CodingErrorAction localCodingErrorAction = paramb.e();; localCodingErrorAction = CodingErrorAction.REPORT)
    {
      if (localCharset != null)
      {
        localCharsetDecoder = localCharset.newDecoder();
        localCharsetDecoder.onMalformedInput(parama);
        localCharsetDecoder.onUnmappableCharacter(localCodingErrorAction);
        localCharsetEncoder = localCharset.newEncoder();
        localCharsetEncoder.onMalformedInput(parama);
        localCharsetEncoder.onUnmappableCharacter(localCodingErrorAction);
      }
      return new z("http-outgoing-" + Long.toString(e.getAndIncrement()), this.b, this.c, this.d, paramb.a(), paramb.b(), localCharsetDecoder, localCharsetEncoder, paramb.f(), null, null, this.f, this.g);
      paramb = a.a;
      break;
      parama = CodingErrorAction.REPORT;
      break label30;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/c/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */