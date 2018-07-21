package com.indooratlas.android.sdk._internal;

import java.io.IOException;

public final class j
  extends IOException
{
  private static final long serialVersionUID = -1616151763072450476L;
  
  private j(String paramString)
  {
    super(paramString);
  }
  
  static j a()
  {
    return new j("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
  }
  
  static j b()
  {
    return new j("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
  }
  
  static j c()
  {
    return new j("CodedInputStream encountered a malformed varint.");
  }
  
  static j d()
  {
    return new j("Protocol message contained an invalid tag (zero).");
  }
  
  static j e()
  {
    return new j("Protocol message end-group tag did not match expected tag.");
  }
  
  static j f()
  {
    return new j("Protocol message tag had invalid wire type.");
  }
  
  static j g()
  {
    return new j("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/indooratlas/android/sdk/_internal/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */