package com.google.zxing.qrcode.decoder;

import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.BitSource;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.StringUtils;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

final class DecodedBitStreamParser
{
  private static final char[] ALPHANUMERIC_CHARS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 32, 36, 37, 42, 43, 45, 46, 47, 58 };
  private static final int GB2312_SUBSET = 1;
  
  static DecoderResult decode(byte[] paramArrayOfByte, Version paramVersion, ErrorCorrectionLevel paramErrorCorrectionLevel, Map<DecodeHintType, ?> paramMap)
    throws FormatException
  {
    BitSource localBitSource = new BitSource(paramArrayOfByte);
    StringBuilder localStringBuilder = new StringBuilder(50);
    Object localObject1 = null;
    boolean bool1 = false;
    ArrayList localArrayList = new ArrayList(1);
    Mode localMode;
    Object localObject2;
    boolean bool2;
    while (localBitSource.available() < 4)
    {
      localMode = Mode.TERMINATOR;
      localObject2 = localObject1;
      bool2 = bool1;
      if (localMode != Mode.TERMINATOR)
      {
        if ((localMode != Mode.FNC1_FIRST_POSITION) && (localMode != Mode.FNC1_SECOND_POSITION)) {
          break label164;
        }
        bool2 = true;
        localObject2 = localObject1;
      }
      label90:
      localObject1 = localObject2;
      bool1 = bool2;
      if (localMode == Mode.TERMINATOR)
      {
        paramMap = localStringBuilder.toString();
        paramVersion = localArrayList;
        if (localArrayList.isEmpty()) {
          paramVersion = null;
        }
        if (paramErrorCorrectionLevel != null) {
          break label425;
        }
      }
    }
    label164:
    label425:
    for (paramErrorCorrectionLevel = null;; paramErrorCorrectionLevel = paramErrorCorrectionLevel.toString())
    {
      return new DecoderResult(paramArrayOfByte, paramMap, paramVersion, paramErrorCorrectionLevel);
      try
      {
        localMode = Mode.forBits(localBitSource.readBits(4));
      }
      catch (IllegalArgumentException paramArrayOfByte)
      {
        throw FormatException.getFormatInstance();
      }
      if (localMode == Mode.STRUCTURED_APPEND)
      {
        localBitSource.readBits(16);
        localObject2 = localObject1;
        bool2 = bool1;
        break label90;
      }
      if (localMode == Mode.ECI)
      {
        localObject1 = CharacterSetECI.getCharacterSetECIByValue(parseECIValue(localBitSource));
        localObject2 = localObject1;
        bool2 = bool1;
        if (localObject1 != null) {
          break label90;
        }
        throw FormatException.getFormatInstance();
      }
      if (localMode == Mode.HANZI)
      {
        i = localBitSource.readBits(4);
        int j = localBitSource.readBits(localMode.getCharacterCountBits(paramVersion));
        localObject2 = localObject1;
        bool2 = bool1;
        if (i != 1) {
          break label90;
        }
        decodeHanziSegment(localBitSource, localStringBuilder, j);
        localObject2 = localObject1;
        bool2 = bool1;
        break label90;
      }
      int i = localBitSource.readBits(localMode.getCharacterCountBits(paramVersion));
      if (localMode == Mode.NUMERIC)
      {
        decodeNumericSegment(localBitSource, localStringBuilder, i);
        localObject2 = localObject1;
        bool2 = bool1;
        break label90;
      }
      if (localMode == Mode.ALPHANUMERIC)
      {
        decodeAlphanumericSegment(localBitSource, localStringBuilder, i, bool1);
        localObject2 = localObject1;
        bool2 = bool1;
        break label90;
      }
      if (localMode == Mode.BYTE)
      {
        decodeByteSegment(localBitSource, localStringBuilder, i, (CharacterSetECI)localObject1, localArrayList, paramMap);
        localObject2 = localObject1;
        bool2 = bool1;
        break label90;
      }
      if (localMode == Mode.KANJI)
      {
        decodeKanjiSegment(localBitSource, localStringBuilder, i);
        localObject2 = localObject1;
        bool2 = bool1;
        break label90;
      }
      throw FormatException.getFormatInstance();
    }
  }
  
  private static void decodeAlphanumericSegment(BitSource paramBitSource, StringBuilder paramStringBuilder, int paramInt, boolean paramBoolean)
    throws FormatException
  {
    int i = paramStringBuilder.length();
    while (paramInt > 1)
    {
      int j = paramBitSource.readBits(11);
      paramStringBuilder.append(toAlphaNumericChar(j / 45));
      paramStringBuilder.append(toAlphaNumericChar(j % 45));
      paramInt -= 2;
    }
    if (paramInt == 1) {
      paramStringBuilder.append(toAlphaNumericChar(paramBitSource.readBits(6)));
    }
    if (paramBoolean)
    {
      paramInt = i;
      if (paramInt < paramStringBuilder.length())
      {
        if (paramStringBuilder.charAt(paramInt) == '%')
        {
          if ((paramInt >= paramStringBuilder.length() - 1) || (paramStringBuilder.charAt(paramInt + 1) != '%')) {
            break label133;
          }
          paramStringBuilder.deleteCharAt(paramInt + 1);
        }
        for (;;)
        {
          paramInt += 1;
          break;
          label133:
          paramStringBuilder.setCharAt(paramInt, '\035');
        }
      }
    }
  }
  
  private static void decodeByteSegment(BitSource paramBitSource, StringBuilder paramStringBuilder, int paramInt, CharacterSetECI paramCharacterSetECI, Collection<byte[]> paramCollection, Map<DecodeHintType, ?> paramMap)
    throws FormatException
  {
    if (paramInt << 3 > paramBitSource.available()) {
      throw FormatException.getFormatInstance();
    }
    byte[] arrayOfByte = new byte[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      arrayOfByte[i] = ((byte)paramBitSource.readBits(8));
      i += 1;
    }
    if (paramCharacterSetECI == null) {}
    for (paramBitSource = StringUtils.guessEncoding(arrayOfByte, paramMap);; paramBitSource = paramCharacterSetECI.name()) {
      try
      {
        paramStringBuilder.append(new String(arrayOfByte, paramBitSource));
        paramCollection.add(arrayOfByte);
        return;
      }
      catch (UnsupportedEncodingException paramBitSource)
      {
        throw FormatException.getFormatInstance();
      }
    }
  }
  
  private static void decodeHanziSegment(BitSource paramBitSource, StringBuilder paramStringBuilder, int paramInt)
    throws FormatException
  {
    if (paramInt * 13 > paramBitSource.available()) {
      throw FormatException.getFormatInstance();
    }
    byte[] arrayOfByte = new byte[paramInt * 2];
    int i = 0;
    if (paramInt > 0)
    {
      int j = paramBitSource.readBits(13);
      j = j / 96 << 8 | j % 96;
      if (j < 959) {
        j += 41377;
      }
      for (;;)
      {
        arrayOfByte[i] = ((byte)(j >> 8 & 0xFF));
        arrayOfByte[(i + 1)] = ((byte)(j & 0xFF));
        i += 2;
        paramInt -= 1;
        break;
        j += 42657;
      }
    }
    try
    {
      paramStringBuilder.append(new String(arrayOfByte, "GB2312"));
      return;
    }
    catch (UnsupportedEncodingException paramBitSource)
    {
      throw FormatException.getFormatInstance();
    }
  }
  
  private static void decodeKanjiSegment(BitSource paramBitSource, StringBuilder paramStringBuilder, int paramInt)
    throws FormatException
  {
    if (paramInt * 13 > paramBitSource.available()) {
      throw FormatException.getFormatInstance();
    }
    byte[] arrayOfByte = new byte[paramInt * 2];
    int i = 0;
    if (paramInt > 0)
    {
      int j = paramBitSource.readBits(13);
      j = j / 192 << 8 | j % 192;
      if (j < 7936) {
        j += 33088;
      }
      for (;;)
      {
        arrayOfByte[i] = ((byte)(j >> 8));
        arrayOfByte[(i + 1)] = ((byte)j);
        i += 2;
        paramInt -= 1;
        break;
        j += 49472;
      }
    }
    try
    {
      paramStringBuilder.append(new String(arrayOfByte, "SJIS"));
      return;
    }
    catch (UnsupportedEncodingException paramBitSource)
    {
      throw FormatException.getFormatInstance();
    }
  }
  
  private static void decodeNumericSegment(BitSource paramBitSource, StringBuilder paramStringBuilder, int paramInt)
    throws FormatException
  {
    while (paramInt >= 3)
    {
      if (paramBitSource.available() < 10) {
        throw FormatException.getFormatInstance();
      }
      int i = paramBitSource.readBits(10);
      if (i >= 1000) {
        throw FormatException.getFormatInstance();
      }
      paramStringBuilder.append(toAlphaNumericChar(i / 100));
      paramStringBuilder.append(toAlphaNumericChar(i / 10 % 10));
      paramStringBuilder.append(toAlphaNumericChar(i % 10));
      paramInt -= 3;
    }
    if (paramInt == 2)
    {
      if (paramBitSource.available() < 7) {
        throw FormatException.getFormatInstance();
      }
      paramInt = paramBitSource.readBits(7);
      if (paramInt >= 100) {
        throw FormatException.getFormatInstance();
      }
      paramStringBuilder.append(toAlphaNumericChar(paramInt / 10));
      paramStringBuilder.append(toAlphaNumericChar(paramInt % 10));
    }
    while (paramInt != 1) {
      return;
    }
    if (paramBitSource.available() < 4) {
      throw FormatException.getFormatInstance();
    }
    paramInt = paramBitSource.readBits(4);
    if (paramInt >= 10) {
      throw FormatException.getFormatInstance();
    }
    paramStringBuilder.append(toAlphaNumericChar(paramInt));
  }
  
  private static int parseECIValue(BitSource paramBitSource)
  {
    int i = paramBitSource.readBits(8);
    if ((i & 0x80) == 0) {
      return i & 0x7F;
    }
    if ((i & 0xC0) == 128) {
      return (i & 0x3F) << 8 | paramBitSource.readBits(8);
    }
    if ((i & 0xE0) == 192) {
      return (i & 0x1F) << 16 | paramBitSource.readBits(16);
    }
    throw new IllegalArgumentException("Bad ECI bits starting with byte " + i);
  }
  
  private static char toAlphaNumericChar(int paramInt)
    throws FormatException
  {
    if (paramInt >= ALPHANUMERIC_CHARS.length) {
      throw FormatException.getFormatInstance();
    }
    return ALPHANUMERIC_CHARS[paramInt];
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/google/zxing/qrcode/decoder/DecodedBitStreamParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */