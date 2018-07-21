package com.google.protobuf;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.CharBuffer;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class TextFormat
{
  private static final int BUFFER_SIZE = 4096;
  
  private static int digitValue(char paramChar)
  {
    if (('0' <= paramChar) && (paramChar <= '9')) {
      return paramChar - '0';
    }
    if (('a' <= paramChar) && (paramChar <= 'z')) {
      return paramChar - 'a' + 10;
    }
    return paramChar - 'A' + 10;
  }
  
  static String escapeBytes(ByteString paramByteString)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramByteString.size());
    int i = 0;
    if (i < paramByteString.size())
    {
      int j = paramByteString.byteAt(i);
      switch (j)
      {
      default: 
        if (j >= 32) {
          localStringBuilder.append((char)j);
        }
        break;
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append("\\a");
        continue;
        localStringBuilder.append("\\b");
        continue;
        localStringBuilder.append("\\f");
        continue;
        localStringBuilder.append("\\n");
        continue;
        localStringBuilder.append("\\r");
        continue;
        localStringBuilder.append("\\t");
        continue;
        localStringBuilder.append("\\v");
        continue;
        localStringBuilder.append("\\\\");
        continue;
        localStringBuilder.append("\\'");
        continue;
        localStringBuilder.append("\\\"");
        continue;
        localStringBuilder.append('\\');
        localStringBuilder.append((char)((j >>> 6 & 0x3) + 48));
        localStringBuilder.append((char)((j >>> 3 & 0x7) + 48));
        localStringBuilder.append((char)((j & 0x7) + 48));
      }
    }
    return localStringBuilder.toString();
  }
  
  static String escapeText(String paramString)
  {
    return escapeBytes(ByteString.copyFromUtf8(paramString));
  }
  
  private static boolean isHex(char paramChar)
  {
    return (('0' <= paramChar) && (paramChar <= '9')) || (('a' <= paramChar) && (paramChar <= 'f')) || (('A' <= paramChar) && (paramChar <= 'F'));
  }
  
  private static boolean isOctal(char paramChar)
  {
    return ('0' <= paramChar) && (paramChar <= '7');
  }
  
  public static void merge(CharSequence paramCharSequence, ExtensionRegistry paramExtensionRegistry, Message.Builder paramBuilder)
    throws TextFormat.ParseException
  {
    paramCharSequence = new Tokenizer(paramCharSequence, null);
    while (!paramCharSequence.atEnd()) {
      mergeField(paramCharSequence, paramExtensionRegistry, paramBuilder);
    }
  }
  
  public static void merge(CharSequence paramCharSequence, Message.Builder paramBuilder)
    throws TextFormat.ParseException
  {
    merge(paramCharSequence, ExtensionRegistry.getEmptyRegistry(), paramBuilder);
  }
  
  public static void merge(Readable paramReadable, ExtensionRegistry paramExtensionRegistry, Message.Builder paramBuilder)
    throws IOException
  {
    merge(toStringBuilder(paramReadable), paramExtensionRegistry, paramBuilder);
  }
  
  public static void merge(Readable paramReadable, Message.Builder paramBuilder)
    throws IOException
  {
    merge(paramReadable, ExtensionRegistry.getEmptyRegistry(), paramBuilder);
  }
  
  private static void mergeField(Tokenizer paramTokenizer, ExtensionRegistry paramExtensionRegistry, Message.Builder paramBuilder)
    throws TextFormat.ParseException
  {
    Object localObject4 = paramBuilder.getDescriptorForType();
    Object localObject3 = null;
    Object localObject1;
    Object localObject2;
    if (paramTokenizer.tryConsume("["))
    {
      localObject1 = new StringBuilder(paramTokenizer.consumeIdentifier());
      while (paramTokenizer.tryConsume("."))
      {
        ((StringBuilder)localObject1).append('.');
        ((StringBuilder)localObject1).append(paramTokenizer.consumeIdentifier());
      }
      localObject3 = paramExtensionRegistry.findExtensionByName(((StringBuilder)localObject1).toString());
      if (localObject3 == null) {
        throw paramTokenizer.parseExceptionPreviousToken("Extension \"" + localObject1 + "\" not found in the ExtensionRegistry.");
      }
      if (((ExtensionRegistry.ExtensionInfo)localObject3).descriptor.getContainingType() != localObject4) {
        throw paramTokenizer.parseExceptionPreviousToken("Extension \"" + localObject1 + "\" does not extend message type \"" + ((Descriptors.Descriptor)localObject4).getFullName() + "\".");
      }
      paramTokenizer.consume("]");
      localObject1 = ((ExtensionRegistry.ExtensionInfo)localObject3).descriptor;
      localObject2 = null;
      if (((Descriptors.FieldDescriptor)localObject1).getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) {
        break label503;
      }
      paramTokenizer.tryConsume(":");
      if (!paramTokenizer.tryConsume("<")) {
        break label438;
      }
      localObject2 = ">";
      label212:
      if (localObject3 != null) {
        break label451;
      }
      localObject3 = paramBuilder.newBuilderForField((Descriptors.FieldDescriptor)localObject1);
    }
    for (;;)
    {
      if (paramTokenizer.tryConsume((String)localObject2)) {
        break label476;
      }
      if (paramTokenizer.atEnd())
      {
        throw paramTokenizer.parseException("Expected \"" + (String)localObject2 + "\".");
        String str = paramTokenizer.consumeIdentifier();
        localObject2 = ((Descriptors.Descriptor)localObject4).findFieldByName(str);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject2 = ((Descriptors.Descriptor)localObject4).findFieldByName(str.toLowerCase(Locale.US));
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            localObject1 = localObject2;
            if (((Descriptors.FieldDescriptor)localObject2).getType() != Descriptors.FieldDescriptor.Type.GROUP) {
              localObject1 = null;
            }
          }
        }
        localObject2 = localObject1;
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (((Descriptors.FieldDescriptor)localObject1).getType() == Descriptors.FieldDescriptor.Type.GROUP)
          {
            localObject2 = localObject1;
            if (!((Descriptors.FieldDescriptor)localObject1).getMessageType().getName().equals(str)) {
              localObject2 = null;
            }
          }
        }
        localObject1 = localObject2;
        if (localObject2 != null) {
          break;
        }
        throw paramTokenizer.parseExceptionPreviousToken("Message type \"" + ((Descriptors.Descriptor)localObject4).getFullName() + "\" has no field named \"" + str + "\".");
        label438:
        paramTokenizer.consume("{");
        localObject2 = "}";
        break label212;
        label451:
        localObject3 = ((ExtensionRegistry.ExtensionInfo)localObject3).defaultInstance.newBuilderForType();
        continue;
      }
      mergeField(paramTokenizer, paramExtensionRegistry, (Message.Builder)localObject3);
    }
    label476:
    paramExtensionRegistry = ((Message.Builder)localObject3).build();
    while (((Descriptors.FieldDescriptor)localObject1).isRepeated())
    {
      paramBuilder.addRepeatedField((Descriptors.FieldDescriptor)localObject1, paramExtensionRegistry);
      return;
      label503:
      paramTokenizer.consume(":");
      switch (localObject1.getType())
      {
      default: 
        paramExtensionRegistry = (ExtensionRegistry)localObject2;
        break;
      case ???: 
      case ???: 
      case ???: 
        paramExtensionRegistry = Integer.valueOf(paramTokenizer.consumeInt32());
        break;
      case ???: 
      case ???: 
      case ???: 
        paramExtensionRegistry = Long.valueOf(paramTokenizer.consumeInt64());
        break;
      case ???: 
      case ???: 
        paramExtensionRegistry = Integer.valueOf(paramTokenizer.consumeUInt32());
        break;
      case ???: 
      case ???: 
        paramExtensionRegistry = Long.valueOf(paramTokenizer.consumeUInt64());
        break;
      case ???: 
        paramExtensionRegistry = Float.valueOf(paramTokenizer.consumeFloat());
        break;
      case ???: 
        paramExtensionRegistry = Double.valueOf(paramTokenizer.consumeDouble());
        break;
      case ???: 
        paramExtensionRegistry = Boolean.valueOf(paramTokenizer.consumeBoolean());
        break;
      case ???: 
        paramExtensionRegistry = paramTokenizer.consumeString();
        break;
      case ???: 
        paramExtensionRegistry = paramTokenizer.consumeByteString();
        break;
      case ???: 
        localObject3 = ((Descriptors.FieldDescriptor)localObject1).getEnumType();
        if (paramTokenizer.lookingAtInteger())
        {
          int i = paramTokenizer.consumeInt32();
          localObject2 = ((Descriptors.EnumDescriptor)localObject3).findValueByNumber(i);
          paramExtensionRegistry = (ExtensionRegistry)localObject2;
          if (localObject2 == null) {
            throw paramTokenizer.parseExceptionPreviousToken("Enum type \"" + ((Descriptors.EnumDescriptor)localObject3).getFullName() + "\" has no value with number " + i + '.');
          }
        }
        else
        {
          localObject4 = paramTokenizer.consumeIdentifier();
          localObject2 = ((Descriptors.EnumDescriptor)localObject3).findValueByName((String)localObject4);
          paramExtensionRegistry = (ExtensionRegistry)localObject2;
          if (localObject2 == null) {
            throw paramTokenizer.parseExceptionPreviousToken("Enum type \"" + ((Descriptors.EnumDescriptor)localObject3).getFullName() + "\" has no value named \"" + (String)localObject4 + "\".");
          }
        }
        break;
      case ???: 
      case ???: 
        throw new RuntimeException("Can't get here.");
      }
    }
    paramBuilder.setField((Descriptors.FieldDescriptor)localObject1, paramExtensionRegistry);
  }
  
  static int parseInt32(String paramString)
    throws NumberFormatException
  {
    return (int)parseInteger(paramString, true, false);
  }
  
  static long parseInt64(String paramString)
    throws NumberFormatException
  {
    return parseInteger(paramString, true, true);
  }
  
  private static long parseInteger(String paramString, boolean paramBoolean1, boolean paramBoolean2)
    throws NumberFormatException
  {
    int i = 0;
    int k = 0;
    if (paramString.startsWith("-", 0))
    {
      if (!paramBoolean1) {
        throw new NumberFormatException("Number must be positive: " + paramString);
      }
      i = 0 + 1;
      k = 1;
    }
    int j = 10;
    int m;
    if (paramString.startsWith("0x", i))
    {
      m = i + 2;
      j = 16;
    }
    Object localObject;
    long l2;
    long l1;
    for (;;)
    {
      localObject = paramString.substring(m);
      if (((String)localObject).length() >= 16) {
        break label254;
      }
      l2 = Long.parseLong((String)localObject, j);
      l1 = l2;
      if (k != 0) {
        l1 = -l2;
      }
      l2 = l1;
      if (paramBoolean2) {
        break label454;
      }
      if (!paramBoolean1) {
        break;
      }
      if (l1 <= 2147483647L)
      {
        l2 = l1;
        if (l1 >= -2147483648L) {
          break label454;
        }
      }
      throw new NumberFormatException("Number out of range for 32-bit signed integer: " + paramString);
      m = i;
      if (paramString.startsWith("0", i))
      {
        j = 8;
        m = i;
      }
    }
    if (l1 < 4294967296L)
    {
      l2 = l1;
      if (l1 >= 0L) {}
    }
    else
    {
      throw new NumberFormatException("Number out of range for 32-bit unsigned integer: " + paramString);
      label254:
      BigInteger localBigInteger = new BigInteger((String)localObject, j);
      localObject = localBigInteger;
      if (k != 0) {
        localObject = localBigInteger.negate();
      }
      if (!paramBoolean2)
      {
        if (paramBoolean1)
        {
          if (((BigInteger)localObject).bitLength() > 31) {
            throw new NumberFormatException("Number out of range for 32-bit signed integer: " + paramString);
          }
        }
        else if (((BigInteger)localObject).bitLength() > 32) {
          throw new NumberFormatException("Number out of range for 32-bit unsigned integer: " + paramString);
        }
      }
      else if (paramBoolean1)
      {
        if (((BigInteger)localObject).bitLength() > 63) {
          throw new NumberFormatException("Number out of range for 64-bit signed integer: " + paramString);
        }
      }
      else if (((BigInteger)localObject).bitLength() > 64) {
        throw new NumberFormatException("Number out of range for 64-bit unsigned integer: " + paramString);
      }
      l2 = ((BigInteger)localObject).longValue();
    }
    label454:
    return l2;
  }
  
  static int parseUInt32(String paramString)
    throws NumberFormatException
  {
    return (int)parseInteger(paramString, false, false);
  }
  
  static long parseUInt64(String paramString)
    throws NumberFormatException
  {
    return parseInteger(paramString, false, true);
  }
  
  private static void print(Message paramMessage, TextGenerator paramTextGenerator)
    throws IOException
  {
    Iterator localIterator = paramMessage.getAllFields().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      printField((Descriptors.FieldDescriptor)localEntry.getKey(), localEntry.getValue(), paramTextGenerator);
    }
    printUnknownFields(paramMessage.getUnknownFields(), paramTextGenerator);
  }
  
  public static void print(Message paramMessage, Appendable paramAppendable)
    throws IOException
  {
    print(paramMessage, new TextGenerator(paramAppendable, null));
  }
  
  public static void print(UnknownFieldSet paramUnknownFieldSet, Appendable paramAppendable)
    throws IOException
  {
    printUnknownFields(paramUnknownFieldSet, new TextGenerator(paramAppendable, null));
  }
  
  private static void printField(Descriptors.FieldDescriptor paramFieldDescriptor, Object paramObject, TextGenerator paramTextGenerator)
    throws IOException
  {
    if (paramFieldDescriptor.isRepeated())
    {
      paramObject = ((List)paramObject).iterator();
      while (((Iterator)paramObject).hasNext()) {
        printSingleField(paramFieldDescriptor, ((Iterator)paramObject).next(), paramTextGenerator);
      }
    }
    printSingleField(paramFieldDescriptor, paramObject, paramTextGenerator);
  }
  
  public static void printField(Descriptors.FieldDescriptor paramFieldDescriptor, Object paramObject, Appendable paramAppendable)
    throws IOException
  {
    printField(paramFieldDescriptor, paramObject, new TextGenerator(paramAppendable, null));
  }
  
  public static String printFieldToString(Descriptors.FieldDescriptor paramFieldDescriptor, Object paramObject)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      printField(paramFieldDescriptor, paramObject, localStringBuilder);
      paramFieldDescriptor = localStringBuilder.toString();
      return paramFieldDescriptor;
    }
    catch (IOException paramFieldDescriptor)
    {
      throw new RuntimeException("Writing to a StringBuilder threw an IOException (should never happen).", paramFieldDescriptor);
    }
  }
  
  private static void printFieldValue(Descriptors.FieldDescriptor paramFieldDescriptor, Object paramObject, TextGenerator paramTextGenerator)
    throws IOException
  {
    switch (paramFieldDescriptor.getType())
    {
    default: 
      return;
    case ???: 
    case ???: 
    case ???: 
    case ???: 
    case ???: 
    case ???: 
    case ???: 
    case ???: 
    case ???: 
      paramTextGenerator.print(paramObject.toString());
      return;
    case ???: 
    case ???: 
      paramTextGenerator.print(unsignedToString(((Integer)paramObject).intValue()));
      return;
    case ???: 
    case ???: 
      paramTextGenerator.print(unsignedToString(((Long)paramObject).longValue()));
      return;
    case ???: 
      paramTextGenerator.print("\"");
      paramTextGenerator.print(escapeText((String)paramObject));
      paramTextGenerator.print("\"");
      return;
    case ???: 
      paramTextGenerator.print("\"");
      paramTextGenerator.print(escapeBytes((ByteString)paramObject));
      paramTextGenerator.print("\"");
      return;
    case ???: 
      paramTextGenerator.print(((Descriptors.EnumValueDescriptor)paramObject).getName());
      return;
    }
    print((Message)paramObject, paramTextGenerator);
  }
  
  private static void printSingleField(Descriptors.FieldDescriptor paramFieldDescriptor, Object paramObject, TextGenerator paramTextGenerator)
    throws IOException
  {
    if (paramFieldDescriptor.isExtension())
    {
      paramTextGenerator.print("[");
      if ((paramFieldDescriptor.getContainingType().getOptions().getMessageSetWireFormat()) && (paramFieldDescriptor.getType() == Descriptors.FieldDescriptor.Type.MESSAGE) && (paramFieldDescriptor.isOptional()) && (paramFieldDescriptor.getExtensionScope() == paramFieldDescriptor.getMessageType()))
      {
        paramTextGenerator.print(paramFieldDescriptor.getMessageType().getFullName());
        paramTextGenerator.print("]");
        label71:
        if (paramFieldDescriptor.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) {
          break label172;
        }
        paramTextGenerator.print(" {\n");
        paramTextGenerator.indent();
      }
    }
    for (;;)
    {
      printFieldValue(paramFieldDescriptor, paramObject, paramTextGenerator);
      if (paramFieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE)
      {
        paramTextGenerator.outdent();
        paramTextGenerator.print("}");
      }
      paramTextGenerator.print("\n");
      return;
      paramTextGenerator.print(paramFieldDescriptor.getFullName());
      break;
      if (paramFieldDescriptor.getType() == Descriptors.FieldDescriptor.Type.GROUP)
      {
        paramTextGenerator.print(paramFieldDescriptor.getMessageType().getName());
        break label71;
      }
      paramTextGenerator.print(paramFieldDescriptor.getName());
      break label71;
      label172:
      paramTextGenerator.print(": ");
    }
  }
  
  public static String printToString(Message paramMessage)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      print(paramMessage, localStringBuilder);
      paramMessage = localStringBuilder.toString();
      return paramMessage;
    }
    catch (IOException paramMessage)
    {
      throw new RuntimeException("Writing to a StringBuilder threw an IOException (should never happen).", paramMessage);
    }
  }
  
  public static String printToString(UnknownFieldSet paramUnknownFieldSet)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      print(paramUnknownFieldSet, localStringBuilder);
      paramUnknownFieldSet = localStringBuilder.toString();
      return paramUnknownFieldSet;
    }
    catch (IOException paramUnknownFieldSet)
    {
      throw new RuntimeException("Writing to a StringBuilder threw an IOException (should never happen).", paramUnknownFieldSet);
    }
  }
  
  private static void printUnknownFields(UnknownFieldSet paramUnknownFieldSet, TextGenerator paramTextGenerator)
    throws IOException
  {
    paramUnknownFieldSet = paramUnknownFieldSet.asMap().entrySet().iterator();
    while (paramUnknownFieldSet.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramUnknownFieldSet.next();
      new StringBuilder().append(((Integer)localEntry.getKey()).toString()).append(": ").toString();
      Object localObject1 = (UnknownFieldSet.Field)localEntry.getValue();
      Object localObject2 = ((UnknownFieldSet.Field)localObject1).getVarintList().iterator();
      long l;
      while (((Iterator)localObject2).hasNext())
      {
        l = ((Long)((Iterator)localObject2).next()).longValue();
        paramTextGenerator.print(((Integer)localEntry.getKey()).toString());
        paramTextGenerator.print(": ");
        paramTextGenerator.print(unsignedToString(l));
        paramTextGenerator.print("\n");
      }
      localObject2 = ((UnknownFieldSet.Field)localObject1).getFixed32List().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        int i = ((Integer)((Iterator)localObject2).next()).intValue();
        paramTextGenerator.print(((Integer)localEntry.getKey()).toString());
        paramTextGenerator.print(": ");
        paramTextGenerator.print(String.format((Locale)null, "0x%08x", new Object[] { Integer.valueOf(i) }));
        paramTextGenerator.print("\n");
      }
      localObject2 = ((UnknownFieldSet.Field)localObject1).getFixed64List().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        l = ((Long)((Iterator)localObject2).next()).longValue();
        paramTextGenerator.print(((Integer)localEntry.getKey()).toString());
        paramTextGenerator.print(": ");
        paramTextGenerator.print(String.format((Locale)null, "0x%016x", new Object[] { Long.valueOf(l) }));
        paramTextGenerator.print("\n");
      }
      localObject2 = ((UnknownFieldSet.Field)localObject1).getLengthDelimitedList().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ByteString localByteString = (ByteString)((Iterator)localObject2).next();
        paramTextGenerator.print(((Integer)localEntry.getKey()).toString());
        paramTextGenerator.print(": \"");
        paramTextGenerator.print(escapeBytes(localByteString));
        paramTextGenerator.print("\"\n");
      }
      localObject1 = ((UnknownFieldSet.Field)localObject1).getGroupList().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (UnknownFieldSet)((Iterator)localObject1).next();
        paramTextGenerator.print(((Integer)localEntry.getKey()).toString());
        paramTextGenerator.print(" {\n");
        paramTextGenerator.indent();
        printUnknownFields((UnknownFieldSet)localObject2, paramTextGenerator);
        paramTextGenerator.outdent();
        paramTextGenerator.print("}\n");
      }
    }
  }
  
  private static StringBuilder toStringBuilder(Readable paramReadable)
    throws IOException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    CharBuffer localCharBuffer = CharBuffer.allocate(4096);
    for (;;)
    {
      int i = paramReadable.read(localCharBuffer);
      if (i == -1) {
        return localStringBuilder;
      }
      localCharBuffer.flip();
      localStringBuilder.append(localCharBuffer, 0, i);
    }
  }
  
  static ByteString unescapeBytes(CharSequence paramCharSequence)
    throws TextFormat.InvalidEscapeSequenceException
  {
    byte[] arrayOfByte = new byte[paramCharSequence.length()];
    int m = 0;
    int j = 0;
    if (j < paramCharSequence.length())
    {
      int i = paramCharSequence.charAt(j);
      int k;
      char c;
      int n;
      if (i == 92) {
        if (j + 1 < paramCharSequence.length())
        {
          k = j + 1;
          c = paramCharSequence.charAt(k);
          if (isOctal(c))
          {
            n = digitValue(c);
            i = n;
            j = k;
            if (k + 1 < paramCharSequence.length())
            {
              i = n;
              j = k;
              if (isOctal(paramCharSequence.charAt(k + 1)))
              {
                j = k + 1;
                i = n * 8 + digitValue(paramCharSequence.charAt(j));
              }
            }
            n = i;
            k = j;
            if (j + 1 < paramCharSequence.length())
            {
              n = i;
              k = j;
              if (isOctal(paramCharSequence.charAt(j + 1)))
              {
                k = j + 1;
                n = i * 8 + digitValue(paramCharSequence.charAt(k));
              }
            }
            arrayOfByte[m] = ((byte)n);
            i = m + 1;
            j = k;
          }
        }
      }
      for (;;)
      {
        j += 1;
        m = i;
        break;
        switch (c)
        {
        default: 
          throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\" + c + '\'');
        case 'a': 
          arrayOfByte[m] = 7;
          i = m + 1;
          j = k;
          break;
        case 'b': 
          arrayOfByte[m] = 8;
          i = m + 1;
          j = k;
          break;
        case 'f': 
          arrayOfByte[m] = 12;
          i = m + 1;
          j = k;
          break;
        case 'n': 
          arrayOfByte[m] = 10;
          i = m + 1;
          j = k;
          break;
        case 'r': 
          arrayOfByte[m] = 13;
          i = m + 1;
          j = k;
          break;
        case 't': 
          arrayOfByte[m] = 9;
          i = m + 1;
          j = k;
          break;
        case 'v': 
          arrayOfByte[m] = 11;
          i = m + 1;
          j = k;
          break;
        case '\\': 
          arrayOfByte[m] = 92;
          i = m + 1;
          j = k;
          break;
        case '\'': 
          arrayOfByte[m] = 39;
          i = m + 1;
          j = k;
          break;
        case '"': 
          arrayOfByte[m] = 34;
          i = m + 1;
          j = k;
          break;
        case 'x': 
          if ((k + 1 < paramCharSequence.length()) && (isHex(paramCharSequence.charAt(k + 1))))
          {
            n = k + 1;
            k = digitValue(paramCharSequence.charAt(n));
            i = k;
            j = n;
            if (n + 1 < paramCharSequence.length())
            {
              i = k;
              j = n;
              if (isHex(paramCharSequence.charAt(n + 1)))
              {
                j = n + 1;
                i = k * 16 + digitValue(paramCharSequence.charAt(j));
              }
            }
            arrayOfByte[m] = ((byte)i);
            i = m + 1;
          }
          else
          {
            throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\x' with no digits");
            throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\' at end of string.");
            arrayOfByte[m] = ((byte)i);
            i = m + 1;
          }
          break;
        }
      }
    }
    return ByteString.copyFrom(arrayOfByte, 0, m);
  }
  
  static String unescapeText(String paramString)
    throws TextFormat.InvalidEscapeSequenceException
  {
    return unescapeBytes(paramString).toStringUtf8();
  }
  
  private static String unsignedToString(int paramInt)
  {
    if (paramInt >= 0) {
      return Integer.toString(paramInt);
    }
    return Long.toString(paramInt & 0xFFFFFFFF);
  }
  
  private static String unsignedToString(long paramLong)
  {
    if (paramLong >= 0L) {
      return Long.toString(paramLong);
    }
    return BigInteger.valueOf(0x7FFFFFFFFFFFFFFF & paramLong).setBit(63).toString();
  }
  
  static class InvalidEscapeSequenceException
    extends IOException
  {
    private static final long serialVersionUID = -8164033650142593304L;
    
    InvalidEscapeSequenceException(String paramString)
    {
      super();
    }
  }
  
  public static class ParseException
    extends IOException
  {
    private static final long serialVersionUID = 3196188060225107702L;
    
    public ParseException(String paramString)
    {
      super();
    }
  }
  
  private static final class TextGenerator
  {
    private boolean atStartOfLine = true;
    private final StringBuilder indent = new StringBuilder();
    private Appendable output;
    
    private TextGenerator(Appendable paramAppendable)
    {
      this.output = paramAppendable;
    }
    
    private void write(CharSequence paramCharSequence, int paramInt)
      throws IOException
    {
      if (paramInt == 0) {
        return;
      }
      if (this.atStartOfLine)
      {
        this.atStartOfLine = false;
        this.output.append(this.indent);
      }
      this.output.append(paramCharSequence);
    }
    
    public void indent()
    {
      this.indent.append("  ");
    }
    
    public void outdent()
    {
      int i = this.indent.length();
      if (i == 0) {
        throw new IllegalArgumentException(" Outdent() without matching Indent().");
      }
      this.indent.delete(i - 2, i);
    }
    
    public void print(CharSequence paramCharSequence)
      throws IOException
    {
      int m = paramCharSequence.length();
      int j = 0;
      int i = 0;
      while (i < m)
      {
        int k = j;
        if (paramCharSequence.charAt(i) == '\n')
        {
          write(paramCharSequence.subSequence(j, m), i - j + 1);
          k = i + 1;
          this.atStartOfLine = true;
        }
        i += 1;
        j = k;
      }
      write(paramCharSequence.subSequence(j, m), m - j);
    }
  }
  
  private static final class Tokenizer
  {
    private static final Pattern DOUBLE_INFINITY = Pattern.compile("-?inf(inity)?", 2);
    private static final Pattern FLOAT_INFINITY = Pattern.compile("-?inf(inity)?f?", 2);
    private static final Pattern FLOAT_NAN = Pattern.compile("nanf?", 2);
    private static final Pattern TOKEN;
    private static final Pattern WHITESPACE = Pattern.compile("(\\s|(#.*$))++", 8);
    private int column = 0;
    private String currentToken;
    private int line = 0;
    private final Matcher matcher;
    private int pos = 0;
    private int previousColumn = 0;
    private int previousLine = 0;
    private final CharSequence text;
    
    static
    {
      TOKEN = Pattern.compile("[a-zA-Z_][0-9a-zA-Z_+-]*+|[0-9+-][0-9a-zA-Z_.+-]*+|\"([^\"\n\\\\]|\\\\.)*+(\"|\\\\?$)|'([^\"\n\\\\]|\\\\.)*+('|\\\\?$)", 8);
    }
    
    private Tokenizer(CharSequence paramCharSequence)
    {
      this.text = paramCharSequence;
      this.matcher = WHITESPACE.matcher(paramCharSequence);
      skipWhitespace();
      nextToken();
    }
    
    private TextFormat.ParseException floatParseException(NumberFormatException paramNumberFormatException)
    {
      return parseException("Couldn't parse number: " + paramNumberFormatException.getMessage());
    }
    
    private TextFormat.ParseException integerParseException(NumberFormatException paramNumberFormatException)
    {
      return parseException("Couldn't parse integer: " + paramNumberFormatException.getMessage());
    }
    
    private void skipWhitespace()
    {
      this.matcher.usePattern(WHITESPACE);
      if (this.matcher.lookingAt()) {
        this.matcher.region(this.matcher.end(), this.matcher.regionEnd());
      }
    }
    
    public boolean atEnd()
    {
      return this.currentToken.length() == 0;
    }
    
    public void consume(String paramString)
      throws TextFormat.ParseException
    {
      if (!tryConsume(paramString)) {
        throw parseException("Expected \"" + paramString + "\".");
      }
    }
    
    public boolean consumeBoolean()
      throws TextFormat.ParseException
    {
      if (this.currentToken.equals("true"))
      {
        nextToken();
        return true;
      }
      if (this.currentToken.equals("false"))
      {
        nextToken();
        return false;
      }
      throw parseException("Expected \"true\" or \"false\".");
    }
    
    public ByteString consumeByteString()
      throws TextFormat.ParseException
    {
      int i = 0;
      if (this.currentToken.length() > 0) {
        i = this.currentToken.charAt(0);
      }
      if ((i != 34) && (i != 39)) {
        throw parseException("Expected string.");
      }
      if ((this.currentToken.length() < 2) || (this.currentToken.charAt(this.currentToken.length() - 1) != i)) {
        throw parseException("String missing ending quote.");
      }
      try
      {
        ByteString localByteString = TextFormat.unescapeBytes(this.currentToken.substring(1, this.currentToken.length() - 1));
        nextToken();
        return localByteString;
      }
      catch (TextFormat.InvalidEscapeSequenceException localInvalidEscapeSequenceException)
      {
        throw parseException(localInvalidEscapeSequenceException.getMessage());
      }
    }
    
    public double consumeDouble()
      throws TextFormat.ParseException
    {
      if (DOUBLE_INFINITY.matcher(this.currentToken).matches())
      {
        boolean bool = this.currentToken.startsWith("-");
        nextToken();
        if (bool) {
          return Double.NEGATIVE_INFINITY;
        }
        return Double.POSITIVE_INFINITY;
      }
      if (this.currentToken.equalsIgnoreCase("nan"))
      {
        nextToken();
        return NaN.0D;
      }
      try
      {
        double d = Double.parseDouble(this.currentToken);
        nextToken();
        return d;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        throw floatParseException(localNumberFormatException);
      }
    }
    
    public float consumeFloat()
      throws TextFormat.ParseException
    {
      if (FLOAT_INFINITY.matcher(this.currentToken).matches())
      {
        boolean bool = this.currentToken.startsWith("-");
        nextToken();
        if (bool) {
          return Float.NEGATIVE_INFINITY;
        }
        return Float.POSITIVE_INFINITY;
      }
      if (FLOAT_NAN.matcher(this.currentToken).matches())
      {
        nextToken();
        return NaN.0F;
      }
      try
      {
        float f = Float.parseFloat(this.currentToken);
        nextToken();
        return f;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        throw floatParseException(localNumberFormatException);
      }
    }
    
    public String consumeIdentifier()
      throws TextFormat.ParseException
    {
      int i = 0;
      while (i < this.currentToken.length())
      {
        int j = this.currentToken.charAt(i);
        if (((97 <= j) && (j <= 122)) || ((65 <= j) && (j <= 90)) || ((48 <= j) && (j <= 57)) || (j == 95) || (j == 46)) {
          i += 1;
        } else {
          throw parseException("Expected identifier.");
        }
      }
      String str = this.currentToken;
      nextToken();
      return str;
    }
    
    public int consumeInt32()
      throws TextFormat.ParseException
    {
      try
      {
        int i = TextFormat.parseInt32(this.currentToken);
        nextToken();
        return i;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        throw integerParseException(localNumberFormatException);
      }
    }
    
    public long consumeInt64()
      throws TextFormat.ParseException
    {
      try
      {
        long l = TextFormat.parseInt64(this.currentToken);
        nextToken();
        return l;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        throw integerParseException(localNumberFormatException);
      }
    }
    
    public String consumeString()
      throws TextFormat.ParseException
    {
      return consumeByteString().toStringUtf8();
    }
    
    public int consumeUInt32()
      throws TextFormat.ParseException
    {
      try
      {
        int i = TextFormat.parseUInt32(this.currentToken);
        nextToken();
        return i;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        throw integerParseException(localNumberFormatException);
      }
    }
    
    public long consumeUInt64()
      throws TextFormat.ParseException
    {
      try
      {
        long l = TextFormat.parseUInt64(this.currentToken);
        nextToken();
        return l;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        throw integerParseException(localNumberFormatException);
      }
    }
    
    public boolean lookingAtInteger()
    {
      if (this.currentToken.length() == 0) {}
      int i;
      do
      {
        return false;
        i = this.currentToken.charAt(0);
      } while (((48 > i) || (i > 57)) && (i != 45) && (i != 43));
      return true;
    }
    
    public void nextToken()
    {
      this.previousLine = this.line;
      this.previousColumn = this.column;
      if (this.pos < this.matcher.regionStart())
      {
        if (this.text.charAt(this.pos) == '\n') {
          this.line += 1;
        }
        for (this.column = 0;; this.column += 1)
        {
          this.pos += 1;
          break;
        }
      }
      if (this.matcher.regionStart() == this.matcher.regionEnd())
      {
        this.currentToken = "";
        return;
      }
      this.matcher.usePattern(TOKEN);
      if (this.matcher.lookingAt())
      {
        this.currentToken = this.matcher.group();
        this.matcher.region(this.matcher.end(), this.matcher.regionEnd());
      }
      for (;;)
      {
        skipWhitespace();
        return;
        this.currentToken = String.valueOf(this.text.charAt(this.pos));
        this.matcher.region(this.pos + 1, this.matcher.regionEnd());
      }
    }
    
    public TextFormat.ParseException parseException(String paramString)
    {
      return new TextFormat.ParseException(this.line + 1 + ":" + (this.column + 1) + ": " + paramString);
    }
    
    public TextFormat.ParseException parseExceptionPreviousToken(String paramString)
    {
      return new TextFormat.ParseException(this.previousLine + 1 + ":" + (this.previousColumn + 1) + ": " + paramString);
    }
    
    public boolean tryConsume(String paramString)
    {
      if (this.currentToken.equals(paramString))
      {
        nextToken();
        return true;
      }
      return false;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/google/protobuf/TextFormat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */