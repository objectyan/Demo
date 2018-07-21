package org.apache.commons.codec.language;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

@Deprecated
public class Soundex
  implements StringEncoder
{
  public static final Soundex US_ENGLISH = null;
  public static final char[] US_ENGLISH_MAPPING = null;
  public static final String US_ENGLISH_MAPPING_STRING = "01230120022455012623010202";
  
  public Soundex()
  {
    throw new RuntimeException("Stub!");
  }
  
  public Soundex(char[] paramArrayOfChar)
  {
    throw new RuntimeException("Stub!");
  }
  
  public int difference(String paramString1, String paramString2)
    throws EncoderException
  {
    throw new RuntimeException("Stub!");
  }
  
  public Object encode(Object paramObject)
    throws EncoderException
  {
    throw new RuntimeException("Stub!");
  }
  
  public String encode(String paramString)
  {
    throw new RuntimeException("Stub!");
  }
  
  @Deprecated
  public int getMaxLength()
  {
    throw new RuntimeException("Stub!");
  }
  
  @Deprecated
  public void setMaxLength(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public String soundex(String paramString)
  {
    throw new RuntimeException("Stub!");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/org/apache/commons/codec/language/Soundex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */