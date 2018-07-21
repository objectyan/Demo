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

public final class CarlifeFeatureConfigProto
{
  private static Descriptors.FileDescriptor descriptor;
  private static Descriptors.Descriptor internal_static_com_baidu_carlife_protobuf_CarlifeFeatureConfig_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_com_baidu_carlife_protobuf_CarlifeFeatureConfig_fieldAccessorTable;
  
  static
  {
    Descriptors.FileDescriptor.InternalDescriptorAssigner local1 = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
    {
      public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor paramAnonymousFileDescriptor)
      {
        CarlifeFeatureConfigProto.access$902(paramAnonymousFileDescriptor);
        CarlifeFeatureConfigProto.access$002((Descriptors.Descriptor)CarlifeFeatureConfigProto.getDescriptor().getMessageTypes().get(0));
        CarlifeFeatureConfigProto.access$102(new GeneratedMessage.FieldAccessorTable(CarlifeFeatureConfigProto.internal_static_com_baidu_carlife_protobuf_CarlifeFeatureConfig_descriptor, new String[] { "Key", "Value" }, CarlifeFeatureConfigProto.CarlifeFeatureConfig.class, CarlifeFeatureConfigProto.CarlifeFeatureConfig.Builder.class));
        return null;
      }
    };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\037CarlifeFeatureConfigProto.proto\022\032com.baidu.carlife.protobuf\"2\n\024CarlifeFeatureConfig\022\013\n\003key\030\001 \002(\t\022\r\n\005value\030\002 \002(\005" }, new Descriptors.FileDescriptor[0], local1);
  }
  
  public static Descriptors.FileDescriptor getDescriptor()
  {
    return descriptor;
  }
  
  public static void internalForceInit() {}
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {}
  
  public static final class CarlifeFeatureConfig
    extends GeneratedMessage
  {
    public static final int KEY_FIELD_NUMBER = 1;
    public static final int VALUE_FIELD_NUMBER = 2;
    private static final CarlifeFeatureConfig defaultInstance = new CarlifeFeatureConfig();
    private boolean hasKey;
    private boolean hasValue;
    private String key_ = "";
    private int memoizedSerializedSize = -1;
    private int value_ = 0;
    
    static
    {
      CarlifeFeatureConfigProto.getDescriptor();
      CarlifeFeatureConfigProto.internalForceInit();
    }
    
    public static CarlifeFeatureConfig getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return CarlifeFeatureConfigProto.internal_static_com_baidu_carlife_protobuf_CarlifeFeatureConfig_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$300();
    }
    
    public static Builder newBuilder(CarlifeFeatureConfig paramCarlifeFeatureConfig)
    {
      return newBuilder().mergeFrom(paramCarlifeFeatureConfig);
    }
    
    public static CarlifeFeatureConfig parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeFeatureConfig parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeFeatureConfig parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static CarlifeFeatureConfig parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeFeatureConfig parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static CarlifeFeatureConfig parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static CarlifeFeatureConfig parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeFeatureConfig parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeFeatureConfig parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static CarlifeFeatureConfig parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public CarlifeFeatureConfig getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public String getKey()
    {
      return this.key_;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      i = 0;
      if (hasKey()) {
        i = 0 + CodedOutputStream.computeStringSize(1, getKey());
      }
      int j = i;
      if (hasValue()) {
        j = i + CodedOutputStream.computeInt32Size(2, getValue());
      }
      i = j + getUnknownFields().getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public int getValue()
    {
      return this.value_;
    }
    
    public boolean hasKey()
    {
      return this.hasKey;
    }
    
    public boolean hasValue()
    {
      return this.hasValue;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return CarlifeFeatureConfigProto.internal_static_com_baidu_carlife_protobuf_CarlifeFeatureConfig_fieldAccessorTable;
    }
    
    public final boolean isInitialized()
    {
      if (!this.hasKey) {}
      while (!this.hasValue) {
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
      if (hasKey()) {
        paramCodedOutputStream.writeString(1, getKey());
      }
      if (hasValue()) {
        paramCodedOutputStream.writeInt32(2, getValue());
      }
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.Builder<Builder>
    {
      private CarlifeFeatureConfigProto.CarlifeFeatureConfig result;
      
      private CarlifeFeatureConfigProto.CarlifeFeatureConfig buildParsed()
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
        localBuilder.result = new CarlifeFeatureConfigProto.CarlifeFeatureConfig(null);
        return localBuilder;
      }
      
      public CarlifeFeatureConfigProto.CarlifeFeatureConfig build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public CarlifeFeatureConfigProto.CarlifeFeatureConfig buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        CarlifeFeatureConfigProto.CarlifeFeatureConfig localCarlifeFeatureConfig = this.result;
        this.result = null;
        return localCarlifeFeatureConfig;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new CarlifeFeatureConfigProto.CarlifeFeatureConfig(null);
        return this;
      }
      
      public Builder clearKey()
      {
        CarlifeFeatureConfigProto.CarlifeFeatureConfig.access$502(this.result, false);
        CarlifeFeatureConfigProto.CarlifeFeatureConfig.access$602(this.result, CarlifeFeatureConfigProto.CarlifeFeatureConfig.getDefaultInstance().getKey());
        return this;
      }
      
      public Builder clearValue()
      {
        CarlifeFeatureConfigProto.CarlifeFeatureConfig.access$702(this.result, false);
        CarlifeFeatureConfigProto.CarlifeFeatureConfig.access$802(this.result, 0);
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(this.result);
      }
      
      public CarlifeFeatureConfigProto.CarlifeFeatureConfig getDefaultInstanceForType()
      {
        return CarlifeFeatureConfigProto.CarlifeFeatureConfig.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return CarlifeFeatureConfigProto.CarlifeFeatureConfig.getDescriptor();
      }
      
      public String getKey()
      {
        return this.result.getKey();
      }
      
      public int getValue()
      {
        return this.result.getValue();
      }
      
      public boolean hasKey()
      {
        return this.result.hasKey();
      }
      
      public boolean hasValue()
      {
        return this.result.hasValue();
      }
      
      protected CarlifeFeatureConfigProto.CarlifeFeatureConfig internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CarlifeFeatureConfigProto.CarlifeFeatureConfig paramCarlifeFeatureConfig)
      {
        if (paramCarlifeFeatureConfig == CarlifeFeatureConfigProto.CarlifeFeatureConfig.getDefaultInstance()) {
          return this;
        }
        if (paramCarlifeFeatureConfig.hasKey()) {
          setKey(paramCarlifeFeatureConfig.getKey());
        }
        if (paramCarlifeFeatureConfig.hasValue()) {
          setValue(paramCarlifeFeatureConfig.getValue());
        }
        mergeUnknownFields(paramCarlifeFeatureConfig.getUnknownFields());
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
          case 10: 
            setKey(paramCodedInputStream.readString());
            break;
          case 16: 
            setValue(paramCodedInputStream.readInt32());
          }
        }
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof CarlifeFeatureConfigProto.CarlifeFeatureConfig)) {
          return mergeFrom((CarlifeFeatureConfigProto.CarlifeFeatureConfig)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder setKey(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        CarlifeFeatureConfigProto.CarlifeFeatureConfig.access$502(this.result, true);
        CarlifeFeatureConfigProto.CarlifeFeatureConfig.access$602(this.result, paramString);
        return this;
      }
      
      public Builder setValue(int paramInt)
      {
        CarlifeFeatureConfigProto.CarlifeFeatureConfig.access$702(this.result, true);
        CarlifeFeatureConfigProto.CarlifeFeatureConfig.access$802(this.result, paramInt);
        return this;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/protobuf/CarlifeFeatureConfigProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */