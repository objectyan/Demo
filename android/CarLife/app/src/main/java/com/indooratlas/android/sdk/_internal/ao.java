package com.indooratlas.android.sdk._internal;

import android.text.TextUtils;
import java.util.ArrayList;
import org.json.JSONObject;

public final class ao
  extends an
  implements ac
{
  public ao(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public final <R> aa<R> a(z<R> paramz, String paramString)
  {
    Object localObject = eg.a(paramString, "contextId must be non null", new Object[0]);
    paramString = (String)localObject;
    if (((String)localObject).indexOf('.') == -1) {
      paramString = "floorplan." + (String)localObject;
    }
    int i;
    if (!TextUtils.isEmpty(null))
    {
      i = 1;
      paramString = a(ah.a.d).a("/%s/raster_images", new Object[] { paramString });
      if (i != 0)
      {
        eg.a("ida-key", "query parameter name must be non empty", new Object[0]);
        if (af.a(null)) {
          break label195;
        }
        if (paramString.c == null) {
          paramString.c = new ArrayList();
        }
        localObject = new ah.b("ida-key");
        paramString.c.add(localObject);
      }
      localObject = paramString.a();
      if (i == 0) {
        break label225;
      }
    }
    label195:
    label225:
    for (paramString = "true";; paramString = "false")
    {
      paramString = a((String)localObject, "GET", null, null, new String[] { "X-IA-Skip-Signature", paramString });
      return new am(this.e.a(paramString), paramz);
      i = 0;
      break;
      throw new IllegalArgumentException("query param value for " + "ida-key" + " must be non empty");
    }
  }
  
  public final <R> aa<R> a(z<R> paramz, JSONObject paramJSONObject)
  {
    b();
    paramJSONObject = b(a(ah.a.c).a("/init", new Object[0]).a(), paramJSONObject.toString().getBytes(f));
    return new am(this.e.a(paramJSONObject), paramz);
  }
  
  public final aa<Void> a(String paramString, byte[] paramArrayOfByte)
  {
    b();
    new String(paramArrayOfByte, f);
    paramString = b(a(ah.a.c).a("/events/%s", new Object[] { paramString }).a(), paramArrayOfByte);
    return new am(this.e.a(paramString), z.a);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */