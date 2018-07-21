package b.a.f;

import okio.ByteString;

public final class c
{
  public static final ByteString a = ByteString.encodeUtf8(":");
  public static final ByteString b = ByteString.encodeUtf8(":status");
  public static final ByteString c = ByteString.encodeUtf8(":method");
  public static final ByteString d = ByteString.encodeUtf8(":path");
  public static final ByteString e = ByteString.encodeUtf8(":scheme");
  public static final ByteString f = ByteString.encodeUtf8(":authority");
  public final ByteString g;
  public final ByteString h;
  final int i;
  
  public c(String paramString1, String paramString2)
  {
    this(ByteString.encodeUtf8(paramString1), ByteString.encodeUtf8(paramString2));
  }
  
  public c(ByteString paramByteString, String paramString)
  {
    this(paramByteString, ByteString.encodeUtf8(paramString));
  }
  
  public c(ByteString paramByteString1, ByteString paramByteString2)
  {
    this.g = paramByteString1;
    this.h = paramByteString2;
    this.i = (paramByteString1.size() + 32 + paramByteString2.size());
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof c))
    {
      paramObject = (c)paramObject;
      bool1 = bool2;
      if (this.g.equals(((c)paramObject).g))
      {
        bool1 = bool2;
        if (this.h.equals(((c)paramObject).h)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    return (this.g.hashCode() + 527) * 31 + this.h.hashCode();
  }
  
  public String toString()
  {
    return b.a.c.a("%s: %s", new Object[] { this.g.utf8(), this.h.utf8() });
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/b/a/f/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */