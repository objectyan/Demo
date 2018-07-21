package com.google.protobuf;

import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public abstract class GeneratedMessageLite
  extends AbstractMessageLite
{
  public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> newGeneratedExtension(ContainingType paramContainingType, Type paramType, MessageLite paramMessageLite, Internal.EnumLiteMap<?> paramEnumLiteMap, int paramInt, WireFormat.FieldType paramFieldType)
  {
    return new GeneratedExtension(paramContainingType, paramType, paramMessageLite, new ExtensionDescriptor(paramEnumLiteMap, paramInt, paramFieldType, false, false, null), null);
  }
  
  public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, List<Type>> newRepeatedGeneratedExtension(ContainingType paramContainingType, MessageLite paramMessageLite, Internal.EnumLiteMap<?> paramEnumLiteMap, int paramInt, WireFormat.FieldType paramFieldType, boolean paramBoolean)
  {
    return new GeneratedExtension(paramContainingType, Collections.emptyList(), paramMessageLite, new ExtensionDescriptor(paramEnumLiteMap, paramInt, paramFieldType, true, paramBoolean, null), null);
  }
  
  public static abstract class Builder<MessageType extends GeneratedMessageLite, BuilderType extends Builder>
    extends AbstractMessageLite.Builder<BuilderType>
  {
    public BuilderType clone()
    {
      throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }
    
    public abstract MessageType getDefaultInstanceForType();
    
    protected abstract MessageType internalGetResult();
    
    public abstract BuilderType mergeFrom(MessageType paramMessageType);
    
    protected boolean parseUnknownField(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite, int paramInt)
      throws IOException
    {
      return paramCodedInputStream.skipField(paramInt);
    }
  }
  
  public static abstract class ExtendableBuilder<MessageType extends GeneratedMessageLite.ExtendableMessage<MessageType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>>
    extends GeneratedMessageLite.Builder<MessageType, BuilderType>
  {
    public final <Type> BuilderType addExtension(GeneratedMessageLite.GeneratedExtension<MessageType, List<Type>> paramGeneratedExtension, Type paramType)
    {
      GeneratedMessageLite.ExtendableMessage localExtendableMessage = internalGetResult();
      GeneratedMessageLite.ExtendableMessage.access$400(localExtendableMessage, paramGeneratedExtension);
      GeneratedMessageLite.ExtendableMessage.access$200(localExtendableMessage).addRepeatedField(GeneratedMessageLite.GeneratedExtension.access$000(paramGeneratedExtension), paramType);
      return this;
    }
    
    public final <Type> BuilderType clearExtension(GeneratedMessageLite.GeneratedExtension<MessageType, ?> paramGeneratedExtension)
    {
      GeneratedMessageLite.ExtendableMessage localExtendableMessage = internalGetResult();
      GeneratedMessageLite.ExtendableMessage.access$400(localExtendableMessage, paramGeneratedExtension);
      GeneratedMessageLite.ExtendableMessage.access$200(localExtendableMessage).clearField(GeneratedMessageLite.GeneratedExtension.access$000(paramGeneratedExtension));
      return this;
    }
    
    public BuilderType clone()
    {
      throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }
    
    public final <Type> Type getExtension(GeneratedMessageLite.GeneratedExtension<MessageType, Type> paramGeneratedExtension)
    {
      return (Type)internalGetResult().getExtension(paramGeneratedExtension);
    }
    
    public final <Type> Type getExtension(GeneratedMessageLite.GeneratedExtension<MessageType, List<Type>> paramGeneratedExtension, int paramInt)
    {
      return (Type)internalGetResult().getExtension(paramGeneratedExtension, paramInt);
    }
    
    public final <Type> int getExtensionCount(GeneratedMessageLite.GeneratedExtension<MessageType, List<Type>> paramGeneratedExtension)
    {
      return internalGetResult().getExtensionCount(paramGeneratedExtension);
    }
    
    public final boolean hasExtension(GeneratedMessageLite.GeneratedExtension<MessageType, ?> paramGeneratedExtension)
    {
      return internalGetResult().hasExtension(paramGeneratedExtension);
    }
    
    protected abstract MessageType internalGetResult();
    
    protected final void mergeExtensionFields(MessageType paramMessageType)
    {
      GeneratedMessageLite.ExtendableMessage.access$200(internalGetResult()).mergeFrom(GeneratedMessageLite.ExtendableMessage.access$200(paramMessageType));
    }
    
    protected boolean parseUnknownField(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite, int paramInt)
      throws IOException
    {
      FieldSet localFieldSet = GeneratedMessageLite.ExtendableMessage.access$200(internalGetResult());
      int i = WireFormat.getTagWireType(paramInt);
      int j = WireFormat.getTagFieldNumber(paramInt);
      GeneratedMessageLite.GeneratedExtension localGeneratedExtension = paramExtensionRegistryLite.findLiteExtensionByNumber(getDefaultInstanceForType(), j);
      if ((localGeneratedExtension == null) || (i != FieldSet.getWireFormatForFieldType(GeneratedMessageLite.GeneratedExtension.access$000(localGeneratedExtension).getLiteType(), GeneratedMessageLite.GeneratedExtension.access$000(localGeneratedExtension).isPacked()))) {
        return paramCodedInputStream.skipField(paramInt);
      }
      if (GeneratedMessageLite.GeneratedExtension.access$000(localGeneratedExtension).isPacked())
      {
        paramInt = paramCodedInputStream.pushLimit(paramCodedInputStream.readRawVarint32());
        if (GeneratedMessageLite.GeneratedExtension.access$000(localGeneratedExtension).getLiteType() == WireFormat.FieldType.ENUM) {
          while (paramCodedInputStream.getBytesUntilLimit() > 0)
          {
            i = paramCodedInputStream.readEnum();
            paramExtensionRegistryLite = GeneratedMessageLite.GeneratedExtension.access$000(localGeneratedExtension).getEnumType().findValueByNumber(i);
            if (paramExtensionRegistryLite == null) {
              return true;
            }
            localFieldSet.addRepeatedField(GeneratedMessageLite.GeneratedExtension.access$000(localGeneratedExtension), paramExtensionRegistryLite);
          }
        }
        while (paramCodedInputStream.getBytesUntilLimit() > 0)
        {
          paramExtensionRegistryLite = FieldSet.readPrimitiveField(paramCodedInputStream, GeneratedMessageLite.GeneratedExtension.access$000(localGeneratedExtension).getLiteType());
          localFieldSet.addRepeatedField(GeneratedMessageLite.GeneratedExtension.access$000(localGeneratedExtension), paramExtensionRegistryLite);
        }
        paramCodedInputStream.popLimit(paramInt);
      }
      for (;;)
      {
        return true;
        switch (GeneratedMessageLite.1.$SwitchMap$com$google$protobuf$WireFormat$JavaType[GeneratedMessageLite.GeneratedExtension.access$000(localGeneratedExtension).getLiteJavaType().ordinal()])
        {
        default: 
          paramCodedInputStream = FieldSet.readPrimitiveField(paramCodedInputStream, GeneratedMessageLite.GeneratedExtension.access$000(localGeneratedExtension).getLiteType());
        }
        for (;;)
        {
          if (GeneratedMessageLite.GeneratedExtension.access$000(localGeneratedExtension).isRepeated())
          {
            localFieldSet.addRepeatedField(GeneratedMessageLite.GeneratedExtension.access$000(localGeneratedExtension), paramCodedInputStream);
            break;
            Object localObject2 = null;
            Object localObject1 = localObject2;
            if (!GeneratedMessageLite.GeneratedExtension.access$000(localGeneratedExtension).isRepeated())
            {
              MessageLite localMessageLite = (MessageLite)localFieldSet.getField(GeneratedMessageLite.GeneratedExtension.access$000(localGeneratedExtension));
              localObject1 = localObject2;
              if (localMessageLite != null) {
                localObject1 = localMessageLite.toBuilder();
              }
            }
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = GeneratedMessageLite.GeneratedExtension.access$500(localGeneratedExtension).newBuilderForType();
            }
            if (GeneratedMessageLite.GeneratedExtension.access$000(localGeneratedExtension).getLiteType() == WireFormat.FieldType.GROUP) {
              paramCodedInputStream.readGroup(localGeneratedExtension.getNumber(), (MessageLite.Builder)localObject2, paramExtensionRegistryLite);
            }
            for (;;)
            {
              paramCodedInputStream = ((MessageLite.Builder)localObject2).build();
              break;
              paramCodedInputStream.readMessage((MessageLite.Builder)localObject2, paramExtensionRegistryLite);
            }
            paramInt = paramCodedInputStream.readEnum();
            paramExtensionRegistryLite = GeneratedMessageLite.GeneratedExtension.access$000(localGeneratedExtension).getEnumType().findValueByNumber(paramInt);
            paramCodedInputStream = paramExtensionRegistryLite;
            if (paramExtensionRegistryLite == null) {
              return true;
            }
          }
        }
        localFieldSet.setField(GeneratedMessageLite.GeneratedExtension.access$000(localGeneratedExtension), paramCodedInputStream);
      }
    }
    
    public final <Type> BuilderType setExtension(GeneratedMessageLite.GeneratedExtension<MessageType, List<Type>> paramGeneratedExtension, int paramInt, Type paramType)
    {
      GeneratedMessageLite.ExtendableMessage localExtendableMessage = internalGetResult();
      GeneratedMessageLite.ExtendableMessage.access$400(localExtendableMessage, paramGeneratedExtension);
      GeneratedMessageLite.ExtendableMessage.access$200(localExtendableMessage).setRepeatedField(GeneratedMessageLite.GeneratedExtension.access$000(paramGeneratedExtension), paramInt, paramType);
      return this;
    }
    
    public final <Type> BuilderType setExtension(GeneratedMessageLite.GeneratedExtension<MessageType, Type> paramGeneratedExtension, Type paramType)
    {
      GeneratedMessageLite.ExtendableMessage localExtendableMessage = internalGetResult();
      GeneratedMessageLite.ExtendableMessage.access$400(localExtendableMessage, paramGeneratedExtension);
      GeneratedMessageLite.ExtendableMessage.access$200(localExtendableMessage).setField(GeneratedMessageLite.GeneratedExtension.access$000(paramGeneratedExtension), paramType);
      return this;
    }
  }
  
  public static abstract class ExtendableMessage<MessageType extends ExtendableMessage<MessageType>>
    extends GeneratedMessageLite
  {
    private final FieldSet<GeneratedMessageLite.ExtensionDescriptor> extensions = FieldSet.newFieldSet();
    
    private void verifyExtensionContainingType(GeneratedMessageLite.GeneratedExtension<MessageType, ?> paramGeneratedExtension)
    {
      if (paramGeneratedExtension.getContainingTypeDefaultInstance() != getDefaultInstanceForType()) {
        throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
      }
    }
    
    protected boolean extensionsAreInitialized()
    {
      return this.extensions.isInitialized();
    }
    
    protected int extensionsSerializedSize()
    {
      return this.extensions.getSerializedSize();
    }
    
    protected int extensionsSerializedSizeAsMessageSet()
    {
      return this.extensions.getMessageSetSerializedSize();
    }
    
    public final <Type> Type getExtension(GeneratedMessageLite.GeneratedExtension<MessageType, Type> paramGeneratedExtension)
    {
      verifyExtensionContainingType(paramGeneratedExtension);
      Object localObject2 = this.extensions.getField(GeneratedMessageLite.GeneratedExtension.access$000(paramGeneratedExtension));
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = GeneratedMessageLite.GeneratedExtension.access$100(paramGeneratedExtension);
      }
      return (Type)localObject1;
    }
    
    public final <Type> Type getExtension(GeneratedMessageLite.GeneratedExtension<MessageType, List<Type>> paramGeneratedExtension, int paramInt)
    {
      verifyExtensionContainingType(paramGeneratedExtension);
      return (Type)this.extensions.getRepeatedField(GeneratedMessageLite.GeneratedExtension.access$000(paramGeneratedExtension), paramInt);
    }
    
    public final <Type> int getExtensionCount(GeneratedMessageLite.GeneratedExtension<MessageType, List<Type>> paramGeneratedExtension)
    {
      verifyExtensionContainingType(paramGeneratedExtension);
      return this.extensions.getRepeatedFieldCount(GeneratedMessageLite.GeneratedExtension.access$000(paramGeneratedExtension));
    }
    
    public final boolean hasExtension(GeneratedMessageLite.GeneratedExtension<MessageType, ?> paramGeneratedExtension)
    {
      verifyExtensionContainingType(paramGeneratedExtension);
      return this.extensions.hasField(GeneratedMessageLite.GeneratedExtension.access$000(paramGeneratedExtension));
    }
    
    protected ExtendableMessage<MessageType>.ExtensionWriter newExtensionWriter()
    {
      return new ExtensionWriter(false, null);
    }
    
    protected ExtendableMessage<MessageType>.ExtensionWriter newMessageSetExtensionWriter()
    {
      return new ExtensionWriter(true, null);
    }
    
    protected class ExtensionWriter
    {
      private final Iterator<Map.Entry<GeneratedMessageLite.ExtensionDescriptor, Object>> iter = GeneratedMessageLite.ExtendableMessage.this.extensions.iterator();
      private final boolean messageSetWireFormat;
      private Map.Entry<GeneratedMessageLite.ExtensionDescriptor, Object> next;
      
      private ExtensionWriter(boolean paramBoolean)
      {
        if (this.iter.hasNext()) {
          this.next = ((Map.Entry)this.iter.next());
        }
        this.messageSetWireFormat = paramBoolean;
      }
      
      public void writeUntil(int paramInt, CodedOutputStream paramCodedOutputStream)
        throws IOException
      {
        while ((this.next != null) && (((GeneratedMessageLite.ExtensionDescriptor)this.next.getKey()).getNumber() < paramInt))
        {
          GeneratedMessageLite.ExtensionDescriptor localExtensionDescriptor = (GeneratedMessageLite.ExtensionDescriptor)this.next.getKey();
          if ((this.messageSetWireFormat) && (localExtensionDescriptor.getLiteJavaType() == WireFormat.JavaType.MESSAGE) && (!localExtensionDescriptor.isRepeated())) {
            paramCodedOutputStream.writeMessageSetExtension(localExtensionDescriptor.getNumber(), (MessageLite)this.next.getValue());
          }
          for (;;)
          {
            if (!this.iter.hasNext()) {
              break label131;
            }
            this.next = ((Map.Entry)this.iter.next());
            break;
            FieldSet.writeField(localExtensionDescriptor, this.next.getValue(), paramCodedOutputStream);
          }
          label131:
          this.next = null;
        }
      }
    }
  }
  
  private static final class ExtensionDescriptor
    implements FieldSet.FieldDescriptorLite<ExtensionDescriptor>
  {
    private final Internal.EnumLiteMap<?> enumTypeMap;
    private final boolean isPacked;
    private final boolean isRepeated;
    private final int number;
    private final WireFormat.FieldType type;
    
    private ExtensionDescriptor(Internal.EnumLiteMap<?> paramEnumLiteMap, int paramInt, WireFormat.FieldType paramFieldType, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.enumTypeMap = paramEnumLiteMap;
      this.number = paramInt;
      this.type = paramFieldType;
      this.isRepeated = paramBoolean1;
      this.isPacked = paramBoolean2;
    }
    
    public int compareTo(ExtensionDescriptor paramExtensionDescriptor)
    {
      return this.number - paramExtensionDescriptor.number;
    }
    
    public Internal.EnumLiteMap<?> getEnumType()
    {
      return this.enumTypeMap;
    }
    
    public WireFormat.JavaType getLiteJavaType()
    {
      return this.type.getJavaType();
    }
    
    public WireFormat.FieldType getLiteType()
    {
      return this.type;
    }
    
    public int getNumber()
    {
      return this.number;
    }
    
    public MessageLite.Builder internalMergeFrom(MessageLite.Builder paramBuilder, MessageLite paramMessageLite)
    {
      return ((GeneratedMessageLite.Builder)paramBuilder).mergeFrom((GeneratedMessageLite)paramMessageLite);
    }
    
    public boolean isPacked()
    {
      return this.isPacked;
    }
    
    public boolean isRepeated()
    {
      return this.isRepeated;
    }
  }
  
  public static final class GeneratedExtension<ContainingType extends MessageLite, Type>
  {
    private final ContainingType containingTypeDefaultInstance;
    private final Type defaultValue;
    private final GeneratedMessageLite.ExtensionDescriptor descriptor;
    private final MessageLite messageDefaultInstance;
    
    private GeneratedExtension(ContainingType paramContainingType, Type paramType, MessageLite paramMessageLite, GeneratedMessageLite.ExtensionDescriptor paramExtensionDescriptor)
    {
      this.containingTypeDefaultInstance = paramContainingType;
      this.defaultValue = paramType;
      this.messageDefaultInstance = paramMessageLite;
      this.descriptor = paramExtensionDescriptor;
    }
    
    public ContainingType getContainingTypeDefaultInstance()
    {
      return this.containingTypeDefaultInstance;
    }
    
    public MessageLite getMessageDefaultInstance()
    {
      return this.messageDefaultInstance;
    }
    
    public int getNumber()
    {
      return this.descriptor.getNumber();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/google/protobuf/GeneratedMessageLite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */