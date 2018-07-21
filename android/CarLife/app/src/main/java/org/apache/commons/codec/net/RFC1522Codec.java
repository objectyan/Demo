package org.apache.commons.codec.net;

import java.io.UnsupportedEncodingException;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;

@Deprecated
abstract class RFC1522Codec
{
  RFC1522Codec()
  {
    throw new RuntimeException("Stub!");
  }
  
  protected String decodeText(String paramString)
    throws DecoderException, UnsupportedEncodingException
  {
    throw new RuntimeException("Stub!");
  }
  
  protected abstract byte[] doDecoding(byte[] paramArrayOfByte)
    throws DecoderException;
  
  protected abstract byte[] doEncoding(byte[] paramArrayOfByte)
    throws EncoderException;
  
  protected String encodeText(String paramString1, String paramString2)
    throws EncoderException, UnsupportedEncodingException
  {
    throw new RuntimeException("Stub!");
  }
  
  protected abstract String getEncoding();
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/org/apache/commons/codec/net/RFC1522Codec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */