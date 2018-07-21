package com.baidu.speech.core;

import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;

public class BDSCharacterCoder
{
  private static String[] encodingNames = { "UTF-8", "GB18030" };
  
  public static int convertCharacterEncoding(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    int i = 0;
    if ((paramInt1 >= encodingNames.length) || (paramInt2 >= encodingNames.length))
    {
      Log.e("BDSCharacterCoder", "requested source or target encoding is invalid, min: 0, max: " + encodingNames.length + " requested source: " + paramInt1 + " requested target: " + paramInt2);
      return 0;
    }
    Object localObject2 = Charset.forName(encodingNames[paramInt1]);
    Object localObject1 = Charset.forName(encodingNames[paramInt2]);
    localObject2 = ((Charset)localObject2).newDecoder();
    localObject1 = ((Charset)localObject1).newEncoder();
    char[] arrayOfChar = new char[paramArrayOfByte1.length];
    CharBuffer localCharBuffer = CharBuffer.wrap(arrayOfChar);
    paramArrayOfByte1 = ((CharsetDecoder)localObject2).decode(ByteBuffer.wrap(paramArrayOfByte1), localCharBuffer, true);
    localObject2 = CharBuffer.wrap(arrayOfChar, 0, localCharBuffer.position());
    boolean bool = paramArrayOfByte1.isError();
    paramArrayOfByte1 = ByteBuffer.wrap(paramArrayOfByte2);
    paramArrayOfByte2 = ((CharsetEncoder)localObject1).encode((CharBuffer)localObject2, paramArrayOfByte1, true);
    if (!bool)
    {
      paramInt1 = i;
      if (!paramArrayOfByte2.isError()) {}
    }
    else
    {
      paramInt1 = 1;
    }
    paramInt2 = paramArrayOfByte1.position();
    if (paramInt1 != 0) {
      return paramInt2 * -1;
    }
    return paramInt2;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/speech/core/BDSCharacterCoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */