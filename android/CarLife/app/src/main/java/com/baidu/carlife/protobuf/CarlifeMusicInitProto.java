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

public final class CarlifeMusicInitProto
{
  private static Descriptors.FileDescriptor descriptor;
  private static Descriptors.Descriptor internal_static_com_baidu_carlife_protobuf_CarlifeMusicInit_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_com_baidu_carlife_protobuf_CarlifeMusicInit_fieldAccessorTable;
  
  static
  {
    Descriptors.FileDescriptor.InternalDescriptorAssigner local1 = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
    {
      public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor paramAnonymousFileDescriptor)
      {
        CarlifeMusicInitProto.access$1102(paramAnonymousFileDescriptor);
        CarlifeMusicInitProto.access$002((Descriptors.Descriptor)CarlifeMusicInitProto.getDescriptor().getMessageTypes().get(0));
        CarlifeMusicInitProto.access$102(new GeneratedMessage.FieldAccessorTable(CarlifeMusicInitProto.internal_static_com_baidu_carlife_protobuf_CarlifeMusicInit_descriptor, new String[] { "SampleRate", "ChannelConfig", "SampleFormat" }, CarlifeMusicInitProto.CarlifeMusicInit.class, CarlifeMusicInitProto.CarlifeMusicInit.Builder.class));
        return null;
      }
    };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\033CarlifeMusicInitProto.proto\022\032com.baidu.carlife.protobuf\"S\n\020CarlifeMusicInit\022\022\n\nsampleRate\030\001 \002(\005\022\025\n\rchannelConfig\030\002 \002(\005\022\024\n\fsampleFormat\030\003 \002(\005" }, new Descriptors.FileDescriptor[0], local1);
  }
  
  public static Descriptors.FileDescriptor getDescriptor()
  {
    return descriptor;
  }
  
  public static void internalForceInit() {}
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {}
  
  public static final class CarlifeMusicInit
    extends GeneratedMessage
  {
    public static final int CHANNELCONFIG_FIELD_NUMBER = 2;
    public static final int SAMPLEFORMAT_FIELD_NUMBER = 3;
    public static final int SAMPLERATE_FIELD_NUMBER = 1;
    private static final CarlifeMusicInit defaultInstance = new CarlifeMusicInit();
    private int channelConfig_ = 0;
    private boolean hasChannelConfig;
    private boolean hasSampleFormat;
    private boolean hasSampleRate;
    private int memoizedSerializedSize = -1;
    private int sampleFormat_ = 0;
    private int sampleRate_ = 0;
    
    static
    {
      CarlifeMusicInitProto.getDescriptor();
      CarlifeMusicInitProto.internalForceInit();
    }
    
    public static CarlifeMusicInit getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return CarlifeMusicInitProto.internal_static_com_baidu_carlife_protobuf_CarlifeMusicInit_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$300();
    }
    
    public static Builder newBuilder(CarlifeMusicInit paramCarlifeMusicInit)
    {
      return newBuilder().mergeFrom(paramCarlifeMusicInit);
    }
    
    public static CarlifeMusicInit parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeMusicInit parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeMusicInit parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static CarlifeMusicInit parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeMusicInit parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static CarlifeMusicInit parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static CarlifeMusicInit parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeMusicInit parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeMusicInit parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static CarlifeMusicInit parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public int getChannelConfig()
    {
      return this.channelConfig_;
    }
    
    public CarlifeMusicInit getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public int getSampleFormat()
    {
      return this.sampleFormat_;
    }
    
    public int getSampleRate()
    {
      return this.sampleRate_;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      int j = 0;
      if (hasSampleRate()) {
        j = 0 + CodedOutputStream.computeInt32Size(1, getSampleRate());
      }
      i = j;
      if (hasChannelConfig()) {
        i = j + CodedOutputStream.computeInt32Size(2, getChannelConfig());
      }
      j = i;
      if (hasSampleFormat()) {
        j = i + CodedOutputStream.computeInt32Size(3, getSampleFormat());
      }
      i = j + getUnknownFields().getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public boolean hasChannelConfig()
    {
      return this.hasChannelConfig;
    }
    
    public boolean hasSampleFormat()
    {
      return this.hasSampleFormat;
    }
    
    public boolean hasSampleRate()
    {
      return this.hasSampleRate;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return CarlifeMusicInitProto.internal_static_com_baidu_carlife_protobuf_CarlifeMusicInit_fieldAccessorTable;
    }
    
    public final boolean isInitialized()
    {
      if (!this.hasSampleRate) {}
      while ((!this.hasChannelConfig) || (!this.hasSampleFormat)) {
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
      if (hasSampleRate()) {
        paramCodedOutputStream.writeInt32(1, getSampleRate());
      }
      if (hasChannelConfig()) {
        paramCodedOutputStream.writeInt32(2, getChannelConfig());
      }
      if (hasSampleFormat()) {
        paramCodedOutputStream.writeInt32(3, getSampleFormat());
      }
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.Builder<Builder>
    {
      private CarlifeMusicInitProto.CarlifeMusicInit result;
      
      private CarlifeMusicInitProto.CarlifeMusicInit buildParsed()
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
        localBuilder.result = new CarlifeMusicInitProto.CarlifeMusicInit(null);
        return localBuilder;
      }
      
      public CarlifeMusicInitProto.CarlifeMusicInit build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public CarlifeMusicInitProto.CarlifeMusicInit buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        CarlifeMusicInitProto.CarlifeMusicInit localCarlifeMusicInit = this.result;
        this.result = null;
        return localCarlifeMusicInit;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new CarlifeMusicInitProto.CarlifeMusicInit(null);
        return this;
      }
      
      public Builder clearChannelConfig()
      {
        CarlifeMusicInitProto.CarlifeMusicInit.access$702(this.result, false);
        CarlifeMusicInitProto.CarlifeMusicInit.access$802(this.result, 0);
        return this;
      }
      
      public Builder clearSampleFormat()
      {
        CarlifeMusicInitProto.CarlifeMusicInit.access$902(this.result, false);
        CarlifeMusicInitProto.CarlifeMusicInit.access$1002(this.result, 0);
        return this;
      }
      
      public Builder clearSampleRate()
      {
        CarlifeMusicInitProto.CarlifeMusicInit.access$502(this.result, false);
        CarlifeMusicInitProto.CarlifeMusicInit.access$602(this.result, 0);
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(this.result);
      }
      
      public int getChannelConfig()
      {
        return this.result.getChannelConfig();
      }
      
      public CarlifeMusicInitProto.CarlifeMusicInit getDefaultInstanceForType()
      {
        return CarlifeMusicInitProto.CarlifeMusicInit.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return CarlifeMusicInitProto.CarlifeMusicInit.getDescriptor();
      }
      
      public int getSampleFormat()
      {
        return this.result.getSampleFormat();
      }
      
      public int getSampleRate()
      {
        return this.result.getSampleRate();
      }
      
      public boolean hasChannelConfig()
      {
        return this.result.hasChannelConfig();
      }
      
      public boolean hasSampleFormat()
      {
        return this.result.hasSampleFormat();
      }
      
      public boolean hasSampleRate()
      {
        return this.result.hasSampleRate();
      }
      
      protected CarlifeMusicInitProto.CarlifeMusicInit internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CarlifeMusicInitProto.CarlifeMusicInit paramCarlifeMusicInit)
      {
        if (paramCarlifeMusicInit == CarlifeMusicInitProto.CarlifeMusicInit.getDefaultInstance()) {
          return this;
        }
        if (paramCarlifeMusicInit.hasSampleRate()) {
          setSampleRate(paramCarlifeMusicInit.getSampleRate());
        }
        if (paramCarlifeMusicInit.hasChannelConfig()) {
          setChannelConfig(paramCarlifeMusicInit.getChannelConfig());
        }
        if (paramCarlifeMusicInit.hasSampleFormat()) {
          setSampleFormat(paramCarlifeMusicInit.getSampleFormat());
        }
        mergeUnknownFields(paramCarlifeMusicInit.getUnknownFields());
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
            setSampleRate(paramCodedInputStream.readInt32());
            break;
          case 16: 
            setChannelConfig(paramCodedInputStream.readInt32());
            break;
          case 24: 
            setSampleFormat(paramCodedInputStream.readInt32());
          }
        }
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof CarlifeMusicInitProto.CarlifeMusicInit)) {
          return mergeFrom((CarlifeMusicInitProto.CarlifeMusicInit)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder setChannelConfig(int paramInt)
      {
        CarlifeMusicInitProto.CarlifeMusicInit.access$702(this.result, true);
        CarlifeMusicInitProto.CarlifeMusicInit.access$802(this.result, paramInt);
        return this;
      }
      
      public Builder setSampleFormat(int paramInt)
      {
        CarlifeMusicInitProto.CarlifeMusicInit.access$902(this.result, true);
        CarlifeMusicInitProto.CarlifeMusicInit.access$1002(this.result, paramInt);
        return this;
      }
      
      public Builder setSampleRate(int paramInt)
      {
        CarlifeMusicInitProto.CarlifeMusicInit.access$502(this.result, true);
        CarlifeMusicInitProto.CarlifeMusicInit.access$602(this.result, paramInt);
        return this;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/protobuf/CarlifeMusicInitProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */