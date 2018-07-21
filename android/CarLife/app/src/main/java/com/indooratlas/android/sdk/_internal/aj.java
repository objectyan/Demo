package com.indooratlas.android.sdk._internal;

import android.text.TextUtils;
import java.io.IOException;

public final class aj
  implements gf
{
  public final gm a(gf.a parama)
    throws IOException
  {
    gk localgk = parama.a();
    Object localObject = localgk.a("X-IA-Compress-Request");
    if ((TextUtils.isEmpty((CharSequence)localObject)) || (localgk.d() == null)) {
      return parama.a(localgk);
    }
    if (((String)localObject).equalsIgnoreCase("true"))
    {
      localObject = new gl()
      {
        public final gg a()
        {
          return this.a.a();
        }
        
        public final void a(io paramAnonymousio)
          throws IOException
        {
          paramAnonymousio = ix.a(new iu(paramAnonymousio));
          this.a.a(paramAnonymousio);
          paramAnonymousio.close();
        }
        
        public final long b()
        {
          return -1L;
        }
      };
      return parama.a(localgk.e().a("Content-Encoding", "gzip").a(localgk.b(), (gl)localObject).a());
    }
    return parama.a(localgk);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */