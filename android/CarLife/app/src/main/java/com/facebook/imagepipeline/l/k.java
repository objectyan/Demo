package com.facebook.imagepipeline.l;

import android.net.Uri;
import android.util.Base64;
import com.facebook.common.c.a;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.i.d;
import com.facebook.imagepipeline.m.c;
import com.facebook.imagepipeline.memory.z;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class k
  extends y
{
  private static final String a = "DataFetchProducer";
  
  public k(z paramz, boolean paramBoolean)
  {
    super(a.a(), paramz, paramBoolean);
  }
  
  @VisibleForTesting
  static byte[] a(String paramString)
  {
    com.facebook.common.internal.k.a(paramString.substring(0, 5).equals("data:"));
    int i = paramString.indexOf(',');
    String str = paramString.substring(i + 1, paramString.length());
    if (b(paramString.substring(0, i))) {
      return Base64.decode(str, 0);
    }
    return Uri.decode(str).getBytes();
  }
  
  @VisibleForTesting
  static boolean b(String paramString)
  {
    if (!paramString.contains(";")) {
      return false;
    }
    paramString = paramString.split(";");
    return paramString[(paramString.length - 1)].equals("base64");
  }
  
  protected d a(c paramc)
    throws IOException
  {
    paramc = a(paramc.b().toString());
    return a(new ByteArrayInputStream(paramc), paramc.length);
  }
  
  protected String a()
  {
    return "DataFetchProducer";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/l/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */