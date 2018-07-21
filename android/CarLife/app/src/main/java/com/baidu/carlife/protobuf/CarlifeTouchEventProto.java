package com.baidu.carlife.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FileDescriptor;
import com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage.Builder;
import com.google.protobuf.GeneratedMessage.FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.UninitializedMessageException;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet.Builder;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public final class CarlifeTouchEventProto
{
  private static Descriptors.FileDescriptor descriptor;
  private static Descriptors.Descriptor internal_static_com_baidu_carlife_protobuf_CarlifeTouchEvent_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_com_baidu_carlife_protobuf_CarlifeTouchEvent_fieldAccessorTable;
  
  static
  {
    Descriptors.FileDescriptor.InternalDescriptorAssigner local1 = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
    {
      public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor paramAnonymousFileDescriptor)
      {
        CarlifeTouchEventProto.access$1102(paramAnonymousFileDescriptor);
        CarlifeTouchEventProto.access$002((Descriptors.Descriptor)CarlifeTouchEventProto.getDescriptor().getMessageTypes().get(0));
        CarlifeTouchEventProto.access$102(new GeneratedMessage.FieldAccessorTable(CarlifeTouchEventProto.internal_static_com_baidu_carlife_protobuf_CarlifeTouchEvent_descriptor, new String[] { "Type", "Code", "Value" }, CarlifeTouchEventProto.CarlifeTouchEvent.class, CarlifeTouchEventProto.CarlifeTouchEvent.Builder.class));
        return null;
      }
    };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\034CarlifeTouchEventProto.proto\022\032com.baidu.carlife.protobuf\">\n\021CarlifeTouchEvent\022\f\n\004type\030\001 \002(\005\022\f\n\004code\030\002 \002(\005\022\r\n\005value\030\003 \002(\005" }, new Descriptors.FileDescriptor[0], local1);
  }
  
  public static Descriptors.FileDescriptor getDescriptor()
  {
    return descriptor;
  }
  
  public static void internalForceInit() {}
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {}
  
  public static final class CarlifeTouchEvent
    extends GeneratedMessage
  {
    public static final int CODE_FIELD_NUMBER = 2;
    public static final int TYPE_FIELD_NUMBER = 1;
    public static final int VALUE_FIELD_NUMBER = 3;
    private static final CarlifeTouchEvent defaultInstance = new CarlifeTouchEvent();
    private int code_ = 0;
    private boolean hasCode;
    private boolean hasType;
    private boolean hasValue;
    private int memoizedSerializedSize = -1;
    private int type_ = 0;
    private int value_ = 0;
    
    static
    {
      CarlifeTouchEventProto.getDescriptor();
      CarlifeTouchEventProto.internalForceInit();
    }
    
    public static CarlifeTouchEvent getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return CarlifeTouchEventProto.internal_static_com_baidu_carlife_protobuf_CarlifeTouchEvent_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$300();
    }
    
    public static Builder newBuilder(CarlifeTouchEvent paramCarlifeTouchEvent)
    {
      return newBuilder().mergeFrom(paramCarlifeTouchEvent);
    }
    
    public static CarlifeTouchEvent parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeTouchEvent parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeTouchEvent parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static CarlifeTouchEvent parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeTouchEvent parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static CarlifeTouchEvent parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static CarlifeTouchEvent parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeTouchEvent parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeTouchEvent parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static CarlifeTouchEvent parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public int getCode()
    {
      return this.code_;
    }
    
    public CarlifeTouchEvent getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      int j = 0;
      if (hasType()) {
        j = 0 + CodedOutputStream.computeInt32Size(1, getType());
      }
      i = j;
      if (hasCode()) {
        i = j + CodedOutputStream.computeInt32Size(2, getCode());
      }
      j = i;
      if (hasValue()) {
        j = i + CodedOutputStream.computeInt32Size(3, getValue());
      }
      i = j + getUnknownFields().getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public int getType()
    {
      return this.type_;
    }
    
    public int getValue()
    {
      return this.value_;
    }
    
    public boolean hasCode()
    {
      return this.hasCode;
    }
    
    public boolean hasType()
    {
      return this.hasType;
    }
    
    public boolean hasValue()
    {
      return this.hasValue;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return CarlifeTouchEventProto.internal_static_com_baidu_carlife_protobuf_CarlifeTouchEvent_fieldAccessorTable;
    }
    
    public final boolean isInitialized()
    {
      if (!this.hasType) {}
      while ((!this.hasCode) || (!this.hasValue)) {
        return false;
      }
      return true;
    }
    
    public Builder newBuilderForType()
    {
      return newBuilder();
    }
    
    public Builder toBuilder()
    {
      return newBuilder(this);
    }
    
    public void writeTo(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      if (hasType()) {
        paramCodedOutputStream.writeInt32(1, getType());
      }
      if (hasCode()) {
        paramCodedOutputStream.writeInt32(2, getCode());
      }
      if (hasValue()) {
        paramCodedOutputStream.writeInt32(3, getValue());
      }
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.Builder<Builder>
    {
      private CarlifeTouchEventProto.CarlifeTouchEvent result;
      
      private CarlifeTouchEventProto.CarlifeTouchEvent buildParsed()
        throws InvalidProtocolBufferException
      {
        if (!isInitialized()) {
          throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
        }
        return buildPartial();
      }
      
      private static Builder create()
      {
        Builder localBuilder = new Builder();
        localBuilder.result = new CarlifeTouchEventProto.CarlifeTouchEvent(null);
        return localBuilder;
      }
      
      public CarlifeTouchEventProto.CarlifeTouchEvent build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public CarlifeTouchEventProto.CarlifeTouchEvent buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        CarlifeTouchEventProto.CarlifeTouchEvent localCarlifeTouchEvent = this.result;
        this.result = null;
        return localCarlifeTouchEvent;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new CarlifeTouchEventProto.CarlifeTouchEvent(null);
        return this;
      }
      
      public Builder clearCode()
      {
        CarlifeTouchEventProto.CarlifeTouchEvent.access$702(this.result, false);
        CarlifeTouchEventProto.CarlifeTouchEvent.access$802(this.result, 0);
        return this;
      }
      
      public Builder clearType()
      {
        CarlifeTouchEventProto.CarlifeTouchEvent.access$502(this.result, false);
        CarlifeTouchEventProto.CarlifeTouchEvent.access$602(this.result, 0);
        return this;
      }
      
      public Builder clearValue()
      {
        CarlifeTouchEventProto.CarlifeTouchEvent.access$902(this.result, false);
        CarlifeTouchEventProto.CarlifeTouchEvent.access$1002(this.result, 0);
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(this.result);
      }
      
      public int getCode()
      {
        return this.result.getCode();
      }
      
      public CarlifeTouchEventProto.CarlifeTouchEvent getDefaultInstanceForType()
      {
        return CarlifeTouchEventProto.CarlifeTouchEvent.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return CarlifeTouchEventProto.CarlifeTouchEvent.getDescriptor();
      }
      
      public int getType()
      {
        return this.result.getType();
      }
      
      public int getValue()
      {
        return this.result.getValue();
      }
      
      public boolean hasCode()
      {
        return this.result.hasCode();
      }
      
      public boolean hasType()
      {
        return this.result.hasType();
      }
      
      public boolean hasValue()
      {
        return this.result.hasValue();
      }
      
      protected CarlifeTouchEventProto.CarlifeTouchEvent internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CarlifeTouchEventProto.CarlifeTouchEvent paramCarlifeTouchEvent)
      {
        if (paramCarlifeTouchEvent == CarlifeTouchEventProto.CarlifeTouchEvent.getDefaultInstance()) {
          return this;
        }
        if (paramCarlifeTouchEvent.hasType()) {
          setType(paramCarlifeTouchEvent.getType());
        }
        if (paramCarlifeTouchEvent.hasCode()) {
          setCode(paramCarlifeTouchEvent.getCode());
        }
        if (paramCarlifeTouchEvent.hasValue()) {
          setValue(paramCarlifeTouchEvent.getValue());
        }
        mergeUnknownFields(paramCarlifeTouchEvent.getUnknownFields());
        return this;
      }
      
      public Builder mergeFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
        throws IOException
      {
        UnknownFieldSet.Builder localBuilder = UnknownFieldSet.newBuilder(getUnknownFields());
        for (;;)
        {
          int i = paramCodedInputStream.readTag();
          switch (i)
          {
          default: 
            if (!parseUnknownField(paramCodedInputStream, localBuilder, paramExtensionRegistryLite, i))
            {
              setUnknownFields(localBuilder.build());
              return this;
            }
            break;
          case 0: 
            setUnknownFields(localBuilder.build());
            return this;
          case 8: 
            setType(paramCodedInputStream.readInt32());
            break;
          case 16: 
            setCode(paramCodedInputStream.readInt32());
            break;
          case 24: 
            setValue(paramCodedInputStream.readInt32());
          }
        }
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof CarlifeTouchEventProto.CarlifeTouchEvent)) {
          return mergeFrom((CarlifeTouchEventProto.CarlifeTouchEvent)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder setCode(int paramInt)
      {
        CarlifeTouchEventProto.CarlifeTouchEvent.access$702(this.result, true);
        CarlifeTouchEventProto.CarlifeTouchEvent.access$802(this.result, paramInt);
        return this;
      }
      
      public Builder setType(int paramInt)
      {
        CarlifeTouchEventProto.CarlifeTouchEvent.access$502(this.result, true);
        CarlifeTouchEventProto.CarlifeTouchEvent.access$602(this.result, paramInt);
        return this;
      }
      
      public Builder setValue(int paramInt)
      {
        CarlifeTouchEventProto.CarlifeTouchEvent.access$902(this.result, true);
        CarlifeTouchEventProto.CarlifeTouchEvent.access$1002(this.result, paramInt);
        return this;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/protobuf/CarlifeTouchEventProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */