package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class AbstractMessage
  extends AbstractMessageLite
  implements Message
{
  private int memoizedSize = -1;
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof Message)) {
        return false;
      }
      paramObject = (Message)paramObject;
      if (getDescriptorForType() != ((Message)paramObject).getDescriptorForType()) {
        return false;
      }
    } while ((getAllFields().equals(((Message)paramObject).getAllFields())) && (getUnknownFields().equals(((Message)paramObject).getUnknownFields())));
    return false;
  }
  
  public int getSerializedSize()
  {
    int i = this.memoizedSize;
    if (i != -1) {
      return i;
    }
    i = 0;
    boolean bool = getDescriptorForType().getOptions().getMessageSetWireFormat();
    Object localObject1 = getAllFields().entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
      Descriptors.FieldDescriptor localFieldDescriptor = (Descriptors.FieldDescriptor)((Map.Entry)localObject2).getKey();
      localObject2 = ((Map.Entry)localObject2).getValue();
      if ((bool) && (localFieldDescriptor.isExtension()) && (localFieldDescriptor.getType() == Descriptors.FieldDescriptor.Type.MESSAGE) && (!localFieldDescriptor.isRepeated())) {
        i += CodedOutputStream.computeMessageSetExtensionSize(localFieldDescriptor.getNumber(), (Message)localObject2);
      } else {
        i += FieldSet.computeFieldSize(localFieldDescriptor, localObject2);
      }
    }
    localObject1 = getUnknownFields();
    if (bool) {
      i += ((UnknownFieldSet)localObject1).getSerializedSizeAsMessageSet();
    }
    for (;;)
    {
      this.memoizedSize = i;
      return i;
      i += ((UnknownFieldSet)localObject1).getSerializedSize();
    }
  }
  
  public int hashCode()
  {
    return ((getDescriptorForType().hashCode() + 779) * 53 + getAllFields().hashCode()) * 29 + getUnknownFields().hashCode();
  }
  
  public boolean isInitialized()
  {
    Iterator localIterator = getDescriptorForType().getFields().iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (Descriptors.FieldDescriptor)localIterator.next();
      if ((((Descriptors.FieldDescriptor)localObject).isRequired()) && (!hasField((Descriptors.FieldDescriptor)localObject))) {
        return false;
      }
    }
    localIterator = getAllFields().entrySet().iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localObject = (Map.Entry)localIterator.next();
        Descriptors.FieldDescriptor localFieldDescriptor = (Descriptors.FieldDescriptor)((Map.Entry)localObject).getKey();
        if (localFieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE)
        {
          if (localFieldDescriptor.isRepeated())
          {
            localObject = ((List)((Map.Entry)localObject).getValue()).iterator();
            if (!((Iterator)localObject).hasNext()) {
              continue;
            }
            if (((Message)((Iterator)localObject).next()).isInitialized()) {
              break;
            }
            return false;
          }
          if (!((Message)((Map.Entry)localObject).getValue()).isInitialized()) {
            return false;
          }
        }
      }
    }
    return true;
  }
  
  public final String toString()
  {
    return TextFormat.printToString(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
    throws IOException
  {
    boolean bool = getDescriptorForType().getOptions().getMessageSetWireFormat();
    Object localObject1 = getAllFields().entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
      Descriptors.FieldDescriptor localFieldDescriptor = (Descriptors.FieldDescriptor)((Map.Entry)localObject2).getKey();
      localObject2 = ((Map.Entry)localObject2).getValue();
      if ((bool) && (localFieldDescriptor.isExtension()) && (localFieldDescriptor.getType() == Descriptors.FieldDescriptor.Type.MESSAGE) && (!localFieldDescriptor.isRepeated())) {
        paramCodedOutputStream.writeMessageSetExtension(localFieldDescriptor.getNumber(), (Message)localObject2);
      } else {
        FieldSet.writeField(localFieldDescriptor, localObject2, paramCodedOutputStream);
      }
    }
    localObject1 = getUnknownFields();
    if (bool)
    {
      ((UnknownFieldSet)localObject1).writeAsMessageSetTo(paramCodedOutputStream);
      return;
    }
    ((UnknownFieldSet)localObject1).writeTo(paramCodedOutputStream);
  }
  
  public static abstract class Builder<BuilderType extends Builder>
    extends AbstractMessageLite.Builder<BuilderType>
    implements Message.Builder
  {
    private static List<String> findMissingFields(Message paramMessage)
    {
      ArrayList localArrayList = new ArrayList();
      findMissingFields(paramMessage, "", localArrayList);
      return localArrayList;
    }
    
    private static void findMissingFields(Message paramMessage, String paramString, List<String> paramList)
    {
      Iterator localIterator = paramMessage.getDescriptorForType().getFields().iterator();
      Descriptors.FieldDescriptor localFieldDescriptor;
      while (localIterator.hasNext())
      {
        localFieldDescriptor = (Descriptors.FieldDescriptor)localIterator.next();
        if ((localFieldDescriptor.isRequired()) && (!paramMessage.hasField(localFieldDescriptor))) {
          paramList.add(paramString + localFieldDescriptor.getName());
        }
      }
      localIterator = paramMessage.getAllFields().entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        localFieldDescriptor = (Descriptors.FieldDescriptor)((Map.Entry)localObject).getKey();
        localObject = ((Map.Entry)localObject).getValue();
        if (localFieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
          if (localFieldDescriptor.isRepeated())
          {
            int i = 0;
            localObject = ((List)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              findMissingFields((Message)((Iterator)localObject).next(), subMessagePrefix(paramString, localFieldDescriptor, i), paramList);
              i += 1;
            }
          }
          else if (paramMessage.hasField(localFieldDescriptor))
          {
            findMissingFields((Message)localObject, subMessagePrefix(paramString, localFieldDescriptor, -1), paramList);
          }
        }
      }
    }
    
    static boolean mergeFieldFrom(CodedInputStream paramCodedInputStream, UnknownFieldSet.Builder paramBuilder, ExtensionRegistryLite paramExtensionRegistryLite, Message.Builder paramBuilder1, int paramInt)
      throws IOException
    {
      Object localObject = paramBuilder1.getDescriptorForType();
      if ((((Descriptors.Descriptor)localObject).getOptions().getMessageSetWireFormat()) && (paramInt == WireFormat.MESSAGE_SET_ITEM_TAG))
      {
        mergeMessageSetExtensionFromCodedStream(paramCodedInputStream, paramBuilder, paramExtensionRegistryLite, paramBuilder1);
        return true;
      }
      int j = WireFormat.getTagWireType(paramInt);
      int i = WireFormat.getTagFieldNumber(paramInt);
      Message localMessage = null;
      ExtensionRegistry.ExtensionInfo localExtensionInfo;
      if (((Descriptors.Descriptor)localObject).isExtensionNumber(i)) {
        if ((paramExtensionRegistryLite instanceof ExtensionRegistry))
        {
          localExtensionInfo = ((ExtensionRegistry)paramExtensionRegistryLite).findExtensionByNumber((Descriptors.Descriptor)localObject, i);
          if (localExtensionInfo == null) {
            localObject = null;
          }
        }
      }
      while ((localObject == null) || (j != FieldSet.getWireFormatForFieldType(((Descriptors.FieldDescriptor)localObject).getLiteType(), ((Descriptors.FieldDescriptor)localObject).getOptions().getPacked())))
      {
        return paramBuilder.mergeFieldFrom(paramInt, paramCodedInputStream);
        localObject = localExtensionInfo.descriptor;
        localMessage = localExtensionInfo.defaultInstance;
        continue;
        localObject = null;
        continue;
        localObject = ((Descriptors.Descriptor)localObject).findFieldByNumber(i);
      }
      if (((Descriptors.FieldDescriptor)localObject).getOptions().getPacked())
      {
        paramInt = paramCodedInputStream.pushLimit(paramCodedInputStream.readRawVarint32());
        if (((Descriptors.FieldDescriptor)localObject).getLiteType() == WireFormat.FieldType.ENUM) {
          while (paramCodedInputStream.getBytesUntilLimit() > 0)
          {
            i = paramCodedInputStream.readEnum();
            paramBuilder = ((Descriptors.FieldDescriptor)localObject).getEnumType().findValueByNumber(i);
            if (paramBuilder == null) {
              return true;
            }
            paramBuilder1.addRepeatedField((Descriptors.FieldDescriptor)localObject, paramBuilder);
          }
        }
        while (paramCodedInputStream.getBytesUntilLimit() > 0) {
          paramBuilder1.addRepeatedField((Descriptors.FieldDescriptor)localObject, FieldSet.readPrimitiveField(paramCodedInputStream, ((Descriptors.FieldDescriptor)localObject).getLiteType()));
        }
        paramCodedInputStream.popLimit(paramInt);
      }
      for (;;)
      {
        return true;
        switch (AbstractMessage.1.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[localObject.getType().ordinal()])
        {
        default: 
          paramCodedInputStream = FieldSet.readPrimitiveField(paramCodedInputStream, ((Descriptors.FieldDescriptor)localObject).getLiteType());
        }
        for (;;)
        {
          if (((Descriptors.FieldDescriptor)localObject).isRepeated())
          {
            paramBuilder1.addRepeatedField((Descriptors.FieldDescriptor)localObject, paramCodedInputStream);
            break;
            if (localMessage != null) {}
            for (paramBuilder = localMessage.newBuilderForType();; paramBuilder = paramBuilder1.newBuilderForField((Descriptors.FieldDescriptor)localObject))
            {
              if (!((Descriptors.FieldDescriptor)localObject).isRepeated()) {
                paramBuilder.mergeFrom((Message)paramBuilder1.getField((Descriptors.FieldDescriptor)localObject));
              }
              paramCodedInputStream.readGroup(((Descriptors.FieldDescriptor)localObject).getNumber(), paramBuilder, paramExtensionRegistryLite);
              paramCodedInputStream = paramBuilder.build();
              break;
            }
            if (localMessage != null) {}
            for (paramBuilder = localMessage.newBuilderForType();; paramBuilder = paramBuilder1.newBuilderForField((Descriptors.FieldDescriptor)localObject))
            {
              if (!((Descriptors.FieldDescriptor)localObject).isRepeated()) {
                paramBuilder.mergeFrom((Message)paramBuilder1.getField((Descriptors.FieldDescriptor)localObject));
              }
              paramCodedInputStream.readMessage(paramBuilder, paramExtensionRegistryLite);
              paramCodedInputStream = paramBuilder.build();
              break;
            }
            paramInt = paramCodedInputStream.readEnum();
            paramExtensionRegistryLite = ((Descriptors.FieldDescriptor)localObject).getEnumType().findValueByNumber(paramInt);
            paramCodedInputStream = paramExtensionRegistryLite;
            if (paramExtensionRegistryLite == null)
            {
              paramBuilder.mergeVarintField(i, paramInt);
              return true;
            }
          }
        }
        paramBuilder1.setField((Descriptors.FieldDescriptor)localObject, paramCodedInputStream);
      }
    }
    
    private static void mergeMessageSetExtensionFromCodedStream(CodedInputStream paramCodedInputStream, UnknownFieldSet.Builder paramBuilder, ExtensionRegistryLite paramExtensionRegistryLite, Message.Builder paramBuilder1)
      throws IOException
    {
      Descriptors.Descriptor localDescriptor = paramBuilder1.getDescriptorForType();
      int i = 0;
      ByteString localByteString = null;
      Object localObject1 = null;
      Object localObject2 = null;
      int j = paramCodedInputStream.readTag();
      if (j == 0) {}
      for (;;)
      {
        paramCodedInputStream.checkLastTagWas(WireFormat.MESSAGE_SET_ITEM_END_TAG);
        if (localObject1 != null) {
          paramBuilder1.setField((Descriptors.FieldDescriptor)localObject2, ((Message.Builder)localObject1).build());
        }
        return;
        if (j == WireFormat.MESSAGE_SET_TYPE_ID_TAG)
        {
          j = paramCodedInputStream.readUInt32();
          i = j;
          if (j == 0) {
            break;
          }
          if ((paramExtensionRegistryLite instanceof ExtensionRegistry)) {}
          for (Object localObject3 = ((ExtensionRegistry)paramExtensionRegistryLite).findExtensionByNumber(localDescriptor, j);; localObject3 = null)
          {
            if (localObject3 == null) {
              break label212;
            }
            Descriptors.FieldDescriptor localFieldDescriptor = ((ExtensionRegistry.ExtensionInfo)localObject3).descriptor;
            localObject3 = ((ExtensionRegistry.ExtensionInfo)localObject3).defaultInstance.newBuilderForType();
            localObject1 = (Message)paramBuilder1.getField(localFieldDescriptor);
            if (localObject1 != null) {
              ((Message.Builder)localObject3).mergeFrom((Message)localObject1);
            }
            localObject2 = localFieldDescriptor;
            localObject1 = localObject3;
            i = j;
            if (localByteString == null) {
              break;
            }
            ((Message.Builder)localObject3).mergeFrom(CodedInputStream.newInstance(localByteString.newInput()));
            localByteString = null;
            localObject2 = localFieldDescriptor;
            localObject1 = localObject3;
            i = j;
            break;
          }
          label212:
          i = j;
          if (localByteString == null) {
            break;
          }
          paramBuilder.mergeField(j, UnknownFieldSet.Field.newBuilder().addLengthDelimited(localByteString).build());
          localByteString = null;
          i = j;
          break;
        }
        if (j == WireFormat.MESSAGE_SET_MESSAGE_TAG)
        {
          if (i == 0)
          {
            localByteString = paramCodedInputStream.readBytes();
            break;
          }
          if (localObject1 == null)
          {
            paramBuilder.mergeField(i, UnknownFieldSet.Field.newBuilder().addLengthDelimited(paramCodedInputStream.readBytes()).build());
            break;
          }
          paramCodedInputStream.readMessage((MessageLite.Builder)localObject1, paramExtensionRegistryLite);
          break;
        }
        if (paramCodedInputStream.skipField(j)) {
          break;
        }
      }
    }
    
    protected static UninitializedMessageException newUninitializedMessageException(Message paramMessage)
    {
      return new UninitializedMessageException(findMissingFields(paramMessage));
    }
    
    private static String subMessagePrefix(String paramString, Descriptors.FieldDescriptor paramFieldDescriptor, int paramInt)
    {
      paramString = new StringBuilder(paramString);
      if (paramFieldDescriptor.isExtension()) {
        paramString.append('(').append(paramFieldDescriptor.getFullName()).append(')');
      }
      for (;;)
      {
        if (paramInt != -1) {
          paramString.append('[').append(paramInt).append(']');
        }
        paramString.append('.');
        return paramString.toString();
        paramString.append(paramFieldDescriptor.getName());
      }
    }
    
    public BuilderType clear()
    {
      Iterator localIterator = getAllFields().entrySet().iterator();
      while (localIterator.hasNext()) {
        clearField((Descriptors.FieldDescriptor)((Map.Entry)localIterator.next()).getKey());
      }
      return this;
    }
    
    public abstract BuilderType clone();
    
    public BuilderType mergeDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return (Builder)super.mergeDelimitedFrom(paramInputStream);
    }
    
    public BuilderType mergeDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (Builder)super.mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite);
    }
    
    public BuilderType mergeFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return (Builder)super.mergeFrom(paramByteString);
    }
    
    public BuilderType mergeFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (Builder)super.mergeFrom(paramByteString, paramExtensionRegistryLite);
    }
    
    public BuilderType mergeFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return mergeFrom(paramCodedInputStream, ExtensionRegistry.getEmptyRegistry());
    }
    
    public BuilderType mergeFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      UnknownFieldSet.Builder localBuilder = UnknownFieldSet.newBuilder(getUnknownFields());
      int i = paramCodedInputStream.readTag();
      if (i == 0) {}
      for (;;)
      {
        setUnknownFields(localBuilder.build());
        return this;
        if (mergeFieldFrom(paramCodedInputStream, localBuilder, paramExtensionRegistryLite, this, i)) {
          break;
        }
      }
    }
    
    public BuilderType mergeFrom(Message paramMessage)
    {
      if (paramMessage.getDescriptorForType() != getDescriptorForType()) {
        throw new IllegalArgumentException("mergeFrom(Message) can only merge messages of the same type.");
      }
      Iterator localIterator = paramMessage.getAllFields().entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        Descriptors.FieldDescriptor localFieldDescriptor = (Descriptors.FieldDescriptor)((Map.Entry)localObject).getKey();
        if (localFieldDescriptor.isRepeated())
        {
          localObject = ((List)((Map.Entry)localObject).getValue()).iterator();
          while (((Iterator)localObject).hasNext()) {
            addRepeatedField(localFieldDescriptor, ((Iterator)localObject).next());
          }
        }
        else if (localFieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE)
        {
          Message localMessage = (Message)getField(localFieldDescriptor);
          if (localMessage == localMessage.getDefaultInstanceForType()) {
            setField(localFieldDescriptor, ((Map.Entry)localObject).getValue());
          } else {
            setField(localFieldDescriptor, localMessage.newBuilderForType().mergeFrom(localMessage).mergeFrom((Message)((Map.Entry)localObject).getValue()).build());
          }
        }
        else
        {
          setField(localFieldDescriptor, ((Map.Entry)localObject).getValue());
        }
      }
      mergeUnknownFields(paramMessage.getUnknownFields());
      return this;
    }
    
    public BuilderType mergeFrom(InputStream paramInputStream)
      throws IOException
    {
      return (Builder)super.mergeFrom(paramInputStream);
    }
    
    public BuilderType mergeFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (Builder)super.mergeFrom(paramInputStream, paramExtensionRegistryLite);
    }
    
    public BuilderType mergeFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return (Builder)super.mergeFrom(paramArrayOfByte);
    }
    
    public BuilderType mergeFrom(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws InvalidProtocolBufferException
    {
      return (Builder)super.mergeFrom(paramArrayOfByte, paramInt1, paramInt2);
    }
    
    public BuilderType mergeFrom(byte[] paramArrayOfByte, int paramInt1, int paramInt2, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (Builder)super.mergeFrom(paramArrayOfByte, paramInt1, paramInt2, paramExtensionRegistryLite);
    }
    
    public BuilderType mergeFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (Builder)super.mergeFrom(paramArrayOfByte, paramExtensionRegistryLite);
    }
    
    public BuilderType mergeUnknownFields(UnknownFieldSet paramUnknownFieldSet)
    {
      setUnknownFields(UnknownFieldSet.newBuilder(getUnknownFields()).mergeFrom(paramUnknownFieldSet).build());
      return this;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/google/protobuf/AbstractMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */