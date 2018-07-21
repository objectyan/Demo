package com.google.protobuf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

final class FieldSet<FieldDescriptorType extends FieldDescriptorLite<FieldDescriptorType>>
{
  private static final FieldSet DEFAULT_INSTANCE = new FieldSet(true);
  private Map<FieldDescriptorType, Object> fields;
  
  private FieldSet()
  {
    this.fields = new TreeMap();
  }
  
  private FieldSet(boolean paramBoolean)
  {
    this.fields = Collections.emptyMap();
  }
  
  private static int computeElementSize(WireFormat.FieldType paramFieldType, int paramInt, Object paramObject)
  {
    int i = CodedOutputStream.computeTagSize(paramInt);
    paramInt = i;
    if (paramFieldType == WireFormat.FieldType.GROUP) {
      paramInt = i * 2;
    }
    return computeElementSizeNoTag(paramFieldType, paramObject) + paramInt;
  }
  
  private static int computeElementSizeNoTag(WireFormat.FieldType paramFieldType, Object paramObject)
  {
    switch (paramFieldType)
    {
    default: 
      throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
    case ???: 
      return CodedOutputStream.computeDoubleSizeNoTag(((Double)paramObject).doubleValue());
    case ???: 
      return CodedOutputStream.computeFloatSizeNoTag(((Float)paramObject).floatValue());
    case ???: 
      return CodedOutputStream.computeInt64SizeNoTag(((Long)paramObject).longValue());
    case ???: 
      return CodedOutputStream.computeUInt64SizeNoTag(((Long)paramObject).longValue());
    case ???: 
      return CodedOutputStream.computeInt32SizeNoTag(((Integer)paramObject).intValue());
    case ???: 
      return CodedOutputStream.computeFixed64SizeNoTag(((Long)paramObject).longValue());
    case ???: 
      return CodedOutputStream.computeFixed32SizeNoTag(((Integer)paramObject).intValue());
    case ???: 
      return CodedOutputStream.computeBoolSizeNoTag(((Boolean)paramObject).booleanValue());
    case ???: 
      return CodedOutputStream.computeStringSizeNoTag((String)paramObject);
    case ???: 
      return CodedOutputStream.computeGroupSizeNoTag((MessageLite)paramObject);
    case ???: 
      return CodedOutputStream.computeMessageSizeNoTag((MessageLite)paramObject);
    case ???: 
      return CodedOutputStream.computeBytesSizeNoTag((ByteString)paramObject);
    case ???: 
      return CodedOutputStream.computeUInt32SizeNoTag(((Integer)paramObject).intValue());
    case ???: 
      return CodedOutputStream.computeSFixed32SizeNoTag(((Integer)paramObject).intValue());
    case ???: 
      return CodedOutputStream.computeSFixed64SizeNoTag(((Long)paramObject).longValue());
    case ???: 
      return CodedOutputStream.computeSInt32SizeNoTag(((Integer)paramObject).intValue());
    case ???: 
      return CodedOutputStream.computeSInt64SizeNoTag(((Long)paramObject).longValue());
    }
    return CodedOutputStream.computeEnumSizeNoTag(((Internal.EnumLite)paramObject).getNumber());
  }
  
  public static int computeFieldSize(FieldDescriptorLite<?> paramFieldDescriptorLite, Object paramObject)
  {
    WireFormat.FieldType localFieldType = paramFieldDescriptorLite.getLiteType();
    int k = paramFieldDescriptorLite.getNumber();
    if (paramFieldDescriptorLite.isRepeated())
    {
      int j;
      if (paramFieldDescriptorLite.isPacked())
      {
        i = 0;
        paramFieldDescriptorLite = ((List)paramObject).iterator();
        while (paramFieldDescriptorLite.hasNext()) {
          i += computeElementSizeNoTag(localFieldType, paramFieldDescriptorLite.next());
        }
        j = CodedOutputStream.computeTagSize(k) + i + CodedOutputStream.computeRawVarint32Size(i);
        return j;
      }
      int i = 0;
      paramFieldDescriptorLite = ((List)paramObject).iterator();
      for (;;)
      {
        j = i;
        if (!paramFieldDescriptorLite.hasNext()) {
          break;
        }
        i += computeElementSize(localFieldType, k, paramFieldDescriptorLite.next());
      }
    }
    return computeElementSize(localFieldType, k, paramObject);
  }
  
  public static <T extends FieldDescriptorLite<T>> FieldSet<T> emptySet()
  {
    return DEFAULT_INSTANCE;
  }
  
  static int getWireFormatForFieldType(WireFormat.FieldType paramFieldType, boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2;
    }
    return paramFieldType.getWireType();
  }
  
  public static <T extends FieldDescriptorLite<T>> FieldSet<T> newFieldSet()
  {
    return new FieldSet();
  }
  
  public static Object readPrimitiveField(CodedInputStream paramCodedInputStream, WireFormat.FieldType paramFieldType)
    throws IOException
  {
    switch (paramFieldType)
    {
    default: 
      throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
    case ???: 
      return Double.valueOf(paramCodedInputStream.readDouble());
    case ???: 
      return Float.valueOf(paramCodedInputStream.readFloat());
    case ???: 
      return Long.valueOf(paramCodedInputStream.readInt64());
    case ???: 
      return Long.valueOf(paramCodedInputStream.readUInt64());
    case ???: 
      return Integer.valueOf(paramCodedInputStream.readInt32());
    case ???: 
      return Long.valueOf(paramCodedInputStream.readFixed64());
    case ???: 
      return Integer.valueOf(paramCodedInputStream.readFixed32());
    case ???: 
      return Boolean.valueOf(paramCodedInputStream.readBool());
    case ???: 
      return paramCodedInputStream.readString();
    case ???: 
      return paramCodedInputStream.readBytes();
    case ???: 
      return Integer.valueOf(paramCodedInputStream.readUInt32());
    case ???: 
      return Integer.valueOf(paramCodedInputStream.readSFixed32());
    case ???: 
      return Long.valueOf(paramCodedInputStream.readSFixed64());
    case ???: 
      return Integer.valueOf(paramCodedInputStream.readSInt32());
    case ???: 
      return Long.valueOf(paramCodedInputStream.readSInt64());
    case ???: 
      throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
    case ???: 
      throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
    }
    throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
  }
  
  private static void verifyType(WireFormat.FieldType paramFieldType, Object paramObject)
  {
    if (paramObject == null) {
      throw new NullPointerException();
    }
    boolean bool = false;
    switch (1.$SwitchMap$com$google$protobuf$WireFormat$JavaType[paramFieldType.getJavaType().ordinal()])
    {
    }
    while (!bool)
    {
      throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
      bool = paramObject instanceof Integer;
      continue;
      bool = paramObject instanceof Long;
      continue;
      bool = paramObject instanceof Float;
      continue;
      bool = paramObject instanceof Double;
      continue;
      bool = paramObject instanceof Boolean;
      continue;
      bool = paramObject instanceof String;
      continue;
      bool = paramObject instanceof ByteString;
      continue;
      bool = paramObject instanceof Internal.EnumLite;
      continue;
      bool = paramObject instanceof MessageLite;
    }
  }
  
  private static void writeElement(CodedOutputStream paramCodedOutputStream, WireFormat.FieldType paramFieldType, int paramInt, Object paramObject)
    throws IOException
  {
    if (paramFieldType == WireFormat.FieldType.GROUP)
    {
      paramCodedOutputStream.writeGroup(paramInt, (MessageLite)paramObject);
      return;
    }
    paramCodedOutputStream.writeTag(paramInt, getWireFormatForFieldType(paramFieldType, false));
    writeElementNoTag(paramCodedOutputStream, paramFieldType, paramObject);
  }
  
  private static void writeElementNoTag(CodedOutputStream paramCodedOutputStream, WireFormat.FieldType paramFieldType, Object paramObject)
    throws IOException
  {
    switch (paramFieldType)
    {
    default: 
      return;
    case ???: 
      paramCodedOutputStream.writeDoubleNoTag(((Double)paramObject).doubleValue());
      return;
    case ???: 
      paramCodedOutputStream.writeFloatNoTag(((Float)paramObject).floatValue());
      return;
    case ???: 
      paramCodedOutputStream.writeInt64NoTag(((Long)paramObject).longValue());
      return;
    case ???: 
      paramCodedOutputStream.writeUInt64NoTag(((Long)paramObject).longValue());
      return;
    case ???: 
      paramCodedOutputStream.writeInt32NoTag(((Integer)paramObject).intValue());
      return;
    case ???: 
      paramCodedOutputStream.writeFixed64NoTag(((Long)paramObject).longValue());
      return;
    case ???: 
      paramCodedOutputStream.writeFixed32NoTag(((Integer)paramObject).intValue());
      return;
    case ???: 
      paramCodedOutputStream.writeBoolNoTag(((Boolean)paramObject).booleanValue());
      return;
    case ???: 
      paramCodedOutputStream.writeStringNoTag((String)paramObject);
      return;
    case ???: 
      paramCodedOutputStream.writeGroupNoTag((MessageLite)paramObject);
      return;
    case ???: 
      paramCodedOutputStream.writeMessageNoTag((MessageLite)paramObject);
      return;
    case ???: 
      paramCodedOutputStream.writeBytesNoTag((ByteString)paramObject);
      return;
    case ???: 
      paramCodedOutputStream.writeUInt32NoTag(((Integer)paramObject).intValue());
      return;
    case ???: 
      paramCodedOutputStream.writeSFixed32NoTag(((Integer)paramObject).intValue());
      return;
    case ???: 
      paramCodedOutputStream.writeSFixed64NoTag(((Long)paramObject).longValue());
      return;
    case ???: 
      paramCodedOutputStream.writeSInt32NoTag(((Integer)paramObject).intValue());
      return;
    case ???: 
      paramCodedOutputStream.writeSInt64NoTag(((Long)paramObject).longValue());
      return;
    }
    paramCodedOutputStream.writeEnumNoTag(((Internal.EnumLite)paramObject).getNumber());
  }
  
  public static void writeField(FieldDescriptorLite<?> paramFieldDescriptorLite, Object paramObject, CodedOutputStream paramCodedOutputStream)
    throws IOException
  {
    WireFormat.FieldType localFieldType = paramFieldDescriptorLite.getLiteType();
    int i = paramFieldDescriptorLite.getNumber();
    if (paramFieldDescriptorLite.isRepeated())
    {
      paramObject = (List)paramObject;
      if (paramFieldDescriptorLite.isPacked())
      {
        paramCodedOutputStream.writeTag(i, 2);
        i = 0;
        paramFieldDescriptorLite = ((List)paramObject).iterator();
        while (paramFieldDescriptorLite.hasNext()) {
          i += computeElementSizeNoTag(localFieldType, paramFieldDescriptorLite.next());
        }
        paramCodedOutputStream.writeRawVarint32(i);
        paramFieldDescriptorLite = ((List)paramObject).iterator();
        while (paramFieldDescriptorLite.hasNext()) {
          writeElementNoTag(paramCodedOutputStream, localFieldType, paramFieldDescriptorLite.next());
        }
      }
      paramFieldDescriptorLite = ((List)paramObject).iterator();
      while (paramFieldDescriptorLite.hasNext()) {
        writeElement(paramCodedOutputStream, localFieldType, i, paramFieldDescriptorLite.next());
      }
    }
    writeElement(paramCodedOutputStream, localFieldType, i, paramObject);
  }
  
  public void addRepeatedField(FieldDescriptorType paramFieldDescriptorType, Object paramObject)
  {
    if (!paramFieldDescriptorType.isRepeated()) {
      throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
    }
    verifyType(paramFieldDescriptorType.getLiteType(), paramObject);
    Object localObject = this.fields.get(paramFieldDescriptorType);
    if (localObject == null)
    {
      localObject = new ArrayList();
      this.fields.put(paramFieldDescriptorType, localObject);
    }
    for (paramFieldDescriptorType = (FieldDescriptorType)localObject;; paramFieldDescriptorType = (List)localObject)
    {
      paramFieldDescriptorType.add(paramObject);
      return;
    }
  }
  
  public void clear()
  {
    this.fields.clear();
  }
  
  public void clearField(FieldDescriptorType paramFieldDescriptorType)
  {
    this.fields.remove(paramFieldDescriptorType);
  }
  
  public Map<FieldDescriptorType, Object> getAllFields()
  {
    return Collections.unmodifiableMap(this.fields);
  }
  
  public Object getField(FieldDescriptorType paramFieldDescriptorType)
  {
    return this.fields.get(paramFieldDescriptorType);
  }
  
  public int getMessageSetSerializedSize()
  {
    int i = 0;
    Iterator localIterator = this.fields.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      FieldDescriptorLite localFieldDescriptorLite = (FieldDescriptorLite)localEntry.getKey();
      if ((localFieldDescriptorLite.getLiteJavaType() == WireFormat.JavaType.MESSAGE) && (!localFieldDescriptorLite.isRepeated()) && (!localFieldDescriptorLite.isPacked())) {
        i += CodedOutputStream.computeMessageSetExtensionSize(((FieldDescriptorLite)localEntry.getKey()).getNumber(), (MessageLite)localEntry.getValue());
      } else {
        i += computeFieldSize(localFieldDescriptorLite, localEntry.getValue());
      }
    }
    return i;
  }
  
  public Object getRepeatedField(FieldDescriptorType paramFieldDescriptorType, int paramInt)
  {
    if (!paramFieldDescriptorType.isRepeated()) {
      throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }
    paramFieldDescriptorType = this.fields.get(paramFieldDescriptorType);
    if (paramFieldDescriptorType == null) {
      throw new IndexOutOfBoundsException();
    }
    return ((List)paramFieldDescriptorType).get(paramInt);
  }
  
  public int getRepeatedFieldCount(FieldDescriptorType paramFieldDescriptorType)
  {
    if (!paramFieldDescriptorType.isRepeated()) {
      throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }
    paramFieldDescriptorType = this.fields.get(paramFieldDescriptorType);
    if (paramFieldDescriptorType == null) {
      return 0;
    }
    return ((List)paramFieldDescriptorType).size();
  }
  
  public int getSerializedSize()
  {
    int i = 0;
    Iterator localIterator = this.fields.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      i += computeFieldSize((FieldDescriptorLite)localEntry.getKey(), localEntry.getValue());
    }
    return i;
  }
  
  public boolean hasField(FieldDescriptorType paramFieldDescriptorType)
  {
    if (paramFieldDescriptorType.isRepeated()) {
      throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
    }
    return this.fields.get(paramFieldDescriptorType) != null;
  }
  
  public boolean isInitialized()
  {
    Iterator localIterator = this.fields.entrySet().iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        FieldDescriptorLite localFieldDescriptorLite = (FieldDescriptorLite)((Map.Entry)localObject).getKey();
        if (localFieldDescriptorLite.getLiteJavaType() == WireFormat.JavaType.MESSAGE)
        {
          if (localFieldDescriptorLite.isRepeated())
          {
            localObject = ((List)((Map.Entry)localObject).getValue()).iterator();
            if (!((Iterator)localObject).hasNext()) {
              continue;
            }
            if (((MessageLite)((Iterator)localObject).next()).isInitialized()) {
              break;
            }
            return false;
          }
          if (!((MessageLite)((Map.Entry)localObject).getValue()).isInitialized()) {
            return false;
          }
        }
      }
    }
    return true;
  }
  
  public Iterator<Map.Entry<FieldDescriptorType, Object>> iterator()
  {
    return this.fields.entrySet().iterator();
  }
  
  public void makeImmutable()
  {
    Iterator localIterator = this.fields.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((FieldDescriptorLite)localEntry.getKey()).isRepeated())
      {
        List localList = (List)localEntry.getValue();
        this.fields.put(localEntry.getKey(), Collections.unmodifiableList(localList));
      }
    }
    this.fields = Collections.unmodifiableMap(this.fields);
  }
  
  public void mergeFrom(FieldSet<FieldDescriptorType> paramFieldSet)
  {
    paramFieldSet = paramFieldSet.fields.entrySet().iterator();
    while (paramFieldSet.hasNext())
    {
      Object localObject1 = (Map.Entry)paramFieldSet.next();
      FieldDescriptorLite localFieldDescriptorLite = (FieldDescriptorLite)((Map.Entry)localObject1).getKey();
      localObject1 = ((Map.Entry)localObject1).getValue();
      Object localObject2;
      if (localFieldDescriptorLite.isRepeated())
      {
        localObject2 = this.fields.get(localFieldDescriptorLite);
        if (localObject2 == null) {
          this.fields.put(localFieldDescriptorLite, new ArrayList((List)localObject1));
        } else {
          ((List)localObject2).addAll((List)localObject1);
        }
      }
      else if (localFieldDescriptorLite.getLiteJavaType() == WireFormat.JavaType.MESSAGE)
      {
        localObject2 = this.fields.get(localFieldDescriptorLite);
        if (localObject2 == null) {
          this.fields.put(localFieldDescriptorLite, localObject1);
        } else {
          this.fields.put(localFieldDescriptorLite, localFieldDescriptorLite.internalMergeFrom(((MessageLite)localObject2).toBuilder(), (MessageLite)localObject1).build());
        }
      }
      else
      {
        this.fields.put(localFieldDescriptorLite, localObject1);
      }
    }
  }
  
  public void setField(FieldDescriptorType paramFieldDescriptorType, Object paramObject)
  {
    if (paramFieldDescriptorType.isRepeated())
    {
      if (!(paramObject instanceof List)) {
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll((List)paramObject);
      paramObject = localArrayList.iterator();
      while (((Iterator)paramObject).hasNext())
      {
        Object localObject = ((Iterator)paramObject).next();
        verifyType(paramFieldDescriptorType.getLiteType(), localObject);
      }
      paramObject = localArrayList;
    }
    for (;;)
    {
      this.fields.put(paramFieldDescriptorType, paramObject);
      return;
      verifyType(paramFieldDescriptorType.getLiteType(), paramObject);
    }
  }
  
  public void setRepeatedField(FieldDescriptorType paramFieldDescriptorType, int paramInt, Object paramObject)
  {
    if (!paramFieldDescriptorType.isRepeated()) {
      throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }
    Object localObject = this.fields.get(paramFieldDescriptorType);
    if (localObject == null) {
      throw new IndexOutOfBoundsException();
    }
    verifyType(paramFieldDescriptorType.getLiteType(), paramObject);
    ((List)localObject).set(paramInt, paramObject);
  }
  
  public void writeMessageSetTo(CodedOutputStream paramCodedOutputStream)
    throws IOException
  {
    Iterator localIterator = this.fields.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      FieldDescriptorLite localFieldDescriptorLite = (FieldDescriptorLite)localEntry.getKey();
      if ((localFieldDescriptorLite.getLiteJavaType() == WireFormat.JavaType.MESSAGE) && (!localFieldDescriptorLite.isRepeated()) && (!localFieldDescriptorLite.isPacked())) {
        paramCodedOutputStream.writeMessageSetExtension(((FieldDescriptorLite)localEntry.getKey()).getNumber(), (MessageLite)localEntry.getValue());
      } else {
        writeField(localFieldDescriptorLite, localEntry.getValue(), paramCodedOutputStream);
      }
    }
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
    throws IOException
  {
    Iterator localIterator = this.fields.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      writeField((FieldDescriptorLite)localEntry.getKey(), localEntry.getValue(), paramCodedOutputStream);
    }
  }
  
  public static abstract interface FieldDescriptorLite<T extends FieldDescriptorLite<T>>
    extends Comparable<T>
  {
    public abstract Internal.EnumLiteMap<?> getEnumType();
    
    public abstract WireFormat.JavaType getLiteJavaType();
    
    public abstract WireFormat.FieldType getLiteType();
    
    public abstract int getNumber();
    
    public abstract MessageLite.Builder internalMergeFrom(MessageLite.Builder paramBuilder, MessageLite paramMessageLite);
    
    public abstract boolean isPacked();
    
    public abstract boolean isRepeated();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/google/protobuf/FieldSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */