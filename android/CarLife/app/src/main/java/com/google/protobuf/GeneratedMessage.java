package com.google.protobuf;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public abstract class GeneratedMessage
  extends AbstractMessage
{
  private UnknownFieldSet unknownFields = UnknownFieldSet.getDefaultInstance();
  
  private Map<Descriptors.FieldDescriptor, Object> getAllFieldsMutable()
  {
    TreeMap localTreeMap = new TreeMap();
    Iterator localIterator = internalGetFieldAccessorTable().descriptor.getFields().iterator();
    while (localIterator.hasNext())
    {
      Descriptors.FieldDescriptor localFieldDescriptor = (Descriptors.FieldDescriptor)localIterator.next();
      if (localFieldDescriptor.isRepeated())
      {
        List localList = (List)getField(localFieldDescriptor);
        if (!localList.isEmpty()) {
          localTreeMap.put(localFieldDescriptor, localList);
        }
      }
      else if (hasField(localFieldDescriptor))
      {
        localTreeMap.put(localFieldDescriptor, getField(localFieldDescriptor));
      }
    }
    return localTreeMap;
  }
  
  private static Method getMethodOrDie(Class paramClass, String paramString, Class... paramVarArgs)
  {
    try
    {
      paramVarArgs = paramClass.getMethod(paramString, paramVarArgs);
      return paramVarArgs;
    }
    catch (NoSuchMethodException paramVarArgs)
    {
      throw new RuntimeException("Generated message class \"" + paramClass.getName() + "\" missing method \"" + paramString + "\".", paramVarArgs);
    }
  }
  
  private static Object invokeOrDie(Method paramMethod, Object paramObject, Object... paramVarArgs)
  {
    try
    {
      paramMethod = paramMethod.invoke(paramObject, paramVarArgs);
      return paramMethod;
    }
    catch (IllegalAccessException paramMethod)
    {
      throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", paramMethod);
    }
    catch (InvocationTargetException paramMethod)
    {
      paramMethod = paramMethod.getCause();
      if ((paramMethod instanceof RuntimeException)) {
        throw ((RuntimeException)paramMethod);
      }
      if ((paramMethod instanceof Error)) {
        throw ((Error)paramMethod);
      }
      throw new RuntimeException("Unexpected exception thrown by generated accessor method.", paramMethod);
    }
  }
  
  public static <ContainingType extends Message, Type> GeneratedExtension<ContainingType, Type> newGeneratedExtension(Descriptors.FieldDescriptor paramFieldDescriptor, Class<Type> paramClass)
  {
    if (paramFieldDescriptor.isRepeated()) {
      throw new IllegalArgumentException("Must call newRepeatedGeneratedExtension() for repeated types.");
    }
    return new GeneratedExtension(paramFieldDescriptor, paramClass, null);
  }
  
  public static <ContainingType extends Message, Type> GeneratedExtension<ContainingType, List<Type>> newRepeatedGeneratedExtension(Descriptors.FieldDescriptor paramFieldDescriptor, Class<Type> paramClass)
  {
    if (!paramFieldDescriptor.isRepeated()) {
      throw new IllegalArgumentException("Must call newGeneratedExtension() for non-repeated types.");
    }
    return new GeneratedExtension(paramFieldDescriptor, paramClass, null);
  }
  
  public Map<Descriptors.FieldDescriptor, Object> getAllFields()
  {
    return Collections.unmodifiableMap(getAllFieldsMutable());
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return internalGetFieldAccessorTable().descriptor;
  }
  
  public Object getField(Descriptors.FieldDescriptor paramFieldDescriptor)
  {
    return internalGetFieldAccessorTable().getField(paramFieldDescriptor).get(this);
  }
  
  public Object getRepeatedField(Descriptors.FieldDescriptor paramFieldDescriptor, int paramInt)
  {
    return internalGetFieldAccessorTable().getField(paramFieldDescriptor).getRepeated(this, paramInt);
  }
  
  public int getRepeatedFieldCount(Descriptors.FieldDescriptor paramFieldDescriptor)
  {
    return internalGetFieldAccessorTable().getField(paramFieldDescriptor).getRepeatedCount(this);
  }
  
  public final UnknownFieldSet getUnknownFields()
  {
    return this.unknownFields;
  }
  
  public boolean hasField(Descriptors.FieldDescriptor paramFieldDescriptor)
  {
    return internalGetFieldAccessorTable().getField(paramFieldDescriptor).has(this);
  }
  
  protected abstract FieldAccessorTable internalGetFieldAccessorTable();
  
  public boolean isInitialized()
  {
    Iterator localIterator = getDescriptorForType().getFields().iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        Object localObject = (Descriptors.FieldDescriptor)localIterator.next();
        if ((((Descriptors.FieldDescriptor)localObject).isRequired()) && (!hasField((Descriptors.FieldDescriptor)localObject))) {
          return false;
        }
        if (((Descriptors.FieldDescriptor)localObject).getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE)
        {
          if (((Descriptors.FieldDescriptor)localObject).isRepeated())
          {
            localObject = ((List)getField((Descriptors.FieldDescriptor)localObject)).iterator();
            if (!((Iterator)localObject).hasNext()) {
              continue;
            }
            if (((Message)((Iterator)localObject).next()).isInitialized()) {
              break;
            }
            return false;
          }
          if ((hasField((Descriptors.FieldDescriptor)localObject)) && (!((Message)getField((Descriptors.FieldDescriptor)localObject)).isInitialized())) {
            return false;
          }
        }
      }
    }
    return true;
  }
  
  public static abstract class Builder<BuilderType extends Builder>
    extends AbstractMessage.Builder<BuilderType>
  {
    private GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return internalGetResult().internalGetFieldAccessorTable();
    }
    
    public BuilderType addRepeatedField(Descriptors.FieldDescriptor paramFieldDescriptor, Object paramObject)
    {
      GeneratedMessage.FieldAccessorTable.access$100(internalGetFieldAccessorTable(), paramFieldDescriptor).addRepeated(this, paramObject);
      return this;
    }
    
    public BuilderType clearField(Descriptors.FieldDescriptor paramFieldDescriptor)
    {
      GeneratedMessage.FieldAccessorTable.access$100(internalGetFieldAccessorTable(), paramFieldDescriptor).clear(this);
      return this;
    }
    
    public BuilderType clone()
    {
      throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }
    
    public Map<Descriptors.FieldDescriptor, Object> getAllFields()
    {
      return internalGetResult().getAllFields();
    }
    
    public Descriptors.Descriptor getDescriptorForType()
    {
      return GeneratedMessage.FieldAccessorTable.access$000(internalGetFieldAccessorTable());
    }
    
    public Object getField(Descriptors.FieldDescriptor paramFieldDescriptor)
    {
      if (paramFieldDescriptor.isRepeated()) {
        return Collections.unmodifiableList((List)internalGetResult().getField(paramFieldDescriptor));
      }
      return internalGetResult().getField(paramFieldDescriptor);
    }
    
    public Object getRepeatedField(Descriptors.FieldDescriptor paramFieldDescriptor, int paramInt)
    {
      return internalGetResult().getRepeatedField(paramFieldDescriptor, paramInt);
    }
    
    public int getRepeatedFieldCount(Descriptors.FieldDescriptor paramFieldDescriptor)
    {
      return internalGetResult().getRepeatedFieldCount(paramFieldDescriptor);
    }
    
    public final UnknownFieldSet getUnknownFields()
    {
      return internalGetResult().unknownFields;
    }
    
    public boolean hasField(Descriptors.FieldDescriptor paramFieldDescriptor)
    {
      return internalGetResult().hasField(paramFieldDescriptor);
    }
    
    protected abstract GeneratedMessage internalGetResult();
    
    public boolean isInitialized()
    {
      return internalGetResult().isInitialized();
    }
    
    public final BuilderType mergeUnknownFields(UnknownFieldSet paramUnknownFieldSet)
    {
      GeneratedMessage localGeneratedMessage = internalGetResult();
      GeneratedMessage.access$202(localGeneratedMessage, UnknownFieldSet.newBuilder(localGeneratedMessage.unknownFields).mergeFrom(paramUnknownFieldSet).build());
      return this;
    }
    
    public Message.Builder newBuilderForField(Descriptors.FieldDescriptor paramFieldDescriptor)
    {
      return GeneratedMessage.FieldAccessorTable.access$100(internalGetFieldAccessorTable(), paramFieldDescriptor).newBuilder();
    }
    
    protected boolean parseUnknownField(CodedInputStream paramCodedInputStream, UnknownFieldSet.Builder paramBuilder, ExtensionRegistryLite paramExtensionRegistryLite, int paramInt)
      throws IOException
    {
      return paramBuilder.mergeFieldFrom(paramInt, paramCodedInputStream);
    }
    
    public BuilderType setField(Descriptors.FieldDescriptor paramFieldDescriptor, Object paramObject)
    {
      GeneratedMessage.FieldAccessorTable.access$100(internalGetFieldAccessorTable(), paramFieldDescriptor).set(this, paramObject);
      return this;
    }
    
    public BuilderType setRepeatedField(Descriptors.FieldDescriptor paramFieldDescriptor, int paramInt, Object paramObject)
    {
      GeneratedMessage.FieldAccessorTable.access$100(internalGetFieldAccessorTable(), paramFieldDescriptor).setRepeated(this, paramInt, paramObject);
      return this;
    }
    
    public final BuilderType setUnknownFields(UnknownFieldSet paramUnknownFieldSet)
    {
      GeneratedMessage.access$202(internalGetResult(), paramUnknownFieldSet);
      return this;
    }
  }
  
  public static abstract class ExtendableBuilder<MessageType extends GeneratedMessage.ExtendableMessage, BuilderType extends ExtendableBuilder>
    extends GeneratedMessage.Builder<BuilderType>
  {
    public final <Type> BuilderType addExtension(GeneratedMessage.GeneratedExtension<MessageType, List<Type>> paramGeneratedExtension, Type paramType)
    {
      GeneratedMessage.ExtendableMessage localExtendableMessage = internalGetResult();
      GeneratedMessage.ExtendableMessage.access$800(localExtendableMessage, paramGeneratedExtension);
      Descriptors.FieldDescriptor localFieldDescriptor = paramGeneratedExtension.getDescriptor();
      GeneratedMessage.ExtendableMessage.access$500(localExtendableMessage).addRepeatedField(localFieldDescriptor, GeneratedMessage.GeneratedExtension.access$1000(paramGeneratedExtension, paramType));
      return this;
    }
    
    public BuilderType addRepeatedField(Descriptors.FieldDescriptor paramFieldDescriptor, Object paramObject)
    {
      if (paramFieldDescriptor.isExtension())
      {
        GeneratedMessage.ExtendableMessage localExtendableMessage = internalGetResult();
        GeneratedMessage.ExtendableMessage.access$1100(localExtendableMessage, paramFieldDescriptor);
        GeneratedMessage.ExtendableMessage.access$500(localExtendableMessage).addRepeatedField(paramFieldDescriptor, paramObject);
        return this;
      }
      return (ExtendableBuilder)super.addRepeatedField(paramFieldDescriptor, paramObject);
    }
    
    public final <Type> BuilderType clearExtension(GeneratedMessage.GeneratedExtension<MessageType, ?> paramGeneratedExtension)
    {
      GeneratedMessage.ExtendableMessage localExtendableMessage = internalGetResult();
      GeneratedMessage.ExtendableMessage.access$800(localExtendableMessage, paramGeneratedExtension);
      GeneratedMessage.ExtendableMessage.access$500(localExtendableMessage).clearField(paramGeneratedExtension.getDescriptor());
      return this;
    }
    
    public BuilderType clearField(Descriptors.FieldDescriptor paramFieldDescriptor)
    {
      if (paramFieldDescriptor.isExtension())
      {
        GeneratedMessage.ExtendableMessage localExtendableMessage = internalGetResult();
        GeneratedMessage.ExtendableMessage.access$1100(localExtendableMessage, paramFieldDescriptor);
        GeneratedMessage.ExtendableMessage.access$500(localExtendableMessage).clearField(paramFieldDescriptor);
        return this;
      }
      return (ExtendableBuilder)super.clearField(paramFieldDescriptor);
    }
    
    public BuilderType clone()
    {
      throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }
    
    public final <Type> Type getExtension(GeneratedMessage.GeneratedExtension<MessageType, Type> paramGeneratedExtension)
    {
      return (Type)internalGetResult().getExtension(paramGeneratedExtension);
    }
    
    public final <Type> Type getExtension(GeneratedMessage.GeneratedExtension<MessageType, List<Type>> paramGeneratedExtension, int paramInt)
    {
      return (Type)internalGetResult().getExtension(paramGeneratedExtension, paramInt);
    }
    
    public final <Type> int getExtensionCount(GeneratedMessage.GeneratedExtension<MessageType, List<Type>> paramGeneratedExtension)
    {
      return internalGetResult().getExtensionCount(paramGeneratedExtension);
    }
    
    public final boolean hasExtension(GeneratedMessage.GeneratedExtension<MessageType, ?> paramGeneratedExtension)
    {
      return internalGetResult().hasExtension(paramGeneratedExtension);
    }
    
    protected abstract GeneratedMessage.ExtendableMessage<MessageType> internalGetResult();
    
    protected final void mergeExtensionFields(GeneratedMessage.ExtendableMessage paramExtendableMessage)
    {
      GeneratedMessage.ExtendableMessage.access$500(internalGetResult()).mergeFrom(GeneratedMessage.ExtendableMessage.access$500(paramExtendableMessage));
    }
    
    protected boolean parseUnknownField(CodedInputStream paramCodedInputStream, UnknownFieldSet.Builder paramBuilder, ExtensionRegistryLite paramExtensionRegistryLite, int paramInt)
      throws IOException
    {
      internalGetResult();
      return AbstractMessage.Builder.mergeFieldFrom(paramCodedInputStream, paramBuilder, paramExtensionRegistryLite, this, paramInt);
    }
    
    public final <Type> BuilderType setExtension(GeneratedMessage.GeneratedExtension<MessageType, List<Type>> paramGeneratedExtension, int paramInt, Type paramType)
    {
      GeneratedMessage.ExtendableMessage localExtendableMessage = internalGetResult();
      GeneratedMessage.ExtendableMessage.access$800(localExtendableMessage, paramGeneratedExtension);
      Descriptors.FieldDescriptor localFieldDescriptor = paramGeneratedExtension.getDescriptor();
      GeneratedMessage.ExtendableMessage.access$500(localExtendableMessage).setRepeatedField(localFieldDescriptor, paramInt, GeneratedMessage.GeneratedExtension.access$1000(paramGeneratedExtension, paramType));
      return this;
    }
    
    public final <Type> BuilderType setExtension(GeneratedMessage.GeneratedExtension<MessageType, Type> paramGeneratedExtension, Type paramType)
    {
      GeneratedMessage.ExtendableMessage localExtendableMessage = internalGetResult();
      GeneratedMessage.ExtendableMessage.access$800(localExtendableMessage, paramGeneratedExtension);
      Descriptors.FieldDescriptor localFieldDescriptor = paramGeneratedExtension.getDescriptor();
      GeneratedMessage.ExtendableMessage.access$500(localExtendableMessage).setField(localFieldDescriptor, GeneratedMessage.GeneratedExtension.access$900(paramGeneratedExtension, paramType));
      return this;
    }
    
    public BuilderType setField(Descriptors.FieldDescriptor paramFieldDescriptor, Object paramObject)
    {
      if (paramFieldDescriptor.isExtension())
      {
        GeneratedMessage.ExtendableMessage localExtendableMessage = internalGetResult();
        GeneratedMessage.ExtendableMessage.access$1100(localExtendableMessage, paramFieldDescriptor);
        GeneratedMessage.ExtendableMessage.access$500(localExtendableMessage).setField(paramFieldDescriptor, paramObject);
        return this;
      }
      return (ExtendableBuilder)super.setField(paramFieldDescriptor, paramObject);
    }
    
    public BuilderType setRepeatedField(Descriptors.FieldDescriptor paramFieldDescriptor, int paramInt, Object paramObject)
    {
      if (paramFieldDescriptor.isExtension())
      {
        GeneratedMessage.ExtendableMessage localExtendableMessage = internalGetResult();
        GeneratedMessage.ExtendableMessage.access$1100(localExtendableMessage, paramFieldDescriptor);
        GeneratedMessage.ExtendableMessage.access$500(localExtendableMessage).setRepeatedField(paramFieldDescriptor, paramInt, paramObject);
        return this;
      }
      return (ExtendableBuilder)super.setRepeatedField(paramFieldDescriptor, paramInt, paramObject);
    }
  }
  
  public static abstract class ExtendableMessage<MessageType extends ExtendableMessage>
    extends GeneratedMessage
  {
    private final FieldSet<Descriptors.FieldDescriptor> extensions = FieldSet.newFieldSet();
    
    private void verifyContainingType(Descriptors.FieldDescriptor paramFieldDescriptor)
    {
      if (paramFieldDescriptor.getContainingType() != getDescriptorForType()) {
        throw new IllegalArgumentException("FieldDescriptor does not match message type.");
      }
    }
    
    private void verifyExtensionContainingType(GeneratedMessage.GeneratedExtension<MessageType, ?> paramGeneratedExtension)
    {
      if (paramGeneratedExtension.getDescriptor().getContainingType() != getDescriptorForType()) {
        throw new IllegalArgumentException("Extension is for type \"" + paramGeneratedExtension.getDescriptor().getContainingType().getFullName() + "\" which does not match message type \"" + getDescriptorForType().getFullName() + "\".");
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
    
    public Map<Descriptors.FieldDescriptor, Object> getAllFields()
    {
      Map localMap = super.getAllFieldsMutable();
      localMap.putAll(this.extensions.getAllFields());
      return Collections.unmodifiableMap(localMap);
    }
    
    public final <Type> Type getExtension(GeneratedMessage.GeneratedExtension<MessageType, Type> paramGeneratedExtension)
    {
      verifyExtensionContainingType(paramGeneratedExtension);
      Descriptors.FieldDescriptor localFieldDescriptor = paramGeneratedExtension.getDescriptor();
      Object localObject = this.extensions.getField(localFieldDescriptor);
      if (localObject == null)
      {
        if (localFieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
          return paramGeneratedExtension.getMessageDefaultInstance();
        }
        return (Type)GeneratedMessage.GeneratedExtension.access$300(paramGeneratedExtension, localFieldDescriptor.getDefaultValue());
      }
      return (Type)GeneratedMessage.GeneratedExtension.access$300(paramGeneratedExtension, localObject);
    }
    
    public final <Type> Type getExtension(GeneratedMessage.GeneratedExtension<MessageType, List<Type>> paramGeneratedExtension, int paramInt)
    {
      verifyExtensionContainingType(paramGeneratedExtension);
      Descriptors.FieldDescriptor localFieldDescriptor = paramGeneratedExtension.getDescriptor();
      return (Type)GeneratedMessage.GeneratedExtension.access$400(paramGeneratedExtension, this.extensions.getRepeatedField(localFieldDescriptor, paramInt));
    }
    
    public final <Type> int getExtensionCount(GeneratedMessage.GeneratedExtension<MessageType, List<Type>> paramGeneratedExtension)
    {
      verifyExtensionContainingType(paramGeneratedExtension);
      paramGeneratedExtension = paramGeneratedExtension.getDescriptor();
      return this.extensions.getRepeatedFieldCount(paramGeneratedExtension);
    }
    
    public Object getField(Descriptors.FieldDescriptor paramFieldDescriptor)
    {
      if (paramFieldDescriptor.isExtension())
      {
        verifyContainingType(paramFieldDescriptor);
        Object localObject2 = this.extensions.getField(paramFieldDescriptor);
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          if (paramFieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
            localObject1 = DynamicMessage.getDefaultInstance(paramFieldDescriptor.getMessageType());
          }
        }
        else {
          return localObject1;
        }
        return paramFieldDescriptor.getDefaultValue();
      }
      return super.getField(paramFieldDescriptor);
    }
    
    public Object getRepeatedField(Descriptors.FieldDescriptor paramFieldDescriptor, int paramInt)
    {
      if (paramFieldDescriptor.isExtension())
      {
        verifyContainingType(paramFieldDescriptor);
        return this.extensions.getRepeatedField(paramFieldDescriptor, paramInt);
      }
      return super.getRepeatedField(paramFieldDescriptor, paramInt);
    }
    
    public int getRepeatedFieldCount(Descriptors.FieldDescriptor paramFieldDescriptor)
    {
      if (paramFieldDescriptor.isExtension())
      {
        verifyContainingType(paramFieldDescriptor);
        return this.extensions.getRepeatedFieldCount(paramFieldDescriptor);
      }
      return super.getRepeatedFieldCount(paramFieldDescriptor);
    }
    
    public final boolean hasExtension(GeneratedMessage.GeneratedExtension<MessageType, ?> paramGeneratedExtension)
    {
      verifyExtensionContainingType(paramGeneratedExtension);
      return this.extensions.hasField(paramGeneratedExtension.getDescriptor());
    }
    
    public boolean hasField(Descriptors.FieldDescriptor paramFieldDescriptor)
    {
      if (paramFieldDescriptor.isExtension())
      {
        verifyContainingType(paramFieldDescriptor);
        return this.extensions.hasField(paramFieldDescriptor);
      }
      return super.hasField(paramFieldDescriptor);
    }
    
    public boolean isInitialized()
    {
      return (super.isInitialized()) && (extensionsAreInitialized());
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
      private final Iterator<Map.Entry<Descriptors.FieldDescriptor, Object>> iter = GeneratedMessage.ExtendableMessage.this.extensions.iterator();
      private final boolean messageSetWireFormat;
      private Map.Entry<Descriptors.FieldDescriptor, Object> next;
      
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
        while ((this.next != null) && (((Descriptors.FieldDescriptor)this.next.getKey()).getNumber() < paramInt))
        {
          Descriptors.FieldDescriptor localFieldDescriptor = (Descriptors.FieldDescriptor)this.next.getKey();
          if ((this.messageSetWireFormat) && (localFieldDescriptor.getLiteJavaType() == WireFormat.JavaType.MESSAGE) && (!localFieldDescriptor.isRepeated())) {
            paramCodedOutputStream.writeMessageSetExtension(localFieldDescriptor.getNumber(), (Message)this.next.getValue());
          }
          for (;;)
          {
            if (!this.iter.hasNext()) {
              break label131;
            }
            this.next = ((Map.Entry)this.iter.next());
            break;
            FieldSet.writeField(localFieldDescriptor, this.next.getValue(), paramCodedOutputStream);
          }
          label131:
          this.next = null;
        }
      }
    }
  }
  
  public static final class FieldAccessorTable
  {
    private final Descriptors.Descriptor descriptor;
    private final FieldAccessor[] fields;
    
    public FieldAccessorTable(Descriptors.Descriptor paramDescriptor, String[] paramArrayOfString, Class<? extends GeneratedMessage> paramClass, Class<? extends GeneratedMessage.Builder> paramClass1)
    {
      this.descriptor = paramDescriptor;
      this.fields = new FieldAccessor[paramDescriptor.getFields().size()];
      int i = 0;
      if (i < this.fields.length)
      {
        Descriptors.FieldDescriptor localFieldDescriptor = (Descriptors.FieldDescriptor)paramDescriptor.getFields().get(i);
        if (localFieldDescriptor.isRepeated()) {
          if (localFieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
            this.fields[i] = new RepeatedMessageFieldAccessor(localFieldDescriptor, paramArrayOfString[i], paramClass, paramClass1);
          }
        }
        for (;;)
        {
          i += 1;
          break;
          if (localFieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.ENUM)
          {
            this.fields[i] = new RepeatedEnumFieldAccessor(localFieldDescriptor, paramArrayOfString[i], paramClass, paramClass1);
          }
          else
          {
            this.fields[i] = new RepeatedFieldAccessor(localFieldDescriptor, paramArrayOfString[i], paramClass, paramClass1);
            continue;
            if (localFieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
              this.fields[i] = new SingularMessageFieldAccessor(localFieldDescriptor, paramArrayOfString[i], paramClass, paramClass1);
            } else if (localFieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.ENUM) {
              this.fields[i] = new SingularEnumFieldAccessor(localFieldDescriptor, paramArrayOfString[i], paramClass, paramClass1);
            } else {
              this.fields[i] = new SingularFieldAccessor(localFieldDescriptor, paramArrayOfString[i], paramClass, paramClass1);
            }
          }
        }
      }
    }
    
    private FieldAccessor getField(Descriptors.FieldDescriptor paramFieldDescriptor)
    {
      if (paramFieldDescriptor.getContainingType() != this.descriptor) {
        throw new IllegalArgumentException("FieldDescriptor does not match message type.");
      }
      if (paramFieldDescriptor.isExtension()) {
        throw new IllegalArgumentException("This type does not have extensions.");
      }
      return this.fields[paramFieldDescriptor.getIndex()];
    }
    
    private static abstract interface FieldAccessor
    {
      public abstract void addRepeated(GeneratedMessage.Builder paramBuilder, Object paramObject);
      
      public abstract void clear(GeneratedMessage.Builder paramBuilder);
      
      public abstract Object get(GeneratedMessage paramGeneratedMessage);
      
      public abstract Object getRepeated(GeneratedMessage paramGeneratedMessage, int paramInt);
      
      public abstract int getRepeatedCount(GeneratedMessage paramGeneratedMessage);
      
      public abstract boolean has(GeneratedMessage paramGeneratedMessage);
      
      public abstract Message.Builder newBuilder();
      
      public abstract void set(GeneratedMessage.Builder paramBuilder, Object paramObject);
      
      public abstract void setRepeated(GeneratedMessage.Builder paramBuilder, int paramInt, Object paramObject);
    }
    
    private static final class RepeatedEnumFieldAccessor
      extends GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor
    {
      private final Method getValueDescriptorMethod = GeneratedMessage.getMethodOrDie(this.type, "getValueDescriptor", new Class[0]);
      private final Method valueOfMethod = GeneratedMessage.getMethodOrDie(this.type, "valueOf", new Class[] { Descriptors.EnumValueDescriptor.class });
      
      RepeatedEnumFieldAccessor(Descriptors.FieldDescriptor paramFieldDescriptor, String paramString, Class<? extends GeneratedMessage> paramClass, Class<? extends GeneratedMessage.Builder> paramClass1)
      {
        super(paramString, paramClass, paramClass1);
      }
      
      public void addRepeated(GeneratedMessage.Builder paramBuilder, Object paramObject)
      {
        super.addRepeated(paramBuilder, GeneratedMessage.invokeOrDie(this.valueOfMethod, null, new Object[] { paramObject }));
      }
      
      public Object get(GeneratedMessage paramGeneratedMessage)
      {
        ArrayList localArrayList = new ArrayList();
        paramGeneratedMessage = ((List)super.get(paramGeneratedMessage)).iterator();
        while (paramGeneratedMessage.hasNext())
        {
          Object localObject = paramGeneratedMessage.next();
          localArrayList.add(GeneratedMessage.invokeOrDie(this.getValueDescriptorMethod, localObject, new Object[0]));
        }
        return Collections.unmodifiableList(localArrayList);
      }
      
      public Object getRepeated(GeneratedMessage paramGeneratedMessage, int paramInt)
      {
        return GeneratedMessage.invokeOrDie(this.getValueDescriptorMethod, super.getRepeated(paramGeneratedMessage, paramInt), new Object[0]);
      }
      
      public void setRepeated(GeneratedMessage.Builder paramBuilder, int paramInt, Object paramObject)
      {
        super.setRepeated(paramBuilder, paramInt, GeneratedMessage.invokeOrDie(this.valueOfMethod, null, new Object[] { paramObject }));
      }
    }
    
    private static class RepeatedFieldAccessor
      implements GeneratedMessage.FieldAccessorTable.FieldAccessor
    {
      protected final Method addRepeatedMethod;
      protected final Method clearMethod;
      protected final Method getCountMethod;
      protected final Method getMethod;
      protected final Method getRepeatedMethod;
      protected final Method setRepeatedMethod;
      protected final Class type;
      
      RepeatedFieldAccessor(Descriptors.FieldDescriptor paramFieldDescriptor, String paramString, Class<? extends GeneratedMessage> paramClass, Class<? extends GeneratedMessage.Builder> paramClass1)
      {
        this.getMethod = GeneratedMessage.getMethodOrDie(paramClass, "get" + paramString + "List", new Class[0]);
        this.getRepeatedMethod = GeneratedMessage.getMethodOrDie(paramClass, "get" + paramString, new Class[] { Integer.TYPE });
        this.type = this.getRepeatedMethod.getReturnType();
        this.setRepeatedMethod = GeneratedMessage.getMethodOrDie(paramClass1, "set" + paramString, new Class[] { Integer.TYPE, this.type });
        this.addRepeatedMethod = GeneratedMessage.getMethodOrDie(paramClass1, "add" + paramString, new Class[] { this.type });
        this.getCountMethod = GeneratedMessage.getMethodOrDie(paramClass, "get" + paramString + "Count", new Class[0]);
        this.clearMethod = GeneratedMessage.getMethodOrDie(paramClass1, "clear" + paramString, new Class[0]);
      }
      
      public void addRepeated(GeneratedMessage.Builder paramBuilder, Object paramObject)
      {
        GeneratedMessage.invokeOrDie(this.addRepeatedMethod, paramBuilder, new Object[] { paramObject });
      }
      
      public void clear(GeneratedMessage.Builder paramBuilder)
      {
        GeneratedMessage.invokeOrDie(this.clearMethod, paramBuilder, new Object[0]);
      }
      
      public Object get(GeneratedMessage paramGeneratedMessage)
      {
        return GeneratedMessage.invokeOrDie(this.getMethod, paramGeneratedMessage, new Object[0]);
      }
      
      public Object getRepeated(GeneratedMessage paramGeneratedMessage, int paramInt)
      {
        return GeneratedMessage.invokeOrDie(this.getRepeatedMethod, paramGeneratedMessage, new Object[] { Integer.valueOf(paramInt) });
      }
      
      public int getRepeatedCount(GeneratedMessage paramGeneratedMessage)
      {
        return ((Integer)GeneratedMessage.invokeOrDie(this.getCountMethod, paramGeneratedMessage, new Object[0])).intValue();
      }
      
      public boolean has(GeneratedMessage paramGeneratedMessage)
      {
        throw new UnsupportedOperationException("hasField() called on a singular field.");
      }
      
      public Message.Builder newBuilder()
      {
        throw new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
      }
      
      public void set(GeneratedMessage.Builder paramBuilder, Object paramObject)
      {
        clear(paramBuilder);
        paramObject = ((List)paramObject).iterator();
        while (((Iterator)paramObject).hasNext()) {
          addRepeated(paramBuilder, ((Iterator)paramObject).next());
        }
      }
      
      public void setRepeated(GeneratedMessage.Builder paramBuilder, int paramInt, Object paramObject)
      {
        GeneratedMessage.invokeOrDie(this.setRepeatedMethod, paramBuilder, new Object[] { Integer.valueOf(paramInt), paramObject });
      }
    }
    
    private static final class RepeatedMessageFieldAccessor
      extends GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor
    {
      private final Method newBuilderMethod = GeneratedMessage.getMethodOrDie(this.type, "newBuilder", new Class[0]);
      
      RepeatedMessageFieldAccessor(Descriptors.FieldDescriptor paramFieldDescriptor, String paramString, Class<? extends GeneratedMessage> paramClass, Class<? extends GeneratedMessage.Builder> paramClass1)
      {
        super(paramString, paramClass, paramClass1);
      }
      
      private Object coerceType(Object paramObject)
      {
        if (this.type.isInstance(paramObject)) {
          return paramObject;
        }
        return ((Message.Builder)GeneratedMessage.invokeOrDie(this.newBuilderMethod, null, new Object[0])).mergeFrom((Message)paramObject).build();
      }
      
      public void addRepeated(GeneratedMessage.Builder paramBuilder, Object paramObject)
      {
        super.addRepeated(paramBuilder, coerceType(paramObject));
      }
      
      public Message.Builder newBuilder()
      {
        return (Message.Builder)GeneratedMessage.invokeOrDie(this.newBuilderMethod, null, new Object[0]);
      }
      
      public void setRepeated(GeneratedMessage.Builder paramBuilder, int paramInt, Object paramObject)
      {
        super.setRepeated(paramBuilder, paramInt, coerceType(paramObject));
      }
    }
    
    private static final class SingularEnumFieldAccessor
      extends GeneratedMessage.FieldAccessorTable.SingularFieldAccessor
    {
      private Method getValueDescriptorMethod = GeneratedMessage.getMethodOrDie(this.type, "getValueDescriptor", new Class[0]);
      private Method valueOfMethod = GeneratedMessage.getMethodOrDie(this.type, "valueOf", new Class[] { Descriptors.EnumValueDescriptor.class });
      
      SingularEnumFieldAccessor(Descriptors.FieldDescriptor paramFieldDescriptor, String paramString, Class<? extends GeneratedMessage> paramClass, Class<? extends GeneratedMessage.Builder> paramClass1)
      {
        super(paramString, paramClass, paramClass1);
      }
      
      public Object get(GeneratedMessage paramGeneratedMessage)
      {
        return GeneratedMessage.invokeOrDie(this.getValueDescriptorMethod, super.get(paramGeneratedMessage), new Object[0]);
      }
      
      public void set(GeneratedMessage.Builder paramBuilder, Object paramObject)
      {
        super.set(paramBuilder, GeneratedMessage.invokeOrDie(this.valueOfMethod, null, new Object[] { paramObject }));
      }
    }
    
    private static class SingularFieldAccessor
      implements GeneratedMessage.FieldAccessorTable.FieldAccessor
    {
      protected final Method clearMethod;
      protected final Method getMethod;
      protected final Method hasMethod;
      protected final Method setMethod;
      protected final Class type;
      
      SingularFieldAccessor(Descriptors.FieldDescriptor paramFieldDescriptor, String paramString, Class<? extends GeneratedMessage> paramClass, Class<? extends GeneratedMessage.Builder> paramClass1)
      {
        this.getMethod = GeneratedMessage.getMethodOrDie(paramClass, "get" + paramString, new Class[0]);
        this.type = this.getMethod.getReturnType();
        this.setMethod = GeneratedMessage.getMethodOrDie(paramClass1, "set" + paramString, new Class[] { this.type });
        this.hasMethod = GeneratedMessage.getMethodOrDie(paramClass, "has" + paramString, new Class[0]);
        this.clearMethod = GeneratedMessage.getMethodOrDie(paramClass1, "clear" + paramString, new Class[0]);
      }
      
      public void addRepeated(GeneratedMessage.Builder paramBuilder, Object paramObject)
      {
        throw new UnsupportedOperationException("addRepeatedField() called on a singular field.");
      }
      
      public void clear(GeneratedMessage.Builder paramBuilder)
      {
        GeneratedMessage.invokeOrDie(this.clearMethod, paramBuilder, new Object[0]);
      }
      
      public Object get(GeneratedMessage paramGeneratedMessage)
      {
        return GeneratedMessage.invokeOrDie(this.getMethod, paramGeneratedMessage, new Object[0]);
      }
      
      public Object getRepeated(GeneratedMessage paramGeneratedMessage, int paramInt)
      {
        throw new UnsupportedOperationException("getRepeatedField() called on a singular field.");
      }
      
      public int getRepeatedCount(GeneratedMessage paramGeneratedMessage)
      {
        throw new UnsupportedOperationException("getRepeatedFieldSize() called on a singular field.");
      }
      
      public boolean has(GeneratedMessage paramGeneratedMessage)
      {
        return ((Boolean)GeneratedMessage.invokeOrDie(this.hasMethod, paramGeneratedMessage, new Object[0])).booleanValue();
      }
      
      public Message.Builder newBuilder()
      {
        throw new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
      }
      
      public void set(GeneratedMessage.Builder paramBuilder, Object paramObject)
      {
        GeneratedMessage.invokeOrDie(this.setMethod, paramBuilder, new Object[] { paramObject });
      }
      
      public void setRepeated(GeneratedMessage.Builder paramBuilder, int paramInt, Object paramObject)
      {
        throw new UnsupportedOperationException("setRepeatedField() called on a singular field.");
      }
    }
    
    private static final class SingularMessageFieldAccessor
      extends GeneratedMessage.FieldAccessorTable.SingularFieldAccessor
    {
      private final Method newBuilderMethod = GeneratedMessage.getMethodOrDie(this.type, "newBuilder", new Class[0]);
      
      SingularMessageFieldAccessor(Descriptors.FieldDescriptor paramFieldDescriptor, String paramString, Class<? extends GeneratedMessage> paramClass, Class<? extends GeneratedMessage.Builder> paramClass1)
      {
        super(paramString, paramClass, paramClass1);
      }
      
      private Object coerceType(Object paramObject)
      {
        if (this.type.isInstance(paramObject)) {
          return paramObject;
        }
        return ((Message.Builder)GeneratedMessage.invokeOrDie(this.newBuilderMethod, null, new Object[0])).mergeFrom((Message)paramObject).build();
      }
      
      public Message.Builder newBuilder()
      {
        return (Message.Builder)GeneratedMessage.invokeOrDie(this.newBuilderMethod, null, new Object[0]);
      }
      
      public void set(GeneratedMessage.Builder paramBuilder, Object paramObject)
      {
        super.set(paramBuilder, coerceType(paramObject));
      }
    }
  }
  
  public static final class GeneratedExtension<ContainingType extends Message, Type>
  {
    private final Descriptors.FieldDescriptor descriptor;
    private final Method enumGetValueDescriptor;
    private final Method enumValueOf;
    private final Message messageDefaultInstance;
    private final Class type;
    
    private GeneratedExtension(Descriptors.FieldDescriptor paramFieldDescriptor, Class paramClass)
    {
      if (!paramFieldDescriptor.isExtension()) {
        throw new IllegalArgumentException("GeneratedExtension given a regular (non-extension) field.");
      }
      this.descriptor = paramFieldDescriptor;
      this.type = paramClass;
      switch (GeneratedMessage.1.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType[paramFieldDescriptor.getJavaType().ordinal()])
      {
      default: 
        this.enumValueOf = null;
        this.enumGetValueDescriptor = null;
        this.messageDefaultInstance = null;
        return;
      case 1: 
        this.enumValueOf = null;
        this.enumGetValueDescriptor = null;
        this.messageDefaultInstance = ((Message)GeneratedMessage.invokeOrDie(GeneratedMessage.access$1300(paramClass, "getDefaultInstance", new Class[0]), null, new Object[0]));
        return;
      }
      this.enumValueOf = GeneratedMessage.getMethodOrDie(paramClass, "valueOf", new Class[] { Descriptors.EnumValueDescriptor.class });
      this.enumGetValueDescriptor = GeneratedMessage.getMethodOrDie(paramClass, "getValueDescriptor", new Class[0]);
      this.messageDefaultInstance = null;
    }
    
    private Object fromReflectionType(Object paramObject)
    {
      if (this.descriptor.isRepeated())
      {
        Object localObject;
        if (this.descriptor.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE)
        {
          localObject = paramObject;
          if (this.descriptor.getJavaType() != Descriptors.FieldDescriptor.JavaType.ENUM) {}
        }
        else
        {
          localObject = new ArrayList();
          paramObject = ((List)paramObject).iterator();
          while (((Iterator)paramObject).hasNext()) {
            ((List)localObject).add(singularFromReflectionType(((Iterator)paramObject).next()));
          }
        }
        return localObject;
      }
      return singularFromReflectionType(paramObject);
    }
    
    private Object singularFromReflectionType(Object paramObject)
    {
      switch (GeneratedMessage.1.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType[this.descriptor.getJavaType().ordinal()])
      {
      default: 
      case 1: 
        do
        {
          return paramObject;
        } while (this.type.isInstance(paramObject));
        return this.messageDefaultInstance.newBuilderForType().mergeFrom((Message)paramObject).build();
      }
      return GeneratedMessage.invokeOrDie(this.enumValueOf, null, new Object[] { (Descriptors.EnumValueDescriptor)paramObject });
    }
    
    private Object singularToReflectionType(Object paramObject)
    {
      switch (GeneratedMessage.1.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType[this.descriptor.getJavaType().ordinal()])
      {
      default: 
        return paramObject;
      }
      return GeneratedMessage.invokeOrDie(this.enumGetValueDescriptor, paramObject, new Object[0]);
    }
    
    private Object toReflectionType(Object paramObject)
    {
      if (this.descriptor.isRepeated())
      {
        if (this.descriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.ENUM)
        {
          ArrayList localArrayList = new ArrayList();
          Iterator localIterator = ((List)paramObject).iterator();
          for (;;)
          {
            paramObject = localArrayList;
            if (!localIterator.hasNext()) {
              break;
            }
            localArrayList.add(singularToReflectionType(localIterator.next()));
          }
        }
        return paramObject;
      }
      return singularToReflectionType(paramObject);
    }
    
    public Descriptors.FieldDescriptor getDescriptor()
    {
      return this.descriptor;
    }
    
    public Message getMessageDefaultInstance()
    {
      return this.messageDefaultInstance;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/google/protobuf/GeneratedMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */